package de.itemis.xtext.utils.jface.viewers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.source.AnnotationModel;
import org.eclipse.jface.text.source.ICharacterPairMatcher;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.editors.text.EditorsPlugin;
import org.eclipse.ui.swt.IFocusService;
import org.eclipse.ui.texteditor.AbstractDecoratedTextEditor;
import org.eclipse.ui.texteditor.AnnotationPreference;
import org.eclipse.ui.texteditor.DefaultMarkerAnnotationAccess;
import org.eclipse.ui.texteditor.MarkerAnnotationPreferences;
import org.eclipse.ui.texteditor.SourceViewerDecorationSupport;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.XtextSourceViewer.Factory;
import org.eclipse.xtext.ui.editor.XtextSourceViewerConfiguration;
import org.eclipse.xtext.ui.editor.bracketmatching.BracketMatchingPreferencesInitializer;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider;
import org.eclipse.xtext.ui.editor.validation.AnnotationIssueProcessor;
import org.eclipse.xtext.ui.editor.validation.ValidationJob;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;
import com.google.inject.name.Named;

import de.itemis.xtext.utils.jface.viewers.util.ActiveEditorTracker;

/**
 * This class integrates xText Features into a {@link StyledText} and can be
 * used i.e. as {@link CellEditor}s in jface {@link StructuredViewer}s or in GMF
 * EditParts via DirectEditManager.
 * 
 * The current implementation supports, code completion, syntax highlighting and
 * validation
 * 
 * Some code is initially copied from xText.
 * 
 * @author andreas.muelder@itemis.de
 * @author alexander.nyssen@itemis.de
 * @author patrick.koenemann@itemis.de
 */
// TODO: Check if we can use the XTextDocumentProvider instead of creating own
// XTextDocument + setup
@SuppressWarnings("restriction")
public class XtextStyledText {

	/**
	 * The sourceViewer, that provides additional functions to the styled text
	 * widget
	 */
	protected XtextSourceViewer sourceviewer;

	private ValidationJob validationJob;

	private IssueResolutionProvider resolutionProvider = new IssueResolutionProvider.NullImpl();
	@Inject
	private IPreferenceStoreAccess preferenceStoreAccess;
	@Inject
	private ICharacterPairMatcher characterPairMatcher;
	@Inject
	private XtextSourceViewerConfiguration configuration;
	@Inject
	private Factory sourceViewerFactory;
	@Inject
	private XtextStyledTextHighlightingHelper xtextStyledTextHighlightingHelper;
	@Inject
	private XtextResource fakeResource;
	@Inject
	private IResourceValidator validator;
	@Inject
	private Provider<IDocumentPartitioner> documentPartitioner;
	@Inject
	private @Named(Constants.FILE_EXTENSIONS)
	String fileExtension;
	@Inject
	private XtextDocument document;
	@Inject
	private IResourceSetProvider resourceSetProvider;

	private Resource contextResource;

	private final int style;

	private Composite parent;

	private IProject activeProject;

	private StyledText styledText;

	private ResourceSet resourceSet;

	/**
	 * C'tor to create a new Instance.
	 * 
	 * No specific contextResource is set for xtext! If you need a
	 * contextResource, use
	 * {@link XtextStyledText#XtextStyledText(Composite, int, Injector, Resource)}
	 * !
	 * 
	 * <b>Please note:</b> Since the text control has content assist proposals
	 * enabled via a listener, <code>dispose</code> must be called to unregister
	 * the listener!
	 * 
	 * @param style
	 *            The SWT styles for this text widget.
	 * @param injector
	 *            For xtext dependency injection.
	 */
	public XtextStyledText(Composite parent, int style, Injector injector) {
		this(parent, style, injector, null);
	}

