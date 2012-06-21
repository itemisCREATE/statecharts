package org.yakindu.sct.generator.java.runtime.cyclebased.test_parallelregions;

public class Test_ParallelRegionsStatemachine
		implements
			ITest_ParallelRegionsStatemachine {

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
			this.reg3 = value;
		}

		private int hierarchy;

		public int getHierarchy() {
			return hierarchy;
		}

		public void setHierarchy(int value) {
			this.hierarchy = value;
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

	private SCIDefaultImpl sCIDefault;

	public enum State {
		MainRegion_State1, MainRegion_State2, MainRegion_State2_Region1_State3, MainRegion_State2_Region1_State4, MainRegion_State2_Region1_State4_Region2_State5, MainRegion_State2_Region1_State4_Region2_State6, MainRegion_State2_Region1_State4_Region4_State9, MainRegion_State2_Region3_State7, MainRegion_State2_Region3_State8, $NullState$
	};

	private final State[] stateVector = new State[3];

	private int nextStateIndex;

	public Test_ParallelRegionsStatemachine() {

		sCIDefault = new SCIDefaultImpl();

	}

	public void init() {
		for (int i = 0; i < 3; i++) {
			stateVector[i] = State.$NullState$;
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

	public void raiseEvent9() {
		sCIDefault.raiseEvent9();
	}

	public void raiseEvent10() {
		sCIDefault.raiseEvent10();
	}

	public void raiseEvent11() {
		sCIDefault.raiseEvent11();
	}

	public void raiseEvent12() {
		sCIDefault.raiseEvent12();
	}

	public void raiseEvent13() {
		sCIDefault.raiseEvent13();
	}

	public void raiseEvent14() {
		sCIDefault.raiseEvent14();
	}

	public int getReg3() {
		return sCIDefault.getReg3();
	}

	public void setReg3(int value) {
		sCIDefault.setReg3(value);
	}
	public int getHierarchy() {
		return sCIDefault.getHierarchy();
	}

	public void setHierarchy(int value) {
		sCIDefault.setHierarchy(value);
	}

	public void enter() {
		sCIDefault.setReg3(-(1));

		// unknown function type org.yakindu.sct.model.sexec.impl.SequenceImpl@182ac83f (name: entryAction) (comment: Entry action for statechart 'Test_ParallelRegions'.)();
		nextStateIndex = 0;
		stateVector[0] = State.MainRegion_State1;

	}

	public void exit() {
		//Handle exit of all possible states (of mainRegion) at position 0...
		switch (stateVector[0]) {

			case MainRegion_State1 :
				stateVector[0] = State.$NullState$;
				sCIDefault.setHierarchy(2);

				break;

			case MainRegion_State2_Region1_State3 :
				stateVector[0] = State.$NullState$;

				break;

			case MainRegion_State2_Region1_State4_Region2_State5 :
				stateVector[0] = State.$NullState$;
				sCIDefault.setHierarchy(sCIDefault.getHierarchy() - (5));

				break;

			case MainRegion_State2_Region1_State4_Region2_State6 :
				stateVector[0] = State.$NullState$;
				sCIDefault.setHierarchy(sCIDefault.getHierarchy() - (6));

				break;

			default :
				break;
		}
		//Handle exit of all possible states (of mainRegion) at position 1...
		switch (stateVector[1]) {

			case MainRegion_State2_Region1_State4_Region4_State9 :
				stateVector[1] = State.$NullState$;
				sCIDefault.setHierarchy(sCIDefault.getHierarchy() - (10));

				sCIDefault.setHierarchy(sCIDefault.getHierarchy() / (4));

				break;

			default :
				break;
		}
		//Handle exit of all possible states (of mainRegion) at position 2...
		switch (stateVector[2]) {

			case MainRegion_State2_Region3_State7 :
				stateVector[2] = State.$NullState$;
				sCIDefault.setReg3(-(1));

				sCIDefault.setHierarchy(sCIDefault.getHierarchy() - (3));

				break;

			case MainRegion_State2_Region3_State8 :
				stateVector[2] = State.$NullState$;
				sCIDefault.setReg3(-(1));

				sCIDefault.setHierarchy(sCIDefault.getHierarchy() - (3));

				break;

			default :
				break;
		}

		// unknown function type org.yakindu.sct.model.sexec.impl.SequenceImpl@60188b9b (name: exitAction) (comment: Exit action for state 'Test_ParallelRegions'.)();
	}

	private void reactMainRegion_State1() {
		if (sCIDefault.event1) {
			stateVector[0] = State.$NullState$;
			sCIDefault.setHierarchy(2);

			sCIDefault.setHierarchy(sCIDefault.getHierarchy() + (3));

			nextStateIndex = 0;
			stateVector[0] = State.MainRegion_State2_Region1_State3;

			sCIDefault.setReg3(7);

			nextStateIndex = 2;
			stateVector[2] = State.MainRegion_State2_Region3_State7;

		} else {
			if (sCIDefault.event11) {
				stateVector[0] = State.$NullState$;
				sCIDefault.setHierarchy(2);

				sCIDefault.setHierarchy(sCIDefault.getHierarchy() + (3));

				sCIDefault.setHierarchy(sCIDefault.getHierarchy() * (4));

				sCIDefault.setHierarchy(sCIDefault.getHierarchy() + (6));

				nextStateIndex = 0;
				stateVector[0] = State.MainRegion_State2_Region1_State4_Region2_State6;

				sCIDefault.setHierarchy(sCIDefault.getHierarchy() + (10));

				nextStateIndex = 1;
				stateVector[1] = State.MainRegion_State2_Region1_State4_Region4_State9;

				sCIDefault.setReg3(7);

				nextStateIndex = 2;
				stateVector[2] = State.MainRegion_State2_Region3_State7;

			} else {
				if (sCIDefault.event12) {
					stateVector[0] = State.$NullState$;
					sCIDefault.setHierarchy(2);

					sCIDefault.setHierarchy(sCIDefault.getHierarchy() + (3));

					nextStateIndex = 0;
					stateVector[0] = State.MainRegion_State2_Region1_State3;

					sCIDefault.setReg3(8);

					nextStateIndex = 2;
					stateVector[2] = State.MainRegion_State2_Region3_State8;

				} else {
					if (sCIDefault.event13) {
						stateVector[0] = State.$NullState$;
						sCIDefault.setHierarchy(2);

						sCIDefault
								.setHierarchy(sCIDefault.getHierarchy() + (3));

						sCIDefault
								.setHierarchy(sCIDefault.getHierarchy() * (4));

						sCIDefault
								.setHierarchy(sCIDefault.getHierarchy() + (5));

						nextStateIndex = 0;
						stateVector[0] = State.MainRegion_State2_Region1_State4_Region2_State5;

						sCIDefault
								.setHierarchy(sCIDefault.getHierarchy() + (10));

						nextStateIndex = 1;
						stateVector[1] = State.MainRegion_State2_Region1_State4_Region4_State9;

						sCIDefault.setReg3(7);

						nextStateIndex = 2;
						stateVector[2] = State.MainRegion_State2_Region3_State7;

					}
				}
			}
		}

	}
	private void reactMainRegion_State2() {
	}
	private void reactMainRegion_State2_Region1_State3() {
		if (sCIDefault.event10) {
			//Handle exit of all possible states (of Region1) at position 0...
			switch (stateVector[0]) {

				case MainRegion_State2_Region1_State3 :
					stateVector[0] = State.$NullState$;

					break;

				case MainRegion_State2_Region1_State4_Region2_State5 :
					stateVector[0] = State.$NullState$;
					sCIDefault.setHierarchy(sCIDefault.getHierarchy() - (5));

					break;

				case MainRegion_State2_Region1_State4_Region2_State6 :
					stateVector[0] = State.$NullState$;
					sCIDefault.setHierarchy(sCIDefault.getHierarchy() - (6));

					break;

				default :
					break;
			}
			//Handle exit of all possible states (of Region1) at position 1...
			switch (stateVector[1]) {

				case MainRegion_State2_Region1_State4_Region4_State9 :
					stateVector[1] = State.$NullState$;
					sCIDefault.setHierarchy(sCIDefault.getHierarchy() - (10));

					sCIDefault.setHierarchy(sCIDefault.getHierarchy() / (4));

					break;

				default :
					break;
			}

			//Handle exit of all possible states (of Region3) at position 2...
			switch (stateVector[2]) {

				case MainRegion_State2_Region3_State7 :
					stateVector[2] = State.$NullState$;
					sCIDefault.setReg3(-(1));

					break;

				case MainRegion_State2_Region3_State8 :
					stateVector[2] = State.$NullState$;
					sCIDefault.setReg3(-(1));

					break;

				default :
					break;
			}

			sCIDefault.setHierarchy(sCIDefault.getHierarchy() - (3));

			nextStateIndex = 0;
			stateVector[0] = State.MainRegion_State1;

		} else {
			if (sCIDefault.event2) {
				stateVector[0] = State.$NullState$;

				sCIDefault.setHierarchy(sCIDefault.getHierarchy() * (4));

				sCIDefault.setHierarchy(sCIDefault.getHierarchy() + (5));

				nextStateIndex = 0;
				stateVector[0] = State.MainRegion_State2_Region1_State4_Region2_State5;

				sCIDefault.setHierarchy(sCIDefault.getHierarchy() + (10));

				nextStateIndex = 1;
				stateVector[1] = State.MainRegion_State2_Region1_State4_Region4_State9;

			} else {
				if ((sCIDefault.event3 || sCIDefault.event9)) {
					//Handle exit of all possible states (of Region1) at position 0...
					switch (stateVector[0]) {

						case MainRegion_State2_Region1_State3 :
							stateVector[0] = State.$NullState$;

							break;

						case MainRegion_State2_Region1_State4_Region2_State5 :
							stateVector[0] = State.$NullState$;
							sCIDefault
									.setHierarchy(sCIDefault.getHierarchy() - (5));

							break;

						case MainRegion_State2_Region1_State4_Region2_State6 :
							stateVector[0] = State.$NullState$;
							sCIDefault
									.setHierarchy(sCIDefault.getHierarchy() - (6));

							break;

						default :
							break;
					}
					//Handle exit of all possible states (of Region1) at position 1...
					switch (stateVector[1]) {

						case MainRegion_State2_Region1_State4_Region4_State9 :
							stateVector[1] = State.$NullState$;
							sCIDefault
									.setHierarchy(sCIDefault.getHierarchy() - (10));

							sCIDefault
									.setHierarchy(sCIDefault.getHierarchy() / (4));

							break;

						default :
							break;
					}

					//Handle exit of all possible states (of Region3) at position 2...
					switch (stateVector[2]) {

						case MainRegion_State2_Region3_State7 :
							stateVector[2] = State.$NullState$;
							sCIDefault.setReg3(-(1));

							break;

						case MainRegion_State2_Region3_State8 :
							stateVector[2] = State.$NullState$;
							sCIDefault.setReg3(-(1));

							break;

						default :
							break;
					}

					sCIDefault.setHierarchy(sCIDefault.getHierarchy() - (3));

					nextStateIndex = 0;
					stateVector[0] = State.MainRegion_State1;

				}
			}

		}

	}
	private void reactMainRegion_State2_Region1_State4() {
	}
	private void reactMainRegion_State2_Region1_State4_Region2_State5() {
		if (sCIDefault.event10) {
			//Handle exit of all possible states (of Region1) at position 0...
			switch (stateVector[0]) {

				case MainRegion_State2_Region1_State3 :
					stateVector[0] = State.$NullState$;

					break;

				case MainRegion_State2_Region1_State4_Region2_State5 :
					stateVector[0] = State.$NullState$;
					sCIDefault.setHierarchy(sCIDefault.getHierarchy() - (5));

					break;

				case MainRegion_State2_Region1_State4_Region2_State6 :
					stateVector[0] = State.$NullState$;
					sCIDefault.setHierarchy(sCIDefault.getHierarchy() - (6));

					break;

				default :
					break;
			}
			//Handle exit of all possible states (of Region1) at position 1...
			switch (stateVector[1]) {

				case MainRegion_State2_Region1_State4_Region4_State9 :
					stateVector[1] = State.$NullState$;
					sCIDefault.setHierarchy(sCIDefault.getHierarchy() - (10));

					sCIDefault.setHierarchy(sCIDefault.getHierarchy() / (4));

					break;

				default :
					break;
			}

			//Handle exit of all possible states (of Region3) at position 2...
			switch (stateVector[2]) {

				case MainRegion_State2_Region3_State7 :
					stateVector[2] = State.$NullState$;
					sCIDefault.setReg3(-(1));

					break;

				case MainRegion_State2_Region3_State8 :
					stateVector[2] = State.$NullState$;
					sCIDefault.setReg3(-(1));

					break;

				default :
					break;
			}

			sCIDefault.setHierarchy(sCIDefault.getHierarchy() - (3));

			nextStateIndex = 0;
			stateVector[0] = State.MainRegion_State1;

		} else {
			if (sCIDefault.event14) {
				//Handle exit of all possible states (of Region1) at position 0...
				switch (stateVector[0]) {

					case MainRegion_State2_Region1_State3 :
						stateVector[0] = State.$NullState$;

						break;

					case MainRegion_State2_Region1_State4_Region2_State5 :
						stateVector[0] = State.$NullState$;
						sCIDefault
								.setHierarchy(sCIDefault.getHierarchy() - (5));

						break;

					case MainRegion_State2_Region1_State4_Region2_State6 :
						stateVector[0] = State.$NullState$;
						sCIDefault
								.setHierarchy(sCIDefault.getHierarchy() - (6));

						break;

					default :
						break;
				}
				//Handle exit of all possible states (of Region1) at position 1...
				switch (stateVector[1]) {

					case MainRegion_State2_Region1_State4_Region4_State9 :
						stateVector[1] = State.$NullState$;
						sCIDefault
								.setHierarchy(sCIDefault.getHierarchy() - (10));

						sCIDefault
								.setHierarchy(sCIDefault.getHierarchy() / (4));

						break;

					default :
						break;
				}

				//Handle exit of all possible states (of Region3) at position 2...
				switch (stateVector[2]) {

					case MainRegion_State2_Region3_State7 :
						stateVector[2] = State.$NullState$;
						sCIDefault.setReg3(-(1));

						break;

					case MainRegion_State2_Region3_State8 :
						stateVector[2] = State.$NullState$;
						sCIDefault.setReg3(-(1));

						break;

					default :
						break;
				}

				sCIDefault.setHierarchy(sCIDefault.getHierarchy() - (3));

				nextStateIndex = 0;
				stateVector[0] = State.MainRegion_State1;

			} else {
				if (sCIDefault.event3) {
					stateVector[0] = State.$NullState$;
					sCIDefault.setHierarchy(sCIDefault.getHierarchy() - (5));

					sCIDefault.setHierarchy(sCIDefault.getHierarchy() + (6));

					nextStateIndex = 0;
					stateVector[0] = State.MainRegion_State2_Region1_State4_Region2_State6;

				}

			}

		}

	}
	private void reactMainRegion_State2_Region1_State4_Region2_State6() {
		if (sCIDefault.event10) {
			//Handle exit of all possible states (of Region1) at position 0...
			switch (stateVector[0]) {

				case MainRegion_State2_Region1_State3 :
					stateVector[0] = State.$NullState$;

					break;

				case MainRegion_State2_Region1_State4_Region2_State5 :
					stateVector[0] = State.$NullState$;
					sCIDefault.setHierarchy(sCIDefault.getHierarchy() - (5));

					break;

				case MainRegion_State2_Region1_State4_Region2_State6 :
					stateVector[0] = State.$NullState$;
					sCIDefault.setHierarchy(sCIDefault.getHierarchy() - (6));

					break;

				default :
					break;
			}
			//Handle exit of all possible states (of Region1) at position 1...
			switch (stateVector[1]) {

				case MainRegion_State2_Region1_State4_Region4_State9 :
					stateVector[1] = State.$NullState$;
					sCIDefault.setHierarchy(sCIDefault.getHierarchy() - (10));

					sCIDefault.setHierarchy(sCIDefault.getHierarchy() / (4));

					break;

				default :
					break;
			}

			//Handle exit of all possible states (of Region3) at position 2...
			switch (stateVector[2]) {

				case MainRegion_State2_Region3_State7 :
					stateVector[2] = State.$NullState$;
					sCIDefault.setReg3(-(1));

					break;

				case MainRegion_State2_Region3_State8 :
					stateVector[2] = State.$NullState$;
					sCIDefault.setReg3(-(1));

					break;

				default :
					break;
			}

			sCIDefault.setHierarchy(sCIDefault.getHierarchy() - (3));

			nextStateIndex = 0;
			stateVector[0] = State.MainRegion_State1;

		} else {
			if (sCIDefault.event14) {
				//Handle exit of all possible states (of Region1) at position 0...
				switch (stateVector[0]) {

					case MainRegion_State2_Region1_State3 :
						stateVector[0] = State.$NullState$;

						break;

					case MainRegion_State2_Region1_State4_Region2_State5 :
						stateVector[0] = State.$NullState$;
						sCIDefault
								.setHierarchy(sCIDefault.getHierarchy() - (5));

						break;

					case MainRegion_State2_Region1_State4_Region2_State6 :
						stateVector[0] = State.$NullState$;
						sCIDefault
								.setHierarchy(sCIDefault.getHierarchy() - (6));

						break;

					default :
						break;
				}
				//Handle exit of all possible states (of Region1) at position 1...
				switch (stateVector[1]) {

					case MainRegion_State2_Region1_State4_Region4_State9 :
						stateVector[1] = State.$NullState$;
						sCIDefault
								.setHierarchy(sCIDefault.getHierarchy() - (10));

						sCIDefault
								.setHierarchy(sCIDefault.getHierarchy() / (4));

						break;

					default :
						break;
				}

				//Handle exit of all possible states (of Region3) at position 2...
				switch (stateVector[2]) {

					case MainRegion_State2_Region3_State7 :
						stateVector[2] = State.$NullState$;
						sCIDefault.setReg3(-(1));

						break;

					case MainRegion_State2_Region3_State8 :
						stateVector[2] = State.$NullState$;
						sCIDefault.setReg3(-(1));

						break;

					default :
						break;
				}

				sCIDefault.setHierarchy(sCIDefault.getHierarchy() - (3));

				nextStateIndex = 0;
				stateVector[0] = State.MainRegion_State1;

			} else {
				if (sCIDefault.event4) {
					stateVector[0] = State.$NullState$;
					sCIDefault.setHierarchy(sCIDefault.getHierarchy() - (6));

					sCIDefault.setHierarchy(sCIDefault.getHierarchy() + (5));

					nextStateIndex = 0;
					stateVector[0] = State.MainRegion_State2_Region1_State4_Region2_State5;

				}

			}

		}

	}
	private void reactMainRegion_State2_Region1_State4_Region4_State9() {
		if (sCIDefault.event8) {
			//Handle exit of all possible states (of Region1) at position 0...
			switch (stateVector[0]) {

				case MainRegion_State2_Region1_State3 :
					stateVector[0] = State.$NullState$;

					break;

				case MainRegion_State2_Region1_State4_Region2_State5 :
					stateVector[0] = State.$NullState$;
					sCIDefault.setHierarchy(sCIDefault.getHierarchy() - (5));

					break;

				case MainRegion_State2_Region1_State4_Region2_State6 :
					stateVector[0] = State.$NullState$;
					sCIDefault.setHierarchy(sCIDefault.getHierarchy() - (6));

					break;

				default :
					break;
			}
			//Handle exit of all possible states (of Region1) at position 1...
			switch (stateVector[1]) {

				case MainRegion_State2_Region1_State4_Region4_State9 :
					stateVector[1] = State.$NullState$;
					sCIDefault.setHierarchy(sCIDefault.getHierarchy() - (10));

					sCIDefault.setHierarchy(sCIDefault.getHierarchy() / (4));

					break;

				default :
					break;
			}

			//Handle exit of all possible states (of Region3) at position 2...
			switch (stateVector[2]) {

				case MainRegion_State2_Region3_State7 :
					stateVector[2] = State.$NullState$;
					sCIDefault.setReg3(-(1));

					break;

				case MainRegion_State2_Region3_State8 :
					stateVector[2] = State.$NullState$;
					sCIDefault.setReg3(-(1));

					break;

				default :
					break;
			}

			sCIDefault.setHierarchy(sCIDefault.getHierarchy() - (3));

			nextStateIndex = 0;
			stateVector[0] = State.MainRegion_State1;

		}
	}
	private void reactMainRegion_State2_Region3_State7() {
		if ((sCIDefault.event5 || sCIDefault.event3)) {
			stateVector[2] = State.$NullState$;
			sCIDefault.setReg3(-(1));

			sCIDefault.setReg3(8);

			nextStateIndex = 2;
			stateVector[2] = State.MainRegion_State2_Region3_State8;

		} else {
			if (sCIDefault.event7) {
				//Handle exit of all possible states (of Region1) at position 0...
				switch (stateVector[0]) {

					case MainRegion_State2_Region1_State3 :
						stateVector[0] = State.$NullState$;

						break;

					case MainRegion_State2_Region1_State4_Region2_State5 :
						stateVector[0] = State.$NullState$;
						sCIDefault
								.setHierarchy(sCIDefault.getHierarchy() - (5));

						break;

					case MainRegion_State2_Region1_State4_Region2_State6 :
						stateVector[0] = State.$NullState$;
						sCIDefault
								.setHierarchy(sCIDefault.getHierarchy() - (6));

						break;

					default :
						break;
				}
				//Handle exit of all possible states (of Region1) at position 1...
				switch (stateVector[1]) {

					case MainRegion_State2_Region1_State4_Region4_State9 :
						stateVector[1] = State.$NullState$;
						sCIDefault
								.setHierarchy(sCIDefault.getHierarchy() - (10));

						sCIDefault
								.setHierarchy(sCIDefault.getHierarchy() / (4));

						break;

					default :
						break;
				}

				//Handle exit of all possible states (of Region3) at position 2...
				switch (stateVector[2]) {

					case MainRegion_State2_Region3_State7 :
						stateVector[2] = State.$NullState$;
						sCIDefault.setReg3(-(1));

						break;

					case MainRegion_State2_Region3_State8 :
						stateVector[2] = State.$NullState$;
						sCIDefault.setReg3(-(1));

						break;

					default :
						break;
				}

				sCIDefault.setHierarchy(sCIDefault.getHierarchy() - (3));

				nextStateIndex = 0;
				stateVector[0] = State.MainRegion_State1;

			}
		}
	}
	private void reactMainRegion_State2_Region3_State8() {
		if (sCIDefault.event6) {
			stateVector[2] = State.$NullState$;
			sCIDefault.setReg3(-(1));

			sCIDefault.setReg3(7);

			nextStateIndex = 2;
			stateVector[2] = State.MainRegion_State2_Region3_State7;

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
				case MainRegion_State2_Region1_State3 :
					reactMainRegion_State2_Region1_State3();
					break;
				case MainRegion_State2_Region1_State4 :
					reactMainRegion_State2_Region1_State4();
					break;
				case MainRegion_State2_Region1_State4_Region2_State5 :
					reactMainRegion_State2_Region1_State4_Region2_State5();
					break;
				case MainRegion_State2_Region1_State4_Region2_State6 :
					reactMainRegion_State2_Region1_State4_Region2_State6();
					break;
				case MainRegion_State2_Region1_State4_Region4_State9 :
					reactMainRegion_State2_Region1_State4_Region4_State9();
					break;
				case MainRegion_State2_Region3_State7 :
					reactMainRegion_State2_Region3_State7();
					break;
				case MainRegion_State2_Region3_State8 :
					reactMainRegion_State2_Region3_State8();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
