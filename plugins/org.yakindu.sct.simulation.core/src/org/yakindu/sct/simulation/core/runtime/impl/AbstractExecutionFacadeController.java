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

package org.yakindu.sct.simulation.core.runtime.impl;

import org.yakindu.sct.simulation.core.runtime.IExecutionFacade;
import org.yakindu.sct.simulation.core.runtime.IExecutionFacadeController;

/**
 * Abstract base implementation for {@link IExecutionFacadeController}s
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractExecutionFacadeController implements
		IExecutionFacadeController {

	protected final IExecutionFacade facade;

	protected boolean terminated = false;
	protected boolean suspended = false;

	public AbstractExecutionFacadeController(IExecutionFacade facade) {
		this.facade = facade;
	}

	public void start() {
		facade.enter();
	}

	public void suspend() {
		suspended = true;
	}

	public void resume() {
		suspended = false;
	}

	public void terminate() {
		terminated = true;
		facade.tearDown();
	}
	
	public void step() {
		facade.runCycle();		
	}

}