	/**
	 * C'tor to create a new Instance.
	 * 
	 * In contrast to
	 * {@link XtextStyledText#XtextStyledText(Composite, int, Injector)}, this
	 * constructor uses a specific contextResource for xtext.
	 * 
	 * <b>Please note:</b> Since the text control has content assist proposals
	 * enabled via a listener, <code>dispose</code> must be called to unregister
	 * the listener!
	 * 
	 * @param style
	 *            The SWT styles for this text widget.
	 * @param injector
	 *            For xtext dependency injection.
	 * @param contextResource
	 *            A contextResource for xtext. May be null.
	 */
	public XtextStyledText(Composite parent, int style, Injector injector,
			Resource context) {
		this.style = style;
		this.parent = parent;
		if (injector == null)
			throw new IllegalArgumentException("Injector must not be null!");
		injector.injectMembers(this);
		// create resource set
		resourceSet = createXtextResourceSet();
		// context may be null (can be passed in lazily as well)
		if (context != null) {
			setContextResource(context);
		}
	}

	/**
	 * Creates decoration support for the sourceViewer. code is entirely copied
	 * from {@link XtextEditor} and its super class
	 * {@link AbstractDecoratedTextEditor}.
	 * 
	 */
	private void configureSourceViewerDecorationSupport(
			SourceViewerDecorationSupport support) {
		MarkerAnnotationPreferences annotationPreferences = new MarkerAnnotationPreferences();
		@SuppressWarnings("unchecked")
		List<AnnotationPreference> prefs = annotationPreferences
				.getAnnotationPreferences();
		for (AnnotationPreference annotationPreference : prefs) {
			support.setAnnotationPreference(annotationPreference);
		}

		support.setCharacterPairMatcher(characterPairMatcher);
		support.setMatchingCharacterPainterPreferenceKeys(
				BracketMatchingPreferencesInitializer.IS_ACTIVE_KEY,
				BracketMatchingPreferencesInitializer.COLOR_KEY);

		support.install(preferenceStoreAccess.getPreferenceStore());

	}

	protected void createContextFakeResource() {
		// deep copy context resource contents, because simply loading the
		// fakeResource will
		// not reflect the current edit state, but the last saved state.
		Resource contextResourceCopy = resourceSet
				.createResource(contextResource.getURI());
		contextResourceCopy.getContents().addAll(
				EcoreUtil.copyAll(contextResource.getContents()));
		resourceSet.getResources().add(contextResourceCopy);
	}

	private URI createFakeResourceBaseFragment(String activeProject) {
		return URI.createPlatformResourceURI(activeProject + "/embedded", true);
	}

	private URI createFakeResourceUri(String activeProject) {
		return createFakeResourceBaseFragment(activeProject)
				.appendFileExtension(fileExtension);
	}

	/**
	 * Creates an {@link SourceViewer} and returns the {@link StyledText} widget
	 * of the viewer as the cell editors control. Some code is copied from
	 * {@link XtextEditor}.
	 */
	protected void createStyledText() {
		// initialize contents of fake resource
		initXtextFakeResource();
		// connect xtext document to fake resource
		initXtextDocument();
		// connect xtext document to xtext source viewer
		createXtextSourceViewer();

		// install semantic highlighting support
		installHighlightingHelper();
		
		validationJob = createValidationJob();
		document.setValidationJob(validationJob);

		styledText = sourceviewer.getTextWidget();

		styledText.setData(XtextStyledText.class.getCanonicalName(), this);
		styledText.setFont(parent.getFont());
		styledText.setBackground(parent.getBackground());
		styledText.setText("");
		
		if ((styledText.getStyle() & SWT.SINGLE) != 0) {
			// Add listener to send DefaultSelection event when ENTER is pressed.
			// This will emulate the behavior of the Text widget.
			styledText.addListener(SWT.KeyDown, new Listener() {
				
				public void handleEvent(Event event) {
					if (event.keyCode == SWT.CR) {
						Event selectionEvent = new Event();
						selectionEvent.type = SWT.DefaultSelection;
						selectionEvent.widget = event.widget;
						for (Listener l : event.widget.getListeners(SWT.DefaultSelection)) {
							l.handleEvent(selectionEvent);
						}
					}
				}
				
			});
		}
		
		// Register focus tracker for evaluating the active focus control in core expression
		IFocusService service = (IFocusService) PlatformUI.getWorkbench().getService(IFocusService.class);
		service.addFocusTracker(styledText, StyledText.class.getCanonicalName());
	}

