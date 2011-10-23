package org.eclipselabs.damos.mscript.codegen.c.ide.ui;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class CodegenCIDEUIPlugin extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipselabs.mscript.codegen.c.ide.ui";

	// The shared instance
	private static CodegenCIDEUIPlugin plugin;
	
	/**
	 * The constructor
	 */
	public CodegenCIDEUIPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
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
	public static CodegenCIDEUIPlugin getDefault() {
		return plugin;
	}

}
