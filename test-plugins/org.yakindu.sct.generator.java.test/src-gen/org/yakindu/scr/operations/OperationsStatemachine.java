package org.yakindu.scr.operations;


public class OperationsStatemachine implements IOperationsStatemachine {
	protected class SCIInterface1Impl implements SCIInterface1 {
	
		private SCIInterface1OperationCallback operationCallback;
		
		public void setSCIInterface1OperationCallback(
				SCIInterface1OperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}
	}
	
	protected SCIInterface1Impl sCIInterface1;
	
	protected class SCInterfaceImpl implements SCInterface {
	
		private SCInterfaceOperationCallback operationCallback;
		
		public void setSCInterfaceOperationCallback(
				SCInterfaceOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}
		private boolean ev;
		
		public void raiseEv() {
			ev = true;
		}
		
		protected void clearEvents() {
			ev = false;
		}
	}
	
	protected SCInterfaceImpl sCInterface;
	
	private boolean initialized = false;
	
	public enum State {
		main_region_B,
		main_region_C,
		main_region_D,
		main_region_A,
		$NullState$
	};
	
	private final State[] stateVector = new State[1];
	
	private int nextStateIndex;
	
	private boolean myBool;
	
	protected void setMyBool(boolean value) {
		myBool = value;
	}
	
	protected boolean getMyBool() {
		return myBool;
	}
	
	private InternalOperationCallback operationCallback;
	public OperationsStatemachine() {
		sCIInterface1 = new SCIInterface1Impl();
		sCInterface = new SCInterfaceImpl();
	}
	
	public void init() {
		this.initialized = true;
		if (this.operationCallback == null) {
			throw new IllegalStateException("Operation callback for internal must be set.");	
		}
		if (this.sCIInterface1.operationCallback == null) {
			throw new IllegalStateException("Operation callback for interface sCIInterface1 must be set.");
		}
		
		if (this.sCInterface.operationCallback == null) {
			throw new IllegalStateException("Operation callback for interface sCInterface must be set.");
		}
		
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}
		clearEvents();
		clearOutEvents();
		setMyBool(false);
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
		case main_region_B:
			return stateVector[0] == State.main_region_B;
		case main_region_C:
			return stateVector[0] == State.main_region_C;
		case main_region_D:
			return stateVector[0] == State.main_region_D;
		case main_region_A:
			return stateVector[0] == State.main_region_A;
		default:
			return false;
		}
	}
	
	public SCIInterface1 getSCIInterface1() {
		return sCIInterface1;
	}
	
	public SCInterface getSCInterface() {
		return sCInterface;
	}
	
	public void setInternalOperationCallback(
			InternalOperationCallback operationCallback) {
		this.operationCallback = operationCallback;
	}
	
	public void raiseEv() {
		sCInterface.raiseEv();
	}
	
	/* Entry action for state 'B'. */
	private void entryAction_main_region_B() {
		operationCallback.internalOperation1();
		
		setMyBool(operationCallback.internalOperation2(4));
		
		operationCallback.internalOperation3();
		
		operationCallback.internalOperation3a(1.0);
		
		operationCallback.internalOperation4();
		
		operationCallback.internalOperation4a(5);
		
		operationCallback.internalOperation5();
		
		operationCallback.internalOperation5a("");
	}
	
	/* Entry action for state 'C'. */
	private void entryAction_main_region_C() {
		sCIInterface1.operationCallback.interfaceOperation1();
		
		sCIInterface1.operationCallback.interfaceOperation2(4);
		
		sCIInterface1.operationCallback.interfaceOperation3();
		
		sCIInterface1.operationCallback.interfaceOperation3a(1.0);
		
		sCIInterface1.operationCallback.interfaceOperation4();
		
		sCIInterface1.operationCallback.interfaceOperation4a(5);
		
		sCIInterface1.operationCallback.interfaceOperation5();
		
		sCIInterface1.operationCallback.interfaceOperation5a("");
	}
	
	/* Entry action for state 'D'. */
	private void entryAction_main_region_D() {
		sCInterface.operationCallback.unnamedInterfaceOperation1();
		
		sCInterface.operationCallback.unnamedInterfaceOperation2(4);
		
		sCInterface.operationCallback.unnamedOperation3();
		
		sCInterface.operationCallback.unnamedOperation3a(1.0);
		
		sCInterface.operationCallback.unnamedOperation4();
		
		sCInterface.operationCallback.unnamedOperation4a(5);
		
		sCInterface.operationCallback.unnamedOperation5();
		
		sCInterface.operationCallback.unnamedOperation5a("");
	}
	
	/* 'default' enter sequence for state B */
	private void enterSequence_main_region_B_default() {
		entryAction_main_region_B();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_B;
	}
	
	/* 'default' enter sequence for state C */
	private void enterSequence_main_region_C_default() {
		entryAction_main_region_C();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_C;
	}
	
	/* 'default' enter sequence for state D */
	private void enterSequence_main_region_D_default() {
		entryAction_main_region_D();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_D;
	}
	
	/* 'default' enter sequence for state A */
	private void enterSequence_main_region_A_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_A;
	}
	
	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
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
	
	/* Default exit sequence for state D */
	private void exitSequence_main_region_D() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state A */
	private void exitSequence_main_region_A() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
		case main_region_B:
			exitSequence_main_region_B();
			break;
		case main_region_C:
			exitSequence_main_region_C();
			break;
		case main_region_D:
			exitSequence_main_region_D();
			break;
		case main_region_A:
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
	
	private boolean react(boolean try_transition) {
		return false;
	}
	
	private boolean main_region_B_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (react(try_transition)==false) {
				if ((sCInterface.ev) && (sCInterface.operationCallback.alwaysTrue())) {
					exitSequence_main_region_B();
					enterSequence_main_region_C_default();
				} else {
					did_transition = false;
				}
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
				if (sCInterface.ev) {
					exitSequence_main_region_C();
					enterSequence_main_region_D_default();
				} else {
					did_transition = false;
				}
			}
		}
		if (did_transition==false) {
		}
		return did_transition;
	}
	
	private boolean main_region_D_react(boolean try_transition) {
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
	
	private boolean main_region_A_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (react(try_transition)==false) {
				exitSequence_main_region_A();
				enterSequence_main_region_B_default();
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
			case main_region_B:
				main_region_B_react(true);
				break;
			case main_region_C:
				main_region_C_react(true);
				break;
			case main_region_D:
				main_region_D_react(true);
				break;
			case main_region_A:
				main_region_A_react(true);
				break;
			default:
				// $NullState$
			}
		}
		clearEvents();
	}
}
