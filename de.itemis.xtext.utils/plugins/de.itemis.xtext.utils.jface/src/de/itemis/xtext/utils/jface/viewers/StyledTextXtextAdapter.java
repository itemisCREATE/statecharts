package de.itemis.xtext.utils.jface.viewers;

import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.source.AnnotationModel;
import org.eclipse.jface.text.source.ICharacterPairMatcher;
import org.eclipse.jface.text.source.ISharedTextColors;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
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
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.XtextSourceViewerConfiguration;
import org.eclipse.xtext.ui.editor.bracketmatching.BracketMatchingPreferencesInitializer;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider;
import org.eclipse.xtext.ui.editor.validation.AnnotationIssueProcessor;
import org.eclipse.xtext.ui.editor.validation.ValidationJob;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

import de.itemis.xtext.utils.jface.fieldassist.CompletionProposalAdapter;
import de.itemis.xtext.utils.jface.viewers.context.IXtextFakeContextResourcesProvider;
import de.itemis.xtext.utils.jface.viewers.context.XtextFakeResourceContext;

/**
 * 
 * @author andreas.muelder@itemis.de
 * @author alexander.nyssen@itemis.de
 * @author patrick.koenemann@itemis.de
 * 
 */
@SuppressWarnings("restriction")
public class StyledTextXtextAdapter {

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
	private XtextStyledTextHighlightingHelper xtextStyledTextHighlightingHelper;
	@Inject
	private IResourceValidator validator;
	@Inject
	private Provider<IDocumentPartitioner> documentPartitioner;
	@Inject
	private XtextDocument document;
	private XtextFakeResourceContext fakeResourceContext;
	private final IXtextFakeContextResourcesProvider contextFakeResourceProvider;

	private StyledText styledText;

	public StyledTextXtextAdapter(Injector injector,
			IXtextFakeContextResourcesProvider contextFakeResourceProvider) {
		this.contextFakeResourceProvider = contextFakeResourceProvider;
		injector.injectMembers(this);

		// create fake resource and containing resource set
		createFakeResourceContext(injector);
	}

	public StyledTextXtextAdapter(Injector injector) {
		this(injector, IXtextFakeContextResourcesProvider.NULL_CONTEXT_PROVIDER);
	}

	public void adapt(StyledText styledText) {
		this.styledText = styledText;

		// perform initialization of fake resource context
		updateFakeResourceContext();

		// connect Xtext document to fake resource
		initXtextDocument(fakeResourceContext);

		// connect xtext document to xtext source viewer
		createXtextSourceViewer();

		// install semantic highlighting support
		installHighlightingHelper();

		validationJob = createValidationJob();
		document.setValidationJob(validationJob);

		styledText.setData(StyledTextXtextAdapter.class.getCanonicalName(),
				this);

		final IContentAssistant contentAssistant = sourceviewer
				.getContentAssistant();
		final CompletionProposalAdapter completionProposalAdapter = new CompletionProposalAdapter(
				styledText, contentAssistant, KeyStroke.getInstance(SWT.CTRL,
						SWT.SPACE), null);

		if ((styledText.getStyle() & SWT.SINGLE) != 0) {
			// The regular key down event is too late (after popup is closed).
			// when using the StyledText.VerifyKey event (3005), we get the
			// event early enough!
			styledText.addListener(3005, new Listener() {
				public void handleEvent(Event event) {
					if (event.character == SWT.CR
							&& !completionProposalAdapter.isProposalPopupOpen()) {
						Event selectionEvent = new Event();
						selectionEvent.type = SWT.DefaultSelection;
						selectionEvent.widget = event.widget;
						for (Listener l : event.widget
								.getListeners(SWT.DefaultSelection)) {
							l.handleEvent(selectionEvent);
						}
					}
				}
			});
		}

		// Register focus tracker for evaluating the active focus control in
		// core expression
		IFocusService service = (IFocusService) PlatformUI.getWorkbench()
				.getService(IFocusService.class);
		service.addFocusTracker(styledText, StyledText.class.getCanonicalName());

	}

	protected ValidationJob createValidationJob() {
		return new ValidationJob(validator, document,
				new AnnotationIssueProcessor(document, sourceviewer
						.getAnnotationModel(), resolutionProvider),
				CheckMode.ALL);
	}

	protected void createFakeResourceContext(Injector injector) {
		this.fakeResourceContext = new XtextFakeResourceContext(injector);
	}

	protected void createXtextSourceViewer() {
		sourceviewer = new XtextSourceViewerEx(styledText,
				preferenceStoreAccess.getPreferenceStore());
		sourceviewer.configure(configuration);
		sourceviewer.setDocument(document, new AnnotationModel());
		SourceViewerDecorationSupport support = new SourceViewerDecorationSupport(
				sourceviewer, null, new DefaultMarkerAnnotationAccess(),
				getSharedColors());
		configureSourceViewerDecorationSupport(support);
	}

	protected ISharedTextColors getSharedColors() {
		return EditorsPlugin.getDefault().getSharedTextColors();
	}

	/**
	 * Creates decoration support for the sourceViewer. code is entirely copied
	 * from {@link XtextEditor} and its super class
	 * {@link AbstractDecoratedTextEditor}.
	 * 
	 */
	protected void configureSourceViewerDecorationSupport(
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

	protected void initXtextDocument(XtextFakeResourceContext context) {
		document.setInput(context.getFakeResource());

		IDocumentPartitioner partitioner = documentPartitioner.get();
		partitioner.connect(document);
		document.setDocumentPartitioner(partitioner);
	}

	public void setVisibleRegion(int start, int length) {
		sourceviewer.setVisibleRegion(start, length);
	}

	public void resetVisibleRegion() {
		sourceviewer.resetVisibleRegion();
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

	protected XtextSourceViewerConfiguration getXtextSourceViewerConfiguration() {
		return configuration;
	}

	protected XtextDocument getXtextDocument() {
		return document;
	}

	protected XtextSourceViewer getXtextSourceviewer() {
		return sourceviewer;
	}

	public IParseResult getXtextParseResult() {
		return document
				.readOnly(new IUnitOfWork<IParseResult, XtextResource>() {

					public IParseResult exec(XtextResource state)
							throws Exception {
						return state.getParseResult();
					}
				});
	}

	public IContentAssistant getContentAssistant() {
		return getXtextSourceviewer().getContentAssistant();
	}

	public List<Issue> getXtextValidationIssues() {
		return validationJob.createIssues(new NullProgressMonitor());
	}

	public void updateFakeResourceContext() {
		fakeResourceContext
				.updateFakeResourceContext(contextFakeResourceProvider);
	}

	protected IXtextFakeContextResourcesProvider getFakeResourceContextProvider() {
		return contextFakeResourceProvider;
	}

	public XtextFakeResourceContext getFakeResourceContext() {
		return fakeResourceContext;
	}
}
