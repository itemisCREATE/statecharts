/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.runtime.java.test_hierarchy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import org.yakindu.sct.runtime.java.Event;
import org.yakindu.sct.runtime.java.IStatemachine;

public class Test_HierarchyCycleBasedStatemachine implements IStatemachine {

	public enum State {
		State1, State9, State10, State2, State3, State4, State5, State6, State7, State8,
	};

	private DefaultInterfaceImpl defaultInterface;

	private final Set<State> activeStates = EnumSet.noneOf(State.class);

	private final ArrayList<Event> occuredEvents;

	private final Collection<Event> outEvents;

	public Test_HierarchyCycleBasedStatemachine() {
		occuredEvents = new ArrayList<Event>();
		outEvents = new HashSet<Event>();
		defaultInterface = new DefaultInterfaceImpl(this);

	}

	protected Collection<Event> getOccuredEvents() {
		return occuredEvents;
	}

	protected Collection<Event> getOutEvents() {
		return outEvents;
	}

	protected boolean eventOccured() {
		return !occuredEvents.isEmpty();
	}

	public void init() {

	}

	public Set<State> getActiveStates() {
		return EnumSet.copyOf(activeStates);
	}

	public DefaultInterface getDefaultInterface() {
		return defaultInterface;
	}

	public void enter() {
		defaultInterface.setVarS1(1);

		defaultInterface.setVarS1(defaultInterface.getVarS1() + (1));

		activeStates.add(State.State9);

	}

