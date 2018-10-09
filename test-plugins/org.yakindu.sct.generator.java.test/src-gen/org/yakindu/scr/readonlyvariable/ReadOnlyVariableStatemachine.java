package org.yakindu.scr.readonlyvariable;

public class ReadOnlyVariableStatemachine implements IReadOnlyVariableStatemachine {

	protected class SCInterfaceImpl implements SCInterface {
	
		private long myInt;
		
		public long getMyInt() {
			return myInt;
		}
		
		protected void setMyInt(long value) {
			this.myInt = value;
		}
		
		private String myString;
		
		public String getMyString() {
			return myString;
		}
		
		protected void setMyString(String value) {
			this.myString = value;
		}
		
		private boolean myBool;
		
		public boolean getMyBool() {
			return myBool;
		}
		
		protected void setMyBool(boolean value) {
			this.myBool = value;
		}
		
		private double myReal;
		
		public double getMyReal() {
			return myReal;
		}
		
		protected void setMyReal(double value) {
			this.myReal = value;
		}
		
	}
	
	protected SCInterfaceImpl sCInterface;
	
	protected class SCIAImpl implements SCIA {
	
		private long myInt;
		
		public long getMyInt() {
			return myInt;
		}
		
		protected void setMyInt(long value) {
			this.myInt = value;
		}
		
		private String myString;
		
		public String getMyString() {
			return myString;
		}
		
		protected void setMyString(String value) {
			this.myString = value;
		}
		
		private boolean myBool;
		
		public boolean getMyBool() {
			return myBool;
		}
		
		protected void setMyBool(boolean value) {
			this.myBool = value;
		}
		
		private double myReal;
		
		public double getMyReal() {
			return myReal;
		}
		
		protected void setMyReal(double value) {
			this.myReal = value;
		}
		
	}
	
	protected SCIAImpl sCIA;
	
	private boolean initialized = false;
	
	public enum State {
		main_region_StateB,
		main_region_StateA,
		$NullState$
	};
	
	private final State[] stateVector = new State[1];
	
	private int nextStateIndex;
	
	public ReadOnlyVariableStatemachine() {
		sCInterface = new SCInterfaceImpl();
		sCIA = new SCIAImpl();
	}
	
	public void init() {
		this.initialized = true;
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}
		clearEvents();
		clearOutEvents();
		sCInterface.setMyInt(0);
		
		sCInterface.setMyString("testString");
		
		sCInterface.setMyBool(true);
		
		sCInterface.setMyReal(1.1);
		
		sCIA.setMyInt(0);
		
		sCIA.setMyString("testString");
		
		sCIA.setMyBool(true);
		
		sCIA.setMyReal(1.1);
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
		case main_region_StateB:
			return stateVector[0] == State.main_region_StateB;
		case main_region_StateA:
			return stateVector[0] == State.main_region_StateA;
		default:
			return false;
		}
	}
	
	public SCInterface getSCInterface() {
		return sCInterface;
	}
	
	public SCIA getSCIA() {
		return sCIA;
	}
	
	public long getMyInt() {
		return sCInterface.getMyInt();
	}
	
	public String getMyString() {
		return sCInterface.getMyString();
	}
	
	public boolean getMyBool() {
		return sCInterface.getMyBool();
	}
	
	public double getMyReal() {
		return sCInterface.getMyReal();
	}
	
	/* Entry action for state 'StateB'. */
	private void entryAction_main_region_StateB() {
		sCInterface.setMyInt(100);
		
		sCInterface.setMyString("fail");
		
		sCInterface.setMyBool(false);
		
		sCInterface.setMyReal(6.6);
		
		sCIA.setMyInt(200);
		
		sCIA.setMyString("A_fail");
		
		sCIA.setMyBool(false);
		
		sCIA.setMyReal(7.7);
	}
	
	/* 'default' enter sequence for state StateB */
	private void enterSequence_main_region_StateB_default() {
		entryAction_main_region_StateB();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_StateB;
	}
	
	/* 'default' enter sequence for state StateA */
	private void enterSequence_main_region_StateA_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_StateA;
	}
	
	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}
	
	/* Default exit sequence for state StateB */
	private void exitSequence_main_region_StateB() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state StateA */
	private void exitSequence_main_region_StateA() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
		case main_region_StateB:
			exitSequence_main_region_StateB();
			break;
		case main_region_StateA:
			exitSequence_main_region_StateA();
			break;
		default:
			break;
		}
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_StateA_default();
	}
	
	private boolean react(boolean try_transition) {
		return false;
	}
	
	private boolean main_region_StateB_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (react(try_transition)==false) {
				did_transition = false;;
			}
		}
		if (did_transition==false) {
		}
		return did_transition;
	}
	
	private boolean main_region_StateA_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (react(try_transition)==false) {
				exitSequence_main_region_StateA();
				enterSequence_main_region_StateB_default();
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
			case main_region_StateB:
				main_region_StateB_react(true);
				break;
			case main_region_StateA:
				main_region_StateA_react(true);
				break;
			default:
				// $NullState$
			}
		}
		clearEvents();
	}
}
