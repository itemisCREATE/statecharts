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
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IStep;
import org.eclipse.debug.internal.ui.commands.actions.ResumeCommandAction;
import org.eclipse.debug.internal.ui.commands.actions.StepOverCommandAction;
import org.eclipse.debug.internal.ui.commands.actions.SuspendCommandAction;
import org.eclipse.debug.internal.ui.commands.actions.TerminateCommandAction;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.sct.domain.extension.DomainRegistry;
import org.yakindu.sct.domain.extension.IDomain;
import org.yakindu.sct.model.sruntime.ExecutionEvent;
import org.yakindu.sct.simulation.core.engine.ISimulationEngine;
import org.yakindu.sct.simulation.core.engine.scheduling.DefaultTimeTaskScheduler;
import org.yakindu.sct.simulation.core.engine.scheduling.ITimeTaskScheduler;
import org.yakindu.sct.simulation.ui.view.actions.CollapseAllAction;
import org.yakindu.sct.simulation.ui.view.actions.ExpandAllAction;
import org.yakindu.sct.simulation.ui.view.actions.HideTimeEventsAction;
import org.yakindu.sct.simulation.ui.view.editing.ScopeSlotEditingSupport.ITypeSystemProvider;

import com.google.common.collect.Lists;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SimulationView extends AbstractDebugTargetView implements ITypeSystemProvider {

	private TreeViewer viewer;
	private ViewerRefresher viewerRefresher;
	private FormToolkit kit;
	private Font font;
	private RaiseEventSelectionListener selectionListener;
	private ITypeSystem typeSystem;
	private ITimeTaskScheduler timeScheduler;
	private Label timeSchedulerLabel;
	private TimeSchedulerComponentRefresher timeSchedulerRefresher;

	public SimulationView() {
		kit = new FormToolkit(Display.getDefault());
		kit.setBorderStyle(SWT.BORDER);
		font = new Font(Display.getDefault(), new FontData("Courier", 10, SWT.BOLD));
	}

	@Override
	public void dispose() {
		selectionListener.dispose();
		font.dispose();
		disposeTimeSchedulerComponent();
		disposeViewerRefresher();
		disposeTimeSchedulerRefresher();
		super.dispose();
	}

	protected void disposeTimeSchedulerRefresher() {
		if (timeSchedulerRefresher != null) {
			timeSchedulerRefresher.cancel = true;
			timeSchedulerRefresher = null;
		}
	}

	protected void disposeViewerRefresher() {
		if (viewerRefresher != null) {
			viewerRefresher.cancel = true;
			viewerRefresher = null;
		}
	}

	protected void disposeTimeSchedulerComponent() {
		if (timeSchedulerLabel != null && !timeSchedulerLabel.isDisposed()) {
			timeSchedulerLabel.dispose();
		}
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new FillLayout(SWT.VERTICAL));
		Composite top = kit.createComposite(parent);
		top.setLayout(new FillLayout(SWT.VERTICAL));
		SashForm sashForm = new SashForm(top, SWT.SMOOTH | SWT.VERTICAL);
		sashForm.setBackground(ColorConstants.white);
		sashForm.setLayout(new FillLayout(SWT.NONE));
		createViewer(sashForm);
		createTimeScheduler(sashForm);
		sashForm.setWeights(new int[]{10, 1});
		hookActions();
		super.createPartControl(parent);
	}

	@Override
	public void setFocus() {
		viewer.getTree().setFocus();
	}

	protected Viewer createViewer(Composite parent) {
		viewer = ExecutionContextViewerFactory.createViewer(parent, false, this);
		selectionListener = new RaiseEventSelectionListener(viewer);
		return viewer;
	}

	public Label createTimeScheduler(Composite parent) {
		Composite comp = new Composite(parent, SWT.BORDER);
		GridLayout layout = new GridLayout();
		comp.setLayout(layout);
		timeSchedulerLabel = new Label(comp, SWT.NONE);
		timeSchedulerLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, true));
		timeSchedulerLabel.setToolTipText("Displays the duration since the simulation is running");
		return timeSchedulerLabel;
	}

	protected void setViewerInput(Object input) {
		if (viewerRefresher != null || input == null) {
			viewerRefresher.cancel = true;
			timeSchedulerRefresher.cancel = true;
		} else {
			if (viewerRefresher == null)
				this.viewerRefresher = new ViewerRefresher();
			if (timeSchedulerRefresher == null)
				this.timeSchedulerRefresher = new TimeSchedulerComponentRefresher();
		}
		if (input != null) {
			this.viewer.setInput(input);
			if (this.viewerRefresher.isCancel())
				this.viewerRefresher.cancel = false;
			if (timeSchedulerRefresher.isCancel())
				this.timeSchedulerRefresher.cancel = false;

			new Thread(viewerRefresher).start();
			new Thread(timeSchedulerRefresher).start();
		}

	}

	protected void handleDebugEvent(DebugEvent debugEvent) {
		updateActions();
		switch (debugEvent.getKind()) {
			case DebugEvent.TERMINATE :
				Display.getDefault().asyncExec(new Runnable() {
					public void run() {
						setViewerInput(null);
					}
				});
				break;
			case DebugEvent.SUSPEND :
				break;
			case DebugEvent.RESUME :
				break;
		}
	}

	protected void activeTargetChanged(final IDebugTarget debugTarget) {
		updateTypeSystem(debugTarget);
		ISimulationEngine engine = (ISimulationEngine) debugTarget.getAdapter(ISimulationEngine.class);
		timeScheduler = (DefaultTimeTaskScheduler) engine.getTimeTaskScheduler();
		setViewerInput(engine.getExecutionContext());
		(new ExpandAllAction(viewer)).run();
		updateActions();
	}

	protected void updateActions() {
		IContributionItem[] items = getViewSite().getActionBars().getToolBarManager().getItems();
		for (IContributionItem iContributionItem : items) {
			if (iContributionItem instanceof ActionContributionItem) {
				IAction currentAction = ((ActionContributionItem) iContributionItem).getAction();
				currentAction.setEnabled(currentAction.isEnabled());
			}
		}
	}

	private void updateTypeSystem(final IDebugTarget debugTarget) {
		IDomain domain = DomainRegistry.getDomain((EObject) debugTarget.getAdapter(EObject.class));
		typeSystem = domain.getInjector(IDomain.FEATURE_SIMULATION).getInstance(ITypeSystem.class);
	}

	protected void hookActions() {
		IToolBarManager mgr = getViewSite().getActionBars().getToolBarManager();
		Lists.newArrayList(new ResumeAction(), new SuspendAction(), new TerminateAction(), new StepOverAction())
				.forEach(action -> {
					mgr.add(action);
				});
		updateActions();
		mgr.add(new Separator());
		IAction collapse = new CollapseAllAction(viewer);
		mgr.add(collapse);
		IAction expand = new ExpandAllAction(viewer);
		mgr.add(expand);
		IAction hideTimeEvent = new HideTimeEventsAction(false);
		mgr.add(hideTimeEvent);
		getViewSite().getActionBars().getToolBarManager().update(true);
	}

	/**
	 * Listens for event selections within the Context TreeViewer
	 * 
	 * @author andreas muelder - Initial contribution and API
	 * 
	 */
	protected static class RaiseEventSelectionListener {

		private TreeViewer viewer;
		private Point mouseLocation;

		MouseMoveListener moveListener = new MouseMoveListener() {
			public void mouseMove(MouseEvent e) {
				mouseLocation = new Point(e.x, e.y);
			}
		};
		MouseAdapter clickListener = new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				ViewerCell cell = viewer.getCell(mouseLocation);
				if (cell == null || cell.getColumnIndex() != 0)
					return;
				Object element = cell.getElement();
				if (element instanceof ExecutionEvent)
					raiseEvent((ExecutionEvent) element);
			}
		};

		public RaiseEventSelectionListener(TreeViewer viewer) {
			this.viewer = viewer;
			registerMouseListener();
		}

		public void dispose() {
			if (!viewer.getControl().isDisposed()) {
				viewer.getControl().removeMouseMoveListener(moveListener);
				viewer.getControl().removeMouseListener(clickListener);
			}
		}

		protected void registerMouseListener() {
			viewer.getControl().addMouseMoveListener(moveListener);
			viewer.getControl().addMouseListener(clickListener);
		}

		public void raiseEvent(ExecutionEvent event) {
			event.setRaised(!event.isRaised());
			viewer.refresh();
		}
	}

	@Override
	public ITypeSystem getTypeSystem() {
		return typeSystem;
	}

	@SuppressWarnings("restriction")
	protected class StepOverAction extends StepOverCommandAction implements IAction {
		@Override
		public void run() {
			if (debugTarget instanceof IStep) {
				try {
					((IStep) debugTarget).stepOver();
				} catch (DebugException e) {
					e.printStackTrace();
				}
			}
		}

		@Override
		public boolean isEnabled() {
			return debugTarget != null && (debugTarget instanceof IStep && ((IStep) debugTarget).canStepOver());
		}
	}

	@SuppressWarnings("restriction")
	protected class TerminateAction extends TerminateCommandAction implements IAction {
		@Override
		public void run() {
			try {
				debugTarget.terminate();
			} catch (DebugException e) {
				e.printStackTrace();
			}
		}

		@Override
		public boolean isEnabled() {
			return debugTarget != null && debugTarget.canTerminate();
		}
	}

	@SuppressWarnings("restriction")
	protected class SuspendAction extends SuspendCommandAction implements IAction {
		@Override
		public void run() {
			try {
				debugTarget.suspend();
			} catch (DebugException e) {
				e.printStackTrace();
			}
		}

		@Override
		public boolean isEnabled() {
			return debugTarget != null && debugTarget.canSuspend();
		}
	}

	@SuppressWarnings("restriction")
	protected class ResumeAction extends ResumeCommandAction implements IAction {
		@Override
		public void run() {
			try {
				debugTarget.resume();
			} catch (DebugException e) {
				e.printStackTrace();
			}
		}

		@Override
		public boolean isEnabled() {
			return debugTarget != null && debugTarget.canResume();
		}
	}

	protected class ViewerRefresher implements Runnable {

		private static final int UPDATE_INTERVAL = 500;
		private boolean cancel = false;

		@Override
		public void run() {
			while (!cancel && viewer.getInput() != null) {
				try {
					Thread.sleep(UPDATE_INTERVAL);
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {
							if (viewer != null && !viewer.getControl().isDisposed()
									&& ((ExecutionContextContentProvider) viewer.getContentProvider())
											.isShouldUpdate()) {
								viewer.refresh();
							}
						}
					});
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		public boolean isCancel() {
			return cancel;
		}

		public void setCancel(boolean cancel) {
			this.cancel = cancel;
		}
	}

	protected class TimeSchedulerComponentRefresher implements Runnable {

		private static final int UPDATE_INTERVAL = 500;
		private boolean cancel = false;

		@Override
		public void run() {
			while (!cancel && !timeSchedulerLabel.isDisposed() && timeScheduler != null) {
				try {
					Thread.sleep(UPDATE_INTERVAL);
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {

							if (timeSchedulerLabel != null && !timeSchedulerLabel.isDisposed()) {
								updateTimestamp(timeScheduler.getCurrentTime());
							}
						}
					});
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		protected void updateTimestamp(long timestamp) {
			String formatDurationHMS = DurationFormatUtils.formatDuration(timestamp, "HH:mm:ss.SSS");
			timeSchedulerLabel.setText("Simulation time: " + formatDurationHMS);
			timeSchedulerLabel.update();
		}

		public boolean isCancel() {
			return cancel;
		}

		public void setCancel(boolean cancel) {
			this.cancel = cancel;
		}
	}

}
