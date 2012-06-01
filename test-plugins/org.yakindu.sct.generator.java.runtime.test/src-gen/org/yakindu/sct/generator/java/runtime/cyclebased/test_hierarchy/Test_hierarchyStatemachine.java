package org.yakindu.sct.generator.java.runtime.cyclebased.test_hierarchy;

public class Test_hierarchyStatemachine implements ITest_hierarchyStatemachine {

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
			s1 = value;
		}

		private int s2;

		public int getS2() {
			return s2;
		}

		public void setS2(int value) {
			s2 = value;
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

	private DefaultInterfaceImpl defaultInterface;

	public enum State {
		State1, State9, State10, State2, State3, State4, State5, State6, State7, State8, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public Test_hierarchyStatemachine() {

		defaultInterface = new DefaultInterfaceImpl();

	}

	public void init() {
		for (int i = 0; i < 1; i++) {
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

	public void raiseEvent15() {
		defaultInterface.raiseEvent15();
	}

	public void raiseEvent16() {
		defaultInterface.raiseEvent16();
	}

	public int getS1() {
		return defaultInterface.getS1();
	}

	public void setS1(int value) {
		defaultInterface.setS1(value);
	}
	public int getS2() {
		return defaultInterface.getS2();
	}

	public void setS2(int value) {
		defaultInterface.setS2(value);
	}

	public void enter() {
		defaultInterface.setS1(0);

		// unknown function type org.yakindu.sct.model.sexec.impl.SequenceImpl@61c906ce (name: entryAction) (comment: Entry action for statechart 'Test_Hierarchy'.)();
		defaultInterface.setS1(1);

		defaultInterface.setS1(defaultInterface.getS1() + (1));

		nextStateIndex = 0;
		stateVector[0] = State.State9;

	}

	public void exit() {
		//Handle exit of all possible states (of mainRegion) at position 0...
		switch (stateVector[0]) {

			case State9 :
				stateVector[0] = State.$NullState$;
				defaultInterface.setS1(defaultInterface.getS1() - (1));

				defaultInterface.setS1(defaultInterface.getS1() - (1));

				break;

			case State10 :
				stateVector[0] = State.$NullState$;
				defaultInterface.setS1(defaultInterface.getS1() - (1));

				defaultInterface.setS1(defaultInterface.getS1() - (1));

				break;

			case State3 :
				stateVector[0] = State.$NullState$;
				defaultInterface.setS2(defaultInterface.getS2() - (1));

				defaultInterface.setS2(defaultInterface.getS2() - (1));

				break;

			case State5 :
				stateVector[0] = State.$NullState$;
				defaultInterface.setS2(defaultInterface.getS2() - (1));

				defaultInterface.setS2(defaultInterface.getS2() - (1));

				defaultInterface.setS2(defaultInterface.getS2() - (1));

				break;

			case State7 :
				stateVector[0] = State.$NullState$;
				defaultInterface.setS2(defaultInterface.getS2() - (1));

				defaultInterface.setS2(defaultInterface.getS2() - (1));

				defaultInterface.setS2(defaultInterface.getS2() - (1));

				defaultInterface.setS2(defaultInterface.getS2() - (1));

				break;

			case State8 :
				stateVector[0] = State.$NullState$;
				defaultInterface.setS2(defaultInterface.getS2() - (1));

				defaultInterface.setS2(defaultInterface.getS2() - (1));

				defaultInterface.setS2(defaultInterface.getS2() - (1));

				defaultInterface.setS2(defaultInterface.getS2() - (1));

				break;

			default :
				break;
		}

		// unknown function type org.yakindu.sct.model.sexec.impl.SequenceImpl@420eafda (name: exitAction) (comment: Exit action for state 'Test_Hierarchy'.)();
	}

	private void reactState1() {
	}
	private void reactState9() {
		if (defaultInterface.event1) {
			//Handle exit of all possible states (of Region1) at position 0...
			switch (stateVector[0]) {

				case State9 :
					stateVector[0] = State.$NullState$;
					defaultInterface.setS1(defaultInterface.getS1() - (1));

					break;

				case State10 :
					stateVector[0] = State.$NullState$;
					defaultInterface.setS1(defaultInterface.getS1() - (1));

					break;

				default :
					break;
			}

			defaultInterface.setS1(defaultInterface.getS1() - (1));

			defaultInterface.setS2(1);

			defaultInterface.setS2(defaultInterface.getS2() + (1));

			nextStateIndex = 0;
			stateVector[0] = State.State3;

		} else {
			if (defaultInterface.event9) {
				stateVector[0] = State.$NullState$;
				defaultInterface.setS1(defaultInterface.getS1() - (1));

				defaultInterface.setS1(defaultInterface.getS1() + (1));

				nextStateIndex = 0;
				stateVector[0] = State.State10;

			}

		}

	}
	private void reactState10() {
		if (defaultInterface.event1) {
			//Handle exit of all possible states (of Region1) at position 0...
			switch (stateVector[0]) {

				case State9 :
					stateVector[0] = State.$NullState$;
					defaultInterface.setS1(defaultInterface.getS1() - (1));

					break;

				case State10 :
					stateVector[0] = State.$NullState$;
					defaultInterface.setS1(defaultInterface.getS1() - (1));

					break;

				default :
					break;
			}

			defaultInterface.setS1(defaultInterface.getS1() - (1));

			defaultInterface.setS2(1);

			defaultInterface.setS2(defaultInterface.getS2() + (1));

			nextStateIndex = 0;
			stateVector[0] = State.State3;

		} else {
			if (defaultInterface.event10) {
				stateVector[0] = State.$NullState$;
				defaultInterface.setS1(defaultInterface.getS1() - (1));

				defaultInterface.setS1(defaultInterface.getS1() + (1));

				nextStateIndex = 0;
				stateVector[0] = State.State9;

			}

		}

	}
	private void reactState2() {
	}
	private void reactState3() {
		if (defaultInterface.event6) {
			//Handle exit of all possible states (of Region2) at position 0...
			switch (stateVector[0]) {

				case State3 :
					stateVector[0] = State.$NullState$;
					defaultInterface.setS2(defaultInterface.getS2() - (1));

					break;

				case State5 :
					stateVector[0] = State.$NullState$;
					defaultInterface.setS2(defaultInterface.getS2() - (1));

					defaultInterface.setS2(defaultInterface.getS2() - (1));

					break;

				case State7 :
					stateVector[0] = State.$NullState$;
					defaultInterface.setS2(defaultInterface.getS2() - (1));

					defaultInterface.setS2(defaultInterface.getS2() - (1));

					defaultInterface.setS2(defaultInterface.getS2() - (1));

					break;

				case State8 :
					stateVector[0] = State.$NullState$;
					defaultInterface.setS2(defaultInterface.getS2() - (1));

					defaultInterface.setS2(defaultInterface.getS2() - (1));

					defaultInterface.setS2(defaultInterface.getS2() - (1));

					break;

				default :
					break;
			}

			defaultInterface.setS2(defaultInterface.getS2() - (1));

			defaultInterface.setS1(1);

			defaultInterface.setS1(defaultInterface.getS1() + (1));

			nextStateIndex = 0;
			stateVector[0] = State.State9;

		} else {
			if (defaultInterface.event2) {
				stateVector[0] = State.$NullState$;
				defaultInterface.setS2(defaultInterface.getS2() - (1));

				defaultInterface.setS2(defaultInterface.getS2() + (1));

				defaultInterface.setS2(defaultInterface.getS2() + (1));

				nextStateIndex = 0;
				stateVector[0] = State.State5;

			} else {
				if (defaultInterface.event11) {
					//Handle exit of all possible states (of Region2) at position 0...
					switch (stateVector[0]) {

						case State3 :
							stateVector[0] = State.$NullState$;
							defaultInterface
									.setS2(defaultInterface.getS2() - (1));

							break;

						case State5 :
							stateVector[0] = State.$NullState$;
							defaultInterface
									.setS2(defaultInterface.getS2() - (1));

							defaultInterface
									.setS2(defaultInterface.getS2() - (1));

							break;

						case State7 :
							stateVector[0] = State.$NullState$;
							defaultInterface
									.setS2(defaultInterface.getS2() - (1));

							defaultInterface
									.setS2(defaultInterface.getS2() - (1));

							defaultInterface
									.setS2(defaultInterface.getS2() - (1));

							break;

						case State8 :
							stateVector[0] = State.$NullState$;
							defaultInterface
									.setS2(defaultInterface.getS2() - (1));

							defaultInterface
									.setS2(defaultInterface.getS2() - (1));

							defaultInterface
									.setS2(defaultInterface.getS2() - (1));

							break;

						default :
							break;
					}

					defaultInterface.setS2(defaultInterface.getS2() - (1));

					defaultInterface.setS1(1);

					defaultInterface.setS1(defaultInterface.getS1() + (1));

					nextStateIndex = 0;
					stateVector[0] = State.State9;

				} else {
					if (defaultInterface.event14) {
						//Handle exit of all possible states (of Region2) at position 0...
						switch (stateVector[0]) {

							case State3 :
								stateVector[0] = State.$NullState$;
								defaultInterface
										.setS2(defaultInterface.getS2() - (1));

								break;

							case State5 :
								stateVector[0] = State.$NullState$;
								defaultInterface
										.setS2(defaultInterface.getS2() - (1));

								defaultInterface
										.setS2(defaultInterface.getS2() - (1));

								break;

							case State7 :
								stateVector[0] = State.$NullState$;
								defaultInterface
										.setS2(defaultInterface.getS2() - (1));

								defaultInterface
										.setS2(defaultInterface.getS2() - (1));

								defaultInterface
										.setS2(defaultInterface.getS2() - (1));

								break;

							case State8 :
								stateVector[0] = State.$NullState$;
								defaultInterface
										.setS2(defaultInterface.getS2() - (1));

								defaultInterface
										.setS2(defaultInterface.getS2() - (1));

								defaultInterface
										.setS2(defaultInterface.getS2() - (1));

								break;

							default :
								break;
						}

						defaultInterface.setS2(defaultInterface.getS2() - (1));

						defaultInterface.setS1(1);

						defaultInterface.setS1(defaultInterface.getS1() + (1));

						nextStateIndex = 0;
						stateVector[0] = State.State9;

					}
				}
			}

		}

	}
	private void reactState4() {
	}
	private void reactState5() {
		if (defaultInterface.event6) {
			//Handle exit of all possible states (of Region2) at position 0...
			switch (stateVector[0]) {

				case State3 :
					stateVector[0] = State.$NullState$;
					defaultInterface.setS2(defaultInterface.getS2() - (1));

					break;

				case State5 :
					stateVector[0] = State.$NullState$;
					defaultInterface.setS2(defaultInterface.getS2() - (1));

					defaultInterface.setS2(defaultInterface.getS2() - (1));

					break;

				case State7 :
					stateVector[0] = State.$NullState$;
					defaultInterface.setS2(defaultInterface.getS2() - (1));

					defaultInterface.setS2(defaultInterface.getS2() - (1));

					defaultInterface.setS2(defaultInterface.getS2() - (1));

					break;

				case State8 :
					stateVector[0] = State.$NullState$;
					defaultInterface.setS2(defaultInterface.getS2() - (1));

					defaultInterface.setS2(defaultInterface.getS2() - (1));

					defaultInterface.setS2(defaultInterface.getS2() - (1));

					break;

				default :
					break;
			}

			defaultInterface.setS2(defaultInterface.getS2() - (1));

			defaultInterface.setS1(1);

			defaultInterface.setS1(defaultInterface.getS1() + (1));

			nextStateIndex = 0;
			stateVector[0] = State.State9;

		} else {
			if (defaultInterface.event7) {
				//Handle exit of all possible states (of Region4) at position 0...
				switch (stateVector[0]) {

					case State5 :
						stateVector[0] = State.$NullState$;
						defaultInterface.setS2(defaultInterface.getS2() - (1));

						break;

					case State7 :
						stateVector[0] = State.$NullState$;
						defaultInterface.setS2(defaultInterface.getS2() - (1));

						defaultInterface.setS2(defaultInterface.getS2() - (1));

						break;

					case State8 :
						stateVector[0] = State.$NullState$;
						defaultInterface.setS2(defaultInterface.getS2() - (1));

						defaultInterface.setS2(defaultInterface.getS2() - (1));

						break;

					default :
						break;
				}

				defaultInterface.setS2(defaultInterface.getS2() - (1));

				defaultInterface.setS2(defaultInterface.getS2() + (1));

				nextStateIndex = 0;
				stateVector[0] = State.State3;

			} else {
				if (defaultInterface.event3) {
					stateVector[0] = State.$NullState$;
					defaultInterface.setS2(defaultInterface.getS2() - (1));

					defaultInterface.setS2(defaultInterface.getS2() + (1));

					defaultInterface.setS2(defaultInterface.getS2() + (1));

					nextStateIndex = 0;
					stateVector[0] = State.State7;

				} else {
					if (defaultInterface.event12) {
						//Handle exit of all possible states (of Region2) at position 0...
						switch (stateVector[0]) {

							case State3 :
								stateVector[0] = State.$NullState$;
								defaultInterface
										.setS2(defaultInterface.getS2() - (1));

								break;

							case State5 :
								stateVector[0] = State.$NullState$;
								defaultInterface
										.setS2(defaultInterface.getS2() - (1));

								defaultInterface
										.setS2(defaultInterface.getS2() - (1));

								break;

							case State7 :
								stateVector[0] = State.$NullState$;
								defaultInterface
										.setS2(defaultInterface.getS2() - (1));

								defaultInterface
										.setS2(defaultInterface.getS2() - (1));

								defaultInterface
										.setS2(defaultInterface.getS2() - (1));

								break;

							case State8 :
								stateVector[0] = State.$NullState$;
								defaultInterface
										.setS2(defaultInterface.getS2() - (1));

								defaultInterface
										.setS2(defaultInterface.getS2() - (1));

								defaultInterface
										.setS2(defaultInterface.getS2() - (1));

								break;

							default :
								break;
						}

						defaultInterface.setS2(defaultInterface.getS2() - (1));

						defaultInterface.setS1(1);

						defaultInterface.setS1(defaultInterface.getS1() + (1));

						nextStateIndex = 0;
						stateVector[0] = State.State9;

					} else {
						if (defaultInterface.event15) {
							//Handle exit of all possible states (of Region2) at position 0...
							switch (stateVector[0]) {

								case State3 :
									stateVector[0] = State.$NullState$;
									defaultInterface.setS2(defaultInterface
											.getS2() - (1));

									break;

								case State5 :
									stateVector[0] = State.$NullState$;
									defaultInterface.setS2(defaultInterface
											.getS2() - (1));

									defaultInterface.setS2(defaultInterface
											.getS2() - (1));

									break;

								case State7 :
									stateVector[0] = State.$NullState$;
									defaultInterface.setS2(defaultInterface
											.getS2() - (1));

									defaultInterface.setS2(defaultInterface
											.getS2() - (1));

									defaultInterface.setS2(defaultInterface
											.getS2() - (1));

									break;

								case State8 :
									stateVector[0] = State.$NullState$;
									defaultInterface.setS2(defaultInterface
											.getS2() - (1));

									defaultInterface.setS2(defaultInterface
											.getS2() - (1));

									defaultInterface.setS2(defaultInterface
											.getS2() - (1));

									break;

								default :
									break;
							}

							defaultInterface
									.setS2(defaultInterface.getS2() - (1));

							defaultInterface.setS1(1);

							defaultInterface
									.setS1(defaultInterface.getS1() + (1));

							nextStateIndex = 0;
							stateVector[0] = State.State10;

						}
					}
				}

			}

		}

	}
	private void reactState6() {
	}
	private void reactState7() {
		if (defaultInterface.event6) {
			//Handle exit of all possible states (of Region2) at position 0...
			switch (stateVector[0]) {

				case State3 :
					stateVector[0] = State.$NullState$;
					defaultInterface.setS2(defaultInterface.getS2() - (1));

					break;

				case State5 :
					stateVector[0] = State.$NullState$;
					defaultInterface.setS2(defaultInterface.getS2() - (1));

					defaultInterface.setS2(defaultInterface.getS2() - (1));

					break;

				case State7 :
					stateVector[0] = State.$NullState$;
					defaultInterface.setS2(defaultInterface.getS2() - (1));

					defaultInterface.setS2(defaultInterface.getS2() - (1));

					defaultInterface.setS2(defaultInterface.getS2() - (1));

					break;

				case State8 :
					stateVector[0] = State.$NullState$;
					defaultInterface.setS2(defaultInterface.getS2() - (1));

					defaultInterface.setS2(defaultInterface.getS2() - (1));

					defaultInterface.setS2(defaultInterface.getS2() - (1));

					break;

				default :
					break;
			}

			defaultInterface.setS2(defaultInterface.getS2() - (1));

			defaultInterface.setS1(1);

			defaultInterface.setS1(defaultInterface.getS1() + (1));

			nextStateIndex = 0;
			stateVector[0] = State.State9;

		} else {
			if (defaultInterface.event7) {
				//Handle exit of all possible states (of Region4) at position 0...
				switch (stateVector[0]) {

					case State5 :
						stateVector[0] = State.$NullState$;
						defaultInterface.setS2(defaultInterface.getS2() - (1));

						break;

					case State7 :
						stateVector[0] = State.$NullState$;
						defaultInterface.setS2(defaultInterface.getS2() - (1));

						defaultInterface.setS2(defaultInterface.getS2() - (1));

						break;

					case State8 :
						stateVector[0] = State.$NullState$;
						defaultInterface.setS2(defaultInterface.getS2() - (1));

						defaultInterface.setS2(defaultInterface.getS2() - (1));

						break;

					default :
						break;
				}

				defaultInterface.setS2(defaultInterface.getS2() - (1));

				defaultInterface.setS2(defaultInterface.getS2() + (1));

				nextStateIndex = 0;
				stateVector[0] = State.State3;

			} else {
				if (defaultInterface.event8) {
					//Handle exit of all possible states (of Region6) at position 0...
					switch (stateVector[0]) {

						case State7 :
							stateVector[0] = State.$NullState$;
							defaultInterface
									.setS2(defaultInterface.getS2() - (1));

							break;

						case State8 :
							stateVector[0] = State.$NullState$;
							defaultInterface
									.setS2(defaultInterface.getS2() - (1));

							break;

						default :
							break;
					}

					defaultInterface.setS2(defaultInterface.getS2() - (1));

					defaultInterface.setS2(defaultInterface.getS2() + (1));

					nextStateIndex = 0;
					stateVector[0] = State.State5;

				} else {
					if (defaultInterface.event4) {
						stateVector[0] = State.$NullState$;
						defaultInterface.setS2(defaultInterface.getS2() - (1));

						defaultInterface.setS2(defaultInterface.getS2() + (1));

						nextStateIndex = 0;
						stateVector[0] = State.State8;

					}

				}

			}

		}

	}
	private void reactState8() {
		if (defaultInterface.event6) {
			//Handle exit of all possible states (of Region2) at position 0...
			switch (stateVector[0]) {

				case State3 :
					stateVector[0] = State.$NullState$;
					defaultInterface.setS2(defaultInterface.getS2() - (1));

					break;

				case State5 :
					stateVector[0] = State.$NullState$;
					defaultInterface.setS2(defaultInterface.getS2() - (1));

					defaultInterface.setS2(defaultInterface.getS2() - (1));

					break;

				case State7 :
					stateVector[0] = State.$NullState$;
					defaultInterface.setS2(defaultInterface.getS2() - (1));

					defaultInterface.setS2(defaultInterface.getS2() - (1));

					defaultInterface.setS2(defaultInterface.getS2() - (1));

					break;

				case State8 :
					stateVector[0] = State.$NullState$;
					defaultInterface.setS2(defaultInterface.getS2() - (1));

					defaultInterface.setS2(defaultInterface.getS2() - (1));

					defaultInterface.setS2(defaultInterface.getS2() - (1));

					break;

				default :
					break;
			}

			defaultInterface.setS2(defaultInterface.getS2() - (1));

			defaultInterface.setS1(1);

			defaultInterface.setS1(defaultInterface.getS1() + (1));

			nextStateIndex = 0;
			stateVector[0] = State.State9;

		} else {
			if (defaultInterface.event7) {
				//Handle exit of all possible states (of Region4) at position 0...
				switch (stateVector[0]) {

					case State5 :
						stateVector[0] = State.$NullState$;
						defaultInterface.setS2(defaultInterface.getS2() - (1));

						break;

					case State7 :
						stateVector[0] = State.$NullState$;
						defaultInterface.setS2(defaultInterface.getS2() - (1));

						defaultInterface.setS2(defaultInterface.getS2() - (1));

						break;

					case State8 :
						stateVector[0] = State.$NullState$;
						defaultInterface.setS2(defaultInterface.getS2() - (1));

						defaultInterface.setS2(defaultInterface.getS2() - (1));

						break;

					default :
						break;
				}

				defaultInterface.setS2(defaultInterface.getS2() - (1));

				defaultInterface.setS2(defaultInterface.getS2() + (1));

				nextStateIndex = 0;
				stateVector[0] = State.State3;

			} else {
				if (defaultInterface.event8) {
					//Handle exit of all possible states (of Region6) at position 0...
					switch (stateVector[0]) {

						case State7 :
							stateVector[0] = State.$NullState$;
							defaultInterface
									.setS2(defaultInterface.getS2() - (1));

							break;

						case State8 :
							stateVector[0] = State.$NullState$;
							defaultInterface
									.setS2(defaultInterface.getS2() - (1));

							break;

						default :
							break;
					}

					defaultInterface.setS2(defaultInterface.getS2() - (1));

					defaultInterface.setS2(defaultInterface.getS2() + (1));

					nextStateIndex = 0;
					stateVector[0] = State.State5;

				} else {
					if (defaultInterface.event5) {
						stateVector[0] = State.$NullState$;
						defaultInterface.setS2(defaultInterface.getS2() - (1));

						defaultInterface.setS2(defaultInterface.getS2() + (1));

						nextStateIndex = 0;
						stateVector[0] = State.State7;

					} else {
						if (defaultInterface.event13) {
							//Handle exit of all possible states (of Region2) at position 0...
							switch (stateVector[0]) {

								case State3 :
									stateVector[0] = State.$NullState$;
									defaultInterface.setS2(defaultInterface
											.getS2() - (1));

									break;

								case State5 :
									stateVector[0] = State.$NullState$;
									defaultInterface.setS2(defaultInterface
											.getS2() - (1));

									defaultInterface.setS2(defaultInterface
											.getS2() - (1));

									break;

								case State7 :
									stateVector[0] = State.$NullState$;
									defaultInterface.setS2(defaultInterface
											.getS2() - (1));

									defaultInterface.setS2(defaultInterface
											.getS2() - (1));

									defaultInterface.setS2(defaultInterface
											.getS2() - (1));

									break;

								case State8 :
									stateVector[0] = State.$NullState$;
									defaultInterface.setS2(defaultInterface
											.getS2() - (1));

									defaultInterface.setS2(defaultInterface
											.getS2() - (1));

									defaultInterface.setS2(defaultInterface
											.getS2() - (1));

									break;

								default :
									break;
							}

							defaultInterface
									.setS2(defaultInterface.getS2() - (1));

							defaultInterface.setS1(1);

							defaultInterface
									.setS1(defaultInterface.getS1() + (1));

							nextStateIndex = 0;
							stateVector[0] = State.State9;

						} else {
							if (defaultInterface.event16) {
								//Handle exit of all possible states (of Region2) at position 0...
								switch (stateVector[0]) {

									case State3 :
										stateVector[0] = State.$NullState$;
										defaultInterface.setS2(defaultInterface
												.getS2() - (1));

										break;

									case State5 :
										stateVector[0] = State.$NullState$;
										defaultInterface.setS2(defaultInterface
												.getS2() - (1));

										defaultInterface.setS2(defaultInterface
												.getS2() - (1));

										break;

									case State7 :
										stateVector[0] = State.$NullState$;
										defaultInterface.setS2(defaultInterface
												.getS2() - (1));

										defaultInterface.setS2(defaultInterface
												.getS2() - (1));

										defaultInterface.setS2(defaultInterface
												.getS2() - (1));

										break;

									case State8 :
										stateVector[0] = State.$NullState$;
										defaultInterface.setS2(defaultInterface
												.getS2() - (1));

										defaultInterface.setS2(defaultInterface
												.getS2() - (1));

										defaultInterface.setS2(defaultInterface
												.getS2() - (1));

										break;

									default :
										break;
								}

								defaultInterface
										.setS2(defaultInterface.getS2() - (1));

								defaultInterface.setS1(1);

								defaultInterface
										.setS1(defaultInterface.getS1() + (1));

								nextStateIndex = 0;
								stateVector[0] = State.State10;

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
				case State1 :
					reactState1();
					break;
				case State9 :
					reactState9();
					break;
				case State10 :
					reactState10();
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
