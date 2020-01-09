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
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.time.DurationFormatUtils;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IStep;
import org.eclipse.debug.internal.ui.commands.actions.RestartCommandAction;
import org.eclipse.debug.internal.ui.commands.actions.ResumeCommandAction;
import org.eclipse.debug.internal.ui.commands.actions.StepOverCommandAction;
import org.eclipse.debug.internal.ui.commands.actions.SuspendCommandAction;
import org.eclipse.debug.internal.ui.commands.actions.TerminateAndRelaunchAction;
import org.eclipse.debug.internal.ui.commands.actions.TerminateCommandAction;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.actions.DebugCommandAction;
import org.eclipse.debug.ui.contexts.DebugContextEvent;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.sct.domain.extension.DomainRegistry;
import org.yakindu.sct.domain.extension.IDomain;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sruntime.ExecutionEvent;
import org.yakindu.sct.simulation.core.debugmodel.SCTDebugTarget;
import org.yakindu.sct.simulation.core.engine.ISimulationEngine;
import org.yakindu.sct.simulation.core.engine.scheduling.ITimeTaskScheduler;
import org.yakindu.sct.simulation.ui.SimulationImages;
import org.yakindu.sct.simulation.ui.model.presenter.SCTSourceDisplayDispatcher;
import org.yakindu.sct.simulation.ui.view.actions.CollapseAllAction;
import org.yakindu.sct.simulation.ui.view.actions.ExpandAllAction;
import org.yakindu.sct.simulation.ui.view.actions.HideTimeEventsAction;
import org.yakindu.sct.simulation.ui.view.editing.ScopeSlotEditingSupport.ITypeSystemProvider;
import org.yakindu.sct.ui.editor.partitioning.DiagramPartitioningUtil;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@SuppressWarnings("restriction")
public class SimulationView extends AbstractDebugTargetView implements ITypeSystemProvider {

	public static final String ID = "org.yakindu.sct.simulation.ui.declarationview"; //$NON-NLS-1$

	private TreeViewer viewer;
	private ViewerRefresher viewerRefresher;
	private FormToolkit kit;
	private Font font;
	private RaiseEventSelectionListener selectionListener;
	private ITypeSystem typeSystem;
	private ITimeTaskScheduler timeScheduler;
	private Label timeLabel;
	private Label timeIconLabel;
	private ComboViewer sessionDropdown;
	private HashSet<IDebugTarget> targets = Sets.newHashSet();
	private static SCTSourceDisplayDispatcher sctSourceDisplayDispatcher;
	private static final int FONT_SIZE = 11;
	private static final String FONT = "Courier New";

	private SessionSelectionChangedListener listener;

	public SimulationView() {
		kit = new FormToolkit(Display.getDefault());
		kit.setBorderStyle(SWT.BORDER);
		font = new Font(Display.getDefault(), new FontData(FONT, FONT_SIZE, SWT.NORMAL));
		sctSourceDisplayDispatcher = new SCTSourceDisplayDispatcher();
	}

	@Override
	public void dispose() {
		selectionListener.dispose();
		font.dispose();
		sctSourceDisplayDispatcher = null;
		disposeSessionDropDownComponent();
		disposeViewerRefresher();
		disposeTimeLabels();
		super.dispose();
	}

	protected void disposeViewerRefresher() {
		if (viewerRefresher != null) {
			viewerRefresher.cancel = true;
			viewerRefresher = null;
		}
	}

	protected void disposeTimeLabels() {
		if (timeLabel != null && !timeLabel.isDisposed()) {
			timeLabel.dispose();
		}
		if (timeIconLabel != null && !timeIconLabel.isDisposed()) {
			timeIconLabel.dispose();
		}
	}

