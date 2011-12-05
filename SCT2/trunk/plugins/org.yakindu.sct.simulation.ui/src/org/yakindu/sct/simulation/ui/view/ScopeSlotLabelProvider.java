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
package org.yakindu.sct.simulation.ui.view;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.yakindu.sct.simulation.core.runtime.impl.AbstractSlot;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ScopeSlotLabelProvider extends ColumnLabelProvider {

	private final int index;

	public ScopeSlotLabelProvider(int index) {
		this.index = index;
	}

	@Override
	public String getText(Object element) {
		switch (index) {
		case 0:
			// NAME
			return ((AbstractSlot) element).getName();
		case 1:
			// TYPE
			Class<?> type = ((AbstractSlot) element).getType();
			return type != null ? type.getSimpleName() : null;
		case 2:
			// VALUE:
			Object value = ((AbstractSlot) element).getValue();
			return value != null ? value.toString() : null;
		default:
			return "";
		}
	}
}
