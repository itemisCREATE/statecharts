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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IStatusHandler;
import org.eclipse.emf.common.util.WrappedException;
import org.yakindu.sct.simulation.core.Activator;
import org.yakindu.sct.simulation.core.debugmodel.SCTDebugTarget;
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

	public static final int ERROR_DURING_SIMULATION = 765;

	protected final IExecutionFacade facade;

	protected boolean terminated = false;
	protected boolean suspended = false;

	private SCTDebugTarget target;

	public AbstractExecutionFacadeController(SCTDebugTarget target) {
		this.target = target;
		this.facade = (IExecutionFacade) target
				.getAdapter(IExecutionFacade.class);
	}

	protected void runCycle() {
		try {
			facade.runCycle();
		} catch (WrappedException ex) {
			Status errorStatus = new Status(Status.ERROR, Activator.PLUGIN_ID,
					ERROR_DURING_SIMULATION, ex.getCause().getMessage(),
					ex.getCause());
			IStatusHandler statusHandler = DebugPlugin.getDefault()
					.getStatusHandler(errorStatus);
			try {
				statusHandler.handleStatus(errorStatus, target);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
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
