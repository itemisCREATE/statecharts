package org.yakindu.scr.statechartactive;


public class StatechartActiveStatemachine implements IStatechartActiveStatemachine {
	private boolean initialized = false;
	
	public enum State {
		r_A,
		$NullState$
	};
	
	private final State[] stateVector = new State[1];
	
	private int nextStateIndex;
	
	
	public StatechartActiveStatemachine() {
	}
	
	public void init() {
		this.initialized = true;
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}
		clearEvents();
		clearOutEvents();
	}
	
	public void enter() {
		if (!initialized) {
			throw new IllegalStateException(
				"The state machine needs to be initialized first by calling the init() function."
			);
		}
		enterSequence_r_default();
	}
	
	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
		clearOutEvents();
		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
			switch (stateVector[nextStateIndex]) {
			case r_A:
				r_A_react(true);
				break;
			default:
				// $NullState$
			}
		}
		clearEvents();
	}
	public void exit() {
		exitSequence_r();
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
		case r_A:
			return stateVector[0] == State.r_A;
		default:
			return false;
		}
	}
	
	/* 'default' enter sequence for state A */
	private void enterSequence_r_A_default() {
		nextStateIndex = 0;
		stateVector[0] = State.r_A;
	}
	
	/* 'default' enter sequence for region r */
	private void enterSequence_r_default() {
		react_StatechartActive_r__entry_Default();
	}
	
	/* Default exit sequence for state A */
	private void exitSequence_r_A() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for region r */
	private void exitSequence_r() {
		switch (stateVector[0]) {
		case r_A:
			exitSequence_r_A();
			break;
		default:
			break;
		}
	}
	
	/* Default react sequence for initial entry  */
	private void react_StatechartActive_r__entry_Default() {
		enterSequence_r_A_default();
	}
	
	private boolean react() {
		return false;
	}
	
	private boolean r_A_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (react()==false) {
				did_transition = false;
			}
		}
		return did_transition;
	}
	
}
