package org.yakindu.scr.parenthesis;

public class ParenthesisStatemachine implements IParenthesisStatemachine {

	protected class SCInterfaceImpl implements SCInterface {

		private long erg;

		public long getErg() {
			return erg;
		}

		public void setErg(long value) {
			this.erg = value;
		}

	}

	protected SCInterfaceImpl sCInterface;

	public enum State {
		mainRegion_A, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public ParenthesisStatemachine() {

		sCInterface = new SCInterfaceImpl();
	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCInterface.setErg(0);
	}

	public void enter() {
		entryAction();

		enterSequence_mainRegion_default();
	}

	public void exit() {
		exitSequence_mainRegion();

		exitAction();
	}

	/**
	 * @see IStatemachine#isActive()
	 */
	public boolean isActive() {

		return stateVector[0] != State.$NullState$;
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
			case mainRegion_A :
				return stateVector[0] == State.mainRegion_A;
			default :
				return false;
		}
	}

	public SCInterface getSCInterface() {
		return sCInterface;
	}

	public long getErg() {
		return sCInterface.getErg();
	}

	public void setErg(long value) {
		sCInterface.setErg(value);
	}

	/* Entry action for statechart 'Parenthesis'. */
	private void entryAction() {
	}

	/* Entry action for state 'A'. */
	private void entryAction_mainRegion_A() {
		sCInterface.setErg(4 * (3 - 1));
	}

	/* Exit action for state 'Parenthesis'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state A */
	private void enterSequence_mainRegion_A_default() {
		entryAction_mainRegion_A();

		nextStateIndex = 0;
		stateVector[0] = State.mainRegion_A;
	}

	/* 'default' enter sequence for region mainRegion */
	private void enterSequence_mainRegion_default() {
		react_mainRegion__entry_Default();
	}

	/* Default exit sequence for state A */
	private void exitSequence_mainRegion_A() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for region mainRegion */
	private void exitSequence_mainRegion() {
		switch (stateVector[0]) {
			case mainRegion_A :
				exitSequence_mainRegion_A();
				break;

			default :
				break;
		}
	}

	/* The reactions of state A. */
	private void react_mainRegion_A() {
	}

	/* Default react sequence for initial entry  */
	private void react_mainRegion__entry_Default() {
		enterSequence_mainRegion_A_default();
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case mainRegion_A :
					react_mainRegion_A();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
