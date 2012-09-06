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
		Main_region_A, Main_region_B, Main_region_B_r1_C1, Main_region_B_r1_C2, Main_region_B_r2_D1, Main_region_B_r2_D2, $NullState$
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

	protected void clearEvents() {
		sCIDefault.clearEvents();

	}

	protected void clearOutEvents() {
	}

	public boolean isStateActive(State state) {
		switch (state) {

			case Main_region_A :
				return stateVector[0] == State.Main_region_A;

			case Main_region_B :
				return stateVector[0].ordinal() >= State.Main_region_B
						.ordinal()
						&& stateVector[0].ordinal() <= State.Main_region_B_r2_D2
								.ordinal();

			case Main_region_B_r1_C1 :
				return stateVector[0] == State.Main_region_B_r1_C1;

			case Main_region_B_r1_C2 :
				return stateVector[0] == State.Main_region_B_r1_C2;

			case Main_region_B_r2_D1 :
				return stateVector[1] == State.Main_region_B_r2_D1;

			case Main_region_B_r2_D2 :
				return stateVector[1] == State.Main_region_B_r2_D2;

			default :
				return false;
		}
		/*
		for (int i=0;i<stateVector.length;i++){
			if (stateVector[i]==state) {
				return true;
			}
		}
		return false;
		 */
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

	public void enter() {
		entryActionSyncJoin();
		nextStateIndex = 0;
		stateVector[0] = State.Main_region_B_r1_C1;

		nextStateIndex = 1;
		stateVector[1] = State.Main_region_B_r2_D1;

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

		exitActionSyncJoin();
	}

	private void entryActionSyncJoin() {

	}

	private void exitActionSyncJoin() {

	}

	private void reactMain_region_A() {
		if ((sCIDefault.e || sCIDefault.f)) {
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.Main_region_B_r1_C1;

			nextStateIndex = 1;
			stateVector[1] = State.Main_region_B_r2_D1;

		}

	}
	private void reactMain_region_B() {
	}
	private void reactMain_region_B_r1_C1() {
		if (sCIDefault.e) {
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.Main_region_B_r1_C2;

		}

	}
	private void reactMain_region_B_r1_C2() {
		if (((sCIDefault.jc && isStateActive(State.Main_region_B_r2_D2)) && sCIDefault.jd)) {
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

			react_sync0_();
			react_sync0_();

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
		if (((sCIDefault.jd && isStateActive(State.Main_region_B_r1_C2)) && sCIDefault.jc)) {
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

			react_sync0_();
			react_sync0_();

		}
	}
	private void react_sync0_() {
		nextStateIndex = 0;
		stateVector[0] = State.Main_region_A;

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
