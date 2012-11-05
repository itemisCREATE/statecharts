package org.yakindu.scr.alwaysoncycle;

public class AlwaysOncycleStatemachine implements IAlwaysOncycleStatemachine {

	private final class SCIDefaultImpl implements SCIDefault {

		private int value;

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		private boolean v2;

		public boolean getV2() {
			return v2;
		}

		public void setV2(boolean value) {
			this.v2 = value;
		}

	}

	private SCIDefaultImpl sCIDefault;

	public enum State {
		main_region_StateA, main_region_StateB, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public AlwaysOncycleStatemachine() {

		sCIDefault = new SCIDefaultImpl();

	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCIDefault.value = 0;

		sCIDefault.v2 = false;
	}

	public void enter() {
		entryAction();

		sCIDefault.value = 0;

		nextStateIndex = 0;
		stateVector[0] = State.main_region_StateA;
	}

	public void exit() {
		switch (stateVector[0]) {
			case main_region_StateA :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				sCIDefault.value = 0;
				break;

			case main_region_StateB :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			default :
				break;
		}

		exitAction();
	}

	protected void clearEvents() {

	}

	protected void clearOutEvents() {
	}

	public boolean isStateActive(State state) {
		switch (state) {
			case main_region_StateA :
				return stateVector[0] == State.main_region_StateA;
			case main_region_StateB :
				return stateVector[0] == State.main_region_StateB;
			default :
				return false;
		}
	}

	public SCIDefault getSCIDefault() {
		return sCIDefault;
	}

	public int getValue() {
		return sCIDefault.getValue();
	}

	public void setValue(int value) {
		sCIDefault.setValue(value);
	}
	public boolean getV2() {
		return sCIDefault.getV2();
	}

	public void setV2(boolean value) {
		sCIDefault.setV2(value);
	}

	/* Entry action for statechart 'AlwaysOncycle'. */
	private void entryAction() {
	}

	/* Exit action for state 'AlwaysOncycle'. */
	private void exitAction() {
	}

	/* The reactions of state StateA. */
	private void reactMain_region_StateA() {
		if (sCIDefault.value == 5) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			sCIDefault.value = 0;

			nextStateIndex = 0;
			stateVector[0] = State.main_region_StateB;
		} else {
			sCIDefault.value += 1;
		}
	}

	/* The reactions of state StateB. */
	private void reactMain_region_StateB() {
		if (sCIDefault.value == 5) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			sCIDefault.value = 0;

			nextStateIndex = 0;
			stateVector[0] = State.main_region_StateA;
		} else {
			sCIDefault.value += 1;
		}
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_StateA :
					reactMain_region_StateA();
					break;
				case main_region_StateB :
					reactMain_region_StateB();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
