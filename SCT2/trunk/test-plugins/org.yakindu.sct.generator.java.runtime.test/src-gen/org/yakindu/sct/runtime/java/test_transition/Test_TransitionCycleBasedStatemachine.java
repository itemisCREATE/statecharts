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
import org.yakindu.sct.runtime.java.TimeEvent;
import org.yakindu.sct.runtime.java.ITimedStatemachine;
import org.yakindu.sct.runtime.java.ITimerService;
import org.yakindu.sct.runtime.java.EventNotification;
import org.yakindu.sct.runtime.java.Notification;

public class Test_TransitionCycleBasedStatemachine
		implements
			ITimedStatemachine {

	private enum TimeEvents {
		State1_time_event_0, State1_time_event_1,
	}

	private static final TimeEvent<TimeEvents> State1_time_event_0 = new TimeEvent<TimeEvents>(
			TimeEvents.State1_time_event_0, 7, false);
	private static final TimeEvent<TimeEvents> State1_time_event_1 = new TimeEvent<TimeEvents>(
			TimeEvents.State1_time_event_1, 7, false);

	public enum State {
		State1, State2, $NullState$
	};

	private InterfaceAImpl interfaceA;
	private DefaultInterfaceImpl defaultInterface;

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	private final EventVector<Event<? extends Enum<?>>> occuredEvents;

	private final Collection<Event<? extends Enum<?>>> outEvents;

	private ITimerService timerService;

	private long cycleStartTime;

	public Test_TransitionCycleBasedStatemachine() {
		occuredEvents = new EventVector<Event<? extends Enum<?>>>(9);
		outEvents = new HashSet<Event<? extends Enum<?>>>();
		interfaceA = new InterfaceAImpl(this);
		defaultInterface = new DefaultInterfaceImpl(this);
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
		for (int i = 0; i < stateVector.length; i++) {
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

	public void notify(Notification<?> notification) {
		if (notification instanceof EventNotification) {
			EventNotification eventNotification = (EventNotification) notification;
			getOccuredEvents().add(eventNotification.getElement());
		}
	}

	public InterfaceA getInterfaceA() {
		return interfaceA;
	}

	public DefaultInterface getDefaultInterface() {
		return defaultInterface;
	}

	public void enter() {
		cycleStartTime = System.currentTimeMillis();
		getTimerService().setTimer(State1_time_event_0, (10 * 1000),
				cycleStartTime);
		getTimerService().setTimer(State1_time_event_1, 100, cycleStartTime);

		nextStateIndex = 0;
		stateVector[0] = State.State1;

	}

	private void reactState1() {
		if (((occuredEvents.contains(interfaceA.getEventEvent1()) || occuredEvents
				.contains(interfaceA.getEventEvent2())) && (interfaceA
				.getEventEvent1().getValue() < 0))) {
			stateVector[0] = State.$NullState$;

			getTimerService().resetTimer(State1_time_event_0);
			getTimerService().resetTimer(State1_time_event_1);

			defaultInterface.setVarI(2);

			nextStateIndex = 0;
			stateVector[0] = State.State2;

		} else {
			if ((defaultInterface.getVarI() == 5)) {
				stateVector[0] = State.$NullState$;

				getTimerService().resetTimer(State1_time_event_0);
				getTimerService().resetTimer(State1_time_event_1);

				nextStateIndex = 0;
				stateVector[0] = State.State2;

			} else {
				if ((occuredEvents.contains(interfaceA.getEventEvent3()) && (defaultInterface
						.getVarJ() < 20))) {
					stateVector[0] = State.$NullState$;

					getTimerService().resetTimer(State1_time_event_0);
					getTimerService().resetTimer(State1_time_event_1);

					nextStateIndex = 0;
					stateVector[0] = State.State2;

				} else {
					if (((occuredEvents.contains(interfaceA.getEventEvent3()) || occuredEvents
							.contains(interfaceA.getEventEvent4())) && (defaultInterface
							.getVarJ() > 30))) {
						stateVector[0] = State.$NullState$;

						getTimerService().resetTimer(State1_time_event_0);
						getTimerService().resetTimer(State1_time_event_1);

						nextStateIndex = 0;
						stateVector[0] = State.State2;

					} else {
						if (occuredEvents.contains(defaultInterface
								.getEventEvent6())) {
							stateVector[0] = State.$NullState$;

							getTimerService().resetTimer(State1_time_event_0);
							getTimerService().resetTimer(State1_time_event_1);

							defaultInterface.setVarI(15);

							nextStateIndex = 0;
							stateVector[0] = State.State2;

						} else {
							if (occuredEvents.contains(defaultInterface
									.getEventEvent7())) {
								stateVector[0] = State.$NullState$;

								getTimerService().resetTimer(
										State1_time_event_0);
								getTimerService().resetTimer(
										State1_time_event_1);

								defaultInterface.setVarJ((defaultInterface
										.getVarI() * 9));

								nextStateIndex = 0;
								stateVector[0] = State.State2;

							} else {
								if (occuredEvents.contains(State1_time_event_0)) {
									stateVector[0] = State.$NullState$;

									getTimerService().resetTimer(
											State1_time_event_0);
									getTimerService().resetTimer(
											State1_time_event_1);

									nextStateIndex = 0;
									stateVector[0] = State.State2;

								} else {
									if (occuredEvents
											.contains(State1_time_event_1)) {
										stateVector[0] = State.$NullState$;

										getTimerService().resetTimer(
												State1_time_event_0);
										getTimerService().resetTimer(
												State1_time_event_1);

										nextStateIndex = 0;
										stateVector[0] = State.State2;

									} else {
										if ((occuredEvents.contains(interfaceA
												.getEventEvent1()) && (interfaceA
												.getEventEvent1().getValue() > 5))) {
											stateVector[0] = State.$NullState$;

											getTimerService().resetTimer(
													State1_time_event_0);
											getTimerService().resetTimer(
													State1_time_event_1);

											defaultInterface.setVarI(1);

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
		}
	}
	private void reactState2() {
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
