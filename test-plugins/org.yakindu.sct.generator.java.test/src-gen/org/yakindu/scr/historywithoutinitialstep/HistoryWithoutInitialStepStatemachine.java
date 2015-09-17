package org.yakindu.scr.historywithoutinitialstep;

public class HistoryWithoutInitialStepStatemachine implements IHistoryWithoutInitialStepStatemachine {

	protected class SCInterfaceImpl implements SCInterface {

		private boolean toA;

		public void raiseToA() {
			toA = true;
		}

		private boolean toB;

		public void raiseToB() {
			toB = true;
		}

		private boolean toHistory;

		public void raiseToHistory() {
			toHistory = true;
		}

		private boolean next;

		public void raiseNext() {
			next = true;
		}

		protected void clearEvents() {
			toA = false;
			toB = false;
			toHistory = false;
			next = false;
		}

	}

	protected SCInterfaceImpl sCInterface;

	public enum State {
		main_region_A, main_region_B, main_region_B_r1_C, main_region_B_r1_D, main_region_B_r1_E, main_region_B_r1_E__region0_F, $NullState$
	};

	private State[] historyVector = new State[1];
	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public HistoryWithoutInitialStepStatemachine() {

		sCInterface = new SCInterfaceImpl();
	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		for (int i = 0; i < 1; i++) {
			historyVector[i] = State.$NullState$;
		}
		clearEvents();
		clearOutEvents();

	}

