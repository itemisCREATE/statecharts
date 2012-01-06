/**
Copyright (c) 2011 committers of YAKINDU and others. 
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html
 
Contributors:
	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.runtime.java.test_expression;

import java.util.Collection;
import java.util.HashSet;
import org.yakindu.sct.runtime.java.Event;
import org.yakindu.sct.runtime.java.EventVector;
import org.yakindu.sct.runtime.java.IStatemachine;

public class Test_ExpressionCycleBasedStatemachine implements IStatemachine {

	public enum State {
		State1, State2, $NullState$
	};

	private DefaultInterfaceImpl defaultInterface;
	private InterfaceOtherImpl interfaceOther;

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	private final EventVector<Event<? extends Enum<?>>> occuredEvents;

	private final Collection<Event<? extends Enum<?>>> outEvents;

	public Test_ExpressionCycleBasedStatemachine() {
		occuredEvents = new EventVector<Event<? extends Enum<?>>>(3);
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

	public void enter() {
		defaultInterface.setVarVar3(defaultInterface.getVarVar3()
				+ ((defaultInterface.getVarVar2() * defaultInterface
						.getVarVar3())));

		nextStateIndex = 0;
		stateVector[0] = State.State1;

	}

	private void reactState1() {
		if ((occuredEvents.contains(defaultInterface.getEventEvent1()) && ((interfaceOther
				.getVarVar1() == true) || (defaultInterface.getVarVar5() == false)))) {
			stateVector[0] = State.$NullState$;

			defaultInterface.setVarVar2(1);

			defaultInterface.setVarVar4(22.3);

			interfaceOther.setVarVar1(false);

			defaultInterface.setVarVar3(defaultInterface.getVarVar3() / (5));

			defaultInterface.setVarVar1(defaultInterface.getVarVar1() + (1));

			nextStateIndex = 0;
			stateVector[0] = State.State2;

		}
	}
	private void reactState2() {
		if ((occuredEvents.contains(defaultInterface.getEventEvent1()) && (defaultInterface
				.getVarVar3() > 0))) {
			stateVector[0] = State.$NullState$;

			defaultInterface.setVarVar5(true);

			defaultInterface.setVarVar3(defaultInterface.getVarVar3()
					+ ((defaultInterface.getVarVar2() * defaultInterface
							.getVarVar3())));

			nextStateIndex = 0;
			stateVector[0] = State.State1;

		} else {
			if (true) {
				defaultInterface
						.setVarVar1(defaultInterface.getVarVar1() + (1));

			}

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
				default :
					// $NullState$
			}
		}

		occuredEvents.clear();
	}
}
