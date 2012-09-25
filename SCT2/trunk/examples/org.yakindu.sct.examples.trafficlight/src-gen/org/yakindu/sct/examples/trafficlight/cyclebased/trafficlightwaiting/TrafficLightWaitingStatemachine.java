package org.yakindu.sct.examples.trafficlight.cyclebased.trafficlightwaiting;

import org.yakindu.sct.examples.trafficlight.cyclebased.TimeEvent;
import org.yakindu.sct.examples.trafficlight.cyclebased.ITimerService;

public class TrafficLightWaitingStatemachine
		implements
			ITrafficLightWaitingStatemachine {

	private final TimeEvent trafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0 = new TimeEvent(
			false, 0);
	private final TimeEvent trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn_time_event_0 = new TimeEvent(
			false, 1);
	private final TimeEvent trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff_time_event_0 = new TimeEvent(
			false, 2);
	private final TimeEvent trafficLightWaiting_main_region_on_r1_StreetAttention_time_event_0 = new TimeEvent(
			false, 3);
	private final TimeEvent trafficLightWaiting_main_region_on_r1_StreetRed_time_event_0 = new TimeEvent(
			false, 4);
	private final TimeEvent trafficLightWaiting_main_region_on_r1_PedestrianGreen_time_event_0 = new TimeEvent(
			false, 5);
	private final TimeEvent trafficLightWaiting_main_region_on_r1_PedestrianRed_time_event_0 = new TimeEvent(
			false, 6);
	private final TimeEvent trafficLightWaiting_main_region_on_r1_StreetPrepare_time_event_0 = new TimeEvent(
			false, 7);
	private final TimeEvent trafficLightWaiting_main_region_off_r1_YellowOn_time_event_0 = new TimeEvent(
			false, 8);
	private final TimeEvent trafficLightWaiting_main_region_off_r1_YellowOff_time_event_0 = new TimeEvent(
			false, 9);

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

		trafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0
				.setStatemachine(this);
		trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn_time_event_0
				.setStatemachine(this);
		trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff_time_event_0
				.setStatemachine(this);
		trafficLightWaiting_main_region_on_r1_StreetAttention_time_event_0
				.setStatemachine(this);
		trafficLightWaiting_main_region_on_r1_StreetRed_time_event_0
				.setStatemachine(this);
		trafficLightWaiting_main_region_on_r1_PedestrianGreen_time_event_0
				.setStatemachine(this);
		trafficLightWaiting_main_region_on_r1_PedestrianRed_time_event_0
				.setStatemachine(this);
		trafficLightWaiting_main_region_on_r1_StreetPrepare_time_event_0
				.setStatemachine(this);
		trafficLightWaiting_main_region_off_r1_YellowOn_time_event_0
				.setStatemachine(this);
		trafficLightWaiting_main_region_off_r1_YellowOff_time_event_0
				.setStatemachine(this);

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
		switch (state) {

			case Main_region_on :
				return stateVector[0].ordinal() >= State.Main_region_on
						.ordinal()
						&& stateVector[0].ordinal() <= State.Main_region_on_r1_StreetPrepare
								.ordinal();

			case Main_region_on_r1_StreetGreen :
				return stateVector[0] == State.Main_region_on_r1_StreetGreen;

			case Main_region_on_r1_PedWaiting :
				return stateVector[0].ordinal() >= State.Main_region_on_r1_PedWaiting
						.ordinal()
						&& stateVector[0].ordinal() <= State.Main_region_on_r1_PedWaiting_r1_waitOff
								.ordinal();

			case Main_region_on_r1_PedWaiting_r1_waitOn :
				return stateVector[0] == State.Main_region_on_r1_PedWaiting_r1_waitOn;

			case Main_region_on_r1_PedWaiting_r1_waitOff :
				return stateVector[0] == State.Main_region_on_r1_PedWaiting_r1_waitOff;

			case Main_region_on_r1_StreetAttention :
				return stateVector[0] == State.Main_region_on_r1_StreetAttention;

			case Main_region_on_r1_StreetRed :
				return stateVector[0] == State.Main_region_on_r1_StreetRed;

			case Main_region_on_r1_PedestrianGreen :
				return stateVector[0] == State.Main_region_on_r1_PedestrianGreen;

			case Main_region_on_r1_PedestrianRed :
				return stateVector[0] == State.Main_region_on_r1_PedestrianRed;

			case Main_region_on_r1_StreetPrepare :
				return stateVector[0] == State.Main_region_on_r1_StreetPrepare;

			case Main_region_off :
				return stateVector[0].ordinal() >= State.Main_region_off
						.ordinal()
						&& stateVector[0].ordinal() <= State.Main_region_off_r1_YellowOff
								.ordinal();

			case Main_region_off_r1_YellowOn :
				return stateVector[0] == State.Main_region_off_r1_YellowOn;

			case Main_region_off_r1_YellowOff :
				return stateVector[0] == State.Main_region_off_r1_YellowOff;

			default :
				return false;
		}
		/*
		for (int i=0;i<stateVector.length;i++){
			if (stateVector[i]==state) {
				return true;
			}
		}
		return false;
		 */
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
		sCITrafficLight.red = false;
		sCITrafficLight.yellow = false;
		sCITrafficLight.green = true;
		sCIPedestrian.red = true;
		sCIPedestrian.green = false;
		sCIPedestrian.request = false;

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
				getTimerService()
						.resetTimer(
								trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn_time_event_0);

				getTimerService()
						.resetTimer(
								trafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0);
				sCIPedestrian.request = false;

				break;

			case Main_region_on_r1_PedWaiting_r1_waitOff :
				stateVector[0] = State.$NullState$;
				getTimerService()
						.resetTimer(
								trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff_time_event_0);

				getTimerService()
						.resetTimer(
								trafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0);
				sCIPedestrian.request = false;

				break;

			case Main_region_on_r1_StreetAttention :
				stateVector[0] = State.$NullState$;
				getTimerService()
						.resetTimer(
								trafficLightWaiting_main_region_on_r1_StreetAttention_time_event_0);

				break;

			case Main_region_on_r1_StreetRed :
				stateVector[0] = State.$NullState$;
				getTimerService()
						.resetTimer(
								trafficLightWaiting_main_region_on_r1_StreetRed_time_event_0);

				break;

			case Main_region_on_r1_PedestrianGreen :
				stateVector[0] = State.$NullState$;
				getTimerService()
						.resetTimer(
								trafficLightWaiting_main_region_on_r1_PedestrianGreen_time_event_0);

				break;

			case Main_region_on_r1_PedestrianRed :
				stateVector[0] = State.$NullState$;
				getTimerService()
						.resetTimer(
								trafficLightWaiting_main_region_on_r1_PedestrianRed_time_event_0);

				break;

			case Main_region_on_r1_StreetPrepare :
				stateVector[0] = State.$NullState$;
				getTimerService()
						.resetTimer(
								trafficLightWaiting_main_region_on_r1_StreetPrepare_time_event_0);

				break;

			case Main_region_off_r1_YellowOn :
				stateVector[0] = State.$NullState$;
				getTimerService()
						.resetTimer(
								trafficLightWaiting_main_region_off_r1_YellowOn_time_event_0);

				break;

			case Main_region_off_r1_YellowOff :
				stateVector[0] = State.$NullState$;
				getTimerService()
						.resetTimer(
								trafficLightWaiting_main_region_off_r1_YellowOff_time_event_0);

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
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn_time_event_0);

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0);
					sCIPedestrian.request = false;

					break;

				case Main_region_on_r1_PedWaiting_r1_waitOff :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff_time_event_0);

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0);
					sCIPedestrian.request = false;

					break;

				case Main_region_on_r1_StreetAttention :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_StreetAttention_time_event_0);

					break;

				case Main_region_on_r1_StreetRed :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_StreetRed_time_event_0);

					break;

				case Main_region_on_r1_PedestrianGreen :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedestrianGreen_time_event_0);

					break;

				case Main_region_on_r1_PedestrianRed :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedestrianRed_time_event_0);

					break;

				case Main_region_on_r1_StreetPrepare :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_StreetPrepare_time_event_0);

					break;

				default :
					break;
			}

			sCITrafficLight.red = false;
			sCITrafficLight.green = false;
			sCITrafficLight.yellow = false;
			sCIPedestrian.red = false;
			sCIPedestrian.green = false;

			getTimerService()
					.setTimer(
							trafficLightWaiting_main_region_off_r1_YellowOn_time_event_0,
							500, cycleStartTime);
			sCITrafficLight.yellow = true;
			sCIPedestrian.request = true;

			nextStateIndex = 0;
			stateVector[0] = State.Main_region_off_r1_YellowOn;

		} else {
			if (sCIDefault.pedestrianRequest) {
				stateVector[0] = State.$NullState$;

				getTimerService()
						.setTimer(
								trafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0,
								7 * 1000, cycleStartTime);

				getTimerService()
						.setTimer(
								trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn_time_event_0,
								500, cycleStartTime);
				sCIPedestrian.request = true;

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
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn_time_event_0);

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0);
					sCIPedestrian.request = false;

					break;

				case Main_region_on_r1_PedWaiting_r1_waitOff :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff_time_event_0);

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0);
					sCIPedestrian.request = false;

					break;

				case Main_region_on_r1_StreetAttention :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_StreetAttention_time_event_0);

					break;

				case Main_region_on_r1_StreetRed :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_StreetRed_time_event_0);

					break;

				case Main_region_on_r1_PedestrianGreen :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedestrianGreen_time_event_0);

					break;

				case Main_region_on_r1_PedestrianRed :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedestrianRed_time_event_0);

					break;

				case Main_region_on_r1_StreetPrepare :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_StreetPrepare_time_event_0);

					break;

				default :
					break;
			}

			sCITrafficLight.red = false;
			sCITrafficLight.green = false;
			sCITrafficLight.yellow = false;
			sCIPedestrian.red = false;
			sCIPedestrian.green = false;

			getTimerService()
					.setTimer(
							trafficLightWaiting_main_region_off_r1_YellowOn_time_event_0,
							500, cycleStartTime);
			sCITrafficLight.yellow = true;
			sCIPedestrian.request = true;

			nextStateIndex = 0;
			stateVector[0] = State.Main_region_off_r1_YellowOn;

		} else {
			if (timeEvents[trafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0
					.getIndex()]) {
				//Handle exit of all possible states (of r1) at position 0...
				switch (stateVector[0]) {

					case Main_region_on_r1_PedWaiting_r1_waitOn :
						stateVector[0] = State.$NullState$;
						getTimerService()
								.resetTimer(
										trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn_time_event_0);

						break;

					case Main_region_on_r1_PedWaiting_r1_waitOff :
						stateVector[0] = State.$NullState$;
						getTimerService()
								.resetTimer(
										trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff_time_event_0);

						break;

					default :
						break;
				}

				getTimerService()
						.resetTimer(
								trafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0);
				sCIPedestrian.request = false;

				getTimerService()
						.setTimer(
								trafficLightWaiting_main_region_on_r1_StreetAttention_time_event_0,
								2 * 1000, cycleStartTime);
				sCITrafficLight.red = false;
				sCITrafficLight.yellow = true;
				sCITrafficLight.green = false;

				nextStateIndex = 0;
				stateVector[0] = State.Main_region_on_r1_StreetAttention;

			} else {
				if (timeEvents[trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn_time_event_0
						.getIndex()]) {
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn_time_event_0);

					getTimerService()
							.setTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff_time_event_0,
									500, cycleStartTime);
					sCIPedestrian.request = false;

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
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn_time_event_0);

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0);
					sCIPedestrian.request = false;

					break;

				case Main_region_on_r1_PedWaiting_r1_waitOff :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff_time_event_0);

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0);
					sCIPedestrian.request = false;

					break;

				case Main_region_on_r1_StreetAttention :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_StreetAttention_time_event_0);

					break;

				case Main_region_on_r1_StreetRed :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_StreetRed_time_event_0);

					break;

				case Main_region_on_r1_PedestrianGreen :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedestrianGreen_time_event_0);

					break;

				case Main_region_on_r1_PedestrianRed :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedestrianRed_time_event_0);

					break;

				case Main_region_on_r1_StreetPrepare :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_StreetPrepare_time_event_0);

					break;

				default :
					break;
			}

			sCITrafficLight.red = false;
			sCITrafficLight.green = false;
			sCITrafficLight.yellow = false;
			sCIPedestrian.red = false;
			sCIPedestrian.green = false;

			getTimerService()
					.setTimer(
							trafficLightWaiting_main_region_off_r1_YellowOn_time_event_0,
							500, cycleStartTime);
			sCITrafficLight.yellow = true;
			sCIPedestrian.request = true;

			nextStateIndex = 0;
			stateVector[0] = State.Main_region_off_r1_YellowOn;

		} else {
			if (timeEvents[trafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0
					.getIndex()]) {
				//Handle exit of all possible states (of r1) at position 0...
				switch (stateVector[0]) {

					case Main_region_on_r1_PedWaiting_r1_waitOn :
						stateVector[0] = State.$NullState$;
						getTimerService()
								.resetTimer(
										trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn_time_event_0);

						break;

					case Main_region_on_r1_PedWaiting_r1_waitOff :
						stateVector[0] = State.$NullState$;
						getTimerService()
								.resetTimer(
										trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff_time_event_0);

						break;

					default :
						break;
				}

				getTimerService()
						.resetTimer(
								trafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0);
				sCIPedestrian.request = false;

				getTimerService()
						.setTimer(
								trafficLightWaiting_main_region_on_r1_StreetAttention_time_event_0,
								2 * 1000, cycleStartTime);
				sCITrafficLight.red = false;
				sCITrafficLight.yellow = true;
				sCITrafficLight.green = false;

				nextStateIndex = 0;
				stateVector[0] = State.Main_region_on_r1_StreetAttention;

			} else {
				if (timeEvents[trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff_time_event_0
						.getIndex()]) {
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff_time_event_0);

					getTimerService()
							.setTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn_time_event_0,
									500, cycleStartTime);
					sCIPedestrian.request = true;

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
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn_time_event_0);

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0);
					sCIPedestrian.request = false;

					break;

				case Main_region_on_r1_PedWaiting_r1_waitOff :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff_time_event_0);

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0);
					sCIPedestrian.request = false;

					break;

				case Main_region_on_r1_StreetAttention :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_StreetAttention_time_event_0);

					break;

				case Main_region_on_r1_StreetRed :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_StreetRed_time_event_0);

					break;

				case Main_region_on_r1_PedestrianGreen :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedestrianGreen_time_event_0);

					break;

				case Main_region_on_r1_PedestrianRed :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedestrianRed_time_event_0);

					break;

				case Main_region_on_r1_StreetPrepare :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_StreetPrepare_time_event_0);

					break;

				default :
					break;
			}

			sCITrafficLight.red = false;
			sCITrafficLight.green = false;
			sCITrafficLight.yellow = false;
			sCIPedestrian.red = false;
			sCIPedestrian.green = false;

			getTimerService()
					.setTimer(
							trafficLightWaiting_main_region_off_r1_YellowOn_time_event_0,
							500, cycleStartTime);
			sCITrafficLight.yellow = true;
			sCIPedestrian.request = true;

			nextStateIndex = 0;
			stateVector[0] = State.Main_region_off_r1_YellowOn;

		} else {
			if (timeEvents[trafficLightWaiting_main_region_on_r1_StreetAttention_time_event_0
					.getIndex()]) {
				stateVector[0] = State.$NullState$;
				getTimerService()
						.resetTimer(
								trafficLightWaiting_main_region_on_r1_StreetAttention_time_event_0);

				getTimerService()
						.setTimer(
								trafficLightWaiting_main_region_on_r1_StreetRed_time_event_0,
								2 * 1000, cycleStartTime);
				sCITrafficLight.red = true;
				sCITrafficLight.yellow = false;
				sCITrafficLight.green = false;

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
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn_time_event_0);

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0);
					sCIPedestrian.request = false;

					break;

				case Main_region_on_r1_PedWaiting_r1_waitOff :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff_time_event_0);

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0);
					sCIPedestrian.request = false;

					break;

				case Main_region_on_r1_StreetAttention :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_StreetAttention_time_event_0);

					break;

				case Main_region_on_r1_StreetRed :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_StreetRed_time_event_0);

					break;

				case Main_region_on_r1_PedestrianGreen :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedestrianGreen_time_event_0);

					break;

				case Main_region_on_r1_PedestrianRed :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedestrianRed_time_event_0);

					break;

				case Main_region_on_r1_StreetPrepare :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_StreetPrepare_time_event_0);

					break;

				default :
					break;
			}

			sCITrafficLight.red = false;
			sCITrafficLight.green = false;
			sCITrafficLight.yellow = false;
			sCIPedestrian.red = false;
			sCIPedestrian.green = false;

			getTimerService()
					.setTimer(
							trafficLightWaiting_main_region_off_r1_YellowOn_time_event_0,
							500, cycleStartTime);
			sCITrafficLight.yellow = true;
			sCIPedestrian.request = true;

			nextStateIndex = 0;
			stateVector[0] = State.Main_region_off_r1_YellowOn;

		} else {
			if (timeEvents[trafficLightWaiting_main_region_on_r1_StreetRed_time_event_0
					.getIndex()]) {
				stateVector[0] = State.$NullState$;
				getTimerService()
						.resetTimer(
								trafficLightWaiting_main_region_on_r1_StreetRed_time_event_0);

				getTimerService()
						.setTimer(
								trafficLightWaiting_main_region_on_r1_PedestrianGreen_time_event_0,
								7 * 1000, cycleStartTime);
				sCIPedestrian.red = false;
				sCIPedestrian.green = true;

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
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn_time_event_0);

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0);
					sCIPedestrian.request = false;

					break;

				case Main_region_on_r1_PedWaiting_r1_waitOff :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff_time_event_0);

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0);
					sCIPedestrian.request = false;

					break;

				case Main_region_on_r1_StreetAttention :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_StreetAttention_time_event_0);

					break;

				case Main_region_on_r1_StreetRed :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_StreetRed_time_event_0);

					break;

				case Main_region_on_r1_PedestrianGreen :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedestrianGreen_time_event_0);

					break;

				case Main_region_on_r1_PedestrianRed :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedestrianRed_time_event_0);

					break;

				case Main_region_on_r1_StreetPrepare :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_StreetPrepare_time_event_0);

					break;

				default :
					break;
			}

			sCITrafficLight.red = false;
			sCITrafficLight.green = false;
			sCITrafficLight.yellow = false;
			sCIPedestrian.red = false;
			sCIPedestrian.green = false;

			getTimerService()
					.setTimer(
							trafficLightWaiting_main_region_off_r1_YellowOn_time_event_0,
							500, cycleStartTime);
			sCITrafficLight.yellow = true;
			sCIPedestrian.request = true;

			nextStateIndex = 0;
			stateVector[0] = State.Main_region_off_r1_YellowOn;

		} else {
			if (timeEvents[trafficLightWaiting_main_region_on_r1_PedestrianGreen_time_event_0
					.getIndex()]) {
				stateVector[0] = State.$NullState$;
				getTimerService()
						.resetTimer(
								trafficLightWaiting_main_region_on_r1_PedestrianGreen_time_event_0);

				getTimerService()
						.setTimer(
								trafficLightWaiting_main_region_on_r1_PedestrianRed_time_event_0,
								5 * 1000, cycleStartTime);
				sCIPedestrian.red = true;
				sCIPedestrian.green = false;

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
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn_time_event_0);

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0);
					sCIPedestrian.request = false;

					break;

				case Main_region_on_r1_PedWaiting_r1_waitOff :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff_time_event_0);

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0);
					sCIPedestrian.request = false;

					break;

				case Main_region_on_r1_StreetAttention :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_StreetAttention_time_event_0);

					break;

				case Main_region_on_r1_StreetRed :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_StreetRed_time_event_0);

					break;

				case Main_region_on_r1_PedestrianGreen :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedestrianGreen_time_event_0);

					break;

				case Main_region_on_r1_PedestrianRed :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedestrianRed_time_event_0);

					break;

				case Main_region_on_r1_StreetPrepare :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_StreetPrepare_time_event_0);

					break;

				default :
					break;
			}

			sCITrafficLight.red = false;
			sCITrafficLight.green = false;
			sCITrafficLight.yellow = false;
			sCIPedestrian.red = false;
			sCIPedestrian.green = false;

			getTimerService()
					.setTimer(
							trafficLightWaiting_main_region_off_r1_YellowOn_time_event_0,
							500, cycleStartTime);
			sCITrafficLight.yellow = true;
			sCIPedestrian.request = true;

			nextStateIndex = 0;
			stateVector[0] = State.Main_region_off_r1_YellowOn;

		} else {
			if (timeEvents[trafficLightWaiting_main_region_on_r1_PedestrianRed_time_event_0
					.getIndex()]) {
				stateVector[0] = State.$NullState$;
				getTimerService()
						.resetTimer(
								trafficLightWaiting_main_region_on_r1_PedestrianRed_time_event_0);

				getTimerService()
						.setTimer(
								trafficLightWaiting_main_region_on_r1_StreetPrepare_time_event_0,
								2 * 1000, cycleStartTime);
				sCITrafficLight.red = true;
				sCITrafficLight.yellow = true;
				sCITrafficLight.green = false;

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
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn_time_event_0);

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0);
					sCIPedestrian.request = false;

					break;

				case Main_region_on_r1_PedWaiting_r1_waitOff :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff_time_event_0);

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0);
					sCIPedestrian.request = false;

					break;

				case Main_region_on_r1_StreetAttention :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_StreetAttention_time_event_0);

					break;

				case Main_region_on_r1_StreetRed :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_StreetRed_time_event_0);

					break;

				case Main_region_on_r1_PedestrianGreen :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedestrianGreen_time_event_0);

					break;

				case Main_region_on_r1_PedestrianRed :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedestrianRed_time_event_0);

					break;

				case Main_region_on_r1_StreetPrepare :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_StreetPrepare_time_event_0);

					break;

				default :
					break;
			}

			sCITrafficLight.red = false;
			sCITrafficLight.green = false;
			sCITrafficLight.yellow = false;
			sCIPedestrian.red = false;
			sCIPedestrian.green = false;

			getTimerService()
					.setTimer(
							trafficLightWaiting_main_region_off_r1_YellowOn_time_event_0,
							500, cycleStartTime);
			sCITrafficLight.yellow = true;
			sCIPedestrian.request = true;

			nextStateIndex = 0;
			stateVector[0] = State.Main_region_off_r1_YellowOn;

		} else {
			if (timeEvents[trafficLightWaiting_main_region_on_r1_StreetPrepare_time_event_0
					.getIndex()]) {
				stateVector[0] = State.$NullState$;
				getTimerService()
						.resetTimer(
								trafficLightWaiting_main_region_on_r1_StreetPrepare_time_event_0);

				sCITrafficLight.red = false;
				sCITrafficLight.yellow = false;
				sCITrafficLight.green = true;
				sCIPedestrian.red = true;
				sCIPedestrian.green = false;
				sCIPedestrian.request = false;

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
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_off_r1_YellowOn_time_event_0);

					break;

				case Main_region_off_r1_YellowOff :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_off_r1_YellowOff_time_event_0);

					break;

				default :
					break;
			}

			sCITrafficLight.red = false;
			sCITrafficLight.yellow = false;
			sCITrafficLight.green = true;
			sCIPedestrian.red = true;
			sCIPedestrian.green = false;
			sCIPedestrian.request = false;

			nextStateIndex = 0;
			stateVector[0] = State.Main_region_on_r1_StreetGreen;

		} else {
			if (timeEvents[trafficLightWaiting_main_region_off_r1_YellowOn_time_event_0
					.getIndex()]) {
				stateVector[0] = State.$NullState$;
				getTimerService()
						.resetTimer(
								trafficLightWaiting_main_region_off_r1_YellowOn_time_event_0);

				getTimerService()
						.setTimer(
								trafficLightWaiting_main_region_off_r1_YellowOff_time_event_0,
								500, cycleStartTime);
				sCITrafficLight.yellow = false;
				sCIPedestrian.request = false;

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
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_off_r1_YellowOn_time_event_0);

					break;

				case Main_region_off_r1_YellowOff :
					stateVector[0] = State.$NullState$;
					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_off_r1_YellowOff_time_event_0);

					break;

				default :
					break;
			}

			sCITrafficLight.red = false;
			sCITrafficLight.yellow = false;
			sCITrafficLight.green = true;
			sCIPedestrian.red = true;
			sCIPedestrian.green = false;
			sCIPedestrian.request = false;

			nextStateIndex = 0;
			stateVector[0] = State.Main_region_on_r1_StreetGreen;

		} else {
			if (timeEvents[trafficLightWaiting_main_region_off_r1_YellowOff_time_event_0
					.getIndex()]) {
				stateVector[0] = State.$NullState$;
				getTimerService()
						.resetTimer(
								trafficLightWaiting_main_region_off_r1_YellowOff_time_event_0);

				getTimerService()
						.setTimer(
								trafficLightWaiting_main_region_off_r1_YellowOn_time_event_0,
								500, cycleStartTime);
				sCITrafficLight.yellow = true;
				sCIPedestrian.request = true;

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
