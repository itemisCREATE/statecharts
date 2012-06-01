package org.yakindu.sct.generator.java.runtime.cyclebased.test_expression;

import java.util.LinkedList;
import java.util.List;

public class Test_expressionStatemachine
		implements
			ITest_expressionStatemachine {

	private final class DefaultInterfaceImpl implements DefaultInterface {

		private List<DefaultInterfaceListener> listeners = new LinkedList<DefaultInterfaceListener>();

		public List<DefaultInterfaceListener> getListeners() {
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
			for (DefaultInterfaceListener listener : listeners) {
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
			var1 = value;
		}

		private int var2 = 123;

		public int getVar2() {
			return var2;
		}

		public void setVar2(int value) {
			var2 = value;
		}

		private double var3 = 19.4;

		public double getVar3() {
			return var3;
		}

		public void setVar3(double value) {
			var3 = value;
		}

		private double var4 = 43.3;

		public double getVar4() {
			return var4;
		}

		public void setVar4(double value) {
			var4 = value;
		}

		private boolean var5 = false;

		public boolean getVar5() {
			return var5;
		}

		public void setVar5(boolean value) {
			var5 = value;
		}

		private String var6 = "foo";

		public String getVar6() {
			return var6;
		}

		public void setVar6(String value) {
			var6 = value;
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

	private DefaultInterfaceImpl defaultInterface;

	private final class InterfaceOtherImpl implements InterfaceOther {

		private boolean var1;

		public boolean getVar1() {
			return var1;
		}

		public void setVar1(boolean value) {
			var1 = value;
		}

		private double var2;

		public double getVar2() {
			return var2;
		}

		public void setVar2(double value) {
			var2 = value;
		}

		private int var3;

		public int getVar3() {
			return var3;
		}

		public void setVar3(int value) {
			var3 = value;
		}

	}

	private InterfaceOtherImpl interfaceOther;

	public enum State {
		State1, State2, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public Test_expressionStatemachine() {

		defaultInterface = new DefaultInterfaceImpl();
		interfaceOther = new InterfaceOtherImpl();

	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();
	}

	protected void clearEvents() {
		defaultInterface.clearEvents();

	}

	protected void clearOutEvents() {
		defaultInterface.clearOutEvents();
	}

	public boolean isStateActive(State state) {
		for (int i = 0; i < stateVector.length; i++) {
			if (stateVector[i] == state) {
				return true;
			}
		}
		return false;
	}

	public DefaultInterface getDefaultInterface() {
		return defaultInterface;
	}
	public InterfaceOther getInterfaceOther() {
		return interfaceOther;
	}

	public void raiseEvent1(int value) {
		defaultInterface.raiseEvent1(value);
	}

	public boolean isRaisedEvent2() {
		return defaultInterface.isRaisedEvent2();
	}
	public double getEvent2Value() {
		return defaultInterface.getEvent2Value();
	}

	public void raiseEvent3() {
		defaultInterface.raiseEvent3();
	}

	public int getVar1() {
		return defaultInterface.getVar1();
	}

	public void setVar1(int value) {
		defaultInterface.setVar1(value);
	}
	public int getVar2() {
		return defaultInterface.getVar2();
	}

	public void setVar2(int value) {
		defaultInterface.setVar2(value);
	}
	public double getVar3() {
		return defaultInterface.getVar3();
	}

	public void setVar3(double value) {
		defaultInterface.setVar3(value);
	}
	public double getVar4() {
		return defaultInterface.getVar4();
	}

	public void setVar4(double value) {
		defaultInterface.setVar4(value);
	}
	public boolean getVar5() {
		return defaultInterface.getVar5();
	}

	public void setVar5(boolean value) {
		defaultInterface.setVar5(value);
	}
	public String getVar6() {
		return defaultInterface.getVar6();
	}

	public void setVar6(String value) {
		defaultInterface.setVar6(value);
	}

	public void enter() {
		defaultInterface.setVar1(6);
		defaultInterface.setVar2(123);
		defaultInterface.setVar3(19.4);
		defaultInterface.setVar4(43.3);
		defaultInterface.setVar5(false);
		defaultInterface.setVar6("foo");

		// unknown function type org.yakindu.sct.model.sexec.impl.SequenceImpl@1272a24f (name: entryAction) (comment: Entry action for statechart 'Test_Expression'.)();
		defaultInterface.setVar3(defaultInterface.getVar3()
				+ ((defaultInterface.getVar2() * defaultInterface.getVar3())));

		nextStateIndex = 0;
		stateVector[0] = State.State1;

	}

	public void exit() {
		//Handle exit of all possible states (of mainRegion) at position 0...
		switch (stateVector[0]) {

			case State1 :
				stateVector[0] = State.$NullState$;
				defaultInterface.setVar2(1);

				defaultInterface.setVar4(22.3);

				break;

			case State2 :
				stateVector[0] = State.$NullState$;

				break;

			default :
				break;
		}

		// unknown function type org.yakindu.sct.model.sexec.impl.SequenceImpl@53511634 (name: exitAction) (comment: Exit action for state 'Test_Expression'.)();
	}

	private void reactState1() {
		if ((defaultInterface.event1 && ((interfaceOther.getVar1() == true) || (defaultInterface
				.getVar5() == false)))) {
			stateVector[0] = State.$NullState$;
			defaultInterface.setVar2(1);

			defaultInterface.setVar4(22.3);

			interfaceOther.setVar1(false);

			defaultInterface.setVar3(defaultInterface.getVar3() / (5));

			defaultInterface.setVar1(defaultInterface.getVar1() + (1));

			nextStateIndex = 0;
			stateVector[0] = State.State2;

		} else {
			if ((defaultInterface.event1 && (defaultInterface.getVar6() == null
					? "foo" == null
					: defaultInterface.getVar6().equals("foo")))) {
				stateVector[0] = State.$NullState$;
				defaultInterface.setVar2(1);

				defaultInterface.setVar4(22.3);

				defaultInterface.setVar6("bar");

				defaultInterface.setVar3(defaultInterface.getVar3() / (5));

				defaultInterface.setVar1(defaultInterface.getVar1() + (1));

				nextStateIndex = 0;
				stateVector[0] = State.State2;

			}
		}

	}
	private void reactState2() {
		if ((defaultInterface.event1 && (defaultInterface.getVar3() > 0))) {
			stateVector[0] = State.$NullState$;

			defaultInterface.setVar5(true);

			defaultInterface
					.setVar3(defaultInterface.getVar3()
							+ ((defaultInterface.getVar2() * defaultInterface
									.getVar3())));

			nextStateIndex = 0;
			stateVector[0] = State.State1;

		} else {
			defaultInterface.setVar1(defaultInterface.getVar1() + (1));
			/* toCode not defined for: org.yakindu.sct.model.stext.stext.impl.OperationDefinitionImpl@314788d8 (name: op1) */
			/* toCode not defined for: org.yakindu.sct.model.stext.stext.impl.OperationDefinitionImpl@3778b148 (name: op2) */

		}

	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case State1 :
					reactState1();
					break;
				case State2 :
					reactState2();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
