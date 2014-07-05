package org.yakindu.scr.internaleventlifecycle;

public class InternalEventLifeCycleStatemachine
		implements
			IInternalEventLifeCycleStatemachine {

	private boolean i1;

	private boolean i2;

	private final class SCInterfaceImpl implements SCInterface {

		private boolean e;

		public void raiseE() {
			e = true;
		}

		private boolean f;

		public void raiseF() {
			f = true;
		}

		public void clearEvents() {
			e = false;
			f = false;
		}

	}

	private SCInterfaceImpl sCInterface;

	public enum State {
		r1_A, r1_B, r2_C, r2_D, $NullState$
	};

	private final State[] stateVector = new State[2];

	private int nextStateIndex;

	public InternalEventLifeCycleStatemachine() {

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

		nextStateIndex = 0;
		stateVector[0] = State.r1_A;

		nextStateIndex = 1;
		stateVector[1] = State.r2_C;
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
			case r2_C :
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
				break;

			case r2_D :
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
		i1 = false;
		i2 = false;

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
			case r1_A :
				return stateVector[0] == State.r1_A;
			case r1_B :
				return stateVector[0] == State.r1_B;
			case r2_C :
				return stateVector[1] == State.r2_C;
			case r2_D :
				return stateVector[1] == State.r2_D;
			default :
				return false;
		}
	}

	public SCInterface getSCInterface() {
		return sCInterface;
	}

	private void raiseI1() {
		i1 = true;
	}

	private void raiseI2() {
		i2 = true;
	}

	public void raiseE() {
		sCInterface.raiseE();
	}
	public void raiseF() {
		sCInterface.raiseF();
	}

	/* Entry action for statechart 'InternalEventLifeCycle'. */
	private void entryAction() {
	}

	/* Exit action for state 'InternalEventLifeCycle'. */
	private void exitAction() {
	}

	/* The reactions of state A. */
	private void reactR1_A() {
		if (i2) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.r1_B;
		} else {
			if (sCInterface.e) {
				raiseI1();
			}
		}
	}

	/* The reactions of state B. */
	private void reactR1_B() {
		if (sCInterface.e) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.r1_A;
		}
	}

	/* The reactions of state C. */
	private void reactR2_C() {
		if (i1) {
			nextStateIndex = 1;
			stateVector[1] = State.$NullState$;

			nextStateIndex = 1;
			stateVector[1] = State.r2_D;
		}
	}

	/* The reactions of state D. */
	private void reactR2_D() {
		if (sCInterface.f) {
			nextStateIndex = 1;
			stateVector[1] = State.$NullState$;

			raiseI2();

			nextStateIndex = 1;
			stateVector[1] = State.r2_C;
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
				case r2_C :
					reactR2_C();
					break;
				case r2_D :
					reactR2_D();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
