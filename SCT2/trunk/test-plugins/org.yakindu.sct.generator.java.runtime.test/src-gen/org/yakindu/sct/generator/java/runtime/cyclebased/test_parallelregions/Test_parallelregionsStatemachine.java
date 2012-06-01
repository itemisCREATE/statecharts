package org.yakindu.sct.generator.java.runtime.cyclebased.test_parallelregions;

public class Test_parallelregionsStatemachine
		implements
			ITest_parallelregionsStatemachine {

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

		private boolean event9;

		public void raiseEvent9() {
			event9 = true;
		}

		private boolean event10;

		public void raiseEvent10() {
			event10 = true;
		}

		private boolean event11;

		public void raiseEvent11() {
			event11 = true;
		}

		private boolean event12;

		public void raiseEvent12() {
			event12 = true;
		}

		private boolean event13;

		public void raiseEvent13() {
			event13 = true;
		}

		private boolean event14;

		public void raiseEvent14() {
			event14 = true;
		}

		private int reg3 = -(1);

		public int getReg3() {
			return reg3;
		}

		public void setReg3(int value) {
			reg3 = value;
		}

		private int hierarchy;

		public int getHierarchy() {
			return hierarchy;
		}

		public void setHierarchy(int value) {
			hierarchy = value;
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
			event9 = false;
			event10 = false;
			event11 = false;
			event12 = false;
			event13 = false;
			event14 = false;
		}

	}

	private DefaultInterfaceImpl defaultInterface;

	public enum State {
		State1, State2, State3, State4, State5, State6, State9, State7, State8, $NullState$
	};

	private final State[] stateVector = new State[3];

	private int nextStateIndex;

	public Test_parallelregionsStatemachine() {

		defaultInterface = new DefaultInterfaceImpl();

	}

	public void init() {
		for (int i = 0; i < 3; i++) {
			stateVector[i] = State.$NullState$;
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

	public void raiseEvent9() {
		defaultInterface.raiseEvent9();
	}

	public void raiseEvent10() {
		defaultInterface.raiseEvent10();
	}

	public void raiseEvent11() {
		defaultInterface.raiseEvent11();
	}

	public void raiseEvent12() {
		defaultInterface.raiseEvent12();
	}

	public void raiseEvent13() {
		defaultInterface.raiseEvent13();
	}

	public void raiseEvent14() {
		defaultInterface.raiseEvent14();
	}

	public int getReg3() {
		return defaultInterface.getReg3();
	}

	public void setReg3(int value) {
		defaultInterface.setReg3(value);
	}
	public int getHierarchy() {
		return defaultInterface.getHierarchy();
	}

	public void setHierarchy(int value) {
		defaultInterface.setHierarchy(value);
	}

	public void enter() {
		defaultInterface.setReg3(-(1));

		// unknown function type org.yakindu.sct.model.sexec.impl.SequenceImpl@2ab49724 (name: entryAction) (comment: Entry action for statechart 'Test_ParallelRegions'.)();
		nextStateIndex = 0;
		stateVector[0] = State.State1;

	}

	public void exit() {
		//Handle exit of all possible states (of mainRegion) at position 0...
		switch (stateVector[0]) {

			case State1 :
				stateVector[0] = State.$NullState$;
				defaultInterface.setHierarchy(2);

				break;

			case State3 :
				stateVector[0] = State.$NullState$;

				break;

			case State5 :
				stateVector[0] = State.$NullState$;
				defaultInterface
						.setHierarchy(defaultInterface.getHierarchy() - (5));

				break;

			case State6 :
				stateVector[0] = State.$NullState$;
				defaultInterface
						.setHierarchy(defaultInterface.getHierarchy() - (6));

				break;

			default :
				break;
		}
		//Handle exit of all possible states (of mainRegion) at position 1...
		switch (stateVector[1]) {

			case State9 :
				stateVector[1] = State.$NullState$;
				defaultInterface
						.setHierarchy(defaultInterface.getHierarchy() - (10));

				defaultInterface
						.setHierarchy(defaultInterface.getHierarchy() / (4));

				break;

			default :
				break;
		}
		//Handle exit of all possible states (of mainRegion) at position 2...
		switch (stateVector[2]) {

			case State7 :
				stateVector[2] = State.$NullState$;
				defaultInterface.setReg3(-(1));

				defaultInterface
						.setHierarchy(defaultInterface.getHierarchy() - (3));

				break;

			case State8 :
				stateVector[2] = State.$NullState$;
				defaultInterface.setReg3(-(1));

				defaultInterface
						.setHierarchy(defaultInterface.getHierarchy() - (3));

				break;

			default :
				break;
		}

		// unknown function type org.yakindu.sct.model.sexec.impl.SequenceImpl@528f11dc (name: exitAction) (comment: Exit action for state 'Test_ParallelRegions'.)();
	}

	private void reactState1() {
		if (defaultInterface.event1) {
			stateVector[0] = State.$NullState$;
			defaultInterface.setHierarchy(2);

			defaultInterface
					.setHierarchy(defaultInterface.getHierarchy() + (3));

			nextStateIndex = 0;
			stateVector[0] = State.State3;

			defaultInterface.setReg3(7);

			nextStateIndex = 2;
			stateVector[2] = State.State7;

		} else {
			if (defaultInterface.event11) {
				stateVector[0] = State.$NullState$;
				defaultInterface.setHierarchy(2);

				defaultInterface
						.setHierarchy(defaultInterface.getHierarchy() + (3));

				defaultInterface
						.setHierarchy(defaultInterface.getHierarchy() * (4));

				defaultInterface
						.setHierarchy(defaultInterface.getHierarchy() + (6));

				nextStateIndex = 0;
				stateVector[0] = State.State6;

				defaultInterface
						.setHierarchy(defaultInterface.getHierarchy() + (10));

				nextStateIndex = 1;
				stateVector[1] = State.State9;

				defaultInterface.setReg3(7);

				nextStateIndex = 2;
				stateVector[2] = State.State7;

			} else {
				if (defaultInterface.event12) {
					stateVector[0] = State.$NullState$;
					defaultInterface.setHierarchy(2);

					defaultInterface.setHierarchy(defaultInterface
							.getHierarchy() + (3));

					nextStateIndex = 0;
					stateVector[0] = State.State3;

					defaultInterface.setReg3(8);

					nextStateIndex = 2;
					stateVector[2] = State.State8;

				} else {
					if (defaultInterface.event13) {
						stateVector[0] = State.$NullState$;
						defaultInterface.setHierarchy(2);

						defaultInterface.setHierarchy(defaultInterface
								.getHierarchy() + (3));

						defaultInterface.setHierarchy(defaultInterface
								.getHierarchy() * (4));

						defaultInterface.setHierarchy(defaultInterface
								.getHierarchy() + (5));

						nextStateIndex = 0;
						stateVector[0] = State.State5;

						defaultInterface.setHierarchy(defaultInterface
								.getHierarchy() + (10));

						nextStateIndex = 1;
						stateVector[1] = State.State9;

						defaultInterface.setReg3(7);

						nextStateIndex = 2;
						stateVector[2] = State.State7;

					}
				}
			}
		}

	}
	private void reactState2() {
	}
	private void reactState3() {
		if (defaultInterface.event10) {
			//Handle exit of all possible states (of Region1) at position 0...
			switch (stateVector[0]) {

				case State3 :
					stateVector[0] = State.$NullState$;

					break;

				case State5 :
					stateVector[0] = State.$NullState$;
					defaultInterface.setHierarchy(defaultInterface
							.getHierarchy() - (5));

					break;

				case State6 :
					stateVector[0] = State.$NullState$;
					defaultInterface.setHierarchy(defaultInterface
							.getHierarchy() - (6));

					break;

				default :
					break;
			}
			//Handle exit of all possible states (of Region1) at position 1...
			switch (stateVector[1]) {

				case State9 :
					stateVector[1] = State.$NullState$;
					defaultInterface.setHierarchy(defaultInterface
							.getHierarchy() - (10));

					defaultInterface.setHierarchy(defaultInterface
							.getHierarchy() / (4));

					break;

				default :
					break;
			}

			//Handle exit of all possible states (of Region3) at position 2...
			switch (stateVector[2]) {

				case State7 :
					stateVector[2] = State.$NullState$;
					defaultInterface.setReg3(-(1));

					break;

				case State8 :
					stateVector[2] = State.$NullState$;
					defaultInterface.setReg3(-(1));

					break;

				default :
					break;
			}

			defaultInterface
					.setHierarchy(defaultInterface.getHierarchy() - (3));

			nextStateIndex = 0;
			stateVector[0] = State.State1;

		} else {
			if (defaultInterface.event2) {
				stateVector[0] = State.$NullState$;

				defaultInterface
						.setHierarchy(defaultInterface.getHierarchy() * (4));

				defaultInterface
						.setHierarchy(defaultInterface.getHierarchy() + (5));

				nextStateIndex = 0;
				stateVector[0] = State.State5;

				defaultInterface
						.setHierarchy(defaultInterface.getHierarchy() + (10));

				nextStateIndex = 1;
				stateVector[1] = State.State9;

			} else {
				if ((defaultInterface.event3 || defaultInterface.event9)) {
					//Handle exit of all possible states (of Region1) at position 0...
					switch (stateVector[0]) {

						case State3 :
							stateVector[0] = State.$NullState$;

							break;

						case State5 :
							stateVector[0] = State.$NullState$;
							defaultInterface.setHierarchy(defaultInterface
									.getHierarchy() - (5));

							break;

						case State6 :
							stateVector[0] = State.$NullState$;
							defaultInterface.setHierarchy(defaultInterface
									.getHierarchy() - (6));

							break;

						default :
							break;
					}
					//Handle exit of all possible states (of Region1) at position 1...
					switch (stateVector[1]) {

						case State9 :
							stateVector[1] = State.$NullState$;
							defaultInterface.setHierarchy(defaultInterface
									.getHierarchy() - (10));

							defaultInterface.setHierarchy(defaultInterface
									.getHierarchy() / (4));

							break;

						default :
							break;
					}

					//Handle exit of all possible states (of Region3) at position 2...
					switch (stateVector[2]) {

						case State7 :
							stateVector[2] = State.$NullState$;
							defaultInterface.setReg3(-(1));

							break;

						case State8 :
							stateVector[2] = State.$NullState$;
							defaultInterface.setReg3(-(1));

							break;

						default :
							break;
					}

					defaultInterface.setHierarchy(defaultInterface
							.getHierarchy() - (3));

					nextStateIndex = 0;
					stateVector[0] = State.State1;

				}
			}

		}

	}
	private void reactState4() {
	}
	private void reactState5() {
		if (defaultInterface.event10) {
			//Handle exit of all possible states (of Region1) at position 0...
			switch (stateVector[0]) {

				case State3 :
					stateVector[0] = State.$NullState$;

					break;

				case State5 :
					stateVector[0] = State.$NullState$;
					defaultInterface.setHierarchy(defaultInterface
							.getHierarchy() - (5));

					break;

				case State6 :
					stateVector[0] = State.$NullState$;
					defaultInterface.setHierarchy(defaultInterface
							.getHierarchy() - (6));

					break;

				default :
					break;
			}
			//Handle exit of all possible states (of Region1) at position 1...
			switch (stateVector[1]) {

				case State9 :
					stateVector[1] = State.$NullState$;
					defaultInterface.setHierarchy(defaultInterface
							.getHierarchy() - (10));

					defaultInterface.setHierarchy(defaultInterface
							.getHierarchy() / (4));

					break;

				default :
					break;
			}

			//Handle exit of all possible states (of Region3) at position 2...
			switch (stateVector[2]) {

				case State7 :
					stateVector[2] = State.$NullState$;
					defaultInterface.setReg3(-(1));

					break;

				case State8 :
					stateVector[2] = State.$NullState$;
					defaultInterface.setReg3(-(1));

					break;

				default :
					break;
			}

			defaultInterface
					.setHierarchy(defaultInterface.getHierarchy() - (3));

			nextStateIndex = 0;
			stateVector[0] = State.State1;

		} else {
			if (defaultInterface.event14) {
				//Handle exit of all possible states (of Region1) at position 0...
				switch (stateVector[0]) {

					case State3 :
						stateVector[0] = State.$NullState$;

						break;

					case State5 :
						stateVector[0] = State.$NullState$;
						defaultInterface.setHierarchy(defaultInterface
								.getHierarchy() - (5));

						break;

					case State6 :
						stateVector[0] = State.$NullState$;
						defaultInterface.setHierarchy(defaultInterface
								.getHierarchy() - (6));

						break;

					default :
						break;
				}
				//Handle exit of all possible states (of Region1) at position 1...
				switch (stateVector[1]) {

					case State9 :
						stateVector[1] = State.$NullState$;
						defaultInterface.setHierarchy(defaultInterface
								.getHierarchy() - (10));

						defaultInterface.setHierarchy(defaultInterface
								.getHierarchy() / (4));

						break;

					default :
						break;
				}

				//Handle exit of all possible states (of Region3) at position 2...
				switch (stateVector[2]) {

					case State7 :
						stateVector[2] = State.$NullState$;
						defaultInterface.setReg3(-(1));

						break;

					case State8 :
						stateVector[2] = State.$NullState$;
						defaultInterface.setReg3(-(1));

						break;

					default :
						break;
				}

				defaultInterface
						.setHierarchy(defaultInterface.getHierarchy() - (3));

				nextStateIndex = 0;
				stateVector[0] = State.State1;

			} else {
				if (defaultInterface.event3) {
					stateVector[0] = State.$NullState$;
					defaultInterface.setHierarchy(defaultInterface
							.getHierarchy() - (5));

					defaultInterface.setHierarchy(defaultInterface
							.getHierarchy() + (6));

					nextStateIndex = 0;
					stateVector[0] = State.State6;

				}

			}

		}

	}
	private void reactState6() {
		if (defaultInterface.event10) {
			//Handle exit of all possible states (of Region1) at position 0...
			switch (stateVector[0]) {

				case State3 :
					stateVector[0] = State.$NullState$;

					break;

				case State5 :
					stateVector[0] = State.$NullState$;
					defaultInterface.setHierarchy(defaultInterface
							.getHierarchy() - (5));

					break;

				case State6 :
					stateVector[0] = State.$NullState$;
					defaultInterface.setHierarchy(defaultInterface
							.getHierarchy() - (6));

					break;

				default :
					break;
			}
			//Handle exit of all possible states (of Region1) at position 1...
			switch (stateVector[1]) {

				case State9 :
					stateVector[1] = State.$NullState$;
					defaultInterface.setHierarchy(defaultInterface
							.getHierarchy() - (10));

					defaultInterface.setHierarchy(defaultInterface
							.getHierarchy() / (4));

					break;

				default :
					break;
			}

			//Handle exit of all possible states (of Region3) at position 2...
			switch (stateVector[2]) {

				case State7 :
					stateVector[2] = State.$NullState$;
					defaultInterface.setReg3(-(1));

					break;

				case State8 :
					stateVector[2] = State.$NullState$;
					defaultInterface.setReg3(-(1));

					break;

				default :
					break;
			}

			defaultInterface
					.setHierarchy(defaultInterface.getHierarchy() - (3));

			nextStateIndex = 0;
			stateVector[0] = State.State1;

		} else {
			if (defaultInterface.event14) {
				//Handle exit of all possible states (of Region1) at position 0...
				switch (stateVector[0]) {

					case State3 :
						stateVector[0] = State.$NullState$;

						break;

					case State5 :
						stateVector[0] = State.$NullState$;
						defaultInterface.setHierarchy(defaultInterface
								.getHierarchy() - (5));

						break;

					case State6 :
						stateVector[0] = State.$NullState$;
						defaultInterface.setHierarchy(defaultInterface
								.getHierarchy() - (6));

						break;

					default :
						break;
				}
				//Handle exit of all possible states (of Region1) at position 1...
				switch (stateVector[1]) {

					case State9 :
						stateVector[1] = State.$NullState$;
						defaultInterface.setHierarchy(defaultInterface
								.getHierarchy() - (10));

						defaultInterface.setHierarchy(defaultInterface
								.getHierarchy() / (4));

						break;

					default :
						break;
				}

				//Handle exit of all possible states (of Region3) at position 2...
				switch (stateVector[2]) {

					case State7 :
						stateVector[2] = State.$NullState$;
						defaultInterface.setReg3(-(1));

						break;

					case State8 :
						stateVector[2] = State.$NullState$;
						defaultInterface.setReg3(-(1));

						break;

					default :
						break;
				}

				defaultInterface
						.setHierarchy(defaultInterface.getHierarchy() - (3));

				nextStateIndex = 0;
				stateVector[0] = State.State1;

			} else {
				if (defaultInterface.event4) {
					stateVector[0] = State.$NullState$;
					defaultInterface.setHierarchy(defaultInterface
							.getHierarchy() - (6));

					defaultInterface.setHierarchy(defaultInterface
							.getHierarchy() + (5));

					nextStateIndex = 0;
					stateVector[0] = State.State5;

				}

			}

		}

	}
	private void reactState9() {
		if (defaultInterface.event8) {
			//Handle exit of all possible states (of Region1) at position 0...
			switch (stateVector[0]) {

				case State3 :
					stateVector[0] = State.$NullState$;

					break;

				case State5 :
					stateVector[0] = State.$NullState$;
					defaultInterface.setHierarchy(defaultInterface
							.getHierarchy() - (5));

					break;

				case State6 :
					stateVector[0] = State.$NullState$;
					defaultInterface.setHierarchy(defaultInterface
							.getHierarchy() - (6));

					break;

				default :
					break;
			}
			//Handle exit of all possible states (of Region1) at position 1...
			switch (stateVector[1]) {

				case State9 :
					stateVector[1] = State.$NullState$;
					defaultInterface.setHierarchy(defaultInterface
							.getHierarchy() - (10));

					defaultInterface.setHierarchy(defaultInterface
							.getHierarchy() / (4));

					break;

				default :
					break;
			}

			//Handle exit of all possible states (of Region3) at position 2...
			switch (stateVector[2]) {

				case State7 :
					stateVector[2] = State.$NullState$;
					defaultInterface.setReg3(-(1));

					break;

				case State8 :
					stateVector[2] = State.$NullState$;
					defaultInterface.setReg3(-(1));

					break;

				default :
					break;
			}

			defaultInterface
					.setHierarchy(defaultInterface.getHierarchy() - (3));

			nextStateIndex = 0;
			stateVector[0] = State.State1;

		}
	}
	private void reactState7() {
		if ((defaultInterface.event5 || defaultInterface.event3)) {
			stateVector[2] = State.$NullState$;
			defaultInterface.setReg3(-(1));

			defaultInterface.setReg3(8);

			nextStateIndex = 2;
			stateVector[2] = State.State8;

		} else {
			if (defaultInterface.event7) {
				//Handle exit of all possible states (of Region1) at position 0...
				switch (stateVector[0]) {

					case State3 :
						stateVector[0] = State.$NullState$;

						break;

					case State5 :
						stateVector[0] = State.$NullState$;
						defaultInterface.setHierarchy(defaultInterface
								.getHierarchy() - (5));

						break;

					case State6 :
						stateVector[0] = State.$NullState$;
						defaultInterface.setHierarchy(defaultInterface
								.getHierarchy() - (6));

						break;

					default :
						break;
				}
				//Handle exit of all possible states (of Region1) at position 1...
				switch (stateVector[1]) {

					case State9 :
						stateVector[1] = State.$NullState$;
						defaultInterface.setHierarchy(defaultInterface
								.getHierarchy() - (10));

						defaultInterface.setHierarchy(defaultInterface
								.getHierarchy() / (4));

						break;

					default :
						break;
				}

				//Handle exit of all possible states (of Region3) at position 2...
				switch (stateVector[2]) {

					case State7 :
						stateVector[2] = State.$NullState$;
						defaultInterface.setReg3(-(1));

						break;

					case State8 :
						stateVector[2] = State.$NullState$;
						defaultInterface.setReg3(-(1));

						break;

					default :
						break;
				}

				defaultInterface
						.setHierarchy(defaultInterface.getHierarchy() - (3));

				nextStateIndex = 0;
				stateVector[0] = State.State1;

			}
		}
	}
	private void reactState8() {
		if (defaultInterface.event6) {
			stateVector[2] = State.$NullState$;
			defaultInterface.setReg3(-(1));

			defaultInterface.setReg3(7);

			nextStateIndex = 2;
			stateVector[2] = State.State7;

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
				case State5 :
					reactState5();
					break;
				case State6 :
					reactState6();
					break;
				case State9 :
					reactState9();
					break;
				case State7 :
					reactState7();
					break;
				case State8 :
					reactState8();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
