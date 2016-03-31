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
import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.widgets.Composite;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.typesystem.ITypeSystem;

/**
 * {@link TextCellEditor} support for Integer values
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class IntegerEditingSupport extends ScopeSlotEditingSupport {

	public IntegerEditingSupport(ColumnViewer viewer, ITypeSystemProvider provider) {
		super(viewer, provider);
	}

	@Override
	public CellEditor getCellEditor(Object element) {
		TextCellEditor textCellEditor = new TextCellEditor((Composite) getViewer().getControl());
		textCellEditor.setValidator(new ICellEditorValidator() {
			public String isValid(Object value) {
				try {
					Long.parseLong((String) value);
				} catch (NumberFormatException e) {
					return "No valid integer value!";
				}
				return null;
			}
		});

		return textCellEditor;
	}

	@Override
	public Type getSupportedType() {
		return provider.getTypeSystem().getType(ITypeSystem.INTEGER);
	}

	@Override
	protected Object convertValue(Object element, Object value) {
		if (value != null && value instanceof String && ((String) value).trim().length() > 0) {
			return Long.parseLong((String) value);
		}
		return null;
	}
}