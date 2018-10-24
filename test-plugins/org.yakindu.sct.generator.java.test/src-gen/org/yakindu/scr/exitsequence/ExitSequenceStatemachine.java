package org.yakindu.scr.exitsequence;

public class ExitSequenceStatemachine implements IExitSequenceStatemachine {

	protected class SCInterfaceImpl implements SCInterface {
	
		private boolean e;
		
		public void raiseE() {
			e = true;
			runCycle();
		}
		
		private boolean guard;
		
		public boolean getGuard() {
			return guard;
		}
		
		public void setGuard(boolean value) {
			this.guard = value;
		}
		
		private long canary;
		
		public long getCanary() {
			return canary;
		}
		
		public void setCanary(long value) {
			this.canary = value;
		}
		
		protected void clearEvents() {
			e = false;
		}
	}
	
	protected SCInterfaceImpl sCInterface;
	
	private boolean initialized = false;
	
	public enum State {
		main_region_StateA,
		main_region_StateA_inner1_State1A,
		main_region_StateA_inner1_State1B,
		main_region_StateA_inner1_State1B_inner2a_State2A,
		main_region_StateA_inner1_State1B_inner2b_State2B,
		$NullState$
	};
	
	private final State[] stateVector = new State[2];
	
	private int nextStateIndex;
	
	public ExitSequenceStatemachine() {
		sCInterface = new SCInterfaceImpl();
	}
	
	public void init() {
		this.initialized = true;
		for (int i = 0; i < 2; i++) {
			stateVector[i] = State.$NullState$;
		}
		clearEvents();
		clearOutEvents();
		sCInterface.setGuard(false);
		
		sCInterface.setCanary(0);
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
		return stateVector[0] != State.$NullState$||stateVector[1] != State.$NullState$;
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
		case main_region_StateA:
			return stateVector[0].ordinal() >= State.
					main_region_StateA.ordinal()&& stateVector[0].ordinal() <= State.main_region_StateA_inner1_State1B_inner2b_State2B.ordinal();
		case main_region_StateA_inner1_State1A:
			return stateVector[0] == State.main_region_StateA_inner1_State1A;
		case main_region_StateA_inner1_State1B:
			return stateVector[0].ordinal() >= State.
					main_region_StateA_inner1_State1B.ordinal()&& stateVector[0].ordinal() <= State.main_region_StateA_inner1_State1B_inner2b_State2B.ordinal();
		case main_region_StateA_inner1_State1B_inner2a_State2A:
			return stateVector[0] == State.main_region_StateA_inner1_State1B_inner2a_State2A;
		case main_region_StateA_inner1_State1B_inner2b_State2B:
			return stateVector[1] == State.main_region_StateA_inner1_State1B_inner2b_State2B;
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
	
	public boolean getGuard() {
		return sCInterface.getGuard();
	}
	
	public void setGuard(boolean value) {
		sCInterface.setGuard(value);
	}
	
	public long getCanary() {
		return sCInterface.getCanary();
	}
	
	public void setCanary(long value) {
		sCInterface.setCanary(value);
	}
	
	/* Exit action for state 'StateA'. */
	private void exitAction_main_region_StateA() {
		sCInterface.setCanary(1);
	}
	
	/* 'default' enter sequence for state StateA */
	private void enterSequence_main_region_StateA_default() {
		enterSequence_main_region_StateA_inner1_default();
	}
	
	/* 'default' enter sequence for state State1A */
	private void enterSequence_main_region_StateA_inner1_State1A_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_StateA_inner1_State1A;
	}
	
	/* 'default' enter sequence for state State1B */
	private void enterSequence_main_region_StateA_inner1_State1B_default() {
		enterSequence_main_region_StateA_inner1_State1B_inner2a_default();
		enterSequence_main_region_StateA_inner1_State1B_inner2b_default();
	}
	
