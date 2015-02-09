package org.yakindu.scr.statechartlocalreactions;

public class StatechartLocalReactionsStatemachine
		implements
			IStatechartLocalReactionsStatemachine {

	static {
	}

	private final class SCInterfaceImpl implements SCInterface {

		private long myInt;
		public long getMyInt() {
			return myInt;
		}

		public void setMyInt(long value) {
			this.myInt = value;
		}

	}

	private SCInterfaceImpl sCInterface;

	public enum State {
		main_region_S1, main_region_S2, region2_a, $NullState$
	};

	private final State[] stateVector = new State[2];

	private int nextStateIndex;

	public StatechartLocalReactionsStatemachine() {

		sCInterface = new SCInterfaceImpl();
	}

	public void init() {
		for (int i = 0; i < 2; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCInterface.myInt = 0;
	}

	public void enter() {
		entryAction();

		enterSequenceMain_region();

		enterSequenceRegion2();
	}

	public void exit() {
		exitSequenceMain_region();

		exitSequenceRegion2();

		exitAction();
	}

	/**
	 * This method resets the incoming events (time events included).
	 */
	protected void clearEvents() {

	}

	/**
	 * This method resets the outgoing events.
	 */
	protected void clearOutEvents() {
	}

	/**
	 * Returns true if the given state is currently active otherwise false.
	 */
	public boolean isStateActive(State state) {
		switch (state) {
			case main_region_S1 :
				return stateVector[0] == State.main_region_S1;
			case main_region_S2 :
				return stateVector[0] == State.main_region_S2;
			case region2_a :
				return stateVector[1] == State.region2_a;
			default :
				return false;
		}
	}

	public SCInterface getSCInterface() {
		return sCInterface;
	}

	public long getMyInt() {
		return sCInterface.getMyInt();
	}

	public void setMyInt(long value) {
		sCInterface.setMyInt(value);
	}

	private boolean checkLr0() {
		return true;
	}

	private boolean checkMain_region_S1Tr0() {
		return true;
	}

	private boolean checkMain_region_S2Tr0() {
		return true;
	}

	private void effectLr0() {
		sCInterface.myInt += 1;
	}

	private void effectMain_region_S1Tr0() {
		exitSequenceMain_region_S1();

		enterSequenceMain_region_S2();
	}

	private void effectMain_region_S2Tr0() {
		exitSequenceMain_region_S2();

		enterSequenceMain_region_S1();
	}

	/* Entry action for statechart 'StatechartLocalReactions'. */
	private void entryAction() {
	}

	/* Exit action for state 'StatechartLocalReactions'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state S1 */
	private void enterSequenceMain_region_S1() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_S1;
	}

	/* 'default' enter sequence for state S2 */
	private void enterSequenceMain_region_S2() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_S2;
	}

	/* 'default' enter sequence for state a */
	private void enterSequenceRegion2_a() {
		nextStateIndex = 1;
		stateVector[1] = State.region2_a;
	}

	/* 'default' enter sequence for region main region */
	private void enterSequenceMain_region() {
		reactStatechartLocalReactions_main_region__entry_Default();
	}

	/* 'default' enter sequence for region region2 */
	private void enterSequenceRegion2() {
		reactStatechartLocalReactions_region2__entry_Default();
	}

	/* Default exit sequence for state S1 */
	private void exitSequenceMain_region_S1() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state S2 */
	private void exitSequenceMain_region_S2() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state a */
	private void exitSequenceRegion2_a() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for region main region */
	private void exitSequenceMain_region() {
		switch (stateVector[0]) {
			case main_region_S1 :
				exitSequenceMain_region_S1();
				break;

			case main_region_S2 :
				exitSequenceMain_region_S2();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region region2 */
	private void exitSequenceRegion2() {
		switch (stateVector[1]) {
			case region2_a :
				exitSequenceRegion2_a();
				break;

			default :
				break;
		}
	}

	/* The reactions of state S1. */
	private void reactMain_region_S1() {
		effectLr0();

		effectMain_region_S1Tr0();
	}

	/* The reactions of state S2. */
	private void reactMain_region_S2() {
		effectLr0();

		effectMain_region_S2Tr0();
	}

	/* The reactions of state a. */
	private void reactRegion2_a() {
	}

	/* Default react sequence for initial entry  */
	private void reactStatechartLocalReactions_main_region__entry_Default() {
		enterSequenceMain_region_S1();
	}

	/* Default react sequence for initial entry  */
	private void reactStatechartLocalReactions_region2__entry_Default() {
		enterSequenceRegion2_a();
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_S1 :
					reactMain_region_S1();
					break;
				case main_region_S2 :
					reactMain_region_S2();
					break;
				case region2_a :
					reactRegion2_a();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
