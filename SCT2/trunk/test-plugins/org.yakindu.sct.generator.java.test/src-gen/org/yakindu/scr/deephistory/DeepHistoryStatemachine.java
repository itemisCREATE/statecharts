package org.yakindu.scr.deephistory;

public class DeepHistoryStatemachine implements IDeepHistoryStatemachine {

	static {
	}

	private final class SCInterfaceImpl implements SCInterface {

		private boolean event1;

		public void raiseEvent1() {
			event1 = true;
		}

		private boolean event2;

		public void raiseEvent2() {
			event2 = true;
		}

		private boolean event3;

		public void raiseEvent3() {
			event3 = true;
		}

		private boolean event4;

		public void raiseEvent4() {
			event4 = true;
		}

		private boolean event5;

		public void raiseEvent5() {
			event5 = true;
		}

		private boolean event6;

		public void raiseEvent6() {
			event6 = true;
		}

		private boolean event7;

		public void raiseEvent7() {
			event7 = true;
		}

		private boolean event8;

		public void raiseEvent8() {
			event8 = true;
		}

		private boolean event9;

		public void raiseEvent9() {
			event9 = true;
		}

		public void clearEvents() {
			event1 = false;
			event2 = false;
			event3 = false;
			event4 = false;
			event5 = false;
			event6 = false;
			event7 = false;
			event8 = false;
			event9 = false;
		}

	}

	private SCInterfaceImpl sCInterface;

	public enum State {
		mainRegion_State1, mainRegion_State2, mainRegion_State2__region0_a, mainRegion_State2__region0_State4, mainRegion_State2__region0_State4__region0_State6, mainRegion_State2__region0_State4__region0_State7, mainRegion_State2__region0_State4__region0_State7__region0_State8, mainRegion_State2__region0_State4__region0_State7__region0_State9, mainRegion_State2__region0_State5, $NullState$
	};

	private State[] historyVector = new State[3];
	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public DeepHistoryStatemachine() {

		sCInterface = new SCInterfaceImpl();
	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		for (int i = 0; i < 3; i++) {
			historyVector[i] = State.$NullState$;
		}
		clearEvents();
		clearOutEvents();

	}

	public void enter() {
		entryAction();

		enterSequenceMainRegion();
	}

