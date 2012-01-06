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
import org.yakindu.sct.runtime.java.IStatemachine;

public class InterfaceTestCycleBasedStatemachine implements IStatemachine {

	public enum State {
		State1, State2, State3, State4, $NullState$
	};

	private DefaultInterfaceImpl defaultInterface;
	private InterfaceOtherImpl interfaceOther;
	private InterfaceThirdImpl interfaceThird;

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	private final EventVector<Event<? extends Enum<?>>> occuredEvents;

	private final Collection<Event<? extends Enum<?>>> outEvents;

	public InterfaceTestCycleBasedStatemachine() {
		occuredEvents = new EventVector<Event<? extends Enum<?>>>(6);
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
		for (int i = 0; i < stateVector.length; i++) {
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
		nextStateIndex = 0;
		stateVector[0] = State.State1;

	}

	private void reactState1() {
		if ((occuredEvents.contains(defaultInterface.getEventEvent1()) && (defaultInterface
				.getVarVar2() > 0))) {
			stateVector[0] = State.$NullState$;

			defaultInterface.raiseEvent2(22);

			nextStateIndex = 0;
			stateVector[0] = State.State2;

		} else {
			if ((occuredEvents.contains(interfaceOther.getEventEvent3()) && (defaultInterface
					.getVarVar3() == 1))) {
				stateVector[0] = State.$NullState$;

				interfaceOther.raiseEvent4();

				nextStateIndex = 0;
				stateVector[0] = State.State3;

			} else {
				if ((occuredEvents.contains(interfaceThird.getEventEvent5()) && (defaultInterface
						.getVarVar1() == true))) {
					stateVector[0] = State.$NullState$;

					interfaceThird.raiseEvent6(true);

					nextStateIndex = 0;
					stateVector[0] = State.State4;

				}
			}
		}
	}
	private void reactState2() {
		if (occuredEvents.contains(defaultInterface.getEventEvent1())) {
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.State1;

		}
	}
	private void reactState3() {
		if (occuredEvents.contains(interfaceOther.getEventEvent3())) {
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.State1;

		}
	}
	private void reactState4() {
		if (occuredEvents.contains(interfaceThird.getEventEvent5())) {
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
