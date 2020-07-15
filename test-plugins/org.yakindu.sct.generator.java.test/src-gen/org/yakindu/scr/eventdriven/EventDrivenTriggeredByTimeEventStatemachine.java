/** Generated by YAKINDU Statechart Tools code generator. */
package org.yakindu.scr.eventdriven;

import java.util.LinkedList;
import java.util.Queue;
import org.yakindu.sct.ITimer;

public class EventDrivenTriggeredByTimeEventStatemachine implements IEventDrivenTriggeredByTimeEventStatemachine {
	protected class InterfaceImpl implements Interface {
	
		private long x;
		
		public long getX() {
			return x;
		}
		
		public void setX(long value) {
			this.x = value;
		}
		
		private long transition_count;
		
		public long getTransition_count() {
			return transition_count;
		}
		
		public void setTransition_count(long value) {
			this.transition_count = value;
		}
		
	}
	
	protected InterfaceImpl defaultInterface;
	
	private boolean initialized = false;
	
	public enum State {
		R_A,
		R_B,
		$NULLSTATE$
	};
	
	private final State[] stateVector = new State[1];
	
	private int nextStateIndex;
	
	private ITimer timer;
	
	private final boolean[] timeEvents = new boolean[2];
	
	private Queue<Runnable> inEventQueue = new LinkedList<Runnable>();
	private boolean isExecuting;
	
	protected boolean getIsExecuting() {
		return isExecuting;
	}
	
	protected void setIsExecuting(boolean value) {
		this.isExecuting = value;
	}
	public EventDrivenTriggeredByTimeEventStatemachine() {
		defaultInterface = new InterfaceImpl();
	}
	
	public void init() {
		this.initialized = true;
		if (timer == null) {
			throw new IllegalStateException("timer not set.");
		}
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NULLSTATE$;
		}
		
		clearInEvents();
		
		defaultInterface.setX(0);
		
		defaultInterface.setTransition_count(0);
		
		isExecuting = false;
	}
	
	public void enter() {
		if (!initialized)
			throw new IllegalStateException(
			        "The state machine needs to be initialized first by calling the init() function.");
		if (timer == null) {
			throw new IllegalStateException("timer not set.");
		}
		
		if (getIsExecuting()) {
			return;
		}
		isExecuting = true;
		enterSequence_r_default();
		isExecuting = false;
	}
	
	public void exit() {
		if (getIsExecuting()) {
			return;
		}
		isExecuting = true;
		exitSequence_r();
		isExecuting = false;
	}
	
	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
			        "The state machine needs to be initialized first by calling the init() function.");
		if (timer == null) {
			throw new IllegalStateException("timer not set.");
		}
		
		if (getIsExecuting()) {
			return;
		}
		isExecuting = true;
		nextEvent();
		do { 
			for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
				switch (stateVector[nextStateIndex]) {
				case R_A:
					r_A_react(true);
					break;
				case R_B:
					r_B_react(true);
					break;
				default:
					// $NULLSTATE$
				}
			}
			
			clearInEvents();
			nextEvent();
		} while ((timeEvents[0] || timeEvents[1]));
		
		isExecuting = false;
	}
	
	/**
	 * @see IStatemachine#isActive()
	 */
	public boolean isActive() {
		return stateVector[0] != State.$NULLSTATE$;
	}
	
	/** 
	* Always returns 'false' since this state machine can never become final.
	*
	* @see IStatemachine#isFinal()
	*/
	public boolean isFinal() {
		return false;
	}
	private void clearInEvents() {
		timeEvents[0] = false;
		timeEvents[1] = false;
	}
	
	protected void nextEvent() {
		if(!inEventQueue.isEmpty()) {
			inEventQueue.poll().run();
			return;
		}
	}
	/**
	* Returns true if the given state is currently active otherwise false.
	*/
	public boolean isStateActive(State state) {
	
		switch (state) {
		case R_A:
			return stateVector[0] == State.R_A;
		case R_B:
			return stateVector[0] == State.R_B;
		default:
			return false;
		}
	}
	
	/**
	* Set the {@link ITimer} for the state machine. It must be set
	* externally on a timed state machine before a run cycle can be correctly
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
		inEventQueue.add(new Runnable() {
			@Override
			public void run() {
				timeEvents[eventID] = true;
			}
		});
		runCycle();
	}
	
	public Interface getInterface() {
		return defaultInterface;
	}
	
	public long getX() {
		return defaultInterface.getX();
	}
	
	public void setX(long value) {
		defaultInterface.setX(value);
	}
	
	public long getTransition_count() {
		return defaultInterface.getTransition_count();
	}
	
	public void setTransition_count(long value) {
		defaultInterface.setTransition_count(value);
	}
	
	/* Entry action for state 'A'. */
	private void entryAction_r_A() {
		timer.setTimer(this, 0, (1 * 1000), false);
	}
	
	/* Entry action for state 'B'. */
	private void entryAction_r_B() {
		timer.setTimer(this, 1, (1 * 1000), false);
	}
	
	/* Exit action for state 'A'. */
	private void exitAction_r_A() {
		timer.unsetTimer(this, 0);
	}
	
	/* Exit action for state 'B'. */
	private void exitAction_r_B() {
		timer.unsetTimer(this, 1);
	}
	
	/* 'default' enter sequence for state A */
	private void enterSequence_r_A_default() {
		entryAction_r_A();
		nextStateIndex = 0;
		stateVector[0] = State.R_A;
	}
	
	/* 'default' enter sequence for state B */
	private void enterSequence_r_B_default() {
		entryAction_r_B();
		nextStateIndex = 0;
		stateVector[0] = State.R_B;
	}
	
	/* 'default' enter sequence for region r */
	private void enterSequence_r_default() {
		react_r__entry_Default();
	}
	
	/* Default exit sequence for state A */
	private void exitSequence_r_A() {
		nextStateIndex = 0;
		stateVector[0] = State.$NULLSTATE$;
		
		exitAction_r_A();
	}
	
	/* Default exit sequence for state B */
	private void exitSequence_r_B() {
		nextStateIndex = 0;
		stateVector[0] = State.$NULLSTATE$;
		
		exitAction_r_B();
	}
	
	/* Default exit sequence for region r */
	private void exitSequence_r() {
		switch (stateVector[0]) {
		case R_A:
			exitSequence_r_A();
			break;
		case R_B:
			exitSequence_r_B();
			break;
		default:
			break;
		}
	}
	
	/* Default react sequence for initial entry  */
	private void react_r__entry_Default() {
		enterSequence_r_A_default();
	}
	
	private boolean react() {
		return false;
	}
	
	private boolean r_A_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (react()==false) {
				if (timeEvents[0]) {
					exitSequence_r_A();
					defaultInterface.setTransition_count(defaultInterface.getTransition_count() + 1);
					
					enterSequence_r_B_default();
				} else {
					did_transition = false;
				}
			}
		}
		if (did_transition==false) {
			defaultInterface.setX(defaultInterface.getX() + 1);
		}
		return did_transition;
	}
	
	private boolean r_B_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (react()==false) {
				if (timeEvents[1]) {
					exitSequence_r_B();
					defaultInterface.setTransition_count(defaultInterface.getTransition_count() + 1);
					
					enterSequence_r_A_default();
				} else {
					did_transition = false;
				}
			}
		}
		if (did_transition==false) {
			defaultInterface.setX(defaultInterface.getX() + 1);
		}
		return did_transition;
	}
	
}
