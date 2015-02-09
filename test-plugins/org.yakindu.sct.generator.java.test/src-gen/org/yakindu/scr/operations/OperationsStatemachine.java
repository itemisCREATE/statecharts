package org.yakindu.scr.operations;

public class OperationsStatemachine implements IOperationsStatemachine {

	static {
	}

	private final class SCIInterface1Impl implements SCIInterface1 {

		private SCIInterface1OperationCallback operationCallback;

		public void setSCIInterface1OperationCallback(
				SCIInterface1OperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}

	}

	private SCIInterface1Impl sCIInterface1;
	private final class SCInterfaceImpl implements SCInterface {

		private SCInterfaceOperationCallback operationCallback;

		public void setSCInterfaceOperationCallback(
				SCInterfaceOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}

		private boolean ev;

		public void raiseEv() {
			ev = true;
		}

		public void clearEvents() {
			ev = false;
		}

	}

	private SCInterfaceImpl sCInterface;

	public enum State {
		main_region_B, main_region_C, main_region_D, main_region_A, $NullState$
	};

	private boolean myBool;

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	private InternalOperationCallback operationCallback;

	public OperationsStatemachine() {

		sCIInterface1 = new SCIInterface1Impl();
		sCInterface = new SCInterfaceImpl();
	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		myBool = false;
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
			case main_region_B :
				return stateVector[0] == State.main_region_B;
			case main_region_C :
				return stateVector[0] == State.main_region_C;
			case main_region_D :
				return stateVector[0] == State.main_region_D;
			case main_region_A :
				return stateVector[0] == State.main_region_A;
			default :
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

	private boolean checkMain_region_BTr0() {
		return (sCInterface.ev) && sCInterface.operationCallback.alwaysTrue();
	}

	private boolean checkMain_region_CTr0() {
		return sCInterface.ev;
	}

	private boolean checkMain_region_ATr0() {
		return true;
	}

	private void effectMain_region_BTr0() {
		exitSequenceMain_region_B();

		enterSequenceMain_region_C();
	}

	private void effectMain_region_CTr0() {
		exitSequenceMain_region_C();

		enterSequenceMain_region_D();
	}

	private void effectMain_region_ATr0() {
		exitSequenceMain_region_A();

		enterSequenceMain_region_B();
	}

	/* Entry action for statechart 'Operations'. */
	private void entryAction() {
	}

	/* Entry action for state 'B'. */
	private void entryActionMain_region_B() {
		operationCallback.internalOperation1();

		myBool = operationCallback.internalOperation2(4);

		operationCallback.internalOperation3();

		operationCallback.internalOperation3a(1.0);

		operationCallback.internalOperation4();

		operationCallback.internalOperation4a(5);

		operationCallback.internalOperation5();

		operationCallback.internalOperation5a("");
	}

	/* Entry action for state 'C'. */
	private void entryActionMain_region_C() {
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
	private void entryActionMain_region_D() {
		sCInterface.operationCallback.unnamedInterfaceOperation1();

		sCInterface.operationCallback.unnamedInterfaceOperation2(4);

		sCInterface.operationCallback.unnamedOperation3();

		sCInterface.operationCallback.unnamedOperation3a(1.0);

		sCInterface.operationCallback.unnamedOperation4();

		sCInterface.operationCallback.unnamedOperation4a(5);

		sCInterface.operationCallback.unnamedOperation5();

		sCInterface.operationCallback.unnamedOperation5a("");
	}

	/* Exit action for state 'Operations'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state B */
	private void enterSequenceMain_region_B() {
		entryActionMain_region_B();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_B;
	}

	/* 'default' enter sequence for state C */
	private void enterSequenceMain_region_C() {
		entryActionMain_region_C();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_C;
	}

	/* 'default' enter sequence for state D */
	private void enterSequenceMain_region_D() {
		entryActionMain_region_D();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_D;
	}

	/* 'default' enter sequence for state A */
	private void enterSequenceMain_region_A() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_A;
	}

	/* 'default' enter sequence for region main region */
	private void enterSequenceMain_region() {
		reactOperations_main_region__entry_Default();
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

	/* Default exit sequence for state D */
	private void exitSequenceMain_region_D() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state A */
	private void exitSequenceMain_region_A() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for region main region */
	private void exitSequenceMain_region() {
		switch (stateVector[0]) {
			case main_region_B :
				exitSequenceMain_region_B();
				break;

			case main_region_C :
				exitSequenceMain_region_C();
				break;

			case main_region_D :
				exitSequenceMain_region_D();
				break;

			case main_region_A :
				exitSequenceMain_region_A();
				break;

			default :
				break;
		}
	}

	/* The reactions of state B. */
	private void reactMain_region_B() {
		if (checkMain_region_BTr0()) {
			effectMain_region_BTr0();
		}
	}

	/* The reactions of state C. */
	private void reactMain_region_C() {
		if (checkMain_region_CTr0()) {
			effectMain_region_CTr0();
		}
	}

	/* The reactions of state D. */
	private void reactMain_region_D() {
	}

	/* The reactions of state A. */
	private void reactMain_region_A() {
		effectMain_region_ATr0();
	}

	/* Default react sequence for initial entry  */
	private void reactOperations_main_region__entry_Default() {
		enterSequenceMain_region_A();
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_B :
					reactMain_region_B();
					break;
				case main_region_C :
					reactMain_region_C();
					break;
				case main_region_D :
					reactMain_region_D();
					break;
				case main_region_A :
					reactMain_region_A();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
