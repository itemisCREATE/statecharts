/**
Copyright (c) 2011 committers of YAKINDU and others. 
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html
 
Contributors:
	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.runtime.java.test_transition;

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

	protected Test_TransitionCycleBasedStatemachine statemachine;

	public DefaultInterfaceImpl(
			Test_TransitionCycleBasedStatemachine statemachine) {

		this.statemachine = statemachine;
		variableMap = new HashMap<String, Object>();
		variableMap.put("i", new Integer(0));
		variableMap.put("j", new Double(0D));

		inEventMap = new HashMap<String, Event<Events>>();

		outEventMap = new HashMap<String, Event<Events>>();

		inEventMap.put("event5", new ValuedEvent<Events, Boolean>(
				Events.Event5, 5, false));
		inEventMap.put("event6", new Event<Events>(Events.Event6, 5));
		outEventMap.put("event7", new Event<Events>(Events.Event7, 5));
	}

	public void raiseEvent5(boolean value) {
		getEventEvent5().setValue(value);
		statemachine.getOccuredEvents().add(getEventEvent5());
	}

	@SuppressWarnings("unchecked")
	public ValuedEvent<Events, Boolean> getEventEvent5() {
		return (ValuedEvent<Events, Boolean>) inEventMap.get("event5");
	}

	public void raiseEvent6() {
		statemachine.getOccuredEvents().add(getEventEvent6());
	}

	public Event<Events> getEventEvent6() {
		return inEventMap.get("event6");
	}

	public void raiseEvent7() {
		statemachine.getOccuredEvents().add(getEventEvent7());
		statemachine.getOutEvents().add(getEventEvent7());
		notifyListenersOnEventRaised(new EventNotification(getEventEvent7()));
	}

	public Event<Events> getEventEvent7() {
		return outEventMap.get("event7");
	}

	public boolean isRaisedEvent7() {
		return statemachine.getOutEvents().contains(getEventEvent7());
	}

	public int getVarI() {
		return (Integer) variableMap.get("i");
	}

	public void setVarI(int value) {
		int oldValue = getVarI();
		variableMap.put("i", new Integer(value));
		notifyListenersOnVariableChanged(new VariableNotification<Integer>(
				Variables.i, getVarI(), oldValue));
	}
	public double getVarJ() {
		return (Double) variableMap.get("j");
	}

	public void setVarJ(double value) {
		double oldValue = getVarJ();
		variableMap.put("j", new Double(value));
		notifyListenersOnVariableChanged(new VariableNotification<Double>(
				Variables.j, getVarJ(), oldValue));
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
