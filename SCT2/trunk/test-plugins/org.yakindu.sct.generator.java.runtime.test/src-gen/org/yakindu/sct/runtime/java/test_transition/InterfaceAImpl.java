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
package org.yakindu.sct.runtime.java.test_transition;

import org.yakindu.sct.runtime.java.Event;
import org.yakindu.sct.runtime.java.EventNotification;
import org.yakindu.sct.runtime.java.NotificationSender;
import org.yakindu.sct.runtime.java.ValuedEvent;

public class InterfaceAImpl extends NotificationSender implements InterfaceA {
	
	private final ValuedEvent<Integer> EventEvent1 = new ValuedEvent<Integer>("event1", 1); 
	private final Event EventEvent2 = new Event("event2"); 
	private final Event EventEvent3 = new Event("event3"); 
	private final Event EventEvent4 = new Event("event4"); 
	
	private Test_TransitionAbstractBaseStatemachine statemachine; 
	
	public InterfaceAImpl(Test_TransitionAbstractBaseStatemachine statemachine) {
		this.statemachine = statemachine;
	}
	
	public void raiseEvent1() {
		statemachine.getOccuredEvents().add(EventEvent1);
	}
	
	public void raiseEvent1(int value) {
		EventEvent1.setValue(value);
		statemachine.getOccuredEvents().add(EventEvent1);
	}
	
	public ValuedEvent<Integer> getEventEvent1() {
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
		statemachine.getOutEvents().add(EventEvent4);
		notifyListeners(new EventNotification(EventEvent4));
	}
	
	
	public Event getEventEvent4() {
		return EventEvent4;
	}
	
	public boolean isRaisedEvent4() {
		return statemachine.getOutEvents().contains(EventEvent4);
	}
	
}
