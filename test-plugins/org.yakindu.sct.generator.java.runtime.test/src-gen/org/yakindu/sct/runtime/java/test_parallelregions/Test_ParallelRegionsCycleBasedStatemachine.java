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

import java.util.Collection;
import java.util.HashSet;
import org.yakindu.sct.runtime.java.Event;
import org.yakindu.sct.runtime.java.EventVector;
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

	private final EventVector<Event<? extends Enum<?>>> occuredEvents;

	private final Collection<Event<? extends Enum<?>>> outEvents;

	public Test_ParallelRegionsCycleBasedStatemachine() {
		occuredEvents = new EventVector<Event<? extends Enum<?>>>(10);
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
		nextStateIndex = 0;
		stateVector[0] = State.State1;

	}

	private void reactState1() {
		if (occuredEvents.contains(defaultInterface.getEventEvent1())) {
			stateVector[0] = null;

			nextStateIndex = 0;
			stateVector[0] = State.State3;

			defaultInterface.setVarReg3(7);

			nextStateIndex = 2;
			stateVector[2] = State.State7;

		}
	}
	private void reactState2() {
	}
	private void reactState3() {
		if (occuredEvents.contains(defaultInterface.getEventEvent10())) {
			//Handle exit of all possible states on position 0...
			switch (stateVector[0]) {

				case State3 :
					stateVector[0] = null;

					break;

				case State5 :
					stateVector[0] = null;

					break;

				case State6 :
					stateVector[0] = null;

					break;

				default :
					break;
			}
			//Handle exit of all possible states on position 1...
			switch (stateVector[1]) {

				case State9 :
					stateVector[1] = null;

					break;

				default :
					break;
			}
			//Handle exit of all possible states on position 2...
			switch (stateVector[2]) {

				case State7 :
					stateVector[2] = null;

					defaultInterface.setVarReg3(-(1));

					break;

				case State8 :
					stateVector[2] = null;

					defaultInterface.setVarReg3(-(1));

					break;

				default :
					break;
			}

			nextStateIndex = 0;
			stateVector[0] = State.State1;

		} else {
			if (occuredEvents.contains(defaultInterface.getEventEvent2())) {
				stateVector[0] = null;

				nextStateIndex = 0;
				stateVector[0] = State.State5;

				nextStateIndex = 1;
				stateVector[1] = State.State9;

			} else {
				if ((occuredEvents.contains(defaultInterface.getEventEvent3()) || occuredEvents
						.contains(defaultInterface.getEventEvent9()))) {
					stateVector[0] = null;

					nextStateIndex = 0;
					stateVector[0] = State.State1;

				}
			}

		}
	}
	private void reactState4() {
	}
	private void reactState5() {
		if (occuredEvents.contains(defaultInterface.getEventEvent10())) {
			//Handle exit of all possible states on position 0...
			switch (stateVector[0]) {

				case State3 :
					stateVector[0] = null;

					break;

				case State5 :
					stateVector[0] = null;

					break;

				case State6 :
					stateVector[0] = null;

					break;

				default :
					break;
			}
			//Handle exit of all possible states on position 1...
			switch (stateVector[1]) {

				case State9 :
					stateVector[1] = null;

					break;

				default :
					break;
			}
			//Handle exit of all possible states on position 2...
			switch (stateVector[2]) {

				case State7 :
					stateVector[2] = null;

					defaultInterface.setVarReg3(-(1));

					break;

				case State8 :
					stateVector[2] = null;

					defaultInterface.setVarReg3(-(1));

					break;

				default :
					break;
			}

			nextStateIndex = 0;
			stateVector[0] = State.State1;

		} else {
			if (occuredEvents.contains(defaultInterface.getEventEvent3())) {
				stateVector[0] = null;

				nextStateIndex = 0;
				stateVector[0] = State.State6;

			}

		}
	}
	private void reactState6() {
		if (occuredEvents.contains(defaultInterface.getEventEvent10())) {
			//Handle exit of all possible states on position 0...
			switch (stateVector[0]) {

				case State3 :
					stateVector[0] = null;

					break;

				case State5 :
					stateVector[0] = null;

					break;

				case State6 :
					stateVector[0] = null;

					break;

				default :
					break;
			}
			//Handle exit of all possible states on position 1...
			switch (stateVector[1]) {

				case State9 :
					stateVector[1] = null;

					break;

				default :
					break;
			}
			//Handle exit of all possible states on position 2...
			switch (stateVector[2]) {

				case State7 :
					stateVector[2] = null;

					defaultInterface.setVarReg3(-(1));

					break;

				case State8 :
					stateVector[2] = null;

					defaultInterface.setVarReg3(-(1));

					break;

				default :
					break;
			}

			nextStateIndex = 0;
			stateVector[0] = State.State1;

		} else {
			if (occuredEvents.contains(defaultInterface.getEventEvent4())) {
				stateVector[0] = null;

				nextStateIndex = 0;
				stateVector[0] = State.State5;

			}

		}
	}
	private void reactState9() {
		if (occuredEvents.contains(defaultInterface.getEventEvent10())) {
			//Handle exit of all possible states on position 0...
			switch (stateVector[0]) {

				case State3 :
					stateVector[0] = null;

					break;

				case State5 :
					stateVector[0] = null;

					break;

				case State6 :
					stateVector[0] = null;

					break;

				default :
					break;
			}
			//Handle exit of all possible states on position 1...
			switch (stateVector[1]) {

				case State9 :
					stateVector[1] = null;

					break;

				default :
					break;
			}
			//Handle exit of all possible states on position 2...
			switch (stateVector[2]) {

				case State7 :
					stateVector[2] = null;

					defaultInterface.setVarReg3(-(1));

					break;

				case State8 :
					stateVector[2] = null;

					defaultInterface.setVarReg3(-(1));

					break;

				default :
					break;
			}

			nextStateIndex = 0;
			stateVector[0] = State.State1;

		} else {
			if (occuredEvents.contains(defaultInterface.getEventEvent8())) {
				stateVector[1] = null;

				nextStateIndex = 0;
				stateVector[0] = State.State1;

			}

		}
	}
	private void reactState7() {
		if (occuredEvents.contains(defaultInterface.getEventEvent10())) {
			//Handle exit of all possible states on position 0...
			switch (stateVector[0]) {

				case State3 :
					stateVector[0] = null;

					break;

				case State5 :
					stateVector[0] = null;

					break;

				case State6 :
					stateVector[0] = null;

					break;

				default :
					break;
			}
			//Handle exit of all possible states on position 1...
			switch (stateVector[1]) {

				case State9 :
					stateVector[1] = null;

					break;

				default :
					break;
			}
			//Handle exit of all possible states on position 2...
			switch (stateVector[2]) {

				case State7 :
					stateVector[2] = null;

					defaultInterface.setVarReg3(-(1));

					break;

				case State8 :
					stateVector[2] = null;

					defaultInterface.setVarReg3(-(1));

					break;

				default :
					break;
			}

			nextStateIndex = 0;
			stateVector[0] = State.State1;

		} else {
			if ((occuredEvents.contains(defaultInterface.getEventEvent5()) || occuredEvents
					.contains(defaultInterface.getEventEvent3()))) {
				stateVector[2] = null;

				defaultInterface.setVarReg3(-(1));

				defaultInterface.setVarReg3(8);

				nextStateIndex = 2;
				stateVector[2] = State.State8;

			} else {
				if (occuredEvents.contains(defaultInterface.getEventEvent7())) {
					stateVector[2] = null;

					defaultInterface.setVarReg3(-(1));

					nextStateIndex = 0;
					stateVector[0] = State.State1;

				}
			}

		}
	}
	private void reactState8() {
		if (occuredEvents.contains(defaultInterface.getEventEvent10())) {
			//Handle exit of all possible states on position 0...
			switch (stateVector[0]) {

				case State3 :
					stateVector[0] = null;

					break;

				case State5 :
					stateVector[0] = null;

					break;

				case State6 :
					stateVector[0] = null;

					break;

				default :
					break;
			}
			//Handle exit of all possible states on position 1...
			switch (stateVector[1]) {

				case State9 :
					stateVector[1] = null;

					break;

				default :
					break;
			}
			//Handle exit of all possible states on position 2...
			switch (stateVector[2]) {

				case State7 :
					stateVector[2] = null;

					defaultInterface.setVarReg3(-(1));

					break;

				case State8 :
					stateVector[2] = null;

					defaultInterface.setVarReg3(-(1));

					break;

				default :
					break;
			}

			nextStateIndex = 0;
			stateVector[0] = State.State1;

		} else {
			if (occuredEvents.contains(defaultInterface.getEventEvent6())) {
				stateVector[2] = null;

				defaultInterface.setVarReg3(-(1));

				defaultInterface.setVarReg3(7);

				nextStateIndex = 2;
				stateVector[2] = State.State7;

			}

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
