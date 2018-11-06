package org.yakindu.scr.choice;

public class ChoiceStatemachine implements IChoiceStatemachine {

	protected class SCInterfaceImpl implements SCInterface {
	
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
		
		protected void clearEvents() {
			e = false;
			f = false;
			g = false;
			h = false;
		}
	}
	
	protected SCInterfaceImpl sCInterface;
	
	private boolean initialized = false;
	
	public enum State {
		main_region_A,
		main_region_B,
		main_region_C,
		$NullState$
	};
	
	private final State[] stateVector = new State[1];
	
	private int nextStateIndex;
	
	public ChoiceStatemachine() {
		sCInterface = new SCInterfaceImpl();
	}
	
	public void init() {
		this.initialized = true;
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}
		clearEvents();
		clearOutEvents();
		sCInterface.setC(false);
	}
	
	public void enter() {
		if (!initialized) {
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
		}
		enterSequence_main_region_default();
	}
	
	public void exit() {
		exitSequence_main_region();
	}
	
	/**
	 * @see IStatemachine#isActive()
	 */
	public boolean isActive() {
		return stateVector[0] != State.$NullState$;
	}
	
	/** 
	* Always returns 'false' since this state machine can never become final.
	*
	* @see IStatemachine#isFinal()
	*/
	public boolean isFinal() {
		return false;
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
		case main_region_A:
			return stateVector[0] == State.main_region_A;
		case main_region_B:
			return stateVector[0] == State.main_region_B;
		case main_region_C:
			return stateVector[0] == State.main_region_C;
		default:
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
	
	private boolean check_main_region__choice_0_tr1_tr1() {
		return sCInterface.getC();
	}
	
	private boolean check_main_region__choice_1_tr0_tr0() {
		return sCInterface.getC();
	}
	
	private boolean check_main_region__choice_2_tr1_tr1() {
		return sCInterface.getC();
	}
	
	private boolean check_main_region__choice_3_tr1_tr1() {
		return sCInterface.getC();
	}
	
	private void effect_main_region__choice_0_tr1() {
		enterSequence_main_region_C_default();
	}
	
	private void effect_main_region__choice_0_tr0() {
		enterSequence_main_region_B_default();
	}
	
	private void effect_main_region__choice_1_tr0() {
		enterSequence_main_region_C_default();
	}
	
	private void effect_main_region__choice_1_tr1() {
		enterSequence_main_region_B_default();
	}
	
	private void effect_main_region__choice_2_tr1() {
		enterSequence_main_region_C_default();
	}
	
	private void effect_main_region__choice_2_tr0() {
		enterSequence_main_region_B_default();
	}
	
	private void effect_main_region__choice_3_tr1() {
		enterSequence_main_region_C_default();
	}
	
	private void effect_main_region__choice_3_tr0() {
		enterSequence_main_region_B_default();
	}
	
	/* 'default' enter sequence for state A */
	private void enterSequence_main_region_A_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_A;
	}
	
	/* 'default' enter sequence for state B */
	private void enterSequence_main_region_B_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_B;
	}
	
	/* 'default' enter sequence for state C */
	private void enterSequence_main_region_C_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_C;
	}
	
	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}
	
	/* Default exit sequence for state A */
	private void exitSequence_main_region_A() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state B */
	private void exitSequence_main_region_B() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state C */
	private void exitSequence_main_region_C() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
		case main_region_A:
			exitSequence_main_region_A();
			break;
		case main_region_B:
			exitSequence_main_region_B();
			break;
		case main_region_C:
			exitSequence_main_region_C();
			break;
		default:
			break;
		}
	}
	
	/* The reactions of state null. */
	private void react_main_region__choice_0() {
		if (check_main_region__choice_0_tr1_tr1()) {
			effect_main_region__choice_0_tr1();
		} else {
			effect_main_region__choice_0_tr0();
		}
	}
	
	/* The reactions of state null. */
	private void react_main_region__choice_1() {
		if (check_main_region__choice_1_tr0_tr0()) {
			effect_main_region__choice_1_tr0();
		} else {
			effect_main_region__choice_1_tr1();
		}
	}
	
	/* The reactions of state null. */
	private void react_main_region__choice_2() {
		if (check_main_region__choice_2_tr1_tr1()) {
			effect_main_region__choice_2_tr1();
		} else {
			effect_main_region__choice_2_tr0();
		}
	}
	
	/* The reactions of state null. */
	private void react_main_region__choice_3() {
		if (check_main_region__choice_3_tr1_tr1()) {
			effect_main_region__choice_3_tr1();
		} else {
			effect_main_region__choice_3_tr0();
		}
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_A_default();
	}
	
	private boolean react(boolean try_transition) {
		return false;
	}
	
	private boolean main_region_A_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (react(try_transition)==false) {
				if (sCInterface.e) {
					exitSequence_main_region_A();
					react_main_region__choice_0();
				} else {
					if (sCInterface.f) {
						exitSequence_main_region_A();
						react_main_region__choice_2();
					} else {
						if (sCInterface.g) {
							exitSequence_main_region_A();
							react_main_region__choice_1();
						} else {
							if (sCInterface.h) {
								exitSequence_main_region_A();
								react_main_region__choice_3();
							} else {
								did_transition = false;
							}
						}
					}
				}
			}
		}
		if (did_transition==false) {
		}
		return did_transition;
	}
	
	private boolean main_region_B_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (react(try_transition)==false) {
				exitSequence_main_region_B();
				enterSequence_main_region_A_default();
			}
		}
		if (did_transition==false) {
		}
		return did_transition;
	}
	
	private boolean main_region_C_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (react(try_transition)==false) {
				exitSequence_main_region_C();
				enterSequence_main_region_A_default();
			}
		}
		if (did_transition==false) {
		}
		return did_transition;
	}
	
	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
		clearOutEvents();
		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
			switch (stateVector[nextStateIndex]) {
			case main_region_A:
				main_region_A_react(true);
				break;
			case main_region_B:
				main_region_B_react(true);
				break;
			case main_region_C:
				main_region_C_react(true);
				break;
			default:
				// $NullState$
			}
		}
		clearEvents();
	}
}
