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
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.yakindu.sct.simulation.core.sruntime.ExecutionSlot;
import org.yakindu.sct.simulation.core.sruntime.ExecutionVariable;

/**
 * {@link CellEditor} support for Boolean values
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class BooleanEditingSupport extends ScopeSlotEditingSupport {

	public BooleanEditingSupport(ColumnViewer viewer) {
		super(viewer);
	}

	@Override
	public CellEditor getCellEditor(Object element) {
		return new ComboBoxCellEditor((Composite) getViewer().getControl(), new String[] { "true", "false" },
				SWT.READ_ONLY);
	}

	@Override
	public Class<?> getSupportedType() {
		return Boolean.class;
	}

	public Object getValue(Object element) {
		if (element instanceof ExecutionVariable) {
			Boolean value = (Boolean) ((ExecutionSlot) element).getValue();
			return value ? 0 : 1;
		}
		return null;
	}

	@Override
	protected Object convertValue(Object element, Object value) {
		if (value != null && value instanceof Integer) {
			return ((Integer) value).intValue() == 0 ? true : false;
		}
		return null;
	}

}
