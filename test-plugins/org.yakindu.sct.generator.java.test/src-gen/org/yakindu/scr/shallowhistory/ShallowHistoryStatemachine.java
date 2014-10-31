package org.yakindu.scr.shallowhistory;

public class ShallowHistoryStatemachine implements IShallowHistoryStatemachine {

	private final class SCInterfaceImpl implements SCInterface {

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

	private SCInterfaceImpl sCInterface;

	public enum State {
		mainRegion_State1, mainRegion_State2, mainRegion_State2__region0_State3, mainRegion_State2__region0_State4, mainRegion_State2__region0_State4__region0_State6, mainRegion_State2__region0_State4__region0_State7, mainRegion_State2__region0_State4__region0_State7__region0_State8, mainRegion_State2__region0_State4__region0_State7__region0_State9, mainRegion_State2__region0_State5, $NullState$
	};

	private State[] historyVector = new State[2];
	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public ShallowHistoryStatemachine() {

		sCInterface = new SCInterfaceImpl();
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

	public void enter() {
		entryAction();

		nextStateIndex = 0;
		stateVector[0] = State.mainRegion_State1;
	}

	public void exit() {
		switch (stateVector[0]) {
			case mainRegion_State1 :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case mainRegion_State2__region0_State3 :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case mainRegion_State2__region0_State4__region0_State6 :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case mainRegion_State2__region0_State4__region0_State7__region0_State8 :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case mainRegion_State2__region0_State4__region0_State7__region0_State9 :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case mainRegion_State2__region0_State5 :
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
			case mainRegion_State1 :
				return stateVector[0] == State.mainRegion_State1;
			case mainRegion_State2 :
				return stateVector[0].ordinal() >= State.mainRegion_State2
						.ordinal()
						&& stateVector[0].ordinal() <= State.mainRegion_State2__region0_State5
								.ordinal();
			case mainRegion_State2__region0_State3 :
				return stateVector[0] == State.mainRegion_State2__region0_State3;
			case mainRegion_State2__region0_State4 :
				return stateVector[0].ordinal() >= State.mainRegion_State2__region0_State4
						.ordinal()
						&& stateVector[0].ordinal() <= State.mainRegion_State2__region0_State4__region0_State7__region0_State9
								.ordinal();
			case mainRegion_State2__region0_State4__region0_State6 :
				return stateVector[0] == State.mainRegion_State2__region0_State4__region0_State6;
			case mainRegion_State2__region0_State4__region0_State7 :
				return stateVector[0].ordinal() >= State.mainRegion_State2__region0_State4__region0_State7
						.ordinal()
						&& stateVector[0].ordinal() <= State.mainRegion_State2__region0_State4__region0_State7__region0_State9
								.ordinal();
			case mainRegion_State2__region0_State4__region0_State7__region0_State8 :
				return stateVector[0] == State.mainRegion_State2__region0_State4__region0_State7__region0_State8;
			case mainRegion_State2__region0_State4__region0_State7__region0_State9 :
				return stateVector[0] == State.mainRegion_State2__region0_State4__region0_State7__region0_State9;
			case mainRegion_State2__region0_State5 :
				return stateVector[0] == State.mainRegion_State2__region0_State5;
			default :
				return false;
		}
	}

	public SCInterface getSCInterface() {
		return sCInterface;
	}

	public void raiseEvent1() {
		sCInterface.raiseEvent1();
	}
	public void raiseEvent2() {
		sCInterface.raiseEvent2();
	}
	public void raiseEvent3() {
		sCInterface.raiseEvent3();
	}
	public void raiseEvent4() {
		sCInterface.raiseEvent4();
	}
	public void raiseEvent5() {
		sCInterface.raiseEvent5();
	}
	public void raiseEvent6() {
		sCInterface.raiseEvent6();
	}
	public void raiseEvent7() {
		sCInterface.raiseEvent7();
	}
	public void raiseEvent8() {
		sCInterface.raiseEvent8();
	}

	/* Entry action for statechart 'ShallowHistory'. */
	private void entryAction() {
	}

	/* Exit action for state 'ShallowHistory'. */
	private void exitAction() {
	}

	/* shallow enterSequence with history in child null */
	private void shallowEnterSequenceMainRegion_State2_region0() {
		switch (historyVector[0]) {
			case mainRegion_State2__region0_State3 :
				nextStateIndex = 0;
				stateVector[0] = State.mainRegion_State2__region0_State3;

				historyVector[0] = stateVector[0];
				break;

			case mainRegion_State2__region0_State4__region0_State6 :
				nextStateIndex = 0;
				stateVector[0] = State.mainRegion_State2__region0_State4__region0_State6;

				historyVector[0] = stateVector[0];
				break;

			case mainRegion_State2__region0_State4__region0_State7__region0_State8 :
				nextStateIndex = 0;
				stateVector[0] = State.mainRegion_State2__region0_State4__region0_State6;

				historyVector[0] = stateVector[0];
				break;

			case mainRegion_State2__region0_State4__region0_State7__region0_State9 :
				nextStateIndex = 0;
				stateVector[0] = State.mainRegion_State2__region0_State4__region0_State6;

				historyVector[0] = stateVector[0];
				break;

			case mainRegion_State2__region0_State5 :
				nextStateIndex = 0;
				stateVector[0] = State.mainRegion_State2__region0_State5;

				historyVector[0] = stateVector[0];
				break;

			default :
				break;
		}
	}

	/* shallow enterSequence with history in child null */
	private void shallowEnterSequenceMainRegion_State2_region0_State4_region0_State7_region0() {
		switch (historyVector[1]) {
			case mainRegion_State2__region0_State4__region0_State7__region0_State8 :
				nextStateIndex = 0;
				stateVector[0] = State.mainRegion_State2__region0_State4__region0_State7__region0_State8;

				historyVector[1] = stateVector[0];
				break;

			case mainRegion_State2__region0_State4__region0_State7__region0_State9 :
				nextStateIndex = 0;
				stateVector[0] = State.mainRegion_State2__region0_State4__region0_State7__region0_State9;

				historyVector[1] = stateVector[0];
				break;

			default :
				break;
		}
	}

	/* The reactions of state State1. */
	private void reactMainRegion_State1() {
		if (sCInterface.event1) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			/* Enter the region with shallow history */
			if (historyVector[0] != State.$NullState$) {
				shallowEnterSequenceMainRegion_State2_region0();
			} else {
				nextStateIndex = 0;
				stateVector[0] = State.mainRegion_State2__region0_State3;

				historyVector[0] = stateVector[0];
			}
		}
	}

