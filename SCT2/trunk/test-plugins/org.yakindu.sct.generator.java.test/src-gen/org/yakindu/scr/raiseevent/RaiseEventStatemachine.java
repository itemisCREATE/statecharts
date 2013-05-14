package org.yakindu.scr.raiseevent;

public class RaiseEventStatemachine implements IRaiseEventStatemachine {

	private final class SCInterfaceImpl implements SCInterface {

		private boolean e1;

		public boolean isRaisedE1() {
			return e1;
		}

		private void raiseE1() {
			e1 = true;
		}

		private boolean e2;

		public void raiseE2() {
			e2 = true;
		}

		public void clearEvents() {
			e2 = false;
		}

		public void clearOutEvents() {
			e1 = false;
		}
	}

	private SCInterfaceImpl sCInterface;

	public enum State {
		main_region_StateA, main_region_StateB, second_region_SateA, second_region_StateB, $NullState$
	};

	private final State[] stateVector = new State[2];

	private int nextStateIndex;

	public RaiseEventStatemachine() {

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

		nextStateIndex = 0;
		stateVector[0] = State.main_region_StateA;

		nextStateIndex = 1;
		stateVector[1] = State.second_region_SateA;
	}

	public void exit() {
		switch (stateVector[0]) {
			case main_region_StateA :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_StateB :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			default :
				break;
		}

		switch (stateVector[1]) {
			case second_region_SateA :
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
				break;

			case second_region_StateB :
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
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
		sCInterface.clearOutEvents();
	}

	public boolean isStateActive(State state) {
		switch (state) {
			case main_region_StateA :
				return stateVector[0] == State.main_region_StateA;
			case main_region_StateB :
				return stateVector[0] == State.main_region_StateB;
			case second_region_SateA :
				return stateVector[1] == State.second_region_SateA;
			case second_region_StateB :
				return stateVector[1] == State.second_region_StateB;
			default :
				return false;
		}
	}

	public SCInterface getSCInterface() {
		return sCInterface;
	}

	public boolean isRaisedE1() {
		return sCInterface.isRaisedE1();
	}
	public void raiseE2() {
		sCInterface.raiseE2();
	}

	/* Entry action for statechart 'RaiseEvent'. */
	private void entryAction() {
	}

	/* Exit action for state 'RaiseEvent'. */
	private void exitAction() {
	}

	/* The reactions of state StateA. */
	private void reactMain_region_StateA() {
		if (sCInterface.e2) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			sCInterface.raiseE1();

			nextStateIndex = 0;
			stateVector[0] = State.main_region_StateB;
		}
	}

	/* The reactions of state StateB. */
	private void reactMain_region_StateB() {
	}

	/* The reactions of state SateA. */
	private void reactSecond_region_SateA() {
		if (sCInterface.e1) {
			nextStateIndex = 1;
			stateVector[1] = State.$NullState$;

			nextStateIndex = 1;
			stateVector[1] = State.second_region_StateB;
		}
	}

	/* The reactions of state StateB. */
	private void reactSecond_region_StateB() {
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_StateA :
					reactMain_region_StateA();
					break;
				case main_region_StateB :
					reactMain_region_StateB();
					break;
				case second_region_SateA :
					reactSecond_region_SateA();
					break;
				case second_region_StateB :
					reactSecond_region_StateB();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