	protected void disposeSessionDropDownComponent() {
		if (sessionDropdown != null && sessionDropdown.getControl() != null
				&& !sessionDropdown.getControl().isDisposed()) {
			sessionDropdown.getControl().dispose();
		}
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new FillLayout(SWT.VERTICAL));
		Composite top = kit.createComposite(parent);
		top.setLayout(new GridLayout(2, false));
		createSessionSelectorComponent(top);
		createTimeSchedulerComponent(top);
		createViewer(top);
		hookActions();
		super.createPartControl(parent);
	}

	protected ComboViewer createSessionSelectorComponent(Composite top) {
		Combo combo = new Combo(top, SWT.DROP_DOWN | SWT.READ_ONLY);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		this.sessionDropdown = new ComboViewer(combo);
		this.sessionDropdown.setContentProvider(new ArrayContentProvider());
		this.sessionDropdown.setLabelProvider(new LabelProvider() {

			@Override
			public String getText(Object element) {
				IDebugTarget target = ((IDebugTarget) element);
				boolean isTerminated = target.isTerminated();
				boolean isSuspended = target.isSuspended();
				try {
					return target.getName() + " ["
							+ (isTerminated ? "terminated" : isSuspended ? "suspended" : "active") + "]";
				} catch (DebugException e) {
					return "unkown state";
				}
			}
		});

		listener = new SessionSelectionChangedListener();
		this.sessionDropdown.addPostSelectionChangedListener(listener);

		targets.clear();
		for (ILaunch iLaunch : DebugPlugin.getDefault().getLaunchManager().getLaunches()) {
			for (IDebugTarget iDebugTarget : iLaunch.getDebugTargets()) {
				if (!iDebugTarget.isTerminated())
					targets.add(iDebugTarget);
			}
		}
		sessionDropdown.setInput(targets);
		if (!targets.isEmpty()) {
			IDebugTarget dt = targets.iterator().next();
			sessionDropdown.setSelection(new StructuredSelection(dt), true);
			activeTargetChanged(dt);
		}

		return this.sessionDropdown;
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

	public Label createTimeSchedulerComponent(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		comp.setLayout(new GridLayout(2, false));
		timeIconLabel = new Label(comp, SWT.NONE);
		timeIconLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false));
		timeIconLabel.setImage(SimulationImages.SIMULATION_CLOCK.image());
		timeIconLabel.setToolTipText("Displays the duration since the simulation is running");
		timeIconLabel.setVisible(false);
		timeLabel = new Label(comp, SWT.NONE);
		timeLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false));
		return timeLabel;
	}

	protected void setViewerInput(Object input) {
		if (viewerRefresher == null)
			this.viewerRefresher = new ViewerRefresher();

		Display.getDefault().asyncExec(() -> {
			if (input == null) {
				viewerRefresher.cancel = true;
			} else {
				if (this.viewerRefresher.isCancel())
					this.viewerRefresher.cancel = false;
				new Thread(viewerRefresher).start();
			}
			this.viewer.setInput(input);
		});

	}

	@Override
	protected void handleDebugEvent(DebugEvent debugEvent) {
		updateActions();
		switch (debugEvent.getKind()) {
		case DebugEvent.TERMINATE:
			setViewerInput(null);
			break;
		case DebugEvent.SUSPEND:
			break;
		case DebugEvent.RESUME:
			break;
		}
		Display.getDefault().asyncExec(() -> {
			if (debugEvent.getSource() != null) {
				sessionDropdown.refresh();
				targets.removeIf(dt -> dt.isTerminated());
			}
		});
	}

	@Override
	public void debugContextChanged(DebugContextEvent event) {
		super.debugContextChanged(event);
		if (debugTarget != null)
			this.sessionDropdown.setSelection(new StructuredSelection(debugTarget));
	}

	@Override
	protected void activeTargetChanged(final IDebugTarget debugTarget) {
		openEditorForTarget(debugTarget);
		updateTypeSystem(debugTarget);
		ISimulationEngine engine = debugTarget.getAdapter(ISimulationEngine.class);
		timeScheduler = engine.getTimeTaskScheduler();
		setViewerInput(engine.getExecutionContext());
		updateActions();
		updateSessionDropdownInput(debugTarget);
	}

	protected void openEditorForTarget(final IDebugTarget debugTarget) {
		if (this.debugTarget != null && debugTarget instanceof SCTDebugTarget
				&& ((SCTDebugTarget) debugTarget).isPrimary()) {
			EObject adapter = debugTarget.getAdapter(EObject.class);
			if (adapter instanceof Statechart) {
				Statechart statechart = (Statechart) adapter;
				Diagram diagram = DiagramPartitioningUtil.getDiagramContaining(statechart);
				Display.getDefault().asyncExec(new Runnable() {
					@Override
					public void run() {
						DiagramPartitioningUtil.openEditor(diagram);
					}
				});
			}
		}
	}

	protected void updateSessionDropdownInput(final IDebugTarget debugTarget) {
		Display.getDefault().asyncExec(() -> {
			if (debugTarget != null) {
				if (!targets.contains(debugTarget)) {
					targets.add(debugTarget);

					sessionDropdown.setInput(targets);
					sessionDropdown.setSelection(new StructuredSelection(debugTarget), true);
					changeTarget(debugTarget);
				}
				sessionDropdown.refresh();
			}
		});
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
		IDomain domain = DomainRegistry.getDomain(debugTarget.getAdapter(EObject.class));
		typeSystem = domain.getInjector(IDomain.FEATURE_SIMULATION).getInstance(ITypeSystem.class);
	}

	protected void hookActions() {
		IToolBarManager mgr = getViewSite().getActionBars().getToolBarManager();
		addActions(mgr, Lists.newArrayList(new ResumeAction(), new SuspendAction(), new StepOverAction()));
		addActions(mgr, Lists.newArrayList(new TerminateAction(), new TerminateAndRelaunch()));
		addActions(mgr, Lists.newArrayList(new RestartAction()));
		IAction collapse = new CollapseAllAction(viewer);
		mgr.add(collapse);
		IAction expand = new ExpandAllAction(viewer);
		mgr.add(expand);
		IAction hideTimeEvent = new HideTimeEventsAction(false);
		mgr.add(hideTimeEvent);
		getViewSite().getActionBars().getToolBarManager().update(true);
	}

	protected void addActions(IToolBarManager mgr, ArrayList<DebugCommandAction> actions) {
		if (actions.isEmpty()) {
			return;
		}
		for (DebugCommandAction action : actions) {
			mgr.add(action);
		}
		updateActions();
		mgr.add(new Separator());
	}

	/**
	 * @author robert rudi - Initial contribution and API
	 *
	 */
	protected class SessionSelectionChangedListener implements ISelectionChangedListener {
		@Override
		public void selectionChanged(SelectionChangedEvent event) {
			IStructuredSelection selection = (IStructuredSelection) event.getSelection();
			IDebugTarget debugTarget = (IDebugTarget) selection.getFirstElement();
			if (debugTarget != null) {
				changeTarget(debugTarget);
				sctSourceDisplayDispatcher.displaySource(debugTarget, SimulationView.this.getSite().getPage(), true);
			}
		}
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
			@Override
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

	protected class RestartAction extends RestartCommandAction implements IAction {
		@Override
		public void run() {
			Display.getDefault().asyncExec(new Runnable() {

				@Override
				public void run() {
					IDebugTarget[] debugTargets = debugTarget.getLaunch().getDebugTargets();
					for (IDebugTarget current : debugTargets) {
						ILaunch launch = current.getLaunch();
						SCTDebugTarget target = (SCTDebugTarget) launch.getDebugTarget();
						ILaunchConfiguration launchConfiguration = target.getLaunch().getLaunchConfiguration();
						DebugUITools.launch(launchConfiguration, target.getLaunch().getLaunchMode());
					}
				}
			});
		}

		@Override
		public boolean isEnabled() {
			return debugTarget != null;
		}
	}

	protected class TerminateAndRelaunch extends TerminateAndRelaunchAction implements IAction {
		@Override
		public void run() {
			Display.getDefault().asyncExec(new Runnable() {

				@Override
				public void run() {
					IDebugTarget[] debugTargets = debugTarget.getLaunch().getDebugTargets();
					for (IDebugTarget current : debugTargets) {
						ILaunch launch = current.getLaunch();
						SCTDebugTarget target = (SCTDebugTarget) launch.getDebugTarget();
						try {
							target.getLaunch().terminate();
							ILaunchConfiguration launchConfiguration = target.getLaunch().getLaunchConfiguration();
							DebugUITools.launch(launchConfiguration, target.getLaunch().getLaunchMode());
						} catch (CoreException e) {
							e.printStackTrace();
						}
					}
				}
			});
		}

		@Override
		public boolean isEnabled() {
			return debugTarget != null && !debugTarget.isTerminated();
		}
	}

	protected class StepOverAction extends StepOverCommandAction implements IAction {
		@Override
		public void run() {
			Display.getDefault().asyncExec(new Runnable() {

				@Override
				public void run() {
					IDebugTarget[] debugTargets = debugTarget.getLaunch().getDebugTargets();
					for (IDebugTarget current : debugTargets) {
						if (current instanceof IStep) {
							try {
								((IStep) current).stepOver();
							} catch (DebugException e) {
								e.printStackTrace();
							}
						}
					}
				}
			});
		}

		@Override
		public boolean isEnabled() {
			return debugTarget != null && (debugTarget instanceof IStep && ((IStep) debugTarget).canStepOver());
		}
	}

	protected class TerminateAction extends TerminateCommandAction implements IAction {
		@Override
		public void run() {
			Display.getDefault().asyncExec(new Runnable() {

				@Override
				public void run() {
					try {
						IDebugTarget[] debugTargets = debugTarget.getLaunch().getDebugTargets();
						for (IDebugTarget current : debugTargets) {
							current.terminate();
						}
					} catch (DebugException e) {
						e.printStackTrace();
					}
				}
			});
		}

		@Override
		public boolean isEnabled() {
			return debugTarget != null && debugTarget.canTerminate();
		}
	}

	protected class SuspendAction extends SuspendCommandAction implements IAction {
		@Override
		public void run() {
			Display.getDefault().asyncExec(new Runnable() {

				@Override
				public void run() {
					try {
						IDebugTarget[] debugTargets = debugTarget.getLaunch().getDebugTargets();
						for (IDebugTarget current : debugTargets) {
							current.suspend();
						}
					} catch (DebugException e) {
						e.printStackTrace();
					}
				}
			});
		}

		@Override
		public boolean isEnabled() {
			return debugTarget != null && debugTarget.canSuspend();
		}
	}

	protected class ResumeAction extends ResumeCommandAction implements IAction {
		@Override
		public void run() {
			Display.getDefault().asyncExec(new Runnable() {

				@Override
				public void run() {
					try {
						IDebugTarget[] debugTargets = debugTarget.getLaunch().getDebugTargets();
						for (IDebugTarget current : debugTargets) {
							current.resume();
						}
					} catch (DebugException e) {
						e.printStackTrace();
					}
				}
			});
		}

		@Override
		public boolean isEnabled() {
			return debugTarget != null && debugTarget.canResume();
		}
	}

	protected class ViewerRefresher implements Runnable {

		private static final long UPDATE_INTERVAL = 500;
		private boolean cancel = false;

		@Override
		public void run() {
			while (!cancel) {
				try {
					Thread.sleep(UPDATE_INTERVAL);
					Display.getDefault().asyncExec(() -> {
						if (viewer != null && !viewer.getControl().isDisposed()
								&& ((ExecutionContextContentProvider) viewer.getContentProvider()).isShouldUpdate()) {
							viewer.refresh();
						}

						if (timeLabel != null && !timeLabel.isDisposed() && timeScheduler != null && debugTarget != null
								&& !debugTarget.isTerminated() && timeLabel != null && !timeLabel.isDisposed()) {
							updateTimestamp(timeScheduler.getCurrentTime());
						} else {
							if (timeIconLabel != null && !timeIconLabel.isDisposed() && timeIconLabel.isVisible())
								updateTimestamp(0);
						}
					});
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		protected void updateTimestamp(long timestamp) {
			String formatDurationHMS = DurationFormatUtils.formatDuration(timestamp,
					(timestamp == 0 ? "--:--:--.---" : "HH:mm:ss.SSS"), true);
			timeLabel.setText(formatDurationHMS);
			timeLabel.setFont(font);
			String time = getReadableSimulationTime(timestamp);
			boolean isValidTime = time != null || (time != null && !time.isEmpty()) || timestamp != 0;
			timeIconLabel.setVisible(isValidTime);
			if (isValidTime) {
				timeLabel.setToolTipText("Simulation running since " + time);
				// layout all time-relevant components
				timeLabel.getParent().getParent().layout();
			}
		}

		protected String getReadableSimulationTime(long timestamp) {
			long days = TimeUnit.MILLISECONDS.toDays(timestamp);
			long hours = TimeUnit.MILLISECONDS.toHours(timestamp);
			long minutes = TimeUnit.MILLISECONDS.toMinutes(timestamp);
			long seconds = TimeUnit.MILLISECONDS.toSeconds(timestamp);
			return DurationFormatUtils
					.formatDuration(timestamp,
							(days > 0 ? "dd 'days '" : "") + (hours > 0 ? "HH 'hours '" : "")
									+ (minutes > 0 ? "mm 'minutes '" : "") + (seconds > 0 ? "ss 'seconds '" : ""),
							false);
		}

		public boolean isCancel() {
			return cancel;
		}

		public void setCancel(boolean cancel) {
			this.cancel = cancel;
		}
	}
}
