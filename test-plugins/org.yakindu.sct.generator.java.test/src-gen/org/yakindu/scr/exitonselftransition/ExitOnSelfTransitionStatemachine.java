package org.yakindu.scr.exitonselftransition;

public class ExitOnSelfTransitionStatemachine
		implements
			IExitOnSelfTransitionStatemachine {

	private final class SCInterfaceImpl implements SCInterface {

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

	private SCInterfaceImpl sCInterface;

	public enum State {
		main_region_A, main_region_B, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public ExitOnSelfTransitionStatemachine() {

		sCInterface = new SCInterfaceImpl();

	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCInterface.entryCount = 0;

		sCInterface.exitCount = 0;
	}

	public void enter() {
		entryAction();

		sCInterface.entryCount += 1;

		nextStateIndex = 0;
		stateVector[0] = State.main_region_A;
	}

	public void exit() {
		switch (stateVector[0]) {
			case main_region_A :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				sCInterface.exitCount += 1;
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
		sCInterface.clearEvents();

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

	public SCInterface getSCInterface() {
		return sCInterface;
	}

	public void raiseE() {
		sCInterface.raiseE();
	}
	public void raiseF() {
		sCInterface.raiseF();
	}

	public int getEntryCount() {
		return sCInterface.getEntryCount();
	}

	public void setEntryCount(int value) {
		sCInterface.setEntryCount(value);
	}
	public int getExitCount() {
		return sCInterface.getExitCount();
	}

	public void setExitCount(int value) {
		sCInterface.setExitCount(value);
	}

	/* Entry action for statechart 'ExitOnSelfTransition'. */
	private void entryAction() {
	}

	/* Exit action for state 'ExitOnSelfTransition'. */
	private void exitAction() {
	}

	/* The reactions of state A. */
	private void reactMain_region_A() {
		if (sCInterface.e) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			sCInterface.exitCount += 1;

			sCInterface.entryCount += 1;

			nextStateIndex = 0;
			stateVector[0] = State.main_region_A;
		} else {
			if (sCInterface.f) {
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				sCInterface.exitCount += 1;

				nextStateIndex = 0;
				stateVector[0] = State.main_region_B;
			}
		}
	}

	/* The reactions of state B. */
	private void reactMain_region_B() {
		if (sCInterface.f) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			sCInterface.entryCount += 1;

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
