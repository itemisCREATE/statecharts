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
package de.itemis.xtext.utils.jface.viewers;

import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.text.source.AnnotationModel;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewer;
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
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Inject;


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
public class XtextCellEditor extends StyledTextCellEditor {

	/**
	 * Key listener executed content assist operation on CTRL+Space
	 */
	private final KeyListener keyListener = new KeyListener() {


		public void keyPressed(KeyEvent e) {
			XtextCellEditor.this.valueChanged(true, true);
			// CONTENTASSIST_PROPOSALS
			if ((e.keyCode == 32) && ((e.stateMask & SWT.CTRL) != 0)) {
				BusyIndicator.showWhile(Display.getDefault(), new Runnable() {
					public void run() {
						sourceviewer
								.doOperation(ISourceViewer.CONTENTASSIST_PROPOSALS);
					}
				});
			}
		}
		public void keyReleased(KeyEvent e) {
		}

	};

	

	/**
	 * The sourceViewer, that provides additional functions to the styled text
	 * widget
	 */
	private XtextSourceViewer sourceviewer;

	private ValidationJob validationJob;
	/**
	 * the xText document the sourceViewer uses
	 */
	@Inject
	private XtextDocument document;
	@Inject
	private IssueResolutionProvider resolutionProvider;
	@Inject
	private IPreferenceStoreAccess preferenceStoreAccess;
	@Inject
	private CharacterPairMatcher characterPairMatcher;
	@Inject
	private XtextSourceViewerConfiguration configuration;
	@Inject
	private Factory sourceViewerFactory;
	@Inject
	private XtextResource resource;
	@Inject
	private IResourceValidator validator;



	/**
	 * C'tor to create a new Instance.
	 * 
	 */
	public XtextCellEditor(int style) {
		setStyle(style);
	}
	
	/**
	 * Creates an {@link SourceViewer} and returns the {@link StyledText} widget
	 * of the viewer as the cell editors control. Some code is copied from
	 * {@link XtextEditor}.
	 */
	@Override
	protected Control createControl(Composite parent) {
		sourceviewer = sourceViewerFactory.createSourceViewer(parent, null,
				null, false, getStyle());
		sourceviewer.configure(configuration);
		
		//'dummy' document for the sourceviewer
		XtextResourceSet resourceSet = new XtextResourceSet();
		resourceSet.getResources().add(resource);
		setResourceUri(resource);
		document.setInput(resource);
		
		sourceviewer.setDocument(document, new AnnotationModel());

		SourceViewerDecorationSupport support = new SourceViewerDecorationSupport(
				sourceviewer, null, new DefaultMarkerAnnotationAccess(),
				EditorsPlugin.getDefault().getSharedTextColors());
		configureSourceViewerDecorationSupport(support);

		validationJob = createValidationJob();
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


	@Override
	protected StyledText createStyledText(Composite parent) {
		sourceviewer = sourceViewerFactory.createSourceViewer(parent, null,
				null, false, getStyle());
		sourceviewer.configure(configuration);
		sourceviewer.setDocument(document, new AnnotationModel());

		SourceViewerDecorationSupport support = new SourceViewerDecorationSupport(
				sourceviewer, null, new DefaultMarkerAnnotationAccess(),
				EditorsPlugin.getDefault().getSharedTextColors());
		configureSourceViewerDecorationSupport(support);

		validationJob = createValidationJob();
		document.setValidationJob(validationJob);

		return sourceviewer.getTextWidget();
	}

	private ValidationJob createValidationJob() {
		return new ValidationJob(validator, document,
				new AnnotationIssueProcessor(document, sourceviewer
						.getAnnotationModel(), resolutionProvider),
				CheckMode.ALL);
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


	/**
	 * Sets the resource uri. From the resource uris project name the global
	 * scope is determined.
	 * 
	 * @param resource
	 */
	protected void setResourceUri(final XtextResource resource) {
		// TODO: This should be moved outside the CellEditor
		//TODO: Remove dependency to IFileEditorInput
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


	public IParseResult getParseResult() {
		return document
				.readOnly(new IUnitOfWork<IParseResult, XtextResource>() {

					public IParseResult exec(XtextResource state)
							throws Exception {
						return state.getParseResult();
					}
				});
	}

	public List<Issue> getIssues() {
		return validationJob.createIssues(new NullProgressMonitor());
	}

	@Override
	public void dispose() {
		text.removeKeyListener(keyListener);
		document.disposeInput();
		super.dispose();
	}
}
