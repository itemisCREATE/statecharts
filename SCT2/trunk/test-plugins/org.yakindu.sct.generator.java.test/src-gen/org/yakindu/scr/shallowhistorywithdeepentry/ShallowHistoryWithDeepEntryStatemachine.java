package org.yakindu.scr.shallowhistorywithdeepentry;

public class ShallowHistoryWithDeepEntryStatemachine
		implements
			IShallowHistoryWithDeepEntryStatemachine {

	static {
	}

	private final class SCInterfaceImpl implements SCInterface {

		private boolean toZ;

		public void raiseToZ() {
			toZ = true;
		}

		private boolean toY;

		public void raiseToY() {
			toY = true;
		}

		private boolean toC;

		public void raiseToC() {
			toC = true;
		}

		private boolean toA;

		public void raiseToA() {
			toA = true;
		}

		public void clearEvents() {
			toZ = false;
			toY = false;
			toC = false;
			toA = false;
		}

	}

	private SCInterfaceImpl sCInterface;

	public enum State {
		main_region_Y, main_region_Z, main_region_Z__region0_A, main_region_Z__region0_B, main_region_Z__region0_B__region0_C, $NullState$
	};

	private State[] historyVector = new State[1];
	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public ShallowHistoryWithDeepEntryStatemachine() {

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
			case main_region_Y :
				return stateVector[0] == State.main_region_Y;
			case main_region_Z :
				return stateVector[0].ordinal() >= State.main_region_Z
						.ordinal()
						&& stateVector[0].ordinal() <= State.main_region_Z__region0_B__region0_C
								.ordinal();
			case main_region_Z__region0_A :
				return stateVector[0] == State.main_region_Z__region0_A;
			case main_region_Z__region0_B :
				return stateVector[0].ordinal() >= State.main_region_Z__region0_B
						.ordinal()
						&& stateVector[0].ordinal() <= State.main_region_Z__region0_B__region0_C
								.ordinal();
			case main_region_Z__region0_B__region0_C :
				return stateVector[0] == State.main_region_Z__region0_B__region0_C;
			default :
				return false;
		}
	}

	public SCInterface getSCInterface() {
		return sCInterface;
	}

	public void raiseToZ() {
		sCInterface.raiseToZ();
	}
	public void raiseToY() {
		sCInterface.raiseToY();
	}
	public void raiseToC() {
		sCInterface.raiseToC();
	}
	public void raiseToA() {
		sCInterface.raiseToA();
	}

	private boolean checkMain_region_YTr0() {
		return sCInterface.toZ;
	}

	private boolean checkMain_region_YTr1() {
		return sCInterface.toC;
	}

	private boolean checkMain_region_ZTr0() {
		return sCInterface.toY;
	}

	private boolean checkMain_region_Z_region0_ATr0() {
		return sCInterface.toC;
	}

	private boolean checkMain_region_Z_region0_B_region0_CTr0() {
		return sCInterface.toA;
	}

	private void effectMain_region_YTr0() {
		exitSequenceMain_region_Y();

		enterSequenceMain_region_Z();
	}

	private void effectMain_region_YTr1() {
		exitSequenceMain_region_Y();

		enterSequenceMain_region_Z_region0_B_region0_C();

		historyVector[0] = stateVector[0];
	}

	private void effectMain_region_ZTr0() {
		exitSequenceMain_region_Z();

		enterSequenceMain_region_Y();
	}

	private void effectMain_region_Z_region0_ATr0() {
		exitSequenceMain_region_Z_region0_A();

		enterSequenceMain_region_Z_region0_B_region0_C();

		historyVector[0] = stateVector[0];
	}

	private void effectMain_region_Z_region0_B_region0_CTr0() {
		exitSequenceMain_region_Z_region0_B();

		enterSequenceMain_region_Z_region0_A();
	}

	/* Entry action for statechart 'ShallowHistoryWithDeepEntry'. */
	private void entryAction() {
	}

	/* Exit action for state 'ShallowHistoryWithDeepEntry'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state Y */
	private void enterSequenceMain_region_Y() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Y;
	}

	/* 'default' enter sequence for state Z */
	private void enterSequenceMain_region_Z() {
		enterSequenceMain_region_Z_region0();
	}

	/* 'default' enter sequence for state A */
	private void enterSequenceMain_region_Z_region0_A() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Z__region0_A;

		historyVector[0] = stateVector[0];
	}

	/* 'default' enter sequence for state B */
	private void enterSequenceMain_region_Z_region0_B() {
		enterSequenceMain_region_Z_region0_B_region0();

		historyVector[0] = stateVector[0];
	}

	/* 'default' enter sequence for state C */
	private void enterSequenceMain_region_Z_region0_B_region0_C() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Z__region0_B__region0_C;
	}

	/* 'default' enter sequence for region main region */
	private void enterSequenceMain_region() {
		reactShallowHistoryWithDeepEntry_main_region__entry_Default();
	}

	/* 'default' enter sequence for region null */
	private void enterSequenceMain_region_Z_region0() {
		reactShallowHistoryWithDeepEntry_main_region_Z__region0__entry_Default();
	}

	/* shallow enterSequence with history in child null */
	private void shallowEnterSequenceMain_region_Z_region0() {
		switch (historyVector[0]) {
			case main_region_Z__region0_A :
				enterSequenceMain_region_Z_region0_A();
				break;

			case main_region_Z__region0_B__region0_C :
				enterSequenceMain_region_Z_region0_B();
				break;

			default :
				break;
		}
	}

	/* 'default' enter sequence for region null */
	private void enterSequenceMain_region_Z_region0_B_region0() {
		reactShallowHistoryWithDeepEntry_main_region_Z__region0_B__region0__entry_Default();
	}

	/* Default exit sequence for state Y */
	private void exitSequenceMain_region_Y() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Z */
	private void exitSequenceMain_region_Z() {
		exitSequenceMain_region_Z_region0();
	}

	/* Default exit sequence for state A */
	private void exitSequenceMain_region_Z_region0_A() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state B */
	private void exitSequenceMain_region_Z_region0_B() {
		exitSequenceMain_region_Z_region0_B_region0();
	}

	/* Default exit sequence for state C */
	private void exitSequenceMain_region_Z_region0_B_region0_C() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for region main region */
	private void exitSequenceMain_region() {
		switch (stateVector[0]) {
			case main_region_Y :
				exitSequenceMain_region_Y();
				break;

			case main_region_Z__region0_A :
				exitSequenceMain_region_Z_region0_A();
				break;

			case main_region_Z__region0_B__region0_C :
				exitSequenceMain_region_Z_region0_B_region0_C();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region null */
	private void exitSequenceMain_region_Z_region0() {
		switch (stateVector[0]) {
			case main_region_Z__region0_A :
				exitSequenceMain_region_Z_region0_A();
				break;

			case main_region_Z__region0_B__region0_C :
				exitSequenceMain_region_Z_region0_B_region0_C();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region null */
	private void exitSequenceMain_region_Z_region0_B_region0() {
		switch (stateVector[0]) {
			case main_region_Z__region0_B__region0_C :
				exitSequenceMain_region_Z_region0_B_region0_C();
				break;

			default :
				break;
		}
	}

	/* The reactions of state Y. */
	private void reactMain_region_Y() {
		if (checkMain_region_YTr0()) {
			effectMain_region_YTr0();
		} else {
			if (checkMain_region_YTr1()) {
				effectMain_region_YTr1();
			}
		}
	}

	/* The reactions of state A. */
	private void reactMain_region_Z_region0_A() {
		if (checkMain_region_ZTr0()) {
			effectMain_region_ZTr0();
		} else {
			if (checkMain_region_Z_region0_ATr0()) {
				effectMain_region_Z_region0_ATr0();
			}
		}
	}

	/* The reactions of state C. */
	private void reactMain_region_Z_region0_B_region0_C() {
		if (checkMain_region_ZTr0()) {
			effectMain_region_ZTr0();
		} else {
			if (checkMain_region_Z_region0_B_region0_CTr0()) {
				effectMain_region_Z_region0_B_region0_CTr0();
			}
		}
	}

	/* Default react sequence for initial entry  */
	private void reactShallowHistoryWithDeepEntry_main_region__entry_Default() {
		enterSequenceMain_region_Y();
	}

	/* Default react sequence for shallow history entry  */
	private void reactShallowHistoryWithDeepEntry_main_region_Z__region0__entry_Default() {
		/* Enter the region with shallow history */
		if (historyVector[0] != State.$NullState$) {
			shallowEnterSequenceMain_region_Z_region0();
		} else {
			enterSequenceMain_region_Z_region0_A();
		}
	}

	/* Default react sequence for initial entry  */
	private void reactShallowHistoryWithDeepEntry_main_region_Z__region0_B__region0__entry_Default() {
		enterSequenceMain_region_Z_region0_B_region0_C();
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_Y :
					reactMain_region_Y();
					break;
				case main_region_Z__region0_A :
					reactMain_region_Z_region0_A();
					break;
				case main_region_Z__region0_B__region0_C :
					reactMain_region_Z_region0_B_region0_C();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
