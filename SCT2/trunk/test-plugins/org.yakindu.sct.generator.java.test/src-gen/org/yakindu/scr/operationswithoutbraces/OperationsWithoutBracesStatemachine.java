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

		enterSequenceMain_region();

		enterSequenceAnother_region();
	}

	public void exit() {
		exitSequenceMain_region();

		exitSequenceAnother_region();

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

	private boolean checkMain_region_ATr0() {
		return (true) && !sCInterface.operationCallback.myBoolOp();
	}

	private boolean checkMain_region_BTr0() {
		return (true) && sCInterface.operationCallback.myIntOp() == 0;
	}

	private boolean checkMain_region_CTr0() {
		return (true) && sCInterface.operationCallback.myRealOp() == 0.0;
	}

	private boolean checkAnother_region_ATr0() {
		return (true) && !sCInterface.operationCallback.myBoolOp();
	}

	private boolean checkAnother_region_BTr0() {
		return (true) && sCInterface.operationCallback.myIntOp() == 0;
	}

	private boolean checkAnother_region_CTr0() {
		return (true) && sCInterface.operationCallback.myRealOp() == 0.0;
	}

	private void effectMain_region_ATr0() {
		exitSequenceMain_region_A();

		enterSequenceMain_region_B();
	}

	private void effectMain_region_BTr0() {
		exitSequenceMain_region_B();

		enterSequenceMain_region_C();
	}

	private void effectMain_region_CTr0() {
		exitSequenceMain_region_C();

		enterSequenceMain_region_D();
	}

	private void effectAnother_region_ATr0() {
		exitSequenceAnother_region_A();

		enterSequenceAnother_region_B();
	}

	private void effectAnother_region_BTr0() {
		exitSequenceAnother_region_B();

		enterSequenceAnother_region_C();
	}

	private void effectAnother_region_CTr0() {
		exitSequenceAnother_region_C();

		enterSequenceAnother_region_D();
	}

	/* Entry action for statechart 'OperationsWithoutBraces'. */
	private void entryAction() {
	}

	/* Exit action for state 'OperationsWithoutBraces'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state A */
	private void enterSequenceMain_region_A() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_A;
	}

	/* 'default' enter sequence for state B */
	private void enterSequenceMain_region_B() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_B;
	}

	/* 'default' enter sequence for state C */
	private void enterSequenceMain_region_C() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_C;
	}

	/* 'default' enter sequence for state D */
	private void enterSequenceMain_region_D() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_D;
	}

	/* 'default' enter sequence for state A */
	private void enterSequenceAnother_region_A() {
		nextStateIndex = 1;
		stateVector[1] = State.another_region_A;
	}

	/* 'default' enter sequence for state B */
	private void enterSequenceAnother_region_B() {
		nextStateIndex = 1;
		stateVector[1] = State.another_region_B;
	}

	/* 'default' enter sequence for state C */
	private void enterSequenceAnother_region_C() {
		nextStateIndex = 1;
		stateVector[1] = State.another_region_C;
	}

	/* 'default' enter sequence for state D */
	private void enterSequenceAnother_region_D() {
		nextStateIndex = 1;
		stateVector[1] = State.another_region_D;
	}

	/* 'default' enter sequence for region main region */
	private void enterSequenceMain_region() {
		reactOperationsWithoutBraces_main_region__entry_Default();
	}

	/* 'default' enter sequence for region another region */
	private void enterSequenceAnother_region() {
		reactOperationsWithoutBraces_another_region__entry_Default();
	}

	/* Default exit sequence for state A */
	private void exitSequenceMain_region_A() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
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
	private void exitSequenceAnother_region_A() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state B */
	private void exitSequenceAnother_region_B() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state C */
	private void exitSequenceAnother_region_C() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state D */
	private void exitSequenceAnother_region_D() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for region main region */
	private void exitSequenceMain_region() {
		switch (stateVector[0]) {
			case main_region_A :
				exitSequenceMain_region_A();
				break;

			case main_region_B :
				exitSequenceMain_region_B();
				break;

			case main_region_C :
				exitSequenceMain_region_C();
				break;

			case main_region_D :
				exitSequenceMain_region_D();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region another region */
	private void exitSequenceAnother_region() {
		switch (stateVector[1]) {
			case another_region_A :
				exitSequenceAnother_region_A();
				break;

			case another_region_B :
				exitSequenceAnother_region_B();
				break;

			case another_region_C :
				exitSequenceAnother_region_C();
				break;

			case another_region_D :
				exitSequenceAnother_region_D();
				break;

			default :
				break;
		}
	}

	/* The reactions of state A. */
	private void reactMain_region_A() {
		if (checkMain_region_ATr0()) {
			effectMain_region_ATr0();
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
	private void reactAnother_region_A() {
		if (checkAnother_region_ATr0()) {
			effectAnother_region_ATr0();
		}
	}

	/* The reactions of state B. */
	private void reactAnother_region_B() {
		if (checkAnother_region_BTr0()) {
			effectAnother_region_BTr0();
		}
	}

	/* The reactions of state C. */
	private void reactAnother_region_C() {
		if (checkAnother_region_CTr0()) {
			effectAnother_region_CTr0();
		}
	}

	/* The reactions of state D. */
	private void reactAnother_region_D() {
	}

	/* Default react sequence for initial entry  */
	private void reactOperationsWithoutBraces_main_region__entry_Default() {
		enterSequenceMain_region_A();
	}

	/* Default react sequence for initial entry  */
	private void reactOperationsWithoutBraces_another_region__entry_Default() {
		enterSequenceAnother_region_A();
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
