/**
Copyright (c) 2011 committers of YAKINDU and others. 
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html
 
Contributors:
	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.runtime.java.test_shallowhistory;

import java.util.Collection;
import java.util.HashSet;
import org.yakindu.sct.runtime.java.Event;
import org.yakindu.sct.runtime.java.EventVector;
import java.util.HashMap;
import java.util.Map;
import org.yakindu.sct.runtime.java.IGenericAccessStatemachine;
import org.yakindu.sct.runtime.java.IGenericAccessInterface;
import org.yakindu.sct.runtime.java.IStatemachine;

public class Test_ShallowHistoryCycleBasedStatemachine
		implements
			IGenericAccessStatemachine,
			DefaultInterface,
			IStatemachine {

	public enum State {
		State1, State2, State3, State4, State6, State7, State8, State9, State5, $NullState$
	};

	protected Map<String, IGenericAccessInterface> interfaceMap;

	private State[] historyVector = new State[2];

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	private final EventVector<Event<? extends Enum<?>>> occuredEvents;

	private final Collection<Event<? extends Enum<?>>> outEvents;

	public Test_ShallowHistoryCycleBasedStatemachine() {
		occuredEvents = new EventVector<Event<? extends Enum<?>>>(8);
		outEvents = new HashSet<Event<? extends Enum<?>>>();
		interfaceMap = new HashMap<String, IGenericAccessInterface>();
		interfaceMap.put("DefaultInterface", new DefaultInterfaceImpl(this));

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

		for (int i = 0; i < 2; i++) {
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

	public IGenericAccessInterface getInterface(String name) {
		return interfaceMap.get(name);
	}

	protected Map<String, IGenericAccessInterface> getInterfaceMap() {
		return interfaceMap;
	}

	public DefaultInterface getDefaultInterface() {
		return (DefaultInterface) getInterface("DefaultInterface");
	}

	protected IDefaultInterfaceImpl getDefaultInterfaceImpl() {
		return (IDefaultInterfaceImpl) getInterface("DefaultInterface");
	}

	public void raiseEvent1() {
		getDefaultInterface().raiseEvent1();
	}

	public void raiseEvent2() {
		getDefaultInterface().raiseEvent2();
	}

	public void raiseEvent3() {
		getDefaultInterface().raiseEvent3();
	}

	public void raiseEvent4() {
		getDefaultInterface().raiseEvent4();
	}

	public void raiseEvent5() {
		getDefaultInterface().raiseEvent5();
	}

	public void raiseEvent6() {
		getDefaultInterface().raiseEvent6();
	}

	public void raiseEvent7() {
		getDefaultInterface().raiseEvent7();
	}

	public void raiseEvent8() {
		getDefaultInterface().raiseEvent8();
	}

	public boolean raiseEvent(String name) {
		return getDefaultInterface().raiseEvent(name);
	}

	@SuppressWarnings("unchecked")
	public boolean raiseEvent(String name, Object value) {
		return getDefaultInterface().raiseEvent(name, value);
	}

	public boolean setVariable(String name, Object value) {
		return getDefaultInterface().setVariable(name, value);
	}

	public Object getVariable(String name) {
		return getDefaultInterface().getVariable(name);
	}

	public void enter() {
		nextStateIndex = 0;
		stateVector[0] = State.State1;

	}

	public void exit() {
		//Handle exit of all possible states (of mainRegion) at position 0...
		switch (stateVector[0]) {

			case State1 :
				stateVector[0] = State.$NullState$;

				break;

			case State3 :

				historyVector[0] = stateVector[0];
				stateVector[0] = State.$NullState$;

				break;

			case State6 :

				historyVector[0] = stateVector[0];
				stateVector[0] = State.$NullState$;

				break;

			case State8 :

				historyVector[0] = stateVector[0];

				historyVector[1] = stateVector[0];
				stateVector[0] = State.$NullState$;

				break;

			case State9 :

				historyVector[0] = stateVector[0];

				historyVector[1] = stateVector[0];
				stateVector[0] = State.$NullState$;

				break;

			case State5 :

				historyVector[0] = stateVector[0];
				stateVector[0] = State.$NullState$;

				break;

			default :
				break;
		}

	}

	private void shallowEnterSequenceState20() {
		//Handle shallow history entry of null
		switch (historyVector[0]) {

			case State3 :
				nextStateIndex = 0;
				stateVector[0] = State.State3;

				break;

			case State6 :
				nextStateIndex = 0;
				stateVector[0] = State.State6;

				break;

			case State8 :
				nextStateIndex = 0;
				stateVector[0] = State.State6;

				break;

			case State9 :
				nextStateIndex = 0;
				stateVector[0] = State.State6;

				break;

			case State5 :
				nextStateIndex = 0;
				stateVector[0] = State.State5;

				break;

			default :
				break;
		}
	}

	private void shallowEnterSequenceState70() {
		//Handle shallow history entry of null
		switch (historyVector[1]) {

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

			//Enter the region with shallow history
			if (historyVector[0] != State.$NullState$) {

				shallowEnterSequenceState20();
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

					historyVector[1] = stateVector[0];
					stateVector[0] = State.$NullState$;

					break;

				case State9 :

					historyVector[1] = stateVector[0];
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

					historyVector[1] = stateVector[0];
					stateVector[0] = State.$NullState$;

					break;

				case State9 :

					historyVector[1] = stateVector[0];
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
				//Handle exit of all possible states (of null) at position 0...
				switch (stateVector[0]) {

					case State6 :
						stateVector[0] = State.$NullState$;

						break;

					case State8 :

						historyVector[1] = stateVector[0];
						stateVector[0] = State.$NullState$;

						break;

					case State9 :

						historyVector[1] = stateVector[0];
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

					//Enter the region with shallow history
					if (historyVector[1] != State.$NullState$) {

						shallowEnterSequenceState70();
					} else {
						nextStateIndex = 0;
						stateVector[0] = State.State8;

					}

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

					historyVector[1] = stateVector[0];
					stateVector[0] = State.$NullState$;

					break;

				case State9 :

					historyVector[1] = stateVector[0];
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
				//Handle exit of all possible states (of null) at position 0...
				switch (stateVector[0]) {

					case State6 :
						stateVector[0] = State.$NullState$;

						break;

					case State8 :

						historyVector[1] = stateVector[0];
						stateVector[0] = State.$NullState$;

						break;

					case State9 :

						historyVector[1] = stateVector[0];
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

					historyVector[1] = stateVector[0];
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

					historyVector[1] = stateVector[0];
					stateVector[0] = State.$NullState$;

					break;

				case State9 :

					historyVector[1] = stateVector[0];
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
				//Handle exit of all possible states (of null) at position 0...
				switch (stateVector[0]) {

					case State6 :
						stateVector[0] = State.$NullState$;

						break;

					case State8 :

						historyVector[1] = stateVector[0];
						stateVector[0] = State.$NullState$;

						break;

					case State9 :

						historyVector[1] = stateVector[0];
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

					historyVector[1] = stateVector[0];
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

					historyVector[1] = stateVector[0];
					stateVector[0] = State.$NullState$;

					break;

				case State9 :

					historyVector[1] = stateVector[0];
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
