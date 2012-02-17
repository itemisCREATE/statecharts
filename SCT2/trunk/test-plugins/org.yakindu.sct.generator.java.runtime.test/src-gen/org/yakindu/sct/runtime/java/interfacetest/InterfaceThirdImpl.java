/**
Copyright (c) 2011 committers of YAKINDU and others. 
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html
 
Contributors:
	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.runtime.java.interfacetest;

import java.util.HashMap;
import java.util.Map;
import org.yakindu.sct.runtime.java.Event;
import org.yakindu.sct.runtime.java.NotificationSender;
import org.yakindu.sct.runtime.java.EventNotification;
import org.yakindu.sct.runtime.java.VariableNotification;
import org.yakindu.sct.runtime.java.ValuedEvent;

public class InterfaceThirdImpl extends NotificationSender
		implements
			IInterfaceThirdImpl {
	protected Map<String, Object> variableMap;
	protected Map<String, Event<Events>> outEventMap;
	protected Map<String, Event<Events>> inEventMap;

	protected InterfaceTestCycleBasedStatemachine statemachine;

	public InterfaceThirdImpl(InterfaceTestCycleBasedStatemachine statemachine) {

		this.statemachine = statemachine;
		variableMap = new HashMap<String, Object>();
		variableMap.put("v1", new Double(0D));

		inEventMap = new HashMap<String, Event<Events>>();

		outEventMap = new HashMap<String, Event<Events>>();

		inEventMap.put("event5", new Event<Events>(Events.Event5, 4));
		outEventMap.put("event6", new ValuedEvent<Events, Boolean>(
				Events.Event6, 4, false));
	}

	public void raiseEvent5() {
		statemachine.getOccuredEvents().add(getEventEvent5());
	}

	public Event<Events> getEventEvent5() {
		return inEventMap.get("event5");
	}

	public void raiseEvent6(boolean value) {
		getEventEvent6().setValue(value);
		statemachine.getOccuredEvents().add(getEventEvent6());
		statemachine.getOutEvents().add(getEventEvent6());
		notifyListenersOnEventRaised(new EventNotification(getEventEvent6()));
	}

	@SuppressWarnings("unchecked")
	public ValuedEvent<Events, Boolean> getEventEvent6() {
		return (ValuedEvent<Events, Boolean>) outEventMap.get("event6");
	}

	public boolean isRaisedEvent6() {
		return statemachine.getOutEvents().contains(getEventEvent6());
	}

	public double getVarV1() {
		return (Double) variableMap.get("v1");
	}

	public void setVarV1(double value) {
		double oldValue = getVarV1();
		variableMap.put("v1", new Double(value));
		notifyListenersOnVariableChanged(new VariableNotification<Double>(
				Variables.v1, getVarV1(), oldValue));
	}

	public boolean raiseEvent(String name) {
		if (inEventMap.get(name) != null) {
			return statemachine.getOccuredEvents().add(inEventMap.get(name));
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public boolean raiseEvent(String name, Object value) {
		if (inEventMap.get(name) != null
				&& inEventMap.get(name) instanceof ValuedEvent) {
			ValuedEvent<?, ?> event = (ValuedEvent<?, ?>) inEventMap.get(name);
			if (event.getValue().getClass() == value.getClass()) {
				((ValuedEvent<Events, Object>) event).setValue(value);
				return statemachine.getOccuredEvents()
						.add(inEventMap.get(name));
			}
		}
		return false;
	}

	public boolean setVariable(String name, Object value) {
		if (variableMap.get(name) != null
				&& variableMap.get(name).getClass() == value.getClass()) {
			Object oldValue = variableMap.get(name);
			variableMap.put(name, value);
			notifyListenersOnVariableChanged(new VariableNotification<Object>(
					Variables.valueOf(name), variableMap.get(name), oldValue));
			return true;
		}
		return false;
	}

	public Object getVariable(String name) {
		return variableMap.get(name);
	}
}
