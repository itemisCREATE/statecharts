package org.yakindu.scr.logicaland;

public class LogicalAndStatemachine implements ILogicalAndStatemachine {

	private final class SCInterfaceImpl implements SCInterface {

		private long x;

		public long getX() {
			return x;
		}

		public void setX(long value) {
			this.x = value;
		}

		private boolean b;

		public boolean getB() {
			return b;
		}

		public void setB(boolean value) {
			this.b = value;
		}

	}

	private SCInterfaceImpl sCInterface;

	public enum State {
		main_region_A, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public LogicalAndStatemachine() {

		sCInterface = new SCInterfaceImpl();
	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCInterface.x = 1;

		sCInterface.b = false;
	}

	public void enter() {
		entryAction();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_A;
	}

	public void exit() {
		switch (stateVector[0]) {
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
			default :
				return false;
		}
	}

	public SCInterface getSCInterface() {
		return sCInterface;
	}

	public long getX() {
		return sCInterface.getX();
	}

	public void setX(long value) {
		sCInterface.setX(value);
	}
	public boolean getB() {
		return sCInterface.getB();
	}

	public void setB(boolean value) {
		sCInterface.setB(value);
	}

	/* Entry action for statechart 'LogicalAnd'. */
	private void entryAction() {
	}

	/* Exit action for state 'LogicalAnd'. */
	private void exitAction() {
	}

	/* The reactions of state A. */
	private void reactMain_region_A() {
		if (sCInterface.x == 1) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			sCInterface.b = ((sCInterface.x += 1) == 2 && (sCInterface.x *= 2) == 4);

			nextStateIndex = 0;
			stateVector[0] = State.main_region_A;
		}
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
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
