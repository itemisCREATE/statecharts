package org.yakindu.scr.stextkeywordsinstatesandregions;

public class STextKeywordsInStatesAndRegionsStatemachine
		implements
			ISTextKeywordsInStatesAndRegionsStatemachine {

	private final class SCIDefaultImpl implements SCIDefault {

		private boolean e;

		public void raiseE() {
			e = true;
		}

		public void clearEvents() {
			e = false;
		}

	}

	private SCIDefaultImpl sCIDefault;

	public enum State {
		default_var, operation_interface, operation_active, $NullState$
	};

	private final State[] stateVector = new State[2];

	private int nextStateIndex;

	public STextKeywordsInStatesAndRegionsStatemachine() {

		sCIDefault = new SCIDefaultImpl();

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
		stateVector[0] = State.default_var;

		nextStateIndex = 1;
		stateVector[1] = State.operation_interface;
	}

	public void exit() {
		switch (stateVector[0]) {
			case default_var :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			default :
				break;
		}

		switch (stateVector[1]) {
			case operation_interface :
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
				break;

			case operation_active :
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
				break;

			default :
				break;
		}

		exitAction();
	}

	protected void clearEvents() {
		sCIDefault.clearEvents();

	}

	protected void clearOutEvents() {
	}

	public boolean isStateActive(State state) {
		switch (state) {
			case default_var :
				return stateVector[0] == State.default_var;
			case operation_interface :
				return stateVector[1] == State.operation_interface;
			case operation_active :
				return stateVector[1] == State.operation_active;
			default :
				return false;
		}
	}

	public SCIDefault getSCIDefault() {
		return sCIDefault;
	}

	public void raiseE() {
		sCIDefault.raiseE();
	}

	/* Entry action for statechart 'STextKeywordsInStatesAndRegions'. */
	private void entryAction() {
	}

	/* Exit action for state 'STextKeywordsInStatesAndRegions'. */
	private void exitAction() {
	}

	/* The reactions of state var. */
	private void reactDefault_var() {
	}

	/* The reactions of state interface. */
	private void reactOperation_interface() {
		if (isStateActive(State.default_var)) {
			nextStateIndex = 1;
			stateVector[1] = State.$NullState$;

			nextStateIndex = 1;
			stateVector[1] = State.operation_active;
		}
	}

	/* The reactions of state active. */
	private void reactOperation_active() {
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case default_var :
					reactDefault_var();
					break;
				case operation_interface :
					reactOperation_interface();
					break;
				case operation_active :
					reactOperation_active();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
