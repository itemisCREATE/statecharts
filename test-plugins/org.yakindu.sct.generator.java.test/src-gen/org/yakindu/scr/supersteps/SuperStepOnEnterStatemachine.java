/** Generated by YAKINDU Statechart Tools code generator. */
package org.yakindu.scr.supersteps;

import java.util.LinkedList;
import java.util.Queue;

public class SuperStepOnEnterStatemachine implements ISuperStepOnEnterStatemachine {
	private boolean initialized = false;
	
	public enum State {
		R1_STATEA,
		R1_STATEB,
		R2_STATEA,
		R2_STATEB,
		$NULLSTATE$
	};
	
	private final State[] stateVector = new State[2];
	
	private int nextStateIndex;
	
	private Queue<Runnable> internalEventQueue = new LinkedList<Runnable>();
	private boolean e;
	private boolean isExecuting;
	
	protected boolean getIsExecuting() {
		return isExecuting;
	}
	
	protected void setIsExecuting(boolean value) {
		this.isExecuting = value;
	}
	private boolean stateConfVectorChanged;
	
	protected boolean getStateConfVectorChanged() {
		return stateConfVectorChanged;
	}
	
	protected void setStateConfVectorChanged(boolean value) {
		this.stateConfVectorChanged = value;
	}
	public SuperStepOnEnterStatemachine() {
	}
	
	public void init() {
		this.initialized = true;
		for (int i = 0; i < 2; i++) {
			stateVector[i] = State.$NULLSTATE$;
		}
		
		clearInternalEvents();
		
		
		isExecuting = false;
	}
	
	public void enter() {
		if (!initialized)
			throw new IllegalStateException(
			        "The state machine needs to be initialized first by calling the init() function.");
		
		if (getIsExecuting()) {
			return;
		}
		isExecuting = true;
		enterSequence_r1_default();
		enterSequence_r2_default();
		do { 
			stateConfVectorChanged = false;
			microStep();
		} while (getStateConfVectorChanged());
		
		isExecuting = false;
	}
	
