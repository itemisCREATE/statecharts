package org.yakindu.scr.performancetest;
import org.yakindu.scr.TimeEvent;
import org.yakindu.scr.ITimerService;

public class PerformanceTestStatemachine
		implements
			IPerformanceTestStatemachine {

	private final TimeEvent performanceTest_time_event_0 = new TimeEvent(true,
			0);
	private final TimeEvent performanceTest_time_event_1 = new TimeEvent(true,
			1);

	private final boolean[] timeEvents = new boolean[2];

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

		private int x;

		public int getX() {
			return x;
		}

		public void setX(int value) {
			this.x = value;
		}

		private int a;

		public int getA() {
			return a;
		}

		public void setA(int value) {
			this.a = value;
		}

		private int c;

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
		mr_A, mr_B, mr_B_r1_X, mr_B_r1_Y, mr_B_r1_Z, mr_B_r1_V, mr_B_r1_W, mr_B_r1_S, mr_B_r1_T, mr_B_r1_U, mr_B_r2_S, mr_B_r2_T, mr_B_r2_U, mr_B_r2_V, mr_B_r2_W, $NullState$
	};

	private State[] historyVector = new State[1];
	private final State[] stateVector = new State[2];

	private int nextStateIndex;

	private ITimerService timerService;

	private long cycleStartTime;

	public PerformanceTestStatemachine() {

		sCIDefault = new SCIDefaultImpl();

		performanceTest_time_event_0.setStatemachine(this);
		performanceTest_time_event_1.setStatemachine(this);
	}

	public void init() {
		if (timerService == null) {
			throw new IllegalStateException("TimerService not set.");
		}
		for (int i = 0; i < 2; i++) {
			stateVector[i] = State.$NullState$;
		}

		for (int i = 0; i < 1; i++) {
			historyVector[i] = State.$NullState$;
		}
		clearEvents();
		clearOutEvents();

		sCIDefault.x = 0;

		sCIDefault.a = 0;

		sCIDefault.c = 0;
	}

	public void enter() {
		if (timerService == null) {
			throw new IllegalStateException("TimerService not set.");
		}
		cycleStartTime = System.currentTimeMillis();
		getTimerService().setTimer(performanceTest_time_event_0, 2000,
				cycleStartTime);

		getTimerService().setTimer(performanceTest_time_event_1, 6200,
				cycleStartTime);

		entryAction();

		sCIDefault.a += 1;

		nextStateIndex = 0;
		stateVector[0] = State.mr_A;
	}

	public void exit() {
		switch (stateVector[0]) {
			case mr_A :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case mr_B_r1_X :
				historyVector[0] = stateVector[0];

				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case mr_B_r1_Y :
				historyVector[0] = stateVector[0];

				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case mr_B_r1_Z :
				historyVector[0] = stateVector[0];

				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case mr_B_r1_V :
				historyVector[0] = stateVector[0];

				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case mr_B_r1_W :
				historyVector[0] = stateVector[0];

				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case mr_B_r1_S :
				historyVector[0] = stateVector[0];

				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case mr_B_r1_T :
				historyVector[0] = stateVector[0];

				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case mr_B_r1_U :
				historyVector[0] = stateVector[0];

				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			default :
				break;
		}

		switch (stateVector[1]) {
			case mr_B_r2_S :
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
				break;

			case mr_B_r2_T :
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
				break;

			case mr_B_r2_U :
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
				break;

			case mr_B_r2_V :
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
				break;

			case mr_B_r2_W :
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
				break;

			default :
				break;
		}

		exitAction();
	}

	protected void clearEvents() {
		sCIDefault.clearEvents();

		for (int i = 0; i < timeEvents.length; i++) {
			timeEvents[i] = false;
		}
	}

	protected void clearOutEvents() {
	}

	public boolean isStateActive(State state) {
		switch (state) {
			case mr_A :
				return stateVector[0] == State.mr_A;
			case mr_B :
				return stateVector[0].ordinal() >= State.mr_B.ordinal()
						&& stateVector[0].ordinal() <= State.mr_B_r2_W
								.ordinal();
			case mr_B_r1_X :
				return stateVector[0] == State.mr_B_r1_X;
			case mr_B_r1_Y :
				return stateVector[0] == State.mr_B_r1_Y;
			case mr_B_r1_Z :
				return stateVector[0] == State.mr_B_r1_Z;
			case mr_B_r1_V :
				return stateVector[0] == State.mr_B_r1_V;
			case mr_B_r1_W :
				return stateVector[0] == State.mr_B_r1_W;
			case mr_B_r1_S :
				return stateVector[0] == State.mr_B_r1_S;
			case mr_B_r1_T :
				return stateVector[0] == State.mr_B_r1_T;
			case mr_B_r1_U :
				return stateVector[0] == State.mr_B_r1_U;
			case mr_B_r2_S :
				return stateVector[1] == State.mr_B_r2_S;
			case mr_B_r2_T :
				return stateVector[1] == State.mr_B_r2_T;
			case mr_B_r2_U :
				return stateVector[1] == State.mr_B_r2_U;
			case mr_B_r2_V :
				return stateVector[1] == State.mr_B_r2_V;
			case mr_B_r2_W :
				return stateVector[1] == State.mr_B_r2_W;
			default :
				return false;
		}
	}

	public void setTimerService(ITimerService timerService) {
		this.timerService = timerService;
	}

	public ITimerService getTimerService() {
		return timerService;
	}

	public void onTimeEventRaised(TimeEvent timeEvent) {
		timeEvents[timeEvent.getIndex()] = true;
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

	private boolean checkLr0() {
		return true;
	}

	private boolean checkLr1() {
		return timeEvents[performanceTest_time_event_0.getIndex()];
	}

	private boolean checkLr2() {
		return timeEvents[performanceTest_time_event_1.getIndex()];
	}

	private void effectLr0() {
		sCIDefault.c += 1;
	}

	private void effectLr1() {
		sCIDefault.raiseE2();

		sCIDefault.raiseE1();
	}

	private void effectLr2() {
		sCIDefault.raiseE3();
	}

	/* Entry action for statechart 'PerformanceTest'. */
	private void entryAction() {
		getTimerService().setTimer(performanceTest_time_event_0, 2000,
				cycleStartTime);

		getTimerService().setTimer(performanceTest_time_event_1, 6200,
				cycleStartTime);
	}

	/* Exit action for state 'PerformanceTest'. */
	private void exitAction() {
		getTimerService().resetTimer(performanceTest_time_event_0);

		getTimerService().resetTimer(performanceTest_time_event_1);
	}

	/* shallow enterSequence with history in child r1 */
	private void shallowEnterSequenceMr_B_r1() {
		switch (historyVector[0]) {
			case mr_B_r1_X :
				nextStateIndex = 0;
				stateVector[0] = State.mr_B_r1_X;
				break;

			case mr_B_r1_Y :
				nextStateIndex = 0;
				stateVector[0] = State.mr_B_r1_Y;
				break;

			case mr_B_r1_Z :
				nextStateIndex = 0;
				stateVector[0] = State.mr_B_r1_Z;
				break;

			case mr_B_r1_V :
				nextStateIndex = 0;
				stateVector[0] = State.mr_B_r1_V;
				break;

			case mr_B_r1_W :
				nextStateIndex = 0;
				stateVector[0] = State.mr_B_r1_W;
				break;

			case mr_B_r1_S :
				nextStateIndex = 0;
				stateVector[0] = State.mr_B_r1_S;
				break;

			case mr_B_r1_T :
				nextStateIndex = 0;
				stateVector[0] = State.mr_B_r1_T;
				break;

			case mr_B_r1_U :
				nextStateIndex = 0;
				stateVector[0] = State.mr_B_r1_U;
				break;

			default :
				break;
		}
	}

	/* The reactions of state A. */
	private void reactMr_A() {
		effectLr0();

		if (checkLr1()) {
			effectLr1();
		}

		if (checkLr2()) {
			effectLr2();
		}

		if (sCIDefault.e1) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			/* Enter the region with shallow history */
			if (historyVector[0] != State.$NullState$) {
				shallowEnterSequenceMr_B_r1();
			} else {
				nextStateIndex = 0;
				stateVector[0] = State.mr_B_r1_S;
			}

			nextStateIndex = 1;
			stateVector[1] = State.mr_B_r2_S;
		}
	}

	/* The reactions of state X. */
	private void reactMr_B_r1_X() {
		effectLr0();

		if (checkLr1()) {
			effectLr1();
		}

		if (checkLr2()) {
			effectLr2();
		}

		if (sCIDefault.e2) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			if (true) {
				sCIDefault.x += 1;

				if (sCIDefault.x == 4) {
					nextStateIndex = 0;
					stateVector[0] = State.mr_B_r1_V;
				} else {
					if (sCIDefault.x == 5) {
						nextStateIndex = 0;
						stateVector[0] = State.mr_B_r1_W;
					} else {
						if (sCIDefault.x == 6) {
							nextStateIndex = 0;
							stateVector[0] = State.mr_B_r1_X;
						} else {
							if (sCIDefault.x == 7) {
								nextStateIndex = 0;
								stateVector[0] = State.mr_B_r1_Y;
							} else {
								if (sCIDefault.x == 8) {
									sCIDefault.x = 0;

									nextStateIndex = 0;
									stateVector[0] = State.mr_B_r1_Z;
								} else {
									if (sCIDefault.x == 3) {
										nextStateIndex = 0;
										stateVector[0] = State.mr_B_r1_U;
									} else {
										if (sCIDefault.x == 2) {
											nextStateIndex = 0;
											stateVector[0] = State.mr_B_r1_T;
										} else {
											if (true) {
												nextStateIndex = 0;
												stateVector[0] = State.mr_B_r1_S;
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
	}

	/* The reactions of state Y. */
	private void reactMr_B_r1_Y() {
		effectLr0();

		if (checkLr1()) {
			effectLr1();
		}

		if (checkLr2()) {
			effectLr2();
		}

		if (sCIDefault.e2) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			if (true) {
				sCIDefault.x += 1;

				if (sCIDefault.x == 4) {
					nextStateIndex = 0;
					stateVector[0] = State.mr_B_r1_V;
				} else {
					if (sCIDefault.x == 5) {
						nextStateIndex = 0;
						stateVector[0] = State.mr_B_r1_W;
					} else {
						if (sCIDefault.x == 6) {
							nextStateIndex = 0;
							stateVector[0] = State.mr_B_r1_X;
						} else {
							if (sCIDefault.x == 7) {
								nextStateIndex = 0;
								stateVector[0] = State.mr_B_r1_Y;
							} else {
								if (sCIDefault.x == 8) {
									sCIDefault.x = 0;

									nextStateIndex = 0;
									stateVector[0] = State.mr_B_r1_Z;
								} else {
									if (sCIDefault.x == 3) {
										nextStateIndex = 0;
										stateVector[0] = State.mr_B_r1_U;
									} else {
										if (sCIDefault.x == 2) {
											nextStateIndex = 0;
											stateVector[0] = State.mr_B_r1_T;
										} else {
											if (true) {
												nextStateIndex = 0;
												stateVector[0] = State.mr_B_r1_S;
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
	}

	/* The reactions of state Z. */
	private void reactMr_B_r1_Z() {
		effectLr0();

		if (checkLr1()) {
			effectLr1();
		}

		if (checkLr2()) {
			effectLr2();
		}

		if (sCIDefault.e2) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			if (true) {
				sCIDefault.x += 1;

				if (sCIDefault.x == 4) {
					nextStateIndex = 0;
					stateVector[0] = State.mr_B_r1_V;
				} else {
					if (sCIDefault.x == 5) {
						nextStateIndex = 0;
						stateVector[0] = State.mr_B_r1_W;
					} else {
						if (sCIDefault.x == 6) {
							nextStateIndex = 0;
							stateVector[0] = State.mr_B_r1_X;
						} else {
							if (sCIDefault.x == 7) {
								nextStateIndex = 0;
								stateVector[0] = State.mr_B_r1_Y;
							} else {
								if (sCIDefault.x == 8) {
									sCIDefault.x = 0;

									nextStateIndex = 0;
									stateVector[0] = State.mr_B_r1_Z;
								} else {
									if (sCIDefault.x == 3) {
										nextStateIndex = 0;
										stateVector[0] = State.mr_B_r1_U;
									} else {
										if (sCIDefault.x == 2) {
											nextStateIndex = 0;
											stateVector[0] = State.mr_B_r1_T;
										} else {
											if (true) {
												nextStateIndex = 0;
												stateVector[0] = State.mr_B_r1_S;
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
	}

	/* The reactions of state V. */
	private void reactMr_B_r1_V() {
		effectLr0();

		if (checkLr1()) {
			effectLr1();
		}

		if (checkLr2()) {
			effectLr2();
		}

		if (sCIDefault.e2) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			if (true) {
				sCIDefault.x += 1;

				if (sCIDefault.x == 4) {
					nextStateIndex = 0;
					stateVector[0] = State.mr_B_r1_V;
				} else {
					if (sCIDefault.x == 5) {
						nextStateIndex = 0;
						stateVector[0] = State.mr_B_r1_W;
					} else {
						if (sCIDefault.x == 6) {
							nextStateIndex = 0;
							stateVector[0] = State.mr_B_r1_X;
						} else {
							if (sCIDefault.x == 7) {
								nextStateIndex = 0;
								stateVector[0] = State.mr_B_r1_Y;
							} else {
								if (sCIDefault.x == 8) {
									sCIDefault.x = 0;

									nextStateIndex = 0;
									stateVector[0] = State.mr_B_r1_Z;
								} else {
									if (sCIDefault.x == 3) {
										nextStateIndex = 0;
										stateVector[0] = State.mr_B_r1_U;
									} else {
										if (sCIDefault.x == 2) {
											nextStateIndex = 0;
											stateVector[0] = State.mr_B_r1_T;
										} else {
											if (true) {
												nextStateIndex = 0;
												stateVector[0] = State.mr_B_r1_S;
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
	}

	/* The reactions of state W. */
	private void reactMr_B_r1_W() {
		effectLr0();

		if (checkLr1()) {
			effectLr1();
		}

		if (checkLr2()) {
			effectLr2();
		}

		if (sCIDefault.e2) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			if (true) {
				sCIDefault.x += 1;

				if (sCIDefault.x == 4) {
					nextStateIndex = 0;
					stateVector[0] = State.mr_B_r1_V;
				} else {
					if (sCIDefault.x == 5) {
						nextStateIndex = 0;
						stateVector[0] = State.mr_B_r1_W;
					} else {
						if (sCIDefault.x == 6) {
							nextStateIndex = 0;
							stateVector[0] = State.mr_B_r1_X;
						} else {
							if (sCIDefault.x == 7) {
								nextStateIndex = 0;
								stateVector[0] = State.mr_B_r1_Y;
							} else {
								if (sCIDefault.x == 8) {
									sCIDefault.x = 0;

									nextStateIndex = 0;
									stateVector[0] = State.mr_B_r1_Z;
								} else {
									if (sCIDefault.x == 3) {
										nextStateIndex = 0;
										stateVector[0] = State.mr_B_r1_U;
									} else {
										if (sCIDefault.x == 2) {
											nextStateIndex = 0;
											stateVector[0] = State.mr_B_r1_T;
										} else {
											if (true) {
												nextStateIndex = 0;
												stateVector[0] = State.mr_B_r1_S;
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
	}

	/* The reactions of state S. */
	private void reactMr_B_r1_S() {
		effectLr0();

		if (checkLr1()) {
			effectLr1();
		}

		if (checkLr2()) {
			effectLr2();
		}

		if (sCIDefault.e2) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			if (true) {
				sCIDefault.x += 1;

				if (sCIDefault.x == 4) {
					nextStateIndex = 0;
					stateVector[0] = State.mr_B_r1_V;
				} else {
					if (sCIDefault.x == 5) {
						nextStateIndex = 0;
						stateVector[0] = State.mr_B_r1_W;
					} else {
						if (sCIDefault.x == 6) {
							nextStateIndex = 0;
							stateVector[0] = State.mr_B_r1_X;
						} else {
							if (sCIDefault.x == 7) {
								nextStateIndex = 0;
								stateVector[0] = State.mr_B_r1_Y;
							} else {
								if (sCIDefault.x == 8) {
									sCIDefault.x = 0;

									nextStateIndex = 0;
									stateVector[0] = State.mr_B_r1_Z;
								} else {
									if (sCIDefault.x == 3) {
										nextStateIndex = 0;
										stateVector[0] = State.mr_B_r1_U;
									} else {
										if (sCIDefault.x == 2) {
											nextStateIndex = 0;
											stateVector[0] = State.mr_B_r1_T;
										} else {
											if (true) {
												nextStateIndex = 0;
												stateVector[0] = State.mr_B_r1_S;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		} else {
			if (isStateActive(State.mr_B_r2_W) && sCIDefault.e3) {
				historyVector[0] = stateVector[0];

				switch (stateVector[0]) {
					case mr_B_r1_X :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					case mr_B_r1_Y :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					case mr_B_r1_Z :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					case mr_B_r1_V :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					case mr_B_r1_W :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					case mr_B_r1_S :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					case mr_B_r1_T :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					case mr_B_r1_U :
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					default :
						break;
				}

				switch (stateVector[1]) {
					case mr_B_r2_S :
						nextStateIndex = 1;
						stateVector[1] = State.$NullState$;
						break;

					case mr_B_r2_T :
						nextStateIndex = 1;
						stateVector[1] = State.$NullState$;
						break;

					case mr_B_r2_U :
						nextStateIndex = 1;
						stateVector[1] = State.$NullState$;
						break;

					case mr_B_r2_V :
						nextStateIndex = 1;
						stateVector[1] = State.$NullState$;
						break;

					case mr_B_r2_W :
						nextStateIndex = 1;
						stateVector[1] = State.$NullState$;
						break;

					default :
						break;
				}

				reactPerformanceTest_mr__sync0();

				reactPerformanceTest_mr__sync0();
			}
		}
	}

	/* The reactions of state T. */
	private void reactMr_B_r1_T() {
		effectLr0();

		if (checkLr1()) {
			effectLr1();
		}

		if (checkLr2()) {
			effectLr2();
		}

		if (sCIDefault.e2) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			if (true) {
				sCIDefault.x += 1;

				if (sCIDefault.x == 4) {
					nextStateIndex = 0;
					stateVector[0] = State.mr_B_r1_V;
				} else {
					if (sCIDefault.x == 5) {
						nextStateIndex = 0;
						stateVector[0] = State.mr_B_r1_W;
					} else {
						if (sCIDefault.x == 6) {
							nextStateIndex = 0;
							stateVector[0] = State.mr_B_r1_X;
						} else {
							if (sCIDefault.x == 7) {
								nextStateIndex = 0;
								stateVector[0] = State.mr_B_r1_Y;
							} else {
								if (sCIDefault.x == 8) {
									sCIDefault.x = 0;

									nextStateIndex = 0;
									stateVector[0] = State.mr_B_r1_Z;
								} else {
									if (sCIDefault.x == 3) {
										nextStateIndex = 0;
										stateVector[0] = State.mr_B_r1_U;
									} else {
										if (sCIDefault.x == 2) {
											nextStateIndex = 0;
											stateVector[0] = State.mr_B_r1_T;
										} else {
											if (true) {
												nextStateIndex = 0;
												stateVector[0] = State.mr_B_r1_S;
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
	}

	/* The reactions of state U. */
	private void reactMr_B_r1_U() {
		effectLr0();

		if (checkLr1()) {
			effectLr1();
		}

		if (checkLr2()) {
			effectLr2();
		}

		if (sCIDefault.e2) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			if (true) {
				sCIDefault.x += 1;

				if (sCIDefault.x == 4) {
					nextStateIndex = 0;
					stateVector[0] = State.mr_B_r1_V;
				} else {
					if (sCIDefault.x == 5) {
						nextStateIndex = 0;
						stateVector[0] = State.mr_B_r1_W;
					} else {
						if (sCIDefault.x == 6) {
							nextStateIndex = 0;
							stateVector[0] = State.mr_B_r1_X;
						} else {
							if (sCIDefault.x == 7) {
								nextStateIndex = 0;
								stateVector[0] = State.mr_B_r1_Y;
							} else {
								if (sCIDefault.x == 8) {
									sCIDefault.x = 0;

									nextStateIndex = 0;
									stateVector[0] = State.mr_B_r1_Z;
								} else {
									if (sCIDefault.x == 3) {
										nextStateIndex = 0;
										stateVector[0] = State.mr_B_r1_U;
									} else {
										if (sCIDefault.x == 2) {
											nextStateIndex = 0;
											stateVector[0] = State.mr_B_r1_T;
										} else {
											if (true) {
												nextStateIndex = 0;
												stateVector[0] = State.mr_B_r1_S;
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
	}

	/* The reactions of state S. */
	private void reactMr_B_r2_S() {
		if (sCIDefault.e3) {
			nextStateIndex = 1;
			stateVector[1] = State.$NullState$;

			nextStateIndex = 1;
			stateVector[1] = State.mr_B_r2_T;
		}
	}

	/* The reactions of state T. */
	private void reactMr_B_r2_T() {
		if (sCIDefault.e3) {
			nextStateIndex = 1;
			stateVector[1] = State.$NullState$;

			nextStateIndex = 1;
			stateVector[1] = State.mr_B_r2_U;
		}
	}

	/* The reactions of state U. */
	private void reactMr_B_r2_U() {
		if (sCIDefault.e3) {
			nextStateIndex = 1;
			stateVector[1] = State.$NullState$;

			nextStateIndex = 1;
			stateVector[1] = State.mr_B_r2_V;
		} else {
			if (sCIDefault.e2) {
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;

				nextStateIndex = 1;
				stateVector[1] = State.mr_B_r2_W;
			}
		}
	}

	/* The reactions of state V. */
	private void reactMr_B_r2_V() {
		if (sCIDefault.e3) {
			nextStateIndex = 1;
			stateVector[1] = State.$NullState$;

			nextStateIndex = 1;
			stateVector[1] = State.mr_B_r2_W;
		} else {
			if (sCIDefault.e2) {
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;

				nextStateIndex = 1;
				stateVector[1] = State.mr_B_r2_S;
			}
		}
	}

	/* The reactions of state W. */
	private void reactMr_B_r2_W() {
		if (sCIDefault.e3 && isStateActive(State.mr_B_r1_S)) {
			historyVector[0] = stateVector[0];

			switch (stateVector[0]) {
				case mr_B_r1_X :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case mr_B_r1_Y :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case mr_B_r1_Z :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case mr_B_r1_V :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case mr_B_r1_W :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case mr_B_r1_S :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case mr_B_r1_T :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case mr_B_r1_U :
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				default :
					break;
			}

			switch (stateVector[1]) {
				case mr_B_r2_S :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				case mr_B_r2_T :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				case mr_B_r2_U :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				case mr_B_r2_V :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				case mr_B_r2_W :
					nextStateIndex = 1;
					stateVector[1] = State.$NullState$;
					break;

				default :
					break;
			}

			reactPerformanceTest_mr__sync0();

			reactPerformanceTest_mr__sync0();
		}
	}

	/* The reactions of state null. */
	private void reactPerformanceTest_mr__sync0() {
		sCIDefault.a += 1;

		nextStateIndex = 0;
		stateVector[0] = State.mr_A;
	}

	public void runCycle() {

		cycleStartTime = System.currentTimeMillis();

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case mr_A :
					reactMr_A();
					break;
				case mr_B_r1_X :
					reactMr_B_r1_X();
					break;
				case mr_B_r1_Y :
					reactMr_B_r1_Y();
					break;
				case mr_B_r1_Z :
					reactMr_B_r1_Z();
					break;
				case mr_B_r1_V :
					reactMr_B_r1_V();
					break;
				case mr_B_r1_W :
					reactMr_B_r1_W();
					break;
				case mr_B_r1_S :
					reactMr_B_r1_S();
					break;
				case mr_B_r1_T :
					reactMr_B_r1_T();
					break;
				case mr_B_r1_U :
					reactMr_B_r1_U();
					break;
				case mr_B_r2_S :
					reactMr_B_r2_S();
					break;
				case mr_B_r2_T :
					reactMr_B_r2_T();
					break;
				case mr_B_r2_U :
					reactMr_B_r2_U();
					break;
				case mr_B_r2_V :
					reactMr_B_r2_V();
					break;
				case mr_B_r2_W :
					reactMr_B_r2_W();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
