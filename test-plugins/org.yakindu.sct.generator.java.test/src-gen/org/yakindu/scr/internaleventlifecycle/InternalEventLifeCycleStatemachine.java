package org.yakindu.scr.internaleventlifecycle;

public class InternalEventLifeCycleStatemachine
		implements
			IInternalEventLifeCycleStatemachine {

	private boolean i1;

	private boolean i2;

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
		R1_A, R1_B, R2_C, R2_D, $NullState$
	};

	private final State[] stateVector = new State[2];

	private int nextStateIndex;

	public InternalEventLifeCycleStatemachine() {

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
		i1 = false;
		i2 = false;

	}

	protected void clearOutEvents() {
	}

	public boolean isStateActive(State state) {
		switch (state) {

			case R1_A :
				return stateVector[0] == State.R1_A;

			case R1_B :
				return stateVector[0] == State.R1_B;

			case R2_C :
				return stateVector[1] == State.R2_C;

			case R2_D :
				return stateVector[1] == State.R2_D;

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

	private void raiseI1() {
		i1 = true;
	}

	private void raiseI2() {
		i2 = true;
	}

	public void raiseE() {
		sCIDefault.raiseE();
	}

	public void raiseF() {
		sCIDefault.raiseF();
	}

	public void enter() {
		entryActionInternalEventLifeCycle();
		nextStateIndex = 0;
		stateVector[0] = State.R1_A;

		nextStateIndex = 1;
		stateVector[1] = State.R2_C;

	}

	public void exit() {
		//Handle exit of all possible states (of r1) at position 0...
		switch (stateVector[0]) {

			case R1_A :
				stateVector[0] = State.$NullState$;

				break;

			case R1_B :
				stateVector[0] = State.$NullState$;

				break;

			default :
				break;
		}

		//Handle exit of all possible states (of r2) at position 1...
		switch (stateVector[1]) {

			case R2_C :
				stateVector[1] = State.$NullState$;

				break;

			case R2_D :
				stateVector[1] = State.$NullState$;

				break;

			default :
				break;
		}

		exitActionInternalEventLifeCycle();
	}

	private void entryActionInternalEventLifeCycle() {

	}

	private void exitActionInternalEventLifeCycle() {

	}

	private void reactR1_A() {
		if (i2) {
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.R1_B;

		} else {
			if (sCIDefault.e) {
				raiseI1();

			}

		}

	}
	private void reactR1_B() {
		if (sCIDefault.e) {
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.R1_A;

		}

	}
	private void reactR2_C() {
		if (i1) {
			stateVector[1] = State.$NullState$;

			nextStateIndex = 1;
			stateVector[1] = State.R2_D;

		}
	}
	private void reactR2_D() {
		if (sCIDefault.f) {
			stateVector[1] = State.$NullState$;

			raiseI2();

			nextStateIndex = 1;
			stateVector[1] = State.R2_C;

		}
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case R1_A :
					reactR1_A();
					break;
				case R1_B :
					reactR1_B();
					break;
				case R2_C :
					reactR2_C();
					break;
				case R2_D :
					reactR2_D();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
