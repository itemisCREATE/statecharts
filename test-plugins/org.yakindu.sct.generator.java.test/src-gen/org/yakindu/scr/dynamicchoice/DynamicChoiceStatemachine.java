package org.yakindu.scr.dynamicchoice;

public class DynamicChoiceStatemachine implements IDynamicChoiceStatemachine {

	static {
	}

	private final class SCInterfaceImpl implements SCInterface {

		private boolean reset;

		public void raiseReset() {
			reset = true;
		}

		private long number;
		public long getNumber() {
			return number;
		}

		public void setNumber(long value) {
			this.number = value;
		}

		public void clearEvents() {
			reset = false;
		}

	}

	private SCInterfaceImpl sCInterface;

	public enum State {
		main_region_Start, main_region_A, main_region_B, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public DynamicChoiceStatemachine() {

		sCInterface = new SCInterfaceImpl();
	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCInterface.number = 0;
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
			case main_region_Start :
				return stateVector[0] == State.main_region_Start;
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

	public void raiseReset() {
		sCInterface.raiseReset();
	}

	public long getNumber() {
		return sCInterface.getNumber();
	}

	public void setNumber(long value) {
		sCInterface.setNumber(value);
	}

	private boolean checkMain_region_StartTr0() {
		return true;
	}

	private boolean checkDynamicChoice_main_region__choice_0Tr0() {
		return sCInterface.number == 2;
	}

	private boolean checkDynamicChoice_main_region__choice_0Tr1() {
		return true;
	}

	private void effectMain_region_StartTr0() {
		exitSequenceMain_region_Start();

		sCInterface.number += 1;

		reactDynamicChoice_main_region__choice_0();
	}

	private void effectDynamicChoice_main_region__choice_0Tr0() {
		enterSequenceMain_region_A();
	}

	private void effectDynamicChoice_main_region__choice_0Tr1() {
		enterSequenceMain_region_B();
	}

	/* Entry action for statechart 'DynamicChoice'. */
	private void entryAction() {
	}

	/* Entry action for state 'Start'. */
	private void entryActionMain_region_Start() {
		sCInterface.number = 1;
	}

	/* Exit action for state 'DynamicChoice'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state Start */
	private void enterSequenceMain_region_Start() {
		entryActionMain_region_Start();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_Start;
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
		reactDynamicChoice_main_region__entry_Default();
	}

	/* Default exit sequence for state Start */
	private void exitSequenceMain_region_Start() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
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
			case main_region_Start :
				exitSequenceMain_region_Start();
				break;

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

	/* The reactions of state Start. */
	private void reactMain_region_Start() {
		effectMain_region_StartTr0();
	}

	/* The reactions of state A. */
	private void reactMain_region_A() {
	}

	/* The reactions of state B. */
	private void reactMain_region_B() {
	}

	/* The reactions of state null. */
	private void reactDynamicChoice_main_region__choice_0() {
		if (checkDynamicChoice_main_region__choice_0Tr0()) {
			effectDynamicChoice_main_region__choice_0Tr0();
		} else {
			effectDynamicChoice_main_region__choice_0Tr1();
		}
	}

	/* Default react sequence for initial entry  */
	private void reactDynamicChoice_main_region__entry_Default() {
		enterSequenceMain_region_Start();
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_Start :
					reactMain_region_Start();
					break;
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
