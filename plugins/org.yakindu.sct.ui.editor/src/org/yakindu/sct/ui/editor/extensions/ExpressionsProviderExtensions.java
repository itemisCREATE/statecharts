/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.extensions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EClass;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ExpressionsProviderExtensions {

	private static final String EXPRESSIONS_EXTENSION = "org.yakindu.sct.ui.editor.expressions";

	protected ExpressionsProviderExtensions() {
		// Not intended to be instantiated
	}

	/**
	 * Returns all registered {@link IExpressionsProvider}s 
	 * @param type
	 * @param resourceUri
	 * @return
	 */
	public static IExpressionsProvider getRegisteredProvider(EClass type,
			String resourceUri) {
		List<IExpressionsProvider> loadRegisteredProvider = loadRegisteredProvider();
		for (IExpressionsProvider t : loadRegisteredProvider) {
			if (t.isProviderFor(type, resourceUri)) {
				return t;
			}
		}
		return null;
	}

	protected static List<IExpressionsProvider> loadRegisteredProvider() {
		List<IExpressionsProvider> providers = new ArrayList<IExpressionsProvider>();
		IConfigurationElement[] configurationElements = Platform
				.getExtensionRegistry().getConfigurationElementsFor(
						EXPRESSIONS_EXTENSION);
		for (IConfigurationElement configurationElement : configurationElements) {
			try {
				IExpressionsProvider provider = (IExpressionsProvider) configurationElement
						.createExecutableExtension("class");
				providers.add(provider);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		return providers;
	}
}
