/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.runtime.java.test_hierarchy;

import org.yakindu.sct.runtime.java.EventNotification;
import org.yakindu.sct.runtime.java.Event;

public class InterfaceDefaultImpl implements InterfaceDefault {
	
	private final Event<Void> EventEvent1 = new Event<Void>("event1", null); 
	private final Event<Void> EventEvent2 = new Event<Void>("event2", null); 
	private final Event<Void> EventEvent3 = new Event<Void>("event3", null); 
	private final Event<Void> EventEvent4 = new Event<Void>("event4", null); 
	private final Event<Void> EventEvent5 = new Event<Void>("event5", null); 
	private final Event<Void> EventEvent6 = new Event<Void>("event6", null); 
	private final Event<Void> EventEvent7 = new Event<Void>("event7", null); 
	private final Event<Void> EventEvent8 = new Event<Void>("event8", null); 
	private final Event<Void> EventEvent9 = new Event<Void>("event9", null); 
	private final Event<Void> EventEvent10 = new Event<Void>("event10", null); 
	private final Event<Void> EventEvent11 = new Event<Void>("event11", null); 
	private final Event<Void> EventEvent12 = new Event<Void>("event12", null); 
	private final Event<Void> EventEvent13 = new Event<Void>("event13", null); 
	private final Event<Void> EventEvent14 = new Event<Void>("event14", null); 
	private final Event<Void> EventEvent15 = new Event<Void>("event15", null); 
	private final Event<Void> EventEvent16 = new Event<Void>("event16", null); 
	
	private Test_HierarchyAbstractBaseStatemachine statemachine; 
	
	public InterfaceDefaultImpl(Test_HierarchyAbstractBaseStatemachine statemachine) {
		this.statemachine = statemachine;
	}
	
	public void raiseEvent1() {
		statemachine.getOccuredEvents().add(EventEvent1);
	}
	
	
	public Event<Void> getEventEvent1() {
		return EventEvent1;
	}
	
	public void raiseEvent2() {
		statemachine.getOccuredEvents().add(EventEvent2);
	}
	
	
	public Event<Void> getEventEvent2() {
		return EventEvent2;
	}
	
	public void raiseEvent3() {
		statemachine.getOccuredEvents().add(EventEvent3);
	}
	
	
	public Event<Void> getEventEvent3() {
		return EventEvent3;
	}
	
	public void raiseEvent4() {
		statemachine.getOccuredEvents().add(EventEvent4);
	}
	
	
	public Event<Void> getEventEvent4() {
		return EventEvent4;
	}
	
	public void raiseEvent5() {
		statemachine.getOccuredEvents().add(EventEvent5);
	}
	
	
	public Event<Void> getEventEvent5() {
		return EventEvent5;
	}
	
	public void raiseEvent6() {
		statemachine.getOccuredEvents().add(EventEvent6);
	}
	
	
	public Event<Void> getEventEvent6() {
		return EventEvent6;
	}
	
	public void raiseEvent7() {
		statemachine.getOccuredEvents().add(EventEvent7);
	}
	
	
	public Event<Void> getEventEvent7() {
		return EventEvent7;
	}
	
	public void raiseEvent8() {
		statemachine.getOccuredEvents().add(EventEvent8);
	}
	
	
	public Event<Void> getEventEvent8() {
		return EventEvent8;
	}
	
	public void raiseEvent9() {
		statemachine.getOccuredEvents().add(EventEvent9);
	}
	
	
	public Event<Void> getEventEvent9() {
		return EventEvent9;
	}
	
	public void raiseEvent10() {
		statemachine.getOccuredEvents().add(EventEvent10);
	}
	
	
	public Event<Void> getEventEvent10() {
		return EventEvent10;
	}
	
	public void raiseEvent11() {
		statemachine.getOccuredEvents().add(EventEvent11);
	}
	
	
	public Event<Void> getEventEvent11() {
		return EventEvent11;
	}
	
	public void raiseEvent12() {
		statemachine.getOccuredEvents().add(EventEvent12);
	}
	
	
	public Event<Void> getEventEvent12() {
		return EventEvent12;
	}
	
	public void raiseEvent13() {
		statemachine.getOccuredEvents().add(EventEvent13);
	}
	
	
	public Event<Void> getEventEvent13() {
		return EventEvent13;
	}
	
	public void raiseEvent14() {
		statemachine.getOccuredEvents().add(EventEvent14);
	}
	
	
	public Event<Void> getEventEvent14() {
		return EventEvent14;
	}
	
	public void raiseEvent15() {
		statemachine.getOccuredEvents().add(EventEvent15);
	}
	
	
	public Event<Void> getEventEvent15() {
		return EventEvent15;
	}
	
	public void raiseEvent16() {
		statemachine.getOccuredEvents().add(EventEvent16);
	}
	
	
	public Event<Void> getEventEvent16() {
		return EventEvent16;
	}
	
	
	private int varS1;
	
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
