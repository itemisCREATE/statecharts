package org.yakindu.scr.readonlyvariable;

public class ReadOnlyVariableStatemachine
		implements
			IReadOnlyVariableStatemachine {

	private final class SCInterfaceImpl implements SCInterface {

		private long myInt;
		public long getMyInt() {
			return myInt;
		}

		private String myString;
		public String getMyString() {
			return myString;
		}

		private boolean myBool;
		public boolean getMyBool() {
			return myBool;
		}

		private double myReal;
		public double getMyReal() {
			return myReal;
		}

	}

	private SCInterfaceImpl sCInterface;
	private final class SCIAImpl implements SCIA {

		private long myInt;
		public long getMyInt() {
			return myInt;
		}

		private String myString;
		public String getMyString() {
			return myString;
		}

		private boolean myBool;
		public boolean getMyBool() {
			return myBool;
		}

		private double myReal;
		public double getMyReal() {
			return myReal;
		}

	}

	private SCIAImpl sCIA;

	public enum State {
		main_region_StateB, main_region_StateA, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public ReadOnlyVariableStatemachine() {

		sCInterface = new SCInterfaceImpl();
		sCIA = new SCIAImpl();
	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCInterface.myInt = 0;

		sCInterface.myString = "testString";

		sCInterface.myBool = true;

		sCInterface.myReal = 1.1;

		sCIA.myInt = 0;

		sCIA.myString = "testString";

		sCIA.myBool = true;

		sCIA.myReal = 1.1;
	}

	public void enter() {
		entryAction();

		enterSequence_main_region_default();
	}

	public void exit() {
		exitSequence_main_region();

		exitAction();
	}

	/**
	 * @see IStatemachine#isActive()
	 */
	@Override
	public boolean isActive() {

		return stateVector[0] != State.$NullState$;
	}

	/** 
	 * Always returns 'false' since this state machine can never become final.
	 *
	 * @see IStatemachine#isFinal() 
	 */
	@Override
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
			case main_region_StateB :
				return stateVector[0] == State.main_region_StateB;
			case main_region_StateA :
				return stateVector[0] == State.main_region_StateA;
			default :
				return false;
		}
	}

	public SCInterface getSCInterface() {
		return sCInterface;
	}
	public SCIA getSCIA() {
		return sCIA;
	}

	public long getMyInt() {
		return sCInterface.getMyInt();
	}

	public String getMyString() {
		return sCInterface.getMyString();
	}

	public boolean getMyBool() {
		return sCInterface.getMyBool();
	}

	public double getMyReal() {
		return sCInterface.getMyReal();
	}

	private boolean check_main_region_StateA_tr0_tr0() {
		return true;
	}

	private void effect_main_region_StateA_tr0() {
		exitSequence_main_region_StateA();

		enterSequence_main_region_StateB_default();
	}

	/* Entry action for statechart 'ReadOnlyVariable'. */
	private void entryAction() {
	}

	/* Entry action for state 'StateB'. */
	private void entryAction_main_region_StateB() {
		sCInterface.myInt = 100;

		sCInterface.myString = "fail";

		sCInterface.myBool = false;

		sCInterface.myReal = 6.6;

		sCIA.myInt = 200;

		sCIA.myString = "A_fail";

		sCIA.myBool = false;

		sCIA.myReal = 7.7;
	}

	/* Exit action for state 'ReadOnlyVariable'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state StateB */
	private void enterSequence_main_region_StateB_default() {
		entryAction_main_region_StateB();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_StateB;
	}

	/* 'default' enter sequence for state StateA */
	private void enterSequence_main_region_StateA_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_StateA;
	}

	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}

	/* Default exit sequence for state StateB */
	private void exitSequence_main_region_StateB() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state StateA */
	private void exitSequence_main_region_StateA() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
			case main_region_StateB :
				exitSequence_main_region_StateB();
				break;

			case main_region_StateA :
				exitSequence_main_region_StateA();
				break;

			default :
				break;
		}
	}

	/* The reactions of state StateB. */
	private void react_main_region_StateB() {
	}

	/* The reactions of state StateA. */
	private void react_main_region_StateA() {
		effect_main_region_StateA_tr0();
	}

	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_StateA_default();
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_StateB :
					react_main_region_StateB();
					break;
				case main_region_StateA :
					react_main_region_StateA();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
