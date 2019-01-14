package org.yakindu.scr.tracing;

import java.util.LinkedList;
import java.util.List;
import org.yakindu.scr.ITracingListener;

public class TracingStatemachine implements ITracingStatemachine {
	protected class SCInterfaceImpl implements SCInterface {
	
	}
	
	protected SCInterfaceImpl sCInterface;
	
	private boolean initialized = false;
	
	public enum State {
		main_region_StateA,
		main_region__final_,
		$NullState$
	};
	
	private final State[] stateVector = new State[1];
	
	private int nextStateIndex;
	
	private List <ITracingListener<State>> ifaceTraceObservers = new LinkedList <ITracingListener<State>>();
	
	
	public TracingStatemachine() {
		sCInterface = new SCInterfaceImpl();
	}
	
	public void init() {
		this.initialized = true;
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}
		clearEvents();
		clearOutEvents();
	}
	
	public void enter() {
		if (!initialized) {
			throw new IllegalStateException(
				"The state machine needs to be initialized first by calling the init() function."
			);
		}
		enterSequence_main_region_default();
	}
	
	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
		clearOutEvents();
		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
			switch (stateVector[nextStateIndex]) {
			case main_region_StateA:
				main_region_StateA_react(true);
				break;
			case main_region__final_:
				main_region__final__react(true);
				break;
			default:
				// $NullState$
			}
		}
		clearEvents();
	}
	public void exit() {
		exitSequence_main_region();
	}
	
	/**
	 * @see IStatemachine#isActive()
	 */
	public boolean isActive() {
		return stateVector[0] != State.$NullState$;
	}
	
	/** 
	* @see IStatemachine#isFinal()
	*/
	public boolean isFinal() {
		return (stateVector[0] == State.main_region__final_);
	}
	/**
	* This method resets the incoming events (time events included).
	*/
	protected void clearEvents() {
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
		case main_region_StateA:
			return stateVector[0] == State.main_region_StateA;
		case main_region__final_:
			return stateVector[0] == State.main_region__final_;
		default:
			return false;
		}
	}
	
	public SCInterface getSCInterface() {
		return sCInterface;
	}
	
	public void addTraceObserver(ITracingListener<State> ifaceTraceObserver) {
		if(!(this.ifaceTraceObservers.contains(ifaceTraceObserver))) {
			this.ifaceTraceObservers.add(ifaceTraceObserver);
		}
	}
	
	public void removeTraceObserver(ITracingListener<State> ifaceTraceObserver) {
		if(this.ifaceTraceObservers.contains(ifaceTraceObserver)) {
			this.ifaceTraceObservers.remove(ifaceTraceObserver);
		}
	}
	/* 'default' enter sequence for state StateA */
	private void enterSequence_main_region_StateA_default() {
		for(ITracingListener<State> ifaceTraceObserver : ifaceTraceObservers) {
			ifaceTraceObserver.onStateEntered(State.main_region_StateA);
		}
		
		nextStateIndex = 0;
		stateVector[0] = State.main_region_StateA;
	}
	
	/* Default enter sequence for state null */
	private void enterSequence_main_region__final__default() {
		for(ITracingListener<State> ifaceTraceObserver : ifaceTraceObservers) {
			ifaceTraceObserver.onStateEntered(State.main_region__final_);
		}
		
		nextStateIndex = 0;
		stateVector[0] = State.main_region__final_;
	}
	
	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}
	
	/* Default exit sequence for state StateA */
	private void exitSequence_main_region_StateA() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		for(ITracingListener<State> ifaceTraceObserver : ifaceTraceObservers) {
			ifaceTraceObserver.onStateExited(State.main_region_StateA);
		}
	}
	
	/* Default exit sequence for final state. */
	private void exitSequence_main_region__final_() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		for(ITracingListener<State> ifaceTraceObserver : ifaceTraceObservers) {
			ifaceTraceObserver.onStateExited(State.main_region__final_);
		}
	}
	
	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
		case main_region_StateA:
			exitSequence_main_region_StateA();
			break;
		case main_region__final_:
			exitSequence_main_region__final_();
			break;
		default:
			break;
		}
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_StateA_default();
	}
	
	private boolean react() {
		return false;
	}
	
	private boolean main_region_StateA_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			
			exitSequence_main_region_StateA();
			
			enterSequence_main_region__final__default();
		}
		if (did_transition==false) {
			did_transition = react();
		}
		return did_transition;
	}
	
	private boolean main_region__final__react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			did_transition = false;
		}
		if (did_transition==false) {
			did_transition = react();
		}
		return did_transition;
	}
	
}
