package org.yakindu.sct.core.simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.yakindu.sct.core.simulation.ISimulationSessionListener.SimulationState;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;

/**
 * 
 * @author muelder
 * 
 */
public class SGraphSimulationSession implements Runnable,
		ISGraphExecutionListener {

	private List<ISimulationSessionListener> listeners;

	private BlockingQueue<Runnable> taskQueue;

	private SimulationState currentState;
	private final ISGraphExecutionFacade facade;

	private Timer timer;

	public SGraphSimulationSession(ISGraphExecutionFacade facade) {
		this.facade = facade;
		facade.addExecutionListener(this);
		listeners = new ArrayList<ISimulationSessionListener>();
		taskQueue = new LinkedBlockingQueue<Runnable>();
		timer = new Timer();
	}

	public void start() {
		taskQueue.add(new Runnable() {
			@Override
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
			@Override
			public void run() {
				changeSimulationState(SimulationState.SINGLESTEP);
			}
		});
	}

	public void resume() {
		taskQueue.add(new Runnable() {
			@Override
			public void run() {
				changeSimulationState(SimulationState.RUNNING);
				scheduleCycle();
			}
		});
	}

	public void suspend() {
		taskQueue.add(new Runnable() {
			@Override
			public void run() {
				changeSimulationState(SimulationState.PAUSED);
			}
		});
	}

	public void terminate() {
		taskQueue.add(new Runnable() {
			@Override
			public void run() {
				changeSimulationState(SimulationState.TERMINATED);
			}
		});
	}

	public void raiseEvent(final String eventName) {
		taskQueue.add(new Runnable() {
			@Override
			public void run() {
				facade.raise(eventName);
			}
		});
	}

	public void setVariableValue(String variableName, Object value) {

	}

	protected void scheduleCycle() {
		if (currentState == SimulationState.RUNNING) {
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					taskQueue.add(new Runnable() {
						@Override
						public void run() {
							facade.runCycle();
						}
					});
					scheduleCycle();
				}
			}, 100);

		}
	}

	@Override
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
		for (ISimulationSessionListener listener : listeners) {
			listener.simulationStateChanged(this.currentState, newState);
		}
		this.currentState = newState;
	}

	@Override
	public void stateEntered(Vertex vertex) {
		for (ISimulationSessionListener listener : listeners) {
			listener.stateEntered(vertex);
		}
	}

	@Override
	public void stateLeft(Vertex vertex) {
		for (ISimulationSessionListener listener : listeners) {
			listener.stateLeft(vertex);
		}

	}

	@Override
	public void transitionFired(Transition transition) {
		for (ISimulationSessionListener listener : listeners) {
			listener.transitionFired(transition);
		}

	}

	public List<ISimulationSessionListener> getListeners() {
		return listeners;
	}

}
