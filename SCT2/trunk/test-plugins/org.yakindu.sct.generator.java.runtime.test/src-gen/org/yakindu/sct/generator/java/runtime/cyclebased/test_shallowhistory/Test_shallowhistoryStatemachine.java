package org.yakindu.sct.generator.java.runtime.cyclebased.test_shallowhistory;

public class Test_shallowhistoryStatemachine
		implements
			ITest_shallowhistoryStatemachine {

	private final class DefaultInterfaceImpl implements DefaultInterface {

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

	private DefaultInterfaceImpl defaultInterface;

	public enum State {
		State1, State2, State3, State4, State6, State7, State8, State9, State5, $NullState$
	};

	private State[] historyVector = new State[2];

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public Test_shallowhistoryStatemachine() {

		defaultInterface = new DefaultInterfaceImpl();

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
		defaultInterface.clearEvents();

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

	public DefaultInterface getDefaultInterface() {
		return defaultInterface;
	}

	public void raiseEvent1() {
		defaultInterface.raiseEvent1();
	}

	public void raiseEvent2() {
		defaultInterface.raiseEvent2();
	}

	public void raiseEvent3() {
		defaultInterface.raiseEvent3();
	}

	public void raiseEvent4() {
		defaultInterface.raiseEvent4();
	}

	public void raiseEvent5() {
		defaultInterface.raiseEvent5();
	}

	public void raiseEvent6() {
		defaultInterface.raiseEvent6();
	}

	public void raiseEvent7() {
		defaultInterface.raiseEvent7();
	}

	public void raiseEvent8() {
		defaultInterface.raiseEvent8();
	}

	public void enter() {

		// unknown function type org.yakindu.sct.model.sexec.impl.SequenceImpl@33292437 (name: entryAction) (comment: Entry action for statechart 'Test_ShallowHistory'.)();
		nextStateIndex = 0;
		stateVector[0] = State.State1;

	}

	public void exit() {
		//Handle exit of all possible states (of mainRegion) at position 0...
		switch (stateVector[0]) {

			case State1 :
				stateVector[0] = State.$NullState$;

				break;

			case State3 :

				historyVector[0] = stateVector[0];
				stateVector[0] = State.$NullState$;

				break;

			case State6 :

				historyVector[0] = stateVector[0];
				stateVector[0] = State.$NullState$;

				break;

			case State8 :

				historyVector[1] = stateVector[0];

				historyVector[0] = stateVector[0];
				stateVector[0] = State.$NullState$;

				break;

			case State9 :

				historyVector[1] = stateVector[0];

				historyVector[0] = stateVector[0];
				stateVector[0] = State.$NullState$;

				break;

			case State5 :

				historyVector[0] = stateVector[0];
				stateVector[0] = State.$NullState$;

				break;

			default :
				break;
		}

		// unknown function type org.yakindu.sct.model.sexec.impl.SequenceImpl@5994519c (name: exitAction) (comment: Exit action for state 'Test_ShallowHistory'.)();
	}

	private void shallowEnterSequenceState2Region0() {
		//Handle shallow history entry of null
		switch (historyVector[0]) {

			case State3 :
				nextStateIndex = 0;
				stateVector[0] = State.State3;

				break;

			case State6 :
				nextStateIndex = 0;
				stateVector[0] = State.State6;

				break;

			case State8 :
				nextStateIndex = 0;
				stateVector[0] = State.State6;

				break;

			case State9 :
				nextStateIndex = 0;
				stateVector[0] = State.State6;

				break;

			case State5 :
				nextStateIndex = 0;
				stateVector[0] = State.State5;

				break;

			default :
				break;
		}
	}

	private void shallowEnterSequenceState7Region0() {
		//Handle shallow history entry of null
		switch (historyVector[1]) {

			case State8 :
				nextStateIndex = 0;
				stateVector[0] = State.State8;

				break;

			case State9 :
				nextStateIndex = 0;
				stateVector[0] = State.State9;

				break;

			default :
				break;
		}
	}
	private void reactState1() {
		if (defaultInterface.event1) {
			stateVector[0] = State.$NullState$;

			//Enter the region with shallow history
			if (historyVector[0] != State.$NullState$) {

				shallowEnterSequenceState2Region0();
			} else {
				nextStateIndex = 0;
				stateVector[0] = State.State3;

			}

		}

	}
	private void reactState2() {
	}
	private void reactState3() {
		if (defaultInterface.event2) {

			historyVector[0] = stateVector[0];
			//Handle exit of all possible states (of region0) at position 0...
			switch (stateVector[0]) {

				case State3 :
					stateVector[0] = State.$NullState$;

					break;

				case State6 :
					stateVector[0] = State.$NullState$;

					break;

				case State8 :

					historyVector[1] = stateVector[0];
					stateVector[0] = State.$NullState$;

					break;

				case State9 :

					historyVector[1] = stateVector[0];
					stateVector[0] = State.$NullState$;

					break;

				case State5 :
					stateVector[0] = State.$NullState$;

					break;

				default :
					break;
			}

			nextStateIndex = 0;
			stateVector[0] = State.State1;

		} else {
			if (defaultInterface.event3) {
				stateVector[0] = State.$NullState$;

				nextStateIndex = 0;
				stateVector[0] = State.State6;

			}

		}

	}
	private void reactState4() {
	}
	private void reactState6() {
		if (defaultInterface.event2) {

			historyVector[0] = stateVector[0];
			//Handle exit of all possible states (of region0) at position 0...
			switch (stateVector[0]) {

				case State3 :
					stateVector[0] = State.$NullState$;

					break;

				case State6 :
					stateVector[0] = State.$NullState$;

					break;

				case State8 :

					historyVector[1] = stateVector[0];
					stateVector[0] = State.$NullState$;

					break;

				case State9 :

					historyVector[1] = stateVector[0];
					stateVector[0] = State.$NullState$;

					break;

				case State5 :
					stateVector[0] = State.$NullState$;

					break;

				default :
					break;
			}

			nextStateIndex = 0;
			stateVector[0] = State.State1;

		} else {
			if (defaultInterface.event4) {
				//Handle exit of all possible states (of region0) at position 0...
				switch (stateVector[0]) {

					case State6 :
						stateVector[0] = State.$NullState$;

						break;

					case State8 :

						historyVector[1] = stateVector[0];
						stateVector[0] = State.$NullState$;

						break;

					case State9 :

						historyVector[1] = stateVector[0];
						stateVector[0] = State.$NullState$;

						break;

					default :
						break;
				}

				nextStateIndex = 0;
				stateVector[0] = State.State5;

			} else {
				if (defaultInterface.event5) {
					stateVector[0] = State.$NullState$;

					//Enter the region with shallow history
					if (historyVector[1] != State.$NullState$) {

						shallowEnterSequenceState7Region0();
					} else {
						nextStateIndex = 0;
						stateVector[0] = State.State8;

					}

				}

			}

		}

	}
	private void reactState7() {
	}
	private void reactState8() {
		if (defaultInterface.event2) {

			historyVector[0] = stateVector[0];
			//Handle exit of all possible states (of region0) at position 0...
			switch (stateVector[0]) {

				case State3 :
					stateVector[0] = State.$NullState$;

					break;

				case State6 :
					stateVector[0] = State.$NullState$;

					break;

				case State8 :

					historyVector[1] = stateVector[0];
					stateVector[0] = State.$NullState$;

					break;

				case State9 :

					historyVector[1] = stateVector[0];
					stateVector[0] = State.$NullState$;

					break;

				case State5 :
					stateVector[0] = State.$NullState$;

					break;

				default :
					break;
			}

			nextStateIndex = 0;
			stateVector[0] = State.State1;

		} else {
			if (defaultInterface.event4) {
				//Handle exit of all possible states (of region0) at position 0...
				switch (stateVector[0]) {

					case State6 :
						stateVector[0] = State.$NullState$;

						break;

					case State8 :

						historyVector[1] = stateVector[0];
						stateVector[0] = State.$NullState$;

						break;

					case State9 :

						historyVector[1] = stateVector[0];
						stateVector[0] = State.$NullState$;

						break;

					default :
						break;
				}

				nextStateIndex = 0;
				stateVector[0] = State.State5;

			} else {
				if (defaultInterface.event6) {

					historyVector[1] = stateVector[0];
					//Handle exit of all possible states (of region0) at position 0...
					switch (stateVector[0]) {

						case State8 :
							stateVector[0] = State.$NullState$;

							break;

						case State9 :
							stateVector[0] = State.$NullState$;

							break;

						default :
							break;
					}

					nextStateIndex = 0;
					stateVector[0] = State.State6;

				} else {
					if (defaultInterface.event7) {
						stateVector[0] = State.$NullState$;

						nextStateIndex = 0;
						stateVector[0] = State.State9;

					}

				}

			}

		}

	}
	private void reactState9() {
		if (defaultInterface.event2) {

			historyVector[0] = stateVector[0];
			//Handle exit of all possible states (of region0) at position 0...
			switch (stateVector[0]) {

				case State3 :
					stateVector[0] = State.$NullState$;

					break;

				case State6 :
					stateVector[0] = State.$NullState$;

					break;

				case State8 :

					historyVector[1] = stateVector[0];
					stateVector[0] = State.$NullState$;

					break;

				case State9 :

					historyVector[1] = stateVector[0];
					stateVector[0] = State.$NullState$;

					break;

				case State5 :
					stateVector[0] = State.$NullState$;

					break;

				default :
					break;
			}

			nextStateIndex = 0;
			stateVector[0] = State.State1;

		} else {
			if (defaultInterface.event4) {
				//Handle exit of all possible states (of region0) at position 0...
				switch (stateVector[0]) {

					case State6 :
						stateVector[0] = State.$NullState$;

						break;

					case State8 :

						historyVector[1] = stateVector[0];
						stateVector[0] = State.$NullState$;

						break;

					case State9 :

						historyVector[1] = stateVector[0];
						stateVector[0] = State.$NullState$;

						break;

					default :
						break;
				}

				nextStateIndex = 0;
				stateVector[0] = State.State5;

			} else {
				if (defaultInterface.event6) {

					historyVector[1] = stateVector[0];
					//Handle exit of all possible states (of region0) at position 0...
					switch (stateVector[0]) {

						case State8 :
							stateVector[0] = State.$NullState$;

							break;

						case State9 :
							stateVector[0] = State.$NullState$;

							break;

						default :
							break;
					}

					nextStateIndex = 0;
					stateVector[0] = State.State6;

				} else {
					if (defaultInterface.event8) {
						stateVector[0] = State.$NullState$;

						nextStateIndex = 0;
						stateVector[0] = State.State8;

					}

				}

			}

		}

	}
	private void reactState5() {
		if (defaultInterface.event2) {

			historyVector[0] = stateVector[0];
			//Handle exit of all possible states (of region0) at position 0...
			switch (stateVector[0]) {

				case State3 :
					stateVector[0] = State.$NullState$;

					break;

				case State6 :
					stateVector[0] = State.$NullState$;

					break;

				case State8 :

					historyVector[1] = stateVector[0];
					stateVector[0] = State.$NullState$;

					break;

				case State9 :

					historyVector[1] = stateVector[0];
					stateVector[0] = State.$NullState$;

					break;

				case State5 :
					stateVector[0] = State.$NullState$;

					break;

				default :
					break;
			}

			nextStateIndex = 0;
			stateVector[0] = State.State1;

		} else {

		}

	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case State1 :
					reactState1();
					break;
				case State2 :
					reactState2();
					break;
				case State3 :
					reactState3();
					break;
				case State4 :
					reactState4();
					break;
				case State6 :
					reactState6();
					break;
				case State7 :
					reactState7();
					break;
				case State8 :
					reactState8();
					break;
				case State9 :
					reactState9();
					break;
				case State5 :
					reactState5();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
