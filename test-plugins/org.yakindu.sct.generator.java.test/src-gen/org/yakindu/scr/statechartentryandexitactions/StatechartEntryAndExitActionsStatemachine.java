package org.yakindu.scr.statechartentryandexitactions;


public class StatechartEntryAndExitActionsStatemachine implements IStatechartEntryAndExitActionsStatemachine {
	protected class SCInterfaceImpl implements SCInterface {
	
		private long x;
		
		public long getX() {
			return x;
		}
		
		public void setX(long value) {
			this.x = value;
		}
		
		private long y;
		
		public long getY() {
			return y;
		}
		
		public void setY(long value) {
			this.y = value;
		}
		
		private boolean b;
		
		public boolean getB() {
			return b;
		}
		
		public void setB(boolean value) {
			this.b = value;
		}
		
	}
	
	protected SCInterfaceImpl sCInterface;
	
	private boolean initialized = false;
	
	public enum State {
		statechartEntryAndExitActions_main_region_A,
		$NullState$
	};
	
	private final State[] stateVector = new State[1];
	
	private int nextStateIndex;
	
	
	public StatechartEntryAndExitActionsStatemachine() {
		sCInterface = new SCInterfaceImpl();
	}
	
	public void init() {
		this.initialized = true;
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}
		clearEvents();
		clearOutEvents();
		sCInterface.setX(0);
		
		sCInterface.setY(0);
		
		sCInterface.setB(false);
	}
	
	public void enter() {
		if (!initialized) {
			throw new IllegalStateException(
				"The state machine needs to be initialized first by calling the init() function."
			);
		}
		sCInterface.setX(2);
		
		sCInterface.setY(3);
		
		sCInterface.setX(sCInterface.getX() + sCInterface.y);
		
		enterSequence_StatechartEntryAndExitActions_main_region_default();
	}
	
	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
		clearOutEvents();
		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
			switch (stateVector[nextStateIndex]) {
			case statechartEntryAndExitActions_main_region_A:
				statechartEntryAndExitActions_main_region_A_react(true);
				break;
			default:
				// $NullState$
			}
		}
		clearEvents();
	}
	public void exit() {
		exitSequence_StatechartEntryAndExitActions_main_region();
		sCInterface.setX(8);
		
		sCInterface.setY(2);
		
		sCInterface.setX(sCInterface.getX() - sCInterface.y);
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
		case statechartEntryAndExitActions_main_region_A:
			return stateVector[0] == State.statechartEntryAndExitActions_main_region_A;
		default:
			return false;
		}
	}
	
	public SCInterface getSCInterface() {
		return sCInterface;
	}
	
	public long getX() {
		return sCInterface.getX();
	}
	
	public void setX(long value) {
		sCInterface.setX(value);
	}
	
	public long getY() {
		return sCInterface.getY();
	}
	
	public void setY(long value) {
		sCInterface.setY(value);
	}
	
	public boolean getB() {
		return sCInterface.getB();
	}
	
	public void setB(boolean value) {
		sCInterface.setB(value);
	}
	
	/* 'default' enter sequence for state A */
	private void enterSequence_StatechartEntryAndExitActions_main_region_A_default() {
		nextStateIndex = 0;
		stateVector[0] = State.statechartEntryAndExitActions_main_region_A;
	}
	
	/* 'default' enter sequence for region main region */
	private void enterSequence_StatechartEntryAndExitActions_main_region_default() {
		react_StatechartEntryAndExitActions_main_region__entry_Default();
	}
	
	/* Default exit sequence for state A */
	private void exitSequence_StatechartEntryAndExitActions_main_region_A() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for region main region */
	private void exitSequence_StatechartEntryAndExitActions_main_region() {
		switch (stateVector[0]) {
		case statechartEntryAndExitActions_main_region_A:
			exitSequence_StatechartEntryAndExitActions_main_region_A();
			break;
		default:
			break;
		}
	}
	
	/* Default react sequence for initial entry  */
	private void react_StatechartEntryAndExitActions_main_region__entry_Default() {
		enterSequence_StatechartEntryAndExitActions_main_region_A_default();
	}
	
	private boolean react(boolean try_transition) {
		return false;
	}
	
	private boolean statechartEntryAndExitActions_main_region_A_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (react(try_transition)==false) {
				did_transition = false;
			}
		}
		if (did_transition==false) {
		}
		return did_transition;
	}
	
}
