/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.simulation.ui.view.editing;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.sct.model.sruntime.ExecutionSlot;

/**
 * {@link CellEditor} support for Boolean values
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class BooleanEditingSupport extends ScopeSlotEditingSupport {

	public BooleanEditingSupport(ColumnViewer viewer, ITypeSystemProvider provider) {
		super(viewer, provider);
	}

	@Override
	public CellEditor getCellEditor(Object element) {
		return new CheckboxCellEditor((Composite) getViewer().getControl(), SWT.CHECK);
	}

	@Override
	public Type getSupportedType() {
		return provider.getTypeSystem().getType(ITypeSystem.BOOLEAN);
	}

	public Object getValue(Object element) {
		if (element instanceof ExecutionSlot) {
			Boolean value = (Boolean) ((ExecutionSlot) element).getValue();
			return value ? false : true;
		}
		return null;
	}

	@Override
	protected Object convertValue(Object element, Object value) {
		if (value != null && value instanceof Integer) {
			return ((Integer) value).intValue() == 0 ? true : false;
		}
		if (value != null && value instanceof Boolean)
			return value;
		return null;
	}

}
