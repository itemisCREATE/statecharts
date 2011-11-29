/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.runtime.java.test_expression;

import org.yakindu.sct.runtime.java.EventNotification;
import org.yakindu.sct.runtime.java.NotificationSender;
import org.yakindu.sct.runtime.java.ValuedEvent;

public class InterfaceDefaultImpl extends NotificationSender
		implements
			InterfaceDefault {

	private final ValuedEvent<Integer> EventEvent1 = new ValuedEvent<Integer>(
			"event1", 0);
	private final ValuedEvent<Double> EventEvent2 = new ValuedEvent<Double>(
			"event2", 0D);

	private Test_ExpressionAbstractBaseStatemachine statemachine;

	public InterfaceDefaultImpl(
			Test_ExpressionAbstractBaseStatemachine statemachine) {
		this.statemachine = statemachine;
	}

	public void raiseEvent1() {
		statemachine.getOccuredEvents().add(EventEvent1);
	}

	public void raiseEvent1(int value) {
		EventEvent1.setValue(value);
		statemachine.getOccuredEvents().add(EventEvent1);
	}

	public ValuedEvent<Integer> getEventEvent1() {
		return EventEvent1;
	}

	public void raiseEvent2() {
		statemachine.getOccuredEvents().add(EventEvent2);
		statemachine.getOutEvents().add(EventEvent2);
		notifyListeners(new EventNotification(EventEvent2));
	}

	public void raiseEvent2(double value) {
		EventEvent2.setValue(value);
		statemachine.getOccuredEvents().add(EventEvent2);
		statemachine.getOutEvents().add(EventEvent2);
		notifyListeners(new EventNotification(EventEvent2));
	}

	public ValuedEvent<Double> getEventEvent2() {
		return EventEvent2;
	}

	public boolean isRaisedEvent2() {
		return statemachine.getOutEvents().contains(EventEvent2);
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
