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
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Injector;

/**
 * This class integrates xText Features into a {@link CellEditor} and can be used i.E. in 
 * jface {@link StructuredViewer}s or in GMF EditParts via DirectEditManager.
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
	 * Key listener for updating, applying, and canceling cell editor.
	 */
	private final KeyListener keyListener = new KeyListener() {

		public void keyPressed(KeyEvent e) {
//			if (e.keyCode == SWT.CR && ((text.getStyle() & SWT.MULTI) == 0 || 
//					(e.stateMask & SWT.CTRL) != 0)) {
//				// apply value to cell editor and finish editing
//				XtextCellEditor.this.fireApplyEditorValue();
//			} else if (e.keyCode == SWT.ESC) {
//				// cancel editor
//				XtextCellEditor.this.fireCancelEditor();
//			} else {
//				// notify cell editor about changes
//				XtextCellEditor.this.valueChanged(true, true);
//			}
		}

		public void keyReleased(KeyEvent e) {
		}
	};

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
		text.addKeyListener(keyListener);
		text.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				XtextCellEditor.this.focusLost();
			}
		});
		return text;
	}

	protected XtextStyledText createXtextWidget(Composite parent, int style, Injector injector, Resource context) {
		return new XtextStyledText(parent, style, injector, context);
	}

	@Override
	public void dispose() {
		text.removeKeyListener(keyListener);
		xtextWidget.dispose();
		super.dispose();
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
