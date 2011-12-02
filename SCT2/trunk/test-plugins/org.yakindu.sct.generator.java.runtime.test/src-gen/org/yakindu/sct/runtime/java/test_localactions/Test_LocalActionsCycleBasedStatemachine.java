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
package org.yakindu.sct.runtime.java.test_localactions;

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

public class Test_LocalActionsCycleBasedStatemachine
		implements
			ITimedStatemachine {

	private static final TimeEvent State1_time_event_0 = new TimeEvent(
			"State1_time_event_0", true);
	private static final TimeEvent State2_time_event_0 = new TimeEvent(
			"State2_time_event_0", false);

	public enum State {
		State1, State2,
	};

	private DefaultInterfaceImpl defaultInterface;

	private final Set<State> activeStates = EnumSet.noneOf(State.class);

	private final ArrayList<Event> occuredEvents;

	private final Collection<Event> outEvents;

	private ITimerHandler timerHandler;

	private long cycleStartTime;

	public Test_LocalActionsCycleBasedStatemachine() {
		occuredEvents = new ArrayList<Event>();
		outEvents = new HashSet<Event>();
		defaultInterface = new DefaultInterfaceImpl(this);
		State1_time_event_0.setStatemachine(this);
		State2_time_event_0.setStatemachine(this);

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
					"TimerHandler of statemachine \"+Test_LocalActions+\" not set!");
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

	public DefaultInterface getDefaultInterface() {
		return defaultInterface;
	}

	public void enter() {
		cycleStartTime = System.currentTimeMillis();
		getTimerHandler().setTimer(State1_time_event_0, 100, cycleStartTime);
		defaultInterface.setVarI(1);

		activeStates.add(State.State1);

	}

	private void reactState1() {
		if (occuredEvents.contains(defaultInterface.getEventEvent1())) {
			activeStates.remove(State.State1);
			getTimerHandler().resetTimer(State1_time_event_0);
			defaultInterface.setVarI(0);

			getTimerHandler()
					.setTimer(State2_time_event_0, 200, cycleStartTime);
			defaultInterface.setVarJ(1);

			activeStates.add(State.State2);

		} else {
			if (true) {
				defaultInterface.setVarI(2);

			}
			if (occuredEvents.contains(defaultInterface.getEventEvent2())) {
				defaultInterface.setVarI(3);

			}
			if (occuredEvents.contains(State1_time_event_0)) {
				defaultInterface.setVarC(defaultInterface.getVarC() + (1));

			}

		}
	}
	private void reactState2() {
		if (occuredEvents.contains(defaultInterface.getEventEvent3())) {
			activeStates.remove(State.State2);
			getTimerHandler().resetTimer(State2_time_event_0);
			defaultInterface.setVarJ(0);

			getTimerHandler()
					.setTimer(State1_time_event_0, 100, cycleStartTime);
			defaultInterface.setVarI(1);

			activeStates.add(State.State1);

		} else {
			if ((occuredEvents.contains(defaultInterface.getEventEvent2()) || occuredEvents
					.contains(defaultInterface.getEventEvent4()))) {
				defaultInterface.setVarJ(2);

			}
			if (occuredEvents.contains(State2_time_event_0)) {
				defaultInterface.setVarJ(3);

			}

		}
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
