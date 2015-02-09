package org.yakindu.scr.stringexpressions;

public class StringExpressionsStatemachine
		implements
			IStringExpressionsStatemachine {

	static {
	}

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

		enterSequenceMain_region();
	}

	public void exit() {
		exitSequenceMain_region();

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

	private boolean checkMain_region_AssignmentCheckedTr0() {
		return sCInterface.e;
	}

	private boolean checkMain_region_VarToVarCompareSucceededTr0() {
		return sCInterface.e;
	}

	private boolean checkMain_region_VarToConstCompareSucceededTr0() {
		return sCInterface.e;
	}

	private boolean checkMain_region_ConstToVarCompareSucceededTr0() {
		return sCInterface.e;
	}

	private boolean checkStringExpressions_main_region__choice_0Tr1() {
		return sCInterface.e;
	}

	private boolean checkStringExpressions_main_region__choice_0Tr0() {
		return true;
	}

	private boolean checkStringExpressions_main_region__choice_1Tr1() {
		return (sCInterface.e)
				&& (sCInterface.stringA == null
						? sCInterface.stringA2 == null
						: sCInterface.stringA.equals(sCInterface.stringA2));
	}

	private boolean checkStringExpressions_main_region__choice_1Tr0() {
		return true;
	}

	private boolean checkStringExpressions_main_region__choice_2Tr1() {
		return (sCInterface.e)
				&& (sCInterface.stringA == null
						? sCInterface.stringB != null
						: !sCInterface.stringA.equals(sCInterface.stringB));
	}

	private boolean checkStringExpressions_main_region__choice_2Tr0() {
		return true;
	}

	private boolean checkStringExpressions_main_region__choice_3Tr0() {
		return sCInterface.e;
	}

	private boolean checkStringExpressions_main_region__choice_3Tr1() {
		return true;
	}

	private boolean checkStringExpressions_main_region__choice_4Tr1() {
		return (sCInterface.e)
				&& (sCInterface.stringA == null
						? "A" == null
						: sCInterface.stringA.equals("A"));
	}

	private boolean checkStringExpressions_main_region__choice_4Tr0() {
		return true;
	}

	private boolean checkStringExpressions_main_region__choice_5Tr1() {
		return (sCInterface.e)
				&& (sCInterface.stringA == null
						? "B" != null
						: !sCInterface.stringA.equals("B"));
	}

	private boolean checkStringExpressions_main_region__choice_5Tr0() {
		return true;
	}

	private boolean checkStringExpressions_main_region__choice_6Tr0() {
		return true;
	}

	private boolean checkStringExpressions_main_region__choice_7Tr0() {
		return sCInterface.e;
	}

	private boolean checkStringExpressions_main_region__choice_7Tr1() {
		return true;
	}

	private boolean checkStringExpressions_main_region__choice_8Tr1() {
		return (sCInterface.e)
				&& ("A" == null ? sCInterface.stringA == null : "A"
						.equals(sCInterface.stringA));
	}

	private boolean checkStringExpressions_main_region__choice_8Tr0() {
		return true;
	}

	private boolean checkStringExpressions_main_region__choice_9Tr1() {
		return (sCInterface.e)
				&& ("A" == null ? sCInterface.stringB != null : !"A"
						.equals(sCInterface.stringB));
	}

	private boolean checkStringExpressions_main_region__choice_9Tr0() {
		return true;
	}

	private boolean checkStringExpressions_main_region__choice_10Tr0() {
		return true;
	}

	private boolean checkStringExpressions_main_region__choice_11Tr0() {
		return sCInterface.e;
	}

	private boolean checkStringExpressions_main_region__choice_11Tr1() {
		return true;
	}

	private boolean checkStringExpressions_main_region__choice_12Tr1() {
		return (sCInterface.e) && ("A" == null ? "A" == null : "A".equals("A"));
	}

	private boolean checkStringExpressions_main_region__choice_12Tr0() {
		return true;
	}

	private boolean checkStringExpressions_main_region__choice_13Tr1() {
		return (sCInterface.e)
				&& ("A" == null ? "B" != null : !"A".equals("B"));
	}

	private boolean checkStringExpressions_main_region__choice_13Tr0() {
		return true;
	}

	private boolean checkStringExpressions_main_region__choice_14Tr0() {
		return true;
	}

	private void effectMain_region_AssignmentCheckedTr0() {
		exitSequenceMain_region_AssignmentChecked();

		sCInterface.stringVarEqual = (sCInterface.stringA == null
				? sCInterface.stringA2 == null
				: sCInterface.stringA.equals(sCInterface.stringA2));

		reactStringExpressions_main_region__choice_0();
	}

	private void effectMain_region_VarToVarCompareSucceededTr0() {
		exitSequenceMain_region_VarToVarCompareSucceeded();

		sCInterface.stringVarEqual = (sCInterface.stringA == null
				? "A" == null
				: sCInterface.stringA.equals("A"));

		reactStringExpressions_main_region__choice_3();
	}

	private void effectMain_region_VarToConstCompareSucceededTr0() {
		exitSequenceMain_region_VarToConstCompareSucceeded();

		sCInterface.stringVarEqual = ("A" == null
				? sCInterface.stringA == null
				: "A".equals(sCInterface.stringA));

		reactStringExpressions_main_region__choice_7();
	}

	private void effectMain_region_ConstToVarCompareSucceededTr0() {
		exitSequenceMain_region_ConstToVarCompareSucceeded();

		sCInterface.stringVarEqual = ("A" == null ? "A" == null : "A"
				.equals("A"));

		reactStringExpressions_main_region__choice_11();
	}

	private void effectStringExpressions_main_region__choice_0Tr1() {
		sCInterface.stringVarNotEqual = (sCInterface.stringA == null
				? sCInterface.stringB != null
				: !sCInterface.stringA.equals(sCInterface.stringB));

		reactStringExpressions_main_region__choice_1();
	}

	private void effectStringExpressions_main_region__choice_0Tr0() {
		enterSequenceMain_region_Failed();
	}

	private void effectStringExpressions_main_region__choice_1Tr1() {
		sCInterface.guardStringEqual = (sCInterface.stringA == null
				? sCInterface.stringA2 == null
				: sCInterface.stringA.equals(sCInterface.stringA2));

		reactStringExpressions_main_region__choice_2();
	}

	private void effectStringExpressions_main_region__choice_1Tr0() {
		enterSequenceMain_region_Failed();
	}

	private void effectStringExpressions_main_region__choice_2Tr1() {
		sCInterface.guardStringNotEqual = (sCInterface.stringA == null
				? sCInterface.stringB != null
				: !sCInterface.stringA.equals(sCInterface.stringB));

		enterSequenceMain_region_VarToVarCompareSucceeded();
	}

	private void effectStringExpressions_main_region__choice_2Tr0() {
		enterSequenceMain_region_Failed();
	}

	private void effectStringExpressions_main_region__choice_3Tr0() {
		sCInterface.stringVarNotEqual = (sCInterface.stringA == null
				? "B" != null
				: !sCInterface.stringA.equals("B"));

		reactStringExpressions_main_region__choice_4();
	}

	private void effectStringExpressions_main_region__choice_3Tr1() {
		reactStringExpressions_main_region__choice_6();
	}

	private void effectStringExpressions_main_region__choice_4Tr1() {
		sCInterface.guardStringEqual = (sCInterface.stringA == null
				? "A" == null
				: sCInterface.stringA.equals("A"));

		reactStringExpressions_main_region__choice_5();
	}

	private void effectStringExpressions_main_region__choice_4Tr0() {
		reactStringExpressions_main_region__choice_6();
	}

	private void effectStringExpressions_main_region__choice_5Tr1() {
		sCInterface.guardStringNotEqual = (sCInterface.stringA == null
				? "B" != null
				: !sCInterface.stringA.equals("B"));

		enterSequenceMain_region_VarToConstCompareSucceeded();
	}

	private void effectStringExpressions_main_region__choice_5Tr0() {
		reactStringExpressions_main_region__choice_6();
	}

	private void effectStringExpressions_main_region__choice_6Tr0() {
		enterSequenceMain_region_Failed();
	}

	private void effectStringExpressions_main_region__choice_7Tr0() {
		sCInterface.stringVarNotEqual = ("A" == null
				? sCInterface.stringB != null
				: !"A".equals(sCInterface.stringB));

		reactStringExpressions_main_region__choice_8();
	}

	private void effectStringExpressions_main_region__choice_7Tr1() {
		reactStringExpressions_main_region__choice_10();
	}

	private void effectStringExpressions_main_region__choice_8Tr1() {
		sCInterface.guardStringEqual = ("A" == null
				? sCInterface.stringA == null
				: "A".equals(sCInterface.stringA));

		reactStringExpressions_main_region__choice_9();
	}

	private void effectStringExpressions_main_region__choice_8Tr0() {
		reactStringExpressions_main_region__choice_10();
	}

	private void effectStringExpressions_main_region__choice_9Tr1() {
		sCInterface.guardStringNotEqual = ("A" == null
				? sCInterface.stringB != null
				: !"A".equals(sCInterface.stringB));

		enterSequenceMain_region_ConstToVarCompareSucceeded();
	}

	private void effectStringExpressions_main_region__choice_9Tr0() {
		reactStringExpressions_main_region__choice_10();
	}

	private void effectStringExpressions_main_region__choice_10Tr0() {
		reactStringExpressions_main_region__choice_6();
	}

	private void effectStringExpressions_main_region__choice_11Tr0() {
		sCInterface.stringVarNotEqual = ("A" == null ? "B" != null : !"A"
				.equals("B"));

		reactStringExpressions_main_region__choice_12();
	}

	private void effectStringExpressions_main_region__choice_11Tr1() {
		reactStringExpressions_main_region__choice_14();
	}

	private void effectStringExpressions_main_region__choice_12Tr1() {
		sCInterface.guardStringEqual = ("A" == null ? "A" == null : "A"
				.equals("A"));

		reactStringExpressions_main_region__choice_13();
	}

	private void effectStringExpressions_main_region__choice_12Tr0() {
		reactStringExpressions_main_region__choice_14();
	}

	private void effectStringExpressions_main_region__choice_13Tr1() {
		sCInterface.guardStringNotEqual = ("A" == null ? "B" != null : !"A"
				.equals("B"));

		enterSequenceMain_region_ConstToConstCompareSucceeded();
	}

	private void effectStringExpressions_main_region__choice_13Tr0() {
		reactStringExpressions_main_region__choice_14();
	}

	private void effectStringExpressions_main_region__choice_14Tr0() {
		reactStringExpressions_main_region__choice_10();
	}

	/* Entry action for statechart 'StringExpressions'. */
	private void entryAction() {
	}

	/* Entry action for state 'AssignmentChecked'. */
	private void entryActionMain_region_AssignmentChecked() {
		sCInterface.stringVarNotEqual = !(sCInterface.stringA == null
				? sCInterface.stringB == null
				: sCInterface.stringA.equals(sCInterface.stringB));

		sCInterface.stringVarEqual = !(sCInterface.stringA == null
				? sCInterface.stringA2 != null
				: !sCInterface.stringA.equals(sCInterface.stringA2));
	}

	/* Exit action for state 'StringExpressions'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state AssignmentChecked */
	private void enterSequenceMain_region_AssignmentChecked() {
		entryActionMain_region_AssignmentChecked();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_AssignmentChecked;
	}

	/* 'default' enter sequence for state Failed */
	private void enterSequenceMain_region_Failed() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Failed;
	}

	/* 'default' enter sequence for state VarToVarCompareSucceeded */
	private void enterSequenceMain_region_VarToVarCompareSucceeded() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_VarToVarCompareSucceeded;
	}

	/* 'default' enter sequence for state VarToConstCompareSucceeded */
	private void enterSequenceMain_region_VarToConstCompareSucceeded() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_VarToConstCompareSucceeded;
	}

	/* 'default' enter sequence for state ConstToVarCompareSucceeded */
	private void enterSequenceMain_region_ConstToVarCompareSucceeded() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_ConstToVarCompareSucceeded;
	}

	/* 'default' enter sequence for state ConstToConstCompareSucceeded */
	private void enterSequenceMain_region_ConstToConstCompareSucceeded() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_ConstToConstCompareSucceeded;
	}

	/* 'default' enter sequence for region main region */
	private void enterSequenceMain_region() {
		reactStringExpressions_main_region__entry_Default();
	}

	/* Default exit sequence for state AssignmentChecked */
	private void exitSequenceMain_region_AssignmentChecked() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Failed */
	private void exitSequenceMain_region_Failed() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state VarToVarCompareSucceeded */
	private void exitSequenceMain_region_VarToVarCompareSucceeded() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state VarToConstCompareSucceeded */
	private void exitSequenceMain_region_VarToConstCompareSucceeded() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state ConstToVarCompareSucceeded */
	private void exitSequenceMain_region_ConstToVarCompareSucceeded() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state ConstToConstCompareSucceeded */
	private void exitSequenceMain_region_ConstToConstCompareSucceeded() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for region main region */
	private void exitSequenceMain_region() {
		switch (stateVector[0]) {
			case main_region_AssignmentChecked :
				exitSequenceMain_region_AssignmentChecked();
				break;

			case main_region_Failed :
				exitSequenceMain_region_Failed();
				break;

			case main_region_VarToVarCompareSucceeded :
				exitSequenceMain_region_VarToVarCompareSucceeded();
				break;

			case main_region_VarToConstCompareSucceeded :
				exitSequenceMain_region_VarToConstCompareSucceeded();
				break;

			case main_region_ConstToVarCompareSucceeded :
				exitSequenceMain_region_ConstToVarCompareSucceeded();
				break;

			case main_region_ConstToConstCompareSucceeded :
				exitSequenceMain_region_ConstToConstCompareSucceeded();
				break;

			default :
				break;
		}
	}

	/* The reactions of state AssignmentChecked. */
	private void reactMain_region_AssignmentChecked() {
		if (checkMain_region_AssignmentCheckedTr0()) {
			effectMain_region_AssignmentCheckedTr0();
		}
	}

	/* The reactions of state Failed. */
	private void reactMain_region_Failed() {
	}

	/* The reactions of state VarToVarCompareSucceeded. */
	private void reactMain_region_VarToVarCompareSucceeded() {
		if (checkMain_region_VarToVarCompareSucceededTr0()) {
			effectMain_region_VarToVarCompareSucceededTr0();
		}
	}

	/* The reactions of state VarToConstCompareSucceeded. */
	private void reactMain_region_VarToConstCompareSucceeded() {
		if (checkMain_region_VarToConstCompareSucceededTr0()) {
			effectMain_region_VarToConstCompareSucceededTr0();
		}
	}

	/* The reactions of state ConstToVarCompareSucceeded. */
	private void reactMain_region_ConstToVarCompareSucceeded() {
		if (checkMain_region_ConstToVarCompareSucceededTr0()) {
			effectMain_region_ConstToVarCompareSucceededTr0();
		}
	}

	/* The reactions of state ConstToConstCompareSucceeded. */
	private void reactMain_region_ConstToConstCompareSucceeded() {
	}

	/* The reactions of state null. */
	private void reactStringExpressions_main_region__choice_0() {
		if (checkStringExpressions_main_region__choice_0Tr1()) {
			effectStringExpressions_main_region__choice_0Tr1();
		} else {
			effectStringExpressions_main_region__choice_0Tr0();
		}
	}

	/* The reactions of state null. */
	private void reactStringExpressions_main_region__choice_1() {
		if (checkStringExpressions_main_region__choice_1Tr1()) {
			effectStringExpressions_main_region__choice_1Tr1();
		} else {
			effectStringExpressions_main_region__choice_1Tr0();
		}
	}

	/* The reactions of state null. */
	private void reactStringExpressions_main_region__choice_2() {
		if (checkStringExpressions_main_region__choice_2Tr1()) {
			effectStringExpressions_main_region__choice_2Tr1();
		} else {
			effectStringExpressions_main_region__choice_2Tr0();
		}
	}

	/* The reactions of state null. */
	private void reactStringExpressions_main_region__choice_3() {
		if (checkStringExpressions_main_region__choice_3Tr0()) {
			effectStringExpressions_main_region__choice_3Tr0();
		} else {
			effectStringExpressions_main_region__choice_3Tr1();
		}
	}

	/* The reactions of state null. */
	private void reactStringExpressions_main_region__choice_4() {
		if (checkStringExpressions_main_region__choice_4Tr1()) {
			effectStringExpressions_main_region__choice_4Tr1();
		} else {
			effectStringExpressions_main_region__choice_4Tr0();
		}
	}

	/* The reactions of state null. */
	private void reactStringExpressions_main_region__choice_5() {
		if (checkStringExpressions_main_region__choice_5Tr1()) {
			effectStringExpressions_main_region__choice_5Tr1();
		} else {
			effectStringExpressions_main_region__choice_5Tr0();
		}
	}

	/* The reactions of state null. */
	private void reactStringExpressions_main_region__choice_6() {
		effectStringExpressions_main_region__choice_6Tr0();
	}

	/* The reactions of state null. */
	private void reactStringExpressions_main_region__choice_7() {
		if (checkStringExpressions_main_region__choice_7Tr0()) {
			effectStringExpressions_main_region__choice_7Tr0();
		} else {
			effectStringExpressions_main_region__choice_7Tr1();
		}
	}

	/* The reactions of state null. */
	private void reactStringExpressions_main_region__choice_8() {
		if (checkStringExpressions_main_region__choice_8Tr1()) {
			effectStringExpressions_main_region__choice_8Tr1();
		} else {
			effectStringExpressions_main_region__choice_8Tr0();
		}
	}

	/* The reactions of state null. */
	private void reactStringExpressions_main_region__choice_9() {
		if (checkStringExpressions_main_region__choice_9Tr1()) {
			effectStringExpressions_main_region__choice_9Tr1();
		} else {
			effectStringExpressions_main_region__choice_9Tr0();
		}
	}

	/* The reactions of state null. */
	private void reactStringExpressions_main_region__choice_10() {
		effectStringExpressions_main_region__choice_10Tr0();
	}

	/* The reactions of state null. */
	private void reactStringExpressions_main_region__choice_11() {
		if (checkStringExpressions_main_region__choice_11Tr0()) {
			effectStringExpressions_main_region__choice_11Tr0();
		} else {
			effectStringExpressions_main_region__choice_11Tr1();
		}
	}

	/* The reactions of state null. */
	private void reactStringExpressions_main_region__choice_12() {
		if (checkStringExpressions_main_region__choice_12Tr1()) {
			effectStringExpressions_main_region__choice_12Tr1();
		} else {
			effectStringExpressions_main_region__choice_12Tr0();
		}
	}

	/* The reactions of state null. */
	private void reactStringExpressions_main_region__choice_13() {
		if (checkStringExpressions_main_region__choice_13Tr1()) {
			effectStringExpressions_main_region__choice_13Tr1();
		} else {
			effectStringExpressions_main_region__choice_13Tr0();
		}
	}

	/* The reactions of state null. */
	private void reactStringExpressions_main_region__choice_14() {
		effectStringExpressions_main_region__choice_14Tr0();
	}

	/* Default react sequence for initial entry  */
	private void reactStringExpressions_main_region__entry_Default() {
		enterSequenceMain_region_AssignmentChecked();
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
