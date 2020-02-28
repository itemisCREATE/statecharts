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
import org.eclipse.debug.internal.ui.sourcelookup.SourceLookupManager;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.actions.DebugCommandAction;
import org.eclipse.debug.ui.contexts.DebugContextEvent;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.ControlContribution;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IContributionManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.sct.domain.extension.DomainRegistry;
import org.yakindu.sct.domain.extension.IDomain;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sruntime.ExecutionEvent;
import org.yakindu.sct.simulation.core.debugmodel.SCTDebugTarget;
import org.yakindu.sct.simulation.core.engine.ISimulationEngine;
import org.yakindu.sct.simulation.ui.view.actions.CollapseAllAction;
import org.yakindu.sct.simulation.ui.view.actions.ExpandAllAction;
import org.yakindu.sct.simulation.ui.view.actions.HideTimeEventsAction;
import org.yakindu.sct.simulation.ui.view.editing.ScopeSlotEditingSupport.ITypeSystemProvider;
import org.yakindu.sct.ui.editor.partitioning.DiagramPartitioningUtil;

import com.google.common.collect.Lists;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@SuppressWarnings("restriction")
public class SimulationView extends AbstractDebugTargetView implements ITypeSystemProvider {

	public static final String ID = "org.yakindu.sct.simulation.ui.declarationview"; //$NON-NLS-1$

	private TreeViewer executionContextViewer;
	private TreeViewer simulationSessionViewer;
	private Clock clock;

	private ViewerRefresher viewerRefresher;
	private FormToolkit kit;
	private RaiseEventSelectionListener selectionListener;
	private ITypeSystem typeSystem;

	private ISelectionChangedListener selectionChangedListener;

	public SimulationView() {
		kit = new FormToolkit(Display.getDefault());
		kit.setBorderStyle(SWT.BORDER);
	}

	@Override
	public void dispose() {
		selectionListener.dispose();
		disposeViewerRefresher();
		super.dispose();
	}

