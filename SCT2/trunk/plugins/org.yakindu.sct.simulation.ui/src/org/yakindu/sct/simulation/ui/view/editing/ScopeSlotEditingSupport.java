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
import org.yakindu.sct.simulation.core.runtime.IExecutionContext;
import org.yakindu.sct.simulation.core.runtime.ISlot;
import org.yakindu.sct.simulation.core.runtime.impl.AbstractSlot;

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
		if (element instanceof AbstractSlot) {
			Object value = ((AbstractSlot) element).getValue();
			// TODO: check compatibility via (type system ) type not via class
			// of value
			if (value instanceof EObject) {
				return getSupportedType().isAssignableFrom(
						((EObject) value).eClass().getInstanceClass());
			} else {
				return getSupportedType().isAssignableFrom(value.getClass());
			}
		}
		return false;
	}

	@Override
	public Object getValue(Object element) {
		if (element instanceof AbstractSlot) {
			Object value = ((ISlot) element).getValue();
			if (value != null)
				return String.valueOf(value);
		}
		return "";
	}

	@SuppressWarnings("deprecation")
	@Override
	public void setValue(Object element, Object value) {
		value = convertValue(element, value);
		if (value == null)
			return;
		IExecutionContext input = (IExecutionContext) getViewer().getInput();
		if (element instanceof AbstractSlot) {
			input.setSlotValue(((ISlot) element).getName(), value);
		}
	}
}
