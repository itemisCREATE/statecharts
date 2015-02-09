package org.yakindu.scr.enterstate;

public class EnterStateStatemachine implements IEnterStateStatemachine {

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
		r_A, r_B, r_B_r_E, r_B_r_F, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public EnterStateStatemachine() {

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
				return stateVector[0] == State.r_A;
			case r_B :
				return stateVector[0].ordinal() >= State.r_B.ordinal()
						&& stateVector[0].ordinal() <= State.r_B_r_F.ordinal();
			case r_B_r_E :
				return stateVector[0] == State.r_B_r_E;
			case r_B_r_F :
				return stateVector[0] == State.r_B_r_F;
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

	private boolean checkR_ATr0() {
		return sCInterface.e;
	}

	private boolean checkR_ATr1() {
		return sCInterface.f;
	}

	private boolean checkR_ATr2() {
		return sCInterface.g;
	}

	private void effectR_ATr0() {
		exitSequenceR_A();

		enterSequenceR_B();
	}

	private void effectR_ATr1() {
		exitSequenceR_A();

		enterSequenceR_B();
	}

	private void effectR_ATr2() {
		exitSequenceR_A();

		enterSequenceR_B();
	}

	/* Entry action for statechart 'EnterState'. */
	private void entryAction() {
	}

	/* Exit action for state 'EnterState'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state A */
	private void enterSequenceR_A() {
		nextStateIndex = 0;
		stateVector[0] = State.r_A;
	}

	/* 'default' enter sequence for state B */
	private void enterSequenceR_B() {
		enterSequenceR_B_r();
	}

	/* 'f' enter sequence for state B */
	private void enterSequenceR_B() {
		enterSequenceR_B_r();
	}

	/* 'g' enter sequence for state B */
	private void enterSequenceR_B() {
		enterSequenceR_B_r();
	}

	/* 'default' enter sequence for state E */
	private void enterSequenceR_B_r_E() {
		nextStateIndex = 0;
		stateVector[0] = State.r_B_r_E;
	}

	/* 'default' enter sequence for state F */
	private void enterSequenceR_B_r_F() {
		nextStateIndex = 0;
		stateVector[0] = State.r_B_r_F;
	}

	/* 'default' enter sequence for region r */
	private void enterSequenceR() {
		reactEnterState_r__entry_Default();
	}

	/* 'default' enter sequence for region r */
	private void enterSequenceR_B_r() {
		reactEnterState_r_B_r__entry_Default();
	}

	/* 'f' enter sequence for region r */
	private void enterSequenceR_B_r() {
		reactEnterState_r_B_r_f();
	}

	/* Default exit sequence for state A */
	private void exitSequenceR_A() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state E */
	private void exitSequenceR_B_r_E() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state F */
	private void exitSequenceR_B_r_F() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for region r */
	private void exitSequenceR() {
		switch (stateVector[0]) {
			case r_A :
				exitSequenceR_A();
				break;

			case r_B_r_E :
				exitSequenceR_B_r_E();
				break;

			case r_B_r_F :
				exitSequenceR_B_r_F();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region r */
	private void exitSequenceR_B_r() {
		switch (stateVector[0]) {
			case r_B_r_E :
				exitSequenceR_B_r_E();
				break;

			case r_B_r_F :
				exitSequenceR_B_r_F();
				break;

			default :
				break;
		}
	}

	/* The reactions of state A. */
	private void reactR_A() {
		if (checkR_ATr0()) {
			effectR_ATr0();
		} else {
			if (checkR_ATr1()) {
				effectR_ATr1();
			} else {
				if (checkR_ATr2()) {
					effectR_ATr2();
				}
			}
		}
	}

	/* The reactions of state E. */
	private void reactR_B_r_E() {
	}

	/* The reactions of state F. */
	private void reactR_B_r_F() {
	}

	/* Default react sequence for initial entry  */
	private void reactEnterState_r__entry_Default() {
		enterSequenceR_A();
	}

	/* Default react sequence for initial entry  */
	private void reactEnterState_r_B_r__entry_Default() {
		enterSequenceR_B_r_E();
	}

	/* Default react sequence for initial entry f */
	private void reactEnterState_r_B_r_f() {
		enterSequenceR_B_r_F();
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case r_A :
					reactR_A();
					break;
				case r_B_r_E :
					reactR_B_r_E();
					break;
				case r_B_r_F :
					reactR_B_r_F();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
