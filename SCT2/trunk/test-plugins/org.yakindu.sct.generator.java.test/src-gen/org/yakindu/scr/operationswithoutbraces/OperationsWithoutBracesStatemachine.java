package org.yakindu.scr.operationswithoutbraces;

public class OperationsWithoutBracesStatemachine
		implements
			IOperationsWithoutBracesStatemachine {

	static {
	}

	private final class SCInterfaceImpl implements SCInterface {

		private SCInterfaceOperationCallback operationCallback;

		public void setSCInterfaceOperationCallback(
				SCInterfaceOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}

	}

	private SCInterfaceImpl sCInterface;

	public enum State {
		main_region_A, main_region_B, main_region_C, main_region_D, another_region_A, another_region_B, another_region_C, another_region_D, $NullState$
	};

	private final State[] stateVector = new State[2];

	private int nextStateIndex;

	public OperationsWithoutBracesStatemachine() {

		sCInterface = new SCInterfaceImpl();
	}

	public void init() {
		for (int i = 0; i < 2; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

	}

	public void enter() {
		entryAction();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_A;

		nextStateIndex = 1;
		stateVector[1] = State.another_region_A;
	}

	public void exit() {
		switch (stateVector[0]) {
			case main_region_A :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

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

			default :
				break;
		}

		switch (stateVector[1]) {
			case another_region_A :
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
				break;

			case another_region_B :
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
				break;

			case another_region_C :
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
				break;

			case another_region_D :
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
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
			case main_region_A :
				return stateVector[0] == State.main_region_A;
			case main_region_B :
				return stateVector[0] == State.main_region_B;
			case main_region_C :
				return stateVector[0] == State.main_region_C;
			case main_region_D :
				return stateVector[0] == State.main_region_D;
			case another_region_A :
				return stateVector[1] == State.another_region_A;
			case another_region_B :
				return stateVector[1] == State.another_region_B;
			case another_region_C :
				return stateVector[1] == State.another_region_C;
			case another_region_D :
				return stateVector[1] == State.another_region_D;
			default :
				return false;
		}
	}

	public SCInterface getSCInterface() {
		return sCInterface;
	}

	/* Entry action for statechart 'OperationsWithoutBraces'. */
	private void entryAction() {
	}

	/* Exit action for state 'OperationsWithoutBraces'. */
	private void exitAction() {
	}

	/* The reactions of state A. */
	private void reactMain_region_A() {
		if ((true) && !sCInterface.operationCallback.myBoolOp()) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.main_region_B;
		}
	}

	/* The reactions of state B. */
	private void reactMain_region_B() {
		if ((true) && sCInterface.operationCallback.myIntOp() == 0) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.main_region_C;
		}
	}

	/* The reactions of state C. */
	private void reactMain_region_C() {
		if ((true) && sCInterface.operationCallback.myRealOp() == 0.0) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.main_region_D;
		}
	}

	/* The reactions of state D. */
	private void reactMain_region_D() {
	}

	/* The reactions of state A. */
	private void reactAnother_region_A() {
		if ((true) && !sCInterface.operationCallback.myBoolOp()) {
			nextStateIndex = 1;
			stateVector[1] = State.$NullState$;

			nextStateIndex = 1;
			stateVector[1] = State.another_region_B;
		}
	}

	/* The reactions of state B. */
	private void reactAnother_region_B() {
		if ((true) && sCInterface.operationCallback.myIntOp() == 0) {
			nextStateIndex = 1;
			stateVector[1] = State.$NullState$;

			nextStateIndex = 1;
			stateVector[1] = State.another_region_C;
		}
	}

	/* The reactions of state C. */
	private void reactAnother_region_C() {
		if ((true) && sCInterface.operationCallback.myRealOp() == 0.0) {
			nextStateIndex = 1;
			stateVector[1] = State.$NullState$;

			nextStateIndex = 1;
			stateVector[1] = State.another_region_D;
		}
	}

	/* The reactions of state D. */
	private void reactAnother_region_D() {
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_A :
					reactMain_region_A();
					break;
				case main_region_B :
					reactMain_region_B();
					break;
				case main_region_C :
					reactMain_region_C();
					break;
				case main_region_D :
					reactMain_region_D();
					break;
				case another_region_A :
					reactAnother_region_A();
					break;
				case another_region_B :
					reactAnother_region_B();
					break;
				case another_region_C :
					reactAnother_region_C();
					break;
				case another_region_D :
					reactAnother_region_D();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
