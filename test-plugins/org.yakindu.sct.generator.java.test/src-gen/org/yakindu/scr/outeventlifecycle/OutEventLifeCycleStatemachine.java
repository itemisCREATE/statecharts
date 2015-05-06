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

	private boolean check_r1_A_tr0_tr0() {
		return sCInterface.e;
	}

	private boolean check_r1_B_lr0_lr0() {
		return sCInterface.f;
	}

	private boolean check_r2_B_lr0_lr0() {
		return sCInterface.f;
	}

	private void effect_r1_A_tr0() {
		exitSequence_r1_A();

		sCInterface.raiseF();

		enterSequence_r1_B_default();
	}

	private void effect_r1_B_lr0_lr0() {
		sCInterface.f_available_in_next_cycle = true;
	}

	private void effect_r2_B_lr0_lr0() {
		sCInterface.f_available_in_cycle = true;
	}

	/* Entry action for statechart 'OutEventLifeCycle'. */
	private void entryAction() {
	}

	/* Exit action for state 'OutEventLifeCycle'. */
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

	/* 'default' enter sequence for state B */
	private void enterSequence_r2_B_default() {
		nextStateIndex = 1;
		stateVector[1] = State.r2_B;
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

	/* Default exit sequence for state B */
	private void exitSequence_r2_B() {
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
			case r2_B :
				exitSequence_r2_B();
				break;

			default :
				break;
		}
	}

	/* The reactions of state A. */
	private void react_r1_A() {
		if (check_r1_A_tr0_tr0()) {
			effect_r1_A_tr0();
		}
	}

	/* The reactions of state B. */
	private void react_r1_B() {
		if (check_r1_B_lr0_lr0()) {
			effect_r1_B_lr0_lr0();
		}
	}

	/* The reactions of state B. */
	private void react_r2_B() {
		if (check_r2_B_lr0_lr0()) {
			effect_r2_B_lr0_lr0();
		}
	}

	/* Default react sequence for initial entry  */
	private void react_r1__entry_Default() {
		enterSequence_r1_A_default();
	}

	/* Default react sequence for initial entry  */
	private void react_r2__entry_Default() {
		enterSequence_r2_B_default();
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
				case r2_B :
					react_r2_B();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
