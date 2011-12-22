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
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.simulation.core.runtime.ExecutionException;
import org.yakindu.sct.simulation.core.runtime.IExecutionContext;

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
	private List<ExecutionState> activeStateConfig;

	public ExecutionContextImpl() {
		variables = new ArrayList<ExecutionVariable>();
		declaredEvents = new ArrayList<ExecutionEvent>();
		raisedEvents = new ArrayList<ExecutionEvent>();
		activeStateConfig = new ArrayList<ExecutionState>();
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
		ExecutionEvent event = getDeclaredEvent(eventName);
		if (event == null)
			throw new ExecutionException("Event with name " + eventName
					+ "is undefined!");
		ExecutionEvent eventCopy = event.getCopy();
		if (value != null) {
			eventCopy.setValue(value);
		}
		raisedEvents.add(eventCopy);
		notifyEventRaised(eventCopy);
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

	public List<ExecutionState> getStateConfiguration() {
		return activeStateConfig;
	}

	public void call(String procedureId) {
		// TODO: Implement me
	}

	public Set<Vertex> getActiveLeafStates() {
		Set<Vertex> vertices = new HashSet<Vertex>();
		for (ExecutionState state : activeStateConfig) {
			vertices.add((Vertex) state.getSourceElement());
		}
		return vertices;
	}

	public Set<Vertex> getAllActiveStates() {
		Set<Vertex> vertices = new HashSet<Vertex>();
		for (ExecutionState state : activeStateConfig) {
			vertices.addAll(getActiveHierachy((Vertex) state.getSourceElement()));
		}
		return vertices;
	}

	private Collection<? extends Vertex> getActiveHierachy(Vertex vertex) {
		List<Vertex> result = new ArrayList<Vertex>();
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

}
