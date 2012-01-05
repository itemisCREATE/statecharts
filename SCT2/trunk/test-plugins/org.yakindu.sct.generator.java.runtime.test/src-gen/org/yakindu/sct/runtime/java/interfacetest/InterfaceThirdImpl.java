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

import org.yakindu.sct.runtime.java.Event;
import org.yakindu.sct.runtime.java.EventNotification;
import org.yakindu.sct.runtime.java.NotificationSender;
import org.yakindu.sct.runtime.java.ValuedEvent;

public class InterfaceThirdImpl extends NotificationSender
		implements
			InterfaceThird {

	private final Event<Events> EventEvent5 = new Event<Events>(Events.Event5,
			4);
	private final ValuedEvent<Events, Boolean> EventEvent6 = new ValuedEvent<Events, Boolean>(
			Events.Event6, 4, false);

	private InterfaceTestCycleBasedStatemachine statemachine;

	public InterfaceThirdImpl(InterfaceTestCycleBasedStatemachine statemachine) {
		this.statemachine = statemachine;
	}

	public void raiseEvent5() {
		statemachine.getOccuredEvents().add(EventEvent5);
	}

	public Event<Events> getEventEvent5() {
		return EventEvent5;
	}

	public void raiseEvent6(boolean value) {
		EventEvent6.setValue(value);
		statemachine.getOccuredEvents().add(EventEvent6);
		statemachine.getOutEvents().add(EventEvent6);
		notifyListeners(new EventNotification(EventEvent6));
	}

	public ValuedEvent<Events, Boolean> getEventEvent6() {
		return EventEvent6;
	}

	public boolean isRaisedEvent6() {
		return statemachine.getOutEvents().contains(EventEvent6);
	}

	private double varV1;

	public double getVarV1() {
		return varV1;
	}

	public void setVarV1(double value) {
		varV1 = value;
	}
}
