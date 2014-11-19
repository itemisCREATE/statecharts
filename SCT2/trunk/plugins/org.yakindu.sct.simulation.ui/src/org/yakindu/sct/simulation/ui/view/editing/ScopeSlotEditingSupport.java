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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ColumnViewer;
import org.yakindu.sct.simulation.core.sruntime.ExecutionSlot;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class ScopeSlotEditingSupport extends PublicEditingSupport {

	protected abstract Class<?> getSupportedType();

	protected abstract Object convertValue(Object element, Object value);

	public ScopeSlotEditingSupport(ColumnViewer viewer) {
		super(viewer);
	}

	@Override
	public boolean canEdit(Object element) {
		if (element instanceof ExecutionSlot) {
			if(!((ExecutionSlot) element).isWritable())
				return false;
			Object value = ((ExecutionSlot) element).getValue();
			if (value == null) {
				return false;
			} else if (value instanceof EObject) {
				return getSupportedType().isAssignableFrom(((EObject) value).eClass().getInstanceClass());
			} else {
				return getSupportedType().isAssignableFrom(value.getClass());
			}
		}
		return false;
	}

	@Override
	public Object getValue(Object element) {
		if (element instanceof ExecutionSlot) {
			Object value = ((ExecutionSlot) element).getValue();
			if (value != null)
				return String.valueOf(value);
		}
		return "";
	}

	@Override
	public void setValue(Object element, Object value) {
		value = convertValue(element, value);
		if (value == null)
			return;
		if (element instanceof ExecutionSlot) {
			((ExecutionSlot) element).setValue(value);
		}
	}
}
