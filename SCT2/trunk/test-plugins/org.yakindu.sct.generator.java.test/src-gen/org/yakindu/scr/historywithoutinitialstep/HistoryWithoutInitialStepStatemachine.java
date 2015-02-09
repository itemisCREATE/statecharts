package org.yakindu.scr.historywithoutinitialstep;

public class HistoryWithoutInitialStepStatemachine
		implements
			IHistoryWithoutInitialStepStatemachine {

	static {
	}

	private final class SCInterfaceImpl implements SCInterface {

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

		public void clearEvents() {
			toA = false;
			toB = false;
			toHistory = false;
			next = false;
		}

	}

	private SCInterfaceImpl sCInterface;

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
				return stateVector[0].ordinal() >= State.main_region_B
						.ordinal()
						&& stateVector[0].ordinal() <= State.main_region_B_r1_E__region0_F
								.ordinal();
			case main_region_B_r1_C :
				return stateVector[0] == State.main_region_B_r1_C;
			case main_region_B_r1_D :
				return stateVector[0] == State.main_region_B_r1_D;
			case main_region_B_r1_E :
				return stateVector[0].ordinal() >= State.main_region_B_r1_E
						.ordinal()
						&& stateVector[0].ordinal() <= State.main_region_B_r1_E__region0_F
								.ordinal();
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

	private boolean checkMain_region_ATr0() {
		return sCInterface.toB;
	}

	private boolean checkMain_region_ATr1() {
		return sCInterface.toHistory;
	}

	private boolean checkMain_region_BTr0() {
		return sCInterface.toA;
	}

	private boolean checkMain_region_B_r1_CTr0() {
		return sCInterface.next;
	}

	private boolean checkMain_region_B_r1_DTr0() {
		return sCInterface.next;
	}

	private boolean checkMain_region_B_r1_ETr0() {
		return sCInterface.next;
	}

	private void effectMain_region_ATr0() {
		exitSequenceMain_region_A();

		enterSequenceMain_region_B();
	}

	private void effectMain_region_ATr1() {
		exitSequenceMain_region_A();

		reactHistoryWithoutInitialStep_main_region_B_r1_he();
	}

	private void effectMain_region_BTr0() {
		exitSequenceMain_region_B();

		enterSequenceMain_region_A();
	}

	private void effectMain_region_B_r1_CTr0() {
		exitSequenceMain_region_B_r1_C();

		enterSequenceMain_region_B_r1_D();
	}

	private void effectMain_region_B_r1_DTr0() {
		exitSequenceMain_region_B_r1_D();

		enterSequenceMain_region_B_r1_E();
	}

	private void effectMain_region_B_r1_ETr0() {
		exitSequenceMain_region_B_r1_E();

		enterSequenceMain_region_B_r1_C();
	}

	/* Entry action for statechart 'HistoryWithoutInitialStep'. */
	private void entryAction() {
	}

	/* Exit action for state 'HistoryWithoutInitialStep'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state A */
	private void enterSequenceMain_region_A() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_A;
	}

	/* 'default' enter sequence for state B */
	private void enterSequenceMain_region_B() {
		enterSequenceMain_region_B_r1();
	}

	/* 'default' enter sequence for state C */
	private void enterSequenceMain_region_B_r1_C() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_B_r1_C;

		historyVector[0] = stateVector[0];
	}

	/* 'default' enter sequence for state D */
	private void enterSequenceMain_region_B_r1_D() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_B_r1_D;

		historyVector[0] = stateVector[0];
	}

	/* 'default' enter sequence for state E */
	private void enterSequenceMain_region_B_r1_E() {
		enterSequenceMain_region_B_r1_E_region0();

		historyVector[0] = stateVector[0];
	}

	/* 'default' enter sequence for state F */
	private void enterSequenceMain_region_B_r1_E_region0_F() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_B_r1_E__region0_F;
	}

	/* 'default' enter sequence for region main region */
	private void enterSequenceMain_region() {
		reactHistoryWithoutInitialStep_main_region__entry_Default();
	}

	/* 'default' enter sequence for region r1 */
	private void enterSequenceMain_region_B_r1() {
		reactHistoryWithoutInitialStep_main_region_B_r1__entry_Default();
	}

	/* shallow enterSequence with history in child r1 */
	private void shallowEnterSequenceMain_region_B_r1() {
		switch (historyVector[0]) {
			case main_region_B_r1_C :
				enterSequenceMain_region_B_r1_C();
				break;

			case main_region_B_r1_D :
				enterSequenceMain_region_B_r1_D();
				break;

			case main_region_B_r1_E__region0_F :
				enterSequenceMain_region_B_r1_E();
				break;

			default :
				break;
		}
	}

	/* 'default' enter sequence for region null */
	private void enterSequenceMain_region_B_r1_E_region0() {
		reactHistoryWithoutInitialStep_main_region_B_r1_E__region0__entry_Default();
	}

	/* Default exit sequence for state A */
	private void exitSequenceMain_region_A() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state B */
	private void exitSequenceMain_region_B() {
		exitSequenceMain_region_B_r1();
	}

	/* Default exit sequence for state C */
	private void exitSequenceMain_region_B_r1_C() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state D */
	private void exitSequenceMain_region_B_r1_D() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state E */
	private void exitSequenceMain_region_B_r1_E() {
		exitSequenceMain_region_B_r1_E_region0();
	}

	/* Default exit sequence for state F */
	private void exitSequenceMain_region_B_r1_E_region0_F() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for region main region */
	private void exitSequenceMain_region() {
		switch (stateVector[0]) {
			case main_region_A :
				exitSequenceMain_region_A();
				break;

			case main_region_B_r1_C :
				exitSequenceMain_region_B_r1_C();
				break;

			case main_region_B_r1_D :
				exitSequenceMain_region_B_r1_D();
				break;

			case main_region_B_r1_E__region0_F :
				exitSequenceMain_region_B_r1_E_region0_F();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region r1 */
	private void exitSequenceMain_region_B_r1() {
		switch (stateVector[0]) {
			case main_region_B_r1_C :
				exitSequenceMain_region_B_r1_C();
				break;

			case main_region_B_r1_D :
				exitSequenceMain_region_B_r1_D();
				break;

			case main_region_B_r1_E__region0_F :
				exitSequenceMain_region_B_r1_E_region0_F();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region null */
	private void exitSequenceMain_region_B_r1_E_region0() {
		switch (stateVector[0]) {
			case main_region_B_r1_E__region0_F :
				exitSequenceMain_region_B_r1_E_region0_F();
				break;

			default :
				break;
		}
	}

	/* The reactions of state A. */
	private void reactMain_region_A() {
		if (checkMain_region_ATr0()) {
			effectMain_region_ATr0();
		} else {
			if (checkMain_region_ATr1()) {
				effectMain_region_ATr1();
			}
		}
	}

	/* The reactions of state C. */
	private void reactMain_region_B_r1_C() {
		if (checkMain_region_BTr0()) {
			effectMain_region_BTr0();
		} else {
			if (checkMain_region_B_r1_CTr0()) {
				effectMain_region_B_r1_CTr0();
			}
		}
	}

	/* The reactions of state D. */
	private void reactMain_region_B_r1_D() {
		if (checkMain_region_BTr0()) {
			effectMain_region_BTr0();
		} else {
			if (checkMain_region_B_r1_DTr0()) {
				effectMain_region_B_r1_DTr0();
			}
		}
	}

	/* The reactions of state F. */
	private void reactMain_region_B_r1_E_region0_F() {
		if (checkMain_region_BTr0()) {
			effectMain_region_BTr0();
		} else {
			if (checkMain_region_B_r1_ETr0()) {
				effectMain_region_B_r1_ETr0();
			} else {
			}
		}
	}

	/* Default react sequence for initial entry  */
	private void reactHistoryWithoutInitialStep_main_region__entry_Default() {
		enterSequenceMain_region_A();
	}

	/* Default react sequence for initial entry  */
	private void reactHistoryWithoutInitialStep_main_region_B_r1__entry_Default() {
		enterSequenceMain_region_B_r1_C();
	}

	/* Default react sequence for shallow history entry he */
	private void reactHistoryWithoutInitialStep_main_region_B_r1_he() {
		/* Enter the region with shallow history */
		if (historyVector[0] != State.$NullState$) {
			shallowEnterSequenceMain_region_B_r1();
		}
	}

	/* Default react sequence for initial entry  */
	private void reactHistoryWithoutInitialStep_main_region_B_r1_E__region0__entry_Default() {
		enterSequenceMain_region_B_r1_E_region0_F();
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_A :
					reactMain_region_A();
					break;
				case main_region_B_r1_C :
					reactMain_region_B_r1_C();
					break;
				case main_region_B_r1_D :
					reactMain_region_B_r1_D();
					break;
				case main_region_B_r1_E__region0_F :
					reactMain_region_B_r1_E_region0_F();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
