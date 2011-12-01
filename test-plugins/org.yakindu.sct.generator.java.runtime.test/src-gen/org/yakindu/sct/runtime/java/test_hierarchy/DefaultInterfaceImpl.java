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
package org.yakindu.sct.runtime.java.test_hierarchy;

import org.yakindu.sct.runtime.java.Event;

public class DefaultInterfaceImpl implements DefaultInterface {

	private final Event EventEvent1 = new Event("event1");
	private final Event EventEvent2 = new Event("event2");
	private final Event EventEvent3 = new Event("event3");
	private final Event EventEvent4 = new Event("event4");
	private final Event EventEvent5 = new Event("event5");
	private final Event EventEvent6 = new Event("event6");
	private final Event EventEvent7 = new Event("event7");
	private final Event EventEvent8 = new Event("event8");
	private final Event EventEvent9 = new Event("event9");
	private final Event EventEvent10 = new Event("event10");
	private final Event EventEvent11 = new Event("event11");
	private final Event EventEvent12 = new Event("event12");
	private final Event EventEvent13 = new Event("event13");
	private final Event EventEvent14 = new Event("event14");
	private final Event EventEvent15 = new Event("event15");
	private final Event EventEvent16 = new Event("event16");

	private Test_HierarchyCycleBasedStatemachine statemachine;

	public DefaultInterfaceImpl(
			Test_HierarchyCycleBasedStatemachine statemachine) {
		this.statemachine = statemachine;
	}

	public void raiseEvent1() {
		statemachine.getOccuredEvents().add(EventEvent1);
	}

	public Event getEventEvent1() {
		return EventEvent1;
	}

	public void raiseEvent2() {
		statemachine.getOccuredEvents().add(EventEvent2);
	}

	public Event getEventEvent2() {
		return EventEvent2;
	}

	public void raiseEvent3() {
		statemachine.getOccuredEvents().add(EventEvent3);
	}

	public Event getEventEvent3() {
		return EventEvent3;
	}

	public void raiseEvent4() {
		statemachine.getOccuredEvents().add(EventEvent4);
	}

	public Event getEventEvent4() {
		return EventEvent4;
	}

	public void raiseEvent5() {
		statemachine.getOccuredEvents().add(EventEvent5);
	}

	public Event getEventEvent5() {
		return EventEvent5;
	}

	public void raiseEvent6() {
		statemachine.getOccuredEvents().add(EventEvent6);
	}

	public Event getEventEvent6() {
		return EventEvent6;
	}

	public void raiseEvent7() {
		statemachine.getOccuredEvents().add(EventEvent7);
	}

	public Event getEventEvent7() {
		return EventEvent7;
	}

	public void raiseEvent8() {
		statemachine.getOccuredEvents().add(EventEvent8);
	}

	public Event getEventEvent8() {
		return EventEvent8;
	}

	public void raiseEvent9() {
		statemachine.getOccuredEvents().add(EventEvent9);
	}

	public Event getEventEvent9() {
		return EventEvent9;
	}

	public void raiseEvent10() {
		statemachine.getOccuredEvents().add(EventEvent10);
	}

	public Event getEventEvent10() {
		return EventEvent10;
	}

	public void raiseEvent11() {
		statemachine.getOccuredEvents().add(EventEvent11);
	}

	public Event getEventEvent11() {
		return EventEvent11;
	}

	public void raiseEvent12() {
		statemachine.getOccuredEvents().add(EventEvent12);
	}

	public Event getEventEvent12() {
		return EventEvent12;
	}

	public void raiseEvent13() {
		statemachine.getOccuredEvents().add(EventEvent13);
	}

	public Event getEventEvent13() {
		return EventEvent13;
	}

	public void raiseEvent14() {
		statemachine.getOccuredEvents().add(EventEvent14);
	}

	public Event getEventEvent14() {
		return EventEvent14;
	}

	public void raiseEvent15() {
		statemachine.getOccuredEvents().add(EventEvent15);
	}

	public Event getEventEvent15() {
		return EventEvent15;
	}

	public void raiseEvent16() {
		statemachine.getOccuredEvents().add(EventEvent16);
	}

	public Event getEventEvent16() {
		return EventEvent16;
	}

	private int varS1 = 0;

	public int getVarS1() {
		return varS1;
	}

	public void setVarS1(int value) {
		varS1 = value;
	}
	private int varS2;

	public int getVarS2() {
		return varS2;
	}

	public void setVarS2(int value) {
		varS2 = value;
	}
}
