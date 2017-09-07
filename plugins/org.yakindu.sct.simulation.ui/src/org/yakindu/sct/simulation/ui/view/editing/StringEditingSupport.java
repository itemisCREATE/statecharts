/**
 * Copyright (c) 2012 committers of YAKINDU and others.
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
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.widgets.Composite;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.sct.model.sruntime.ExecutionSlot;

/**
 * {@link CellEditor} support for String values
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class StringEditingSupport extends ScopeSlotEditingSupport {

	public StringEditingSupport(ColumnViewer viewer, ITypeSystemProvider provider) {
		super(viewer, provider);
	}

	@Override
	public CellEditor getCellEditor(Object element) {
		return new TextCellEditor((Composite) getViewer().getControl());
	}

	@Override
	public Type getSupportedType() {
		return provider.getTypeSystem().getType(ITypeSystem.STRING);
	}

	public Object getValue(Object element) {
		if (element instanceof ExecutionSlot) {
			return (String) ((ExecutionSlot) element).getValue();
		}
		return null;
	}

	@Override
	protected Object convertValue(Object element, Object value) {
		return value;
	}

}
