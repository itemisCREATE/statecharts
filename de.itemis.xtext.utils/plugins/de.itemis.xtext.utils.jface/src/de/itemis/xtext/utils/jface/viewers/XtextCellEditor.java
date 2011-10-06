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

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Injector;

import de.itemis.utils.jface.viewers.StyledTextCellEditor;
import de.itemis.xtext.utils.jface.fieldassist.CompletionProposalAdapter;


/**
 * This class integrates Xtext features into a {@link CellEditor} and can be used e.g. in 
 * jFace {@link StructuredViewer}s or in GMF EditParts via DirectEditManager.
 * 
 * The current implementation supports, code completion, syntax highlighting and validation
 * 
 * @see XtextStyledText
 * 
 * @author andreas.muelder@itemis.de
 * @author alexander.nyssen@itemis.de
 * @author patrick.koenemann@itemis.de
 */
public class XtextCellEditor extends StyledTextCellEditor {

	/**
	 * Delegator to the actual styled text that provides the xtext features.
	 */
	protected XtextStyledText xtextWidget;

	private Injector injector;
	
	private Resource context;
	
	/**
	 * C'tor to create a new Instance.
	 * 
	 * @param style
	 *            The SWT style of this cell editor.
	 * @param injector
	 *            Used for dependency injection of xtext features.
	 */
	public XtextCellEditor(int style, Injector injector) {
		setStyle(style);
		this.injector = injector;
	}

	/**
	 * C'tor to create a new Instance with context.
	 * 
	 * @param style
	 *            The SWT style of this cell editor.
	 * @param injector
	 *            Used for dependency injection of xtext features.
	 * @param context
	 *            The context for xtext.
	 */
	public XtextCellEditor(int style, Injector injector, Resource context) {
		this(style, injector);
		this.context = context;
	}

	/**
	 * Creates an {@link SourceViewer} and returns the {@link StyledText} widget of the 
	 * viewer as the cell editors control. Some code is copied from {@link XtextEditor}.
	 */
	@Override
	protected Control createControl(Composite parent) {
		xtextWidget = createXtextWidget(parent, getStyle(), injector, context);
		text = xtextWidget.getStyledText();
		text.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				XtextCellEditor.this.focusLost();
			}
		});
		
		final XtextSourceViewer sourceViewer = xtextWidget.getSourceviewer();
		final IContentAssistant contentAssistant = sourceViewer.getContentAssistant();
		new CompletionProposalAdapter(text, contentAssistant, KeyStroke.getInstance(SWT.CTRL, SWT.SPACE), null);

		if ((text.getStyle() & SWT.SINGLE) != 0) {
			
			// The regular key down event is too late (after popup is closed again).
			// when using the StyledText.VerifyKey event (3005), we get the event early enough!
			text.addListener(3005, new Listener() {
				public void handleEvent(Event event) {
					if (event.character == SWT.CR && !xtextWidget.isProposalPopupActive()) {
//						System.err.println("handle event (CR), " + event.doit + " -> " + event);
						XtextCellEditor.this.fireApplyEditorValue();
					} else if (event.character == SWT.ESC && !xtextWidget.isProposalPopupActive()) {
//						System.err.println("handle event (ESC), " + event.doit + " -> " + event);
						XtextCellEditor.this.fireCancelEditor();
					}
				}
			});
		}
		
		return text;
	}

	@Override
	protected void focusLost() {
		if (!xtextWidget.isProposalPopupActive())
			super.focusLost();
	}
	
	protected XtextStyledText createXtextWidget(Composite parent, int style, Injector injector, Resource context) {
		return new XtextStyledText(parent, style, injector, context);
	}

	@Override
	public void dispose() {
		xtextWidget.dispose();
		super.dispose();
	}

	/**
	 * This is damn important! If we don't return false here, the ColumnEditorViewer calls applyEditorValue on FocusLostEvents!
	 */
	@Override
	protected boolean dependsOnExternalFocusListener() {
		return false;
	}
	
	public void setContext(Resource context) {
		xtextWidget.setContextResource(context);
	}

	public List<Issue> getIssues() {
		return xtextWidget.getIssues();
	}

	public Resource getContext() {
		return xtextWidget.getContextResource();
	}
	
	public void setVisibleRegion(int start, int length) {
		xtextWidget.setVisibleRegion(start, length);
	}

}
