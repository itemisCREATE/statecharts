package org.yakindu.sct.examples.trafficlight.cyclebased.trafficlightwaiting;

import org.yakindu.sct.examples.trafficlight.cyclebased.TimeEvent;
import org.yakindu.sct.examples.trafficlight.cyclebased.ITimerService;

public class TrafficlightwaitingStatemachine
		implements
			ITrafficlightwaitingStatemachine {

	private final TimeEvent pedWaiting_time_event_0 = new TimeEvent(false, 0);
	private final TimeEvent waitOn_time_event_0 = new TimeEvent(false, 1);
	private final TimeEvent waitOff_time_event_0 = new TimeEvent(false, 2);
	private final TimeEvent streetAttention_time_event_0 = new TimeEvent(false,
			3);
	private final TimeEvent streetRed_time_event_0 = new TimeEvent(false, 4);
	private final TimeEvent pedestrianGreen_time_event_0 = new TimeEvent(false,
			5);
	private final TimeEvent pedestrianRed_time_event_0 = new TimeEvent(false, 6);
	private final TimeEvent streetPrepare_time_event_0 = new TimeEvent(false, 7);
	private final TimeEvent yellowOn_time_event_0 = new TimeEvent(false, 8);
	private final TimeEvent yellowOff_time_event_0 = new TimeEvent(false, 9);

	private final boolean[] timeEvents = new boolean[10];

	private final class InterfaceTrafficLightImpl
			implements
				InterfaceTrafficLight {

		private boolean red;

		public boolean getRed() {
			return red;
		}

		public void setRed(boolean value) {
			red = value;
		}

		private boolean yellow;

		public boolean getYellow() {
			return yellow;
		}

		public void setYellow(boolean value) {
			yellow = value;
		}

		private boolean green;

		public boolean getGreen() {
			return green;
		}

		public void setGreen(boolean value) {
			green = value;
		}

	}

	private InterfaceTrafficLightImpl interfaceTrafficLight;

	private final class InterfacePedestrianImpl implements InterfacePedestrian {

		private boolean request;

		public boolean getRequest() {
			return request;
		}

		public void setRequest(boolean value) {
			request = value;
		}

		private boolean red;

		public boolean getRed() {
			return red;
		}

		public void setRed(boolean value) {
			red = value;
		}

		private boolean green;

		public boolean getGreen() {
			return green;
		}

		public void setGreen(boolean value) {
			green = value;
		}

	}

	private InterfacePedestrianImpl interfacePedestrian;

	private final class DefaultInterfaceImpl implements DefaultInterface {

		private boolean pedestrianRequest;

		public void raisePedestrianRequest() {
			pedestrianRequest = true;
		}

		private boolean onOff;

		public void raiseOnOff() {
			onOff = true;
		}

		public void clearEvents() {
			pedestrianRequest = false;
			onOff = false;
		}

	}

	private DefaultInterfaceImpl defaultInterface;

	public enum State {
		On, StreetGreen, PedWaiting, WaitOn, WaitOff, StreetAttention, StreetRed, PedestrianGreen, PedestrianRed, StreetPrepare, Off, YellowOn, YellowOff, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	private ITimerService timerService;

	private long cycleStartTime;

	public TrafficlightwaitingStatemachine() {

		interfaceTrafficLight = new InterfaceTrafficLightImpl();
		interfacePedestrian = new InterfacePedestrianImpl();
		defaultInterface = new DefaultInterfaceImpl();

		pedWaiting_time_event_0.setStatemachine(this);
		waitOn_time_event_0.setStatemachine(this);
		waitOff_time_event_0.setStatemachine(this);
		streetAttention_time_event_0.setStatemachine(this);
		streetRed_time_event_0.setStatemachine(this);
		pedestrianGreen_time_event_0.setStatemachine(this);
		pedestrianRed_time_event_0.setStatemachine(this);
		streetPrepare_time_event_0.setStatemachine(this);
		yellowOn_time_event_0.setStatemachine(this);
		yellowOff_time_event_0.setStatemachine(this);

	}

	public void init() {
		if (timerService == null) {
			throw new IllegalStateException("TimerService not set.");
		}
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();
	}

	protected void clearEvents() {
		defaultInterface.clearEvents();

		for (int i = 0; i < timeEvents.length; i++) {
			timeEvents[i] = false;
		}
	}

	protected void clearOutEvents() {
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
		return timerService;
	}

	public void onTimeEventRaised(TimeEvent timeEvent) {
		timeEvents[timeEvent.getIndex()] = true;
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

	public void raisePedestrianRequest() {
		defaultInterface.raisePedestrianRequest();
	}

	public void raiseOnOff() {
		defaultInterface.raiseOnOff();
	}

	public void enter() {
		if (timerService == null) {
			throw new IllegalStateException("TimerService not set.");
		}
		cycleStartTime = System.currentTimeMillis();

		// unknown function type org.yakindu.sct.model.sexec.impl.SequenceImpl@1b8b070c (name: entryAction) (comment: Entry action for statechart 'TrafficLightWaiting'.)();
		interfaceTrafficLight.setRed(false);
		interfaceTrafficLight.setYellow(false);
		interfaceTrafficLight.setGreen(true);
		interfacePedestrian.setRed(true);
		interfacePedestrian.setGreen(false);
		interfacePedestrian.setRequest(false);

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
				getTimerService().resetTimer(waitOn_time_event_0);

				getTimerService().resetTimer(pedWaiting_time_event_0);
				interfacePedestrian.setRequest(false);

				break;

			case WaitOff :
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(waitOff_time_event_0);

				getTimerService().resetTimer(pedWaiting_time_event_0);
				interfacePedestrian.setRequest(false);

				break;

			case StreetAttention :
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(streetAttention_time_event_0);

				break;

			case StreetRed :
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(streetRed_time_event_0);

				break;

			case PedestrianGreen :
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(pedestrianGreen_time_event_0);

				break;

			case PedestrianRed :
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(pedestrianRed_time_event_0);

				break;

			case StreetPrepare :
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(streetPrepare_time_event_0);

				break;

			case YellowOn :
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(yellowOn_time_event_0);

				break;

			case YellowOff :
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(yellowOff_time_event_0);

				break;

			default :
				break;
		}

		// unknown function type org.yakindu.sct.model.sexec.impl.SequenceImpl@5c482390 (name: exitAction) (comment: Exit action for state 'TrafficLightWaiting'.)();
	}

	private void reactOn() {
	}
	private void reactStreetGreen() {
		if (defaultInterface.onOff) {
			//Handle exit of all possible states (of r1) at position 0...
			switch (stateVector[0]) {

				case StreetGreen :
					stateVector[0] = State.$NullState$;

					break;

				case WaitOn :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(waitOn_time_event_0);

					getTimerService().resetTimer(pedWaiting_time_event_0);
					interfacePedestrian.setRequest(false);

					break;

				case WaitOff :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(waitOff_time_event_0);

					getTimerService().resetTimer(pedWaiting_time_event_0);
					interfacePedestrian.setRequest(false);

					break;

				case StreetAttention :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetAttention_time_event_0);

					break;

				case StreetRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetRed_time_event_0);

					break;

				case PedestrianGreen :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(pedestrianGreen_time_event_0);

					break;

				case PedestrianRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(pedestrianRed_time_event_0);

					break;

				case StreetPrepare :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetPrepare_time_event_0);

					break;

				default :
					break;
			}

			interfaceTrafficLight.setRed(false);
			interfaceTrafficLight.setGreen(false);
			interfaceTrafficLight.setYellow(false);
			interfacePedestrian.setRed(false);
			interfacePedestrian.setGreen(false);

			getTimerService().setTimer(yellowOn_time_event_0, 500,
					cycleStartTime);
			interfaceTrafficLight.setYellow(true);
			interfacePedestrian.setRequest(true);

			nextStateIndex = 0;
			stateVector[0] = State.YellowOn;

		} else {
			if (defaultInterface.pedestrianRequest) {
				stateVector[0] = State.$NullState$;

				getTimerService().setTimer(pedWaiting_time_event_0, (7 * 1000),
						cycleStartTime);

				getTimerService().setTimer(waitOn_time_event_0, 500,
						cycleStartTime);
				interfacePedestrian.setRequest(true);

				nextStateIndex = 0;
				stateVector[0] = State.WaitOn;

			}

		}

	}
	private void reactPedWaiting() {
	}
	private void reactWaitOn() {
		if (defaultInterface.onOff) {
			//Handle exit of all possible states (of r1) at position 0...
			switch (stateVector[0]) {

				case StreetGreen :
					stateVector[0] = State.$NullState$;

					break;

				case WaitOn :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(waitOn_time_event_0);

					getTimerService().resetTimer(pedWaiting_time_event_0);
					interfacePedestrian.setRequest(false);

					break;

				case WaitOff :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(waitOff_time_event_0);

					getTimerService().resetTimer(pedWaiting_time_event_0);
					interfacePedestrian.setRequest(false);

					break;

				case StreetAttention :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetAttention_time_event_0);

					break;

				case StreetRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetRed_time_event_0);

					break;

				case PedestrianGreen :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(pedestrianGreen_time_event_0);

					break;

				case PedestrianRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(pedestrianRed_time_event_0);

					break;

				case StreetPrepare :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetPrepare_time_event_0);

					break;

				default :
					break;
			}

			interfaceTrafficLight.setRed(false);
			interfaceTrafficLight.setGreen(false);
			interfaceTrafficLight.setYellow(false);
			interfacePedestrian.setRed(false);
			interfacePedestrian.setGreen(false);

			getTimerService().setTimer(yellowOn_time_event_0, 500,
					cycleStartTime);
			interfaceTrafficLight.setYellow(true);
			interfacePedestrian.setRequest(true);

			nextStateIndex = 0;
			stateVector[0] = State.YellowOn;

		} else {
			if (timeEvents[pedWaiting_time_event_0.getIndex()]) {
				//Handle exit of all possible states (of r1) at position 0...
				switch (stateVector[0]) {

					case WaitOn :
						stateVector[0] = State.$NullState$;
						getTimerService().resetTimer(waitOn_time_event_0);

						break;

					case WaitOff :
						stateVector[0] = State.$NullState$;
						getTimerService().resetTimer(waitOff_time_event_0);

						break;

					default :
						break;
				}

				getTimerService().resetTimer(pedWaiting_time_event_0);
				interfacePedestrian.setRequest(false);

				getTimerService().setTimer(streetAttention_time_event_0,
						(2 * 1000), cycleStartTime);
				interfaceTrafficLight.setRed(false);
				interfaceTrafficLight.setYellow(true);
				interfaceTrafficLight.setGreen(false);

				nextStateIndex = 0;
				stateVector[0] = State.StreetAttention;

			} else {
				if (timeEvents[waitOn_time_event_0.getIndex()]) {
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(waitOn_time_event_0);

					getTimerService().setTimer(waitOff_time_event_0, 500,
							cycleStartTime);
					interfacePedestrian.setRequest(false);

					nextStateIndex = 0;
					stateVector[0] = State.WaitOff;

				}

			}

		}

	}
	private void reactWaitOff() {
		if (defaultInterface.onOff) {
			//Handle exit of all possible states (of r1) at position 0...
			switch (stateVector[0]) {

				case StreetGreen :
					stateVector[0] = State.$NullState$;

					break;

				case WaitOn :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(waitOn_time_event_0);

					getTimerService().resetTimer(pedWaiting_time_event_0);
					interfacePedestrian.setRequest(false);

					break;

				case WaitOff :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(waitOff_time_event_0);

					getTimerService().resetTimer(pedWaiting_time_event_0);
					interfacePedestrian.setRequest(false);

					break;

				case StreetAttention :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetAttention_time_event_0);

					break;

				case StreetRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetRed_time_event_0);

					break;

				case PedestrianGreen :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(pedestrianGreen_time_event_0);

					break;

				case PedestrianRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(pedestrianRed_time_event_0);

					break;

				case StreetPrepare :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetPrepare_time_event_0);

					break;

				default :
					break;
			}

			interfaceTrafficLight.setRed(false);
			interfaceTrafficLight.setGreen(false);
			interfaceTrafficLight.setYellow(false);
			interfacePedestrian.setRed(false);
			interfacePedestrian.setGreen(false);

			getTimerService().setTimer(yellowOn_time_event_0, 500,
					cycleStartTime);
			interfaceTrafficLight.setYellow(true);
			interfacePedestrian.setRequest(true);

			nextStateIndex = 0;
			stateVector[0] = State.YellowOn;

		} else {
			if (timeEvents[pedWaiting_time_event_0.getIndex()]) {
				//Handle exit of all possible states (of r1) at position 0...
				switch (stateVector[0]) {

					case WaitOn :
						stateVector[0] = State.$NullState$;
						getTimerService().resetTimer(waitOn_time_event_0);

						break;

					case WaitOff :
						stateVector[0] = State.$NullState$;
						getTimerService().resetTimer(waitOff_time_event_0);

						break;

					default :
						break;
				}

				getTimerService().resetTimer(pedWaiting_time_event_0);
				interfacePedestrian.setRequest(false);

				getTimerService().setTimer(streetAttention_time_event_0,
						(2 * 1000), cycleStartTime);
				interfaceTrafficLight.setRed(false);
				interfaceTrafficLight.setYellow(true);
				interfaceTrafficLight.setGreen(false);

				nextStateIndex = 0;
				stateVector[0] = State.StreetAttention;

			} else {
				if (timeEvents[waitOff_time_event_0.getIndex()]) {
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(waitOff_time_event_0);

					getTimerService().setTimer(waitOn_time_event_0, 500,
							cycleStartTime);
					interfacePedestrian.setRequest(true);

					nextStateIndex = 0;
					stateVector[0] = State.WaitOn;

				}

			}

		}

	}
	private void reactStreetAttention() {
		if (defaultInterface.onOff) {
			//Handle exit of all possible states (of r1) at position 0...
			switch (stateVector[0]) {

				case StreetGreen :
					stateVector[0] = State.$NullState$;

					break;

				case WaitOn :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(waitOn_time_event_0);

					getTimerService().resetTimer(pedWaiting_time_event_0);
					interfacePedestrian.setRequest(false);

					break;

				case WaitOff :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(waitOff_time_event_0);

					getTimerService().resetTimer(pedWaiting_time_event_0);
					interfacePedestrian.setRequest(false);

					break;

				case StreetAttention :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetAttention_time_event_0);

					break;

				case StreetRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetRed_time_event_0);

					break;

				case PedestrianGreen :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(pedestrianGreen_time_event_0);

					break;

				case PedestrianRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(pedestrianRed_time_event_0);

					break;

				case StreetPrepare :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetPrepare_time_event_0);

					break;

				default :
					break;
			}

			interfaceTrafficLight.setRed(false);
			interfaceTrafficLight.setGreen(false);
			interfaceTrafficLight.setYellow(false);
			interfacePedestrian.setRed(false);
			interfacePedestrian.setGreen(false);

			getTimerService().setTimer(yellowOn_time_event_0, 500,
					cycleStartTime);
			interfaceTrafficLight.setYellow(true);
			interfacePedestrian.setRequest(true);

			nextStateIndex = 0;
			stateVector[0] = State.YellowOn;

		} else {
			if (timeEvents[streetAttention_time_event_0.getIndex()]) {
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(streetAttention_time_event_0);

				getTimerService().setTimer(streetRed_time_event_0, (2 * 1000),
						cycleStartTime);
				interfaceTrafficLight.setRed(true);
				interfaceTrafficLight.setYellow(false);
				interfaceTrafficLight.setGreen(false);

				nextStateIndex = 0;
				stateVector[0] = State.StreetRed;

			}

		}

	}
	private void reactStreetRed() {
		if (defaultInterface.onOff) {
			//Handle exit of all possible states (of r1) at position 0...
			switch (stateVector[0]) {

				case StreetGreen :
					stateVector[0] = State.$NullState$;

					break;

				case WaitOn :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(waitOn_time_event_0);

					getTimerService().resetTimer(pedWaiting_time_event_0);
					interfacePedestrian.setRequest(false);

					break;

				case WaitOff :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(waitOff_time_event_0);

					getTimerService().resetTimer(pedWaiting_time_event_0);
					interfacePedestrian.setRequest(false);

					break;

				case StreetAttention :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetAttention_time_event_0);

					break;

				case StreetRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetRed_time_event_0);

					break;

				case PedestrianGreen :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(pedestrianGreen_time_event_0);

					break;

				case PedestrianRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(pedestrianRed_time_event_0);

					break;

				case StreetPrepare :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetPrepare_time_event_0);

					break;

				default :
					break;
			}

			interfaceTrafficLight.setRed(false);
			interfaceTrafficLight.setGreen(false);
			interfaceTrafficLight.setYellow(false);
			interfacePedestrian.setRed(false);
			interfacePedestrian.setGreen(false);

			getTimerService().setTimer(yellowOn_time_event_0, 500,
					cycleStartTime);
			interfaceTrafficLight.setYellow(true);
			interfacePedestrian.setRequest(true);

			nextStateIndex = 0;
			stateVector[0] = State.YellowOn;

		} else {
			if (timeEvents[streetRed_time_event_0.getIndex()]) {
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(streetRed_time_event_0);

				getTimerService().setTimer(pedestrianGreen_time_event_0,
						(7 * 1000), cycleStartTime);
				interfacePedestrian.setRed(false);
				interfacePedestrian.setGreen(true);

				nextStateIndex = 0;
				stateVector[0] = State.PedestrianGreen;

			}

		}

	}
	private void reactPedestrianGreen() {
		if (defaultInterface.onOff) {
			//Handle exit of all possible states (of r1) at position 0...
			switch (stateVector[0]) {

				case StreetGreen :
					stateVector[0] = State.$NullState$;

					break;

				case WaitOn :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(waitOn_time_event_0);

					getTimerService().resetTimer(pedWaiting_time_event_0);
					interfacePedestrian.setRequest(false);

					break;

				case WaitOff :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(waitOff_time_event_0);

					getTimerService().resetTimer(pedWaiting_time_event_0);
					interfacePedestrian.setRequest(false);

					break;

				case StreetAttention :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetAttention_time_event_0);

					break;

				case StreetRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetRed_time_event_0);

					break;

				case PedestrianGreen :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(pedestrianGreen_time_event_0);

					break;

				case PedestrianRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(pedestrianRed_time_event_0);

					break;

				case StreetPrepare :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetPrepare_time_event_0);

					break;

				default :
					break;
			}

			interfaceTrafficLight.setRed(false);
			interfaceTrafficLight.setGreen(false);
			interfaceTrafficLight.setYellow(false);
			interfacePedestrian.setRed(false);
			interfacePedestrian.setGreen(false);

			getTimerService().setTimer(yellowOn_time_event_0, 500,
					cycleStartTime);
			interfaceTrafficLight.setYellow(true);
			interfacePedestrian.setRequest(true);

			nextStateIndex = 0;
			stateVector[0] = State.YellowOn;

		} else {
			if (timeEvents[pedestrianGreen_time_event_0.getIndex()]) {
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(pedestrianGreen_time_event_0);

				getTimerService().setTimer(pedestrianRed_time_event_0,
						(5 * 1000), cycleStartTime);
				interfacePedestrian.setRed(true);
				interfacePedestrian.setGreen(false);

				nextStateIndex = 0;
				stateVector[0] = State.PedestrianRed;

			}

		}

	}
	private void reactPedestrianRed() {
		if (defaultInterface.onOff) {
			//Handle exit of all possible states (of r1) at position 0...
			switch (stateVector[0]) {

				case StreetGreen :
					stateVector[0] = State.$NullState$;

					break;

				case WaitOn :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(waitOn_time_event_0);

					getTimerService().resetTimer(pedWaiting_time_event_0);
					interfacePedestrian.setRequest(false);

					break;

				case WaitOff :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(waitOff_time_event_0);

					getTimerService().resetTimer(pedWaiting_time_event_0);
					interfacePedestrian.setRequest(false);

					break;

				case StreetAttention :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetAttention_time_event_0);

					break;

				case StreetRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetRed_time_event_0);

					break;

				case PedestrianGreen :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(pedestrianGreen_time_event_0);

					break;

				case PedestrianRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(pedestrianRed_time_event_0);

					break;

				case StreetPrepare :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetPrepare_time_event_0);

					break;

				default :
					break;
			}

			interfaceTrafficLight.setRed(false);
			interfaceTrafficLight.setGreen(false);
			interfaceTrafficLight.setYellow(false);
			interfacePedestrian.setRed(false);
			interfacePedestrian.setGreen(false);

			getTimerService().setTimer(yellowOn_time_event_0, 500,
					cycleStartTime);
			interfaceTrafficLight.setYellow(true);
			interfacePedestrian.setRequest(true);

			nextStateIndex = 0;
			stateVector[0] = State.YellowOn;

		} else {
			if (timeEvents[pedestrianRed_time_event_0.getIndex()]) {
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(pedestrianRed_time_event_0);

				getTimerService().setTimer(streetPrepare_time_event_0,
						(2 * 1000), cycleStartTime);
				interfaceTrafficLight.setRed(true);
				interfaceTrafficLight.setYellow(true);
				interfaceTrafficLight.setGreen(false);

				nextStateIndex = 0;
				stateVector[0] = State.StreetPrepare;

			}

		}

	}
	private void reactStreetPrepare() {
		if (defaultInterface.onOff) {
			//Handle exit of all possible states (of r1) at position 0...
			switch (stateVector[0]) {

				case StreetGreen :
					stateVector[0] = State.$NullState$;

					break;

				case WaitOn :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(waitOn_time_event_0);

					getTimerService().resetTimer(pedWaiting_time_event_0);
					interfacePedestrian.setRequest(false);

					break;

				case WaitOff :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(waitOff_time_event_0);

					getTimerService().resetTimer(pedWaiting_time_event_0);
					interfacePedestrian.setRequest(false);

					break;

				case StreetAttention :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetAttention_time_event_0);

					break;

				case StreetRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetRed_time_event_0);

					break;

				case PedestrianGreen :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(pedestrianGreen_time_event_0);

					break;

				case PedestrianRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(pedestrianRed_time_event_0);

					break;

				case StreetPrepare :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetPrepare_time_event_0);

					break;

				default :
					break;
			}

			interfaceTrafficLight.setRed(false);
			interfaceTrafficLight.setGreen(false);
			interfaceTrafficLight.setYellow(false);
			interfacePedestrian.setRed(false);
			interfacePedestrian.setGreen(false);

			getTimerService().setTimer(yellowOn_time_event_0, 500,
					cycleStartTime);
			interfaceTrafficLight.setYellow(true);
			interfacePedestrian.setRequest(true);

			nextStateIndex = 0;
			stateVector[0] = State.YellowOn;

		} else {
			if (timeEvents[streetPrepare_time_event_0.getIndex()]) {
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(streetPrepare_time_event_0);

				interfaceTrafficLight.setRed(false);
				interfaceTrafficLight.setYellow(false);
				interfaceTrafficLight.setGreen(true);
				interfacePedestrian.setRed(true);
				interfacePedestrian.setGreen(false);
				interfacePedestrian.setRequest(false);

				nextStateIndex = 0;
				stateVector[0] = State.StreetGreen;

			}

		}

	}
	private void reactOff() {
	}
	private void reactYellowOn() {
		if (defaultInterface.onOff) {
			//Handle exit of all possible states (of r1) at position 0...
			switch (stateVector[0]) {

				case YellowOn :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(yellowOn_time_event_0);

					break;

				case YellowOff :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(yellowOff_time_event_0);

					break;

				default :
					break;
			}

			interfaceTrafficLight.setRed(false);
			interfaceTrafficLight.setYellow(false);
			interfaceTrafficLight.setGreen(true);
			interfacePedestrian.setRed(true);
			interfacePedestrian.setGreen(false);
			interfacePedestrian.setRequest(false);

			nextStateIndex = 0;
			stateVector[0] = State.StreetGreen;

		} else {
			if (timeEvents[yellowOn_time_event_0.getIndex()]) {
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(yellowOn_time_event_0);

				getTimerService().setTimer(yellowOff_time_event_0, 500,
						cycleStartTime);
				interfaceTrafficLight.setYellow(false);
				interfacePedestrian.setRequest(false);

				nextStateIndex = 0;
				stateVector[0] = State.YellowOff;

			}

		}

	}
	private void reactYellowOff() {
		if (defaultInterface.onOff) {
			//Handle exit of all possible states (of r1) at position 0...
			switch (stateVector[0]) {

				case YellowOn :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(yellowOn_time_event_0);

					break;

				case YellowOff :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(yellowOff_time_event_0);

					break;

				default :
					break;
			}

			interfaceTrafficLight.setRed(false);
			interfaceTrafficLight.setYellow(false);
			interfaceTrafficLight.setGreen(true);
			interfacePedestrian.setRed(true);
			interfacePedestrian.setGreen(false);
			interfacePedestrian.setRequest(false);

			nextStateIndex = 0;
			stateVector[0] = State.StreetGreen;

		} else {
			if (timeEvents[yellowOff_time_event_0.getIndex()]) {
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(yellowOff_time_event_0);

				getTimerService().setTimer(yellowOn_time_event_0, 500,
						cycleStartTime);
				interfaceTrafficLight.setYellow(true);
				interfacePedestrian.setRequest(true);

				nextStateIndex = 0;
				stateVector[0] = State.YellowOn;

			}

		}

	}

	public void runCycle() {

		cycleStartTime = System.currentTimeMillis();

		clearOutEvents();

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

		clearEvents();
	}
}
