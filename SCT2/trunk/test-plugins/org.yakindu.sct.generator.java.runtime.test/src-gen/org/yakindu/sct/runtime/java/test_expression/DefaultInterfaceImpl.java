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

import org.yakindu.sct.runtime.java.Event;
import org.yakindu.sct.runtime.java.NotificationSender;
import org.yakindu.sct.runtime.java.EventNotification;
import org.yakindu.sct.runtime.java.VariableNotification;
import org.yakindu.sct.runtime.java.ValuedEvent;

public class DefaultInterfaceImpl extends NotificationSender
		implements
			DefaultInterface {
	private final ValuedEvent<Events, Integer> EventEvent1 = new ValuedEvent<Events, Integer>(
			Events.Event1, 0, 0);
	private final ValuedEvent<Events, Double> EventEvent2 = new ValuedEvent<Events, Double>(
			Events.Event2, 0, 0D);
	private final Event<Events> EventEvent3 = new Event<Events>(Events.Event3,
			0);

	private Test_ExpressionCycleBasedStatemachine statemachine;

	public DefaultInterfaceImpl(
			Test_ExpressionCycleBasedStatemachine statemachine) {
		this.statemachine = statemachine;
	}

	public void raiseEvent1(int value) {
		getEventEvent1().setValue(value);
		statemachine.getOccuredEvents().add(getEventEvent1());
	}

	public ValuedEvent<Events, Integer> getEventEvent1() {
		return EventEvent1;
	}

	public void raiseEvent2(double value) {
		getEventEvent2().setValue(value);
		statemachine.getOccuredEvents().add(getEventEvent2());
		statemachine.getOutEvents().add(getEventEvent2());
		notifyListeners(new EventNotification(getEventEvent2()));
	}

	public ValuedEvent<Events, Double> getEventEvent2() {
		return EventEvent2;
	}

	public boolean isRaisedEvent2() {
		return statemachine.getOutEvents().contains(getEventEvent2());
	}

	public void raiseEvent3() {
		statemachine.getOccuredEvents().add(getEventEvent3());
	}

	public Event<Events> getEventEvent3() {
		return EventEvent3;
	}

	private int varVar1 = 6;
	public int getVarVar1() {
		return varVar1;
	}

	public void setVarVar1(int value) {
		int oldValue = getVarVar1();
		varVar1 = value;
		notifyListeners(new VariableNotification<Integer>(Variables.var1,
				getVarVar1(), oldValue));
	}
	private int varVar2 = 123;
	public int getVarVar2() {
		return varVar2;
	}

	public void setVarVar2(int value) {
		int oldValue = getVarVar2();
		varVar2 = value;
		notifyListeners(new VariableNotification<Integer>(Variables.var2,
				getVarVar2(), oldValue));
	}
	private double varVar3 = 19.4;
	public double getVarVar3() {
		return varVar3;
	}

	public void setVarVar3(double value) {
		double oldValue = getVarVar3();
		varVar3 = value;
		notifyListeners(new VariableNotification<Double>(Variables.var3,
				getVarVar3(), oldValue));
	}
	private double varVar4 = 43.3;
	public double getVarVar4() {
		return varVar4;
	}

	public void setVarVar4(double value) {
		double oldValue = getVarVar4();
		varVar4 = value;
		notifyListeners(new VariableNotification<Double>(Variables.var4,
				getVarVar4(), oldValue));
	}
	private boolean varVar5 = false;
	public boolean getVarVar5() {
		return varVar5;
	}

	public void setVarVar5(boolean value) {
		boolean oldValue = getVarVar5();
		varVar5 = value;
		notifyListeners(new VariableNotification<Boolean>(Variables.var5,
				getVarVar5(), oldValue));
	}

}
