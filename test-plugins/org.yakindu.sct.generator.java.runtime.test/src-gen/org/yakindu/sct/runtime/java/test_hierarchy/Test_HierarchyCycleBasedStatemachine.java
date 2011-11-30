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

	private InterfaceDefaultImpl interfaceDefault;

	private final Set<State> activeStates = EnumSet.noneOf(State.class);

	private final ArrayList<Event> occuredEvents;

	private final Collection<Event> outEvents;

	public Test_HierarchyCycleBasedStatemachine() {
		occuredEvents = new ArrayList<Event>();
		outEvents = new HashSet<Event>();
		interfaceDefault = new InterfaceDefaultImpl(this);
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

	public InterfaceDefault getInterfaceDefault() {
		return interfaceDefault;
	}

	public void enterSequenceStatechartTest_Hierarchy() {
		enterSequenceState1();
	}

	private boolean conditionState1Tr0() {
		return occuredEvents.contains(interfaceDefault.getEventEvent1());
	}
	private boolean conditionState9Tr0() {
		return occuredEvents.contains(interfaceDefault.getEventEvent9());
	}
	private boolean conditionState10Tr0() {
		return occuredEvents.contains(interfaceDefault.getEventEvent10());
	}
	private boolean conditionState2Tr0() {
		return occuredEvents.contains(interfaceDefault.getEventEvent6());
	}
	private boolean conditionState3Tr0() {
		return occuredEvents.contains(interfaceDefault.getEventEvent2());
	}
	private boolean conditionState3Tr1() {
		return occuredEvents.contains(interfaceDefault.getEventEvent11());
	}
	private boolean conditionState3Tr2() {
		return occuredEvents.contains(interfaceDefault.getEventEvent14());
	}
	private boolean conditionState4Tr0() {
		return occuredEvents.contains(interfaceDefault.getEventEvent7());
	}
	private boolean conditionState5Tr0() {
		return occuredEvents.contains(interfaceDefault.getEventEvent3());
	}
	private boolean conditionState5Tr1() {
		return occuredEvents.contains(interfaceDefault.getEventEvent12());
	}
	private boolean conditionState5Tr2() {
		return occuredEvents.contains(interfaceDefault.getEventEvent15());
	}
	private boolean conditionState6Tr0() {
		return occuredEvents.contains(interfaceDefault.getEventEvent8());
	}
	private boolean conditionState7Tr0() {
		return occuredEvents.contains(interfaceDefault.getEventEvent4());
	}
	private boolean conditionState8Tr0() {
		return occuredEvents.contains(interfaceDefault.getEventEvent5());
	}
	private boolean conditionState8Tr1() {
		return occuredEvents.contains(interfaceDefault.getEventEvent13());
	}
	private boolean conditionState8Tr2() {
		return occuredEvents.contains(interfaceDefault.getEventEvent16());
	}
	private void actionsState1Tr0() {
		exitSequenceState1();
		enterSequenceState2();

	}
	private void actionsState9Tr0() {
		exitSequenceState9();
		enterSequenceState10();

	}
	private void actionsState10Tr0() {
		exitSequenceState10();
		enterSequenceState9();

	}
	private void actionsState2Tr0() {
		exitSequenceState2();
		enterSequenceState1();

	}
	private void actionsState3Tr0() {
		exitSequenceState3();
		enterSequenceState4();

	}
	private void actionsState3Tr1() {
		exitSequenceState3();
		exitActionState2();
		enterSequenceState1();

	}
	private void actionsState3Tr2() {
		exitSequenceState3();
		exitActionState2();
		entryActionState1();
		enterSequenceState9();

	}
	private void actionsState4Tr0() {
		exitSequenceState4();
		enterSequenceState3();

	}
	private void actionsState5Tr0() {
		exitSequenceState5();
		enterSequenceState6();

	}
	private void actionsState5Tr1() {
		exitSequenceState5();
		exitActionState4();
		exitActionState2();
		enterSequenceState1();

	}
	private void actionsState5Tr2() {
		exitSequenceState5();
		exitActionState4();
		exitActionState2();
		entryActionState1();
		enterSequenceState10();

	}
	private void actionsState6Tr0() {
		exitSequenceState6();
		enterSequenceState5();

	}
	private void actionsState7Tr0() {
		exitSequenceState7();
		enterSequenceState8();

	}
	private void actionsState8Tr0() {
		exitSequenceState8();
		enterSequenceState7();

	}
	private void actionsState8Tr1() {
		exitSequenceState8();
		exitActionState6();
		exitActionState4();
		exitActionState2();
		enterSequenceState1();

	}
	private void actionsState8Tr2() {
		exitSequenceState8();
		exitActionState6();
		exitActionState4();
		exitActionState2();
		entryActionState1();
		enterSequenceState10();

	}
	private void entryActionState1() {
		interfaceDefault.setVarS1(1);

	}
	private void entryActionState9() {
		interfaceDefault.setVarS1(interfaceDefault.getVarS1() + (1));

	}
	private void entryActionState10() {
		interfaceDefault.setVarS1(interfaceDefault.getVarS1() + (1));

	}
	private void entryActionState2() {
		interfaceDefault.setVarS2(1);

	}
	private void entryActionState3() {
		interfaceDefault.setVarS2(interfaceDefault.getVarS2() + (1));

	}
	private void entryActionState4() {
		interfaceDefault.setVarS2(interfaceDefault.getVarS2() + (1));

	}
	private void entryActionState5() {
		interfaceDefault.setVarS2(interfaceDefault.getVarS2() + (1));

	}
	private void entryActionState6() {
		interfaceDefault.setVarS2(interfaceDefault.getVarS2() + (1));

	}
	private void entryActionState7() {
		interfaceDefault.setVarS2(interfaceDefault.getVarS2() + (1));

	}
	private void entryActionState8() {
		interfaceDefault.setVarS2(interfaceDefault.getVarS2() + (1));

	}
	private void exitActionState1() {
		interfaceDefault.setVarS1(interfaceDefault.getVarS1() - (1));

	}
	private void exitActionState9() {
		interfaceDefault.setVarS1(interfaceDefault.getVarS1() - (1));

	}
	private void exitActionState10() {
		interfaceDefault.setVarS1(interfaceDefault.getVarS1() - (1));

	}
	private void exitActionState2() {
		interfaceDefault.setVarS2(interfaceDefault.getVarS2() - (1));

	}
	private void exitActionState3() {
		interfaceDefault.setVarS2(interfaceDefault.getVarS2() - (1));

	}
	private void exitActionState4() {
		interfaceDefault.setVarS2(interfaceDefault.getVarS2() - (1));

	}
	private void exitActionState5() {
		interfaceDefault.setVarS2(interfaceDefault.getVarS2() - (1));

	}
	private void exitActionState6() {
		interfaceDefault.setVarS2(interfaceDefault.getVarS2() - (1));

	}
	private void exitActionState7() {
		interfaceDefault.setVarS2(interfaceDefault.getVarS2() - (1));

	}
	private void exitActionState8() {
		interfaceDefault.setVarS2(interfaceDefault.getVarS2() - (1));

	}

	private void enterSequenceState1() {
		entryActionState1();
		enterSequenceState9();
	}

	private void enterSequenceState9() {
		entryActionState9();
		activeStates.add(State.State9);
	}

	private void enterSequenceState10() {
		entryActionState10();
		activeStates.add(State.State10);
	}

	private void enterSequenceState2() {
		entryActionState2();
		enterSequenceState3();
	}

	private void enterSequenceState3() {
		entryActionState3();
		activeStates.add(State.State3);
	}

	private void enterSequenceState4() {
		entryActionState4();
		enterSequenceState5();
	}

	private void enterSequenceState5() {
		entryActionState5();
		activeStates.add(State.State5);
	}

	private void enterSequenceState6() {
		entryActionState6();
		enterSequenceState7();
	}

	private void enterSequenceState7() {
		entryActionState7();
		activeStates.add(State.State7);
	}

	private void enterSequenceState8() {
		entryActionState8();
		activeStates.add(State.State8);
	}
	private void exitSequenceState1() {
		if (activeStates.contains(State.State9)) {
			exitSequenceState9();

		} else if (activeStates.contains(State.State10)) {
			exitSequenceState10();

		}
		exitActionState1();
	}
	private void exitSequenceState9() {
		activeStates.remove(State.State9);
		exitActionState9();
	}
	private void exitSequenceState10() {
		activeStates.remove(State.State10);
		exitActionState10();
	}
	private void exitSequenceState2() {
		if (activeStates.contains(State.State3)) {
			exitSequenceState3();

		} else if (activeStates.contains(State.State5)) {
			exitSequenceState5();
			exitActionState4();

		} else if (activeStates.contains(State.State7)) {
			exitSequenceState7();
			exitActionState6();
			exitActionState4();

		} else if (activeStates.contains(State.State8)) {
			exitSequenceState8();
			exitActionState6();
			exitActionState4();

		}
		exitActionState2();
	}
	private void exitSequenceState3() {
		activeStates.remove(State.State3);
		exitActionState3();
	}
	private void exitSequenceState4() {
		if (activeStates.contains(State.State5)) {
			exitSequenceState5();

		} else if (activeStates.contains(State.State7)) {
			exitSequenceState7();
			exitActionState6();

		} else if (activeStates.contains(State.State8)) {
			exitSequenceState8();
			exitActionState6();

		}
		exitActionState4();
	}
	private void exitSequenceState5() {
		activeStates.remove(State.State5);
		exitActionState5();
	}
	private void exitSequenceState6() {
		if (activeStates.contains(State.State7)) {
			exitSequenceState7();

		} else if (activeStates.contains(State.State8)) {
			exitSequenceState8();

		}
		exitActionState6();
	}
	private void exitSequenceState7() {
		activeStates.remove(State.State7);
		exitActionState7();
	}
	private void exitSequenceState8() {
		activeStates.remove(State.State8);
		exitActionState8();
	}
	private void reactState1() {
	}
	private void reactState9() {
		if (conditionState1Tr0()) {
			actionsState1Tr0();
		} else {
			if (conditionState9Tr0()) {
				actionsState9Tr0();
			}

		}
	}
	private void reactState10() {
		if (conditionState1Tr0()) {
			actionsState1Tr0();
		} else {
			if (conditionState10Tr0()) {
				actionsState10Tr0();
			}

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
			} else {
				if (conditionState3Tr1()) {
					actionsState3Tr1();
				} else {
					if (conditionState3Tr2()) {
						actionsState3Tr2();
					}
				}
			}

		}
	}
	private void reactState4() {
	}
	private void reactState5() {
		if (conditionState2Tr0()) {
			actionsState2Tr0();
		} else {
			if (conditionState4Tr0()) {
				actionsState4Tr0();
			} else {
				if (conditionState5Tr0()) {
					actionsState5Tr0();
				} else {
					if (conditionState5Tr1()) {
						actionsState5Tr1();
					} else {
						if (conditionState5Tr2()) {
							actionsState5Tr2();
						}
					}
				}

			}

		}
	}
	private void reactState6() {
	}
	private void reactState7() {
		if (conditionState2Tr0()) {
			actionsState2Tr0();
		} else {
			if (conditionState4Tr0()) {
				actionsState4Tr0();
			} else {
				if (conditionState6Tr0()) {
					actionsState6Tr0();
				} else {
					if (conditionState7Tr0()) {
						actionsState7Tr0();
					}

				}

			}

		}
	}
	private void reactState8() {
		if (conditionState2Tr0()) {
			actionsState2Tr0();
		} else {
			if (conditionState4Tr0()) {
				actionsState4Tr0();
			} else {
				if (conditionState6Tr0()) {
					actionsState6Tr0();
				} else {
					if (conditionState8Tr0()) {
						actionsState8Tr0();
					} else {
						if (conditionState8Tr1()) {
							actionsState8Tr1();
						} else {
							if (conditionState8Tr2()) {
								actionsState8Tr2();
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
