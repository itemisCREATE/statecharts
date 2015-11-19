package org.yakindu.scr.dynamicchoice;

public class DynamicChoiceStatemachine implements IDynamicChoiceStatemachine {

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

		enterSequence_main_region_default();
	}

	public void exit() {
		exitSequence_main_region();

		exitAction();
	}

	/**
	 * @see IStatemachine#isActive()
	 */
	@Override
	public boolean isActive() {

		return stateVector[0] != State.$NullState$;
	}

	/** 
	 * Always returns 'false' since this state machine can never become final.
	 *
	 * @see IStatemachine#isFinal() 
	 */
	@Override
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

	private boolean check_main_region_Start_tr0_tr0() {
		return true;
	}

	private boolean check_main_region__choice_0_tr0_tr0() {
		return sCInterface.number == 2;
	}

	private boolean check_main_region__choice_0_tr1() {
		return true;
	}

	private void effect_main_region_Start_tr0() {
		exitSequence_main_region_Start();

		sCInterface.number += 1;

		react_main_region__choice_0();
	}

	private void effect_main_region__choice_0_tr0() {
		enterSequence_main_region_A_default();
	}

	private void effect_main_region__choice_0_tr1() {
		enterSequence_main_region_B_default();
	}

	/* Entry action for statechart 'DynamicChoice'. */
	private void entryAction() {
	}

	/* Entry action for state 'Start'. */
	private void entryAction_main_region_Start() {
		sCInterface.number = 1;
	}

	/* Exit action for state 'DynamicChoice'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state Start */
	private void enterSequence_main_region_Start_default() {
		entryAction_main_region_Start();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_Start;
	}

	/* 'default' enter sequence for state A */
	private void enterSequence_main_region_A_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_A;
	}

	/* 'default' enter sequence for state B */
	private void enterSequence_main_region_B_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_B;
	}

	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}

	/* Default exit sequence for state Start */
	private void exitSequence_main_region_Start() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
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
			case main_region_Start :
				exitSequence_main_region_Start();
				break;

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

	/* The reactions of state Start. */
	private void react_main_region_Start() {
		effect_main_region_Start_tr0();
	}

	/* The reactions of state A. */
	private void react_main_region_A() {
	}

	/* The reactions of state B. */
	private void react_main_region_B() {
	}

	/* The reactions of state null. */
	private void react_main_region__choice_0() {
		if (check_main_region__choice_0_tr0_tr0()) {
			effect_main_region__choice_0_tr0();
		} else {
			effect_main_region__choice_0_tr1();
		}
	}

	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_Start_default();
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_Start :
					react_main_region_Start();
					break;
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
