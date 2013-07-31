/**
Copyright (c) 2012 committers of YAKINDU and others.
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html

Contributors:
    committers of YAKINDU - initial API and implementation
�*/
package org.yakindu.sct.examples.trafficlight.cyclebased.trafficlightwaiting;
import org.yakindu.sct.examples.trafficlight.cyclebased.ITimer;

public class TrafficLightWaitingStatemachine
		implements
			ITrafficLightWaitingStatemachine {

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
	private final class SCInterfaceImpl implements SCInterface {

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

	private SCInterfaceImpl sCInterface;

	public enum State {
		main_region_on, main_region_on_r1_StreetGreen, main_region_on_r1_PedWaiting, main_region_on_r1_PedWaiting_r1_waitOn, main_region_on_r1_PedWaiting_r1_waitOff, main_region_on_r1_StreetAttention, main_region_on_r1_StreetRed, main_region_on_r1_PedestrianGreen, main_region_on_r1_PedestrianRed, main_region_on_r1_StreetPrepare, main_region_off, main_region_off_r1_YellowOn, main_region_off_r1_YellowOff, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	private ITimer timer;

	public TrafficLightWaitingStatemachine() {

		sCITrafficLight = new SCITrafficLightImpl();
		sCIPedestrian = new SCIPedestrianImpl();
		sCInterface = new SCInterfaceImpl();
	}

	public void init() {
		if (timer == null) {
			throw new IllegalStateException("timer not set.");
		}
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCITrafficLight.red = false;

		sCITrafficLight.yellow = false;

		sCITrafficLight.green = false;

		sCIPedestrian.request = false;

		sCIPedestrian.red = false;

		sCIPedestrian.green = false;
	}

	public void enter() {
		if (timer == null) {
			throw new IllegalStateException("timer not set.");
		}
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

				timer.unsetTimer(this, 1);

				timer.unsetTimer(this, 0);

				sCIPedestrian.request = false;
				break;

			case main_region_on_r1_PedWaiting_r1_waitOff :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				timer.unsetTimer(this, 2);

				timer.unsetTimer(this, 0);

				sCIPedestrian.request = false;
				break;

			case main_region_on_r1_StreetAttention :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				timer.unsetTimer(this, 3);
				break;

			case main_region_on_r1_StreetRed :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				timer.unsetTimer(this, 4);
				break;

			case main_region_on_r1_PedestrianGreen :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				timer.unsetTimer(this, 5);
				break;

			case main_region_on_r1_PedestrianRed :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				timer.unsetTimer(this, 6);
				break;

			case main_region_on_r1_StreetPrepare :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				timer.unsetTimer(this, 7);
				break;

			case main_region_off_r1_YellowOn :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				timer.unsetTimer(this, 8);
				break;

			case main_region_off_r1_YellowOff :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				timer.unsetTimer(this, 9);
				break;

			default :
				break;
		}

		exitAction();
	}

	protected void clearEvents() {
		sCInterface.clearEvents();

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

	/**
	 * Set the {@link ITimer} for the state machine. It must be set
	 * externally on a timed state machine before a run cycle can be correct
	 * executed.
	 * 
	 * @param timer
	 */
	public void setTimer(ITimer timer) {
		this.timer = timer;
	}

	/**
	 * Returns the currently used timer.
	 * 
	 * @return {@link ITimer}
	 */
	public ITimer getTimer() {
		return timer;
	}

	public void timeElapsed(int eventID) {
		timeEvents[eventID] = true;
	}

	public SCITrafficLight getSCITrafficLight() {
		return sCITrafficLight;
	}
	public SCIPedestrian getSCIPedestrian() {
		return sCIPedestrian;
	}
	public SCInterface getSCInterface() {
		return sCInterface;
	}

	public void raisePedestrianRequest() {
		sCInterface.raisePedestrianRequest();
	}
	public void raiseOnOff() {
		sCInterface.raiseOnOff();
	}

	/* Entry action for statechart 'TrafficLightWaiting'. */
	private void entryAction() {
	}

	/* Exit action for state 'TrafficLightWaiting'. */
	private void exitAction() {
	}

	/* The reactions of state StreetGreen. */
	private void reactMain_region_on_r1_StreetGreen() {
		if (sCInterface.onOff) {
			switch (stateVector[0]) {
				case main_region_on_r1_StreetGreen :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_on_r1_PedWaiting_r1_waitOn :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 1);

					timer.unsetTimer(this, 0);

					sCIPedestrian.request = false;
					break;

				case main_region_on_r1_PedWaiting_r1_waitOff :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 2);

					timer.unsetTimer(this, 0);

					sCIPedestrian.request = false;
					break;

				case main_region_on_r1_StreetAttention :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 3);
					break;

				case main_region_on_r1_StreetRed :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 4);
					break;

				case main_region_on_r1_PedestrianGreen :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 5);
					break;

				case main_region_on_r1_PedestrianRed :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 6);
					break;

				case main_region_on_r1_StreetPrepare :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 7);
					break;

				default :
					break;
			}

			sCITrafficLight.red = false;

			sCITrafficLight.green = false;

			sCITrafficLight.yellow = false;

			sCIPedestrian.red = false;

			sCIPedestrian.green = false;

			timer.setTimer(this, 8, 500, false);

			sCITrafficLight.yellow = true;

			sCIPedestrian.request = true;

			nextStateIndex = 0;
			stateVector[0] = State.main_region_off_r1_YellowOn;
		} else {
			if (sCInterface.pedestrianRequest) {
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				timer.setTimer(this, 0, 7 * 1000, false);

				timer.setTimer(this, 1, 500, false);

				sCIPedestrian.request = true;

				nextStateIndex = 0;
				stateVector[0] = State.main_region_on_r1_PedWaiting_r1_waitOn;
			}
		}
	}

	/* The reactions of state waitOn. */
	private void reactMain_region_on_r1_PedWaiting_r1_waitOn() {
		if (sCInterface.onOff) {
			switch (stateVector[0]) {
				case main_region_on_r1_StreetGreen :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_on_r1_PedWaiting_r1_waitOn :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 1);

					timer.unsetTimer(this, 0);

					sCIPedestrian.request = false;
					break;

				case main_region_on_r1_PedWaiting_r1_waitOff :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 2);

					timer.unsetTimer(this, 0);

					sCIPedestrian.request = false;
					break;

				case main_region_on_r1_StreetAttention :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 3);
					break;

				case main_region_on_r1_StreetRed :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 4);
					break;

				case main_region_on_r1_PedestrianGreen :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 5);
					break;

				case main_region_on_r1_PedestrianRed :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 6);
					break;

				case main_region_on_r1_StreetPrepare :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 7);
					break;

				default :
					break;
			}

			sCITrafficLight.red = false;

			sCITrafficLight.green = false;

			sCITrafficLight.yellow = false;

			sCIPedestrian.red = false;

			sCIPedestrian.green = false;

			timer.setTimer(this, 8, 500, false);

			sCITrafficLight.yellow = true;

			sCIPedestrian.request = true;

			nextStateIndex = 0;
			stateVector[0] = State.main_region_off_r1_YellowOn;
		} else {
			if (timeEvents[0]) {
				switch (stateVector[0]) {
					case main_region_on_r1_PedWaiting_r1_waitOn :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;

						timer.unsetTimer(this, 1);
						break;

					case main_region_on_r1_PedWaiting_r1_waitOff :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;

						timer.unsetTimer(this, 2);
						break;

					default :
						break;
				}

				timer.unsetTimer(this, 0);

				sCIPedestrian.request = false;

				timer.setTimer(this, 3, 2 * 1000, false);

				sCITrafficLight.red = false;

				sCITrafficLight.yellow = true;

				sCITrafficLight.green = false;

				nextStateIndex = 0;
				stateVector[0] = State.main_region_on_r1_StreetAttention;
			} else {
				if (timeEvents[1]) {
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 1);

					timer.setTimer(this, 2, 500, false);

					sCIPedestrian.request = false;

					nextStateIndex = 0;
					stateVector[0] = State.main_region_on_r1_PedWaiting_r1_waitOff;
				}
			}
		}
	}

	/* The reactions of state waitOff. */
	private void reactMain_region_on_r1_PedWaiting_r1_waitOff() {
		if (sCInterface.onOff) {
			switch (stateVector[0]) {
				case main_region_on_r1_StreetGreen :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_on_r1_PedWaiting_r1_waitOn :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 1);

					timer.unsetTimer(this, 0);

					sCIPedestrian.request = false;
					break;

				case main_region_on_r1_PedWaiting_r1_waitOff :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 2);

					timer.unsetTimer(this, 0);

					sCIPedestrian.request = false;
					break;

				case main_region_on_r1_StreetAttention :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 3);
					break;

				case main_region_on_r1_StreetRed :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 4);
					break;

				case main_region_on_r1_PedestrianGreen :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 5);
					break;

				case main_region_on_r1_PedestrianRed :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 6);
					break;

				case main_region_on_r1_StreetPrepare :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 7);
					break;

				default :
					break;
			}

			sCITrafficLight.red = false;

			sCITrafficLight.green = false;

			sCITrafficLight.yellow = false;

			sCIPedestrian.red = false;

			sCIPedestrian.green = false;

			timer.setTimer(this, 8, 500, false);

			sCITrafficLight.yellow = true;

			sCIPedestrian.request = true;

			nextStateIndex = 0;
			stateVector[0] = State.main_region_off_r1_YellowOn;
		} else {
			if (timeEvents[0]) {
				switch (stateVector[0]) {
					case main_region_on_r1_PedWaiting_r1_waitOn :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;

						timer.unsetTimer(this, 1);
						break;

					case main_region_on_r1_PedWaiting_r1_waitOff :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;

						timer.unsetTimer(this, 2);
						break;

					default :
						break;
				}

				timer.unsetTimer(this, 0);

				sCIPedestrian.request = false;

				timer.setTimer(this, 3, 2 * 1000, false);

				sCITrafficLight.red = false;

				sCITrafficLight.yellow = true;

				sCITrafficLight.green = false;

				nextStateIndex = 0;
				stateVector[0] = State.main_region_on_r1_StreetAttention;
			} else {
				if (timeEvents[2]) {
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 2);

					timer.setTimer(this, 1, 500, false);

					sCIPedestrian.request = true;

					nextStateIndex = 0;
					stateVector[0] = State.main_region_on_r1_PedWaiting_r1_waitOn;
				}
			}
		}
	}

	/* The reactions of state StreetAttention. */
	private void reactMain_region_on_r1_StreetAttention() {
		if (sCInterface.onOff) {
			switch (stateVector[0]) {
				case main_region_on_r1_StreetGreen :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_on_r1_PedWaiting_r1_waitOn :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 1);

					timer.unsetTimer(this, 0);

					sCIPedestrian.request = false;
					break;

				case main_region_on_r1_PedWaiting_r1_waitOff :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 2);

					timer.unsetTimer(this, 0);

					sCIPedestrian.request = false;
					break;

				case main_region_on_r1_StreetAttention :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 3);
					break;

				case main_region_on_r1_StreetRed :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 4);
					break;

				case main_region_on_r1_PedestrianGreen :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 5);
					break;

				case main_region_on_r1_PedestrianRed :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 6);
					break;

				case main_region_on_r1_StreetPrepare :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 7);
					break;

				default :
					break;
			}

			sCITrafficLight.red = false;

			sCITrafficLight.green = false;

			sCITrafficLight.yellow = false;

			sCIPedestrian.red = false;

			sCIPedestrian.green = false;

			timer.setTimer(this, 8, 500, false);

			sCITrafficLight.yellow = true;

			sCIPedestrian.request = true;

			nextStateIndex = 0;
			stateVector[0] = State.main_region_off_r1_YellowOn;
		} else {
			if (timeEvents[3]) {
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				timer.unsetTimer(this, 3);

				timer.setTimer(this, 4, 2 * 1000, false);

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
		if (sCInterface.onOff) {
			switch (stateVector[0]) {
				case main_region_on_r1_StreetGreen :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_on_r1_PedWaiting_r1_waitOn :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 1);

					timer.unsetTimer(this, 0);

					sCIPedestrian.request = false;
					break;

				case main_region_on_r1_PedWaiting_r1_waitOff :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 2);

					timer.unsetTimer(this, 0);

					sCIPedestrian.request = false;
					break;

				case main_region_on_r1_StreetAttention :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 3);
					break;

				case main_region_on_r1_StreetRed :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 4);
					break;

				case main_region_on_r1_PedestrianGreen :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 5);
					break;

				case main_region_on_r1_PedestrianRed :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 6);
					break;

				case main_region_on_r1_StreetPrepare :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 7);
					break;

				default :
					break;
			}

			sCITrafficLight.red = false;

			sCITrafficLight.green = false;

			sCITrafficLight.yellow = false;

			sCIPedestrian.red = false;

			sCIPedestrian.green = false;

			timer.setTimer(this, 8, 500, false);

			sCITrafficLight.yellow = true;

			sCIPedestrian.request = true;

			nextStateIndex = 0;
			stateVector[0] = State.main_region_off_r1_YellowOn;
		} else {
			if (timeEvents[4]) {
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				timer.unsetTimer(this, 4);

				timer.setTimer(this, 5, 7 * 1000, false);

				sCIPedestrian.red = false;

				sCIPedestrian.green = true;

				nextStateIndex = 0;
				stateVector[0] = State.main_region_on_r1_PedestrianGreen;
			}
		}
	}

	/* The reactions of state PedestrianGreen. */
	private void reactMain_region_on_r1_PedestrianGreen() {
		if (sCInterface.onOff) {
			switch (stateVector[0]) {
				case main_region_on_r1_StreetGreen :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_on_r1_PedWaiting_r1_waitOn :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 1);

					timer.unsetTimer(this, 0);

					sCIPedestrian.request = false;
					break;

				case main_region_on_r1_PedWaiting_r1_waitOff :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 2);

					timer.unsetTimer(this, 0);

					sCIPedestrian.request = false;
					break;

				case main_region_on_r1_StreetAttention :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 3);
					break;

				case main_region_on_r1_StreetRed :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 4);
					break;

				case main_region_on_r1_PedestrianGreen :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 5);
					break;

				case main_region_on_r1_PedestrianRed :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 6);
					break;

				case main_region_on_r1_StreetPrepare :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 7);
					break;

				default :
					break;
			}

			sCITrafficLight.red = false;

			sCITrafficLight.green = false;

			sCITrafficLight.yellow = false;

			sCIPedestrian.red = false;

			sCIPedestrian.green = false;

			timer.setTimer(this, 8, 500, false);

			sCITrafficLight.yellow = true;

			sCIPedestrian.request = true;

			nextStateIndex = 0;
			stateVector[0] = State.main_region_off_r1_YellowOn;
		} else {
			if (timeEvents[5]) {
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				timer.unsetTimer(this, 5);

				timer.setTimer(this, 6, 5 * 1000, false);

				sCIPedestrian.red = true;

				sCIPedestrian.green = false;

				nextStateIndex = 0;
				stateVector[0] = State.main_region_on_r1_PedestrianRed;
			}
		}
	}

	/* The reactions of state PedestrianRed. */
	private void reactMain_region_on_r1_PedestrianRed() {
		if (sCInterface.onOff) {
			switch (stateVector[0]) {
				case main_region_on_r1_StreetGreen :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_on_r1_PedWaiting_r1_waitOn :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 1);

					timer.unsetTimer(this, 0);

					sCIPedestrian.request = false;
					break;

				case main_region_on_r1_PedWaiting_r1_waitOff :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 2);

					timer.unsetTimer(this, 0);

					sCIPedestrian.request = false;
					break;

				case main_region_on_r1_StreetAttention :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 3);
					break;

				case main_region_on_r1_StreetRed :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 4);
					break;

				case main_region_on_r1_PedestrianGreen :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 5);
					break;

				case main_region_on_r1_PedestrianRed :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 6);
					break;

				case main_region_on_r1_StreetPrepare :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 7);
					break;

				default :
					break;
			}

			sCITrafficLight.red = false;

			sCITrafficLight.green = false;

			sCITrafficLight.yellow = false;

			sCIPedestrian.red = false;

			sCIPedestrian.green = false;

			timer.setTimer(this, 8, 500, false);

			sCITrafficLight.yellow = true;

			sCIPedestrian.request = true;

			nextStateIndex = 0;
			stateVector[0] = State.main_region_off_r1_YellowOn;
		} else {
			if (timeEvents[6]) {
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				timer.unsetTimer(this, 6);

				timer.setTimer(this, 7, 2 * 1000, false);

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
		if (sCInterface.onOff) {
			switch (stateVector[0]) {
				case main_region_on_r1_StreetGreen :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_on_r1_PedWaiting_r1_waitOn :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 1);

					timer.unsetTimer(this, 0);

					sCIPedestrian.request = false;
					break;

				case main_region_on_r1_PedWaiting_r1_waitOff :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 2);

					timer.unsetTimer(this, 0);

					sCIPedestrian.request = false;
					break;

				case main_region_on_r1_StreetAttention :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 3);
					break;

				case main_region_on_r1_StreetRed :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 4);
					break;

				case main_region_on_r1_PedestrianGreen :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 5);
					break;

				case main_region_on_r1_PedestrianRed :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 6);
					break;

				case main_region_on_r1_StreetPrepare :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 7);
					break;

				default :
					break;
			}

			sCITrafficLight.red = false;

			sCITrafficLight.green = false;

			sCITrafficLight.yellow = false;

			sCIPedestrian.red = false;

			sCIPedestrian.green = false;

			timer.setTimer(this, 8, 500, false);

			sCITrafficLight.yellow = true;

			sCIPedestrian.request = true;

			nextStateIndex = 0;
			stateVector[0] = State.main_region_off_r1_YellowOn;
		} else {
			if (timeEvents[7]) {
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				timer.unsetTimer(this, 7);

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
		if (sCInterface.onOff) {
			switch (stateVector[0]) {
				case main_region_off_r1_YellowOn :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 8);
					break;

				case main_region_off_r1_YellowOff :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 9);
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
			if (timeEvents[8]) {
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				timer.unsetTimer(this, 8);

				timer.setTimer(this, 9, 500, false);

				sCITrafficLight.yellow = false;

				sCIPedestrian.request = false;

				nextStateIndex = 0;
				stateVector[0] = State.main_region_off_r1_YellowOff;
			}
		}
	}

	/* The reactions of state YellowOff. */
	private void reactMain_region_off_r1_YellowOff() {
		if (sCInterface.onOff) {
			switch (stateVector[0]) {
				case main_region_off_r1_YellowOn :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 8);
					break;

				case main_region_off_r1_YellowOff :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 9);
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
			if (timeEvents[9]) {
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				timer.unsetTimer(this, 9);

				timer.setTimer(this, 8, 500, false);

				sCITrafficLight.yellow = true;

				sCIPedestrian.request = true;

				nextStateIndex = 0;
				stateVector[0] = State.main_region_off_r1_YellowOn;
			}
		}
	}

	public void runCycle() {

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
