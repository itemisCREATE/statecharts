/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.simulation.core;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.yakindu.sct.simulation.core.hmr.SCTHotModelReplacementManager;

public class SimulationCoreActivator extends Plugin implements BundleActivator {

	public static final String PLUGIN_ID = "org.yakindu.sct.simulation.core";

	private static SimulationCoreActivator plugin;
		

	public void start(BundleContext bundleContext) throws Exception {
		super.start(bundleContext);
		plugin = this;
		SCTHotModelReplacementManager.INSTANCE.startup();
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		super.stop(bundleContext);
		plugin = this;
		SCTHotModelReplacementManager.INSTANCE.tearDown();
	}
	
	public static SimulationCoreActivator getDefault() {
		return plugin;
	}

}
