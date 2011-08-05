package org.yakindu.sct.simulation.runtime.sgraph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.yakindu.sct.simulation.core.ISGraphExecutionScope;
import org.yakindu.sct.simulation.core.ISGraphExecutionScope.ScopeSlot;
import org.yakindu.sct.simulation.runtime.ExecutionScope;
import org.yakindu.sct.simulation.runtime.stext.RTVariable;

/**
 * Adapts the {@link ISGraphExecutionScope} interface to the runtime
 * {@link ExecutionScope}
 * 
 */
public class ExecutionScopeAdapter implements ISGraphExecutionScope {

	private final ExecutionScope scope;

	public ExecutionScopeAdapter(ExecutionScope scope) {
		this.scope = scope;
	}

	public ScopeSlot getVariable(String varName) {
		return toScope(scope.getVariable(varName));
	}

	public List<ScopeVariable> getVariables() {
		List<ScopeVariable> scopeVariables = new ArrayList<ScopeVariable>();
		Collection<RTVariable> variables = scope.getVariables();
		for (RTVariable rtVariable : variables) {
			scopeVariables.add(toScope(rtVariable));
		}
		return scopeVariables;
	}

	private ScopeVariable toScope(RTVariable rtVariable) {
		return new ScopeVariable(rtVariable.getName(), rtVariable.getType(),
				rtVariable.getValue());
	}

	public void setSlotValue(ScopeSlot variable, Object object) {
		RTVariable rtVar = scope.getVariable(variable.getName());
		scope.setVariableValue(rtVar, object);

	}

	public void createVariable(String varName, Object value, Class<?> type) {
		RTVariable var = new RTVariable(varName);
		var.setValue(value);
		scope.addVariable(var);

	}

	public void call(String procedureId) {
		// TODO
	}

	public void raise(String signal) {
		scope.raise(signal, null);
	}

	public List<ScopeEvent> getEvents() {

		List<ScopeEvent> scopeEvents = new ArrayList<ScopeEvent>();
		Collection<RTSignalEvent> events = scope.getEvents();
		for (RTSignalEvent rtEvent : events) {
			scopeEvents.add(toScope(rtEvent));
		}
		return scopeEvents;
	}

	
	private ScopeEvent toScope(RTSignalEvent rtEvent) {
		return new ScopeEvent(rtEvent.getId(), rtEvent.getType(), rtEvent.getValue());
	}

	
	public void raise(ScopeEvent event) {
		raise(event.getName());	
	}
	
}
