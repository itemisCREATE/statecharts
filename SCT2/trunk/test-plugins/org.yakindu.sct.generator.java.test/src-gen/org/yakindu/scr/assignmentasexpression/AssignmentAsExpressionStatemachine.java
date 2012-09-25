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
		Main_region_A, $NullState$
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

	protected void clearEvents() {

	}

	protected void clearOutEvents() {
	}

	public boolean isStateActive(State state) {
		switch (state) {

			case Main_region_A :
				return stateVector[0] == State.Main_region_A;

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

	public void enter() {
		sCIDefault.a = 0;

		sCIDefault.b = 0;

		entryActionAssignmentAsExpression();
		sCIDefault.a = ((sCIDefault.b = 5)) + 4;

		nextStateIndex = 0;
		stateVector[0] = State.Main_region_A;

	}

	public void exit() {
		//Handle exit of all possible states (of main region) at position 0...
		switch (stateVector[0]) {

			case Main_region_A :
				stateVector[0] = State.$NullState$;

				break;

			default :
				break;
		}

		exitActionAssignmentAsExpression();
	}

	private void entryActionAssignmentAsExpression() {

	}

	private void exitActionAssignmentAsExpression() {

	}

	private void reactMain_region_A() {

	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case Main_region_A :
					reactMain_region_A();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
