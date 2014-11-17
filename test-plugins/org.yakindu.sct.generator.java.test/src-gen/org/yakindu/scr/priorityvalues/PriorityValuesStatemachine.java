package org.yakindu.scr.priorityvalues;

public class PriorityValuesStatemachine implements IPriorityValuesStatemachine {

	private final class SCInterfaceImpl implements SCInterface {

		private boolean event1;

		public void raiseEvent1() {
			event1 = true;
		}

		private boolean event2;

		public void raiseEvent2() {
			event2 = true;
		}

		public void clearEvents() {
			event1 = false;
			event2 = false;
		}

	}

	private SCInterfaceImpl sCInterface;

	public enum State {
		someRegion_A, someRegion_B, main_region_A, main_region_B, main_region_C, main_region_D, main_region_E, $NullState$
	};

	private final State[] stateVector = new State[2];

	private int nextStateIndex;

	public PriorityValuesStatemachine() {

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
		stateVector[0] = State.someRegion_A;

		nextStateIndex = 1;
		stateVector[1] = State.main_region_A;
	}

	public void exit() {
		switch (stateVector[0]) {
			case someRegion_A :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case someRegion_B :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			default :
				break;
		}

		switch (stateVector[1]) {
			case main_region_A :
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
				break;

			case main_region_B :
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
				break;

			case main_region_C :
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
				break;

			case main_region_D :
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
				break;

			case main_region_E :
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
			case someRegion_A :
				return stateVector[0] == State.someRegion_A;
			case someRegion_B :
				return stateVector[0] == State.someRegion_B;
			case main_region_A :
				return stateVector[1] == State.main_region_A;
			case main_region_B :
				return stateVector[1] == State.main_region_B;
			case main_region_C :
				return stateVector[1] == State.main_region_C;
			case main_region_D :
				return stateVector[1] == State.main_region_D;
			case main_region_E :
				return stateVector[1] == State.main_region_E;
			default :
				return false;
		}
	}

	public SCInterface getSCInterface() {
		return sCInterface;
	}

	public void raiseEvent1() {
		sCInterface.raiseEvent1();
	}
	public void raiseEvent2() {
		sCInterface.raiseEvent2();
	}

	/* Entry action for statechart 'PriorityValues'. */
	private void entryAction() {
	}

	/* Exit action for state 'PriorityValues'. */
	private void exitAction() {
	}

	/* The reactions of state A. */
	private void reactSomeRegion_A() {
		if (sCInterface.event2) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.someRegion_B;
		}
	}

	/* The reactions of state B. */
	private void reactSomeRegion_B() {
	}

	/* The reactions of state A. */
	private void reactMain_region_A() {
		if (sCInterface.event1) {
			nextStateIndex = 1;
			stateVector[1] = State.$NullState$;

			nextStateIndex = 1;
			stateVector[1] = State.main_region_C;
		} else {
			if (sCInterface.event1) {
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;

				nextStateIndex = 1;
				stateVector[1] = State.main_region_B;
			} else {
				if (sCInterface.event1) {
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;

					nextStateIndex = 1;
					stateVector[1] = State.main_region_D;
				} else {
					if ((sCInterface.event2)
							&& !isStateActive(State.someRegion_B)) {
						nextStateIndex = 1;
						stateVector[1] = State.$NullState$;

						nextStateIndex = 1;
						stateVector[1] = State.main_region_E;
					}
				}
			}
		}
	}

	/* The reactions of state B. */
	private void reactMain_region_B() {
	}

	/* The reactions of state C. */
	private void reactMain_region_C() {
	}

	/* The reactions of state D. */
	private void reactMain_region_D() {
	}

	/* The reactions of state E. */
	private void reactMain_region_E() {
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case someRegion_A :
					reactSomeRegion_A();
					break;
				case someRegion_B :
					reactSomeRegion_B();
					break;
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
				case main_region_E :
					reactMain_region_E();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
