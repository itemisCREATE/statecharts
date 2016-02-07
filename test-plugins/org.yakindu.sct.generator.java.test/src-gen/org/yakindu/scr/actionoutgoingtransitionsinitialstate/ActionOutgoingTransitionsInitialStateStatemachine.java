package org.yakindu.scr.actionoutgoingtransitionsinitialstate;

public class ActionOutgoingTransitionsInitialStateStatemachine
		implements
			IActionOutgoingTransitionsInitialStateStatemachine {

	protected class SCInterfaceImpl implements SCInterface {

		private long internalB;

		public long getInternalB() {
			return internalB;
		}

		public void setInternalB(long value) {
			this.internalB = value;
		}

		private long c;

		public long getC() {
			return c;
		}

		public void setC(long value) {
			this.c = value;
		}

		private long d;

		public long getD() {
			return d;
		}

		public void setD(long value) {
			this.d = value;
		}

	}

	protected SCInterfaceImpl sCInterface;

	private boolean initialized = false;

	public enum State {
		region_1__1, region_2__1, region_2__1_r1__2, $NullState$
	};

	private final State[] stateVector = new State[2];

	private int nextStateIndex;

	private long b;

	protected void setB(long value) {
		b = value;
	}

	protected long getB() {
		return b;
	}

	public ActionOutgoingTransitionsInitialStateStatemachine() {

		sCInterface = new SCInterfaceImpl();
	}

	public void init() {
		this.initialized = true;
		for (int i = 0; i < 2; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCInterface.setInternalB(0);

		sCInterface.setC(0);

		sCInterface.setD(0);

		setB(0);
	}

	public void enter() {
		if (!initialized)
			throw new IllegalStateException(
					"The statemachine needs to be initialized first by calling the init() function.");

		enterSequence_region_1_default();

		enterSequence_region_2_default();
	}

	public void exit() {
		exitSequence_region_1();

		exitSequence_region_2();
	}

	/**
	 * @see IStatemachine#isActive()
	 */
	public boolean isActive() {

		return stateVector[0] != State.$NullState$ || stateVector[1] != State.$NullState$;
	}

	/** 
	* Always returns 'false' since this state machine can never become final.
	*
	 * @see IStatemachine#isFinal() 
	 */
	public boolean isFinal() {
		return false;
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
			case region_1__1 :
				return stateVector[0] == State.region_1__1;
			case region_2__1 :
				return stateVector[1].ordinal() >= State.region_2__1.ordinal()
						&& stateVector[1].ordinal() <= State.region_2__1_r1__2.ordinal();
			case region_2__1_r1__2 :
				return stateVector[1] == State.region_2__1_r1__2;
			default :
				return false;
		}
	}

	public SCInterface getSCInterface() {
		return sCInterface;
	}

	public long getInternalB() {
		return sCInterface.getInternalB();
	}

	public void setInternalB(long value) {
		sCInterface.setInternalB(value);
	}
	public long getC() {
		return sCInterface.getC();
	}

	public void setC(long value) {
		sCInterface.setC(value);
	}
	public long getD() {
		return sCInterface.getD();
	}

	public void setD(long value) {
		sCInterface.setD(value);
	}

	/* Entry action for state '1'. */
	private void entryAction_region_1__1() {
		sCInterface.setInternalB(b);
	}

	/* 'default' enter sequence for state 1 */
	private void enterSequence_region_1__1_default() {
		entryAction_region_1__1();

		nextStateIndex = 0;
		stateVector[0] = State.region_1__1;
	}

	/* 'default' enter sequence for state 1 */
	private void enterSequence_region_2__1_default() {
		enterSequence_region_2__1_r1_default();
	}

	/* 'default' enter sequence for state 2 */
	private void enterSequence_region_2__1_r1__2_default() {
		nextStateIndex = 1;
		stateVector[1] = State.region_2__1_r1__2;
	}

	/* 'default' enter sequence for region region 1 */
	private void enterSequence_region_1_default() {
		react_region_1__entry_Default();
	}

	/* 'default' enter sequence for region region 2 */
	private void enterSequence_region_2_default() {
		react_region_2__entry_Default();
	}

	/* 'default' enter sequence for region r1 */
	private void enterSequence_region_2__1_r1_default() {
		react_region_2__1_r1__entry_Default();
	}

	/* Default exit sequence for state 1 */
	private void exitSequence_region_1__1() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state 2 */
	private void exitSequence_region_2__1_r1__2() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for region region 1 */
	private void exitSequence_region_1() {
		switch (stateVector[0]) {
			case region_1__1 :
				exitSequence_region_1__1();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region region 2 */
	private void exitSequence_region_2() {
		switch (stateVector[1]) {
			case region_2__1_r1__2 :
				exitSequence_region_2__1_r1__2();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region r1 */
	private void exitSequence_region_2__1_r1() {
		switch (stateVector[1]) {
			case region_2__1_r1__2 :
				exitSequence_region_2__1_r1__2();
				break;

			default :
				break;
		}
	}

	/* The reactions of state 1. */
	private void react_region_1__1() {
	}

	/* The reactions of state 2. */
	private void react_region_2__1_r1__2() {
	}

	/* Default react sequence for initial entry  */
	private void react_region_1__entry_Default() {
		enterSequence_region_1__1_default();
	}

	/* Default react sequence for initial entry  */
	private void react_region_2__entry_Default() {
		enterSequence_region_2__1_default();
	}

	/* Default react sequence for initial entry  */
	private void react_region_2__1_r1__entry_Default() {
		enterSequence_region_2__1_r1__2_default();
	}

	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The statemachine needs to be initialized first by calling the init() function.");

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case region_1__1 :
					react_region_1__1();
					break;
				case region_2__1_r1__2 :
					react_region_2__1_r1__2();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
