package org.yakindu.scr.priorityvalues;

public class PriorityValuesStatemachine implements IPriorityValuesStatemachine {

	protected class SCInterfaceImpl implements SCInterface {

		private boolean event1;

		public void raiseEvent1() {
			event1 = true;
		}

		private boolean event2;

		public void raiseEvent2() {
			event2 = true;
		}

		protected void clearEvents() {
			event1 = false;
			event2 = false;
		}

	}

	protected SCInterfaceImpl sCInterface;

	private boolean initialized = false;

	public enum State {
		someRegion_A, someRegion_B, main_region_A, main_region_B, main_region_C, main_region_D, main_region_E, $NullState$
	};

	private final State[] stateVector = new State[2];

	private int nextStateIndex;

	public PriorityValuesStatemachine() {

		sCInterface = new SCInterfaceImpl();
	}

	public void init() {
		this.initialized = true;
		for (int i = 0; i < 2; i++) {
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

		enterSequence_someRegion_default();

		enterSequence_main_region_default();
	}

	public void exit() {
		initialized = false;
		exitSequence_someRegion();

		exitSequence_main_region();

		exitAction();
	}

	/**
	 * @see IStatemachine#isActive()
	 */
	public boolean isActive() {

		return stateVector[0] != State.$NullState$ || stateVector[1] != State.$NullState$;
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
			case someRegion_A :
				return stateVector[0] == State.someRegion_A;
			case someRegion_B :
				return stateVector[0] == State.someRegion_B;
			case main_region_A :
				return stateVector[1] == State.main_region_A;
			case main_region_B :
				return stateVector[1] == State.main_region_B;
			case main_region_C :
				return stateVector[1] == State.main_region_C;
			case main_region_D :
				return stateVector[1] == State.main_region_D;
			case main_region_E :
				return stateVector[1] == State.main_region_E;
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
	public void raiseEvent2() {
		sCInterface.raiseEvent2();
	}

	private boolean check_someRegion_A_tr0_tr0() {
		return sCInterface.event2;
	}

	private boolean check_main_region_A_tr0_tr0() {
		return sCInterface.event1;
	}

	private boolean check_main_region_A_tr1_tr1() {
		return sCInterface.event1;
	}

	private boolean check_main_region_A_tr2_tr2() {
		return sCInterface.event1;
	}

	private boolean check_main_region_A_tr3_tr3() {
		return (sCInterface.event2) && !isStateActive(State.someRegion_B);
	}

	private void effect_someRegion_A_tr0() {
		exitSequence_someRegion_A();

		enterSequence_someRegion_B_default();
	}

	private void effect_main_region_A_tr0() {
		exitSequence_main_region_A();

		enterSequence_main_region_C_default();
	}

	private void effect_main_region_A_tr1() {
		exitSequence_main_region_A();

		enterSequence_main_region_B_default();
	}

	private void effect_main_region_A_tr2() {
		exitSequence_main_region_A();

		enterSequence_main_region_D_default();
	}

	private void effect_main_region_A_tr3() {
		exitSequence_main_region_A();

		enterSequence_main_region_E_default();
	}

	/* Entry action for statechart 'PriorityValues'. */
	private void entryAction() {
	}

	/* Exit action for state 'PriorityValues'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state A */
	private void enterSequence_someRegion_A_default() {
		nextStateIndex = 0;
		stateVector[0] = State.someRegion_A;
	}

	/* 'default' enter sequence for state B */
	private void enterSequence_someRegion_B_default() {
		nextStateIndex = 0;
		stateVector[0] = State.someRegion_B;
	}

	/* 'default' enter sequence for state A */
	private void enterSequence_main_region_A_default() {
		nextStateIndex = 1;
		stateVector[1] = State.main_region_A;
	}

	/* 'default' enter sequence for state B */
	private void enterSequence_main_region_B_default() {
		nextStateIndex = 1;
		stateVector[1] = State.main_region_B;
	}

	/* 'default' enter sequence for state C */
	private void enterSequence_main_region_C_default() {
		nextStateIndex = 1;
		stateVector[1] = State.main_region_C;
	}

	/* 'default' enter sequence for state D */
	private void enterSequence_main_region_D_default() {
		nextStateIndex = 1;
		stateVector[1] = State.main_region_D;
	}

	/* 'default' enter sequence for state E */
	private void enterSequence_main_region_E_default() {
		nextStateIndex = 1;
		stateVector[1] = State.main_region_E;
	}

	/* 'default' enter sequence for region someRegion */
	private void enterSequence_someRegion_default() {
		react_someRegion__entry_Default();
	}

	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}

	/* Default exit sequence for state A */
	private void exitSequence_someRegion_A() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state B */
	private void exitSequence_someRegion_B() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state A */
	private void exitSequence_main_region_A() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state B */
	private void exitSequence_main_region_B() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state C */
	private void exitSequence_main_region_C() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state D */
	private void exitSequence_main_region_D() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state E */
	private void exitSequence_main_region_E() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for region someRegion */
	private void exitSequence_someRegion() {
		switch (stateVector[0]) {
			case someRegion_A :
				exitSequence_someRegion_A();
				break;

			case someRegion_B :
				exitSequence_someRegion_B();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[1]) {
			case main_region_A :
				exitSequence_main_region_A();
				break;

			case main_region_B :
				exitSequence_main_region_B();
				break;

			case main_region_C :
				exitSequence_main_region_C();
				break;

			case main_region_D :
				exitSequence_main_region_D();
				break;

			case main_region_E :
				exitSequence_main_region_E();
				break;

			default :
				break;
		}
	}

	/* The reactions of state A. */
	private void react_someRegion_A() {
		if (check_someRegion_A_tr0_tr0()) {
			effect_someRegion_A_tr0();
		}
	}

	/* The reactions of state B. */
	private void react_someRegion_B() {
	}

	/* The reactions of state A. */
	private void react_main_region_A() {
		if (check_main_region_A_tr0_tr0()) {
			effect_main_region_A_tr0();
		} else {
			if (check_main_region_A_tr1_tr1()) {
				effect_main_region_A_tr1();
			} else {
				if (check_main_region_A_tr2_tr2()) {
					effect_main_region_A_tr2();
				} else {
					if (check_main_region_A_tr3_tr3()) {
						effect_main_region_A_tr3();
					}
				}
			}
		}
	}

	/* The reactions of state B. */
	private void react_main_region_B() {
	}

	/* The reactions of state C. */
	private void react_main_region_C() {
	}

	/* The reactions of state D. */
	private void react_main_region_D() {
	}

	/* The reactions of state E. */
	private void react_main_region_E() {
	}

	/* Default react sequence for initial entry  */
	private void react_someRegion__entry_Default() {
		enterSequence_someRegion_A_default();
	}

	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_A_default();
	}

	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The statemachine needs to be initialized first by calling the init() function.");

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case someRegion_A :
					react_someRegion_A();
					break;
				case someRegion_B :
					react_someRegion_B();
					break;
				case main_region_A :
					react_main_region_A();
					break;
				case main_region_B :
					react_main_region_B();
					break;
				case main_region_C :
					react_main_region_C();
					break;
				case main_region_D :
					react_main_region_D();
					break;
				case main_region_E :
					react_main_region_E();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
