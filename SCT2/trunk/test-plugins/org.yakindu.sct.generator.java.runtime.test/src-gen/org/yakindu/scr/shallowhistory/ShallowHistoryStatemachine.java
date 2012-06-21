package org.yakindu.scr.shallowhistory;

public class ShallowHistoryStatemachine implements IShallowHistoryStatemachine {

	private final class SCIDefaultImpl implements SCIDefault {

		private boolean event1;

		public void raiseEvent1() {
			event1 = true;
		}

		private boolean event2;

		public void raiseEvent2() {
			event2 = true;
		}

		private boolean event3;

		public void raiseEvent3() {
			event3 = true;
		}

		private boolean event4;

		public void raiseEvent4() {
			event4 = true;
		}

		private boolean event5;

		public void raiseEvent5() {
			event5 = true;
		}

		private boolean event6;

		public void raiseEvent6() {
			event6 = true;
		}

		private boolean event7;

		public void raiseEvent7() {
			event7 = true;
		}

		private boolean event8;

		public void raiseEvent8() {
			event8 = true;
		}

		public void clearEvents() {
			event1 = false;
			event2 = false;
			event3 = false;
			event4 = false;
			event5 = false;
			event6 = false;
			event7 = false;
			event8 = false;
		}

	}

	private SCIDefaultImpl sCIDefault;

	public enum State {
		MainRegion_State1, MainRegion_State2, MainRegion_State2__region0_State3, MainRegion_State2__region0_State4, MainRegion_State2__region0_State4__region0_State6, MainRegion_State2__region0_State4__region0_State7, MainRegion_State2__region0_State4__region0_State7__region0_State8, MainRegion_State2__region0_State4__region0_State7__region0_State9, MainRegion_State2__region0_State5, $NullState$
	};

	private State[] historyVector = new State[2];

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public ShallowHistoryStatemachine() {

		sCIDefault = new SCIDefaultImpl();

	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		for (int i = 0; i < 2; i++) {
			historyVector[i] = State.$NullState$;
		}
		clearEvents();
		clearOutEvents();
	}

	protected void clearEvents() {
		sCIDefault.clearEvents();

	}

	protected void clearOutEvents() {
	}

	public boolean isStateActive(State state) {
		for (int i = 0; i < stateVector.length; i++) {
			if (stateVector[i] == state) {
				return true;
			}
		}
		return false;
	}

	public SCIDefault getSCIDefault() {
		return sCIDefault;
	}

	public void raiseEvent1() {
		sCIDefault.raiseEvent1();
	}

	public void raiseEvent2() {
		sCIDefault.raiseEvent2();
	}

	public void raiseEvent3() {
		sCIDefault.raiseEvent3();
	}

	public void raiseEvent4() {
		sCIDefault.raiseEvent4();
	}

	public void raiseEvent5() {
		sCIDefault.raiseEvent5();
	}

	public void raiseEvent6() {
		sCIDefault.raiseEvent6();
	}

	public void raiseEvent7() {
		sCIDefault.raiseEvent7();
	}

	public void raiseEvent8() {
		sCIDefault.raiseEvent8();
	}

	public void enter() {

		// unknown function type org.yakindu.sct.model.sexec.impl.SequenceImpl@9b64fac (name: entryAction) (comment: Entry action for statechart 'ShallowHistory'.)();
		nextStateIndex = 0;
		stateVector[0] = State.MainRegion_State1;

	}

	public void exit() {
		//Handle exit of all possible states (of mainRegion) at position 0...
		switch (stateVector[0]) {

			case MainRegion_State1 :
				stateVector[0] = State.$NullState$;

				break;

			case MainRegion_State2__region0_State3 :

				historyVector[0] = stateVector[0];
				stateVector[0] = State.$NullState$;

				break;

			case MainRegion_State2__region0_State4__region0_State6 :

				historyVector[0] = stateVector[0];
				stateVector[0] = State.$NullState$;

				break;

			case MainRegion_State2__region0_State4__region0_State7__region0_State8 :

				historyVector[1] = stateVector[0];

				historyVector[0] = stateVector[0];
				stateVector[0] = State.$NullState$;

				break;

			case MainRegion_State2__region0_State4__region0_State7__region0_State9 :

				historyVector[1] = stateVector[0];

				historyVector[0] = stateVector[0];
				stateVector[0] = State.$NullState$;

				break;

			case MainRegion_State2__region0_State5 :

				historyVector[0] = stateVector[0];
				stateVector[0] = State.$NullState$;

				break;

			default :
				break;
		}

		// unknown function type org.yakindu.sct.model.sexec.impl.SequenceImpl@1674b452 (name: exitAction) (comment: Exit action for state 'ShallowHistory'.)();
	}

