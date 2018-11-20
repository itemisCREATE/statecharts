package org.yakindu.src.operationcallbackimpl;

public class OperationCallbackImplStatemachine implements IOperationCallbackImplStatemachine {

	protected class SCInterfaceImpl implements SCInterface {
	
		private SCInterfaceOperationCallback operationCallback;
		
		public void setSCInterfaceOperationCallback(
				SCInterfaceOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}
	}
	
	protected SCInterfaceImpl sCInterface;
	
	protected class SCINamedImpl implements SCINamed {
	
		private SCINamedOperationCallback operationCallback;
		
		public void setSCINamedOperationCallback(
				SCINamedOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}
	}
	
	protected SCINamedImpl sCINamed;
	
	private boolean initialized = false;
	
	public enum State {
		main_region_StateA,
		$NullState$
	};
	
	private final State[] stateVector = new State[1];
	
	private int nextStateIndex;
	
	
	
	private InternalOperationCallback operationCallback;
	public OperationCallbackImplStatemachine() {
		sCInterface = new SCInterfaceImpl();
		sCINamed = new SCINamedImpl();
	}
	
	public void init() {
		this.initialized = true;
		if (this.operationCallback == null) {
			throw new IllegalStateException("Operation callback for internal must be set.");	
		}
		
		if (this.sCInterface.operationCallback == null) {
			throw new IllegalStateException("Operation callback for interface sCInterface must be set.");
		}
		
		if (this.sCINamed.operationCallback == null) {
			throw new IllegalStateException("Operation callback for interface sCINamed must be set.");
		}

		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}
		clearEvents();
		clearOutEvents();
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
	public boolean isStateActive(State mainRegionA) {
	
		switch (mainRegionA) {
		case main_region_StateA:
			return stateVector[0] == State.main_region_StateA;
		default:
			return false;
		}
	}
	
	public SCInterface getSCInterface() {
		return sCInterface;
	}
	
	public SCINamed getSCINamed() {
		return sCINamed;
	}
	
	public void setInternalOperationCallback(
			InternalOperationCallback operationCallback) {
		this.operationCallback = operationCallback;
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
	
	/* Default exit sequence for state StateA */
	private void exitSequence_main_region_StateA() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
		case main_region_StateA:
			exitSequence_main_region_StateA();
			break;
		default:
			break;
		}
	}
	
	/* The reactions of state StateA. */
	private void react_main_region_StateA() {
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_StateA_default();
	}
	
	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
		clearOutEvents();
		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
			switch (stateVector[nextStateIndex]) {
			case main_region_StateA:
				react_main_region_StateA();
				break;
			default:
				// $NullState$
			}
		}
		clearEvents();
	}
}
