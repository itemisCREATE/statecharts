/**
Copyright (c) 2011 committers of YAKINDU and others. 
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html
 
Contributors:
	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.runtime.java.test_parallelregions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import org.yakindu.sct.runtime.java.Event;
import org.yakindu.sct.runtime.java.IStatemachine;

public class Test_ParallelRegionsCycleBasedStatemachine
		implements
			IStatemachine {

	public enum State {
		State1, State2, State3, State4, State5, State6, State9, State7, State8,
	};

	private DefaultInterfaceImpl defaultInterface;

	private final State[] stateVector = new State[3];

	private int nextStateIndex;

	private final ArrayList<Event<? extends Enum<?>>> occuredEvents;

	private final Collection<Event<? extends Enum<?>>> outEvents;

	public Test_ParallelRegionsCycleBasedStatemachine() {
		occuredEvents = new ArrayList<Event<? extends Enum<?>>>();
		outEvents = new HashSet<Event<? extends Enum<?>>>();
		defaultInterface = new DefaultInterfaceImpl(this);

	}

	protected Collection<Event<? extends Enum<?>>> getOccuredEvents() {
		return occuredEvents;
	}

	protected Collection<Event<? extends Enum<?>>> getOutEvents() {
		return outEvents;
	}

	protected boolean eventOccured() {
		return !occuredEvents.isEmpty();
	}

	public void init() {

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

	public void enter() {

		enterSequenceState1();
	}

	private boolean conditionState1Tr0() {
		return occuredEvents.contains(defaultInterface.getEventEvent1());
	}
	private boolean conditionState3Tr0() {
		return occuredEvents.contains(defaultInterface.getEventEvent2());
	}
	private boolean conditionState5Tr0() {
		return occuredEvents.contains(defaultInterface.getEventEvent3());
	}
	private boolean conditionState6Tr0() {
		return occuredEvents.contains(defaultInterface.getEventEvent4());
	}
	private boolean conditionState7Tr0() {
		return (occuredEvents.contains(defaultInterface.getEventEvent5()) || occuredEvents
				.contains(defaultInterface.getEventEvent3()));
	}
	private boolean conditionState8Tr0() {
		return occuredEvents.contains(defaultInterface.getEventEvent6());
	}
	private void actionsState1Tr0() {

		exitSequenceState1();

		enterSequenceState2();

	}
	private void actionsState3Tr0() {

		exitSequenceState3();

		enterSequenceState4();

	}
	private void actionsState5Tr0() {

		exitSequenceState5();

		enterSequenceState6();

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
	private void entryActionState2() {
		defaultInterface.setVarBla(true);

	}

	private void enterSequenceState1() {
		nextStateIndex = 0;
		stateVector[0] = State.State1;

	}

	private void enterSequenceState2() {

		entryActionState2();

		enterSequenceState3();

		enterSequenceState7();
	}

	private void enterSequenceState3() {
		nextStateIndex = 0;
		stateVector[0] = State.State3;

	}

	private void enterSequenceState4() {

		enterSequenceState5();

		enterSequenceState9();
	}

	private void enterSequenceState5() {
		nextStateIndex = 0;
		stateVector[0] = State.State5;

	}

	private void enterSequenceState6() {
		nextStateIndex = 0;
		stateVector[0] = State.State6;

	}

	private void enterSequenceState9() {
		nextStateIndex = 1;
		stateVector[1] = State.State9;

	}

	private void enterSequenceState7() {
		nextStateIndex = 2;
		stateVector[2] = State.State7;

	}

	private void enterSequenceState8() {
		nextStateIndex = 2;
		stateVector[2] = State.State8;

	}
	private void exitSequenceState1() {
		stateVector[0] = null;

	}
	private void exitSequenceState3() {
		stateVector[0] = null;

	}
	private void exitSequenceState5() {
		stateVector[0] = null;

	}
	private void exitSequenceState6() {
		stateVector[0] = null;

	}
	private void exitSequenceState9() {
		stateVector[1] = null;

	}
	private void exitSequenceState7() {
		stateVector[2] = null;

	}
	private void exitSequenceState8() {
		stateVector[2] = null;

	}
	private void reactState1() {
		if (conditionState1Tr0()) {

			actionsState1Tr0();
		}
	}
	private void reactState2() {
	}
	private void reactState3() {
		if (conditionState3Tr0()) {

			actionsState3Tr0();
		}

	}
	private void reactState4() {
	}
	private void reactState5() {
		if (conditionState5Tr0()) {

			actionsState5Tr0();
		}

	}
	private void reactState6() {
		if (conditionState6Tr0()) {

			actionsState6Tr0();
		}

	}
	private void reactState9() {

	}
	private void reactState7() {
		if (conditionState7Tr0()) {

			actionsState7Tr0();
		}

	}
	private void reactState8() {
		if (conditionState8Tr0()) {

			actionsState8Tr0();
		}

	}
	public void runCycle() {
		outEvents.clear();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
			if (stateVector[nextStateIndex] != null) {
				switch (stateVector[nextStateIndex]) {
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
					case State5 :
						reactState5();
						break;
					case State6 :
						reactState6();
						break;
					case State9 :
						reactState9();
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
		}
		occuredEvents.clear();
	}
}
