/**
 * Copyright (c) 2011 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	itemis AG - initial API and implementation
 * 
 */
package de.itemis.xtext.utils.gmf.directedit;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.jface.text.source.AnnotationModel;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.editors.text.EditorsPlugin;
import org.eclipse.ui.texteditor.AbstractDecoratedTextEditor;
import org.eclipse.ui.texteditor.AnnotationPreference;
import org.eclipse.ui.texteditor.DefaultMarkerAnnotationAccess;
import org.eclipse.ui.texteditor.MarkerAnnotationPreferences;
import org.eclipse.ui.texteditor.SourceViewerDecorationSupport;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.XtextSourceViewer.Factory;
import org.eclipse.xtext.ui.editor.XtextSourceViewerConfiguration;
import org.eclipse.xtext.ui.editor.bracketmatching.BracketMatchingPreferencesInitializer;
import org.eclipse.xtext.ui.editor.bracketmatching.CharacterPairMatcher;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider;
import org.eclipse.xtext.ui.editor.validation.AnnotationIssueProcessor;
import org.eclipse.xtext.ui.editor.validation.ValidationJob;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;

import com.google.inject.Injector;

/**
 * This class integrates xText Features into a {@link CellEditor} and can be
 * used i.E. in jface {@link StructuredViewer}s or in GMF EditParts via
 * DirectEditManager.
 * 
 * The current implementation supports, code completion, syntax highlighting and
 * validation
 * 
 * Some code is initially copied from xText.
 * 
 * @author andreas.muelder@itemis.de
 * @author alexander.nyssen@itemis.de
 */

@SuppressWarnings("restriction")
public class XtextCellEditor extends CellEditor {

	/**
	 * Key listener executed content assist operation on CTRL+Space
	 */
	private final KeyListener keyListener = new KeyListener() {

		public void keyReleased(KeyEvent e) {
			// TODO
			// XTextCellEditor.this.keyReleaseOccured(e);
		}

		public void keyPressed(KeyEvent e) {
			XtextCellEditor.this.valueChanged(true, true);
			//CONTENTASSIST_PROPOSALS
			if ((e.keyCode == 32) && ((e.stateMask & SWT.CTRL) != 0)) {
				BusyIndicator.showWhile(Display.getDefault(), new Runnable() {
					public void run() {
						sourceviewer
								.doOperation(ISourceViewer.CONTENTASSIST_PROPOSALS);
					}
				});
			}
			//QUICK_ASSIST
			if ((e.keyCode == 49) && ((e.stateMask & SWT.CTRL) != 0)) {
				BusyIndicator.showWhile(Display.getDefault(), new Runnable() {
					public void run() {
						sourceviewer
								.doOperation(ISourceViewer.QUICK_ASSIST);
					}
				});
			}
		}

	};

	/**
	 * the SWT Control the cell editor works with
	 */
	private StyledText text;
	/**
	 * the google guice injector used to create the required instances via the
	 * xText generated modules
	 */
	private Injector injector;

	/**
	 * the xText document the sourceViewer uses
	 */
	private XtextDocument document;
	

	/**
	 * The sourceViewer, that provides additional functions to the styled text
	 * widget
	 */
	private XtextSourceViewer sourceviewer;

	/**
	 * C'tor to create a new Instance.
	 * 
	 */
	public XtextCellEditor(Composite parent, Injector injector, int style) {
		this.injector = injector;
		setStyle(style);
		create(parent);
	}

