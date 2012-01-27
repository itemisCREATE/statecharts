/**
Copyright (c) 2011 committers of YAKINDU and others. 
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html
 
Contributors:
	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.runtime.java.trafficlightwaiting;

import java.util.Collection;
import java.util.HashSet;
import org.yakindu.sct.runtime.java.Event;
import org.yakindu.sct.runtime.java.EventVector;
import org.yakindu.sct.runtime.java.TimeEvent;
import org.yakindu.sct.runtime.java.ITimedStatemachine;
import org.yakindu.sct.runtime.java.ITimerService;
import org.yakindu.sct.runtime.java.EventNotification;
import org.yakindu.sct.runtime.java.Notification;

public class TrafficLightWaitingCycleBasedStatemachine
		implements
			ITimedStatemachine {

	private enum TimeEvents {
		PedWaiting_time_event_0, WaitOn_time_event_0, WaitOff_time_event_0, StreetAttention_time_event_0, StreetRed_time_event_0, PedestrianGreen_time_event_0, PedestrianRed_time_event_0, StreetPrepare_time_event_0, YellowOn_time_event_0, YellowOff_time_event_0,
	}

	private static final TimeEvent<TimeEvents> PedWaiting_time_event_0 = new TimeEvent<TimeEvents>(
			TimeEvents.PedWaiting_time_event_0, 2, false);
	private static final TimeEvent<TimeEvents> WaitOn_time_event_0 = new TimeEvent<TimeEvents>(
			TimeEvents.WaitOn_time_event_0, 2, false);
	private static final TimeEvent<TimeEvents> WaitOff_time_event_0 = new TimeEvent<TimeEvents>(
			TimeEvents.WaitOff_time_event_0, 2, false);
	private static final TimeEvent<TimeEvents> StreetAttention_time_event_0 = new TimeEvent<TimeEvents>(
			TimeEvents.StreetAttention_time_event_0, 2, false);
	private static final TimeEvent<TimeEvents> StreetRed_time_event_0 = new TimeEvent<TimeEvents>(
			TimeEvents.StreetRed_time_event_0, 2, false);
	private static final TimeEvent<TimeEvents> PedestrianGreen_time_event_0 = new TimeEvent<TimeEvents>(
			TimeEvents.PedestrianGreen_time_event_0, 2, false);
	private static final TimeEvent<TimeEvents> PedestrianRed_time_event_0 = new TimeEvent<TimeEvents>(
			TimeEvents.PedestrianRed_time_event_0, 2, false);
	private static final TimeEvent<TimeEvents> StreetPrepare_time_event_0 = new TimeEvent<TimeEvents>(
			TimeEvents.StreetPrepare_time_event_0, 2, false);
	private static final TimeEvent<TimeEvents> YellowOn_time_event_0 = new TimeEvent<TimeEvents>(
			TimeEvents.YellowOn_time_event_0, 2, false);
	private static final TimeEvent<TimeEvents> YellowOff_time_event_0 = new TimeEvent<TimeEvents>(
			TimeEvents.YellowOff_time_event_0, 2, false);

	public enum State {
		On, StreetGreen, PedWaiting, WaitOn, WaitOff, StreetAttention, StreetRed, PedestrianGreen, PedestrianRed, StreetPrepare, Off, YellowOn, YellowOff, $NullState$
	};

	private InterfaceTrafficLightImpl interfaceTrafficLight;
	private InterfacePedestrianImpl interfacePedestrian;
	private DefaultInterfaceImpl defaultInterface;

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	private final EventVector<Event<? extends Enum<?>>> occuredEvents;

	private final Collection<Event<? extends Enum<?>>> outEvents;

	private ITimerService timerService;

	private long cycleStartTime;

	public TrafficLightWaitingCycleBasedStatemachine() {
		occuredEvents = new EventVector<Event<? extends Enum<?>>>(12);
		outEvents = new HashSet<Event<? extends Enum<?>>>();
		interfaceTrafficLight = new InterfaceTrafficLightImpl();
		interfacePedestrian = new InterfacePedestrianImpl();
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
					"TimerService of statemachine \"+TrafficLightWaiting+\" not set!");
		}
		return timerService;
	}

	public void notify(Notification notification) {
		if (notification instanceof EventNotification) {
			EventNotification eventNotification = (EventNotification) notification;
			getOccuredEvents().add(eventNotification.getEvent());
		}
	}

	public InterfaceTrafficLight getInterfaceTrafficLight() {
		return interfaceTrafficLight;
	}

	private InterfaceTrafficLightImpl getInterfaceTrafficLightImpl() {
		return interfaceTrafficLight;
	}
	public InterfacePedestrian getInterfacePedestrian() {
		return interfacePedestrian;
	}

	private InterfacePedestrianImpl getInterfacePedestrianImpl() {
		return interfacePedestrian;
	}
	public DefaultInterface getDefaultInterface() {
		return defaultInterface;
	}

	private DefaultInterfaceImpl getDefaultInterfaceImpl() {
		return defaultInterface;
	}

	public void enter() {
		cycleStartTime = System.currentTimeMillis();
		getInterfaceTrafficLightImpl().setVarRed(false);
		getInterfaceTrafficLightImpl().setVarYellow(false);
		getInterfaceTrafficLightImpl().setVarGreen(true);
		getInterfacePedestrianImpl().setVarRed(true);
		getInterfacePedestrianImpl().setVarGreen(false);
		getInterfacePedestrianImpl().setVarRequest(false);

		nextStateIndex = 0;
		stateVector[0] = State.StreetGreen;

	}

	public void exit() {
		//Handle exit of all possible states (of main region) at position 0...
		switch (stateVector[0]) {

			case StreetGreen :
				stateVector[0] = State.$NullState$;

				break;

			case WaitOn :
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(WaitOn_time_event_0);

				getTimerService().resetTimer(PedWaiting_time_event_0);
				getInterfacePedestrianImpl().setVarRequest(false);

				break;

			case WaitOff :
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(WaitOff_time_event_0);

				getTimerService().resetTimer(PedWaiting_time_event_0);
				getInterfacePedestrianImpl().setVarRequest(false);

				break;

			case StreetAttention :
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(StreetAttention_time_event_0);

				break;

			case StreetRed :
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(StreetRed_time_event_0);

				break;

			case PedestrianGreen :
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(PedestrianGreen_time_event_0);

				break;

			case PedestrianRed :
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(PedestrianRed_time_event_0);

				break;

			case StreetPrepare :
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(StreetPrepare_time_event_0);

				break;

			case YellowOn :
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(YellowOn_time_event_0);

				break;

			case YellowOff :
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(YellowOff_time_event_0);

				break;

			default :
				break;
		}

	}

	private void reactOn() {
	}
	private void reactStreetGreen() {
		if (occuredEvents.contains(getDefaultInterfaceImpl()
				.getEventKeypress2())) {
			//Handle exit of all possible states (of r1) at position 0...
			switch (stateVector[0]) {

				case StreetGreen :
					stateVector[0] = State.$NullState$;

					break;

				case WaitOn :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(WaitOn_time_event_0);

					getTimerService().resetTimer(PedWaiting_time_event_0);
					getInterfacePedestrianImpl().setVarRequest(false);

					break;

				case WaitOff :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(WaitOff_time_event_0);

					getTimerService().resetTimer(PedWaiting_time_event_0);
					getInterfacePedestrianImpl().setVarRequest(false);

					break;

				case StreetAttention :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(StreetAttention_time_event_0);

					break;

				case StreetRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(StreetRed_time_event_0);

					break;

				case PedestrianGreen :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(PedestrianGreen_time_event_0);

					break;

				case PedestrianRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(PedestrianRed_time_event_0);

					break;

				case StreetPrepare :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(StreetPrepare_time_event_0);

					break;

				default :
					break;
			}

			getInterfaceTrafficLightImpl().setVarRed(false);
			getInterfaceTrafficLightImpl().setVarGreen(false);
			getInterfaceTrafficLightImpl().setVarYellow(false);
			getInterfacePedestrianImpl().setVarRed(false);
			getInterfacePedestrianImpl().setVarGreen(false);

			getTimerService().setTimer(YellowOn_time_event_0, 500,
					cycleStartTime);
			getInterfaceTrafficLightImpl().setVarYellow(true);

			nextStateIndex = 0;
			stateVector[0] = State.YellowOn;

		} else {
			if (occuredEvents.contains(getDefaultInterfaceImpl()
					.getEventKeypress1())) {
				stateVector[0] = State.$NullState$;

				getTimerService().setTimer(PedWaiting_time_event_0, (7 * 1000),
						cycleStartTime);

				getTimerService().setTimer(WaitOn_time_event_0, 500,
						cycleStartTime);
				getInterfacePedestrianImpl().setVarRequest(true);

				nextStateIndex = 0;
				stateVector[0] = State.WaitOn;

			}

		}
	}
	private void reactPedWaiting() {
	}
	private void reactWaitOn() {
		if (occuredEvents.contains(getDefaultInterfaceImpl()
				.getEventKeypress2())) {
			//Handle exit of all possible states (of r1) at position 0...
			switch (stateVector[0]) {

				case StreetGreen :
					stateVector[0] = State.$NullState$;

					break;

				case WaitOn :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(WaitOn_time_event_0);

					getTimerService().resetTimer(PedWaiting_time_event_0);
					getInterfacePedestrianImpl().setVarRequest(false);

					break;

				case WaitOff :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(WaitOff_time_event_0);

					getTimerService().resetTimer(PedWaiting_time_event_0);
					getInterfacePedestrianImpl().setVarRequest(false);

					break;

				case StreetAttention :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(StreetAttention_time_event_0);

					break;

				case StreetRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(StreetRed_time_event_0);

					break;

				case PedestrianGreen :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(PedestrianGreen_time_event_0);

					break;

				case PedestrianRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(PedestrianRed_time_event_0);

					break;

				case StreetPrepare :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(StreetPrepare_time_event_0);

					break;

				default :
					break;
			}

			getInterfaceTrafficLightImpl().setVarRed(false);
			getInterfaceTrafficLightImpl().setVarGreen(false);
			getInterfaceTrafficLightImpl().setVarYellow(false);
			getInterfacePedestrianImpl().setVarRed(false);
			getInterfacePedestrianImpl().setVarGreen(false);

			getTimerService().setTimer(YellowOn_time_event_0, 500,
					cycleStartTime);
			getInterfaceTrafficLightImpl().setVarYellow(true);

			nextStateIndex = 0;
			stateVector[0] = State.YellowOn;

		} else {
			if (occuredEvents.contains(PedWaiting_time_event_0)) {
				//Handle exit of all possible states (of r1) at position 0...
				switch (stateVector[0]) {

					case WaitOn :
						stateVector[0] = State.$NullState$;
						getTimerService().resetTimer(WaitOn_time_event_0);

						break;

					case WaitOff :
						stateVector[0] = State.$NullState$;
						getTimerService().resetTimer(WaitOff_time_event_0);

						break;

					default :
						break;
				}

				getTimerService().resetTimer(PedWaiting_time_event_0);
				getInterfacePedestrianImpl().setVarRequest(false);

				getTimerService().setTimer(StreetAttention_time_event_0,
						(2 * 1000), cycleStartTime);
				getInterfaceTrafficLightImpl().setVarRed(false);
				getInterfaceTrafficLightImpl().setVarYellow(true);
				getInterfaceTrafficLightImpl().setVarGreen(false);

				nextStateIndex = 0;
				stateVector[0] = State.StreetAttention;

			} else {
				if (occuredEvents.contains(WaitOn_time_event_0)) {
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(WaitOn_time_event_0);

					getTimerService().setTimer(WaitOff_time_event_0, 500,
							cycleStartTime);
					getInterfacePedestrianImpl().setVarRequest(false);

					nextStateIndex = 0;
					stateVector[0] = State.WaitOff;

				}

			}

		}
	}
	private void reactWaitOff() {
		if (occuredEvents.contains(getDefaultInterfaceImpl()
				.getEventKeypress2())) {
			//Handle exit of all possible states (of r1) at position 0...
			switch (stateVector[0]) {

				case StreetGreen :
					stateVector[0] = State.$NullState$;

					break;

				case WaitOn :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(WaitOn_time_event_0);

					getTimerService().resetTimer(PedWaiting_time_event_0);
					getInterfacePedestrianImpl().setVarRequest(false);

					break;

				case WaitOff :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(WaitOff_time_event_0);

					getTimerService().resetTimer(PedWaiting_time_event_0);
					getInterfacePedestrianImpl().setVarRequest(false);

					break;

				case StreetAttention :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(StreetAttention_time_event_0);

					break;

				case StreetRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(StreetRed_time_event_0);

					break;

				case PedestrianGreen :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(PedestrianGreen_time_event_0);

					break;

				case PedestrianRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(PedestrianRed_time_event_0);

					break;

				case StreetPrepare :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(StreetPrepare_time_event_0);

					break;

				default :
					break;
			}

			getInterfaceTrafficLightImpl().setVarRed(false);
			getInterfaceTrafficLightImpl().setVarGreen(false);
			getInterfaceTrafficLightImpl().setVarYellow(false);
			getInterfacePedestrianImpl().setVarRed(false);
			getInterfacePedestrianImpl().setVarGreen(false);

			getTimerService().setTimer(YellowOn_time_event_0, 500,
					cycleStartTime);
			getInterfaceTrafficLightImpl().setVarYellow(true);

			nextStateIndex = 0;
			stateVector[0] = State.YellowOn;

		} else {
			if (occuredEvents.contains(PedWaiting_time_event_0)) {
				//Handle exit of all possible states (of r1) at position 0...
				switch (stateVector[0]) {

					case WaitOn :
						stateVector[0] = State.$NullState$;
						getTimerService().resetTimer(WaitOn_time_event_0);

						break;

					case WaitOff :
						stateVector[0] = State.$NullState$;
						getTimerService().resetTimer(WaitOff_time_event_0);

						break;

					default :
						break;
				}

				getTimerService().resetTimer(PedWaiting_time_event_0);
				getInterfacePedestrianImpl().setVarRequest(false);

				getTimerService().setTimer(StreetAttention_time_event_0,
						(2 * 1000), cycleStartTime);
				getInterfaceTrafficLightImpl().setVarRed(false);
				getInterfaceTrafficLightImpl().setVarYellow(true);
				getInterfaceTrafficLightImpl().setVarGreen(false);

				nextStateIndex = 0;
				stateVector[0] = State.StreetAttention;

			} else {
				if (occuredEvents.contains(WaitOff_time_event_0)) {
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(WaitOff_time_event_0);

					getTimerService().setTimer(WaitOn_time_event_0, 500,
							cycleStartTime);
					getInterfacePedestrianImpl().setVarRequest(true);

					nextStateIndex = 0;
					stateVector[0] = State.WaitOn;

				}

			}

		}
	}
	private void reactStreetAttention() {
		if (occuredEvents.contains(getDefaultInterfaceImpl()
				.getEventKeypress2())) {
			//Handle exit of all possible states (of r1) at position 0...
			switch (stateVector[0]) {

				case StreetGreen :
					stateVector[0] = State.$NullState$;

					break;

				case WaitOn :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(WaitOn_time_event_0);

					getTimerService().resetTimer(PedWaiting_time_event_0);
					getInterfacePedestrianImpl().setVarRequest(false);

					break;

				case WaitOff :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(WaitOff_time_event_0);

					getTimerService().resetTimer(PedWaiting_time_event_0);
					getInterfacePedestrianImpl().setVarRequest(false);

					break;

				case StreetAttention :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(StreetAttention_time_event_0);

					break;

				case StreetRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(StreetRed_time_event_0);

					break;

				case PedestrianGreen :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(PedestrianGreen_time_event_0);

					break;

				case PedestrianRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(PedestrianRed_time_event_0);

					break;

				case StreetPrepare :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(StreetPrepare_time_event_0);

					break;

				default :
					break;
			}

			getInterfaceTrafficLightImpl().setVarRed(false);
			getInterfaceTrafficLightImpl().setVarGreen(false);
			getInterfaceTrafficLightImpl().setVarYellow(false);
			getInterfacePedestrianImpl().setVarRed(false);
			getInterfacePedestrianImpl().setVarGreen(false);

			getTimerService().setTimer(YellowOn_time_event_0, 500,
					cycleStartTime);
			getInterfaceTrafficLightImpl().setVarYellow(true);

			nextStateIndex = 0;
			stateVector[0] = State.YellowOn;

		} else {
			if (occuredEvents.contains(StreetAttention_time_event_0)) {
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(StreetAttention_time_event_0);

				getTimerService().setTimer(StreetRed_time_event_0, (2 * 1000),
						cycleStartTime);
				getInterfaceTrafficLightImpl().setVarRed(true);
				getInterfaceTrafficLightImpl().setVarYellow(false);
				getInterfaceTrafficLightImpl().setVarGreen(false);

				nextStateIndex = 0;
				stateVector[0] = State.StreetRed;

			}

		}
	}
	private void reactStreetRed() {
		if (occuredEvents.contains(getDefaultInterfaceImpl()
				.getEventKeypress2())) {
			//Handle exit of all possible states (of r1) at position 0...
			switch (stateVector[0]) {

				case StreetGreen :
					stateVector[0] = State.$NullState$;

					break;

				case WaitOn :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(WaitOn_time_event_0);

					getTimerService().resetTimer(PedWaiting_time_event_0);
					getInterfacePedestrianImpl().setVarRequest(false);

					break;

				case WaitOff :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(WaitOff_time_event_0);

					getTimerService().resetTimer(PedWaiting_time_event_0);
					getInterfacePedestrianImpl().setVarRequest(false);

					break;

				case StreetAttention :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(StreetAttention_time_event_0);

					break;

				case StreetRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(StreetRed_time_event_0);

					break;

				case PedestrianGreen :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(PedestrianGreen_time_event_0);

					break;

				case PedestrianRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(PedestrianRed_time_event_0);

					break;

				case StreetPrepare :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(StreetPrepare_time_event_0);

					break;

				default :
					break;
			}

			getInterfaceTrafficLightImpl().setVarRed(false);
			getInterfaceTrafficLightImpl().setVarGreen(false);
			getInterfaceTrafficLightImpl().setVarYellow(false);
			getInterfacePedestrianImpl().setVarRed(false);
			getInterfacePedestrianImpl().setVarGreen(false);

			getTimerService().setTimer(YellowOn_time_event_0, 500,
					cycleStartTime);
			getInterfaceTrafficLightImpl().setVarYellow(true);

			nextStateIndex = 0;
			stateVector[0] = State.YellowOn;

		} else {
			if (occuredEvents.contains(StreetRed_time_event_0)) {
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(StreetRed_time_event_0);

				getTimerService().setTimer(PedestrianGreen_time_event_0,
						(7 * 1000), cycleStartTime);
				getInterfacePedestrianImpl().setVarRed(false);
				getInterfacePedestrianImpl().setVarGreen(true);

				nextStateIndex = 0;
				stateVector[0] = State.PedestrianGreen;

			}

		}
	}
	private void reactPedestrianGreen() {
		if (occuredEvents.contains(getDefaultInterfaceImpl()
				.getEventKeypress2())) {
			//Handle exit of all possible states (of r1) at position 0...
			switch (stateVector[0]) {

				case StreetGreen :
					stateVector[0] = State.$NullState$;

					break;

				case WaitOn :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(WaitOn_time_event_0);

					getTimerService().resetTimer(PedWaiting_time_event_0);
					getInterfacePedestrianImpl().setVarRequest(false);

					break;

				case WaitOff :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(WaitOff_time_event_0);

					getTimerService().resetTimer(PedWaiting_time_event_0);
					getInterfacePedestrianImpl().setVarRequest(false);

					break;

				case StreetAttention :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(StreetAttention_time_event_0);

					break;

				case StreetRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(StreetRed_time_event_0);

					break;

				case PedestrianGreen :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(PedestrianGreen_time_event_0);

					break;

				case PedestrianRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(PedestrianRed_time_event_0);

					break;

				case StreetPrepare :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(StreetPrepare_time_event_0);

					break;

				default :
					break;
			}

			getInterfaceTrafficLightImpl().setVarRed(false);
			getInterfaceTrafficLightImpl().setVarGreen(false);
			getInterfaceTrafficLightImpl().setVarYellow(false);
			getInterfacePedestrianImpl().setVarRed(false);
			getInterfacePedestrianImpl().setVarGreen(false);

			getTimerService().setTimer(YellowOn_time_event_0, 500,
					cycleStartTime);
			getInterfaceTrafficLightImpl().setVarYellow(true);

			nextStateIndex = 0;
			stateVector[0] = State.YellowOn;

		} else {
			if (occuredEvents.contains(PedestrianGreen_time_event_0)) {
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(PedestrianGreen_time_event_0);

				getTimerService().setTimer(PedestrianRed_time_event_0,
						(5 * 1000), cycleStartTime);
				getInterfacePedestrianImpl().setVarRed(true);
				getInterfacePedestrianImpl().setVarGreen(false);

				nextStateIndex = 0;
				stateVector[0] = State.PedestrianRed;

			}

		}
	}
	private void reactPedestrianRed() {
		if (occuredEvents.contains(getDefaultInterfaceImpl()
				.getEventKeypress2())) {
			//Handle exit of all possible states (of r1) at position 0...
			switch (stateVector[0]) {

				case StreetGreen :
					stateVector[0] = State.$NullState$;

					break;

				case WaitOn :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(WaitOn_time_event_0);

					getTimerService().resetTimer(PedWaiting_time_event_0);
					getInterfacePedestrianImpl().setVarRequest(false);

					break;

				case WaitOff :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(WaitOff_time_event_0);

					getTimerService().resetTimer(PedWaiting_time_event_0);
					getInterfacePedestrianImpl().setVarRequest(false);

					break;

				case StreetAttention :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(StreetAttention_time_event_0);

					break;

				case StreetRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(StreetRed_time_event_0);

					break;

				case PedestrianGreen :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(PedestrianGreen_time_event_0);

					break;

				case PedestrianRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(PedestrianRed_time_event_0);

					break;

				case StreetPrepare :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(StreetPrepare_time_event_0);

					break;

				default :
					break;
			}

			getInterfaceTrafficLightImpl().setVarRed(false);
			getInterfaceTrafficLightImpl().setVarGreen(false);
			getInterfaceTrafficLightImpl().setVarYellow(false);
			getInterfacePedestrianImpl().setVarRed(false);
			getInterfacePedestrianImpl().setVarGreen(false);

			getTimerService().setTimer(YellowOn_time_event_0, 500,
					cycleStartTime);
			getInterfaceTrafficLightImpl().setVarYellow(true);

			nextStateIndex = 0;
			stateVector[0] = State.YellowOn;

		} else {
			if (occuredEvents.contains(PedestrianRed_time_event_0)) {
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(PedestrianRed_time_event_0);

				getTimerService().setTimer(StreetPrepare_time_event_0,
						(2 * 1000), cycleStartTime);
				getInterfaceTrafficLightImpl().setVarRed(true);
				getInterfaceTrafficLightImpl().setVarYellow(true);
				getInterfaceTrafficLightImpl().setVarGreen(false);

				nextStateIndex = 0;
				stateVector[0] = State.StreetPrepare;

			}

		}
	}
	private void reactStreetPrepare() {
		if (occuredEvents.contains(getDefaultInterfaceImpl()
				.getEventKeypress2())) {
			//Handle exit of all possible states (of r1) at position 0...
			switch (stateVector[0]) {

				case StreetGreen :
					stateVector[0] = State.$NullState$;

					break;

				case WaitOn :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(WaitOn_time_event_0);

					getTimerService().resetTimer(PedWaiting_time_event_0);
					getInterfacePedestrianImpl().setVarRequest(false);

					break;

				case WaitOff :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(WaitOff_time_event_0);

					getTimerService().resetTimer(PedWaiting_time_event_0);
					getInterfacePedestrianImpl().setVarRequest(false);

					break;

				case StreetAttention :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(StreetAttention_time_event_0);

					break;

				case StreetRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(StreetRed_time_event_0);

					break;

				case PedestrianGreen :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(PedestrianGreen_time_event_0);

					break;

				case PedestrianRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(PedestrianRed_time_event_0);

					break;

				case StreetPrepare :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(StreetPrepare_time_event_0);

					break;

				default :
					break;
			}

			getInterfaceTrafficLightImpl().setVarRed(false);
			getInterfaceTrafficLightImpl().setVarGreen(false);
			getInterfaceTrafficLightImpl().setVarYellow(false);
			getInterfacePedestrianImpl().setVarRed(false);
			getInterfacePedestrianImpl().setVarGreen(false);

			getTimerService().setTimer(YellowOn_time_event_0, 500,
					cycleStartTime);
			getInterfaceTrafficLightImpl().setVarYellow(true);

			nextStateIndex = 0;
			stateVector[0] = State.YellowOn;

		} else {
			if (occuredEvents.contains(StreetPrepare_time_event_0)) {
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(StreetPrepare_time_event_0);

				getInterfaceTrafficLightImpl().setVarRed(false);
				getInterfaceTrafficLightImpl().setVarYellow(false);
				getInterfaceTrafficLightImpl().setVarGreen(true);
				getInterfacePedestrianImpl().setVarRed(true);
				getInterfacePedestrianImpl().setVarGreen(false);
				getInterfacePedestrianImpl().setVarRequest(false);

				nextStateIndex = 0;
				stateVector[0] = State.StreetGreen;

			}

		}
	}
	private void reactOff() {
	}
	private void reactYellowOn() {
		if (occuredEvents.contains(getDefaultInterfaceImpl()
				.getEventKeypress2())) {
			//Handle exit of all possible states (of r1) at position 0...
			switch (stateVector[0]) {

				case YellowOn :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(YellowOn_time_event_0);

					break;

				case YellowOff :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(YellowOff_time_event_0);

					break;

				default :
					break;
			}

			getInterfaceTrafficLightImpl().setVarRed(false);
			getInterfaceTrafficLightImpl().setVarYellow(false);
			getInterfaceTrafficLightImpl().setVarGreen(true);
			getInterfacePedestrianImpl().setVarRed(true);
			getInterfacePedestrianImpl().setVarGreen(false);
			getInterfacePedestrianImpl().setVarRequest(false);

			nextStateIndex = 0;
			stateVector[0] = State.StreetGreen;

		} else {
			if (occuredEvents.contains(YellowOn_time_event_0)) {
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(YellowOn_time_event_0);

				getTimerService().setTimer(YellowOff_time_event_0, 500,
						cycleStartTime);
				getInterfaceTrafficLightImpl().setVarYellow(false);

				nextStateIndex = 0;
				stateVector[0] = State.YellowOff;

			}

		}
	}
	private void reactYellowOff() {
		if (occuredEvents.contains(getDefaultInterfaceImpl()
				.getEventKeypress2())) {
			//Handle exit of all possible states (of r1) at position 0...
			switch (stateVector[0]) {

				case YellowOn :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(YellowOn_time_event_0);

					break;

				case YellowOff :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(YellowOff_time_event_0);

					break;

				default :
					break;
			}

			getInterfaceTrafficLightImpl().setVarRed(false);
			getInterfaceTrafficLightImpl().setVarYellow(false);
			getInterfaceTrafficLightImpl().setVarGreen(true);
			getInterfacePedestrianImpl().setVarRed(true);
			getInterfacePedestrianImpl().setVarGreen(false);
			getInterfacePedestrianImpl().setVarRequest(false);

			nextStateIndex = 0;
			stateVector[0] = State.StreetGreen;

		} else {
			if (occuredEvents.contains(YellowOff_time_event_0)) {
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(YellowOff_time_event_0);

				getTimerService().setTimer(YellowOn_time_event_0, 500,
						cycleStartTime);
				getInterfaceTrafficLightImpl().setVarYellow(true);

				nextStateIndex = 0;
				stateVector[0] = State.YellowOn;

			}

		}
	}
	public void runCycle() {
		cycleStartTime = System.currentTimeMillis();
		outEvents.clear();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
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
					// $NullState$
			}
		}

		occuredEvents.clear();
	}
}