	public void enter() {
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
						&& stateVector[0].ordinal() <= State.main_region_B_r1_E__region0_F.ordinal();
			case main_region_B_r1_C :
				return stateVector[0] == State.main_region_B_r1_C;
			case main_region_B_r1_D :
				return stateVector[0] == State.main_region_B_r1_D;
			case main_region_B_r1_E :
				return stateVector[0].ordinal() >= State.main_region_B_r1_E.ordinal()
						&& stateVector[0].ordinal() <= State.main_region_B_r1_E__region0_F.ordinal();
			case main_region_B_r1_E__region0_F :
				return stateVector[0] == State.main_region_B_r1_E__region0_F;
			default :
				return false;
		}
	}

	public SCInterface getSCInterface() {
		return sCInterface;
	}

	public void raiseToA() {
		sCInterface.raiseToA();
	}
	public void raiseToB() {
		sCInterface.raiseToB();
	}
	public void raiseToHistory() {
		sCInterface.raiseToHistory();
	}
	public void raiseNext() {
		sCInterface.raiseNext();
	}

	private boolean check_main_region_A_tr0_tr0() {
		return sCInterface.toB;
	}

	private boolean check_main_region_A_tr1_tr1() {
		return sCInterface.toHistory;
	}

	private boolean check_main_region_B_tr0_tr0() {
		return sCInterface.toA;
	}

	private boolean check_main_region_B_r1_C_tr0_tr0() {
		return sCInterface.next;
	}

	private boolean check_main_region_B_r1_D_tr0_tr0() {
		return sCInterface.next;
	}

	private boolean check_main_region_B_r1_E_tr0_tr0() {
		return sCInterface.next;
	}

	private void effect_main_region_A_tr0() {
		exitSequence_main_region_A();

		enterSequence_main_region_B_default();
	}

	private void effect_main_region_A_tr1() {
		exitSequence_main_region_A();

		react_main_region_B_r1_he();
	}

	private void effect_main_region_B_tr0() {
		exitSequence_main_region_B();

		enterSequence_main_region_A_default();
	}

	private void effect_main_region_B_r1_C_tr0() {
		exitSequence_main_region_B_r1_C();

		enterSequence_main_region_B_r1_D_default();
	}

	private void effect_main_region_B_r1_D_tr0() {
		exitSequence_main_region_B_r1_D();

		enterSequence_main_region_B_r1_E_default();
	}

	private void effect_main_region_B_r1_E_tr0() {
		exitSequence_main_region_B_r1_E();

		enterSequence_main_region_B_r1_C_default();
	}

	/* Entry action for statechart 'HistoryWithoutInitialStep'. */
	private void entryAction() {
	}

	/* Exit action for state 'HistoryWithoutInitialStep'. */
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
	}

	/* 'default' enter sequence for state C */
	private void enterSequence_main_region_B_r1_C_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_B_r1_C;

		historyVector[0] = stateVector[0];
	}

	/* 'default' enter sequence for state D */
	private void enterSequence_main_region_B_r1_D_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_B_r1_D;

		historyVector[0] = stateVector[0];
	}

	/* 'default' enter sequence for state E */
	private void enterSequence_main_region_B_r1_E_default() {
		enterSequence_main_region_B_r1_E__region0_default();

		historyVector[0] = stateVector[0];
	}

	/* 'default' enter sequence for state F */
	private void enterSequence_main_region_B_r1_E__region0_F_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_B_r1_E__region0_F;
	}

	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}

	/* 'default' enter sequence for region r1 */
	private void enterSequence_main_region_B_r1_default() {
		react_main_region_B_r1__entry_Default();
	}

	/* shallow enterSequence with history in child r1 */
	private void shallowEnterSequence_main_region_B_r1() {
		switch (historyVector[0]) {
			case main_region_B_r1_C :
				enterSequence_main_region_B_r1_C_default();
				break;

			case main_region_B_r1_D :
				enterSequence_main_region_B_r1_D_default();
				break;

			case main_region_B_r1_E__region0_F :
				enterSequence_main_region_B_r1_E_default();
				break;

			default :
				break;
		}
	}

	/* 'default' enter sequence for region null */
	private void enterSequence_main_region_B_r1_E__region0_default() {
		react_main_region_B_r1_E__region0__entry_Default();
	}

	/* Default exit sequence for state A */
	private void exitSequence_main_region_A() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state B */
	private void exitSequence_main_region_B() {
		exitSequence_main_region_B_r1();
	}

	/* Default exit sequence for state C */
	private void exitSequence_main_region_B_r1_C() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state D */
	private void exitSequence_main_region_B_r1_D() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state E */
	private void exitSequence_main_region_B_r1_E() {
		exitSequence_main_region_B_r1_E__region0();
	}

	/* Default exit sequence for state F */
	private void exitSequence_main_region_B_r1_E__region0_F() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
			case main_region_A :
				exitSequence_main_region_A();
				break;

			case main_region_B_r1_C :
				exitSequence_main_region_B_r1_C();
				break;

			case main_region_B_r1_D :
				exitSequence_main_region_B_r1_D();
				break;

			case main_region_B_r1_E__region0_F :
				exitSequence_main_region_B_r1_E__region0_F();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region r1 */
	private void exitSequence_main_region_B_r1() {
		switch (stateVector[0]) {
			case main_region_B_r1_C :
				exitSequence_main_region_B_r1_C();
				break;

			case main_region_B_r1_D :
				exitSequence_main_region_B_r1_D();
				break;

			case main_region_B_r1_E__region0_F :
				exitSequence_main_region_B_r1_E__region0_F();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region null */
	private void exitSequence_main_region_B_r1_E__region0() {
		switch (stateVector[0]) {
			case main_region_B_r1_E__region0_F :
				exitSequence_main_region_B_r1_E__region0_F();
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

	/* The reactions of state C. */
	private void react_main_region_B_r1_C() {
		if (check_main_region_B_tr0_tr0()) {
			effect_main_region_B_tr0();
		} else {
			if (check_main_region_B_r1_C_tr0_tr0()) {
				effect_main_region_B_r1_C_tr0();
			}
		}
	}

	/* The reactions of state D. */
	private void react_main_region_B_r1_D() {
		if (check_main_region_B_tr0_tr0()) {
			effect_main_region_B_tr0();
		} else {
			if (check_main_region_B_r1_D_tr0_tr0()) {
				effect_main_region_B_r1_D_tr0();
			}
		}
	}

	/* The reactions of state F. */
	private void react_main_region_B_r1_E__region0_F() {
		if (check_main_region_B_tr0_tr0()) {
			effect_main_region_B_tr0();
		} else {
			if (check_main_region_B_r1_E_tr0_tr0()) {
				effect_main_region_B_r1_E_tr0();
			} else {
			}
		}
	}

	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_A_default();
	}

	/* Default react sequence for initial entry  */
	private void react_main_region_B_r1__entry_Default() {
		enterSequence_main_region_B_r1_C_default();
	}

	/* Default react sequence for shallow history entry he */
	private void react_main_region_B_r1_he() {
		/* Enter the region with shallow history */
		if (historyVector[0] != State.$NullState$) {
			shallowEnterSequence_main_region_B_r1();
		}
	}

	/* Default react sequence for initial entry  */
	private void react_main_region_B_r1_E__region0__entry_Default() {
		enterSequence_main_region_B_r1_E__region0_F_default();
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_A :
					react_main_region_A();
					break;
				case main_region_B_r1_C :
					react_main_region_B_r1_C();
					break;
				case main_region_B_r1_D :
					react_main_region_B_r1_D();
					break;
				case main_region_B_r1_E__region0_F :
					react_main_region_B_r1_E__region0_F();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
