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
package org.yakindu.sct.simulation.core.launch;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.simulation.core.debugmodel.SCTDebugTarget;
import org.yakindu.sct.simulation.core.engine.ISimulationEngine;
import org.yakindu.sct.simulation.core.util.ResourceUtil;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractSCTLaunchConfigurationDelegate extends LaunchConfigurationDelegate implements
		ILaunchConfigurationDelegate {

	public String FILE_NAME = "filename";
	public String DEFAULT_FILE_NAME = "";

	protected abstract ISimulationEngine createExecutionContainer(ILaunch launch, Statechart statechart);

	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor)
			throws CoreException {
		String filename = configuration.getAttribute(FILE_NAME, DEFAULT_FILE_NAME);
		Statechart statechart = loadStatechart(filename);
		SCTDebugTarget target = createDebugTarget(launch, statechart);
		launch.addDebugTarget(target);
		target.init();
		target.start();
	}

	protected SCTDebugTarget createDebugTarget(ILaunch launch, Statechart statechart) throws CoreException {
		Assert.isNotNull(statechart);
		return new SCTDebugTarget(launch, statechart, createExecutionContainer(launch, statechart));
	}

	protected Statechart loadStatechart(String filename) {
		return ResourceUtil.loadStatechart(filename);
	}

	@Override
	protected IProject[] getProjectsForProblemSearch(ILaunchConfiguration configuration, String mode)
			throws CoreException {
		String filename = configuration.getAttribute(FILE_NAME, "");
		IResource resource = ResourcesPlugin.getWorkspace().getRoot().findMember(filename);
		return new IProject[] { resource.getProject() };

	}

}
