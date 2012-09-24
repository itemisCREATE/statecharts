package org.yakindu.scr.performancetest;

public class PerformanceTestStatemachine
		implements
			IPerformanceTestStatemachine {

	private final class SCIDefaultImpl implements SCIDefault {

		private boolean e1;

		public void raiseE1() {
			e1 = true;
		}

		private boolean e2;

		public void raiseE2() {
			e2 = true;
		}

		private boolean e3;

		public void raiseE3() {
			e3 = true;
		}

		private int x = 0;

		public int getX() {
			return x;
		}

		public void setX(int value) {
			this.x = value;
		}

		private int a = 0;

		public int getA() {
			return a;
		}

		public void setA(int value) {
			this.a = value;
		}

		private int c = 0;

		public int getC() {
			return c;
		}

		public void setC(int value) {
			this.c = value;
		}

		public void clearEvents() {
			e1 = false;
			e2 = false;
			e3 = false;
		}

	}

	private SCIDefaultImpl sCIDefault;

	public enum State {
		Mr_A, Mr_B, Mr_B_r1_X, Mr_B_r1_Y, Mr_B_r1_Z, Mr_B_r1_V, Mr_B_r1_W, Mr_B_r1_S, Mr_B_r1_T, Mr_B_r1_U, Mr_B_r2_S, Mr_B_r2_T, Mr_B_r2_U, Mr_B_r2_V, Mr_B_r2_W, $NullState$
	};

	private State[] historyVector = new State[1];

	private final State[] stateVector = new State[2];

	private int nextStateIndex;

	public PerformanceTestStatemachine() {

		sCIDefault = new SCIDefaultImpl();

	}

	public void init() {
		for (int i = 0; i < 2; i++) {
			stateVector[i] = State.$NullState$;
		}

		for (int i = 0; i < 1; i++) {
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
		switch (state) {

			case Mr_A :
				return stateVector[0] == State.Mr_A;

			case Mr_B :
				return stateVector[0].ordinal() >= State.Mr_B.ordinal()
						&& stateVector[0].ordinal() <= State.Mr_B_r2_W
								.ordinal();

			case Mr_B_r1_X :
				return stateVector[0] == State.Mr_B_r1_X;

			case Mr_B_r1_Y :
				return stateVector[0] == State.Mr_B_r1_Y;

			case Mr_B_r1_Z :
				return stateVector[0] == State.Mr_B_r1_Z;

			case Mr_B_r1_V :
				return stateVector[0] == State.Mr_B_r1_V;

			case Mr_B_r1_W :
				return stateVector[0] == State.Mr_B_r1_W;

			case Mr_B_r1_S :
				return stateVector[0] == State.Mr_B_r1_S;

			case Mr_B_r1_T :
				return stateVector[0] == State.Mr_B_r1_T;

			case Mr_B_r1_U :
				return stateVector[0] == State.Mr_B_r1_U;

			case Mr_B_r2_S :
				return stateVector[1] == State.Mr_B_r2_S;

			case Mr_B_r2_T :
				return stateVector[1] == State.Mr_B_r2_T;

			case Mr_B_r2_U :
				return stateVector[1] == State.Mr_B_r2_U;

			case Mr_B_r2_V :
				return stateVector[1] == State.Mr_B_r2_V;

			case Mr_B_r2_W :
				return stateVector[1] == State.Mr_B_r2_W;

			default :
				return false;
		}
		/*
		for (int i=0;i<stateVector.length;i++){
			if (stateVector[i]==state) {
				return true;
			}
		}
		return false;
		 */
	}

	public SCIDefault getSCIDefault() {
		return sCIDefault;
	}

	public void raiseE1() {
		sCIDefault.raiseE1();
	}

	public void raiseE2() {
		sCIDefault.raiseE2();
	}

	public void raiseE3() {
		sCIDefault.raiseE3();
	}

	public int getX() {
		return sCIDefault.getX();
	}

	public void setX(int value) {
		sCIDefault.setX(value);
	}
	public int getA() {
		return sCIDefault.getA();
	}

	public void setA(int value) {
		sCIDefault.setA(value);
	}
	public int getC() {
		return sCIDefault.getC();
	}

	public void setC(int value) {
		sCIDefault.setC(value);
	}

	public void enter() {
		sCIDefault.x = 0;

		sCIDefault.a = 0;

		sCIDefault.c = 0;

		entryActionPerformanceTest();
		sCIDefault.a += 1;

		nextStateIndex = 0;
		stateVector[0] = State.Mr_A;

	}

	public void exit() {
		//Handle exit of all possible states (of mr) at position 0...
		switch (stateVector[0]) {

			case Mr_A :
				stateVector[0] = State.$NullState$;

				break;

			case Mr_B_r1_X :

				historyVector[0] = stateVector[0];
				stateVector[0] = State.$NullState$;

				break;

			case Mr_B_r1_Y :

				historyVector[0] = stateVector[0];
				stateVector[0] = State.$NullState$;

				break;

			case Mr_B_r1_Z :

				historyVector[0] = stateVector[0];
				stateVector[0] = State.$NullState$;

				break;

			case Mr_B_r1_V :

				historyVector[0] = stateVector[0];
				stateVector[0] = State.$NullState$;

				break;

			case Mr_B_r1_W :

				historyVector[0] = stateVector[0];
				stateVector[0] = State.$NullState$;

				break;

			case Mr_B_r1_S :

				historyVector[0] = stateVector[0];
				stateVector[0] = State.$NullState$;

				break;

			case Mr_B_r1_T :

				historyVector[0] = stateVector[0];
				stateVector[0] = State.$NullState$;

				break;

			case Mr_B_r1_U :

				historyVector[0] = stateVector[0];
				stateVector[0] = State.$NullState$;

				break;

			default :
				break;
		}
		//Handle exit of all possible states (of mr) at position 1...
		switch (stateVector[1]) {

			case Mr_B_r2_S :
				stateVector[1] = State.$NullState$;

				break;

			case Mr_B_r2_T :
				stateVector[1] = State.$NullState$;

				break;

			case Mr_B_r2_U :
				stateVector[1] = State.$NullState$;

				break;

			case Mr_B_r2_V :
				stateVector[1] = State.$NullState$;

				break;

			case Mr_B_r2_W :
				stateVector[1] = State.$NullState$;

				break;

			default :
				break;
		}

		exitActionPerformanceTest();
	}

	private void entryActionPerformanceTest() {

	}

	private void exitActionPerformanceTest() {

	}

	private boolean conditionPerformanceTestLr0() {
		return true;
	}
	private void actionsPerformanceTestLr0() {
		sCIDefault.c += 1;

	}

	private void shallowEnterSequenceMr_BR1() {
		//Handle shallow history entry of r1
		switch (historyVector[0]) {

			case Mr_B_r1_X :
				nextStateIndex = 0;
				stateVector[0] = State.Mr_B_r1_X;

				break;

			case Mr_B_r1_Y :
				nextStateIndex = 0;
				stateVector[0] = State.Mr_B_r1_Y;

				break;

			case Mr_B_r1_Z :
				nextStateIndex = 0;
				stateVector[0] = State.Mr_B_r1_Z;

				break;

			case Mr_B_r1_V :
				nextStateIndex = 0;
				stateVector[0] = State.Mr_B_r1_V;

				break;

			case Mr_B_r1_W :
				nextStateIndex = 0;
				stateVector[0] = State.Mr_B_r1_W;

				break;

			case Mr_B_r1_S :
				nextStateIndex = 0;
				stateVector[0] = State.Mr_B_r1_S;

				break;

			case Mr_B_r1_T :
				nextStateIndex = 0;
				stateVector[0] = State.Mr_B_r1_T;

				break;

			case Mr_B_r1_U :
				nextStateIndex = 0;
				stateVector[0] = State.Mr_B_r1_U;

				break;

			default :
				break;
		}
	}

	private void reactMr_A() {
		actionsPerformanceTestLr0();
		if (sCIDefault.e1) {
			stateVector[0] = State.$NullState$;

			//Enter the region with shallow history
			if (historyVector[0] != State.$NullState$) {
				shallowEnterSequenceMr_BR1();
			} else {
				nextStateIndex = 0;
				stateVector[0] = State.Mr_B_r1_S;

			}

			nextStateIndex = 1;
			stateVector[1] = State.Mr_B_r2_S;

		}

	}
	private void reactMr_B() {
	}
	private void reactMr_B_r1_X() {
		actionsPerformanceTestLr0();
		if (sCIDefault.e2) {
			stateVector[0] = State.$NullState$;

			if (true) {
				sCIDefault.x += 1;

				if ((sCIDefault.x == 4)) {
					nextStateIndex = 0;
					stateVector[0] = State.Mr_B_r1_V;

				} else {
					if ((sCIDefault.x == 5)) {
						nextStateIndex = 0;
						stateVector[0] = State.Mr_B_r1_W;

					} else {
						if ((sCIDefault.x == 6)) {
							nextStateIndex = 0;
							stateVector[0] = State.Mr_B_r1_X;

						} else {
							if ((sCIDefault.x == 7)) {
								nextStateIndex = 0;
								stateVector[0] = State.Mr_B_r1_Y;

							} else {
								if ((sCIDefault.x == 8)) {
									sCIDefault.x = 0;

									nextStateIndex = 0;
									stateVector[0] = State.Mr_B_r1_Z;

								} else {
									if ((sCIDefault.x == 3)) {
										nextStateIndex = 0;
										stateVector[0] = State.Mr_B_r1_U;

									} else {
										if ((sCIDefault.x == 2)) {
											nextStateIndex = 0;
											stateVector[0] = State.Mr_B_r1_T;

										} else {
											nextStateIndex = 0;
											stateVector[0] = State.Mr_B_r1_S;

										}
									}
								}
							}
						}
					}
				}

			}

		}

	}
	private void reactMr_B_r1_Y() {
		actionsPerformanceTestLr0();
		if (sCIDefault.e2) {
			stateVector[0] = State.$NullState$;

			if (true) {
				sCIDefault.x += 1;

				if ((sCIDefault.x == 4)) {
					nextStateIndex = 0;
					stateVector[0] = State.Mr_B_r1_V;

				} else {
					if ((sCIDefault.x == 5)) {
						nextStateIndex = 0;
						stateVector[0] = State.Mr_B_r1_W;

					} else {
						if ((sCIDefault.x == 6)) {
							nextStateIndex = 0;
							stateVector[0] = State.Mr_B_r1_X;

						} else {
							if ((sCIDefault.x == 7)) {
								nextStateIndex = 0;
								stateVector[0] = State.Mr_B_r1_Y;

							} else {
								if ((sCIDefault.x == 8)) {
									sCIDefault.x = 0;

									nextStateIndex = 0;
									stateVector[0] = State.Mr_B_r1_Z;

								} else {
									if ((sCIDefault.x == 3)) {
										nextStateIndex = 0;
										stateVector[0] = State.Mr_B_r1_U;

									} else {
										if ((sCIDefault.x == 2)) {
											nextStateIndex = 0;
											stateVector[0] = State.Mr_B_r1_T;

										} else {
											nextStateIndex = 0;
											stateVector[0] = State.Mr_B_r1_S;

										}
									}
								}
							}
						}
					}
				}

			}

		}

	}
	private void reactMr_B_r1_Z() {
		actionsPerformanceTestLr0();
		if (sCIDefault.e2) {
			stateVector[0] = State.$NullState$;

			if (true) {
				sCIDefault.x += 1;

				if ((sCIDefault.x == 4)) {
					nextStateIndex = 0;
					stateVector[0] = State.Mr_B_r1_V;

				} else {
					if ((sCIDefault.x == 5)) {
						nextStateIndex = 0;
						stateVector[0] = State.Mr_B_r1_W;

					} else {
						if ((sCIDefault.x == 6)) {
							nextStateIndex = 0;
							stateVector[0] = State.Mr_B_r1_X;

						} else {
							if ((sCIDefault.x == 7)) {
								nextStateIndex = 0;
								stateVector[0] = State.Mr_B_r1_Y;

							} else {
								if ((sCIDefault.x == 8)) {
									sCIDefault.x = 0;

									nextStateIndex = 0;
									stateVector[0] = State.Mr_B_r1_Z;

								} else {
									if ((sCIDefault.x == 3)) {
										nextStateIndex = 0;
										stateVector[0] = State.Mr_B_r1_U;

									} else {
										if ((sCIDefault.x == 2)) {
											nextStateIndex = 0;
											stateVector[0] = State.Mr_B_r1_T;

										} else {
											nextStateIndex = 0;
											stateVector[0] = State.Mr_B_r1_S;

										}
									}
								}
							}
						}
					}
				}

			}

		}

	}
	private void reactMr_B_r1_V() {
		actionsPerformanceTestLr0();
		if (sCIDefault.e2) {
			stateVector[0] = State.$NullState$;

			if (true) {
				sCIDefault.x += 1;

				if ((sCIDefault.x == 4)) {
					nextStateIndex = 0;
					stateVector[0] = State.Mr_B_r1_V;

				} else {
					if ((sCIDefault.x == 5)) {
						nextStateIndex = 0;
						stateVector[0] = State.Mr_B_r1_W;

					} else {
						if ((sCIDefault.x == 6)) {
							nextStateIndex = 0;
							stateVector[0] = State.Mr_B_r1_X;

						} else {
							if ((sCIDefault.x == 7)) {
								nextStateIndex = 0;
								stateVector[0] = State.Mr_B_r1_Y;

							} else {
								if ((sCIDefault.x == 8)) {
									sCIDefault.x = 0;

									nextStateIndex = 0;
									stateVector[0] = State.Mr_B_r1_Z;

								} else {
									if ((sCIDefault.x == 3)) {
										nextStateIndex = 0;
										stateVector[0] = State.Mr_B_r1_U;

									} else {
										if ((sCIDefault.x == 2)) {
											nextStateIndex = 0;
											stateVector[0] = State.Mr_B_r1_T;

										} else {
											nextStateIndex = 0;
											stateVector[0] = State.Mr_B_r1_S;

										}
									}
								}
							}
						}
					}
				}

			}

		}

	}
	private void reactMr_B_r1_W() {
		actionsPerformanceTestLr0();
		if (sCIDefault.e2) {
			stateVector[0] = State.$NullState$;

			if (true) {
				sCIDefault.x += 1;

				if ((sCIDefault.x == 4)) {
					nextStateIndex = 0;
					stateVector[0] = State.Mr_B_r1_V;

				} else {
					if ((sCIDefault.x == 5)) {
						nextStateIndex = 0;
						stateVector[0] = State.Mr_B_r1_W;

					} else {
						if ((sCIDefault.x == 6)) {
							nextStateIndex = 0;
							stateVector[0] = State.Mr_B_r1_X;

						} else {
							if ((sCIDefault.x == 7)) {
								nextStateIndex = 0;
								stateVector[0] = State.Mr_B_r1_Y;

							} else {
								if ((sCIDefault.x == 8)) {
									sCIDefault.x = 0;

									nextStateIndex = 0;
									stateVector[0] = State.Mr_B_r1_Z;

								} else {
									if ((sCIDefault.x == 3)) {
										nextStateIndex = 0;
										stateVector[0] = State.Mr_B_r1_U;

									} else {
										if ((sCIDefault.x == 2)) {
											nextStateIndex = 0;
											stateVector[0] = State.Mr_B_r1_T;

										} else {
											nextStateIndex = 0;
											stateVector[0] = State.Mr_B_r1_S;

										}
									}
								}
							}
						}
					}
				}

			}

		}

	}
	private void reactMr_B_r1_S() {
		actionsPerformanceTestLr0();
		if (sCIDefault.e2) {
			stateVector[0] = State.$NullState$;

			if (true) {
				sCIDefault.x += 1;

				if ((sCIDefault.x == 4)) {
					nextStateIndex = 0;
					stateVector[0] = State.Mr_B_r1_V;

				} else {
					if ((sCIDefault.x == 5)) {
						nextStateIndex = 0;
						stateVector[0] = State.Mr_B_r1_W;

					} else {
						if ((sCIDefault.x == 6)) {
							nextStateIndex = 0;
							stateVector[0] = State.Mr_B_r1_X;

						} else {
							if ((sCIDefault.x == 7)) {
								nextStateIndex = 0;
								stateVector[0] = State.Mr_B_r1_Y;

							} else {
								if ((sCIDefault.x == 8)) {
									sCIDefault.x = 0;

									nextStateIndex = 0;
									stateVector[0] = State.Mr_B_r1_Z;

								} else {
									if ((sCIDefault.x == 3)) {
										nextStateIndex = 0;
										stateVector[0] = State.Mr_B_r1_U;

									} else {
										if ((sCIDefault.x == 2)) {
											nextStateIndex = 0;
											stateVector[0] = State.Mr_B_r1_T;

										} else {
											nextStateIndex = 0;
											stateVector[0] = State.Mr_B_r1_S;

										}
									}
								}
							}
						}
					}
				}

			}

		} else {
			if ((isStateActive(State.Mr_B_r2_W) && sCIDefault.e3)) {

				historyVector[0] = stateVector[0];
				//Handle exit of all possible states (of r1) at position 0...
				switch (stateVector[0]) {

					case Mr_B_r1_X :
						stateVector[0] = State.$NullState$;

						break;

					case Mr_B_r1_Y :
						stateVector[0] = State.$NullState$;

						break;

					case Mr_B_r1_Z :
						stateVector[0] = State.$NullState$;

						break;

					case Mr_B_r1_V :
						stateVector[0] = State.$NullState$;

						break;

					case Mr_B_r1_W :
						stateVector[0] = State.$NullState$;

						break;

					case Mr_B_r1_S :
						stateVector[0] = State.$NullState$;

						break;

					case Mr_B_r1_T :
						stateVector[0] = State.$NullState$;

						break;

					case Mr_B_r1_U :
						stateVector[0] = State.$NullState$;

						break;

					default :
						break;
				}

				//Handle exit of all possible states (of r2) at position 1...
				switch (stateVector[1]) {

					case Mr_B_r2_S :
						stateVector[1] = State.$NullState$;

						break;

					case Mr_B_r2_T :
						stateVector[1] = State.$NullState$;

						break;

					case Mr_B_r2_U :
						stateVector[1] = State.$NullState$;

						break;

					case Mr_B_r2_V :
						stateVector[1] = State.$NullState$;

						break;

					case Mr_B_r2_W :
						stateVector[1] = State.$NullState$;

						break;

					default :
						break;
				}

				react_sync0_();
				react_sync0_();

			}
		}

	}
	private void reactMr_B_r1_T() {
		actionsPerformanceTestLr0();
		if (sCIDefault.e2) {
			stateVector[0] = State.$NullState$;

			if (true) {
				sCIDefault.x += 1;

				if ((sCIDefault.x == 4)) {
					nextStateIndex = 0;
					stateVector[0] = State.Mr_B_r1_V;

				} else {
					if ((sCIDefault.x == 5)) {
						nextStateIndex = 0;
						stateVector[0] = State.Mr_B_r1_W;

					} else {
						if ((sCIDefault.x == 6)) {
							nextStateIndex = 0;
							stateVector[0] = State.Mr_B_r1_X;

						} else {
							if ((sCIDefault.x == 7)) {
								nextStateIndex = 0;
								stateVector[0] = State.Mr_B_r1_Y;

							} else {
								if ((sCIDefault.x == 8)) {
									sCIDefault.x = 0;

									nextStateIndex = 0;
									stateVector[0] = State.Mr_B_r1_Z;

								} else {
									if ((sCIDefault.x == 3)) {
										nextStateIndex = 0;
										stateVector[0] = State.Mr_B_r1_U;

									} else {
										if ((sCIDefault.x == 2)) {
											nextStateIndex = 0;
											stateVector[0] = State.Mr_B_r1_T;

										} else {
											nextStateIndex = 0;
											stateVector[0] = State.Mr_B_r1_S;

										}
									}
								}
							}
						}
					}
				}

			}

		}

	}
	private void reactMr_B_r1_U() {
		actionsPerformanceTestLr0();
		if (sCIDefault.e2) {
			stateVector[0] = State.$NullState$;

			if (true) {
				sCIDefault.x += 1;

				if ((sCIDefault.x == 4)) {
					nextStateIndex = 0;
					stateVector[0] = State.Mr_B_r1_V;

				} else {
					if ((sCIDefault.x == 5)) {
						nextStateIndex = 0;
						stateVector[0] = State.Mr_B_r1_W;

					} else {
						if ((sCIDefault.x == 6)) {
							nextStateIndex = 0;
							stateVector[0] = State.Mr_B_r1_X;

						} else {
							if ((sCIDefault.x == 7)) {
								nextStateIndex = 0;
								stateVector[0] = State.Mr_B_r1_Y;

							} else {
								if ((sCIDefault.x == 8)) {
									sCIDefault.x = 0;

									nextStateIndex = 0;
									stateVector[0] = State.Mr_B_r1_Z;

								} else {
									if ((sCIDefault.x == 3)) {
										nextStateIndex = 0;
										stateVector[0] = State.Mr_B_r1_U;

									} else {
										if ((sCIDefault.x == 2)) {
											nextStateIndex = 0;
											stateVector[0] = State.Mr_B_r1_T;

										} else {
											nextStateIndex = 0;
											stateVector[0] = State.Mr_B_r1_S;

										}
									}
								}
							}
						}
					}
				}

			}

		}

	}
	private void reactMr_B_r2_S() {
		if (sCIDefault.e3) {
			stateVector[1] = State.$NullState$;

			nextStateIndex = 1;
			stateVector[1] = State.Mr_B_r2_T;

		}
	}
	private void reactMr_B_r2_T() {
		if (sCIDefault.e3) {
			stateVector[1] = State.$NullState$;

			nextStateIndex = 1;
			stateVector[1] = State.Mr_B_r2_U;

		}
	}
	private void reactMr_B_r2_U() {
		if (sCIDefault.e3) {
			stateVector[1] = State.$NullState$;

			nextStateIndex = 1;
			stateVector[1] = State.Mr_B_r2_V;

		} else {
			if (sCIDefault.e2) {
				stateVector[1] = State.$NullState$;

				nextStateIndex = 1;
				stateVector[1] = State.Mr_B_r2_W;

			}
		}
	}
	private void reactMr_B_r2_V() {
		if (sCIDefault.e3) {
			stateVector[1] = State.$NullState$;

			nextStateIndex = 1;
			stateVector[1] = State.Mr_B_r2_W;

		} else {
			if (sCIDefault.e2) {
				stateVector[1] = State.$NullState$;

				nextStateIndex = 1;
				stateVector[1] = State.Mr_B_r2_S;

			}
		}
	}
	private void reactMr_B_r2_W() {
		if ((sCIDefault.e3 && isStateActive(State.Mr_B_r1_S))) {

			historyVector[0] = stateVector[0];
			//Handle exit of all possible states (of r1) at position 0...
			switch (stateVector[0]) {

				case Mr_B_r1_X :
					stateVector[0] = State.$NullState$;

					break;

				case Mr_B_r1_Y :
					stateVector[0] = State.$NullState$;

					break;

				case Mr_B_r1_Z :
					stateVector[0] = State.$NullState$;

					break;

				case Mr_B_r1_V :
					stateVector[0] = State.$NullState$;

					break;

				case Mr_B_r1_W :
					stateVector[0] = State.$NullState$;

					break;

				case Mr_B_r1_S :
					stateVector[0] = State.$NullState$;

					break;

				case Mr_B_r1_T :
					stateVector[0] = State.$NullState$;

					break;

				case Mr_B_r1_U :
					stateVector[0] = State.$NullState$;

					break;

				default :
					break;
			}

			//Handle exit of all possible states (of r2) at position 1...
			switch (stateVector[1]) {

				case Mr_B_r2_S :
					stateVector[1] = State.$NullState$;

					break;

				case Mr_B_r2_T :
					stateVector[1] = State.$NullState$;

					break;

				case Mr_B_r2_U :
					stateVector[1] = State.$NullState$;

					break;

				case Mr_B_r2_V :
					stateVector[1] = State.$NullState$;

					break;

				case Mr_B_r2_W :
					stateVector[1] = State.$NullState$;

					break;

				default :
					break;
			}

			react_sync0_();
			react_sync0_();

		}
	}
	private void react_sync0_() {
		sCIDefault.a += 1;

		nextStateIndex = 0;
		stateVector[0] = State.Mr_A;

	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case Mr_A :
					reactMr_A();
					break;
				case Mr_B :
					reactMr_B();
					break;
				case Mr_B_r1_X :
					reactMr_B_r1_X();
					break;
				case Mr_B_r1_Y :
					reactMr_B_r1_Y();
					break;
				case Mr_B_r1_Z :
					reactMr_B_r1_Z();
					break;
				case Mr_B_r1_V :
					reactMr_B_r1_V();
					break;
				case Mr_B_r1_W :
					reactMr_B_r1_W();
					break;
				case Mr_B_r1_S :
					reactMr_B_r1_S();
					break;
				case Mr_B_r1_T :
					reactMr_B_r1_T();
					break;
				case Mr_B_r1_U :
					reactMr_B_r1_U();
					break;
				case Mr_B_r2_S :
					reactMr_B_r2_S();
					break;
				case Mr_B_r2_T :
					reactMr_B_r2_T();
					break;
				case Mr_B_r2_U :
					reactMr_B_r2_U();
					break;
				case Mr_B_r2_V :
					reactMr_B_r2_V();
					break;
				case Mr_B_r2_W :
					reactMr_B_r2_W();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
