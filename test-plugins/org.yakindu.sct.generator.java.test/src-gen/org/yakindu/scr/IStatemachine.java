package org.yakindu.scr;

/**
 * Basic interface for state machines.
 */
public interface IStatemachine {

	/**
	 * Initializes the state machine. Use to init internal variables etc.
	 */
	public void init();

	/**
	 * Enters the state machine. Sets the state machine in a defined state.
	 */
	public void enter();

	/**
	 * Exits the state machine. Leaves the state machine with a defined state.
	 */
	public void exit();

	/**
	 * Checks if the state machine is active. 
	 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it was exited.
	 */
	public boolean isActive();

	/**
	 * Checks if all active states are final. 
	 * If there are no active states then the state machine is considered as incative and this method returns false.
	 */
	public boolean isFinal();

	/**
	* Start a run-to-completion cycle.
	*/
	public void runCycle();
}
