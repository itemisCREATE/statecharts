package org.yakindu.scr.simplehierachy;

public class SimpleHierachyStatemachine implements ISimpleHierachyStatemachine {

	protected class SCInterfaceImpl implements SCInterface {

		private boolean event1;

		public void raiseEvent1() {
			event1 = true;
		}

		protected void clearEvents() {
			event1 = false;
		}

	}

	protected SCInterfaceImpl sCInterface;

	private boolean initialized = false;

	public enum State {
		main_region_A, main_region_B, main_region_B_subregion1_B1, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public SimpleHierachyStatemachine() {

		sCInterface = new SCInterfaceImpl();
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
			case main_region_B :
				return stateVector[0].ordinal() >= State.main_region_B.ordinal()
						&& stateVector[0].ordinal() <= State.main_region_B_subregion1_B1.ordinal();
			case main_region_B_subregion1_B1 :
				return stateVector[0] == State.main_region_B_subregion1_B1;
			default :
				return false;
		}
	}

	public SCInterface getSCInterface() {
		return sCInterface;
	}

	public void raiseEvent1() {
		sCInterface.raiseEvent1();
	}

	private boolean check_main_region_A_tr0_tr0() {
		return sCInterface.event1;
	}

	private void effect_main_region_A_tr0() {
		exitSequence_main_region_A();

		enterSequence_main_region_B_default();
	}

	/* Entry action for statechart 'SimpleHierachy'. */
	private void entryAction() {
	}

	/* Exit action for state 'SimpleHierachy'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state A */
	private void enterSequence_main_region_A_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_A;
	}

	/* 'default' enter sequence for state B */
	private void enterSequence_main_region_B_default() {
		enterSequence_main_region_B_subregion1_default();
	}

	/* 'default' enter sequence for state B1 */
	private void enterSequence_main_region_B_subregion1_B1_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_B_subregion1_B1;
	}

	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}

	/* 'default' enter sequence for region subregion1 */
	private void enterSequence_main_region_B_subregion1_default() {
		react_main_region_B_subregion1__entry_Default();
	}

	/* Default exit sequence for state A */
	private void exitSequence_main_region_A() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state B1 */
	private void exitSequence_main_region_B_subregion1_B1() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
			case main_region_A :
				exitSequence_main_region_A();
				break;

			case main_region_B_subregion1_B1 :
				exitSequence_main_region_B_subregion1_B1();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region subregion1 */
	private void exitSequence_main_region_B_subregion1() {
		switch (stateVector[0]) {
			case main_region_B_subregion1_B1 :
				exitSequence_main_region_B_subregion1_B1();
				break;

			default :
				break;
		}
	}

	/* The reactions of state A. */
	private void react_main_region_A() {
		if (check_main_region_A_tr0_tr0()) {
			effect_main_region_A_tr0();
		}
	}

	/* The reactions of state B1. */
	private void react_main_region_B_subregion1_B1() {
	}

	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_A_default();
	}

	/* Default react sequence for initial entry  */
	private void react_main_region_B_subregion1__entry_Default() {
		enterSequence_main_region_B_subregion1_B1_default();
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
				case main_region_B_subregion1_B1 :
					react_main_region_B_subregion1_B1();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
