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

		enterSequence_main_region_default();

		enterSequence_another_region_default();
	}

	public void exit() {
		exitSequence_main_region();

		exitSequence_another_region();

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

	private boolean check_main_region_A_tr0() {
		return (true) && !sCInterface.operationCallback.myBoolOp();
	}

	private boolean check_main_region_B_tr0() {
		return (true) && sCInterface.operationCallback.myIntOp() == 0;
	}

	private boolean check_main_region_C_tr0() {
		return (true) && sCInterface.operationCallback.myRealOp() == 0.0;
	}

	private boolean check_another_region_A_tr0() {
		return (true) && !sCInterface.operationCallback.myBoolOp();
	}

	private boolean check_another_region_B_tr0() {
		return (true) && sCInterface.operationCallback.myIntOp() == 0;
	}

	private boolean check_another_region_C_tr0() {
		return (true) && sCInterface.operationCallback.myRealOp() == 0.0;
	}

	private void effect_main_region_A_tr0() {
		exitSequence_main_region_A();

		enterSequence_main_region_B_default();
	}

	private void effect_main_region_B_tr0() {
		exitSequence_main_region_B();

		enterSequence_main_region_C_default();
	}

	private void effect_main_region_C_tr0() {
		exitSequence_main_region_C();

		enterSequence_main_region_D_default();
	}

	private void effect_another_region_A_tr0() {
		exitSequence_another_region_A();

		enterSequence_another_region_B_default();
	}

	private void effect_another_region_B_tr0() {
		exitSequence_another_region_B();

		enterSequence_another_region_C_default();
	}

	private void effect_another_region_C_tr0() {
		exitSequence_another_region_C();

		enterSequence_another_region_D_default();
	}

	/* Entry action for statechart 'OperationsWithoutBraces'. */
	private void entryAction() {
	}

	/* Exit action for state 'OperationsWithoutBraces'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state A */
	private void enterSequence_main_region_A_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_A;
	}

	/* 'default' enter sequence for state B */
	private void enterSequence_main_region_B_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_B;
	}

	/* 'default' enter sequence for state C */
	private void enterSequence_main_region_C_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_C;
	}

	/* 'default' enter sequence for state D */
	private void enterSequence_main_region_D_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_D;
	}

	/* 'default' enter sequence for state A */
	private void enterSequence_another_region_A_default() {
		nextStateIndex = 1;
		stateVector[1] = State.another_region_A;
	}

	/* 'default' enter sequence for state B */
	private void enterSequence_another_region_B_default() {
		nextStateIndex = 1;
		stateVector[1] = State.another_region_B;
	}

	/* 'default' enter sequence for state C */
	private void enterSequence_another_region_C_default() {
		nextStateIndex = 1;
		stateVector[1] = State.another_region_C;
	}

	/* 'default' enter sequence for state D */
	private void enterSequence_another_region_D_default() {
		nextStateIndex = 1;
		stateVector[1] = State.another_region_D;
	}

	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}

	/* 'default' enter sequence for region another region */
	private void enterSequence_another_region_default() {
		react_another_region__entry_Default();
	}

	/* Default exit sequence for state A */
	private void exitSequence_main_region_A() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
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
	private void exitSequence_another_region_A() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state B */
	private void exitSequence_another_region_B() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state C */
	private void exitSequence_another_region_C() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state D */
	private void exitSequence_another_region_D() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
			case main_region_A :
				exitSequence_main_region_A();
				break;

			case main_region_B :
				exitSequence_main_region_B();
				break;

			case main_region_C :
				exitSequence_main_region_C();
				break;

			case main_region_D :
				exitSequence_main_region_D();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region another region */
	private void exitSequence_another_region() {
		switch (stateVector[1]) {
			case another_region_A :
				exitSequence_another_region_A();
				break;

			case another_region_B :
				exitSequence_another_region_B();
				break;

			case another_region_C :
				exitSequence_another_region_C();
				break;

			case another_region_D :
				exitSequence_another_region_D();
				break;

			default :
				break;
		}
	}

	/* The reactions of state A. */
	private void react_main_region_A() {
		if (check_main_region_A_tr0()) {
			effect_main_region_A_tr0();
		}
	}

	/* The reactions of state B. */
	private void react_main_region_B() {
		if (check_main_region_B_tr0()) {
			effect_main_region_B_tr0();
		}
	}

	/* The reactions of state C. */
	private void react_main_region_C() {
		if (check_main_region_C_tr0()) {
			effect_main_region_C_tr0();
		}
	}

	/* The reactions of state D. */
	private void react_main_region_D() {
	}

	/* The reactions of state A. */
	private void react_another_region_A() {
		if (check_another_region_A_tr0()) {
			effect_another_region_A_tr0();
		}
	}

	/* The reactions of state B. */
	private void react_another_region_B() {
		if (check_another_region_B_tr0()) {
			effect_another_region_B_tr0();
		}
	}

	/* The reactions of state C. */
	private void react_another_region_C() {
		if (check_another_region_C_tr0()) {
			effect_another_region_C_tr0();
		}
	}

	/* The reactions of state D. */
	private void react_another_region_D() {
	}

	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_A_default();
	}

	/* Default react sequence for initial entry  */
	private void react_another_region__entry_Default() {
		enterSequence_another_region_A_default();
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_A :
					react_main_region_A();
					break;
				case main_region_B :
					react_main_region_B();
					break;
				case main_region_C :
					react_main_region_C();
					break;
				case main_region_D :
					react_main_region_D();
					break;
				case another_region_A :
					react_another_region_A();
					break;
				case another_region_B :
					react_another_region_B();
					break;
				case another_region_C :
					react_another_region_C();
					break;
				case another_region_D :
					react_another_region_D();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
