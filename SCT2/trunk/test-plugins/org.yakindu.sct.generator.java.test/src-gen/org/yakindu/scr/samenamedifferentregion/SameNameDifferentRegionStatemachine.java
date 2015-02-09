package org.yakindu.scr.samenamedifferentregion;

public class SameNameDifferentRegionStatemachine
		implements
			ISameNameDifferentRegionStatemachine {

	static {
	}

	private final class SCInterfaceImpl implements SCInterface {

		private boolean e1;

		public void raiseE1() {
			e1 = true;
		}

		public void clearEvents() {
			e1 = false;
		}

	}

	private SCInterfaceImpl sCInterface;

	public enum State {
		main_region_StateA, main_region_StateB, main_region_StateB_r1_StateA, main_region_StateB_r1_StateB, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public SameNameDifferentRegionStatemachine() {

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

		enterSequence_main_region_default();
	}

	public void exit() {
		exitSequence_main_region();

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
			case main_region_StateA :
				return stateVector[0] == State.main_region_StateA;
			case main_region_StateB :
				return stateVector[0].ordinal() >= State.main_region_StateB
						.ordinal()
						&& stateVector[0].ordinal() <= State.main_region_StateB_r1_StateB
								.ordinal();
			case main_region_StateB_r1_StateA :
				return stateVector[0] == State.main_region_StateB_r1_StateA;
			case main_region_StateB_r1_StateB :
				return stateVector[0] == State.main_region_StateB_r1_StateB;
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

	private boolean check_main_region_StateA_tr0() {
		return sCInterface.e1;
	}

	private boolean check_main_region_StateB_r1_StateA_tr0() {
		return sCInterface.e1;
	}

	private void effect_main_region_StateA_tr0() {
		exitSequence_main_region_StateA();

		enterSequence_main_region_StateB_default();
	}

	private void effect_main_region_StateB_r1_StateA_tr0() {
		exitSequence_main_region_StateB_r1_StateA();

		enterSequence_main_region_StateB_r1_StateB_default();
	}

	/* Entry action for statechart 'SameNameDifferentRegion'. */
	private void entryAction() {
	}

	/* Exit action for state 'SameNameDifferentRegion'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state StateA */
	private void enterSequence_main_region_StateA_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_StateA;
	}

	/* 'default' enter sequence for state StateB */
	private void enterSequence_main_region_StateB_default() {
		enterSequence_main_region_StateB_r1_default();
	}

	/* 'default' enter sequence for state StateA */
	private void enterSequence_main_region_StateB_r1_StateA_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_StateB_r1_StateA;
	}

	/* 'default' enter sequence for state StateB */
	private void enterSequence_main_region_StateB_r1_StateB_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_StateB_r1_StateB;
	}

	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}

	/* 'default' enter sequence for region r1 */
	private void enterSequence_main_region_StateB_r1_default() {
		react_main_region_StateB_r1__entry_Default();
	}

	/* Default exit sequence for state StateA */
	private void exitSequence_main_region_StateA() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state StateA */
	private void exitSequence_main_region_StateB_r1_StateA() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state StateB */
	private void exitSequence_main_region_StateB_r1_StateB() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
			case main_region_StateA :
				exitSequence_main_region_StateA();
				break;

			case main_region_StateB_r1_StateA :
				exitSequence_main_region_StateB_r1_StateA();
				break;

			case main_region_StateB_r1_StateB :
				exitSequence_main_region_StateB_r1_StateB();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region r1 */
	private void exitSequence_main_region_StateB_r1() {
		switch (stateVector[0]) {
			case main_region_StateB_r1_StateA :
				exitSequence_main_region_StateB_r1_StateA();
				break;

			case main_region_StateB_r1_StateB :
				exitSequence_main_region_StateB_r1_StateB();
				break;

			default :
				break;
		}
	}

	/* The reactions of state StateA. */
	private void react_main_region_StateA() {
		if (check_main_region_StateA_tr0()) {
			effect_main_region_StateA_tr0();
		}
	}

	/* The reactions of state StateA. */
	private void react_main_region_StateB_r1_StateA() {
		if (check_main_region_StateB_r1_StateA_tr0()) {
			effect_main_region_StateB_r1_StateA_tr0();
		}
	}

	/* The reactions of state StateB. */
	private void react_main_region_StateB_r1_StateB() {
	}

	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_StateA_default();
	}

	/* Default react sequence for initial entry  */
	private void react_main_region_StateB_r1__entry_Default() {
		enterSequence_main_region_StateB_r1_StateA_default();
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_StateA :
					react_main_region_StateA();
					break;
				case main_region_StateB_r1_StateA :
					react_main_region_StateB_r1_StateA();
					break;
				case main_region_StateB_r1_StateB :
					react_main_region_StateB_r1_StateB();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
