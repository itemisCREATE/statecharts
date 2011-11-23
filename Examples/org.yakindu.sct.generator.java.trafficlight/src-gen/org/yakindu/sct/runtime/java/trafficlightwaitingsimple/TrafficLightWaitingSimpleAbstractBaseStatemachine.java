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
package org.yakindu.sct.runtime.java.trafficlightwaitingsimple;

import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import org.yakindu.sct.runtime.java.Event;
import org.yakindu.sct.runtime.java.TimeEvent;
import org.yakindu.sct.runtime.java.ITimedStatemachine;
import org.yakindu.sct.runtime.java.ITimerHandler;
import org.yakindu.sct.runtime.java.EventNotification;
import org.yakindu.sct.runtime.java.Notification;

public abstract class TrafficLightWaitingSimpleAbstractBaseStatemachine implements ITimedStatemachine {
	
	
	private static final TimeEvent StreetAttention_time_event_0 = new TimeEvent("StreetAttention_time_event_0", false); 
	private static final TimeEvent StreetRed_time_event_0 = new TimeEvent("StreetRed_time_event_0", false); 
	private static final TimeEvent PedestrianGreen_time_event_0 = new TimeEvent("PedestrianGreen_time_event_0", false); 
	private static final TimeEvent PedestrianRed_time_event_0 = new TimeEvent("PedestrianRed_time_event_0", false); 
	private static final TimeEvent StreetPrepare_time_event_0 = new TimeEvent("StreetPrepare_time_event_0", false); 
	private static final TimeEvent WaitOn_time_event_0 = new TimeEvent("WaitOn_time_event_0", false); 
	private static final TimeEvent WaitOff_time_event_0 = new TimeEvent("WaitOff_time_event_0", false); 
	
	
	public enum State {
	      StreetGreen,
	      StreetAttention,
	      StreetRed,
	      PedestrianGreen,
	      PedestrianRed,
	      StreetPrepare,
	      WaitOn,
	      WaitOff,
	};
	
	private InterfaceTrafficLightImpl interfaceTrafficLight;
	private InterfacePedestrianImpl interfacePedestrian;
	private InterfaceDefaultImpl interfaceDefault;
	private int varCycle;
	

	private final Set<State> activeStates = EnumSet.noneOf(State.class);
	
	private final Collection<Event> occuredEvents;
	
	private final Collection<Event> outEvents;
	
	private ITimerHandler timerHandler;
	
	private long cycleStartTime;
	
	public TrafficLightWaitingSimpleAbstractBaseStatemachine(Collection<Event> occuredEvents) {
		this.occuredEvents = occuredEvents;
		this.outEvents = new HashSet<Event>();
		interfaceTrafficLight = new InterfaceTrafficLightImpl(this);
		interfacePedestrian = new InterfacePedestrianImpl(this);
		interfaceDefault = new InterfaceDefaultImpl(this);
	}
	
	protected Collection<Event> getOccuredEvents() {
		return occuredEvents;
	}
	
	protected Collection<Event> getOutEvents(){
		return outEvents;
	}
		
	public void entry() {
		cycleStartTime = System.currentTimeMillis();
	activeStates.add(State.StreetGreen);
		entryActionsStreetGreen();
		
		
	}
	
	protected boolean eventOccured() {
		return !getOccuredEvents().isEmpty();
	}
	
	public void init() {
		
	}
	
	public void setTimerHandler(ITimerHandler timerHandler) {
		this.timerHandler = timerHandler;
	}

	public ITimerHandler getTimerHandler() {
		if (timerHandler == null) {
			throw new NullPointerException("TimerHandler of statemachine \"+TrafficLightWaitingSimple+\" not set!");
		}
		return timerHandler;
	}

	public void notify(Notification<?> notification) {
		if (notification instanceof EventNotification) {
			EventNotification eventNotification = (EventNotification) notification;
			getOccuredEvents().add(eventNotification.getElement());
		}
	}
		
	public Set<State> getActiveStates(){
		return EnumSet.copyOf(activeStates);
	}
	
	public InterfaceTrafficLight getInterfaceTrafficLight() {
		return interfaceTrafficLight;
	}
	
	public InterfacePedestrian getInterfacePedestrian() {
		return interfacePedestrian;
	}
	
	public InterfaceDefault getInterfaceDefault() {
		return interfaceDefault;
	}
	
