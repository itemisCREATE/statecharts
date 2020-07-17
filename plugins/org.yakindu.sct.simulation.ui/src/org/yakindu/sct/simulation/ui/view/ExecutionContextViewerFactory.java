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

import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationEvent;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationListener;
import org.eclipse.jface.viewers.ColumnViewerEditorDeactivationEvent;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.yakindu.sct.simulation.ui.view.editing.BooleanEditingSupport;
import org.yakindu.sct.simulation.ui.view.editing.EnumerationEditingSupport;
import org.yakindu.sct.simulation.ui.view.editing.IntegerEditingSupport;
import org.yakindu.sct.simulation.ui.view.editing.MultiEditingSupport;
import org.yakindu.sct.simulation.ui.view.editing.RealEditingSupport;
import org.yakindu.sct.simulation.ui.view.editing.ScopeSlotEditingSupport.ITypeSystemProvider;
import org.yakindu.sct.simulation.ui.view.editing.StringEditingSupport;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ExecutionContextViewerFactory {

	private static final int NAME_COL_MIN_WIDTH = 100;
	private static final int NAME_COL_WIDTH_RATIO = 3;
	private static final int VALUE_COL_MIN_WIDTH = 80;
	private static final int VALUE_COL_WIDTH_RATIO = 1;

	public static TreeViewer createViewer(Composite parent, boolean readOnly, ITypeSystemProvider provider) {
		Composite comp = new Composite(parent, SWT.NONE);
		comp.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		TreeColumnLayout layout = new TreeColumnLayout();
		comp.setLayout(layout);
		final TreeViewer viewer = new TreeViewer(comp,
				SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
		viewer.getTree().setHeaderVisible(true);
		viewer.getTree().setLinesVisible(true);
		ExecutionContextContentProvider contentProvider = new ExecutionContextContentProvider();
		viewer.setContentProvider(contentProvider);
		viewer.setFilters(new ViewerFilter[]{new TimeEventViewerFilter(), new VisibleViewerFilter()});
    
		TreeViewerColumn nameColumn = new TreeViewerColumn(viewer, SWT.NONE);
		nameColumn.getColumn().setText("Name");
		nameColumn.getColumn().setResizable(true);
		nameColumn.setLabelProvider(new ExecutionContextLabelProvider(0, readOnly));

		TreeViewerColumn valueColumn = new TreeViewerColumn(viewer, SWT.NONE);
		valueColumn.getColumn().setText("Value");
		valueColumn.getColumn().setResizable(false);
		valueColumn.setLabelProvider(new ExecutionContextLabelProvider(1, readOnly));

		layout.setColumnData(nameColumn.getColumn(), new ColumnWeightData(NAME_COL_WIDTH_RATIO, NAME_COL_MIN_WIDTH));
		layout.setColumnData(valueColumn.getColumn(), new ColumnWeightData(VALUE_COL_WIDTH_RATIO, VALUE_COL_MIN_WIDTH));
		if (!readOnly)
			valueColumn.setEditingSupport(new MultiEditingSupport(viewer,
					/*
					 * Specialized editing supports first...
					 */
					new EnumerationEditingSupport(viewer, provider), //
					new IntegerEditingSupport(viewer, provider), //
					new RealEditingSupport(viewer, provider), //
					new BooleanEditingSupport(viewer, provider), //
					new StringEditingSupport(viewer, provider)));//

		valueColumn.getViewer().getColumnViewerEditor()
				.addEditorActivationListener(new ColumnViewerEditorActivationListener() {
					@Override
					public void afterEditorDeactivated(ColumnViewerEditorDeactivationEvent event) {
						contentProvider.setShouldUpdate(true);
						viewer.refresh();
					}

					@Override
					public void afterEditorActivated(ColumnViewerEditorActivationEvent event) {
						contentProvider.setShouldUpdate(false);
					}

					@Override
					public void beforeEditorDeactivated(ColumnViewerEditorDeactivationEvent event) {
					}

					@Override
					public void beforeEditorActivated(ColumnViewerEditorActivationEvent event) {
					}
				});
		return viewer;
	}
}
