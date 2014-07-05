package org.yakindu.scr.alwaysoncycle;

public class AlwaysOncycleStatemachine implements IAlwaysOncycleStatemachine {

	private final class SCInterfaceImpl implements SCInterface {

		private long value;

		public long getValue() {
			return value;
		}

		public void setValue(long value) {
			this.value = value;
		}

		private boolean v2;

		public boolean getV2() {
			return v2;
		}

		public void setV2(boolean value) {
			this.v2 = value;
		}

	}

	private SCInterfaceImpl sCInterface;

	public enum State {
		main_region_StateA, main_region_StateB, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public AlwaysOncycleStatemachine() {

		sCInterface = new SCInterfaceImpl();
	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCInterface.value = 0;

		sCInterface.v2 = false;
	}

	public void enter() {
		entryAction();

		sCInterface.value = 0;

		nextStateIndex = 0;
		stateVector[0] = State.main_region_StateA;
	}

	public void exit() {
		switch (stateVector[0]) {
			case main_region_StateA :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				sCInterface.value = 0;
				break;

			case main_region_StateB :
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
			case main_region_StateA :
				return stateVector[0] == State.main_region_StateA;
			case main_region_StateB :
				return stateVector[0] == State.main_region_StateB;
			default :
				return false;
		}
	}

	public SCInterface getSCInterface() {
		return sCInterface;
	}

	public long getValue() {
		return sCInterface.getValue();
	}

	public void setValue(long value) {
		sCInterface.setValue(value);
	}
	public boolean getV2() {
		return sCInterface.getV2();
	}

	public void setV2(boolean value) {
		sCInterface.setV2(value);
	}

	/* Entry action for statechart 'AlwaysOncycle'. */
	private void entryAction() {
	}

	/* Exit action for state 'AlwaysOncycle'. */
	private void exitAction() {
	}

	/* The reactions of state StateA. */
	private void reactMain_region_StateA() {
		if (sCInterface.value == 5) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			sCInterface.value = 0;

			nextStateIndex = 0;
			stateVector[0] = State.main_region_StateB;
		} else {
			sCInterface.value += 1;
		}
	}

	/* The reactions of state StateB. */
	private void reactMain_region_StateB() {
		if (sCInterface.value == 5) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			sCInterface.value = 0;

			nextStateIndex = 0;
			stateVector[0] = State.main_region_StateA;
		} else {
			sCInterface.value += 1;
		}
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
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
