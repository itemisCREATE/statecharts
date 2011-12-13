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

	private DefaultInterfaceImpl defaultInterface;
	private InterfaceOtherImpl interfaceOther;

	private final Set<State> activeStates = EnumSet.noneOf(State.class);

	private final ArrayList<Event<? extends Enum<?>>> occuredEvents;

	private final Collection<Event<? extends Enum<?>>> outEvents;

	public Test_ExpressionCycleBasedStatemachine() {
		occuredEvents = new ArrayList<Event<? extends Enum<?>>>();
		outEvents = new HashSet<Event<? extends Enum<?>>>();
		defaultInterface = new DefaultInterfaceImpl(this);
		interfaceOther = new InterfaceOtherImpl();

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

	public Set<State> getActiveStates() {
		return EnumSet.copyOf(activeStates);
	}

	public DefaultInterface getDefaultInterface() {
		return defaultInterface;
	}

	public InterfaceOther getInterfaceOther() {
		return interfaceOther;
	}

	public void enter() {
		defaultInterface.setVarVar3(defaultInterface.getVarVar3()
				+ ((defaultInterface.getVarVar2() * defaultInterface
						.getVarVar3())));

		activeStates.add(State.State1);

	}

	private void reactState1() {
		if ((occuredEvents.contains(defaultInterface.getEventEvent1()) && ((interfaceOther
				.getVarVar1() == true) || (defaultInterface.getVarVar5() == false)))) {
			activeStates.remove(State.State1);
			defaultInterface.setVarVar2(1);

			defaultInterface.setVarVar4(22.3);

			interfaceOther.setVarVar1(false);

			defaultInterface.setVarVar3(defaultInterface.getVarVar3() / (5));

			defaultInterface.setVarVar1(defaultInterface.getVarVar1() + (1));

			activeStates.add(State.State2);

		}
	}
	private void reactState2() {
		if ((occuredEvents.contains(defaultInterface.getEventEvent1()) && (defaultInterface
				.getVarVar3() > 0))) {
			activeStates.remove(State.State2);

			defaultInterface.setVarVar5(true);

			defaultInterface.setVarVar3(defaultInterface.getVarVar3()
					+ ((defaultInterface.getVarVar2() * defaultInterface
							.getVarVar3())));

			activeStates.add(State.State1);

		} else {
			if (true) {
				defaultInterface
						.setVarVar1(defaultInterface.getVarVar1() + (1));

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
