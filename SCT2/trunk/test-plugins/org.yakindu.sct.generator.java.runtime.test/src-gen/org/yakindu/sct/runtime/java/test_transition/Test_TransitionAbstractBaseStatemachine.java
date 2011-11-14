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

import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import org.yakindu.sct.runtime.java.Event;
import org.yakindu.sct.runtime.java.TimeEvent;
import org.yakindu.sct.runtime.java.ITimedStatemachine;
import org.yakindu.sct.runtime.java.ITimerHandler;
import org.yakindu.sct.runtime.java.TimerHandler;
import org.yakindu.sct.runtime.java.EventNotification;
import org.yakindu.sct.runtime.java.Notification;
import org.yakindu.sct.runtime.java.ValuedEvent;

public abstract class Test_TransitionAbstractBaseStatemachine implements ITimedStatemachine {
	
	private final ValuedEvent<Integer> EventEvent10 = new ValuedEvent<Integer>("event10", 0); 
	
	private static final TimeEvent State1_time_event_0 = new TimeEvent("State1_time_event_0", false); 
	private static final TimeEvent State1_time_event_1 = new TimeEvent("State1_time_event_1", false); 
	
	
	public enum State {
	      State1,
	      State2,
	};
	
	private InterfaceAImpl interfaceA;
	private InterfaceDefaultImpl interfaceDefault;
	
	

	private final Set<State> activeStates = EnumSet.noneOf(State.class);
	
	private final Collection<Event> occuredEvents;
	
	private final Collection<Event> outEvents;
	
	private ITimerHandler timerHandler;
	
	public Test_TransitionAbstractBaseStatemachine(Collection<Event> occuredEvents) {
		this.occuredEvents = occuredEvents;
		this.outEvents = new HashSet<Event>();
		interfaceA = new InterfaceAImpl(this);
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
			timerHandler = new TimerHandler(this);
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
	
	public InterfaceA getInterfaceA() {
		return interfaceA;
	}
	
	public InterfaceDefault getInterfaceDefault() {
		return interfaceDefault;
	}
	
	private void raiseEvent10() {
		getOccuredEvents().add(EventEvent10);
	}
	
	private void raiseEvent10(int value) {
		EventEvent10.setValue(value);
		getOccuredEvents().add(EventEvent10);
	}
	
	private int getEventValueEvent10() {
		return EventEvent10.getValue();
	}

	private boolean conditionState1Tr0(Collection<?> events) {
		return (getOccuredEvents().contains(interfaceA.getEventEvent1()) || getOccuredEvents().contains(interfaceA.getEventEvent2()));
	}
	private boolean conditionState1Tr1(Collection<?> events) {
		return (interfaceDefault.getVarI() == 5);
	}
	private boolean conditionState1Tr2(Collection<?> events) {
		return (getOccuredEvents().contains(interfaceA.getEventEvent3()) && (interfaceDefault.getVarJ() < 20));
	}
	private boolean conditionState1Tr3(Collection<?> events) {
		return ((getOccuredEvents().contains(interfaceA.getEventEvent3()) || getOccuredEvents().contains(interfaceA.getEventEvent4())) && (interfaceDefault.getVarJ() > 30));
	}
	private boolean conditionState1Tr4(Collection<?> events) {
		return getOccuredEvents().contains(interfaceDefault.getEventEvent6());
	}
	private boolean conditionState1Tr5(Collection<?> events) {
		return getOccuredEvents().contains(interfaceDefault.getEventEvent7());
	}
	private boolean conditionState1Tr6(Collection<?> events) {
		return getOccuredEvents().contains(State1_time_event_0);
	}
	private boolean conditionState1Tr7(Collection<?> events) {
		return getOccuredEvents().contains(State1_time_event_1);
	}
	private boolean conditionState1Tr8(Collection<?> events) {
		return getOccuredEvents().contains(interfaceA.getEventEvent1());
	}
	private void actionsState1Tr0() {
exitActionsState1();
	activeStates.remove(State.State1);
	activeStates.add(State.State2);

	}
	private void actionsState1Tr1() {
exitActionsState1();
	activeStates.remove(State.State1);
	activeStates.add(State.State2);

	}
	private void actionsState1Tr2() {
exitActionsState1();
	activeStates.remove(State.State1);
	activeStates.add(State.State2);

	}
	private void actionsState1Tr3() {
exitActionsState1();
	activeStates.remove(State.State1);
	activeStates.add(State.State2);

	}
	private void actionsState1Tr4() {
exitActionsState1();
	activeStates.remove(State.State1);
	interfaceDefault.setVarI(15);

	activeStates.add(State.State2);

	}
	private void actionsState1Tr5() {
exitActionsState1();
	activeStates.remove(State.State1);
	interfaceDefault.setVarJ((interfaceDefault.getVarI() * 9));

	activeStates.add(State.State2);

	}
	private void actionsState1Tr6() {
exitActionsState1();
	activeStates.remove(State.State1);
	activeStates.add(State.State2);

	}
	private void actionsState1Tr7() {
exitActionsState1();
	activeStates.remove(State.State1);
	activeStates.add(State.State2);

	}
	private void actionsState1Tr8() {
exitActionsState1();
	activeStates.remove(State.State1);
	activeStates.add(State.State2);

	}
	private void cycleState1(Collection<?> events) {
if (conditionState1Tr0(events) ) { 
actionsState1Tr0();
}
else {
if (conditionState1Tr1(events) ) { 
actionsState1Tr1();
}
else {
if (conditionState1Tr2(events) ) { 
actionsState1Tr2();
}
else {
if (conditionState1Tr3(events) ) { 
actionsState1Tr3();
}
else {
if (conditionState1Tr4(events) ) { 
actionsState1Tr4();
}
else {
if (conditionState1Tr5(events) ) { 
actionsState1Tr5();
}
else {
if (conditionState1Tr6(events) ) { 
actionsState1Tr6();
}
else {
if (conditionState1Tr7(events) ) { 
actionsState1Tr7();
}
else {
if (conditionState1Tr8(events) ) { 
actionsState1Tr8();
}
}
}
}
}
}
}
}
}
	}
	private void cycleState2(Collection<?> events) {
	}
	private void entryActionsState1() {
getTimerHandler().setTimer(State1_time_event_0, (10 * 1000));
getTimerHandler().setTimer(State1_time_event_1, 100);

	}
	private void exitActionsState1() {
getTimerHandler().resetTimer(State1_time_event_0);
getTimerHandler().resetTimer(State1_time_event_1);

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
			default:
				// no state found
			}
		}
	}
}
