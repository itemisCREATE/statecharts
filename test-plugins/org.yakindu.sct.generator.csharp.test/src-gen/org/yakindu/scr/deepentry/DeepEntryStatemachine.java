package org.yakindu.scr.deepentry;

public class DeepEntryStatemachine implements IDeepEntryStatemachine {

	private final class SCInterfaceImpl implements SCInterface {

		private boolean e;

		public void raiseE() {
			e = true;
		}

		private boolean f;

		public void raiseF() {
			f = true;
		}

		private long x;
		public long getX() {
			return x;
		}

		public void setX(long value) {
			this.x = value;
		}

		private long y;
		public long getY() {
			return y;
		}

		public void setY(long value) {
			this.y = value;
		}

		private long z;
		public long getZ() {
			return z;
		}

		public void setZ(long value) {
			this.z = value;
		}

		public void clearEvents() {
			e = false;
			f = false;
		}

	}

	private SCInterfaceImpl sCInterface;

	public enum State {
		r_A, r_A_r_B, r2_B, r2_B_r_BA, r2_B_r_BA_r_BAA, r2_B_r_BB, r2_C, r3_D, r3_D_r_DA, r3_D_r_DA_r_DAA, $NullState$
	};

	private State[] historyVector = new State[4];
	private final State[] stateVector = new State[3];

	private int nextStateIndex;

	public DeepEntryStatemachine() {

		sCInterface = new SCInterfaceImpl();
	}

	public void init() {
		for (int i = 0; i < 3; i++) {
			stateVector[i] = State.$NullState$;
		}

		for (int i = 0; i < 4; i++) {
			historyVector[i] = State.$NullState$;
		}
		clearEvents();
		clearOutEvents();

		sCInterface.x = 0;

		sCInterface.y = 0;

		sCInterface.z = 0;
	}

	public void enter() {
		entryAction();

		enterSequence_r_default();

		enterSequence_r2_default();

		enterSequence_r3_default();
	}

	public void exit() {
		exitSequence_r();

		exitSequence_r2();

		exitSequence_r3();

		exitAction();
	}

	/**
	 * @see IStatemachine#isActive()
	 */
	@Override
	public boolean isActive() {

		return stateVector[0] != State.$NullState$
				|| stateVector[1] != State.$NullState$
				|| stateVector[2] != State.$NullState$;
	}

