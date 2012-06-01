package org.yakindu.sct.generator.java.runtime.cyclebased.test_transition;

import java.util.LinkedList;
import java.util.List;
import org.yakindu.sct.generator.java.runtime.cyclebased.TimeEvent;
import org.yakindu.sct.generator.java.runtime.cyclebased.ITimerService;

public class Test_transitionStatemachine
		implements
			ITest_transitionStatemachine {

	private final TimeEvent state1_time_event_0 = new TimeEvent(false, 0);
	private final TimeEvent state1_time_event_1 = new TimeEvent(false, 1);

	private final boolean[] timeEvents = new boolean[2];

	private final class InterfaceAImpl implements InterfaceA {

		private List<InterfaceAListener> listeners = new LinkedList<InterfaceAListener>();

		public List<InterfaceAListener> getListeners() {
			return listeners;
		}

		private boolean event1;

		private int event1Value;

		public void raiseEvent1(int value) {
			event1 = true;
			event1Value = value;
		}

		private int getEvent1Value() {
			if (!event1)
				throw new IllegalStateException(
						"Illegal event value acces. Event Event1 is not raised!");
			return event1Value;
		}

		private boolean event2;

		public void raiseEvent2() {
			event2 = true;
		}

		private boolean event3;

		public void raiseEvent3() {
			event3 = true;
		}

		private boolean event4;

		public void raiseEvent4() {
			event4 = true;
		}

		private boolean event5;

		private boolean event5Out;

		public boolean isRaisedEvent5() {
			return event5Out;
		}

		private void raiseEvent5() {
			event5Out = true;
			event5 = true;
			for (InterfaceAListener listener : listeners) {
				listener.onEvent5Raised();
			}
		}

		public void clearEvents() {
			event1 = false;
			event2 = false;
			event3 = false;
			event4 = false;
			event5 = false;
		}

		public void clearOutEvents() {
			event5Out = false;
		}

	}

	private InterfaceAImpl interfaceA;

	private final class DefaultInterfaceImpl implements DefaultInterface {

		private List<DefaultInterfaceListener> listeners = new LinkedList<DefaultInterfaceListener>();

		public List<DefaultInterfaceListener> getListeners() {
			return listeners;
		}

		private boolean event5;

		private boolean event5Value;

		public void raiseEvent5(boolean value) {
			event5 = true;
			event5Value = value;
		}

		private boolean getEvent5Value() {
			if (!event5)
				throw new IllegalStateException(
						"Illegal event value acces. Event Event5 is not raised!");
			return event5Value;
		}

		private boolean event6;

		public void raiseEvent6() {
			event6 = true;
		}

		private boolean event7;

		private boolean event7Out;

		public boolean isRaisedEvent7() {
			return event7Out;
		}

		private void raiseEvent7() {
			event7Out = true;
			event7 = true;
			for (DefaultInterfaceListener listener : listeners) {
				listener.onEvent7Raised();
			}
		}

		private int i;

		public int getI() {
			return i;
		}

		public void setI(int value) {
			i = value;
		}

		private double j;

		public double getJ() {
			return j;
		}

		public void setJ(double value) {
			j = value;
		}

		public void clearEvents() {
			event5 = false;
			event6 = false;
			event7 = false;
		}

		public void clearOutEvents() {
			event7Out = false;
		}

	}

	private DefaultInterfaceImpl defaultInterface;

	public enum State {
		State1, State2, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	private ITimerService timerService;

	private long cycleStartTime;

	public Test_transitionStatemachine() {

		interfaceA = new InterfaceAImpl();
		defaultInterface = new DefaultInterfaceImpl();

		state1_time_event_0.setStatemachine(this);
		state1_time_event_1.setStatemachine(this);

	}

	public void init() {
		if (timerService == null) {
			throw new IllegalStateException("TimerService not set.");
		}
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();
	}

	protected void clearEvents() {
		interfaceA.clearEvents();
		defaultInterface.clearEvents();

		for (int i = 0; i < timeEvents.length; i++) {
			timeEvents[i] = false;
		}
	}

	protected void clearOutEvents() {
		interfaceA.clearOutEvents();
		defaultInterface.clearOutEvents();
	}

	public boolean isStateActive(State state) {
		for (int i = 0; i < stateVector.length; i++) {
			if (stateVector[i] == state) {
				return true;
			}
		}
		return false;
	}

	public void setTimerService(ITimerService timerService) {
		this.timerService = timerService;
	}

	public ITimerService getTimerService() {
		return timerService;
	}

	public void onTimeEventRaised(TimeEvent timeEvent) {
		timeEvents[timeEvent.getIndex()] = true;
	}

	public InterfaceA getInterfaceA() {
		return interfaceA;
	}
	public DefaultInterface getDefaultInterface() {
		return defaultInterface;
	}

	public void raiseEvent5(boolean value) {
		defaultInterface.raiseEvent5(value);
	}

	public void raiseEvent6() {
		defaultInterface.raiseEvent6();
	}

	public boolean isRaisedEvent7() {
		return defaultInterface.isRaisedEvent7();
	}

	public int getI() {
		return defaultInterface.getI();
	}

	public void setI(int value) {
		defaultInterface.setI(value);
	}
	public double getJ() {
		return defaultInterface.getJ();
	}

	public void setJ(double value) {
		defaultInterface.setJ(value);
	}

	public void enter() {
		if (timerService == null) {
			throw new IllegalStateException("TimerService not set.");
		}
		cycleStartTime = System.currentTimeMillis();

		// unknown function type org.yakindu.sct.model.sexec.impl.SequenceImpl@47df4d31 (name: entryAction) (comment: Entry action for statechart 'Test_Transition'.)();
		getTimerService().setTimer(state1_time_event_0, (10 * 1000),
				cycleStartTime);
		getTimerService().setTimer(state1_time_event_1, 100, cycleStartTime);

		nextStateIndex = 0;
		stateVector[0] = State.State1;

	}

	public void exit() {
		//Handle exit of all possible states (of region0) at position 0...
		switch (stateVector[0]) {

			case State1 :
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(state1_time_event_0);
				getTimerService().resetTimer(state1_time_event_1);

				break;

			case State2 :
				stateVector[0] = State.$NullState$;

				break;

			default :
				break;
		}

		// unknown function type org.yakindu.sct.model.sexec.impl.SequenceImpl@6a757be1 (name: exitAction) (comment: Exit action for state 'Test_Transition'.)();
	}

	private void reactState1() {
		if (((interfaceA.event1 || interfaceA.event2) && (interfaceA.event1Value < 0))) {
			stateVector[0] = State.$NullState$;
			getTimerService().resetTimer(state1_time_event_0);
			getTimerService().resetTimer(state1_time_event_1);

			defaultInterface.setI(2);

			nextStateIndex = 0;
			stateVector[0] = State.State2;

		} else {
			if ((defaultInterface.getI() == 5)) {
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(state1_time_event_0);
				getTimerService().resetTimer(state1_time_event_1);

				nextStateIndex = 0;
				stateVector[0] = State.State2;

			} else {
				if ((interfaceA.event3 && (defaultInterface.getJ() < 20))) {
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(state1_time_event_0);
					getTimerService().resetTimer(state1_time_event_1);

					nextStateIndex = 0;
					stateVector[0] = State.State2;

				} else {
					if (((interfaceA.event3 || interfaceA.event4) && (defaultInterface
							.getJ() > 30))) {
						stateVector[0] = State.$NullState$;
						getTimerService().resetTimer(state1_time_event_0);
						getTimerService().resetTimer(state1_time_event_1);

						nextStateIndex = 0;
						stateVector[0] = State.State2;

					} else {
						if (timeEvents[state1_time_event_0.getIndex()]) {
							stateVector[0] = State.$NullState$;
							getTimerService().resetTimer(state1_time_event_0);
							getTimerService().resetTimer(state1_time_event_1);

							nextStateIndex = 0;
							stateVector[0] = State.State2;

						} else {
							if (timeEvents[state1_time_event_1.getIndex()]) {
								stateVector[0] = State.$NullState$;
								getTimerService().resetTimer(
										state1_time_event_0);
								getTimerService().resetTimer(
										state1_time_event_1);

								nextStateIndex = 0;
								stateVector[0] = State.State2;

							} else {
								if ((interfaceA.event1 && (interfaceA.event1Value > 5))) {
									stateVector[0] = State.$NullState$;
									getTimerService().resetTimer(
											state1_time_event_0);
									getTimerService().resetTimer(
											state1_time_event_1);

									defaultInterface.setI(1);

									nextStateIndex = 0;
									stateVector[0] = State.State2;

								}
							}
						}
					}
				}
			}
		}

	}
	private void reactState2() {
		if (defaultInterface.event6) {
			stateVector[0] = State.$NullState$;

			getTimerService().setTimer(state1_time_event_0, (10 * 1000),
					cycleStartTime);
			getTimerService()
					.setTimer(state1_time_event_1, 100, cycleStartTime);

			nextStateIndex = 0;
			stateVector[0] = State.State1;

		}

	}

	public void runCycle() {

		cycleStartTime = System.currentTimeMillis();

		clearOutEvents();

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

		clearEvents();
	}
}
