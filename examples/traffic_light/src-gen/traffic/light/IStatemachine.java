/**
Copyright (c) 2012-2015 committers of YAKINDU and others.
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html

Contributors:
    committers of YAKINDU - initial API and implementation
�*/
package traffic.light;

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
	 * Checks if the statemachine is active. 
	 * A statemachine is active if it was entered. It is inactive if it has not been entered at all or if it was exited.
	 */
	public boolean isActive();

	/**
	 * Checks if all active states are final. 
	 * If there are no active states then the statemachine is considered as incative and this method returns false.
	 */
	public boolean isFinal();

	/**
	* Start a run-to-completion cycle.
	*/
	public void runCycle();
}
