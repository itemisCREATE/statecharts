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
		MainRegion_A, $NullState$
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

	protected void clearEvents() {

	}

	protected void clearOutEvents() {
	}

	public boolean isStateActive(State state) {
		switch (state) {

			case MainRegion_A :
				return stateVector[0] == State.MainRegion_A;

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

	public int getErg() {
		return sCIDefault.getErg();
	}

	public void setErg(int value) {
		sCIDefault.setErg(value);
	}

	public void enter() {
		entryActionParenthesis();
		sCIDefault.erg = 4 * (3 - 1);

		nextStateIndex = 0;
		stateVector[0] = State.MainRegion_A;

	}

	public void exit() {
		//Handle exit of all possible states (of mainRegion) at position 0...
		switch (stateVector[0]) {

			case MainRegion_A :
				stateVector[0] = State.$NullState$;

				break;

			default :
				break;
		}

		exitActionParenthesis();
	}

	private void entryActionParenthesis() {

	}

	private void exitActionParenthesis() {

	}

	private void reactMainRegion_A() {

	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case MainRegion_A :
					reactMainRegion_A();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
