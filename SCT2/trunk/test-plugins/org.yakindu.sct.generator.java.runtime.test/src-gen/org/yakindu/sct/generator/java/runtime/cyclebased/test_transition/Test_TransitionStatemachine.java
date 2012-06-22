package org.yakindu.sct.generator.java.runtime.cyclebased.test_transition;

import java.util.LinkedList;
import java.util.List;
import org.yakindu.sct.generator.java.runtime.cyclebased.TimeEvent;
import org.yakindu.sct.generator.java.runtime.cyclebased.ITimerService;

public class Test_TransitionStatemachine
		implements
			ITest_TransitionStatemachine {

	private final TimeEvent state1_time_event_0 = new TimeEvent(false, 0);
	private final TimeEvent state1_time_event_1 = new TimeEvent(false, 1);

	private final boolean[] timeEvents = new boolean[2];

	private final class SCIAImpl implements SCIA {

		private List<SCIAListener> listeners = new LinkedList<SCIAListener>();

		public List<SCIAListener> getListeners() {
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
			for (SCIAListener listener : listeners) {
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

	private SCIAImpl sCIA;

	private final class SCIDefaultImpl implements SCIDefault {

		private List<SCIDefaultListener> listeners = new LinkedList<SCIDefaultListener>();

		public List<SCIDefaultListener> getListeners() {
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
			for (SCIDefaultListener listener : listeners) {
				listener.onEvent7Raised();
			}
		}

		private int i;

		public int getI() {
			return i;
		}

		public void setI(int value) {
			this.i = value;
		}

		private double j;

		public double getJ() {
			return j;
		}

		public void setJ(double value) {
			this.j = value;
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

	private SCIDefaultImpl sCIDefault;

	public enum State {
		_region0_State1, _region0_State2, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	private ITimerService timerService;

	private long cycleStartTime;

	public Test_TransitionStatemachine() {

		sCIA = new SCIAImpl();
		sCIDefault = new SCIDefaultImpl();

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
		sCIA.clearEvents();
		sCIDefault.clearEvents();

		for (int i = 0; i < timeEvents.length; i++) {
			timeEvents[i] = false;
		}
	}

	protected void clearOutEvents() {
		sCIA.clearOutEvents();
		sCIDefault.clearOutEvents();
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

	public SCIA getSCIA() {
		return sCIA;
	}
	public SCIDefault getSCIDefault() {
		return sCIDefault;
	}

	public void raiseEvent5(boolean value) {
		sCIDefault.raiseEvent5(value);
	}

	public void raiseEvent6() {
		sCIDefault.raiseEvent6();
	}

	public boolean isRaisedEvent7() {
		return sCIDefault.isRaisedEvent7();
	}

	public int getI() {
		return sCIDefault.getI();
	}

	public void setI(int value) {
		sCIDefault.setI(value);
	}
	public double getJ() {
		return sCIDefault.getJ();
	}

	public void setJ(double value) {
		sCIDefault.setJ(value);
	}

	public void enter() {
		if (timerService == null) {
			throw new IllegalStateException("TimerService not set.");
		}
		cycleStartTime = System.currentTimeMillis();
		entryActionTest_Transition();
		getTimerService().setTimer(state1_time_event_0, (10 * 1000),
				cycleStartTime);
		getTimerService().setTimer(state1_time_event_1, 100, cycleStartTime);

		nextStateIndex = 0;
		stateVector[0] = State._region0_State1;

	}

	public void exit() {
		//Handle exit of all possible states (of region0) at position 0...
		switch (stateVector[0]) {

			case _region0_State1 :
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(state1_time_event_0);
				getTimerService().resetTimer(state1_time_event_1);

				break;

			case _region0_State2 :
				stateVector[0] = State.$NullState$;

				break;

			default :
				break;
		}

		exitActionTest_Transition();
	}

	private void entryActionTest_Transition() {

	}

	private void exitActionTest_Transition() {

	}

	private void react_region0_State1() {
		if (((sCIA.event1 || sCIA.event2) && (sCIA.event1Value < 0))) {
			stateVector[0] = State.$NullState$;
			getTimerService().resetTimer(state1_time_event_0);
			getTimerService().resetTimer(state1_time_event_1);

			sCIDefault.setI(2);

			nextStateIndex = 0;
			stateVector[0] = State._region0_State2;

		} else {
			if ((sCIDefault.getI() == 5)) {
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(state1_time_event_0);
				getTimerService().resetTimer(state1_time_event_1);

				nextStateIndex = 0;
				stateVector[0] = State._region0_State2;

			} else {
				if ((sCIA.event3 && (sCIDefault.getJ() < 20))) {
					stateVector[0] = State.$NullState$;
					getTimerService().resetTimer(state1_time_event_0);
					getTimerService().resetTimer(state1_time_event_1);

					nextStateIndex = 0;
					stateVector[0] = State._region0_State2;

				} else {
					if (((sCIA.event3 || sCIA.event4) && (sCIDefault.getJ() > 30))) {
						stateVector[0] = State.$NullState$;
						getTimerService().resetTimer(state1_time_event_0);
						getTimerService().resetTimer(state1_time_event_1);

						nextStateIndex = 0;
						stateVector[0] = State._region0_State2;

					} else {
						if (timeEvents[state1_time_event_0.getIndex()]) {
							stateVector[0] = State.$NullState$;
							getTimerService().resetTimer(state1_time_event_0);
							getTimerService().resetTimer(state1_time_event_1);

							nextStateIndex = 0;
							stateVector[0] = State._region0_State2;

						} else {
							if (timeEvents[state1_time_event_1.getIndex()]) {
								stateVector[0] = State.$NullState$;
								getTimerService().resetTimer(
										state1_time_event_0);
								getTimerService().resetTimer(
										state1_time_event_1);

								nextStateIndex = 0;
								stateVector[0] = State._region0_State2;

							} else {
								if ((sCIA.event1 && (sCIA.event1Value > 5))) {
									stateVector[0] = State.$NullState$;
									getTimerService().resetTimer(
											state1_time_event_0);
									getTimerService().resetTimer(
											state1_time_event_1);

									sCIDefault.setI(1);

									nextStateIndex = 0;
									stateVector[0] = State._region0_State2;

								}
							}
						}
					}
				}
			}
		}

	}
	private void react_region0_State2() {
		if (sCIDefault.event6) {
			stateVector[0] = State.$NullState$;

			getTimerService().setTimer(state1_time_event_0, (10 * 1000),
					cycleStartTime);
			getTimerService()
					.setTimer(state1_time_event_1, 100, cycleStartTime);

			nextStateIndex = 0;
			stateVector[0] = State._region0_State1;

		}

	}

	public void runCycle() {

		cycleStartTime = System.currentTimeMillis();

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case _region0_State1 :
					react_region0_State1();
					break;
				case _region0_State2 :
					react_region0_State2();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
