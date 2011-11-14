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
package org.yakindu.sct.runtime.java.test_expression;

import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import org.yakindu.sct.runtime.java.Event;
import org.yakindu.sct.runtime.java.ITimedStatemachine;
import org.yakindu.sct.runtime.java.ITimerHandler;
import org.yakindu.sct.runtime.java.TimerHandler;
import org.yakindu.sct.runtime.java.EventNotification;
import org.yakindu.sct.runtime.java.Notification;

public abstract class Test_ExpressionAbstractBaseStatemachine implements ITimedStatemachine {
	
	
	
	
	public enum State {
	      State1,
	      State2,
	};
	
	private InterfaceDefaultImpl interfaceDefault;
	
	

	private final Set<State> activeStates = EnumSet.noneOf(State.class);
	
	private final Collection<Event> occuredEvents;
	
	private final Collection<Event> outEvents;
	
	private ITimerHandler timerHandler;
	
	public Test_ExpressionAbstractBaseStatemachine(Collection<Event> occuredEvents) {
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
	
	public InterfaceDefault getInterfaceDefault() {
		return interfaceDefault;
	}
	

	private boolean conditionState1Tr0(Collection<?> events) {
		return getOccuredEvents().contains(interfaceDefault.getEventEvent1());
	}
	private boolean conditionState2Tr0(Collection<?> events) {
		return getOccuredEvents().contains(interfaceDefault.getEventEvent1());
	}
	private void actionsState1Tr0() {
	activeStates.remove(State.State1);
	activeStates.add(State.State2);

	}
	private void actionsState2Tr0() {
	activeStates.remove(State.State2);
	activeStates.add(State.State1);

	}
	private void cycleState1(Collection<?> events) {
if (conditionState1Tr0(events) ) { 
actionsState1Tr0();
}
	}
	private void cycleState2(Collection<?> events) {
if (conditionState2Tr0(events) ) { 
actionsState2Tr0();
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
			default:
				// no state found
			}
		}
	}
}
