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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.yakindu.base.types.EnumerationType;
import org.yakindu.base.types.Enumerator;
import org.yakindu.sct.simulation.core.sruntime.ExecutionSlot;

/**
 * {@link CellEditor} support for Boolean values
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class EnumerationEditingSupport extends ScopeSlotEditingSupport {

	public EnumerationEditingSupport(ColumnViewer viewer) {
		super(viewer);
	}

	@Override
	public CellEditor getCellEditor(Object element) {
		if (element instanceof ExecutionSlot) {
			EnumerationType e = getEnumerationType((ExecutionSlot) element);
			List<String> enumeratorNames = new ArrayList<String>();
			for (Enumerator enumerator : e.getEnumerator()) {
				enumeratorNames.add(enumerator.getName());
			}
			return new ComboBoxCellEditor((Composite) getViewer().getControl(),
					enumeratorNames.toArray(new String[] {}), SWT.READ_ONLY);
		}
		return null;
	}

	public EnumerationType getEnumerationType(ExecutionSlot element) {
		EnumerationType e = (EnumerationType) element.getType().getType();
		return e;
	}

	public Object getValue(Object element) {
		if (element instanceof ExecutionSlot) {
			EnumerationType e = getEnumerationType((ExecutionSlot) element);
			return e.getEnumerator().indexOf(((ExecutionSlot) element).getValue());
		}
		return null;
	}

	@Override
	protected Class<?> getSupportedType() {
		return Enumerator.class;
	}

	@Override
	protected Object convertValue(Object element, Object value) {
		if (element instanceof ExecutionSlot) {
			if (value != null && value instanceof Integer) {
				int index = ((Integer) value).intValue();
				EnumerationType e = getEnumerationType((ExecutionSlot) element);
				if (index < 0) {
					return e.getEnumerator().iterator().next();
				}
				return e.getEnumerator().get(index);
			}
		}
		return null;
	}
}
