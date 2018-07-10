package org.yakindu.scr.eventdriventriggeredbyevent;
import org.yakindu.scr.ITimer;

public class EventDrivenTriggeredByEventStatemachine implements IEventDrivenTriggeredByEventStatemachine {

	protected class SCInterfaceImpl implements SCInterface {
	
		private boolean e;
		
		public void raiseE() {
			e = true;
			runCycle();
		}
		
		private long x;
		
		public long getX() {
			return x;
		}
		
		public void setX(long value) {
			this.x = value;
		}
		
		protected void clearEvents() {
			e = false;
		}
	}
	
	protected SCInterfaceImpl sCInterface;
	
	private boolean initialized = false;
	
	public enum State {
		eventDrivenTriggeredByEvent_main_region_A,
		eventDrivenTriggeredByEvent_main_region_B,
		$NullState$
	};
	
	private final State[] stateVector = new State[1];
	
	private int nextStateIndex;
	
	private ITimer timer;
	
	private final boolean[] timeEvents = new boolean[1];
	public EventDrivenTriggeredByEventStatemachine() {
		sCInterface = new SCInterfaceImpl();
	}
	
	public void init() {
		this.initialized = true;
		if (timer == null) {
			throw new IllegalStateException("timer not set.");
		}
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}
		clearEvents();
		clearOutEvents();
		sCInterface.setX(0);
	}
	
	public void enter() {
		if (!initialized) {
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
		}
		if (timer == null) {
			throw new IllegalStateException("timer not set.");
		}
		enterSequence_EventDrivenTriggeredByEvent_main_region_default();
	}
	
	public void exit() {
		exitSequence_EventDrivenTriggeredByEvent_main_region();
	}
	
	/**
	 * @see IStatemachine#isActive()
	 */
	public boolean isActive() {
		return stateVector[0] != State.$NullState$;
	}
	
	/** 
	* Always returns 'false' since this state machine can never become final.
	*
	* @see IStatemachine#isFinal()
	*/
	public boolean isFinal() {
		return false;
	}
	/**
	* This method resets the incoming events (time events included).
	*/
	protected void clearEvents() {
		sCInterface.clearEvents();
		for (int i=0; i<timeEvents.length; i++) {
			timeEvents[i] = false;
		}
	}
	
	/**
	* This method resets the outgoing events.
	*/
	protected void clearOutEvents() {
	}
	
	/**
	* Returns true if the given state is currently active otherwise false.
	*/
	public boolean isStateActive(State state) {
	
		switch (state) {
		case eventDrivenTriggeredByEvent_main_region_A:
			return stateVector[0] == State.eventDrivenTriggeredByEvent_main_region_A;
		case eventDrivenTriggeredByEvent_main_region_B:
			return stateVector[0] == State.eventDrivenTriggeredByEvent_main_region_B;
		default:
			return false;
		}
	}
	
	/**
	* Set the {@link ITimer} for the state machine. It must be set
	* externally on a timed state machine before a run cycle can be correct
	* executed.
	* 
	* @param timer
	*/
	public void setTimer(ITimer timer) {
		this.timer = timer;
	}
	
	/**
	* Returns the currently used timer.
	* 
	* @return {@link ITimer}
	*/
	public ITimer getTimer() {
		return timer;
	}
	
	public void timeElapsed(int eventID) {
		timeEvents[eventID] = true;
		runCycle();
	}
	
	public SCInterface getSCInterface() {
		return sCInterface;
	}
	
	public void raiseE() {
		sCInterface.raiseE();
	}
	
	public long getX() {
		return sCInterface.getX();
	}
	
	public void setX(long value) {
		sCInterface.setX(value);
	}
	
	private boolean check_EventDrivenTriggeredByEvent_main_region_A_lr0_lr0() {
		return true;
	}
	
	private boolean check_EventDrivenTriggeredByEvent_main_region_A_tr0_tr0() {
		return sCInterface.e;
	}
	
	private boolean check_EventDrivenTriggeredByEvent_main_region_B_lr0_lr0() {
		return true;
	}
	
	private boolean check_EventDrivenTriggeredByEvent_main_region_B_lr1_lr1() {
		return timeEvents[0];
	}
	
	private boolean check_EventDrivenTriggeredByEvent_main_region_B_tr0_tr0() {
		return sCInterface.e;
	}
	
	private void effect_EventDrivenTriggeredByEvent_main_region_A_lr0_lr0() {
		sCInterface.setX(sCInterface.getX() + 1);
	}
	
	private void effect_EventDrivenTriggeredByEvent_main_region_A_tr0() {
		exitSequence_EventDrivenTriggeredByEvent_main_region_A();
		enterSequence_EventDrivenTriggeredByEvent_main_region_B_default();
	}
	
	private void effect_EventDrivenTriggeredByEvent_main_region_B_lr0_lr0() {
		sCInterface.setX(sCInterface.getX() + 1);
	}
	
	private void effect_EventDrivenTriggeredByEvent_main_region_B_lr1_lr1() {
		sCInterface.setX(sCInterface.getX() + 0);
	}
	
	private void effect_EventDrivenTriggeredByEvent_main_region_B_tr0() {
		exitSequence_EventDrivenTriggeredByEvent_main_region_B();
		enterSequence_EventDrivenTriggeredByEvent_main_region_A_default();
	}
	
	/* Entry action for state 'B'. */
	private void entryAction_EventDrivenTriggeredByEvent_main_region_B() {
		timer.setTimer(this, 0, 100000 * 1000, false);
	}
	
	/* Exit action for state 'B'. */
	private void exitAction_EventDrivenTriggeredByEvent_main_region_B() {
		timer.unsetTimer(this, 0);
	}
	
	/* 'default' enter sequence for state A */
	private void enterSequence_EventDrivenTriggeredByEvent_main_region_A_default() {
		nextStateIndex = 0;
		stateVector[0] = State.eventDrivenTriggeredByEvent_main_region_A;
	}
	
	/* 'default' enter sequence for state B */
	private void enterSequence_EventDrivenTriggeredByEvent_main_region_B_default() {
		entryAction_EventDrivenTriggeredByEvent_main_region_B();
		nextStateIndex = 0;
		stateVector[0] = State.eventDrivenTriggeredByEvent_main_region_B;
	}
	
	/* 'default' enter sequence for region main region */
	private void enterSequence_EventDrivenTriggeredByEvent_main_region_default() {
		react_EventDrivenTriggeredByEvent_main_region__entry_Default();
	}
	
	/* Default exit sequence for state A */
	private void exitSequence_EventDrivenTriggeredByEvent_main_region_A() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state B */
	private void exitSequence_EventDrivenTriggeredByEvent_main_region_B() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_EventDrivenTriggeredByEvent_main_region_B();
	}
	
	/* Default exit sequence for region main region */
	private void exitSequence_EventDrivenTriggeredByEvent_main_region() {
		switch (stateVector[0]) {
		case eventDrivenTriggeredByEvent_main_region_A:
			exitSequence_EventDrivenTriggeredByEvent_main_region_A();
			break;
		case eventDrivenTriggeredByEvent_main_region_B:
			exitSequence_EventDrivenTriggeredByEvent_main_region_B();
			break;
		default:
			break;
		}
	}
	
	/* The reactions of state A. */
	private void react_EventDrivenTriggeredByEvent_main_region_A() {
		if (check_EventDrivenTriggeredByEvent_main_region_A_tr0_tr0()) {
			effect_EventDrivenTriggeredByEvent_main_region_A_tr0();
		} else {
			effect_EventDrivenTriggeredByEvent_main_region_A_lr0_lr0();
		}
	}
	
	/* The reactions of state B. */
	private void react_EventDrivenTriggeredByEvent_main_region_B() {
		if (check_EventDrivenTriggeredByEvent_main_region_B_tr0_tr0()) {
			effect_EventDrivenTriggeredByEvent_main_region_B_tr0();
		} else {
			effect_EventDrivenTriggeredByEvent_main_region_B_lr0_lr0();
			if (check_EventDrivenTriggeredByEvent_main_region_B_lr1_lr1()) {
				effect_EventDrivenTriggeredByEvent_main_region_B_lr1_lr1();
			}
		}
	}
	
	/* Default react sequence for initial entry  */
	private void react_EventDrivenTriggeredByEvent_main_region__entry_Default() {
		enterSequence_EventDrivenTriggeredByEvent_main_region_A_default();
	}
	
	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
	
		clearOutEvents();
		singleCycle();
		clearEvents();
		
	}
	
	protected void singleCycle() {
		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
			switch (stateVector[nextStateIndex]) {
			case eventDrivenTriggeredByEvent_main_region_A:
				react_EventDrivenTriggeredByEvent_main_region_A();
				break;
			case eventDrivenTriggeredByEvent_main_region_B:
				react_EventDrivenTriggeredByEvent_main_region_B();
				break;
			default:
				// $NullState$
			}
		}
	}
}
