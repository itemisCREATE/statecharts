package org.yakindu.scr.timedtransitions;
import org.yakindu.scr.ITimer;

public class TimedTransitionsStatemachine
		implements
			ITimedTransitionsStatemachine {

	static {
	}

	private final boolean[] timeEvents = new boolean[1];

	public enum State {
		main_region_Start, main_region_End, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	private ITimer timer;

	public TimedTransitionsStatemachine() {

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

	}

	public void enter() {
		if (timer == null) {
			throw new IllegalStateException("timer not set.");
		}
		entryAction();

		enterSequenceMain_region();
	}

	public void exit() {
		exitSequenceMain_region();

		exitAction();
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

	private boolean checkMain_region_StartTr0() {
		return timeEvents[0];
	}

	private void effectMain_region_StartTr0() {
		exitSequenceMain_region_Start();

		enterSequenceMain_region_End();
	}

	/* Entry action for statechart 'TimedTransitions'. */
	private void entryAction() {
	}

	/* Entry action for state 'Start'. */
	private void entryActionMain_region_Start() {

		timer.setTimer(this, 0, 2 * 1000, false);
	}

	/* Exit action for state 'TimedTransitions'. */
	private void exitAction() {
	}

	/* Exit action for state 'Start'. */
	private void exitActionMain_region_Start() {
		timer.unsetTimer(this, 0);
	}

	/* 'default' enter sequence for state Start */
	private void enterSequenceMain_region_Start() {
		entryActionMain_region_Start();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_Start;
	}

	/* 'default' enter sequence for state End */
	private void enterSequenceMain_region_End() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_End;
	}

	/* 'default' enter sequence for region main region */
	private void enterSequenceMain_region() {
		reactTimedTransitions_main_region__entry_Default();
	}

	/* Default exit sequence for state Start */
	private void exitSequenceMain_region_Start() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		exitActionMain_region_Start();
	}

	/* Default exit sequence for state End */
	private void exitSequenceMain_region_End() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for region main region */
	private void exitSequenceMain_region() {
		switch (stateVector[0]) {
			case main_region_Start :
				exitSequenceMain_region_Start();
				break;

			case main_region_End :
				exitSequenceMain_region_End();
				break;

			default :
				break;
		}
	}

	/* The reactions of state Start. */
	private void reactMain_region_Start() {
		if (checkMain_region_StartTr0()) {
			effectMain_region_StartTr0();
		}
	}

	/* The reactions of state End. */
	private void reactMain_region_End() {
	}

	/* Default react sequence for initial entry  */
	private void reactTimedTransitions_main_region__entry_Default() {
		enterSequenceMain_region_Start();
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_Start :
					reactMain_region_Start();
					break;
				case main_region_End :
					reactMain_region_End();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
