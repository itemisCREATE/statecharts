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

public class InterfaceOtherImpl extends NotificationSender
		implements
			IInterfaceOtherImpl {
	protected Map<String, Object> variableMap;
	protected Map<String, Event<Events>> outEventMap;
	protected Map<String, Event<Events>> inEventMap;

	protected InterfaceTestCycleBasedStatemachine statemachine;

	public InterfaceOtherImpl(InterfaceTestCycleBasedStatemachine statemachine) {

		this.statemachine = statemachine;
		variableMap = new HashMap<String, Object>();
		variableMap.put("v1", new Integer(0));

		inEventMap = new HashMap<String, Event<Events>>();

		outEventMap = new HashMap<String, Event<Events>>();

		inEventMap.put("event3", new Event<Events>(Events.Event3, 2));
		outEventMap.put("event4", new Event<Events>(Events.Event4, 2));
	}

	public void raiseEvent3() {
		statemachine.getOccuredEvents().add(getEventEvent3());
	}

	public Event<Events> getEventEvent3() {
		return inEventMap.get("event3");
	}

	public void raiseEvent4() {
		statemachine.getOccuredEvents().add(getEventEvent4());
		statemachine.getOutEvents().add(getEventEvent4());
		notifyListenersOnEventRaised(new EventNotification(getEventEvent4()));
	}

	public Event<Events> getEventEvent4() {
		return outEventMap.get("event4");
	}

	public boolean isRaisedEvent4() {
		return statemachine.getOutEvents().contains(getEventEvent4());
	}

	public int getVarV1() {
		return (Integer) variableMap.get("v1");
	}

	public void setVarV1(int value) {
		int oldValue = getVarV1();
		variableMap.put("v1", new Integer(value));
		notifyListenersOnVariableChanged(new VariableNotification<Integer>(
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
