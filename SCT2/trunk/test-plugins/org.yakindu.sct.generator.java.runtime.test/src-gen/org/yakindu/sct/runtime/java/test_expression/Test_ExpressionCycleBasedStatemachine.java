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
package org.yakindu.sct.runtime.java.test_expression;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import org.yakindu.sct.runtime.java.Event;
import org.yakindu.sct.runtime.java.IStatemachine;

public class Test_ExpressionCycleBasedStatemachine implements IStatemachine {

	public enum State {
		State1, State2,
	};

	private InterfaceDefaultImpl interfaceDefault;
	private InterfaceOtherImpl interfaceOther;

	private final Set<State> activeStates = EnumSet.noneOf(State.class);

	private final ArrayList<Event> occuredEvents;

	private final Collection<Event> outEvents;

	public Test_ExpressionCycleBasedStatemachine() {
		occuredEvents = new ArrayList<Event>();
		outEvents = new HashSet<Event>();
		interfaceDefault = new InterfaceDefaultImpl(this);
		interfaceOther = new InterfaceOtherImpl(this);
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

	public InterfaceOther getInterfaceOther() {
		return interfaceOther;
	}

	public void enterSequenceStatechartTest_Expression() {
		enterSequenceState1();
	}

	private boolean conditionState1Tr0() {
		return (occuredEvents.contains(interfaceDefault.getEventEvent1()) && ((interfaceOther
				.getVarVar1() == true) || (interfaceDefault.getVarVar5() == false)));
	}
	private boolean conditionState2Tr0() {
		return (occuredEvents.contains(interfaceDefault.getEventEvent1()) && (interfaceDefault
				.getVarVar3() > 0));
	}
	private boolean conditionState2Lr2() {
		return true;
	}
	private void actionsState1Tr0() {
		exitSequenceState1();
		interfaceOther.setVarVar1(false);

		enterSequenceState2();

	}
	private void actionsState2Tr0() {
		exitSequenceState2();
		interfaceDefault.setVarVar5(true);

		enterSequenceState1();

	}
	private void actionsState2Lr2() {
		interfaceDefault.setVarVar1(interfaceDefault.getVarVar1() + (1));

	}
	private void entryActionState1() {
		interfaceDefault.setVarVar3(interfaceDefault.getVarVar3()
				+ ((interfaceDefault.getVarVar2() * interfaceDefault
						.getVarVar3())));

	}
	private void entryActionState2() {
		interfaceDefault.setVarVar3(interfaceDefault.getVarVar3() / (5));

		interfaceDefault.setVarVar1(interfaceDefault.getVarVar1() + (1));

	}
	private void exitActionState1() {
		interfaceDefault.setVarVar2(1);

		interfaceDefault.setVarVar4(22.3);

	}

	private void enterSequenceState1() {
		entryActionState1();
		activeStates.add(State.State1);
	}

	private void enterSequenceState2() {
		entryActionState2();
		activeStates.add(State.State2);
	}
	private void exitSequenceState1() {
		activeStates.remove(State.State1);
		exitActionState1();
	}
	private void exitSequenceState2() {
		activeStates.remove(State.State2);
	}
	private void reactState1() {
		if (conditionState1Tr0()) {
			actionsState1Tr0();
		}
	}
	private void reactState2() {
		if (conditionState2Tr0()) {
			actionsState2Tr0();
		} else {
			if (conditionState2Lr2()) {
				actionsState2Lr2();
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
				case State2 :
					reactState2();
					break;
				default :
					// no state found
			}
		}
		occuredEvents.clear();
	}
}
