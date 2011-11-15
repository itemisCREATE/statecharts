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

import org.yakindu.sct.runtime.java.Event;

public class InterfaceDefaultImpl implements InterfaceDefault {
	
	private final Event EventEvent1 = new Event("Event1"); 
	private final Event EventEvent2 = new Event("Event2"); 
	private final Event EventEvent3 = new Event("Event3"); 
	private final Event EventEvent4 = new Event("Event4"); 
	
	private Test_LocalActionsAbstractBaseStatemachine statemachine; 
	
	public InterfaceDefaultImpl(Test_LocalActionsAbstractBaseStatemachine statemachine) {
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
