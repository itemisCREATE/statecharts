package org.yakindu.scr.guardedexit;

public class GuardedExitStatemachine implements IGuardedExitStatemachine {

	private final class SCIDefaultImpl implements SCIDefault {

		private boolean e;

		public void raiseE() {
			e = true;
		}

		private boolean guard = false;

		public boolean getGuard() {
			return guard;
		}

		public void setGuard(boolean value) {
			this.guard = value;
		}

		private boolean done = false;

		public boolean getDone() {
			return done;
		}

		public void setDone(boolean value) {
			this.done = value;
		}

		public void clearEvents() {
			e = false;
		}

	}

	private SCIDefaultImpl sCIDefault;

	public enum State {
		main_region_A, main_region_B, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public GuardedExitStatemachine() {

		sCIDefault = new SCIDefaultImpl();

	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();
	}

	public void enter() {
		sCIDefault.guard = false;

		sCIDefault.done = false;

		entryAction();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_A;
	}

	public void exit() {
		switch (stateVector[0]) {
			case main_region_A :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				sCIDefault.done = true;
				break;

			case main_region_B :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			default :
				break;
		}

		exitAction();
	}

	protected void clearEvents() {
		sCIDefault.clearEvents();

	}

	protected void clearOutEvents() {
	}

	public boolean isStateActive(State state) {
		switch (state) {
			case main_region_A :
				return stateVector[0] == State.main_region_A;
			case main_region_B :
				return stateVector[0] == State.main_region_B;
			default :
				return false;
		}
	}

	public SCIDefault getSCIDefault() {
		return sCIDefault;
	}

	public void raiseE() {
		sCIDefault.raiseE();
	}

	public boolean getGuard() {
		return sCIDefault.getGuard();
	}

	public void setGuard(boolean value) {
		sCIDefault.setGuard(value);
	}
	public boolean getDone() {
		return sCIDefault.getDone();
	}

	public void setDone(boolean value) {
		sCIDefault.setDone(value);
	}

	/* Entry action for statechart 'GuardedExit'. */
	private void entryAction() {
	}

	/* Exit action for state 'GuardedExit'. */
	private void exitAction() {
	}

	/* The reactions of state A. */
	private void reactMain_region_A() {
		if (sCIDefault.e) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			sCIDefault.done = true;

			nextStateIndex = 0;
			stateVector[0] = State.main_region_B;
		}
	}

	/* The reactions of state B. */
	private void reactMain_region_B() {
		if (sCIDefault.e) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.main_region_A;
		}
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_A :
					reactMain_region_A();
					break;
				case main_region_B :
					reactMain_region_B();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
