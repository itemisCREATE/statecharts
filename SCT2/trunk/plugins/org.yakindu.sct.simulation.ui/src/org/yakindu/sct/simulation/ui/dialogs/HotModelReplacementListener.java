/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.simulation.ui.dialogs;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.internal.ui.DebugUIPlugin;
import org.eclipse.swt.widgets.Display;
import org.yakindu.sct.simulation.core.hmr.IHotModelReplacementListener;
import org.yakindu.sct.simulation.ui.SimulationActivator;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@SuppressWarnings("restriction")
public class HotModelReplacementListener implements
		IHotModelReplacementListener {

	private static final String MESSAGE = "The YAKINDU Statechart model changed during a simulation session. Do you want to terminate or restart the simulation?";
	private IStatus status = new Status(IStatus.WARNING,
			SimulationActivator.PLUGIN_ID, IStatus.WARNING,
			"Resource changed during simulation", null);

	public void hotCodeReplaceFailed(final List<IDebugTarget> targets) {
		final Display display = Display.getDefault();
		try {
			final String title = "Model changed during simulation";
			display.asyncExec(new Runnable() {
				public void run() {
					if (display.isDisposed()) {
						return;
					}
					SimulationLaunchErrorDialog dialog = new SimulationLaunchErrorDialog(
							DebugUIPlugin.getShell(), title, MESSAGE, status,
							targets);
					dialog.setBlockOnOpen(false);
					dialog.open();
				}
			});
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
