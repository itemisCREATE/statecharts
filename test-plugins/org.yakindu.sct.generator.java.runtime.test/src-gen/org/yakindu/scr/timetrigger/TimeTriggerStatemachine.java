package org.yakindu.scr.timetrigger;

import org.yakindu.scr.TimeEvent;
import org.yakindu.scr.ITimerService;

public class TimeTriggerStatemachine implements ITimeTriggerStatemachine {

	private final TimeEvent stateA_time_event_0 = new TimeEvent(false, 0);
	private final TimeEvent stateB_time_event_0 = new TimeEvent(true, 1);

	private final boolean[] timeEvents = new boolean[2];

	private final class SCIDefaultImpl implements SCIDefault {

		private int value;

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

	}

	private SCIDefaultImpl sCIDefault;

	public enum State {
		MainRegion_StateA, MainRegion_StateB, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	private ITimerService timerService;

	private long cycleStartTime;

	public TimeTriggerStatemachine() {

		sCIDefault = new SCIDefaultImpl();

		stateA_time_event_0.setStatemachine(this);
		stateB_time_event_0.setStatemachine(this);

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

	public int getValue() {
		return sCIDefault.getValue();
	}

	public void setValue(int value) {
		sCIDefault.setValue(value);
	}

	public void enter() {
		if (timerService == null) {
			throw new IllegalStateException("TimerService not set.");
		}
		cycleStartTime = System.currentTimeMillis();
		entryActionTimeTrigger();
		getTimerService().setTimer(stateA_time_event_0, 100, cycleStartTime);
		sCIDefault.setValue(0);

		nextStateIndex = 0;
		stateVector[0] = State.MainRegion_StateA;

	}

	public void exit() {
		//Handle exit of all possible states (of mainRegion) at position 0...
		switch (stateVector[0]) {

			case MainRegion_StateA :
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(stateA_time_event_0);

				break;

			case MainRegion_StateB :
				stateVector[0] = State.$NullState$;
				getTimerService().resetTimer(stateB_time_event_0);

				break;

			default :
				break;
		}

		exitActionTimeTrigger();
	}

	private void entryActionTimeTrigger() {

	}

	private void exitActionTimeTrigger() {

	}

	private void reactMainRegion_StateA() {
		if (timeEvents[stateA_time_event_0.getIndex()]) {
			stateVector[0] = State.$NullState$;
			getTimerService().resetTimer(stateA_time_event_0);

			getTimerService().setTimer(stateB_time_event_0, 20, cycleStartTime);

			nextStateIndex = 0;
			stateVector[0] = State.MainRegion_StateB;

		}

	}
	private void reactMainRegion_StateB() {
		if ((sCIDefault.getValue() == 10)) {
			stateVector[0] = State.$NullState$;
			getTimerService().resetTimer(stateB_time_event_0);

			getTimerService()
					.setTimer(stateA_time_event_0, 100, cycleStartTime);
			sCIDefault.setValue(0);

			nextStateIndex = 0;
			stateVector[0] = State.MainRegion_StateA;

		} else {
			if (timeEvents[stateB_time_event_0.getIndex()]) {
				sCIDefault.setValue(sCIDefault.getValue() + (1));

			}

		}

	}

	public void runCycle() {

		cycleStartTime = System.currentTimeMillis();

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case MainRegion_StateA :
					reactMainRegion_StateA();
					break;
				case MainRegion_StateB :
					reactMainRegion_StateB();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