	public void exit() {
		if (getIsExecuting()) {
			return;
		}
		isExecuting = true;
		exitSequence_r1();
		exitSequence_r2();
		isExecuting = false;
	}
	
	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
			        "The state machine needs to be initialized first by calling the init() function.");
		
		if (getIsExecuting()) {
			return;
		}
		isExecuting = true;
		nextEvent();
		do { 
			do { 
				stateConfVectorChanged = false;
				microStep();
			} while (getStateConfVectorChanged());
			
			clearInternalEvents();
			nextEvent();
		} while (e);
		
		isExecuting = false;
	}
	
	/**
	 * @see IStatemachine#isActive()
	 */
	public boolean isActive() {
		return stateVector[0] != State.$NULLSTATE$||stateVector[1] != State.$NULLSTATE$;
	}
	
	/** 
	* Always returns 'false' since this state machine can never become final.
	*
	* @see IStatemachine#isFinal()
	*/
	public boolean isFinal() {
		return false;
	}
	private void clearInternalEvents() {
		e = false;
	}
	
	private void microStep() {
		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
			switch (stateVector[nextStateIndex]) {
			case R1_STATEA:
				r1_StateA_react(true);
				break;
			case R1_STATEB:
				r1_StateB_react(true);
				break;
			case R2_STATEA:
				r2_StateA_react(true);
				break;
			case R2_STATEB:
				r2_StateB_react(true);
				break;
			default:
				// $NULLSTATE$
			}
		}
	}
	
	protected void nextEvent() {
		if(!internalEventQueue.isEmpty()) {
			internalEventQueue.poll().run();
			return;
		}
	}
	/**
	* Returns true if the given state is currently active otherwise false.
	*/
	public boolean isStateActive(State state) {
	
		switch (state) {
		case R1_STATEA:
			return stateVector[0] == State.R1_STATEA;
		case R1_STATEB:
			return stateVector[0] == State.R1_STATEB;
		case R2_STATEA:
			return stateVector[1] == State.R2_STATEA;
		case R2_STATEB:
			return stateVector[1] == State.R2_STATEB;
		default:
			return false;
		}
	}
	
	private void raiseE() {
	
		internalEventQueue.add(new Runnable() {
			@Override public void run() {
				e = true;					
			}
		});
	}
	
	/* Entry action for state 'StateA'. */
	private void entryAction_r2_StateA() {
		raiseE();
	}
	
	/* 'default' enter sequence for state StateA */
	private void enterSequence_r1_StateA_default() {
		nextStateIndex = 0;
		stateVector[0] = State.R1_STATEA;
		stateConfVectorChanged = true;
	}
	
	/* 'default' enter sequence for state StateB */
	private void enterSequence_r1_StateB_default() {
		nextStateIndex = 0;
		stateVector[0] = State.R1_STATEB;
		stateConfVectorChanged = true;
	}
	
	/* 'default' enter sequence for state StateA */
	private void enterSequence_r2_StateA_default() {
		entryAction_r2_StateA();
		nextStateIndex = 1;
		stateVector[1] = State.R2_STATEA;
		stateConfVectorChanged = true;
	}
	
	/* 'default' enter sequence for state StateB */
	private void enterSequence_r2_StateB_default() {
		nextStateIndex = 1;
		stateVector[1] = State.R2_STATEB;
		stateConfVectorChanged = true;
	}
	
	/* 'default' enter sequence for region r1 */
	private void enterSequence_r1_default() {
		react_r1__entry_Default();
	}
	
	/* 'default' enter sequence for region r2 */
	private void enterSequence_r2_default() {
		react_r2__entry_Default();
	}
	
	/* Default exit sequence for state StateA */
	private void exitSequence_r1_StateA() {
		nextStateIndex = 0;
		stateVector[0] = State.$NULLSTATE$;
	}
	
	/* Default exit sequence for state StateB */
	private void exitSequence_r1_StateB() {
		nextStateIndex = 0;
		stateVector[0] = State.$NULLSTATE$;
	}
	
	/* Default exit sequence for state StateA */
	private void exitSequence_r2_StateA() {
		nextStateIndex = 1;
		stateVector[1] = State.$NULLSTATE$;
	}
	
	/* Default exit sequence for state StateB */
	private void exitSequence_r2_StateB() {
		nextStateIndex = 1;
		stateVector[1] = State.$NULLSTATE$;
	}
	
	/* Default exit sequence for region r1 */
	private void exitSequence_r1() {
		switch (stateVector[0]) {
		case R1_STATEA:
			exitSequence_r1_StateA();
			break;
		case R1_STATEB:
			exitSequence_r1_StateB();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region r2 */
	private void exitSequence_r2() {
		switch (stateVector[1]) {
		case R2_STATEA:
			exitSequence_r2_StateA();
			break;
		case R2_STATEB:
			exitSequence_r2_StateB();
			break;
		default:
			break;
		}
	}
	
	/* Default react sequence for initial entry  */
	private void react_r1__entry_Default() {
		enterSequence_r1_StateA_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_r2__entry_Default() {
		enterSequence_r2_StateA_default();
	}
	
	private boolean react() {
		return false;
	}
	
	private boolean r1_StateA_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (react()==false) {
				exitSequence_r1_StateA();
				enterSequence_r1_StateB_default();
			}
		}
		return did_transition;
	}
	
	private boolean r1_StateB_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (react()==false) {
				did_transition = false;
			}
		}
		return did_transition;
	}
	
	private boolean r2_StateA_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (e) {
				exitSequence_r2_StateA();
				enterSequence_r2_StateB_default();
			} else {
				did_transition = false;
			}
		}
		return did_transition;
	}
	
	private boolean r2_StateB_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			did_transition = false;
		}
		return did_transition;
	}
	
}
