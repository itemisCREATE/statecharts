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

import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import org.yakindu.sct.runtime.java.Event;
import org.yakindu.sct.runtime.java.IStatemachine;

public abstract class Test_ParallelRegionsAbstractBaseStatemachine implements IStatemachine {
	
	
	
	
	public enum State {
	      State1,
	      State2,
	      State3,
	      State4,
	      State5,
	      State6,
	      State9,
	      State7,
	      State8,
	};
	
	private InterfaceDefaultImpl interfaceDefault;

	private final Set<State> activeStates = EnumSet.noneOf(State.class);
	
	private final Collection<Event> occuredEvents;
	
	private final Collection<Event> outEvents;
	
	
	public Test_ParallelRegionsAbstractBaseStatemachine(Collection<Event> occuredEvents) {
		this.occuredEvents = occuredEvents;
		this.outEvents = new HashSet<Event>();
		interfaceDefault = new InterfaceDefaultImpl(this);
	}
	
	protected Collection<Event> getOccuredEvents() {
		return occuredEvents;
	}
	
	protected Collection<Event> getOutEvents(){
		return outEvents;
	}
		
	public void entry() {
	activeStates.add(State.State1);
		
		
	}
	
	protected boolean eventOccured() {
		return !getOccuredEvents().isEmpty();
	}

	public void init() {
		
	}
	
		
	public Set<State> getActiveStates(){
		return EnumSet.copyOf(activeStates);
	}
	
	public InterfaceDefault getInterfaceDefault() {
		return interfaceDefault;
	}
	
	private boolean conditionState1Tr0(Collection<?> events) {
		return getOccuredEvents().contains(interfaceDefault.getEventEvent1());
	}
	private boolean conditionState3Tr0(Collection<?> events) {
		return getOccuredEvents().contains(interfaceDefault.getEventEvent2());
	}
	private boolean conditionState5Tr0(Collection<?> events) {
		return getOccuredEvents().contains(interfaceDefault.getEventEvent3());
	}
	private boolean conditionState6Tr0(Collection<?> events) {
		return getOccuredEvents().contains(interfaceDefault.getEventEvent4());
	}
	private boolean conditionState7Tr0(Collection<?> events) {
		return (getOccuredEvents().contains(interfaceDefault.getEventEvent5()) || getOccuredEvents().contains(interfaceDefault.getEventEvent3()));
	}
	private boolean conditionState8Tr0(Collection<?> events) {
		return getOccuredEvents().contains(interfaceDefault.getEventEvent6());
	}
	private void actionsState1Tr0() {
	activeStates.remove(State.State1);
	activeStates.add(State.State2);

	}
	private void actionsState3Tr0() {
	activeStates.remove(State.State3);
	activeStates.add(State.State4);

	}
	private void actionsState5Tr0() {
	activeStates.remove(State.State5);
	activeStates.add(State.State6);

	}
	private void actionsState6Tr0() {
	activeStates.remove(State.State6);
	activeStates.add(State.State5);

	}
	private void actionsState7Tr0() {
	activeStates.remove(State.State7);
	activeStates.add(State.State8);

	}
	private void actionsState8Tr0() {
	activeStates.remove(State.State8);
	activeStates.add(State.State7);

	}
	private void cycleState1(Collection<?> events) {
if (conditionState1Tr0(events) ) { 
actionsState1Tr0();
}
	}
	private void cycleState2(Collection<?> events) {
	}
	private void cycleState3(Collection<?> events) {
if (conditionState3Tr0(events) ) { 
actionsState3Tr0();
}
	}
	private void cycleState4(Collection<?> events) {
	}
	private void cycleState5(Collection<?> events) {
if (conditionState5Tr0(events) ) { 
actionsState5Tr0();
}
	}
	private void cycleState6(Collection<?> events) {
if (conditionState6Tr0(events) ) { 
actionsState6Tr0();
}
	}
	private void cycleState9(Collection<?> events) {
	}
	private void cycleState7(Collection<?> events) {
if (conditionState7Tr0(events) ) { 
actionsState7Tr0();
}
	}
	private void cycleState8(Collection<?> events) {
if (conditionState8Tr0(events) ) { 
actionsState8Tr0();
}
	}
	protected void runCycle(Collection<?> events) {
		getOutEvents().clear();
		for (State state : activeStates) {
			switch (state) {
    		case State1:
        		cycleState1(events);
        		break;
    		case State2:
        		cycleState2(events);
        		break;
    		case State3:
        		cycleState3(events);
        		break;
    		case State4:
        		cycleState4(events);
        		break;
    		case State5:
        		cycleState5(events);
        		break;
    		case State6:
        		cycleState6(events);
        		break;
    		case State9:
        		cycleState9(events);
        		break;
    		case State7:
        		cycleState7(events);
        		break;
    		case State8:
        		cycleState8(events);
        		break;
			default:
				// no state found
			}
		}
	}
}
