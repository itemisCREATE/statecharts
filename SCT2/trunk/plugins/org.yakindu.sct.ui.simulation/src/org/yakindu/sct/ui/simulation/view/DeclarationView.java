package org.yakindu.sct.ui.simulation.view;

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
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.yakindu.sct.core.simulation.ISimulationSessionListener;
import org.yakindu.sct.core.simulation.SGraphSimulationSession;
import org.yakindu.sct.core.simulation.SGraphSimulationSessionRegistry;
import org.yakindu.sct.model.sgraph.Declaration;
import org.yakindu.sct.model.sgraph.Event;
import org.yakindu.sct.model.sgraph.NamedElement;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Variable;
import org.yakindu.sct.model.sgraph.Vertex;

import de.itemis.xtext.utils.jface.viewers.util.ActiveEditorResolver;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class DeclarationView extends ViewPart implements
		ISimulationSessionListener {

	public static final String ID = "org.yakindu.sct.ui.simulation.declarationview";

	private TableViewer eventViewer;

	private TableViewer variableViewer;

	private List<Control> controls;

	public DeclarationView() {
		SGraphSimulationSessionRegistry.INSTANCE.getListeners().add(this);
	}

	@Override
	public void createPartControl(Composite parent) {
		controls = new ArrayList<Control>();
		parent.setLayout(new GridLayout(1, true));

		eventViewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.FULL_SELECTION);
		eventViewer.getTable().setLinesVisible(true);
		eventViewer.getTable().setHeaderVisible(true);
		createEventColumns(eventViewer);
		eventViewer.setContentProvider(new ArrayContentProvider());
		eventViewer.addFilter(new ClassViewerFilter(Event.class));
		GridDataFactory.fillDefaults().grab(true, true)
				.applyTo(eventViewer.getTable());

		variableViewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.FULL_SELECTION);
		variableViewer.getTable().setLinesVisible(true);
		variableViewer.getTable().setHeaderVisible(true);
		createVariableColumns(variableViewer);
		variableViewer.setContentProvider(new ArrayContentProvider());
		variableViewer.addFilter(new ClassViewerFilter(Variable.class));
		GridDataFactory.fillDefaults().grab(true, true)
				.applyTo(variableViewer.getTable());

		setEventViewerInput(getViewerInput());
	}

	@Override
	public void dispose() {
		SGraphSimulationSessionRegistry.INSTANCE.getListeners().remove(this);
		super.dispose();
	}

	private void createVariableColumns(TableViewer viewer) {
		TableViewerColumn variableColumn = new TableViewerColumn(viewer,
				SWT.NONE);
		variableColumn.getColumn().setText("variable name");
		variableColumn.getColumn().setWidth(120);
		variableColumn.getColumn().setResizable(true);
		variableColumn.getColumn().setMoveable(true);
		variableColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof NamedElement) {
					return ((NamedElement) element).getName();
				}
				return super.getText(element);
			}
		});

		TableViewerColumn valueColumn = new TableViewerColumn(viewer, SWT.NONE);
		valueColumn.getColumn().setText("value");
		valueColumn.getColumn().setWidth(120);
		valueColumn.getColumn().setResizable(true);
		valueColumn.getColumn().setMoveable(true);
		valueColumn.setLabelProvider(new ColumnLabelProvider());
	}

	private void createEventColumns(final TableViewer viewer) {
		TableViewerColumn eventColumn = new TableViewerColumn(viewer, SWT.NONE);
		eventColumn.getColumn().setText("event name");
		eventColumn.getColumn().setWidth(120);
		eventColumn.getColumn().setResizable(true);
		eventColumn.getColumn().setMoveable(true);
		eventColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof NamedElement) {
					return ((NamedElement) element).getName();
				}
				return super.getText(element);
			}
		});

		TableViewerColumn executeColumn = new TableViewerColumn(viewer,
				SWT.NONE);
		executeColumn.getColumn().setText("execute event");
		executeColumn.getColumn().setWidth(120);
		executeColumn.getColumn().setResizable(true);
		executeColumn.getColumn().setMoveable(true);
		executeColumn.setLabelProvider(new ColumnLabelProvider());

	}

	@Override
	public void setFocus() {
		eventViewer.getTable().setFocus();
	}

	public void setEventViewerInput(List<Declaration> events) {
		eventViewer.setInput(events);
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

	public void clearViewerInput() {
		for (Control control : controls) {
			control.dispose();
		}
		eventViewer.setInput(null);
		variableViewer.setInput(null);
	}

	private static final class ButtonListener implements SelectionListener {

		private final String eventName;

		public ButtonListener(String eventName) {
			this.eventName = eventName;
		}

		public void widgetSelected(SelectionEvent e) {
			SGraphSimulationSession activeSession = SGraphSimulationSessionRegistry.INSTANCE
					.getActiveSession();
			if (activeSession != null) {
				activeSession.raiseEvent(eventName);
			}

		}

		public void widgetDefaultSelected(SelectionEvent e) {
			// Nothing to do
		}

	}

	public static List<Declaration> getViewerInput() {
		List<Declaration> declarations = new ArrayList<Declaration>();
		Resource activeEditorResource = ActiveEditorResolver
				.getActiveEditorResource();
		if (activeEditorResource == null)
			return Collections.emptyList();
		TreeIterator<EObject> allContents = activeEditorResource
				.getAllContents();
		while (allContents.hasNext()) {
			EObject next = allContents.next();
			if (next instanceof Declaration) {
				declarations.add((Declaration) next);
			}
		}
		return declarations;

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
		System.out.println("VARIABLE VALUE CHANGED!!!!! " + variableName
				+ " value is " + value);
	}

	protected DeclarationView getDeclarationView() {
		IViewReference[] viewReferences = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getViewReferences();
		for (IViewReference ref : viewReferences) {
			if (DeclarationView.ID.equals(ref.getId())) {
				return (DeclarationView) ref.getView(true);

			}
		}
		return null;
	}

	private void clearDeclarationView() {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				DeclarationView eventView = getDeclarationView();
				if (eventView != null) {
					eventView.clearViewerInput();
				}
			}
		});
	}

	private void updateDeclarationView() {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				DeclarationView eventView = getDeclarationView();
				if (eventView != null) {
					eventView.setEventViewerInput(getViewerInput());
				}
			}
		});
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

}
