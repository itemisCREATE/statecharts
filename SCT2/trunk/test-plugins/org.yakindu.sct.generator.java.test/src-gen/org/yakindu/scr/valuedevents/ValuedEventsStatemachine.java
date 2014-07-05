package org.yakindu.scr.valuedevents;

public class ValuedEventsStatemachine implements IValuedEventsStatemachine {

	private final class SCInterfaceImpl implements SCInterface {

		private boolean integerEvent;

		private long integerEventValue;

		public void raiseIntegerEvent(long value) {
			integerEvent = true;
			integerEventValue = value;
		}

		private long getIntegerEventValue() {
			if (!integerEvent)
				throw new IllegalStateException(
						"Illegal event value acces. Event IntegerEvent is not raised!");
			return integerEventValue;
		}

		private long myVar;

		public long getMyVar() {
			return myVar;
		}

		public void setMyVar(long value) {
			this.myVar = value;
		}

		public void clearEvents() {
			integerEvent = false;
		}

	}

	private SCInterfaceImpl sCInterface;

	public enum State {
		main_region_A, _region1_B, _region1_C, $NullState$
	};

	private final State[] stateVector = new State[2];

	private int nextStateIndex;

	public ValuedEventsStatemachine() {

		sCInterface = new SCInterfaceImpl();
	}

	public void init() {
		for (int i = 0; i < 2; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCInterface.myVar = 0;
	}

	public void enter() {
		entryAction();

		sCInterface.raiseIntegerEvent(2 * 21);

		nextStateIndex = 0;
		stateVector[0] = State.main_region_A;

		nextStateIndex = 1;
		stateVector[1] = State._region1_B;
	}

	public void exit() {
		switch (stateVector[0]) {
			case main_region_A :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			default :
				break;
		}

		switch (stateVector[1]) {
			case _region1_B :
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
				break;

			case _region1_C :
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
				break;

			default :
				break;
		}

		exitAction();
	}

	/**
	 * This method resets the incoming events (time events included).
	 */
	protected void clearEvents() {
		sCInterface.clearEvents();

	}

	/**
	 * This method resets the outgoing events.
	 */
	protected void clearOutEvents() {
	}

	/**
	 * Returns true if the given state is currently active otherwise false.
	 */
	public boolean isStateActive(State state) {
		switch (state) {
			case main_region_A :
				return stateVector[0] == State.main_region_A;
			case _region1_B :
				return stateVector[1] == State._region1_B;
			case _region1_C :
				return stateVector[1] == State._region1_C;
			default :
				return false;
		}
	}

	public SCInterface getSCInterface() {
		return sCInterface;
	}

	public void raiseIntegerEvent(long value) {
		sCInterface.raiseIntegerEvent(value);
	}

	public long getMyVar() {
		return sCInterface.getMyVar();
	}

	public void setMyVar(long value) {
		sCInterface.setMyVar(value);
	}

	/* Entry action for statechart 'ValuedEvents'. */
	private void entryAction() {
	}

	/* Exit action for state 'ValuedEvents'. */
	private void exitAction() {
	}

	/* The reactions of state A. */
	private void reactMain_region_A() {
	}

	/* The reactions of state B. */
	private void reactRegion1_B() {
		if (sCInterface.integerEvent) {
			nextStateIndex = 1;
			stateVector[1] = State.$NullState$;

			sCInterface.myVar = sCInterface.integerEventValue;

			nextStateIndex = 1;
			stateVector[1] = State._region1_C;
		}
	}

	/* The reactions of state C. */
	private void reactRegion1_C() {
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_A :
					reactMain_region_A();
					break;
				case _region1_B :
					reactRegion1_B();
					break;
				case _region1_C :
					reactRegion1_C();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
