package org.yakindu.sct.examples.trafficlight.cyclebased.trafficlightwaiting;

import org.yakindu.sct.examples.trafficlight.cyclebased.TimeEvent;
import org.yakindu.sct.examples.trafficlight.cyclebased.ITimerService;

public class TrafficLightWaitingStatemachine
		implements
			ITrafficLightWaitingStatemachine {

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

	private final class SCITrafficLightImpl implements SCITrafficLight {

		private boolean red;

		public boolean getRed() {
			return red;
		}

		public void setRed(boolean value) {
			this.red = value;
		}

		private boolean yellow;

		public boolean getYellow() {
			return yellow;
		}

		public void setYellow(boolean value) {
			this.yellow = value;
		}

		private boolean green;

		public boolean getGreen() {
			return green;
		}

		public void setGreen(boolean value) {
			this.green = value;
		}

	}

	private SCITrafficLightImpl sCITrafficLight;

	private final class SCIPedestrianImpl implements SCIPedestrian {

		private boolean request;

		public boolean getRequest() {
			return request;
		}

		public void setRequest(boolean value) {
			this.request = value;
		}

		private boolean red;

		public boolean getRed() {
			return red;
		}

		public void setRed(boolean value) {
			this.red = value;
		}

		private boolean green;

		public boolean getGreen() {
			return green;
		}

		public void setGreen(boolean value) {
			this.green = value;
		}

	}

	private SCIPedestrianImpl sCIPedestrian;

	private final class SCIDefaultImpl implements SCIDefault {

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

	private SCIDefaultImpl sCIDefault;

	public enum State {
		Main_region_on, Main_region_on_r1_StreetGreen, Main_region_on_r1_PedWaiting, Main_region_on_r1_PedWaiting_r1_waitOn, Main_region_on_r1_PedWaiting_r1_waitOff, Main_region_on_r1_StreetAttention, Main_region_on_r1_StreetRed, Main_region_on_r1_PedestrianGreen, Main_region_on_r1_PedestrianRed, Main_region_on_r1_StreetPrepare, Main_region_off, Main_region_off_r1_YellowOn, Main_region_off_r1_YellowOff, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	private ITimerService timerService;

	private long cycleStartTime;

	public TrafficLightWaitingStatemachine() {

		sCITrafficLight = new SCITrafficLightImpl();
		sCIPedestrian = new SCIPedestrianImpl();
		sCIDefault = new SCIDefaultImpl();

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
		sCIDefault.clearEvents();

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

	public SCITrafficLight getSCITrafficLight() {
		return sCITrafficLight;
	}
	public SCIPedestrian getSCIPedestrian() {
		return sCIPedestrian;
	}
	public SCIDefault getSCIDefault() {
		return sCIDefault;
	}

	public void raisePedestrianRequest() {
		sCIDefault.raisePedestrianRequest();
	}

	public void raiseOnOff() {
		sCIDefault.raiseOnOff();
	}

	public void enter() {
		if (timerService == null) {
			throw new IllegalStateException("TimerService not set.");
		}
		cycleStartTime = System.currentTimeMillis();
		entryActionTrafficLightWaiting();
		sCITrafficLight.setRed(false);
		sCITrafficLight.setYellow(false);
		sCITrafficLight.setGreen(true);
		sCIPedestrian.setRed(true);
		sCIPedestrian.setGreen(false);
		sCIPedestrian.setRequest(false);

		nextStateIndex = 0;
		stateVector[0] = State.Main_region_on_r1_StreetGreen;

	}

	public void exit() {
		//Handle exit of all possible states (of main region) at position 0...
		switch (stateVector[0]) {

			case Main_region_on_r1_StreetGreen :
				stateVector[0] = State.$NullState$;

				break;

			case Main_region_on_r1_PedWaiting_r1_waitOn :
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(waitOn_time_event_0);

				getTimerService().resetTimer(pedWaiting_time_event_0);
				sCIPedestrian.setRequest(false);

				break;

			case Main_region_on_r1_PedWaiting_r1_waitOff :
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(waitOff_time_event_0);

				getTimerService().resetTimer(pedWaiting_time_event_0);
				sCIPedestrian.setRequest(false);

				break;

			case Main_region_on_r1_StreetAttention :
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(streetAttention_time_event_0);

				break;

			case Main_region_on_r1_StreetRed :
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(streetRed_time_event_0);

				break;

			case Main_region_on_r1_PedestrianGreen :
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(pedestrianGreen_time_event_0);

				break;

			case Main_region_on_r1_PedestrianRed :
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(pedestrianRed_time_event_0);

				break;

			case Main_region_on_r1_StreetPrepare :
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(streetPrepare_time_event_0);

				break;

			case Main_region_off_r1_YellowOn :
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(yellowOn_time_event_0);

				break;

			case Main_region_off_r1_YellowOff :
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(yellowOff_time_event_0);

				break;

			default :
				break;
		}

		exitActionTrafficLightWaiting();
	}

	private void entryActionTrafficLightWaiting() {

	}

	private void exitActionTrafficLightWaiting() {

	}

	private void reactMain_region_on() {
	}
	private void reactMain_region_on_r1_StreetGreen() {
		if (sCIDefault.onOff) {
			//Handle exit of all possible states (of r1) at position 0...
			switch (stateVector[0]) {

				case Main_region_on_r1_StreetGreen :
					stateVector[0] = State.$NullState$;

					break;

				case Main_region_on_r1_PedWaiting_r1_waitOn :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(waitOn_time_event_0);

					getTimerService().resetTimer(pedWaiting_time_event_0);
					sCIPedestrian.setRequest(false);

					break;

				case Main_region_on_r1_PedWaiting_r1_waitOff :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(waitOff_time_event_0);

					getTimerService().resetTimer(pedWaiting_time_event_0);
					sCIPedestrian.setRequest(false);

					break;

				case Main_region_on_r1_StreetAttention :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetAttention_time_event_0);

					break;

				case Main_region_on_r1_StreetRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetRed_time_event_0);

					break;

				case Main_region_on_r1_PedestrianGreen :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(pedestrianGreen_time_event_0);

					break;

				case Main_region_on_r1_PedestrianRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(pedestrianRed_time_event_0);

					break;

				case Main_region_on_r1_StreetPrepare :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetPrepare_time_event_0);

					break;

				default :
					break;
			}

			sCITrafficLight.setRed(false);
			sCITrafficLight.setGreen(false);
			sCITrafficLight.setYellow(false);
			sCIPedestrian.setRed(false);
			sCIPedestrian.setGreen(false);

			getTimerService().setTimer(yellowOn_time_event_0, 500,
					cycleStartTime);
			sCITrafficLight.setYellow(true);
			sCIPedestrian.setRequest(true);

			nextStateIndex = 0;
			stateVector[0] = State.Main_region_off_r1_YellowOn;

		} else {
			if (sCIDefault.pedestrianRequest) {
				stateVector[0] = State.$NullState$;

				getTimerService().setTimer(pedWaiting_time_event_0, (7 * 1000),
						cycleStartTime);

				getTimerService().setTimer(waitOn_time_event_0, 500,
						cycleStartTime);
				sCIPedestrian.setRequest(true);

				nextStateIndex = 0;
				stateVector[0] = State.Main_region_on_r1_PedWaiting_r1_waitOn;

			}

		}

	}
	private void reactMain_region_on_r1_PedWaiting() {
	}
	private void reactMain_region_on_r1_PedWaiting_r1_waitOn() {
		if (sCIDefault.onOff) {
			//Handle exit of all possible states (of r1) at position 0...
			switch (stateVector[0]) {

				case Main_region_on_r1_StreetGreen :
					stateVector[0] = State.$NullState$;

					break;

				case Main_region_on_r1_PedWaiting_r1_waitOn :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(waitOn_time_event_0);

					getTimerService().resetTimer(pedWaiting_time_event_0);
					sCIPedestrian.setRequest(false);

					break;

				case Main_region_on_r1_PedWaiting_r1_waitOff :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(waitOff_time_event_0);

					getTimerService().resetTimer(pedWaiting_time_event_0);
					sCIPedestrian.setRequest(false);

					break;

				case Main_region_on_r1_StreetAttention :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetAttention_time_event_0);

					break;

				case Main_region_on_r1_StreetRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetRed_time_event_0);

					break;

				case Main_region_on_r1_PedestrianGreen :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(pedestrianGreen_time_event_0);

					break;

				case Main_region_on_r1_PedestrianRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(pedestrianRed_time_event_0);

					break;

				case Main_region_on_r1_StreetPrepare :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetPrepare_time_event_0);

					break;

				default :
					break;
			}

			sCITrafficLight.setRed(false);
			sCITrafficLight.setGreen(false);
			sCITrafficLight.setYellow(false);
			sCIPedestrian.setRed(false);
			sCIPedestrian.setGreen(false);

			getTimerService().setTimer(yellowOn_time_event_0, 500,
					cycleStartTime);
			sCITrafficLight.setYellow(true);
			sCIPedestrian.setRequest(true);

			nextStateIndex = 0;
			stateVector[0] = State.Main_region_off_r1_YellowOn;

		} else {
			if (timeEvents[pedWaiting_time_event_0.getIndex()]) {
				//Handle exit of all possible states (of r1) at position 0...
				switch (stateVector[0]) {

					case Main_region_on_r1_PedWaiting_r1_waitOn :
						stateVector[0] = State.$NullState$;
						getTimerService().resetTimer(waitOn_time_event_0);

						break;

					case Main_region_on_r1_PedWaiting_r1_waitOff :
						stateVector[0] = State.$NullState$;
						getTimerService().resetTimer(waitOff_time_event_0);

						break;

					default :
						break;
				}

				getTimerService().resetTimer(pedWaiting_time_event_0);
				sCIPedestrian.setRequest(false);

				getTimerService().setTimer(streetAttention_time_event_0,
						(2 * 1000), cycleStartTime);
				sCITrafficLight.setRed(false);
				sCITrafficLight.setYellow(true);
				sCITrafficLight.setGreen(false);

				nextStateIndex = 0;
				stateVector[0] = State.Main_region_on_r1_StreetAttention;

			} else {
				if (timeEvents[waitOn_time_event_0.getIndex()]) {
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(waitOn_time_event_0);

					getTimerService().setTimer(waitOff_time_event_0, 500,
							cycleStartTime);
					sCIPedestrian.setRequest(false);

					nextStateIndex = 0;
					stateVector[0] = State.Main_region_on_r1_PedWaiting_r1_waitOff;

				}

			}

		}

	}
	private void reactMain_region_on_r1_PedWaiting_r1_waitOff() {
		if (sCIDefault.onOff) {
			//Handle exit of all possible states (of r1) at position 0...
			switch (stateVector[0]) {

				case Main_region_on_r1_StreetGreen :
					stateVector[0] = State.$NullState$;

					break;

				case Main_region_on_r1_PedWaiting_r1_waitOn :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(waitOn_time_event_0);

					getTimerService().resetTimer(pedWaiting_time_event_0);
					sCIPedestrian.setRequest(false);

					break;

				case Main_region_on_r1_PedWaiting_r1_waitOff :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(waitOff_time_event_0);

					getTimerService().resetTimer(pedWaiting_time_event_0);
					sCIPedestrian.setRequest(false);

					break;

				case Main_region_on_r1_StreetAttention :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetAttention_time_event_0);

					break;

				case Main_region_on_r1_StreetRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetRed_time_event_0);

					break;

				case Main_region_on_r1_PedestrianGreen :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(pedestrianGreen_time_event_0);

					break;

				case Main_region_on_r1_PedestrianRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(pedestrianRed_time_event_0);

					break;

				case Main_region_on_r1_StreetPrepare :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetPrepare_time_event_0);

					break;

				default :
					break;
			}

			sCITrafficLight.setRed(false);
			sCITrafficLight.setGreen(false);
			sCITrafficLight.setYellow(false);
			sCIPedestrian.setRed(false);
			sCIPedestrian.setGreen(false);

			getTimerService().setTimer(yellowOn_time_event_0, 500,
					cycleStartTime);
			sCITrafficLight.setYellow(true);
			sCIPedestrian.setRequest(true);

			nextStateIndex = 0;
			stateVector[0] = State.Main_region_off_r1_YellowOn;

		} else {
			if (timeEvents[pedWaiting_time_event_0.getIndex()]) {
				//Handle exit of all possible states (of r1) at position 0...
				switch (stateVector[0]) {

					case Main_region_on_r1_PedWaiting_r1_waitOn :
						stateVector[0] = State.$NullState$;
						getTimerService().resetTimer(waitOn_time_event_0);

						break;

					case Main_region_on_r1_PedWaiting_r1_waitOff :
						stateVector[0] = State.$NullState$;
						getTimerService().resetTimer(waitOff_time_event_0);

						break;

					default :
						break;
				}

				getTimerService().resetTimer(pedWaiting_time_event_0);
				sCIPedestrian.setRequest(false);

				getTimerService().setTimer(streetAttention_time_event_0,
						(2 * 1000), cycleStartTime);
				sCITrafficLight.setRed(false);
				sCITrafficLight.setYellow(true);
				sCITrafficLight.setGreen(false);

				nextStateIndex = 0;
				stateVector[0] = State.Main_region_on_r1_StreetAttention;

			} else {
				if (timeEvents[waitOff_time_event_0.getIndex()]) {
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(waitOff_time_event_0);

					getTimerService().setTimer(waitOn_time_event_0, 500,
							cycleStartTime);
					sCIPedestrian.setRequest(true);

					nextStateIndex = 0;
					stateVector[0] = State.Main_region_on_r1_PedWaiting_r1_waitOn;

				}

			}

		}

	}
	private void reactMain_region_on_r1_StreetAttention() {
		if (sCIDefault.onOff) {
			//Handle exit of all possible states (of r1) at position 0...
			switch (stateVector[0]) {

				case Main_region_on_r1_StreetGreen :
					stateVector[0] = State.$NullState$;

					break;

				case Main_region_on_r1_PedWaiting_r1_waitOn :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(waitOn_time_event_0);

					getTimerService().resetTimer(pedWaiting_time_event_0);
					sCIPedestrian.setRequest(false);

					break;

				case Main_region_on_r1_PedWaiting_r1_waitOff :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(waitOff_time_event_0);

					getTimerService().resetTimer(pedWaiting_time_event_0);
					sCIPedestrian.setRequest(false);

					break;

				case Main_region_on_r1_StreetAttention :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetAttention_time_event_0);

					break;

				case Main_region_on_r1_StreetRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetRed_time_event_0);

					break;

				case Main_region_on_r1_PedestrianGreen :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(pedestrianGreen_time_event_0);

					break;

				case Main_region_on_r1_PedestrianRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(pedestrianRed_time_event_0);

					break;

				case Main_region_on_r1_StreetPrepare :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetPrepare_time_event_0);

					break;

				default :
					break;
			}

			sCITrafficLight.setRed(false);
			sCITrafficLight.setGreen(false);
			sCITrafficLight.setYellow(false);
			sCIPedestrian.setRed(false);
			sCIPedestrian.setGreen(false);

			getTimerService().setTimer(yellowOn_time_event_0, 500,
					cycleStartTime);
			sCITrafficLight.setYellow(true);
			sCIPedestrian.setRequest(true);

			nextStateIndex = 0;
			stateVector[0] = State.Main_region_off_r1_YellowOn;

		} else {
			if (timeEvents[streetAttention_time_event_0.getIndex()]) {
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(streetAttention_time_event_0);

				getTimerService().setTimer(streetRed_time_event_0, (2 * 1000),
						cycleStartTime);
				sCITrafficLight.setRed(true);
				sCITrafficLight.setYellow(false);
				sCITrafficLight.setGreen(false);

				nextStateIndex = 0;
				stateVector[0] = State.Main_region_on_r1_StreetRed;

			}

		}

	}
	private void reactMain_region_on_r1_StreetRed() {
		if (sCIDefault.onOff) {
			//Handle exit of all possible states (of r1) at position 0...
			switch (stateVector[0]) {

				case Main_region_on_r1_StreetGreen :
					stateVector[0] = State.$NullState$;

					break;

				case Main_region_on_r1_PedWaiting_r1_waitOn :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(waitOn_time_event_0);

					getTimerService().resetTimer(pedWaiting_time_event_0);
					sCIPedestrian.setRequest(false);

					break;

				case Main_region_on_r1_PedWaiting_r1_waitOff :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(waitOff_time_event_0);

					getTimerService().resetTimer(pedWaiting_time_event_0);
					sCIPedestrian.setRequest(false);

					break;

				case Main_region_on_r1_StreetAttention :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetAttention_time_event_0);

					break;

				case Main_region_on_r1_StreetRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetRed_time_event_0);

					break;

				case Main_region_on_r1_PedestrianGreen :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(pedestrianGreen_time_event_0);

					break;

				case Main_region_on_r1_PedestrianRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(pedestrianRed_time_event_0);

					break;

				case Main_region_on_r1_StreetPrepare :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetPrepare_time_event_0);

					break;

				default :
					break;
			}

			sCITrafficLight.setRed(false);
			sCITrafficLight.setGreen(false);
			sCITrafficLight.setYellow(false);
			sCIPedestrian.setRed(false);
			sCIPedestrian.setGreen(false);

			getTimerService().setTimer(yellowOn_time_event_0, 500,
					cycleStartTime);
			sCITrafficLight.setYellow(true);
			sCIPedestrian.setRequest(true);

			nextStateIndex = 0;
			stateVector[0] = State.Main_region_off_r1_YellowOn;

		} else {
			if (timeEvents[streetRed_time_event_0.getIndex()]) {
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(streetRed_time_event_0);

				getTimerService().setTimer(pedestrianGreen_time_event_0,
						(7 * 1000), cycleStartTime);
				sCIPedestrian.setRed(false);
				sCIPedestrian.setGreen(true);

				nextStateIndex = 0;
				stateVector[0] = State.Main_region_on_r1_PedestrianGreen;

			}

		}

	}
	private void reactMain_region_on_r1_PedestrianGreen() {
		if (sCIDefault.onOff) {
			//Handle exit of all possible states (of r1) at position 0...
			switch (stateVector[0]) {

				case Main_region_on_r1_StreetGreen :
					stateVector[0] = State.$NullState$;

					break;

				case Main_region_on_r1_PedWaiting_r1_waitOn :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(waitOn_time_event_0);

					getTimerService().resetTimer(pedWaiting_time_event_0);
					sCIPedestrian.setRequest(false);

					break;

				case Main_region_on_r1_PedWaiting_r1_waitOff :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(waitOff_time_event_0);

					getTimerService().resetTimer(pedWaiting_time_event_0);
					sCIPedestrian.setRequest(false);

					break;

				case Main_region_on_r1_StreetAttention :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetAttention_time_event_0);

					break;

				case Main_region_on_r1_StreetRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetRed_time_event_0);

					break;

				case Main_region_on_r1_PedestrianGreen :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(pedestrianGreen_time_event_0);

					break;

				case Main_region_on_r1_PedestrianRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(pedestrianRed_time_event_0);

					break;

				case Main_region_on_r1_StreetPrepare :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetPrepare_time_event_0);

					break;

				default :
					break;
			}

			sCITrafficLight.setRed(false);
			sCITrafficLight.setGreen(false);
			sCITrafficLight.setYellow(false);
			sCIPedestrian.setRed(false);
			sCIPedestrian.setGreen(false);

			getTimerService().setTimer(yellowOn_time_event_0, 500,
					cycleStartTime);
			sCITrafficLight.setYellow(true);
			sCIPedestrian.setRequest(true);

			nextStateIndex = 0;
			stateVector[0] = State.Main_region_off_r1_YellowOn;

		} else {
			if (timeEvents[pedestrianGreen_time_event_0.getIndex()]) {
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(pedestrianGreen_time_event_0);

				getTimerService().setTimer(pedestrianRed_time_event_0,
						(5 * 1000), cycleStartTime);
				sCIPedestrian.setRed(true);
				sCIPedestrian.setGreen(false);

				nextStateIndex = 0;
				stateVector[0] = State.Main_region_on_r1_PedestrianRed;

			}

		}

	}
	private void reactMain_region_on_r1_PedestrianRed() {
		if (sCIDefault.onOff) {
			//Handle exit of all possible states (of r1) at position 0...
			switch (stateVector[0]) {

				case Main_region_on_r1_StreetGreen :
					stateVector[0] = State.$NullState$;

					break;

				case Main_region_on_r1_PedWaiting_r1_waitOn :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(waitOn_time_event_0);

					getTimerService().resetTimer(pedWaiting_time_event_0);
					sCIPedestrian.setRequest(false);

					break;

				case Main_region_on_r1_PedWaiting_r1_waitOff :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(waitOff_time_event_0);

					getTimerService().resetTimer(pedWaiting_time_event_0);
					sCIPedestrian.setRequest(false);

					break;

				case Main_region_on_r1_StreetAttention :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetAttention_time_event_0);

					break;

				case Main_region_on_r1_StreetRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetRed_time_event_0);

					break;

				case Main_region_on_r1_PedestrianGreen :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(pedestrianGreen_time_event_0);

					break;

				case Main_region_on_r1_PedestrianRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(pedestrianRed_time_event_0);

					break;

				case Main_region_on_r1_StreetPrepare :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetPrepare_time_event_0);

					break;

				default :
					break;
			}

			sCITrafficLight.setRed(false);
			sCITrafficLight.setGreen(false);
			sCITrafficLight.setYellow(false);
			sCIPedestrian.setRed(false);
			sCIPedestrian.setGreen(false);

			getTimerService().setTimer(yellowOn_time_event_0, 500,
					cycleStartTime);
			sCITrafficLight.setYellow(true);
			sCIPedestrian.setRequest(true);

			nextStateIndex = 0;
			stateVector[0] = State.Main_region_off_r1_YellowOn;

		} else {
			if (timeEvents[pedestrianRed_time_event_0.getIndex()]) {
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(pedestrianRed_time_event_0);

				getTimerService().setTimer(streetPrepare_time_event_0,
						(2 * 1000), cycleStartTime);
				sCITrafficLight.setRed(true);
				sCITrafficLight.setYellow(true);
				sCITrafficLight.setGreen(false);

				nextStateIndex = 0;
				stateVector[0] = State.Main_region_on_r1_StreetPrepare;

			}

		}

	}
	private void reactMain_region_on_r1_StreetPrepare() {
		if (sCIDefault.onOff) {
			//Handle exit of all possible states (of r1) at position 0...
			switch (stateVector[0]) {

				case Main_region_on_r1_StreetGreen :
					stateVector[0] = State.$NullState$;

					break;

				case Main_region_on_r1_PedWaiting_r1_waitOn :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(waitOn_time_event_0);

					getTimerService().resetTimer(pedWaiting_time_event_0);
					sCIPedestrian.setRequest(false);

					break;

				case Main_region_on_r1_PedWaiting_r1_waitOff :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(waitOff_time_event_0);

					getTimerService().resetTimer(pedWaiting_time_event_0);
					sCIPedestrian.setRequest(false);

					break;

				case Main_region_on_r1_StreetAttention :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetAttention_time_event_0);

					break;

				case Main_region_on_r1_StreetRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetRed_time_event_0);

					break;

				case Main_region_on_r1_PedestrianGreen :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(pedestrianGreen_time_event_0);

					break;

				case Main_region_on_r1_PedestrianRed :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(pedestrianRed_time_event_0);

					break;

				case Main_region_on_r1_StreetPrepare :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(streetPrepare_time_event_0);

					break;

				default :
					break;
			}

			sCITrafficLight.setRed(false);
			sCITrafficLight.setGreen(false);
			sCITrafficLight.setYellow(false);
			sCIPedestrian.setRed(false);
			sCIPedestrian.setGreen(false);

			getTimerService().setTimer(yellowOn_time_event_0, 500,
					cycleStartTime);
			sCITrafficLight.setYellow(true);
			sCIPedestrian.setRequest(true);

			nextStateIndex = 0;
			stateVector[0] = State.Main_region_off_r1_YellowOn;

		} else {
			if (timeEvents[streetPrepare_time_event_0.getIndex()]) {
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(streetPrepare_time_event_0);

				sCITrafficLight.setRed(false);
				sCITrafficLight.setYellow(false);
				sCITrafficLight.setGreen(true);
				sCIPedestrian.setRed(true);
				sCIPedestrian.setGreen(false);
				sCIPedestrian.setRequest(false);

				nextStateIndex = 0;
				stateVector[0] = State.Main_region_on_r1_StreetGreen;

			}

		}

	}
	private void reactMain_region_off() {
	}
	private void reactMain_region_off_r1_YellowOn() {
		if (sCIDefault.onOff) {
			//Handle exit of all possible states (of r1) at position 0...
			switch (stateVector[0]) {

				case Main_region_off_r1_YellowOn :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(yellowOn_time_event_0);

					break;

				case Main_region_off_r1_YellowOff :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(yellowOff_time_event_0);

					break;

				default :
					break;
			}

			sCITrafficLight.setRed(false);
			sCITrafficLight.setYellow(false);
			sCITrafficLight.setGreen(true);
			sCIPedestrian.setRed(true);
			sCIPedestrian.setGreen(false);
			sCIPedestrian.setRequest(false);

			nextStateIndex = 0;
			stateVector[0] = State.Main_region_on_r1_StreetGreen;

		} else {
			if (timeEvents[yellowOn_time_event_0.getIndex()]) {
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(yellowOn_time_event_0);

				getTimerService().setTimer(yellowOff_time_event_0, 500,
						cycleStartTime);
				sCITrafficLight.setYellow(false);
				sCIPedestrian.setRequest(false);

				nextStateIndex = 0;
				stateVector[0] = State.Main_region_off_r1_YellowOff;

			}

		}

	}
	private void reactMain_region_off_r1_YellowOff() {
		if (sCIDefault.onOff) {
			//Handle exit of all possible states (of r1) at position 0...
			switch (stateVector[0]) {

				case Main_region_off_r1_YellowOn :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(yellowOn_time_event_0);

					break;

				case Main_region_off_r1_YellowOff :
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(yellowOff_time_event_0);

					break;

				default :
					break;
			}

			sCITrafficLight.setRed(false);
			sCITrafficLight.setYellow(false);
			sCITrafficLight.setGreen(true);
			sCIPedestrian.setRed(true);
			sCIPedestrian.setGreen(false);
			sCIPedestrian.setRequest(false);

			nextStateIndex = 0;
			stateVector[0] = State.Main_region_on_r1_StreetGreen;

		} else {
			if (timeEvents[yellowOff_time_event_0.getIndex()]) {
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(yellowOff_time_event_0);

				getTimerService().setTimer(yellowOn_time_event_0, 500,
						cycleStartTime);
				sCITrafficLight.setYellow(true);
				sCIPedestrian.setRequest(true);

				nextStateIndex = 0;
				stateVector[0] = State.Main_region_off_r1_YellowOn;

			}

		}

	}

	public void runCycle() {

		cycleStartTime = System.currentTimeMillis();

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case Main_region_on :
					reactMain_region_on();
					break;
				case Main_region_on_r1_StreetGreen :
					reactMain_region_on_r1_StreetGreen();
					break;
				case Main_region_on_r1_PedWaiting :
					reactMain_region_on_r1_PedWaiting();
					break;
				case Main_region_on_r1_PedWaiting_r1_waitOn :
					reactMain_region_on_r1_PedWaiting_r1_waitOn();
					break;
				case Main_region_on_r1_PedWaiting_r1_waitOff :
					reactMain_region_on_r1_PedWaiting_r1_waitOff();
					break;
				case Main_region_on_r1_StreetAttention :
					reactMain_region_on_r1_StreetAttention();
					break;
				case Main_region_on_r1_StreetRed :
					reactMain_region_on_r1_StreetRed();
					break;
				case Main_region_on_r1_PedestrianGreen :
					reactMain_region_on_r1_PedestrianGreen();
					break;
				case Main_region_on_r1_PedestrianRed :
					reactMain_region_on_r1_PedestrianRed();
					break;
				case Main_region_on_r1_StreetPrepare :
					reactMain_region_on_r1_StreetPrepare();
					break;
				case Main_region_off :
					reactMain_region_off();
					break;
				case Main_region_off_r1_YellowOn :
					reactMain_region_off_r1_YellowOn();
					break;
				case Main_region_off_r1_YellowOff :
					reactMain_region_off_r1_YellowOff();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
