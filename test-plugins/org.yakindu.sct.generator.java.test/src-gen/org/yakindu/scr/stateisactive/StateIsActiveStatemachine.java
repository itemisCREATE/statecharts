package org.yakindu.scr.stateisactive;

public class StateIsActiveStatemachine implements IStateIsActiveStatemachine {

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
		r1_R1A, r1_R1B, r2_R2A, r2_R2B, $NullState$
	};

	private final State[] stateVector = new State[2];

	private int nextStateIndex;

	public StateIsActiveStatemachine() {

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
		stateVector[0] = State.r1_R1A;

		nextStateIndex = 1;
		stateVector[1] = State.r2_R2A;
	}

	public void exit() {
		switch (stateVector[0]) {
			case r1_R1A :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case r1_R1B :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			default :
				break;
		}

		switch (stateVector[1]) {
			case r2_R2A :
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
				break;

			case r2_R2B :
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
				break;

			default :
				break;
		}

		exitAction();
	}

	protected void clearEvents() {
		sCInterface.clearEvents();

	}

	protected void clearOutEvents() {
	}

	public boolean isStateActive(State state) {
		switch (state) {
			case r1_R1A :
				return stateVector[0] == State.r1_R1A;
			case r1_R1B :
				return stateVector[0] == State.r1_R1B;
			case r2_R2A :
				return stateVector[1] == State.r2_R2A;
			case r2_R2B :
				return stateVector[1] == State.r2_R2B;
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

	/* Entry action for statechart 'StateIsActive'. */
	private void entryAction() {
	}

	/* Exit action for state 'StateIsActive'. */
	private void exitAction() {
	}

	/* The reactions of state R1A. */
	private void reactR1_R1A() {
		if (isStateActive(State.r2_R2B)) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.r1_R1B;
		}
	}

	/* The reactions of state R1B. */
	private void reactR1_R1B() {
	}

	/* The reactions of state R2A. */
	private void reactR2_R2A() {
		if (sCInterface.event1) {
			nextStateIndex = 1;
			stateVector[1] = State.$NullState$;

			nextStateIndex = 1;
			stateVector[1] = State.r2_R2B;
		}
	}

	/* The reactions of state R2B. */
	private void reactR2_R2B() {
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case r1_R1A :
					reactR1_R1A();
					break;
				case r1_R1B :
					reactR1_R1B();
					break;
				case r2_R2A :
					reactR2_R2A();
					break;
				case r2_R2B :
					reactR2_R2B();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