	protected void disposeViewerRefresher() {
		if (viewerRefresher != null) {
			viewerRefresher.cancel = true;
			viewerRefresher = null;
		}
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new FillLayout(SWT.VERTICAL));
		Composite top = kit.createComposite(parent);
		top.setLayout(new GridLayout(2, false));
		SashForm sash = new SashForm(top, SWT.VERTICAL | SWT.SMOOTH);
		sash.setSashWidth(2);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(sash);
		createSimulationSessionViewer(sash);
		createExecutionContextViewer(sash);
		sash.setWeights(new int[] { 1, 5 });
		IToolBarManager mgr = getViewSite().getActionBars().getToolBarManager();
		addSimulationSessionActions(mgr);
		super.createPartControl(parent);
	}

	@Override
	public void setFocus() {
		executionContextViewer.getTree().setFocus();
	}

	protected void createSimulationSessionViewer(Composite parent) {
		simulationSessionViewer = SimulationSessionViewerFactory.createViewer(parent);
		selectionChangedListener = new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				Object selection = ((StructuredSelection) event.getSelection()).getFirstElement();
				if (selection instanceof IDebugTarget)
					changeTarget((IDebugTarget) selection);
				else if (selection instanceof ILaunch)
					changeTarget(((ILaunch) selection).getDebugTarget());
				SourceLookupManager.getDefault().displaySource(selection, getSite().getPage(), true);
			}
		};
		simulationSessionViewer.addSelectionChangedListener(selectionChangedListener);

		MenuManager contextMenu = new MenuManager();
		addSimulationSessionActions(contextMenu);
		Menu menu = contextMenu.createContextMenu(simulationSessionViewer.getControl());
		simulationSessionViewer.getControl().setMenu(menu);
	}

	protected void createExecutionContextViewer(Composite parent) {
		Composite contextViewerComposite = kit.createComposite(parent);
		contextViewerComposite.setLayout(new GridLayout(1, false));
		ToolBar toolBar = new ToolBar(contextViewerComposite, SWT.FLAT | SWT.WRAP | SWT.RIGHT);
		GridDataFactory.fillDefaults().align(SWT.END, SWT.FILL).grab(true, false).applyTo(toolBar);
		executionContextViewer = ExecutionContextViewerFactory.createViewer(contextViewerComposite, false, this);
		selectionListener = new RaiseEventSelectionListener(executionContextViewer);
		final ToolBarManager manager = new ToolBarManager(toolBar);
		manager.add(new ControlContribution("clock") {
			@Override
			protected Control createControl(Composite parent) {
				if (clock == null)
					clock = new Clock(parent);
				return clock;
			}
		});
		manager.add(new Separator());
		manager.add(new ActionContributionItem(new ExpandAllAction(executionContextViewer)));
		manager.add(new ActionContributionItem(new CollapseAllAction(executionContextViewer)));
		manager.add(new ActionContributionItem(new HideTimeEventsAction(false)));
		manager.update(true);
		toolBar.pack();
	}

	@Override
	public void launchChanged(ILaunch launch) {
		sessionViewerInputChanged(launch);
		super.launchChanged(launch);

	}

	private void sessionViewerInputChanged(ILaunch changedLaunch) {
		ILaunch[] launches = DebugPlugin.getDefault().getLaunchManager().getLaunches();
		List<ILaunch> activeLaunches = Lists.newArrayList();
		for (ILaunch iLaunch : launches) {
			if (!iLaunch.isTerminated()) {
				activeLaunches.add(iLaunch);
			}
		}
		Display.getDefault().asyncExec(() -> {
			try {
				simulationSessionViewer.removeSelectionChangedListener(selectionChangedListener);
				;
				simulationSessionViewer.setInput(activeLaunches.toArray());
				simulationSessionViewer.expandAll();
			} finally {
				simulationSessionViewer.addSelectionChangedListener(selectionChangedListener);
				if (changedLaunch != null)
					simulationSessionViewer.setSelection(new StructuredSelection(changedLaunch));
			}
		});
	}

	protected void setExecutionContextInput(Object input) {
		if (viewerRefresher == null)
			this.viewerRefresher = new ViewerRefresher();

		Display.getDefault().asyncExec(() -> {
			if (input == null) {
				viewerRefresher.cancel = true;
			} else {
				if (this.viewerRefresher.isCancel()) {
					this.viewerRefresher.cancel = false;
					new Thread(viewerRefresher).start();
				}
			}
			this.executionContextViewer.setInput(input);
			this.executionContextViewer.expandToLevel(2);
		});
	}

	@Override
	protected void handleDebugEvent(DebugEvent debugEvent) {
		updateActions();
		switch (debugEvent.getKind()) {
		case DebugEvent.TERMINATE:
			setExecutionContextInput(null);
			Display.getDefault().asyncExec(() -> {
				sessionViewerInputChanged(null);
				if (clock != null && !clock.isDisposed()) {
					clock.updateTimestamp(0);
				}
			});
			break;
		case DebugEvent.SUSPEND:
			Display.getDefault().asyncExec(() -> {
				simulationSessionViewer.refresh();
			});
			break;
		case DebugEvent.RESUME:
			Display.getDefault().asyncExec(() -> {
				simulationSessionViewer.refresh();
			});
			break;
		}
	}

	@Override
	public void debugContextChanged(DebugContextEvent event) {
	}

	@Override
	protected void activeTargetChanged(final IDebugTarget debugTarget) {
		openEditorForTarget(debugTarget);
		updateTypeSystem(debugTarget);
		ISimulationEngine engine = debugTarget.getAdapter(ISimulationEngine.class);
		setExecutionContextInput(engine.getExecutionContext());
		updateActions();
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

	protected void addSimulationSessionActions(IContributionManager mgr) {
		addActions(mgr, Lists.newArrayList(new ResumeAction(), new SuspendAction(), new StepOverAction()));
		addActions(mgr, Lists.newArrayList(new TerminateAction(), new TerminateAndRelaunch()));
		addActions(mgr, Lists.newArrayList(new RestartAction()));
		mgr.update(true);
	}

	protected void addActions(IContributionManager mgr, ArrayList<DebugCommandAction> actions) {
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
					ILaunchConfiguration launchConfiguration = debugTarget.getLaunch().getLaunchConfiguration();
					DebugUITools.launch(launchConfiguration, debugTarget.getLaunch().getLaunchMode());
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
						} catch (CoreException e) {
							e.printStackTrace();
						}
					}
					ILaunchConfiguration launchConfiguration = debugTarget.getLaunch().getLaunchConfiguration();
					DebugUITools.launch(launchConfiguration, debugTarget.getLaunch().getLaunchMode());
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

		private static final long UPDATE_INTERVAL = 100;
		private boolean cancel = false;

		@Override
		public void run() {
			while (!cancel) {
				try {
					Thread.sleep(UPDATE_INTERVAL);
					Display.getDefault().asyncExec(() -> {
						if (executionContextViewer != null && !executionContextViewer.getControl().isDisposed()
								&& ((ExecutionContextContentProvider) executionContextViewer.getContentProvider())
										.isShouldUpdate()) {
							executionContextViewer.refresh();
							if (clock != null && !clock.isDisposed() && debugTarget != null
									&& !debugTarget.isTerminated()) {
								ISimulationEngine engine = debugTarget.getLaunch().getDebugTarget()
										.getAdapter(ISimulationEngine.class);
								clock.updateTimestamp(engine.getTimeTaskScheduler().getCurrentTime());
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
}
