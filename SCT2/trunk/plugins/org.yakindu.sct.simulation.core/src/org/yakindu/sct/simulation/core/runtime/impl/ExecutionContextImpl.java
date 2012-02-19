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
package org.yakindu.sct.simulation.core.runtime.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.yakindu.sct.model.sexec.ExecutionRegion;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sgraph.RegularState;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.simulation.core.runtime.ExecutionException;
import org.yakindu.sct.simulation.core.runtime.IExecutionContext;
import org.yakindu.sct.simulation.core.runtime.timer.VirtualClock;

import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ExecutionContextImpl extends AbstractExecutionContext implements
		IExecutionContext {

	private List<ExecutionVariable> variables;
	private List<ExecutionEvent> declaredEvents;
	private List<ExecutionEvent> raisedEvents;
	private ExecutionState[] activeStateConfig;
	private Map<Integer, ExecutionState> historyStateConfig;
	private double timeScaleFactor;
	private VirtualClock virtualClock;

	public ExecutionContextImpl() {
		variables = new ArrayList<ExecutionVariable>();
		declaredEvents = new ArrayList<ExecutionEvent>();
		raisedEvents = new ArrayList<ExecutionEvent>();
		timeScaleFactor = 1.0d;
		virtualClock = new VirtualClock();
		activeStateConfig = null;
		historyStateConfig = null;
	}

	public List<ExecutionEvent> getDeclaredEvents() {
		synchronized (declaredEvents) {
			return Collections.unmodifiableList(declaredEvents);
		}
	}

	public void declareEvent(ExecutionEvent event) {
		synchronized (declaredEvents) {
			declaredEvents.add(event);
		}
	}

	public List<ExecutionEvent> getRaisedEvents() {
		return Collections.unmodifiableList(raisedEvents);
	}

	public void resetRaisedEvents() {
		synchronized (raisedEvents) {
			raisedEvents.clear();
		}
	}

	public void raiseEvent(String eventName, Object value) {
		synchronized (raisedEvents) {
			ExecutionEvent event = getDeclaredEvent(eventName);
			if (event == null)
				throw new ExecutionException("Event with name " + eventName
						+ " is undefined!");
			ExecutionEvent eventCopy = event.getCopy();
			if (value != null) {
				eventCopy.setValue(value);
			}
			raisedEvents.add(eventCopy);
			notifyEventRaised(eventCopy);
		}
	}

	private ExecutionEvent getDeclaredEvent(String eventName) {
		synchronized (declaredEvents) {
			for (ExecutionEvent event : declaredEvents) {
				if (event.getName().equals(eventName))
					return event;
			}
		}
		return null;
	}

	public boolean isEventRaised(String eventName) {
		synchronized (raisedEvents) {
			for (ExecutionEvent event : raisedEvents) {
				if (eventName.equals(event.getName())) {
					return true;
				}
			}
		}
		return false;
	}

	public List<ExecutionVariable> getVariables() {
		return Collections.unmodifiableList(variables);
	}

	public ExecutionVariable getVariable(String varName) {
		synchronized (variables) {
			for (ExecutionVariable variable : variables) {
				if (varName.equals(variable.getName())) {
					return variable;
				}
			}
		}
		return null;
	}

	public void declareVariable(ExecutionVariable variable) {
		synchronized (variables) {
			variables.add(variable);
		}
	}

	public void setVariableValue(String name, Object value)
			throws ExecutionException {
		ExecutionVariable variable = getVariable(name);
		if (variable == null)
			throw new ExecutionException("Variable with name " + name
					+ " is undefined!");
		variable.setValue(value);
		notifyVariableValueChanged(variable);

	}

	public ExecutionState[] getStateConfiguration() {
		return activeStateConfig;
	}

	public ExecutionState getHistoryStateConfiguration(ExecutionRegion region) {
		return historyStateConfig.get(region.getHistoryVector().getOffset());
	}

	public void saveHistoryStateConfiguration(ExecutionRegion region) {
		historyStateConfig.put(region.getHistoryVector().getOffset(),
				getStateConfiguration()[region.getStateVector().getOffset()]);
	}

	public void initStateConfigurationVector(int size) {
		activeStateConfig = new ExecutionState[size];
		for (int i = 0; i < size; i++) {
			activeStateConfig[i] = null;
		}
		historyStateConfig = Maps.newHashMap();
	}

	public void call(String procedureId) {
		// TODO: Implement me
	}

	public Set<RegularState> getActiveLeafStates() {
		Set<RegularState> vertices = new HashSet<RegularState>();
		for (ExecutionState state : activeStateConfig) {
			if (state != null)
				vertices.add((RegularState) state.getSourceElement());
		}
		return vertices;
	}

	public Set<RegularState> getAllActiveStates() {
		Set<RegularState> vertices = new HashSet<RegularState>();
		for (ExecutionState state : activeStateConfig) {
			if (state != null)
				vertices.addAll(getActiveHierachy((RegularState) state
						.getSourceElement()));
		}
		return vertices;
	}

	private Collection<? extends RegularState> getActiveHierachy(
			RegularState vertex) {
		List<RegularState> result = new ArrayList<RegularState>();
		result.add(vertex);
		EObject container = vertex.eContainer();
		while (container != null) {
			if (container instanceof State) {
				result.add((State) container);
			}
			container = container.eContainer();
		}
		return result;
	}

	public double getTimeScaleFactor() {
		return timeScaleFactor;
	}

	public void setTimeScaleFactor(double factor) {
		double oldFactor = timeScaleFactor;
		timeScaleFactor = factor;
		notifyTimeScaleFactorChanged(oldFactor, factor);
	}

	public VirtualClock getVirtualClock() {
		return virtualClock;
	}
}
