package org.yakindu.scr.choice;

public class ChoiceStatemachine implements IChoiceStatemachine {

	static {
	}

	private final class SCInterfaceImpl implements SCInterface {

		private boolean e;

		public void raiseE() {
			e = true;
		}

		private boolean f;

		public void raiseF() {
			f = true;
		}

		private boolean g;

		public void raiseG() {
			g = true;
		}

		private boolean h;

		public void raiseH() {
			h = true;
		}

		private boolean c;
		public boolean getC() {
			return c;
		}

		public void setC(boolean value) {
			this.c = value;
		}

		public void clearEvents() {
			e = false;
			f = false;
			g = false;
			h = false;
		}

	}

	private SCInterfaceImpl sCInterface;

	public enum State {
		main_region_A, main_region_B, main_region_C, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public ChoiceStatemachine() {

		sCInterface = new SCInterfaceImpl();
	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCInterface.c = false;
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
			case main_region_A :
				return stateVector[0] == State.main_region_A;
			case main_region_B :
				return stateVector[0] == State.main_region_B;
			case main_region_C :
				return stateVector[0] == State.main_region_C;
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
	public void raiseF() {
		sCInterface.raiseF();
	}
	public void raiseG() {
		sCInterface.raiseG();
	}
	public void raiseH() {
		sCInterface.raiseH();
	}

	public boolean getC() {
		return sCInterface.getC();
	}

	public void setC(boolean value) {
		sCInterface.setC(value);
	}

	private boolean checkMain_region_ATr0() {
		return sCInterface.e;
	}

	private boolean checkMain_region_ATr1() {
		return sCInterface.f;
	}

	private boolean checkMain_region_ATr2() {
		return sCInterface.g;
	}

	private boolean checkMain_region_ATr3() {
		return sCInterface.h;
	}

	private boolean checkMain_region_BTr0() {
		return true;
	}

	private boolean checkMain_region_CTr0() {
		return true;
	}

	private boolean checkChoice_main_region__choice_0Tr1() {
		return sCInterface.c;
	}

	private boolean checkChoice_main_region__choice_0Tr0() {
		return true;
	}

	private boolean checkChoice_main_region__choice_1Tr0() {
		return sCInterface.c;
	}

	private boolean checkChoice_main_region__choice_1Tr1() {
		return true;
	}

	private boolean checkChoice_main_region__choice_2Tr1() {
		return sCInterface.c;
	}

	private boolean checkChoice_main_region__choice_2Tr0() {
		return true;
	}

	private boolean checkChoice_main_region__choice_3Tr1() {
		return sCInterface.c;
	}

	private boolean checkChoice_main_region__choice_3Tr0() {
		return true;
	}

	private void effectMain_region_ATr0() {
		exitSequenceMain_region_A();

		reactChoice_main_region__choice_0();
	}

	private void effectMain_region_ATr1() {
		exitSequenceMain_region_A();

		reactChoice_main_region__choice_2();
	}

	private void effectMain_region_ATr2() {
		exitSequenceMain_region_A();

		reactChoice_main_region__choice_1();
	}

	private void effectMain_region_ATr3() {
		exitSequenceMain_region_A();

		reactChoice_main_region__choice_3();
	}

	private void effectMain_region_BTr0() {
		exitSequenceMain_region_B();

		enterSequenceMain_region_A();
	}

	private void effectMain_region_CTr0() {
		exitSequenceMain_region_C();

		enterSequenceMain_region_A();
	}

	private void effectChoice_main_region__choice_0Tr1() {
		enterSequenceMain_region_C();
	}

	private void effectChoice_main_region__choice_0Tr0() {
		enterSequenceMain_region_B();
	}

	private void effectChoice_main_region__choice_1Tr0() {
		enterSequenceMain_region_C();
	}

	private void effectChoice_main_region__choice_1Tr1() {
		enterSequenceMain_region_B();
	}

	private void effectChoice_main_region__choice_2Tr1() {
		enterSequenceMain_region_C();
	}

	private void effectChoice_main_region__choice_2Tr0() {
		enterSequenceMain_region_B();
	}

	private void effectChoice_main_region__choice_3Tr1() {
		enterSequenceMain_region_C();
	}

	private void effectChoice_main_region__choice_3Tr0() {
		enterSequenceMain_region_B();
	}

	/* Entry action for statechart 'Choice'. */
	private void entryAction() {
	}

	/* Exit action for state 'Choice'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state A */
	private void enterSequenceMain_region_A() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_A;
	}

	/* 'default' enter sequence for state B */
	private void enterSequenceMain_region_B() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_B;
	}

	/* 'default' enter sequence for state C */
	private void enterSequenceMain_region_C() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_C;
	}

	/* 'default' enter sequence for region main region */
	private void enterSequenceMain_region() {
		reactChoice_main_region__entry_Default();
	}

	/* Default exit sequence for state A */
	private void exitSequenceMain_region_A() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state B */
	private void exitSequenceMain_region_B() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state C */
	private void exitSequenceMain_region_C() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for region main region */
	private void exitSequenceMain_region() {
		switch (stateVector[0]) {
			case main_region_A :
				exitSequenceMain_region_A();
				break;

			case main_region_B :
				exitSequenceMain_region_B();
				break;

			case main_region_C :
				exitSequenceMain_region_C();
				break;

			default :
				break;
		}
	}

	/* The reactions of state A. */
	private void reactMain_region_A() {
		if (checkMain_region_ATr0()) {
			effectMain_region_ATr0();
		} else {
			if (checkMain_region_ATr1()) {
				effectMain_region_ATr1();
			} else {
				if (checkMain_region_ATr2()) {
					effectMain_region_ATr2();
				} else {
					if (checkMain_region_ATr3()) {
						effectMain_region_ATr3();
					}
				}
			}
		}
	}

	/* The reactions of state B. */
	private void reactMain_region_B() {
		effectMain_region_BTr0();
	}

	/* The reactions of state C. */
	private void reactMain_region_C() {
		effectMain_region_CTr0();
	}

	/* The reactions of state null. */
	private void reactChoice_main_region__choice_0() {
		if (checkChoice_main_region__choice_0Tr1()) {
			effectChoice_main_region__choice_0Tr1();
		} else {
			effectChoice_main_region__choice_0Tr0();
		}
	}

	/* The reactions of state null. */
	private void reactChoice_main_region__choice_1() {
		if (checkChoice_main_region__choice_1Tr0()) {
			effectChoice_main_region__choice_1Tr0();
		} else {
			effectChoice_main_region__choice_1Tr1();
		}
	}

	/* The reactions of state null. */
	private void reactChoice_main_region__choice_2() {
		if (checkChoice_main_region__choice_2Tr1()) {
			effectChoice_main_region__choice_2Tr1();
		} else {
			effectChoice_main_region__choice_2Tr0();
		}
	}

	/* The reactions of state null. */
	private void reactChoice_main_region__choice_3() {
		if (checkChoice_main_region__choice_3Tr1()) {
			effectChoice_main_region__choice_3Tr1();
		} else {
			effectChoice_main_region__choice_3Tr0();
		}
	}

	/* Default react sequence for initial entry  */
	private void reactChoice_main_region__entry_Default() {
		enterSequenceMain_region_A();
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
				case main_region_C :
					reactMain_region_C();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
