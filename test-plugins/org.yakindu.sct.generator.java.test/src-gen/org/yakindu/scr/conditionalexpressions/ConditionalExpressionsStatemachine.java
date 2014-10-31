package org.yakindu.scr.conditionalexpressions;

public class ConditionalExpressionsStatemachine
		implements
			IConditionalExpressionsStatemachine {

	private final class SCInterfaceImpl implements SCInterface {

		private boolean e;

		public void raiseE() {
			e = true;
		}

		private long condition;

		public long getCondition() {
			return condition;
		}

		public void setCondition(long value) {
			this.condition = value;
		}

		private boolean boolVar;

		public boolean getBoolVar() {
			return boolVar;
		}

		public void setBoolVar(boolean value) {
			this.boolVar = value;
		}

		public void clearEvents() {
			e = false;
		}

	}

	private SCInterfaceImpl sCInterface;

	public enum State {
		main_region_A, main_region_B, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public ConditionalExpressionsStatemachine() {

		sCInterface = new SCInterfaceImpl();
	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCInterface.condition = sCInterface.boolVar ? 3 : 2;

		sCInterface.boolVar = true;
	}

	public void enter() {
		entryAction();

		sCInterface.condition = sCInterface.boolVar ? 1 : 0;

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
			case main_region_B :
				return stateVector[0] == State.main_region_B;
			default :
				return false;
		}
	}

	public SCInterface getSCInterface() {
		return sCInterface;
	}

	public void raiseE() {
		sCInterface.raiseE();
	}

	public long getCondition() {
		return sCInterface.getCondition();
	}

	public void setCondition(long value) {
		sCInterface.setCondition(value);
	}
	public boolean getBoolVar() {
		return sCInterface.getBoolVar();
	}

	public void setBoolVar(boolean value) {
		sCInterface.setBoolVar(value);
	}

	/* Entry action for statechart 'ConditionalExpressions'. */
	private void entryAction() {
	}

	/* Exit action for state 'ConditionalExpressions'. */
	private void exitAction() {
	}

	/* The reactions of state A. */
	private void reactMain_region_A() {
		if (sCInterface.e && 1 == (sCInterface.boolVar ? 1 : 0)) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			sCInterface.condition = ((sCInterface.condition == 2) ? 1 : 2);

			nextStateIndex = 0;
			stateVector[0] = State.main_region_B;
		}
	}

	/* The reactions of state B. */
	private void reactMain_region_B() {
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
