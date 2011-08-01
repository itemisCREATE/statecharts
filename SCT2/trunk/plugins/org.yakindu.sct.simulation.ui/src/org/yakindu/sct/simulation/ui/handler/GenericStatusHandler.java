package org.yakindu.sct.simulation.ui.handler;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.core.IStatusHandler;
import org.eclipse.ui.statushandlers.StatusManager;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class GenericStatusHandler implements IStatusHandler {

	public Object handleStatus(IStatus status, Object source)
			throws CoreException {
		StatusManager.getManager().handle(status, StatusManager.SHOW);
		return null;

	}

}
