/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */

package org.yakindu.sct.simulation.ui.handler;

import java.util.Collections;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.core.IStatusHandler;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.internal.ui.DebugUIPlugin;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.yakindu.sct.simulation.ui.dialogs.SimulationLaunchErrorDialog;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * @author florian antony
 * 
 */
@SuppressWarnings("restriction")
public class TerminateLaunchStatusHandler implements IStatusHandler {

	public Object handleStatus(final IStatus status, final Object source) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				Shell shell = DebugUIPlugin.getShell();
				SimulationLaunchErrorDialog dialog = new SimulationLaunchErrorDialog(shell,
						"Exception occured during simulation", status.getMessage(), status, Collections
								.singletonList((IDebugTarget) source));
				dialog.setBlockOnOpen(false);
				dialog.open();
			}
		});
		return null;
	}
}
