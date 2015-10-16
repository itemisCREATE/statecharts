package org.yakindu.scr.entrychoice;

public class EntryChoiceStatemachine implements IEntryChoiceStatemachine {

	private boolean initialized = false;

	public enum State {
		main_region_A, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public EntryChoiceStatemachine() {

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
		if (!initialized)
			throw new IllegalStateException(
					"The statemachine needs to be initialized first by calling the init() function.");

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
			case main_region_A :
				return stateVector[0] == State.main_region_A;
			default :
				return false;
		}
	}

	private boolean check_main_region__choice_0_tr0_tr0() {
		return true;
	}

	private void effect_main_region__choice_0_tr0() {
		enterSequence_main_region_A_default();
	}

	/* Entry action for statechart 'EntryChoice'. */
	private void entryAction() {
	}

	/* Exit action for state 'EntryChoice'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state A */
	private void enterSequence_main_region_A_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_A;
	}

	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}

	/* Default exit sequence for state A */
	private void exitSequence_main_region_A() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
			case main_region_A :
				exitSequence_main_region_A();
				break;

			default :
				break;
		}
	}

	/* The reactions of state A. */
	private void react_main_region_A() {
	}

	/* The reactions of state null. */
	private void react_main_region__choice_0() {
		effect_main_region__choice_0_tr0();
	}

	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		react_main_region__choice_0();
	}

	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The statemachine needs to be initialized first by calling the init() function.");

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_A :
					react_main_region_A();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
