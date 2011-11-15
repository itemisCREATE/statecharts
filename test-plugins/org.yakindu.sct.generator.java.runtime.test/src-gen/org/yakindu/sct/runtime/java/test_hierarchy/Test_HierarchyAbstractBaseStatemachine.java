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

import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import org.yakindu.sct.runtime.java.Event;
import org.yakindu.sct.runtime.java.ITimedStatemachine;
import org.yakindu.sct.runtime.java.ITimerHandler;
import org.yakindu.sct.runtime.java.EventNotification;
import org.yakindu.sct.runtime.java.Notification;

public abstract class Test_HierarchyAbstractBaseStatemachine implements ITimedStatemachine {
	
	
	
	
	public enum State {
	      State1,
	      State9,
	      State10,
	      State2,
	      State3,
	      State4,
	      State5,
	      State6,
	      State7,
	      State8,
	};
	
	private InterfaceDefaultImpl interfaceDefault;
	
	

	private final Set<State> activeStates = EnumSet.noneOf(State.class);
	
	private final Collection<Event> occuredEvents;
	
	private final Collection<Event> outEvents;
	
	private ITimerHandler timerHandler;
	
	public Test_HierarchyAbstractBaseStatemachine(Collection<Event> occuredEvents) {
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
		entryActionsState1();
		
		
	}
	
	protected boolean eventOccured() {
		return !getOccuredEvents().isEmpty();
	}
	
	@Override
	public void init() {
		
	}

	@Override
	public void setTimerHandler(ITimerHandler timerHandler) {
		this.timerHandler = timerHandler;
	}

	@Override
	public ITimerHandler getTimerHandler() {
		if (timerHandler == null) {
			throw new NullPointerException("TimerHandler of statemachine \"+Test_Hierarchy+\" not set!");
		}
		return timerHandler;
	}
	
