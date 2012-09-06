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

		private int entryCount = 0;

		public int getEntryCount() {
			return entryCount;
		}

		public void setEntryCount(int value) {
			this.entryCount = value;
		}

		private int exitCount = 0;

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
		Main_region_A, Main_region_B, $NullState$
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
	}

	protected void clearEvents() {
		sCIDefault.clearEvents();

	}

	protected void clearOutEvents() {
	}

	public boolean isStateActive(State state) {
		switch (state) {

			case Main_region_A :
				return stateVector[0] == State.Main_region_A;

			case Main_region_B :
				return stateVector[0] == State.Main_region_B;

			default :
				return false;
		}
		/*
		for (int i=0;i<stateVector.length;i++){
			if (stateVector[i]==state) {
				return true;
			}
		}
		return false;
		 */
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

	public void enter() {
		sCIDefault.entryCount = 0;

		sCIDefault.exitCount = 0;

		entryActionExitOnSelfTransition();
		sCIDefault.entryCount += 1;

		nextStateIndex = 0;
		stateVector[0] = State.Main_region_A;

	}

	public void exit() {
		//Handle exit of all possible states (of main region) at position 0...
		switch (stateVector[0]) {

			case Main_region_A :
				stateVector[0] = State.$NullState$;
				sCIDefault.exitCount += 1;

				break;

			case Main_region_B :
				stateVector[0] = State.$NullState$;

				break;

			default :
				break;
		}

		exitActionExitOnSelfTransition();
	}

	private void entryActionExitOnSelfTransition() {

	}

	private void exitActionExitOnSelfTransition() {

	}

	private void reactMain_region_A() {
		if (sCIDefault.e) {
			sCIDefault.entryCount += 1;

			nextStateIndex = 0;
			stateVector[0] = State.Main_region_A;

		} else {
			if (sCIDefault.f) {
				stateVector[0] = State.$NullState$;
				sCIDefault.exitCount += 1;

				nextStateIndex = 0;
				stateVector[0] = State.Main_region_B;

			}
		}

	}
	private void reactMain_region_B() {
		if (sCIDefault.f) {
			stateVector[0] = State.$NullState$;

			sCIDefault.entryCount += 1;

			nextStateIndex = 0;
			stateVector[0] = State.Main_region_A;

		}

	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case Main_region_A :
					reactMain_region_A();
					break;
				case Main_region_B :
					reactMain_region_B();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
