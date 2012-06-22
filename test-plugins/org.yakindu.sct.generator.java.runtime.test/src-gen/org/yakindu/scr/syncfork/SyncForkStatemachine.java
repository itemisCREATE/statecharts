package org.yakindu.scr.syncfork;

public class SyncForkStatemachine implements ISyncForkStatemachine {

	private final class SCIDefaultImpl implements SCIDefault {

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

	private SCIDefaultImpl sCIDefault;

	public enum State {
		Main_region_A, Main_region_B, Main_region_B_r1_C1, Main_region_B_r1_C2, Main_region_B_r2_D1, Main_region_B_r2_D2, $NullState$
	};

	private final State[] stateVector = new State[2];

	private int nextStateIndex;

	public SyncForkStatemachine() {

		sCIDefault = new SCIDefaultImpl();

	}

	public void init() {
		for (int i = 0; i < 2; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();
	}

	protected void clearEvents() {
		sCIDefault.clearEvents();

	}

	protected void clearOutEvents() {
	}

	public boolean isStateActive(State state) {
		for (int i = 0; i < stateVector.length; i++) {
			if (stateVector[i] == state) {
				return true;
			}
		}
		return false;
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

	public void enter() {
		entryActionSyncFork();
		nextStateIndex = 0;
		stateVector[0] = State.Main_region_A;

	}

	public void exit() {
		//Handle exit of all possible states (of main region) at position 0...
		switch (stateVector[0]) {

			case Main_region_A :
				stateVector[0] = State.$NullState$;

				break;

			case Main_region_B_r1_C1 :
				stateVector[0] = State.$NullState$;

				break;

			case Main_region_B_r1_C2 :
				stateVector[0] = State.$NullState$;

				break;

			default :
				break;
		}
		//Handle exit of all possible states (of main region) at position 1...
		switch (stateVector[1]) {

			case Main_region_B_r2_D1 :
				stateVector[1] = State.$NullState$;

				break;

			case Main_region_B_r2_D2 :
				stateVector[1] = State.$NullState$;

				break;

			default :
				break;
		}

		exitActionSyncFork();
	}

	private void entryActionSyncFork() {

	}

	private void exitActionSyncFork() {

	}

	private void reactMain_region_A() {
		if (sCIDefault.e) {
			stateVector[0] = State.$NullState$;

			react_sync0_();

		} else {
			if (sCIDefault.f) {
				stateVector[0] = State.$NullState$;

				nextStateIndex = 0;
				stateVector[0] = State.Main_region_B_r1_C1;

				nextStateIndex = 1;
				stateVector[1] = State.Main_region_B_r2_D1;

			}
		}

	}
	private void reactMain_region_B() {
	}
	private void reactMain_region_B_r1_C1() {
		if (sCIDefault.e) {
			//Handle exit of all possible states (of r1) at position 0...
			switch (stateVector[0]) {

				case Main_region_B_r1_C1 :
					stateVector[0] = State.$NullState$;

					break;

				case Main_region_B_r1_C2 :
					stateVector[0] = State.$NullState$;

					break;

				default :
					break;
			}

			//Handle exit of all possible states (of r2) at position 1...
			switch (stateVector[1]) {

				case Main_region_B_r2_D1 :
					stateVector[1] = State.$NullState$;

					break;

				case Main_region_B_r2_D2 :
					stateVector[1] = State.$NullState$;

					break;

				default :
					break;
			}

			nextStateIndex = 0;
			stateVector[0] = State.Main_region_A;

		} else {
			if (sCIDefault.f) {
				stateVector[0] = State.$NullState$;

				nextStateIndex = 0;
				stateVector[0] = State.Main_region_B_r1_C2;

			}

		}

	}
	private void reactMain_region_B_r1_C2() {
		if (sCIDefault.e) {
			//Handle exit of all possible states (of r1) at position 0...
			switch (stateVector[0]) {

				case Main_region_B_r1_C1 :
					stateVector[0] = State.$NullState$;

					break;

				case Main_region_B_r1_C2 :
					stateVector[0] = State.$NullState$;

					break;

				default :
					break;
			}

			//Handle exit of all possible states (of r2) at position 1...
			switch (stateVector[1]) {

				case Main_region_B_r2_D1 :
					stateVector[1] = State.$NullState$;

					break;

				case Main_region_B_r2_D2 :
					stateVector[1] = State.$NullState$;

					break;

				default :
					break;
			}

			nextStateIndex = 0;
			stateVector[0] = State.Main_region_A;

		} else {

		}

	}
	private void reactMain_region_B_r2_D1() {
		if (sCIDefault.f) {
			stateVector[1] = State.$NullState$;

			nextStateIndex = 1;
			stateVector[1] = State.Main_region_B_r2_D2;

		}
	}
	private void reactMain_region_B_r2_D2() {
	}
	private void react_sync0_() {
		nextStateIndex = 0;
		stateVector[0] = State.Main_region_B_r1_C2;

		nextStateIndex = 1;
		stateVector[1] = State.Main_region_B_r2_D1;

	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case Main_region_A :
					reactMain_region_A();
					break;
				case Main_region_B :
					reactMain_region_B();
					break;
				case Main_region_B_r1_C1 :
					reactMain_region_B_r1_C1();
					break;
				case Main_region_B_r1_C2 :
					reactMain_region_B_r1_C2();
					break;
				case Main_region_B_r2_D1 :
					reactMain_region_B_r2_D1();
					break;
				case Main_region_B_r2_D2 :
					reactMain_region_B_r2_D2();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
