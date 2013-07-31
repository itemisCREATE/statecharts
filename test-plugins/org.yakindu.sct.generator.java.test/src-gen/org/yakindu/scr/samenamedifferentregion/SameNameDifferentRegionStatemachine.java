package org.yakindu.scr.samenamedifferentregion;

public class SameNameDifferentRegionStatemachine
		implements
			ISameNameDifferentRegionStatemachine {

	private final class SCInterfaceImpl implements SCInterface {

		private boolean e1;

		public void raiseE1() {
			e1 = true;
		}

		public void clearEvents() {
			e1 = false;
		}

	}

	private SCInterfaceImpl sCInterface;

	public enum State {
		main_region_StateA, main_region_StateB, main_region_StateB_r1_StateA, main_region_StateB_r1_StateB, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public SameNameDifferentRegionStatemachine() {

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
		stateVector[0] = State.main_region_StateA;
	}

	public void exit() {
		switch (stateVector[0]) {
			case main_region_StateA :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_StateB_r1_StateA :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_StateB_r1_StateB :
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
			case main_region_StateA :
				return stateVector[0] == State.main_region_StateA;
			case main_region_StateB :
				return stateVector[0].ordinal() >= State.main_region_StateB
						.ordinal()
						&& stateVector[0].ordinal() <= State.main_region_StateB_r1_StateB
								.ordinal();
			case main_region_StateB_r1_StateA :
				return stateVector[0] == State.main_region_StateB_r1_StateA;
			case main_region_StateB_r1_StateB :
				return stateVector[0] == State.main_region_StateB_r1_StateB;
			default :
				return false;
		}
	}

	public SCInterface getSCInterface() {
		return sCInterface;
	}

	public void raiseE1() {
		sCInterface.raiseE1();
	}

	/* Entry action for statechart 'SameNameDifferentRegion'. */
	private void entryAction() {
	}

	/* Exit action for state 'SameNameDifferentRegion'. */
	private void exitAction() {
	}

	/* The reactions of state StateA. */
	private void reactMain_region_StateA() {
		if (sCInterface.e1) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.main_region_StateB_r1_StateA;
		}
	}

	/* The reactions of state StateA. */
	private void reactMain_region_StateB_r1_StateA() {
		if (sCInterface.e1) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.main_region_StateB_r1_StateB;
		}
	}

	/* The reactions of state StateB. */
	private void reactMain_region_StateB_r1_StateB() {
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_StateA :
					reactMain_region_StateA();
					break;
				case main_region_StateB_r1_StateA :
					reactMain_region_StateB_r1_StateA();
					break;
				case main_region_StateB_r1_StateB :
					reactMain_region_StateB_r1_StateB();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
