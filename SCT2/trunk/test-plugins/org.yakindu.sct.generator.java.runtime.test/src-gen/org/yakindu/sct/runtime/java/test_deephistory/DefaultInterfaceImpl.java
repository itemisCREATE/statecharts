/**
Copyright (c) 2011 committers of YAKINDU and others. 
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html
 
Contributors:
	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.runtime.java.test_deephistory;

import org.yakindu.sct.runtime.java.Event;

public class DefaultInterfaceImpl implements DefaultInterface {

	private final Event<Events> EventEvent1 = new Event<Events>(Events.Event1,
			0);
	private final Event<Events> EventEvent2 = new Event<Events>(Events.Event2,
			0);
	private final Event<Events> EventEvent3 = new Event<Events>(Events.Event3,
			0);
	private final Event<Events> EventEvent4 = new Event<Events>(Events.Event4,
			0);
	private final Event<Events> EventEvent5 = new Event<Events>(Events.Event5,
			0);
	private final Event<Events> EventEvent6 = new Event<Events>(Events.Event6,
			0);
	private final Event<Events> EventEvent7 = new Event<Events>(Events.Event7,
			0);
	private final Event<Events> EventEvent8 = new Event<Events>(Events.Event8,
			0);
	private final Event<Events> EventEvent9 = new Event<Events>(Events.Event9,
			0);

	private Test_DeepHistoryCycleBasedStatemachine statemachine;

	public DefaultInterfaceImpl(
			Test_DeepHistoryCycleBasedStatemachine statemachine) {
		this.statemachine = statemachine;
	}

	public void raiseEvent1() {
		statemachine.getOccuredEvents().add(EventEvent1);
	}

	public Event<Events> getEventEvent1() {
		return EventEvent1;
	}

	public void raiseEvent2() {
		statemachine.getOccuredEvents().add(EventEvent2);
	}

	public Event<Events> getEventEvent2() {
		return EventEvent2;
	}

	public void raiseEvent3() {
		statemachine.getOccuredEvents().add(EventEvent3);
	}

	public Event<Events> getEventEvent3() {
		return EventEvent3;
	}

	public void raiseEvent4() {
		statemachine.getOccuredEvents().add(EventEvent4);
	}

	public Event<Events> getEventEvent4() {
		return EventEvent4;
	}

	public void raiseEvent5() {
		statemachine.getOccuredEvents().add(EventEvent5);
	}

	public Event<Events> getEventEvent5() {
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
	}

	public Event<Events> getEventEvent7() {
		return EventEvent7;
	}

	public void raiseEvent8() {
		statemachine.getOccuredEvents().add(EventEvent8);
	}

	public Event<Events> getEventEvent8() {
		return EventEvent8;
	}

	public void raiseEvent9() {
		statemachine.getOccuredEvents().add(EventEvent9);
	}

	public Event<Events> getEventEvent9() {
		return EventEvent9;
	}

}
