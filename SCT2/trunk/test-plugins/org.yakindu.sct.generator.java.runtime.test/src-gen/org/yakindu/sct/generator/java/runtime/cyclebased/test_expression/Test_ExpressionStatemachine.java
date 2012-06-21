package org.yakindu.sct.generator.java.runtime.cyclebased.test_expression;

import java.util.LinkedList;
import java.util.List;

public class Test_ExpressionStatemachine
		implements
			ITest_ExpressionStatemachine {

	private final class SCIDefaultImpl implements SCIDefault {

		private List<SCIDefaultListener> listeners = new LinkedList<SCIDefaultListener>();

		public List<SCIDefaultListener> getListeners() {
			return listeners;
		}

		private boolean event1;

		private int event1Value;

		public void raiseEvent1(int value) {
			event1 = true;
			event1Value = value;
		}

		private int getEvent1Value() {
			if (!event1)
				throw new IllegalStateException(
						"Illegal event value acces. Event Event1 is not raised!");
			return event1Value;
		}

		private boolean event2;

		private boolean event2Out;

		private double event2Value;

		public boolean isRaisedEvent2() {
			return event2Out;
		}

		private void raiseEvent2(double value) {
			event2Out = true;
			event2 = true;
			event2Value = value;
			for (SCIDefaultListener listener : listeners) {
				listener.onEvent2Raised(value);
			}
		}

		public double getEvent2Value() {
			if (!event2Out)
				throw new IllegalStateException(
						"Illegal event value acces. Event Event2 is not raised!");
			return event2Value;
		}

		private boolean event3;

		public void raiseEvent3() {
			event3 = true;
		}

		private int var1 = 6;

		public int getVar1() {
			return var1;
		}

		public void setVar1(int value) {
			this.var1 = value;
		}

		private int var2 = 123;

		public int getVar2() {
			return var2;
		}

		public void setVar2(int value) {
			this.var2 = value;
		}

		private double var3 = 19.4;

		public double getVar3() {
			return var3;
		}

		public void setVar3(double value) {
			this.var3 = value;
		}

		private double var4 = 43.3;

		public double getVar4() {
			return var4;
		}

		public void setVar4(double value) {
			this.var4 = value;
		}

		private boolean var5 = false;

		public boolean getVar5() {
			return var5;
		}

		public void setVar5(boolean value) {
			this.var5 = value;
		}

		private String var6 = "foo";

		public String getVar6() {
			return var6;
		}

		public void setVar6(String value) {
			this.var6 = value;
		}

		public void clearEvents() {
			event1 = false;
			event2 = false;
			event3 = false;
		}

		public void clearOutEvents() {
			event2Out = false;
		}

	}

	private SCIDefaultImpl sCIDefault;

	private final class SCIOtherImpl implements SCIOther {

		private boolean var1;

		public boolean getVar1() {
			return var1;
		}

		public void setVar1(boolean value) {
			this.var1 = value;
		}

		private double var2;

		public double getVar2() {
			return var2;
		}

		public void setVar2(double value) {
			this.var2 = value;
		}

		private int var3;

		public int getVar3() {
			return var3;
		}

		public void setVar3(int value) {
			this.var3 = value;
		}

	}

	private SCIOtherImpl sCIOther;

	public enum State {
		MainRegion_state1, MainRegion_state2, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public Test_ExpressionStatemachine() {

		sCIDefault = new SCIDefaultImpl();
		sCIOther = new SCIOtherImpl();

	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();
	}

	protected void clearEvents() {
		sCIDefault.clearEvents();

	}

	protected void clearOutEvents() {
		sCIDefault.clearOutEvents();
	}

	public boolean isStateActive(State state) {
		for (int i = 0; i < stateVector.length; i++) {
			if (stateVector[i] == state) {
				return true;
			}
		}
		return false;
	}

	public SCIDefault getSCIDefault() {
		return sCIDefault;
	}
	public SCIOther getSCIOther() {
		return sCIOther;
	}

	public void raiseEvent1(int value) {
		sCIDefault.raiseEvent1(value);
	}

	public boolean isRaisedEvent2() {
		return sCIDefault.isRaisedEvent2();
	}
	public double getEvent2Value() {
		return sCIDefault.getEvent2Value();
	}

	public void raiseEvent3() {
		sCIDefault.raiseEvent3();
	}

	public int getVar1() {
		return sCIDefault.getVar1();
	}

	public void setVar1(int value) {
		sCIDefault.setVar1(value);
	}
	public int getVar2() {
		return sCIDefault.getVar2();
	}

	public void setVar2(int value) {
		sCIDefault.setVar2(value);
	}
	public double getVar3() {
		return sCIDefault.getVar3();
	}

	public void setVar3(double value) {
		sCIDefault.setVar3(value);
	}
	public double getVar4() {
		return sCIDefault.getVar4();
	}

	public void setVar4(double value) {
		sCIDefault.setVar4(value);
	}
	public boolean getVar5() {
		return sCIDefault.getVar5();
	}

	public void setVar5(boolean value) {
		sCIDefault.setVar5(value);
	}
	public String getVar6() {
		return sCIDefault.getVar6();
	}

	public void setVar6(String value) {
		sCIDefault.setVar6(value);
	}

	public void enter() {
		sCIDefault.setVar1(6);
		sCIDefault.setVar2(123);
		sCIDefault.setVar3(19.4);
		sCIDefault.setVar4(43.3);
		sCIDefault.setVar5(false);
		sCIDefault.setVar6("foo");

		// unknown function type org.yakindu.sct.model.sexec.impl.SequenceImpl@36a6b26e (name: entryAction) (comment: Entry action for statechart 'Test_Expression'.)();
		sCIDefault.setVar3(sCIDefault.getVar3()
				+ ((sCIDefault.getVar2() * sCIDefault.getVar3())));

		nextStateIndex = 0;
		stateVector[0] = State.MainRegion_state1;

	}

	public void exit() {
		//Handle exit of all possible states (of mainRegion) at position 0...
		switch (stateVector[0]) {

			case MainRegion_state1 :
				stateVector[0] = State.$NullState$;
				sCIDefault.setVar2(1);

				sCIDefault.setVar4(22.3);

				break;

			case MainRegion_state2 :
				stateVector[0] = State.$NullState$;

				break;

			default :
				break;
		}

		// unknown function type org.yakindu.sct.model.sexec.impl.SequenceImpl@110f1712 (name: exitAction) (comment: Exit action for state 'Test_Expression'.)();
	}

	private void reactMainRegion_state1() {
		if ((sCIDefault.event1 && ((sCIOther.getVar1() == true) || (sCIDefault
				.getVar5() == false)))) {
			stateVector[0] = State.$NullState$;
			sCIDefault.setVar2(1);

			sCIDefault.setVar4(22.3);

			sCIOther.setVar1(false);

			sCIDefault.setVar3(sCIDefault.getVar3() / (5));

			sCIDefault.setVar1(sCIDefault.getVar1() + (1));

			nextStateIndex = 0;
			stateVector[0] = State.MainRegion_state2;

		} else {
			if ((sCIDefault.event1 && (sCIDefault.getVar6() == null
					? "foo" == null
					: sCIDefault.getVar6().equals("foo")))) {
				stateVector[0] = State.$NullState$;
				sCIDefault.setVar2(1);

				sCIDefault.setVar4(22.3);

				sCIDefault.setVar6("bar");

				sCIDefault.setVar3(sCIDefault.getVar3() / (5));

				sCIDefault.setVar1(sCIDefault.getVar1() + (1));

				nextStateIndex = 0;
				stateVector[0] = State.MainRegion_state2;

			}
		}

	}
	private void reactMainRegion_state2() {
		if ((sCIDefault.event1 && (sCIDefault.getVar3() > 0))) {
			stateVector[0] = State.$NullState$;

			sCIDefault.setVar5(true);

			sCIDefault.setVar3(sCIDefault.getVar3()
					+ ((sCIDefault.getVar2() * sCIDefault.getVar3())));

			nextStateIndex = 0;
			stateVector[0] = State.MainRegion_state1;

		} else {
			sCIDefault.setVar1(sCIDefault.getVar1() + (1));
			/* toCode not defined for: org.yakindu.sct.model.stext.stext.impl.OperationDefinitionImpl@5a04d557 (name: op1) */
			/* toCode not defined for: org.yakindu.sct.model.stext.stext.impl.OperationDefinitionImpl@34979855 (name: op2) */

		}

	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case MainRegion_state1 :
					reactMainRegion_state1();
					break;
				case MainRegion_state2 :
					reactMainRegion_state2();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
