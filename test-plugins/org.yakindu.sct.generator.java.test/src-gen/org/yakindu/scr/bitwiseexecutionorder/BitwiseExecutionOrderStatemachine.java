package org.yakindu.scr.bitwiseexecutionorder;

public class BitwiseExecutionOrderStatemachine implements IBitwiseExecutionOrderStatemachine {

	private boolean initialized = false;
	
	public enum State {
		main_region_StateB,
		main_region__final_,
		$NullState$
	};
	
	private final State[] stateVector = new State[1];
	
	private int nextStateIndex;
	
	private long y;
	
	protected void setY(long value) {
		y = value;
	}
	
	protected long getY() {
		return y;
	}
	
	private long x;
	
	protected void setX(long value) {
		x = value;
	}
	
	protected long getX() {
		return x;
	}
	
	public BitwiseExecutionOrderStatemachine() {
	}
	
	public void init() {
		this.initialized = true;
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}
		clearEvents();
		clearOutEvents();
		setY(0);
		
		setX(0);
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
	* @see IStatemachine#isFinal()
	*/
	public boolean isFinal() {
		return (stateVector[0] == State.main_region__final_);
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
		case main_region__final_:
			return stateVector[0] == State.main_region__final_;
		default:
			return false;
		}
	}
	
	private boolean check_main_region_StateB_tr0_tr0() {
		return getY()==3 && getX()==7;
	}
	
	private void effect_main_region_StateB_tr0() {
		exitSequence_main_region_StateB();
		enterSequence_main_region__final__default();
	}
	
	/* Entry action for state 'StateB'. */
	private void entryAction_main_region_StateB() {
		setY(3 | 4 ^ 5);
		
		setX(3 | 4 ^ 5 & 1);
	}
	
	/* 'default' enter sequence for state StateB */
	private void enterSequence_main_region_StateB_default() {
		entryAction_main_region_StateB();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_StateB;
	}
	
	/* Default enter sequence for state null */
	private void enterSequence_main_region__final__default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region__final_;
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
	
	/* Default exit sequence for final state. */
	private void exitSequence_main_region__final_() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
		case main_region_StateB:
			exitSequence_main_region_StateB();
			break;
		case main_region__final_:
			exitSequence_main_region__final_();
			break;
		default:
			break;
		}
	}
	
	/* The reactions of state StateB. */
	private void react_main_region_StateB() {
		if (check_main_region_StateB_tr0_tr0()) {
			effect_main_region_StateB_tr0();
		}
	}
	
	/* The reactions of state null. */
	private void react_main_region__final_() {
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_StateB_default();
	}
	
	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
		clearOutEvents();
		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
			switch (stateVector[nextStateIndex]) {
			case main_region_StateB:
				react_main_region_StateB();
				break;
			case main_region__final_:
				react_main_region__final_();
				break;
			default:
				// $NullState$
			}
		}
		clearEvents();
	}
}