	/* The reactions of state State3. */
	private void reactMainRegion_State2_region0_State3() {
		if (sCInterface.event2) {
			switch (stateVector[0]) {
				case mainRegion_State2__region0_State3 :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case mainRegion_State2__region0_State4__region0_State6 :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case mainRegion_State2__region0_State4__region0_State7__region0_State8 :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case mainRegion_State2__region0_State4__region0_State7__region0_State9 :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case mainRegion_State2__region0_State5 :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				default :
					break;
			}

			nextStateIndex = 0;
			stateVector[0] = State.mainRegion_State1;
		} else {
			if (sCInterface.event3) {
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				nextStateIndex = 0;
				stateVector[0] = State.mainRegion_State2__region0_State4__region0_State6;

				historyVector[0] = stateVector[0];
			}
		}
	}

	/* The reactions of state State6. */
	private void reactMainRegion_State2_region0_State4_region0_State6() {
		if (sCInterface.event2) {
			switch (stateVector[0]) {
				case mainRegion_State2__region0_State3 :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case mainRegion_State2__region0_State4__region0_State6 :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case mainRegion_State2__region0_State4__region0_State7__region0_State8 :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case mainRegion_State2__region0_State4__region0_State7__region0_State9 :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case mainRegion_State2__region0_State5 :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				default :
					break;
			}

			nextStateIndex = 0;
			stateVector[0] = State.mainRegion_State1;
		} else {
			if (sCInterface.event4) {
				switch (stateVector[0]) {
					case mainRegion_State2__region0_State4__region0_State6 :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					case mainRegion_State2__region0_State4__region0_State7__region0_State8 :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					case mainRegion_State2__region0_State4__region0_State7__region0_State9 :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					default :
						break;
				}

				nextStateIndex = 0;
				stateVector[0] = State.mainRegion_State2__region0_State5;

				historyVector[0] = stateVector[0];
			} else {
				if (sCInterface.event5) {
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					/* Enter the region with shallow history */
					if (historyVector[1] != State.$NullState$) {
						shallowEnterSequenceMainRegion_State2_region0_State4_region0_State7_region0();
					} else {
						nextStateIndex = 0;
						stateVector[0] = State.mainRegion_State2__region0_State4__region0_State7__region0_State8;

						historyVector[1] = stateVector[0];
					}
				}
			}
		}
	}

