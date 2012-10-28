package org.yakindu.scr.assignmentasexpression;

public class AssignmentAsExpressionStatemachine
		implements
			IAssignmentAsExpressionStatemachine {

	private final class SCIDefaultImpl implements SCIDefault {

		private int a = 0;

		public int getA() {
			return a;
		}

		public void setA(int value) {
			this.a = value;
		}

		private int b = 0;

		public int getB() {
			return b;
		}

		public void setB(int value) {
			this.b = value;
		}

	}

	private SCIDefaultImpl sCIDefault;

	public enum State {
		main_region_A, main_region_B, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public AssignmentAsExpressionStatemachine() {

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
		sCIDefault.a = 0;

		sCIDefault.b = 0;

		entryAction();

		sCIDefault.a = (sCIDefault.b = 5) + 4;

		nextStateIndex = 0;
		stateVector[0] = State.main_region_A;
	}

	public void exit() {
		switch (stateVector[0]) {
			case main_region_A :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_B :
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
			case main_region_A :
				return stateVector[0] == State.main_region_A;
			case main_region_B :
				return stateVector[0] == State.main_region_B;
			default :
				return false;
		}
	}

	public SCIDefault getSCIDefault() {
		return sCIDefault;
	}

	public int getA() {
		return sCIDefault.getA();
	}

	public void setA(int value) {
		sCIDefault.setA(value);
	}
	public int getB() {
		return sCIDefault.getB();
	}

	public void setB(int value) {
		sCIDefault.setB(value);
	}

	/* Entry action for statechart 'AssignmentAsExpression'. */
	private void entryAction() {
	}

	/* Exit action for state 'AssignmentAsExpression'. */
	private void exitAction() {
	}

	/* The reactions of state A. */
	private void reactMain_region_A() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		nextStateIndex = 0;
		stateVector[0] = State.main_region_B;
	}

	/* The reactions of state B. */
	private void reactMain_region_B() {
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_A :
					reactMain_region_A();
					break;
				case main_region_B :
					reactMain_region_B();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
