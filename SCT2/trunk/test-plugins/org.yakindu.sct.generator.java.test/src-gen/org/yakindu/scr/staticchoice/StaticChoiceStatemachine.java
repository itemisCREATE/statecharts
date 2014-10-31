package org.yakindu.scr.staticchoice;

public class StaticChoiceStatemachine implements IStaticChoiceStatemachine {

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

		sCInterface.number = 1;

		nextStateIndex = 0;
		stateVector[0] = State.main_region_Start;
	}

	public void exit() {
		switch (stateVector[0]) {
			case main_region_Start :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_B :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_A :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			default :
				break;
		}

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

	/* Entry action for statechart 'StaticChoice'. */
	private void entryAction() {
	}

	/* Exit action for state 'StaticChoice'. */
	private void exitAction() {
	}

	/* The reactions of state Start. */
	private void reactMain_region_Start() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		sCInterface.number += 1;

		if (sCInterface.number == 2) {
			nextStateIndex = 0;
			stateVector[0] = State.main_region_A;
		} else {
			nextStateIndex = 0;
			stateVector[0] = State.main_region_B;
		}
	}

	/* The reactions of state B. */
	private void reactMain_region_B() {
	}

	/* The reactions of state A. */
	private void reactMain_region_A() {
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
