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

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IDebugEventSetListener;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IToolBarManager;
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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.sct.domain.extension.DomainRegistry;
import org.yakindu.sct.domain.extension.IDomain;
import org.yakindu.sct.simulation.core.engine.ISimulationEngine;
import org.yakindu.sct.simulation.core.sruntime.ExecutionEvent;
import org.yakindu.sct.simulation.ui.view.actions.CollapseAllAction;
import org.yakindu.sct.simulation.ui.view.actions.DebugActions;
import org.yakindu.sct.simulation.ui.view.actions.ExpandAllAction;
import org.yakindu.sct.simulation.ui.view.actions.HideTimeEventsAction;
import org.yakindu.sct.simulation.ui.view.editing.ScopeSlotEditingSupport.ITypeSystemProvider;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SimulationView extends AbstractDebugTargetView implements ITypeSystemProvider, IDebugEventSetListener {

	private TreeViewer viewer;
	private FormToolkit kit;
	private Font font;
	private RaiseEventSelectionListener selectionListener;
	private ITypeSystem typeSystem;

	private static enum DebugAction {
		RESUME(0), SUSPEND(1), TERMINATE(2), DISCONNECT(3), STEPINTO(4), STEPOVER(5), STEPRETURN(6);

		int value = 0;

		DebugAction(int val) {
			this.value = val;
		}
	}

	private IAction[] actions = new IAction[DebugAction.values().length];

	public SimulationView() {
		kit = new FormToolkit(Display.getDefault());
		kit.setBorderStyle(SWT.BORDER);
		font = new Font(Display.getDefault(), new FontData("Courier", 10, SWT.BOLD));

	}

	@Override
	public void dispose() {
		selectionListener.dispose();
		font.dispose();
		super.dispose();
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new FillLayout(SWT.VERTICAL));
		Composite top = kit.createComposite(parent);
		top.setLayout(new FillLayout(SWT.VERTICAL));
		createViewer(top);
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
		DebugPlugin.getDefault().addDebugEventListener(this);
		return viewer;
	}

	protected void handleDebugEvent(DebugEvent debugEvent) {
		switch (debugEvent.getKind()) {
			case DebugEvent.TERMINATE :
				Display.getDefault().asyncExec(new Runnable() {
					public void run() {
						viewer.setInput(null);
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
		updateActions(debugTarget);
		ISimulationEngine engine = (ISimulationEngine) debugTarget.getAdapter(ISimulationEngine.class);
		viewer.setInput(engine.getExecutionContext());
		(new ExpandAllAction(viewer)).run();
	}

	private void updateActions(IDebugTarget debugTarget) {
		if (debugTarget != null) {
			actions[DebugAction.RESUME.value].setEnabled(debugTarget.isSuspended() && debugTarget.canResume());
			actions[DebugAction.SUSPEND.value].setEnabled(debugTarget.canSuspend() && !debugTarget.isSuspended());
			actions[DebugAction.TERMINATE.value].setEnabled(!debugTarget.isTerminated());
			actions[DebugAction.DISCONNECT.value].setEnabled(debugTarget.canDisconnect() && !debugTarget.isDisconnected());
			try {
				for (IThread thread : debugTarget.getThreads()) {
						actions[DebugAction.STEPINTO.value].setEnabled(thread.canStepInto());				
						actions[DebugAction.STEPOVER.value].setEnabled(thread.canStepOver() && thread.isStepping());
						actions[DebugAction.STEPRETURN.value].setEnabled(thread.canStepReturn());		
				}
			} catch (DebugException e) {
				e.printStackTrace();
			}

		}

	}

	private void updateTypeSystem(final IDebugTarget debugTarget) {
		IDomain domain = DomainRegistry.getDomain((EObject) debugTarget.getAdapter(EObject.class));
		typeSystem = domain.getInjector(IDomain.FEATURE_SIMULATION).getInstance(ITypeSystem.class);
	}

	protected void hookActions() {
		IToolBarManager mgr = getViewSite().getActionBars().getToolBarManager();

		mgr.add(createResumeAction());
		mgr.add(createSuspendAction());
		mgr.add(createTerminateAction());
		mgr.add(createDisconnectAction());
		mgr.add(createStepIntoAction());
		mgr.add(createStepOverAction());
		mgr.add(createStepReturnAction());
		
		updateActions(debugTarget);
		IAction collapse = new CollapseAllAction(viewer);
		mgr.add(collapse);
		IAction expand = new ExpandAllAction(viewer);
		mgr.add(expand);
		IAction hideTimeEvent = new HideTimeEventsAction(false);
		mgr.add(hideTimeEvent);
	}

	private IAction createStepReturnAction() {
		return actions[DebugAction.STEPRETURN.value] = new DebugActions.StepReturn() {
			@Override
			public void run() {
				try {
					if (debugTarget != null && debugTarget.getThreads() != null) {
						Display.getCurrent().asyncExec(new Runnable() {
							@Override
							public void run() {
								try {
									for (IThread thread : debugTarget.getThreads()) {
										if (thread.canStepReturn()) {
											thread.stepReturn();
										}
									}
								} catch (DebugException e) {
									e.printStackTrace();
								}
							}
						});
					}
				} catch (DebugException e) {
					e.printStackTrace();
				}
			}
		};
	}

	private IAction createStepOverAction() {
		return actions[DebugAction.STEPOVER.value] = new DebugActions.StepOver() {
			@Override
			public void run() {
				try {
					if (debugTarget != null && debugTarget.getThreads() != null) {
						Display.getCurrent().asyncExec(new Runnable() {
							@Override
							public void run() {
								try {
									if (debugTarget.hasThreads())
										for (IThread thread : debugTarget.getThreads()) {
											if (thread.canStepOver()) {
												thread.stepOver();
											}
										}
								} catch (DebugException e) {
									e.printStackTrace();
								}
							}
						});
					}
				} catch (DebugException e) {
					e.printStackTrace();
				}
			}
		};
	}

	private IAction createStepIntoAction() {
		return actions[DebugAction.STEPINTO.value] = new DebugActions.StepInto() {
			@Override
			public void run() {
				try {
					if (debugTarget != null && debugTarget.getThreads() != null) {
						Display.getCurrent().asyncExec(new Runnable() {
							@Override
							public void run() {
								try {
									for (IThread thread : debugTarget.getThreads()) {
										if (thread.canStepInto()) {
											thread.stepInto();
										}
									}
								} catch (DebugException e) {
									e.printStackTrace();
								}
							}
						});
					}
				} catch (DebugException e) {
					e.printStackTrace();
				}
			}
		};
	}

	private IAction createDisconnectAction() {
		return actions[DebugAction.DISCONNECT.value] = new DebugActions.Disconnect() {
			@Override
			public void run() {
				if (debugTarget != null && debugTarget.canDisconnect()) {
					Display.getCurrent().asyncExec(new Runnable() {
						@Override
						public void run() {
							try {
								debugTarget.disconnect();
							} catch (DebugException e) {
								e.printStackTrace();
							}
						}
					});
				}
			}
		};
	}

	private IAction createTerminateAction() {
		return actions[DebugAction.TERMINATE.value] = new DebugActions.Terminate() {

			@Override
			public void run() {
				if (debugTarget != null && debugTarget.canTerminate()) {
					Display.getCurrent().asyncExec(new Runnable() {
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
			}
		};
	}

	private IAction createSuspendAction() {
		return actions[DebugAction.SUSPEND.value] = new DebugActions.Suspend() {
			@Override
			public void run() {
				if (debugTarget != null && debugTarget.canSuspend()) {
					Display.getCurrent().asyncExec(new Runnable() {
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
			}
		};
	}

	private IAction createResumeAction() {
		return actions[DebugAction.RESUME.value] = new DebugActions.Resume() {
			@Override
			public void run() {

				if (debugTarget != null && debugTarget.canResume()) {
					Display.getCurrent().asyncExec(new Runnable() {
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
			}
		};
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
}
