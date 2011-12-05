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
package org.yakindu.sct.runtime.java.test_parallelregions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import org.yakindu.sct.runtime.java.Event;
import org.yakindu.sct.runtime.java.IStatemachine;

public class Test_ParallelRegionsCycleBasedStatemachine
		implements
			IStatemachine {

	public enum State {
		State1, State2, State3, State4, State5, State6, State9, State7, State8,
	};

	private DefaultInterfaceImpl defaultInterface;

	private final Set<State> activeStates = EnumSet.noneOf(State.class);

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

			activeStates.add(State.State7);

		}
	}
	private void reactState2() {
	}
	private void reactState3() {
		if (occuredEvents.contains(defaultInterface.getEventEvent2())) {
			activeStates.remove(State.State3);

			activeStates.add(State.State5);

			activeStates.add(State.State9);

		}

	}
	private void reactState4() {
	}
	private void reactState5() {
		if (occuredEvents.contains(defaultInterface.getEventEvent3())) {
			activeStates.remove(State.State5);

			activeStates.add(State.State6);

		}

	}
	private void reactState6() {
		if (occuredEvents.contains(defaultInterface.getEventEvent4())) {
			activeStates.remove(State.State6);

			activeStates.add(State.State5);

		}

	}
	private void reactState9() {

	}
	private void reactState7() {
		if ((occuredEvents.contains(defaultInterface.getEventEvent5()) || occuredEvents
				.contains(defaultInterface.getEventEvent3()))) {
			activeStates.remove(State.State7);

			activeStates.add(State.State8);

		}

	}
	private void reactState8() {
		if (occuredEvents.contains(defaultInterface.getEventEvent6())) {
			activeStates.remove(State.State8);

			activeStates.add(State.State7);

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
		occuredEvents.clear();
	}
}
