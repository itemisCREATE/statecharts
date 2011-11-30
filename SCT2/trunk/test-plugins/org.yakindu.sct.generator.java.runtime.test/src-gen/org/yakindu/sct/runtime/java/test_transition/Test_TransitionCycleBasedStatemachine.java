/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.runtime.java.test_transition;

import java.util.ArrayList;
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
import org.yakindu.sct.runtime.java.ValuedEvent;

public class Test_TransitionCycleBasedStatemachine
		implements
			ITimedStatemachine {

	private final ValuedEvent<Integer> EventEvent10 = new ValuedEvent<Integer>(
			"event10", 0);

	private static final TimeEvent State1_time_event_0 = new TimeEvent(
			"State1_time_event_0", false);
	private static final TimeEvent State1_time_event_1 = new TimeEvent(
			"State1_time_event_1", false);

	public enum State {
		State1, State2,
	};

	private InterfaceAImpl interfaceA;
	private InterfaceDefaultImpl interfaceDefault;

	private final Set<State> activeStates = EnumSet.noneOf(State.class);

	private final ArrayList<Event> occuredEvents;

	private final Collection<Event> outEvents;

	private ITimerHandler timerHandler;

	private long cycleStartTime;

	public Test_TransitionCycleBasedStatemachine() {
		occuredEvents = new ArrayList<Event>();
		outEvents = new HashSet<Event>();
		interfaceA = new InterfaceAImpl(this);
		interfaceDefault = new InterfaceDefaultImpl(this);
	}

	protected Collection<Event> getOccuredEvents() {
		return occuredEvents;
	}

	protected Collection<Event> getOutEvents() {
		return outEvents;
	}

	protected boolean eventOccured() {
		return !occuredEvents.isEmpty();
	}

	public void init() {

	}

	public void setTimerHandler(ITimerHandler timerHandler) {
		this.timerHandler = timerHandler;
	}

	public ITimerHandler getTimerHandler() {
		if (timerHandler == null) {
			throw new NullPointerException(
					"TimerHandler of statemachine \"+Test_Transition+\" not set!");
		}
		return timerHandler;
	}

	public void notify(Notification<?> notification) {
		if (notification instanceof EventNotification) {
			EventNotification eventNotification = (EventNotification) notification;
			getOccuredEvents().add(eventNotification.getElement());
		}
	}

	public Set<State> getActiveStates() {
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

	private ValuedEvent<Integer> getEventEvent10() {
		return EventEvent10;
	}

	public void enter() {
		cycleStartTime = System.currentTimeMillis();
		enterSequenceState1();
	}

	private boolean conditionState1Tr0() {
		return (occuredEvents.contains(interfaceA.getEventEvent1()) || occuredEvents
				.contains(interfaceA.getEventEvent2()));
	}
	private boolean conditionState1Tr1() {
		return (interfaceDefault.getVarI() == 5);
	}
	private boolean conditionState1Tr2() {
		return (occuredEvents.contains(interfaceA.getEventEvent3()) && (interfaceDefault
				.getVarJ() < 20));
	}
	private boolean conditionState1Tr3() {
		return ((occuredEvents.contains(interfaceA.getEventEvent3()) || occuredEvents
				.contains(interfaceA.getEventEvent4())) && (interfaceDefault
				.getVarJ() > 30));
	}
	private boolean conditionState1Tr4() {
		return occuredEvents.contains(interfaceDefault.getEventEvent6());
	}
	private boolean conditionState1Tr5() {
		return occuredEvents.contains(interfaceDefault.getEventEvent7());
	}
	private boolean conditionState1Tr6() {
		return occuredEvents.contains(State1_time_event_0);
	}
	private boolean conditionState1Tr7() {
		return occuredEvents.contains(State1_time_event_1);
	}
	private boolean conditionState1Tr8() {
		return occuredEvents.contains(interfaceA.getEventEvent1());
	}
	private void actionsState1Tr0() {
		exitSequenceState1();
		enterSequenceState2();

	}
	private void actionsState1Tr1() {
		exitSequenceState1();
		enterSequenceState2();

	}
	private void actionsState1Tr2() {
		exitSequenceState1();
		enterSequenceState2();

	}
	private void actionsState1Tr3() {
		exitSequenceState1();
		enterSequenceState2();

	}
	private void actionsState1Tr4() {
		exitSequenceState1();
		interfaceDefault.setVarI(15);

		enterSequenceState2();

	}
	private void actionsState1Tr5() {
		exitSequenceState1();
		interfaceDefault.setVarJ((interfaceDefault.getVarI() * 9));

		enterSequenceState2();

	}
	private void actionsState1Tr6() {
		exitSequenceState1();
		enterSequenceState2();

	}
	private void actionsState1Tr7() {
		exitSequenceState1();
		enterSequenceState2();

	}
	private void actionsState1Tr8() {
		exitSequenceState1();
		enterSequenceState2();

	}
	private void entryActionState1() {
		getTimerHandler().setTimer(State1_time_event_0, (10 * 1000),
				cycleStartTime);
		getTimerHandler().setTimer(State1_time_event_1, 100, cycleStartTime);

	}
	private void exitActionState1() {
		getTimerHandler().resetTimer(State1_time_event_0);
		getTimerHandler().resetTimer(State1_time_event_1);

	}

	private void enterSequenceState1() {
		entryActionState1();
		activeStates.add(State.State1);
	}

	private void enterSequenceState2() {
		activeStates.add(State.State2);
	}
	private void exitSequenceState1() {
		activeStates.remove(State.State1);
		exitActionState1();
	}
	private void exitSequenceState2() {
		activeStates.remove(State.State2);
	}
	private void reactState1() {
		if (conditionState1Tr0()) {
			actionsState1Tr0();
		} else {
			if (conditionState1Tr1()) {
				actionsState1Tr1();
			} else {
				if (conditionState1Tr2()) {
					actionsState1Tr2();
				} else {
					if (conditionState1Tr3()) {
						actionsState1Tr3();
					} else {
						if (conditionState1Tr4()) {
							actionsState1Tr4();
						} else {
							if (conditionState1Tr5()) {
								actionsState1Tr5();
							} else {
								if (conditionState1Tr6()) {
									actionsState1Tr6();
								} else {
									if (conditionState1Tr7()) {
										actionsState1Tr7();
									} else {
										if (conditionState1Tr8()) {
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
	private void reactState2() {
	}
	public void runCycle() {
		cycleStartTime = System.currentTimeMillis();
		outEvents.clear();
		for (State state : activeStates) {
			switch (state) {
				case State1 :
					reactState1();
					break;
				case State2 :
					reactState2();
					break;
				default :
					// no state found
			}
		}
		occuredEvents.clear();
	}
}
