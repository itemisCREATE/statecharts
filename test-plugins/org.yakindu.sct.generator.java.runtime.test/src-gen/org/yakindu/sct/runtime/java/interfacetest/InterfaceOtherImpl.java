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

public class InterfaceOtherImpl extends NotificationSender
		implements
			InterfaceOther {

	private final Event<Events> EventEvent3 = new Event<Events>(Events.Event3,
			2);
	private final Event<Events> EventEvent4 = new Event<Events>(Events.Event4,
			2);

	private InterfaceTestCycleBasedStatemachine statemachine;

	public InterfaceOtherImpl(InterfaceTestCycleBasedStatemachine statemachine) {
		this.statemachine = statemachine;
	}

	public void raiseEvent3() {
		statemachine.getOccuredEvents().add(EventEvent3);
	}

	public Event<Events> getEventEvent3() {
		return EventEvent3;
	}

	public void raiseEvent4() {
		statemachine.getOccuredEvents().add(EventEvent4);
		statemachine.getOutEvents().add(EventEvent4);
		notifyListeners(new EventNotification(EventEvent4));
	}

	public Event<Events> getEventEvent4() {
		return EventEvent4;
	}

	public boolean isRaisedEvent4() {
		return statemachine.getOutEvents().contains(EventEvent4);
	}

	private int varV1 = 5;

	public int getVarV1() {
		return varV1;
	}

	public void setVarV1(int value) {
		varV1 = value;
	}
}
