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
import org.yakindu.sct.simulation.core.ISGraphExecutionScope.ScopeVariable;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ScopeVariableLabelProvider extends ColumnLabelProvider {

	private final int index;

	public ScopeVariableLabelProvider(int index) {
		this.index = index;
	}

	@Override
	public String getText(Object element) {
		switch (index) {
		case 0:
			// NAME
			return ((ScopeVariable) element).getName();
		case 1:
			// TYPE
			return ((ScopeVariable) element).getType().getSimpleName();
		case 2:
			// VALUE:
			return ((ScopeVariable) element).getValue().toString();
		default:
			return "";
		}
	}
}
