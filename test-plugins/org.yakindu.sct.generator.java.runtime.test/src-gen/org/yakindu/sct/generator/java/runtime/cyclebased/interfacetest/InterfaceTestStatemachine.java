package org.yakindu.sct.generator.java.runtime.cyclebased.interfacetest;

import java.util.LinkedList;
import java.util.List;

public class InterfaceTestStatemachine implements IInterfaceTestStatemachine {

	private final class SCIDefaultImpl implements SCIDefault {

		private List<SCIDefaultListener> listeners = new LinkedList<SCIDefaultListener>();

		public List<SCIDefaultListener> getListeners() {
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
			for (SCIDefaultListener listener : listeners) {
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
			this.var1 = value;
		}

		private double var2 = 2.3;

		public double getVar2() {
			return var2;
		}

		public void setVar2(double value) {
			this.var2 = value;
		}

		private int var3 = 1;

		public int getVar3() {
			return var3;
		}

		public void setVar3(int value) {
			this.var3 = value;
		}

		public void clearEvents() {
			event1 = false;
			event2 = false;
		}

		public void clearOutEvents() {
			event2Out = false;
		}

	}

	private SCIDefaultImpl sCIDefault;

	private final class SCIOtherImpl implements SCIOther {

		private List<SCIOtherListener> listeners = new LinkedList<SCIOtherListener>();

		public List<SCIOtherListener> getListeners() {
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
			for (SCIOtherListener listener : listeners) {
				listener.onEvent4Raised();
			}
		}

		private int v1 = 5;

		public int getV1() {
			return v1;
		}

		public void setV1(int value) {
			this.v1 = value;
		}

		public void clearEvents() {
			event3 = false;
			event4 = false;
		}

		public void clearOutEvents() {
			event4Out = false;
		}

	}

	private SCIOtherImpl sCIOther;

	private final class SCIThirdImpl implements SCIThird {

		private List<SCIThirdListener> listeners = new LinkedList<SCIThirdListener>();

		public List<SCIThirdListener> getListeners() {
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
			for (SCIThirdListener listener : listeners) {
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
			this.v1 = value;
		}

		public void clearEvents() {
			event5 = false;
			event6 = false;
		}

		public void clearOutEvents() {
			event6Out = false;
		}

	}

	private SCIThirdImpl sCIThird;

	public enum State {
		MainRegion_state1, MainRegion_state2, MainRegion_state3, MainRegion_state4, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public InterfaceTestStatemachine() {

		sCIDefault = new SCIDefaultImpl();
		sCIOther = new SCIOtherImpl();
		sCIThird = new SCIThirdImpl();

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
		sCIOther.clearEvents();
		sCIThird.clearEvents();

	}

	protected void clearOutEvents() {
		sCIDefault.clearOutEvents();
		sCIOther.clearOutEvents();
		sCIThird.clearOutEvents();
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
	public SCIThird getSCIThird() {
		return sCIThird;
	}

	public void raiseEvent1() {
		sCIDefault.raiseEvent1();
	}

	public boolean isRaisedEvent2() {
		return sCIDefault.isRaisedEvent2();
	}
	public int getEvent2Value() {
		return sCIDefault.getEvent2Value();
	}

	public boolean getVar1() {
		return sCIDefault.getVar1();
	}

	public void setVar1(boolean value) {
		sCIDefault.setVar1(value);
	}
	public double getVar2() {
		return sCIDefault.getVar2();
	}

	public void setVar2(double value) {
		sCIDefault.setVar2(value);
	}
	public int getVar3() {
		return sCIDefault.getVar3();
	}

	public void setVar3(int value) {
		sCIDefault.setVar3(value);
	}

	public void enter() {
		sCIDefault.setVar2(2.3);
		sCIDefault.setVar3(1);
		sCIOther.setV1(5);

		// unknown function type org.yakindu.sct.model.sexec.impl.SequenceImpl@119d4893 (name: entryAction) (comment: Entry action for statechart 'InterfaceTest'.)();
		nextStateIndex = 0;
		stateVector[0] = State.MainRegion_state1;

	}

	public void exit() {
		//Handle exit of all possible states (of mainRegion) at position 0...
		switch (stateVector[0]) {

			case MainRegion_state1 :
				stateVector[0] = State.$NullState$;

				break;

			case MainRegion_state2 :
				stateVector[0] = State.$NullState$;
				sCIOther.setV1(10);

				break;

			case MainRegion_state3 :
				stateVector[0] = State.$NullState$;

				break;

			case MainRegion_state4 :
				stateVector[0] = State.$NullState$;

				break;

			default :
				break;
		}

		// unknown function type org.yakindu.sct.model.sexec.impl.SequenceImpl@4a269585 (name: exitAction) (comment: Exit action for state 'InterfaceTest'.)();
	}

	private void reactMainRegion_state1() {
		if ((sCIDefault.event1 && (sCIDefault.getVar2() > 0))) {
			stateVector[0] = State.$NullState$;

			sCIDefault.raiseEvent2(22);

			nextStateIndex = 0;
			stateVector[0] = State.MainRegion_state2;

		} else {
			if ((sCIOther.event3 && (sCIDefault.getVar3() == 1))) {
				stateVector[0] = State.$NullState$;

				sCIOther.raiseEvent4();

				nextStateIndex = 0;
				stateVector[0] = State.MainRegion_state3;

			} else {
				if ((sCIThird.event5 && (sCIDefault.getVar1() == true))) {
					stateVector[0] = State.$NullState$;

					sCIThird.raiseEvent6(true);

					nextStateIndex = 0;
					stateVector[0] = State.MainRegion_state4;

				}
			}
		}

	}
	private void reactMainRegion_state2() {
		if (sCIDefault.event1) {
			stateVector[0] = State.$NullState$;
			sCIOther.setV1(10);

			nextStateIndex = 0;
			stateVector[0] = State.MainRegion_state1;

		}

	}
	private void reactMainRegion_state3() {
		if (sCIOther.event3) {
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.MainRegion_state1;

		}

	}
	private void reactMainRegion_state4() {
		if (sCIThird.event5) {
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.MainRegion_state1;

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
				case MainRegion_state3 :
					reactMainRegion_state3();
					break;
				case MainRegion_state4 :
					reactMainRegion_state4();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
