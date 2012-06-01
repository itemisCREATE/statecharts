package org.yakindu.sct.generator.java.runtime.cyclebased.interfacetest;

import java.util.LinkedList;
import java.util.List;

public class InterfacetestStatemachine implements IInterfacetestStatemachine {

	private final class DefaultInterfaceImpl implements DefaultInterface {

		private List<DefaultInterfaceListener> listeners = new LinkedList<DefaultInterfaceListener>();

		public List<DefaultInterfaceListener> getListeners() {
			return listeners;
		}

		private boolean event1;

		public void raiseEvent1() {
			event1 = true;
		}

		private boolean event2;

		private boolean event2Out;

		private int event2Value;

		public boolean isRaisedEvent2() {
			return event2Out;
		}

		private void raiseEvent2(int value) {
			event2Out = true;
			event2 = true;
			event2Value = value;
			for (DefaultInterfaceListener listener : listeners) {
				listener.onEvent2Raised(value);
			}
		}

		public int getEvent2Value() {
			if (!event2Out)
				throw new IllegalStateException(
						"Illegal event value acces. Event Event2 is not raised!");
			return event2Value;
		}

		private boolean var1;

		public boolean getVar1() {
			return var1;
		}

		public void setVar1(boolean value) {
			var1 = value;
		}

		private double var2 = 2.3;

		public double getVar2() {
			return var2;
		}

		public void setVar2(double value) {
			var2 = value;
		}

		private int var3 = 1;

		public int getVar3() {
			return var3;
		}

		public void setVar3(int value) {
			var3 = value;
		}

		public void clearEvents() {
			event1 = false;
			event2 = false;
		}

		public void clearOutEvents() {
			event2Out = false;
		}

	}

	private DefaultInterfaceImpl defaultInterface;

	private final class InterfaceOtherImpl implements InterfaceOther {

		private List<InterfaceOtherListener> listeners = new LinkedList<InterfaceOtherListener>();

		public List<InterfaceOtherListener> getListeners() {
			return listeners;
		}

		private boolean event3;

		public void raiseEvent3() {
			event3 = true;
		}

		private boolean event4;

		private boolean event4Out;

		public boolean isRaisedEvent4() {
			return event4Out;
		}

		private void raiseEvent4() {
			event4Out = true;
			event4 = true;
			for (InterfaceOtherListener listener : listeners) {
				listener.onEvent4Raised();
			}
		}

		private int v1 = 5;

		public int getV1() {
			return v1;
		}

		public void setV1(int value) {
			v1 = value;
		}

		public void clearEvents() {
			event3 = false;
			event4 = false;
		}

		public void clearOutEvents() {
			event4Out = false;
		}

	}

	private InterfaceOtherImpl interfaceOther;

	private final class InterfaceThirdImpl implements InterfaceThird {

		private List<InterfaceThirdListener> listeners = new LinkedList<InterfaceThirdListener>();

		public List<InterfaceThirdListener> getListeners() {
			return listeners;
		}

		private boolean event5;

		public void raiseEvent5() {
			event5 = true;
		}

		private boolean event6;

		private boolean event6Out;

		private boolean event6Value;

		public boolean isRaisedEvent6() {
			return event6Out;
		}

		private void raiseEvent6(boolean value) {
			event6Out = true;
			event6 = true;
			event6Value = value;
			for (InterfaceThirdListener listener : listeners) {
				listener.onEvent6Raised(value);
			}
		}

		public boolean getEvent6Value() {
			if (!event6Out)
				throw new IllegalStateException(
						"Illegal event value acces. Event Event6 is not raised!");
			return event6Value;
		}

		private double v1;

		public double getV1() {
			return v1;
		}

		public void setV1(double value) {
			v1 = value;
		}

		public void clearEvents() {
			event5 = false;
			event6 = false;
		}

		public void clearOutEvents() {
			event6Out = false;
		}

	}

	private InterfaceThirdImpl interfaceThird;

	public enum State {
		State1, State2, State3, State4, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public InterfacetestStatemachine() {

		defaultInterface = new DefaultInterfaceImpl();
		interfaceOther = new InterfaceOtherImpl();
		interfaceThird = new InterfaceThirdImpl();

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
		interfaceOther.clearEvents();
		interfaceThird.clearEvents();

	}

	protected void clearOutEvents() {
		defaultInterface.clearOutEvents();
		interfaceOther.clearOutEvents();
		interfaceThird.clearOutEvents();
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
	public InterfaceThird getInterfaceThird() {
		return interfaceThird;
	}

	public void raiseEvent1() {
		defaultInterface.raiseEvent1();
	}

	public boolean isRaisedEvent2() {
		return defaultInterface.isRaisedEvent2();
	}
	public int getEvent2Value() {
		return defaultInterface.getEvent2Value();
	}

	public boolean getVar1() {
		return defaultInterface.getVar1();
	}

	public void setVar1(boolean value) {
		defaultInterface.setVar1(value);
	}
	public double getVar2() {
		return defaultInterface.getVar2();
	}

	public void setVar2(double value) {
		defaultInterface.setVar2(value);
	}
	public int getVar3() {
		return defaultInterface.getVar3();
	}

	public void setVar3(int value) {
		defaultInterface.setVar3(value);
	}

	public void enter() {
		defaultInterface.setVar2(2.3);
		defaultInterface.setVar3(1);
		interfaceOther.setV1(5);

		// unknown function type org.yakindu.sct.model.sexec.impl.SequenceImpl@524c4135 (name: entryAction) (comment: Entry action for statechart 'InterfaceTest'.)();
		nextStateIndex = 0;
		stateVector[0] = State.State1;

	}

	public void exit() {
		//Handle exit of all possible states (of mainRegion) at position 0...
		switch (stateVector[0]) {

			case State1 :
				stateVector[0] = State.$NullState$;

				break;

			case State2 :
				stateVector[0] = State.$NullState$;
				interfaceOther.setV1(10);

				break;

			case State3 :
				stateVector[0] = State.$NullState$;

				break;

			case State4 :
				stateVector[0] = State.$NullState$;

				break;

			default :
				break;
		}

		// unknown function type org.yakindu.sct.model.sexec.impl.SequenceImpl@2b29bb9a (name: exitAction) (comment: Exit action for state 'InterfaceTest'.)();
	}

	private void reactState1() {
		if ((defaultInterface.event1 && (defaultInterface.getVar2() > 0))) {
			stateVector[0] = State.$NullState$;

			defaultInterface.raiseEvent2(22);

			nextStateIndex = 0;
			stateVector[0] = State.State2;

		} else {
			if ((interfaceOther.event3 && (defaultInterface.getVar3() == 1))) {
				stateVector[0] = State.$NullState$;

				interfaceOther.raiseEvent4();

				nextStateIndex = 0;
				stateVector[0] = State.State3;

			} else {
				if ((interfaceThird.event5 && (defaultInterface.getVar1() == true))) {
					stateVector[0] = State.$NullState$;

					interfaceThird.raiseEvent6(true);

					nextStateIndex = 0;
					stateVector[0] = State.State4;

				}
			}
		}

	}
	private void reactState2() {
		if (defaultInterface.event1) {
			stateVector[0] = State.$NullState$;
			interfaceOther.setV1(10);

			nextStateIndex = 0;
			stateVector[0] = State.State1;

		}

	}
	private void reactState3() {
		if (interfaceOther.event3) {
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.State1;

		}

	}
	private void reactState4() {
		if (interfaceThird.event5) {
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.State1;

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
				case State3 :
					reactState3();
					break;
				case State4 :
					reactState4();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
