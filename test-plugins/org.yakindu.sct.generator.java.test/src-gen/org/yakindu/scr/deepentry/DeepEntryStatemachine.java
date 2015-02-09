package org.yakindu.scr.deepentry;

public class DeepEntryStatemachine implements IDeepEntryStatemachine {

	static {
	}

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

		enterSequenceR();

		enterSequenceR2();

		enterSequenceR3();
	}

	public void exit() {
		exitSequenceR();

		exitSequenceR2();

		exitSequenceR3();

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

	private boolean checkR2_BTr0() {
		return sCInterface.f;
	}

	private boolean checkR2_B_r_BATr0() {
		return sCInterface.e;
	}

	private boolean checkR2_CTr0() {
		return sCInterface.f;
	}

	private void effectR2_BTr0() {
		exitSequenceR2_B();

		enterSequenceR2_C();
	}

	private void effectR2_B_r_BATr0() {
		exitSequenceR2_B_r_BA();

		enterSequenceR2_B_r_BB();
	}

	private void effectR2_CTr0() {
		exitSequenceR2_C();

		enterSequenceR2_B();
	}

	/* Entry action for statechart 'DeepEntry'. */
	private void entryAction() {
	}

	/* Entry action for state 'A'. */
	private void entryActionR_A() {
		sCInterface.x += 1;
	}

	/* Entry action for state 'BA'. */
	private void entryActionR2_B_r_BA() {
		sCInterface.y += 1;
	}

	/* Entry action for state 'D'. */
	private void entryActionR3_D() {
		sCInterface.z += 1;
	}

	/* Entry action for state 'DA'. */
	private void entryActionR3_D_r_DA() {
		sCInterface.z += 1;
	}

	/* Exit action for state 'DeepEntry'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state B */
	private void enterSequenceR_A_r_B() {
		nextStateIndex = 0;
		stateVector[0] = State.r_A_r_B;
	}

	/* 'default' enter sequence for state B */
	private void enterSequenceR2_B() {
		enterSequenceR2_B_r();
	}

	/* 'default' enter sequence for state BA */
	private void enterSequenceR2_B_r_BA() {
		entryActionR2_B_r_BA();

		enterSequenceR2_B_r_BA_r();

		historyVector[0] = stateVector[1];
	}

	/* 'default' enter sequence for state BAA */
	private void enterSequenceR2_B_r_BA_r_BAA() {
		nextStateIndex = 1;
		stateVector[1] = State.r2_B_r_BA_r_BAA;
	}

	/* 'default' enter sequence for state BB */
	private void enterSequenceR2_B_r_BB() {
		nextStateIndex = 1;
		stateVector[1] = State.r2_B_r_BB;

		historyVector[0] = stateVector[1];
	}

	/* 'default' enter sequence for state C */
	private void enterSequenceR2_C() {
		nextStateIndex = 1;
		stateVector[1] = State.r2_C;
	}

	/* 'default' enter sequence for state DAA */
	private void enterSequenceR3_D_r_DA_r_DAA() {
		nextStateIndex = 2;
		stateVector[2] = State.r3_D_r_DA_r_DAA;

		historyVector[3] = stateVector[2];
	}

	/* 'default' enter sequence for region r */
	private void enterSequenceR() {
		reactDeepEntry_r__entry_Default();
	}

	/* 'default' enter sequence for region r2 */
	private void enterSequenceR2() {
		reactDeepEntry_r2__entry_Default();
	}

	/* 'default' enter sequence for region r */
	private void enterSequenceR2_B_r() {
		reactDeepEntry_r2_B_r__entry_Default();
	}

	/* shallow enterSequence with history in child r */
	private void shallowEnterSequenceR2_B_r() {
		switch (historyVector[0]) {
			case r2_B_r_BA_r_BAA :
				enterSequenceR2_B_r_BA();
				break;

			case r2_B_r_BB :
				enterSequenceR2_B_r_BB();
				break;

			default :
				break;
		}
	}

	/* 'default' enter sequence for region r */
	private void enterSequenceR2_B_r_BA_r() {
		reactDeepEntry_r2_B_r_BA_r__entry_Default();
	}

	/* 'default' enter sequence for region r3 */
	private void enterSequenceR3() {
		reactDeepEntry_r3__entry_Default();
	}

	/* deep enterSequence with history in child r3 */
	private void deepEnterSequenceR3() {
		switch (historyVector[1]) {
			case r3_D_r_DA_r_DAA :
				entryActionR3_D();

				deepEnterSequenceR3_D_r();
				break;

			default :
				break;
		}
	}

	/* deep enterSequence with history in child r */
	private void deepEnterSequenceR3_D_r() {
		switch (historyVector[2]) {
			case r3_D_r_DA_r_DAA :
				entryActionR3_D_r_DA();

				deepEnterSequenceR3_D_r_DA_r();
				break;

			default :
				break;
		}
	}

	/* deep enterSequence with history in child r */
	private void deepEnterSequenceR3_D_r_DA_r() {
		switch (historyVector[3]) {
			case r3_D_r_DA_r_DAA :
				enterSequenceR3_D_r_DA_r_DAA();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for state B */
	private void exitSequenceR_A_r_B() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state B */
	private void exitSequenceR2_B() {
		exitSequenceR2_B_r();
	}

	/* Default exit sequence for state BA */
	private void exitSequenceR2_B_r_BA() {
		exitSequenceR2_B_r_BA_r();
	}

	/* Default exit sequence for state BAA */
	private void exitSequenceR2_B_r_BA_r_BAA() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state BB */
	private void exitSequenceR2_B_r_BB() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state C */
	private void exitSequenceR2_C() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state DAA */
	private void exitSequenceR3_D_r_DA_r_DAA() {
		nextStateIndex = 2;
		stateVector[2] = State.$NullState$;
	}

	/* Default exit sequence for region r */
	private void exitSequenceR() {
		switch (stateVector[0]) {
			case r_A_r_B :
				exitSequenceR_A_r_B();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region r */
	private void exitSequenceR_A_r() {
		switch (stateVector[0]) {
			case r_A_r_B :
				exitSequenceR_A_r_B();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region r2 */
	private void exitSequenceR2() {
		switch (stateVector[1]) {
			case r2_B_r_BA_r_BAA :
				exitSequenceR2_B_r_BA_r_BAA();
				break;

			case r2_B_r_BB :
				exitSequenceR2_B_r_BB();
				break;

			case r2_C :
				exitSequenceR2_C();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region r */
	private void exitSequenceR2_B_r() {
		switch (stateVector[1]) {
			case r2_B_r_BA_r_BAA :
				exitSequenceR2_B_r_BA_r_BAA();
				break;

			case r2_B_r_BB :
				exitSequenceR2_B_r_BB();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region r */
	private void exitSequenceR2_B_r_BA_r() {
		switch (stateVector[1]) {
			case r2_B_r_BA_r_BAA :
				exitSequenceR2_B_r_BA_r_BAA();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region r3 */
	private void exitSequenceR3() {
		switch (stateVector[2]) {
			case r3_D_r_DA_r_DAA :
				exitSequenceR3_D_r_DA_r_DAA();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region r */
	private void exitSequenceR3_D_r() {
		switch (stateVector[2]) {
			case r3_D_r_DA_r_DAA :
				exitSequenceR3_D_r_DA_r_DAA();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region r */
	private void exitSequenceR3_D_r_DA_r() {
		switch (stateVector[2]) {
			case r3_D_r_DA_r_DAA :
				exitSequenceR3_D_r_DA_r_DAA();
				break;

			default :
				break;
		}
	}

	/* The reactions of state B. */
	private void reactR_A_r_B() {
	}

	/* The reactions of state BAA. */
	private void reactR2_B_r_BA_r_BAA() {
		if (checkR2_BTr0()) {
			effectR2_BTr0();
		} else {
			if (checkR2_B_r_BATr0()) {
				effectR2_B_r_BATr0();
			} else {
			}
		}
	}

	/* The reactions of state BB. */
	private void reactR2_B_r_BB() {
		if (checkR2_BTr0()) {
			effectR2_BTr0();
		} else {
		}
	}

	/* The reactions of state C. */
	private void reactR2_C() {
		if (checkR2_CTr0()) {
			effectR2_CTr0();
		}
	}

	/* The reactions of state DAA. */
	private void reactR3_D_r_DA_r_DAA() {
	}

	/* Default react sequence for initial entry  */
	private void reactDeepEntry_r__entry_Default() {
		entryActionR_A();

		enterSequenceR_A_r_B();
	}

	/* Default react sequence for shallow history entry  */
	private void reactDeepEntry_r2_B_r__entry_Default() {
		/* Enter the region with shallow history */
		if (historyVector[0] != State.$NullState$) {
			shallowEnterSequenceR2_B_r();
		} else {
			entryActionR2_B_r_BA();

			enterSequenceR2_B_r_BA_r_BAA();

			historyVector[0] = stateVector[1];
		}
	}

	/* Default react sequence for initial entry  */
	private void reactDeepEntry_r2_B_r_BA_r__entry_Default() {
		enterSequenceR2_B_r_BA_r_BAA();
	}

	/* Default react sequence for initial entry  */
	private void reactDeepEntry_r2__entry_Default() {
		enterSequenceR2_B();
	}

	/* Default react sequence for deep history entry  */
	private void reactDeepEntry_r3__entry_Default() {
		/* Enter the region with deep history */
		if (historyVector[1] != State.$NullState$) {
			deepEnterSequenceR3();
		} else {
			entryActionR3_D();

			entryActionR3_D_r_DA();

			enterSequenceR3_D_r_DA_r_DAA();

			historyVector[2] = stateVector[2];

			historyVector[1] = stateVector[2];
		}
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case r_A_r_B :
					reactR_A_r_B();
					break;
				case r2_B_r_BA_r_BAA :
					reactR2_B_r_BA_r_BAA();
					break;
				case r2_B_r_BB :
					reactR2_B_r_BB();
					break;
				case r2_C :
					reactR2_C();
					break;
				case r3_D_r_DA_r_DAA :
					reactR3_D_r_DA_r_DAA();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
