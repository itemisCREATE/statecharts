/**
 * Copyright (c) 2015 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.base.xtext.utils.jface.viewers;

import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.source.AnnotationModel;
import org.eclipse.jface.text.source.ICharacterPairMatcher;
import org.eclipse.jface.text.source.ISharedTextColors;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.IWorkbenchPartSite;
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
import org.yakindu.base.xtext.utils.jface.fieldassist.CompletionProposalAdapter;
import org.yakindu.base.xtext.utils.jface.viewers.context.IXtextFakeContextResourcesProvider;
import org.yakindu.base.xtext.utils.jface.viewers.context.XtextFakeResourceContext;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

/**
 *
 * @author andreas.muelder@itemis.de
 * @author alexander.nyssen@itemis.de
 * @author patrick.koenemann@itemis.de
 *
 */
@SuppressWarnings("restriction")
public class StyledTextXtextAdapter {

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

	private final IssueResolutionProvider resolutionProvider = new IssueResolutionProvider.NullImpl();
	private final IXtextFakeContextResourcesProvider contextFakeResourceProvider;
	private final XtextFakeResourceContext fakeResourceContext;

	private XtextSourceViewer sourceviewer;

	private ValidationJob validationJob;

	private StyledText styledText;

	private ControlDecoration decoration;

	private SourceViewerDecorationSupport decorationSupport;
	private IWorkbenchPartSite site;

	public StyledTextXtextAdapter(Injector injector, IXtextFakeContextResourcesProvider contextFakeResourceProvider) {
		this.contextFakeResourceProvider = contextFakeResourceProvider;
		injector.injectMembers(this);

		// create fake resource and containing resource set
		this.fakeResourceContext = createFakeResourceContext(injector);
	}

	public StyledTextXtextAdapter(Injector injector) {
		this(injector, IXtextFakeContextResourcesProvider.NULL_CONTEXT_PROVIDER);
	}

	public StyledTextXtextAdapter(Injector inject, IWorkbenchPartSite site) {
		this(inject);
		this.site = site;
	}

	public void adapt(StyledText styledText) {
		adapt(styledText, true);
	}

