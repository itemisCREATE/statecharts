package org.yakindu.scr.entryexitselftransition;

public class EntryExitSelfTransitionStatemachine
		implements
			IEntryExitSelfTransitionStatemachine {

	private final class SCInterfaceImpl implements SCInterface {

		private boolean e;

		public void raiseE() {
			e = true;
		}

		private boolean e1;

		public void raiseE1() {
			e1 = true;
		}

		private long exits;

		public long getExits() {
			return exits;
		}

		public void setExits(long value) {
			this.exits = value;
		}

		private long entries;

		public long getEntries() {
			return entries;
		}

		public void setEntries(long value) {
			this.entries = value;
		}

		public void clearEvents() {
			e = false;
			e1 = false;
		}

	}

	private SCInterfaceImpl sCInterface;

	public enum State {
		main_region_A, main_region_A__region0_B, main_region_A__region0_C, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public EntryExitSelfTransitionStatemachine() {

		sCInterface = new SCInterfaceImpl();
	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCInterface.exits = 0;

		sCInterface.entries = 0;
	}

	public void enter() {
		entryAction();

		sCInterface.entries += 1;

		nextStateIndex = 0;
		stateVector[0] = State.main_region_A__region0_B;
	}

	public void exit() {
		switch (stateVector[0]) {
			case main_region_A__region0_B :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				sCInterface.exits += 1;
				break;

			case main_region_A__region0_C :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				sCInterface.exits += 1;
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
				return stateVector[0].ordinal() >= State.main_region_A
						.ordinal()
						&& stateVector[0].ordinal() <= State.main_region_A__region0_C
								.ordinal();
			case main_region_A__region0_B :
				return stateVector[0] == State.main_region_A__region0_B;
			case main_region_A__region0_C :
				return stateVector[0] == State.main_region_A__region0_C;
			default :
				return false;
		}
	}

	public SCInterface getSCInterface() {
		return sCInterface;
	}

	public void raiseE() {
		sCInterface.raiseE();
	}
	public void raiseE1() {
		sCInterface.raiseE1();
	}

	public long getExits() {
		return sCInterface.getExits();
	}

	public void setExits(long value) {
		sCInterface.setExits(value);
	}
	public long getEntries() {
		return sCInterface.getEntries();
	}

	public void setEntries(long value) {
		sCInterface.setEntries(value);
	}

	/* Entry action for statechart 'EntryExitSelfTransition'. */
	private void entryAction() {
	}

	/* Exit action for state 'EntryExitSelfTransition'. */
	private void exitAction() {
	}

	/* The reactions of state B. */
	private void reactMain_region_A_region0_B() {
		if (sCInterface.e) {
			switch (stateVector[0]) {
				case main_region_A__region0_B :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_A__region0_C :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				default :
					break;
			}

			sCInterface.exits += 1;

			sCInterface.entries += 1;

			nextStateIndex = 0;
			stateVector[0] = State.main_region_A__region0_C;
		} else {
			if (sCInterface.e1) {
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				nextStateIndex = 0;
				stateVector[0] = State.main_region_A__region0_C;
			}
		}
	}

	/* The reactions of state C. */
	private void reactMain_region_A_region0_C() {
		if (sCInterface.e) {
			switch (stateVector[0]) {
				case main_region_A__region0_B :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_A__region0_C :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				default :
					break;
			}

			sCInterface.exits += 1;

			sCInterface.entries += 1;

			nextStateIndex = 0;
			stateVector[0] = State.main_region_A__region0_C;
		} else {
			if (sCInterface.e1) {
				switch (stateVector[0]) {
					case main_region_A__region0_B :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					case main_region_A__region0_C :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					default :
						break;
				}

				sCInterface.exits += 1;

				sCInterface.entries += 1;

				nextStateIndex = 0;
				stateVector[0] = State.main_region_A__region0_B;
			}
		}
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_A__region0_B :
					reactMain_region_A_region0_B();
					break;
				case main_region_A__region0_C :
					reactMain_region_A_region0_C();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
