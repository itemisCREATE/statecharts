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
import org.yakindu.sct.runtime.java.EventNotification;
import org.yakindu.sct.runtime.java.NotificationSender;
import org.yakindu.sct.runtime.java.ValuedEvent;

public class DefaultInterfaceImpl extends NotificationSender
		implements
			DefaultInterface {

	private final ValuedEvent<Events, Boolean> EventEvent5 = new ValuedEvent<Events, Boolean>(
			Events.Event5, 4, false);
	private final Event<Events> EventEvent6 = new Event<Events>(Events.Event6,
			4);
	private final Event<Events> EventEvent7 = new Event<Events>(Events.Event7,
			4);

	private Test_TransitionCycleBasedStatemachine statemachine;

	public DefaultInterfaceImpl(
			Test_TransitionCycleBasedStatemachine statemachine) {
		this.statemachine = statemachine;
	}

	public void raiseEvent5(boolean value) {
		EventEvent5.setValue(value);
		statemachine.getOccuredEvents().add(EventEvent5);
	}

	public ValuedEvent<Events, Boolean> getEventEvent5() {
		return EventEvent5;
	}

	public void raiseEvent6() {
		statemachine.getOccuredEvents().add(EventEvent6);
	}

	public Event<Events> getEventEvent6() {
		return EventEvent6;
	}

	public void raiseEvent7() {
		statemachine.getOccuredEvents().add(EventEvent7);
		statemachine.getOutEvents().add(EventEvent7);
		notifyListeners(new EventNotification(EventEvent7));
	}

	public Event<Events> getEventEvent7() {
		return EventEvent7;
	}

	public boolean isRaisedEvent7() {
		return statemachine.getOutEvents().contains(EventEvent7);
	}

	private int varI;

	public int getVarI() {
		return varI;
	}

	public void setVarI(int value) {
		varI = value;
	}
	private double varJ;

	public double getVarJ() {
		return varJ;
	}

	public void setVarJ(double value) {
		varJ = value;
	}
}
