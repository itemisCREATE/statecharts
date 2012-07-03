package org.yakindu.scr.guard;

public class GuardStatemachine implements IGuardStatemachine {

	private boolean event1;

	private boolean event2;

	private boolean eventReturn;

	public enum State {
		Main_region_A, Main_region_B, $NullState$
	};

	private int myVar = 0;

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public GuardStatemachine() {

	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();
	}

	protected void clearEvents() {

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

	private void raiseEvent1() {
		event1 = true;
	}

	private void raiseEvent2() {
		event2 = true;
	}

	private void raiseEventReturn() {
		eventReturn = true;
	}

	private int getMyVar() {
		return myVar;
	}

	private void setMyVar(int value) {
		myVar = value;
	}

	public void enter() {
		setMyVar(0);
		entryActionGuard();
		nextStateIndex = 0;
		stateVector[0] = State.Main_region_A;

	}

	public void exit() {
		//Handle exit of all possible states (of main region) at position 0...
		switch (stateVector[0]) {

			case Main_region_A :
				stateVector[0] = State.$NullState$;

				break;

			case Main_region_B :
				stateVector[0] = State.$NullState$;

				break;

			default :
				break;
		}

		exitActionGuard();
	}

	private void entryActionGuard() {

	}

	private void exitActionGuard() {

	}

	private void reactMain_region_A() {
		if ((event1 && (getMyVar() == 10))) {
			stateVector[0] = State.$NullState$;

			setMyVar(10);

			nextStateIndex = 0;
			stateVector[0] = State.Main_region_B;

		} else {
			if (event2) {
				stateVector[0] = State.$NullState$;

				setMyVar(10);

				nextStateIndex = 0;
				stateVector[0] = State.Main_region_B;

			}
		}

	}
	private void reactMain_region_B() {
		if (eventReturn) {
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.Main_region_A;

		}

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
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
