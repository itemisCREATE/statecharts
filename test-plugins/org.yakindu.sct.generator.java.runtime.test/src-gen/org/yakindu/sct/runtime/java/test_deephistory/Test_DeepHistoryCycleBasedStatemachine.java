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
package org.yakindu.sct.runtime.java.test_deephistory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import org.yakindu.sct.runtime.java.Event;
import org.yakindu.sct.runtime.java.IStatemachine;

public class Test_DeepHistoryCycleBasedStatemachine implements IStatemachine {

	public enum State {
		State1, State2, State3, State4, State6, State7, State8, State9, State5,
	};

	private DefaultInterfaceImpl defaultInterface;

	private final Set<State> activeStates = EnumSet.noneOf(State.class);

	private final ArrayList<Event> occuredEvents;

	private final Collection<Event> outEvents;

	public Test_DeepHistoryCycleBasedStatemachine() {
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
		activeStates.add(State.State1);

	}

	private void reactState1() {
		if (occuredEvents.contains(defaultInterface.getEventEvent1())) {
			activeStates.remove(State.State1);

			activeStates.add(State.State3);

		}
	}
	private void reactState2() {
	}
	private void reactState3() {
		if (occuredEvents.contains(defaultInterface.getEventEvent2())) {
			if (activeStates.contains(State.State3)) {
				activeStates.remove(State.State3);

			} else if (activeStates.contains(State.State6)) {
				activeStates.remove(State.State6);

			} else if (activeStates.contains(State.State8)) {
				activeStates.remove(State.State8);

			} else if (activeStates.contains(State.State9)) {
				activeStates.remove(State.State9);

			} else if (activeStates.contains(State.State5)) {
				activeStates.remove(State.State5);

			}

			activeStates.add(State.State1);

		} else {
			if (occuredEvents.contains(defaultInterface.getEventEvent3())) {
				activeStates.remove(State.State3);

				activeStates.add(State.State6);

			}

		}
	}
	private void reactState4() {
	}
	private void reactState6() {
		if (occuredEvents.contains(defaultInterface.getEventEvent2())) {
			if (activeStates.contains(State.State3)) {
				activeStates.remove(State.State3);

			} else if (activeStates.contains(State.State6)) {
				activeStates.remove(State.State6);

			} else if (activeStates.contains(State.State8)) {
				activeStates.remove(State.State8);

			} else if (activeStates.contains(State.State9)) {
				activeStates.remove(State.State9);

			} else if (activeStates.contains(State.State5)) {
				activeStates.remove(State.State5);

			}

			activeStates.add(State.State1);

		} else {
			if (occuredEvents.contains(defaultInterface.getEventEvent4())) {
				if (activeStates.contains(State.State6)) {
					activeStates.remove(State.State6);

				} else if (activeStates.contains(State.State8)) {
					activeStates.remove(State.State8);

				} else if (activeStates.contains(State.State9)) {
					activeStates.remove(State.State9);

				}

				activeStates.add(State.State5);

			} else {
				if (occuredEvents.contains(defaultInterface.getEventEvent5())) {
					activeStates.remove(State.State6);

					activeStates.add(State.State8);

				}

			}

		}
	}
	private void reactState7() {
	}
	private void reactState8() {
		if (occuredEvents.contains(defaultInterface.getEventEvent2())) {
			if (activeStates.contains(State.State3)) {
				activeStates.remove(State.State3);

			} else if (activeStates.contains(State.State6)) {
				activeStates.remove(State.State6);

			} else if (activeStates.contains(State.State8)) {
				activeStates.remove(State.State8);

			} else if (activeStates.contains(State.State9)) {
				activeStates.remove(State.State9);

			} else if (activeStates.contains(State.State5)) {
				activeStates.remove(State.State5);

			}

			activeStates.add(State.State1);

		} else {
			if (occuredEvents.contains(defaultInterface.getEventEvent4())) {
				if (activeStates.contains(State.State6)) {
					activeStates.remove(State.State6);

				} else if (activeStates.contains(State.State8)) {
					activeStates.remove(State.State8);

				} else if (activeStates.contains(State.State9)) {
					activeStates.remove(State.State9);

				}

				activeStates.add(State.State5);

			} else {
				if (occuredEvents.contains(defaultInterface.getEventEvent6())) {
					if (activeStates.contains(State.State8)) {
						activeStates.remove(State.State8);

					} else if (activeStates.contains(State.State9)) {
						activeStates.remove(State.State9);

					}

					activeStates.add(State.State6);

				} else {
					if (occuredEvents.contains(defaultInterface
							.getEventEvent7())) {
						activeStates.remove(State.State8);

						activeStates.add(State.State9);

					}

				}

			}

		}
	}
	private void reactState9() {
		if (occuredEvents.contains(defaultInterface.getEventEvent2())) {
			if (activeStates.contains(State.State3)) {
				activeStates.remove(State.State3);

			} else if (activeStates.contains(State.State6)) {
				activeStates.remove(State.State6);

			} else if (activeStates.contains(State.State8)) {
				activeStates.remove(State.State8);

			} else if (activeStates.contains(State.State9)) {
				activeStates.remove(State.State9);

			} else if (activeStates.contains(State.State5)) {
				activeStates.remove(State.State5);

			}

			activeStates.add(State.State1);

		} else {
			if (occuredEvents.contains(defaultInterface.getEventEvent4())) {
				if (activeStates.contains(State.State6)) {
					activeStates.remove(State.State6);

				} else if (activeStates.contains(State.State8)) {
					activeStates.remove(State.State8);

				} else if (activeStates.contains(State.State9)) {
					activeStates.remove(State.State9);

				}

				activeStates.add(State.State5);

			} else {
				if (occuredEvents.contains(defaultInterface.getEventEvent6())) {
					if (activeStates.contains(State.State8)) {
						activeStates.remove(State.State8);

					} else if (activeStates.contains(State.State9)) {
						activeStates.remove(State.State9);

					}

					activeStates.add(State.State6);

				} else {
					if (occuredEvents.contains(defaultInterface
							.getEventEvent8())) {
						activeStates.remove(State.State9);

						activeStates.add(State.State8);

					}

				}

			}

		}
	}
	private void reactState5() {
		if (occuredEvents.contains(defaultInterface.getEventEvent2())) {
			if (activeStates.contains(State.State3)) {
				activeStates.remove(State.State3);

			} else if (activeStates.contains(State.State6)) {
				activeStates.remove(State.State6);

			} else if (activeStates.contains(State.State8)) {
				activeStates.remove(State.State8);

			} else if (activeStates.contains(State.State9)) {
				activeStates.remove(State.State9);

			} else if (activeStates.contains(State.State5)) {
				activeStates.remove(State.State5);

			}

			activeStates.add(State.State1);

		} else {

		}
	}
	public void runCycle() {
		outEvents.clear();
		for (State state : activeStates) {
			switch (state) {
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
					// no state found
			}
		}
		occuredEvents.clear();
	}
}
