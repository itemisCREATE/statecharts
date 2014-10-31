package org.yakindu.scr.outeventlifecycle;

public class OutEventLifeCycleStatemachine
		implements
			IOutEventLifeCycleStatemachine {

	private final class SCInterfaceImpl implements SCInterface {

		private boolean e;

		public void raiseE() {
			e = true;
		}

		private boolean f;

		public boolean isRaisedF() {
			return f;
		}

		private void raiseF() {
			f = true;
		}

		private boolean f_available_in_cycle;

		public boolean getF_available_in_cycle() {
			return f_available_in_cycle;
		}

		public void setF_available_in_cycle(boolean value) {
			this.f_available_in_cycle = value;
		}

		private boolean f_available_in_next_cycle;

		public boolean getF_available_in_next_cycle() {
			return f_available_in_next_cycle;
		}

		public void setF_available_in_next_cycle(boolean value) {
			this.f_available_in_next_cycle = value;
		}

		public void clearEvents() {
			e = false;
		}

		public void clearOutEvents() {
			f = false;
		}
	}

	private SCInterfaceImpl sCInterface;

	public enum State {
		r1_A, r1_B, r2_B, $NullState$
	};

	private final State[] stateVector = new State[2];

	private int nextStateIndex;

	public OutEventLifeCycleStatemachine() {

		sCInterface = new SCInterfaceImpl();
	}

	public void init() {
		for (int i = 0; i < 2; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCInterface.f_available_in_cycle = false;

		sCInterface.f_available_in_next_cycle = false;
	}

	public void enter() {
		entryAction();

		nextStateIndex = 0;
		stateVector[0] = State.r1_A;

		nextStateIndex = 1;
		stateVector[1] = State.r2_B;
	}

	public void exit() {
		switch (stateVector[0]) {
			case r1_A :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case r1_B :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			default :
				break;
		}

		switch (stateVector[1]) {
			case r2_B :
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
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
		sCInterface.clearOutEvents();
	}

	/**
	 * Returns true if the given state is currently active otherwise false.
	 */
	public boolean isStateActive(State state) {
		switch (state) {
			case r1_A :
				return stateVector[0] == State.r1_A;
			case r1_B :
				return stateVector[0] == State.r1_B;
			case r2_B :
				return stateVector[1] == State.r2_B;
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
	public boolean isRaisedF() {
		return sCInterface.isRaisedF();
	}

	public boolean getF_available_in_cycle() {
		return sCInterface.getF_available_in_cycle();
	}

	public void setF_available_in_cycle(boolean value) {
		sCInterface.setF_available_in_cycle(value);
	}
	public boolean getF_available_in_next_cycle() {
		return sCInterface.getF_available_in_next_cycle();
	}

	public void setF_available_in_next_cycle(boolean value) {
		sCInterface.setF_available_in_next_cycle(value);
	}

	/* Entry action for statechart 'OutEventLifeCycle'. */
	private void entryAction() {
	}

	/* Exit action for state 'OutEventLifeCycle'. */
	private void exitAction() {
	}

	/* The reactions of state A. */
	private void reactR1_A() {
		if (sCInterface.e) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			sCInterface.raiseF();

			nextStateIndex = 0;
			stateVector[0] = State.r1_B;
		}
	}

	/* The reactions of state B. */
	private void reactR1_B() {
		if (sCInterface.f) {
			sCInterface.f_available_in_next_cycle = true;
		}
	}

	/* The reactions of state B. */
	private void reactR2_B() {
		if (sCInterface.f) {
			sCInterface.f_available_in_cycle = true;
		}
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case r1_A :
					reactR1_A();
					break;
				case r1_B :
					reactR1_B();
					break;
				case r2_B :
					reactR2_B();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
