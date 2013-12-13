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

		private int x;

		public int getX() {
			return x;
		}

		public void setX(int value) {
			this.x = value;
		}

		private int y;

		public int getY() {
			return y;
		}

		public void setY(int value) {
			this.y = value;
		}

		private int z;

		public int getZ() {
			return z;
		}

		public void setZ(int value) {
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

		sCInterface.x += 1;

		nextStateIndex = 0;
		stateVector[0] = State.r_A_r_B;

		/* Enter the region with shallow history */
		if (historyVector[0] != State.$NullState$) {
			shallowEnterSequenceR2_B_r();
		} else {
			sCInterface.y += 1;

			nextStateIndex = 1;
			stateVector[1] = State.r2_B_r_BA_r_BAA;
		}

		/* Enter the region with deep history */
		if (historyVector[1] != State.$NullState$) {
			deepEnterSequenceR3();
		} else {
			sCInterface.z += 1;

			sCInterface.z += 1;

			nextStateIndex = 2;
			stateVector[2] = State.r3_D_r_DA_r_DAA;
		}
	}

	public void exit() {
		switch (stateVector[0]) {
			case r_A_r_B :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			default :
				break;
		}

		switch (stateVector[1]) {
			case r2_B_r_BA_r_BAA :
				historyVector[0] = stateVector[1];

				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
				break;

			case r2_B_r_BB :
				historyVector[0] = stateVector[1];

				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
				break;

			case r2_C :
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
				break;

			default :
				break;
		}

		historyVector[1] = stateVector[2];

		switch (stateVector[2]) {
			case r3_D_r_DA_r_DAA :
				historyVector[3] = stateVector[2];

				historyVector[2] = stateVector[2];

				nextStateIndex = 2;
				stateVector[2] = State.$NullState$;
				break;

			default :
				break;
		}

		exitAction();
	}

	protected void clearEvents() {
		sCInterface.clearEvents();

	}

	protected void clearOutEvents() {
	}

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

	public int getX() {
		return sCInterface.getX();
	}

	public void setX(int value) {
		sCInterface.setX(value);
	}
	public int getY() {
		return sCInterface.getY();
	}

	public void setY(int value) {
		sCInterface.setY(value);
	}
	public int getZ() {
		return sCInterface.getZ();
	}

	public void setZ(int value) {
		sCInterface.setZ(value);
	}

	/* Entry action for statechart 'DeepEntry'. */
	private void entryAction() {
	}

	/* Exit action for state 'DeepEntry'. */
	private void exitAction() {
	}

	/* shallow enterSequence with history in child r */
	private void shallowEnterSequenceR2_B_r() {
		switch (historyVector[0]) {
			case r2_B_r_BA_r_BAA :
				sCInterface.y += 1;
				break;

			case r2_B_r_BB :
				nextStateIndex = 1;
				stateVector[1] = State.r2_B_r_BB;
				break;

			default :
				break;
		}
	}

	/* deep enterSequence with history in child r3 */
	private void deepEnterSequenceR3() {
		switch (historyVector[1]) {
			case r3_D_r_DA_r_DAA :
				sCInterface.z += 1;

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
				sCInterface.z += 1;

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
				nextStateIndex = 2;
				stateVector[2] = State.r3_D_r_DA_r_DAA;
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
		if (sCInterface.f) {
			historyVector[0] = stateVector[1];

			switch (stateVector[1]) {
				case r2_B_r_BA_r_BAA :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				case r2_B_r_BB :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				default :
					break;
			}

			nextStateIndex = 1;
			stateVector[1] = State.r2_C;
		} else {
			if (sCInterface.e) {
				switch (stateVector[1]) {
					case r2_B_r_BA_r_BAA :
						nextStateIndex = 1;
						stateVector[1] = State.$NullState$;
						break;

					default :
						break;
				}

				nextStateIndex = 1;
				stateVector[1] = State.r2_B_r_BB;
			} else {
			}
		}
	}

	/* The reactions of state BB. */
	private void reactR2_B_r_BB() {
		if (sCInterface.f) {
			historyVector[0] = stateVector[1];

			switch (stateVector[1]) {
				case r2_B_r_BA_r_BAA :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				case r2_B_r_BB :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				default :
					break;
			}

			nextStateIndex = 1;
			stateVector[1] = State.r2_C;
		} else {
		}
	}

	/* The reactions of state C. */
	private void reactR2_C() {
		if (sCInterface.f) {
			nextStateIndex = 1;
			stateVector[1] = State.$NullState$;

			/* Enter the region with shallow history */
			if (historyVector[0] != State.$NullState$) {
				shallowEnterSequenceR2_B_r();
			} else {
				sCInterface.y += 1;

				nextStateIndex = 1;
				stateVector[1] = State.r2_B_r_BA_r_BAA;
			}
		}
	}

	/* The reactions of state DAA. */
	private void reactR3_D_r_DA_r_DAA() {
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
