package org.yakindu.scr.choice;

public class ChoiceStatemachine implements IChoiceStatemachine {

	private final class SCIDefaultImpl implements SCIDefault {

		private boolean pressKey;

		public void raisePressKey() {
			pressKey = true;
		}

		private int value;

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
		main_region_A, main_region_B, main_region_C, $NullState$
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

		sCIDefault.value = 4;
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

			case main_region_B :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_C :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
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
				return stateVector[0] == State.main_region_B;
			case main_region_C :
				return stateVector[0] == State.main_region_C;
			default :
				return false;
		}
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

	/* Entry action for statechart 'Choice'. */
	private void entryAction() {
	}

	/* Exit action for state 'Choice'. */
	private void exitAction() {
	}

	/* The reactions of state A. */
	private void reactMain_region_A() {
		if (sCIDefault.pressKey) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			if ((sCIDefault.value % 2) == 0) {
				sCIDefault.value -= 1;

				nextStateIndex = 0;
				stateVector[0] = State.main_region_B;
			} else {
				sCIDefault.value -= 1;

				nextStateIndex = 0;
				stateVector[0] = State.main_region_C;
			}
		}
	}

	/* The reactions of state B. */
	private void reactMain_region_B() {
		if (sCIDefault.pressKey) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.main_region_A;
		}
	}

	/* The reactions of state C. */
	private void reactMain_region_C() {
		if (sCIDefault.pressKey) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			if (sCIDefault.value == 2) {
				sCIDefault.value -= 1;

				nextStateIndex = 0;
				stateVector[0] = State.main_region_B;
			} else {
				nextStateIndex = 0;
				stateVector[0] = State.main_region_A;
			}
		}
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_A :
					reactMain_region_A();
					break;
				case main_region_B :
					reactMain_region_B();
					break;
				case main_region_C :
					reactMain_region_C();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
