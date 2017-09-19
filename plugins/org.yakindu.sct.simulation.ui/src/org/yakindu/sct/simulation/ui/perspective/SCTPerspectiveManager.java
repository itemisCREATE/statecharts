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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IDebugEventSetListener;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchListener;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.internal.ui.DebugUIPlugin;
import org.eclipse.debug.internal.ui.launchConfigurations.PerspectiveManager;
import org.eclipse.debug.internal.ui.viewers.AsynchronousSchedulingRuleFactory;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.progress.UIJob;
import org.yakindu.sct.simulation.core.debugmodel.SCTDebugTarget;
import org.yakindu.sct.ui.perspectives.IYakinduSctPerspectives;

/**
 * custom implementation of the {@link PerspectiveManager} for the YAKINDU
 * Statechart launch types. </br>
 * 
 * This implementation forces to open the YAKINDU Simulation perspective and the
 * Debug view. It switches back to modeling view after simulation is
 * terminated.</br>
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@SuppressWarnings("restriction")
public class SCTPerspectiveManager extends PerspectiveManager implements ILaunchListener, IDebugEventSetListener {

	protected static final String ID_PERSPECTIVE_SCT_MODELING = IYakinduSctPerspectives.ID_PERSPECTIVE_SCT_MODELING;
	protected static final String ID_PERSPECTIVE_SCT_SIMULATION = IYakinduSctPerspectives.ID_PERSPECTIVE_SCT_SIMULATION;
	private static final String DEBUG_VIEW_ID = "org.eclipse.debug.ui.DebugView";
	private static final String LAUNCH_TYPE = "org.yakindu.sct.simulation.core.launch.statechart";

	public void launchAdded(ILaunch launch) {
		try {
			ILaunchConfigurationType type = launch.getLaunchConfiguration().getType();
			// Open the simulation perspective for all yakindu simulation types
			if (type.getIdentifier().equals(LAUNCH_TYPE)) {
				schedulePerspectiveSwitchJob(ID_PERSPECTIVE_SCT_SIMULATION);
			}
		} catch (CoreException ex) {
			ex.printStackTrace();
		}
	}

	public void handleDebugEvents(DebugEvent[] events) {
		for (DebugEvent debugEvent : events) {
			if ((debugEvent.getSource() instanceof SCTDebugTarget))
				switch (debugEvent.getKind()) {
					case DebugEvent.TERMINATE :
						if (allTargetsTerminated())
							schedulePerspectiveSwitchJob(ID_PERSPECTIVE_SCT_MODELING);
						break;
					case DebugEvent.SUSPEND :
						break;
					case DebugEvent.RESUME :
						break;
				}
		}
	}

	protected boolean allTargetsTerminated() {
		ILaunch[] launches = DebugPlugin.getDefault().getLaunchManager().getLaunches();
		for (ILaunch launch : launches) {
			for (IDebugTarget target : launch.getDebugTargets()) {
				if (!target.isTerminated())
					return false;
			}
		}
		return true;
	}

	protected void schedulePerspectiveSwitchJob(final String perspectiveID) {
		Job switchJob = new UIJob(DebugUIPlugin.getStandardDisplay(), "Perspective Switch Job") { //$NON-NLS-1$
			public IStatus runInUIThread(IProgressMonitor monitor) {
				IWorkbenchWindow window = DebugUIPlugin.getActiveWorkbenchWindow();
				if (window != null && !(isCurrentPerspective(window, perspectiveID))) {
					switchToPerspective(window, perspectiveID);
				}
				// Force the debug view to open
				if (window != null) {
					try {
						window.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(DEBUG_VIEW_ID);
					} catch (PartInitException e) {
						e.printStackTrace();
					}
				}
				return Status.OK_STATUS;
			}
		};
		switchJob.setSystem(true);
		switchJob.setPriority(Job.INTERACTIVE);
		switchJob.setRule(AsynchronousSchedulingRuleFactory.getDefault().newSerialPerObjectRule(this));
		switchJob.schedule();
	}

	public void launchChanged(ILaunch launch) {
		// Nothing to do
	}

	public void launchRemoved(ILaunch launch) {
		// Nothing to do
	}

}
