package org.yakindu.scr.entryexitselftransition;

public class EntryExitSelfTransitionStatemachine
		implements
			IEntryExitSelfTransitionStatemachine {

	static {
	}

	private final class SCInterfaceImpl implements SCInterface {

		private boolean e;

		public void raiseE() {
			e = true;
		}

		private boolean e1;

		public void raiseE1() {
			e1 = true;
		}

		private long exits;
		public long getExits() {
			return exits;
		}

		public void setExits(long value) {
			this.exits = value;
		}

		private long entries;
		public long getEntries() {
			return entries;
		}

		public void setEntries(long value) {
			this.entries = value;
		}

		public void clearEvents() {
			e = false;
			e1 = false;
		}

	}

	private SCInterfaceImpl sCInterface;

	public enum State {
		main_region_A, main_region_A__region0_B, main_region_A__region0_C, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public EntryExitSelfTransitionStatemachine() {

		sCInterface = new SCInterfaceImpl();
	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCInterface.exits = 0;

		sCInterface.entries = 0;
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
				return stateVector[0].ordinal() >= State.main_region_A
						.ordinal()
						&& stateVector[0].ordinal() <= State.main_region_A__region0_C
								.ordinal();
			case main_region_A__region0_B :
				return stateVector[0] == State.main_region_A__region0_B;
			case main_region_A__region0_C :
				return stateVector[0] == State.main_region_A__region0_C;
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
	public void raiseE1() {
		sCInterface.raiseE1();
	}

	public long getExits() {
		return sCInterface.getExits();
	}

	public void setExits(long value) {
		sCInterface.setExits(value);
	}
	public long getEntries() {
		return sCInterface.getEntries();
	}

	public void setEntries(long value) {
		sCInterface.setEntries(value);
	}

	private boolean checkMain_region_ATr0() {
		return sCInterface.e;
	}

	private boolean checkMain_region_A_region0_BTr0() {
		return sCInterface.e1;
	}

	private boolean checkMain_region_A_region0_CTr0() {
		return sCInterface.e1;
	}

	private void effectMain_region_ATr0() {
		exitSequenceMain_region_A();

		entryActionMain_region_A();

		enterSequenceMain_region_A_region0_C();
	}

	private void effectMain_region_A_region0_BTr0() {
		exitSequenceMain_region_A_region0_B();

		enterSequenceMain_region_A_region0_C();
	}

	private void effectMain_region_A_region0_CTr0() {
		exitSequenceMain_region_A();

		enterSequenceMain_region_A();
	}

	/* Entry action for statechart 'EntryExitSelfTransition'. */
	private void entryAction() {
	}

	/* Entry action for state 'A'. */
	private void entryActionMain_region_A() {
		sCInterface.entries += 1;
	}

	/* Exit action for state 'EntryExitSelfTransition'. */
	private void exitAction() {
	}

	/* Exit action for state 'A'. */
	private void exitActionMain_region_A() {
		sCInterface.exits += 1;
	}

	/* 'default' enter sequence for state A */
	private void enterSequenceMain_region_A() {
		entryActionMain_region_A();

		enterSequenceMain_region_A_region0();
	}

	/* 'default' enter sequence for state B */
	private void enterSequenceMain_region_A_region0_B() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_A__region0_B;
	}

	/* 'default' enter sequence for state C */
	private void enterSequenceMain_region_A_region0_C() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_A__region0_C;
	}

	/* 'default' enter sequence for region main region */
	private void enterSequenceMain_region() {
		reactEntryExitSelfTransition_main_region__entry_Default();
	}

	/* 'default' enter sequence for region  */
	private void enterSequenceMain_region_A_region0() {
		reactEntryExitSelfTransition_main_region_A__region0__entry_Default();
	}

	/* Default exit sequence for state A */
	private void exitSequenceMain_region_A() {
		exitSequenceMain_region_A_region0();

		exitActionMain_region_A();
	}

	/* Default exit sequence for state B */
	private void exitSequenceMain_region_A_region0_B() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state C */
	private void exitSequenceMain_region_A_region0_C() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for region main region */
	private void exitSequenceMain_region() {
		switch (stateVector[0]) {
			case main_region_A__region0_B :
				exitSequenceMain_region_A_region0_B();

				exitActionMain_region_A();
				break;

			case main_region_A__region0_C :
				exitSequenceMain_region_A_region0_C();

				exitActionMain_region_A();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region  */
	private void exitSequenceMain_region_A_region0() {
		switch (stateVector[0]) {
			case main_region_A__region0_B :
				exitSequenceMain_region_A_region0_B();
				break;

			case main_region_A__region0_C :
				exitSequenceMain_region_A_region0_C();
				break;

			default :
				break;
		}
	}

	/* The reactions of state B. */
	private void reactMain_region_A_region0_B() {
		if (checkMain_region_ATr0()) {
			effectMain_region_ATr0();
		} else {
			if (checkMain_region_A_region0_BTr0()) {
				effectMain_region_A_region0_BTr0();
			}
		}
	}

	/* The reactions of state C. */
	private void reactMain_region_A_region0_C() {
		if (checkMain_region_ATr0()) {
			effectMain_region_ATr0();
		} else {
			if (checkMain_region_A_region0_CTr0()) {
				effectMain_region_A_region0_CTr0();
			}
		}
	}

	/* Default react sequence for initial entry  */
	private void reactEntryExitSelfTransition_main_region__entry_Default() {
		enterSequenceMain_region_A();
	}

	/* Default react sequence for initial entry  */
	private void reactEntryExitSelfTransition_main_region_A__region0__entry_Default() {
		enterSequenceMain_region_A_region0_B();
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_A__region0_B :
					reactMain_region_A_region0_B();
					break;
				case main_region_A__region0_C :
					reactMain_region_A_region0_C();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
