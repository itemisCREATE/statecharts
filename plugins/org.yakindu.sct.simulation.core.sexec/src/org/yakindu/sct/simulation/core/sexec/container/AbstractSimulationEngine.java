/**
* Copyright (c) 2017 itemis AG - All rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* 
* Contributors:
* 	Jonathan Thoene - itemis AG
*
*/
package org.yakindu.sct.simulation.core.sexec.container;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IStatusHandler;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.emf.common.util.WrappedException;
import org.yakindu.sct.simulation.core.SimulationCoreActivator;
import org.yakindu.sct.simulation.core.engine.IExecutionControl;
import org.yakindu.sct.simulation.core.engine.ISimulationEngine;

public abstract class AbstractSimulationEngine implements ISimulationEngine, IExecutionControl {
	public static final String ERROR_MSG = "An unexpected error ocurred during simulation.";

	public static final int ERROR_DURING_SIMULATION = 765;
	
	protected void handleException(Throwable t) {
		if (t instanceof WrappedException) {
			t = ((WrappedException) t).getCause();
		}
		String statusMessage = t.getMessage() == null ? ERROR_MSG : t.getMessage();
		Status errorStatus = new Status(Status.ERROR, SimulationCoreActivator.PLUGIN_ID, ERROR_DURING_SIMULATION,
				statusMessage, t);
		SimulationCoreActivator.getDefault().getLog().log(errorStatus);
		IStatusHandler statusHandler = DebugPlugin.getDefault().getStatusHandler(errorStatus);
		try {
			statusHandler.handleStatus(errorStatus, getDebugTarget());
		} catch (CoreException e) {
			e.printStackTrace();
		} finally {
			terminate();
		}
	}
	
	protected Object getDebugTarget() {
		IDebugTarget[] debugTargets = DebugPlugin.getDefault().getLaunchManager().getDebugTargets();
		for (IDebugTarget iDebugTarget : debugTargets) {
			if (iDebugTarget.isTerminated())
				continue;
			if (iDebugTarget.getAdapter(ISimulationEngine.class) == this)
				return iDebugTarget;
		}
		return null;
	}
	
	@Override
	public IExecutionControl getExecutionControl() {
		return this;
	}
}
