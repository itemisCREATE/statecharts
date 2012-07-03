package org.yakindu.scr.statechartlocalreactions;

public class StatechartLocalReactionsStatemachine
		implements
			IStatechartLocalReactionsStatemachine {

	private final class SCIDefaultImpl implements SCIDefault {

		private int myInt;

		public int getMyInt() {
			return myInt;
		}

		public void setMyInt(int value) {
			this.myInt = value;
		}

	}

	private SCIDefaultImpl sCIDefault;

	public enum State {
		Main_region_S1, Main_region_S2, Region2_a, $NullState$
	};

	private final State[] stateVector = new State[2];

	private int nextStateIndex;

	public StatechartLocalReactionsStatemachine() {

		sCIDefault = new SCIDefaultImpl();

	}

	public void init() {
		for (int i = 0; i < 2; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();
	}

	protected void clearEvents() {

	}

	protected void clearOutEvents() {
	}

	public boolean isStateActive(State state) {
		for (int i = 0; i < stateVector.length; i++) {
			if (stateVector[i] == state) {
				return true;
			}
		}
		return false;
	}

	public SCIDefault getSCIDefault() {
		return sCIDefault;
	}

	public int getMyInt() {
		return sCIDefault.getMyInt();
	}

	public void setMyInt(int value) {
		sCIDefault.setMyInt(value);
	}

	public void enter() {
		entryActionStatechartLocalReactions();
		nextStateIndex = 0;
		stateVector[0] = State.Main_region_S1;

		nextStateIndex = 1;
		stateVector[1] = State.Region2_a;

	}

	public void exit() {
		//Handle exit of all possible states (of main region) at position 0...
		switch (stateVector[0]) {

			case Main_region_S1 :
				stateVector[0] = State.$NullState$;

				break;

			case Main_region_S2 :
				stateVector[0] = State.$NullState$;

				break;

			default :
				break;
		}

		//Handle exit of all possible states (of region2) at position 1...
		switch (stateVector[1]) {

			case Region2_a :
				stateVector[1] = State.$NullState$;

				break;

			default :
				break;
		}

		exitActionStatechartLocalReactions();
	}

	private void entryActionStatechartLocalReactions() {

	}

	private void exitActionStatechartLocalReactions() {

	}

	private boolean conditionStatechartLocalReactionsLr0() {
		return true;
	}
	private void actionsStatechartLocalReactionsLr0() {
		sCIDefault.setMyInt(sCIDefault.getMyInt() + (1));

	}

	private void reactMain_region_S1() {
		actionsStatechartLocalReactionsLr0();
		if (true) {
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.Main_region_S2;

		}

	}
	private void reactMain_region_S2() {
		actionsStatechartLocalReactionsLr0();
		if (true) {
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.Main_region_S1;

		}

	}
	private void reactRegion2_a() {
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case Main_region_S1 :
					reactMain_region_S1();
					break;
				case Main_region_S2 :
					reactMain_region_S2();
					break;
				case Region2_a :
					reactRegion2_a();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
