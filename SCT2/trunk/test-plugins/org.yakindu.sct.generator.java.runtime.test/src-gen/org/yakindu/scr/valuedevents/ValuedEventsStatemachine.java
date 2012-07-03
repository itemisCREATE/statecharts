package org.yakindu.scr.valuedevents;

public class ValuedEventsStatemachine implements IValuedEventsStatemachine {

	private final class SCIDefaultImpl implements SCIDefault {

		private boolean integerEvent;

		private int integerEventValue;

		public void raiseIntegerEvent(int value) {
			integerEvent = true;
			integerEventValue = value;
		}

		private int getIntegerEventValue() {
			if (!integerEvent)
				throw new IllegalStateException(
						"Illegal event value acces. Event IntegerEvent is not raised!");
			return integerEventValue;
		}

		private int myVar;

		public int getMyVar() {
			return myVar;
		}

		public void setMyVar(int value) {
			this.myVar = value;
		}

		public void clearEvents() {
			integerEvent = false;
		}

	}

	private SCIDefaultImpl sCIDefault;

	public enum State {
		Main_region_A, _region1_B, _region1_C, $NullState$
	};

	private final State[] stateVector = new State[2];

	private int nextStateIndex;

	public ValuedEventsStatemachine() {

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

	public void raiseIntegerEvent(int value) {
		sCIDefault.raiseIntegerEvent(value);
	}

	public int getMyVar() {
		return sCIDefault.getMyVar();
	}

	public void setMyVar(int value) {
		sCIDefault.setMyVar(value);
	}

	public void enter() {
		entryActionValuedEvents();
		sCIDefault.raiseIntegerEvent((2 * 21));

		nextStateIndex = 0;
		stateVector[0] = State.Main_region_A;

		nextStateIndex = 1;
		stateVector[1] = State._region1_B;

	}

	public void exit() {
		//Handle exit of all possible states (of main region) at position 0...
		switch (stateVector[0]) {

			case Main_region_A :
				stateVector[0] = State.$NullState$;

				break;

			default :
				break;
		}

		//Handle exit of all possible states (of region1) at position 1...
		switch (stateVector[1]) {

			case _region1_B :
				stateVector[1] = State.$NullState$;

				break;

			case _region1_C :
				stateVector[1] = State.$NullState$;

				break;

			default :
				break;
		}

		exitActionValuedEvents();
	}

	private void entryActionValuedEvents() {

	}

	private void exitActionValuedEvents() {

	}

	private void reactMain_region_A() {

	}
	private void react_region1_B() {
		if (sCIDefault.integerEvent) {
			stateVector[1] = State.$NullState$;

			sCIDefault.setMyVar(sCIDefault.integerEventValue);

			nextStateIndex = 1;
			stateVector[1] = State._region1_C;

		}
	}
	private void react_region1_C() {
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case Main_region_A :
					reactMain_region_A();
					break;
				case _region1_B :
					react_region1_B();
					break;
				case _region1_C :
					react_region1_C();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
