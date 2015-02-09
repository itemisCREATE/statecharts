package org.yakindu.scr.ineventlifecycle;

public class InEventLifeCycleStatemachine
		implements
			IInEventLifeCycleStatemachine {

	static {
	}

	private final class SCInterfaceImpl implements SCInterface {

		private boolean e;

		public void raiseE() {
			e = true;
		}

		private long i;
		public long getI() {
			return i;
		}

		public void setI(long value) {
			this.i = value;
		}

		public void clearEvents() {
			e = false;
		}

	}

	private SCInterfaceImpl sCInterface;

	public enum State {
		main_region_A, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public InEventLifeCycleStatemachine() {

		sCInterface = new SCInterfaceImpl();
	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCInterface.i = 0;
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

	public long getI() {
		return sCInterface.getI();
	}

	public void setI(long value) {
		sCInterface.setI(value);
	}

	private boolean checkMain_region_ALr0() {
		return sCInterface.e;
	}

	private void effectMain_region_ALr0() {
		sCInterface.i += 1;
	}

	/* Entry action for statechart 'InEventLifeCycle'. */
	private void entryAction() {
	}

	/* Exit action for state 'InEventLifeCycle'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state A */
	private void enterSequenceMain_region_A() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_A;
	}

	/* 'default' enter sequence for region main region */
	private void enterSequenceMain_region() {
		reactInEventLifeCycle_main_region__entry_Default();
	}

	/* Default exit sequence for state A */
	private void exitSequenceMain_region_A() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for region main region */
	private void exitSequenceMain_region() {
		switch (stateVector[0]) {
			case main_region_A :
				exitSequenceMain_region_A();
				break;

			default :
				break;
		}
	}

	/* The reactions of state A. */
	private void reactMain_region_A() {
		if (checkMain_region_ALr0()) {
			effectMain_region_ALr0();
		}
	}

	/* Default react sequence for initial entry  */
	private void reactInEventLifeCycle_main_region__entry_Default() {
		enterSequenceMain_region_A();
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
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
