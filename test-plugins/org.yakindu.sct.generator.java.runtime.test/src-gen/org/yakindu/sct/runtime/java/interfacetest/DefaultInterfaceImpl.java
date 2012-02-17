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

public class DefaultInterfaceImpl extends NotificationSender
		implements
			IDefaultInterfaceImpl {
	protected Map<String, Object> variableMap;
	protected Map<String, Event<Events>> outEventMap;
	protected Map<String, Event<Events>> inEventMap;

	protected InterfaceTestCycleBasedStatemachine statemachine;

	public DefaultInterfaceImpl(InterfaceTestCycleBasedStatemachine statemachine) {

		this.statemachine = statemachine;
		variableMap = new HashMap<String, Object>();
		variableMap.put("var1", new Boolean(false));
		variableMap.put("var2", new Double(0D));
		variableMap.put("var3", new Integer(0));

		inEventMap = new HashMap<String, Event<Events>>();

		outEventMap = new HashMap<String, Event<Events>>();

		inEventMap.put("event1", new Event<Events>(Events.Event1, 0));
		outEventMap.put("event2", new ValuedEvent<Events, Integer>(
				Events.Event2, 0, 0));
	}

	public void raiseEvent1() {
		statemachine.getOccuredEvents().add(getEventEvent1());
	}

	public Event<Events> getEventEvent1() {
		return inEventMap.get("event1");
	}

	public void raiseEvent2(int value) {
		getEventEvent2().setValue(value);
		statemachine.getOccuredEvents().add(getEventEvent2());
		statemachine.getOutEvents().add(getEventEvent2());
		notifyListenersOnEventRaised(new EventNotification(getEventEvent2()));
	}

	@SuppressWarnings("unchecked")
	public ValuedEvent<Events, Integer> getEventEvent2() {
		return (ValuedEvent<Events, Integer>) outEventMap.get("event2");
	}

	public boolean isRaisedEvent2() {
		return statemachine.getOutEvents().contains(getEventEvent2());
	}

	public boolean getVarVar1() {
		return (Boolean) variableMap.get("var1");
	}

	public void setVarVar1(boolean value) {
		boolean oldValue = getVarVar1();
		variableMap.put("var1", new Boolean(value));
		notifyListenersOnVariableChanged(new VariableNotification<Boolean>(
				Variables.var1, getVarVar1(), oldValue));
	}
	public double getVarVar2() {
		return (Double) variableMap.get("var2");
	}

	public void setVarVar2(double value) {
		double oldValue = getVarVar2();
		variableMap.put("var2", new Double(value));
		notifyListenersOnVariableChanged(new VariableNotification<Double>(
				Variables.var2, getVarVar2(), oldValue));
	}
	public int getVarVar3() {
		return (Integer) variableMap.get("var3");
	}

	public void setVarVar3(int value) {
		int oldValue = getVarVar3();
		variableMap.put("var3", new Integer(value));
		notifyListenersOnVariableChanged(new VariableNotification<Integer>(
				Variables.var3, getVarVar3(), oldValue));
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