	private void shallowEnterSequenceMainRegion_State2Region0() {
		//Handle shallow history entry of null
		switch (historyVector[0]) {

			case MainRegion_State2__region0_State3 :
				nextStateIndex = 0;
				stateVector[0] = State.MainRegion_State2__region0_State3;

				break;

			case MainRegion_State2__region0_State4__region0_State6 :
				nextStateIndex = 0;
				stateVector[0] = State.MainRegion_State2__region0_State4__region0_State6;

				break;

			case MainRegion_State2__region0_State4__region0_State7__region0_State8 :
				nextStateIndex = 0;
				stateVector[0] = State.MainRegion_State2__region0_State4__region0_State6;

				break;

			case MainRegion_State2__region0_State4__region0_State7__region0_State9 :
				nextStateIndex = 0;
				stateVector[0] = State.MainRegion_State2__region0_State4__region0_State6;

				break;

			case MainRegion_State2__region0_State5 :
				nextStateIndex = 0;
				stateVector[0] = State.MainRegion_State2__region0_State5;

				break;

			default :
				break;
		}
	}

	private void shallowEnterSequenceMainRegion_State2__region0_State4__region0_State7Region0() {
		//Handle shallow history entry of null
		switch (historyVector[1]) {

			case MainRegion_State2__region0_State4__region0_State7__region0_State8 :
				nextStateIndex = 0;
				stateVector[0] = State.MainRegion_State2__region0_State4__region0_State7__region0_State8;

				break;

			case MainRegion_State2__region0_State4__region0_State7__region0_State9 :
				nextStateIndex = 0;
				stateVector[0] = State.MainRegion_State2__region0_State4__region0_State7__region0_State9;

				break;

			default :
				break;
		}
	}
	private void reactMainRegion_State1() {
		if (sCIDefault.event1) {
			stateVector[0] = State.$NullState$;

			//Enter the region with shallow history
			if (historyVector[0] != State.$NullState$) {

				shallowEnterSequenceMainRegion_State2Region0();
			} else {
				nextStateIndex = 0;
				stateVector[0] = State.MainRegion_State2__region0_State3;

			}

		}

	}
	private void reactMainRegion_State2() {
	}
	private void reactMainRegion_State2__region0_State3() {
		if (sCIDefault.event2) {

			historyVector[0] = stateVector[0];
			//Handle exit of all possible states (of region0) at position 0...
			switch (stateVector[0]) {

				case MainRegion_State2__region0_State3 :
					stateVector[0] = State.$NullState$;

					break;

				case MainRegion_State2__region0_State4__region0_State6 :
					stateVector[0] = State.$NullState$;

					break;

				case MainRegion_State2__region0_State4__region0_State7__region0_State8 :

					historyVector[1] = stateVector[0];
					stateVector[0] = State.$NullState$;

					break;

				case MainRegion_State2__region0_State4__region0_State7__region0_State9 :

					historyVector[1] = stateVector[0];
					stateVector[0] = State.$NullState$;

					break;

				case MainRegion_State2__region0_State5 :
					stateVector[0] = State.$NullState$;

					break;

				default :
					break;
			}

			nextStateIndex = 0;
			stateVector[0] = State.MainRegion_State1;

		} else {
			if (sCIDefault.event3) {
				stateVector[0] = State.$NullState$;

				nextStateIndex = 0;
				stateVector[0] = State.MainRegion_State2__region0_State4__region0_State6;

			}

		}

	}
	private void reactMainRegion_State2__region0_State4() {
	}
	private void reactMainRegion_State2__region0_State4__region0_State6() {
		if (sCIDefault.event2) {

			historyVector[0] = stateVector[0];
			//Handle exit of all possible states (of region0) at position 0...
			switch (stateVector[0]) {

				case MainRegion_State2__region0_State3 :
					stateVector[0] = State.$NullState$;

					break;

				case MainRegion_State2__region0_State4__region0_State6 :
					stateVector[0] = State.$NullState$;

					break;

				case MainRegion_State2__region0_State4__region0_State7__region0_State8 :

					historyVector[1] = stateVector[0];
					stateVector[0] = State.$NullState$;

					break;

				case MainRegion_State2__region0_State4__region0_State7__region0_State9 :

					historyVector[1] = stateVector[0];
					stateVector[0] = State.$NullState$;

					break;

				case MainRegion_State2__region0_State5 :
					stateVector[0] = State.$NullState$;

					break;

				default :
					break;
			}

			nextStateIndex = 0;
			stateVector[0] = State.MainRegion_State1;

		} else {
			if (sCIDefault.event4) {
				//Handle exit of all possible states (of region0) at position 0...
				switch (stateVector[0]) {

					case MainRegion_State2__region0_State4__region0_State6 :
						stateVector[0] = State.$NullState$;

						break;

					case MainRegion_State2__region0_State4__region0_State7__region0_State8 :

						historyVector[1] = stateVector[0];
						stateVector[0] = State.$NullState$;

						break;

					case MainRegion_State2__region0_State4__region0_State7__region0_State9 :

						historyVector[1] = stateVector[0];
						stateVector[0] = State.$NullState$;

						break;

					default :
						break;
				}

				nextStateIndex = 0;
				stateVector[0] = State.MainRegion_State2__region0_State5;

			} else {
				if (sCIDefault.event5) {
					stateVector[0] = State.$NullState$;

					//Enter the region with shallow history
					if (historyVector[1] != State.$NullState$) {

						shallowEnterSequenceMainRegion_State2__region0_State4__region0_State7Region0();
					} else {
						nextStateIndex = 0;
						stateVector[0] = State.MainRegion_State2__region0_State4__region0_State7__region0_State8;

					}

				}

			}

		}

	}
	private void reactMainRegion_State2__region0_State4__region0_State7() {
	}
	private void reactMainRegion_State2__region0_State4__region0_State7__region0_State8() {
		if (sCIDefault.event2) {

			historyVector[0] = stateVector[0];
			//Handle exit of all possible states (of region0) at position 0...
			switch (stateVector[0]) {

				case MainRegion_State2__region0_State3 :
					stateVector[0] = State.$NullState$;

					break;

				case MainRegion_State2__region0_State4__region0_State6 :
					stateVector[0] = State.$NullState$;

					break;

				case MainRegion_State2__region0_State4__region0_State7__region0_State8 :

					historyVector[1] = stateVector[0];
					stateVector[0] = State.$NullState$;

					break;

				case MainRegion_State2__region0_State4__region0_State7__region0_State9 :

					historyVector[1] = stateVector[0];
					stateVector[0] = State.$NullState$;

					break;

				case MainRegion_State2__region0_State5 :
					stateVector[0] = State.$NullState$;

					break;

				default :
					break;
			}

			nextStateIndex = 0;
			stateVector[0] = State.MainRegion_State1;

		} else {
			if (sCIDefault.event4) {
				//Handle exit of all possible states (of region0) at position 0...
				switch (stateVector[0]) {

					case MainRegion_State2__region0_State4__region0_State6 :
						stateVector[0] = State.$NullState$;

						break;

					case MainRegion_State2__region0_State4__region0_State7__region0_State8 :

						historyVector[1] = stateVector[0];
						stateVector[0] = State.$NullState$;

						break;

					case MainRegion_State2__region0_State4__region0_State7__region0_State9 :

						historyVector[1] = stateVector[0];
						stateVector[0] = State.$NullState$;

						break;

					default :
						break;
				}

				nextStateIndex = 0;
				stateVector[0] = State.MainRegion_State2__region0_State5;

			} else {
				if (sCIDefault.event6) {

					historyVector[1] = stateVector[0];
					//Handle exit of all possible states (of region0) at position 0...
					switch (stateVector[0]) {

						case MainRegion_State2__region0_State4__region0_State7__region0_State8 :
							stateVector[0] = State.$NullState$;

							break;

						case MainRegion_State2__region0_State4__region0_State7__region0_State9 :
							stateVector[0] = State.$NullState$;

							break;

						default :
							break;
					}

					nextStateIndex = 0;
					stateVector[0] = State.MainRegion_State2__region0_State4__region0_State6;

				} else {
					if (sCIDefault.event7) {
						stateVector[0] = State.$NullState$;

						nextStateIndex = 0;
						stateVector[0] = State.MainRegion_State2__region0_State4__region0_State7__region0_State9;

					}

				}

			}

		}

	}
	private void reactMainRegion_State2__region0_State4__region0_State7__region0_State9() {
		if (sCIDefault.event2) {

			historyVector[0] = stateVector[0];
			//Handle exit of all possible states (of region0) at position 0...
			switch (stateVector[0]) {

				case MainRegion_State2__region0_State3 :
					stateVector[0] = State.$NullState$;

					break;

				case MainRegion_State2__region0_State4__region0_State6 :
					stateVector[0] = State.$NullState$;

					break;

				case MainRegion_State2__region0_State4__region0_State7__region0_State8 :

					historyVector[1] = stateVector[0];
					stateVector[0] = State.$NullState$;

					break;

				case MainRegion_State2__region0_State4__region0_State7__region0_State9 :

					historyVector[1] = stateVector[0];
					stateVector[0] = State.$NullState$;

					break;

				case MainRegion_State2__region0_State5 :
					stateVector[0] = State.$NullState$;

					break;

				default :
					break;
			}

			nextStateIndex = 0;
			stateVector[0] = State.MainRegion_State1;

		} else {
			if (sCIDefault.event4) {
				//Handle exit of all possible states (of region0) at position 0...
				switch (stateVector[0]) {

					case MainRegion_State2__region0_State4__region0_State6 :
						stateVector[0] = State.$NullState$;

						break;

					case MainRegion_State2__region0_State4__region0_State7__region0_State8 :

						historyVector[1] = stateVector[0];
						stateVector[0] = State.$NullState$;

						break;

					case MainRegion_State2__region0_State4__region0_State7__region0_State9 :

						historyVector[1] = stateVector[0];
						stateVector[0] = State.$NullState$;

						break;

					default :
						break;
				}

				nextStateIndex = 0;
				stateVector[0] = State.MainRegion_State2__region0_State5;

			} else {
				if (sCIDefault.event6) {

					historyVector[1] = stateVector[0];
					//Handle exit of all possible states (of region0) at position 0...
					switch (stateVector[0]) {

						case MainRegion_State2__region0_State4__region0_State7__region0_State8 :
							stateVector[0] = State.$NullState$;

							break;

						case MainRegion_State2__region0_State4__region0_State7__region0_State9 :
							stateVector[0] = State.$NullState$;

							break;

						default :
							break;
					}

					nextStateIndex = 0;
					stateVector[0] = State.MainRegion_State2__region0_State4__region0_State6;

				} else {
					if (sCIDefault.event8) {
						stateVector[0] = State.$NullState$;

						nextStateIndex = 0;
						stateVector[0] = State.MainRegion_State2__region0_State4__region0_State7__region0_State8;

					}

				}

			}

		}

	}
	private void reactMainRegion_State2__region0_State5() {
		if (sCIDefault.event2) {

			historyVector[0] = stateVector[0];
			//Handle exit of all possible states (of region0) at position 0...
			switch (stateVector[0]) {

				case MainRegion_State2__region0_State3 :
					stateVector[0] = State.$NullState$;

					break;

				case MainRegion_State2__region0_State4__region0_State6 :
					stateVector[0] = State.$NullState$;

					break;

				case MainRegion_State2__region0_State4__region0_State7__region0_State8 :

					historyVector[1] = stateVector[0];
					stateVector[0] = State.$NullState$;

					break;

				case MainRegion_State2__region0_State4__region0_State7__region0_State9 :

					historyVector[1] = stateVector[0];
					stateVector[0] = State.$NullState$;

					break;

				case MainRegion_State2__region0_State5 :
					stateVector[0] = State.$NullState$;

					break;

				default :
					break;
			}

			nextStateIndex = 0;
			stateVector[0] = State.MainRegion_State1;

		} else {

		}

	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case MainRegion_State1 :
					reactMainRegion_State1();
					break;
				case MainRegion_State2 :
					reactMainRegion_State2();
					break;
				case MainRegion_State2__region0_State3 :
					reactMainRegion_State2__region0_State3();
					break;
				case MainRegion_State2__region0_State4 :
					reactMainRegion_State2__region0_State4();
					break;
				case MainRegion_State2__region0_State4__region0_State6 :
					reactMainRegion_State2__region0_State4__region0_State6();
					break;
				case MainRegion_State2__region0_State4__region0_State7 :
					reactMainRegion_State2__region0_State4__region0_State7();
					break;
				case MainRegion_State2__region0_State4__region0_State7__region0_State8 :
					reactMainRegion_State2__region0_State4__region0_State7__region0_State8();
					break;
				case MainRegion_State2__region0_State4__region0_State7__region0_State9 :
					reactMainRegion_State2__region0_State4__region0_State7__region0_State9();
					break;
				case MainRegion_State2__region0_State5 :
					reactMainRegion_State2__region0_State5();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
