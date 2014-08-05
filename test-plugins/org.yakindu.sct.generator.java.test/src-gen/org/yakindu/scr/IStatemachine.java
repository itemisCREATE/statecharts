package org.yakindu.scr;

/**
 * Basic interface for statemachines.
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
	* Exits the statemachine. Leaves the statemachine with a defined state.
	*/
	public void exit();

	/**
	* Start a run-to-completion cycle.
	*/
	public void runCycle();
}
