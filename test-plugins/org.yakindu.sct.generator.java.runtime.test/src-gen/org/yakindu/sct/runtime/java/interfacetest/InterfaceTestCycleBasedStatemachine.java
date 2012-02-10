/**
Copyright (c) 2011 committers of YAKINDU and others. 
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html
 
Contributors:
	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.runtime.java.interfacetest;

import java.util.Collection;
import java.util.HashSet;
import org.yakindu.sct.runtime.java.Event;
import org.yakindu.sct.runtime.java.EventVector;
import java.util.HashMap;
import java.util.Map;
import org.yakindu.sct.runtime.java.IGenericAccessStatemachine;
import org.yakindu.sct.runtime.java.IGenericAccessInterface;
import org.yakindu.sct.runtime.java.IStatemachine;

public class InterfaceTestCycleBasedStatemachine
		implements
			IGenericAccessStatemachine,
			IStatemachine {

	public enum State {
		State1, State2, State3, State4, $NullState$
	};

	protected Map<String, IGenericAccessInterface> interfaceMap;

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	private final EventVector<Event<? extends Enum<?>>> occuredEvents;

	private final Collection<Event<? extends Enum<?>>> outEvents;

	public InterfaceTestCycleBasedStatemachine() {
		occuredEvents = new EventVector<Event<? extends Enum<?>>>(6);
		outEvents = new HashSet<Event<? extends Enum<?>>>();
		interfaceMap = new HashMap<String, IGenericAccessInterface>();
		interfaceMap.put("DefaultInterface", new DefaultInterfaceImpl(this));
		interfaceMap.put("InterfaceOther", new InterfaceOtherImpl(this));
		interfaceMap.put("InterfaceThird", new InterfaceThirdImpl(this));

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
	public InterfaceOther getInterfaceOther() {
		return (InterfaceOther) getInterface("InterfaceOther");
	}

	protected IInterfaceOtherImpl getInterfaceOtherImpl() {
		return (IInterfaceOtherImpl) getInterface("InterfaceOther");
	}
	public InterfaceThird getInterfaceThird() {
		return (InterfaceThird) getInterface("InterfaceThird");
	}

	protected IInterfaceThirdImpl getInterfaceThirdImpl() {
		return (IInterfaceThirdImpl) getInterface("InterfaceThird");
	}

	public void enter() {
		getDefaultInterfaceImpl().setVarVar2(2.3);
		getDefaultInterfaceImpl().setVarVar3(1);
		getInterfaceOtherImpl().setVarV1(5);
		nextStateIndex = 0;
		stateVector[0] = State.State1;

	}

	public void exit() {
		//Handle exit of all possible states (of mainRegion) at position 0...
		switch (stateVector[0]) {

			case State1 :
				stateVector[0] = State.$NullState$;

				break;

			case State2 :
				stateVector[0] = State.$NullState$;
				getInterfaceOtherImpl().setVarV1(10);

				break;

			case State3 :
				stateVector[0] = State.$NullState$;

				break;

			case State4 :
				stateVector[0] = State.$NullState$;

				break;

			default :
				break;
		}

	}

	private void reactState1() {
		if ((occuredEvents.contains(getDefaultInterfaceImpl().getEventEvent1()) && (getDefaultInterfaceImpl()
				.getVarVar2() > 0))) {
			stateVector[0] = State.$NullState$;

			getDefaultInterfaceImpl().raiseEvent2(22);

			nextStateIndex = 0;
			stateVector[0] = State.State2;

		} else {
			if ((occuredEvents.contains(getInterfaceOtherImpl()
					.getEventEvent3()) && (getDefaultInterfaceImpl()
					.getVarVar3() == 1))) {
				stateVector[0] = State.$NullState$;

				getInterfaceOtherImpl().raiseEvent4();

				nextStateIndex = 0;
				stateVector[0] = State.State3;

			} else {
				if ((occuredEvents.contains(getInterfaceThirdImpl()
						.getEventEvent5()) && (getDefaultInterfaceImpl()
						.getVarVar1() == true))) {
					stateVector[0] = State.$NullState$;

					getInterfaceThirdImpl().raiseEvent6(true);

					nextStateIndex = 0;
					stateVector[0] = State.State4;

				}
			}
		}
	}
	private void reactState2() {
		if (occuredEvents.contains(getDefaultInterfaceImpl().getEventEvent1())) {
			stateVector[0] = State.$NullState$;
			getInterfaceOtherImpl().setVarV1(10);

			nextStateIndex = 0;
			stateVector[0] = State.State1;

		}
	}
	private void reactState3() {
		if (occuredEvents.contains(getInterfaceOtherImpl().getEventEvent3())) {
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.State1;

		}
	}
	private void reactState4() {
		if (occuredEvents.contains(getInterfaceThirdImpl().getEventEvent5())) {
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.State1;

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
				default :
					// $NullState$
			}
		}

		occuredEvents.clear();
	}
}
