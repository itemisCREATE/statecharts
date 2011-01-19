/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.yakindu.sct.statechart.diagram.xtext.integration;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.text.source.AnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.internal.editors.text.EditorsPlugin;
import org.eclipse.ui.texteditor.AbstractDecoratedTextEditor;
import org.eclipse.ui.texteditor.AnnotationPreference;
import org.eclipse.ui.texteditor.DefaultMarkerAnnotationAccess;
import org.eclipse.ui.texteditor.MarkerAnnotationPreferences;
import org.eclipse.ui.texteditor.SourceViewerDecorationSupport;
import org.eclipse.xtext.parser.antlr.IAntlrParser;
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
import org.eclipse.xtext.ui.editor.validation.IValidationIssueProcessor;
import org.eclipse.xtext.ui.editor.validation.ValidationJob;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

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
public class XTextCellEditor extends CellEditor {

	/**
	 * Key listener executed content assist operation on CTRL+Space
	 */
	private final KeyListener keyListener = new KeyListener() {

		@Override
		public void keyReleased(KeyEvent e) {
			// Nothing to do
		}

		@Override
		public void keyPressed(KeyEvent e) {
			updateDocument();
			if ((e.character == ' ') && ((e.stateMask & SWT.CTRL) != 0)) {
				BusyIndicator.showWhile(Display.getDefault(), new Runnable() {
					public void run() {
						sourceviewer
								.doOperation(ISourceViewer.CONTENTASSIST_PROPOSALS);
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
	public XTextCellEditor(Composite parent, Injector injector, int style) {
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
		document = createDocument();
		IResourceValidator validator = createResourceValidator();
		sourceviewer.setDocument(document, new AnnotationModel());
		SourceViewerDecorationSupport support = new SourceViewerDecorationSupport(
				sourceviewer, null, new DefaultMarkerAnnotationAccess(),
				EditorsPlugin.getDefault().getSharedTextColors());
		configureSourceViewerDecorationSupport(support);

		ValidationJob validationJob = new ValidationJob(validator, document,
				new ValidationProcessor(document,
						sourceviewer.getAnnotationModel()), CheckMode.ALL);
		document.setValidationJob(validationJob);

		text = sourceviewer.getTextWidget();
		text.addKeyListener(keyListener);
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
	private XtextDocument createDocument() {
		XtextDocument document = injector.getInstance(XtextDocument.class);
		XtextResource resource = injector.getInstance(XtextResource.class);
		XtextResourceSet resourceSet = injector
				.getInstance(XtextResourceSet.class);
		resourceSet.getResources().add(resource);
		resource.setParser(injector.getInstance(IAntlrParser.class));
		resource.setURI(URI.createURI("platform:/resource/"
				+ System.currentTimeMillis() + "/dummy"));
		document.setInput(resource);
		return document;
	}

	/**
	 * Updates the documents content
	 */
	private void updateDocument() {
		document.modify(new IUnitOfWork.Void<XtextResource>() {
			@Override
			public void process(XtextResource state) throws Exception {
				state.reparse(text.getText());
			}
		});
	}

	@Override
	protected Object doGetValue() {
		return text.getText();
	}

	@Override
	protected void doSetFocus() {
		text.setFocus();

	}

	@Override
	protected void doSetValue(Object value) {
		text.setText((String) value == null ? "" : (String) value);
		updateDocument();

	}

	@Override
	public void dispose() {
		text.removeKeyListener(keyListener);
		document.disposeInput();
		super.dispose();
	}

	/**
	 * Validation job
	 */
	private static class ValidationProcessor implements
			IValidationIssueProcessor {

		private AnnotationIssueProcessor processor;

		public ValidationProcessor(XtextDocument document,
				IAnnotationModel model) {
			processor = new AnnotationIssueProcessor(document, model,
					new IssueResolutionProvider.NullImpl());
		}

		public void processIssues(List<Issue> issues, IProgressMonitor monitor) {
			processor.processIssues(issues, monitor);
		}
	}

}
