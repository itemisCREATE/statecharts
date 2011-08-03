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
 * @param <T>
 */
public class Extensions<T extends ISCTProvider> {

	private final String extensionPointId;

	public Extensions(String extensionPointId) {
		this.extensionPointId = extensionPointId;
	}


	public T getRegisteredProvider(EClass type, String resourceUri) {
		List<T> loadRegisteredProvider = loadRegisteredProvider();
		for (T t : loadRegisteredProvider) {
			if (t.isProviderFor(type, resourceUri)) {
				return t;
			}
		}
		throw new IllegalStateException("No provider found for type" + type);

	}

	public List<T> loadRegisteredProvider() {
		List<T> providers = new ArrayList<T>();
		IConfigurationElement[] configurationElements = Platform
				.getExtensionRegistry().getConfigurationElementsFor(
						extensionPointId);
		for (IConfigurationElement configurationElement : configurationElements) {
			try {
				@SuppressWarnings("unchecked")
				T provider = (T) configurationElement
						.createExecutableExtension("class");
				providers.add(provider);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		return providers;
	}
}
