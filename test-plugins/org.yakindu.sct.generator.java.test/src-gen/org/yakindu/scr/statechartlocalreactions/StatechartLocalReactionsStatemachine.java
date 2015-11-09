package org.yakindu.scr.statechartlocalreactions;

public class StatechartLocalReactionsStatemachine implements IStatechartLocalReactionsStatemachine {

	protected class SCInterfaceImpl implements SCInterface {

		private long myInt;

		public long getMyInt() {
			return myInt;
		}

		public void setMyInt(long value) {
			this.myInt = value;
		}

	}

	protected SCInterfaceImpl sCInterface;

	private boolean initialized = false;

	public enum State {
		main_region_S1, main_region_S2, region2_a, $NullState$
	};

	private final State[] stateVector = new State[2];

	private int nextStateIndex;

	public StatechartLocalReactionsStatemachine() {

		sCInterface = new SCInterfaceImpl();
	}

	public void init() {
		this.initialized = true;
		for (int i = 0; i < 2; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCInterface.setMyInt(0);
	}

	public void enter() {
		if (!initialized)
			throw new IllegalStateException(
					"The statemachine needs to be initialized first by calling the init() function.");

		entryAction();

		enterSequence_main_region_default();

		enterSequence_region2_default();
	}

	public void exit() {
		exitSequence_main_region();

		exitSequence_region2();

		exitAction();
	}

	/**
	 * @see IStatemachine#isActive()
	 */
	public boolean isActive() {

		return stateVector[0] != State.$NullState$ || stateVector[1] != State.$NullState$;
	}

	/** 
	* Always returns 'false' since this state machine can never become final.
	*
	 * @see IStatemachine#isFinal() 
	 */
	public boolean isFinal() {
		return false;
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

	private boolean check__lr0() {
		return true;
	}

	private boolean check__lr1() {
		return sCInterface.getMyInt() == 100;
	}

	private boolean check_main_region_S1_tr0_tr0() {
		return true;
	}

	private boolean check_main_region_S2_tr0_tr0() {
		return true;
	}

	private void effect__lr0() {
		sCInterface.setMyInt(sCInterface.getMyInt() + 1);
	}

	private void effect__lr1() {
		sCInterface.setMyInt(0);
	}

	private void effect_main_region_S1_tr0() {
		exitSequence_main_region_S1();

		enterSequence_main_region_S2_default();
	}

	private void effect_main_region_S2_tr0() {
		exitSequence_main_region_S2();

		enterSequence_main_region_S1_default();
	}

	/* Entry action for statechart 'StatechartLocalReactions'. */
	private void entryAction() {
	}

	/* Exit action for state 'StatechartLocalReactions'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state S1 */
	private void enterSequence_main_region_S1_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_S1;
	}

	/* 'default' enter sequence for state S2 */
	private void enterSequence_main_region_S2_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_S2;
	}

	/* 'default' enter sequence for state a */
	private void enterSequence_region2_a_default() {
		nextStateIndex = 1;
		stateVector[1] = State.region2_a;
	}

	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}

	/* 'default' enter sequence for region region2 */
	private void enterSequence_region2_default() {
		react_region2__entry_Default();
	}

	/* Default exit sequence for state S1 */
	private void exitSequence_main_region_S1() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state S2 */
	private void exitSequence_main_region_S2() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state a */
	private void exitSequence_region2_a() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
			case main_region_S1 :
				exitSequence_main_region_S1();
				break;

			case main_region_S2 :
				exitSequence_main_region_S2();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region region2 */
	private void exitSequence_region2() {
		switch (stateVector[1]) {
			case region2_a :
				exitSequence_region2_a();
				break;

			default :
				break;
		}
	}

	/* The reactions of state S1. */
	private void react_main_region_S1() {
		effect__lr0();

		if (check__lr1()) {
			effect__lr1();
		}

		effect_main_region_S1_tr0();
	}

	/* The reactions of state S2. */
	private void react_main_region_S2() {
		effect__lr0();

		if (check__lr1()) {
			effect__lr1();
		}

		effect_main_region_S2_tr0();
	}

	/* The reactions of state a. */
	private void react_region2_a() {
	}

	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_S1_default();
	}

	/* Default react sequence for initial entry  */
	private void react_region2__entry_Default() {
		enterSequence_region2_a_default();
	}

	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The statemachine needs to be initialized first by calling the init() function.");

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_S1 :
					react_main_region_S1();
					break;
				case main_region_S2 :
					react_main_region_S2();
					break;
				case region2_a :
					react_region2_a();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
