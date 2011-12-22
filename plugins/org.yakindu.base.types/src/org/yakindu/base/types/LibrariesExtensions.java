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
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.osgi.framework.Bundle;

/**
 * 
 * @author Alexander Ny§en
 * 
 */
public class LibrariesExtensions {

	private static final String EXTENSION_POINT_ID = "org.yakindu.base.types.libraries";
	private static final String ATTRIBUTE_LOCATION = "location";
	
	public static Iterable<LibraryDescriptor> getRegisteredTypeLibraries() {
		List<LibraryDescriptor> descriptors = new ArrayList<LibraryDescriptor>();
		IConfigurationElement[] registeredConfigElements = getRegisteredConfigElements();
		for (IConfigurationElement configElement : registeredConfigElements) {
			IContributor contributor = configElement.getContributor();
			Bundle bundle = Platform.getBundle(contributor.getName());
			URI location = URI.createPlatformPluginURI(bundle.getSymbolicName() + "/" + configElement
					.getAttribute(ATTRIBUTE_LOCATION), true);
			descriptors.add(new LibraryDescriptor(location, bundle));
		}
		return descriptors;
	}

	public static IConfigurationElement[] getRegisteredConfigElements() {
		return Platform.getExtensionRegistry().getConfigurationElementsFor(
				EXTENSION_POINT_ID);
	}
}
