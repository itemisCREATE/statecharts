/**
Copyright (c) 2011 committers of YAKINDU and others. 
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html
 
Contributors:
	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.runtime.java.trafficlightwaiting;

import org.yakindu.sct.runtime.java.Event;

public class DefaultInterfaceImpl implements DefaultInterface {

	private final Event<Events> EventKeypress1 = new Event<Events>(
			Events.Keypress1, 0);
	private final Event<Events> EventKeypress2 = new Event<Events>(
			Events.Keypress2, 0);

	private TrafficLightWaitingCycleBasedStatemachine statemachine;

	public DefaultInterfaceImpl(
			TrafficLightWaitingCycleBasedStatemachine statemachine) {
		this.statemachine = statemachine;
	}

	public void raiseKeypress1() {
		statemachine.getOccuredEvents().add(EventKeypress1);
	}

	public Event<Events> getEventKeypress1() {
		return EventKeypress1;
	}

	public void raiseKeypress2() {
		statemachine.getOccuredEvents().add(EventKeypress2);
	}

	public Event<Events> getEventKeypress2() {
		return EventKeypress2;
	}

}
