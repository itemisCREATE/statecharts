package org.yakindu.scr.timedtransitions;
import org.yakindu.scr.ITimer;

public class TimedTransitionsStatemachine
		implements
			ITimedTransitionsStatemachine {

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

		timer.setTimer(this, 0, 2 * 1000, false);

		nextStateIndex = 0;
		stateVector[0] = State.main_region_Start;
	}

	public void exit() {
		switch (stateVector[0]) {
			case main_region_Start :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				timer.unsetTimer(this, 0);
				break;

			case main_region_End :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			default :
				break;
		}

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

	/* Entry action for statechart 'TimedTransitions'. */
	private void entryAction() {
	}

	/* Exit action for state 'TimedTransitions'. */
	private void exitAction() {
	}

	/* The reactions of state Start. */
	private void reactMain_region_Start() {
		if (timeEvents[0]) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			timer.unsetTimer(this, 0);

			nextStateIndex = 0;
			stateVector[0] = State.main_region_End;
		}
	}

	/* The reactions of state End. */
	private void reactMain_region_End() {
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
