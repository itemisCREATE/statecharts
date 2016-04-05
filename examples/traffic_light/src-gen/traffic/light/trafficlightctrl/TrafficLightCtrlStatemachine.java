/** Copyright (c) 2012-2015 committers of YAKINDU and others.
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html

Contributors:
    committers of YAKINDU - initial API and implementation
� */
package traffic.light.trafficlightctrl;
import traffic.light.ITimer;

public class TrafficLightCtrlStatemachine implements ITrafficLightCtrlStatemachine {

	protected class SCITrafficLightImpl implements SCITrafficLight {

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

	protected SCITrafficLightImpl sCITrafficLight;

	protected class SCIPedestrianImpl implements SCIPedestrian {

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

	protected SCIPedestrianImpl sCIPedestrian;

	protected class SCInterfaceImpl implements SCInterface {

		private SCInterfaceOperationCallback operationCallback;

		public void setSCInterfaceOperationCallback(SCInterfaceOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}

		private boolean pedestrianRequest;

		public void raisePedestrianRequest() {
			pedestrianRequest = true;
		}

		private boolean onOff;

		public void raiseOnOff() {
			onOff = true;
		}

		protected void clearEvents() {
			pedestrianRequest = false;
			onOff = false;
		}

	}

	protected SCInterfaceImpl sCInterface;

	private boolean initialized = false;

	public enum State {
		main_region_on, main_region_on_r1_StreetGreen, main_region_on_r1_PedWaiting, main_region_on_r1_PedWaiting_r1_waitOn, main_region_on_r1_PedWaiting_r1_waitOff, main_region_on_r1_StreetAttention, main_region_on_r1_StreetRed, main_region_on_r1_PedestrianGreen, main_region_on_r1_PedestrianRed, main_region_on_r1_StreetPrepare, main_region_on_r1_Safe, main_region_off, main_region_off_r1_YellowOn, main_region_off_r1_YellowOff, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	private ITimer timer;

	private final boolean[] timeEvents = new boolean[12];

	public TrafficLightCtrlStatemachine() {

		sCITrafficLight = new SCITrafficLightImpl();
		sCIPedestrian = new SCIPedestrianImpl();
		sCInterface = new SCInterfaceImpl();
	}

	public void init() {
		this.initialized = true;
		if (timer == null) {
			throw new IllegalStateException("timer not set.");
		}
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCITrafficLight.setRed(false);

		sCITrafficLight.setYellow(false);

		sCITrafficLight.setGreen(false);

		sCIPedestrian.setRequest(false);

		sCIPedestrian.setRed(false);

		sCIPedestrian.setGreen(false);
	}

	public void enter() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");

		if (timer == null) {
			throw new IllegalStateException("timer not set.");
		}
		entryAction();

		enterSequence_main_region_default();
	}

	public void exit() {
		exitSequence_main_region();

		exitAction();
	}

	/**
	 * @see IStatemachine#isActive()
	 */
	public boolean isActive() {

		return stateVector[0] != State.$NullState$;
	}

	/** 
	* Always returns 'false' since this state machine can never become final.
	*
	 * @see IStatemachine#isFinal()
	 */
	public boolean isFinal() {
		return false;
	}

	/**
	* This method resets the incoming events (time events included).
	*/
	protected void clearEvents() {
		sCInterface.clearEvents();

		for (int i = 0; i < timeEvents.length; i++) {
			timeEvents[i] = false;
		}
	}

	/**
	* This method resets the outgoing events.
	*/
	protected void clearOutEvents() {
	}

