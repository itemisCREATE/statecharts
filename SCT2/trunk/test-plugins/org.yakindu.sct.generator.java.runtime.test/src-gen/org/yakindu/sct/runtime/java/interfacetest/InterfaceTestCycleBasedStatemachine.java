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
package org.yakindu.sct.runtime.java.interfacetest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import org.yakindu.sct.runtime.java.Event;
import org.yakindu.sct.runtime.java.IStatemachine;

public class InterfaceTestCycleBasedStatemachine implements IStatemachine {

	public enum State {
		State1, State2, State3, State4,
	};

	private DefaultInterfaceImpl defaultInterface;
	private InterfaceOtherImpl interfaceOther;
	private InterfaceThirdImpl interfaceThird;

	private final Set<State> activeStates = EnumSet.noneOf(State.class);

	private final ArrayList<Event> occuredEvents;

	private final Collection<Event> outEvents;

	public InterfaceTestCycleBasedStatemachine() {
		occuredEvents = new ArrayList<Event>();
		outEvents = new HashSet<Event>();
		defaultInterface = new DefaultInterfaceImpl(this);
		interfaceOther = new InterfaceOtherImpl(this);
		interfaceThird = new InterfaceThirdImpl(this);
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

	public InterfaceOther getInterfaceOther() {
		return interfaceOther;
	}

	public InterfaceThird getInterfaceThird() {
		return interfaceThird;
	}

	public void enter() {
		enterSequenceState1();
	}

	private boolean conditionState1Tr0() {
		return (occuredEvents.contains(defaultInterface.getEventEvent1()) && (defaultInterface
				.getVarVar2() > 0));
	}
	private boolean conditionState1Tr1() {
		return (occuredEvents.contains(interfaceOther.getEventEvent3()) && (defaultInterface
				.getVarVar3() == 1));
	}
	private boolean conditionState1Tr2() {
		return (occuredEvents.contains(interfaceThird.getEventEvent5()) && (defaultInterface
				.getVarVar1() == true));
	}
	private boolean conditionState2Tr0() {
		return occuredEvents.contains(defaultInterface.getEventEvent1());
	}
	private boolean conditionState3Tr0() {
		return occuredEvents.contains(interfaceOther.getEventEvent3());
	}
	private boolean conditionState4Tr0() {
		return occuredEvents.contains(interfaceThird.getEventEvent5());
	}
	private void actionsState1Tr0() {
		exitSequenceState1();
		enterSequenceState2();

	}
	private void actionsState1Tr1() {
		exitSequenceState1();
		enterSequenceState3();

	}
	private void actionsState1Tr2() {
		exitSequenceState1();
		enterSequenceState4();

	}
	private void actionsState2Tr0() {
		exitSequenceState2();
		enterSequenceState1();

	}
	private void actionsState3Tr0() {
		exitSequenceState3();
		enterSequenceState1();

	}
	private void actionsState4Tr0() {
		exitSequenceState4();
		enterSequenceState1();

	}
	private void entryActionState2() {
		defaultInterface.raiseEvent2(22);

	}
	private void entryActionState3() {
		interfaceOther.raiseEvent4();

	}
	private void entryActionState4() {
		interfaceThird.raiseEvent6(true);

	}

	private void enterSequenceState1() {
		activeStates.add(State.State1);
	}

	private void enterSequenceState2() {
		entryActionState2();
		activeStates.add(State.State2);
	}

	private void enterSequenceState3() {
		entryActionState3();
		activeStates.add(State.State3);
	}

	private void enterSequenceState4() {
		entryActionState4();
		activeStates.add(State.State4);
	}
	private void exitSequenceState1() {
		activeStates.remove(State.State1);
	}
	private void exitSequenceState2() {
		activeStates.remove(State.State2);
	}
	private void exitSequenceState3() {
		activeStates.remove(State.State3);
	}
	private void exitSequenceState4() {
		activeStates.remove(State.State4);
	}
	private void reactState1() {
		if (conditionState1Tr0()) {
			actionsState1Tr0();
		} else {
			if (conditionState1Tr1()) {
				actionsState1Tr1();
			} else {
				if (conditionState1Tr2()) {
					actionsState1Tr2();
				}
			}
		}
	}
	private void reactState2() {
		if (conditionState2Tr0()) {
			actionsState2Tr0();
		}
	}
	private void reactState3() {
		if (conditionState3Tr0()) {
			actionsState3Tr0();
		}
	}
	private void reactState4() {
		if (conditionState4Tr0()) {
			actionsState4Tr0();
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
				default :
					// no state found
			}
		}
		occuredEvents.clear();
	}
}
