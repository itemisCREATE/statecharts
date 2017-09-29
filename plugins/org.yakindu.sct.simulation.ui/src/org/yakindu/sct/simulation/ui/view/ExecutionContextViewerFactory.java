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

import org.eclipse.jface.viewers.ColumnViewerEditorActivationEvent;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationListener;
import org.eclipse.jface.viewers.ColumnViewerEditorDeactivationEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IMemento;
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

	public static TreeViewer createViewer(Composite parent, boolean readOnly, ITypeSystemProvider provider,
			IMemento memento) {

		final TreeViewer viewer = new TreeViewer(parent,
				SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
		viewer.getTree().setHeaderVisible(true);
		viewer.getTree().setLinesVisible(true);
		final ExecutionContextContentProvider contentProvider = new ExecutionContextContentProvider();
		viewer.setContentProvider(contentProvider);
		viewer.setFilters(new ViewerFilter[]{new TimeEventViewerFilter()});

		TreeViewerColumn nameColumn = new TreeViewerColumn(viewer, SWT.FILL);
		nameColumn.getColumn().setText("Name");
		nameColumn.getColumn().setResizable(true);
		nameColumn.setLabelProvider(new ExecutionContextLabelProvider(0));
		TreeViewerColumn valueColumn = new TreeViewerColumn(viewer, SWT.FILL);
		valueColumn.getColumn().setText("Value");
		valueColumn.getColumn().setResizable(false);
		valueColumn.setLabelProvider(new ExecutionContextLabelProvider(1));

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

		TreeViewerColumnResizer treeViewerColumnResizer = new TreeViewerColumnResizer(viewer, nameColumn, valueColumn,
				memento);

		parent.addControlListener(treeViewerColumnResizer);
		viewer.getTree().addControlListener(treeViewerColumnResizer);
		treeViewerColumnResizer.resizeViewerColumns();
		return viewer;
	}

	/**
	 * 
	 * @author robert rudi - Initial contribution and API
	 * 
	 */
	private static final class TreeViewerColumnResizer extends ControlAdapter {

		public static final int VALUE_COL_VIEW_WIDTH_PERCENTAGE = 3; // 33%
		public static final int VALUE_COL_MIN_WIDTH = 80;
		public static final int NAME_COL_MIN_WIDTH = 100;

		private final TreeViewer viewer;
		private final TreeViewerColumn nameColumn;
		private final TreeViewerColumn valueColumn;
		private IMemento memento;

		private TreeViewerColumnResizer(TreeViewer viewer, TreeViewerColumn nameColumn, TreeViewerColumn valueColumn,
				IMemento memento) {
			this.nameColumn = nameColumn;
			this.viewer = viewer;
			this.valueColumn = valueColumn;
			this.memento = memento;
		}
		@Override
		public void controlResized(ControlEvent e) {
			resizeViewerColumns();
			rememberOrRestoreColumnWidths();
		}

		@Override
		public void controlMoved(ControlEvent e) {
			resizeViewerColumns();
			rememberOrRestoreColumnWidths();
		}

		protected void resizeViewerColumns() {
			Tree tree = viewer.getTree();
			Rectangle area = tree.getParent().getParent().getClientArea();
			Point size = tree.computeSize(SWT.DEFAULT, SWT.DEFAULT);
			ScrollBar vBar = tree.getVerticalBar();
			int width = area.width - tree.computeTrim(0, 0, 0, 0).width + vBar.getSize().x;
			if (size.y > area.height + tree.getHeaderHeight()) {
				width -= vBar.getSize().x;
			}
			Point oldSize = tree.getSize();
			if (oldSize.x > area.width) {
				setColumnWidths(vBar, width);
				tree.setSize(area.width, area.height);
			} else {
				tree.setSize(area.width, area.height);
				setColumnWidths(vBar, width);
			}
		}
		protected void setColumnWidths(ScrollBar vBar, int width) {
			int preferredValueColumnWidth = getPreferredValueColumnWidth(vBar, width);
			if (memento != null && (memento.getInteger("VALUE_COL_WIDTH") == null)) {
				valueColumn.getColumn().setWidth(Math.max(preferredValueColumnWidth, VALUE_COL_MIN_WIDTH));
			} else {
				if (memento != null && (memento.getInteger("VALUE_COL_WIDTH") != null)) {
					valueColumn.getColumn()
							.setWidth(Math.max(width - nameColumn.getColumn().getWidth(), VALUE_COL_MIN_WIDTH));
				}
			}
			int preferredNameColumnWidth = getPreferredNameColumnWidth(vBar, width);
			if (memento != null && (memento.getInteger("NAME_COL_WIDTH") == null)) {
				nameColumn.getColumn().setWidth(Math.max(preferredNameColumnWidth, NAME_COL_MIN_WIDTH));
			}

			valueColumn.getColumn().setWidth(Math.max(width - nameColumn.getColumn().getWidth(),
					Math.max(valueColumn.getColumn().getWidth(), VALUE_COL_MIN_WIDTH)));
		}

		private int getPreferredNameColumnWidth(ScrollBar vBar, int width) {
			return width - (vBar.isVisible() ? vBar.getSize().x : 0) - valueColumn.getColumn().getWidth();
		}

		private int getPreferredValueColumnWidth(ScrollBar vBar, int width) {
			return (width - (vBar.isVisible() ? vBar.getSize().x : 0)) / VALUE_COL_VIEW_WIDTH_PERCENTAGE;
		}

		protected void rememberOrRestoreColumnWidths() {
			if (memento != null) {
				if (memento.getInteger("VALUE_COL_WIDTH") == null) {
					memento.putInteger("VALUE_COL_WIDTH", valueColumn.getColumn().getWidth());
				} else {
					if (valueColumn.getColumn().getWidth() != memento.getInteger("VALUE_COL_WIDTH")) {
						memento.putInteger("VALUE_COL_WIDTH", valueColumn.getColumn().getWidth());
						valueColumn.getColumn().setWidth(memento.getInteger("VALUE_COL_WIDTH"));
					}
				}
				if (memento.getInteger("NAME_COL_WIDTH") == null) {
					memento.putInteger("NAME_COL_WIDTH", valueColumn.getColumn().getWidth());
				} else {
					if (nameColumn.getColumn().getWidth() != memento.getInteger("NAME_COL_WIDTH")) {
						memento.putInteger("NAME_COL_WIDTH", nameColumn.getColumn().getWidth());
						nameColumn.getColumn().setWidth(memento.getInteger("NAME_COL_WIDTH"));
					}
				}
			}
		}

	}
}
