/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.examples.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ExampleActivator extends AbstractUIPlugin implements BundleActivator {

	public static final String PLUGIN_ID = "org.yakindu.sct.examples.ui";

	private static BundleContext context;

	private static ExampleActivator plugin;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		plugin = this;
		ExampleActivator.context = bundleContext;
	}

	public void stop(BundleContext bundleContext) throws Exception {
		plugin = null;
		ExampleActivator.context = null;
	}

	public static ExampleActivator getDefault() {
		return plugin;
	}
}
