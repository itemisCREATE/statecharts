package org.yakindu.scr.choice;

public class ChoiceStatemachine implements IChoiceStatemachine {

	private final class SCInterfaceImpl implements SCInterface {

		private boolean e;

		public void raiseE() {
			e = true;
		}

		private boolean f;

		public void raiseF() {
			f = true;
		}

		private boolean g;

		public void raiseG() {
			g = true;
		}

		private boolean h;

		public void raiseH() {
			h = true;
		}

		private boolean c;

		public boolean getC() {
			return c;
		}

		public void setC(boolean value) {
			this.c = value;
		}

		public void clearEvents() {
			e = false;
			f = false;
			g = false;
			h = false;
		}

	}

	private SCInterfaceImpl sCInterface;

	public enum State {
		main_region_A, main_region_B, main_region_C, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public ChoiceStatemachine() {

		sCInterface = new SCInterfaceImpl();
	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCInterface.c = false;
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

			case main_region_C :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
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
			case main_region_A :
				return stateVector[0] == State.main_region_A;
			case main_region_B :
				return stateVector[0] == State.main_region_B;
			case main_region_C :
				return stateVector[0] == State.main_region_C;
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
	public void raiseG() {
		sCInterface.raiseG();
	}
	public void raiseH() {
		sCInterface.raiseH();
	}

	public boolean getC() {
		return sCInterface.getC();
	}

	public void setC(boolean value) {
		sCInterface.setC(value);
	}

	/* Entry action for statechart 'Choice'. */
	private void entryAction() {
	}

	/* Exit action for state 'Choice'. */
	private void exitAction() {
	}

	/* The reactions of state A. */
	private void reactMain_region_A() {
		if (sCInterface.e) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			if (sCInterface.c) {
				nextStateIndex = 0;
				stateVector[0] = State.main_region_C;
			} else {
				nextStateIndex = 0;
				stateVector[0] = State.main_region_B;
			}
		} else {
			if (sCInterface.f) {
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				if (sCInterface.c) {
					nextStateIndex = 0;
					stateVector[0] = State.main_region_C;
				} else {
					nextStateIndex = 0;
					stateVector[0] = State.main_region_B;
				}
			} else {
				if (sCInterface.g) {
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					if (sCInterface.c) {
						nextStateIndex = 0;
						stateVector[0] = State.main_region_C;
					} else {
						nextStateIndex = 0;
						stateVector[0] = State.main_region_B;
					}
				} else {
					if (sCInterface.h) {
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;

						if (sCInterface.c) {
							nextStateIndex = 0;
							stateVector[0] = State.main_region_C;
						} else {
							nextStateIndex = 0;
							stateVector[0] = State.main_region_B;
						}
					}
				}
			}
		}
	}

	/* The reactions of state B. */
	private void reactMain_region_B() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		nextStateIndex = 0;
		stateVector[0] = State.main_region_A;
	}

	/* The reactions of state C. */
	private void reactMain_region_C() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

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
				case main_region_B :
					reactMain_region_B();
					break;
				case main_region_C :
					reactMain_region_C();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
