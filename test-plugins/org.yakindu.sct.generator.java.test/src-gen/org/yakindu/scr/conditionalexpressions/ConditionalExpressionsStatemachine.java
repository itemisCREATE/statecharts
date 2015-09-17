package org.yakindu.scr.conditionalexpressions;

public class ConditionalExpressionsStatemachine implements IConditionalExpressionsStatemachine {

	protected class SCInterfaceImpl implements SCInterface {

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

		protected void clearEvents() {
			e = false;
		}

	}

	protected SCInterfaceImpl sCInterface;

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

		sCInterface.setCondition(sCInterface.boolVar ? 3 : 2);

		sCInterface.setBoolVar(true);
	}

	public void enter() {
		entryAction();

		enterSequence_main_region_default();
	}

	public void exit() {
		exitSequence_main_region();

		exitAction();
	}

	/**
	 * @see IStatemachine#isActive()
	 */
	public boolean isActive() {

		return stateVector[0] != State.$NullState$;
	}

	/** 
	* Always returns 'false' since this state machine can never become final.
	*
	 * @see IStatemachine#isFinal() 
	 */
	public boolean isFinal() {
		return false;
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

	private boolean check_main_region_A_tr0_tr0() {
		return (sCInterface.e) && 1 == (sCInterface.getBoolVar() ? 1 : 0);
	}

	private void effect_main_region_A_tr0() {
		exitSequence_main_region_A();

		enterSequence_main_region_B_default();
	}

	/* Entry action for statechart 'ConditionalExpressions'. */
	private void entryAction() {
	}

	/* Entry action for state 'A'. */
	private void entryAction_main_region_A() {
		sCInterface.setCondition(sCInterface.boolVar ? 1 : 0);
	}

	/* Entry action for state 'B'. */
	private void entryAction_main_region_B() {
		sCInterface.setCondition(((sCInterface.condition == 2) ? 1 : 2));
	}

	/* Exit action for state 'ConditionalExpressions'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state A */
	private void enterSequence_main_region_A_default() {
		entryAction_main_region_A();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_A;
	}

	/* 'default' enter sequence for state B */
	private void enterSequence_main_region_B_default() {
		entryAction_main_region_B();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_B;
	}

	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}

	/* Default exit sequence for state A */
	private void exitSequence_main_region_A() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state B */
	private void exitSequence_main_region_B() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
			case main_region_A :
				exitSequence_main_region_A();
				break;

			case main_region_B :
				exitSequence_main_region_B();
				break;

			default :
				break;
		}
	}

	/* The reactions of state A. */
	private void react_main_region_A() {
		if (check_main_region_A_tr0_tr0()) {
			effect_main_region_A_tr0();
		}
	}

	/* The reactions of state B. */
	private void react_main_region_B() {
	}

	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_A_default();
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_A :
					react_main_region_A();
					break;
				case main_region_B :
					react_main_region_B();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
