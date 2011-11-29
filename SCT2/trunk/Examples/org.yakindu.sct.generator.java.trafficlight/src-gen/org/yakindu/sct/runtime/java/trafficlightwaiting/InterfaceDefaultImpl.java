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
package org.yakindu.sct.runtime.java.trafficlightwaiting;

import org.yakindu.sct.runtime.java.Event;

public class InterfaceDefaultImpl implements InterfaceDefault {

	private final Event EventKeypress1 = new Event("keypress1");
	private final Event EventKeypress2 = new Event("keypress2");
	private final Event EventKeypress3 = new Event("keypress3");

	private TrafficLightWaitingAbstractBaseStatemachine statemachine;

	public InterfaceDefaultImpl(
			TrafficLightWaitingAbstractBaseStatemachine statemachine) {
		this.statemachine = statemachine;
	}

	public void raiseKeypress1() {
		statemachine.getOccuredEvents().add(EventKeypress1);
	}

	public Event getEventKeypress1() {
		return EventKeypress1;
	}

	public void raiseKeypress2() {
		statemachine.getOccuredEvents().add(EventKeypress2);
	}

	public Event getEventKeypress2() {
		return EventKeypress2;
	}

	public void raiseKeypress3() {
		statemachine.getOccuredEvents().add(EventKeypress3);
	}

	public Event getEventKeypress3() {
		return EventKeypress3;
	}

}
