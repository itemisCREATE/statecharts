package org.yakindu.scr.outeventlifecycle;

public class OutEventLifeCycleStatemachine
		implements
			IOutEventLifeCycleStatemachine {

	private final class SCIDefaultImpl implements SCIDefault {

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

	private SCIDefaultImpl sCIDefault;

	public enum State {
		r1_A, r1_B, r2_B, $NullState$
	};

	private final State[] stateVector = new State[2];

	private int nextStateIndex;

	public OutEventLifeCycleStatemachine() {

		sCIDefault = new SCIDefaultImpl();

	}

	public void init() {
		for (int i = 0; i < 2; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCIDefault.f_available_in_cycle = false;

		sCIDefault.f_available_in_next_cycle = false;
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

	protected void clearEvents() {
		sCIDefault.clearEvents();

	}

	protected void clearOutEvents() {
		sCIDefault.clearOutEvents();
	}

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

	public SCIDefault getSCIDefault() {
		return sCIDefault;
	}

	public void raiseE() {
		sCIDefault.raiseE();
	}
	public boolean isRaisedF() {
		return sCIDefault.isRaisedF();
	}

	public boolean getF_available_in_cycle() {
		return sCIDefault.getF_available_in_cycle();
	}

	public void setF_available_in_cycle(boolean value) {
		sCIDefault.setF_available_in_cycle(value);
	}
	public boolean getF_available_in_next_cycle() {
		return sCIDefault.getF_available_in_next_cycle();
	}

	public void setF_available_in_next_cycle(boolean value) {
		sCIDefault.setF_available_in_next_cycle(value);
	}

	/* Entry action for statechart 'OutEventLifeCycle'. */
	private void entryAction() {
	}

	/* Exit action for state 'OutEventLifeCycle'. */
	private void exitAction() {
	}

	/* The reactions of state A. */
	private void reactR1_A() {
		if (sCIDefault.e) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			sCIDefault.raiseF();

			nextStateIndex = 0;
			stateVector[0] = State.r1_B;
		}
	}

	/* The reactions of state B. */
	private void reactR1_B() {
		if (sCIDefault.f) {
			sCIDefault.f_available_in_next_cycle = true;
		}
	}

	/* The reactions of state B. */
	private void reactR2_B() {
		if (sCIDefault.f) {
			sCIDefault.f_available_in_cycle = true;
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
