/**
Copyright (c) 2011 committers of YAKINDU and others. 
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html
 
Contributors:
	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.runtime.java.test_parallelregions;

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
	private final Event<Events> EventEvent10 = new Event<Events>(
			Events.Event10, 0);
	private final Event<Events> EventEvent11 = new Event<Events>(
			Events.Event11, 0);
	private final Event<Events> EventEvent12 = new Event<Events>(
			Events.Event12, 0);
	private final Event<Events> EventEvent13 = new Event<Events>(
			Events.Event13, 0);
	private final Event<Events> EventEvent14 = new Event<Events>(
			Events.Event14, 0);

	private Test_ParallelRegionsCycleBasedStatemachine statemachine;

	public DefaultInterfaceImpl(
			Test_ParallelRegionsCycleBasedStatemachine statemachine) {
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

	public void raiseEvent10() {
		statemachine.getOccuredEvents().add(EventEvent10);
	}

	public Event<Events> getEventEvent10() {
		return EventEvent10;
	}

	public void raiseEvent11() {
		statemachine.getOccuredEvents().add(EventEvent11);
	}

	public Event<Events> getEventEvent11() {
		return EventEvent11;
	}

	public void raiseEvent12() {
		statemachine.getOccuredEvents().add(EventEvent12);
	}

	public Event<Events> getEventEvent12() {
		return EventEvent12;
	}

	public void raiseEvent13() {
		statemachine.getOccuredEvents().add(EventEvent13);
	}

	public Event<Events> getEventEvent13() {
		return EventEvent13;
	}

	public void raiseEvent14() {
		statemachine.getOccuredEvents().add(EventEvent14);
	}

	public Event<Events> getEventEvent14() {
		return EventEvent14;
	}

	private int varReg3 = -(1);

	public int getVarReg3() {
		return varReg3;
	}

	public void setVarReg3(int value) {
		varReg3 = value;
	}
	private int varHierarchy;

	public int getVarHierarchy() {
		return varHierarchy;
	}

	public void setVarHierarchy(int value) {
		varHierarchy = value;
	}
}
