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
package org.yakindu.sct.runtime.java.test_parallelregions;

import org.yakindu.sct.runtime.java.EventNotification;
import org.yakindu.sct.runtime.java.Event;

public class InterfaceDefaultImpl implements InterfaceDefault {
	
	private final Event EventEvent1 = new Event("event1"); 
	private final Event EventEvent2 = new Event("event2"); 
	private final Event EventEvent3 = new Event("event3"); 
	private final Event EventEvent4 = new Event("event4"); 
	private final Event EventEvent5 = new Event("event5"); 
	private final Event EventEvent6 = new Event("event6"); 
	
	private Test_ParallelRegionsAbstractBaseStatemachine statemachine; 
	
	public InterfaceDefaultImpl(Test_ParallelRegionsAbstractBaseStatemachine statemachine) {
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
	
	
}
