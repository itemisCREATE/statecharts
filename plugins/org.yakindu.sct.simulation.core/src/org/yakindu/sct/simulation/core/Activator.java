package org.yakindu.sct.simulation.core;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.yakindu.sct.simulation.core.hmr.SCTHotModelReplacementManager;

public class Activator implements BundleActivator {

	private static BundleContext context;

	public static final String PLUGIN_ID = "org.yakindu.sct.simulation.core";

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		SCTHotModelReplacementManager.INSTANCE.startup();
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		SCTHotModelReplacementManager.INSTANCE.tearDown();
	}

}
