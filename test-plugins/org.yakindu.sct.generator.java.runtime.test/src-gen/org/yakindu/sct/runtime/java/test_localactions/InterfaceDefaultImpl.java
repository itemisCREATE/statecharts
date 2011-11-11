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
package org.yakindu.sct.runtime.java.test_localactions;

import org.yakindu.sct.runtime.java.EventNotification;
import org.yakindu.sct.runtime.java.Event;

public class InterfaceDefaultImpl implements InterfaceDefault {
	
	private final Event<Void> EventEvent1 = new Event<Void>("Event1", null); 
	private final Event<Void> EventEvent2 = new Event<Void>("Event2", null); 
	private final Event<Void> EventEvent3 = new Event<Void>("Event3", null); 
	private final Event<Void> EventEvent4 = new Event<Void>("Event4", null); 
	
	private Test_LocalActionsAbstractBaseStatemachine statemachine; 
	
	public InterfaceDefaultImpl(Test_LocalActionsAbstractBaseStatemachine statemachine) {
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
