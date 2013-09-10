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
package org.yakindu.sct.simulation.core.sexec.launch;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.simulation.core.engine.ISimulationEngine;
import org.yakindu.sct.simulation.core.launch.AbstractSCTLaunchConfigurationDelegate;
import org.yakindu.sct.simulation.core.sexec.SimulationModule;
import org.yakindu.sct.simulation.core.sexec.container.ISimulationEngineFactory;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Module;
import com.google.inject.util.Modules;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SexecLaunchConfigurationDelegate extends AbstractSCTLaunchConfigurationDelegate implements
		ILaunchConfigurationDelegate {

	@Inject
	private ISimulationEngineFactory factory;

	@Override
	protected ISimulationEngine createExecutionContainer(final ILaunch launch, Statechart statechart) {
		Module module = Modules.override(new SimulationModule()).with(new Module() {
			@Override
			public void configure(Binder binder) {
				binder.bind(ILaunch.class).toInstance(launch);
			}
		});
		Guice.createInjector(module).injectMembers(this);
		try {
			return factory.createExecutionContainer(statechart, launch);
		} catch (CoreException e) {
			e.printStackTrace();
			return null;
		}
	}

}
