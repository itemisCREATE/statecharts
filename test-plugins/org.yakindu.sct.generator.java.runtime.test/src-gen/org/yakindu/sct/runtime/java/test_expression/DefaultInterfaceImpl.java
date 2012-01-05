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
import org.yakindu.sct.runtime.java.EventNotification;
import org.yakindu.sct.runtime.java.NotificationSender;
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
		EventEvent1.setValue(value);
		statemachine.getOccuredEvents().add(EventEvent1);
	}

	public ValuedEvent<Events, Integer> getEventEvent1() {
		return EventEvent1;
	}

	public void raiseEvent2(double value) {
		EventEvent2.setValue(value);
		statemachine.getOccuredEvents().add(EventEvent2);
		statemachine.getOutEvents().add(EventEvent2);
		notifyListeners(new EventNotification(EventEvent2));
	}

	public ValuedEvent<Events, Double> getEventEvent2() {
		return EventEvent2;
	}

	public boolean isRaisedEvent2() {
		return statemachine.getOutEvents().contains(EventEvent2);
	}

	public void raiseEvent3() {
		statemachine.getOccuredEvents().add(EventEvent3);
	}

	public Event<Events> getEventEvent3() {
		return EventEvent3;
	}

	private int varVar1 = 6;

	public int getVarVar1() {
		return varVar1;
	}

	public void setVarVar1(int value) {
		varVar1 = value;
	}
	private int varVar2 = 123;

	public int getVarVar2() {
		return varVar2;
	}

	public void setVarVar2(int value) {
		varVar2 = value;
	}
	private double varVar3 = 19.4;

	public double getVarVar3() {
		return varVar3;
	}

	public void setVarVar3(double value) {
		varVar3 = value;
	}
	private double varVar4 = 43.3;

	public double getVarVar4() {
		return varVar4;
	}

	public void setVarVar4(double value) {
		varVar4 = value;
	}
	private boolean varVar5 = false;

	public boolean getVarVar5() {
		return varVar5;
	}

	public void setVarVar5(boolean value) {
		varVar5 = value;
	}
}
