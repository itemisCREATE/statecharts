package org.yakindu.scr.simpleevent;

public class SimpleEventStatemachine implements ISimpleEventStatemachine {

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
		Main_region_A, Main_region_B, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public SimpleEventStatemachine() {

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

	public void raiseEvent1() {
		sCIDefault.raiseEvent1();
	}

	public void enter() {
		entryActionSimpleEvent();
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

		exitActionSimpleEvent();
	}

	private void entryActionSimpleEvent() {

	}

	private void exitActionSimpleEvent() {

	}

	private void reactMain_region_A() {
		if (sCIDefault.event1) {
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.Main_region_B;

		}

	}
	private void reactMain_region_B() {

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
