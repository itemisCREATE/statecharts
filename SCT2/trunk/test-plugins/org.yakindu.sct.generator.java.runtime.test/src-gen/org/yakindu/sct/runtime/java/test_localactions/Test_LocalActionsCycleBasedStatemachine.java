/**
Copyright (c) 2011 committers of YAKINDU and others. 
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html
 
Contributors:
	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.runtime.java.test_localactions;

import java.util.Collection;
import java.util.HashSet;
import org.yakindu.sct.runtime.java.Event;
import org.yakindu.sct.runtime.java.EventVector;
import java.util.HashMap;
import java.util.Map;
import org.yakindu.sct.runtime.java.IGenericAccessStatemachine;
import org.yakindu.sct.runtime.java.IGenericAccessInterface;
import org.yakindu.sct.runtime.java.TimeEvent;
import org.yakindu.sct.runtime.java.ITimedStatemachine;
import org.yakindu.sct.runtime.java.ITimerService;

public class Test_LocalActionsCycleBasedStatemachine
		implements
			IGenericAccessStatemachine,
			ITimedStatemachine {

	private enum TimeEvents {
		State1_time_event_0, State2_time_event_0,
	}

	private static final TimeEvent<TimeEvents> State1_time_event_0 = new TimeEvent<TimeEvents>(
			TimeEvents.State1_time_event_0, 4, true);
	private static final TimeEvent<TimeEvents> State2_time_event_0 = new TimeEvent<TimeEvents>(
			TimeEvents.State2_time_event_0, 4, false);

	public enum State {
		State1, State2, $NullState$
	};

	protected Map<String, IGenericAccessInterface> interfaceMap;

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	private final EventVector<Event<? extends Enum<?>>> occuredEvents;

	private final Collection<Event<? extends Enum<?>>> outEvents;

	private ITimerService timerService;

	private long cycleStartTime;

	public Test_LocalActionsCycleBasedStatemachine() {
		occuredEvents = new EventVector<Event<? extends Enum<?>>>(6);
		outEvents = new HashSet<Event<? extends Enum<?>>>();
		interfaceMap = new HashMap<String, IGenericAccessInterface>();
		interfaceMap.put("DefaultInterface", new DefaultInterfaceImpl(this));
		State1_time_event_0.setStatemachine(this);
		State2_time_event_0.setStatemachine(this);

	}

	protected Collection<Event<? extends Enum<?>>> getOccuredEvents() {
		return occuredEvents;
	}

	protected Collection<Event<? extends Enum<?>>> getOutEvents() {
		return outEvents;
	}

	protected boolean eventOccured() {
		return !occuredEvents.isEmpty();
	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		occuredEvents.clear();
	}

	public boolean isStateActive(State state) {
		for (int i = 0; i < stateVector.length; i++) {
			if (stateVector[i] == state) {
				return true;
			}
		}
		return false;
	}

	public void setTimerService(ITimerService timerService) {
		this.timerService = timerService;
	}

	public ITimerService getTimerService() {
		if (timerService == null) {
			throw new NullPointerException(
					"TimerService of statemachine \"+Test_LocalActions+\" not set!");
		}
		return timerService;
	}

	public void onTimeEventRaised(TimeEvent<? extends Enum<?>> timeEvent) {
		getOccuredEvents().add(timeEvent);
	}

	public IGenericAccessInterface getInterface(String name) {
		return interfaceMap.get(name);
	}

	protected Map<String, IGenericAccessInterface> getInterfaceMap() {
		return interfaceMap;
	}

	public DefaultInterface getDefaultInterface() {
		return (DefaultInterface) getInterface("DefaultInterface");
	}

	protected IDefaultInterfaceImpl getDefaultInterfaceImpl() {
		return (IDefaultInterfaceImpl) getInterface("DefaultInterface");
	}

	public void enter() {
		cycleStartTime = System.currentTimeMillis();
		getTimerService().setTimer(State1_time_event_0, 100, cycleStartTime);
		getDefaultInterfaceImpl().setVarI(1);

		nextStateIndex = 0;
		stateVector[0] = State.State1;

	}

	public void exit() {
		//Handle exit of all possible states (of mainRegion) at position 0...
		switch (stateVector[0]) {

			case State1 :
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(State1_time_event_0);
				getDefaultInterfaceImpl().setVarI(0);

				break;

			case State2 :
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(State2_time_event_0);
				getDefaultInterfaceImpl().setVarJ(0);

				break;

			default :
				break;
		}

	}

	private void reactState1() {
		if (occuredEvents.contains(getDefaultInterfaceImpl().getEventEvent1())) {
			stateVector[0] = State.$NullState$;
			getTimerService().resetTimer(State1_time_event_0);
			getDefaultInterfaceImpl().setVarI(0);

			getTimerService()
					.setTimer(State2_time_event_0, 200, cycleStartTime);
			getDefaultInterfaceImpl().setVarJ(1);

			nextStateIndex = 0;
			stateVector[0] = State.State2;

		} else {
			getDefaultInterfaceImpl().setVarI(2);

			if (occuredEvents.contains(getDefaultInterfaceImpl()
					.getEventEvent2())) {
				getDefaultInterfaceImpl().setVarI(3);

			}
			if (occuredEvents.contains(State1_time_event_0)) {
				getDefaultInterfaceImpl().setVarC(
						getDefaultInterfaceImpl().getVarC() + (1));

			}

		}
	}
	private void reactState2() {
		if (occuredEvents.contains(getDefaultInterfaceImpl().getEventEvent3())) {
			stateVector[0] = State.$NullState$;
			getTimerService().resetTimer(State2_time_event_0);
			getDefaultInterfaceImpl().setVarJ(0);

			getTimerService()
					.setTimer(State1_time_event_0, 100, cycleStartTime);
			getDefaultInterfaceImpl().setVarI(1);

			nextStateIndex = 0;
			stateVector[0] = State.State1;

		} else {
			if ((occuredEvents.contains(getDefaultInterfaceImpl()
					.getEventEvent2()) || occuredEvents
					.contains(getDefaultInterfaceImpl().getEventEvent4()))) {
				getDefaultInterfaceImpl().setVarJ(2);

			}
			if (occuredEvents.contains(State2_time_event_0)) {
				getDefaultInterfaceImpl().setVarJ(3);

			}

		}
	}
	public void runCycle() {
		cycleStartTime = System.currentTimeMillis();
		outEvents.clear();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case State1 :
					reactState1();
					break;
				case State2 :
					reactState2();
					break;
				default :
					// $NullState$
			}
		}

		occuredEvents.clear();
	}
}
