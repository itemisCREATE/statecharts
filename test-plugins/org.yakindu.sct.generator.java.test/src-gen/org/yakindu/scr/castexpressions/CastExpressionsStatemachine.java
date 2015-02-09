package org.yakindu.scr.castexpressions;

public class CastExpressionsStatemachine
		implements
			ICastExpressionsStatemachine {

	static {
	}

	private final class SCInterfaceImpl implements SCInterface {

		private double realValue;
		public double getRealValue() {
			return realValue;
		}

		public void setRealValue(double value) {
			this.realValue = value;
		}

		private long intValue;
		public long getIntValue() {
			return intValue;
		}

		public void setIntValue(long value) {
			this.intValue = value;
		}

	}

	private SCInterfaceImpl sCInterface;

	public enum State {
		main_region_A, main_region_B, main_region_C, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public CastExpressionsStatemachine() {

		sCInterface = new SCInterfaceImpl();
	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCInterface.realValue = (((double) 5));

		sCInterface.intValue = (((long) 5.5));
	}

	public void enter() {
		entryAction();

		enterSequenceMain_region();
	}

	public void exit() {
		exitSequenceMain_region();

		exitAction();
	}

	/**
	 * This method resets the incoming events (time events included).
	 */
	protected void clearEvents() {

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
			case main_region_B :
				return stateVector[0] == State.main_region_B;
			case main_region_C :
				return stateVector[0] == State.main_region_C;
			default :
				return false;
		}
	}

	public SCInterface getSCInterface() {
		return sCInterface;
	}

	public double getRealValue() {
		return sCInterface.getRealValue();
	}

	public void setRealValue(double value) {
		sCInterface.setRealValue(value);
	}
	public long getIntValue() {
		return sCInterface.getIntValue();
	}

	public void setIntValue(long value) {
		sCInterface.setIntValue(value);
	}

	private boolean checkMain_region_ATr0() {
		return true;
	}

	private boolean checkMain_region_BTr0() {
		return (true)
				&& ((double) (sCInterface.realValue * 0.1)) > ((long) 1.4)
				&& ((long) (sCInterface.realValue * sCInterface.intValue)) < ((double) 100);
	}

	private void effectMain_region_ATr0() {
		exitSequenceMain_region_A();

		enterSequenceMain_region_B();
	}

	private void effectMain_region_BTr0() {
		exitSequenceMain_region_B();

		enterSequenceMain_region_C();
	}

	/* Entry action for statechart 'CastExpressions'. */
	private void entryAction() {
	}

	/* Entry action for state 'B'. */
	private void entryActionMain_region_B() {
		sCInterface.realValue = 3 * ((long) 5.5);
	}

	/* Entry action for state 'C'. */
	private void entryActionMain_region_C() {
		sCInterface.realValue = ((long) (sCInterface.realValue
				* sCInterface.intValue * 10.1));
	}

	/* Exit action for state 'CastExpressions'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state A */
	private void enterSequenceMain_region_A() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_A;
	}

	/* 'default' enter sequence for state B */
	private void enterSequenceMain_region_B() {
		entryActionMain_region_B();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_B;
	}

	/* 'default' enter sequence for state C */
	private void enterSequenceMain_region_C() {
		entryActionMain_region_C();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_C;
	}

	/* 'default' enter sequence for region main region */
	private void enterSequenceMain_region() {
		reactCastExpressions_main_region__entry_Default();
	}

	/* Default exit sequence for state A */
	private void exitSequenceMain_region_A() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state B */
	private void exitSequenceMain_region_B() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state C */
	private void exitSequenceMain_region_C() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for region main region */
	private void exitSequenceMain_region() {
		switch (stateVector[0]) {
			case main_region_A :
				exitSequenceMain_region_A();
				break;

			case main_region_B :
				exitSequenceMain_region_B();
				break;

			case main_region_C :
				exitSequenceMain_region_C();
				break;

			default :
				break;
		}
	}

	/* The reactions of state A. */
	private void reactMain_region_A() {
		effectMain_region_ATr0();
	}

	/* The reactions of state B. */
	private void reactMain_region_B() {
		if (checkMain_region_BTr0()) {
			effectMain_region_BTr0();
		}
	}

	/* The reactions of state C. */
	private void reactMain_region_C() {
	}

	/* Default react sequence for initial entry  */
	private void reactCastExpressions_main_region__entry_Default() {
		enterSequenceMain_region_A();
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
