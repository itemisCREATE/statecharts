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
	 * Returns a name for the Execution Facade implementation
	 */
	public String getName();
	
	public void tearDown();
	/**
	 * Startes the execution
	 */
	public void enter();
	/**
	 * Executes one cycle
	 */
	public void runCycle();

	public void addExecutionListener(IExecutionFacadeListener listener);

	public void removeExecutionListener(IExecutionFacadeListener listener);

	public IExecutionContext getExecutionContext();
	
}