	public void exit() {
		exitSequenceMainRegion();

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
			case mainRegion_State1 :
				return stateVector[0] == State.mainRegion_State1;
			case mainRegion_State2 :
				return stateVector[0].ordinal() >= State.mainRegion_State2
						.ordinal()
						&& stateVector[0].ordinal() <= State.mainRegion_State2__region0_State5
								.ordinal();
			case mainRegion_State2__region0_a :
				return stateVector[0] == State.mainRegion_State2__region0_a;
			case mainRegion_State2__region0_State4 :
				return stateVector[0].ordinal() >= State.mainRegion_State2__region0_State4
						.ordinal()
						&& stateVector[0].ordinal() <= State.mainRegion_State2__region0_State4__region0_State7__region0_State9
								.ordinal();
			case mainRegion_State2__region0_State4__region0_State6 :
				return stateVector[0] == State.mainRegion_State2__region0_State4__region0_State6;
			case mainRegion_State2__region0_State4__region0_State7 :
				return stateVector[0].ordinal() >= State.mainRegion_State2__region0_State4__region0_State7
						.ordinal()
						&& stateVector[0].ordinal() <= State.mainRegion_State2__region0_State4__region0_State7__region0_State9
								.ordinal();
			case mainRegion_State2__region0_State4__region0_State7__region0_State8 :
				return stateVector[0] == State.mainRegion_State2__region0_State4__region0_State7__region0_State8;
			case mainRegion_State2__region0_State4__region0_State7__region0_State9 :
				return stateVector[0] == State.mainRegion_State2__region0_State4__region0_State7__region0_State9;
			case mainRegion_State2__region0_State5 :
				return stateVector[0] == State.mainRegion_State2__region0_State5;
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
	public void raiseEvent3() {
		sCInterface.raiseEvent3();
	}
	public void raiseEvent4() {
		sCInterface.raiseEvent4();
	}
	public void raiseEvent5() {
		sCInterface.raiseEvent5();
	}
	public void raiseEvent6() {
		sCInterface.raiseEvent6();
	}
	public void raiseEvent7() {
		sCInterface.raiseEvent7();
	}
	public void raiseEvent8() {
		sCInterface.raiseEvent8();
	}
	public void raiseEvent9() {
		sCInterface.raiseEvent9();
	}

	private boolean checkMainRegion_State1Tr0() {
		return sCInterface.event1;
	}

	private boolean checkMainRegion_State2Tr0() {
		return sCInterface.event2;
	}

	private boolean checkMainRegion_State2_region0_aTr0() {
		return sCInterface.event3;
	}

	private boolean checkMainRegion_State2_region0_State4Tr0() {
		return sCInterface.event4;
	}

	private boolean checkMainRegion_State2_region0_State4_region0_State6Tr0() {
		return sCInterface.event5;
	}

	private boolean checkMainRegion_State2_region0_State4_region0_State7Tr0() {
		return sCInterface.event6;
	}

	private boolean checkMainRegion_State2_region0_State4_region0_State7_region0_State8Tr0() {
		return sCInterface.event7;
	}

	private boolean checkMainRegion_State2_region0_State4_region0_State7_region0_State9Tr0() {
		return sCInterface.event8;
	}

	private void effectMainRegion_State1Tr0() {
		exitSequenceMainRegion_State1();

		enterSequenceMainRegion_State2();
	}

	private void effectMainRegion_State2Tr0() {
		exitSequenceMainRegion_State2();

		enterSequenceMainRegion_State1();
	}

	private void effectMainRegion_State2_region0_aTr0() {
		exitSequenceMainRegion_State2_region0_a();

		enterSequenceMainRegion_State2_region0_State4();
	}

	private void effectMainRegion_State2_region0_State4Tr0() {
		exitSequenceMainRegion_State2_region0_State4();

		enterSequenceMainRegion_State2_region0_State5();
	}

	private void effectMainRegion_State2_region0_State4_region0_State6Tr0() {
		exitSequenceMainRegion_State2_region0_State4_region0_State6();

		enterSequenceMainRegion_State2_region0_State4_region0_State7();
	}

	private void effectMainRegion_State2_region0_State4_region0_State7Tr0() {
		exitSequenceMainRegion_State2_region0_State4_region0_State7();

		enterSequenceMainRegion_State2_region0_State4_region0_State6();
	}

	private void effectMainRegion_State2_region0_State4_region0_State7_region0_State8Tr0() {
		exitSequenceMainRegion_State2_region0_State4_region0_State7_region0_State8();

		enterSequenceMainRegion_State2_region0_State4_region0_State7_region0_State9();
	}

	private void effectMainRegion_State2_region0_State4_region0_State7_region0_State9Tr0() {
		exitSequenceMainRegion_State2_region0_State4_region0_State7_region0_State9();

		enterSequenceMainRegion_State2_region0_State4_region0_State7_region0_State8();
	}

	/* Entry action for statechart 'DeepHistory'. */
	private void entryAction() {
	}

	/* Exit action for state 'DeepHistory'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state State1 */
	private void enterSequenceMainRegion_State1() {
		nextStateIndex = 0;
		stateVector[0] = State.mainRegion_State1;
	}

	/* 'default' enter sequence for state State2 */
	private void enterSequenceMainRegion_State2() {
		enterSequenceMainRegion_State2_region0();
	}

	/* 'default' enter sequence for state a */
	private void enterSequenceMainRegion_State2_region0_a() {
		nextStateIndex = 0;
		stateVector[0] = State.mainRegion_State2__region0_a;

		historyVector[0] = stateVector[0];
	}

	/* 'default' enter sequence for state State4 */
	private void enterSequenceMainRegion_State2_region0_State4() {
		enterSequenceMainRegion_State2_region0_State4_region0();

		historyVector[0] = stateVector[0];
	}

	/* 'default' enter sequence for state State6 */
	private void enterSequenceMainRegion_State2_region0_State4_region0_State6() {
		nextStateIndex = 0;
		stateVector[0] = State.mainRegion_State2__region0_State4__region0_State6;

		historyVector[1] = stateVector[0];
	}

	/* 'default' enter sequence for state State7 */
	private void enterSequenceMainRegion_State2_region0_State4_region0_State7() {
		enterSequenceMainRegion_State2_region0_State4_region0_State7_region0();

		historyVector[1] = stateVector[0];
	}

	/* 'default' enter sequence for state State8 */
	private void enterSequenceMainRegion_State2_region0_State4_region0_State7_region0_State8() {
		nextStateIndex = 0;
		stateVector[0] = State.mainRegion_State2__region0_State4__region0_State7__region0_State8;

		historyVector[2] = stateVector[0];
	}

	/* 'default' enter sequence for state State9 */
	private void enterSequenceMainRegion_State2_region0_State4_region0_State7_region0_State9() {
		nextStateIndex = 0;
		stateVector[0] = State.mainRegion_State2__region0_State4__region0_State7__region0_State9;

		historyVector[2] = stateVector[0];
	}

	/* 'default' enter sequence for state State5 */
	private void enterSequenceMainRegion_State2_region0_State5() {
		nextStateIndex = 0;
		stateVector[0] = State.mainRegion_State2__region0_State5;

		historyVector[0] = stateVector[0];
	}

	/* 'default' enter sequence for region mainRegion */
	private void enterSequenceMainRegion() {
		reactDeepHistory_mainRegion__entry_Default();
	}

	/* 'default' enter sequence for region null */
	private void enterSequenceMainRegion_State2_region0() {
		reactDeepHistory_mainRegion_State2__region0__entry_Default();
	}

	/* deep enterSequence with history in child null */
	private void deepEnterSequenceMainRegion_State2_region0() {
		switch (historyVector[0]) {
			case mainRegion_State2__region0_a :
				enterSequenceMainRegion_State2_region0_a();
				break;

			case mainRegion_State2__region0_State4__region0_State6 :
				deepEnterSequenceMainRegion_State2_region0_State4_region0();
				break;

			case mainRegion_State2__region0_State4__region0_State7__region0_State8 :
				deepEnterSequenceMainRegion_State2_region0_State4_region0();
				break;

			case mainRegion_State2__region0_State4__region0_State7__region0_State9 :
				deepEnterSequenceMainRegion_State2_region0_State4_region0();
				break;

			case mainRegion_State2__region0_State5 :
				enterSequenceMainRegion_State2_region0_State5();
				break;

			default :
				break;
		}
	}

	/* 'default' enter sequence for region null */
	private void enterSequenceMainRegion_State2_region0_State4_region0() {
		reactDeepHistory_mainRegion_State2__region0_State4__region0__entry_Default();
	}

	/* deep enterSequence with history in child null */
	private void deepEnterSequenceMainRegion_State2_region0_State4_region0() {
		switch (historyVector[1]) {
			case mainRegion_State2__region0_State4__region0_State6 :
				enterSequenceMainRegion_State2_region0_State4_region0_State6();
				break;

			case mainRegion_State2__region0_State4__region0_State7__region0_State8 :
				deepEnterSequenceMainRegion_State2_region0_State4_region0_State7_region0();
				break;

			case mainRegion_State2__region0_State4__region0_State7__region0_State9 :
				deepEnterSequenceMainRegion_State2_region0_State4_region0_State7_region0();
				break;

			default :
				break;
		}
	}

	/* 'default' enter sequence for region null */
	private void enterSequenceMainRegion_State2_region0_State4_region0_State7_region0() {
		reactDeepHistory_mainRegion_State2__region0_State4__region0_State7__region0__entry_Default();
	}

	/* deep enterSequence with history in child null */
	private void deepEnterSequenceMainRegion_State2_region0_State4_region0_State7_region0() {
		switch (historyVector[2]) {
			case mainRegion_State2__region0_State4__region0_State7__region0_State8 :
				enterSequenceMainRegion_State2_region0_State4_region0_State7_region0_State8();
				break;

			case mainRegion_State2__region0_State4__region0_State7__region0_State9 :
				enterSequenceMainRegion_State2_region0_State4_region0_State7_region0_State9();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for state State1 */
	private void exitSequenceMainRegion_State1() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state State2 */
	private void exitSequenceMainRegion_State2() {
		exitSequenceMainRegion_State2_region0();
	}

	/* Default exit sequence for state a */
	private void exitSequenceMainRegion_State2_region0_a() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state State4 */
	private void exitSequenceMainRegion_State2_region0_State4() {
		exitSequenceMainRegion_State2_region0_State4_region0();
	}

	/* Default exit sequence for state State6 */
	private void exitSequenceMainRegion_State2_region0_State4_region0_State6() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state State7 */
	private void exitSequenceMainRegion_State2_region0_State4_region0_State7() {
		exitSequenceMainRegion_State2_region0_State4_region0_State7_region0();
	}

	/* Default exit sequence for state State8 */
	private void exitSequenceMainRegion_State2_region0_State4_region0_State7_region0_State8() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state State9 */
	private void exitSequenceMainRegion_State2_region0_State4_region0_State7_region0_State9() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state State5 */
	private void exitSequenceMainRegion_State2_region0_State5() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for region mainRegion */
	private void exitSequenceMainRegion() {
		switch (stateVector[0]) {
			case mainRegion_State1 :
				exitSequenceMainRegion_State1();
				break;

			case mainRegion_State2__region0_a :
				exitSequenceMainRegion_State2_region0_a();
				break;

			case mainRegion_State2__region0_State4__region0_State6 :
				exitSequenceMainRegion_State2_region0_State4_region0_State6();
				break;

			case mainRegion_State2__region0_State4__region0_State7__region0_State8 :
				exitSequenceMainRegion_State2_region0_State4_region0_State7_region0_State8();
				break;

			case mainRegion_State2__region0_State4__region0_State7__region0_State9 :
				exitSequenceMainRegion_State2_region0_State4_region0_State7_region0_State9();
				break;

			case mainRegion_State2__region0_State5 :
				exitSequenceMainRegion_State2_region0_State5();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region null */
	private void exitSequenceMainRegion_State2_region0() {
		switch (stateVector[0]) {
			case mainRegion_State2__region0_a :
				exitSequenceMainRegion_State2_region0_a();
				break;

			case mainRegion_State2__region0_State4__region0_State6 :
				exitSequenceMainRegion_State2_region0_State4_region0_State6();
				break;

			case mainRegion_State2__region0_State4__region0_State7__region0_State8 :
				exitSequenceMainRegion_State2_region0_State4_region0_State7_region0_State8();
				break;

			case mainRegion_State2__region0_State4__region0_State7__region0_State9 :
				exitSequenceMainRegion_State2_region0_State4_region0_State7_region0_State9();
				break;

			case mainRegion_State2__region0_State5 :
				exitSequenceMainRegion_State2_region0_State5();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region null */
	private void exitSequenceMainRegion_State2_region0_State4_region0() {
		switch (stateVector[0]) {
			case mainRegion_State2__region0_State4__region0_State6 :
				exitSequenceMainRegion_State2_region0_State4_region0_State6();
				break;

			case mainRegion_State2__region0_State4__region0_State7__region0_State8 :
				exitSequenceMainRegion_State2_region0_State4_region0_State7_region0_State8();
				break;

			case mainRegion_State2__region0_State4__region0_State7__region0_State9 :
				exitSequenceMainRegion_State2_region0_State4_region0_State7_region0_State9();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region null */
	private void exitSequenceMainRegion_State2_region0_State4_region0_State7_region0() {
		switch (stateVector[0]) {
			case mainRegion_State2__region0_State4__region0_State7__region0_State8 :
				exitSequenceMainRegion_State2_region0_State4_region0_State7_region0_State8();
				break;

			case mainRegion_State2__region0_State4__region0_State7__region0_State9 :
				exitSequenceMainRegion_State2_region0_State4_region0_State7_region0_State9();
				break;

			default :
				break;
		}
	}

	/* The reactions of state State1. */
	private void reactMainRegion_State1() {
		if (checkMainRegion_State1Tr0()) {
			effectMainRegion_State1Tr0();
		}
	}

	/* The reactions of state a. */
	private void reactMainRegion_State2_region0_a() {
		if (checkMainRegion_State2Tr0()) {
			effectMainRegion_State2Tr0();
		} else {
			if (checkMainRegion_State2_region0_aTr0()) {
				effectMainRegion_State2_region0_aTr0();
			}
		}
	}

	/* The reactions of state State6. */
	private void reactMainRegion_State2_region0_State4_region0_State6() {
		if (checkMainRegion_State2Tr0()) {
			effectMainRegion_State2Tr0();
		} else {
			if (checkMainRegion_State2_region0_State4Tr0()) {
				effectMainRegion_State2_region0_State4Tr0();
			} else {
				if (checkMainRegion_State2_region0_State4_region0_State6Tr0()) {
					effectMainRegion_State2_region0_State4_region0_State6Tr0();
				}
			}
		}
	}

	/* The reactions of state State8. */
	private void reactMainRegion_State2_region0_State4_region0_State7_region0_State8() {
		if (checkMainRegion_State2Tr0()) {
			effectMainRegion_State2Tr0();
		} else {
			if (checkMainRegion_State2_region0_State4Tr0()) {
				effectMainRegion_State2_region0_State4Tr0();
			} else {
				if (checkMainRegion_State2_region0_State4_region0_State7Tr0()) {
					effectMainRegion_State2_region0_State4_region0_State7Tr0();
				} else {
					if (checkMainRegion_State2_region0_State4_region0_State7_region0_State8Tr0()) {
						effectMainRegion_State2_region0_State4_region0_State7_region0_State8Tr0();
					}
				}
			}
		}
	}

	/* The reactions of state State9. */
	private void reactMainRegion_State2_region0_State4_region0_State7_region0_State9() {
		if (checkMainRegion_State2Tr0()) {
			effectMainRegion_State2Tr0();
		} else {
			if (checkMainRegion_State2_region0_State4Tr0()) {
				effectMainRegion_State2_region0_State4Tr0();
			} else {
				if (checkMainRegion_State2_region0_State4_region0_State7Tr0()) {
					effectMainRegion_State2_region0_State4_region0_State7Tr0();
				} else {
					if (checkMainRegion_State2_region0_State4_region0_State7_region0_State9Tr0()) {
						effectMainRegion_State2_region0_State4_region0_State7_region0_State9Tr0();
					}
				}
			}
		}
	}

	/* The reactions of state State5. */
	private void reactMainRegion_State2_region0_State5() {
		if (checkMainRegion_State2Tr0()) {
			effectMainRegion_State2Tr0();
		} else {
		}
	}

	/* Default react sequence for initial entry  */
	private void reactDeepHistory_mainRegion__entry_Default() {
		enterSequenceMainRegion_State1();
	}

	/* Default react sequence for initial entry  */
	private void reactDeepHistory_mainRegion_State2__region0_State4__region0__entry_Default() {
		enterSequenceMainRegion_State2_region0_State4_region0_State6();
	}

	/* Default react sequence for initial entry  */
	private void reactDeepHistory_mainRegion_State2__region0_State4__region0_State7__region0__entry_Default() {
		enterSequenceMainRegion_State2_region0_State4_region0_State7_region0_State8();
	}

	/* Default react sequence for deep history entry  */
	private void reactDeepHistory_mainRegion_State2__region0__entry_Default() {
		/* Enter the region with deep history */
		if (historyVector[0] != State.$NullState$) {
			deepEnterSequenceMainRegion_State2_region0();
		} else {
			enterSequenceMainRegion_State2_region0_a();
		}
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case mainRegion_State1 :
					reactMainRegion_State1();
					break;
				case mainRegion_State2__region0_a :
					reactMainRegion_State2_region0_a();
					break;
				case mainRegion_State2__region0_State4__region0_State6 :
					reactMainRegion_State2_region0_State4_region0_State6();
					break;
				case mainRegion_State2__region0_State4__region0_State7__region0_State8 :
					reactMainRegion_State2_region0_State4_region0_State7_region0_State8();
					break;
				case mainRegion_State2__region0_State4__region0_State7__region0_State9 :
					reactMainRegion_State2_region0_State4_region0_State7_region0_State9();
					break;
				case mainRegion_State2__region0_State5 :
					reactMainRegion_State2_region0_State5();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
