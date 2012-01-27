/**
Copyright (c) 2011 committers of YAKINDU and others. 
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html
 
Contributors:
	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.runtime.java.test_deephistory;

import java.util.Collection;
import java.util.HashSet;
import org.yakindu.sct.runtime.java.Event;
import org.yakindu.sct.runtime.java.EventVector;
import org.yakindu.sct.runtime.java.IStatemachine;

public class Test_DeepHistoryCycleBasedStatemachine implements IStatemachine {

	public enum State {
		State1, State2, State3, State4, State6, State7, State8, State9, State5, $NullState$
	};

	private DefaultInterfaceImpl defaultInterface;

	private State[] historyVector = new State[3];

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	private final EventVector<Event<? extends Enum<?>>> occuredEvents;

	private final Collection<Event<? extends Enum<?>>> outEvents;

	public Test_DeepHistoryCycleBasedStatemachine() {
		occuredEvents = new EventVector<Event<? extends Enum<?>>>(9);
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
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		for (int i = 0; i < 3; i++) {
			historyVector[i] = State.$NullState$;
		}

		occuredEvents.clear();
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

	private DefaultInterfaceImpl getDefaultInterfaceImpl() {
		return defaultInterface;
	}

	public void enter() {
		nextStateIndex = 0;
		stateVector[0] = State.State1;

	}

	public void exit() {
		//Handle exit of all possible states (of main region) at position 0...
		switch (stateVector[0]) {

			case State1 :
				stateVector[0] = State.$NullState$;

				break;

			case State3 :
				stateVector[0] = State.$NullState$;

				break;

			case State6 :
				stateVector[0] = State.$NullState$;

				break;

			case State8 :
				stateVector[0] = State.$NullState$;

				break;

			case State9 :
				stateVector[0] = State.$NullState$;

				break;

			case State5 :
				stateVector[0] = State.$NullState$;

				break;

			default :
				break;
		}

	}

	private void deepEnterSequenceState20() {
		//Handle deep history entry of null
		switch (historyVector[0]) {

			case State3 :
				nextStateIndex = 0;
				stateVector[0] = State.State3;

				break;

			case State6 :

				deepEnterSequenceState40();

				break;

			case State8 :

				deepEnterSequenceState40();

				break;

			case State9 :

				deepEnterSequenceState40();

				break;

			case State5 :
				nextStateIndex = 0;
				stateVector[0] = State.State5;

				break;

			default :
				break;
		}
	}

	private void deepEnterSequenceState40() {
		//Handle deep history entry of null
		switch (historyVector[1]) {

			case State6 :
				nextStateIndex = 0;
				stateVector[0] = State.State6;

				break;

			case State8 :

				deepEnterSequenceState70();

				break;

			case State9 :

				deepEnterSequenceState70();

				break;

			default :
				break;
		}
	}

	private void deepEnterSequenceState70() {
		//Handle deep history entry of null
		switch (historyVector[2]) {

			case State8 :
				nextStateIndex = 0;
				stateVector[0] = State.State8;

				break;

			case State9 :
				nextStateIndex = 0;
				stateVector[0] = State.State9;

				break;

			default :
				break;
		}
	}

	private void reactState1() {
		if (occuredEvents.contains(getDefaultInterfaceImpl().getEventEvent1())) {
			stateVector[0] = State.$NullState$;

			//Enter the region with deep history
			if (historyVector[0] != State.$NullState$) {

				deepEnterSequenceState20();
			} else {
				nextStateIndex = 0;
				stateVector[0] = State.State3;

			}

		}
	}
	private void reactState2() {
	}
	private void reactState3() {
		if (occuredEvents.contains(getDefaultInterfaceImpl().getEventEvent2())) {

			historyVector[0] = stateVector[0];
			//Handle exit of all possible states (of null) at position 0...
			switch (stateVector[0]) {

				case State3 :
					stateVector[0] = State.$NullState$;

					break;

				case State6 :
					stateVector[0] = State.$NullState$;

					break;

				case State8 :
					stateVector[0] = State.$NullState$;

					break;

				case State9 :
					stateVector[0] = State.$NullState$;

					break;

				case State5 :
					stateVector[0] = State.$NullState$;

					break;

				default :
					break;
			}

			nextStateIndex = 0;
			stateVector[0] = State.State1;

		} else {
			if (occuredEvents.contains(getDefaultInterfaceImpl()
					.getEventEvent3())) {
				stateVector[0] = State.$NullState$;

				nextStateIndex = 0;
				stateVector[0] = State.State6;

			}

		}
	}
	private void reactState4() {
	}
	private void reactState6() {
		if (occuredEvents.contains(getDefaultInterfaceImpl().getEventEvent2())) {

			historyVector[0] = stateVector[0];
			//Handle exit of all possible states (of null) at position 0...
			switch (stateVector[0]) {

				case State3 :
					stateVector[0] = State.$NullState$;

					break;

				case State6 :
					stateVector[0] = State.$NullState$;

					break;

				case State8 :
					stateVector[0] = State.$NullState$;

					break;

				case State9 :
					stateVector[0] = State.$NullState$;

					break;

				case State5 :
					stateVector[0] = State.$NullState$;

					break;

				default :
					break;
			}

			nextStateIndex = 0;
			stateVector[0] = State.State1;

		} else {
			if (occuredEvents.contains(getDefaultInterfaceImpl()
					.getEventEvent4())) {

				historyVector[1] = stateVector[0];
				//Handle exit of all possible states (of null) at position 0...
				switch (stateVector[0]) {

					case State6 :
						stateVector[0] = State.$NullState$;

						break;

					case State8 :
						stateVector[0] = State.$NullState$;

						break;

					case State9 :
						stateVector[0] = State.$NullState$;

						break;

					default :
						break;
				}

				nextStateIndex = 0;
				stateVector[0] = State.State5;

			} else {
				if (occuredEvents.contains(getDefaultInterfaceImpl()
						.getEventEvent5())) {
					stateVector[0] = State.$NullState$;

					nextStateIndex = 0;
					stateVector[0] = State.State8;

				}

			}

		}
	}
	private void reactState7() {
	}
	private void reactState8() {
		if (occuredEvents.contains(getDefaultInterfaceImpl().getEventEvent2())) {

			historyVector[0] = stateVector[0];
			//Handle exit of all possible states (of null) at position 0...
			switch (stateVector[0]) {

				case State3 :
					stateVector[0] = State.$NullState$;

					break;

				case State6 :
					stateVector[0] = State.$NullState$;

					break;

				case State8 :
					stateVector[0] = State.$NullState$;

					break;

				case State9 :
					stateVector[0] = State.$NullState$;

					break;

				case State5 :
					stateVector[0] = State.$NullState$;

					break;

				default :
					break;
			}

			nextStateIndex = 0;
			stateVector[0] = State.State1;

		} else {
			if (occuredEvents.contains(getDefaultInterfaceImpl()
					.getEventEvent4())) {

				historyVector[1] = stateVector[0];
				//Handle exit of all possible states (of null) at position 0...
				switch (stateVector[0]) {

					case State6 :
						stateVector[0] = State.$NullState$;

						break;

					case State8 :
						stateVector[0] = State.$NullState$;

						break;

					case State9 :
						stateVector[0] = State.$NullState$;

						break;

					default :
						break;
				}

				nextStateIndex = 0;
				stateVector[0] = State.State5;

			} else {
				if (occuredEvents.contains(getDefaultInterfaceImpl()
						.getEventEvent6())) {

					historyVector[2] = stateVector[0];
					//Handle exit of all possible states (of null) at position 0...
					switch (stateVector[0]) {

						case State8 :
							stateVector[0] = State.$NullState$;

							break;

						case State9 :
							stateVector[0] = State.$NullState$;

							break;

						default :
							break;
					}

					nextStateIndex = 0;
					stateVector[0] = State.State6;

				} else {
					if (occuredEvents.contains(getDefaultInterfaceImpl()
							.getEventEvent7())) {
						stateVector[0] = State.$NullState$;

						nextStateIndex = 0;
						stateVector[0] = State.State9;

					}

				}

			}

		}
	}
	private void reactState9() {
		if (occuredEvents.contains(getDefaultInterfaceImpl().getEventEvent2())) {

			historyVector[0] = stateVector[0];
			//Handle exit of all possible states (of null) at position 0...
			switch (stateVector[0]) {

				case State3 :
					stateVector[0] = State.$NullState$;

					break;

				case State6 :
					stateVector[0] = State.$NullState$;

					break;

				case State8 :
					stateVector[0] = State.$NullState$;

					break;

				case State9 :
					stateVector[0] = State.$NullState$;

					break;

				case State5 :
					stateVector[0] = State.$NullState$;

					break;

				default :
					break;
			}

			nextStateIndex = 0;
			stateVector[0] = State.State1;

		} else {
			if (occuredEvents.contains(getDefaultInterfaceImpl()
					.getEventEvent4())) {

				historyVector[1] = stateVector[0];
				//Handle exit of all possible states (of null) at position 0...
				switch (stateVector[0]) {

					case State6 :
						stateVector[0] = State.$NullState$;

						break;

					case State8 :
						stateVector[0] = State.$NullState$;

						break;

					case State9 :
						stateVector[0] = State.$NullState$;

						break;

					default :
						break;
				}

				nextStateIndex = 0;
				stateVector[0] = State.State5;

			} else {
				if (occuredEvents.contains(getDefaultInterfaceImpl()
						.getEventEvent6())) {

					historyVector[2] = stateVector[0];
					//Handle exit of all possible states (of null) at position 0...
					switch (stateVector[0]) {

						case State8 :
							stateVector[0] = State.$NullState$;

							break;

						case State9 :
							stateVector[0] = State.$NullState$;

							break;

						default :
							break;
					}

					nextStateIndex = 0;
					stateVector[0] = State.State6;

				} else {
					if (occuredEvents.contains(getDefaultInterfaceImpl()
							.getEventEvent8())) {
						stateVector[0] = State.$NullState$;

						nextStateIndex = 0;
						stateVector[0] = State.State8;

					}

				}

			}

		}
	}
	private void reactState5() {
		if (occuredEvents.contains(getDefaultInterfaceImpl().getEventEvent2())) {

			historyVector[0] = stateVector[0];
			//Handle exit of all possible states (of null) at position 0...
			switch (stateVector[0]) {

				case State3 :
					stateVector[0] = State.$NullState$;

					break;

				case State6 :
					stateVector[0] = State.$NullState$;

					break;

				case State8 :
					stateVector[0] = State.$NullState$;

					break;

				case State9 :
					stateVector[0] = State.$NullState$;

					break;

				case State5 :
					stateVector[0] = State.$NullState$;

					break;

				default :
					break;
			}

			nextStateIndex = 0;
			stateVector[0] = State.State1;

		} else {

		}
	}
	public void runCycle() {
		outEvents.clear();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

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
					// $NullState$
			}
		}

		occuredEvents.clear();
	}
}
