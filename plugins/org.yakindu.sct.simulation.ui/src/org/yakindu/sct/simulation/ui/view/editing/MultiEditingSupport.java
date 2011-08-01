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
import org.eclipse.jface.viewers.EditingSupport;
/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class MultiEditingSupport extends EditingSupport {

	private final PublicEditingSupport[] support;

	private PublicEditingSupport currentActive;

	public MultiEditingSupport(ColumnViewer viewer,
			PublicEditingSupport... support) {
		super(viewer);
		this.support = support;
	}

	@Override
	protected boolean canEdit(Object element) {
		for (PublicEditingSupport current : support) {
			if (current.canEdit(element)) {
				currentActive = current;
				return true;
			}
		}
		return false;
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		return currentActive.getCellEditor(element);
	}

	@Override
	protected Object getValue(Object element) {
		return currentActive.getValue(element);
	}

	@Override
	protected void setValue(Object element, Object value) {
		currentActive.setValue(element, value);
	}

}
