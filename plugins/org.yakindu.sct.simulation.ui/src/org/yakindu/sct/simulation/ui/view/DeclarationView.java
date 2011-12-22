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

import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IDebugEventSetListener;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.internal.ui.actions.CollapseAllAction;
import org.eclipse.debug.ui.AbstractDebugView;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.contexts.DebugContextEvent;
import org.eclipse.debug.ui.contexts.IDebugContextListener;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.handlers.ExpandAllHandler;
import org.yakindu.sct.simulation.core.debugmodel.SCTDebugTarget;
import org.yakindu.sct.simulation.core.runtime.IExecutionContext;
import org.yakindu.sct.simulation.core.runtime.IExecutionFacade;
import org.yakindu.sct.simulation.core.runtime.impl.ExecutionEvent;
import org.yakindu.sct.simulation.ui.view.editing.BooleanEditingSupport;
import org.yakindu.sct.simulation.ui.view.editing.IntegerEditingSupport;
import org.yakindu.sct.simulation.ui.view.editing.MultiEditingSupport;
import org.yakindu.sct.simulation.ui.view.editing.RealEditingSupport;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class DeclarationView extends AbstractDebugView implements
		IDebugContextListener, IDebugEventSetListener {

	private TreeViewer viewer;

	public DeclarationView() {
		DebugUITools.getDebugContextManager().addDebugContextListener(this);
		DebugPlugin.getDefault().addDebugEventListener(this);
	}

	@Override
	public void dispose() {
		super.dispose();
		DebugUITools.getDebugContextManager().removeDebugContextListener(this);
		DebugPlugin.getDefault().removeDebugEventListener(this);
	}

	@Override
	protected Viewer createViewer(Composite parent) {
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL
				| SWT.FULL_SELECTION);
		viewer.getTree().setHeaderVisible(true);
		viewer.getTree().setLinesVisible(true);
		TreeViewerColumn column = new TreeViewerColumn(viewer, SWT.DEFAULT);
		column.getColumn().setText("Name");
		column.getColumn().setMoveable(true);
		column.getColumn().setWidth(200);
		column.setLabelProvider(new ExecutionContextLabelProvider(0));

		TreeViewerColumn valueColumn = new TreeViewerColumn(viewer, SWT.DEFAULT);
		valueColumn.getColumn().setText("Value");
		valueColumn.getColumn().setMoveable(true);
		valueColumn.getColumn().setWidth(100);
		valueColumn.setEditingSupport(new MultiEditingSupport(viewer,
				new BooleanEditingSupport(viewer), new IntegerEditingSupport(
						viewer), new RealEditingSupport(viewer)));
		valueColumn.setLabelProvider(new ExecutionContextLabelProvider(1));
		viewer.setContentProvider(new ExecutionContextContentProvider());
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				Object firstElement = ((IStructuredSelection) event
						.getSelection()).getFirstElement();
				if (firstElement instanceof ExecutionEvent) {
					IExecutionContext input = (IExecutionContext) viewer
							.getInput();
					input.raiseEvent(((ExecutionEvent) firstElement).getName(),
							null);
				}
			}
		});
		return viewer;
	}

	public void debugContextChanged(DebugContextEvent event) {
		if ((event.getFlags() & DebugContextEvent.ACTIVATED) > 0) {
			PlatformObject object = (PlatformObject) ((IStructuredSelection) event
					.getContext()).getFirstElement();
			SCTDebugTarget debugTarget = (SCTDebugTarget) object
					.getAdapter(IDebugTarget.class);
			if (debugTarget != null && !debugTarget.isTerminated())
				refreshInput(debugTarget);
		}

	}

	public void handleDebugEvents(DebugEvent[] events) {
		for (DebugEvent debugEvent : events) {
			handleDebugEvent(debugEvent);
		}
	}

	private void handleDebugEvent(DebugEvent debugEvent) {
		switch (debugEvent.getKind()) {
		case DebugEvent.TERMINATE:
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					viewer.setInput(null);
				}
			});
			break;
		}
	}

	private void refreshInput(SCTDebugTarget debugTarget) {
		IExecutionFacade facade = (IExecutionFacade) debugTarget
				.getAdapter(IExecutionFacade.class);
		viewer.setInput(facade.getExecutionContext());
		viewer.expandAll();

	}

	@Override
	protected void createActions() {
		@SuppressWarnings("restriction")
		IAction action = new CollapseAllAction(viewer);
		setAction("CollapseAll",action); //$NON-NLS-1$
	}

	@Override
	protected String getHelpContextId() {
		return null;
	}

	@Override
	protected void fillContextMenu(IMenuManager menu) {

	}

	@Override
	protected void configureToolBar(IToolBarManager tbm) {
		tbm.add(getAction("CollapseAll")); //$NON-NLS-1$
	}

}
