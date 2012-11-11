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

import org.yakindu.sct.model.sexec.ExecutionRegion;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sgraph.RegularState;
import org.yakindu.sct.simulation.core.runtime.impl.ExecutionEvent;
import org.yakindu.sct.simulation.core.runtime.impl.ExecutionVariable;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * @author axel terfloth - extensions and refactorings
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
	 * @deprecated Event scheduling is not responsibility of the execution context. It should be done by the execution container.
	 * @return
	 */
	public List<ExecutionEvent> getScheduledEvents();

	/**
	 * Clears the collection of raised events
	 * 
	 * @deprecated this method is not appropriate for event life cycle handling. 
	 */
	public void resetRaisedEvents();


	/** 
	 * @deprecated Unsetting events should be performed on the ExectionEvent instances.
	 * @param eventName
	 */
	public void unraiseEvent(String eventName);


	/**
	 * @deprecated Event scheduling is not responsibility of the execution context. It should be done by the execution container.
	 */
	public void flush();

	/**
	 * Schedules an event with an value that can be null
	 * 
	 * @deprecated Event scheduling is not responsibility of the execution context. It should be done by the execution container.
	 * @throws ExecutionException
	 *             if the value is incompatible with the declared event type or
	 *             the Event can not be found
	 */
	public void scheduleEvent(String name, Object value) throws ExecutionException;

	
	/**
	 * Immediately raises an event with an optional value.
	 * 
	 * @deprecated Should be done on the ExecutionEvent instances
	 * 
	 * @param name
	 * @param value
	 * @throws ExecutionException
	 */
	public void raiseEvent(String name, Object value) throws ExecutionException;

	/**
	 * Returns true if the given event is currently raised, false otherwise
	 * 
	 *  @deprecated Should be done on the ExecutionEvent instances
	 */
	public boolean isEventRaised(String eventName);

	/**
	 * @deprecated Event scheduling is not responsibility of the execution context. It should be done by the execution container.
	 * @param name
	 * @return
	 */
	public boolean isEventScheduled(String name);

	
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
	 * Changes the value of a variable / event
	 * 
	 * @deprecated will be removed ...
	 */
	public void setSlotValue(String name, Object value)
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

	/**
	 * 
	 * @param region
	 * @return
	 */
	public ExecutionState getHistoryStateConfiguration(ExecutionRegion region);

	public void saveHistoryStateConfiguration(ExecutionRegion region);

	public abstract IEventSlot getDeclaredEvent(String eventName);

	/**
	 * @deprecated
	 * 
	 * @param eventName
	 */
	public void unscheduleEvent(String eventName);

}
