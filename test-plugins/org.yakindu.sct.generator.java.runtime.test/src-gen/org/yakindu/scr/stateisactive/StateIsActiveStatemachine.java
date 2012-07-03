package org.yakindu.scr.stateisactive;

public class StateIsActiveStatemachine implements IStateIsActiveStatemachine {

	private final class SCIDefaultImpl implements SCIDefault {

		private boolean event1;

		public void raiseEvent1() {
			event1 = true;
		}

		public void clearEvents() {
			event1 = false;
		}

	}

	private SCIDefaultImpl sCIDefault;

	public enum State {
		R1_R1A, R1_R1B, R2_R2A, R2_R2B, $NullState$
	};

	private final State[] stateVector = new State[2];

	private int nextStateIndex;

	public StateIsActiveStatemachine() {

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

	public void raiseEvent1() {
		sCIDefault.raiseEvent1();
	}

	public void enter() {
		entryActionStateIsActive();
		nextStateIndex = 0;
		stateVector[0] = State.R1_R1A;

		nextStateIndex = 1;
		stateVector[1] = State.R2_R2A;

	}

	public void exit() {
		//Handle exit of all possible states (of R1) at position 0...
		switch (stateVector[0]) {

			case R1_R1A :
				stateVector[0] = State.$NullState$;

				break;

			case R1_R1B :
				stateVector[0] = State.$NullState$;

				break;

			default :
				break;
		}

		//Handle exit of all possible states (of R2) at position 1...
		switch (stateVector[1]) {

			case R2_R2A :
				stateVector[1] = State.$NullState$;

				break;

			case R2_R2B :
				stateVector[1] = State.$NullState$;

				break;

			default :
				break;
		}

		exitActionStateIsActive();
	}

	private void entryActionStateIsActive() {

	}

	private void exitActionStateIsActive() {

	}

	private void reactR1_R1A() {
		if (isStateActive(State.R2_R2B)) {
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.R1_R1B;

		}

	}
	private void reactR1_R1B() {

	}
	private void reactR2_R2A() {
		if (sCIDefault.event1) {
			stateVector[1] = State.$NullState$;

			nextStateIndex = 1;
			stateVector[1] = State.R2_R2B;

		}
	}
	private void reactR2_R2B() {
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case R1_R1A :
					reactR1_R1A();
					break;
				case R1_R1B :
					reactR1_R1B();
					break;
				case R2_R2A :
					reactR2_R2A();
					break;
				case R2_R2B :
					reactR2_R2B();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
