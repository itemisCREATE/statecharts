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
import java.util.HashMap;
import java.util.Map;
import org.yakindu.sct.runtime.java.IGenericAccessStatemachine;
import org.yakindu.sct.runtime.java.IGenericAccessInterface;
import org.yakindu.sct.runtime.java.IStatemachine;
import org.yakindu.sct.runtime.java.NotificationSender;

public class Test_ParallelRegionsCycleBasedStatemachine
		extends
			NotificationSender
		implements
			IGenericAccessStatemachine,
			DefaultInterface,
			IStatemachine {

	public enum State {
		State1, State2, State3, State4, State5, State6, State9, State7, State8, $NullState$
	};

	protected Map<String, IGenericAccessInterface> interfaceMap;

	private final State[] stateVector = new State[3];

	private int nextStateIndex;

	private final EventVector<Event<? extends Enum<?>>> occuredEvents;

	private final Collection<Event<? extends Enum<?>>> outEvents;

	public Test_ParallelRegionsCycleBasedStatemachine() {
		occuredEvents = new EventVector<Event<? extends Enum<?>>>(14);
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
		for (int i = 0; i < 3; i++) {
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

	public void raiseEvent9() {
		getDefaultInterface().raiseEvent9();
	}

	public void raiseEvent10() {
		getDefaultInterface().raiseEvent10();
	}

	public void raiseEvent11() {
		getDefaultInterface().raiseEvent11();
	}

	public void raiseEvent12() {
		getDefaultInterface().raiseEvent12();
	}

	public void raiseEvent13() {
		getDefaultInterface().raiseEvent13();
	}

	public void raiseEvent14() {
		getDefaultInterface().raiseEvent14();
	}

	public int getVarReg3() {
		return getDefaultInterface().getVarReg3();
	}

	public void setVarReg3(int value) {
		getDefaultInterface().setVarReg3(value);
	}
	public int getVarHierarchy() {
		return getDefaultInterface().getVarHierarchy();
	}

	public void setVarHierarchy(int value) {
		getDefaultInterface().setVarHierarchy(value);
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
		getDefaultInterfaceImpl().setVarReg3(-(1));
		nextStateIndex = 0;
		stateVector[0] = State.State1;

	}

	public void exit() {
		//Handle exit of all possible states (of mainRegion) at position 0...
		switch (stateVector[0]) {

			case State1 :
				stateVector[0] = State.$NullState$;
				getDefaultInterfaceImpl().setVarHierarchy(2);

				break;

			case State3 :
				stateVector[0] = State.$NullState$;

				break;

			case State5 :
				stateVector[0] = State.$NullState$;
				getDefaultInterfaceImpl().setVarHierarchy(
						getDefaultInterfaceImpl().getVarHierarchy() - (5));

				break;

			case State6 :
				stateVector[0] = State.$NullState$;
				getDefaultInterfaceImpl().setVarHierarchy(
						getDefaultInterfaceImpl().getVarHierarchy() - (6));

				break;

			default :
				break;
		}
		//Handle exit of all possible states (of mainRegion) at position 1...
		switch (stateVector[1]) {

			case State9 :
				stateVector[1] = State.$NullState$;
				getDefaultInterfaceImpl().setVarHierarchy(
						getDefaultInterfaceImpl().getVarHierarchy() - (10));

				getDefaultInterfaceImpl().setVarHierarchy(
						getDefaultInterfaceImpl().getVarHierarchy() / (4));

				break;

			default :
				break;
		}
		//Handle exit of all possible states (of mainRegion) at position 2...
		switch (stateVector[2]) {

			case State7 :
				stateVector[2] = State.$NullState$;
				getDefaultInterfaceImpl().setVarReg3(-(1));

				getDefaultInterfaceImpl().setVarHierarchy(
						getDefaultInterfaceImpl().getVarHierarchy() - (3));

				break;

			case State8 :
				stateVector[2] = State.$NullState$;
				getDefaultInterfaceImpl().setVarReg3(-(1));

				getDefaultInterfaceImpl().setVarHierarchy(
						getDefaultInterfaceImpl().getVarHierarchy() - (3));

				break;

			default :
				break;
		}

	}

	private void reactState1() {
		if (occuredEvents.contains(getDefaultInterfaceImpl().getEventEvent1())) {
			stateVector[0] = State.$NullState$;
			getDefaultInterfaceImpl().setVarHierarchy(2);

			getDefaultInterfaceImpl().setVarHierarchy(
					getDefaultInterfaceImpl().getVarHierarchy() + (3));

			nextStateIndex = 0;
			stateVector[0] = State.State3;

			getDefaultInterfaceImpl().setVarReg3(7);

			nextStateIndex = 2;
			stateVector[2] = State.State7;

		} else {
			if (occuredEvents.contains(getDefaultInterfaceImpl()
					.getEventEvent11())) {
				stateVector[0] = State.$NullState$;
				getDefaultInterfaceImpl().setVarHierarchy(2);

				getDefaultInterfaceImpl().setVarHierarchy(
						getDefaultInterfaceImpl().getVarHierarchy() + (3));

				getDefaultInterfaceImpl().setVarHierarchy(
						getDefaultInterfaceImpl().getVarHierarchy() * (4));

				getDefaultInterfaceImpl().setVarHierarchy(
						getDefaultInterfaceImpl().getVarHierarchy() + (6));

				nextStateIndex = 0;
				stateVector[0] = State.State6;

				getDefaultInterfaceImpl().setVarHierarchy(
						getDefaultInterfaceImpl().getVarHierarchy() + (10));

				nextStateIndex = 1;
				stateVector[1] = State.State9;

				getDefaultInterfaceImpl().setVarReg3(7);

				nextStateIndex = 2;
				stateVector[2] = State.State7;

			} else {
				if (occuredEvents.contains(getDefaultInterfaceImpl()
						.getEventEvent12())) {
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarHierarchy(2);

					getDefaultInterfaceImpl().setVarHierarchy(
							getDefaultInterfaceImpl().getVarHierarchy() + (3));

					nextStateIndex = 0;
					stateVector[0] = State.State3;

					getDefaultInterfaceImpl().setVarReg3(8);

					nextStateIndex = 2;
					stateVector[2] = State.State8;

				} else {
					if (occuredEvents.contains(getDefaultInterfaceImpl()
							.getEventEvent13())) {
						stateVector[0] = State.$NullState$;
						getDefaultInterfaceImpl().setVarHierarchy(2);

						getDefaultInterfaceImpl()
								.setVarHierarchy(
										getDefaultInterfaceImpl()
												.getVarHierarchy() + (3));

						getDefaultInterfaceImpl()
								.setVarHierarchy(
										getDefaultInterfaceImpl()
												.getVarHierarchy() * (4));

						getDefaultInterfaceImpl()
								.setVarHierarchy(
										getDefaultInterfaceImpl()
												.getVarHierarchy() + (5));

						nextStateIndex = 0;
						stateVector[0] = State.State5;

						getDefaultInterfaceImpl()
								.setVarHierarchy(
										getDefaultInterfaceImpl()
												.getVarHierarchy() + (10));

						nextStateIndex = 1;
						stateVector[1] = State.State9;

						getDefaultInterfaceImpl().setVarReg3(7);

						nextStateIndex = 2;
						stateVector[2] = State.State7;

					}
				}
			}
		}
	}
	private void reactState2() {
	}
	private void reactState3() {
		if (occuredEvents.contains(getDefaultInterfaceImpl().getEventEvent10())) {
			//Handle exit of all possible states (of Region1) at position 0...
			switch (stateVector[0]) {

				case State3 :
					stateVector[0] = State.$NullState$;

					break;

				case State5 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarHierarchy(
							getDefaultInterfaceImpl().getVarHierarchy() - (5));

					break;

				case State6 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarHierarchy(
							getDefaultInterfaceImpl().getVarHierarchy() - (6));

					break;

				default :
					break;
			}
			//Handle exit of all possible states (of Region1) at position 1...
			switch (stateVector[1]) {

				case State9 :
					stateVector[1] = State.$NullState$;
					getDefaultInterfaceImpl().setVarHierarchy(
							getDefaultInterfaceImpl().getVarHierarchy() - (10));

					getDefaultInterfaceImpl().setVarHierarchy(
							getDefaultInterfaceImpl().getVarHierarchy() / (4));

					break;

				default :
					break;
			}

			//Handle exit of all possible states (of Region3) at position 2...
			switch (stateVector[2]) {

				case State7 :
					stateVector[2] = State.$NullState$;
					getDefaultInterfaceImpl().setVarReg3(-(1));

					break;

				case State8 :
					stateVector[2] = State.$NullState$;
					getDefaultInterfaceImpl().setVarReg3(-(1));

					break;

				default :
					break;
			}

			getDefaultInterfaceImpl().setVarHierarchy(
					getDefaultInterfaceImpl().getVarHierarchy() - (3));

			nextStateIndex = 0;
			stateVector[0] = State.State1;

		} else {
			if (occuredEvents.contains(getDefaultInterfaceImpl()
					.getEventEvent2())) {
				stateVector[0] = State.$NullState$;

				getDefaultInterfaceImpl().setVarHierarchy(
						getDefaultInterfaceImpl().getVarHierarchy() * (4));

				getDefaultInterfaceImpl().setVarHierarchy(
						getDefaultInterfaceImpl().getVarHierarchy() + (5));

				nextStateIndex = 0;
				stateVector[0] = State.State5;

				getDefaultInterfaceImpl().setVarHierarchy(
						getDefaultInterfaceImpl().getVarHierarchy() + (10));

				nextStateIndex = 1;
				stateVector[1] = State.State9;

			} else {
				if ((occuredEvents.contains(getDefaultInterfaceImpl()
						.getEventEvent3()) || occuredEvents
						.contains(getDefaultInterfaceImpl().getEventEvent9()))) {
					//Handle exit of all possible states (of Region1) at position 0...
					switch (stateVector[0]) {

						case State3 :
							stateVector[0] = State.$NullState$;

							break;

						case State5 :
							stateVector[0] = State.$NullState$;
							getDefaultInterfaceImpl()
									.setVarHierarchy(
											getDefaultInterfaceImpl()
													.getVarHierarchy() - (5));

							break;

						case State6 :
							stateVector[0] = State.$NullState$;
							getDefaultInterfaceImpl()
									.setVarHierarchy(
											getDefaultInterfaceImpl()
													.getVarHierarchy() - (6));

							break;

						default :
							break;
					}
					//Handle exit of all possible states (of Region1) at position 1...
					switch (stateVector[1]) {

						case State9 :
							stateVector[1] = State.$NullState$;
							getDefaultInterfaceImpl()
									.setVarHierarchy(
											getDefaultInterfaceImpl()
													.getVarHierarchy() - (10));

							getDefaultInterfaceImpl()
									.setVarHierarchy(
											getDefaultInterfaceImpl()
													.getVarHierarchy() / (4));

							break;

						default :
							break;
					}

					//Handle exit of all possible states (of Region3) at position 2...
					switch (stateVector[2]) {

						case State7 :
							stateVector[2] = State.$NullState$;
							getDefaultInterfaceImpl().setVarReg3(-(1));

							break;

						case State8 :
							stateVector[2] = State.$NullState$;
							getDefaultInterfaceImpl().setVarReg3(-(1));

							break;

						default :
							break;
					}

					getDefaultInterfaceImpl().setVarHierarchy(
							getDefaultInterfaceImpl().getVarHierarchy() - (3));

					nextStateIndex = 0;
					stateVector[0] = State.State1;

				}
			}

		}
	}
	private void reactState4() {
	}
	private void reactState5() {
		if (occuredEvents.contains(getDefaultInterfaceImpl().getEventEvent10())) {
			//Handle exit of all possible states (of Region1) at position 0...
			switch (stateVector[0]) {

				case State3 :
					stateVector[0] = State.$NullState$;

					break;

				case State5 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarHierarchy(
							getDefaultInterfaceImpl().getVarHierarchy() - (5));

					break;

				case State6 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarHierarchy(
							getDefaultInterfaceImpl().getVarHierarchy() - (6));

					break;

				default :
					break;
			}
			//Handle exit of all possible states (of Region1) at position 1...
			switch (stateVector[1]) {

				case State9 :
					stateVector[1] = State.$NullState$;
					getDefaultInterfaceImpl().setVarHierarchy(
							getDefaultInterfaceImpl().getVarHierarchy() - (10));

					getDefaultInterfaceImpl().setVarHierarchy(
							getDefaultInterfaceImpl().getVarHierarchy() / (4));

					break;

				default :
					break;
			}

			//Handle exit of all possible states (of Region3) at position 2...
			switch (stateVector[2]) {

				case State7 :
					stateVector[2] = State.$NullState$;
					getDefaultInterfaceImpl().setVarReg3(-(1));

					break;

				case State8 :
					stateVector[2] = State.$NullState$;
					getDefaultInterfaceImpl().setVarReg3(-(1));

					break;

				default :
					break;
			}

			getDefaultInterfaceImpl().setVarHierarchy(
					getDefaultInterfaceImpl().getVarHierarchy() - (3));

			nextStateIndex = 0;
			stateVector[0] = State.State1;

		} else {
			if (occuredEvents.contains(getDefaultInterfaceImpl()
					.getEventEvent14())) {
				//Handle exit of all possible states (of Region1) at position 0...
				switch (stateVector[0]) {

					case State3 :
						stateVector[0] = State.$NullState$;

						break;

					case State5 :
						stateVector[0] = State.$NullState$;
						getDefaultInterfaceImpl()
								.setVarHierarchy(
										getDefaultInterfaceImpl()
												.getVarHierarchy() - (5));

						break;

					case State6 :
						stateVector[0] = State.$NullState$;
						getDefaultInterfaceImpl()
								.setVarHierarchy(
										getDefaultInterfaceImpl()
												.getVarHierarchy() - (6));

						break;

					default :
						break;
				}
				//Handle exit of all possible states (of Region1) at position 1...
				switch (stateVector[1]) {

					case State9 :
						stateVector[1] = State.$NullState$;
						getDefaultInterfaceImpl()
								.setVarHierarchy(
										getDefaultInterfaceImpl()
												.getVarHierarchy() - (10));

						getDefaultInterfaceImpl()
								.setVarHierarchy(
										getDefaultInterfaceImpl()
												.getVarHierarchy() / (4));

						break;

					default :
						break;
				}

				//Handle exit of all possible states (of Region3) at position 2...
				switch (stateVector[2]) {

					case State7 :
						stateVector[2] = State.$NullState$;
						getDefaultInterfaceImpl().setVarReg3(-(1));

						break;

					case State8 :
						stateVector[2] = State.$NullState$;
						getDefaultInterfaceImpl().setVarReg3(-(1));

						break;

					default :
						break;
				}

				getDefaultInterfaceImpl().setVarHierarchy(
						getDefaultInterfaceImpl().getVarHierarchy() - (3));

				nextStateIndex = 0;
				stateVector[0] = State.State1;

			} else {
				if (occuredEvents.contains(getDefaultInterfaceImpl()
						.getEventEvent3())) {
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarHierarchy(
							getDefaultInterfaceImpl().getVarHierarchy() - (5));

					getDefaultInterfaceImpl().setVarHierarchy(
							getDefaultInterfaceImpl().getVarHierarchy() + (6));

					nextStateIndex = 0;
					stateVector[0] = State.State6;

				}

			}

		}
	}
	private void reactState6() {
		if (occuredEvents.contains(getDefaultInterfaceImpl().getEventEvent10())) {
			//Handle exit of all possible states (of Region1) at position 0...
			switch (stateVector[0]) {

				case State3 :
					stateVector[0] = State.$NullState$;

					break;

				case State5 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarHierarchy(
							getDefaultInterfaceImpl().getVarHierarchy() - (5));

					break;

				case State6 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarHierarchy(
							getDefaultInterfaceImpl().getVarHierarchy() - (6));

					break;

				default :
					break;
			}
			//Handle exit of all possible states (of Region1) at position 1...
			switch (stateVector[1]) {

				case State9 :
					stateVector[1] = State.$NullState$;
					getDefaultInterfaceImpl().setVarHierarchy(
							getDefaultInterfaceImpl().getVarHierarchy() - (10));

					getDefaultInterfaceImpl().setVarHierarchy(
							getDefaultInterfaceImpl().getVarHierarchy() / (4));

					break;

				default :
					break;
			}

			//Handle exit of all possible states (of Region3) at position 2...
			switch (stateVector[2]) {

				case State7 :
					stateVector[2] = State.$NullState$;
					getDefaultInterfaceImpl().setVarReg3(-(1));

					break;

				case State8 :
					stateVector[2] = State.$NullState$;
					getDefaultInterfaceImpl().setVarReg3(-(1));

					break;

				default :
					break;
			}

			getDefaultInterfaceImpl().setVarHierarchy(
					getDefaultInterfaceImpl().getVarHierarchy() - (3));

			nextStateIndex = 0;
			stateVector[0] = State.State1;

		} else {
			if (occuredEvents.contains(getDefaultInterfaceImpl()
					.getEventEvent14())) {
				//Handle exit of all possible states (of Region1) at position 0...
				switch (stateVector[0]) {

					case State3 :
						stateVector[0] = State.$NullState$;

						break;

					case State5 :
						stateVector[0] = State.$NullState$;
						getDefaultInterfaceImpl()
								.setVarHierarchy(
										getDefaultInterfaceImpl()
												.getVarHierarchy() - (5));

						break;

					case State6 :
						stateVector[0] = State.$NullState$;
						getDefaultInterfaceImpl()
								.setVarHierarchy(
										getDefaultInterfaceImpl()
												.getVarHierarchy() - (6));

						break;

					default :
						break;
				}
				//Handle exit of all possible states (of Region1) at position 1...
				switch (stateVector[1]) {

					case State9 :
						stateVector[1] = State.$NullState$;
						getDefaultInterfaceImpl()
								.setVarHierarchy(
										getDefaultInterfaceImpl()
												.getVarHierarchy() - (10));

						getDefaultInterfaceImpl()
								.setVarHierarchy(
										getDefaultInterfaceImpl()
												.getVarHierarchy() / (4));

						break;

					default :
						break;
				}

				//Handle exit of all possible states (of Region3) at position 2...
				switch (stateVector[2]) {

					case State7 :
						stateVector[2] = State.$NullState$;
						getDefaultInterfaceImpl().setVarReg3(-(1));

						break;

					case State8 :
						stateVector[2] = State.$NullState$;
						getDefaultInterfaceImpl().setVarReg3(-(1));

						break;

					default :
						break;
				}

				getDefaultInterfaceImpl().setVarHierarchy(
						getDefaultInterfaceImpl().getVarHierarchy() - (3));

				nextStateIndex = 0;
				stateVector[0] = State.State1;

			} else {
				if (occuredEvents.contains(getDefaultInterfaceImpl()
						.getEventEvent4())) {
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarHierarchy(
							getDefaultInterfaceImpl().getVarHierarchy() - (6));

					getDefaultInterfaceImpl().setVarHierarchy(
							getDefaultInterfaceImpl().getVarHierarchy() + (5));

					nextStateIndex = 0;
					stateVector[0] = State.State5;

				}

			}

		}
	}
	private void reactState9() {
		if (occuredEvents.contains(getDefaultInterfaceImpl().getEventEvent10())) {
			//Handle exit of all possible states (of Region1) at position 0...
			switch (stateVector[0]) {

				case State3 :
					stateVector[0] = State.$NullState$;

					break;

				case State5 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarHierarchy(
							getDefaultInterfaceImpl().getVarHierarchy() - (5));

					break;

				case State6 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarHierarchy(
							getDefaultInterfaceImpl().getVarHierarchy() - (6));

					break;

				default :
					break;
			}
			//Handle exit of all possible states (of Region1) at position 1...
			switch (stateVector[1]) {

				case State9 :
					stateVector[1] = State.$NullState$;
					getDefaultInterfaceImpl().setVarHierarchy(
							getDefaultInterfaceImpl().getVarHierarchy() - (10));

					getDefaultInterfaceImpl().setVarHierarchy(
							getDefaultInterfaceImpl().getVarHierarchy() / (4));

					break;

				default :
					break;
			}

			//Handle exit of all possible states (of Region3) at position 2...
			switch (stateVector[2]) {

				case State7 :
					stateVector[2] = State.$NullState$;
					getDefaultInterfaceImpl().setVarReg3(-(1));

					break;

				case State8 :
					stateVector[2] = State.$NullState$;
					getDefaultInterfaceImpl().setVarReg3(-(1));

					break;

				default :
					break;
			}

			getDefaultInterfaceImpl().setVarHierarchy(
					getDefaultInterfaceImpl().getVarHierarchy() - (3));

			nextStateIndex = 0;
			stateVector[0] = State.State1;

		} else {
			if (occuredEvents.contains(getDefaultInterfaceImpl()
					.getEventEvent14())) {
				//Handle exit of all possible states (of Region1) at position 0...
				switch (stateVector[0]) {

					case State3 :
						stateVector[0] = State.$NullState$;

						break;

					case State5 :
						stateVector[0] = State.$NullState$;
						getDefaultInterfaceImpl()
								.setVarHierarchy(
										getDefaultInterfaceImpl()
												.getVarHierarchy() - (5));

						break;

					case State6 :
						stateVector[0] = State.$NullState$;
						getDefaultInterfaceImpl()
								.setVarHierarchy(
										getDefaultInterfaceImpl()
												.getVarHierarchy() - (6));

						break;

					default :
						break;
				}
				//Handle exit of all possible states (of Region1) at position 1...
				switch (stateVector[1]) {

					case State9 :
						stateVector[1] = State.$NullState$;
						getDefaultInterfaceImpl()
								.setVarHierarchy(
										getDefaultInterfaceImpl()
												.getVarHierarchy() - (10));

						getDefaultInterfaceImpl()
								.setVarHierarchy(
										getDefaultInterfaceImpl()
												.getVarHierarchy() / (4));

						break;

					default :
						break;
				}

				//Handle exit of all possible states (of Region3) at position 2...
				switch (stateVector[2]) {

					case State7 :
						stateVector[2] = State.$NullState$;
						getDefaultInterfaceImpl().setVarReg3(-(1));

						break;

					case State8 :
						stateVector[2] = State.$NullState$;
						getDefaultInterfaceImpl().setVarReg3(-(1));

						break;

					default :
						break;
				}

				getDefaultInterfaceImpl().setVarHierarchy(
						getDefaultInterfaceImpl().getVarHierarchy() - (3));

				nextStateIndex = 0;
				stateVector[0] = State.State1;

			} else {
				if (occuredEvents.contains(getDefaultInterfaceImpl()
						.getEventEvent8())) {
					//Handle exit of all possible states (of Region1) at position 0...
					switch (stateVector[0]) {

						case State3 :
							stateVector[0] = State.$NullState$;

							break;

						case State5 :
							stateVector[0] = State.$NullState$;
							getDefaultInterfaceImpl()
									.setVarHierarchy(
											getDefaultInterfaceImpl()
													.getVarHierarchy() - (5));

							break;

						case State6 :
							stateVector[0] = State.$NullState$;
							getDefaultInterfaceImpl()
									.setVarHierarchy(
											getDefaultInterfaceImpl()
													.getVarHierarchy() - (6));

							break;

						default :
							break;
					}
					//Handle exit of all possible states (of Region1) at position 1...
					switch (stateVector[1]) {

						case State9 :
							stateVector[1] = State.$NullState$;
							getDefaultInterfaceImpl()
									.setVarHierarchy(
											getDefaultInterfaceImpl()
													.getVarHierarchy() - (10));

							getDefaultInterfaceImpl()
									.setVarHierarchy(
											getDefaultInterfaceImpl()
													.getVarHierarchy() / (4));

							break;

						default :
							break;
					}

					//Handle exit of all possible states (of Region3) at position 2...
					switch (stateVector[2]) {

						case State7 :
							stateVector[2] = State.$NullState$;
							getDefaultInterfaceImpl().setVarReg3(-(1));

							break;

						case State8 :
							stateVector[2] = State.$NullState$;
							getDefaultInterfaceImpl().setVarReg3(-(1));

							break;

						default :
							break;
					}

					getDefaultInterfaceImpl().setVarHierarchy(
							getDefaultInterfaceImpl().getVarHierarchy() - (3));

					nextStateIndex = 0;
					stateVector[0] = State.State1;

				}

			}

		}
	}
	private void reactState7() {
		if (occuredEvents.contains(getDefaultInterfaceImpl().getEventEvent10())) {
			//Handle exit of all possible states (of Region1) at position 0...
			switch (stateVector[0]) {

				case State3 :
					stateVector[0] = State.$NullState$;

					break;

				case State5 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarHierarchy(
							getDefaultInterfaceImpl().getVarHierarchy() - (5));

					break;

				case State6 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarHierarchy(
							getDefaultInterfaceImpl().getVarHierarchy() - (6));

					break;

				default :
					break;
			}
			//Handle exit of all possible states (of Region1) at position 1...
			switch (stateVector[1]) {

				case State9 :
					stateVector[1] = State.$NullState$;
					getDefaultInterfaceImpl().setVarHierarchy(
							getDefaultInterfaceImpl().getVarHierarchy() - (10));

					getDefaultInterfaceImpl().setVarHierarchy(
							getDefaultInterfaceImpl().getVarHierarchy() / (4));

					break;

				default :
					break;
			}

			//Handle exit of all possible states (of Region3) at position 2...
			switch (stateVector[2]) {

				case State7 :
					stateVector[2] = State.$NullState$;
					getDefaultInterfaceImpl().setVarReg3(-(1));

					break;

				case State8 :
					stateVector[2] = State.$NullState$;
					getDefaultInterfaceImpl().setVarReg3(-(1));

					break;

				default :
					break;
			}

			getDefaultInterfaceImpl().setVarHierarchy(
					getDefaultInterfaceImpl().getVarHierarchy() - (3));

			nextStateIndex = 0;
			stateVector[0] = State.State1;

		} else {
			if ((occuredEvents.contains(getDefaultInterfaceImpl()
					.getEventEvent5()) || occuredEvents
					.contains(getDefaultInterfaceImpl().getEventEvent3()))) {
				stateVector[2] = State.$NullState$;
				getDefaultInterfaceImpl().setVarReg3(-(1));

				getDefaultInterfaceImpl().setVarReg3(8);

				nextStateIndex = 2;
				stateVector[2] = State.State8;

			} else {
				if (occuredEvents.contains(getDefaultInterfaceImpl()
						.getEventEvent7())) {
					//Handle exit of all possible states (of Region1) at position 0...
					switch (stateVector[0]) {

						case State3 :
							stateVector[0] = State.$NullState$;

							break;

						case State5 :
							stateVector[0] = State.$NullState$;
							getDefaultInterfaceImpl()
									.setVarHierarchy(
											getDefaultInterfaceImpl()
													.getVarHierarchy() - (5));

							break;

						case State6 :
							stateVector[0] = State.$NullState$;
							getDefaultInterfaceImpl()
									.setVarHierarchy(
											getDefaultInterfaceImpl()
													.getVarHierarchy() - (6));

							break;

						default :
							break;
					}
					//Handle exit of all possible states (of Region1) at position 1...
					switch (stateVector[1]) {

						case State9 :
							stateVector[1] = State.$NullState$;
							getDefaultInterfaceImpl()
									.setVarHierarchy(
											getDefaultInterfaceImpl()
													.getVarHierarchy() - (10));

							getDefaultInterfaceImpl()
									.setVarHierarchy(
											getDefaultInterfaceImpl()
													.getVarHierarchy() / (4));

							break;

						default :
							break;
					}

					//Handle exit of all possible states (of Region3) at position 2...
					switch (stateVector[2]) {

						case State7 :
							stateVector[2] = State.$NullState$;
							getDefaultInterfaceImpl().setVarReg3(-(1));

							break;

						case State8 :
							stateVector[2] = State.$NullState$;
							getDefaultInterfaceImpl().setVarReg3(-(1));

							break;

						default :
							break;
					}

					getDefaultInterfaceImpl().setVarHierarchy(
							getDefaultInterfaceImpl().getVarHierarchy() - (3));

					nextStateIndex = 0;
					stateVector[0] = State.State1;

				}
			}

		}
	}
	private void reactState8() {
		if (occuredEvents.contains(getDefaultInterfaceImpl().getEventEvent10())) {
			//Handle exit of all possible states (of Region1) at position 0...
			switch (stateVector[0]) {

				case State3 :
					stateVector[0] = State.$NullState$;

					break;

				case State5 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarHierarchy(
							getDefaultInterfaceImpl().getVarHierarchy() - (5));

					break;

				case State6 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarHierarchy(
							getDefaultInterfaceImpl().getVarHierarchy() - (6));

					break;

				default :
					break;
			}
			//Handle exit of all possible states (of Region1) at position 1...
			switch (stateVector[1]) {

				case State9 :
					stateVector[1] = State.$NullState$;
					getDefaultInterfaceImpl().setVarHierarchy(
							getDefaultInterfaceImpl().getVarHierarchy() - (10));

					getDefaultInterfaceImpl().setVarHierarchy(
							getDefaultInterfaceImpl().getVarHierarchy() / (4));

					break;

				default :
					break;
			}

			//Handle exit of all possible states (of Region3) at position 2...
			switch (stateVector[2]) {

				case State7 :
					stateVector[2] = State.$NullState$;
					getDefaultInterfaceImpl().setVarReg3(-(1));

					break;

				case State8 :
					stateVector[2] = State.$NullState$;
					getDefaultInterfaceImpl().setVarReg3(-(1));

					break;

				default :
					break;
			}

			getDefaultInterfaceImpl().setVarHierarchy(
					getDefaultInterfaceImpl().getVarHierarchy() - (3));

			nextStateIndex = 0;
			stateVector[0] = State.State1;

		} else {
			if (occuredEvents.contains(getDefaultInterfaceImpl()
					.getEventEvent6())) {
				stateVector[2] = State.$NullState$;
				getDefaultInterfaceImpl().setVarReg3(-(1));

				getDefaultInterfaceImpl().setVarReg3(7);

				nextStateIndex = 2;
				stateVector[2] = State.State7;

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
					// $NullState$
			}
		}

		occuredEvents.clear();
	}
}
