package org.yakindu.scr.priorityvalues;

public class PriorityValuesStatemachine implements IPriorityValuesStatemachine {

	private final class SCIDefaultImpl implements SCIDefault {

		private boolean event1;

		public void raiseEvent1() {
			event1 = true;
		}

		private boolean event2;

		public void raiseEvent2() {
			event2 = true;
		}

		public void clearEvents() {
			event1 = false;
			event2 = false;
		}

	}

	private SCIDefaultImpl sCIDefault;

	public enum State {
		SomeRegion_A, SomeRegion_B, Main_region_A, Main_region_B, Main_region_C, Main_region_D, Main_region_E, $NullState$
	};

	private final State[] stateVector = new State[2];

	private int nextStateIndex;

	public PriorityValuesStatemachine() {

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

	public void raiseEvent2() {
		sCIDefault.raiseEvent2();
	}

	public void enter() {
		entryActionPriorityValues();
		nextStateIndex = 0;
		stateVector[0] = State.SomeRegion_A;

		nextStateIndex = 1;
		stateVector[1] = State.Main_region_A;

	}

	public void exit() {
		//Handle exit of all possible states (of someRegion) at position 0...
		switch (stateVector[0]) {

			case SomeRegion_A :
				stateVector[0] = State.$NullState$;

				break;

			case SomeRegion_B :
				stateVector[0] = State.$NullState$;

				break;

			default :
				break;
		}

		//Handle exit of all possible states (of main region) at position 1...
		switch (stateVector[1]) {

			case Main_region_A :
				stateVector[1] = State.$NullState$;

				break;

			case Main_region_B :
				stateVector[1] = State.$NullState$;

				break;

			case Main_region_C :
				stateVector[1] = State.$NullState$;

				break;

			case Main_region_D :
				stateVector[1] = State.$NullState$;

				break;

			case Main_region_E :
				stateVector[1] = State.$NullState$;

				break;

			default :
				break;
		}

		exitActionPriorityValues();
	}

	private void entryActionPriorityValues() {

	}

	private void exitActionPriorityValues() {

	}

	private void reactSomeRegion_A() {
		if (sCIDefault.event2) {
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.SomeRegion_B;

		}

	}
	private void reactSomeRegion_B() {

	}
	private void reactMain_region_A() {
		if (sCIDefault.event1) {
			stateVector[1] = State.$NullState$;

			nextStateIndex = 1;
			stateVector[1] = State.Main_region_C;

		} else {
			if (sCIDefault.event1) {
				stateVector[1] = State.$NullState$;

				nextStateIndex = 1;
				stateVector[1] = State.Main_region_B;

			} else {
				if (sCIDefault.event1) {
					stateVector[1] = State.$NullState$;

					nextStateIndex = 1;
					stateVector[1] = State.Main_region_D;

				} else {
					if ((sCIDefault.event2 && !isStateActive(State.SomeRegion_B))) {
						stateVector[1] = State.$NullState$;

						nextStateIndex = 1;
						stateVector[1] = State.Main_region_E;

					}
				}
			}
		}
	}
	private void reactMain_region_B() {
	}
	private void reactMain_region_C() {
	}
	private void reactMain_region_D() {
	}
	private void reactMain_region_E() {
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case SomeRegion_A :
					reactSomeRegion_A();
					break;
				case SomeRegion_B :
					reactSomeRegion_B();
					break;
				case Main_region_A :
					reactMain_region_A();
					break;
				case Main_region_B :
					reactMain_region_B();
					break;
				case Main_region_C :
					reactMain_region_C();
					break;
				case Main_region_D :
					reactMain_region_D();
					break;
				case Main_region_E :
					reactMain_region_E();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
