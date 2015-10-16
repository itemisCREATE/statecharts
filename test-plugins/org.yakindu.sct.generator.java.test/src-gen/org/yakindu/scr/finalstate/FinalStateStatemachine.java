package org.yakindu.scr.finalstate;

public class FinalStateStatemachine implements IFinalStateStatemachine {

	private boolean initialized = false;

	public enum State {
		main_region_myState, main_region__final_, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public FinalStateStatemachine() {

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
	 * @see IStatemachine#isFinal() 
	 */
	public boolean isFinal() {
		return (stateVector[0] == State.main_region__final_);
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
			case main_region_myState :
				return stateVector[0] == State.main_region_myState;
			case main_region__final_ :
				return stateVector[0] == State.main_region__final_;
			default :
				return false;
		}
	}

	private boolean check_main_region_myState_tr0_tr0() {
		return true;
	}

	private void effect_main_region_myState_tr0() {
		exitSequence_main_region_myState();

		enterSequence_main_region__final__default();
	}

	/* Entry action for statechart 'FinalState'. */
	private void entryAction() {
	}

	/* Exit action for state 'FinalState'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state myState */
	private void enterSequence_main_region_myState_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_myState;
	}

	/* Default enter sequence for state null */
	private void enterSequence_main_region__final__default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region__final_;
	}

	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}

	/* Default exit sequence for state myState */
	private void exitSequence_main_region_myState() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for final state. */
	private void exitSequence_main_region__final_() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
			case main_region_myState :
				exitSequence_main_region_myState();
				break;

			case main_region__final_ :
				exitSequence_main_region__final_();
				break;

			default :
				break;
		}
	}

	/* The reactions of state myState. */
	private void react_main_region_myState() {
		effect_main_region_myState_tr0();
	}

	/* The reactions of state null. */
	private void react_main_region__final_() {
	}

	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_myState_default();
	}

	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The statemachine needs to be initialized first by calling the init() function.");

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_myState :
					react_main_region_myState();
					break;
				case main_region__final_ :
					react_main_region__final_();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
