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
import org.yakindu.base.types.Type;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.sct.simulation.core.sruntime.ExecutionSlot;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class ScopeSlotEditingSupport extends PublicEditingSupport {

	protected abstract Type getSupportedType();

	protected abstract Object convertValue(Object element, Object value);

	public interface ITypeSystemProvider {
		ITypeSystem getTypeSystem();
	}

	protected ITypeSystemProvider provider;

	public ScopeSlotEditingSupport(ColumnViewer viewer, ITypeSystemProvider provider) {
		super(viewer);
		this.provider = provider;
	}

	@Override
	public boolean canEdit(Object element) {
		if (element instanceof ExecutionSlot) {
			if (!((ExecutionSlot) element).isWritable())
				return false;
			Type type = ((ExecutionSlot) element).getType();
			return provider.getTypeSystem().isSuperType(getSupportedType(), type);
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