	/** 
	 * Always returns 'false' since this state machine can never become final.
	 *
	 * @see IStatemachine#isFinal() 
	 */
	@Override
	public boolean isFinal() {
		return false;
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
			case r_A :
				return stateVector[0].ordinal() >= State.r_A.ordinal()
						&& stateVector[0].ordinal() <= State.r_A_r_B.ordinal();
			case r_A_r_B :
				return stateVector[0] == State.r_A_r_B;
			case r2_B :
				return stateVector[1].ordinal() >= State.r2_B.ordinal()
						&& stateVector[1].ordinal() <= State.r2_B_r_BB
								.ordinal();
			case r2_B_r_BA :
				return stateVector[1].ordinal() >= State.r2_B_r_BA.ordinal()
						&& stateVector[1].ordinal() <= State.r2_B_r_BA_r_BAA
								.ordinal();
			case r2_B_r_BA_r_BAA :
				return stateVector[1] == State.r2_B_r_BA_r_BAA;
			case r2_B_r_BB :
				return stateVector[1] == State.r2_B_r_BB;
			case r2_C :
				return stateVector[1] == State.r2_C;
			case r3_D :
				return stateVector[2].ordinal() >= State.r3_D.ordinal()
						&& stateVector[2].ordinal() <= State.r3_D_r_DA_r_DAA
								.ordinal();
			case r3_D_r_DA :
				return stateVector[2].ordinal() >= State.r3_D_r_DA.ordinal()
						&& stateVector[2].ordinal() <= State.r3_D_r_DA_r_DAA
								.ordinal();
			case r3_D_r_DA_r_DAA :
				return stateVector[2] == State.r3_D_r_DA_r_DAA;
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
	public long getZ() {
		return sCInterface.getZ();
	}

	public void setZ(long value) {
		sCInterface.setZ(value);
	}

	private boolean check_r2_B_tr0_tr0() {
		return sCInterface.f;
	}

	private boolean check_r2_B_r_BA_tr0_tr0() {
		return sCInterface.e;
	}

	private boolean check_r2_C_tr0_tr0() {
		return sCInterface.f;
	}

	private void effect_r2_B_tr0() {
		exitSequence_r2_B();

		enterSequence_r2_C_default();
	}

	private void effect_r2_B_r_BA_tr0() {
		exitSequence_r2_B_r_BA();

		enterSequence_r2_B_r_BB_default();
	}

	private void effect_r2_C_tr0() {
		exitSequence_r2_C();

		enterSequence_r2_B_default();
	}

	/* Entry action for statechart 'DeepEntry'. */
	private void entryAction() {
	}

	/* Entry action for state 'A'. */
	private void entryAction_r_A() {
		sCInterface.x += 1;
	}

	/* Entry action for state 'BA'. */
	private void entryAction_r2_B_r_BA() {
		sCInterface.y += 1;
	}

	/* Entry action for state 'D'. */
	private void entryAction_r3_D() {
		sCInterface.z += 1;
	}

	/* Entry action for state 'DA'. */
	private void entryAction_r3_D_r_DA() {
		sCInterface.z += 1;
	}

	/* Exit action for state 'DeepEntry'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state B */
	private void enterSequence_r_A_r_B_default() {
		nextStateIndex = 0;
		stateVector[0] = State.r_A_r_B;
	}

	/* 'default' enter sequence for state B */
	private void enterSequence_r2_B_default() {
		enterSequence_r2_B_r_default();
	}

	/* 'default' enter sequence for state BA */
	private void enterSequence_r2_B_r_BA_default() {
		entryAction_r2_B_r_BA();

		enterSequence_r2_B_r_BA_r_default();

		historyVector[0] = stateVector[1];
	}

	/* 'default' enter sequence for state BAA */
	private void enterSequence_r2_B_r_BA_r_BAA_default() {
		nextStateIndex = 1;
		stateVector[1] = State.r2_B_r_BA_r_BAA;
	}

	/* 'default' enter sequence for state BB */
	private void enterSequence_r2_B_r_BB_default() {
		nextStateIndex = 1;
		stateVector[1] = State.r2_B_r_BB;

		historyVector[0] = stateVector[1];
	}

	/* 'default' enter sequence for state C */
	private void enterSequence_r2_C_default() {
		nextStateIndex = 1;
		stateVector[1] = State.r2_C;
	}

	/* 'default' enter sequence for state DAA */
	private void enterSequence_r3_D_r_DA_r_DAA_default() {
		nextStateIndex = 2;
		stateVector[2] = State.r3_D_r_DA_r_DAA;

		historyVector[3] = stateVector[2];
	}

	/* 'default' enter sequence for region r */
	private void enterSequence_r_default() {
		react_r__entry_Default();
	}

	/* 'default' enter sequence for region r2 */
	private void enterSequence_r2_default() {
		react_r2__entry_Default();
	}

	/* 'default' enter sequence for region r */
	private void enterSequence_r2_B_r_default() {
		react_r2_B_r__entry_Default();
	}

	/* shallow enterSequence with history in child r */
	private void shallowEnterSequence_r2_B_r() {
		switch (historyVector[0]) {
			case r2_B_r_BA_r_BAA :
				enterSequence_r2_B_r_BA_default();
				break;

			case r2_B_r_BB :
				enterSequence_r2_B_r_BB_default();
				break;

			default :
				break;
		}
	}

	/* 'default' enter sequence for region r */
	private void enterSequence_r2_B_r_BA_r_default() {
		react_r2_B_r_BA_r__entry_Default();
	}

	/* 'default' enter sequence for region r3 */
	private void enterSequence_r3_default() {
		react_r3__entry_Default();
	}

	/* deep enterSequence with history in child r3 */
	private void deepEnterSequence_r3() {
		switch (historyVector[1]) {
			case r3_D_r_DA_r_DAA :
				entryAction_r3_D();

				deepEnterSequence_r3_D_r();
				break;

			default :
				break;
		}
	}

	/* deep enterSequence with history in child r */
	private void deepEnterSequence_r3_D_r() {
		switch (historyVector[2]) {
			case r3_D_r_DA_r_DAA :
				entryAction_r3_D_r_DA();

				deepEnterSequence_r3_D_r_DA_r();
				break;

			default :
				break;
		}
	}

	/* deep enterSequence with history in child r */
	private void deepEnterSequence_r3_D_r_DA_r() {
		switch (historyVector[3]) {
			case r3_D_r_DA_r_DAA :
				enterSequence_r3_D_r_DA_r_DAA_default();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for state B */
	private void exitSequence_r_A_r_B() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state B */
	private void exitSequence_r2_B() {
		exitSequence_r2_B_r();
	}

	/* Default exit sequence for state BA */
	private void exitSequence_r2_B_r_BA() {
		exitSequence_r2_B_r_BA_r();
	}

	/* Default exit sequence for state BAA */
	private void exitSequence_r2_B_r_BA_r_BAA() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state BB */
	private void exitSequence_r2_B_r_BB() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state C */
	private void exitSequence_r2_C() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state DAA */
	private void exitSequence_r3_D_r_DA_r_DAA() {
		nextStateIndex = 2;
		stateVector[2] = State.$NullState$;
	}

	/* Default exit sequence for region r */
	private void exitSequence_r() {
		switch (stateVector[0]) {
			case r_A_r_B :
				exitSequence_r_A_r_B();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region r */
	private void exitSequence_r_A_r() {
		switch (stateVector[0]) {
			case r_A_r_B :
				exitSequence_r_A_r_B();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region r2 */
	private void exitSequence_r2() {
		switch (stateVector[1]) {
			case r2_B_r_BA_r_BAA :
				exitSequence_r2_B_r_BA_r_BAA();
				break;

			case r2_B_r_BB :
				exitSequence_r2_B_r_BB();
				break;

			case r2_C :
				exitSequence_r2_C();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region r */
	private void exitSequence_r2_B_r() {
		switch (stateVector[1]) {
			case r2_B_r_BA_r_BAA :
				exitSequence_r2_B_r_BA_r_BAA();
				break;

			case r2_B_r_BB :
				exitSequence_r2_B_r_BB();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region r */
	private void exitSequence_r2_B_r_BA_r() {
		switch (stateVector[1]) {
			case r2_B_r_BA_r_BAA :
				exitSequence_r2_B_r_BA_r_BAA();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region r3 */
	private void exitSequence_r3() {
		switch (stateVector[2]) {
			case r3_D_r_DA_r_DAA :
				exitSequence_r3_D_r_DA_r_DAA();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region r */
	private void exitSequence_r3_D_r() {
		switch (stateVector[2]) {
			case r3_D_r_DA_r_DAA :
				exitSequence_r3_D_r_DA_r_DAA();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region r */
	private void exitSequence_r3_D_r_DA_r() {
		switch (stateVector[2]) {
			case r3_D_r_DA_r_DAA :
				exitSequence_r3_D_r_DA_r_DAA();
				break;

			default :
				break;
		}
	}

	/* The reactions of state B. */
	private void react_r_A_r_B() {
	}

	/* The reactions of state BAA. */
	private void react_r2_B_r_BA_r_BAA() {
		if (check_r2_B_tr0_tr0()) {
			effect_r2_B_tr0();
		} else {
			if (check_r2_B_r_BA_tr0_tr0()) {
				effect_r2_B_r_BA_tr0();
			} else {
			}
		}
	}

	/* The reactions of state BB. */
	private void react_r2_B_r_BB() {
		if (check_r2_B_tr0_tr0()) {
			effect_r2_B_tr0();
		} else {
		}
	}

	/* The reactions of state C. */
	private void react_r2_C() {
		if (check_r2_C_tr0_tr0()) {
			effect_r2_C_tr0();
		}
	}

	/* The reactions of state DAA. */
	private void react_r3_D_r_DA_r_DAA() {
	}

	/* Default react sequence for initial entry  */
	private void react_r__entry_Default() {
		entryAction_r_A();

		enterSequence_r_A_r_B_default();
	}

	/* Default react sequence for shallow history entry  */
	private void react_r2_B_r__entry_Default() {
		/* Enter the region with shallow history */
		if (historyVector[0] != State.$NullState$) {
			shallowEnterSequence_r2_B_r();
		} else {
			entryAction_r2_B_r_BA();

			enterSequence_r2_B_r_BA_r_BAA_default();

			historyVector[0] = stateVector[1];
		}
	}

	/* Default react sequence for initial entry  */
	private void react_r2_B_r_BA_r__entry_Default() {
		enterSequence_r2_B_r_BA_r_BAA_default();
	}

	/* Default react sequence for initial entry  */
	private void react_r2__entry_Default() {
		enterSequence_r2_B_default();
	}

	/* Default react sequence for deep history entry  */
	private void react_r3__entry_Default() {
		/* Enter the region with deep history */
		if (historyVector[1] != State.$NullState$) {
			deepEnterSequence_r3();
		} else {
			entryAction_r3_D();

			entryAction_r3_D_r_DA();

			enterSequence_r3_D_r_DA_r_DAA_default();

			historyVector[2] = stateVector[2];

			historyVector[1] = stateVector[2];
		}
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case r_A_r_B :
					react_r_A_r_B();
					break;
				case r2_B_r_BA_r_BAA :
					react_r2_B_r_BA_r_BAA();
					break;
				case r2_B_r_BB :
					react_r2_B_r_BB();
					break;
				case r2_C :
					react_r2_C();
					break;
				case r3_D_r_DA_r_DAA :
					react_r3_D_r_DA_r_DAA();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
