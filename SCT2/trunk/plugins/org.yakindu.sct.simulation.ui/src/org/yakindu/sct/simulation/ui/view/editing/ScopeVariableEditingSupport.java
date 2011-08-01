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
import org.yakindu.sct.simulation.core.ISGraphExecutionScope;
import org.yakindu.sct.simulation.core.SGraphSimulationSessionRegistry;
import org.yakindu.sct.simulation.core.ISGraphExecutionScope.ScopeVariable;


/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class ScopeVariableEditingSupport extends PublicEditingSupport {

	protected abstract Class<?> getSupportedType();

	protected abstract Object convertValue(Object value);

	public ScopeVariableEditingSupport(ColumnViewer viewer) {
		super(viewer);
	}

	@Override
	public boolean canEdit(Object element) {
		if (element instanceof ScopeVariable) {
			return getSupportedType().equals(
					((ScopeVariable) element).getType());
		}
		return false;
	}

	@Override
	public Object getValue(Object element) {
		if (element instanceof ScopeVariable) {
			return String.valueOf(((ScopeVariable) element).getValue());
		}
		return null;
	}

	@Override
	public void setValue(Object element, Object value) {
		value = convertValue(value);
		if (value == null)
			return;
		if (element instanceof ScopeVariable) {
			ISGraphExecutionScope scope = SGraphSimulationSessionRegistry.INSTANCE
					.getActiveSession().getExecutionScope();
			scope.setVariableValue((ScopeVariable) element, value);
		}
	}
}