	private int getVarCycle() {
		return varCycle;
	}
	
	private void setVarCycle(int value) {
		varCycle = value;
	}	
	
	private boolean conditionStreetGreenTr0(Collection<?> events) {
		return getOccuredEvents().contains(interfaceDefault.getEventKeypress1());
	}
	private boolean conditionStreetAttentionTr0(Collection<?> events) {
		return getOccuredEvents().contains(StreetAttention_time_event_0);
	}
	private boolean conditionStreetRedTr0(Collection<?> events) {
		return getOccuredEvents().contains(StreetRed_time_event_0);
	}
	private boolean conditionPedestrianGreenTr0(Collection<?> events) {
		return getOccuredEvents().contains(PedestrianGreen_time_event_0);
	}
	private boolean conditionPedestrianRedTr0(Collection<?> events) {
		return getOccuredEvents().contains(PedestrianRed_time_event_0);
	}
	private boolean conditionStreetPrepareTr0(Collection<?> events) {
		return getOccuredEvents().contains(StreetPrepare_time_event_0);
	}
	private boolean conditionWaitOnTr0(Collection<?> events) {
		return getOccuredEvents().contains(WaitOn_time_event_0);
	}
	private boolean conditionWaitOffTr0(Collection<?> events) {
		return (getVarCycle() >= 7);
	}
	private boolean conditionWaitOffTr1(Collection<?> events) {
		return getOccuredEvents().contains(WaitOff_time_event_0);
	}
	private void actionsStreetGreenTr0() {
	activeStates.remove(State.StreetGreen);
	setVarCycle(1);

	activeStates.add(State.WaitOn);
entryActionsWaitOn();

	}
	private void actionsStreetAttentionTr0() {
exitActionsStreetAttention();
	activeStates.remove(State.StreetAttention);
	activeStates.add(State.StreetRed);
entryActionsStreetRed();

	}
	private void actionsStreetRedTr0() {
exitActionsStreetRed();
	activeStates.remove(State.StreetRed);
	activeStates.add(State.PedestrianGreen);
entryActionsPedestrianGreen();

	}
	private void actionsPedestrianGreenTr0() {
exitActionsPedestrianGreen();
	activeStates.remove(State.PedestrianGreen);
	activeStates.add(State.PedestrianRed);
entryActionsPedestrianRed();

	}
	private void actionsPedestrianRedTr0() {
exitActionsPedestrianRed();
	activeStates.remove(State.PedestrianRed);
	activeStates.add(State.StreetPrepare);
entryActionsStreetPrepare();

	}
	private void actionsStreetPrepareTr0() {
exitActionsStreetPrepare();
	activeStates.remove(State.StreetPrepare);
	activeStates.add(State.StreetGreen);
entryActionsStreetGreen();

	}
	private void actionsWaitOnTr0() {
exitActionsWaitOn();
	activeStates.remove(State.WaitOn);
	activeStates.add(State.WaitOff);
entryActionsWaitOff();

	}
	private void actionsWaitOffTr0() {
exitActionsWaitOff();
	activeStates.remove(State.WaitOff);
	activeStates.add(State.StreetAttention);
entryActionsStreetAttention();

	}
	private void actionsWaitOffTr1() {
exitActionsWaitOff();
	activeStates.remove(State.WaitOff);
	setVarCycle(getVarCycle() + (1));

	activeStates.add(State.WaitOn);
entryActionsWaitOn();

	}
	private void cycleStreetGreen(Collection<?> events) {
if (conditionStreetGreenTr0(events) ) { 
actionsStreetGreenTr0();
}
	}
	private void cycleStreetAttention(Collection<?> events) {
if (conditionStreetAttentionTr0(events) ) { 
actionsStreetAttentionTr0();
}
	}
	private void cycleStreetRed(Collection<?> events) {
if (conditionStreetRedTr0(events) ) { 
actionsStreetRedTr0();
}
	}
	private void cyclePedestrianGreen(Collection<?> events) {
if (conditionPedestrianGreenTr0(events) ) { 
actionsPedestrianGreenTr0();
}
	}
	private void cyclePedestrianRed(Collection<?> events) {
if (conditionPedestrianRedTr0(events) ) { 
actionsPedestrianRedTr0();
}
	}
	private void cycleStreetPrepare(Collection<?> events) {
if (conditionStreetPrepareTr0(events) ) { 
actionsStreetPrepareTr0();
}
	}
	private void cycleWaitOn(Collection<?> events) {
if (conditionWaitOnTr0(events) ) { 
actionsWaitOnTr0();
}
	}
	private void cycleWaitOff(Collection<?> events) {
if (conditionWaitOffTr0(events) ) { 
actionsWaitOffTr0();
}
else {
if (conditionWaitOffTr1(events) ) { 
actionsWaitOffTr1();
}
}
	}
	private void entryActionsStreetGreen() {
	interfaceTrafficLight.setVarRed(false);
	interfaceTrafficLight.setVarYellow(false);
	interfaceTrafficLight.setVarGreen(true);
	interfacePedestrian.setVarRed(true);
	interfacePedestrian.setVarGreen(false);
	interfacePedestrian.setVarRequest(false);


	}
	private void entryActionsStreetAttention() {
getTimerHandler().setTimer(StreetAttention_time_event_0, (2 * 1000), cycleStartTime);
	interfaceTrafficLight.setVarRed(false);
	interfaceTrafficLight.setVarYellow(true);
	interfaceTrafficLight.setVarGreen(false);


	}
	private void entryActionsStreetRed() {
getTimerHandler().setTimer(StreetRed_time_event_0, (2 * 1000), cycleStartTime);
	interfaceTrafficLight.setVarRed(true);
	interfaceTrafficLight.setVarYellow(false);
	interfaceTrafficLight.setVarGreen(false);


	}
	private void entryActionsPedestrianGreen() {
getTimerHandler().setTimer(PedestrianGreen_time_event_0, (7 * 1000), cycleStartTime);
	interfacePedestrian.setVarRed(false);
	interfacePedestrian.setVarGreen(true);


	}
	private void entryActionsPedestrianRed() {
getTimerHandler().setTimer(PedestrianRed_time_event_0, (3 * 1000), cycleStartTime);
	interfacePedestrian.setVarRed(true);
	interfacePedestrian.setVarGreen(false);


	}
	private void entryActionsStreetPrepare() {
getTimerHandler().setTimer(StreetPrepare_time_event_0, (2 * 1000), cycleStartTime);
	interfaceTrafficLight.setVarRed(true);
	interfaceTrafficLight.setVarYellow(true);
	interfaceTrafficLight.setVarGreen(false);


	}
	private void entryActionsWaitOn() {
getTimerHandler().setTimer(WaitOn_time_event_0, 500, cycleStartTime);
	interfacePedestrian.setVarRequest(true);


	}
	private void entryActionsWaitOff() {
getTimerHandler().setTimer(WaitOff_time_event_0, 500, cycleStartTime);
	interfacePedestrian.setVarRequest(false);


	}
	private void exitActionsStreetAttention() {
getTimerHandler().resetTimer(StreetAttention_time_event_0);

	}
	private void exitActionsStreetRed() {
getTimerHandler().resetTimer(StreetRed_time_event_0);

	}
	private void exitActionsPedestrianGreen() {
getTimerHandler().resetTimer(PedestrianGreen_time_event_0);

	}
	private void exitActionsPedestrianRed() {
getTimerHandler().resetTimer(PedestrianRed_time_event_0);

	}
	private void exitActionsStreetPrepare() {
getTimerHandler().resetTimer(StreetPrepare_time_event_0);

	}
	private void exitActionsWaitOn() {
getTimerHandler().resetTimer(WaitOn_time_event_0);

	}
	private void exitActionsWaitOff() {
getTimerHandler().resetTimer(WaitOff_time_event_0);

	}
	protected void runCycle(Collection<?> events) {
		cycleStartTime = System.currentTimeMillis();
		getOutEvents().clear();
		for (State state : activeStates) {
			switch (state) {
    		case StreetGreen:
        		cycleStreetGreen(events);
        		break;
    		case StreetAttention:
        		cycleStreetAttention(events);
        		break;
    		case StreetRed:
        		cycleStreetRed(events);
        		break;
    		case PedestrianGreen:
        		cyclePedestrianGreen(events);
        		break;
    		case PedestrianRed:
        		cyclePedestrianRed(events);
        		break;
    		case StreetPrepare:
        		cycleStreetPrepare(events);
        		break;
    		case WaitOn:
        		cycleWaitOn(events);
        		break;
    		case WaitOff:
        		cycleWaitOff(events);
        		break;
			default:
				// no state found
			}
		}
	}
}
