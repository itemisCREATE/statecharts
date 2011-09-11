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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.contexts.DebugContextEvent;
import org.eclipse.debug.ui.contexts.IDebugContextListener;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.simulation.core.ISGraphExecutionScope.ScopeEvent;
import org.yakindu.sct.simulation.core.ISGraphExecutionScope.ScopeVariable;
import org.yakindu.sct.simulation.core.ISimulationSessionListener;
import org.yakindu.sct.simulation.core.SGraphSimulationSession;
import org.yakindu.sct.simulation.ui.view.editing.BooleanEditingSupport;
import org.yakindu.sct.simulation.ui.view.editing.IntegerEditingSupport;
import org.yakindu.sct.simulation.ui.view.editing.MultiEditingSupport;
import org.yakindu.sct.simulation.ui.view.editing.RealEditingSupport;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class DeclarationView extends ViewPart implements IDebugContextListener,
		ISimulationSessionListener, ActiveSessionProvider {

	private TableViewer eventViewer;

	private TableViewer variableViewer;

	private List<Control> controls;

	private SGraphSimulationSession activeSession;

	public DeclarationView() {
		controls = new ArrayList<Control>();
	}

	@Override
	public void init(IViewSite site) throws PartInitException {
		super.init(site);
		DebugUITools.getDebugContextManager()
				.getContextService(site.getWorkbenchWindow())
				.addDebugContextListener(this);
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1, true));
		createEventViewer(parent);
		createVariableViewer(parent);
	}

	private void createVariableViewer(Composite parent) {
		variableViewer = createTableViewer(parent);
		createScopeSlotColumns(variableViewer);
		setVariableViewerInput();
	}

	private void createEventViewer(Composite parent) {
		eventViewer = createTableViewer(parent);
		createScopeSlotColumns(eventViewer);
		createColumn(eventViewer, "raise", 50, 3);
		setEventViewerInput();
	}

	private TableViewer createTableViewer(Composite parent) {
		TableViewer viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.FULL_SELECTION);
		viewer.getTable().setLinesVisible(true);
		viewer.getTable().setHeaderVisible(true);
		GridDataFactory.fillDefaults().grab(true, true)
				.applyTo(viewer.getTable());
		viewer.setContentProvider(new ArrayContentProvider());
		return viewer;
	}

	private TableViewerColumn createColumn(TableViewer viewer, String text,
			int width, int index) {
		TableViewerColumn column = new TableViewerColumn(viewer, SWT.NONE);
		column.getColumn().setText(text);
		column.getColumn().setWidth(width);
		column.getColumn().setResizable(true);
		column.getColumn().setMoveable(true);
		column.setLabelProvider(new ScopeSlotLabelProvider(index));
		return column;
	}

	private void createScopeSlotColumns(TableViewer viewer) {
		createColumn(viewer, "name", 80, 0);
		createColumn(viewer, "type", 80, 1);
		TableViewerColumn valueColumn = createColumn(viewer, "value", 80, 2);
		valueColumn.setEditingSupport(new MultiEditingSupport(viewer,
				new BooleanEditingSupport(viewer, this),
				new IntegerEditingSupport(viewer, this),
				new RealEditingSupport(viewer, this)));
	}

	@Override
	public void setFocus() {
		eventViewer.getTable().setFocus();
	}

	public void setEventViewerInput() {
		if (activeSession != null) {
			List<ScopeEvent> events = activeSession.getExecutionScope()
					.getEvents();
			eventViewer.setInput(events);
			TableItem[] items = eventViewer.getTable().getItems();
			for (TableItem tableItem : items) {
				final TableEditor editor = new TableEditor(
						eventViewer.getTable());
				editor.horizontalAlignment = SWT.LEFT;
				editor.grabHorizontal = true;
				editor.grabVertical = true;
				Button button = new Button(eventViewer.getTable(), SWT.FLAT);
				button.setText("raise");
				button.addSelectionListener(new ButtonListener(tableItem
						.getText()));
				editor.setEditor(button, tableItem, 3);
				controls.add(button);
			}
		}
	}

	private void setVariableViewerInput() {
		if (activeSession != null) {
			List<ScopeVariable> variables = activeSession.getExecutionScope()
					.getVariables();
			variableViewer.setInput(variables);
		}
	}

	public void clearViewerInput() {
		for (Control control : controls) {
			control.dispose();
		}
		eventViewer.setInput(null);
		variableViewer.setInput(null);
	}

	public void variableValueChanged(String variableName, Object value) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				setVariableViewerInput();
			}
		});
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	public void stateEntered(Vertex vertex) {
		// Nothing to do
	}

	public void stateLeft(Vertex vertex) {
		// Nothing to do
	}

	public void transitionFired(Transition transition) {
		// Nothing to do
	}

	public void eventRaised(String eventName) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				setEventViewerInput();
			}
		});
	}

	private final class ButtonListener implements SelectionListener {

		private final String eventName;

		public ButtonListener(String eventName) {
			this.eventName = eventName;
		}

		public void widgetSelected(SelectionEvent e) {
			if (activeSession != null) {
				activeSession.raiseEvent(new ScopeEvent(eventName));
			}
		}

		public void widgetDefaultSelected(SelectionEvent e) {
			// Nothing to do
		}
	}

	public void debugContextChanged(DebugContextEvent event) {
		StructuredSelection strSel = (StructuredSelection) event.getContext();
		PlatformObject firstElement = (PlatformObject) strSel.getFirstElement();
		if (firstElement == null) {
			return;
		}
		SGraphSimulationSession selectedSession = (SGraphSimulationSession) firstElement
				.getAdapter(SGraphSimulationSession.class);
		if (selectedSession == null
				|| selectedSession.getCurrentState() == SimulationState.TERMINATED) {
			activeSession = selectedSession;
			clearViewerInput();
		}
		if (!(selectedSession == activeSession) && selectedSession != null) {
			if (activeSession != null) {
				activeSession.getListeners().remove(this);
			}
			activeSession = selectedSession;
			selectedSession.getListeners().add(this);
			clearViewerInput();
			setEventViewerInput();
			setVariableViewerInput();
		}
	}

	public SGraphSimulationSession getActiveSession() {
		return activeSession;
	}

	public void simulationStateChanged(SimulationState oldState,
			SimulationState newState) {
		switch (newState) {
		case STARTED:
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					setEventViewerInput();
					setVariableViewerInput();
				}
			});
			break;
		case TERMINATED:
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					clearViewerInput();
				}
			});
			;
			break;
		}
	}
}
