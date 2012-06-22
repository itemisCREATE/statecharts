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
		Main_region_A, Main_region_B, $NullState$
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
	}

	protected void clearEvents() {
		sCIMyInterface.clearEvents();

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

	public SCIMyInterface getSCIMyInterface() {
		return sCIMyInterface;
	}

	public void enter() {
		entryActionFeatureCalls();
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

		exitActionFeatureCalls();
	}

	private void entryActionFeatureCalls() {

	}

	private void exitActionFeatureCalls() {

	}

	private void reactMain_region_A() {
		if (sCIMyInterface.event1) {
			stateVector[0] = State.$NullState$;

			sCIMyInterface.setMyInt(42);

			sCIMyInterface.raiseEvent1();

			nextStateIndex = 0;
			stateVector[0] = State.Main_region_B;

		}

	}
	private void reactMain_region_B() {
		if (sCIMyInterface.event1) {
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
