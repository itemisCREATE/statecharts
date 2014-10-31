package org.yakindu.scr.historywithoutinitialstep;

public class HistoryWithoutInitialStepStatemachine
		implements
			IHistoryWithoutInitialStepStatemachine {

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

		nextStateIndex = 0;
		stateVector[0] = State.main_region_A;
	}

	public void exit() {
		switch (stateVector[0]) {
			case main_region_A :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_B_r1_C :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_B_r1_D :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_B_r1_E__region0_F :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			default :
				break;
		}

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

	/* Entry action for statechart 'HistoryWithoutInitialStep'. */
	private void entryAction() {
	}

	/* Exit action for state 'HistoryWithoutInitialStep'. */
	private void exitAction() {
	}

	/* shallow enterSequence with history in child r1 */
	private void shallowEnterSequenceMain_region_B_r1() {
		switch (historyVector[0]) {
			case main_region_B_r1_C :
				nextStateIndex = 0;
				stateVector[0] = State.main_region_B_r1_C;

				historyVector[0] = stateVector[0];
				break;

			case main_region_B_r1_D :
				nextStateIndex = 0;
				stateVector[0] = State.main_region_B_r1_D;

				historyVector[0] = stateVector[0];
				break;

			case main_region_B_r1_E__region0_F :
				nextStateIndex = 0;
				stateVector[0] = State.main_region_B_r1_E__region0_F;

				historyVector[0] = stateVector[0];
				break;

			default :
				break;
		}
	}

	/* The reactions of state A. */
	private void reactMain_region_A() {
		if (sCInterface.toB) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.main_region_B_r1_C;

			historyVector[0] = stateVector[0];
		} else {
			if (sCInterface.toHistory) {
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				/* Enter the region with shallow history */
				if (historyVector[0] != State.$NullState$) {
					shallowEnterSequenceMain_region_B_r1();
				}
			}
		}
	}

	/* The reactions of state C. */
	private void reactMain_region_B_r1_C() {
		if (sCInterface.toA) {
			switch (stateVector[0]) {
				case main_region_B_r1_C :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_B_r1_D :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_B_r1_E__region0_F :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				default :
					break;
			}

			nextStateIndex = 0;
			stateVector[0] = State.main_region_A;
		} else {
			if (sCInterface.next) {
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				nextStateIndex = 0;
				stateVector[0] = State.main_region_B_r1_D;

				historyVector[0] = stateVector[0];
			}
		}
	}

	/* The reactions of state D. */
	private void reactMain_region_B_r1_D() {
		if (sCInterface.toA) {
			switch (stateVector[0]) {
				case main_region_B_r1_C :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_B_r1_D :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_B_r1_E__region0_F :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				default :
					break;
			}

			nextStateIndex = 0;
			stateVector[0] = State.main_region_A;
		} else {
			if (sCInterface.next) {
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				nextStateIndex = 0;
				stateVector[0] = State.main_region_B_r1_E__region0_F;

				historyVector[0] = stateVector[0];
			}
		}
	}

	/* The reactions of state F. */
	private void reactMain_region_B_r1_E_region0_F() {
		if (sCInterface.toA) {
			switch (stateVector[0]) {
				case main_region_B_r1_C :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_B_r1_D :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_B_r1_E__region0_F :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				default :
					break;
			}

			nextStateIndex = 0;
			stateVector[0] = State.main_region_A;
		} else {
			if (sCInterface.next) {
				switch (stateVector[0]) {
					case main_region_B_r1_E__region0_F :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					default :
						break;
				}

				nextStateIndex = 0;
				stateVector[0] = State.main_region_B_r1_C;

				historyVector[0] = stateVector[0];
			} else {
			}
		}
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
