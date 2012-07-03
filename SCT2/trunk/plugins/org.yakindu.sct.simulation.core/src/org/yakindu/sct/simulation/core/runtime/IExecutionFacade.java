/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.simulation.core.runtime;

/**
 * Facade for executable statechart implementation.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public interface IExecutionFacade {

	/**
	 * Unique name
	 */
	public String getName();

	/**
	 * Called before execution, used for initialization
	 */
	public void enter();

	/**
	 * Called after execution, used for clean up
	 */
	public void tearDown();

	/**
	 * Call on every cycle
	 */
	public void runCycle();

	/**
	 * Adds an implementation of {@link IExecutionTraceListener}
	 */
	public void addTraceListener(IExecutionTraceListener listener);

	/**
	 * Removes an implementation of {@link IExecutionTraceListener}
	 */
	public void removeTraceListener(IExecutionTraceListener listener);

	/**
	 * Returns the {@link IExecutionContext}
	 */
	public IExecutionContext getExecutionContext();

	/**
	 * Adds a callback object that is used for the simulation of operations
	 */
	public void addCallbackObject(Object object);

	/**
	 * Removes a callback object that is used for the simulation of operations
	 */
	public void removeCallbackObject(Object object);

}
