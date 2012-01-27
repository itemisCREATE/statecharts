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

import org.yakindu.sct.runtime.java.Event;
import org.yakindu.sct.runtime.java.NotificationSender;
import org.yakindu.sct.runtime.java.EventNotification;
import org.yakindu.sct.runtime.java.VariableNotification;
import org.yakindu.sct.runtime.java.ValuedEvent;

public class DefaultInterfaceImpl extends NotificationSender
		implements
			DefaultInterface {
	private final ValuedEvent<Events, Boolean> EventEvent5 = new ValuedEvent<Events, Boolean>(
			Events.Event5, 5, false);
	private final Event<Events> EventEvent6 = new Event<Events>(Events.Event6,
			5);
	private final Event<Events> EventEvent7 = new Event<Events>(Events.Event7,
			5);

	private Test_TransitionCycleBasedStatemachine statemachine;

	public DefaultInterfaceImpl(
			Test_TransitionCycleBasedStatemachine statemachine) {
		this.statemachine = statemachine;
	}

	public void raiseEvent5(boolean value) {
		getEventEvent5().setValue(value);
		statemachine.getOccuredEvents().add(getEventEvent5());
	}

	public ValuedEvent<Events, Boolean> getEventEvent5() {
		return EventEvent5;
	}

	public void raiseEvent6() {
		statemachine.getOccuredEvents().add(getEventEvent6());
	}

	public Event<Events> getEventEvent6() {
		return EventEvent6;
	}

	public void raiseEvent7() {
		statemachine.getOccuredEvents().add(getEventEvent7());
		statemachine.getOutEvents().add(getEventEvent7());
		notifyListeners(new EventNotification(getEventEvent7()));
	}

	public Event<Events> getEventEvent7() {
		return EventEvent7;
	}

	public boolean isRaisedEvent7() {
		return statemachine.getOutEvents().contains(getEventEvent7());
	}

	private int varI;
	public int getVarI() {
		return varI;
	}

	public void setVarI(int value) {
		int oldValue = getVarI();
		varI = value;
		notifyListeners(new VariableNotification<Integer>(Variables.i,
				getVarI(), oldValue));
	}
	private double varJ;
	public double getVarJ() {
		return varJ;
	}

	public void setVarJ(double value) {
		double oldValue = getVarJ();
		varJ = value;
		notifyListeners(new VariableNotification<Double>(Variables.j,
				getVarJ(), oldValue));
	}

}
