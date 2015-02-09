package org.yakindu.scr.raiseevent;

public class RaiseEventStatemachine implements IRaiseEventStatemachine {

	static {
	}

	private final class SCInterfaceImpl implements SCInterface {

		private boolean e1;

		public boolean isRaisedE1() {
			return e1;
		}

		private void raiseE1() {
			e1 = true;
		}

		private boolean e2;

		public void raiseE2() {
			e2 = true;
		}

		public void clearEvents() {
			e2 = false;
		}

		public void clearOutEvents() {
			e1 = false;
		}
	}

	private SCInterfaceImpl sCInterface;

	public enum State {
		main_region_StateA, main_region_StateB, second_region_SateA, second_region_StateB, $NullState$
	};

	private final State[] stateVector = new State[2];

	private int nextStateIndex;

	public RaiseEventStatemachine() {

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

		enterSequenceSecond_region();
	}

	public void exit() {
		exitSequenceMain_region();

		exitSequenceSecond_region();

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
		sCInterface.clearOutEvents();
	}

	/**
	 * Returns true if the given state is currently active otherwise false.
	 */
	public boolean isStateActive(State state) {
		switch (state) {
			case main_region_StateA :
				return stateVector[0] == State.main_region_StateA;
			case main_region_StateB :
				return stateVector[0] == State.main_region_StateB;
			case second_region_SateA :
				return stateVector[1] == State.second_region_SateA;
			case second_region_StateB :
				return stateVector[1] == State.second_region_StateB;
			default :
				return false;
		}
	}

	public SCInterface getSCInterface() {
		return sCInterface;
	}

	public boolean isRaisedE1() {
		return sCInterface.isRaisedE1();
	}
	public void raiseE2() {
		sCInterface.raiseE2();
	}

	private boolean checkMain_region_StateATr0() {
		return sCInterface.e2;
	}

	private boolean checkSecond_region_SateATr0() {
		return sCInterface.e1;
	}

	private void effectMain_region_StateATr0() {
		exitSequenceMain_region_StateA();

		enterSequenceMain_region_StateB();
	}

	private void effectSecond_region_SateATr0() {
		exitSequenceSecond_region_SateA();

		enterSequenceSecond_region_StateB();
	}

	/* Entry action for statechart 'RaiseEvent'. */
	private void entryAction() {
	}

	/* Entry action for state 'StateB'. */
	private void entryActionMain_region_StateB() {
		sCInterface.raiseE1();
	}

	/* Exit action for state 'RaiseEvent'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state StateA */
	private void enterSequenceMain_region_StateA() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_StateA;
	}

	/* 'default' enter sequence for state StateB */
	private void enterSequenceMain_region_StateB() {
		entryActionMain_region_StateB();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_StateB;
	}

	/* 'default' enter sequence for state SateA */
	private void enterSequenceSecond_region_SateA() {
		nextStateIndex = 1;
		stateVector[1] = State.second_region_SateA;
	}

	/* 'default' enter sequence for state StateB */
	private void enterSequenceSecond_region_StateB() {
		nextStateIndex = 1;
		stateVector[1] = State.second_region_StateB;
	}

	/* 'default' enter sequence for region main region */
	private void enterSequenceMain_region() {
		reactRaiseEvent_main_region__entry_Default();
	}

	/* 'default' enter sequence for region second region */
	private void enterSequenceSecond_region() {
		reactRaiseEvent_second_region__entry_Default();
	}

	/* Default exit sequence for state StateA */
	private void exitSequenceMain_region_StateA() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state StateB */
	private void exitSequenceMain_region_StateB() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state SateA */
	private void exitSequenceSecond_region_SateA() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state StateB */
	private void exitSequenceSecond_region_StateB() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for region main region */
	private void exitSequenceMain_region() {
		switch (stateVector[0]) {
			case main_region_StateA :
				exitSequenceMain_region_StateA();
				break;

			case main_region_StateB :
				exitSequenceMain_region_StateB();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region second region */
	private void exitSequenceSecond_region() {
		switch (stateVector[1]) {
			case second_region_SateA :
				exitSequenceSecond_region_SateA();
				break;

			case second_region_StateB :
				exitSequenceSecond_region_StateB();
				break;

			default :
				break;
		}
	}

	/* The reactions of state StateA. */
	private void reactMain_region_StateA() {
		if (checkMain_region_StateATr0()) {
			effectMain_region_StateATr0();
		}
	}

	/* The reactions of state StateB. */
	private void reactMain_region_StateB() {
	}

	/* The reactions of state SateA. */
	private void reactSecond_region_SateA() {
		if (checkSecond_region_SateATr0()) {
			effectSecond_region_SateATr0();
		}
	}

	/* The reactions of state StateB. */
	private void reactSecond_region_StateB() {
	}

	/* Default react sequence for initial entry  */
	private void reactRaiseEvent_main_region__entry_Default() {
		enterSequenceMain_region_StateA();
	}

	/* Default react sequence for initial entry  */
	private void reactRaiseEvent_second_region__entry_Default() {
		enterSequenceSecond_region_SateA();
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_StateA :
					reactMain_region_StateA();
					break;
				case main_region_StateB :
					reactMain_region_StateB();
					break;
				case second_region_SateA :
					reactSecond_region_SateA();
					break;
				case second_region_StateB :
					reactSecond_region_StateB();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
