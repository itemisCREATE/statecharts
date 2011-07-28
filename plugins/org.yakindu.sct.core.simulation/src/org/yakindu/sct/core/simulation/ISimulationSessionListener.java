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
package org.yakindu.sct.core.simulation;

import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public interface ISimulationSessionListener extends ISGraphExecutionListener {

	public static enum SimulationState {
		STARTED, RUNNING, SINGLESTEP, PAUSED, TERMINATED
	}
	

	public void simulationStateChanged(SimulationState oldState,
			SimulationState newState);

	/**
	 * Null implementation
	 * 
	 */
	public static class SimulationSessionListenerAdapter implements
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

		@Override
		public void variableValueChanged(String variableName, Object value) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void eventRaised(String eventName) {
			// TODO Auto-generated method stub
			
		}
	}
}
