/**
Copyright (c) 2011 committers of YAKINDU and others. 
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html
 
Contributors:
	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.runtime.java.test_hierarchy;

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

public class Test_HierarchyCycleBasedStatemachine extends NotificationSender
		implements
			IGenericAccessStatemachine,
			DefaultInterface,
			IStatemachine {

	public enum State {
		State1, State9, State10, State2, State3, State4, State5, State6, State7, State8, $NullState$
	};

	protected Map<String, IGenericAccessInterface> interfaceMap;

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	private final EventVector<Event<? extends Enum<?>>> occuredEvents;

	private final Collection<Event<? extends Enum<?>>> outEvents;

	public Test_HierarchyCycleBasedStatemachine() {
		occuredEvents = new EventVector<Event<? extends Enum<?>>>(16);
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

	public void raiseEvent15() {
		getDefaultInterface().raiseEvent15();
	}

	public void raiseEvent16() {
		getDefaultInterface().raiseEvent16();
	}

	public int getVarS1() {
		return getDefaultInterface().getVarS1();
	}

	public void setVarS1(int value) {
		getDefaultInterface().setVarS1(value);
	}
	public int getVarS2() {
		return getDefaultInterface().getVarS2();
	}

	public void setVarS2(int value) {
		getDefaultInterface().setVarS2(value);
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
		getDefaultInterfaceImpl().setVarS1(0);
		getDefaultInterfaceImpl().setVarS1(1);

		getDefaultInterfaceImpl().setVarS1(
				getDefaultInterfaceImpl().getVarS1() + (1));

		nextStateIndex = 0;
		stateVector[0] = State.State9;

	}

	public void exit() {
		//Handle exit of all possible states (of mainRegion) at position 0...
		switch (stateVector[0]) {

			case State9 :
				stateVector[0] = State.$NullState$;
				getDefaultInterfaceImpl().setVarS1(
						getDefaultInterfaceImpl().getVarS1() - (1));

				getDefaultInterfaceImpl().setVarS1(
						getDefaultInterfaceImpl().getVarS1() - (1));

				break;

			case State10 :
				stateVector[0] = State.$NullState$;
				getDefaultInterfaceImpl().setVarS1(
						getDefaultInterfaceImpl().getVarS1() - (1));

				getDefaultInterfaceImpl().setVarS1(
						getDefaultInterfaceImpl().getVarS1() - (1));

				break;

			case State3 :
				stateVector[0] = State.$NullState$;
				getDefaultInterfaceImpl().setVarS2(
						getDefaultInterfaceImpl().getVarS2() - (1));

				getDefaultInterfaceImpl().setVarS2(
						getDefaultInterfaceImpl().getVarS2() - (1));

				break;

			case State5 :
				stateVector[0] = State.$NullState$;
				getDefaultInterfaceImpl().setVarS2(
						getDefaultInterfaceImpl().getVarS2() - (1));

				getDefaultInterfaceImpl().setVarS2(
						getDefaultInterfaceImpl().getVarS2() - (1));

				getDefaultInterfaceImpl().setVarS2(
						getDefaultInterfaceImpl().getVarS2() - (1));

				break;

			case State7 :
				stateVector[0] = State.$NullState$;
				getDefaultInterfaceImpl().setVarS2(
						getDefaultInterfaceImpl().getVarS2() - (1));

				getDefaultInterfaceImpl().setVarS2(
						getDefaultInterfaceImpl().getVarS2() - (1));

				getDefaultInterfaceImpl().setVarS2(
						getDefaultInterfaceImpl().getVarS2() - (1));

				getDefaultInterfaceImpl().setVarS2(
						getDefaultInterfaceImpl().getVarS2() - (1));

				break;

			case State8 :
				stateVector[0] = State.$NullState$;
				getDefaultInterfaceImpl().setVarS2(
						getDefaultInterfaceImpl().getVarS2() - (1));

				getDefaultInterfaceImpl().setVarS2(
						getDefaultInterfaceImpl().getVarS2() - (1));

				getDefaultInterfaceImpl().setVarS2(
						getDefaultInterfaceImpl().getVarS2() - (1));

				getDefaultInterfaceImpl().setVarS2(
						getDefaultInterfaceImpl().getVarS2() - (1));

				break;

			default :
				break;
		}

	}

	private void reactState1() {
	}
	private void reactState9() {
		if (occuredEvents.contains(getDefaultInterfaceImpl().getEventEvent1())) {
			//Handle exit of all possible states (of Region1) at position 0...
			switch (stateVector[0]) {

				case State9 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarS1(
							getDefaultInterfaceImpl().getVarS1() - (1));

					break;

				case State10 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarS1(
							getDefaultInterfaceImpl().getVarS1() - (1));

					break;

				default :
					break;
			}

			getDefaultInterfaceImpl().setVarS1(
					getDefaultInterfaceImpl().getVarS1() - (1));

			getDefaultInterfaceImpl().setVarS2(1);

			getDefaultInterfaceImpl().setVarS2(
					getDefaultInterfaceImpl().getVarS2() + (1));

			nextStateIndex = 0;
			stateVector[0] = State.State3;

		} else {
			if (occuredEvents.contains(getDefaultInterfaceImpl()
					.getEventEvent9())) {
				stateVector[0] = State.$NullState$;
				getDefaultInterfaceImpl().setVarS1(
						getDefaultInterfaceImpl().getVarS1() - (1));

				getDefaultInterfaceImpl().setVarS1(
						getDefaultInterfaceImpl().getVarS1() + (1));

				nextStateIndex = 0;
				stateVector[0] = State.State10;

			}

		}

	}
	private void reactState10() {
		if (occuredEvents.contains(getDefaultInterfaceImpl().getEventEvent1())) {
			//Handle exit of all possible states (of Region1) at position 0...
			switch (stateVector[0]) {

				case State9 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarS1(
							getDefaultInterfaceImpl().getVarS1() - (1));

					break;

				case State10 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarS1(
							getDefaultInterfaceImpl().getVarS1() - (1));

					break;

				default :
					break;
			}

			getDefaultInterfaceImpl().setVarS1(
					getDefaultInterfaceImpl().getVarS1() - (1));

			getDefaultInterfaceImpl().setVarS2(1);

			getDefaultInterfaceImpl().setVarS2(
					getDefaultInterfaceImpl().getVarS2() + (1));

			nextStateIndex = 0;
			stateVector[0] = State.State3;

		} else {
			if (occuredEvents.contains(getDefaultInterfaceImpl()
					.getEventEvent10())) {
				stateVector[0] = State.$NullState$;
				getDefaultInterfaceImpl().setVarS1(
						getDefaultInterfaceImpl().getVarS1() - (1));

				getDefaultInterfaceImpl().setVarS1(
						getDefaultInterfaceImpl().getVarS1() + (1));

				nextStateIndex = 0;
				stateVector[0] = State.State9;

			}

		}

	}
	private void reactState2() {
	}
	private void reactState3() {
		if (occuredEvents.contains(getDefaultInterfaceImpl().getEventEvent6())) {
			//Handle exit of all possible states (of Region2) at position 0...
			switch (stateVector[0]) {

				case State3 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					break;

				case State5 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					break;

				case State7 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					break;

				case State8 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					break;

				default :
					break;
			}

			getDefaultInterfaceImpl().setVarS2(
					getDefaultInterfaceImpl().getVarS2() - (1));

			getDefaultInterfaceImpl().setVarS1(1);

			getDefaultInterfaceImpl().setVarS1(
					getDefaultInterfaceImpl().getVarS1() + (1));

			nextStateIndex = 0;
			stateVector[0] = State.State9;

		} else {
			if (occuredEvents.contains(getDefaultInterfaceImpl()
					.getEventEvent2())) {
				stateVector[0] = State.$NullState$;
				getDefaultInterfaceImpl().setVarS2(
						getDefaultInterfaceImpl().getVarS2() - (1));

				getDefaultInterfaceImpl().setVarS2(
						getDefaultInterfaceImpl().getVarS2() + (1));

				getDefaultInterfaceImpl().setVarS2(
						getDefaultInterfaceImpl().getVarS2() + (1));

				nextStateIndex = 0;
				stateVector[0] = State.State5;

			} else {
				if (occuredEvents.contains(getDefaultInterfaceImpl()
						.getEventEvent11())) {
					//Handle exit of all possible states (of Region2) at position 0...
					switch (stateVector[0]) {

						case State3 :
							stateVector[0] = State.$NullState$;
							getDefaultInterfaceImpl().setVarS2(
									getDefaultInterfaceImpl().getVarS2() - (1));

							break;

						case State5 :
							stateVector[0] = State.$NullState$;
							getDefaultInterfaceImpl().setVarS2(
									getDefaultInterfaceImpl().getVarS2() - (1));

							getDefaultInterfaceImpl().setVarS2(
									getDefaultInterfaceImpl().getVarS2() - (1));

							break;

						case State7 :
							stateVector[0] = State.$NullState$;
							getDefaultInterfaceImpl().setVarS2(
									getDefaultInterfaceImpl().getVarS2() - (1));

							getDefaultInterfaceImpl().setVarS2(
									getDefaultInterfaceImpl().getVarS2() - (1));

							getDefaultInterfaceImpl().setVarS2(
									getDefaultInterfaceImpl().getVarS2() - (1));

							break;

						case State8 :
							stateVector[0] = State.$NullState$;
							getDefaultInterfaceImpl().setVarS2(
									getDefaultInterfaceImpl().getVarS2() - (1));

							getDefaultInterfaceImpl().setVarS2(
									getDefaultInterfaceImpl().getVarS2() - (1));

							getDefaultInterfaceImpl().setVarS2(
									getDefaultInterfaceImpl().getVarS2() - (1));

							break;

						default :
							break;
					}

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS1(1);

					getDefaultInterfaceImpl().setVarS1(
							getDefaultInterfaceImpl().getVarS1() + (1));

					nextStateIndex = 0;
					stateVector[0] = State.State9;

				} else {
					if (occuredEvents.contains(getDefaultInterfaceImpl()
							.getEventEvent14())) {
						//Handle exit of all possible states (of Region2) at position 0...
						switch (stateVector[0]) {

							case State3 :
								stateVector[0] = State.$NullState$;
								getDefaultInterfaceImpl()
										.setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

								break;

							case State5 :
								stateVector[0] = State.$NullState$;
								getDefaultInterfaceImpl()
										.setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

								getDefaultInterfaceImpl()
										.setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

								break;

							case State7 :
								stateVector[0] = State.$NullState$;
								getDefaultInterfaceImpl()
										.setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

								getDefaultInterfaceImpl()
										.setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

								getDefaultInterfaceImpl()
										.setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

								break;

							case State8 :
								stateVector[0] = State.$NullState$;
								getDefaultInterfaceImpl()
										.setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

								getDefaultInterfaceImpl()
										.setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

								getDefaultInterfaceImpl()
										.setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

								break;

							default :
								break;
						}

						getDefaultInterfaceImpl().setVarS2(
								getDefaultInterfaceImpl().getVarS2() - (1));

						getDefaultInterfaceImpl().setVarS1(1);

						getDefaultInterfaceImpl().setVarS1(
								getDefaultInterfaceImpl().getVarS1() + (1));

						nextStateIndex = 0;
						stateVector[0] = State.State9;

					}
				}
			}

		}

	}
	private void reactState4() {
	}
	private void reactState5() {
		if (occuredEvents.contains(getDefaultInterfaceImpl().getEventEvent6())) {
			//Handle exit of all possible states (of Region2) at position 0...
			switch (stateVector[0]) {

				case State3 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					break;

				case State5 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					break;

				case State7 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					break;

				case State8 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					break;

				default :
					break;
			}

			getDefaultInterfaceImpl().setVarS2(
					getDefaultInterfaceImpl().getVarS2() - (1));

			getDefaultInterfaceImpl().setVarS1(1);

			getDefaultInterfaceImpl().setVarS1(
					getDefaultInterfaceImpl().getVarS1() + (1));

			nextStateIndex = 0;
			stateVector[0] = State.State9;

		} else {
			if (occuredEvents.contains(getDefaultInterfaceImpl()
					.getEventEvent7())) {
				//Handle exit of all possible states (of Region4) at position 0...
				switch (stateVector[0]) {

					case State5 :
						stateVector[0] = State.$NullState$;
						getDefaultInterfaceImpl().setVarS2(
								getDefaultInterfaceImpl().getVarS2() - (1));

						break;

					case State7 :
						stateVector[0] = State.$NullState$;
						getDefaultInterfaceImpl().setVarS2(
								getDefaultInterfaceImpl().getVarS2() - (1));

						getDefaultInterfaceImpl().setVarS2(
								getDefaultInterfaceImpl().getVarS2() - (1));

						break;

					case State8 :
						stateVector[0] = State.$NullState$;
						getDefaultInterfaceImpl().setVarS2(
								getDefaultInterfaceImpl().getVarS2() - (1));

						getDefaultInterfaceImpl().setVarS2(
								getDefaultInterfaceImpl().getVarS2() - (1));

						break;

					default :
						break;
				}

				getDefaultInterfaceImpl().setVarS2(
						getDefaultInterfaceImpl().getVarS2() - (1));

				getDefaultInterfaceImpl().setVarS2(
						getDefaultInterfaceImpl().getVarS2() + (1));

				nextStateIndex = 0;
				stateVector[0] = State.State3;

			} else {
				if (occuredEvents.contains(getDefaultInterfaceImpl()
						.getEventEvent3())) {
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() + (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() + (1));

					nextStateIndex = 0;
					stateVector[0] = State.State7;

				} else {
					if (occuredEvents.contains(getDefaultInterfaceImpl()
							.getEventEvent12())) {
						//Handle exit of all possible states (of Region2) at position 0...
						switch (stateVector[0]) {

							case State3 :
								stateVector[0] = State.$NullState$;
								getDefaultInterfaceImpl()
										.setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

								break;

							case State5 :
								stateVector[0] = State.$NullState$;
								getDefaultInterfaceImpl()
										.setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

								getDefaultInterfaceImpl()
										.setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

								break;

							case State7 :
								stateVector[0] = State.$NullState$;
								getDefaultInterfaceImpl()
										.setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

								getDefaultInterfaceImpl()
										.setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

								getDefaultInterfaceImpl()
										.setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

								break;

							case State8 :
								stateVector[0] = State.$NullState$;
								getDefaultInterfaceImpl()
										.setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

								getDefaultInterfaceImpl()
										.setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

								getDefaultInterfaceImpl()
										.setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

								break;

							default :
								break;
						}

						getDefaultInterfaceImpl().setVarS2(
								getDefaultInterfaceImpl().getVarS2() - (1));

						getDefaultInterfaceImpl().setVarS1(1);

						getDefaultInterfaceImpl().setVarS1(
								getDefaultInterfaceImpl().getVarS1() + (1));

						nextStateIndex = 0;
						stateVector[0] = State.State9;

					} else {
						if (occuredEvents.contains(getDefaultInterfaceImpl()
								.getEventEvent15())) {
							//Handle exit of all possible states (of Region2) at position 0...
							switch (stateVector[0]) {

								case State3 :
									stateVector[0] = State.$NullState$;
									getDefaultInterfaceImpl().setVarS2(
											getDefaultInterfaceImpl()
													.getVarS2() - (1));

									break;

								case State5 :
									stateVector[0] = State.$NullState$;
									getDefaultInterfaceImpl().setVarS2(
											getDefaultInterfaceImpl()
													.getVarS2() - (1));

									getDefaultInterfaceImpl().setVarS2(
											getDefaultInterfaceImpl()
													.getVarS2() - (1));

									break;

								case State7 :
									stateVector[0] = State.$NullState$;
									getDefaultInterfaceImpl().setVarS2(
											getDefaultInterfaceImpl()
													.getVarS2() - (1));

									getDefaultInterfaceImpl().setVarS2(
											getDefaultInterfaceImpl()
													.getVarS2() - (1));

									getDefaultInterfaceImpl().setVarS2(
											getDefaultInterfaceImpl()
													.getVarS2() - (1));

									break;

								case State8 :
									stateVector[0] = State.$NullState$;
									getDefaultInterfaceImpl().setVarS2(
											getDefaultInterfaceImpl()
													.getVarS2() - (1));

									getDefaultInterfaceImpl().setVarS2(
											getDefaultInterfaceImpl()
													.getVarS2() - (1));

									getDefaultInterfaceImpl().setVarS2(
											getDefaultInterfaceImpl()
													.getVarS2() - (1));

									break;

								default :
									break;
							}

							getDefaultInterfaceImpl().setVarS2(
									getDefaultInterfaceImpl().getVarS2() - (1));

							getDefaultInterfaceImpl().setVarS1(1);

							getDefaultInterfaceImpl().setVarS1(
									getDefaultInterfaceImpl().getVarS1() + (1));

							nextStateIndex = 0;
							stateVector[0] = State.State10;

						}
					}
				}

			}

		}

	}
	private void reactState6() {
	}
	private void reactState7() {
		if (occuredEvents.contains(getDefaultInterfaceImpl().getEventEvent6())) {
			//Handle exit of all possible states (of Region2) at position 0...
			switch (stateVector[0]) {

				case State3 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					break;

				case State5 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					break;

				case State7 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					break;

				case State8 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					break;

				default :
					break;
			}

			getDefaultInterfaceImpl().setVarS2(
					getDefaultInterfaceImpl().getVarS2() - (1));

			getDefaultInterfaceImpl().setVarS1(1);

			getDefaultInterfaceImpl().setVarS1(
					getDefaultInterfaceImpl().getVarS1() + (1));

			nextStateIndex = 0;
			stateVector[0] = State.State9;

		} else {
			if (occuredEvents.contains(getDefaultInterfaceImpl()
					.getEventEvent7())) {
				//Handle exit of all possible states (of Region4) at position 0...
				switch (stateVector[0]) {

					case State5 :
						stateVector[0] = State.$NullState$;
						getDefaultInterfaceImpl().setVarS2(
								getDefaultInterfaceImpl().getVarS2() - (1));

						break;

					case State7 :
						stateVector[0] = State.$NullState$;
						getDefaultInterfaceImpl().setVarS2(
								getDefaultInterfaceImpl().getVarS2() - (1));

						getDefaultInterfaceImpl().setVarS2(
								getDefaultInterfaceImpl().getVarS2() - (1));

						break;

					case State8 :
						stateVector[0] = State.$NullState$;
						getDefaultInterfaceImpl().setVarS2(
								getDefaultInterfaceImpl().getVarS2() - (1));

						getDefaultInterfaceImpl().setVarS2(
								getDefaultInterfaceImpl().getVarS2() - (1));

						break;

					default :
						break;
				}

				getDefaultInterfaceImpl().setVarS2(
						getDefaultInterfaceImpl().getVarS2() - (1));

				getDefaultInterfaceImpl().setVarS2(
						getDefaultInterfaceImpl().getVarS2() + (1));

				nextStateIndex = 0;
				stateVector[0] = State.State3;

			} else {
				if (occuredEvents.contains(getDefaultInterfaceImpl()
						.getEventEvent8())) {
					//Handle exit of all possible states (of Region6) at position 0...
					switch (stateVector[0]) {

						case State7 :
							stateVector[0] = State.$NullState$;
							getDefaultInterfaceImpl().setVarS2(
									getDefaultInterfaceImpl().getVarS2() - (1));

							break;

						case State8 :
							stateVector[0] = State.$NullState$;
							getDefaultInterfaceImpl().setVarS2(
									getDefaultInterfaceImpl().getVarS2() - (1));

							break;

						default :
							break;
					}

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() + (1));

					nextStateIndex = 0;
					stateVector[0] = State.State5;

				} else {
					if (occuredEvents.contains(getDefaultInterfaceImpl()
							.getEventEvent4())) {
						stateVector[0] = State.$NullState$;
						getDefaultInterfaceImpl().setVarS2(
								getDefaultInterfaceImpl().getVarS2() - (1));

						getDefaultInterfaceImpl().setVarS2(
								getDefaultInterfaceImpl().getVarS2() + (1));

						nextStateIndex = 0;
						stateVector[0] = State.State8;

					}

				}

			}

		}

	}
	private void reactState8() {
		if (occuredEvents.contains(getDefaultInterfaceImpl().getEventEvent6())) {
			//Handle exit of all possible states (of Region2) at position 0...
			switch (stateVector[0]) {

				case State3 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					break;

				case State5 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					break;

				case State7 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					break;

				case State8 :
					stateVector[0] = State.$NullState$;
					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					break;

				default :
					break;
			}

			getDefaultInterfaceImpl().setVarS2(
					getDefaultInterfaceImpl().getVarS2() - (1));

			getDefaultInterfaceImpl().setVarS1(1);

			getDefaultInterfaceImpl().setVarS1(
					getDefaultInterfaceImpl().getVarS1() + (1));

			nextStateIndex = 0;
			stateVector[0] = State.State9;

		} else {
			if (occuredEvents.contains(getDefaultInterfaceImpl()
					.getEventEvent7())) {
				//Handle exit of all possible states (of Region4) at position 0...
				switch (stateVector[0]) {

					case State5 :
						stateVector[0] = State.$NullState$;
						getDefaultInterfaceImpl().setVarS2(
								getDefaultInterfaceImpl().getVarS2() - (1));

						break;

					case State7 :
						stateVector[0] = State.$NullState$;
						getDefaultInterfaceImpl().setVarS2(
								getDefaultInterfaceImpl().getVarS2() - (1));

						getDefaultInterfaceImpl().setVarS2(
								getDefaultInterfaceImpl().getVarS2() - (1));

						break;

					case State8 :
						stateVector[0] = State.$NullState$;
						getDefaultInterfaceImpl().setVarS2(
								getDefaultInterfaceImpl().getVarS2() - (1));

						getDefaultInterfaceImpl().setVarS2(
								getDefaultInterfaceImpl().getVarS2() - (1));

						break;

					default :
						break;
				}

				getDefaultInterfaceImpl().setVarS2(
						getDefaultInterfaceImpl().getVarS2() - (1));

				getDefaultInterfaceImpl().setVarS2(
						getDefaultInterfaceImpl().getVarS2() + (1));

				nextStateIndex = 0;
				stateVector[0] = State.State3;

			} else {
				if (occuredEvents.contains(getDefaultInterfaceImpl()
						.getEventEvent8())) {
					//Handle exit of all possible states (of Region6) at position 0...
					switch (stateVector[0]) {

						case State7 :
							stateVector[0] = State.$NullState$;
							getDefaultInterfaceImpl().setVarS2(
									getDefaultInterfaceImpl().getVarS2() - (1));

							break;

						case State8 :
							stateVector[0] = State.$NullState$;
							getDefaultInterfaceImpl().setVarS2(
									getDefaultInterfaceImpl().getVarS2() - (1));

							break;

						default :
							break;
					}

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() - (1));

					getDefaultInterfaceImpl().setVarS2(
							getDefaultInterfaceImpl().getVarS2() + (1));

					nextStateIndex = 0;
					stateVector[0] = State.State5;

				} else {
					if (occuredEvents.contains(getDefaultInterfaceImpl()
							.getEventEvent5())) {
						stateVector[0] = State.$NullState$;
						getDefaultInterfaceImpl().setVarS2(
								getDefaultInterfaceImpl().getVarS2() - (1));

						getDefaultInterfaceImpl().setVarS2(
								getDefaultInterfaceImpl().getVarS2() + (1));

						nextStateIndex = 0;
						stateVector[0] = State.State7;

					} else {
						if (occuredEvents.contains(getDefaultInterfaceImpl()
								.getEventEvent13())) {
							//Handle exit of all possible states (of Region2) at position 0...
							switch (stateVector[0]) {

								case State3 :
									stateVector[0] = State.$NullState$;
									getDefaultInterfaceImpl().setVarS2(
											getDefaultInterfaceImpl()
													.getVarS2() - (1));

									break;

								case State5 :
									stateVector[0] = State.$NullState$;
									getDefaultInterfaceImpl().setVarS2(
											getDefaultInterfaceImpl()
													.getVarS2() - (1));

									getDefaultInterfaceImpl().setVarS2(
											getDefaultInterfaceImpl()
													.getVarS2() - (1));

									break;

								case State7 :
									stateVector[0] = State.$NullState$;
									getDefaultInterfaceImpl().setVarS2(
											getDefaultInterfaceImpl()
													.getVarS2() - (1));

									getDefaultInterfaceImpl().setVarS2(
											getDefaultInterfaceImpl()
													.getVarS2() - (1));

									getDefaultInterfaceImpl().setVarS2(
											getDefaultInterfaceImpl()
													.getVarS2() - (1));

									break;

								case State8 :
									stateVector[0] = State.$NullState$;
									getDefaultInterfaceImpl().setVarS2(
											getDefaultInterfaceImpl()
													.getVarS2() - (1));

									getDefaultInterfaceImpl().setVarS2(
											getDefaultInterfaceImpl()
													.getVarS2() - (1));

									getDefaultInterfaceImpl().setVarS2(
											getDefaultInterfaceImpl()
													.getVarS2() - (1));

									break;

								default :
									break;
							}

							getDefaultInterfaceImpl().setVarS2(
									getDefaultInterfaceImpl().getVarS2() - (1));

							getDefaultInterfaceImpl().setVarS1(1);

							getDefaultInterfaceImpl().setVarS1(
									getDefaultInterfaceImpl().getVarS1() + (1));

							nextStateIndex = 0;
							stateVector[0] = State.State9;

						} else {
							if (occuredEvents
									.contains(getDefaultInterfaceImpl()
											.getEventEvent16())) {
								//Handle exit of all possible states (of Region2) at position 0...
								switch (stateVector[0]) {

									case State3 :
										stateVector[0] = State.$NullState$;
										getDefaultInterfaceImpl().setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

										break;

									case State5 :
										stateVector[0] = State.$NullState$;
										getDefaultInterfaceImpl().setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

										getDefaultInterfaceImpl().setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

										break;

									case State7 :
										stateVector[0] = State.$NullState$;
										getDefaultInterfaceImpl().setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

										getDefaultInterfaceImpl().setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

										getDefaultInterfaceImpl().setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

										break;

									case State8 :
										stateVector[0] = State.$NullState$;
										getDefaultInterfaceImpl().setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

										getDefaultInterfaceImpl().setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

										getDefaultInterfaceImpl().setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

										break;

									default :
										break;
								}

								getDefaultInterfaceImpl()
										.setVarS2(
												getDefaultInterfaceImpl()
														.getVarS2() - (1));

								getDefaultInterfaceImpl().setVarS1(1);

								getDefaultInterfaceImpl()
										.setVarS1(
												getDefaultInterfaceImpl()
														.getVarS1() + (1));

								nextStateIndex = 0;
								stateVector[0] = State.State10;

							}
						}
					}

				}

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
				case State9 :
					reactState9();
					break;
				case State10 :
					reactState10();
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
