package org.yakindu.sct.core.simulation;

import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;

/**
 * 
 * @author andreas muelder
 * 
 */
public interface ISimulationSessionListener extends ISGraphExecutionListener {

	public static enum SimulationState {
		STARTED, RUNNING, SINGLESTEP, PAUSED, TERMINATED
	}

	public void simulationStateChanged(SimulationState oldState,
			SimulationState newState);

	/**
	 * Empty implementation
	 * 
	 */
	public static class ISimulationSessionListenerAdapter implements
			ISimulationSessionListener {

		@Override
		public void stateEntered(Vertex vertex) {
		}

		@Override
		public void stateLeft(Vertex vertex) {
		}

		@Override
		public void transitionFired(Transition transition) {
		}

		@Override
		public void simulationStateChanged(SimulationState oldState,
				SimulationState newState) {
		}
	}
}
