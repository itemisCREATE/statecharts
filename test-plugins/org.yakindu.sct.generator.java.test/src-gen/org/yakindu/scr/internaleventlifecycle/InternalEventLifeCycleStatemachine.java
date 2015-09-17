package org.yakindu.scr.internaleventlifecycle;

public class InternalEventLifeCycleStatemachine implements IInternalEventLifeCycleStatemachine {

	protected class SCInterfaceImpl implements SCInterface {

		private boolean e;

		public void raiseE() {
			e = true;
		}

		private boolean f;

		public void raiseF() {
			f = true;
		}

		protected void clearEvents() {
			e = false;
			f = false;
		}

	}

	protected SCInterfaceImpl sCInterface;

	public enum State {
		r1_A, r1_B, r2_C, r2_D, $NullState$
	};

	private final State[] stateVector = new State[2];

	private int nextStateIndex;

	private boolean i1;

	private boolean i2;

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

		enterSequence_r1_default();

		enterSequence_r2_default();
	}

	public void exit() {
		exitSequence_r1();

		exitSequence_r2();

		exitAction();
	}

	/**
	 * @see IStatemachine#isActive()
	 */
	public boolean isActive() {

		return stateVector[0] != State.$NullState$ || stateVector[1] != State.$NullState$;
	}

	/** 
	* Always returns 'false' since this state machine can never become final.
	*
	 * @see IStatemachine#isFinal() 
	 */
	public boolean isFinal() {
		return false;
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

	private boolean check_r1_A_tr0_tr0() {
		return i2;
	}

	private boolean check_r1_A_lr0_lr0() {
		return sCInterface.e;
	}

	private boolean check_r1_B_tr0_tr0() {
		return sCInterface.e;
	}

	private boolean check_r2_C_tr0_tr0() {
		return i1;
	}

	private boolean check_r2_D_tr0_tr0() {
		return sCInterface.f;
	}

	private void effect_r1_A_tr0() {
		exitSequence_r1_A();

		enterSequence_r1_B_default();
	}

	private void effect_r1_A_lr0_lr0() {
		raiseI1();
	}

	private void effect_r1_B_tr0() {
		exitSequence_r1_B();

		enterSequence_r1_A_default();
	}

	private void effect_r2_C_tr0() {
		exitSequence_r2_C();

		enterSequence_r2_D_default();
	}

	private void effect_r2_D_tr0() {
		exitSequence_r2_D();

		raiseI2();

		enterSequence_r2_C_default();
	}

	/* Entry action for statechart 'InternalEventLifeCycle'. */
	private void entryAction() {
	}

	/* Exit action for state 'InternalEventLifeCycle'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state A */
	private void enterSequence_r1_A_default() {
		nextStateIndex = 0;
		stateVector[0] = State.r1_A;
	}

	/* 'default' enter sequence for state B */
	private void enterSequence_r1_B_default() {
		nextStateIndex = 0;
		stateVector[0] = State.r1_B;
	}

	/* 'default' enter sequence for state C */
	private void enterSequence_r2_C_default() {
		nextStateIndex = 1;
		stateVector[1] = State.r2_C;
	}

	/* 'default' enter sequence for state D */
	private void enterSequence_r2_D_default() {
		nextStateIndex = 1;
		stateVector[1] = State.r2_D;
	}

	/* 'default' enter sequence for region r1 */
	private void enterSequence_r1_default() {
		react_r1__entry_Default();
	}

	/* 'default' enter sequence for region r2 */
	private void enterSequence_r2_default() {
		react_r2__entry_Default();
	}

	/* Default exit sequence for state A */
	private void exitSequence_r1_A() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state B */
	private void exitSequence_r1_B() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state C */
	private void exitSequence_r2_C() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state D */
	private void exitSequence_r2_D() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for region r1 */
	private void exitSequence_r1() {
		switch (stateVector[0]) {
			case r1_A :
				exitSequence_r1_A();
				break;

			case r1_B :
				exitSequence_r1_B();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region r2 */
	private void exitSequence_r2() {
		switch (stateVector[1]) {
			case r2_C :
				exitSequence_r2_C();
				break;

			case r2_D :
				exitSequence_r2_D();
				break;

			default :
				break;
		}
	}

	/* The reactions of state A. */
	private void react_r1_A() {
		if (check_r1_A_tr0_tr0()) {
			effect_r1_A_tr0();
		} else {
			if (check_r1_A_lr0_lr0()) {
				effect_r1_A_lr0_lr0();
			}
		}
	}

	/* The reactions of state B. */
	private void react_r1_B() {
		if (check_r1_B_tr0_tr0()) {
			effect_r1_B_tr0();
		}
	}

	/* The reactions of state C. */
	private void react_r2_C() {
		if (check_r2_C_tr0_tr0()) {
			effect_r2_C_tr0();
		}
	}

	/* The reactions of state D. */
	private void react_r2_D() {
		if (check_r2_D_tr0_tr0()) {
			effect_r2_D_tr0();
		}
	}

	/* Default react sequence for initial entry  */
	private void react_r1__entry_Default() {
		enterSequence_r1_A_default();
	}

	/* Default react sequence for initial entry  */
	private void react_r2__entry_Default() {
		enterSequence_r2_C_default();
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case r1_A :
					react_r1_A();
					break;
				case r1_B :
					react_r1_B();
					break;
				case r2_C :
					react_r2_C();
					break;
				case r2_D :
					react_r2_D();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
