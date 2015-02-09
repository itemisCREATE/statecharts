package org.yakindu.scr.staticchoice;

public class StaticChoiceStatemachine implements IStaticChoiceStatemachine {

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
		main_region_Start, main_region_B, main_region_A, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public StaticChoiceStatemachine() {

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
			case main_region_B :
				return stateVector[0] == State.main_region_B;
			case main_region_A :
				return stateVector[0] == State.main_region_A;
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

	private boolean checkStaticChoice_main_region__choice_0Tr1() {
		return sCInterface.number == 2;
	}

	private boolean checkStaticChoice_main_region__choice_0Tr0() {
		return true;
	}

	private void effectMain_region_StartTr0() {
		exitSequenceMain_region_Start();

		sCInterface.number += 1;

		reactStaticChoice_main_region__choice_0();
	}

	private void effectStaticChoice_main_region__choice_0Tr1() {
		enterSequenceMain_region_A();
	}

	private void effectStaticChoice_main_region__choice_0Tr0() {
		enterSequenceMain_region_B();
	}

	/* Entry action for statechart 'StaticChoice'. */
	private void entryAction() {
	}

	/* Entry action for state 'Start'. */
	private void entryActionMain_region_Start() {
		sCInterface.number = 1;
	}

	/* Exit action for state 'StaticChoice'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state Start */
	private void enterSequenceMain_region_Start() {
		entryActionMain_region_Start();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_Start;
	}

	/* 'default' enter sequence for state B */
	private void enterSequenceMain_region_B() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_B;
	}

	/* 'default' enter sequence for state A */
	private void enterSequenceMain_region_A() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_A;
	}

	/* 'default' enter sequence for region main region */
	private void enterSequenceMain_region() {
		reactStaticChoice_main_region__entry_Default();
	}

	/* Default exit sequence for state Start */
	private void exitSequenceMain_region_Start() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state B */
	private void exitSequenceMain_region_B() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state A */
	private void exitSequenceMain_region_A() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for region main region */
	private void exitSequenceMain_region() {
		switch (stateVector[0]) {
			case main_region_Start :
				exitSequenceMain_region_Start();
				break;

			case main_region_B :
				exitSequenceMain_region_B();
				break;

			case main_region_A :
				exitSequenceMain_region_A();
				break;

			default :
				break;
		}
	}

	/* The reactions of state Start. */
	private void reactMain_region_Start() {
		effectMain_region_StartTr0();
	}

	/* The reactions of state B. */
	private void reactMain_region_B() {
	}

	/* The reactions of state A. */
	private void reactMain_region_A() {
	}

	/* The reactions of state null. */
	private void reactStaticChoice_main_region__choice_0() {
		if (checkStaticChoice_main_region__choice_0Tr1()) {
			effectStaticChoice_main_region__choice_0Tr1();
		} else {
			effectStaticChoice_main_region__choice_0Tr0();
		}
	}

	/* Default react sequence for initial entry  */
	private void reactStaticChoice_main_region__entry_Default() {
		enterSequenceMain_region_Start();
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_Start :
					reactMain_region_Start();
					break;
				case main_region_B :
					reactMain_region_B();
					break;
				case main_region_A :
					reactMain_region_A();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
