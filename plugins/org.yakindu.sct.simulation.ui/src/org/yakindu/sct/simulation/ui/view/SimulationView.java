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

import org.apache.commons.lang.time.DurationFormatUtils;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IDebugEventSetListener;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.contexts.DebugContextEvent;
import org.eclipse.debug.ui.contexts.IDebugContextListener;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.part.ViewPart;
import org.yakindu.sct.simulation.core.debugmodel.SCTDebugTarget;
import org.yakindu.sct.simulation.core.runtime.IExecutionContext;
import org.yakindu.sct.simulation.core.runtime.IExecutionFacade;
import org.yakindu.sct.simulation.core.runtime.impl.ExecutionEvent;
import org.yakindu.sct.simulation.core.runtime.timer.VirtualClock;
import org.yakindu.sct.simulation.ui.view.actions.CollapseAllAction;
import org.yakindu.sct.simulation.ui.view.actions.ExpandAllAction;
import org.yakindu.sct.simulation.ui.view.actions.HideTimeEventsAction;
import org.yakindu.sct.simulation.ui.view.editing.BooleanEditingSupport;
import org.yakindu.sct.simulation.ui.view.editing.IntegerEditingSupport;
import org.yakindu.sct.simulation.ui.view.editing.MultiEditingSupport;
import org.yakindu.sct.simulation.ui.view.editing.RealEditingSupport;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SimulationView extends ViewPart implements IDebugContextListener,
		IDebugEventSetListener {

	private TreeViewer viewer;
	private SCTDebugTarget debugTarget;
	private Text scaleFactor;
	private FormToolkit kit;
	private Font font;
	private Label lblVirtualTime;
	private Label lblRealTime;
	private ClockUpdater clockUpdater;

	public SimulationView() {
		DebugUITools.getDebugContextManager().addDebugContextListener(this);
		DebugPlugin.getDefault().addDebugEventListener(this);
		kit = new FormToolkit(Display.getDefault());
		font = new Font(Display.getDefault(), new FontData("Courier", 10,
				SWT.BOLD));
		clockUpdater = new ClockUpdater();
	}

	@Override
	public void dispose() {
		clockUpdater.setTerminated(true);
		super.dispose();
		DebugUITools.getDebugContextManager().removeDebugContextListener(this);
		DebugPlugin.getDefault().removeDebugEventListener(this);
		font.dispose();
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new FillLayout(SWT.VERTICAL));
		createViewer(parent);
		createTimeScalingSection(parent);
		hookActions();
	}

	@Override
	public void setFocus() {
		viewer.getTree().setFocus();
	}

	private void createTimeScalingSection(Composite parent) {
		Section section = kit.createSection(parent, Section.TITLE_BAR);
		section.setText("time scaling");
		Composite client = kit.createComposite(section);
		client.setLayout(new GridLayout(3, false));
		section.setClient(client);
		createClocks(client);
		createScalingControls(client);
	}

	private void createScalingControls(Composite client) {
		final Scale scale = new Scale(client, SWT.NONE);
		scale.setMinimum(1);
		scale.setMaximum(100);
		scale.setSelection(50);
		scale.setPageIncrement(5);
		scale.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				int selection = scale.getSelection();
				if (selection > 50) {
					selection = selection - 50;
					scaleFactor.setText(String.valueOf(1.0d * selection));
				} else if (selection == 50) {
					scaleFactor.setText(String.valueOf(1.0d));
				} else {
					selection = 50 - selection;
					scaleFactor.setText(String.valueOf(1.0d / selection));
				}
				applyScaleFactor();
			}
		});
		GridDataFactory.fillDefaults().span(3, 0).applyTo(scale);
		Label label = kit.createLabel(client, "scale factor: ");
		GridDataFactory.fillDefaults().grab(true, false).applyTo(label);
		scaleFactor = kit.createText(client, "1.0");
		GridDataFactory.fillDefaults().grab(true, false).applyTo(scaleFactor);
		final Button setScale = kit.createButton(client, "apply", SWT.PUSH);
		setScale.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				applyScaleFactor();
			}
		});
		GridDataFactory.fillDefaults().applyTo(setScale);
	}

	private void createClocks(Composite parent) {
		// Virtual Clock
		Label label = kit.createLabel(parent, "virtual time:");
		GridDataFactory.fillDefaults().applyTo(label);
		lblVirtualTime = new Label(parent, SWT.NONE);
		lblVirtualTime.setFont(font);
		lblVirtualTime.setText("00:00:00:00");

		GridDataFactory.fillDefaults().grab(true, false).span(2, 0)
				.applyTo(lblVirtualTime);
		// Real time clock
		Label label2 = kit.createLabel(parent, "real time:");
		GridDataFactory.fillDefaults().applyTo(label2);
		lblRealTime = new Label(parent, SWT.NONE);
		lblRealTime.setFont(font);
		lblRealTime.setText("00:00:00:00");
		GridDataFactory.fillDefaults().grab(true, false).span(2, 0)
				.applyTo(lblRealTime);

	}

	private void applyScaleFactor() {
		try {
			double factor = Double.parseDouble(scaleFactor.getText());
			IExecutionFacade facade = (IExecutionFacade) debugTarget
					.getAdapter(IExecutionFacade.class);
			facade.getExecutionContext().setTimeScaleFactor(factor);
		} catch (NumberFormatException ex) {
		}
	}

	protected Viewer createViewer(Composite parent) {
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL
				| SWT.FULL_SELECTION);
		viewer.getTree().setHeaderVisible(true);
		viewer.getTree().setLinesVisible(true);
		TreeViewerColumn column = new TreeViewerColumn(viewer, SWT.DEFAULT);
		column.getColumn().setText("Name");
		column.getColumn().setMoveable(true);
		column.getColumn().setWidth(150);
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
			if (object == null)
				return;
			SCTDebugTarget newTarget = (SCTDebugTarget) object
					.getAdapter(IDebugTarget.class);

			if (newTarget != debugTarget && newTarget != null
					&& !newTarget.isTerminated()) {
				refreshInput(newTarget);
				debugTarget = newTarget;
				new Thread(clockUpdater).start();
			}
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
					clockUpdater.setTerminated(true);
				}
			});
			break;
		}
	}

	private void refreshInput(final SCTDebugTarget debugTarget) {
		IExecutionFacade facade = (IExecutionFacade) debugTarget
				.getAdapter(IExecutionFacade.class);
		viewer.setInput(facade.getExecutionContext());
		viewer.expandAll();

	}

	protected void hookActions() {
		IToolBarManager mgr = getViewSite().getActionBars().getToolBarManager();
		IAction collapse = new CollapseAllAction(viewer);
		mgr.add(collapse);
		IAction expand = new ExpandAllAction(viewer);
		mgr.add(expand);
		IAction hideTimeEvent = new HideTimeEventsAction(true);
		mgr.add(hideTimeEvent);
	}

	public class ClockUpdater implements Runnable {

		private static final String PATTERN = "HH:mm:ss:SS";
		private boolean terminated = false;

		public void run() {
			while (!terminated) {
				Display.getDefault().asyncExec(new Runnable() {
					public void run() {
						IExecutionFacade facade = (IExecutionFacade) debugTarget
								.getAdapter(IExecutionFacade.class);
						VirtualClock virtualClock = facade
								.getExecutionContext().getVirtualClock();
						if (lblVirtualTime != null
								&& !lblVirtualTime.isDisposed()) {
							String text = DurationFormatUtils.formatDuration(
									virtualClock.getTime()
											- virtualClock.getStartTime(),
									PATTERN);
							lblVirtualTime.setText(text);
						}
						if (lblRealTime != null && !lblRealTime.isDisposed()) {
							String text = DurationFormatUtils.formatDuration(
									System.currentTimeMillis()
											- virtualClock.getStartTime(),
									PATTERN);
							lblRealTime.setText(text);
						}
					}
				});
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		public boolean isTerminated() {
			return terminated;
		}

		public void setTerminated(boolean terminated) {
			this.terminated = terminated;
		}
	}

}
