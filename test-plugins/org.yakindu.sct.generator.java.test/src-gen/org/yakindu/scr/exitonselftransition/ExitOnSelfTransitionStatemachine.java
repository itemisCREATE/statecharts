package org.yakindu.scr.exitonselftransition;

public class ExitOnSelfTransitionStatemachine
		implements
			IExitOnSelfTransitionStatemachine {

	private final class SCIDefaultImpl implements SCIDefault {

		private boolean e;

		public void raiseE() {
			e = true;
		}

		private boolean f;

		public void raiseF() {
			f = true;
		}

		private int entryCount;

		public int getEntryCount() {
			return entryCount;
		}

		public void setEntryCount(int value) {
			this.entryCount = value;
		}

		private int exitCount;

		public int getExitCount() {
			return exitCount;
		}

		public void setExitCount(int value) {
			this.exitCount = value;
		}

		public void clearEvents() {
			e = false;
			f = false;
		}

	}

	private SCIDefaultImpl sCIDefault;

	public enum State {
		main_region_A, main_region_B, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public ExitOnSelfTransitionStatemachine() {

		sCIDefault = new SCIDefaultImpl();

	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCIDefault.entryCount = 0;

		sCIDefault.exitCount = 0;
	}

	public void enter() {
		entryAction();

		sCIDefault.entryCount += 1;

		nextStateIndex = 0;
		stateVector[0] = State.main_region_A;
	}

	public void exit() {
		switch (stateVector[0]) {
			case main_region_A :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				sCIDefault.exitCount += 1;
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
	public void raiseF() {
		sCIDefault.raiseF();
	}

	public int getEntryCount() {
		return sCIDefault.getEntryCount();
	}

	public void setEntryCount(int value) {
		sCIDefault.setEntryCount(value);
	}
	public int getExitCount() {
		return sCIDefault.getExitCount();
	}

	public void setExitCount(int value) {
		sCIDefault.setExitCount(value);
	}

	/* Entry action for statechart 'ExitOnSelfTransition'. */
	private void entryAction() {
	}

	/* Exit action for state 'ExitOnSelfTransition'. */
	private void exitAction() {
	}

	/* The reactions of state A. */
	private void reactMain_region_A() {
		if (sCIDefault.e) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			sCIDefault.exitCount += 1;

			sCIDefault.entryCount += 1;

			nextStateIndex = 0;
			stateVector[0] = State.main_region_A;
		} else {
			if (sCIDefault.f) {
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				sCIDefault.exitCount += 1;

				nextStateIndex = 0;
				stateVector[0] = State.main_region_B;
			}
		}
	}

	/* The reactions of state B. */
	private void reactMain_region_B() {
		if (sCIDefault.f) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			sCIDefault.entryCount += 1;

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
