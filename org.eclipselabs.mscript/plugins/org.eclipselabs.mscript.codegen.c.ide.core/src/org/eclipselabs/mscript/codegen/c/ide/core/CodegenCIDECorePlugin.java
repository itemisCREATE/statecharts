package org.eclipselabs.mscript.codegen.c.ide.core;

import org.eclipse.core.runtime.Plugin;
import org.eclipselabs.mscript.language.MscriptRuntimeModule;
import org.eclipselabs.mscript.language.parser.antlr.MscriptParser;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class CodegenCIDECorePlugin extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipselabs.mscript.codegen.c.ide.core";

	// The shared instance
	private static CodegenCIDECorePlugin plugin;
	
	private MscriptParser mscriptParser;

	/**
	 * The constructor
	 */
	public CodegenCIDECorePlugin() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;

		Injector injector = Guice.createInjector(new MscriptRuntimeModule());
		mscriptParser = injector.getInstance(MscriptParser.class);
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
	public static CodegenCIDECorePlugin getDefault() {
		return plugin;
	}

	/**
	 * @return the mscriptParser
	 */
	public MscriptParser getMscriptParser() {
		return mscriptParser;
	}

}
