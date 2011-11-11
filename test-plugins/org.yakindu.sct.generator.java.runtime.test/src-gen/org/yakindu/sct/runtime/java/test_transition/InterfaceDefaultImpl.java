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

import org.yakindu.sct.runtime.java.EventNotification;
import org.yakindu.sct.runtime.java.Event;
import org.yakindu.sct.runtime.java.NotificationSender;

public class InterfaceDefaultImpl extends NotificationSender implements InterfaceDefault {
	
	private final Event<Boolean> EventEvent5 = new Event<Boolean>("event5", false); 
	private final Event<Void> EventEvent6 = new Event<Void>("event6", null); 
	private final Event<Void> EventEvent7 = new Event<Void>("event7", null); 
	
	private Test_TransitionAbstractBaseStatemachine statemachine; 
	
	public InterfaceDefaultImpl(Test_TransitionAbstractBaseStatemachine statemachine) {
		this.statemachine = statemachine;
	}
	
	public void raiseEvent5() {
		statemachine.getOccuredEvents().add(EventEvent5);
	}
	
	public void raiseEvent5(boolean value) {
		EventEvent5.setValue(value);
		statemachine.getOccuredEvents().add(EventEvent5);
	}
	
	public Event<Boolean> getEventEvent5() {
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
		statemachine.getOutEvents().add(EventEvent7);
		notifyListeners(new EventNotification(EventEvent7));
	}
	
	
	public Event<Void> getEventEvent7() {
		return EventEvent7;
	}
	
	public boolean isRaisedEvent7() {
		return statemachine.getOutEvents().contains(EventEvent7);
	}
	
	private int varI;
	
	public int getVarI() {
		return varI;
	}
	
	public void setVarI(int value) {
		varI = value;
	}	
	private double varJ;
	
	public double getVarJ() {
		return varJ;
	}
	
	public void setVarJ(double value) {
		varJ = value;
	}	
}
