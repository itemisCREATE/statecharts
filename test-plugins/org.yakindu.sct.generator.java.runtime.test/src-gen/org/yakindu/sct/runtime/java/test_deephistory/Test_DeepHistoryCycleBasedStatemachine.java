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
		enterSequenceState1();
	}

	private boolean conditionState1Tr0() {
		return occuredEvents.contains(defaultInterface.getEventEvent1());
	}
	private boolean conditionState2Tr0() {
		return occuredEvents.contains(defaultInterface.getEventEvent2());
	}
	private boolean conditionState3Tr0() {
		return occuredEvents.contains(defaultInterface.getEventEvent3());
	}
	private boolean conditionState4Tr0() {
		return occuredEvents.contains(defaultInterface.getEventEvent4());
	}
	private boolean conditionState6Tr0() {
		return occuredEvents.contains(defaultInterface.getEventEvent5());
	}
	private boolean conditionState7Tr0() {
		return occuredEvents.contains(defaultInterface.getEventEvent6());
	}
	private boolean conditionState8Tr0() {
		return occuredEvents.contains(defaultInterface.getEventEvent7());
	}
	private boolean conditionState9Tr0() {
		return occuredEvents.contains(defaultInterface.getEventEvent8());
	}
	private void actionsState1Tr0() {
		exitSequenceState1();
		enterSequenceState2();

	}
	private void actionsState2Tr0() {
		exitSequenceState2();
		enterSequenceState1();

	}
	private void actionsState3Tr0() {
		exitSequenceState3();
		enterSequenceState4();

	}
	private void actionsState4Tr0() {
		exitSequenceState4();
		enterSequenceState5();

	}
	private void actionsState6Tr0() {
		exitSequenceState6();
		enterSequenceState7();

	}
	private void actionsState7Tr0() {
		exitSequenceState7();
		enterSequenceState6();

	}
	private void actionsState8Tr0() {
		exitSequenceState8();
		enterSequenceState9();

	}
	private void actionsState9Tr0() {
		exitSequenceState9();
		enterSequenceState8();

	}

	private void enterSequenceState1() {
		activeStates.add(State.State1);
	}

	private void enterSequenceState2() {
		enterSequenceState3();
	}

	private void enterSequenceState3() {
		activeStates.add(State.State3);
	}

	private void enterSequenceState4() {
		enterSequenceState6();
	}

	private void enterSequenceState6() {
		activeStates.add(State.State6);
	}

	private void enterSequenceState7() {
		enterSequenceState8();
	}

	private void enterSequenceState8() {
		activeStates.add(State.State8);
	}

	private void enterSequenceState9() {
		activeStates.add(State.State9);
	}

	private void enterSequenceState5() {
		activeStates.add(State.State5);
	}
	private void exitSequenceState1() {
		activeStates.remove(State.State1);
	}
	private void exitSequenceState2() {
		if (activeStates.contains(State.State3)) {
			exitSequenceState3();

		} else if (activeStates.contains(State.State6)) {
			exitSequenceState6();

		} else if (activeStates.contains(State.State8)) {
			exitSequenceState8();

		} else if (activeStates.contains(State.State9)) {
			exitSequenceState9();

		} else if (activeStates.contains(State.State5)) {
			exitSequenceState5();

		}
	}
	private void exitSequenceState3() {
		activeStates.remove(State.State3);
	}
	private void exitSequenceState4() {
		if (activeStates.contains(State.State6)) {
			exitSequenceState6();

		} else if (activeStates.contains(State.State8)) {
			exitSequenceState8();

		} else if (activeStates.contains(State.State9)) {
			exitSequenceState9();

		}
	}
	private void exitSequenceState6() {
		activeStates.remove(State.State6);
	}
	private void exitSequenceState7() {
		if (activeStates.contains(State.State8)) {
			exitSequenceState8();

		} else if (activeStates.contains(State.State9)) {
			exitSequenceState9();

		}
	}
	private void exitSequenceState8() {
		activeStates.remove(State.State8);
	}
	private void exitSequenceState9() {
		activeStates.remove(State.State9);
	}
	private void exitSequenceState5() {
		activeStates.remove(State.State5);
	}
	private void reactState1() {
		if (conditionState1Tr0()) {
			actionsState1Tr0();
		}
	}
	private void reactState2() {
	}
	private void reactState3() {
		if (conditionState2Tr0()) {
			actionsState2Tr0();
		} else {
			if (conditionState3Tr0()) {
				actionsState3Tr0();
			}

		}
	}
	private void reactState4() {
	}
	private void reactState6() {
		if (conditionState2Tr0()) {
			actionsState2Tr0();
		} else {
			if (conditionState4Tr0()) {
				actionsState4Tr0();
			} else {
				if (conditionState6Tr0()) {
					actionsState6Tr0();
				}

			}

		}
	}
	private void reactState7() {
	}
	private void reactState8() {
		if (conditionState2Tr0()) {
			actionsState2Tr0();
		} else {
			if (conditionState4Tr0()) {
				actionsState4Tr0();
			} else {
				if (conditionState7Tr0()) {
					actionsState7Tr0();
				} else {
					if (conditionState8Tr0()) {
						actionsState8Tr0();
					}

				}

			}

		}
	}
	private void reactState9() {
		if (conditionState2Tr0()) {
			actionsState2Tr0();
		} else {
			if (conditionState4Tr0()) {
				actionsState4Tr0();
			} else {
				if (conditionState7Tr0()) {
					actionsState7Tr0();
				} else {
					if (conditionState9Tr0()) {
						actionsState9Tr0();
					}

				}

			}

		}
	}
	private void reactState5() {
		if (conditionState2Tr0()) {
			actionsState2Tr0();
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