	/* The reactions of state State8. */
	private void reactMainRegion_State2_region0_State4_region0_State7_region0_State8() {
		if (sCInterface.event2) {
			switch (stateVector[0]) {
				case mainRegion_State2__region0_State3 :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case mainRegion_State2__region0_State4__region0_State6 :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case mainRegion_State2__region0_State4__region0_State7__region0_State8 :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case mainRegion_State2__region0_State4__region0_State7__region0_State9 :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case mainRegion_State2__region0_State5 :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				default :
					break;
			}

			nextStateIndex = 0;
			stateVector[0] = State.mainRegion_State1;
		} else {
			if (sCInterface.event4) {
				switch (stateVector[0]) {
					case mainRegion_State2__region0_State4__region0_State6 :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					case mainRegion_State2__region0_State4__region0_State7__region0_State8 :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					case mainRegion_State2__region0_State4__region0_State7__region0_State9 :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					default :
						break;
				}

				nextStateIndex = 0;
				stateVector[0] = State.mainRegion_State2__region0_State5;

				historyVector[0] = stateVector[0];
			} else {
				if (sCInterface.event6) {
					switch (stateVector[0]) {
						case mainRegion_State2__region0_State4__region0_State7__region0_State8 :
							nextStateIndex = 0;
							stateVector[0] = State.$NullState$;
							break;

						case mainRegion_State2__region0_State4__region0_State7__region0_State9 :
							nextStateIndex = 0;
							stateVector[0] = State.$NullState$;
							break;

						default :
							break;
					}

					nextStateIndex = 0;
					stateVector[0] = State.mainRegion_State2__region0_State4__region0_State6;
				} else {
					if (sCInterface.event7) {
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;

						nextStateIndex = 0;
						stateVector[0] = State.mainRegion_State2__region0_State4__region0_State7__region0_State9;

						historyVector[1] = stateVector[0];
					}
				}
			}
		}
	}

	/* The reactions of state State9. */
	private void reactMainRegion_State2_region0_State4_region0_State7_region0_State9() {
		if (sCInterface.event2) {
			switch (stateVector[0]) {
				case mainRegion_State2__region0_State3 :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case mainRegion_State2__region0_State4__region0_State6 :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case mainRegion_State2__region0_State4__region0_State7__region0_State8 :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case mainRegion_State2__region0_State4__region0_State7__region0_State9 :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case mainRegion_State2__region0_State5 :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				default :
					break;
			}

			nextStateIndex = 0;
			stateVector[0] = State.mainRegion_State1;
		} else {
			if (sCInterface.event4) {
				switch (stateVector[0]) {
					case mainRegion_State2__region0_State4__region0_State6 :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					case mainRegion_State2__region0_State4__region0_State7__region0_State8 :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					case mainRegion_State2__region0_State4__region0_State7__region0_State9 :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					default :
						break;
				}

				nextStateIndex = 0;
				stateVector[0] = State.mainRegion_State2__region0_State5;

				historyVector[0] = stateVector[0];
			} else {
				if (sCInterface.event6) {
					switch (stateVector[0]) {
						case mainRegion_State2__region0_State4__region0_State7__region0_State8 :
							nextStateIndex = 0;
							stateVector[0] = State.$NullState$;
							break;

						case mainRegion_State2__region0_State4__region0_State7__region0_State9 :
							nextStateIndex = 0;
							stateVector[0] = State.$NullState$;
							break;

						default :
							break;
					}

					nextStateIndex = 0;
					stateVector[0] = State.mainRegion_State2__region0_State4__region0_State6;
				} else {
					if (sCInterface.event8) {
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;

						nextStateIndex = 0;
						stateVector[0] = State.mainRegion_State2__region0_State4__region0_State7__region0_State8;

						historyVector[1] = stateVector[0];
					}
				}
			}
		}
	}

	/* The reactions of state State5. */
	private void reactMainRegion_State2_region0_State5() {
		if (sCInterface.event2) {
			switch (stateVector[0]) {
				case mainRegion_State2__region0_State3 :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case mainRegion_State2__region0_State4__region0_State6 :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case mainRegion_State2__region0_State4__region0_State7__region0_State8 :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case mainRegion_State2__region0_State4__region0_State7__region0_State9 :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case mainRegion_State2__region0_State5 :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				default :
					break;
			}

			nextStateIndex = 0;
			stateVector[0] = State.mainRegion_State1;
		} else {
		}
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case mainRegion_State1 :
					reactMainRegion_State1();
					break;
				case mainRegion_State2__region0_State3 :
					reactMainRegion_State2_region0_State3();
					break;
				case mainRegion_State2__region0_State4__region0_State6 :
					reactMainRegion_State2_region0_State4_region0_State6();
					break;
				case mainRegion_State2__region0_State4__region0_State7__region0_State8 :
					reactMainRegion_State2_region0_State4_region0_State7_region0_State8();
					break;
				case mainRegion_State2__region0_State4__region0_State7__region0_State9 :
					reactMainRegion_State2_region0_State4_region0_State7_region0_State9();
					break;
				case mainRegion_State2__region0_State5 :
					reactMainRegion_State2_region0_State5();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
