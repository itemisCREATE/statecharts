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

import java.util.Collections;

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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.resource.ResourceUtil;
import org.yakindu.sct.simulation.core.debugmodel.SCTDebugTarget;
import org.yakindu.sct.simulation.core.engine.ISimulationEngine;

import com.google.inject.Inject;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractSCTLaunchConfigurationDelegate extends LaunchConfigurationDelegate
		implements ILaunchConfigurationDelegate {

	public String FILE_NAME = "filename";
	public String DEFAULT_FILE_NAME = "";

	protected abstract ISimulationEngine createExecutionContainer(ILaunch launch, Statechart statechart);

	@Inject(optional = true)
	private ILaunchConfigurationDelegate delegate;

	@Override
	public boolean preLaunchCheck(ILaunchConfiguration configuration, String mode, IProgressMonitor monitor)
			throws CoreException {
		String filename = configuration.getAttribute(FILE_NAME, DEFAULT_FILE_NAME);
		URI uri = URI.createPlatformResourceURI(filename, true);
		if (!URIConverter.INSTANCE.exists(uri, Collections.emptyMap()))
			return false;
		return super.preLaunchCheck(configuration, mode, monitor);
	}

	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor)
			throws CoreException {
		String filename = configuration.getAttribute(FILE_NAME, DEFAULT_FILE_NAME);
		Statechart statechart = loadStatechart(filename);
		SCTDebugTarget target = createDebugTarget(launch, statechart);
		target.setPrimary(true);
		launch.addDebugTarget(target);
		try {
			target.init();
			if (delegate != null)
				delegate.launch(configuration, mode, launch, monitor);
			target.start();
		} catch (InitializationException e) {
			// handled in AbstractExecutionFlowSimulationEngine
		}
	}

	protected SCTDebugTarget createDebugTarget(ILaunch launch, Statechart statechart) throws CoreException {
		return createDebugTarget(launch, statechart, statechart.getName());
	}

	protected SCTDebugTarget createDebugTarget(ILaunch launch, Statechart statechart, String name)
			throws CoreException {
		Assert.isNotNull(statechart);
		return new SCTDebugTarget(launch, statechart, name, createExecutionContainer(launch, statechart));
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

	@Override
	public boolean buildForLaunch(ILaunchConfiguration configuration, String mode, IProgressMonitor monitor)
			throws CoreException {
		// Never build the workspace before simulation
		return false;
	}

	public static class InitializationException extends RuntimeException {

		private static final long serialVersionUID = 1L;

		public InitializationException(String msg) {
			super(msg);
		}
	}

}