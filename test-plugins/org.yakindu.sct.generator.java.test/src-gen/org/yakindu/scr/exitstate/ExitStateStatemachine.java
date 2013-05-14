package org.yakindu.scr.exitstate;

public class ExitStateStatemachine implements IExitStateStatemachine {

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

		nextStateIndex = 0;
		stateVector[0] = State.r_A_r_B;
	}

	public void exit() {
		switch (stateVector[0]) {
			case r_A_r_B :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case r_E :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case r_F :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
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
		return sCInterface.e;
	}

	private boolean checkR_A_r_BTr1() {
		return sCInterface.f;
	}

	private boolean checkR_A_r_BTr2() {
		return sCInterface.g;
	}

	private void effectR_ATr0() {
		switch (stateVector[0]) {
			case r_A_r_B :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			default :
				break;
		}

		nextStateIndex = 0;
		stateVector[0] = State.r_E;
	}

	private void effectR_ATr1() {
		switch (stateVector[0]) {
			case r_A_r_B :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			default :
				break;
		}

		nextStateIndex = 0;
		stateVector[0] = State.r_F;
	}

	private void effectR_A_r_BTr0() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		effectR_ATr0();
	}

	private void effectR_A_r_BTr1() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		effectR_ATr1();
	}

	private void effectR_A_r_BTr2() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		effectR_ATr0();
	}

	/* Entry action for statechart 'ExitState'. */
	private void entryAction() {
	}

	/* Exit action for state 'ExitState'. */
	private void exitAction() {
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
