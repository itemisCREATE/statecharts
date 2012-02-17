/**
Copyright (c) 2011 committers of YAKINDU and others. 
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html
 
Contributors:
	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.runtime.java.test_transition;

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

public class Test_TransitionCycleBasedStatemachine
		implements
			IGenericAccessStatemachine,
			ITimedStatemachine {

	private enum TimeEvents {
		State1_time_event_0, State1_time_event_1,
	}

	private static final TimeEvent<TimeEvents> State1_time_event_0 = new TimeEvent<TimeEvents>(
			TimeEvents.State1_time_event_0, 8, false);
	private static final TimeEvent<TimeEvents> State1_time_event_1 = new TimeEvent<TimeEvents>(
			TimeEvents.State1_time_event_1, 8, false);

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

	public Test_TransitionCycleBasedStatemachine() {
		occuredEvents = new EventVector<Event<? extends Enum<?>>>(10);
		outEvents = new HashSet<Event<? extends Enum<?>>>();
		interfaceMap = new HashMap<String, IGenericAccessInterface>();
		interfaceMap.put("InterfaceA", new InterfaceAImpl(this));
		interfaceMap.put("DefaultInterface", new DefaultInterfaceImpl(this));
		State1_time_event_0.setStatemachine(this);
		State1_time_event_1.setStatemachine(this);

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
					"TimerService of statemachine \"+Test_Transition+\" not set!");
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

	public InterfaceA getInterfaceA() {
		return (InterfaceA) getInterface("InterfaceA");
	}

	protected IInterfaceAImpl getInterfaceAImpl() {
		return (IInterfaceAImpl) getInterface("InterfaceA");
	}
	public DefaultInterface getDefaultInterface() {
		return (DefaultInterface) getInterface("DefaultInterface");
	}

	protected IDefaultInterfaceImpl getDefaultInterfaceImpl() {
		return (IDefaultInterfaceImpl) getInterface("DefaultInterface");
	}

	public void enter() {
		cycleStartTime = System.currentTimeMillis();
		getTimerService().setTimer(State1_time_event_0, (10 * 1000),
				cycleStartTime);
		getTimerService().setTimer(State1_time_event_1, 100, cycleStartTime);

		nextStateIndex = 0;
		stateVector[0] = State.State1;

	}

	public void exit() {
		//Handle exit of all possible states (of ) at position 0...
		switch (stateVector[0]) {

			case State1 :
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(State1_time_event_0);
				getTimerService().resetTimer(State1_time_event_1);

				break;

			case State2 :
				stateVector[0] = State.$NullState$;

				break;

			default :
				break;
		}

	}

	private void reactState1() {
		if (((occuredEvents.contains(getInterfaceAImpl().getEventEvent1()) || occuredEvents
				.contains(getInterfaceAImpl().getEventEvent2())) && (getInterfaceAImpl()
				.getEventEvent1().getValue() < 0))) {
			stateVector[0] = State.$NullState$;
			getTimerService().resetTimer(State1_time_event_0);
			getTimerService().resetTimer(State1_time_event_1);

			getDefaultInterfaceImpl().setVarI(2);

			nextStateIndex = 0;
			stateVector[0] = State.State2;

		} else {
			if ((getDefaultInterfaceImpl().getVarI() == 5)) {
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(State1_time_event_0);
				getTimerService().resetTimer(State1_time_event_1);

				nextStateIndex = 0;
				stateVector[0] = State.State2;

			} else {
				if ((occuredEvents.contains(getInterfaceAImpl()
						.getEventEvent3()) && (getDefaultInterfaceImpl()
						.getVarJ() < 20))) {
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(State1_time_event_0);
					getTimerService().resetTimer(State1_time_event_1);

					nextStateIndex = 0;
					stateVector[0] = State.State2;

				} else {
					if (((occuredEvents.contains(getInterfaceAImpl()
							.getEventEvent3()) || occuredEvents
							.contains(getInterfaceAImpl().getEventEvent4())) && (getDefaultInterfaceImpl()
							.getVarJ() > 30))) {
						stateVector[0] = State.$NullState$;
						getTimerService().resetTimer(State1_time_event_0);
						getTimerService().resetTimer(State1_time_event_1);

						nextStateIndex = 0;
						stateVector[0] = State.State2;

					} else {
						if (occuredEvents.contains(State1_time_event_0)) {
							stateVector[0] = State.$NullState$;
							getTimerService().resetTimer(State1_time_event_0);
							getTimerService().resetTimer(State1_time_event_1);

							nextStateIndex = 0;
							stateVector[0] = State.State2;

						} else {
							if (occuredEvents.contains(State1_time_event_1)) {
								stateVector[0] = State.$NullState$;
								getTimerService().resetTimer(
										State1_time_event_0);
								getTimerService().resetTimer(
										State1_time_event_1);

								nextStateIndex = 0;
								stateVector[0] = State.State2;

							} else {
								if ((occuredEvents.contains(getInterfaceAImpl()
										.getEventEvent1()) && (getInterfaceAImpl()
										.getEventEvent1().getValue() > 5))) {
									stateVector[0] = State.$NullState$;
									getTimerService().resetTimer(
											State1_time_event_0);
									getTimerService().resetTimer(
											State1_time_event_1);

									getDefaultInterfaceImpl().setVarI(1);

									nextStateIndex = 0;
									stateVector[0] = State.State2;

								}
							}
						}
					}
				}
			}
		}
	}
	private void reactState2() {
		if (occuredEvents.contains(getDefaultInterfaceImpl().getEventEvent6())) {
			stateVector[0] = State.$NullState$;

			getTimerService().setTimer(State1_time_event_0, (10 * 1000),
					cycleStartTime);
			getTimerService()
					.setTimer(State1_time_event_1, 100, cycleStartTime);

			nextStateIndex = 0;
			stateVector[0] = State.State1;

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
