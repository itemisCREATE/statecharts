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

public abstract class TrafficLightWaitingAbstractBaseStatemachine
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
	private static final TimeEvent BlinkYellow_time_event_0 = new TimeEvent(
			"BlinkYellow_time_event_0", true);

	public enum State {
		On, StreetGreen, PedWaiting, WaitOn, WaitOff, StreetAttention, StreetRed, PedestrianGreen, PedestrianRed, StreetPrepare, Freeze, Off, BlinkYellow,
	};

	private InterfaceTrafficLightImpl interfaceTrafficLight;
	private InterfacePedestrianImpl interfacePedestrian;
	private InterfaceDefaultImpl interfaceDefault;

	private final Set<State> activeStates = EnumSet.noneOf(State.class);

	private final Collection<Event> occuredEvents;

	private final Collection<Event> outEvents;

	private ITimerHandler timerHandler;

	private long cycleStartTime;

	public TrafficLightWaitingAbstractBaseStatemachine(
			Collection<Event> occuredEvents) {
		this.occuredEvents = occuredEvents;
		this.outEvents = new HashSet<Event>();
		interfaceTrafficLight = new InterfaceTrafficLightImpl(this);
		interfacePedestrian = new InterfacePedestrianImpl(this);
		interfaceDefault = new InterfaceDefaultImpl(this);
	}

	protected Collection<Event> getOccuredEvents() {
		return occuredEvents;
	}

	protected Collection<Event> getOutEvents() {
		return outEvents;
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

	public InterfaceDefault getInterfaceDefault() {
		return interfaceDefault;
	}

	public void enterSequenceStatechartTrafficLightWaiting() {
		cycleStartTime = System.currentTimeMillis();
		enterSequenceOn();
	}

	private boolean conditionOnTr0(Collection<?> events) {
		return getOccuredEvents()
				.contains(interfaceDefault.getEventKeypress3());
	}
	private boolean conditionOnTr1(Collection<?> events) {
		return getOccuredEvents()
				.contains(interfaceDefault.getEventKeypress2());
	}
	private boolean conditionStreetGreenTr0(Collection<?> events) {
		return getOccuredEvents()
				.contains(interfaceDefault.getEventKeypress1());
	}
	private boolean conditionPedWaitingTr0(Collection<?> events) {
		return getOccuredEvents().contains(PedWaiting_time_event_0);
	}
	private boolean conditionWaitOnTr0(Collection<?> events) {
		return getOccuredEvents().contains(WaitOn_time_event_0);
	}
	private boolean conditionWaitOffTr0(Collection<?> events) {
		return getOccuredEvents().contains(WaitOff_time_event_0);
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
	private boolean conditionFreezeTr0(Collection<?> events) {
		return getOccuredEvents()
				.contains(interfaceDefault.getEventKeypress3());
	}
	private boolean conditionOffTr0(Collection<?> events) {
		return getOccuredEvents()
				.contains(interfaceDefault.getEventKeypress2());
	}
	private boolean conditionBlinkYellowLr1(Collection<?> events) {
		return getOccuredEvents().contains(BlinkYellow_time_event_0);
	}
	private void actionsOnTr0() {
		exitSequenceOn();
		enterSequenceFreeze();

	}
	private void actionsOnTr1() {
		exitSequenceOn();
		enterSequenceOff();

	}
	private void actionsStreetGreenTr0() {
		exitSequenceStreetGreen();
		enterSequencePedWaiting();

	}
	private void actionsPedWaitingTr0() {
		exitSequencePedWaiting();
		enterSequenceStreetAttention();

	}
	private void actionsWaitOnTr0() {
		exitSequenceWaitOn();
		enterSequenceWaitOff();

	}
	private void actionsWaitOffTr0() {
		exitSequenceWaitOff();
		enterSequenceWaitOn();

	}
	private void actionsStreetAttentionTr0() {
		exitSequenceStreetAttention();
		enterSequenceStreetRed();

	}
	private void actionsStreetRedTr0() {
		exitSequenceStreetRed();
		enterSequencePedestrianGreen();

	}
	private void actionsPedestrianGreenTr0() {
		exitSequencePedestrianGreen();
		enterSequencePedestrianRed();

	}
	private void actionsPedestrianRedTr0() {
		exitSequencePedestrianRed();
		enterSequenceStreetPrepare();

	}
	private void actionsStreetPrepareTr0() {
		exitSequenceStreetPrepare();
		enterSequenceStreetGreen();

	}
	private void actionsFreezeTr0() {
		exitSequenceFreeze();
		enterSequenceOn();

	}
	private void actionsOffTr0() {
		exitSequenceOff();
		enterSequenceOn();

	}
	private void actionsBlinkYellowLr1() {
		interfaceTrafficLight.setVarYellow(!interfaceTrafficLight
				.getVarYellow());

	}
	private void entryActionStreetGreen() {
		interfaceTrafficLight.setVarRed(false);
		interfaceTrafficLight.setVarYellow(false);
		interfaceTrafficLight.setVarGreen(true);
		interfacePedestrian.setVarRed(true);
		interfacePedestrian.setVarGreen(false);
		interfacePedestrian.setVarRequest(false);

	}
	private void entryActionPedWaiting() {
		getTimerHandler().setTimer(PedWaiting_time_event_0, (7 * 1000),
				cycleStartTime);

	}
	private void entryActionWaitOn() {
		getTimerHandler().setTimer(WaitOn_time_event_0, 500, cycleStartTime);
		interfacePedestrian.setVarRequest(true);

	}
	private void entryActionWaitOff() {
		getTimerHandler().setTimer(WaitOff_time_event_0, 500, cycleStartTime);
		interfacePedestrian.setVarRequest(false);

	}
	private void entryActionStreetAttention() {
		getTimerHandler().setTimer(StreetAttention_time_event_0, (2 * 1000),
				cycleStartTime);
		interfaceTrafficLight.setVarRed(false);
		interfaceTrafficLight.setVarYellow(true);
		interfaceTrafficLight.setVarGreen(false);

	}
	private void entryActionStreetRed() {
		getTimerHandler().setTimer(StreetRed_time_event_0, (2 * 1000),
				cycleStartTime);
		interfaceTrafficLight.setVarRed(true);
		interfaceTrafficLight.setVarYellow(false);
		interfaceTrafficLight.setVarGreen(false);

	}
	private void entryActionPedestrianGreen() {
		getTimerHandler().setTimer(PedestrianGreen_time_event_0, (7 * 1000),
				cycleStartTime);
		interfacePedestrian.setVarRed(false);
		interfacePedestrian.setVarGreen(true);

	}
	private void entryActionPedestrianRed() {
		getTimerHandler().setTimer(PedestrianRed_time_event_0, (3 * 1000),
				cycleStartTime);
		interfacePedestrian.setVarRed(true);
		interfacePedestrian.setVarGreen(false);

	}
	private void entryActionStreetPrepare() {
		getTimerHandler().setTimer(StreetPrepare_time_event_0, (2 * 1000),
				cycleStartTime);
		interfaceTrafficLight.setVarRed(true);
		interfaceTrafficLight.setVarYellow(true);
		interfaceTrafficLight.setVarGreen(false);

	}
	private void entryActionOff() {
		interfaceTrafficLight.setVarRed(false);
		interfaceTrafficLight.setVarGreen(false);
		interfaceTrafficLight.setVarYellow(false);
		interfacePedestrian.setVarRed(true);

	}
	private void entryActionBlinkYellow() {
		getTimerHandler().setTimer(BlinkYellow_time_event_0, 500,
				cycleStartTime);
		interfaceTrafficLight.setVarYellow(true);

	}
	private void exitActionPedWaiting() {
		getTimerHandler().resetTimer(PedWaiting_time_event_0);
		interfacePedestrian.setVarRequest(false);

	}
	private void exitActionWaitOn() {
		getTimerHandler().resetTimer(WaitOn_time_event_0);

	}
	private void exitActionWaitOff() {
		getTimerHandler().resetTimer(WaitOff_time_event_0);

	}
	private void exitActionStreetAttention() {
		getTimerHandler().resetTimer(StreetAttention_time_event_0);

	}
	private void exitActionStreetRed() {
		getTimerHandler().resetTimer(StreetRed_time_event_0);

	}
	private void exitActionPedestrianGreen() {
		getTimerHandler().resetTimer(PedestrianGreen_time_event_0);

	}
	private void exitActionPedestrianRed() {
		getTimerHandler().resetTimer(PedestrianRed_time_event_0);

	}
	private void exitActionStreetPrepare() {
		getTimerHandler().resetTimer(StreetPrepare_time_event_0);

	}
	private void exitActionBlinkYellow() {
		getTimerHandler().resetTimer(BlinkYellow_time_event_0);

	}

	private void enterSequenceOn() {
		enterSequenceStreetGreen();
	}

	private void enterSequenceStreetGreen() {
		entryActionStreetGreen();
		activeStates.add(State.StreetGreen);
	}

	private void enterSequencePedWaiting() {
		entryActionPedWaiting();
		enterSequenceWaitOn();
	}

	private void enterSequenceWaitOn() {
		entryActionWaitOn();
		activeStates.add(State.WaitOn);
	}

	private void enterSequenceWaitOff() {
		entryActionWaitOff();
		activeStates.add(State.WaitOff);
	}

	private void enterSequenceStreetAttention() {
		entryActionStreetAttention();
		activeStates.add(State.StreetAttention);
	}

	private void enterSequenceStreetRed() {
		entryActionStreetRed();
		activeStates.add(State.StreetRed);
	}

	private void enterSequencePedestrianGreen() {
		entryActionPedestrianGreen();
		activeStates.add(State.PedestrianGreen);
	}

	private void enterSequencePedestrianRed() {
		entryActionPedestrianRed();
		activeStates.add(State.PedestrianRed);
	}

	private void enterSequenceStreetPrepare() {
		entryActionStreetPrepare();
		activeStates.add(State.StreetPrepare);
	}

	private void enterSequenceFreeze() {
		activeStates.add(State.Freeze);
	}

	private void enterSequenceOff() {
		entryActionOff();
		enterSequenceBlinkYellow();
	}

	private void enterSequenceBlinkYellow() {
		entryActionBlinkYellow();
		activeStates.add(State.BlinkYellow);
	}
	private void exitSequenceOn() {
		if (activeStates.contains(State.StreetGreen)) {
			exitSequenceStreetGreen();

		} else if (activeStates.contains(State.PedWaiting)) {
			exitSequencePedWaiting();

		} else if (activeStates.contains(State.StreetAttention)) {
			exitSequenceStreetAttention();

		} else if (activeStates.contains(State.StreetRed)) {
			exitSequenceStreetRed();

		} else if (activeStates.contains(State.PedestrianGreen)) {
			exitSequencePedestrianGreen();

		} else if (activeStates.contains(State.PedestrianRed)) {
			exitSequencePedestrianRed();

		} else if (activeStates.contains(State.StreetPrepare)) {
			exitSequenceStreetPrepare();

		}
	}
	private void exitSequenceStreetGreen() {
		activeStates.remove(State.StreetGreen);
	}
	private void exitSequencePedWaiting() {
		if (activeStates.contains(State.WaitOn)) {
			exitSequenceWaitOn();

		} else if (activeStates.contains(State.WaitOff)) {
			exitSequenceWaitOff();

		}
		exitActionPedWaiting();
	}
	private void exitSequenceWaitOn() {
		activeStates.remove(State.WaitOn);
		exitActionWaitOn();
	}
	private void exitSequenceWaitOff() {
		activeStates.remove(State.WaitOff);
		exitActionWaitOff();
	}
	private void exitSequenceStreetAttention() {
		activeStates.remove(State.StreetAttention);
		exitActionStreetAttention();
	}
	private void exitSequenceStreetRed() {
		activeStates.remove(State.StreetRed);
		exitActionStreetRed();
	}
	private void exitSequencePedestrianGreen() {
		activeStates.remove(State.PedestrianGreen);
		exitActionPedestrianGreen();
	}
	private void exitSequencePedestrianRed() {
		activeStates.remove(State.PedestrianRed);
		exitActionPedestrianRed();
	}
	private void exitSequenceStreetPrepare() {
		activeStates.remove(State.StreetPrepare);
		exitActionStreetPrepare();
	}
	private void exitSequenceFreeze() {
		activeStates.remove(State.Freeze);
	}
	private void exitSequenceOff() {
		if (activeStates.contains(State.BlinkYellow)) {
			exitSequenceBlinkYellow();

		}
	}
	private void exitSequenceBlinkYellow() {
		activeStates.remove(State.BlinkYellow);
		exitActionBlinkYellow();
	}
	private void cycleOn(Collection<?> events) {
	}
	private void cycleStreetGreen(Collection<?> events) {
		if (conditionOnTr0(events)) {
			actionsOnTr0();
		} else {
			if (conditionOnTr1(events)) {
				actionsOnTr1();
			} else {
				if (conditionStreetGreenTr0(events)) {
					actionsStreetGreenTr0();
				}

			}
		}
	}
	private void cyclePedWaiting(Collection<?> events) {
	}
	private void cycleWaitOn(Collection<?> events) {
		if (conditionOnTr0(events)) {
			actionsOnTr0();
		} else {
			if (conditionOnTr1(events)) {
				actionsOnTr1();
			} else {
				if (conditionPedWaitingTr0(events)) {
					actionsPedWaitingTr0();
				} else {
					if (conditionWaitOnTr0(events)) {
						actionsWaitOnTr0();
					}

				}

			}
		}
	}
	private void cycleWaitOff(Collection<?> events) {
		if (conditionOnTr0(events)) {
			actionsOnTr0();
		} else {
			if (conditionOnTr1(events)) {
				actionsOnTr1();
			} else {
				if (conditionPedWaitingTr0(events)) {
					actionsPedWaitingTr0();
				} else {
					if (conditionWaitOffTr0(events)) {
						actionsWaitOffTr0();
					}

				}

			}
		}
	}
	private void cycleStreetAttention(Collection<?> events) {
		if (conditionOnTr0(events)) {
			actionsOnTr0();
		} else {
			if (conditionOnTr1(events)) {
				actionsOnTr1();
			} else {
				if (conditionStreetAttentionTr0(events)) {
					actionsStreetAttentionTr0();
				}

			}
		}
	}
	private void cycleStreetRed(Collection<?> events) {
		if (conditionOnTr0(events)) {
			actionsOnTr0();
		} else {
			if (conditionOnTr1(events)) {
				actionsOnTr1();
			} else {
				if (conditionStreetRedTr0(events)) {
					actionsStreetRedTr0();
				}

			}
		}
	}
	private void cyclePedestrianGreen(Collection<?> events) {
		if (conditionOnTr0(events)) {
			actionsOnTr0();
		} else {
			if (conditionOnTr1(events)) {
				actionsOnTr1();
			} else {
				if (conditionPedestrianGreenTr0(events)) {
					actionsPedestrianGreenTr0();
				}

			}
		}
	}
	private void cyclePedestrianRed(Collection<?> events) {
		if (conditionOnTr0(events)) {
			actionsOnTr0();
		} else {
			if (conditionOnTr1(events)) {
				actionsOnTr1();
			} else {
				if (conditionPedestrianRedTr0(events)) {
					actionsPedestrianRedTr0();
				}

			}
		}
	}
	private void cycleStreetPrepare(Collection<?> events) {
		if (conditionOnTr0(events)) {
			actionsOnTr0();
		} else {
			if (conditionOnTr1(events)) {
				actionsOnTr1();
			} else {
				if (conditionStreetPrepareTr0(events)) {
					actionsStreetPrepareTr0();
				}

			}
		}
	}
	private void cycleFreeze(Collection<?> events) {
		if (conditionFreezeTr0(events)) {
			actionsFreezeTr0();
		}
	}
	private void cycleOff(Collection<?> events) {
	}
	private void cycleBlinkYellow(Collection<?> events) {
		if (conditionOffTr0(events)) {
			actionsOffTr0();
		} else {
			if (conditionBlinkYellowLr1(events)) {
				actionsBlinkYellowLr1();
			}

		}
	}
	protected void runCycle(Collection<?> events) {
		cycleStartTime = System.currentTimeMillis();
		getOutEvents().clear();
		for (State state : activeStates) {
			switch (state) {
				case On :
					cycleOn(events);
					break;
				case StreetGreen :
					cycleStreetGreen(events);
					break;
				case PedWaiting :
					cyclePedWaiting(events);
					break;
				case WaitOn :
					cycleWaitOn(events);
					break;
				case WaitOff :
					cycleWaitOff(events);
					break;
				case StreetAttention :
					cycleStreetAttention(events);
					break;
				case StreetRed :
					cycleStreetRed(events);
					break;
				case PedestrianGreen :
					cyclePedestrianGreen(events);
					break;
				case PedestrianRed :
					cyclePedestrianRed(events);
					break;
				case StreetPrepare :
					cycleStreetPrepare(events);
					break;
				case Freeze :
					cycleFreeze(events);
					break;
				case Off :
					cycleOff(events);
					break;
				case BlinkYellow :
					cycleBlinkYellow(events);
					break;
				default :
					// no state found
			}
		}
	}
}
