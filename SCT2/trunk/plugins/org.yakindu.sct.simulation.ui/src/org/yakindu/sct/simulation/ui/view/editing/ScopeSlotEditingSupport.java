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

import org.eclipse.jface.viewers.ColumnViewer;
import org.yakindu.sct.simulation.core.runtime.IExecutionContext;
import org.yakindu.sct.simulation.core.runtime.impl.AbstractSlot;
import org.yakindu.sct.simulation.core.runtime.impl.ExecutionVariable;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class ScopeSlotEditingSupport extends PublicEditingSupport {

	protected abstract Class<?> getSupportedType();

	protected abstract Object convertValue(Object value);

	public ScopeSlotEditingSupport(ColumnViewer viewer) {
		super(viewer);
	}

	@Override
	public boolean canEdit(Object element) {
		if (element instanceof AbstractSlot) {
			return getSupportedType()
					.equals(((AbstractSlot) element).getType());
		}
		return false;
	}

	@Override
	public Object getValue(Object element) {
		if (element instanceof AbstractSlot) {
			return String.valueOf(((AbstractSlot) element).getValue());
		}
		return null;
	}

	@Override
	public void setValue(Object element, Object value) {
		value = convertValue(value);
		if (value == null)
			return;
		if (element instanceof ExecutionVariable) {
			IExecutionContext input = (IExecutionContext) getViewer()
					.getInput();
			input.setVariableValue(((ExecutionVariable) element).getName(),
					value);
		}
	}
}
