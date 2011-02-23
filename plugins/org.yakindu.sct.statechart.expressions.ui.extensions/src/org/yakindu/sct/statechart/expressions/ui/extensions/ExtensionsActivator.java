package org.yakindu.sct.statechart.expressions.ui.extensions;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.osgi.framework.BundleContext;
import org.yakindu.sct.statechart.ExpressionsRuntimeModule;
import org.yakindu.sct.statechart.ui.ExpressionsUiModule;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.util.Modules;

/**
 * The activator class controls the plug-in life cycle
 */
public class ExtensionsActivator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.yakindu.sct.statechart.expressions.ui.extensions"; //$NON-NLS-1$

	// The shared instance
	private static ExtensionsActivator plugin;
	
	/**
	 * The constructor
	 */
	public ExtensionsActivator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static ExtensionsActivator getDefault() {
		return plugin;
	}
	
	public Injector getExpressionsInjector() {
		Injector injector =  Guice.createInjector(Modules.override(
				Modules.override(
						Modules.override(new ExpressionsRuntimeModule()).with(
								new ExpressionsUiModule(this))).with(
						new SharedStateModule())).with());
		return injector;
	}

}
