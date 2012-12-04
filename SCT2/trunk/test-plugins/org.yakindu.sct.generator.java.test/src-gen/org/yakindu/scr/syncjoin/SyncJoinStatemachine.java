package org.yakindu.scr.syncjoin;

public class SyncJoinStatemachine implements ISyncJoinStatemachine {

	private final class SCIDefaultImpl implements SCIDefault {

		private boolean e;

		public void raiseE() {
			e = true;
		}

		private boolean f;

		public void raiseF() {
			f = true;
		}

		private boolean jc;

		public void raiseJc() {
			jc = true;
		}

		private boolean jd;

		public void raiseJd() {
			jd = true;
		}

		public void clearEvents() {
			e = false;
			f = false;
			jc = false;
			jd = false;
		}

	}

	private SCIDefaultImpl sCIDefault;

	public enum State {
		main_region_A, main_region_B, main_region_B_r1_C1, main_region_B_r1_C2, main_region_B_r2_D1, main_region_B_r2_D2, $NullState$
	};

	private final State[] stateVector = new State[2];

	private int nextStateIndex;

	public SyncJoinStatemachine() {

		sCIDefault = new SCIDefaultImpl();

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
		stateVector[0] = State.main_region_B_r1_C1;

		nextStateIndex = 1;
		stateVector[1] = State.main_region_B_r2_D1;
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

	protected void clearEvents() {
		sCIDefault.clearEvents();

	}

	protected void clearOutEvents() {
	}

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

	public SCIDefault getSCIDefault() {
		return sCIDefault;
	}

	public void raiseE() {
		sCIDefault.raiseE();
	}
	public void raiseF() {
		sCIDefault.raiseF();
	}
	public void raiseJc() {
		sCIDefault.raiseJc();
	}
	public void raiseJd() {
		sCIDefault.raiseJd();
	}

	/* Entry action for statechart 'SyncJoin'. */
	private void entryAction() {
	}

	/* Exit action for state 'SyncJoin'. */
	private void exitAction() {
	}

	/* The reactions of state A. */
	private void reactMain_region_A() {
		if (sCIDefault.e || sCIDefault.f) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.main_region_B_r1_C1;

			nextStateIndex = 1;
			stateVector[1] = State.main_region_B_r2_D1;
		}
	}

	/* The reactions of state C1. */
	private void reactMain_region_B_r1_C1() {
		if (sCIDefault.e) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.main_region_B_r1_C2;
		}
	}

	/* The reactions of state C2. */
	private void reactMain_region_B_r1_C2() {
		if (sCIDefault.jc && isStateActive(State.main_region_B_r2_D2)
				&& sCIDefault.jd) {
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

			reactSyncJoin_main_region__sync0();

			reactSyncJoin_main_region__sync0();
		}
	}

	/* The reactions of state D1. */
	private void reactMain_region_B_r2_D1() {
		if (sCIDefault.f) {
			nextStateIndex = 1;
			stateVector[1] = State.$NullState$;

			nextStateIndex = 1;
			stateVector[1] = State.main_region_B_r2_D2;
		}
	}

	/* The reactions of state D2. */
	private void reactMain_region_B_r2_D2() {
		if (sCIDefault.jd && isStateActive(State.main_region_B_r1_C2)
				&& sCIDefault.jc) {
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

			reactSyncJoin_main_region__sync0();

			reactSyncJoin_main_region__sync0();
		}
	}

	/* The reactions of state null. */
	private void reactSyncJoin_main_region__sync0() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_A;
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
