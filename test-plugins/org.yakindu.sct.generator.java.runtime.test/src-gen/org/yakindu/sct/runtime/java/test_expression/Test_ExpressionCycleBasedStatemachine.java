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
import java.util.HashMap;
import java.util.Map;
import org.yakindu.sct.runtime.java.IGenericAccessStatemachine;
import org.yakindu.sct.runtime.java.IGenericAccessInterface;
import org.yakindu.sct.runtime.java.IStatemachine;
import org.yakindu.sct.runtime.java.ValuedEvent;
import org.yakindu.sct.runtime.java.NotificationSender;

public class Test_ExpressionCycleBasedStatemachine extends NotificationSender
		implements
			IGenericAccessStatemachine,
			DefaultInterface,
			IStatemachine {

	public enum State {
		State1, State2, $NullState$
	};

	protected Map<String, IGenericAccessInterface> interfaceMap;

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	private final EventVector<Event<? extends Enum<?>>> occuredEvents;

	private final Collection<Event<? extends Enum<?>>> outEvents;

	public Test_ExpressionCycleBasedStatemachine() {
		occuredEvents = new EventVector<Event<? extends Enum<?>>>(3);
		outEvents = new HashSet<Event<? extends Enum<?>>>();
		interfaceMap = new HashMap<String, IGenericAccessInterface>();
		interfaceMap.put("DefaultInterface", new DefaultInterfaceImpl(this));
		interfaceMap.put("InterfaceOther", new InterfaceOtherImpl());

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

	public void raiseEvent1(int value) {
		getDefaultInterface().raiseEvent1(value);
	}

	public boolean isRaisedEvent2() {
		return getOutEvents().contains(getEventEvent2());
	}

	public ValuedEvent<Events, Double> getEventEvent2() {
		return getDefaultInterface().getEventEvent2();
	}

	public void raiseEvent3() {
		getDefaultInterface().raiseEvent3();
	}

	public int getVarVar1() {
		return getDefaultInterface().getVarVar1();
	}

	public void setVarVar1(int value) {
		getDefaultInterface().setVarVar1(value);
	}
	public int getVarVar2() {
		return getDefaultInterface().getVarVar2();
	}

	public void setVarVar2(int value) {
		getDefaultInterface().setVarVar2(value);
	}
	public double getVarVar3() {
		return getDefaultInterface().getVarVar3();
	}

	public void setVarVar3(double value) {
		getDefaultInterface().setVarVar3(value);
	}
	public double getVarVar4() {
		return getDefaultInterface().getVarVar4();
	}

	public void setVarVar4(double value) {
		getDefaultInterface().setVarVar4(value);
	}
	public boolean getVarVar5() {
		return getDefaultInterface().getVarVar5();
	}

	public void setVarVar5(boolean value) {
		getDefaultInterface().setVarVar5(value);
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
		getDefaultInterfaceImpl().setVarVar1(6);
		getDefaultInterfaceImpl().setVarVar2(123);
		getDefaultInterfaceImpl().setVarVar3(19.4);
		getDefaultInterfaceImpl().setVarVar4(43.3);
		getDefaultInterfaceImpl().setVarVar5(false);
		getDefaultInterfaceImpl()
				.setVarVar3(
						getDefaultInterfaceImpl().getVarVar3()
								+ ((getDefaultInterfaceImpl().getVarVar2() * getDefaultInterfaceImpl()
										.getVarVar3())));

		nextStateIndex = 0;
		stateVector[0] = State.State1;

	}

	public void exit() {
		//Handle exit of all possible states (of mainRegion) at position 0...
		switch (stateVector[0]) {

			case State1 :
				stateVector[0] = State.$NullState$;
				getDefaultInterfaceImpl().setVarVar2(1);

				getDefaultInterfaceImpl().setVarVar4(22.3);

				break;

			case State2 :
				stateVector[0] = State.$NullState$;

				break;

			default :
				break;
		}

	}

	private void reactState1() {
		if ((occuredEvents.contains(getDefaultInterfaceImpl().getEventEvent1()) && ((getInterfaceOtherImpl()
				.getVarVar1() == true) || (getDefaultInterfaceImpl()
				.getVarVar5() == false)))) {
			stateVector[0] = State.$NullState$;
			getDefaultInterfaceImpl().setVarVar2(1);

			getDefaultInterfaceImpl().setVarVar4(22.3);

			getInterfaceOtherImpl().setVarVar1(false);

			getDefaultInterfaceImpl().setVarVar3(
					getDefaultInterfaceImpl().getVarVar3() / (5));

			getDefaultInterfaceImpl().setVarVar1(
					getDefaultInterfaceImpl().getVarVar1() + (1));

			nextStateIndex = 0;
			stateVector[0] = State.State2;

		}

	}
	private void reactState2() {
		if ((occuredEvents.contains(getDefaultInterfaceImpl().getEventEvent1()) && (getDefaultInterfaceImpl()
				.getVarVar3() > 0))) {
			stateVector[0] = State.$NullState$;

			getDefaultInterfaceImpl().setVarVar5(true);

			getDefaultInterfaceImpl()
					.setVarVar3(
							getDefaultInterfaceImpl().getVarVar3()
									+ ((getDefaultInterfaceImpl().getVarVar2() * getDefaultInterfaceImpl()
											.getVarVar3())));

			nextStateIndex = 0;
			stateVector[0] = State.State1;

		} else {
			getDefaultInterfaceImpl().setVarVar1(
					getDefaultInterfaceImpl().getVarVar1() + (1));

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