	/**
	* Returns true if the given state is currently active otherwise false.
	*/
	public boolean isStateActive(State state) {
		switch (state) {
			case main_region_on :
				return stateVector[0].ordinal() >= State.main_region_on.ordinal()
						&& stateVector[0].ordinal() <= State.main_region_on_r1_Safe.ordinal();
			case main_region_on_r1_StreetGreen :
				return stateVector[0] == State.main_region_on_r1_StreetGreen;
			case main_region_on_r1_PedWaiting :
				return stateVector[0].ordinal() >= State.main_region_on_r1_PedWaiting.ordinal()
						&& stateVector[0].ordinal() <= State.main_region_on_r1_PedWaiting_r1_waitOff.ordinal();
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
			case main_region_on_r1_Safe :
				return stateVector[0] == State.main_region_on_r1_Safe;
			case main_region_off :
				return stateVector[0].ordinal() >= State.main_region_off.ordinal()
						&& stateVector[0].ordinal() <= State.main_region_off_r1_YellowOff.ordinal();
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

	private boolean check__lr0() {
		return timeEvents[11];
	}

	private boolean check_main_region_on_tr0_tr0() {
		return sCInterface.onOff;
	}

	private boolean check_main_region_on_r1_StreetGreen_tr0_tr0() {
		return sCInterface.pedestrianRequest;
	}

	private boolean check_main_region_on_r1_PedWaiting_tr0_tr0() {
		return timeEvents[0];
	}

	private boolean check_main_region_on_r1_PedWaiting_r1_waitOn_tr0_tr0() {
		return timeEvents[1];
	}

	private boolean check_main_region_on_r1_PedWaiting_r1_waitOff_tr0_tr0() {
		return timeEvents[2];
	}

	private boolean check_main_region_on_r1_StreetAttention_tr0_tr0() {
		return timeEvents[3];
	}

	private boolean check_main_region_on_r1_StreetRed_tr0_tr0() {
		return timeEvents[4];
	}

	private boolean check_main_region_on_r1_PedestrianGreen_tr0_tr0() {
		return timeEvents[5];
	}

	private boolean check_main_region_on_r1_PedestrianRed_tr0_tr0() {
		return timeEvents[6];
	}

	private boolean check_main_region_on_r1_StreetPrepare_tr0_tr0() {
		return timeEvents[7];
	}

	private boolean check_main_region_on_r1_Safe_tr0_tr0() {
		return timeEvents[8];
	}

	private boolean check_main_region_off_tr0_tr0() {
		return sCInterface.onOff;
	}

	private boolean check_main_region_off_r1_YellowOn_tr0_tr0() {
		return timeEvents[9];
	}

	private boolean check_main_region_off_r1_YellowOff_tr0_tr0() {
		return timeEvents[10];
	}

	private void effect__lr0() {
		sCInterface.operationCallback.synchronize();
	}

	private void effect_main_region_on_tr0() {
		exitSequence_main_region_on();

		enterSequence_main_region_off_default();
	}

	private void effect_main_region_on_r1_StreetGreen_tr0() {
		exitSequence_main_region_on_r1_StreetGreen();

		enterSequence_main_region_on_r1_PedWaiting_default();
	}

	private void effect_main_region_on_r1_PedWaiting_tr0() {
		exitSequence_main_region_on_r1_PedWaiting();

		enterSequence_main_region_on_r1_StreetAttention_default();
	}

	private void effect_main_region_on_r1_PedWaiting_r1_waitOn_tr0() {
		exitSequence_main_region_on_r1_PedWaiting_r1_waitOn();

		enterSequence_main_region_on_r1_PedWaiting_r1_waitOff_default();
	}

	private void effect_main_region_on_r1_PedWaiting_r1_waitOff_tr0() {
		exitSequence_main_region_on_r1_PedWaiting_r1_waitOff();

		enterSequence_main_region_on_r1_PedWaiting_r1_waitOn_default();
	}

	private void effect_main_region_on_r1_StreetAttention_tr0() {
		exitSequence_main_region_on_r1_StreetAttention();

		enterSequence_main_region_on_r1_StreetRed_default();
	}

	private void effect_main_region_on_r1_StreetRed_tr0() {
		exitSequence_main_region_on_r1_StreetRed();

		enterSequence_main_region_on_r1_PedestrianGreen_default();
	}

	private void effect_main_region_on_r1_PedestrianGreen_tr0() {
		exitSequence_main_region_on_r1_PedestrianGreen();

		enterSequence_main_region_on_r1_PedestrianRed_default();
	}

	private void effect_main_region_on_r1_PedestrianRed_tr0() {
		exitSequence_main_region_on_r1_PedestrianRed();

		enterSequence_main_region_on_r1_StreetPrepare_default();
	}

	private void effect_main_region_on_r1_StreetPrepare_tr0() {
		exitSequence_main_region_on_r1_StreetPrepare();

		enterSequence_main_region_on_r1_StreetGreen_default();
	}

	private void effect_main_region_on_r1_Safe_tr0() {
		exitSequence_main_region_on_r1_Safe();

		enterSequence_main_region_on_r1_StreetPrepare_default();
	}

	private void effect_main_region_off_tr0() {
		exitSequence_main_region_off();

		enterSequence_main_region_on_default();
	}

	private void effect_main_region_off_r1_YellowOn_tr0() {
		exitSequence_main_region_off_r1_YellowOn();

		enterSequence_main_region_off_r1_YellowOff_default();
	}

	private void effect_main_region_off_r1_YellowOff_tr0() {
		exitSequence_main_region_off_r1_YellowOff();

		enterSequence_main_region_off_r1_YellowOn_default();
	}

	/* Entry action for statechart 'TrafficLightCtrl'. */
	private void entryAction() {

		timer.setTimer(this, 11, 200, true);
	}

	/* Entry action for state 'StreetGreen'. */
	private void entryAction_main_region_on_r1_StreetGreen() {
		sCITrafficLight.setRed(false);

		sCITrafficLight.setYellow(false);

		sCITrafficLight.setGreen(true);

		sCIPedestrian.setRed(true);

		sCIPedestrian.setGreen(false);

		sCIPedestrian.setRequest(false);
	}

	/* Entry action for state 'PedWaiting'. */
	private void entryAction_main_region_on_r1_PedWaiting() {

		timer.setTimer(this, 0, 7 * 1000, false);
	}

	/* Entry action for state 'waitOn'. */
	private void entryAction_main_region_on_r1_PedWaiting_r1_waitOn() {

		timer.setTimer(this, 1, 500, false);

		sCIPedestrian.setRequest(true);
	}

	/* Entry action for state 'waitOff'. */
	private void entryAction_main_region_on_r1_PedWaiting_r1_waitOff() {

		timer.setTimer(this, 2, 500, false);

		sCIPedestrian.setRequest(false);
	}

	/* Entry action for state 'StreetAttention'. */
	private void entryAction_main_region_on_r1_StreetAttention() {

		timer.setTimer(this, 3, 2 * 1000, false);

		sCITrafficLight.setRed(false);

		sCITrafficLight.setYellow(true);

		sCITrafficLight.setGreen(false);
	}

	/* Entry action for state 'StreetRed'. */
	private void entryAction_main_region_on_r1_StreetRed() {

		timer.setTimer(this, 4, 2 * 1000, false);

		sCITrafficLight.setRed(true);

		sCITrafficLight.setYellow(false);

		sCITrafficLight.setGreen(false);
	}

	/* Entry action for state 'PedestrianGreen'. */
	private void entryAction_main_region_on_r1_PedestrianGreen() {

		timer.setTimer(this, 5, 7 * 1000, false);

		sCIPedestrian.setRed(false);

		sCIPedestrian.setGreen(true);
	}

	/* Entry action for state 'PedestrianRed'. */
	private void entryAction_main_region_on_r1_PedestrianRed() {

		timer.setTimer(this, 6, 5 * 1000, false);

		sCIPedestrian.setRed(true);

		sCIPedestrian.setGreen(false);
	}

	/* Entry action for state 'StreetPrepare'. */
	private void entryAction_main_region_on_r1_StreetPrepare() {

		timer.setTimer(this, 7, 2 * 1000, false);

		sCITrafficLight.setRed(true);

		sCITrafficLight.setYellow(true);

		sCITrafficLight.setGreen(false);
	}

	/* Entry action for state 'Safe'. */
	private void entryAction_main_region_on_r1_Safe() {

		timer.setTimer(this, 8, 10 * 1000, false);

		sCITrafficLight.setRed(true);

		sCITrafficLight.setYellow(false);

		sCITrafficLight.setGreen(false);

		sCIPedestrian.setRed(true);

		sCIPedestrian.setGreen(false);

		sCIPedestrian.setRequest(false);
	}

	/* Entry action for state 'off'. */
	private void entryAction_main_region_off() {
		sCITrafficLight.setRed(false);

		sCITrafficLight.setGreen(false);

		sCITrafficLight.setYellow(false);

		sCIPedestrian.setRed(false);

		sCIPedestrian.setGreen(false);
	}

	/* Entry action for state 'YellowOn'. */
	private void entryAction_main_region_off_r1_YellowOn() {

		timer.setTimer(this, 9, 500, false);

		sCITrafficLight.setYellow(true);

		sCIPedestrian.setRequest(true);
	}

	/* Entry action for state 'YellowOff'. */
	private void entryAction_main_region_off_r1_YellowOff() {

		timer.setTimer(this, 10, 500, false);

		sCITrafficLight.setYellow(false);

		sCIPedestrian.setRequest(false);
	}

	/* Exit action for state 'TrafficLightCtrl'. */
	private void exitAction() {
		timer.unsetTimer(this, 11);
	}

	/* Exit action for state 'PedWaiting'. */
	private void exitAction_main_region_on_r1_PedWaiting() {
		timer.unsetTimer(this, 0);

		sCIPedestrian.setRequest(false);
	}

	/* Exit action for state 'waitOn'. */
	private void exitAction_main_region_on_r1_PedWaiting_r1_waitOn() {
		timer.unsetTimer(this, 1);
	}

	/* Exit action for state 'waitOff'. */
	private void exitAction_main_region_on_r1_PedWaiting_r1_waitOff() {
		timer.unsetTimer(this, 2);
	}

	/* Exit action for state 'StreetAttention'. */
	private void exitAction_main_region_on_r1_StreetAttention() {
		timer.unsetTimer(this, 3);
	}

	/* Exit action for state 'StreetRed'. */
	private void exitAction_main_region_on_r1_StreetRed() {
		timer.unsetTimer(this, 4);
	}

	/* Exit action for state 'PedestrianGreen'. */
	private void exitAction_main_region_on_r1_PedestrianGreen() {
		timer.unsetTimer(this, 5);
	}

	/* Exit action for state 'PedestrianRed'. */
	private void exitAction_main_region_on_r1_PedestrianRed() {
		timer.unsetTimer(this, 6);
	}

	/* Exit action for state 'StreetPrepare'. */
	private void exitAction_main_region_on_r1_StreetPrepare() {
		timer.unsetTimer(this, 7);
	}

	/* Exit action for state 'Safe'. */
	private void exitAction_main_region_on_r1_Safe() {
		timer.unsetTimer(this, 8);
	}

	/* Exit action for state 'YellowOn'. */
	private void exitAction_main_region_off_r1_YellowOn() {
		timer.unsetTimer(this, 9);
	}

	/* Exit action for state 'YellowOff'. */
	private void exitAction_main_region_off_r1_YellowOff() {
		timer.unsetTimer(this, 10);
	}

	/* 'default' enter sequence for state on */
	private void enterSequence_main_region_on_default() {
		enterSequence_main_region_on_r1_default();
	}

	/* 'default' enter sequence for state StreetGreen */
	private void enterSequence_main_region_on_r1_StreetGreen_default() {
		entryAction_main_region_on_r1_StreetGreen();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_on_r1_StreetGreen;
	}

	/* 'default' enter sequence for state PedWaiting */
	private void enterSequence_main_region_on_r1_PedWaiting_default() {
		entryAction_main_region_on_r1_PedWaiting();

		enterSequence_main_region_on_r1_PedWaiting_r1_default();
	}

	/* 'default' enter sequence for state waitOn */
	private void enterSequence_main_region_on_r1_PedWaiting_r1_waitOn_default() {
		entryAction_main_region_on_r1_PedWaiting_r1_waitOn();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_on_r1_PedWaiting_r1_waitOn;
	}

	/* 'default' enter sequence for state waitOff */
	private void enterSequence_main_region_on_r1_PedWaiting_r1_waitOff_default() {
		entryAction_main_region_on_r1_PedWaiting_r1_waitOff();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_on_r1_PedWaiting_r1_waitOff;
	}

	/* 'default' enter sequence for state StreetAttention */
	private void enterSequence_main_region_on_r1_StreetAttention_default() {
		entryAction_main_region_on_r1_StreetAttention();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_on_r1_StreetAttention;
	}

	/* 'default' enter sequence for state StreetRed */
	private void enterSequence_main_region_on_r1_StreetRed_default() {
		entryAction_main_region_on_r1_StreetRed();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_on_r1_StreetRed;
	}

	/* 'default' enter sequence for state PedestrianGreen */
	private void enterSequence_main_region_on_r1_PedestrianGreen_default() {
		entryAction_main_region_on_r1_PedestrianGreen();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_on_r1_PedestrianGreen;
	}

	/* 'default' enter sequence for state PedestrianRed */
	private void enterSequence_main_region_on_r1_PedestrianRed_default() {
		entryAction_main_region_on_r1_PedestrianRed();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_on_r1_PedestrianRed;
	}

	/* 'default' enter sequence for state StreetPrepare */
	private void enterSequence_main_region_on_r1_StreetPrepare_default() {
		entryAction_main_region_on_r1_StreetPrepare();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_on_r1_StreetPrepare;
	}

	/* 'default' enter sequence for state Safe */
	private void enterSequence_main_region_on_r1_Safe_default() {
		entryAction_main_region_on_r1_Safe();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_on_r1_Safe;
	}

	/* 'default' enter sequence for state off */
	private void enterSequence_main_region_off_default() {
		entryAction_main_region_off();

		enterSequence_main_region_off_r1_default();
	}

	/* 'default' enter sequence for state YellowOn */
	private void enterSequence_main_region_off_r1_YellowOn_default() {
		entryAction_main_region_off_r1_YellowOn();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_off_r1_YellowOn;
	}

	/* 'default' enter sequence for state YellowOff */
	private void enterSequence_main_region_off_r1_YellowOff_default() {
		entryAction_main_region_off_r1_YellowOff();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_off_r1_YellowOff;
	}

	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}

	/* 'default' enter sequence for region r1 */
	private void enterSequence_main_region_on_r1_default() {
		react_main_region_on_r1__entry_Default();
	}

	/* 'default' enter sequence for region r1 */
	private void enterSequence_main_region_on_r1_PedWaiting_r1_default() {
		react_main_region_on_r1_PedWaiting_r1__entry_Default();
	}

	/* 'default' enter sequence for region r1 */
	private void enterSequence_main_region_off_r1_default() {
		react_main_region_off_r1__entry_Default();
	}

	/* Default exit sequence for state on */
	private void exitSequence_main_region_on() {
		exitSequence_main_region_on_r1();
	}

	/* Default exit sequence for state StreetGreen */
	private void exitSequence_main_region_on_r1_StreetGreen() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state PedWaiting */
	private void exitSequence_main_region_on_r1_PedWaiting() {
		exitSequence_main_region_on_r1_PedWaiting_r1();

		exitAction_main_region_on_r1_PedWaiting();
	}

	/* Default exit sequence for state waitOn */
	private void exitSequence_main_region_on_r1_PedWaiting_r1_waitOn() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		exitAction_main_region_on_r1_PedWaiting_r1_waitOn();
	}

