/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.simulation.core.extensions;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.yakindu.sct.simulation.core.language.ISCLanguageProvider;
import org.yakindu.sct.simulation.core.language.SCLanguageProviders;

/**
 * Utility class that handles the languageprovider extension point.
 * 
 * @author terfloth - Initial contribution and API
 * 
 */
public class SCLanguageProviderExtensions {

	private static final String EXTENSION_POINT_ID = "org.yakindu.sct.simulation.core.languageprovider";
	private static final String ATTRIBUTE_CLASS = "class";

	/**
	 * Creates a new {@link SCLanguageProviders} instance from the registered extensions.
	 * 
	 * @return {@link SCLanguageProviders} instance
	 */
	public static SCLanguageProviders getLanguageProviders() {
		SCLanguageProviders providers = new SCLanguageProviders();
		
		IConfigurationElement[] configurationElements = Platform
				.getExtensionRegistry().getConfigurationElementsFor(
						EXTENSION_POINT_ID);

		for (int i = 0; i < configurationElements.length; i++) {
			try {
				ISCLanguageProvider provider = (ISCLanguageProvider) configurationElements[i]
						.createExecutableExtension(ATTRIBUTE_CLASS);
				providers.addLanguageProvider(provider);
			} catch (CoreException e) {
				e.printStackTrace();
			}
			
		}
		
		return providers;
	}

}
