/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.simulation.core.session;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.yakindu.sct.model.sgraph.CompositeElement;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.simulation.core.runtime.IExecutionContext;
import org.yakindu.sct.simulation.core.runtime.IExecutionFacade;
import org.yakindu.sct.simulation.core.runtime.impl.ExecutionEvent;
import org.yakindu.sct.simulation.core.session.ISimulationSessionListener.SimulationState;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SimulationSession implements Runnable {

	// TODO: Add to launch tab config
	private static final int CYCLE_SLEEP_TIME = 100;

	private List<ISimulationSessionListener> listeners;

	private BlockingQueue<Runnable> taskQueue;

	private SimulationState currentState;

	private final IExecutionFacade facade;

	private Timer timer;

	public SimulationSession(IExecutionFacade facade) {
		this.facade = facade;
		listeners = new ArrayList<ISimulationSessionListener>();
		taskQueue = new LinkedBlockingQueue<Runnable>();
		timer = new Timer();
	}

	public void start() {
		taskQueue.add(new Runnable() {
			public void run() {
				changeSimulationState(SimulationState.STARTED);
				facade.enter();
				changeSimulationState(SimulationState.RUNNING);
				scheduleCycle();
			}
		});
	}

	public void singleStep() {
		taskQueue.add(new Runnable() {
			public void run() {
				changeSimulationState(SimulationState.SINGLESTEP);
			}
		});
	}

	public void resume() {
		taskQueue.add(new Runnable() {
			public void run() {
				changeSimulationState(SimulationState.RUNNING);
				scheduleCycle();
			}
		});
	}

	public void suspend() {
		taskQueue.add(new Runnable() {
			public void run() {
				changeSimulationState(SimulationState.PAUSED);
			}
		});
	}

	public void terminate() {
		taskQueue.add(new Runnable() {
			public void run() {
				changeSimulationState(SimulationState.TERMINATED);
			}
		});
		facade.tearDown();
	}

	public void raiseEvent(final ExecutionEvent event) {
		taskQueue.add(new Runnable() {
			public void run() {
				facade.getExecutionContext().raiseEvent(event.getName(),
						event.getValue());
			}
		});
	}

	protected void scheduleCycle() {
		if (currentState == SimulationState.RUNNING) {
			timer.schedule(new TimerTask() {
				public void run() {
					taskQueue.add(new Runnable() {
						public void run() {
							facade.runCycle();
						}
					});
					scheduleCycle();
				}
			}, CYCLE_SLEEP_TIME);

		}
	}

	public void run() {
		while (!(currentState == SimulationState.TERMINATED)) {
			try {
				Runnable task = taskQueue.take();
				task.run();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	protected void changeSimulationState(SimulationState newState) {
		synchronized (listeners) {
			for (ISimulationSessionListener listener : listeners) {
				listener.simulationStateChanged(this.currentState, newState);
			}
			this.currentState = newState;
		}
	}

	public void addSimulationListener(ISimulationSessionListener listener) {
		synchronized (listeners) {
			listeners.add(listener);
		}
	}

	public void removeSimulationListener(ISimulationSessionListener listener) {
		synchronized (listeners) {
			listeners.remove(listener);
		}
	}

	public IExecutionContext getExecutionContext() {
		return facade.getExecutionContext();
	}

	public SimulationState getCurrentState() {
		return currentState;
	}

	public Set<Vertex> getActiveStates() {
		Set<Vertex> activeStates = new HashSet<Vertex>();
		Set<Vertex> leafStates = facade.getExecutionContext()
				.getActiveLeafStates();
		activeStates.addAll(leafStates);
		for (Vertex vertex : leafStates) {
			CompositeElement composite = vertex.getParentRegion()
					.getComposite();
			while (composite instanceof State) {
				activeStates.add((State) composite);
				composite = ((State) composite).getParentRegion()
						.getComposite();
			}
		}
		return activeStates;
	}

}
