/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */

package org.yakindu.sct.simulation.core.runtime;

/**
 * An {@link IExecutionFacadeController} controls the {@link IExecutionFacade}
 * runCycle method invocation.
 * 
 * Possible implementations can be cycle based or event driven controllers.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public interface IExecutionFacadeController {

	public void start();

	public void suspend();
	
	public void step();

	public void resume();

	public void terminate();

}
