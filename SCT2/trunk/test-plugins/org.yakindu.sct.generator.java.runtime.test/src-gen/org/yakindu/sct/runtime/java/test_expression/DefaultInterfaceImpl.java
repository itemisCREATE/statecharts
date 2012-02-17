/**
Copyright (c) 2011 committers of YAKINDU and others. 
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html
 
Contributors:
	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.runtime.java.test_expression;

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

	protected Test_ExpressionCycleBasedStatemachine statemachine;

	public DefaultInterfaceImpl(
			Test_ExpressionCycleBasedStatemachine statemachine) {

		this.statemachine = statemachine;
		variableMap = new HashMap<String, Object>();
		variableMap.put("var1", new Integer(0));
		variableMap.put("var2", new Integer(0));
		variableMap.put("var3", new Double(0D));
		variableMap.put("var4", new Double(0D));
		variableMap.put("var5", new Boolean(false));

		inEventMap = new HashMap<String, Event<Events>>();

		outEventMap = new HashMap<String, Event<Events>>();

		inEventMap.put("event1", new ValuedEvent<Events, Integer>(
				Events.Event1, 0, 0));
		outEventMap.put("event2", new ValuedEvent<Events, Double>(
				Events.Event2, 0, 0D));
		inEventMap.put("event3", new Event<Events>(Events.Event3, 0));
	}

	public void raiseEvent1(int value) {
		getEventEvent1().setValue(value);
		statemachine.getOccuredEvents().add(getEventEvent1());
	}

	@SuppressWarnings("unchecked")
	public ValuedEvent<Events, Integer> getEventEvent1() {
		return (ValuedEvent<Events, Integer>) inEventMap.get("event1");
	}

	public void raiseEvent2(double value) {
		getEventEvent2().setValue(value);
		statemachine.getOccuredEvents().add(getEventEvent2());
		statemachine.getOutEvents().add(getEventEvent2());
		notifyListenersOnEventRaised(new EventNotification(getEventEvent2()));
	}

	@SuppressWarnings("unchecked")
	public ValuedEvent<Events, Double> getEventEvent2() {
		return (ValuedEvent<Events, Double>) outEventMap.get("event2");
	}

	public boolean isRaisedEvent2() {
		return statemachine.getOutEvents().contains(getEventEvent2());
	}

	public void raiseEvent3() {
		statemachine.getOccuredEvents().add(getEventEvent3());
	}

	public Event<Events> getEventEvent3() {
		return inEventMap.get("event3");
	}

	public int getVarVar1() {
		return (Integer) variableMap.get("var1");
	}

	public void setVarVar1(int value) {
		int oldValue = getVarVar1();
		variableMap.put("var1", new Integer(value));
		notifyListenersOnVariableChanged(new VariableNotification<Integer>(
				Variables.var1, getVarVar1(), oldValue));
	}
	public int getVarVar2() {
		return (Integer) variableMap.get("var2");
	}

	public void setVarVar2(int value) {
		int oldValue = getVarVar2();
		variableMap.put("var2", new Integer(value));
		notifyListenersOnVariableChanged(new VariableNotification<Integer>(
				Variables.var2, getVarVar2(), oldValue));
	}
	public double getVarVar3() {
		return (Double) variableMap.get("var3");
	}

	public void setVarVar3(double value) {
		double oldValue = getVarVar3();
		variableMap.put("var3", new Double(value));
		notifyListenersOnVariableChanged(new VariableNotification<Double>(
				Variables.var3, getVarVar3(), oldValue));
	}
	public double getVarVar4() {
		return (Double) variableMap.get("var4");
	}

	public void setVarVar4(double value) {
		double oldValue = getVarVar4();
		variableMap.put("var4", new Double(value));
		notifyListenersOnVariableChanged(new VariableNotification<Double>(
				Variables.var4, getVarVar4(), oldValue));
	}
	public boolean getVarVar5() {
		return (Boolean) variableMap.get("var5");
	}

	public void setVarVar5(boolean value) {
		boolean oldValue = getVarVar5();
		variableMap.put("var5", new Boolean(value));
		notifyListenersOnVariableChanged(new VariableNotification<Boolean>(
				Variables.var5, getVarVar5(), oldValue));
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
