package org.yakindu.scr.featurecalls;

public class FeatureCallsStatemachine implements IFeatureCallsStatemachine {

	private final class SCIMyInterfaceImpl implements SCIMyInterface {

		private boolean event1;

		public void raiseEvent1() {
			event1 = true;
		}

		private int myInt;

		public int getMyInt() {
			return myInt;
		}

		public void setMyInt(int value) {
			this.myInt = value;
		}

		public void clearEvents() {
			event1 = false;
		}

	}

	private SCIMyInterfaceImpl sCIMyInterface;

	public enum State {
		main_region_A, main_region_B, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public FeatureCallsStatemachine() {

		sCIMyInterface = new SCIMyInterfaceImpl();

	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCIMyInterface.myInt = 0;
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

			default :
				break;
		}

		exitAction();
	}

	protected void clearEvents() {
		sCIMyInterface.clearEvents();

	}

	protected void clearOutEvents() {
	}

	public boolean isStateActive(State state) {
		switch (state) {
			case main_region_A :
				return stateVector[0] == State.main_region_A;
			case main_region_B :
				return stateVector[0] == State.main_region_B;
			default :
				return false;
		}
	}

	public SCIMyInterface getSCIMyInterface() {
		return sCIMyInterface;
	}

	/* Entry action for statechart 'FeatureCalls'. */
	private void entryAction() {
	}

	/* Exit action for state 'FeatureCalls'. */
	private void exitAction() {
	}

	/* The reactions of state A. */
	private void reactMain_region_A() {
		if (sCIMyInterface.event1) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			sCIMyInterface.myInt = 42;

			sCIMyInterface.raiseEvent1();

			nextStateIndex = 0;
			stateVector[0] = State.main_region_B;
		}
	}

	/* The reactions of state B. */
	private void reactMain_region_B() {
		if (sCIMyInterface.event1) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.main_region_A;
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
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
