package org.yakindu.scr.stateisactive;

public class StateIsActiveStatemachine implements IStateIsActiveStatemachine {

	static {
	}

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

		enterSequenceR1();

		enterSequenceR2();
	}

	public void exit() {
		exitSequenceR1();

		exitSequenceR2();

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

	private boolean checkR1_R1ATr0() {
		return isStateActive(State.r2_R2B);
	}

	private boolean checkR2_R2ATr0() {
		return sCInterface.event1;
	}

	private void effectR1_R1ATr0() {
		exitSequenceR1_R1A();

		enterSequenceR1_R1B();
	}

	private void effectR2_R2ATr0() {
		exitSequenceR2_R2A();

		enterSequenceR2_R2B();
	}

	/* Entry action for statechart 'StateIsActive'. */
	private void entryAction() {
	}

	/* Exit action for state 'StateIsActive'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state R1A */
	private void enterSequenceR1_R1A() {
		nextStateIndex = 0;
		stateVector[0] = State.r1_R1A;
	}

	/* 'default' enter sequence for state R1B */
	private void enterSequenceR1_R1B() {
		nextStateIndex = 0;
		stateVector[0] = State.r1_R1B;
	}

	/* 'default' enter sequence for state R2A */
	private void enterSequenceR2_R2A() {
		nextStateIndex = 1;
		stateVector[1] = State.r2_R2A;
	}

	/* 'default' enter sequence for state R2B */
	private void enterSequenceR2_R2B() {
		nextStateIndex = 1;
		stateVector[1] = State.r2_R2B;
	}

	/* 'default' enter sequence for region R1 */
	private void enterSequenceR1() {
		reactStateIsActive_R1__entry_Default();
	}

	/* 'default' enter sequence for region R2 */
	private void enterSequenceR2() {
		reactStateIsActive_R2__entry_Default();
	}

	/* Default exit sequence for state R1A */
	private void exitSequenceR1_R1A() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state R1B */
	private void exitSequenceR1_R1B() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state R2A */
	private void exitSequenceR2_R2A() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state R2B */
	private void exitSequenceR2_R2B() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for region R1 */
	private void exitSequenceR1() {
		switch (stateVector[0]) {
			case r1_R1A :
				exitSequenceR1_R1A();
				break;

			case r1_R1B :
				exitSequenceR1_R1B();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region R2 */
	private void exitSequenceR2() {
		switch (stateVector[1]) {
			case r2_R2A :
				exitSequenceR2_R2A();
				break;

			case r2_R2B :
				exitSequenceR2_R2B();
				break;

			default :
				break;
		}
	}

	/* The reactions of state R1A. */
	private void reactR1_R1A() {
		if (checkR1_R1ATr0()) {
			effectR1_R1ATr0();
		}
	}

	/* The reactions of state R1B. */
	private void reactR1_R1B() {
	}

	/* The reactions of state R2A. */
	private void reactR2_R2A() {
		if (checkR2_R2ATr0()) {
			effectR2_R2ATr0();
		}
	}

	/* The reactions of state R2B. */
	private void reactR2_R2B() {
	}

	/* Default react sequence for initial entry  */
	private void reactStateIsActive_R1__entry_Default() {
		enterSequenceR1_R1A();
	}

	/* Default react sequence for initial entry  */
	private void reactStateIsActive_R2__entry_Default() {
		enterSequenceR2_R2A();
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
