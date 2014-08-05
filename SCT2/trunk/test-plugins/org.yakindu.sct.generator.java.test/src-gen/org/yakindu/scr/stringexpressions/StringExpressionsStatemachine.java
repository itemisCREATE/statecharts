package org.yakindu.scr.stringexpressions;

public class StringExpressionsStatemachine
		implements
			IStringExpressionsStatemachine {

	private final class SCInterfaceImpl implements SCInterface {

		private boolean e;

		public void raiseE() {
			e = true;
		}

		private String stringA;

		public String getStringA() {
			return stringA;
		}

		public void setStringA(String value) {
			this.stringA = value;
		}

		private String stringA2;

		public String getStringA2() {
			return stringA2;
		}

		public void setStringA2(String value) {
			this.stringA2 = value;
		}

		private String stringB;

		public String getStringB() {
			return stringB;
		}

		public void setStringB(String value) {
			this.stringB = value;
		}

		private String quotedStringX;

		public String getQuotedStringX() {
			return quotedStringX;
		}

		public void setQuotedStringX(String value) {
			this.quotedStringX = value;
		}

		private String quotedStringY;

		public String getQuotedStringY() {
			return quotedStringY;
		}

		public void setQuotedStringY(String value) {
			this.quotedStringY = value;
		}

		private boolean stringVarEqual;

		public boolean getStringVarEqual() {
			return stringVarEqual;
		}

		public void setStringVarEqual(boolean value) {
			this.stringVarEqual = value;
		}

		private boolean stringVarNotEqual;

		public boolean getStringVarNotEqual() {
			return stringVarNotEqual;
		}

		public void setStringVarNotEqual(boolean value) {
			this.stringVarNotEqual = value;
		}

		private boolean guardStringNotEqual;

		public boolean getGuardStringNotEqual() {
			return guardStringNotEqual;
		}

		public void setGuardStringNotEqual(boolean value) {
			this.guardStringNotEqual = value;
		}

		private boolean guardStringEqual;

		public boolean getGuardStringEqual() {
			return guardStringEqual;
		}

		public void setGuardStringEqual(boolean value) {
			this.guardStringEqual = value;
		}

		public void clearEvents() {
			e = false;
		}

	}

	private SCInterfaceImpl sCInterface;

	public enum State {
		main_region_AssignmentChecked, main_region_Failed, main_region_VarToVarCompareSucceeded, main_region_VarToConstCompareSucceeded, main_region_ConstToVarCompareSucceeded, main_region_ConstToConstCompareSucceeded, $NullState$
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

		sCInterface.stringA = "A";

		sCInterface.stringA2 = "A";

		sCInterface.stringB = "B";

		sCInterface.quotedStringX = "\"X\"";

		sCInterface.quotedStringY = "\"Y\"";

		sCInterface.stringVarEqual = false;

		sCInterface.stringVarNotEqual = false;

		sCInterface.guardStringNotEqual = false;

		sCInterface.guardStringEqual = false;
	}

	public void enter() {
		entryAction();

		sCInterface.stringVarNotEqual = !(sCInterface.stringA == null
				? sCInterface.stringB == null
				: sCInterface.stringA.equals(sCInterface.stringB));

		sCInterface.stringVarEqual = !(sCInterface.stringA == null
				? sCInterface.stringA2 != null
				: !sCInterface.stringA.equals(sCInterface.stringA2));

		nextStateIndex = 0;
		stateVector[0] = State.main_region_AssignmentChecked;
	}

	public void exit() {
		switch (stateVector[0]) {
			case main_region_AssignmentChecked :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_Failed :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_VarToVarCompareSucceeded :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_VarToConstCompareSucceeded :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_ConstToVarCompareSucceeded :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_ConstToConstCompareSucceeded :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			default :
				break;
		}

		exitAction();
	}

	/**
	 * This method resets the incoming events (time events included).
	 */
	protected void clearEvents() {
		sCInterface.clearEvents();

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
			case main_region_AssignmentChecked :
				return stateVector[0] == State.main_region_AssignmentChecked;
			case main_region_Failed :
				return stateVector[0] == State.main_region_Failed;
			case main_region_VarToVarCompareSucceeded :
				return stateVector[0] == State.main_region_VarToVarCompareSucceeded;
			case main_region_VarToConstCompareSucceeded :
				return stateVector[0] == State.main_region_VarToConstCompareSucceeded;
			case main_region_ConstToVarCompareSucceeded :
				return stateVector[0] == State.main_region_ConstToVarCompareSucceeded;
			case main_region_ConstToConstCompareSucceeded :
				return stateVector[0] == State.main_region_ConstToConstCompareSucceeded;
			default :
				return false;
		}
	}

	public SCInterface getSCInterface() {
		return sCInterface;
	}

	public void raiseE() {
		sCInterface.raiseE();
	}

	public String getStringA() {
		return sCInterface.getStringA();
	}

	public void setStringA(String value) {
		sCInterface.setStringA(value);
	}
	public String getStringA2() {
		return sCInterface.getStringA2();
	}

	public void setStringA2(String value) {
		sCInterface.setStringA2(value);
	}
	public String getStringB() {
		return sCInterface.getStringB();
	}

	public void setStringB(String value) {
		sCInterface.setStringB(value);
	}
	public String getQuotedStringX() {
		return sCInterface.getQuotedStringX();
	}

	public void setQuotedStringX(String value) {
		sCInterface.setQuotedStringX(value);
	}
	public String getQuotedStringY() {
		return sCInterface.getQuotedStringY();
	}

	public void setQuotedStringY(String value) {
		sCInterface.setQuotedStringY(value);
	}
	public boolean getStringVarEqual() {
		return sCInterface.getStringVarEqual();
	}

	public void setStringVarEqual(boolean value) {
		sCInterface.setStringVarEqual(value);
	}
	public boolean getStringVarNotEqual() {
		return sCInterface.getStringVarNotEqual();
	}

	public void setStringVarNotEqual(boolean value) {
		sCInterface.setStringVarNotEqual(value);
	}
	public boolean getGuardStringNotEqual() {
		return sCInterface.getGuardStringNotEqual();
	}

	public void setGuardStringNotEqual(boolean value) {
		sCInterface.setGuardStringNotEqual(value);
	}
	public boolean getGuardStringEqual() {
		return sCInterface.getGuardStringEqual();
	}

	public void setGuardStringEqual(boolean value) {
		sCInterface.setGuardStringEqual(value);
	}

	/* Entry action for statechart 'StringExpressions'. */
	private void entryAction() {
	}

	/* Exit action for state 'StringExpressions'. */
	private void exitAction() {
	}

	/* The reactions of state AssignmentChecked. */
	private void reactMain_region_AssignmentChecked() {
		if (sCInterface.e) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			sCInterface.stringVarEqual = (sCInterface.stringA == null
					? sCInterface.stringA2 == null
					: sCInterface.stringA.equals(sCInterface.stringA2));

			if (sCInterface.e) {
				sCInterface.stringVarNotEqual = (sCInterface.stringA == null
						? sCInterface.stringB != null
						: !sCInterface.stringA.equals(sCInterface.stringB));

				if (sCInterface.e
						&& (sCInterface.stringA == null
								? sCInterface.stringA2 == null
								: sCInterface.stringA
										.equals(sCInterface.stringA2))) {
					sCInterface.guardStringEqual = (sCInterface.stringA == null
							? sCInterface.stringA2 == null
							: sCInterface.stringA.equals(sCInterface.stringA2));

					if (sCInterface.e
							&& (sCInterface.stringA == null
									? sCInterface.stringB != null
									: !sCInterface.stringA
											.equals(sCInterface.stringB))) {
						sCInterface.guardStringNotEqual = (sCInterface.stringA == null
								? sCInterface.stringB != null
								: !sCInterface.stringA
										.equals(sCInterface.stringB));

						nextStateIndex = 0;
						stateVector[0] = State.main_region_VarToVarCompareSucceeded;
					} else {
						nextStateIndex = 0;
						stateVector[0] = State.main_region_Failed;
					}
				} else {
					nextStateIndex = 0;
					stateVector[0] = State.main_region_Failed;
				}
			} else {
				nextStateIndex = 0;
				stateVector[0] = State.main_region_Failed;
			}
		}
	}

	/* The reactions of state Failed. */
	private void reactMain_region_Failed() {
	}

	/* The reactions of state VarToVarCompareSucceeded. */
	private void reactMain_region_VarToVarCompareSucceeded() {
		if (sCInterface.e) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			sCInterface.stringVarEqual = (sCInterface.stringA == null
					? "A" == null
					: sCInterface.stringA.equals("A"));

			if (sCInterface.e) {
				sCInterface.stringVarNotEqual = (sCInterface.stringA == null
						? "B" != null
						: !sCInterface.stringA.equals("B"));

				if (sCInterface.e
						&& (sCInterface.stringA == null
								? "A" == null
								: sCInterface.stringA.equals("A"))) {
					sCInterface.guardStringEqual = (sCInterface.stringA == null
							? "A" == null
							: sCInterface.stringA.equals("A"));

					if (sCInterface.e
							&& (sCInterface.stringA == null
									? "B" != null
									: !sCInterface.stringA.equals("B"))) {
						sCInterface.guardStringNotEqual = (sCInterface.stringA == null
								? "B" != null
								: !sCInterface.stringA.equals("B"));

						nextStateIndex = 0;
						stateVector[0] = State.main_region_VarToConstCompareSucceeded;
					} else {
						nextStateIndex = 0;
						stateVector[0] = State.main_region_Failed;
					}
				} else {
					nextStateIndex = 0;
					stateVector[0] = State.main_region_Failed;
				}
			} else {
				nextStateIndex = 0;
				stateVector[0] = State.main_region_Failed;
			}
		}
	}

	/* The reactions of state VarToConstCompareSucceeded. */
	private void reactMain_region_VarToConstCompareSucceeded() {
		if (sCInterface.e) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			sCInterface.stringVarEqual = ("A" == null
					? sCInterface.stringA == null
					: "A".equals(sCInterface.stringA));

			if (sCInterface.e) {
				sCInterface.stringVarNotEqual = ("A" == null
						? sCInterface.stringB != null
						: !"A".equals(sCInterface.stringB));

				if (sCInterface.e
						&& ("A" == null ? sCInterface.stringA == null : "A"
								.equals(sCInterface.stringA))) {
					sCInterface.guardStringEqual = ("A" == null
							? sCInterface.stringA == null
							: "A".equals(sCInterface.stringA));

					if (sCInterface.e
							&& ("A" == null
									? sCInterface.stringB != null
									: !"A".equals(sCInterface.stringB))) {
						sCInterface.guardStringNotEqual = ("A" == null
								? sCInterface.stringB != null
								: !"A".equals(sCInterface.stringB));

						nextStateIndex = 0;
						stateVector[0] = State.main_region_ConstToVarCompareSucceeded;
					} else {
						nextStateIndex = 0;
						stateVector[0] = State.main_region_Failed;
					}
				} else {
					nextStateIndex = 0;
					stateVector[0] = State.main_region_Failed;
				}
			} else {
				nextStateIndex = 0;
				stateVector[0] = State.main_region_Failed;
			}
		}
	}

	/* The reactions of state ConstToVarCompareSucceeded. */
	private void reactMain_region_ConstToVarCompareSucceeded() {
		if (sCInterface.e) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			sCInterface.stringVarEqual = ("A" == null ? "A" == null : "A"
					.equals("A"));

			if (sCInterface.e) {
				sCInterface.stringVarNotEqual = ("A" == null
						? "B" != null
						: !"A".equals("B"));

				if (sCInterface.e
						&& ("A" == null ? "A" == null : "A".equals("A"))) {
					sCInterface.guardStringEqual = ("A" == null
							? "A" == null
							: "A".equals("A"));

					if (sCInterface.e
							&& ("A" == null ? "B" != null : !"A".equals("B"))) {
						sCInterface.guardStringNotEqual = ("A" == null
								? "B" != null
								: !"A".equals("B"));

						nextStateIndex = 0;
						stateVector[0] = State.main_region_ConstToConstCompareSucceeded;
					} else {
						nextStateIndex = 0;
						stateVector[0] = State.main_region_Failed;
					}
				} else {
					nextStateIndex = 0;
					stateVector[0] = State.main_region_Failed;
				}
			} else {
				nextStateIndex = 0;
				stateVector[0] = State.main_region_Failed;
			}
		}
	}

	/* The reactions of state ConstToConstCompareSucceeded. */
	private void reactMain_region_ConstToConstCompareSucceeded() {
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_AssignmentChecked :
					reactMain_region_AssignmentChecked();
					break;
				case main_region_Failed :
					reactMain_region_Failed();
					break;
				case main_region_VarToVarCompareSucceeded :
					reactMain_region_VarToVarCompareSucceeded();
					break;
				case main_region_VarToConstCompareSucceeded :
					reactMain_region_VarToConstCompareSucceeded();
					break;
				case main_region_ConstToVarCompareSucceeded :
					reactMain_region_ConstToVarCompareSucceeded();
					break;
				case main_region_ConstToConstCompareSucceeded :
					reactMain_region_ConstToConstCompareSucceeded();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
