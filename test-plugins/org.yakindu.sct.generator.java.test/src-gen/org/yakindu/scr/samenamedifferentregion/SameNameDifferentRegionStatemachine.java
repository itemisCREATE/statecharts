package org.yakindu.scr.samenamedifferentregion;

public class SameNameDifferentRegionStatemachine
		implements
			ISameNameDifferentRegionStatemachine {

	private final class SCIDefaultImpl implements SCIDefault {

		private boolean e1;

		public void raiseE1() {
			e1 = true;
		}

		public void clearEvents() {
			e1 = false;
		}

	}

	private SCIDefaultImpl sCIDefault;

	public enum State {
		Main_region_StateA, Main_region_StateB, Main_region_StateB_r1_StateA, Main_region_StateB_r1_StateB, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public SameNameDifferentRegionStatemachine() {

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

			case Main_region_StateA :
				return stateVector[0] == State.Main_region_StateA;

			case Main_region_StateB :
				return stateVector[0].ordinal() >= State.Main_region_StateB
						.ordinal()
						&& stateVector[0].ordinal() <= State.Main_region_StateB_r1_StateB
								.ordinal();

			case Main_region_StateB_r1_StateA :
				return stateVector[0] == State.Main_region_StateB_r1_StateA;

			case Main_region_StateB_r1_StateB :
				return stateVector[0] == State.Main_region_StateB_r1_StateB;

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

	public void raiseE1() {
		sCIDefault.raiseE1();
	}

	public void enter() {
		entryActionSameNameDifferentRegion();
		nextStateIndex = 0;
		stateVector[0] = State.Main_region_StateA;

	}

	public void exit() {
		//Handle exit of all possible states (of main region) at position 0...
		switch (stateVector[0]) {

			case Main_region_StateA :
				stateVector[0] = State.$NullState$;

				break;

			case Main_region_StateB_r1_StateA :
				stateVector[0] = State.$NullState$;

				break;

			case Main_region_StateB_r1_StateB :
				stateVector[0] = State.$NullState$;

				break;

			default :
				break;
		}

		exitActionSameNameDifferentRegion();
	}

	private void entryActionSameNameDifferentRegion() {

	}

	private void exitActionSameNameDifferentRegion() {

	}

	private void reactMain_region_StateA() {
		if (sCIDefault.e1) {
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.Main_region_StateB_r1_StateA;

		}

	}
	private void reactMain_region_StateB() {
	}
	private void reactMain_region_StateB_r1_StateA() {
		if (sCIDefault.e1) {
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.Main_region_StateB_r1_StateB;

		}

	}
	private void reactMain_region_StateB_r1_StateB() {

	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case Main_region_StateA :
					reactMain_region_StateA();
					break;
				case Main_region_StateB :
					reactMain_region_StateB();
					break;
				case Main_region_StateB_r1_StateA :
					reactMain_region_StateB_r1_StateA();
					break;
				case Main_region_StateB_r1_StateB :
					reactMain_region_StateB_r1_StateB();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
