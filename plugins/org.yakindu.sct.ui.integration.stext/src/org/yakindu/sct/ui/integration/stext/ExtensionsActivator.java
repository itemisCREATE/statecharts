package org.yakindu.sct.ui.integration.stext;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class ExtensionsActivator extends AbstractUIPlugin {

	public static final String PLUGIN_ID = "org.yakindu.sct.statechart.expressions.ui.extensions"; //$NON-NLS-1$

	private static ExtensionsActivator plugin;

	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	public static ExtensionsActivator getDefault() {
		return plugin;
	}

}
