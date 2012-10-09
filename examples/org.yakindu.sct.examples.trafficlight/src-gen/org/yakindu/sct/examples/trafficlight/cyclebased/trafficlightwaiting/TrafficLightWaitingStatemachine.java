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
		main_region_on, main_region_on_r1_StreetGreen, main_region_on_r1_PedWaiting, main_region_on_r1_PedWaiting_r1_waitOn, main_region_on_r1_PedWaiting_r1_waitOff, main_region_on_r1_StreetAttention, main_region_on_r1_StreetRed, main_region_on_r1_PedestrianGreen, main_region_on_r1_PedestrianRed, main_region_on_r1_StreetPrepare, main_region_off, main_region_off_r1_YellowOn, main_region_off_r1_YellowOff, $NullState$
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

	public void enter() {
		if (timerService == null) {
			throw new IllegalStateException("TimerService not set.");
		}
		cycleStartTime = System.currentTimeMillis();
		entryAction();

		sCITrafficLight.red = false;

		sCITrafficLight.yellow = false;

		sCITrafficLight.green = true;

		sCIPedestrian.red = true;

		sCIPedestrian.green = false;

		sCIPedestrian.request = false;

		nextStateIndex = 0;
		stateVector[0] = State.main_region_on_r1_StreetGreen;
	}

	public void exit() {
		switch (stateVector[0]) {
			case main_region_on_r1_StreetGreen :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_on_r1_PedWaiting_r1_waitOn :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				getTimerService()
						.resetTimer(
								trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn_time_event_0);

				getTimerService()
						.resetTimer(
								trafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0);

				sCIPedestrian.request = false;
				break;

			case main_region_on_r1_PedWaiting_r1_waitOff :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				getTimerService()
						.resetTimer(
								trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff_time_event_0);

				getTimerService()
						.resetTimer(
								trafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0);

				sCIPedestrian.request = false;
				break;

			case main_region_on_r1_StreetAttention :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				getTimerService()
						.resetTimer(
								trafficLightWaiting_main_region_on_r1_StreetAttention_time_event_0);
				break;

			case main_region_on_r1_StreetRed :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				getTimerService()
						.resetTimer(
								trafficLightWaiting_main_region_on_r1_StreetRed_time_event_0);
				break;

			case main_region_on_r1_PedestrianGreen :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				getTimerService()
						.resetTimer(
								trafficLightWaiting_main_region_on_r1_PedestrianGreen_time_event_0);
				break;

			case main_region_on_r1_PedestrianRed :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				getTimerService()
						.resetTimer(
								trafficLightWaiting_main_region_on_r1_PedestrianRed_time_event_0);
				break;

			case main_region_on_r1_StreetPrepare :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				getTimerService()
						.resetTimer(
								trafficLightWaiting_main_region_on_r1_StreetPrepare_time_event_0);
				break;

			case main_region_off_r1_YellowOn :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				getTimerService()
						.resetTimer(
								trafficLightWaiting_main_region_off_r1_YellowOn_time_event_0);
				break;

			case main_region_off_r1_YellowOff :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				getTimerService()
						.resetTimer(
								trafficLightWaiting_main_region_off_r1_YellowOff_time_event_0);
				break;

			default :
				break;
		}

		exitAction();
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
			case main_region_on :
				return stateVector[0].ordinal() >= State.main_region_on
						.ordinal()
						&& stateVector[0].ordinal() <= State.main_region_on_r1_StreetPrepare
								.ordinal();
			case main_region_on_r1_StreetGreen :
				return stateVector[0] == State.main_region_on_r1_StreetGreen;
			case main_region_on_r1_PedWaiting :
				return stateVector[0].ordinal() >= State.main_region_on_r1_PedWaiting
						.ordinal()
						&& stateVector[0].ordinal() <= State.main_region_on_r1_PedWaiting_r1_waitOff
								.ordinal();
			case main_region_on_r1_PedWaiting_r1_waitOn :
				return stateVector[0] == State.main_region_on_r1_PedWaiting_r1_waitOn;
			case main_region_on_r1_PedWaiting_r1_waitOff :
				return stateVector[0] == State.main_region_on_r1_PedWaiting_r1_waitOff;
			case main_region_on_r1_StreetAttention :
				return stateVector[0] == State.main_region_on_r1_StreetAttention;
			case main_region_on_r1_StreetRed :
				return stateVector[0] == State.main_region_on_r1_StreetRed;
			case main_region_on_r1_PedestrianGreen :
				return stateVector[0] == State.main_region_on_r1_PedestrianGreen;
			case main_region_on_r1_PedestrianRed :
				return stateVector[0] == State.main_region_on_r1_PedestrianRed;
			case main_region_on_r1_StreetPrepare :
				return stateVector[0] == State.main_region_on_r1_StreetPrepare;
			case main_region_off :
				return stateVector[0].ordinal() >= State.main_region_off
						.ordinal()
						&& stateVector[0].ordinal() <= State.main_region_off_r1_YellowOff
								.ordinal();
			case main_region_off_r1_YellowOn :
				return stateVector[0] == State.main_region_off_r1_YellowOn;
			case main_region_off_r1_YellowOff :
				return stateVector[0] == State.main_region_off_r1_YellowOff;
			default :
				return false;
		}
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

	/* Entry action for statechart 'TrafficLightWaiting'. */
	private void entryAction() {
	}

	/* Exit action for state 'TrafficLightWaiting'. */
	private void exitAction() {
	}

	/* The reactions of state StreetGreen. */
	private void reactMain_region_on_r1_StreetGreen() {
		if (sCIDefault.onOff) {
			switch (stateVector[0]) {
				case main_region_on_r1_StreetGreen :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_on_r1_PedWaiting_r1_waitOn :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn_time_event_0);

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0);

					sCIPedestrian.request = false;
					break;

				case main_region_on_r1_PedWaiting_r1_waitOff :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff_time_event_0);

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0);

					sCIPedestrian.request = false;
					break;

				case main_region_on_r1_StreetAttention :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_StreetAttention_time_event_0);
					break;

				case main_region_on_r1_StreetRed :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_StreetRed_time_event_0);
					break;

				case main_region_on_r1_PedestrianGreen :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedestrianGreen_time_event_0);
					break;

				case main_region_on_r1_PedestrianRed :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedestrianRed_time_event_0);
					break;

				case main_region_on_r1_StreetPrepare :
					nextStateIndex = 0;
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
			stateVector[0] = State.main_region_off_r1_YellowOn;
		} else {
			if (sCIDefault.pedestrianRequest) {
				nextStateIndex = 0;
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
				stateVector[0] = State.main_region_on_r1_PedWaiting_r1_waitOn;
			}
		}
	}

	/* The reactions of state waitOn. */
	private void reactMain_region_on_r1_PedWaiting_r1_waitOn() {
		if (sCIDefault.onOff) {
			switch (stateVector[0]) {
				case main_region_on_r1_StreetGreen :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_on_r1_PedWaiting_r1_waitOn :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn_time_event_0);

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0);

					sCIPedestrian.request = false;
					break;

				case main_region_on_r1_PedWaiting_r1_waitOff :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff_time_event_0);

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0);

					sCIPedestrian.request = false;
					break;

				case main_region_on_r1_StreetAttention :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_StreetAttention_time_event_0);
					break;

				case main_region_on_r1_StreetRed :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_StreetRed_time_event_0);
					break;

				case main_region_on_r1_PedestrianGreen :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedestrianGreen_time_event_0);
					break;

				case main_region_on_r1_PedestrianRed :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedestrianRed_time_event_0);
					break;

				case main_region_on_r1_StreetPrepare :
					nextStateIndex = 0;
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
			stateVector[0] = State.main_region_off_r1_YellowOn;
		} else {
			if (timeEvents[trafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0
					.getIndex()]) {
				switch (stateVector[0]) {
					case main_region_on_r1_PedWaiting_r1_waitOn :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;

						getTimerService()
								.resetTimer(
										trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn_time_event_0);
						break;

					case main_region_on_r1_PedWaiting_r1_waitOff :
						nextStateIndex = 0;
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
				stateVector[0] = State.main_region_on_r1_StreetAttention;
			} else {
				if (timeEvents[trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn_time_event_0
						.getIndex()]) {
					nextStateIndex = 0;
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
					stateVector[0] = State.main_region_on_r1_PedWaiting_r1_waitOff;
				}
			}
		}
	}

	/* The reactions of state waitOff. */
	private void reactMain_region_on_r1_PedWaiting_r1_waitOff() {
		if (sCIDefault.onOff) {
			switch (stateVector[0]) {
				case main_region_on_r1_StreetGreen :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_on_r1_PedWaiting_r1_waitOn :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn_time_event_0);

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0);

					sCIPedestrian.request = false;
					break;

				case main_region_on_r1_PedWaiting_r1_waitOff :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff_time_event_0);

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0);

					sCIPedestrian.request = false;
					break;

				case main_region_on_r1_StreetAttention :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_StreetAttention_time_event_0);
					break;

				case main_region_on_r1_StreetRed :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_StreetRed_time_event_0);
					break;

				case main_region_on_r1_PedestrianGreen :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedestrianGreen_time_event_0);
					break;

				case main_region_on_r1_PedestrianRed :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedestrianRed_time_event_0);
					break;

				case main_region_on_r1_StreetPrepare :
					nextStateIndex = 0;
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
			stateVector[0] = State.main_region_off_r1_YellowOn;
		} else {
			if (timeEvents[trafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0
					.getIndex()]) {
				switch (stateVector[0]) {
					case main_region_on_r1_PedWaiting_r1_waitOn :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;

						getTimerService()
								.resetTimer(
										trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn_time_event_0);
						break;

					case main_region_on_r1_PedWaiting_r1_waitOff :
						nextStateIndex = 0;
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
				stateVector[0] = State.main_region_on_r1_StreetAttention;
			} else {
				if (timeEvents[trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff_time_event_0
						.getIndex()]) {
					nextStateIndex = 0;
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
					stateVector[0] = State.main_region_on_r1_PedWaiting_r1_waitOn;
				}
			}
		}
	}

	/* The reactions of state StreetAttention. */
	private void reactMain_region_on_r1_StreetAttention() {
		if (sCIDefault.onOff) {
			switch (stateVector[0]) {
				case main_region_on_r1_StreetGreen :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_on_r1_PedWaiting_r1_waitOn :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn_time_event_0);

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0);

					sCIPedestrian.request = false;
					break;

				case main_region_on_r1_PedWaiting_r1_waitOff :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff_time_event_0);

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0);

					sCIPedestrian.request = false;
					break;

				case main_region_on_r1_StreetAttention :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_StreetAttention_time_event_0);
					break;

				case main_region_on_r1_StreetRed :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_StreetRed_time_event_0);
					break;

				case main_region_on_r1_PedestrianGreen :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedestrianGreen_time_event_0);
					break;

				case main_region_on_r1_PedestrianRed :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedestrianRed_time_event_0);
					break;

				case main_region_on_r1_StreetPrepare :
					nextStateIndex = 0;
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
			stateVector[0] = State.main_region_off_r1_YellowOn;
		} else {
			if (timeEvents[trafficLightWaiting_main_region_on_r1_StreetAttention_time_event_0
					.getIndex()]) {
				nextStateIndex = 0;
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
				stateVector[0] = State.main_region_on_r1_StreetRed;
			}
		}
	}

	/* The reactions of state StreetRed. */
	private void reactMain_region_on_r1_StreetRed() {
		if (sCIDefault.onOff) {
			switch (stateVector[0]) {
				case main_region_on_r1_StreetGreen :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_on_r1_PedWaiting_r1_waitOn :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn_time_event_0);

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0);

					sCIPedestrian.request = false;
					break;

				case main_region_on_r1_PedWaiting_r1_waitOff :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff_time_event_0);

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0);

					sCIPedestrian.request = false;
					break;

				case main_region_on_r1_StreetAttention :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_StreetAttention_time_event_0);
					break;

				case main_region_on_r1_StreetRed :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_StreetRed_time_event_0);
					break;

				case main_region_on_r1_PedestrianGreen :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedestrianGreen_time_event_0);
					break;

				case main_region_on_r1_PedestrianRed :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedestrianRed_time_event_0);
					break;

				case main_region_on_r1_StreetPrepare :
					nextStateIndex = 0;
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
			stateVector[0] = State.main_region_off_r1_YellowOn;
		} else {
			if (timeEvents[trafficLightWaiting_main_region_on_r1_StreetRed_time_event_0
					.getIndex()]) {
				nextStateIndex = 0;
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
				stateVector[0] = State.main_region_on_r1_PedestrianGreen;
			}
		}
	}

	/* The reactions of state PedestrianGreen. */
	private void reactMain_region_on_r1_PedestrianGreen() {
		if (sCIDefault.onOff) {
			switch (stateVector[0]) {
				case main_region_on_r1_StreetGreen :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_on_r1_PedWaiting_r1_waitOn :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn_time_event_0);

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0);

					sCIPedestrian.request = false;
					break;

				case main_region_on_r1_PedWaiting_r1_waitOff :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff_time_event_0);

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0);

					sCIPedestrian.request = false;
					break;

				case main_region_on_r1_StreetAttention :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_StreetAttention_time_event_0);
					break;

				case main_region_on_r1_StreetRed :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_StreetRed_time_event_0);
					break;

				case main_region_on_r1_PedestrianGreen :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedestrianGreen_time_event_0);
					break;

				case main_region_on_r1_PedestrianRed :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedestrianRed_time_event_0);
					break;

				case main_region_on_r1_StreetPrepare :
					nextStateIndex = 0;
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
			stateVector[0] = State.main_region_off_r1_YellowOn;
		} else {
			if (timeEvents[trafficLightWaiting_main_region_on_r1_PedestrianGreen_time_event_0
					.getIndex()]) {
				nextStateIndex = 0;
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
				stateVector[0] = State.main_region_on_r1_PedestrianRed;
			}
		}
	}

	/* The reactions of state PedestrianRed. */
	private void reactMain_region_on_r1_PedestrianRed() {
		if (sCIDefault.onOff) {
			switch (stateVector[0]) {
				case main_region_on_r1_StreetGreen :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_on_r1_PedWaiting_r1_waitOn :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn_time_event_0);

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0);

					sCIPedestrian.request = false;
					break;

				case main_region_on_r1_PedWaiting_r1_waitOff :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff_time_event_0);

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0);

					sCIPedestrian.request = false;
					break;

				case main_region_on_r1_StreetAttention :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_StreetAttention_time_event_0);
					break;

				case main_region_on_r1_StreetRed :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_StreetRed_time_event_0);
					break;

				case main_region_on_r1_PedestrianGreen :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedestrianGreen_time_event_0);
					break;

				case main_region_on_r1_PedestrianRed :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedestrianRed_time_event_0);
					break;

				case main_region_on_r1_StreetPrepare :
					nextStateIndex = 0;
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
			stateVector[0] = State.main_region_off_r1_YellowOn;
		} else {
			if (timeEvents[trafficLightWaiting_main_region_on_r1_PedestrianRed_time_event_0
					.getIndex()]) {
				nextStateIndex = 0;
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
				stateVector[0] = State.main_region_on_r1_StreetPrepare;
			}
		}
	}

	/* The reactions of state StreetPrepare. */
	private void reactMain_region_on_r1_StreetPrepare() {
		if (sCIDefault.onOff) {
			switch (stateVector[0]) {
				case main_region_on_r1_StreetGreen :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_on_r1_PedWaiting_r1_waitOn :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn_time_event_0);

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0);

					sCIPedestrian.request = false;
					break;

				case main_region_on_r1_PedWaiting_r1_waitOff :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff_time_event_0);

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0);

					sCIPedestrian.request = false;
					break;

				case main_region_on_r1_StreetAttention :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_StreetAttention_time_event_0);
					break;

				case main_region_on_r1_StreetRed :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_StreetRed_time_event_0);
					break;

				case main_region_on_r1_PedestrianGreen :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedestrianGreen_time_event_0);
					break;

				case main_region_on_r1_PedestrianRed :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_on_r1_PedestrianRed_time_event_0);
					break;

				case main_region_on_r1_StreetPrepare :
					nextStateIndex = 0;
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
			stateVector[0] = State.main_region_off_r1_YellowOn;
		} else {
			if (timeEvents[trafficLightWaiting_main_region_on_r1_StreetPrepare_time_event_0
					.getIndex()]) {
				nextStateIndex = 0;
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
				stateVector[0] = State.main_region_on_r1_StreetGreen;
			}
		}
	}

	/* The reactions of state YellowOn. */
	private void reactMain_region_off_r1_YellowOn() {
		if (sCIDefault.onOff) {
			switch (stateVector[0]) {
				case main_region_off_r1_YellowOn :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_off_r1_YellowOn_time_event_0);
					break;

				case main_region_off_r1_YellowOff :
					nextStateIndex = 0;
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
			stateVector[0] = State.main_region_on_r1_StreetGreen;
		} else {
			if (timeEvents[trafficLightWaiting_main_region_off_r1_YellowOn_time_event_0
					.getIndex()]) {
				nextStateIndex = 0;
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
				stateVector[0] = State.main_region_off_r1_YellowOff;
			}
		}
	}

	/* The reactions of state YellowOff. */
	private void reactMain_region_off_r1_YellowOff() {
		if (sCIDefault.onOff) {
			switch (stateVector[0]) {
				case main_region_off_r1_YellowOn :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					getTimerService()
							.resetTimer(
									trafficLightWaiting_main_region_off_r1_YellowOn_time_event_0);
					break;

				case main_region_off_r1_YellowOff :
					nextStateIndex = 0;
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
			stateVector[0] = State.main_region_on_r1_StreetGreen;
		} else {
			if (timeEvents[trafficLightWaiting_main_region_off_r1_YellowOff_time_event_0
					.getIndex()]) {
				nextStateIndex = 0;
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
				stateVector[0] = State.main_region_off_r1_YellowOn;
			}
		}
	}

	public void runCycle() {

		cycleStartTime = System.currentTimeMillis();

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_on_r1_StreetGreen :
					reactMain_region_on_r1_StreetGreen();
					break;
				case main_region_on_r1_PedWaiting_r1_waitOn :
					reactMain_region_on_r1_PedWaiting_r1_waitOn();
					break;
				case main_region_on_r1_PedWaiting_r1_waitOff :
					reactMain_region_on_r1_PedWaiting_r1_waitOff();
					break;
				case main_region_on_r1_StreetAttention :
					reactMain_region_on_r1_StreetAttention();
					break;
				case main_region_on_r1_StreetRed :
					reactMain_region_on_r1_StreetRed();
					break;
				case main_region_on_r1_PedestrianGreen :
					reactMain_region_on_r1_PedestrianGreen();
					break;
				case main_region_on_r1_PedestrianRed :
					reactMain_region_on_r1_PedestrianRed();
					break;
				case main_region_on_r1_StreetPrepare :
					reactMain_region_on_r1_StreetPrepare();
					break;
				case main_region_off_r1_YellowOn :
					reactMain_region_off_r1_YellowOn();
					break;
				case main_region_off_r1_YellowOff :
					reactMain_region_off_r1_YellowOff();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
