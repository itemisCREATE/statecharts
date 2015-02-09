package org.yakindu.scr.valuedevents;

public class ValuedEventsStatemachine implements IValuedEventsStatemachine {

	static {
	}

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

		enterSequence_main_region_default();

		enterSequence__region1_default();
	}

	public void exit() {
		exitSequence_main_region();

		exitSequence__region1();

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

	private boolean check__region1_B_tr0() {
		return sCInterface.integerEvent;
	}

	private void effect__region1_B_tr0() {
		exitSequence__region1_B();

		sCInterface.myVar = sCInterface.integerEventValue;

		enterSequence__region1_C_default();
	}

	/* Entry action for statechart 'ValuedEvents'. */
	private void entryAction() {
	}

	/* Entry action for state 'A'. */
	private void entryAction_main_region_A() {
		sCInterface.raiseIntegerEvent(2 * 21);
	}

	/* Exit action for state 'ValuedEvents'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state A */
	private void enterSequence_main_region_A_default() {
		entryAction_main_region_A();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_A;
	}

	/* 'default' enter sequence for state B */
	private void enterSequence__region1_B_default() {
		nextStateIndex = 1;
		stateVector[1] = State._region1_B;
	}

	/* 'default' enter sequence for state C */
	private void enterSequence__region1_C_default() {
		nextStateIndex = 1;
		stateVector[1] = State._region1_C;
	}

	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}

	/* 'default' enter sequence for region null */
	private void enterSequence__region1_default() {
		react__region1__entry_Default();
	}

	/* Default exit sequence for state A */
	private void exitSequence_main_region_A() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state B */
	private void exitSequence__region1_B() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state C */
	private void exitSequence__region1_C() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
			case main_region_A :
				exitSequence_main_region_A();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region null */
	private void exitSequence__region1() {
		switch (stateVector[1]) {
			case _region1_B :
				exitSequence__region1_B();
				break;

			case _region1_C :
				exitSequence__region1_C();
				break;

			default :
				break;
		}
	}

	/* The reactions of state A. */
	private void react_main_region_A() {
	}

	/* The reactions of state B. */
	private void react__region1_B() {
		if (check__region1_B_tr0()) {
			effect__region1_B_tr0();
		}
	}

	/* The reactions of state C. */
	private void react__region1_C() {
	}

	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_A_default();
	}

	/* Default react sequence for initial entry  */
	private void react__region1__entry_Default() {
		enterSequence__region1_B_default();
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_A :
					react_main_region_A();
					break;
				case _region1_B :
					react__region1_B();
					break;
				case _region1_C :
					react__region1_C();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