	public void adapt(StyledText styledText, boolean decorate) {
		this.styledText = styledText;

		// perform initialization of fake resource context
		updateFakeResourceContext();

		// connect Xtext document to fake resource
		initXtextDocument(getFakeResourceContext());

		// connect xtext document to xtext source viewer
		this.sourceviewer = createXtextSourceViewer();
		this.decorationSupport = createSourceViewerDecorationSupport();
		configureSourceViewerDecorationSupport(getDecorationSupport());

		// install semantic highlighting support
		installHighlightingHelper();

		this.validationJob = createValidationJob();
		getXtextDocument().setValidationJob(getValidationJob());

		styledText.setData(StyledTextXtextAdapter.class.getCanonicalName(), this);

		final IContentAssistant contentAssistant = getXtextSourceviewer().getContentAssistant();
		final CompletionProposalAdapter completionProposalAdapter = new CompletionProposalAdapter(styledText,
				contentAssistant, KeyStroke.getInstance(SWT.CTRL, SWT.SPACE), null);

		if ((styledText.getStyle() & SWT.SINGLE) != 0) {
			// The regular key down event is too late (after popup is closed).
			// when using the StyledText.VerifyKey event (3005), we get the
			// event early enough!
			styledText.addListener(3005, new Listener() {
				@Override
				public void handleEvent(Event event) {
					if (event.character == SWT.CR && !completionProposalAdapter.isProposalPopupOpen()) {
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

		// Register focus tracker for evaluating the active focus control in
		// core expression
		IFocusService service = (IFocusService) PlatformUI.getWorkbench().getService(IFocusService.class);
		service.addFocusTracker(styledText, StyledText.class.getCanonicalName());

		if (decorate) {
			// add JDT Style code completion hint decoration
			this.decoration = createContentAssistDecoration(styledText);
		}

		initSelectionProvider();
	}

	protected void initSelectionProvider() {
		// Overrides the editors selection provider to provide the text
		// selection if opened within an editor context
		try {
			if (this.site == null) {
				site = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().getSite();
			}
			XtextStyledTextSelectionProvider xtextStyledTextSelectionProvider = new XtextStyledTextSelectionProvider(
					this.styledText, getFakeResourceContext().getFakeResource());
			ChangeSelectionProviderOnFocusGain listener = new ChangeSelectionProviderOnFocusGain(site,
					xtextStyledTextSelectionProvider, styledText);
			getStyledText().addFocusListener(listener);
			getStyledText().addDisposeListener(listener);
		} catch (NullPointerException ex) {
			// Do nothing, not opened within editor context
		}
	}

	private ControlDecoration createContentAssistDecoration(StyledText styledText) {
		final ControlDecoration result = new ControlDecoration(styledText, SWT.TOP | SWT.LEFT);
		result.setShowHover(true);
		result.setShowOnlyOnFocus(true);

		final Image image = ImageDescriptor
				.createFromFile(XtextStyledTextCellEditor.class, "images/content_assist_cue.gif").createImage();
		result.setImage(image);
		result.setDescriptionText("Content Assist Available (CTRL + Space)");
		result.setMarginWidth(2);
		styledText.addDisposeListener(new DisposeListener() {
			@Override
			public void widgetDisposed(DisposeEvent e) {
				if (getDecoration() != null) {
					getDecoration().dispose();
				}
				if (image != null) {
					image.dispose();
				}
			}
		});
		return result;
	}

	protected ValidationJob createValidationJob() {
		return new ValidationJob(getValidator(), getXtextDocument(), new AnnotationIssueProcessor(getXtextDocument(),
				getXtextSourceviewer().getAnnotationModel(), getResolutionProvider()), CheckMode.FAST_ONLY);
	}

	protected XtextFakeResourceContext createFakeResourceContext(Injector injector) {
		return new XtextFakeResourceContext(injector);
	}

	protected XtextSourceViewer createXtextSourceViewer() {
		final XtextSourceViewer result = new XtextSourceViewerEx(getStyledText(),
				getPreferenceStoreAccess().getPreferenceStore());
		result.configure(getXtextSourceViewerConfiguration());
		result.setDocument(getXtextDocument(), new AnnotationModel());
		return result;
	}

	protected ISharedTextColors getSharedColors() {
		return EditorsPlugin.getDefault().getSharedTextColors();
	}

	/**
	 * Creates decoration support for the sourceViewer. code is entirely copied from
	 * {@link XtextEditor} and its super class {@link AbstractDecoratedTextEditor}.
	 *
	 */
	protected void configureSourceViewerDecorationSupport(SourceViewerDecorationSupport support) {
		MarkerAnnotationPreferences annotationPreferences = new MarkerAnnotationPreferences();
		List<AnnotationPreference> prefs = annotationPreferences.getAnnotationPreferences();
		for (AnnotationPreference annotationPreference : prefs) {
			support.setAnnotationPreference(annotationPreference);
		}

		support.setCharacterPairMatcher(getCharacterPairMatcher());
		support.setMatchingCharacterPainterPreferenceKeys(BracketMatchingPreferencesInitializer.IS_ACTIVE_KEY,
				BracketMatchingPreferencesInitializer.COLOR_KEY);

		support.install(getPreferenceStoreAccess().getPreferenceStore());
	}

	protected void unconfigureSourceViewerDecorationSupport(SourceViewerDecorationSupport support) {
		support.uninstall();
	}

	protected void initXtextDocument(XtextFakeResourceContext context) {
		getXtextDocument().setInput(context.getFakeResource());
		IDocumentPartitioner partitioner = getDocumentPartitioner().get();
		partitioner.connect(getXtextDocument());
		getXtextDocument().setDocumentPartitioner(partitioner);
	}

	public void setVisibleRegion(int start, int length) {
		getXtextSourceviewer().setVisibleRegion(start, length);
	}

	public void resetVisibleRegion() {
		getXtextSourceviewer().resetVisibleRegion();
	}

	private void installHighlightingHelper() {
		if (getXtextStyledTextHighlightingHelper() != null) {
			getXtextStyledTextHighlightingHelper().install(this, getXtextSourceviewer());
		}
	}

	private void uninstallHighlightingHelper() {
		if (getXtextStyledTextHighlightingHelper() != null) {
			getXtextStyledTextHighlightingHelper().uninstall();
		}
	}

	public void dispose() {
		getXtextDocument().setOutdated(true);
		if (getDecorationSupport() != null) {
			unconfigureSourceViewerDecorationSupport(getDecorationSupport());
		}
		uninstallHighlightingHelper();
	}

	protected XtextSourceViewerConfiguration getXtextSourceViewerConfiguration() {
		return this.configuration;
	}

	protected XtextDocument getXtextDocument() {
		return this.document;
	}

	protected XtextSourceViewer getXtextSourceviewer() {
		return this.sourceviewer;
	}

	public IParseResult getXtextParseResult() {
		return getXtextDocument().readOnly(new IUnitOfWork<IParseResult, XtextResource>() {

			@Override
			public IParseResult exec(XtextResource state) throws Exception {
				return state.getParseResult();
			}
		});
	}

	public IContentAssistant getContentAssistant() {
		return getXtextSourceviewer().getContentAssistant();
	}

	public List<Issue> getXtextValidationIssues() {
		return getValidationJob().createIssues(new NullProgressMonitor());
	}

	public void updateFakeResourceContext() {
		getFakeResourceContext().updateFakeResourceContext(getFakeResourceContextProvider());
	}

	protected IXtextFakeContextResourcesProvider getFakeResourceContextProvider() {
		return this.contextFakeResourceProvider;
	}

	public XtextFakeResourceContext getFakeResourceContext() {
		return this.fakeResourceContext;
	}

	protected SourceViewerDecorationSupport createSourceViewerDecorationSupport() {
		return new SourceViewerDecorationSupport(getXtextSourceviewer(), null, new DefaultMarkerAnnotationAccess(),
				getSharedColors());
	}

	protected ValidationJob getValidationJob() {
		return this.validationJob;
	}

	protected IssueResolutionProvider getResolutionProvider() {
		return this.resolutionProvider;
	}

	protected StyledText getStyledText() {
		return this.styledText;
	}

	protected ControlDecoration getDecoration() {
		return this.decoration;
	}

	protected SourceViewerDecorationSupport getDecorationSupport() {
		return this.decorationSupport;
	}

	protected IResourceValidator getValidator() {
		return this.validator;
	}

	protected IPreferenceStoreAccess getPreferenceStoreAccess() {
		return this.preferenceStoreAccess;
	}

	protected ICharacterPairMatcher getCharacterPairMatcher() {
		return this.characterPairMatcher;
	}

	protected Provider<IDocumentPartitioner> getDocumentPartitioner() {
		return this.documentPartitioner;
	}

	protected XtextStyledTextHighlightingHelper getXtextStyledTextHighlightingHelper() {
		return this.xtextStyledTextHighlightingHelper;
	}

	public static class ChangeSelectionProviderOnFocusGain implements FocusListener, DisposeListener {

		protected ISelectionProvider selectionProviderOnFocusGain;
		protected ISelectionProvider selectionProviderOnFocusLost;
		protected IWorkbenchPartSite site;
		private boolean ignoreNextFocusLost = false;
		private StyledText text;

		public ChangeSelectionProviderOnFocusGain(IWorkbenchPartSite site,
				ISelectionProvider selectionProviderOnFocusGain, StyledText text) {
			this.selectionProviderOnFocusGain = selectionProviderOnFocusGain;
			this.site = site;
			this.text = text;
		}

		@Override
		public void focusLost(FocusEvent e) {
			if (SWT.getPlatform().equals("gtk")) {
				if (isIgnoreNextFocusLost()) {
					setIgnoreNextFocusLost(false);
					return;
				}
				if (text.getMenu().isVisible()) {
					setIgnoreNextFocusLost(true);
					return;
				}
			}

			if (this.selectionProviderOnFocusLost != null) {
				this.site.setSelectionProvider(this.selectionProviderOnFocusLost);
			}

			text.setSelection(text.getCaretOffset());

		}

		protected void setIgnoreNextFocusLost(boolean b) {
			this.ignoreNextFocusLost = b;

		}

		protected boolean isIgnoreNextFocusLost() {
			return ignoreNextFocusLost;
		}

		@Override
		public void focusGained(FocusEvent e) {
			this.selectionProviderOnFocusLost = this.site.getSelectionProvider();
			this.site.setSelectionProvider(this.selectionProviderOnFocusGain);
		}

		@Override
		public void widgetDisposed(DisposeEvent e) {
			if (this.selectionProviderOnFocusLost != null) {
				this.site.setSelectionProvider(this.selectionProviderOnFocusLost);
			}
			((StyledText) e.getSource()).removeFocusListener(this);
			((StyledText) e.getSource()).removeDisposeListener(this);
		}

	}
}
