package org.yakindu.scr;

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
	* Enters the statemachine. Sets the statemachine in a defined state.
	*/
	public void enter();

	/**
	* Start a run-to-completion cycle.
	*/
	public void runCycle();
}
