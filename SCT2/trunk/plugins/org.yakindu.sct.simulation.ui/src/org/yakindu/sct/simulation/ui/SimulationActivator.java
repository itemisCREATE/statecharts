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
package org.yakindu.sct.simulation.ui;

import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.yakindu.sct.simulation.core.hmr.SCTHotModelReplacementManager;
import org.yakindu.sct.simulation.ui.dialogs.HotModelReplacementListener;
import org.yakindu.sct.simulation.ui.perspective.SCTPerspectiveManager;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SimulationActivator extends AbstractUIPlugin {

	public static final String PLUGIN_ID = "org.yakindu.sct.statechart.simulation.ui"; //$NON-NLS-1$

	private static SimulationActivator plugin;

	private HotModelReplacementListener hotModelReplacementListener;

	private SCTPerspectiveManager manager;

	public SimulationActivator() {
		hotModelReplacementListener = new HotModelReplacementListener();
		manager = new SCTPerspectiveManager();
	}

	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		SCTHotModelReplacementManager.INSTANCE.addReplacementListener(hotModelReplacementListener);
	}

	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
		SCTHotModelReplacementManager.INSTANCE.removeReplacementListener(hotModelReplacementListener);
		DebugPlugin.getDefault().getLaunchManager().addLaunchListener(manager);
	}

	public static SimulationActivator getDefault() {
		return plugin;
	}

}
