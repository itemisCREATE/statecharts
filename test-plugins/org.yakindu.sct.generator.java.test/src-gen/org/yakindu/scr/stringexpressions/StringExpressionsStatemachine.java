package org.yakindu.scr.stringexpressions;

public class StringExpressionsStatemachine
		implements
			IStringExpressionsStatemachine {

	private final class SCIDefaultImpl implements SCIDefault {

		private boolean e1;

		public void raiseE1() {
			e1 = true;
		}

		private String myString;

		public String getMyString() {
			return myString;
		}

		public void setMyString(String value) {
			this.myString = value;
		}

		private String myString2;

		public String getMyString2() {
			return myString2;
		}

		public void setMyString2(String value) {
			this.myString2 = value;
		}

		private boolean equals;

		public boolean getEquals() {
			return equals;
		}

		public void setEquals(boolean value) {
			this.equals = value;
		}

		private boolean notEqual;

		public boolean getNotEqual() {
			return notEqual;
		}

		public void setNotEqual(boolean value) {
			this.notEqual = value;
		}

		public void clearEvents() {
			e1 = false;
		}

	}

	private SCIDefaultImpl sCIDefault;

	public enum State {
		main_region_StateA, main_region_StateB, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public StringExpressionsStatemachine() {

		sCIDefault = new SCIDefaultImpl();

	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCIDefault.myString = "";

		sCIDefault.myString2 = "";

		sCIDefault.equals = false;

		sCIDefault.notEqual = false;
	}

	public void enter() {
		entryAction();

		sCIDefault.myString = "hello";

		sCIDefault.myString2 = "world";

		nextStateIndex = 0;
		stateVector[0] = State.main_region_StateA;
	}

	public void exit() {
		switch (stateVector[0]) {
			case main_region_StateA :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_StateB :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
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
			case main_region_StateA :
				return stateVector[0] == State.main_region_StateA;
			case main_region_StateB :
				return stateVector[0] == State.main_region_StateB;
			default :
				return false;
		}
	}

	public SCIDefault getSCIDefault() {
		return sCIDefault;
	}

	public void raiseE1() {
		sCIDefault.raiseE1();
	}

	public String getMyString() {
		return sCIDefault.getMyString();
	}

	public void setMyString(String value) {
		sCIDefault.setMyString(value);
	}
	public String getMyString2() {
		return sCIDefault.getMyString2();
	}

	public void setMyString2(String value) {
		sCIDefault.setMyString2(value);
	}
	public boolean getEquals() {
		return sCIDefault.getEquals();
	}

	public void setEquals(boolean value) {
		sCIDefault.setEquals(value);
	}
	public boolean getNotEqual() {
		return sCIDefault.getNotEqual();
	}

	public void setNotEqual(boolean value) {
		sCIDefault.setNotEqual(value);
	}

	/* Entry action for statechart 'StringExpressions'. */
	private void entryAction() {
	}

	/* Exit action for state 'StringExpressions'. */
	private void exitAction() {
	}

	/* The reactions of state StateA. */
	private void reactMain_region_StateA() {
		if (sCIDefault.e1) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			sCIDefault.equals = (sCIDefault.myString == null
					? sCIDefault.myString2 == null
					: sCIDefault.myString.equals(sCIDefault.myString2));

			sCIDefault.notEqual = (sCIDefault.myString == null
					? sCIDefault.myString2 == null
					: !sCIDefault.myString.equals(sCIDefault.myString2));

			nextStateIndex = 0;
			stateVector[0] = State.main_region_StateB;
		}
	}

	/* The reactions of state StateB. */
	private void reactMain_region_StateB() {
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_StateA :
					reactMain_region_StateA();
					break;
				case main_region_StateB :
					reactMain_region_StateB();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
