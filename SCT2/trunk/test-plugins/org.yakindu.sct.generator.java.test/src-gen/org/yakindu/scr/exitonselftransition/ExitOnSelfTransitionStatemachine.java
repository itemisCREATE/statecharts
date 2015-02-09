package org.yakindu.scr.exitonselftransition;

public class ExitOnSelfTransitionStatemachine
		implements
			IExitOnSelfTransitionStatemachine {

	static {
	}

	private final class SCInterfaceImpl implements SCInterface {

		private boolean e;

		public void raiseE() {
			e = true;
		}

		private boolean f;

		public void raiseF() {
			f = true;
		}

		private long entryCount;
		public long getEntryCount() {
			return entryCount;
		}

		public void setEntryCount(long value) {
			this.entryCount = value;
		}

		private long exitCount;
		public long getExitCount() {
			return exitCount;
		}

		public void setExitCount(long value) {
			this.exitCount = value;
		}

		public void clearEvents() {
			e = false;
			f = false;
		}

	}

	private SCInterfaceImpl sCInterface;

	public enum State {
		main_region_A, main_region_B, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public ExitOnSelfTransitionStatemachine() {

		sCInterface = new SCInterfaceImpl();
	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCInterface.entryCount = 0;

		sCInterface.exitCount = 0;
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

	public void raiseE() {
		sCInterface.raiseE();
	}
	public void raiseF() {
		sCInterface.raiseF();
	}

	public long getEntryCount() {
		return sCInterface.getEntryCount();
	}

	public void setEntryCount(long value) {
		sCInterface.setEntryCount(value);
	}
	public long getExitCount() {
		return sCInterface.getExitCount();
	}

	public void setExitCount(long value) {
		sCInterface.setExitCount(value);
	}

	private boolean checkMain_region_ATr0() {
		return sCInterface.e;
	}

	private boolean checkMain_region_ATr1() {
		return sCInterface.f;
	}

	private boolean checkMain_region_BTr0() {
		return sCInterface.f;
	}

	private void effectMain_region_ATr0() {
		exitSequenceMain_region_A();

		enterSequenceMain_region_A();
	}

	private void effectMain_region_ATr1() {
		exitSequenceMain_region_A();

		enterSequenceMain_region_B();
	}

	private void effectMain_region_BTr0() {
		exitSequenceMain_region_B();

		enterSequenceMain_region_A();
	}

	/* Entry action for statechart 'ExitOnSelfTransition'. */
	private void entryAction() {
	}

	/* Entry action for state 'A'. */
	private void entryActionMain_region_A() {
		sCInterface.entryCount += 1;
	}

	/* Exit action for state 'ExitOnSelfTransition'. */
	private void exitAction() {
	}

	/* Exit action for state 'A'. */
	private void exitActionMain_region_A() {
		sCInterface.exitCount += 1;
	}

	/* 'default' enter sequence for state A */
	private void enterSequenceMain_region_A() {
		entryActionMain_region_A();

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
		reactExitOnSelfTransition_main_region__entry_Default();
	}

	/* Default exit sequence for state A */
	private void exitSequenceMain_region_A() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		exitActionMain_region_A();
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
		} else {
			if (checkMain_region_ATr1()) {
				effectMain_region_ATr1();
			}
		}
	}

	/* The reactions of state B. */
	private void reactMain_region_B() {
		if (checkMain_region_BTr0()) {
			effectMain_region_BTr0();
		}
	}

	/* Default react sequence for initial entry  */
	private void reactExitOnSelfTransition_main_region__entry_Default() {
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
