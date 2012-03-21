/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.sexec.interpreter.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.yakindu.sct.model.sexec.ExecutionRegion;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sgraph.RegularState;
import org.yakindu.sct.simulation.core.runtime.ExecutionException;
import org.yakindu.sct.simulation.core.runtime.IExecutionContext;
import org.yakindu.sct.simulation.core.runtime.IExecutionContextListener;
import org.yakindu.sct.simulation.core.runtime.impl.ExecutionContextImpl;
import org.yakindu.sct.simulation.core.runtime.impl.ExecutionEvent;
import org.yakindu.sct.simulation.core.runtime.impl.ExecutionVariable;
import org.yakindu.sct.simulation.core.runtime.timer.VirtualClock;

public class BufferingExecutionContext extends ExecutionContextImpl implements IExecutionContextListener {

	protected IExecutionContext delegate;
	protected boolean delegateNotify = true;

	private HashMap<String, Object> setVariables = new HashMap<String, Object>();

	
	public BufferingExecutionContext(IExecutionContext delegate) {
		this.delegate = delegate;
		delegate.addExecutionContextListener(this);
	}

	public List<ExecutionEvent> getDeclaredEvents() {
		return delegate.getDeclaredEvents();
	}

	public void declareEvent(ExecutionEvent event) {
		delegate.declareEvent(event);
	}


	public void resetRaisedEvents() {
		delegate.resetRaisedEvents();
	}

	
	public ExecutionEvent getDeclaredEvent(String eventName) {
		return delegate.getDeclaredEvent(eventName);
	}

	public boolean isEventRaised(String eventName) {
		return delegate.isEventRaised(eventName);
	}

	public List<ExecutionVariable> getVariables() {
		return delegate.getVariables();
	}

	public void declareVariable(ExecutionVariable variable) {
		delegate.declareVariable(variable);
	}

	public ExecutionVariable getVariable(String varName) {
		return delegate.getVariable(varName);
	}

	public void setVariableValue(String name, Object value)
			throws ExecutionException {
		synchronized (setVariables) {
			setVariables.put(name, value);
		}
	}

	public void flush() {
		synchronized (raisedEvents) {
			delegateNotify = false;
			for (ExecutionEvent event : raisedEvents) {
				delegate.raiseEvent(event.getName(), event.getValue());
			}
			raisedEvents.clear();
			delegateNotify = true;
		}
		synchronized (setVariables) {
			Set<Entry<String, Object>> entrySet = setVariables.entrySet();
			for (Entry<String, Object> entry : entrySet) {
				delegate.setVariableValue(entry.getKey(), entry.getValue());
			}
			setVariables.clear();
		}
	}

	public Set<RegularState> getActiveLeafStates() {
		return delegate.getActiveLeafStates();
	}

	public Set<RegularState> getAllActiveStates() {
		return delegate.getAllActiveStates();
	}

	public ExecutionState[] getStateConfiguration() {
		return delegate.getStateConfiguration();
	}

	public void initStateConfigurationVector(int size) {
		delegate.initStateConfigurationVector(size);
	}

	public void call(String procedureId) {
		delegate.call(procedureId);
	}

	public double getTimeScaleFactor() {
		return delegate.getTimeScaleFactor();
	}

	public void setTimeScaleFactor(double factor) {
		delegate.setTimeScaleFactor(factor);
	}

	public VirtualClock getVirtualClock() {
		return delegate.getVirtualClock();
	}

	public ExecutionState getHistoryStateConfiguration(ExecutionRegion region) {
		return delegate.getHistoryStateConfiguration(region);
	}

	public void saveHistoryStateConfiguration(ExecutionRegion region) {
		delegate.saveHistoryStateConfiguration(region);
	}


	public void eventRaised(ExecutionEvent event) {
		if ( delegateNotify ) {
			notifyEventRaised(event);
		}
	}

	public void variableValueChanged(ExecutionVariable variable) {
		notifyVariableValueChanged(variable);
		
	}

	public void timeScaleFactorChanged(double oldFactor, double newFactor) {
		notifyTimeScaleFactorChanged(oldFactor, newFactor);
	}

	
}
