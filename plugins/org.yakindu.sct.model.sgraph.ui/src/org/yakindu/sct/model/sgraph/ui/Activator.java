package org.yakindu.sct.model.sgraph.ui;

import static com.google.inject.util.Modules.override;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.osgi.framework.BundleContext;
import org.yakindu.sct.model.sgraph.SGraphRuntimeModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.yakindu.sct.model.sgraph.ui"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	private Injector injector;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		injector = createInjector();
	}

	protected Injector createInjector() {
		return Guice.createInjector(override(
				override(new SGraphRuntimeModule()).with(
						new SharedStateModule()))
				.with(new SGraphUiModule(this)));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
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
	public static Activator getDefault() {
		return plugin;
	}

	public Injector getInjector() {
		return injector;
	}
}
