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
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
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
import org.eclipse.ui.part.ViewPart;
import org.yakindu.sct.model.sgraph.Event;
import org.yakindu.sct.model.sgraph.NamedElement;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.simulation.core.ISGraphExecutionScope.ScopeVariable;
import org.yakindu.sct.simulation.core.ISGraphSimulationSession;
import org.yakindu.sct.simulation.core.ISimulationSessionListener;
import org.yakindu.sct.simulation.core.SGraphSimulationSessionRegistry;
import org.yakindu.sct.simulation.ui.view.editing.BooleanEditingSupport;
import org.yakindu.sct.simulation.ui.view.editing.IntegerEditingSupport;
import org.yakindu.sct.simulation.ui.view.editing.MultiEditingSupport;
import org.yakindu.sct.simulation.ui.view.editing.RealEditingSupport;

import de.itemis.xtext.utils.jface.viewers.util.ActiveEditorResolver;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class DeclarationView extends ViewPart implements
		ISimulationSessionListener {

	private TableViewer eventViewer;

	private TableViewer variableViewer;

	private List<Control> controls;

	public DeclarationView() {
		controls = new ArrayList<Control>();
		SGraphSimulationSessionRegistry.INSTANCE.getListeners().add(this);
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1, true));
		createEventViewer(parent);
		createVariableViewer(parent);
		setEventViewerInput();
	}

	private void createVariableViewer(Composite parent) {
		variableViewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.FULL_SELECTION);
		variableViewer.getTable().setLinesVisible(true);
		variableViewer.getTable().setHeaderVisible(true);
		createVariableColumns(variableViewer);
		variableViewer.setContentProvider(new ArrayContentProvider());
		GridDataFactory.fillDefaults().grab(true, true)
				.applyTo(variableViewer.getTable());
	}

	private void createEventViewer(Composite parent) {
		eventViewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.FULL_SELECTION);
		eventViewer.getTable().setLinesVisible(true);
		eventViewer.getTable().setHeaderVisible(true);
		createEventColumns(eventViewer);
		eventViewer.setContentProvider(new ArrayContentProvider());
		GridDataFactory.fillDefaults().grab(true, true)
				.applyTo(eventViewer.getTable());
	}

	private TableViewerColumn createColumn(TableViewer viewer, String text,
			int width) {
		TableViewerColumn column = new TableViewerColumn(viewer, SWT.NONE);
		column.getColumn().setText(text);
		column.getColumn().setWidth(width);
		column.getColumn().setResizable(true);
		column.getColumn().setMoveable(true);
		return column;
	}

	private void createVariableColumns(TableViewer viewer) {
		TableViewerColumn variableColumn = createColumn(viewer, "variable", 80);
		variableColumn.setLabelProvider(new ScopeVariableLabelProvider(0));

		TableViewerColumn typeColumn = createColumn(viewer, "type", 80);
		typeColumn.setLabelProvider(new ScopeVariableLabelProvider(1));

		TableViewerColumn valueColumn = createColumn(viewer, "value", 80);
		valueColumn.setLabelProvider(new ScopeVariableLabelProvider(2));
	
		valueColumn.setEditingSupport(new MultiEditingSupport(viewer,
				new BooleanEditingSupport(viewer), new IntegerEditingSupport(
						viewer), new RealEditingSupport(viewer)));
	}

	private void createEventColumns(final TableViewer viewer) {
		TableViewerColumn eventColumn = createColumn(viewer, "event name", 120);
		eventColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof NamedElement) {
					return ((NamedElement) element).getName();
				}
				return super.getText(element);
			}
		});

		TableViewerColumn executeColumn = createColumn(viewer, "execute event",
				120);
		executeColumn.setLabelProvider(new ColumnLabelProvider());

	}

	@Override
	public void setFocus() {
		eventViewer.getTable().setFocus();
	}

	public void setEventViewerInput() {
		eventViewer.setInput(getViewerInput());
		TableItem[] items = eventViewer.getTable().getItems();
		for (TableItem tableItem : items) {
			final TableEditor editor = new TableEditor(eventViewer.getTable());
			editor.horizontalAlignment = SWT.LEFT;
			editor.grabHorizontal = true;
			editor.grabVertical = true;
			Button button = new Button(eventViewer.getTable(), SWT.FLAT);
			button.setText("raise");
			button.addSelectionListener(new ButtonListener(tableItem.getText()));
			editor.setEditor(button, tableItem, 1);
			controls.add(button);
		}
	}

	private void setVariableViewerInput() {
		ISGraphSimulationSession activeSession = SGraphSimulationSessionRegistry.INSTANCE
				.getActiveSession();
		List<ScopeVariable> variables = activeSession.getExecutionScope()
				.getVariables();
		variableViewer.setInput(variables);
	}

	public void clearViewerInput() {
		for (Control control : controls) {
			control.dispose();
		}
		eventViewer.setInput(null);
		variableViewer.setInput(null);
	}


	public static List<Event> getViewerInput() {
		List<Event> events = new ArrayList<Event>();
		Resource activeEditorResource = ActiveEditorResolver
				.getActiveEditorResource();
		if (activeEditorResource == null)
			return Collections.emptyList();
		TreeIterator<EObject> allContents = activeEditorResource
				.getAllContents();
		while (allContents.hasNext()) {
			EObject next = allContents.next();
			if (next instanceof Event) {
				events.add((Event) next);
			}
		}
		return events;

	}

	public void simulationStateChanged(SimulationState oldState,
			SimulationState newState) {
		switch (newState) {
		case STARTED:
			updateDeclarationView();
			break;
		case TERMINATED:
			clearDeclarationView();
			break;
		}
	}

	public void variableValueChanged(String variableName, Object value) {
		updateDeclarationView();
	}

	private void clearDeclarationView() {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				clearViewerInput();
			}
		});
	}

	private void updateDeclarationView() {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				setEventViewerInput();
				setVariableViewerInput();
			}
		});
	}

	@Override
	public void dispose() {
		SGraphSimulationSessionRegistry.INSTANCE.getListeners().remove(this);
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
		// Nothing to do
	}
	
	private static final class ButtonListener implements SelectionListener {

		private final String eventName;

		public ButtonListener(String eventName) {
			this.eventName = eventName;
		}

		public void widgetSelected(SelectionEvent e) {
			ISGraphSimulationSession activeSession = SGraphSimulationSessionRegistry.INSTANCE
					.getActiveSession();
			if (activeSession != null) {
				activeSession.raiseEvent(eventName);
			}
		}

		public void widgetDefaultSelected(SelectionEvent e) {
			// Nothing to do
		}
	}
}
