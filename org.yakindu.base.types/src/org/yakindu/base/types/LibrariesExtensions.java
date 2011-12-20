/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Alexander Nyssen (itemis AG) - initial API and implementation
 */
package org.yakindu.base.types;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;

/**
 * 
 * @author Alexander Ny§en
 * 
 */
public class LibrariesExtensions {

	private static final String EXTENSION_POINT_ID = "org.yakindu.base.types.libraries";
	private static final String ATTRIBUTE_URI = "uri";

	public static Iterable<URI> getRegisteredTypeLibrariesURIs() {
		List<URI> uris = new ArrayList<URI>();
		IConfigurationElement[] registeredConfigElements = getRegisteredConfigElements();
		for (IConfigurationElement configElement : registeredConfigElements) {
			uris.add(URI.createURI(configElement
					.getAttribute(ATTRIBUTE_URI)));
		}
		return uris;
	}

	public static IConfigurationElement[] getRegisteredConfigElements() {
		return Platform.getExtensionRegistry().getConfigurationElementsFor(
				EXTENSION_POINT_ID);
	}

}
