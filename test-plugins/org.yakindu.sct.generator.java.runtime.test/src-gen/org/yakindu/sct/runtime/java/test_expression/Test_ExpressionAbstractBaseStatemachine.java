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

import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import org.yakindu.sct.runtime.java.Event;
import org.yakindu.sct.runtime.java.IStatemachine;

public abstract class Test_ExpressionAbstractBaseStatemachine
		implements
			IStatemachine {

	public enum State {
		State1, State2,
	};

	private InterfaceDefaultImpl interfaceDefault;
	private InterfaceOtherImpl interfaceOther;

	private final Set<State> activeStates = EnumSet.noneOf(State.class);

	private final Collection<Event> occuredEvents;

	private final Collection<Event> outEvents;

	public Test_ExpressionAbstractBaseStatemachine(
			Collection<Event> occuredEvents) {
		this.occuredEvents = occuredEvents;
		this.outEvents = new HashSet<Event>();
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
		return !getOccuredEvents().isEmpty();
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

	private boolean conditionState1Tr0(Collection<?> events) {
		return (getOccuredEvents().contains(interfaceDefault.getEventEvent1()) && ((interfaceOther
				.getVarVar1() == true) || (interfaceDefault.getVarVar5() == false)));
	}
	private boolean conditionState2Tr0(Collection<?> events) {
		return (getOccuredEvents().contains(interfaceDefault.getEventEvent1()) && (interfaceDefault
				.getVarVar3() > 0));
	}
	private boolean conditionState2Lr2(Collection<?> events) {
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
	private void cycleState1(Collection<?> events) {
		if (conditionState1Tr0(events)) {
			actionsState1Tr0();
		}
	}
	private void cycleState2(Collection<?> events) {
		if (conditionState2Tr0(events)) {
			actionsState2Tr0();
		} else {
			if (conditionState2Lr2(events)) {
				actionsState2Lr2();
			}

		}
	}
	protected void runCycle(Collection<?> events) {
		getOutEvents().clear();
		for (State state : activeStates) {
			switch (state) {
				case State1 :
					cycleState1(events);
					break;
				case State2 :
					cycleState2(events);
					break;
				default :
					// no state found
			}
		}
	}
}
