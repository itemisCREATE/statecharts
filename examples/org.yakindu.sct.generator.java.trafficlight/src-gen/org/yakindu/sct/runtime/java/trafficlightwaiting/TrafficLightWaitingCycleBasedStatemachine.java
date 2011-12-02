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
package org.yakindu.sct.runtime.java.trafficlightwaiting;

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

public class TrafficLightWaitingCycleBasedStatemachine
		implements
			ITimedStatemachine {

	private static final TimeEvent PedWaiting_time_event_0 = new TimeEvent(
			"PedWaiting_time_event_0", false);
	private static final TimeEvent WaitOn_time_event_0 = new TimeEvent(
			"WaitOn_time_event_0", false);
	private static final TimeEvent WaitOff_time_event_0 = new TimeEvent(
			"WaitOff_time_event_0", false);
	private static final TimeEvent StreetAttention_time_event_0 = new TimeEvent(
			"StreetAttention_time_event_0", false);
	private static final TimeEvent StreetRed_time_event_0 = new TimeEvent(
			"StreetRed_time_event_0", false);
	private static final TimeEvent PedestrianGreen_time_event_0 = new TimeEvent(
			"PedestrianGreen_time_event_0", false);
	private static final TimeEvent PedestrianRed_time_event_0 = new TimeEvent(
			"PedestrianRed_time_event_0", false);
	private static final TimeEvent StreetPrepare_time_event_0 = new TimeEvent(
			"StreetPrepare_time_event_0", false);
	private static final TimeEvent YellowOn_time_event_0 = new TimeEvent(
			"YellowOn_time_event_0", false);
	private static final TimeEvent YellowOff_time_event_0 = new TimeEvent(
			"YellowOff_time_event_0", false);

	public enum State {
		On, StreetGreen, PedWaiting, WaitOn, WaitOff, StreetAttention, StreetRed, PedestrianGreen, PedestrianRed, StreetPrepare, Off, YellowOn, YellowOff,
	};

	private InterfaceTrafficLightImpl interfaceTrafficLight;
	private InterfacePedestrianImpl interfacePedestrian;
	private DefaultInterfaceImpl defaultInterface;

	private final Set<State> activeStates = EnumSet.noneOf(State.class);

	private final ArrayList<Event> occuredEvents;

	private final Collection<Event> outEvents;

	private ITimerHandler timerHandler;

	private long cycleStartTime;

	public TrafficLightWaitingCycleBasedStatemachine() {
		occuredEvents = new ArrayList<Event>();
		outEvents = new HashSet<Event>();
		interfaceTrafficLight = new InterfaceTrafficLightImpl(this);
		interfacePedestrian = new InterfacePedestrianImpl(this);
		defaultInterface = new DefaultInterfaceImpl(this);
		PedWaiting_time_event_0.setStatemachine(this);
		WaitOn_time_event_0.setStatemachine(this);
		WaitOff_time_event_0.setStatemachine(this);
		StreetAttention_time_event_0.setStatemachine(this);
		StreetRed_time_event_0.setStatemachine(this);
		PedestrianGreen_time_event_0.setStatemachine(this);
		PedestrianRed_time_event_0.setStatemachine(this);
		StreetPrepare_time_event_0.setStatemachine(this);
		YellowOn_time_event_0.setStatemachine(this);
		YellowOff_time_event_0.setStatemachine(this);

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
					"TimerHandler of statemachine \"+TrafficLightWaiting+\" not set!");
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

	public InterfaceTrafficLight getInterfaceTrafficLight() {
		return interfaceTrafficLight;
	}

	public InterfacePedestrian getInterfacePedestrian() {
		return interfacePedestrian;
	}

	public DefaultInterface getDefaultInterface() {
		return defaultInterface;
	}

	public void enter() {
		cycleStartTime = System.currentTimeMillis();
		interfaceTrafficLight.setVarRed(false);
		interfaceTrafficLight.setVarYellow(false);
		interfaceTrafficLight.setVarGreen(true);
		interfacePedestrian.setVarRed(true);
		interfacePedestrian.setVarGreen(false);
		interfacePedestrian.setVarRequest(false);

		activeStates.add(State.StreetGreen);

	}

	private void reactOn() {
	}
	private void reactStreetGreen() {
		if (occuredEvents.contains(defaultInterface.getEventKeypress2())) {
			if (activeStates.contains(State.StreetGreen)) {
				activeStates.remove(State.StreetGreen);

			} else if (activeStates.contains(State.WaitOn)) {
				activeStates.remove(State.WaitOn);
				getTimerHandler().resetTimer(WaitOn_time_event_0);

				getTimerHandler().resetTimer(PedWaiting_time_event_0);
				interfacePedestrian.setVarRequest(false);

			} else if (activeStates.contains(State.WaitOff)) {
				activeStates.remove(State.WaitOff);
				getTimerHandler().resetTimer(WaitOff_time_event_0);

				getTimerHandler().resetTimer(PedWaiting_time_event_0);
				interfacePedestrian.setVarRequest(false);

			} else if (activeStates.contains(State.StreetAttention)) {
				activeStates.remove(State.StreetAttention);
				getTimerHandler().resetTimer(StreetAttention_time_event_0);

			} else if (activeStates.contains(State.StreetRed)) {
				activeStates.remove(State.StreetRed);
				getTimerHandler().resetTimer(StreetRed_time_event_0);

			} else if (activeStates.contains(State.PedestrianGreen)) {
				activeStates.remove(State.PedestrianGreen);
				getTimerHandler().resetTimer(PedestrianGreen_time_event_0);

			} else if (activeStates.contains(State.PedestrianRed)) {
				activeStates.remove(State.PedestrianRed);
				getTimerHandler().resetTimer(PedestrianRed_time_event_0);

			} else if (activeStates.contains(State.StreetPrepare)) {
				activeStates.remove(State.StreetPrepare);
				getTimerHandler().resetTimer(StreetPrepare_time_event_0);

			}

			interfaceTrafficLight.setVarRed(false);
			interfaceTrafficLight.setVarGreen(false);
			interfaceTrafficLight.setVarYellow(false);
			interfacePedestrian.setVarRed(false);
			interfacePedestrian.setVarGreen(false);

			getTimerHandler().setTimer(YellowOn_time_event_0, 500,
					cycleStartTime);
			interfaceTrafficLight.setVarYellow(true);

			activeStates.add(State.YellowOn);

		} else {
			if (occuredEvents.contains(defaultInterface.getEventKeypress1())) {
				activeStates.remove(State.StreetGreen);

				getTimerHandler().setTimer(PedWaiting_time_event_0, (7 * 1000),
						cycleStartTime);

				getTimerHandler().setTimer(WaitOn_time_event_0, 500,
						cycleStartTime);
				interfacePedestrian.setVarRequest(true);

				activeStates.add(State.WaitOn);

			}

		}
	}
	private void reactPedWaiting() {
	}
	private void reactWaitOn() {
		if (occuredEvents.contains(defaultInterface.getEventKeypress2())) {
			if (activeStates.contains(State.StreetGreen)) {
				activeStates.remove(State.StreetGreen);

			} else if (activeStates.contains(State.WaitOn)) {
				activeStates.remove(State.WaitOn);
				getTimerHandler().resetTimer(WaitOn_time_event_0);

				getTimerHandler().resetTimer(PedWaiting_time_event_0);
				interfacePedestrian.setVarRequest(false);

			} else if (activeStates.contains(State.WaitOff)) {
				activeStates.remove(State.WaitOff);
				getTimerHandler().resetTimer(WaitOff_time_event_0);

				getTimerHandler().resetTimer(PedWaiting_time_event_0);
				interfacePedestrian.setVarRequest(false);

			} else if (activeStates.contains(State.StreetAttention)) {
				activeStates.remove(State.StreetAttention);
				getTimerHandler().resetTimer(StreetAttention_time_event_0);

			} else if (activeStates.contains(State.StreetRed)) {
				activeStates.remove(State.StreetRed);
				getTimerHandler().resetTimer(StreetRed_time_event_0);

			} else if (activeStates.contains(State.PedestrianGreen)) {
				activeStates.remove(State.PedestrianGreen);
				getTimerHandler().resetTimer(PedestrianGreen_time_event_0);

			} else if (activeStates.contains(State.PedestrianRed)) {
				activeStates.remove(State.PedestrianRed);
				getTimerHandler().resetTimer(PedestrianRed_time_event_0);

			} else if (activeStates.contains(State.StreetPrepare)) {
				activeStates.remove(State.StreetPrepare);
				getTimerHandler().resetTimer(StreetPrepare_time_event_0);

			}

			interfaceTrafficLight.setVarRed(false);
			interfaceTrafficLight.setVarGreen(false);
			interfaceTrafficLight.setVarYellow(false);
			interfacePedestrian.setVarRed(false);
			interfacePedestrian.setVarGreen(false);

			getTimerHandler().setTimer(YellowOn_time_event_0, 500,
					cycleStartTime);
			interfaceTrafficLight.setVarYellow(true);

			activeStates.add(State.YellowOn);

		} else {
			if (occuredEvents.contains(PedWaiting_time_event_0)) {
				if (activeStates.contains(State.WaitOn)) {
					activeStates.remove(State.WaitOn);
					getTimerHandler().resetTimer(WaitOn_time_event_0);

				} else if (activeStates.contains(State.WaitOff)) {
					activeStates.remove(State.WaitOff);
					getTimerHandler().resetTimer(WaitOff_time_event_0);

				}
				getTimerHandler().resetTimer(PedWaiting_time_event_0);
				interfacePedestrian.setVarRequest(false);

				getTimerHandler().setTimer(StreetAttention_time_event_0,
						(2 * 1000), cycleStartTime);
				interfaceTrafficLight.setVarRed(false);
				interfaceTrafficLight.setVarYellow(true);
				interfaceTrafficLight.setVarGreen(false);

				activeStates.add(State.StreetAttention);

			} else {
				if (occuredEvents.contains(WaitOn_time_event_0)) {
					activeStates.remove(State.WaitOn);
					getTimerHandler().resetTimer(WaitOn_time_event_0);

					getTimerHandler().setTimer(WaitOff_time_event_0, 500,
							cycleStartTime);
					interfacePedestrian.setVarRequest(false);

					activeStates.add(State.WaitOff);

				}

			}

		}
	}
	private void reactWaitOff() {
		if (occuredEvents.contains(defaultInterface.getEventKeypress2())) {
			if (activeStates.contains(State.StreetGreen)) {
				activeStates.remove(State.StreetGreen);

			} else if (activeStates.contains(State.WaitOn)) {
				activeStates.remove(State.WaitOn);
				getTimerHandler().resetTimer(WaitOn_time_event_0);

				getTimerHandler().resetTimer(PedWaiting_time_event_0);
				interfacePedestrian.setVarRequest(false);

			} else if (activeStates.contains(State.WaitOff)) {
				activeStates.remove(State.WaitOff);
				getTimerHandler().resetTimer(WaitOff_time_event_0);

				getTimerHandler().resetTimer(PedWaiting_time_event_0);
				interfacePedestrian.setVarRequest(false);

			} else if (activeStates.contains(State.StreetAttention)) {
				activeStates.remove(State.StreetAttention);
				getTimerHandler().resetTimer(StreetAttention_time_event_0);

			} else if (activeStates.contains(State.StreetRed)) {
				activeStates.remove(State.StreetRed);
				getTimerHandler().resetTimer(StreetRed_time_event_0);

			} else if (activeStates.contains(State.PedestrianGreen)) {
				activeStates.remove(State.PedestrianGreen);
				getTimerHandler().resetTimer(PedestrianGreen_time_event_0);

			} else if (activeStates.contains(State.PedestrianRed)) {
				activeStates.remove(State.PedestrianRed);
				getTimerHandler().resetTimer(PedestrianRed_time_event_0);

			} else if (activeStates.contains(State.StreetPrepare)) {
				activeStates.remove(State.StreetPrepare);
				getTimerHandler().resetTimer(StreetPrepare_time_event_0);

			}

			interfaceTrafficLight.setVarRed(false);
			interfaceTrafficLight.setVarGreen(false);
			interfaceTrafficLight.setVarYellow(false);
			interfacePedestrian.setVarRed(false);
			interfacePedestrian.setVarGreen(false);

			getTimerHandler().setTimer(YellowOn_time_event_0, 500,
					cycleStartTime);
			interfaceTrafficLight.setVarYellow(true);

			activeStates.add(State.YellowOn);

		} else {
			if (occuredEvents.contains(PedWaiting_time_event_0)) {
				if (activeStates.contains(State.WaitOn)) {
					activeStates.remove(State.WaitOn);
					getTimerHandler().resetTimer(WaitOn_time_event_0);

				} else if (activeStates.contains(State.WaitOff)) {
					activeStates.remove(State.WaitOff);
					getTimerHandler().resetTimer(WaitOff_time_event_0);

				}
				getTimerHandler().resetTimer(PedWaiting_time_event_0);
				interfacePedestrian.setVarRequest(false);

				getTimerHandler().setTimer(StreetAttention_time_event_0,
						(2 * 1000), cycleStartTime);
				interfaceTrafficLight.setVarRed(false);
				interfaceTrafficLight.setVarYellow(true);
				interfaceTrafficLight.setVarGreen(false);

				activeStates.add(State.StreetAttention);

			} else {
				if (occuredEvents.contains(WaitOff_time_event_0)) {
					activeStates.remove(State.WaitOff);
					getTimerHandler().resetTimer(WaitOff_time_event_0);

					getTimerHandler().setTimer(WaitOn_time_event_0, 500,
							cycleStartTime);
					interfacePedestrian.setVarRequest(true);

					activeStates.add(State.WaitOn);

				}

			}

		}
	}
	private void reactStreetAttention() {
		if (occuredEvents.contains(defaultInterface.getEventKeypress2())) {
			if (activeStates.contains(State.StreetGreen)) {
				activeStates.remove(State.StreetGreen);

			} else if (activeStates.contains(State.WaitOn)) {
				activeStates.remove(State.WaitOn);
				getTimerHandler().resetTimer(WaitOn_time_event_0);

				getTimerHandler().resetTimer(PedWaiting_time_event_0);
				interfacePedestrian.setVarRequest(false);

			} else if (activeStates.contains(State.WaitOff)) {
				activeStates.remove(State.WaitOff);
				getTimerHandler().resetTimer(WaitOff_time_event_0);

				getTimerHandler().resetTimer(PedWaiting_time_event_0);
				interfacePedestrian.setVarRequest(false);

			} else if (activeStates.contains(State.StreetAttention)) {
				activeStates.remove(State.StreetAttention);
				getTimerHandler().resetTimer(StreetAttention_time_event_0);

			} else if (activeStates.contains(State.StreetRed)) {
				activeStates.remove(State.StreetRed);
				getTimerHandler().resetTimer(StreetRed_time_event_0);

			} else if (activeStates.contains(State.PedestrianGreen)) {
				activeStates.remove(State.PedestrianGreen);
				getTimerHandler().resetTimer(PedestrianGreen_time_event_0);

			} else if (activeStates.contains(State.PedestrianRed)) {
				activeStates.remove(State.PedestrianRed);
				getTimerHandler().resetTimer(PedestrianRed_time_event_0);

			} else if (activeStates.contains(State.StreetPrepare)) {
				activeStates.remove(State.StreetPrepare);
				getTimerHandler().resetTimer(StreetPrepare_time_event_0);

			}

			interfaceTrafficLight.setVarRed(false);
			interfaceTrafficLight.setVarGreen(false);
			interfaceTrafficLight.setVarYellow(false);
			interfacePedestrian.setVarRed(false);
			interfacePedestrian.setVarGreen(false);

			getTimerHandler().setTimer(YellowOn_time_event_0, 500,
					cycleStartTime);
			interfaceTrafficLight.setVarYellow(true);

			activeStates.add(State.YellowOn);

		} else {
			if (occuredEvents.contains(StreetAttention_time_event_0)) {
				activeStates.remove(State.StreetAttention);
				getTimerHandler().resetTimer(StreetAttention_time_event_0);

				getTimerHandler().setTimer(StreetRed_time_event_0, (2 * 1000),
						cycleStartTime);
				interfaceTrafficLight.setVarRed(true);
				interfaceTrafficLight.setVarYellow(false);
				interfaceTrafficLight.setVarGreen(false);

				activeStates.add(State.StreetRed);

			}

		}
	}
	private void reactStreetRed() {
		if (occuredEvents.contains(defaultInterface.getEventKeypress2())) {
			if (activeStates.contains(State.StreetGreen)) {
				activeStates.remove(State.StreetGreen);

			} else if (activeStates.contains(State.WaitOn)) {
				activeStates.remove(State.WaitOn);
				getTimerHandler().resetTimer(WaitOn_time_event_0);

				getTimerHandler().resetTimer(PedWaiting_time_event_0);
				interfacePedestrian.setVarRequest(false);

			} else if (activeStates.contains(State.WaitOff)) {
				activeStates.remove(State.WaitOff);
				getTimerHandler().resetTimer(WaitOff_time_event_0);

				getTimerHandler().resetTimer(PedWaiting_time_event_0);
				interfacePedestrian.setVarRequest(false);

			} else if (activeStates.contains(State.StreetAttention)) {
				activeStates.remove(State.StreetAttention);
				getTimerHandler().resetTimer(StreetAttention_time_event_0);

			} else if (activeStates.contains(State.StreetRed)) {
				activeStates.remove(State.StreetRed);
				getTimerHandler().resetTimer(StreetRed_time_event_0);

			} else if (activeStates.contains(State.PedestrianGreen)) {
				activeStates.remove(State.PedestrianGreen);
				getTimerHandler().resetTimer(PedestrianGreen_time_event_0);

			} else if (activeStates.contains(State.PedestrianRed)) {
				activeStates.remove(State.PedestrianRed);
				getTimerHandler().resetTimer(PedestrianRed_time_event_0);

			} else if (activeStates.contains(State.StreetPrepare)) {
				activeStates.remove(State.StreetPrepare);
				getTimerHandler().resetTimer(StreetPrepare_time_event_0);

			}

			interfaceTrafficLight.setVarRed(false);
			interfaceTrafficLight.setVarGreen(false);
			interfaceTrafficLight.setVarYellow(false);
			interfacePedestrian.setVarRed(false);
			interfacePedestrian.setVarGreen(false);

			getTimerHandler().setTimer(YellowOn_time_event_0, 500,
					cycleStartTime);
			interfaceTrafficLight.setVarYellow(true);

			activeStates.add(State.YellowOn);

		} else {
			if (occuredEvents.contains(StreetRed_time_event_0)) {
				activeStates.remove(State.StreetRed);
				getTimerHandler().resetTimer(StreetRed_time_event_0);

				getTimerHandler().setTimer(PedestrianGreen_time_event_0,
						(7 * 1000), cycleStartTime);
				interfacePedestrian.setVarRed(false);
				interfacePedestrian.setVarGreen(true);

				activeStates.add(State.PedestrianGreen);

			}

		}
	}
	private void reactPedestrianGreen() {
		if (occuredEvents.contains(defaultInterface.getEventKeypress2())) {
			if (activeStates.contains(State.StreetGreen)) {
				activeStates.remove(State.StreetGreen);

			} else if (activeStates.contains(State.WaitOn)) {
				activeStates.remove(State.WaitOn);
				getTimerHandler().resetTimer(WaitOn_time_event_0);

				getTimerHandler().resetTimer(PedWaiting_time_event_0);
				interfacePedestrian.setVarRequest(false);

			} else if (activeStates.contains(State.WaitOff)) {
				activeStates.remove(State.WaitOff);
				getTimerHandler().resetTimer(WaitOff_time_event_0);

				getTimerHandler().resetTimer(PedWaiting_time_event_0);
				interfacePedestrian.setVarRequest(false);

			} else if (activeStates.contains(State.StreetAttention)) {
				activeStates.remove(State.StreetAttention);
				getTimerHandler().resetTimer(StreetAttention_time_event_0);

			} else if (activeStates.contains(State.StreetRed)) {
				activeStates.remove(State.StreetRed);
				getTimerHandler().resetTimer(StreetRed_time_event_0);

			} else if (activeStates.contains(State.PedestrianGreen)) {
				activeStates.remove(State.PedestrianGreen);
				getTimerHandler().resetTimer(PedestrianGreen_time_event_0);

			} else if (activeStates.contains(State.PedestrianRed)) {
				activeStates.remove(State.PedestrianRed);
				getTimerHandler().resetTimer(PedestrianRed_time_event_0);

			} else if (activeStates.contains(State.StreetPrepare)) {
				activeStates.remove(State.StreetPrepare);
				getTimerHandler().resetTimer(StreetPrepare_time_event_0);

			}

			interfaceTrafficLight.setVarRed(false);
			interfaceTrafficLight.setVarGreen(false);
			interfaceTrafficLight.setVarYellow(false);
			interfacePedestrian.setVarRed(false);
			interfacePedestrian.setVarGreen(false);

			getTimerHandler().setTimer(YellowOn_time_event_0, 500,
					cycleStartTime);
			interfaceTrafficLight.setVarYellow(true);

			activeStates.add(State.YellowOn);

		} else {
			if (occuredEvents.contains(PedestrianGreen_time_event_0)) {
				activeStates.remove(State.PedestrianGreen);
				getTimerHandler().resetTimer(PedestrianGreen_time_event_0);

				getTimerHandler().setTimer(PedestrianRed_time_event_0,
						(5 * 1000), cycleStartTime);
				interfacePedestrian.setVarRed(true);
				interfacePedestrian.setVarGreen(false);

				activeStates.add(State.PedestrianRed);

			}

		}
	}
	private void reactPedestrianRed() {
		if (occuredEvents.contains(defaultInterface.getEventKeypress2())) {
			if (activeStates.contains(State.StreetGreen)) {
				activeStates.remove(State.StreetGreen);

			} else if (activeStates.contains(State.WaitOn)) {
				activeStates.remove(State.WaitOn);
				getTimerHandler().resetTimer(WaitOn_time_event_0);

				getTimerHandler().resetTimer(PedWaiting_time_event_0);
				interfacePedestrian.setVarRequest(false);

			} else if (activeStates.contains(State.WaitOff)) {
				activeStates.remove(State.WaitOff);
				getTimerHandler().resetTimer(WaitOff_time_event_0);

				getTimerHandler().resetTimer(PedWaiting_time_event_0);
				interfacePedestrian.setVarRequest(false);

			} else if (activeStates.contains(State.StreetAttention)) {
				activeStates.remove(State.StreetAttention);
				getTimerHandler().resetTimer(StreetAttention_time_event_0);

			} else if (activeStates.contains(State.StreetRed)) {
				activeStates.remove(State.StreetRed);
				getTimerHandler().resetTimer(StreetRed_time_event_0);

			} else if (activeStates.contains(State.PedestrianGreen)) {
				activeStates.remove(State.PedestrianGreen);
				getTimerHandler().resetTimer(PedestrianGreen_time_event_0);

			} else if (activeStates.contains(State.PedestrianRed)) {
				activeStates.remove(State.PedestrianRed);
				getTimerHandler().resetTimer(PedestrianRed_time_event_0);

			} else if (activeStates.contains(State.StreetPrepare)) {
				activeStates.remove(State.StreetPrepare);
				getTimerHandler().resetTimer(StreetPrepare_time_event_0);

			}

			interfaceTrafficLight.setVarRed(false);
			interfaceTrafficLight.setVarGreen(false);
			interfaceTrafficLight.setVarYellow(false);
			interfacePedestrian.setVarRed(false);
			interfacePedestrian.setVarGreen(false);

			getTimerHandler().setTimer(YellowOn_time_event_0, 500,
					cycleStartTime);
			interfaceTrafficLight.setVarYellow(true);

			activeStates.add(State.YellowOn);

		} else {
			if (occuredEvents.contains(PedestrianRed_time_event_0)) {
				activeStates.remove(State.PedestrianRed);
				getTimerHandler().resetTimer(PedestrianRed_time_event_0);

				getTimerHandler().setTimer(StreetPrepare_time_event_0,
						(2 * 1000), cycleStartTime);
				interfaceTrafficLight.setVarRed(true);
				interfaceTrafficLight.setVarYellow(true);
				interfaceTrafficLight.setVarGreen(false);

				activeStates.add(State.StreetPrepare);

			}

		}
	}
	private void reactStreetPrepare() {
		if (occuredEvents.contains(defaultInterface.getEventKeypress2())) {
			if (activeStates.contains(State.StreetGreen)) {
				activeStates.remove(State.StreetGreen);

			} else if (activeStates.contains(State.WaitOn)) {
				activeStates.remove(State.WaitOn);
				getTimerHandler().resetTimer(WaitOn_time_event_0);

				getTimerHandler().resetTimer(PedWaiting_time_event_0);
				interfacePedestrian.setVarRequest(false);

			} else if (activeStates.contains(State.WaitOff)) {
				activeStates.remove(State.WaitOff);
				getTimerHandler().resetTimer(WaitOff_time_event_0);

				getTimerHandler().resetTimer(PedWaiting_time_event_0);
				interfacePedestrian.setVarRequest(false);

			} else if (activeStates.contains(State.StreetAttention)) {
				activeStates.remove(State.StreetAttention);
				getTimerHandler().resetTimer(StreetAttention_time_event_0);

			} else if (activeStates.contains(State.StreetRed)) {
				activeStates.remove(State.StreetRed);
				getTimerHandler().resetTimer(StreetRed_time_event_0);

			} else if (activeStates.contains(State.PedestrianGreen)) {
				activeStates.remove(State.PedestrianGreen);
				getTimerHandler().resetTimer(PedestrianGreen_time_event_0);

			} else if (activeStates.contains(State.PedestrianRed)) {
				activeStates.remove(State.PedestrianRed);
				getTimerHandler().resetTimer(PedestrianRed_time_event_0);

			} else if (activeStates.contains(State.StreetPrepare)) {
				activeStates.remove(State.StreetPrepare);
				getTimerHandler().resetTimer(StreetPrepare_time_event_0);

			}

			interfaceTrafficLight.setVarRed(false);
			interfaceTrafficLight.setVarGreen(false);
			interfaceTrafficLight.setVarYellow(false);
			interfacePedestrian.setVarRed(false);
			interfacePedestrian.setVarGreen(false);

			getTimerHandler().setTimer(YellowOn_time_event_0, 500,
					cycleStartTime);
			interfaceTrafficLight.setVarYellow(true);

			activeStates.add(State.YellowOn);

		} else {
			if (occuredEvents.contains(StreetPrepare_time_event_0)) {
				activeStates.remove(State.StreetPrepare);
				getTimerHandler().resetTimer(StreetPrepare_time_event_0);

				interfaceTrafficLight.setVarRed(false);
				interfaceTrafficLight.setVarYellow(false);
				interfaceTrafficLight.setVarGreen(true);
				interfacePedestrian.setVarRed(true);
				interfacePedestrian.setVarGreen(false);
				interfacePedestrian.setVarRequest(false);

				activeStates.add(State.StreetGreen);

			}

		}
	}
	private void reactOff() {
	}
	private void reactYellowOn() {
		if (occuredEvents.contains(defaultInterface.getEventKeypress2())) {
			if (activeStates.contains(State.YellowOn)) {
				activeStates.remove(State.YellowOn);
				getTimerHandler().resetTimer(YellowOn_time_event_0);

			} else if (activeStates.contains(State.YellowOff)) {
				activeStates.remove(State.YellowOff);
				getTimerHandler().resetTimer(YellowOff_time_event_0);

			}

			interfaceTrafficLight.setVarRed(false);
			interfaceTrafficLight.setVarYellow(false);
			interfaceTrafficLight.setVarGreen(true);
			interfacePedestrian.setVarRed(true);
			interfacePedestrian.setVarGreen(false);
			interfacePedestrian.setVarRequest(false);

			activeStates.add(State.StreetGreen);

		} else {
			if (occuredEvents.contains(YellowOn_time_event_0)) {
				activeStates.remove(State.YellowOn);
				getTimerHandler().resetTimer(YellowOn_time_event_0);

				getTimerHandler().setTimer(YellowOff_time_event_0, 500,
						cycleStartTime);
				interfaceTrafficLight.setVarYellow(false);

				activeStates.add(State.YellowOff);

			}

		}
	}
	private void reactYellowOff() {
		if (occuredEvents.contains(defaultInterface.getEventKeypress2())) {
			if (activeStates.contains(State.YellowOn)) {
				activeStates.remove(State.YellowOn);
				getTimerHandler().resetTimer(YellowOn_time_event_0);

			} else if (activeStates.contains(State.YellowOff)) {
				activeStates.remove(State.YellowOff);
				getTimerHandler().resetTimer(YellowOff_time_event_0);

			}

			interfaceTrafficLight.setVarRed(false);
			interfaceTrafficLight.setVarYellow(false);
			interfaceTrafficLight.setVarGreen(true);
			interfacePedestrian.setVarRed(true);
			interfacePedestrian.setVarGreen(false);
			interfacePedestrian.setVarRequest(false);

			activeStates.add(State.StreetGreen);

		} else {
			if (occuredEvents.contains(YellowOff_time_event_0)) {
				activeStates.remove(State.YellowOff);
				getTimerHandler().resetTimer(YellowOff_time_event_0);

				getTimerHandler().setTimer(YellowOn_time_event_0, 500,
						cycleStartTime);
				interfaceTrafficLight.setVarYellow(true);

				activeStates.add(State.YellowOn);

			}

		}
	}
	public void runCycle() {
		cycleStartTime = System.currentTimeMillis();
		outEvents.clear();
		for (State state : activeStates) {
			switch (state) {
				case On :
					reactOn();
					break;
				case StreetGreen :
					reactStreetGreen();
					break;
				case PedWaiting :
					reactPedWaiting();
					break;
				case WaitOn :
					reactWaitOn();
					break;
				case WaitOff :
					reactWaitOff();
					break;
				case StreetAttention :
					reactStreetAttention();
					break;
				case StreetRed :
					reactStreetRed();
					break;
				case PedestrianGreen :
					reactPedestrianGreen();
					break;
				case PedestrianRed :
					reactPedestrianRed();
					break;
				case StreetPrepare :
					reactStreetPrepare();
					break;
				case Off :
					reactOff();
					break;
				case YellowOn :
					reactYellowOn();
					break;
				case YellowOff :
					reactYellowOff();
					break;
				default :
					// no state found
			}
		}
		occuredEvents.clear();
	}
}
