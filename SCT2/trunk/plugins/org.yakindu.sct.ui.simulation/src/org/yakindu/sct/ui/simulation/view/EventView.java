package org.yakindu.sct.ui.simulation.view;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.part.ViewPart;
import org.yakindu.sct.core.simulation.SGraphSimulationSession;
import org.yakindu.sct.core.simulation.SGraphSimulationSessionRegistry;
import org.yakindu.sct.model.sgraph.Event;
import org.yakindu.sct.model.sgraph.NamedElement;

/**
 * 
 * @author andreas muelder
 * 
 */
public class EventView extends ViewPart {

	public static final String ID = "org.yakindu.sct.ui.simulation.eventview";

	private TableViewer viewer;

	private List<Control> controls;

	@Override
	public void createPartControl(Composite parent) {
		controls = new ArrayList<Control>();
		parent.setLayout(new FillLayout());
		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.FULL_SELECTION);
		viewer.getTable().setLinesVisible(true);
		viewer.getTable().setHeaderVisible(true);
		createColumns(viewer);
		viewer.setContentProvider(new ArrayContentProvider());

	}

	private void createColumns(final TableViewer viewer) {
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
		viewer.getTable().setFocus();
	}

	public void setViewerInput(List<Event> events) {
		viewer.setInput(events);
		TableItem[] items = viewer.getTable().getItems();
		for (TableItem tableItem : items) {
			final TableEditor editor = new TableEditor(viewer.getTable());
			editor.horizontalAlignment = SWT.LEFT;
			editor.grabHorizontal = true;
			editor.grabVertical = true;
			Button button = new Button(viewer.getTable(), SWT.FLAT);
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
		viewer.setInput(null);
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

}
