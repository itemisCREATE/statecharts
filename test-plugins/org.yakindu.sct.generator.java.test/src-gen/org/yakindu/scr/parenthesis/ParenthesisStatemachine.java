package org.yakindu.scr.parenthesis;

public class ParenthesisStatemachine implements IParenthesisStatemachine {

	private final class SCIDefaultImpl implements SCIDefault {

		private int erg;

		public int getErg() {
			return erg;
		}

		public void setErg(int value) {
			this.erg = value;
		}

	}

	private SCIDefaultImpl sCIDefault;

	public enum State {
		mainRegion_A, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public ParenthesisStatemachine() {

		sCIDefault = new SCIDefaultImpl();

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

		sCIDefault.erg = 4 * (3 - 1);

		nextStateIndex = 0;
		stateVector[0] = State.mainRegion_A;
	}

	public void exit() {
		switch (stateVector[0]) {
			case mainRegion_A :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			default :
				break;
		}

		exitAction();
	}

	protected void clearEvents() {

	}

	protected void clearOutEvents() {
	}

	public boolean isStateActive(State state) {
		switch (state) {
			case mainRegion_A :
				return stateVector[0] == State.mainRegion_A;
			default :
				return false;
		}
	}

	public SCIDefault getSCIDefault() {
		return sCIDefault;
	}

	public int getErg() {
		return sCIDefault.getErg();
	}

	public void setErg(int value) {
		sCIDefault.setErg(value);
	}

	/* Entry action for statechart 'Parenthesis'. */
	private void entryAction() {
	}

	/* Exit action for state 'Parenthesis'. */
	private void exitAction() {
	}

	/* The reactions of state A. */
	private void reactMainRegion_A() {
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case mainRegion_A :
					reactMainRegion_A();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
