package org.yakindu.scr.priorityvalues;

public class PriorityValuesStatemachine implements IPriorityValuesStatemachine {

	static {
	}

	private final class SCInterfaceImpl implements SCInterface {

		private boolean event1;

		public void raiseEvent1() {
			event1 = true;
		}

		private boolean event2;

		public void raiseEvent2() {
			event2 = true;
		}

		public void clearEvents() {
			event1 = false;
			event2 = false;
		}

	}

	private SCInterfaceImpl sCInterface;

	public enum State {
		someRegion_A, someRegion_B, main_region_A, main_region_B, main_region_C, main_region_D, main_region_E, $NullState$
	};

	private final State[] stateVector = new State[2];

	private int nextStateIndex;

	public PriorityValuesStatemachine() {

		sCInterface = new SCInterfaceImpl();
	}

	public void init() {
		for (int i = 0; i < 2; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

	}

	public void enter() {
		entryAction();

		enterSequenceSomeRegion();

		enterSequenceMain_region();
	}

	public void exit() {
		exitSequenceSomeRegion();

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
			case someRegion_A :
				return stateVector[0] == State.someRegion_A;
			case someRegion_B :
				return stateVector[0] == State.someRegion_B;
			case main_region_A :
				return stateVector[1] == State.main_region_A;
			case main_region_B :
				return stateVector[1] == State.main_region_B;
			case main_region_C :
				return stateVector[1] == State.main_region_C;
			case main_region_D :
				return stateVector[1] == State.main_region_D;
			case main_region_E :
				return stateVector[1] == State.main_region_E;
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
	public void raiseEvent2() {
		sCInterface.raiseEvent2();
	}

	private boolean checkSomeRegion_ATr0() {
		return sCInterface.event2;
	}

	private boolean checkMain_region_ATr0() {
		return sCInterface.event1;
	}

	private boolean checkMain_region_ATr1() {
		return sCInterface.event1;
	}

	private boolean checkMain_region_ATr2() {
		return sCInterface.event1;
	}

	private boolean checkMain_region_ATr3() {
		return (sCInterface.event2) && !isStateActive(State.someRegion_B);
	}

	private void effectSomeRegion_ATr0() {
		exitSequenceSomeRegion_A();

		enterSequenceSomeRegion_B();
	}

	private void effectMain_region_ATr0() {
		exitSequenceMain_region_A();

		enterSequenceMain_region_C();
	}

	private void effectMain_region_ATr1() {
		exitSequenceMain_region_A();

		enterSequenceMain_region_B();
	}

	private void effectMain_region_ATr2() {
		exitSequenceMain_region_A();

		enterSequenceMain_region_D();
	}

	private void effectMain_region_ATr3() {
		exitSequenceMain_region_A();

		enterSequenceMain_region_E();
	}

	/* Entry action for statechart 'PriorityValues'. */
	private void entryAction() {
	}

	/* Exit action for state 'PriorityValues'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state A */
	private void enterSequenceSomeRegion_A() {
		nextStateIndex = 0;
		stateVector[0] = State.someRegion_A;
	}

	/* 'default' enter sequence for state B */
	private void enterSequenceSomeRegion_B() {
		nextStateIndex = 0;
		stateVector[0] = State.someRegion_B;
	}

	/* 'default' enter sequence for state A */
	private void enterSequenceMain_region_A() {
		nextStateIndex = 1;
		stateVector[1] = State.main_region_A;
	}

	/* 'default' enter sequence for state B */
	private void enterSequenceMain_region_B() {
		nextStateIndex = 1;
		stateVector[1] = State.main_region_B;
	}

	/* 'default' enter sequence for state C */
	private void enterSequenceMain_region_C() {
		nextStateIndex = 1;
		stateVector[1] = State.main_region_C;
	}

	/* 'default' enter sequence for state D */
	private void enterSequenceMain_region_D() {
		nextStateIndex = 1;
		stateVector[1] = State.main_region_D;
	}

	/* 'default' enter sequence for state E */
	private void enterSequenceMain_region_E() {
		nextStateIndex = 1;
		stateVector[1] = State.main_region_E;
	}

	/* 'default' enter sequence for region someRegion */
	private void enterSequenceSomeRegion() {
		reactPriorityValues_someRegion__entry_Default();
	}

	/* 'default' enter sequence for region main region */
	private void enterSequenceMain_region() {
		reactPriorityValues_main_region__entry_Default();
	}

	/* Default exit sequence for state A */
	private void exitSequenceSomeRegion_A() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state B */
	private void exitSequenceSomeRegion_B() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state A */
	private void exitSequenceMain_region_A() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state B */
	private void exitSequenceMain_region_B() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state C */
	private void exitSequenceMain_region_C() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state D */
	private void exitSequenceMain_region_D() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state E */
	private void exitSequenceMain_region_E() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for region someRegion */
	private void exitSequenceSomeRegion() {
		switch (stateVector[0]) {
			case someRegion_A :
				exitSequenceSomeRegion_A();
				break;

			case someRegion_B :
				exitSequenceSomeRegion_B();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region main region */
	private void exitSequenceMain_region() {
		switch (stateVector[1]) {
			case main_region_A :
				exitSequenceMain_region_A();
				break;

			case main_region_B :
				exitSequenceMain_region_B();
				break;

			case main_region_C :
				exitSequenceMain_region_C();
				break;

			case main_region_D :
				exitSequenceMain_region_D();
				break;

			case main_region_E :
				exitSequenceMain_region_E();
				break;

			default :
				break;
		}
	}

	/* The reactions of state A. */
	private void reactSomeRegion_A() {
		if (checkSomeRegion_ATr0()) {
			effectSomeRegion_ATr0();
		}
	}

	/* The reactions of state B. */
	private void reactSomeRegion_B() {
	}

	/* The reactions of state A. */
	private void reactMain_region_A() {
		if (checkMain_region_ATr0()) {
			effectMain_region_ATr0();
		} else {
			if (checkMain_region_ATr1()) {
				effectMain_region_ATr1();
			} else {
				if (checkMain_region_ATr2()) {
					effectMain_region_ATr2();
				} else {
					if (checkMain_region_ATr3()) {
						effectMain_region_ATr3();
					}
				}
			}
		}
	}

	/* The reactions of state B. */
	private void reactMain_region_B() {
	}

	/* The reactions of state C. */
	private void reactMain_region_C() {
	}

	/* The reactions of state D. */
	private void reactMain_region_D() {
	}

	/* The reactions of state E. */
	private void reactMain_region_E() {
	}

	/* Default react sequence for initial entry  */
	private void reactPriorityValues_someRegion__entry_Default() {
		enterSequenceSomeRegion_A();
	}

	/* Default react sequence for initial entry  */
	private void reactPriorityValues_main_region__entry_Default() {
		enterSequenceMain_region_A();
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case someRegion_A :
					reactSomeRegion_A();
					break;
				case someRegion_B :
					reactSomeRegion_B();
					break;
				case main_region_A :
					reactMain_region_A();
					break;
				case main_region_B :
					reactMain_region_B();
					break;
				case main_region_C :
					reactMain_region_C();
					break;
				case main_region_D :
					reactMain_region_D();
					break;
				case main_region_E :
					reactMain_region_E();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
