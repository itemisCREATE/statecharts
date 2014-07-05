package org.yakindu.scr.syncfork;

public class SyncForkStatemachine implements ISyncForkStatemachine {

	private final class SCInterfaceImpl implements SCInterface {

		private boolean e;

		public void raiseE() {
			e = true;
		}

		private boolean f;

		public void raiseF() {
			f = true;
		}

		public void clearEvents() {
			e = false;
			f = false;
		}

	}

	private SCInterfaceImpl sCInterface;

	public enum State {
		main_region_A, main_region_B, main_region_B_r1_C1, main_region_B_r1_C2, main_region_B_r2_D1, main_region_B_r2_D2, $NullState$
	};

	private final State[] stateVector = new State[2];

	private int nextStateIndex;

	public SyncForkStatemachine() {

		sCInterface = new SCInterfaceImpl();
	}

	public void init() {
		for (int i = 0; i < 2; i++) {
			stateVector[i] = State.$NullState$;
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

			case main_region_B_r1_C1 :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_B_r1_C2 :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			default :
				break;
		}

		switch (stateVector[1]) {
			case main_region_B_r2_D1 :
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
				break;

			case main_region_B_r2_D2 :
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
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
						&& stateVector[0].ordinal() <= State.main_region_B_r2_D2
								.ordinal();
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

	/* Entry action for statechart 'SyncFork'. */
	private void entryAction() {
	}

	/* Exit action for state 'SyncFork'. */
	private void exitAction() {
	}

	/* The reactions of state A. */
	private void reactMain_region_A() {
		if (sCInterface.e) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			reactSyncFork_main_region__sync0();
		} else {
			if (sCInterface.f) {
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				nextStateIndex = 0;
				stateVector[0] = State.main_region_B_r1_C1;

				nextStateIndex = 1;
				stateVector[1] = State.main_region_B_r2_D1;
			}
		}
	}

	/* The reactions of state C1. */
	private void reactMain_region_B_r1_C1() {
		if (sCInterface.e) {
			switch (stateVector[0]) {
				case main_region_B_r1_C1 :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_B_r1_C2 :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				default :
					break;
			}

			switch (stateVector[1]) {
				case main_region_B_r2_D1 :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				case main_region_B_r2_D2 :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				default :
					break;
			}

			nextStateIndex = 0;
			stateVector[0] = State.main_region_A;
		} else {
			if (sCInterface.f) {
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				nextStateIndex = 0;
				stateVector[0] = State.main_region_B_r1_C2;
			}
		}
	}

	/* The reactions of state C2. */
	private void reactMain_region_B_r1_C2() {
		if (sCInterface.e) {
			switch (stateVector[0]) {
				case main_region_B_r1_C1 :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_B_r1_C2 :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				default :
					break;
			}

			switch (stateVector[1]) {
				case main_region_B_r2_D1 :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				case main_region_B_r2_D2 :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				default :
					break;
			}

			nextStateIndex = 0;
			stateVector[0] = State.main_region_A;
		} else {
		}
	}

	/* The reactions of state D1. */
	private void reactMain_region_B_r2_D1() {
		if (sCInterface.f) {
			nextStateIndex = 1;
			stateVector[1] = State.$NullState$;

			nextStateIndex = 1;
			stateVector[1] = State.main_region_B_r2_D2;
		}
	}

	/* The reactions of state D2. */
	private void reactMain_region_B_r2_D2() {
	}

	/* The reactions of state null. */
	private void reactSyncFork_main_region__sync0() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_B_r1_C2;

		nextStateIndex = 1;
		stateVector[1] = State.main_region_B_r2_D2;
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_A :
					reactMain_region_A();
					break;
				case main_region_B_r1_C1 :
					reactMain_region_B_r1_C1();
					break;
				case main_region_B_r1_C2 :
					reactMain_region_B_r1_C2();
					break;
				case main_region_B_r2_D1 :
					reactMain_region_B_r2_D1();
					break;
				case main_region_B_r2_D2 :
					reactMain_region_B_r2_D2();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
