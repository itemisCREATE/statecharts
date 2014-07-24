/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.simulation.ui.view;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.yakindu.sct.simulation.ui.view.editing.BooleanEditingSupport;
import org.yakindu.sct.simulation.ui.view.editing.EnumerationEditingSupport;
import org.yakindu.sct.simulation.ui.view.editing.IntegerEditingSupport;
import org.yakindu.sct.simulation.ui.view.editing.LongEditingSupport;
import org.yakindu.sct.simulation.ui.view.editing.MultiEditingSupport;
import org.yakindu.sct.simulation.ui.view.editing.RealEditingSupport;
import org.yakindu.sct.simulation.ui.view.editing.StringEditingSupport;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ExecutionContextViewerFactory {

	
	public static TreeViewer createViewer(Composite parent, boolean readOnly) {
		TreeViewer viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION);
		viewer.getTree().setHeaderVisible(true);
		viewer.getTree().setLinesVisible(true);
		viewer.setContentProvider(new ExecutionContextContentProvider());
		viewer.setFilters(new ViewerFilter[] { new TimeEventViewerFilter() });
		TreeViewerColumn nameColumn = new TreeViewerColumn(viewer, SWT.DEFAULT);
		nameColumn.getColumn().setText("Name");
		nameColumn.getColumn().setMoveable(true);
		nameColumn.getColumn().setWidth(150);
		nameColumn.setLabelProvider(new ExecutionContextLabelProvider(0));

		TreeViewerColumn valueColumn = new TreeViewerColumn(viewer, SWT.DEFAULT);
		valueColumn.getColumn().setText("Value");
		valueColumn.getColumn().setMoveable(true);
		valueColumn.getColumn().setWidth(100);
		if (!readOnly)
			valueColumn.setEditingSupport(new MultiEditingSupport(viewer, new BooleanEditingSupport(viewer),
					new LongEditingSupport(viewer), new RealEditingSupport(viewer),
					new StringEditingSupport(viewer), new EnumerationEditingSupport(viewer), new IntegerEditingSupport(viewer)));

		valueColumn.setLabelProvider(new ExecutionContextLabelProvider(1));

		return viewer;
	}
}
