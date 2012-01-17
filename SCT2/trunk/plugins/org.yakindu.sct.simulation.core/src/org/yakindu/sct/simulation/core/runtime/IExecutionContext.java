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
package org.yakindu.sct.simulation.core.runtime;

import java.util.List;
import java.util.Set;

import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sgraph.RegularState;
import org.yakindu.sct.simulation.core.runtime.impl.ExecutionEvent;
import org.yakindu.sct.simulation.core.runtime.impl.ExecutionVariable;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public interface IExecutionContext {

	/**
	 * returns a readonly (!) List with all declared events
	 */
	public List<ExecutionEvent> getDeclaredEvents();

	/**
	 * Declares a new Event that can be raised
	 */
	public void declareEvent(ExecutionEvent event);

	/**
	 * Returns a readonly (!) List with all currently raised events
	 */
	public List<ExecutionEvent> getRaisedEvents();

	/**
	 * Clears the collection of raised events
	 */
	public void resetRaisedEvents();

	/**
	 * Raises an event with an value, can be null
	 * 
	 * @throws ExecutionException
	 *             if the value is incompatible with the declared event type or
	 *             the Event can not be found
	 */
	public void raiseEvent(String name, Object value) throws ExecutionException;

	/**
	 * Returns true if the given event is currently raised, false otherwise
	 */
	public boolean isEventRaised(String eventName);

	/**
	 * Returns a readonly (!) List of all variables
	 */
	public List<ExecutionVariable> getVariables();

	/**
	 * Declares a new Variable
	 */
	public void declareVariable(ExecutionVariable variable);

	/**
	 * Returns a {@link ExecutionVariable} by name, might be null
	 */
	public ExecutionVariable getVariable(String varName);

	/**
	 * Changes the value of a variable
	 */
	public void setVariableValue(String name, Object value)
			throws ExecutionException;

	/**
	 * Returns a Set with all currently active states
	 */
	public Set<RegularState> getActiveLeafStates();

	/**
	 * Returns a set with all active leaf states including parents
	 */
	public Set<RegularState> getAllActiveStates();

	/**
	 * Returns the active state configuration
	 */
	public ExecutionState[] getStateConfiguration();

	public void initStateConfigurationVector(int size);

	/**
	 * Calls a declared operation
	 */
	public void call(String procedureId);

	/**
	 * Registeres a new {@link IExecutionContextListener}
	 */
	public void addExecutionContextListener(IExecutionContextListener listener);

	/**
	 * removes a given {@link IExecutionContextListener}
	 */
	public void removeExecutionContextListener(
			IExecutionContextListener listener);

	public double getTimeScaleFactor();

	public void setTimeScaleFactor(double factor);
}
