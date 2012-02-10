/**
Copyright (c) 2011 committers of YAKINDU and others. 
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html
 
Contributors:
	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.runtime.java.test_localactions;

import java.util.HashMap;
import java.util.Map;
import org.yakindu.sct.runtime.java.Event;
import org.yakindu.sct.runtime.java.NotificationSender;
import org.yakindu.sct.runtime.java.VariableNotification;
import org.yakindu.sct.runtime.java.ValuedEvent;

public class DefaultInterfaceImpl extends NotificationSender
		implements
			IDefaultInterfaceImpl {
	protected Map<String, Object> variableMap;
	protected Map<String, Event<Events>> inEventMap;

	protected Test_LocalActionsCycleBasedStatemachine statemachine;

	public DefaultInterfaceImpl(
			Test_LocalActionsCycleBasedStatemachine statemachine) {

		this.statemachine = statemachine;
		variableMap = new HashMap<String, Object>();
		variableMap.put("i", new Integer(0));
		variableMap.put("j", new Integer(0));
		variableMap.put("c", new Integer(0));

		inEventMap = new HashMap<String, Event<Events>>();

		inEventMap.put("Event1", new Event<Events>(Events.Event1, 0));
		inEventMap.put("Event2", new Event<Events>(Events.Event2, 0));
		inEventMap.put("Event3", new Event<Events>(Events.Event3, 0));
		inEventMap.put("Event4", new Event<Events>(Events.Event4, 0));
	}

	public void raiseEvent1() {
		statemachine.getOccuredEvents().add(getEventEvent1());
	}

	public Event<Events> getEventEvent1() {
		return inEventMap.get("Event1");
	}

	public void raiseEvent2() {
		statemachine.getOccuredEvents().add(getEventEvent2());
	}

	public Event<Events> getEventEvent2() {
		return inEventMap.get("Event2");
	}

	public void raiseEvent3() {
		statemachine.getOccuredEvents().add(getEventEvent3());
	}

	public Event<Events> getEventEvent3() {
		return inEventMap.get("Event3");
	}

	public void raiseEvent4() {
		statemachine.getOccuredEvents().add(getEventEvent4());
	}

	public Event<Events> getEventEvent4() {
		return inEventMap.get("Event4");
	}

	public int getVarI() {
		return (Integer) variableMap.get("i");
	}

	public void setVarI(int value) {
		int oldValue = getVarI();
		variableMap.put("i", new Integer(value));
		notifyListeners(new VariableNotification<Integer>(Variables.i,
				getVarI(), oldValue));
	}
	public int getVarJ() {
		return (Integer) variableMap.get("j");
	}

	public void setVarJ(int value) {
		int oldValue = getVarJ();
		variableMap.put("j", new Integer(value));
		notifyListeners(new VariableNotification<Integer>(Variables.j,
				getVarJ(), oldValue));
	}
	public int getVarC() {
		return (Integer) variableMap.get("c");
	}

	public void setVarC(int value) {
		int oldValue = getVarC();
		variableMap.put("c", new Integer(value));
		notifyListeners(new VariableNotification<Integer>(Variables.c,
				getVarC(), oldValue));
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
			notifyListeners(new VariableNotification<Object>(
					Variables.valueOf(name), variableMap.get(name), oldValue));
			return true;
		}
		return false;
	}

	public Object getVariable(String name) {
		return variableMap.get(name);
	}
}
