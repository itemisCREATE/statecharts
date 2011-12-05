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

	private final ArrayList<Event<? extends Enum<?>>> occuredEvents;

	private final Collection<Event<? extends Enum<?>>> outEvents;

	public InterfaceTestCycleBasedStatemachine() {
		occuredEvents = new ArrayList<Event<? extends Enum<?>>>();
		outEvents = new HashSet<Event<? extends Enum<?>>>();
		defaultInterface = new DefaultInterfaceImpl(this);
		interfaceOther = new InterfaceOtherImpl(this);
		interfaceThird = new InterfaceThirdImpl(this);

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

	public InterfaceThird getInterfaceThird() {
		return interfaceThird;
	}

	public void enter() {
		activeStates.add(State.State1);

	}

	private void reactState1() {
		if ((occuredEvents.contains(defaultInterface.getEventEvent1()) && (defaultInterface
				.getVarVar2() > 0))) {
			activeStates.remove(State.State1);

			defaultInterface.raiseEvent2(22);

			activeStates.add(State.State2);

		} else {
			if ((occuredEvents.contains(interfaceOther.getEventEvent3()) && (defaultInterface
					.getVarVar3() == 1))) {
				activeStates.remove(State.State1);

				interfaceOther.raiseEvent4();

				activeStates.add(State.State3);

			} else {
				if ((occuredEvents.contains(interfaceThird.getEventEvent5()) && (defaultInterface
						.getVarVar1() == true))) {
					activeStates.remove(State.State1);

					interfaceThird.raiseEvent6(true);

					activeStates.add(State.State4);

				}
			}
		}
	}
	private void reactState2() {
		if (occuredEvents.contains(defaultInterface.getEventEvent1())) {
			activeStates.remove(State.State2);

			activeStates.add(State.State1);

		}
	}
	private void reactState3() {
		if (occuredEvents.contains(interfaceOther.getEventEvent3())) {
			activeStates.remove(State.State3);

			activeStates.add(State.State1);

		}
	}
	private void reactState4() {
		if (occuredEvents.contains(interfaceThird.getEventEvent5())) {
			activeStates.remove(State.State4);

			activeStates.add(State.State1);

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
