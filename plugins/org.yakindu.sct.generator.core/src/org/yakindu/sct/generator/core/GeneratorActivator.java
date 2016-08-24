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
package org.yakindu.sct.generator.core;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class GeneratorActivator extends Plugin {

	public static final String PLUGIN_ID = "org.yakindu.sct.generator.core"; //$NON-NLS-1$

	// The shared instance
	private static GeneratorActivator plugin;
	// Preference constant for automatic code generation
	public static final String PREF_GENERATE_AUTOMATICALLY = "generate.automatically";

	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	public static GeneratorActivator getDefault() {
		return plugin;
	}

}
