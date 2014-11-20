package org.yakindu.scr.constants;

public class ConstantsStatemachine implements IConstantsStatemachine {

	private final class SCInterfaceImpl implements SCInterface {

		private boolean e;

		public void raiseE() {
			e = true;
		}

		public static final long x;

		public static final long y;

		private long result;
		public long getResult() {
			return result;
		}

		public void setResult(long value) {
			this.result = value;
		}

		public void clearEvents() {
			e = false;
		}

	}

	private SCInterfaceImpl sCInterface;
	private final class SCINamedImpl implements SCINamed {

		public static final String y;

		public static final long two;

	}

	private SCINamedImpl sCINamed;

	public enum State {
		main_region_A, main_region_B, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	static {
		sCInterface.x = 10;

		sCInterface.y = sCInterface.x * 2;

		sCINamed.y = "Hello World";

		sCINamed.two = 2;
	}

	public ConstantsStatemachine() {

		sCInterface = new SCInterfaceImpl();
		sCINamed = new SCINamedImpl();
	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCInterface.result = 0;
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

			case main_region_B :
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
			case main_region_A :
				return stateVector[0] == State.main_region_A;
			case main_region_B :
				return stateVector[0] == State.main_region_B;
			default :
				return false;
		}
	}

	public SCInterface getSCInterface() {
		return sCInterface;
	}
	public SCINamed getSCINamed() {
		return sCINamed;
	}

	public void raiseE() {
		sCInterface.raiseE();
	}

	public long getX() {
		return sCInterface.getX();
	}

	public void setX(long value) {
		sCInterface.setX(value);
	}
	public long getY() {
		return sCInterface.getY();
	}

	public void setY(long value) {
		sCInterface.setY(value);
	}
	public long getResult() {
		return sCInterface.getResult();
	}

	public void setResult(long value) {
		sCInterface.setResult(value);
	}

	/* Entry action for statechart 'Constants'. */
	private void entryAction() {
	}

	/* Exit action for state 'Constants'. */
	private void exitAction() {
	}

	/* The reactions of state A. */
	private void reactMain_region_A() {
		if (sCInterface.e) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			sCInterface.result = sCINamed.two * sCInterface.x;

			nextStateIndex = 0;
			stateVector[0] = State.main_region_B;
		}
	}

	/* The reactions of state B. */
	private void reactMain_region_B() {
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
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
