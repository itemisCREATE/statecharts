package org.yakindu.scr.entrychoice;

public class EntryChoiceStatemachine implements IEntryChoiceStatemachine {

	static {
	}

	public enum State {
		main_region_A, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public EntryChoiceStatemachine() {

	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

	}

	public void enter() {
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

	private boolean checkEntryChoice_main_region__choice_0Tr0() {
		return true;
	}

	private void effectEntryChoice_main_region__choice_0Tr0() {
		enterSequenceMain_region_A();
	}

	/* Entry action for statechart 'EntryChoice'. */
	private void entryAction() {
	}

	/* Exit action for state 'EntryChoice'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state A */
	private void enterSequenceMain_region_A() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_A;
	}

	/* 'default' enter sequence for region main region */
	private void enterSequenceMain_region() {
		reactEntryChoice_main_region__entry_Default();
	}

	/* Default exit sequence for state A */
	private void exitSequenceMain_region_A() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for region main region */
	private void exitSequenceMain_region() {
		switch (stateVector[0]) {
			case main_region_A :
				exitSequenceMain_region_A();
				break;

			default :
				break;
		}
	}

	/* The reactions of state A. */
	private void reactMain_region_A() {
	}

	/* The reactions of state null. */
	private void reactEntryChoice_main_region__choice_0() {
		effectEntryChoice_main_region__choice_0Tr0();
	}

	/* Default react sequence for initial entry  */
	private void reactEntryChoice_main_region__entry_Default() {
		reactEntryChoice_main_region__choice_0();
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_A :
					reactMain_region_A();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
