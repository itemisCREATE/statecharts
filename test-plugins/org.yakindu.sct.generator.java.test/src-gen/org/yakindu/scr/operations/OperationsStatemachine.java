package org.yakindu.scr.operations;

public class OperationsStatemachine implements IOperationsStatemachine {

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

		nextStateIndex = 0;
		stateVector[0] = State.main_region_A;
	}

	public void exit() {
		switch (stateVector[0]) {
			case main_region_B :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_C :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_D :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_A :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			default :
				break;
		}

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

	/* Entry action for statechart 'Operations'. */
	private void entryAction() {
	}

	/* Exit action for state 'Operations'. */
	private void exitAction() {
	}

	/* The reactions of state B. */
	private void reactMain_region_B() {
		if (sCInterface.ev) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			sCIInterface1.operationCallback.interfaceOperation1();

			sCIInterface1.operationCallback.interfaceOperation2(4);

			nextStateIndex = 0;
			stateVector[0] = State.main_region_C;
		}
	}

	/* The reactions of state C. */
	private void reactMain_region_C() {
		if (sCInterface.ev) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			sCInterface.operationCallback.unnamedInterfaceOperation1();

			sCInterface.operationCallback.unnamedInterfaceOperation2(4);

			nextStateIndex = 0;
			stateVector[0] = State.main_region_D;
		}
	}

	/* The reactions of state D. */
	private void reactMain_region_D() {
	}

	/* The reactions of state A. */
	private void reactMain_region_A() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		operationCallback.internalOperation1();

		myBool = operationCallback.internalOperation2(4);

		nextStateIndex = 0;
		stateVector[0] = State.main_region_B;
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
