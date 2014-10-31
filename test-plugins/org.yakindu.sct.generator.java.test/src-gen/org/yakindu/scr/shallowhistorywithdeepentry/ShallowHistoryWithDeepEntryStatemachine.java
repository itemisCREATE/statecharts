package org.yakindu.scr.shallowhistorywithdeepentry;

public class ShallowHistoryWithDeepEntryStatemachine
		implements
			IShallowHistoryWithDeepEntryStatemachine {

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

		nextStateIndex = 0;
		stateVector[0] = State.main_region_Y;
	}

	public void exit() {
		switch (stateVector[0]) {
			case main_region_Y :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_Z__region0_A :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_Z__region0_B__region0_C :
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

	/* Entry action for statechart 'ShallowHistoryWithDeepEntry'. */
	private void entryAction() {
	}

	/* Exit action for state 'ShallowHistoryWithDeepEntry'. */
	private void exitAction() {
	}

	/* shallow enterSequence with history in child null */
	private void shallowEnterSequenceMain_region_Z_region0() {
		switch (historyVector[0]) {
			case main_region_Z__region0_A :
				nextStateIndex = 0;
				stateVector[0] = State.main_region_Z__region0_A;

				historyVector[0] = stateVector[0];
				break;

			case main_region_Z__region0_B__region0_C :
				nextStateIndex = 0;
				stateVector[0] = State.main_region_Z__region0_B__region0_C;

				historyVector[0] = stateVector[0];
				break;

			default :
				break;
		}
	}

	/* The reactions of state Y. */
	private void reactMain_region_Y() {
		if (sCInterface.toZ) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			/* Enter the region with shallow history */
			if (historyVector[0] != State.$NullState$) {
				shallowEnterSequenceMain_region_Z_region0();
			} else {
				nextStateIndex = 0;
				stateVector[0] = State.main_region_Z__region0_A;

				historyVector[0] = stateVector[0];
			}
		} else {
			if (sCInterface.toC) {
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				nextStateIndex = 0;
				stateVector[0] = State.main_region_Z__region0_B__region0_C;

				historyVector[0] = stateVector[0];
			}
		}
	}

	/* The reactions of state A. */
	private void reactMain_region_Z_region0_A() {
		if (sCInterface.toY) {
			switch (stateVector[0]) {
				case main_region_Z__region0_A :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_Z__region0_B__region0_C :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				default :
					break;
			}

			nextStateIndex = 0;
			stateVector[0] = State.main_region_Y;
		} else {
			if (sCInterface.toC) {
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				nextStateIndex = 0;
				stateVector[0] = State.main_region_Z__region0_B__region0_C;

				historyVector[0] = stateVector[0];
			}
		}
	}

	/* The reactions of state C. */
	private void reactMain_region_Z_region0_B_region0_C() {
		if (sCInterface.toY) {
			switch (stateVector[0]) {
				case main_region_Z__region0_A :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_Z__region0_B__region0_C :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				default :
					break;
			}

			nextStateIndex = 0;
			stateVector[0] = State.main_region_Y;
		} else {
			if (sCInterface.toA) {
				switch (stateVector[0]) {
					case main_region_Z__region0_B__region0_C :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					default :
						break;
				}

				nextStateIndex = 0;
				stateVector[0] = State.main_region_Z__region0_A;

				historyVector[0] = stateVector[0];
			}
		}
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
