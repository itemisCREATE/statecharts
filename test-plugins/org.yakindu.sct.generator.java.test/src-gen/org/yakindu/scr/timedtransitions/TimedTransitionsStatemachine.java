package org.yakindu.scr.timedtransitions;
import org.yakindu.scr.ITimer;

public class TimedTransitionsStatemachine implements ITimedTransitionsStatemachine {

	private boolean initialized = false;

	public enum State {
		main_region_Start, main_region_End, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	private ITimer timer;

	private final boolean[] timeEvents = new boolean[1];

	public TimedTransitionsStatemachine() {

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

	}

	public void enter() {
		if (!initialized)
			throw new IllegalStateException(
					"The statemachine needs to be initialized first by calling the init() function.");

		if (timer == null) {
			throw new IllegalStateException("timer not set.");
		}
		entryAction();

		enterSequence_main_region_default();
	}

	public void exit() {
		initialized = false;
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
			case main_region_Start :
				return stateVector[0] == State.main_region_Start;
			case main_region_End :
				return stateVector[0] == State.main_region_End;
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

	private boolean check_main_region_Start_tr0_tr0() {
		return timeEvents[0];
	}

	private void effect_main_region_Start_tr0() {
		exitSequence_main_region_Start();

		enterSequence_main_region_End_default();
	}

	/* Entry action for statechart 'TimedTransitions'. */
	private void entryAction() {
	}

	/* Entry action for state 'Start'. */
	private void entryAction_main_region_Start() {

		timer.setTimer(this, 0, 2 * 1000, false);
	}

	/* Exit action for state 'TimedTransitions'. */
	private void exitAction() {
	}

	/* Exit action for state 'Start'. */
	private void exitAction_main_region_Start() {
		timer.unsetTimer(this, 0);
	}

	/* 'default' enter sequence for state Start */
	private void enterSequence_main_region_Start_default() {
		entryAction_main_region_Start();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_Start;
	}

	/* 'default' enter sequence for state End */
	private void enterSequence_main_region_End_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_End;
	}

	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}

	/* Default exit sequence for state Start */
	private void exitSequence_main_region_Start() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		exitAction_main_region_Start();
	}

	/* Default exit sequence for state End */
	private void exitSequence_main_region_End() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
			case main_region_Start :
				exitSequence_main_region_Start();
				break;

			case main_region_End :
				exitSequence_main_region_End();
				break;

			default :
				break;
		}
	}

	/* The reactions of state Start. */
	private void react_main_region_Start() {
		if (check_main_region_Start_tr0_tr0()) {
			effect_main_region_Start_tr0();
		}
	}

	/* The reactions of state End. */
	private void react_main_region_End() {
	}

	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_Start_default();
	}

	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The statemachine needs to be initialized first by calling the init() function.");

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_Start :
					react_main_region_Start();
					break;
				case main_region_End :
					react_main_region_End();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
