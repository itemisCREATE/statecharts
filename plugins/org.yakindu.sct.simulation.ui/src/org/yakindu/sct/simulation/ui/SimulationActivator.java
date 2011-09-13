package org.yakindu.sct.simulation.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.yakindu.sct.simulation.core.hmr.SCTHotModelReplacementManager;
import org.yakindu.sct.simulation.ui.dialogs.HotModelReplacementListener;

public class SimulationActivator extends AbstractUIPlugin {

	public static final String PLUGIN_ID = "org.yakindu.sct.statechart.simulation.ui"; //$NON-NLS-1$

	private static SimulationActivator plugin;

	private HotModelReplacementListener hotModelReplacementListener;

	public SimulationActivator() {
		hotModelReplacementListener = new HotModelReplacementListener();
	}

	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		SCTHotModelReplacementManager.INSTANCE
				.addReplacementListener(hotModelReplacementListener);
	}

	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
		SCTHotModelReplacementManager.INSTANCE
				.removeReplacementListener(hotModelReplacementListener);
	}

	public static SimulationActivator getDefault() {
		return plugin;
	}

}