	private void reactState1() {
	}
	private void reactState9() {
		if (occuredEvents.contains(defaultInterface.getEventEvent1())) {
			if (activeStates.contains(State.State9)) {
				activeStates.remove(State.State9);
				defaultInterface.setVarS1(defaultInterface.getVarS1() - (1));

			} else if (activeStates.contains(State.State10)) {
				activeStates.remove(State.State10);
				defaultInterface.setVarS1(defaultInterface.getVarS1() - (1));

			}
			defaultInterface.setVarS1(defaultInterface.getVarS1() - (1));

			defaultInterface.setVarS2(1);

			defaultInterface.setVarS2(defaultInterface.getVarS2() + (1));

			activeStates.add(State.State3);

		} else {
			if (occuredEvents.contains(defaultInterface.getEventEvent9())) {
				activeStates.remove(State.State9);
				defaultInterface.setVarS1(defaultInterface.getVarS1() - (1));

				defaultInterface.setVarS1(defaultInterface.getVarS1() + (1));

				activeStates.add(State.State10);

			}

		}
	}
	private void reactState10() {
		if (occuredEvents.contains(defaultInterface.getEventEvent1())) {
			if (activeStates.contains(State.State9)) {
				activeStates.remove(State.State9);
				defaultInterface.setVarS1(defaultInterface.getVarS1() - (1));

			} else if (activeStates.contains(State.State10)) {
				activeStates.remove(State.State10);
				defaultInterface.setVarS1(defaultInterface.getVarS1() - (1));

			}
			defaultInterface.setVarS1(defaultInterface.getVarS1() - (1));

			defaultInterface.setVarS2(1);

			defaultInterface.setVarS2(defaultInterface.getVarS2() + (1));

			activeStates.add(State.State3);

		} else {
			if (occuredEvents.contains(defaultInterface.getEventEvent10())) {
				activeStates.remove(State.State10);
				defaultInterface.setVarS1(defaultInterface.getVarS1() - (1));

				defaultInterface.setVarS1(defaultInterface.getVarS1() + (1));

				activeStates.add(State.State9);

			}

		}
	}
	private void reactState2() {
	}
	private void reactState3() {
		if (occuredEvents.contains(defaultInterface.getEventEvent6())) {
			if (activeStates.contains(State.State3)) {
				activeStates.remove(State.State3);
				defaultInterface.setVarS2(defaultInterface.getVarS2() - (1));

			} else if (activeStates.contains(State.State5)) {
				activeStates.remove(State.State5);
				defaultInterface.setVarS2(defaultInterface.getVarS2() - (1));

				defaultInterface.setVarS2(defaultInterface.getVarS2() - (1));

			} else if (activeStates.contains(State.State7)) {
				activeStates.remove(State.State7);
				defaultInterface.setVarS2(defaultInterface.getVarS2() - (1));

				defaultInterface.setVarS2(defaultInterface.getVarS2() - (1));

				defaultInterface.setVarS2(defaultInterface.getVarS2() - (1));

			} else if (activeStates.contains(State.State8)) {
				activeStates.remove(State.State8);
				defaultInterface.setVarS2(defaultInterface.getVarS2() - (1));

				defaultInterface.setVarS2(defaultInterface.getVarS2() - (1));

				defaultInterface.setVarS2(defaultInterface.getVarS2() - (1));

			}
			defaultInterface.setVarS2(defaultInterface.getVarS2() - (1));

			defaultInterface.setVarS1(1);

			defaultInterface.setVarS1(defaultInterface.getVarS1() + (1));

			activeStates.add(State.State9);

		} else {
			if (occuredEvents.contains(defaultInterface.getEventEvent2())) {
				activeStates.remove(State.State3);
				defaultInterface.setVarS2(defaultInterface.getVarS2() - (1));

				defaultInterface.setVarS2(defaultInterface.getVarS2() + (1));

				defaultInterface.setVarS2(defaultInterface.getVarS2() + (1));

				activeStates.add(State.State5);

			} else {
				if (occuredEvents.contains(defaultInterface.getEventEvent11())) {
					activeStates.remove(State.State3);
					defaultInterface
							.setVarS2(defaultInterface.getVarS2() - (1));

					defaultInterface
							.setVarS2(defaultInterface.getVarS2() - (1));

					defaultInterface.setVarS1(1);

					defaultInterface
							.setVarS1(defaultInterface.getVarS1() + (1));

					activeStates.add(State.State9);

				} else {
					if (occuredEvents.contains(defaultInterface
							.getEventEvent14())) {
						activeStates.remove(State.State3);
						defaultInterface
								.setVarS2(defaultInterface.getVarS2() - (1));

						defaultInterface
								.setVarS2(defaultInterface.getVarS2() - (1));

						defaultInterface.setVarS1(1);

						defaultInterface
								.setVarS1(defaultInterface.getVarS1() + (1));

						activeStates.add(State.State9);

					}
				}
			}

		}
	}
	private void reactState4() {
	}
	private void reactState5() {
		if (occuredEvents.contains(defaultInterface.getEventEvent6())) {
			if (activeStates.contains(State.State3)) {
				activeStates.remove(State.State3);
				defaultInterface.setVarS2(defaultInterface.getVarS2() - (1));

			} else if (activeStates.contains(State.State5)) {
				activeStates.remove(State.State5);
				defaultInterface.setVarS2(defaultInterface.getVarS2() - (1));

				defaultInterface.setVarS2(defaultInterface.getVarS2() - (1));

			} else if (activeStates.contains(State.State7)) {
				activeStates.remove(State.State7);
				defaultInterface.setVarS2(defaultInterface.getVarS2() - (1));

				defaultInterface.setVarS2(defaultInterface.getVarS2() - (1));

				defaultInterface.setVarS2(defaultInterface.getVarS2() - (1));

			} else if (activeStates.contains(State.State8)) {
				activeStates.remove(State.State8);
				defaultInterface.setVarS2(defaultInterface.getVarS2() - (1));

				defaultInterface.setVarS2(defaultInterface.getVarS2() - (1));

				defaultInterface.setVarS2(defaultInterface.getVarS2() - (1));

			}
			defaultInterface.setVarS2(defaultInterface.getVarS2() - (1));

			defaultInterface.setVarS1(1);

			defaultInterface.setVarS1(defaultInterface.getVarS1() + (1));

			activeStates.add(State.State9);

		} else {
			if (occuredEvents.contains(defaultInterface.getEventEvent7())) {
				if (activeStates.contains(State.State5)) {
					activeStates.remove(State.State5);
					defaultInterface
							.setVarS2(defaultInterface.getVarS2() - (1));

				} else if (activeStates.contains(State.State7)) {
					activeStates.remove(State.State7);
					defaultInterface
							.setVarS2(defaultInterface.getVarS2() - (1));

					defaultInterface
							.setVarS2(defaultInterface.getVarS2() - (1));

				} else if (activeStates.contains(State.State8)) {
					activeStates.remove(State.State8);
					defaultInterface
							.setVarS2(defaultInterface.getVarS2() - (1));

					defaultInterface
							.setVarS2(defaultInterface.getVarS2() - (1));

				}
				defaultInterface.setVarS2(defaultInterface.getVarS2() - (1));

				defaultInterface.setVarS2(defaultInterface.getVarS2() + (1));

				activeStates.add(State.State3);

			} else {
				if (occuredEvents.contains(defaultInterface.getEventEvent3())) {
					activeStates.remove(State.State5);
					defaultInterface
							.setVarS2(defaultInterface.getVarS2() - (1));

					defaultInterface
							.setVarS2(defaultInterface.getVarS2() + (1));

					defaultInterface
							.setVarS2(defaultInterface.getVarS2() + (1));

					activeStates.add(State.State7);

				} else {
					if (occuredEvents.contains(defaultInterface
							.getEventEvent12())) {
						activeStates.remove(State.State5);
						defaultInterface
								.setVarS2(defaultInterface.getVarS2() - (1));

						defaultInterface
								.setVarS2(defaultInterface.getVarS2() - (1));

						defaultInterface
								.setVarS2(defaultInterface.getVarS2() - (1));

						defaultInterface.setVarS1(1);

						defaultInterface
								.setVarS1(defaultInterface.getVarS1() + (1));

						activeStates.add(State.State9);

					} else {
						if (occuredEvents.contains(defaultInterface
								.getEventEvent15())) {
							activeStates.remove(State.State5);
							defaultInterface.setVarS2(defaultInterface
									.getVarS2() - (1));

							defaultInterface.setVarS2(defaultInterface
									.getVarS2() - (1));

							defaultInterface.setVarS2(defaultInterface
									.getVarS2() - (1));

							defaultInterface.setVarS1(1);

							defaultInterface.setVarS1(defaultInterface
									.getVarS1() + (1));

							activeStates.add(State.State10);

						}
					}
				}

			}

		}
	}
	private void reactState6() {
	}
	private void reactState7() {
		if (occuredEvents.contains(defaultInterface.getEventEvent6())) {
			if (activeStates.contains(State.State3)) {
				activeStates.remove(State.State3);
				defaultInterface.setVarS2(defaultInterface.getVarS2() - (1));

			} else if (activeStates.contains(State.State5)) {
				activeStates.remove(State.State5);
				defaultInterface.setVarS2(defaultInterface.getVarS2() - (1));

				defaultInterface.setVarS2(defaultInterface.getVarS2() - (1));

			} else if (activeStates.contains(State.State7)) {
				activeStates.remove(State.State7);
				defaultInterface.setVarS2(defaultInterface.getVarS2() - (1));

				defaultInterface.setVarS2(defaultInterface.getVarS2() - (1));

				defaultInterface.setVarS2(defaultInterface.getVarS2() - (1));

			} else if (activeStates.contains(State.State8)) {
				activeStates.remove(State.State8);
				defaultInterface.setVarS2(defaultInterface.getVarS2() - (1));

				defaultInterface.setVarS2(defaultInterface.getVarS2() - (1));

				defaultInterface.setVarS2(defaultInterface.getVarS2() - (1));

			}
			defaultInterface.setVarS2(defaultInterface.getVarS2() - (1));

			defaultInterface.setVarS1(1);

			defaultInterface.setVarS1(defaultInterface.getVarS1() + (1));

			activeStates.add(State.State9);

		} else {
			if (occuredEvents.contains(defaultInterface.getEventEvent7())) {
				if (activeStates.contains(State.State5)) {
					activeStates.remove(State.State5);
					defaultInterface
							.setVarS2(defaultInterface.getVarS2() - (1));

				} else if (activeStates.contains(State.State7)) {
					activeStates.remove(State.State7);
					defaultInterface
							.setVarS2(defaultInterface.getVarS2() - (1));

					defaultInterface
							.setVarS2(defaultInterface.getVarS2() - (1));

				} else if (activeStates.contains(State.State8)) {
					activeStates.remove(State.State8);
					defaultInterface
							.setVarS2(defaultInterface.getVarS2() - (1));

					defaultInterface
							.setVarS2(defaultInterface.getVarS2() - (1));

				}
				defaultInterface.setVarS2(defaultInterface.getVarS2() - (1));

				defaultInterface.setVarS2(defaultInterface.getVarS2() + (1));

				activeStates.add(State.State3);

			} else {
				if (occuredEvents.contains(defaultInterface.getEventEvent8())) {
					if (activeStates.contains(State.State7)) {
						activeStates.remove(State.State7);
						defaultInterface
								.setVarS2(defaultInterface.getVarS2() - (1));

					} else if (activeStates.contains(State.State8)) {
						activeStates.remove(State.State8);
						defaultInterface
								.setVarS2(defaultInterface.getVarS2() - (1));

					}
					defaultInterface
							.setVarS2(defaultInterface.getVarS2() - (1));

					defaultInterface
							.setVarS2(defaultInterface.getVarS2() + (1));

					activeStates.add(State.State5);

				} else {
					if (occuredEvents.contains(defaultInterface
							.getEventEvent4())) {
						activeStates.remove(State.State7);
						defaultInterface
								.setVarS2(defaultInterface.getVarS2() - (1));

						defaultInterface
								.setVarS2(defaultInterface.getVarS2() + (1));

						activeStates.add(State.State8);

					}

				}

			}

		}
	}
	private void reactState8() {
		if (occuredEvents.contains(defaultInterface.getEventEvent6())) {
			if (activeStates.contains(State.State3)) {
				activeStates.remove(State.State3);
				defaultInterface.setVarS2(defaultInterface.getVarS2() - (1));

			} else if (activeStates.contains(State.State5)) {
				activeStates.remove(State.State5);
				defaultInterface.setVarS2(defaultInterface.getVarS2() - (1));

				defaultInterface.setVarS2(defaultInterface.getVarS2() - (1));

			} else if (activeStates.contains(State.State7)) {
				activeStates.remove(State.State7);
				defaultInterface.setVarS2(defaultInterface.getVarS2() - (1));

				defaultInterface.setVarS2(defaultInterface.getVarS2() - (1));

				defaultInterface.setVarS2(defaultInterface.getVarS2() - (1));

			} else if (activeStates.contains(State.State8)) {
				activeStates.remove(State.State8);
				defaultInterface.setVarS2(defaultInterface.getVarS2() - (1));

				defaultInterface.setVarS2(defaultInterface.getVarS2() - (1));

				defaultInterface.setVarS2(defaultInterface.getVarS2() - (1));

			}
			defaultInterface.setVarS2(defaultInterface.getVarS2() - (1));

			defaultInterface.setVarS1(1);

			defaultInterface.setVarS1(defaultInterface.getVarS1() + (1));

			activeStates.add(State.State9);

		} else {
			if (occuredEvents.contains(defaultInterface.getEventEvent7())) {
				if (activeStates.contains(State.State5)) {
					activeStates.remove(State.State5);
					defaultInterface
							.setVarS2(defaultInterface.getVarS2() - (1));

				} else if (activeStates.contains(State.State7)) {
					activeStates.remove(State.State7);
					defaultInterface
							.setVarS2(defaultInterface.getVarS2() - (1));

					defaultInterface
							.setVarS2(defaultInterface.getVarS2() - (1));

				} else if (activeStates.contains(State.State8)) {
					activeStates.remove(State.State8);
					defaultInterface
							.setVarS2(defaultInterface.getVarS2() - (1));

					defaultInterface
							.setVarS2(defaultInterface.getVarS2() - (1));

				}
				defaultInterface.setVarS2(defaultInterface.getVarS2() - (1));

				defaultInterface.setVarS2(defaultInterface.getVarS2() + (1));

				activeStates.add(State.State3);

			} else {
				if (occuredEvents.contains(defaultInterface.getEventEvent8())) {
					if (activeStates.contains(State.State7)) {
						activeStates.remove(State.State7);
						defaultInterface
								.setVarS2(defaultInterface.getVarS2() - (1));

					} else if (activeStates.contains(State.State8)) {
						activeStates.remove(State.State8);
						defaultInterface
								.setVarS2(defaultInterface.getVarS2() - (1));

					}
					defaultInterface
							.setVarS2(defaultInterface.getVarS2() - (1));

					defaultInterface
							.setVarS2(defaultInterface.getVarS2() + (1));

					activeStates.add(State.State5);

				} else {
					if (occuredEvents.contains(defaultInterface
							.getEventEvent5())) {
						activeStates.remove(State.State8);
						defaultInterface
								.setVarS2(defaultInterface.getVarS2() - (1));

						defaultInterface
								.setVarS2(defaultInterface.getVarS2() + (1));

						activeStates.add(State.State7);

					} else {
						if (occuredEvents.contains(defaultInterface
								.getEventEvent13())) {
							activeStates.remove(State.State8);
							defaultInterface.setVarS2(defaultInterface
									.getVarS2() - (1));

							defaultInterface.setVarS2(defaultInterface
									.getVarS2() - (1));

							defaultInterface.setVarS2(defaultInterface
									.getVarS2() - (1));

							defaultInterface.setVarS2(defaultInterface
									.getVarS2() - (1));

							defaultInterface.setVarS1(1);

							defaultInterface.setVarS1(defaultInterface
									.getVarS1() + (1));

							activeStates.add(State.State9);

						} else {
							if (occuredEvents.contains(defaultInterface
									.getEventEvent16())) {
								activeStates.remove(State.State8);
								defaultInterface.setVarS2(defaultInterface
										.getVarS2() - (1));

								defaultInterface.setVarS2(defaultInterface
										.getVarS2() - (1));

								defaultInterface.setVarS2(defaultInterface
										.getVarS2() - (1));

								defaultInterface.setVarS2(defaultInterface
										.getVarS2() - (1));

								defaultInterface.setVarS1(1);

								defaultInterface.setVarS1(defaultInterface
										.getVarS1() + (1));

								activeStates.add(State.State10);

							}
						}
					}

				}

			}

		}
	}
	public void runCycle() {
		outEvents.clear();
		for (State state : activeStates) {
			switch (state) {
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
					// no state found
			}
		}
		occuredEvents.clear();
	}
}
