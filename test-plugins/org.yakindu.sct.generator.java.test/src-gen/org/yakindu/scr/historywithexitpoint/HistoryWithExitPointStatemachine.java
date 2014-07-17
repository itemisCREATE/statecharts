package org.yakindu.scr.historywithexitpoint;

public class HistoryWithExitPointStatemachine
		implements
			IHistoryWithExitPointStatemachine {

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

		/* Enter the region with shallow history */
		if (historyVector[0] != State.$NullState$) {
			shallowEnterSequenceMr_A_r();
		} else {
			nextStateIndex = 0;
			stateVector[0] = State.mr_A_r_X1;

			historyVector[0] = stateVector[0];
		}
	}

	public void exit() {
		switch (stateVector[0]) {
			case mr_A_r_X1 :
				historyVector[0] = stateVector[0];

				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case mr_A_r_X2 :
				historyVector[0] = stateVector[0];

				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case mr_B :
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

	/* Entry action for statechart 'HistoryWithExitPoint'. */
	private void entryAction() {
	}

	/* Exit action for state 'HistoryWithExitPoint'. */
	private void exitAction() {
	}

	/* shallow enterSequence with history in child r */
	private void shallowEnterSequenceMr_A_r() {
		switch (historyVector[0]) {
			case mr_A_r_X1 :
				nextStateIndex = 0;
				stateVector[0] = State.mr_A_r_X1;

				historyVector[0] = stateVector[0];
				break;

			case mr_A_r_X2 :
				nextStateIndex = 0;
				stateVector[0] = State.mr_A_r_X2;

				historyVector[0] = stateVector[0];
				break;

			default :
				break;
		}
	}

	/* The reactions of state X1. */
	private void reactMr_A_r_X1() {
		if (sCInterface.next) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.mr_A_r_X2;

			historyVector[0] = stateVector[0];
		} else {
			if (sCInterface.push) {
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				switch (stateVector[0]) {
					case mr_A_r_X1 :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					case mr_A_r_X2 :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					default :
						break;
				}

				nextStateIndex = 0;
				stateVector[0] = State.mr_B;
			}
		}
	}

	/* The reactions of state X2. */
	private void reactMr_A_r_X2() {
		if (sCInterface.next) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.mr_A_r_X1;

			historyVector[0] = stateVector[0];
		} else {
			if (sCInterface.push) {
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				switch (stateVector[0]) {
					case mr_A_r_X1 :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					case mr_A_r_X2 :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					default :
						break;
				}

				nextStateIndex = 0;
				stateVector[0] = State.mr_B;
			}
		}
	}

	/* The reactions of state B. */
	private void reactMr_B() {
		if (sCInterface.back) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			/* Enter the region with shallow history */
			if (historyVector[0] != State.$NullState$) {
				shallowEnterSequenceMr_A_r();
			} else {
				nextStateIndex = 0;
				stateVector[0] = State.mr_A_r_X1;

				historyVector[0] = stateVector[0];
			}
		}
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
