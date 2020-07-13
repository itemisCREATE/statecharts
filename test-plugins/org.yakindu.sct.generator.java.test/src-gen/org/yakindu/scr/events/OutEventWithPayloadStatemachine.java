/** Generated by YAKINDU Statechart Tools code generator. */
package org.yakindu.scr.events;

import org.yakindu.sct.rx.Observable;

public class OutEventWithPayloadStatemachine implements IOutEventWithPayloadStatemachine {
	protected class InterfaceImpl implements Interface {
	
		private boolean i;
		
		private long iValue;
		
		
		public void raiseI(final long value) {
			iValue = value;
			i = true;
			runCycle();
		}
		protected long getIValue() {
			if (! i ) 
				throw new IllegalStateException("Illegal event value access. Event I is not raised!");
			return iValue;
		}
		
		private boolean o;
		
		private long oValue;
		
		
		protected void raiseO(long value) {
			oValue = value;
			o = true;
			oObservable.next(value);
		}
		public boolean isRaisedO() {
			return o;
		}
		
		
		public long getOValue() {
			if (! o ) 
				throw new IllegalStateException("Illegal event value access. Event O is not raised!");
			return oValue;
		}
		
		private Observable<Long> oObservable = new Observable<Long>();
		
		public Observable<Long> getO() {
			return oObservable;
		}
		
	}
	
	protected InterfaceImpl defaultInterface;
	
	private boolean initialized = false;
	
	public enum State {
		MAIN_REGION_A,
		$NULLSTATE$
	};
	
	private final State[] stateVector = new State[1];
	
	private int nextStateIndex;
	
	private boolean isExecuting;
	
	protected boolean getIsExecuting() {
		return isExecuting;
	}
	
	protected void setIsExecuting(boolean value) {
		this.isExecuting = value;
	}
	public OutEventWithPayloadStatemachine() {
		defaultInterface = new InterfaceImpl();
	}
	
	public void init() {
		this.initialized = true;
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NULLSTATE$;
		}
		
		clearInEvents();
		clearOutEvents();
		
		
		isExecuting = false;
	}
	
	public void enter() {
		if (!initialized)
			throw new IllegalStateException(
			        "The state machine needs to be initialized first by calling the init() function.");
		
		if (getIsExecuting()) {
			return;
		}
		isExecuting = true;
		enterSequence_main_region_default();
		isExecuting = false;
	}
	
	public void exit() {
		if (getIsExecuting()) {
			return;
		}
		isExecuting = true;
		exitSequence_main_region();
		isExecuting = false;
	}
	
	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
			        "The state machine needs to be initialized first by calling the init() function.");
		
		if (getIsExecuting()) {
			return;
		}
		isExecuting = true;
		clearOutEvents();
		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
			switch (stateVector[nextStateIndex]) {
			case MAIN_REGION_A:
				main_region_A_react(true);
				break;
			default:
				// $NULLSTATE$
			}
		}
		
		clearInEvents();
		isExecuting = false;
	}
	
	/**
	 * @see IStatemachine#isActive()
	 */
	public boolean isActive() {
		return stateVector[0] != State.$NULLSTATE$;
	}
	
	/** 
	* Always returns 'false' since this state machine can never become final.
	*
	* @see IStatemachine#isFinal()
	*/
	public boolean isFinal() {
		return false;
	}
	private void clearOutEvents() {
		defaultInterface.o = false;
	}
	
	private void clearInEvents() {
		defaultInterface.i = false;
	}
	
	/**
	* Returns true if the given state is currently active otherwise false.
	*/
	public boolean isStateActive(State state) {
	
		switch (state) {
		case MAIN_REGION_A:
			return stateVector[0] == State.MAIN_REGION_A;
		default:
			return false;
		}
	}
	
	public Interface getInterface() {
		return defaultInterface;
	}
	
	public void raiseI(long value) {
		defaultInterface.raiseI(value);
	}
	
	public boolean isRaisedO() {
		return defaultInterface.isRaisedO();
	}
	
	public long getOValue() {
		return defaultInterface.getOValue();
	}
	
	/* 'default' enter sequence for state A */
	private void enterSequence_main_region_A_default() {
		nextStateIndex = 0;
		stateVector[0] = State.MAIN_REGION_A;
	}
	
	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}
	
	/* Default exit sequence for state A */
	private void exitSequence_main_region_A() {
		nextStateIndex = 0;
		stateVector[0] = State.$NULLSTATE$;
	}
	
	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
		case MAIN_REGION_A:
			exitSequence_main_region_A();
			break;
		default:
			break;
		}
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_A_default();
	}
	
	private boolean react() {
		return false;
	}
	
	private boolean main_region_A_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			did_transition = false;
		}
		if (did_transition==false) {
			if (defaultInterface.i) {
				defaultInterface.raiseO((defaultInterface.getIValue() * 2));
			}
			did_transition = react();
		}
		return did_transition;
	}
	
}