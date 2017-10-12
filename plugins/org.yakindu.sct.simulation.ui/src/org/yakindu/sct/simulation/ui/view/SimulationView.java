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

import java.util.HashSet;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.time.DurationFormatUtils;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IStep;
import org.eclipse.debug.internal.ui.commands.actions.ResumeCommandAction;
import org.eclipse.debug.internal.ui.commands.actions.StepOverCommandAction;
import org.eclipse.debug.internal.ui.commands.actions.SuspendCommandAction;
import org.eclipse.debug.internal.ui.commands.actions.TerminateCommandAction;
import org.eclipse.debug.ui.contexts.DebugContextEvent;
import org.eclipse.emf.ecore.EObject;
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
import org.eclipse.swt.widgets.Combo;
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
import com.google.common.collect.Sets;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@SuppressWarnings("restriction")
public class SimulationView extends AbstractDebugTargetView implements ITypeSystemProvider {

	public static final String ID = "org.yakindu.sct.simulation.ui.simulationview"; //$NON-NLS-1$

	private TreeViewer viewer;
	private ViewerRefresher viewerRefresher;
	private FormToolkit kit;
	private Font font;
	private RaiseEventSelectionListener selectionListener;
	private ITypeSystem typeSystem;
	private ITimeTaskScheduler timeScheduler;
	private Label timeSchedulerLabel;
	private TimeSchedulerComponentRefresher timeSchedulerRefresher;
	private ComboViewer sessionDropdown;
	private HashSet<IDebugTarget> targets = Sets.newHashSet();

	public SimulationView() {
		kit = new FormToolkit(Display.getDefault());
		kit.setBorderStyle(SWT.BORDER);
		font = new Font(Display.getDefault(), new FontData("Courier", 10, SWT.BOLD));
	}

	@Override
	public void dispose() {
		selectionListener.dispose();
		font.dispose();
		disposeSessionDropDownComponent();
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
		top.setLayout(new GridLayout());
		createSessionSelectorComponent(top);
		SashForm sashForm = new SashForm(top, SWT.SMOOTH | SWT.VERTICAL);
		sashForm.setLayout(new FillLayout(SWT.VERTICAL));
		sashForm.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		createViewer(sashForm);
		createTimeScheduler(sashForm);
		sashForm.setWeights(new int[]{10, 1});
		hookActions();
		super.createPartControl(parent);
	}

	/**
	 * @param top
	 * @return
	 */
	protected ComboViewer createSessionSelectorComponent(Composite top) {
		Combo combo = new Combo(top, SWT.DROP_DOWN | SWT.READ_ONLY);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		this.sessionDropdown = new ComboViewer(combo);
		this.sessionDropdown.setContentProvider(new ArrayContentProvider());
		this.sessionDropdown.setLabelProvider(new LabelProvider() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
			 */
			@Override
			public String getText(Object element) {
				IDebugTarget target = ((IDebugTarget) element);
				boolean isTerminated = target.isTerminated();
				boolean isSuspended = target.isSuspended();

				if (target.getLaunch().getDebugTarget() != null)
					try {
						return target.getLaunch().getDebugTarget().getName() + " ["
								+ (isTerminated ? "terminated" : isSuspended ? "suspended" : "active") + "]";
					} catch (DebugException e) {
						return "unkown state";
					}
				else
					return "No simulation running";
			}
		});

		this.sessionDropdown.addPostSelectionChangedListener(new SessionSelectionChangedListener());

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