	@Override
	public void notify(Notification<?> notification) {
		if (notification instanceof EventNotification) {
			EventNotification eventNotification = (EventNotification) notification;
			getOccuredEvents().add(eventNotification.getElement());
		}
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
	private boolean conditionState9Tr0(Collection<?> events) {
		return getOccuredEvents().contains(interfaceDefault.getEventEvent9());
	}
	private boolean conditionState10Tr0(Collection<?> events) {
		return getOccuredEvents().contains(interfaceDefault.getEventEvent10());
	}
	private boolean conditionState2Tr0(Collection<?> events) {
		return getOccuredEvents().contains(interfaceDefault.getEventEvent6());
	}
	private boolean conditionState3Tr0(Collection<?> events) {
		return getOccuredEvents().contains(interfaceDefault.getEventEvent2());
	}
	private boolean conditionState3Tr1(Collection<?> events) {
		return getOccuredEvents().contains(interfaceDefault.getEventEvent11());
	}
	private boolean conditionState3Tr2(Collection<?> events) {
		return getOccuredEvents().contains(interfaceDefault.getEventEvent14());
	}
	private boolean conditionState4Tr0(Collection<?> events) {
		return getOccuredEvents().contains(interfaceDefault.getEventEvent7());
	}
	private boolean conditionState5Tr0(Collection<?> events) {
		return getOccuredEvents().contains(interfaceDefault.getEventEvent3());
	}
	private boolean conditionState5Tr1(Collection<?> events) {
		return getOccuredEvents().contains(interfaceDefault.getEventEvent12());
	}
	private boolean conditionState5Tr2(Collection<?> events) {
		return getOccuredEvents().contains(interfaceDefault.getEventEvent15());
	}
	private boolean conditionState6Tr0(Collection<?> events) {
		return getOccuredEvents().contains(interfaceDefault.getEventEvent8());
	}
	private boolean conditionState7Tr0(Collection<?> events) {
		return getOccuredEvents().contains(interfaceDefault.getEventEvent4());
	}
	private boolean conditionState8Tr0(Collection<?> events) {
		return getOccuredEvents().contains(interfaceDefault.getEventEvent5());
	}
	private boolean conditionState8Tr1(Collection<?> events) {
		return getOccuredEvents().contains(interfaceDefault.getEventEvent13());
	}
	private boolean conditionState8Tr2(Collection<?> events) {
		return getOccuredEvents().contains(interfaceDefault.getEventEvent16());
	}
	private void actionsState1Tr0() {
exitActionsState1();
	activeStates.remove(State.State1);
	activeStates.add(State.State2);
entryActionsState2();

	}
	private void actionsState9Tr0() {
exitActionsState9();
	activeStates.remove(State.State9);
	activeStates.add(State.State10);
entryActionsState10();

	}
	private void actionsState10Tr0() {
exitActionsState10();
	activeStates.remove(State.State10);
	activeStates.add(State.State9);
entryActionsState9();

	}
	private void actionsState2Tr0() {
exitActionsState2();
	activeStates.remove(State.State2);
	activeStates.add(State.State1);
entryActionsState1();

	}
	private void actionsState3Tr0() {
exitActionsState3();
	activeStates.remove(State.State3);
	activeStates.add(State.State4);
entryActionsState4();

	}
	private void actionsState3Tr1() {
exitActionsState3();
	activeStates.remove(State.State3);
	activeStates.add(State.State1);
entryActionsState1();

	}
	private void actionsState3Tr2() {
exitActionsState3();
	activeStates.remove(State.State3);
	activeStates.add(State.State9);
entryActionsState9();

	}
	private void actionsState4Tr0() {
exitActionsState4();
	activeStates.remove(State.State4);
	activeStates.add(State.State3);
entryActionsState3();

	}
	private void actionsState5Tr0() {
exitActionsState5();
	activeStates.remove(State.State5);
	activeStates.add(State.State6);
entryActionsState6();

	}
	private void actionsState5Tr1() {
exitActionsState5();
	activeStates.remove(State.State5);
	activeStates.add(State.State1);
entryActionsState1();

	}
	private void actionsState5Tr2() {
exitActionsState5();
	activeStates.remove(State.State5);
	activeStates.add(State.State10);
entryActionsState10();

	}
	private void actionsState6Tr0() {
exitActionsState6();
	activeStates.remove(State.State6);
	activeStates.add(State.State5);
entryActionsState5();

	}
	private void actionsState7Tr0() {
exitActionsState7();
	activeStates.remove(State.State7);
	activeStates.add(State.State8);
entryActionsState8();

	}
	private void actionsState8Tr0() {
exitActionsState8();
	activeStates.remove(State.State8);
	activeStates.add(State.State7);
entryActionsState7();

	}
	private void actionsState8Tr1() {
exitActionsState8();
	activeStates.remove(State.State8);
	activeStates.add(State.State1);
entryActionsState1();

	}
	private void actionsState8Tr2() {
exitActionsState8();
	activeStates.remove(State.State8);
	activeStates.add(State.State10);
entryActionsState10();

	}
	private void cycleState1(Collection<?> events) {
	}
	private void cycleState9(Collection<?> events) {
if (conditionState9Tr0(events) ) { 
actionsState9Tr0();
}
	}
	private void cycleState10(Collection<?> events) {
if (conditionState10Tr0(events) ) { 
actionsState10Tr0();
}
	}
	private void cycleState2(Collection<?> events) {
	}
	private void cycleState3(Collection<?> events) {
if (conditionState3Tr0(events) ) { 
actionsState3Tr0();
}
else {
if (conditionState3Tr1(events) ) { 
actionsState3Tr1();
}
else {
if (conditionState3Tr2(events) ) { 
actionsState3Tr2();
}
}
}
	}
	private void cycleState4(Collection<?> events) {
	}
	private void cycleState5(Collection<?> events) {
if (conditionState5Tr0(events) ) { 
actionsState5Tr0();
}
else {
if (conditionState5Tr1(events) ) { 
actionsState5Tr1();
}
else {
if (conditionState5Tr2(events) ) { 
actionsState5Tr2();
}
}
}
	}
	private void cycleState6(Collection<?> events) {
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
else {
if (conditionState8Tr1(events) ) { 
actionsState8Tr1();
}
else {
if (conditionState8Tr2(events) ) { 
actionsState8Tr2();
}
}
}
	}
	private void entryActionsState1() {
	interfaceDefault.setVarS1(1);


	}
	private void entryActionsState9() {
	interfaceDefault.setVarS1(interfaceDefault.getVarS1() + (1));


	}
	private void entryActionsState10() {
	interfaceDefault.setVarS1(interfaceDefault.getVarS1() + (1));


	}
	private void entryActionsState2() {
	interfaceDefault.setVarS2(1);


	}
	private void entryActionsState3() {
	interfaceDefault.setVarS2(interfaceDefault.getVarS2() + (1));


	}
	private void entryActionsState4() {
	interfaceDefault.setVarS2(interfaceDefault.getVarS2() + (1));


	}
	private void entryActionsState5() {
	interfaceDefault.setVarS2(interfaceDefault.getVarS2() + (1));


	}
	private void entryActionsState6() {
	interfaceDefault.setVarS2(interfaceDefault.getVarS2() + (1));


	}
	private void entryActionsState7() {
	interfaceDefault.setVarS2(interfaceDefault.getVarS2() + (1));


	}
	private void entryActionsState8() {
	interfaceDefault.setVarS2(interfaceDefault.getVarS2() + (1));


	}
	private void exitActionsState1() {
	interfaceDefault.setVarS1(interfaceDefault.getVarS1() - (1));


	}
	private void exitActionsState9() {
	interfaceDefault.setVarS1(interfaceDefault.getVarS1() - (1));


	}
	private void exitActionsState10() {
	interfaceDefault.setVarS1(interfaceDefault.getVarS1() - (1));


	}
	private void exitActionsState2() {
	interfaceDefault.setVarS2(interfaceDefault.getVarS2() - (1));


	}
	private void exitActionsState3() {
	interfaceDefault.setVarS2(interfaceDefault.getVarS2() - (1));


	}
	private void exitActionsState4() {
	interfaceDefault.setVarS2(interfaceDefault.getVarS2() - (1));


	}
	private void exitActionsState5() {
	interfaceDefault.setVarS2(interfaceDefault.getVarS2() - (1));


	}
	private void exitActionsState6() {
	interfaceDefault.setVarS2(interfaceDefault.getVarS2() - (1));


	}
	private void exitActionsState7() {
	interfaceDefault.setVarS2(interfaceDefault.getVarS2() - (1));


	}
	private void exitActionsState8() {
	interfaceDefault.setVarS2(interfaceDefault.getVarS2() - (1));


	}

	protected void runCycle(Collection<?> events) {
		getOutEvents().clear();
		for (State state : activeStates) {
			switch (state) {
    		case State1:
        		cycleState1(events);
        		break;
    		case State9:
        		cycleState9(events);
        		break;
    		case State10:
        		cycleState10(events);
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
