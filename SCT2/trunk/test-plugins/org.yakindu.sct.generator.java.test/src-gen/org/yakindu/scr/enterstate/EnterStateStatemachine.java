package org.yakindu.scr.enterstate;

public class EnterStateStatemachine implements IEnterStateStatemachine {

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

		nextStateIndex = 0;
		stateVector[0] = State.r_A;
	}

	public void exit() {
		switch (stateVector[0]) {
			case r_A :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case r_B_r_E :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case r_B_r_F :
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

	/* Entry action for statechart 'EnterState'. */
	private void entryAction() {
	}

	/* Exit action for state 'EnterState'. */
	private void exitAction() {
	}

	/* The reactions of state A. */
	private void reactR_A() {
		if (sCInterface.e) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.r_B_r_E;
		} else {
			if (sCInterface.f) {
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				nextStateIndex = 0;
				stateVector[0] = State.r_B_r_F;
			} else {
				if (sCInterface.g) {
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					nextStateIndex = 0;
					stateVector[0] = State.r_B_r_E;
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
