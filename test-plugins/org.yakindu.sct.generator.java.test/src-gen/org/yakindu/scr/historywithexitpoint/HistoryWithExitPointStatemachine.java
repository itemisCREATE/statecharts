package org.yakindu.scr.historywithexitpoint;

public class HistoryWithExitPointStatemachine
		implements
			IHistoryWithExitPointStatemachine {

	static {
	}

	private final class SCInterfaceImpl implements SCInterface {

		private boolean push;

		public void raisePush() {
			push = true;
		}

		private boolean back;

		public void raiseBack() {
			back = true;
		}

		private boolean next;

		public void raiseNext() {
			next = true;
		}

		public void clearEvents() {
			push = false;
			back = false;
			next = false;
		}

	}

	private SCInterfaceImpl sCInterface;

	public enum State {
		mr_A, mr_A_r_X1, mr_A_r_X2, mr_B, $NullState$
	};

	private State[] historyVector = new State[1];
	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public HistoryWithExitPointStatemachine() {

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

		enterSequenceMr();
	}

	public void exit() {
		exitSequenceMr();

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
			case mr_A :
				return stateVector[0].ordinal() >= State.mr_A.ordinal()
						&& stateVector[0].ordinal() <= State.mr_A_r_X2
								.ordinal();
			case mr_A_r_X1 :
				return stateVector[0] == State.mr_A_r_X1;
			case mr_A_r_X2 :
				return stateVector[0] == State.mr_A_r_X2;
			case mr_B :
				return stateVector[0] == State.mr_B;
			default :
				return false;
		}
	}

	public SCInterface getSCInterface() {
		return sCInterface;
	}

	public void raisePush() {
		sCInterface.raisePush();
	}
	public void raiseBack() {
		sCInterface.raiseBack();
	}
	public void raiseNext() {
		sCInterface.raiseNext();
	}

	private boolean checkMr_A_r_X1Tr0() {
		return sCInterface.next;
	}

	private boolean checkMr_A_r_X1Tr1() {
		return sCInterface.push;
	}

	private boolean checkMr_A_r_X2Tr0() {
		return sCInterface.next;
	}

	private boolean checkMr_A_r_X2Tr1() {
		return sCInterface.push;
	}

	private boolean checkMr_BTr0() {
		return sCInterface.back;
	}

	private void effectMr_ATr0() {
		exitSequenceMr_A();

		enterSequenceMr_B();
	}

	private void effectMr_A_r_X1Tr0() {
		exitSequenceMr_A_r_X1();

		enterSequenceMr_A_r_X2();
	}

	private void effectMr_A_r_X1Tr1() {
		exitSequenceMr_A_r_X1();

		reactHistoryWithExitPoint_mr_A_r_exit_to_B();
	}

	private void effectMr_A_r_X2Tr0() {
		exitSequenceMr_A_r_X2();

		enterSequenceMr_A_r_X1();
	}

	private void effectMr_A_r_X2Tr1() {
		exitSequenceMr_A_r_X2();

		reactHistoryWithExitPoint_mr_A_r_exit_to_B();
	}

	private void effectMr_BTr0() {
		exitSequenceMr_B();

		enterSequenceMr_A();
	}

	/* Entry action for statechart 'HistoryWithExitPoint'. */
	private void entryAction() {
	}

	/* Exit action for state 'HistoryWithExitPoint'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state A */
	private void enterSequenceMr_A() {
		enterSequenceMr_A_r();
	}

	/* 'default' enter sequence for state X1 */
	private void enterSequenceMr_A_r_X1() {
		nextStateIndex = 0;
		stateVector[0] = State.mr_A_r_X1;

		historyVector[0] = stateVector[0];
	}

	/* 'default' enter sequence for state X2 */
	private void enterSequenceMr_A_r_X2() {
		nextStateIndex = 0;
		stateVector[0] = State.mr_A_r_X2;

		historyVector[0] = stateVector[0];
	}

	/* 'default' enter sequence for state B */
	private void enterSequenceMr_B() {
		nextStateIndex = 0;
		stateVector[0] = State.mr_B;
	}

	/* 'default' enter sequence for region mr */
	private void enterSequenceMr() {
		reactHistoryWithExitPoint_mr__entry_Default();
	}

	/* 'default' enter sequence for region r */
	private void enterSequenceMr_A_r() {
		reactHistoryWithExitPoint_mr_A_r__entry_Default();
	}

	/* shallow enterSequence with history in child r */
	private void shallowEnterSequenceMr_A_r() {
		switch (historyVector[0]) {
			case mr_A_r_X1 :
				enterSequenceMr_A_r_X1();
				break;

			case mr_A_r_X2 :
				enterSequenceMr_A_r_X2();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for state A */
	private void exitSequenceMr_A() {
		exitSequenceMr_A_r();
	}

	/* Default exit sequence for state X1 */
	private void exitSequenceMr_A_r_X1() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state X2 */
	private void exitSequenceMr_A_r_X2() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state B */
	private void exitSequenceMr_B() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for region mr */
	private void exitSequenceMr() {
		switch (stateVector[0]) {
			case mr_A_r_X1 :
				exitSequenceMr_A_r_X1();
				break;

			case mr_A_r_X2 :
				exitSequenceMr_A_r_X2();
				break;

			case mr_B :
				exitSequenceMr_B();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region r */
	private void exitSequenceMr_A_r() {
		switch (stateVector[0]) {
			case mr_A_r_X1 :
				exitSequenceMr_A_r_X1();
				break;

			case mr_A_r_X2 :
				exitSequenceMr_A_r_X2();
				break;

			default :
				break;
		}
	}

	/* The reactions of state X1. */
	private void reactMr_A_r_X1() {
		if (checkMr_A_r_X1Tr0()) {
			effectMr_A_r_X1Tr0();
		} else {
			if (checkMr_A_r_X1Tr1()) {
				effectMr_A_r_X1Tr1();
			}
		}
	}

	/* The reactions of state X2. */
	private void reactMr_A_r_X2() {
		if (checkMr_A_r_X2Tr0()) {
			effectMr_A_r_X2Tr0();
		} else {
			if (checkMr_A_r_X2Tr1()) {
				effectMr_A_r_X2Tr1();
			}
		}
	}

	/* The reactions of state B. */
	private void reactMr_B() {
		if (checkMr_BTr0()) {
			effectMr_BTr0();
		}
	}

	/* Default react sequence for initial entry  */
	private void reactHistoryWithExitPoint_mr__entry_Default() {
		enterSequenceMr_A();
	}

	/* Default react sequence for shallow history entry  */
	private void reactHistoryWithExitPoint_mr_A_r__entry_Default() {
		/* Enter the region with shallow history */
		if (historyVector[0] != State.$NullState$) {
			shallowEnterSequenceMr_A_r();
		} else {
			enterSequenceMr_A_r_X1();
		}
	}

	/* The reactions of exit exit_to_B. */
	private void reactHistoryWithExitPoint_mr_A_r_exit_to_B() {
		effectMr_ATr0();
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case mr_A_r_X1 :
					reactMr_A_r_X1();
					break;
				case mr_A_r_X2 :
					reactMr_A_r_X2();
					break;
				case mr_B :
					reactMr_B();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
