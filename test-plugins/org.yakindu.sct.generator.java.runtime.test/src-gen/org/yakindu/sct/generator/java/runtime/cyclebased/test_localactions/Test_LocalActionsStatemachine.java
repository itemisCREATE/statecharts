package org.yakindu.sct.generator.java.runtime.cyclebased.test_localactions;

import org.yakindu.sct.generator.java.runtime.cyclebased.TimeEvent;
import org.yakindu.sct.generator.java.runtime.cyclebased.ITimerService;

public class Test_LocalActionsStatemachine
		implements
			ITest_LocalActionsStatemachine {

	private final TimeEvent state1_time_event_0 = new TimeEvent(true, 0);
	private final TimeEvent state2_time_event_0 = new TimeEvent(false, 1);

	private final boolean[] timeEvents = new boolean[2];

	private final class SCIDefaultImpl implements SCIDefault {

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
			this.i = value;
		}

		private int j;

		public int getJ() {
			return j;
		}

		public void setJ(int value) {
			this.j = value;
		}

		private int c;

		public int getC() {
			return c;
		}

		public void setC(int value) {
			this.c = value;
		}

		public void clearEvents() {
			event1 = false;
			event2 = false;
			event3 = false;
			event4 = false;
		}

	}

	private SCIDefaultImpl sCIDefault;

	public enum State {
		MainRegion_State1, MainRegion_State2, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	private ITimerService timerService;

	private long cycleStartTime;

	public Test_LocalActionsStatemachine() {

		sCIDefault = new SCIDefaultImpl();

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
		sCIDefault.clearEvents();

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

	public SCIDefault getSCIDefault() {
		return sCIDefault;
	}

	public void raiseEvent1() {
		sCIDefault.raiseEvent1();
	}

	public void raiseEvent2() {
		sCIDefault.raiseEvent2();
	}

	public void raiseEvent3() {
		sCIDefault.raiseEvent3();
	}

	public void raiseEvent4() {
		sCIDefault.raiseEvent4();
	}

	public int getI() {
		return sCIDefault.getI();
	}

	public void setI(int value) {
		sCIDefault.setI(value);
	}
	public int getJ() {
		return sCIDefault.getJ();
	}

	public void setJ(int value) {
		sCIDefault.setJ(value);
	}
	public int getC() {
		return sCIDefault.getC();
	}

	public void setC(int value) {
		sCIDefault.setC(value);
	}

	public void enter() {
		if (timerService == null) {
			throw new IllegalStateException("TimerService not set.");
		}
		cycleStartTime = System.currentTimeMillis();

		// unknown function type org.yakindu.sct.model.sexec.impl.SequenceImpl@45ef4ff7 (name: entryAction) (comment: Entry action for statechart 'Test_LocalActions'.)();
		getTimerService().setTimer(state1_time_event_0, 100, cycleStartTime);
		sCIDefault.setI(1);

		nextStateIndex = 0;
		stateVector[0] = State.MainRegion_State1;

	}

	public void exit() {
		//Handle exit of all possible states (of mainRegion) at position 0...
		switch (stateVector[0]) {

			case MainRegion_State1 :
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(state1_time_event_0);
				sCIDefault.setI(0);

				break;

			case MainRegion_State2 :
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(state2_time_event_0);
				sCIDefault.setJ(0);

				break;

			default :
				break;
		}

		// unknown function type org.yakindu.sct.model.sexec.impl.SequenceImpl@4b8fe477 (name: exitAction) (comment: Exit action for state 'Test_LocalActions'.)();
	}

	private void reactMainRegion_State1() {
		if (sCIDefault.event1) {
			stateVector[0] = State.$NullState$;
			getTimerService().resetTimer(state1_time_event_0);
			sCIDefault.setI(0);

			getTimerService()
					.setTimer(state2_time_event_0, 200, cycleStartTime);
			sCIDefault.setJ(1);

			nextStateIndex = 0;
			stateVector[0] = State.MainRegion_State2;

		} else {
			sCIDefault.setI(2);

			if (sCIDefault.event2) {
				sCIDefault.setI(3);

			}
			if (timeEvents[state1_time_event_0.getIndex()]) {
				sCIDefault.setC(sCIDefault.getC() + (1));

			}

		}

	}
	private void reactMainRegion_State2() {
		if (sCIDefault.event3) {
			stateVector[0] = State.$NullState$;
			getTimerService().resetTimer(state2_time_event_0);
			sCIDefault.setJ(0);

			getTimerService()
					.setTimer(state1_time_event_0, 100, cycleStartTime);
			sCIDefault.setI(1);

			nextStateIndex = 0;
			stateVector[0] = State.MainRegion_State1;

		} else {
			if ((sCIDefault.event2 || sCIDefault.event4)) {
				sCIDefault.setJ(2);

			}
			if (timeEvents[state2_time_event_0.getIndex()]) {
				sCIDefault.setJ(3);

			}

		}

	}

	public void runCycle() {

		cycleStartTime = System.currentTimeMillis();

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case MainRegion_State1 :
					reactMainRegion_State1();
					break;
				case MainRegion_State2 :
					reactMainRegion_State2();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
