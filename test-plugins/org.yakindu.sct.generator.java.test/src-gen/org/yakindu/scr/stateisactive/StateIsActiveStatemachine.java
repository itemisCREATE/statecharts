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

		enterSequence_R1_default();

		enterSequence_R2_default();
	}

	public void exit() {
		exitSequence_R1();

		exitSequence_R2();

		exitAction();
	}

	/**
	 * @see IStatemachine#isActive()
	 */
	@Override
	public boolean isActive() {

		return stateVector[0] != State.$NullState$
				|| stateVector[1] != State.$NullState$;
	}

	/** 
	 * Always returns 'false' since this state machine can never become final.
	 *
	 * @see IStatemachine#isFinal() 
	 */
	@Override
	public boolean isFinal() {
		return false;
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

	private boolean check_R1_R1A_tr0_tr0() {
		return isStateActive(State.r2_R2B);
	}

	private boolean check_R2_R2A_tr0_tr0() {
		return sCInterface.event1;
	}

	private void effect_R1_R1A_tr0() {
		exitSequence_R1_R1A();

		enterSequence_R1_R1B_default();
	}

	private void effect_R2_R2A_tr0() {
		exitSequence_R2_R2A();

		enterSequence_R2_R2B_default();
	}

	/* Entry action for statechart 'StateIsActive'. */
	private void entryAction() {
	}

	/* Exit action for state 'StateIsActive'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state R1A */
	private void enterSequence_R1_R1A_default() {
		nextStateIndex = 0;
		stateVector[0] = State.r1_R1A;
	}

	/* 'default' enter sequence for state R1B */
	private void enterSequence_R1_R1B_default() {
		nextStateIndex = 0;
		stateVector[0] = State.r1_R1B;
	}

	/* 'default' enter sequence for state R2A */
	private void enterSequence_R2_R2A_default() {
		nextStateIndex = 1;
		stateVector[1] = State.r2_R2A;
	}

	/* 'default' enter sequence for state R2B */
	private void enterSequence_R2_R2B_default() {
		nextStateIndex = 1;
		stateVector[1] = State.r2_R2B;
	}

	/* 'default' enter sequence for region R1 */
	private void enterSequence_R1_default() {
		react_R1__entry_Default();
	}

	/* 'default' enter sequence for region R2 */
	private void enterSequence_R2_default() {
		react_R2__entry_Default();
	}

	/* Default exit sequence for state R1A */
	private void exitSequence_R1_R1A() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state R1B */
	private void exitSequence_R1_R1B() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state R2A */
	private void exitSequence_R2_R2A() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state R2B */
	private void exitSequence_R2_R2B() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for region R1 */
	private void exitSequence_R1() {
		switch (stateVector[0]) {
			case r1_R1A :
				exitSequence_R1_R1A();
				break;

			case r1_R1B :
				exitSequence_R1_R1B();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region R2 */
	private void exitSequence_R2() {
		switch (stateVector[1]) {
			case r2_R2A :
				exitSequence_R2_R2A();
				break;

			case r2_R2B :
				exitSequence_R2_R2B();
				break;

			default :
				break;
		}
	}

	/* The reactions of state R1A. */
	private void react_R1_R1A() {
		if (check_R1_R1A_tr0_tr0()) {
			effect_R1_R1A_tr0();
		}
	}

	/* The reactions of state R1B. */
	private void react_R1_R1B() {
	}

	/* The reactions of state R2A. */
	private void react_R2_R2A() {
		if (check_R2_R2A_tr0_tr0()) {
			effect_R2_R2A_tr0();
		}
	}

	/* The reactions of state R2B. */
	private void react_R2_R2B() {
	}

	/* Default react sequence for initial entry  */
	private void react_R1__entry_Default() {
		enterSequence_R1_R1A_default();
	}

	/* Default react sequence for initial entry  */
	private void react_R2__entry_Default() {
		enterSequence_R2_R2A_default();
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case r1_R1A :
					react_R1_R1A();
					break;
				case r1_R1B :
					react_R1_R1B();
					break;
				case r2_R2A :
					react_R2_R2A();
					break;
				case r2_R2B :
					react_R2_R2B();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
