package org.yakindu.scr.internaleventlifecycle;

public class InternalEventLifeCycleStatemachine
		implements
			IInternalEventLifeCycleStatemachine {

	static {
	}

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

	private boolean checkR1_ATr0() {
		return i2;
	}

	private boolean checkR1_ALr0() {
		return sCInterface.e;
	}

	private boolean checkR1_BTr0() {
		return sCInterface.e;
	}

	private boolean checkR2_CTr0() {
		return i1;
	}

	private boolean checkR2_DTr0() {
		return sCInterface.f;
	}

	private void effectR1_ATr0() {
		exitSequenceR1_A();

		enterSequenceR1_B();
	}

	private void effectR1_ALr0() {
		raiseI1();
	}

	private void effectR1_BTr0() {
		exitSequenceR1_B();

		enterSequenceR1_A();
	}

	private void effectR2_CTr0() {
		exitSequenceR2_C();

		enterSequenceR2_D();
	}

	private void effectR2_DTr0() {
		exitSequenceR2_D();

		raiseI2();

		enterSequenceR2_C();
	}

	/* Entry action for statechart 'InternalEventLifeCycle'. */
	private void entryAction() {
	}

	/* Exit action for state 'InternalEventLifeCycle'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state A */
	private void enterSequenceR1_A() {
		nextStateIndex = 0;
		stateVector[0] = State.r1_A;
	}

	/* 'default' enter sequence for state B */
	private void enterSequenceR1_B() {
		nextStateIndex = 0;
		stateVector[0] = State.r1_B;
	}

	/* 'default' enter sequence for state C */
	private void enterSequenceR2_C() {
		nextStateIndex = 1;
		stateVector[1] = State.r2_C;
	}

	/* 'default' enter sequence for state D */
	private void enterSequenceR2_D() {
		nextStateIndex = 1;
		stateVector[1] = State.r2_D;
	}

	/* 'default' enter sequence for region r1 */
	private void enterSequenceR1() {
		reactInternalEventLifeCycle_r1__entry_Default();
	}

	/* 'default' enter sequence for region r2 */
	private void enterSequenceR2() {
		reactInternalEventLifeCycle_r2__entry_Default();
	}

	/* Default exit sequence for state A */
	private void exitSequenceR1_A() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state B */
	private void exitSequenceR1_B() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state C */
	private void exitSequenceR2_C() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state D */
	private void exitSequenceR2_D() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for region r1 */
	private void exitSequenceR1() {
		switch (stateVector[0]) {
			case r1_A :
				exitSequenceR1_A();
				break;

			case r1_B :
				exitSequenceR1_B();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region r2 */
	private void exitSequenceR2() {
		switch (stateVector[1]) {
			case r2_C :
				exitSequenceR2_C();
				break;

			case r2_D :
				exitSequenceR2_D();
				break;

			default :
				break;
		}
	}

	/* The reactions of state A. */
	private void reactR1_A() {
		if (checkR1_ATr0()) {
			effectR1_ATr0();
		} else {
			if (checkR1_ALr0()) {
				effectR1_ALr0();
			}
		}
	}

	/* The reactions of state B. */
	private void reactR1_B() {
		if (checkR1_BTr0()) {
			effectR1_BTr0();
		}
	}

	/* The reactions of state C. */
	private void reactR2_C() {
		if (checkR2_CTr0()) {
			effectR2_CTr0();
		}
	}

	/* The reactions of state D. */
	private void reactR2_D() {
		if (checkR2_DTr0()) {
			effectR2_DTr0();
		}
	}

	/* Default react sequence for initial entry  */
	private void reactInternalEventLifeCycle_r1__entry_Default() {
		enterSequenceR1_A();
	}

	/* Default react sequence for initial entry  */
	private void reactInternalEventLifeCycle_r2__entry_Default() {
		enterSequenceR2_C();
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
