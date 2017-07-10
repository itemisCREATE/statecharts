package org.yakindu.scr.typealias;

public class TypeAliasStatemachine implements ITypeAliasStatemachine {

	protected class SCInterfaceImpl implements SCInterface {
	
		private boolean myEvent;
		
		public void raiseMyEvent() {
			myEvent = true;
		}
		
		private long myVar;
		
		public long getMyVar() {
			return myVar;
		}
		
		public void setMyVar(long value) {
			this.myVar = value;
		}
		
		private String myString;
		
		public String getMyString() {
			return myString;
		}
		
		public void setMyString(String value) {
			this.myString = value;
		}
		
		protected void clearEvents() {
			myEvent = false;
		}
	}
	
	protected SCInterfaceImpl sCInterface;
	
	private boolean initialized = false;
	
	public enum State {
		main_region_Start,
		main_region_Mid,
		main_region_Mid2,
		main_region_End,
		$NullState$
	};
	
	private final State[] stateVector = new State[1];
	
	private int nextStateIndex;
	
	public TypeAliasStatemachine() {
		sCInterface = new SCInterfaceImpl();
	}
	
	public void init() {
		this.initialized = true;
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}
		clearEvents();
		clearOutEvents();
		sCInterface.setMyVar(0);
		
		sCInterface.setMyString("");
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
		case main_region_Start:
			return stateVector[0] == State.main_region_Start;
		case main_region_Mid:
			return stateVector[0] == State.main_region_Mid;
		case main_region_Mid2:
			return stateVector[0] == State.main_region_Mid2;
		case main_region_End:
			return stateVector[0] == State.main_region_End;
		default:
			return false;
		}
	}
	
	public SCInterface getSCInterface() {
		return sCInterface;
	}
	
	public void raiseMyEvent() {
		sCInterface.raiseMyEvent();
	}
	
	public long getMyVar() {
		return sCInterface.getMyVar();
	}
	
	public void setMyVar(long value) {
		sCInterface.setMyVar(value);
	}
	
	public String getMyString() {
		return sCInterface.getMyString();
	}
	
	public void setMyString(String value) {
		sCInterface.setMyString(value);
	}
	
	private boolean check_main_region_Start_tr0_tr0() {
		return sCInterface.getMyVar()==1;
	}
	
	private boolean check_main_region_Mid_tr0_tr0() {
		return (sCInterface.getMyString()== null?"TypeSystem" ==null :sCInterface.getMyString().equals("TypeSystem"));
	}
	
	private boolean check_main_region_Mid2_tr0_tr0() {
		return sCInterface.myEvent;
	}
	
	private void effect_main_region_Start_tr0() {
		exitSequence_main_region_Start();
		enterSequence_main_region_Mid_default();
	}
	
	private void effect_main_region_Mid_tr0() {
		exitSequence_main_region_Mid();
		enterSequence_main_region_Mid2_default();
	}
	
	private void effect_main_region_Mid2_tr0() {
		exitSequence_main_region_Mid2();
		enterSequence_main_region_End_default();
	}
	
	/* Entry action for state 'Start'. */
	private void entryAction_main_region_Start() {
		sCInterface.setMyVar(1);
	}
	
	/* Entry action for state 'Mid'. */
	private void entryAction_main_region_Mid() {
		sCInterface.setMyString("TypeSystem");
	}
	
	/* 'default' enter sequence for state Start */
	private void enterSequence_main_region_Start_default() {
		entryAction_main_region_Start();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Start;
	}
	
	/* 'default' enter sequence for state Mid */
	private void enterSequence_main_region_Mid_default() {
		entryAction_main_region_Mid();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Mid;
	}
	
	/* 'default' enter sequence for state Mid2 */
	private void enterSequence_main_region_Mid2_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Mid2;
	}
	
	/* 'default' enter sequence for state End */
	private void enterSequence_main_region_End_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_End;
	}
	
	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}
	
	/* Default exit sequence for state Start */
	private void exitSequence_main_region_Start() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Mid */
	private void exitSequence_main_region_Mid() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Mid2 */
	private void exitSequence_main_region_Mid2() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state End */
	private void exitSequence_main_region_End() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
		case main_region_Start:
			exitSequence_main_region_Start();
			break;
		case main_region_Mid:
			exitSequence_main_region_Mid();
			break;
		case main_region_Mid2:
			exitSequence_main_region_Mid2();
			break;
		case main_region_End:
			exitSequence_main_region_End();
			break;
		default:
			break;
		}
	}
	
	/* The reactions of state Start. */
	private void react_main_region_Start() {
		if (check_main_region_Start_tr0_tr0()) {
			effect_main_region_Start_tr0();
		} else {
		}
	}
	
	/* The reactions of state Mid. */
	private void react_main_region_Mid() {
		if (check_main_region_Mid_tr0_tr0()) {
			effect_main_region_Mid_tr0();
		} else {
		}
	}
	
	/* The reactions of state Mid2. */
	private void react_main_region_Mid2() {
		if (check_main_region_Mid2_tr0_tr0()) {
			effect_main_region_Mid2_tr0();
		} else {
		}
	}
	
	/* The reactions of state End. */
	private void react_main_region_End() {
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_Start_default();
	}
	
	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
		clearOutEvents();
		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
			switch (stateVector[nextStateIndex]) {
			case main_region_Start:
				react_main_region_Start();
				break;
			case main_region_Mid:
				react_main_region_Mid();
				break;
			case main_region_Mid2:
				react_main_region_Mid2();
				break;
			case main_region_End:
				react_main_region_End();
				break;
			default:
				// $NullState$
			}
		}
		clearEvents();
	}
}
