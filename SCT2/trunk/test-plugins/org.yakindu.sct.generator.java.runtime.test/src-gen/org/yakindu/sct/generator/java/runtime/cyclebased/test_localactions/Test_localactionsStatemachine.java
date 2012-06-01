package org.yakindu.sct.generator.java.runtime.cyclebased.test_localactions;

import org.yakindu.sct.generator.java.runtime.cyclebased.TimeEvent;
import org.yakindu.sct.generator.java.runtime.cyclebased.ITimerService;

public class Test_localactionsStatemachine
		implements
			ITest_localactionsStatemachine {

	private final TimeEvent state1_time_event_0 = new TimeEvent(true, 0);
	private final TimeEvent state2_time_event_0 = new TimeEvent(false, 1);

	private final boolean[] timeEvents = new boolean[2];

	private final class DefaultInterfaceImpl implements DefaultInterface {

		private boolean event1;

		public void raiseEvent1() {
			event1 = true;
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

		private int i;

		public int getI() {
			return i;
		}

		public void setI(int value) {
			i = value;
		}

		private int j;

		public int getJ() {
			return j;
		}

		public void setJ(int value) {
			j = value;
		}

		private int c;

		public int getC() {
			return c;
		}

		public void setC(int value) {
			c = value;
		}

		public void clearEvents() {
			event1 = false;
			event2 = false;
			event3 = false;
			event4 = false;
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

	public Test_localactionsStatemachine() {

		defaultInterface = new DefaultInterfaceImpl();

		state1_time_event_0.setStatemachine(this);
		state2_time_event_0.setStatemachine(this);

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
		defaultInterface.clearEvents();

		for (int i = 0; i < timeEvents.length; i++) {
			timeEvents[i] = false;
		}
	}

	protected void clearOutEvents() {
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

	public DefaultInterface getDefaultInterface() {
		return defaultInterface;
	}

	public void raiseEvent1() {
		defaultInterface.raiseEvent1();
	}

	public void raiseEvent2() {
		defaultInterface.raiseEvent2();
	}

	public void raiseEvent3() {
		defaultInterface.raiseEvent3();
	}

	public void raiseEvent4() {
		defaultInterface.raiseEvent4();
	}

	public int getI() {
		return defaultInterface.getI();
	}

	public void setI(int value) {
		defaultInterface.setI(value);
	}
	public int getJ() {
		return defaultInterface.getJ();
	}

	public void setJ(int value) {
		defaultInterface.setJ(value);
	}
	public int getC() {
		return defaultInterface.getC();
	}

	public void setC(int value) {
		defaultInterface.setC(value);
	}

	public void enter() {
		if (timerService == null) {
			throw new IllegalStateException("TimerService not set.");
		}
		cycleStartTime = System.currentTimeMillis();

		// unknown function type org.yakindu.sct.model.sexec.impl.SequenceImpl@13965637 (name: entryAction) (comment: Entry action for statechart 'Test_LocalActions'.)();
		getTimerService().setTimer(state1_time_event_0, 100, cycleStartTime);
		defaultInterface.setI(1);

		nextStateIndex = 0;
		stateVector[0] = State.State1;

	}

	public void exit() {
		//Handle exit of all possible states (of mainRegion) at position 0...
		switch (stateVector[0]) {

			case State1 :
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(state1_time_event_0);
				defaultInterface.setI(0);

				break;

			case State2 :
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(state2_time_event_0);
				defaultInterface.setJ(0);

				break;

			default :
				break;
		}

		// unknown function type org.yakindu.sct.model.sexec.impl.SequenceImpl@3f3ab1c5 (name: exitAction) (comment: Exit action for state 'Test_LocalActions'.)();
	}

	private void reactState1() {
		if (defaultInterface.event1) {
			stateVector[0] = State.$NullState$;
			getTimerService().resetTimer(state1_time_event_0);
			defaultInterface.setI(0);

			getTimerService()
					.setTimer(state2_time_event_0, 200, cycleStartTime);
			defaultInterface.setJ(1);

			nextStateIndex = 0;
			stateVector[0] = State.State2;

		} else {
			defaultInterface.setI(2);

			if (defaultInterface.event2) {
				defaultInterface.setI(3);

			}
			if (timeEvents[state1_time_event_0.getIndex()]) {
				defaultInterface.setC(defaultInterface.getC() + (1));

			}

		}

	}
	private void reactState2() {
		if (defaultInterface.event3) {
			stateVector[0] = State.$NullState$;
			getTimerService().resetTimer(state2_time_event_0);
			defaultInterface.setJ(0);

			getTimerService()
					.setTimer(state1_time_event_0, 100, cycleStartTime);
			defaultInterface.setI(1);

			nextStateIndex = 0;
			stateVector[0] = State.State1;

		} else {
			if ((defaultInterface.event2 || defaultInterface.event4)) {
				defaultInterface.setJ(2);

			}
			if (timeEvents[state2_time_event_0.getIndex()]) {
				defaultInterface.setJ(3);

			}

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