	public Label createTimeScheduler(Composite parent) {
		Composite comp = new Composite(parent, SWT.BORDER);
		comp.setLayout(new GridLayout());
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
			Display.getDefault().asyncExec(() -> {
				this.viewer.setInput(input);
				if (this.viewerRefresher.isCancel())
					this.viewerRefresher.cancel = false;
				if (timeSchedulerRefresher.isCancel())
					this.timeSchedulerRefresher.cancel = false;

				new Thread(viewerRefresher).start();
				new Thread(timeSchedulerRefresher).start();
			});
		}

	}

	protected void handleDebugEvent(DebugEvent debugEvent) {
		updateActions();
		switch (debugEvent.getKind()) {
			case DebugEvent.TERMINATE :
				Display.getDefault().asyncExec(() -> {
					setViewerInput(null);
				});
				break;
			case DebugEvent.SUSPEND :
				break;
			case DebugEvent.RESUME :
				break;
		}
		Display.getDefault().asyncExec(() -> {
			if (debugEvent.getSource() != null) {
				sessionDropdown.update(debugEvent.getSource(), null);
				sessionDropdown.refresh();
				if (((IDebugTarget) debugEvent.getSource()).isTerminated())
					targets.remove((IDebugTarget) debugEvent.getSource());
			}
		});
	}

	protected void activeTargetChanged(final IDebugTarget debugTarget) {
		updateTypeSystem(debugTarget);
		ISimulationEngine engine = (ISimulationEngine) debugTarget.getAdapter(ISimulationEngine.class);
		timeScheduler = (DefaultTimeTaskScheduler) engine.getTimeTaskScheduler();
		setViewerInput(engine.getExecutionContext());
		updateActions();
		updateSessionDropdownInput(debugTarget);
	}

	private void updateSessionDropdownInput(final IDebugTarget debugTarget) {
		Display.getDefault().asyncExec(() -> {
			if (debugTarget != null) {
				if (!targets.contains(debugTarget)) {
					targets.add(debugTarget);
					sessionDropdown.setInput(targets);
					sessionDropdown.setSelection(new StructuredSelection(debugTarget), true);
					sessionDropdown.refresh();
				} else {
					sessionDropdown.update(debugTarget, null);
					sessionDropdown.refresh();
				}
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
	 * @author robert rudi - Initial contribution and API
	 *
	 */
	protected final class SessionSelectionChangedListener implements ISelectionChangedListener {
		@Override
		public void selectionChanged(SelectionChangedEvent event) {
			IStructuredSelection selection = (IStructuredSelection) event.getSelection();

			if (!((IDebugTarget) selection.getFirstElement()).isTerminated()) {
				DebugPlugin.getDefault().asyncExec(() -> {
					DebugPlugin.getDefault().fireDebugEventSet(new DebugEvent[]{
							new DebugEvent((IDebugTarget) selection.getFirstElement(), DebugContextEvent.ACTIVATED)});
				});

				setActiveSession();
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

	protected class StepOverAction extends StepOverCommandAction implements IAction {
		@Override
		public void run() {
			Display.getDefault().asyncExec(new Runnable() {

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
						debugTarget.terminate();
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
						debugTarget.suspend();
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
						debugTarget.resume();
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

		private static final int UPDATE_INTERVAL = 500;
		private boolean cancel = false;

		@Override
		public void run() {
			while (!cancel && viewer.getInput() != null) {
				try {
					Thread.sleep(UPDATE_INTERVAL);
					Display.getDefault().asyncExec(() -> {
						if (viewer != null && !viewer.getControl().isDisposed()
								&& ((ExecutionContextContentProvider) viewer.getContentProvider()).isShouldUpdate()) {
							viewer.refresh();
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
					Display.getDefault().asyncExec(() -> {
						if (timeSchedulerLabel != null && !timeSchedulerLabel.isDisposed()) {
							updateTimestamp(timeScheduler.getCurrentTime());
						}
					});
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		protected void updateTimestamp(long timestamp) {
			String formatDurationHMS = DurationFormatUtils.formatDuration(timestamp, "HH:mm:ss.SSS", true);
			timeSchedulerLabel.setText("Simulation time: " + formatDurationHMS);
			String time = getSimulationTimeWithoutPaddedZeros(timestamp);
			timeSchedulerLabel.setToolTipText("Simulation running since " + time);
			timeSchedulerLabel.update();
		}

		/**
		 * @param timestamp
		 * @return
		 */
		private String getSimulationTimeWithoutPaddedZeros(long timestamp) {
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
