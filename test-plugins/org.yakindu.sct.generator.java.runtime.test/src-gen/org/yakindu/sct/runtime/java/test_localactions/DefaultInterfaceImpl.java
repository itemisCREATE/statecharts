/**
Copyright (c) 2011 committers of YAKINDU and others. 
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html
 
Contributors:
	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.runtime.java.test_localactions;

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

	private Test_LocalActionsCycleBasedStatemachine statemachine;

	public DefaultInterfaceImpl(
			Test_LocalActionsCycleBasedStatemachine statemachine) {
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

	private int varI;

	public int getVarI() {
		return varI;
	}

	public void setVarI(int value) {
		varI = value;
	}
	private int varJ;

	public int getVarJ() {
		return varJ;
	}

	public void setVarJ(int value) {
		varJ = value;
	}
	private int varC;

	public int getVarC() {
		return varC;
	}

	public void setVarC(int value) {
		varC = value;
	}
}
