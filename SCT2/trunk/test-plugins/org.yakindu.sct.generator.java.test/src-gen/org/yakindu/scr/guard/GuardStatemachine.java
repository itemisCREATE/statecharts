package org.yakindu.scr.guard;

public class GuardStatemachine implements IGuardStatemachine {

	private final class SCInterfaceImpl implements SCInterface {

		private boolean event1;

		public void raiseEvent1() {
			event1 = true;
		}

		private boolean event2;

		public void raiseEvent2() {
			event2 = true;
		}

		private boolean return_ID;

		public void raiseReturn() {
			return_ID = true;
		}

		private int myVar;

		public int getMyVar() {
			return myVar;
		}

		public void setMyVar(int value) {
			this.myVar = value;
		}

		public void clearEvents() {
			event1 = false;
			event2 = false;
			return_ID = false;
		}

	}

	private SCInterfaceImpl sCInterface;

	public enum State {
		main_region_A, main_region_B, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public GuardStatemachine() {

		sCInterface = new SCInterfaceImpl();

	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCInterface.myVar = 0;
	}

	public void enter() {
		entryAction();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_A;
	}

	public void exit() {
		switch (stateVector[0]) {
			case main_region_A :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
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

	public void raiseEvent1() {
		sCInterface.raiseEvent1();
	}
	public void raiseEvent2() {
		sCInterface.raiseEvent2();
	}
	public void raiseReturn() {
		sCInterface.raiseReturn();
	}

	public int getMyVar() {
		return sCInterface.getMyVar();
	}

	public void setMyVar(int value) {
		sCInterface.setMyVar(value);
	}

	/* Entry action for statechart 'Guard'. */
	private void entryAction() {
	}

	/* Exit action for state 'Guard'. */
	private void exitAction() {
	}

	/* The reactions of state A. */
	private void reactMain_region_A() {
		if (sCInterface.event1 && sCInterface.myVar == 10) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			sCInterface.myVar = 10;

			nextStateIndex = 0;
			stateVector[0] = State.main_region_B;
		} else {
			if (sCInterface.event2) {
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				sCInterface.myVar = 10;

				nextStateIndex = 0;
				stateVector[0] = State.main_region_B;
			}
		}
	}

	/* The reactions of state B. */
	private void reactMain_region_B() {
		if (sCInterface.return_ID) {
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
