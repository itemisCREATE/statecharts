package org.yakindu.scr.choice;

public class ChoiceStatemachine implements IChoiceStatemachine {

	private final class SCIDefaultImpl implements SCIDefault {

		private boolean pressKey;

		public void raisePressKey() {
			pressKey = true;
		}

		private int value = 4;

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public void clearEvents() {
			pressKey = false;
		}

	}

	private SCIDefaultImpl sCIDefault;

	public enum State {
		Main_region_A, Main_region_B, Main_region_C, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public ChoiceStatemachine() {

		sCIDefault = new SCIDefaultImpl();

	}

	public void init() {
		for (int i = 0; i < 1; i++) {
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
				return stateVector[0] == State.Main_region_B;

			case Main_region_C :
				return stateVector[0] == State.Main_region_C;

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

	public void raisePressKey() {
		sCIDefault.raisePressKey();
	}

	public int getValue() {
		return sCIDefault.getValue();
	}

	public void setValue(int value) {
		sCIDefault.setValue(value);
	}

	public void enter() {
		sCIDefault.value = 4;

		entryActionChoice();
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

			case Main_region_C :
				stateVector[0] = State.$NullState$;

				break;

			default :
				break;
		}

		exitActionChoice();
	}

	private void entryActionChoice() {

	}

	private void exitActionChoice() {

	}

	private void reactMain_region_A() {
		if (sCIDefault.pressKey) {
			stateVector[0] = State.$NullState$;

			if (((sCIDefault.value % 2) == 0)) {
				sCIDefault.value -= 1;

				nextStateIndex = 0;
				stateVector[0] = State.Main_region_B;

			} else {
				sCIDefault.value -= 1;

				nextStateIndex = 0;
				stateVector[0] = State.Main_region_C;

			}

		}

	}
	private void reactMain_region_B() {
		if (sCIDefault.pressKey) {
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.Main_region_A;

		}

	}
	private void reactMain_region_C() {
		if (sCIDefault.pressKey) {
			stateVector[0] = State.$NullState$;

			if ((sCIDefault.value == 2)) {
				sCIDefault.value -= 1;

				nextStateIndex = 0;
				stateVector[0] = State.Main_region_B;

			} else {
				nextStateIndex = 0;
				stateVector[0] = State.Main_region_A;

			}

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
				case Main_region_C :
					reactMain_region_C();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
