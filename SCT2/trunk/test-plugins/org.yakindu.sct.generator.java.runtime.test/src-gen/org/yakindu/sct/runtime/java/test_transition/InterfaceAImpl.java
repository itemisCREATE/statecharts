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
import org.yakindu.sct.runtime.java.ValuedEvent;

public class InterfaceAImpl extends NotificationSender implements InterfaceA {
	private final ValuedEvent<Events, Integer> EventEvent1 = new ValuedEvent<Events, Integer>(
			Events.Event1, 0, 1);
	private final Event<Events> EventEvent2 = new Event<Events>(Events.Event2,
			0);
	private final Event<Events> EventEvent3 = new Event<Events>(Events.Event3,
			0);
	private final Event<Events> EventEvent4 = new Event<Events>(Events.Event4,
			0);
	private final Event<Events> EventEvent5 = new Event<Events>(Events.Event5,
			0);

	private Test_TransitionCycleBasedStatemachine statemachine;

	public InterfaceAImpl(Test_TransitionCycleBasedStatemachine statemachine) {
		this.statemachine = statemachine;
	}

	public void raiseEvent1(int value) {
		getEventEvent1().setValue(value);
		statemachine.getOccuredEvents().add(getEventEvent1());
	}

	public ValuedEvent<Events, Integer> getEventEvent1() {
		return EventEvent1;
	}

	public void raiseEvent2() {
		statemachine.getOccuredEvents().add(getEventEvent2());
	}

	public Event<Events> getEventEvent2() {
		return EventEvent2;
	}

	public void raiseEvent3() {
		statemachine.getOccuredEvents().add(getEventEvent3());
	}

	public Event<Events> getEventEvent3() {
		return EventEvent3;
	}

	public void raiseEvent4() {
		statemachine.getOccuredEvents().add(getEventEvent4());
	}

	public Event<Events> getEventEvent4() {
		return EventEvent4;
	}

	public void raiseEvent5() {
		statemachine.getOccuredEvents().add(getEventEvent5());
		statemachine.getOutEvents().add(getEventEvent5());
		notifyListeners(new EventNotification(getEventEvent5()));
	}

	public Event<Events> getEventEvent5() {
		return EventEvent5;
	}

	public boolean isRaisedEvent5() {
		return statemachine.getOutEvents().contains(getEventEvent5());
	}

}
