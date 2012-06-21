package org.yakindu.sct.generator.java.runtime.cyclebased.test_hierarchy;

public class Test_HierarchyStatemachine implements ITest_HierarchyStatemachine {

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

		private boolean event15;

		public void raiseEvent15() {
			event15 = true;
		}

		private boolean event16;

		public void raiseEvent16() {
			event16 = true;
		}

		private int s1 = 0;

		public int getS1() {
			return s1;
		}

		public void setS1(int value) {
			this.s1 = value;
		}

		private int s2;

		public int getS2() {
			return s2;
		}

		public void setS2(int value) {
			this.s2 = value;
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
			event15 = false;
			event16 = false;
		}

	}

	private SCIDefaultImpl sCIDefault;

	public enum State {
		MainRegion_State1, MainRegion_State1_Region1_State9, MainRegion_State1_Region1_State10, MainRegion_State2, MainRegion_State2_Region2_State3, MainRegion_State2_Region2_State4, MainRegion_State2_Region2_State4_Region4_State5, MainRegion_State2_Region2_State4_Region4_State6, MainRegion_State2_Region2_State4_Region4_State6_Region6_State7, MainRegion_State2_Region2_State4_Region4_State6_Region6_State8, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public Test_HierarchyStatemachine() {

		sCIDefault = new SCIDefaultImpl();

	}

	public void init() {
		for (int i = 0; i < 1; i++) {
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

	public void raiseEvent15() {
		sCIDefault.raiseEvent15();
	}

	public void raiseEvent16() {
		sCIDefault.raiseEvent16();
	}

	public int getS1() {
		return sCIDefault.getS1();
	}

	public void setS1(int value) {
		sCIDefault.setS1(value);
	}
	public int getS2() {
		return sCIDefault.getS2();
	}

	public void setS2(int value) {
		sCIDefault.setS2(value);
	}

	public void enter() {
		sCIDefault.setS1(0);

		// unknown function type org.yakindu.sct.model.sexec.impl.SequenceImpl@260c3299 (name: entryAction) (comment: Entry action for statechart 'Test_Hierarchy'.)();
		sCIDefault.setS1(1);

		sCIDefault.setS1(sCIDefault.getS1() + (1));

		nextStateIndex = 0;
		stateVector[0] = State.MainRegion_State1_Region1_State9;

	}

	public void exit() {
		//Handle exit of all possible states (of mainRegion) at position 0...
		switch (stateVector[0]) {

			case MainRegion_State1_Region1_State9 :
				stateVector[0] = State.$NullState$;
				sCIDefault.setS1(sCIDefault.getS1() - (1));

				sCIDefault.setS1(sCIDefault.getS1() - (1));

				break;

			case MainRegion_State1_Region1_State10 :
				stateVector[0] = State.$NullState$;
				sCIDefault.setS1(sCIDefault.getS1() - (1));

				sCIDefault.setS1(sCIDefault.getS1() - (1));

				break;

			case MainRegion_State2_Region2_State3 :
				stateVector[0] = State.$NullState$;
				sCIDefault.setS2(sCIDefault.getS2() - (1));

				sCIDefault.setS2(sCIDefault.getS2() - (1));

				break;

			case MainRegion_State2_Region2_State4_Region4_State5 :
				stateVector[0] = State.$NullState$;
				sCIDefault.setS2(sCIDefault.getS2() - (1));

				sCIDefault.setS2(sCIDefault.getS2() - (1));

				sCIDefault.setS2(sCIDefault.getS2() - (1));

				break;

			case MainRegion_State2_Region2_State4_Region4_State6_Region6_State7 :
				stateVector[0] = State.$NullState$;
				sCIDefault.setS2(sCIDefault.getS2() - (1));

				sCIDefault.setS2(sCIDefault.getS2() - (1));

				sCIDefault.setS2(sCIDefault.getS2() - (1));

				sCIDefault.setS2(sCIDefault.getS2() - (1));

				break;

			case MainRegion_State2_Region2_State4_Region4_State6_Region6_State8 :
				stateVector[0] = State.$NullState$;
				sCIDefault.setS2(sCIDefault.getS2() - (1));

				sCIDefault.setS2(sCIDefault.getS2() - (1));

				sCIDefault.setS2(sCIDefault.getS2() - (1));

				sCIDefault.setS2(sCIDefault.getS2() - (1));

				break;

			default :
				break;
		}

		// unknown function type org.yakindu.sct.model.sexec.impl.SequenceImpl@4281f1c8 (name: exitAction) (comment: Exit action for state 'Test_Hierarchy'.)();
	}

	private void reactMainRegion_State1() {
	}
	private void reactMainRegion_State1_Region1_State9() {
		if (sCIDefault.event1) {
			//Handle exit of all possible states (of Region1) at position 0...
			switch (stateVector[0]) {

				case MainRegion_State1_Region1_State9 :
					stateVector[0] = State.$NullState$;
					sCIDefault.setS1(sCIDefault.getS1() - (1));

					break;

				case MainRegion_State1_Region1_State10 :
					stateVector[0] = State.$NullState$;
					sCIDefault.setS1(sCIDefault.getS1() - (1));

					break;

				default :
					break;
			}

			sCIDefault.setS1(sCIDefault.getS1() - (1));

			sCIDefault.setS2(1);

			sCIDefault.setS2(sCIDefault.getS2() + (1));

			nextStateIndex = 0;
			stateVector[0] = State.MainRegion_State2_Region2_State3;

		} else {
			if (sCIDefault.event9) {
				stateVector[0] = State.$NullState$;
				sCIDefault.setS1(sCIDefault.getS1() - (1));

				sCIDefault.setS1(sCIDefault.getS1() + (1));

				nextStateIndex = 0;
				stateVector[0] = State.MainRegion_State1_Region1_State10;

			}

		}

	}
	private void reactMainRegion_State1_Region1_State10() {
		if (sCIDefault.event1) {
			//Handle exit of all possible states (of Region1) at position 0...
			switch (stateVector[0]) {

				case MainRegion_State1_Region1_State9 :
					stateVector[0] = State.$NullState$;
					sCIDefault.setS1(sCIDefault.getS1() - (1));

					break;

				case MainRegion_State1_Region1_State10 :
					stateVector[0] = State.$NullState$;
					sCIDefault.setS1(sCIDefault.getS1() - (1));

					break;

				default :
					break;
			}

			sCIDefault.setS1(sCIDefault.getS1() - (1));

			sCIDefault.setS2(1);

			sCIDefault.setS2(sCIDefault.getS2() + (1));

			nextStateIndex = 0;
			stateVector[0] = State.MainRegion_State2_Region2_State3;

		} else {
			if (sCIDefault.event10) {
				stateVector[0] = State.$NullState$;
				sCIDefault.setS1(sCIDefault.getS1() - (1));

				sCIDefault.setS1(sCIDefault.getS1() + (1));

				nextStateIndex = 0;
				stateVector[0] = State.MainRegion_State1_Region1_State9;

			}

		}

	}
	private void reactMainRegion_State2() {
	}
	private void reactMainRegion_State2_Region2_State3() {
		if (sCIDefault.event6) {
			//Handle exit of all possible states (of Region2) at position 0...
			switch (stateVector[0]) {

				case MainRegion_State2_Region2_State3 :
					stateVector[0] = State.$NullState$;
					sCIDefault.setS2(sCIDefault.getS2() - (1));

					break;

				case MainRegion_State2_Region2_State4_Region4_State5 :
					stateVector[0] = State.$NullState$;
					sCIDefault.setS2(sCIDefault.getS2() - (1));

					sCIDefault.setS2(sCIDefault.getS2() - (1));

					break;

				case MainRegion_State2_Region2_State4_Region4_State6_Region6_State7 :
					stateVector[0] = State.$NullState$;
					sCIDefault.setS2(sCIDefault.getS2() - (1));

					sCIDefault.setS2(sCIDefault.getS2() - (1));

					sCIDefault.setS2(sCIDefault.getS2() - (1));

					break;

				case MainRegion_State2_Region2_State4_Region4_State6_Region6_State8 :
					stateVector[0] = State.$NullState$;
					sCIDefault.setS2(sCIDefault.getS2() - (1));

					sCIDefault.setS2(sCIDefault.getS2() - (1));

					sCIDefault.setS2(sCIDefault.getS2() - (1));

					break;

				default :
					break;
			}

			sCIDefault.setS2(sCIDefault.getS2() - (1));

			sCIDefault.setS1(1);

			sCIDefault.setS1(sCIDefault.getS1() + (1));

			nextStateIndex = 0;
			stateVector[0] = State.MainRegion_State1_Region1_State9;

		} else {
			if (sCIDefault.event2) {
				stateVector[0] = State.$NullState$;
				sCIDefault.setS2(sCIDefault.getS2() - (1));

				sCIDefault.setS2(sCIDefault.getS2() + (1));

				sCIDefault.setS2(sCIDefault.getS2() + (1));

				nextStateIndex = 0;
				stateVector[0] = State.MainRegion_State2_Region2_State4_Region4_State5;

			} else {
				if (sCIDefault.event11) {
					//Handle exit of all possible states (of Region2) at position 0...
					switch (stateVector[0]) {

						case MainRegion_State2_Region2_State3 :
							stateVector[0] = State.$NullState$;
							sCIDefault.setS2(sCIDefault.getS2() - (1));

							break;

						case MainRegion_State2_Region2_State4_Region4_State5 :
							stateVector[0] = State.$NullState$;
							sCIDefault.setS2(sCIDefault.getS2() - (1));

							sCIDefault.setS2(sCIDefault.getS2() - (1));

							break;

						case MainRegion_State2_Region2_State4_Region4_State6_Region6_State7 :
							stateVector[0] = State.$NullState$;
							sCIDefault.setS2(sCIDefault.getS2() - (1));

							sCIDefault.setS2(sCIDefault.getS2() - (1));

							sCIDefault.setS2(sCIDefault.getS2() - (1));

							break;

						case MainRegion_State2_Region2_State4_Region4_State6_Region6_State8 :
							stateVector[0] = State.$NullState$;
							sCIDefault.setS2(sCIDefault.getS2() - (1));

							sCIDefault.setS2(sCIDefault.getS2() - (1));

							sCIDefault.setS2(sCIDefault.getS2() - (1));

							break;

						default :
							break;
					}

					sCIDefault.setS2(sCIDefault.getS2() - (1));

					sCIDefault.setS1(1);

					sCIDefault.setS1(sCIDefault.getS1() + (1));

					nextStateIndex = 0;
					stateVector[0] = State.MainRegion_State1_Region1_State9;

				} else {
					if (sCIDefault.event14) {
						//Handle exit of all possible states (of Region2) at position 0...
						switch (stateVector[0]) {

							case MainRegion_State2_Region2_State3 :
								stateVector[0] = State.$NullState$;
								sCIDefault.setS2(sCIDefault.getS2() - (1));

								break;

							case MainRegion_State2_Region2_State4_Region4_State5 :
								stateVector[0] = State.$NullState$;
								sCIDefault.setS2(sCIDefault.getS2() - (1));

								sCIDefault.setS2(sCIDefault.getS2() - (1));

								break;

							case MainRegion_State2_Region2_State4_Region4_State6_Region6_State7 :
								stateVector[0] = State.$NullState$;
								sCIDefault.setS2(sCIDefault.getS2() - (1));

								sCIDefault.setS2(sCIDefault.getS2() - (1));

								sCIDefault.setS2(sCIDefault.getS2() - (1));

								break;

							case MainRegion_State2_Region2_State4_Region4_State6_Region6_State8 :
								stateVector[0] = State.$NullState$;
								sCIDefault.setS2(sCIDefault.getS2() - (1));

								sCIDefault.setS2(sCIDefault.getS2() - (1));

								sCIDefault.setS2(sCIDefault.getS2() - (1));

								break;

							default :
								break;
						}

						sCIDefault.setS2(sCIDefault.getS2() - (1));

						sCIDefault.setS1(1);

						sCIDefault.setS1(sCIDefault.getS1() + (1));

						nextStateIndex = 0;
						stateVector[0] = State.MainRegion_State1_Region1_State9;

					}
				}
			}

		}

	}
	private void reactMainRegion_State2_Region2_State4() {
	}
	private void reactMainRegion_State2_Region2_State4_Region4_State5() {
		if (sCIDefault.event6) {
			//Handle exit of all possible states (of Region2) at position 0...
			switch (stateVector[0]) {

				case MainRegion_State2_Region2_State3 :
					stateVector[0] = State.$NullState$;
					sCIDefault.setS2(sCIDefault.getS2() - (1));

					break;

				case MainRegion_State2_Region2_State4_Region4_State5 :
					stateVector[0] = State.$NullState$;
					sCIDefault.setS2(sCIDefault.getS2() - (1));

					sCIDefault.setS2(sCIDefault.getS2() - (1));

					break;

				case MainRegion_State2_Region2_State4_Region4_State6_Region6_State7 :
					stateVector[0] = State.$NullState$;
					sCIDefault.setS2(sCIDefault.getS2() - (1));

					sCIDefault.setS2(sCIDefault.getS2() - (1));

					sCIDefault.setS2(sCIDefault.getS2() - (1));

					break;

				case MainRegion_State2_Region2_State4_Region4_State6_Region6_State8 :
					stateVector[0] = State.$NullState$;
					sCIDefault.setS2(sCIDefault.getS2() - (1));

					sCIDefault.setS2(sCIDefault.getS2() - (1));

					sCIDefault.setS2(sCIDefault.getS2() - (1));

					break;

				default :
					break;
			}

			sCIDefault.setS2(sCIDefault.getS2() - (1));

			sCIDefault.setS1(1);

			sCIDefault.setS1(sCIDefault.getS1() + (1));

			nextStateIndex = 0;
			stateVector[0] = State.MainRegion_State1_Region1_State9;

		} else {
			if (sCIDefault.event7) {
				//Handle exit of all possible states (of Region4) at position 0...
				switch (stateVector[0]) {

					case MainRegion_State2_Region2_State4_Region4_State5 :
						stateVector[0] = State.$NullState$;
						sCIDefault.setS2(sCIDefault.getS2() - (1));

						break;

					case MainRegion_State2_Region2_State4_Region4_State6_Region6_State7 :
						stateVector[0] = State.$NullState$;
						sCIDefault.setS2(sCIDefault.getS2() - (1));

						sCIDefault.setS2(sCIDefault.getS2() - (1));

						break;

					case MainRegion_State2_Region2_State4_Region4_State6_Region6_State8 :
						stateVector[0] = State.$NullState$;
						sCIDefault.setS2(sCIDefault.getS2() - (1));

						sCIDefault.setS2(sCIDefault.getS2() - (1));

						break;

					default :
						break;
				}

				sCIDefault.setS2(sCIDefault.getS2() - (1));

				sCIDefault.setS2(sCIDefault.getS2() + (1));

				nextStateIndex = 0;
				stateVector[0] = State.MainRegion_State2_Region2_State3;

			} else {
				if (sCIDefault.event3) {
					stateVector[0] = State.$NullState$;
					sCIDefault.setS2(sCIDefault.getS2() - (1));

					sCIDefault.setS2(sCIDefault.getS2() + (1));

					sCIDefault.setS2(sCIDefault.getS2() + (1));

					nextStateIndex = 0;
					stateVector[0] = State.MainRegion_State2_Region2_State4_Region4_State6_Region6_State7;

				} else {
					if (sCIDefault.event12) {
						//Handle exit of all possible states (of Region2) at position 0...
						switch (stateVector[0]) {

							case MainRegion_State2_Region2_State3 :
								stateVector[0] = State.$NullState$;
								sCIDefault.setS2(sCIDefault.getS2() - (1));

								break;

							case MainRegion_State2_Region2_State4_Region4_State5 :
								stateVector[0] = State.$NullState$;
								sCIDefault.setS2(sCIDefault.getS2() - (1));

								sCIDefault.setS2(sCIDefault.getS2() - (1));

								break;

							case MainRegion_State2_Region2_State4_Region4_State6_Region6_State7 :
								stateVector[0] = State.$NullState$;
								sCIDefault.setS2(sCIDefault.getS2() - (1));

								sCIDefault.setS2(sCIDefault.getS2() - (1));

								sCIDefault.setS2(sCIDefault.getS2() - (1));

								break;

							case MainRegion_State2_Region2_State4_Region4_State6_Region6_State8 :
								stateVector[0] = State.$NullState$;
								sCIDefault.setS2(sCIDefault.getS2() - (1));

								sCIDefault.setS2(sCIDefault.getS2() - (1));

								sCIDefault.setS2(sCIDefault.getS2() - (1));

								break;

							default :
								break;
						}

						sCIDefault.setS2(sCIDefault.getS2() - (1));

						sCIDefault.setS1(1);

						sCIDefault.setS1(sCIDefault.getS1() + (1));

						nextStateIndex = 0;
						stateVector[0] = State.MainRegion_State1_Region1_State9;

					} else {
						if (sCIDefault.event15) {
							//Handle exit of all possible states (of Region2) at position 0...
							switch (stateVector[0]) {

								case MainRegion_State2_Region2_State3 :
									stateVector[0] = State.$NullState$;
									sCIDefault.setS2(sCIDefault.getS2() - (1));

									break;

								case MainRegion_State2_Region2_State4_Region4_State5 :
									stateVector[0] = State.$NullState$;
									sCIDefault.setS2(sCIDefault.getS2() - (1));

									sCIDefault.setS2(sCIDefault.getS2() - (1));

									break;

								case MainRegion_State2_Region2_State4_Region4_State6_Region6_State7 :
									stateVector[0] = State.$NullState$;
									sCIDefault.setS2(sCIDefault.getS2() - (1));

									sCIDefault.setS2(sCIDefault.getS2() - (1));

									sCIDefault.setS2(sCIDefault.getS2() - (1));

									break;

								case MainRegion_State2_Region2_State4_Region4_State6_Region6_State8 :
									stateVector[0] = State.$NullState$;
									sCIDefault.setS2(sCIDefault.getS2() - (1));

									sCIDefault.setS2(sCIDefault.getS2() - (1));

									sCIDefault.setS2(sCIDefault.getS2() - (1));

									break;

								default :
									break;
							}

							sCIDefault.setS2(sCIDefault.getS2() - (1));

							sCIDefault.setS1(1);

							sCIDefault.setS1(sCIDefault.getS1() + (1));

							nextStateIndex = 0;
							stateVector[0] = State.MainRegion_State1_Region1_State10;

						}
					}
				}

			}

		}

	}
	private void reactMainRegion_State2_Region2_State4_Region4_State6() {
	}
	private void reactMainRegion_State2_Region2_State4_Region4_State6_Region6_State7() {
		if (sCIDefault.event6) {
			//Handle exit of all possible states (of Region2) at position 0...
			switch (stateVector[0]) {

				case MainRegion_State2_Region2_State3 :
					stateVector[0] = State.$NullState$;
					sCIDefault.setS2(sCIDefault.getS2() - (1));

					break;

				case MainRegion_State2_Region2_State4_Region4_State5 :
					stateVector[0] = State.$NullState$;
					sCIDefault.setS2(sCIDefault.getS2() - (1));

					sCIDefault.setS2(sCIDefault.getS2() - (1));

					break;

				case MainRegion_State2_Region2_State4_Region4_State6_Region6_State7 :
					stateVector[0] = State.$NullState$;
					sCIDefault.setS2(sCIDefault.getS2() - (1));

					sCIDefault.setS2(sCIDefault.getS2() - (1));

					sCIDefault.setS2(sCIDefault.getS2() - (1));

					break;

				case MainRegion_State2_Region2_State4_Region4_State6_Region6_State8 :
					stateVector[0] = State.$NullState$;
					sCIDefault.setS2(sCIDefault.getS2() - (1));

					sCIDefault.setS2(sCIDefault.getS2() - (1));

					sCIDefault.setS2(sCIDefault.getS2() - (1));

					break;

				default :
					break;
			}

			sCIDefault.setS2(sCIDefault.getS2() - (1));

			sCIDefault.setS1(1);

			sCIDefault.setS1(sCIDefault.getS1() + (1));

			nextStateIndex = 0;
			stateVector[0] = State.MainRegion_State1_Region1_State9;

		} else {
			if (sCIDefault.event7) {
				//Handle exit of all possible states (of Region4) at position 0...
				switch (stateVector[0]) {

					case MainRegion_State2_Region2_State4_Region4_State5 :
						stateVector[0] = State.$NullState$;
						sCIDefault.setS2(sCIDefault.getS2() - (1));

						break;

					case MainRegion_State2_Region2_State4_Region4_State6_Region6_State7 :
						stateVector[0] = State.$NullState$;
						sCIDefault.setS2(sCIDefault.getS2() - (1));

						sCIDefault.setS2(sCIDefault.getS2() - (1));

						break;

					case MainRegion_State2_Region2_State4_Region4_State6_Region6_State8 :
						stateVector[0] = State.$NullState$;
						sCIDefault.setS2(sCIDefault.getS2() - (1));

						sCIDefault.setS2(sCIDefault.getS2() - (1));

						break;

					default :
						break;
				}

				sCIDefault.setS2(sCIDefault.getS2() - (1));

				sCIDefault.setS2(sCIDefault.getS2() + (1));

				nextStateIndex = 0;
				stateVector[0] = State.MainRegion_State2_Region2_State3;

			} else {
				if (sCIDefault.event8) {
					//Handle exit of all possible states (of Region6) at position 0...
					switch (stateVector[0]) {

						case MainRegion_State2_Region2_State4_Region4_State6_Region6_State7 :
							stateVector[0] = State.$NullState$;
							sCIDefault.setS2(sCIDefault.getS2() - (1));

							break;

						case MainRegion_State2_Region2_State4_Region4_State6_Region6_State8 :
							stateVector[0] = State.$NullState$;
							sCIDefault.setS2(sCIDefault.getS2() - (1));

							break;

						default :
							break;
					}

					sCIDefault.setS2(sCIDefault.getS2() - (1));

					sCIDefault.setS2(sCIDefault.getS2() + (1));

					nextStateIndex = 0;
					stateVector[0] = State.MainRegion_State2_Region2_State4_Region4_State5;

				} else {
					if (sCIDefault.event4) {
						stateVector[0] = State.$NullState$;
						sCIDefault.setS2(sCIDefault.getS2() - (1));

						sCIDefault.setS2(sCIDefault.getS2() + (1));

						nextStateIndex = 0;
						stateVector[0] = State.MainRegion_State2_Region2_State4_Region4_State6_Region6_State8;

					}

				}

			}

		}

	}
	private void reactMainRegion_State2_Region2_State4_Region4_State6_Region6_State8() {
		if (sCIDefault.event6) {
			//Handle exit of all possible states (of Region2) at position 0...
			switch (stateVector[0]) {

				case MainRegion_State2_Region2_State3 :
					stateVector[0] = State.$NullState$;
					sCIDefault.setS2(sCIDefault.getS2() - (1));

					break;

				case MainRegion_State2_Region2_State4_Region4_State5 :
					stateVector[0] = State.$NullState$;
					sCIDefault.setS2(sCIDefault.getS2() - (1));

					sCIDefault.setS2(sCIDefault.getS2() - (1));

					break;

				case MainRegion_State2_Region2_State4_Region4_State6_Region6_State7 :
					stateVector[0] = State.$NullState$;
					sCIDefault.setS2(sCIDefault.getS2() - (1));

					sCIDefault.setS2(sCIDefault.getS2() - (1));

					sCIDefault.setS2(sCIDefault.getS2() - (1));

					break;

				case MainRegion_State2_Region2_State4_Region4_State6_Region6_State8 :
					stateVector[0] = State.$NullState$;
					sCIDefault.setS2(sCIDefault.getS2() - (1));

					sCIDefault.setS2(sCIDefault.getS2() - (1));

					sCIDefault.setS2(sCIDefault.getS2() - (1));

					break;

				default :
					break;
			}

			sCIDefault.setS2(sCIDefault.getS2() - (1));

			sCIDefault.setS1(1);

			sCIDefault.setS1(sCIDefault.getS1() + (1));

			nextStateIndex = 0;
			stateVector[0] = State.MainRegion_State1_Region1_State9;

		} else {
			if (sCIDefault.event7) {
				//Handle exit of all possible states (of Region4) at position 0...
				switch (stateVector[0]) {

					case MainRegion_State2_Region2_State4_Region4_State5 :
						stateVector[0] = State.$NullState$;
						sCIDefault.setS2(sCIDefault.getS2() - (1));

						break;

					case MainRegion_State2_Region2_State4_Region4_State6_Region6_State7 :
						stateVector[0] = State.$NullState$;
						sCIDefault.setS2(sCIDefault.getS2() - (1));

						sCIDefault.setS2(sCIDefault.getS2() - (1));

						break;

					case MainRegion_State2_Region2_State4_Region4_State6_Region6_State8 :
						stateVector[0] = State.$NullState$;
						sCIDefault.setS2(sCIDefault.getS2() - (1));

						sCIDefault.setS2(sCIDefault.getS2() - (1));

						break;

					default :
						break;
				}

				sCIDefault.setS2(sCIDefault.getS2() - (1));

				sCIDefault.setS2(sCIDefault.getS2() + (1));

				nextStateIndex = 0;
				stateVector[0] = State.MainRegion_State2_Region2_State3;

			} else {
				if (sCIDefault.event8) {
					//Handle exit of all possible states (of Region6) at position 0...
					switch (stateVector[0]) {

						case MainRegion_State2_Region2_State4_Region4_State6_Region6_State7 :
							stateVector[0] = State.$NullState$;
							sCIDefault.setS2(sCIDefault.getS2() - (1));

							break;

						case MainRegion_State2_Region2_State4_Region4_State6_Region6_State8 :
							stateVector[0] = State.$NullState$;
							sCIDefault.setS2(sCIDefault.getS2() - (1));

							break;

						default :
							break;
					}

					sCIDefault.setS2(sCIDefault.getS2() - (1));

					sCIDefault.setS2(sCIDefault.getS2() + (1));

					nextStateIndex = 0;
					stateVector[0] = State.MainRegion_State2_Region2_State4_Region4_State5;

				} else {
					if (sCIDefault.event5) {
						stateVector[0] = State.$NullState$;
						sCIDefault.setS2(sCIDefault.getS2() - (1));

						sCIDefault.setS2(sCIDefault.getS2() + (1));

						nextStateIndex = 0;
						stateVector[0] = State.MainRegion_State2_Region2_State4_Region4_State6_Region6_State7;

					} else {
						if (sCIDefault.event13) {
							//Handle exit of all possible states (of Region2) at position 0...
							switch (stateVector[0]) {

								case MainRegion_State2_Region2_State3 :
									stateVector[0] = State.$NullState$;
									sCIDefault.setS2(sCIDefault.getS2() - (1));

									break;

								case MainRegion_State2_Region2_State4_Region4_State5 :
									stateVector[0] = State.$NullState$;
									sCIDefault.setS2(sCIDefault.getS2() - (1));

									sCIDefault.setS2(sCIDefault.getS2() - (1));

									break;

								case MainRegion_State2_Region2_State4_Region4_State6_Region6_State7 :
									stateVector[0] = State.$NullState$;
									sCIDefault.setS2(sCIDefault.getS2() - (1));

									sCIDefault.setS2(sCIDefault.getS2() - (1));

									sCIDefault.setS2(sCIDefault.getS2() - (1));

									break;

								case MainRegion_State2_Region2_State4_Region4_State6_Region6_State8 :
									stateVector[0] = State.$NullState$;
									sCIDefault.setS2(sCIDefault.getS2() - (1));

									sCIDefault.setS2(sCIDefault.getS2() - (1));

									sCIDefault.setS2(sCIDefault.getS2() - (1));

									break;

								default :
									break;
							}

							sCIDefault.setS2(sCIDefault.getS2() - (1));

							sCIDefault.setS1(1);

							sCIDefault.setS1(sCIDefault.getS1() + (1));

							nextStateIndex = 0;
							stateVector[0] = State.MainRegion_State1_Region1_State9;

						} else {
							if (sCIDefault.event16) {
								//Handle exit of all possible states (of Region2) at position 0...
								switch (stateVector[0]) {

									case MainRegion_State2_Region2_State3 :
										stateVector[0] = State.$NullState$;
										sCIDefault
												.setS2(sCIDefault.getS2() - (1));

										break;

									case MainRegion_State2_Region2_State4_Region4_State5 :
										stateVector[0] = State.$NullState$;
										sCIDefault
												.setS2(sCIDefault.getS2() - (1));

										sCIDefault
												.setS2(sCIDefault.getS2() - (1));

										break;

									case MainRegion_State2_Region2_State4_Region4_State6_Region6_State7 :
										stateVector[0] = State.$NullState$;
										sCIDefault
												.setS2(sCIDefault.getS2() - (1));

										sCIDefault
												.setS2(sCIDefault.getS2() - (1));

										sCIDefault
												.setS2(sCIDefault.getS2() - (1));

										break;

									case MainRegion_State2_Region2_State4_Region4_State6_Region6_State8 :
										stateVector[0] = State.$NullState$;
										sCIDefault
												.setS2(sCIDefault.getS2() - (1));

										sCIDefault
												.setS2(sCIDefault.getS2() - (1));

										sCIDefault
												.setS2(sCIDefault.getS2() - (1));

										break;

									default :
										break;
								}

								sCIDefault.setS2(sCIDefault.getS2() - (1));

								sCIDefault.setS1(1);

								sCIDefault.setS1(sCIDefault.getS1() + (1));

								nextStateIndex = 0;
								stateVector[0] = State.MainRegion_State1_Region1_State10;

							}
						}
					}

				}

			}

		}

	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case MainRegion_State1 :
					reactMainRegion_State1();
					break;
				case MainRegion_State1_Region1_State9 :
					reactMainRegion_State1_Region1_State9();
					break;
				case MainRegion_State1_Region1_State10 :
					reactMainRegion_State1_Region1_State10();
					break;
				case MainRegion_State2 :
					reactMainRegion_State2();
					break;
				case MainRegion_State2_Region2_State3 :
					reactMainRegion_State2_Region2_State3();
					break;
				case MainRegion_State2_Region2_State4 :
					reactMainRegion_State2_Region2_State4();
					break;
				case MainRegion_State2_Region2_State4_Region4_State5 :
					reactMainRegion_State2_Region2_State4_Region4_State5();
					break;
				case MainRegion_State2_Region2_State4_Region4_State6 :
					reactMainRegion_State2_Region2_State4_Region4_State6();
					break;
				case MainRegion_State2_Region2_State4_Region4_State6_Region6_State7 :
					reactMainRegion_State2_Region2_State4_Region4_State6_Region6_State7();
					break;
				case MainRegion_State2_Region2_State4_Region4_State6_Region6_State8 :
					reactMainRegion_State2_Region2_State4_Region4_State6_Region6_State8();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