	/* Default exit sequence for state waitOff */
	private void exitSequence_main_region_on_r1_PedWaiting_r1_waitOff() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		exitAction_main_region_on_r1_PedWaiting_r1_waitOff();
	}

	/* Default exit sequence for state StreetAttention */
	private void exitSequence_main_region_on_r1_StreetAttention() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		exitAction_main_region_on_r1_StreetAttention();
	}

	/* Default exit sequence for state StreetRed */
	private void exitSequence_main_region_on_r1_StreetRed() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		exitAction_main_region_on_r1_StreetRed();
	}

	/* Default exit sequence for state PedestrianGreen */
	private void exitSequence_main_region_on_r1_PedestrianGreen() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		exitAction_main_region_on_r1_PedestrianGreen();
	}

	/* Default exit sequence for state PedestrianRed */
	private void exitSequence_main_region_on_r1_PedestrianRed() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		exitAction_main_region_on_r1_PedestrianRed();
	}

	/* Default exit sequence for state StreetPrepare */
	private void exitSequence_main_region_on_r1_StreetPrepare() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		exitAction_main_region_on_r1_StreetPrepare();
	}

	/* Default exit sequence for state Safe */
	private void exitSequence_main_region_on_r1_Safe() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		exitAction_main_region_on_r1_Safe();
	}

	/* Default exit sequence for state off */
	private void exitSequence_main_region_off() {
		exitSequence_main_region_off_r1();
	}

	/* Default exit sequence for state YellowOn */
	private void exitSequence_main_region_off_r1_YellowOn() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		exitAction_main_region_off_r1_YellowOn();
	}

	/* Default exit sequence for state YellowOff */
	private void exitSequence_main_region_off_r1_YellowOff() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		exitAction_main_region_off_r1_YellowOff();
	}

	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
			case main_region_on_r1_StreetGreen :
				exitSequence_main_region_on_r1_StreetGreen();
				break;

			case main_region_on_r1_PedWaiting_r1_waitOn :
				exitSequence_main_region_on_r1_PedWaiting_r1_waitOn();

				exitAction_main_region_on_r1_PedWaiting();
				break;

			case main_region_on_r1_PedWaiting_r1_waitOff :
				exitSequence_main_region_on_r1_PedWaiting_r1_waitOff();

				exitAction_main_region_on_r1_PedWaiting();
				break;

			case main_region_on_r1_StreetAttention :
				exitSequence_main_region_on_r1_StreetAttention();
				break;

			case main_region_on_r1_StreetRed :
				exitSequence_main_region_on_r1_StreetRed();
				break;

			case main_region_on_r1_PedestrianGreen :
				exitSequence_main_region_on_r1_PedestrianGreen();
				break;

			case main_region_on_r1_PedestrianRed :
				exitSequence_main_region_on_r1_PedestrianRed();
				break;

			case main_region_on_r1_StreetPrepare :
				exitSequence_main_region_on_r1_StreetPrepare();
				break;

			case main_region_on_r1_Safe :
				exitSequence_main_region_on_r1_Safe();
				break;

			case main_region_off_r1_YellowOn :
				exitSequence_main_region_off_r1_YellowOn();
				break;

			case main_region_off_r1_YellowOff :
				exitSequence_main_region_off_r1_YellowOff();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region r1 */
	private void exitSequence_main_region_on_r1() {
		switch (stateVector[0]) {
			case main_region_on_r1_StreetGreen :
				exitSequence_main_region_on_r1_StreetGreen();
				break;

			case main_region_on_r1_PedWaiting_r1_waitOn :
				exitSequence_main_region_on_r1_PedWaiting_r1_waitOn();

				exitAction_main_region_on_r1_PedWaiting();
				break;

			case main_region_on_r1_PedWaiting_r1_waitOff :
				exitSequence_main_region_on_r1_PedWaiting_r1_waitOff();

				exitAction_main_region_on_r1_PedWaiting();
				break;

			case main_region_on_r1_StreetAttention :
				exitSequence_main_region_on_r1_StreetAttention();
				break;

			case main_region_on_r1_StreetRed :
				exitSequence_main_region_on_r1_StreetRed();
				break;

			case main_region_on_r1_PedestrianGreen :
				exitSequence_main_region_on_r1_PedestrianGreen();
				break;

			case main_region_on_r1_PedestrianRed :
				exitSequence_main_region_on_r1_PedestrianRed();
				break;

			case main_region_on_r1_StreetPrepare :
				exitSequence_main_region_on_r1_StreetPrepare();
				break;

			case main_region_on_r1_Safe :
				exitSequence_main_region_on_r1_Safe();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region r1 */
	private void exitSequence_main_region_on_r1_PedWaiting_r1() {
		switch (stateVector[0]) {
			case main_region_on_r1_PedWaiting_r1_waitOn :
				exitSequence_main_region_on_r1_PedWaiting_r1_waitOn();
				break;

			case main_region_on_r1_PedWaiting_r1_waitOff :
				exitSequence_main_region_on_r1_PedWaiting_r1_waitOff();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region r1 */
	private void exitSequence_main_region_off_r1() {
		switch (stateVector[0]) {
			case main_region_off_r1_YellowOn :
				exitSequence_main_region_off_r1_YellowOn();
				break;

			case main_region_off_r1_YellowOff :
				exitSequence_main_region_off_r1_YellowOff();
				break;

			default :
				break;
		}
	}

	/* The reactions of state StreetGreen. */
	private void react_main_region_on_r1_StreetGreen() {
		if (check__lr0()) {
			effect__lr0();
		}

		if (check_main_region_on_tr0_tr0()) {
			effect_main_region_on_tr0();
		} else {
			if (check_main_region_on_r1_StreetGreen_tr0_tr0()) {
				effect_main_region_on_r1_StreetGreen_tr0();
			}
		}
	}

	/* The reactions of state waitOn. */
	private void react_main_region_on_r1_PedWaiting_r1_waitOn() {
		if (check__lr0()) {
			effect__lr0();
		}

		if (check_main_region_on_tr0_tr0()) {
			effect_main_region_on_tr0();
		} else {
			if (check_main_region_on_r1_PedWaiting_tr0_tr0()) {
				effect_main_region_on_r1_PedWaiting_tr0();
			} else {
				if (check_main_region_on_r1_PedWaiting_r1_waitOn_tr0_tr0()) {
					effect_main_region_on_r1_PedWaiting_r1_waitOn_tr0();
				}
			}
		}
	}

	/* The reactions of state waitOff. */
	private void react_main_region_on_r1_PedWaiting_r1_waitOff() {
		if (check__lr0()) {
			effect__lr0();
		}

		if (check_main_region_on_tr0_tr0()) {
			effect_main_region_on_tr0();
		} else {
			if (check_main_region_on_r1_PedWaiting_tr0_tr0()) {
				effect_main_region_on_r1_PedWaiting_tr0();
			} else {
				if (check_main_region_on_r1_PedWaiting_r1_waitOff_tr0_tr0()) {
					effect_main_region_on_r1_PedWaiting_r1_waitOff_tr0();
				}
			}
		}
	}

	/* The reactions of state StreetAttention. */
	private void react_main_region_on_r1_StreetAttention() {
		if (check__lr0()) {
			effect__lr0();
		}

		if (check_main_region_on_tr0_tr0()) {
			effect_main_region_on_tr0();
		} else {
			if (check_main_region_on_r1_StreetAttention_tr0_tr0()) {
				effect_main_region_on_r1_StreetAttention_tr0();
			}
		}
	}

	/* The reactions of state StreetRed. */
	private void react_main_region_on_r1_StreetRed() {
		if (check__lr0()) {
			effect__lr0();
		}

		if (check_main_region_on_tr0_tr0()) {
			effect_main_region_on_tr0();
		} else {
			if (check_main_region_on_r1_StreetRed_tr0_tr0()) {
				effect_main_region_on_r1_StreetRed_tr0();
			}
		}
	}

	/* The reactions of state PedestrianGreen. */
	private void react_main_region_on_r1_PedestrianGreen() {
		if (check__lr0()) {
			effect__lr0();
		}

		if (check_main_region_on_tr0_tr0()) {
			effect_main_region_on_tr0();
		} else {
			if (check_main_region_on_r1_PedestrianGreen_tr0_tr0()) {
				effect_main_region_on_r1_PedestrianGreen_tr0();
			}
		}
	}

	/* The reactions of state PedestrianRed. */
	private void react_main_region_on_r1_PedestrianRed() {
		if (check__lr0()) {
			effect__lr0();
		}

		if (check_main_region_on_tr0_tr0()) {
			effect_main_region_on_tr0();
		} else {
			if (check_main_region_on_r1_PedestrianRed_tr0_tr0()) {
				effect_main_region_on_r1_PedestrianRed_tr0();
			}
		}
	}

	/* The reactions of state StreetPrepare. */
	private void react_main_region_on_r1_StreetPrepare() {
		if (check__lr0()) {
			effect__lr0();
		}

		if (check_main_region_on_tr0_tr0()) {
			effect_main_region_on_tr0();
		} else {
			if (check_main_region_on_r1_StreetPrepare_tr0_tr0()) {
				effect_main_region_on_r1_StreetPrepare_tr0();
			}
		}
	}

	/* The reactions of state Safe. */
	private void react_main_region_on_r1_Safe() {
		if (check__lr0()) {
			effect__lr0();
		}

		if (check_main_region_on_tr0_tr0()) {
			effect_main_region_on_tr0();
		} else {
			if (check_main_region_on_r1_Safe_tr0_tr0()) {
				effect_main_region_on_r1_Safe_tr0();
			}
		}
	}

	/* The reactions of state YellowOn. */
	private void react_main_region_off_r1_YellowOn() {
		if (check__lr0()) {
			effect__lr0();
		}

		if (check_main_region_off_tr0_tr0()) {
			effect_main_region_off_tr0();
		} else {
			if (check_main_region_off_r1_YellowOn_tr0_tr0()) {
				effect_main_region_off_r1_YellowOn_tr0();
			}
		}
	}

	/* The reactions of state YellowOff. */
	private void react_main_region_off_r1_YellowOff() {
		if (check__lr0()) {
			effect__lr0();
		}

		if (check_main_region_off_tr0_tr0()) {
			effect_main_region_off_tr0();
		} else {
			if (check_main_region_off_r1_YellowOff_tr0_tr0()) {
				effect_main_region_off_r1_YellowOff_tr0();
			}
		}
	}

	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_off_default();
	}

	/* Default react sequence for initial entry  */
	private void react_main_region_on_r1_PedWaiting_r1__entry_Default() {
		enterSequence_main_region_on_r1_PedWaiting_r1_waitOn_default();
	}

	/* Default react sequence for initial entry  */
	private void react_main_region_on_r1__entry_Default() {
		enterSequence_main_region_on_r1_Safe_default();
	}

	/* Default react sequence for initial entry  */
	private void react_main_region_off_r1__entry_Default() {
		enterSequence_main_region_off_r1_YellowOn_default();
	}

	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_on_r1_StreetGreen :
					react_main_region_on_r1_StreetGreen();
					break;
				case main_region_on_r1_PedWaiting_r1_waitOn :
					react_main_region_on_r1_PedWaiting_r1_waitOn();
					break;
				case main_region_on_r1_PedWaiting_r1_waitOff :
					react_main_region_on_r1_PedWaiting_r1_waitOff();
					break;
				case main_region_on_r1_StreetAttention :
					react_main_region_on_r1_StreetAttention();
					break;
				case main_region_on_r1_StreetRed :
					react_main_region_on_r1_StreetRed();
					break;
				case main_region_on_r1_PedestrianGreen :
					react_main_region_on_r1_PedestrianGreen();
					break;
				case main_region_on_r1_PedestrianRed :
					react_main_region_on_r1_PedestrianRed();
					break;
				case main_region_on_r1_StreetPrepare :
					react_main_region_on_r1_StreetPrepare();
					break;
				case main_region_on_r1_Safe :
					react_main_region_on_r1_Safe();
					break;
				case main_region_off_r1_YellowOn :
					react_main_region_off_r1_YellowOn();
					break;
				case main_region_off_r1_YellowOff :
					react_main_region_off_r1_YellowOff();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