	private ValidationJob createValidationJob() {
		return new ValidationJob(validator, document,
				new AnnotationIssueProcessor(document, sourceviewer
						.getAnnotationModel(), resolutionProvider),
				CheckMode.ALL);
	}

	protected ResourceSet createXtextResourceSet() {
		ResourceSet resourceSet = resourceSetProvider.get(getActiveProject());
		return resourceSet;
	}

	protected void createXtextSourceViewer() {
		sourceviewer = sourceViewerFactory.createSourceViewer(parent, null,
				null, false, style);
		sourceviewer.configure(configuration);
		sourceviewer.setDocument(document, new AnnotationModel());
		SourceViewerDecorationSupport support = new SourceViewerDecorationSupport(
				sourceviewer, null, new DefaultMarkerAnnotationAccess(),
				EditorsPlugin.getDefault().getSharedTextColors());
		configureSourceViewerDecorationSupport(support);
	}

	private void installHighlightingHelper() {
		if (xtextStyledTextHighlightingHelper != null) {
			xtextStyledTextHighlightingHelper.install(this, sourceviewer);
		}
	}

	private void uninstallHighlightingHelper() {
		if (xtextStyledTextHighlightingHelper != null) {
			xtextStyledTextHighlightingHelper.uninstall();
		}
	}

	public void dispose() {
		uninstallHighlightingHelper();
		document.disposeInput();
	}

	protected IProject getActiveProject() {
		if (activeProject == null) {
			activeProject = ActiveEditorTracker.getLastActiveEditorProject();
		}
		return activeProject;
	}

	protected Resource getContextResource() {
		return contextResource;
	}

	protected XtextDocument getDocument() {
		return document;
	}

	protected XtextResource getFakeResource() {
		return fakeResource;
	}

	protected String getFileExtension() {
		return fileExtension;
	}

	public List<Issue> getIssues() {
		return validationJob.createIssues(new NullProgressMonitor());
	}

	public IParseResult getParseResult() {
		return document
				.readOnly(new IUnitOfWork<IParseResult, XtextResource>() {

					public IParseResult exec(XtextResource state)
							throws Exception {
						return state.getParseResult();
					}
				});
	}

	protected ResourceSet getResourceSet() {
		return resourceSet;
	}

	public XtextSourceViewer getSourceviewer() {
		return sourceviewer;
	}
	
	XtextSourceViewerConfiguration getSourceViewerConfiguration() {
		return configuration;
	}

	/**
	 * @return The actual {@link StyledText} control.
	 */
	public StyledText getStyledText() {
		if (styledText == null) {
			createStyledText();
		}
		return styledText;
	}

	protected IResourceValidator getValidator() {
		return validator;
	}

	private void initXtextDocument() {
		document.setInput(fakeResource);

		IDocumentPartitioner partitioner = documentPartitioner.get();
		partitioner.connect(document);
		document.setDocumentPartitioner(partitioner);
	}

	protected void initXtextFakeResource() {
		// add the fake resource (add an uri to it, first)
		String activeProject = getActiveProject().getName();
		fakeResource.setURI(createFakeResourceUri(activeProject));
		resourceSet.getResources().add(fakeResource);
	}

	public void resetVisibleRegion() {
		sourceviewer.resetVisibleRegion();
	}

	/**
	 * Update the contextResource for the styled text.
	 */
	public void setContextResource(Resource contextResource) {
		// remove any other resources that may have been created earlier
		List<Resource> staleResources = new ArrayList<Resource>();
		for (Resource r : resourceSet.getResources()) {
			if (r != fakeResource) {
				staleResources.add(r);
				r.unload();
			}
		}
		resourceSet.getResources().removeAll(staleResources);
		// create context fake resource
		this.contextResource = contextResource;
		if (contextResource != null) {
			createContextFakeResource();
		}
	}

	public void setVisibleRegion(int start, int length) {
		sourceviewer.setVisibleRegion(start, length);
	}
}
