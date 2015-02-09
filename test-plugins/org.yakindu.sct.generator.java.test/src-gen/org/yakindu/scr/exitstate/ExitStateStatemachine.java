package org.yakindu.scr.exitstate;

public class ExitStateStatemachine implements IExitStateStatemachine {

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

		private boolean g;

		public void raiseG() {
			g = true;
		}

		public void clearEvents() {
			e = false;
			f = false;
			g = false;
		}

	}

	private SCInterfaceImpl sCInterface;

	public enum State {
		r_A, r_A_r_B, r_E, r_F, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public ExitStateStatemachine() {

		sCInterface = new SCInterfaceImpl();
	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

	}

	public void enter() {
		entryAction();

		enterSequenceR();
	}

	public void exit() {
		exitSequenceR();

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
			case r_A :
				return stateVector[0].ordinal() >= State.r_A.ordinal()
						&& stateVector[0].ordinal() <= State.r_A_r_B.ordinal();
			case r_A_r_B :
				return stateVector[0] == State.r_A_r_B;
			case r_E :
				return stateVector[0] == State.r_E;
			case r_F :
				return stateVector[0] == State.r_F;
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
	public void raiseG() {
		sCInterface.raiseG();
	}

	private boolean checkR_A_r_BTr0() {
		return sCInterface.g;
	}

	private boolean checkR_A_r_BTr1() {
		return sCInterface.f;
	}

	private boolean checkR_A_r_BTr2() {
		return sCInterface.e;
	}

	private void effectR_ATr0() {
		exitSequenceR_A();

		enterSequenceR_E();
	}

	private void effectR_ATr1() {
		exitSequenceR_A();

		enterSequenceR_F();
	}

	private void effectR_A_r_BTr0() {
		exitSequenceR_A_r_B();

		reactExitState_r_A_r_g();
	}

	private void effectR_A_r_BTr1() {
		exitSequenceR_A_r_B();

		reactExitState_r_A_r_f();
	}

	private void effectR_A_r_BTr2() {
		exitSequenceR_A_r_B();

		reactExitState_r_A_r__exit_Default();
	}

	/* Entry action for statechart 'ExitState'. */
	private void entryAction() {
	}

	/* Exit action for state 'ExitState'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state A */
	private void enterSequenceR_A() {
		enterSequenceR_A_r();
	}

	/* 'default' enter sequence for state B */
	private void enterSequenceR_A_r_B() {
		nextStateIndex = 0;
		stateVector[0] = State.r_A_r_B;
	}

	/* 'default' enter sequence for state E */
	private void enterSequenceR_E() {
		nextStateIndex = 0;
		stateVector[0] = State.r_E;
	}

	/* 'default' enter sequence for state F */
	private void enterSequenceR_F() {
		nextStateIndex = 0;
		stateVector[0] = State.r_F;
	}

	/* 'default' enter sequence for region r */
	private void enterSequenceR() {
		reactExitState_r__entry_Default();
	}

	/* 'default' enter sequence for region r */
	private void enterSequenceR_A_r() {
		reactExitState_r_A_r__entry_Default();
	}

	/* Default exit sequence for state A */
	private void exitSequenceR_A() {
		exitSequenceR_A_r();
	}

	/* Default exit sequence for state B */
	private void exitSequenceR_A_r_B() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state E */
	private void exitSequenceR_E() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state F */
	private void exitSequenceR_F() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for region r */
	private void exitSequenceR() {
		switch (stateVector[0]) {
			case r_A_r_B :
				exitSequenceR_A_r_B();
				break;

			case r_E :
				exitSequenceR_E();
				break;

			case r_F :
				exitSequenceR_F();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region r */
	private void exitSequenceR_A_r() {
		switch (stateVector[0]) {
			case r_A_r_B :
				exitSequenceR_A_r_B();
				break;

			default :
				break;
		}
	}

	/* The reactions of state B. */
	private void reactR_A_r_B() {
		if (checkR_A_r_BTr0()) {
			effectR_A_r_BTr0();
		} else {
			if (checkR_A_r_BTr1()) {
				effectR_A_r_BTr1();
			} else {
				if (checkR_A_r_BTr2()) {
					effectR_A_r_BTr2();
				}
			}
		}
	}

	/* The reactions of state E. */
	private void reactR_E() {
	}

	/* The reactions of state F. */
	private void reactR_F() {
	}

	/* Default react sequence for initial entry  */
	private void reactExitState_r__entry_Default() {
		enterSequenceR_A();
	}

	/* Default react sequence for initial entry  */
	private void reactExitState_r_A_r__entry_Default() {
		enterSequenceR_A_r_B();
	}

	/* The reactions of exit default. */
	private void reactExitState_r_A_r__exit_Default() {
		effectR_ATr0();
	}

	/* The reactions of exit f. */
	private void reactExitState_r_A_r_f() {
		effectR_ATr1();
	}

	/* The reactions of exit g. */
	private void reactExitState_r_A_r_g() {
		effectR_ATr0();
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case r_A_r_B :
					reactR_A_r_B();
					break;
				case r_E :
					reactR_E();
					break;
				case r_F :
					reactR_F();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
