package org.yakindu.scr.castexpressions;

public class CastExpressionsStatemachine
		implements
			ICastExpressionsStatemachine {

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

	/* Entry action for statechart 'CastExpressions'. */
	private void entryAction() {
	}

	/* Exit action for state 'CastExpressions'. */
	private void exitAction() {
	}

	/* The reactions of state A. */
	private void reactMain_region_A() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		sCInterface.realValue = 3 * ((long) 5.5);

		nextStateIndex = 0;
		stateVector[0] = State.main_region_B;
	}

	/* The reactions of state B. */
	private void reactMain_region_B() {
		if (true
				&& ((double) (sCInterface.realValue * 0.1)) > ((long) 1.4)
				&& ((long) (sCInterface.realValue * sCInterface.intValue)) < ((double) 100)) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			sCInterface.realValue = ((long) (sCInterface.realValue
					* sCInterface.intValue * 10.1));

			nextStateIndex = 0;
			stateVector[0] = State.main_region_C;
		}
	}

	/* The reactions of state C. */
	private void reactMain_region_C() {
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
