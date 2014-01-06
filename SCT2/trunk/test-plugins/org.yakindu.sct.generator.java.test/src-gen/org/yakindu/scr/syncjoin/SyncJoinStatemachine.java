package org.yakindu.scr.syncjoin;

public class SyncJoinStatemachine implements ISyncJoinStatemachine {

	private final class SCInterfaceImpl implements SCInterface {

		private boolean e;

		public void raiseE() {
			e = true;
		}

		private boolean f;

		public void raiseF() {
			f = true;
		}

		private boolean jc;

		public void raiseJc() {
			jc = true;
		}

		private boolean jd;

		public void raiseJd() {
			jd = true;
		}

		private long x;

		public long getX() {
			return x;
		}

		public void setX(long value) {
			this.x = value;
		}

		public void clearEvents() {
			e = false;
			f = false;
			jc = false;
			jd = false;
		}

	}

	private SCInterfaceImpl sCInterface;

	public enum State {
		main_region_A, main_region_B, main_region_B_r1_C1, main_region_B_r1_C2, main_region_B_r2_D1, main_region_B_r2_D2, $NullState$
	};

	private final State[] stateVector = new State[2];

	private int nextStateIndex;

	public SyncJoinStatemachine() {

		sCInterface = new SCInterfaceImpl();
	}

	public void init() {
		for (int i = 0; i < 2; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCInterface.x = 0;
	}

	public void enter() {
		entryAction();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_B_r1_C1;

		nextStateIndex = 1;
		stateVector[1] = State.main_region_B_r2_D1;
	}

	public void exit() {
		switch (stateVector[0]) {
			case main_region_A :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_B_r1_C1 :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_B_r1_C2 :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			default :
				break;
		}

		switch (stateVector[1]) {
			case main_region_B_r2_D1 :
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
				break;

			case main_region_B_r2_D2 :
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
			case main_region_A :
				return stateVector[0] == State.main_region_A;
			case main_region_B :
				return stateVector[0].ordinal() >= State.main_region_B
						.ordinal()
						&& stateVector[0].ordinal() <= State.main_region_B_r2_D2
								.ordinal();
			case main_region_B_r1_C1 :
				return stateVector[0] == State.main_region_B_r1_C1;
			case main_region_B_r1_C2 :
				return stateVector[0] == State.main_region_B_r1_C2;
			case main_region_B_r2_D1 :
				return stateVector[1] == State.main_region_B_r2_D1;
			case main_region_B_r2_D2 :
				return stateVector[1] == State.main_region_B_r2_D2;
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
	public void raiseF() {
		sCInterface.raiseF();
	}
	public void raiseJc() {
		sCInterface.raiseJc();
	}
	public void raiseJd() {
		sCInterface.raiseJd();
	}

	public long getX() {
		return sCInterface.getX();
	}

	public void setX(long value) {
		sCInterface.setX(value);
	}

	/* Entry action for statechart 'SyncJoin'. */
	private void entryAction() {
	}

	/* Exit action for state 'SyncJoin'. */
	private void exitAction() {
	}

	/* The reactions of state A. */
	private void reactMain_region_A() {
		if (sCInterface.e || sCInterface.f) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.main_region_B_r1_C1;

			nextStateIndex = 1;
			stateVector[1] = State.main_region_B_r2_D1;
		}
	}

	/* The reactions of state C1. */
	private void reactMain_region_B_r1_C1() {
		if (sCInterface.e) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.main_region_B_r1_C2;
		}
	}

	/* The reactions of state C2. */
	private void reactMain_region_B_r1_C2() {
		if (sCInterface.jc && isStateActive(State.main_region_B_r2_D2)
				&& sCInterface.jd) {
			switch (stateVector[0]) {
				case main_region_B_r1_C1 :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_B_r1_C2 :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				default :
					break;
			}

			switch (stateVector[1]) {
				case main_region_B_r2_D1 :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				case main_region_B_r2_D2 :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				default :
					break;
			}

			reactSyncJoin_main_region__sync0();
		}
	}

	/* The reactions of state D1. */
	private void reactMain_region_B_r2_D1() {
		if (sCInterface.f) {
			nextStateIndex = 1;
			stateVector[1] = State.$NullState$;

			nextStateIndex = 1;
			stateVector[1] = State.main_region_B_r2_D2;
		}
	}

	/* The reactions of state D2. */
	private void reactMain_region_B_r2_D2() {
		if (sCInterface.jd && isStateActive(State.main_region_B_r1_C2)
				&& sCInterface.jc) {
			switch (stateVector[0]) {
				case main_region_B_r1_C1 :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_B_r1_C2 :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				default :
					break;
			}

			switch (stateVector[1]) {
				case main_region_B_r2_D1 :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				case main_region_B_r2_D2 :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				default :
					break;
			}

			reactSyncJoin_main_region__sync0();
		}
	}

	/* The reactions of state null. */
	private void reactSyncJoin_main_region__sync0() {
		sCInterface.x += 1;

		nextStateIndex = 0;
		stateVector[0] = State.main_region_A;
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_A :
					reactMain_region_A();
					break;
				case main_region_B_r1_C1 :
					reactMain_region_B_r1_C1();
					break;
				case main_region_B_r1_C2 :
					reactMain_region_B_r1_C2();
					break;
				case main_region_B_r2_D1 :
					reactMain_region_B_r2_D1();
					break;
				case main_region_B_r2_D2 :
					reactMain_region_B_r2_D2();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
