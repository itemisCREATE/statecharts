/**
 * Copyright (c) 2011-2015 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.simulation.core.sexec.launch;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.yakindu.sct.domain.extension.DomainRegistry;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.simulation.core.engine.ISimulationEngine;
import org.yakindu.sct.simulation.core.launch.AbstractSCTLaunchConfigurationDelegate;
import org.yakindu.sct.simulation.core.sexec.container.ISimulationEngineFactory;
import org.yakindu.sct.simulation.core.sexec.interpreter.IOperationMockup;
import org.yakindu.sct.simulation.core.sexec.interpreter.JavaOperationMockup;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * @author terfloth - added dynamic module configuration based on statechart
 *         language type and language providers
 * 
 */
public class SexecLaunchConfigurationDelegate extends AbstractSCTLaunchConfigurationDelegate implements
		ILaunchConfigurationDelegate {

	@Inject
	private ISimulationEngineFactory factory;

	@Override
	protected ISimulationEngine createExecutionContainer(final ILaunch launch, Statechart statechart) {
		try {

			Injector injector = getInjector(statechart, launch);
			IFile file = WorkspaceSynchronizer.getFile(statechart.eResource());
			injector.injectMembers(this);
			IOperationMockup mockup = injector.getInstance(IOperationMockup.class);
			if (mockup instanceof JavaOperationMockup) {
				IProject project = file.getProject();
				String classes = launch.getLaunchConfiguration().getAttribute(ISCTLaunchParameters.OPERATION_CLASS, "");
				String[] split = classes.split(",");
				((JavaOperationMockup) mockup).initOperationCallbacks(project, split);
			}
			return factory.createExecutionContainer(statechart, launch);
		} catch (CoreException e) {
			e.printStackTrace();
			return null;
		}
	}

	protected Injector getInjector(Statechart statechart, ILaunch launch) {
		return DomainRegistry.getDomainDescriptor(statechart).getDomainInjectorProvider()
				.getSimulationInjector();
	}
}