	/**
	 * Creates an {@link SourceViewer} and returns the {@link StyledText} widget
	 * of the viewer as the cell editors control. Some code is copied from
	 * {@link XtextEditor}.
	 */
	@Override
	protected Control createControl(Composite parent) {
		Factory sourceViewerFactory = createSourceViewerFactory();
		sourceviewer = sourceViewerFactory.createSourceViewer(parent, null,
				null, false, getStyle());
		final SourceViewerConfiguration configuration = createSourceViewerConfiguration();
		sourceviewer.configure(configuration);
		document = createDocument(injector);

		IResourceValidator validator = createResourceValidator();
		sourceviewer.setDocument(document, new AnnotationModel());

		SourceViewerDecorationSupport support = new SourceViewerDecorationSupport(
				sourceviewer, null, new DefaultMarkerAnnotationAccess(),
				EditorsPlugin.getDefault().getSharedTextColors());
		configureSourceViewerDecorationSupport(support);

		IssueResolutionProvider resolutionProvider = injector
				.getInstance(IssueResolutionProvider.class);
		ValidationJob validationJob = new ValidationJob(validator, document,
				new AnnotationIssueProcessor(document, sourceviewer
						.getAnnotationModel(), resolutionProvider),
				CheckMode.ALL);
		document.setValidationJob(validationJob);

		text = sourceviewer.getTextWidget();
		text.addKeyListener(keyListener);

		text.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				XtextCellEditor.this.focusLost();
			}
		});
		text.setFont(parent.getFont());
		text.setBackground(parent.getBackground());
		text.setText("");
		return text;
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

		CharacterPairMatcher characterPairMatcher = injector
				.getInstance(CharacterPairMatcher.class);
		if (characterPairMatcher != null) {
			support.setCharacterPairMatcher(characterPairMatcher);
			support.setMatchingCharacterPainterPreferenceKeys(
					BracketMatchingPreferencesInitializer.IS_ACTIVE_KEY,
					BracketMatchingPreferencesInitializer.COLOR_KEY);

			IPreferenceStoreAccess instance = injector
					.getInstance(IPreferenceStoreAccess.class);
			support.install(instance.getPreferenceStore());
		}

	}

	private IResourceValidator createResourceValidator() {
		IResourceValidator validator = injector
				.getInstance(IResourceValidator.class);
		return validator;
	}

	private SourceViewerConfiguration createSourceViewerConfiguration() {
		SourceViewerConfiguration configuration = injector
				.getInstance(XtextSourceViewerConfiguration.class);
		return configuration;
	}

	private Factory createSourceViewerFactory() {
		Factory sourceViewerFactory = injector
				.getInstance(XtextSourceViewer.Factory.class);
		return sourceViewerFactory;
	}

	/**
	 * Creates a "dummy" Document that the source viewer can use
	 * 
	 */
	public XtextDocument createDocument(Injector injector) {
		XtextDocument document = injector.getInstance(XtextDocument.class);
		XtextResource resource = injector.getInstance(XtextResource.class);
		XtextResourceSet resourceSet = injector
				.getInstance(XtextResourceSet.class);
		resourceSet.getResources().add(resource);
		// resource.setParser(injector.getInstance(IAntlrParser.class));
		setResourceUri(resource);
		document.setInput(resource);
		return document;
	}

	/**
	 * Sets the resource uri. From the resource uris project name the global
	 * scope is determined.
	 * 
	 * @param resource
	 */
	protected void setResourceUri(final XtextResource resource) {
		// TODO: This should be moved outside the CellEditor
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				IWorkbenchWindow activeWorkbenchWindow = PlatformUI
						.getWorkbench().getActiveWorkbenchWindow();
				IWorkbenchPage activePage = activeWorkbenchWindow
						.getActivePage();
				if (activePage != null) {
					IEditorInput editorInput = activePage.getActiveEditor()
							.getEditorInput();
					if (editorInput instanceof IFileEditorInput) {
						IFileEditorInput input = (IFileEditorInput) editorInput;
						String activeProject = input.getFile().getProject()
								.getName();
						resource.setURI(URI.createURI("platform:/resource/"
								+ activeProject + "/embedded"));
					}
				}
			}
		});
	}


	@Override
	protected Object doGetValue() {
		return text.getText();
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
	
	public List<Diagnostic> getDiagnostics()
	{
		return document
		.readOnly(new IUnitOfWork<List<Diagnostic>, XtextResource>() {

			public List<Diagnostic> exec(XtextResource state)
					throws Exception {
				return state.getErrors();
			}
		});
	}
	
	

	@Override
	protected void doSetFocus() {
		text.setFocus();
	}

	@Override
	protected void doSetValue(Object value) {
		text.setText((String) value == null ? "" : (String) value);
		formatText();

	}

	private void formatText() {
		BusyIndicator.showWhile(Display.getDefault(), new Runnable() {
			public void run() {
				// sourceviewer
				// .doOperation(ISourceViewer.FORMAT);
			}
		});
	}
	
	public XtextDocument getDocument() {
		return document;
	}

	@Override
	public void dispose() {
		text.removeKeyListener(keyListener);
		document.disposeInput();
		super.dispose();
	}
}
