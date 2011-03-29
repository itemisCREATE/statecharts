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

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;

import com.google.inject.Injector;

/**
 * Direct edit manager for Xtext aware edit parts. Clients that use this edit
 * manager, must implement {@link IXtextAwareEditPart}.
 * 
 * Some code is initially copied from {@link TextDirectEditManager}.
 * 
 * @author andreas.muelder@itemis.de
 */
public class XtextDirectEditManager extends DirectEditManager {

	private static final int MIN_WIDTH = 20;

	public static CellEditorLocator getTextCellEditorLocator(
			final IXtextAwareEditPart source) {
		return new CellEditorLocator() {
			public void relocate(CellEditor celleditor) {
				StyledText text = (StyledText) celleditor.getControl();
				Rectangle rect = source.getFigure().getBounds().getCopy();
				source.getFigure().translateToAbsolute(rect);
				if (!rect.equals(new Rectangle(text.getBounds()))) {
					text.setBounds(rect.x, rect.y,
							Math.max(rect.width, MIN_WIDTH), rect.height);
				}
			}
		};
	}

	/** String buffer to hold initial characters * */
	private StringBuffer initialString = new StringBuffer();

	private final Injector injector;

	private final int style;

	public XtextDirectEditManager(IXtextAwareEditPart source,
			Injector injector, int style) {
		super(source, XtextCellEditor.class,
				getTextCellEditorLocator((IXtextAwareEditPart) source));
		this.injector = injector;
		this.style = style;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.tools.DirectEditManager#bringDown()
	 */
	@Override
	protected void bringDown() {
		initialString = new StringBuffer();
		super.bringDown();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gef.tools.DirectEditManager#createCellEditorOn(org.eclipse
	 * .swt.widgets.Composite)
	 */
	@Override
	protected CellEditor createCellEditorOn(Composite composite) {
		return new XtextCellEditor(composite, injector, style);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.tools.DirectEditManager#initCellEditor()
	 */
	@Override
	protected void initCellEditor() {
		// init with initial edit text
		IXtextAwareEditPart textEP = (IXtextAwareEditPart) getEditPart();
		setEditText(textEP.getEditText());
	}

	public void setEditText(String toEdit) {

		// Get the cell editor
		CellEditor cellEditor = getCellEditor();

		// IF the cell editor doesn't exist yet...
		if (cellEditor == null) {
			// Do nothing
			return;
		}
		// Get the Text control
		StyledText textControl = (StyledText) cellEditor.getControl();
		cellEditor.setValue(toEdit);

		// Set the controls text and position the caret at the end of the
		textControl.setSelection(toEdit.length());
	}

	/**
	 * Performs show and sets the edit string to be the initial character or
	 * string
	 * 
	 * @param initialChar
	 */
	public void show(char initialChar) {
		initialString = initialString.append(initialChar);
		show();
		if (SWT.getPlatform() != "carbon") { //$NON-NLS-1$ 
			// Set the cell editor text to the initial character
			setEditText(initialString.toString());
		}
	}
}
