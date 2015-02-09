package org.yakindu.scr.simpleevent;

public class SimpleEventStatemachine implements ISimpleEventStatemachine {

	static {
	}

	private final class SCInterfaceImpl implements SCInterface {

		private boolean event1;

		public void raiseEvent1() {
			event1 = true;
		}

		public void clearEvents() {
			event1 = false;
		}

	}

	private SCInterfaceImpl sCInterface;

	public enum State {
		main_region_A, main_region_B, main_region__final_, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public SimpleEventStatemachine() {

		sCInterface = new SCInterfaceImpl();
	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

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
			case main_region__final_ :
				return stateVector[0] == State.main_region__final_;
			default :
				return false;
		}
	}

	public SCInterface getSCInterface() {
		return sCInterface;
	}

	public void raiseEvent1() {
		sCInterface.raiseEvent1();
	}

	private boolean checkMain_region_ATr0() {
		return sCInterface.event1;
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

		enterSequenceMain_region__final_0();
	}

	/* Entry action for statechart 'SimpleEvent'. */
	private void entryAction() {
	}

	/* Exit action for state 'SimpleEvent'. */
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

	/* Default enter sequence for state null */
	private void enterSequenceMain_region__final_0() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region__final_;
	}

	/* 'default' enter sequence for region main region */
	private void enterSequenceMain_region() {
		reactSimpleEvent_main_region__entry_Default();
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

	/* Default exit sequence for final state. */
	private void exitSequenceMain_region__final_0() {
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

			case main_region__final_ :
				exitSequenceMain_region__final_0();
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

	/* The reactions of state null. */
	private void reactMain_region__final_0() {
	}

	/* Default react sequence for initial entry  */
	private void reactSimpleEvent_main_region__entry_Default() {
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
				case main_region__final_ :
					reactMain_region__final_0();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