	/* 'default' enter sequence for state State2A */
	private void enterSequence_main_region_StateA_inner1_State1B_inner2a_State2A_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_StateA_inner1_State1B_inner2a_State2A;
	}
	
	/* 'default' enter sequence for state State2B */
	private void enterSequence_main_region_StateA_inner1_State1B_inner2b_State2B_default() {
		nextStateIndex = 1;
		stateVector[1] = State.main_region_StateA_inner1_State1B_inner2b_State2B;
	}
	
	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}
	
	/* 'default' enter sequence for region inner1 */
	private void enterSequence_main_region_StateA_inner1_default() {
		react_main_region_StateA_inner1__entry_Default();
	}
	
	/* 'default' enter sequence for region inner2a */
	private void enterSequence_main_region_StateA_inner1_State1B_inner2a_default() {
		react_main_region_StateA_inner1_State1B_inner2a__entry_Default();
	}
	
	/* 'default' enter sequence for region inner2b */
	private void enterSequence_main_region_StateA_inner1_State1B_inner2b_default() {
		react_main_region_StateA_inner1_State1B_inner2b__entry_Default();
	}
	
	/* Default exit sequence for state State1A */
	private void exitSequence_main_region_StateA_inner1_exitSequence_main_region_StateA_inner1_State1A() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state State2A */
	private void exitSequence_main_region_StateA_inner1_State1B_inner2a_exitSequence_main_region_StateA_inner1_State1B_inner2a_State2A() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state State2B */
	private void exitSequence_main_region_StateA_inner1_State1B_inner2b_exitSequence_main_region_StateA_inner1_State1B_inner2b_State2B() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}
	
	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
		case main_region_StateA_inner1_State1A:
			exitSequence_main_region_StateA_inner1_exitSequence_main_region_StateA_inner1_State1A();
			break;
		case main_region_StateA_inner1_State1B_inner2a_State2A:
			exitSequence_main_region_StateA_inner1_State1B_inner2a_exitSequence_main_region_StateA_inner1_State1B_inner2a_State2A();
			break;
		default:
			break;
		}
		
		switch (stateVector[1]) {
		case main_region_StateA_inner1_State1B_inner2b_State2B:
			exitSequence_main_region_StateA_inner1_State1B_inner2b_exitSequence_main_region_StateA_inner1_State1B_inner2b_State2B();
			exitAction_main_region_StateA();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region inner1 */
	private void exitSequence_main_region_StateA_inner1() {
		switch (stateVector[0]) {
		case main_region_StateA_inner1_State1A:
			exitSequence_main_region_StateA_inner1_exitSequence_main_region_StateA_inner1_State1A();
			break;
		case main_region_StateA_inner1_State1B_inner2a_State2A:
			exitSequence_main_region_StateA_inner1_State1B_inner2a_exitSequence_main_region_StateA_inner1_State1B_inner2a_State2A();
			break;
		default:
			break;
		}
		
		switch (stateVector[1]) {
		case main_region_StateA_inner1_State1B_inner2b_State2B:
			exitSequence_main_region_StateA_inner1_State1B_inner2b_exitSequence_main_region_StateA_inner1_State1B_inner2b_State2B();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region inner2a */
	private void exitSequence_main_region_StateA_inner1_State1B_inner2a() {
		switch (stateVector[0]) {
		case main_region_StateA_inner1_State1B_inner2a_State2A:
			exitSequence_main_region_StateA_inner1_State1B_inner2a_exitSequence_main_region_StateA_inner1_State1B_inner2a_State2A();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region inner2b */
	private void exitSequence_main_region_StateA_inner1_State1B_inner2b() {
		switch (stateVector[1]) {
		case main_region_StateA_inner1_State1B_inner2b_State2B:
			exitSequence_main_region_StateA_inner1_State1B_inner2b_exitSequence_main_region_StateA_inner1_State1B_inner2b_State2B();
			break;
		default:
			break;
		}
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_StateA_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_StateA_inner1__entry_Default() {
		enterSequence_main_region_StateA_inner1_State1A_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_StateA_inner1_State1B_inner2a__entry_Default() {
		enterSequence_main_region_StateA_inner1_State1B_inner2a_State2A_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_StateA_inner1_State1B_inner2b__entry_Default() {
		enterSequence_main_region_StateA_inner1_State1B_inner2b_State2B_default();
	}
	
	private boolean react(boolean try_transition) {
		return false;
	}
	
	private boolean main_region_StateA_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			did_transition = false;
		}
		if (did_transition==false) {
			did_transition = react(try_transition);
		}
		return did_transition;
	}
	
	private boolean main_region_StateA_inner1_State1A_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (sCInterface.getGuard()) {
				exitSequence_main_region_StateA_inner1_exitSequence_main_region_StateA_inner1_State1A();
				enterSequence_main_region_StateA_inner1_State1B_default();
				main_region_StateA_react(false);
			} else {
				did_transition = false;
			}
		}
		if (did_transition==false) {
		}
		return did_transition;
	}
	
	private boolean main_region_StateA_inner1_State1B_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			did_transition = false;
		}
		if (did_transition==false) {
			did_transition = main_region_StateA_react(try_transition);
		}
		return did_transition;
	}
	
	private boolean main_region_StateA_inner1_State1B_inner2a_State2A_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			did_transition = false;
		}
		if (did_transition==false) {
		}
		return did_transition;
	}
	
	private boolean main_region_StateA_inner1_State1B_inner2b_State2B_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			did_transition = false;
		}
		if (did_transition==false) {
			did_transition = main_region_StateA_inner1_State1B_react(try_transition);
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
			case main_region_StateA_inner1_State1A:
				main_region_StateA_inner1_State1A_react(true);
				break;
			case main_region_StateA_inner1_State1B_inner2a_State2A:
				main_region_StateA_inner1_State1B_inner2a_State2A_react(true);
				break;
			case main_region_StateA_inner1_State1B_inner2b_State2B:
				main_region_StateA_inner1_State1B_inner2b_State2B_react(true);
				break;
			default:
				// $NullState$
			}
		}
		clearEvents();
	}
}
