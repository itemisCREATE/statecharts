package org.yakindu.sct.ui.simulation;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.yakindu.sct.core.simulation.SGraphSimulationSessionRegistry;
import org.yakindu.sct.ui.simulation.editor.HighlightingExecutionListener;

public class SimulationActivator extends AbstractUIPlugin {

	public static final String PLUGIN_ID = "org.yakindu.sct.statechart.simulation.ui"; //$NON-NLS-1$

	private static SimulationActivator plugin;

	public SimulationActivator() {
	}

	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		
		SGraphSimulationSessionRegistry.INSTANCE.getListeners().add(
				new HighlightingExecutionListener());
	}

	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	public static SimulationActivator getDefault() {
		return plugin;
	}

}
