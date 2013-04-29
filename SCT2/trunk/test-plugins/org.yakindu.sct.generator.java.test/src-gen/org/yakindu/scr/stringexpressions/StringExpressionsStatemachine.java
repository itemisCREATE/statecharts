package org.yakindu.scr.stringexpressions;

public class StringExpressionsStatemachine
		implements
			IStringExpressionsStatemachine {

	private final class SCInterfaceImpl implements SCInterface {

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

		private String quotedString;

		public String getQuotedString() {
			return quotedString;
		}

		public void setQuotedString(String value) {
			this.quotedString = value;
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

	private SCInterfaceImpl sCInterface;

	public enum State {
		main_region_StateA, main_region_StateB, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public StringExpressionsStatemachine() {

		sCInterface = new SCInterfaceImpl();

	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCInterface.myString = "";

		sCInterface.myString2 = "";

		sCInterface.quotedString = "\"x\"";

		sCInterface.equals = false;

		sCInterface.notEqual = false;
	}

	public void enter() {
		entryAction();

		sCInterface.myString = "hello";

		sCInterface.myString2 = "world";

		sCInterface.quotedString = "'y'";

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
		sCInterface.clearEvents();

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

	public SCInterface getSCInterface() {
		return sCInterface;
	}

	public void raiseE1() {
		sCInterface.raiseE1();
	}

	public String getMyString() {
		return sCInterface.getMyString();
	}

	public void setMyString(String value) {
		sCInterface.setMyString(value);
	}
	public String getMyString2() {
		return sCInterface.getMyString2();
	}

	public void setMyString2(String value) {
		sCInterface.setMyString2(value);
	}
	public String getQuotedString() {
		return sCInterface.getQuotedString();
	}

	public void setQuotedString(String value) {
		sCInterface.setQuotedString(value);
	}
	public boolean getEquals() {
		return sCInterface.getEquals();
	}

	public void setEquals(boolean value) {
		sCInterface.setEquals(value);
	}
	public boolean getNotEqual() {
		return sCInterface.getNotEqual();
	}

	public void setNotEqual(boolean value) {
		sCInterface.setNotEqual(value);
	}

	/* Entry action for statechart 'StringExpressions'. */
	private void entryAction() {
	}

	/* Exit action for state 'StringExpressions'. */
	private void exitAction() {
	}

	/* The reactions of state StateA. */
	private void reactMain_region_StateA() {
		if (sCInterface.e1) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			sCInterface.equals = (sCInterface.myString == null
					? sCInterface.myString2 == null
					: sCInterface.myString.equals(sCInterface.myString2));

			sCInterface.notEqual = (sCInterface.myString == null
					? sCInterface.myString2 == null
					: !sCInterface.myString.equals(sCInterface.myString2));

			sCInterface.quotedString = "\"z\"";

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
