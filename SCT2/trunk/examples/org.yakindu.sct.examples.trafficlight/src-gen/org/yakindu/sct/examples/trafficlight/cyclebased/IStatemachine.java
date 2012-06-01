package org.yakindu.sct.examples.trafficlight.cyclebased;

/**
 * Basic interface for statemachines.
 * 
 * 
 */
public interface IStatemachine {

	/**
	 * Initializes the statemachine. Use to init internal variables etc.
	 */
	public void init();

	/**
	 * Start a run-to-completion cycle.
	 */
	public void runCycle();

	/**
	 * Enters the statemachine. Sets the statemachine in a defined state.
	 */
	public void enter();
}
