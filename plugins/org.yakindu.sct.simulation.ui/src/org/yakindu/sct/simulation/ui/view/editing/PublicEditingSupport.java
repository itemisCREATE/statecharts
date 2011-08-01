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

/**
 * Makes the Editing Support API public.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class PublicEditingSupport extends
		org.eclipse.jface.viewers.EditingSupport {

	public PublicEditingSupport(ColumnViewer viewer) {
		super(viewer);
	}

	public abstract boolean canEdit(Object element);

	public abstract CellEditor getCellEditor(Object element);

	public abstract Object getValue(Object element);

	public abstract void setValue(Object element, Object value);

}
