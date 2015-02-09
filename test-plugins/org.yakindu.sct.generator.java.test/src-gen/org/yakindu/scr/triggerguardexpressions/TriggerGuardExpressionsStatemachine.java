package org.yakindu.scr.triggerguardexpressions;

public class TriggerGuardExpressionsStatemachine
		implements
			ITriggerGuardExpressionsStatemachine {

	static {
	}

	private final class SCInterfaceImpl implements SCInterface {

		private boolean e1;

		public void raiseE1() {
			e1 = true;
		}

		private boolean e2;

		public void raiseE2() {
			e2 = true;
		}

		private boolean b;
		public boolean getB() {
			return b;
		}

		public void setB(boolean value) {
			this.b = value;
		}

		public void clearEvents() {
			e1 = false;
			e2 = false;
		}

	}

	private SCInterfaceImpl sCInterface;

	public enum State {
		main_region_A, main_region_B, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public TriggerGuardExpressionsStatemachine() {

		sCInterface = new SCInterfaceImpl();
	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCInterface.b = false;
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

	public void raiseE1() {
		sCInterface.raiseE1();
	}
	public void raiseE2() {
		sCInterface.raiseE2();
	}

	public boolean getB() {
		return sCInterface.getB();
	}

	public void setB(boolean value) {
		sCInterface.setB(value);
	}

	private boolean checkMain_region_ATr0() {
		return (sCInterface.e1 || sCInterface.e2) && sCInterface.b;
	}

	private boolean checkMain_region_BTr0() {
		return true;
	}

	private void effectMain_region_ATr0() {
		exitSequenceMain_region_A();

		enterSequenceMain_region_B();
	}

	private void effectMain_region_BTr0() {
		exitSequenceMain_region_B();

		enterSequenceMain_region_A();
	}

	/* Entry action for statechart 'TriggerGuardExpressions'. */
	private void entryAction() {
	}

	/* Exit action for state 'TriggerGuardExpressions'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state A */
	private void enterSequenceMain_region_A() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_A;
	}

	/* 'default' enter sequence for state B */
	private void enterSequenceMain_region_B() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_B;
	}

	/* 'default' enter sequence for region main region */
	private void enterSequenceMain_region() {
		reactTriggerGuardExpressions_main_region__entry_Default();
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

	/* Default exit sequence for region main region */
	private void exitSequenceMain_region() {
		switch (stateVector[0]) {
			case main_region_A :
				exitSequenceMain_region_A();
				break;

			case main_region_B :
				exitSequenceMain_region_B();
				break;

			default :
				break;
		}
	}

	/* The reactions of state A. */
	private void reactMain_region_A() {
		if (checkMain_region_ATr0()) {
			effectMain_region_ATr0();
		}
	}

	/* The reactions of state B. */
	private void reactMain_region_B() {
		effectMain_region_BTr0();
	}

	/* Default react sequence for initial entry  */
	private void reactTriggerGuardExpressions_main_region__entry_Default() {
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
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
