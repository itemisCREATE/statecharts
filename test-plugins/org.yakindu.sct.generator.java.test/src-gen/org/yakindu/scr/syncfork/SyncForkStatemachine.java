package org.yakindu.scr.syncfork;

public class SyncForkStatemachine implements ISyncForkStatemachine {

	protected class SCInterfaceImpl implements SCInterface {

		private boolean e;

		public void raiseE() {
			e = true;
		}

		private boolean f;

		public void raiseF() {
			f = true;
		}

		protected void clearEvents() {
			e = false;
			f = false;
		}

	}

	protected SCInterfaceImpl sCInterface;

	private boolean initialized = false;

	public enum State {
		main_region_A, main_region_B, main_region_B_r1_C1, main_region_B_r1_C2, main_region_B_r2_D1, main_region_B_r2_D2, $NullState$
	};

	private final State[] stateVector = new State[2];

	private int nextStateIndex;

	public SyncForkStatemachine() {

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
			case main_region_A :
				return stateVector[0] == State.main_region_A;
			case main_region_B :
				return stateVector[0].ordinal() >= State.main_region_B.ordinal()
						&& stateVector[0].ordinal() <= State.main_region_B_r2_D2.ordinal();
			case main_region_B_r1_C1 :
				return stateVector[0] == State.main_region_B_r1_C1;
			case main_region_B_r1_C2 :
				return stateVector[0] == State.main_region_B_r1_C2;
			case main_region_B_r2_D1 :
				return stateVector[1] == State.main_region_B_r2_D1;
			case main_region_B_r2_D2 :
				return stateVector[1] == State.main_region_B_r2_D2;
			default :
				return false;
		}
	}

	public SCInterface getSCInterface() {
		return sCInterface;
	}

	public void raiseE() {
		sCInterface.raiseE();
	}
	public void raiseF() {
		sCInterface.raiseF();
	}

	private boolean check_main_region_A_tr0_tr0() {
		return sCInterface.e;
	}

	private boolean check_main_region_A_tr1_tr1() {
		return sCInterface.f;
	}

	private boolean check_main_region_B_tr0_tr0() {
		return sCInterface.e;
	}

	private boolean check_main_region_B_r1_C1_tr0_tr0() {
		return sCInterface.f;
	}

	private boolean check_main_region_B_r2_D1_tr0_tr0() {
		return sCInterface.f;
	}

	private void effect_main_region_A_tr0() {
		exitSequence_main_region_A();

		react_main_region__sync0();
	}

	private void effect_main_region_A_tr1() {
		exitSequence_main_region_A();

		enterSequence_main_region_B_default();
	}

	private void effect_main_region_B_tr0() {
		exitSequence_main_region_B();

		enterSequence_main_region_A_default();
	}

	private void effect_main_region_B_r1_C1_tr0() {
		exitSequence_main_region_B_r1_C1();

		enterSequence_main_region_B_r1_C2_default();
	}

	private void effect_main_region_B_r2_D1_tr0() {
		exitSequence_main_region_B_r2_D1();

		enterSequence_main_region_B_r2_D2_default();
	}

	/* Entry action for statechart 'SyncFork'. */
	private void entryAction() {
	}

	/* Exit action for state 'SyncFork'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state A */
	private void enterSequence_main_region_A_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_A;
	}

	/* 'default' enter sequence for state B */
	private void enterSequence_main_region_B_default() {
		enterSequence_main_region_B_r1_default();

		enterSequence_main_region_B_r2_default();
	}

	/* 'default' enter sequence for state C1 */
	private void enterSequence_main_region_B_r1_C1_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_B_r1_C1;
	}

	/* 'default' enter sequence for state C2 */
	private void enterSequence_main_region_B_r1_C2_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_B_r1_C2;
	}

	/* 'default' enter sequence for state D1 */
	private void enterSequence_main_region_B_r2_D1_default() {
		nextStateIndex = 1;
		stateVector[1] = State.main_region_B_r2_D1;
	}

	/* 'default' enter sequence for state D2 */
	private void enterSequence_main_region_B_r2_D2_default() {
		nextStateIndex = 1;
		stateVector[1] = State.main_region_B_r2_D2;
	}

	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}

	/* 'default' enter sequence for region r1 */
	private void enterSequence_main_region_B_r1_default() {
		react_main_region_B_r1__entry_Default();
	}

	/* 'default' enter sequence for region r2 */
	private void enterSequence_main_region_B_r2_default() {
		react_main_region_B_r2__entry_Default();
	}

	/* Default exit sequence for state A */
	private void exitSequence_main_region_A() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state B */
	private void exitSequence_main_region_B() {
		exitSequence_main_region_B_r1();

		exitSequence_main_region_B_r2();
	}

	/* Default exit sequence for state C1 */
	private void exitSequence_main_region_B_r1_C1() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state C2 */
	private void exitSequence_main_region_B_r1_C2() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state D1 */
	private void exitSequence_main_region_B_r2_D1() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state D2 */
	private void exitSequence_main_region_B_r2_D2() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
			case main_region_A :
				exitSequence_main_region_A();
				break;

			case main_region_B_r1_C1 :
				exitSequence_main_region_B_r1_C1();
				break;

			case main_region_B_r1_C2 :
				exitSequence_main_region_B_r1_C2();
				break;

			default :
				break;
		}

		switch (stateVector[1]) {
			case main_region_B_r2_D1 :
				exitSequence_main_region_B_r2_D1();
				break;

			case main_region_B_r2_D2 :
				exitSequence_main_region_B_r2_D2();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region r1 */
	private void exitSequence_main_region_B_r1() {
		switch (stateVector[0]) {
			case main_region_B_r1_C1 :
				exitSequence_main_region_B_r1_C1();
				break;

			case main_region_B_r1_C2 :
				exitSequence_main_region_B_r1_C2();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region r2 */
	private void exitSequence_main_region_B_r2() {
		switch (stateVector[1]) {
			case main_region_B_r2_D1 :
				exitSequence_main_region_B_r2_D1();
				break;

			case main_region_B_r2_D2 :
				exitSequence_main_region_B_r2_D2();
				break;

			default :
				break;
		}
	}

	/* The reactions of state A. */
	private void react_main_region_A() {
		if (check_main_region_A_tr0_tr0()) {
			effect_main_region_A_tr0();
		} else {
			if (check_main_region_A_tr1_tr1()) {
				effect_main_region_A_tr1();
			}
		}
	}

	/* The reactions of state C1. */
	private void react_main_region_B_r1_C1() {
		if (check_main_region_B_tr0_tr0()) {
			effect_main_region_B_tr0();
		} else {
			if (check_main_region_B_r1_C1_tr0_tr0()) {
				effect_main_region_B_r1_C1_tr0();
			}
		}
	}

	/* The reactions of state C2. */
	private void react_main_region_B_r1_C2() {
		if (check_main_region_B_tr0_tr0()) {
			effect_main_region_B_tr0();
		} else {
		}
	}

	/* The reactions of state D1. */
	private void react_main_region_B_r2_D1() {
		if (check_main_region_B_r2_D1_tr0_tr0()) {
			effect_main_region_B_r2_D1_tr0();
		}
	}

	/* The reactions of state D2. */
	private void react_main_region_B_r2_D2() {
	}

	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_A_default();
	}

	/* Default react sequence for initial entry  */
	private void react_main_region_B_r1__entry_Default() {
		enterSequence_main_region_B_r1_C1_default();
	}

	/* Default react sequence for initial entry  */
	private void react_main_region_B_r2__entry_Default() {
		enterSequence_main_region_B_r2_D1_default();
	}

	/* The reactions of state null. */
	private void react_main_region__sync0() {
		enterSequence_main_region_B_r1_C2_default();

		enterSequence_main_region_B_r2_D2_default();
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
				case main_region_B_r1_C1 :
					react_main_region_B_r1_C1();
					break;
				case main_region_B_r1_C2 :
					react_main_region_B_r1_C2();
					break;
				case main_region_B_r2_D1 :
					react_main_region_B_r2_D1();
					break;
				case main_region_B_r2_D2 :
					react_main_region_B_r2_D2();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
