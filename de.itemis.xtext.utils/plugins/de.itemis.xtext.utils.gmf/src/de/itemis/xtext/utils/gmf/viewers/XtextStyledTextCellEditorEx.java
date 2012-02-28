/******************************************************************************
 * Copyright (c) 2002, 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package de.itemis.xtext.utils.gmf.viewers;

import com.google.inject.Injector;

import de.itemis.xtext.utils.jface.viewers.XtextStyledTextCellEditor;
import de.itemis.xtext.utils.jface.viewers.ContextElementAdapter.IContextElementProvider;
import de.itemis.xtext.utils.jface.viewers.context.IXtextFakeContextResourcesProvider;

/**
 * This is a copy of TextCellEditorEx, only the super class has been changed to
 * {@link XtextStyledTextCellEditor}
 * 
 * @author andreas muelder
 * 
 */
public class XtextStyledTextCellEditorEx extends XtextStyledTextCellEditor {

	private Object originalValue;
	private boolean deactivationLock = false;

	public XtextStyledTextCellEditorEx(int style, Injector injector,
			IXtextFakeContextResourcesProvider contextResourcesProvider) {
		super(style, injector, contextResourcesProvider);
	}

	public XtextStyledTextCellEditorEx(int style, Injector injector) {
		super(style, injector);
	}

	public XtextStyledTextCellEditorEx(int style, Injector injector,
			IContextElementProvider provider) {
		super(style, injector, provider);
	}

	/**
	 * This will be used when an edit has occurred by a ModifyEvent has been
	 * been send. Will call #setValue(Object) but will also call
	 * editOccured(null) to make sure that the dirty flag is set probably and
	 * that any listeners are informed about the changed.
	 * 
	 * @param value
	 *            Value to set the cell editor to.
	 * 
	 *            Note: This happens address defect RATLC00522324. For our
	 *            topgraphical edit parts we delagate the direct edit request to
	 *            a primary edit part and set focus on that. The issue is that
	 *            if the user has typed in an initial character when setting
	 *            focus to the edit part, which typically is a
	 *            TextCompartmentEditPart then setting that intial value does
	 *            not fire the necessary change events that need to occur in
	 *            order for that value to be recongnized. If you don't use this
	 *            method then the result is that if you just type in the initial
	 *            character and that is it then the text compartment loses focus
	 *            then the value will not be saved. This is because setting the
	 *            value of the cell doesn't think its value has changed since
	 *            the first character is not recongized as a change.
	 */
	public void setValueAndProcessEditOccured(Object value) {
		setValue(value);
		// do the processing to ensure if we exit the cell then
		// value will be applied.
		editOccured(null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.CellEditor#doSetValue(java.lang.Object)
	 */
	@Override
	protected void doSetValue(Object value) {
		if (originalValue == null)
			originalValue = value;
		super.doSetValue(value);
	}

	/**
	 * @return boolean value specifying whether or not the value has been
	 *         changed
	 */
	public boolean hasValueChanged() {
		if (getValue() == null)
			return originalValue != null;
		return !getValue().equals(originalValue);
	}

	/*
	 * Runs super deactivate unless it has been locked and otherwise unlocks
	 * deactivation
	 * 
	 * @see org.eclipse.jface.viewers.CellEditor#deactivate()
	 */
	@Override
	public void deactivate() {
		if (!isDeactivationLocked())
			super.deactivate();
		setDeactivationLock(false);
	}

	/**
	 * Returns true if deactivation has been locked
	 * 
	 * @return
	 */
	public boolean isDeactivationLocked() {
		return deactivationLock;
	}

	/**
	 * Sets deactivation lock so that the cell editor does not perform
	 * deactivate
	 * 
	 * @param deactivationLock
	 */
	public void setDeactivationLock(boolean deactivationLock) {
		this.deactivationLock = deactivationLock;
	}

}
