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
package org.yakindu.sct.simulation.ui.perspective;

import static org.yakindu.sct.simulation.core.launch.IStatechartLaunchConfigurationType.CONFIG_TYPE;
import static org.yakindu.sct.ui.perspectives.IYakinduSctPerspectives.ID_PERSPECTIVE_SCT_SIMULATION;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchListener;
import org.eclipse.debug.internal.ui.DebugUIPlugin;
import org.eclipse.debug.internal.ui.launchConfigurations.PerspectiveManager;
import org.eclipse.debug.internal.ui.viewers.AsynchronousSchedulingRuleFactory;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.progress.UIJob;

/**
 * custom implementation of the {@link PerspectiveManager} for the Yakindu
 * Statechart launch types. </br>
 * 
 * This implementation forces to open the Yakindu Simulation perspective without
 * asking the user. </br>
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@SuppressWarnings("restriction")
public class SCTPerspectiveManager extends PerspectiveManager implements
		ILaunchListener {

	public void launchAdded(ILaunch launch) {

		ILaunchConfigurationType statechartLaunchType = DebugPlugin
				.getDefault().getLaunchManager()
				.getLaunchConfigurationType(CONFIG_TYPE);
		try {
			if (statechartLaunchType.equals(launch.getLaunchConfiguration()
					.getType())) {
				Job switchJob = new UIJob(DebugUIPlugin.getStandardDisplay(),
						"Perspective Switch Job") { //$NON-NLS-1$
					public IStatus runInUIThread(IProgressMonitor monitor) {
						IWorkbenchWindow window = DebugUIPlugin
								.getActiveWorkbenchWindow();
						if (window != null
								&& !(isCurrentPerspective(window,
										ID_PERSPECTIVE_SCT_SIMULATION))) {
							switchToPerspective(window,
									ID_PERSPECTIVE_SCT_SIMULATION);
						}
						return Status.OK_STATUS;
					}
				};
				switchJob.setSystem(true);
				switchJob.setPriority(Job.INTERACTIVE);
				switchJob.setRule(AsynchronousSchedulingRuleFactory
						.getDefault().newSerialPerObjectRule(this));
				switchJob.schedule();
			}
		} catch (CoreException ex) {
			ex.printStackTrace();
		}
	}

	public void launchChanged(ILaunch launch) {
		// Nothing to do
	}

	public void launchRemoved(ILaunch launch) {
		// Nothing to do
	}

}
