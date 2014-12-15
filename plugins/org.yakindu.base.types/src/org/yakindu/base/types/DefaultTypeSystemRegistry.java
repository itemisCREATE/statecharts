/**
 * Copyright (c) 2014 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.base.types;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.yakindu.base.types.typesystem.ITypeSystem;

import com.google.inject.Singleton;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@Singleton
public class DefaultTypeSystemRegistry implements ITypeSystemRegistry {

	private static final String EXTENSION_POINT_ID = "org.yakindu.base.types.typesystem";
	private static final String ITYPESYSTEM_CLASS = "typesystem";
	private static final String URI_SCHEME = "scheme";

	private Map<String, ITypeSystem> typeSystemRegistry = new HashMap<String, ITypeSystem>(3);

	public DefaultTypeSystemRegistry() {
		loadFromExtension();
	}

	@Override
	public ITypeSystem getTypeSystem(String uriScheme) {
		return typeSystemRegistry.get(uriScheme);
	}

	public void addTypeSystem(String uriScheme, ITypeSystem system) {
		typeSystemRegistry.put(uriScheme, system);
	}

	public void removeTypeSystem(String uriScheme) {
		typeSystemRegistry.remove(uriScheme);
	}

	protected void loadFromExtension() {
		IConfigurationElement[] configurationElements = Platform.getExtensionRegistry().getConfigurationElementsFor(
				EXTENSION_POINT_ID);
		for (IConfigurationElement element : configurationElements) {
			try {
				addTypeSystem(element.getAttribute(URI_SCHEME),
						(ITypeSystem) element.createExecutableExtension(ITYPESYSTEM_CLASS));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public Iterable<ITypeSystem> getAllTypeSystems() {
		return typeSystemRegistry.values();
	}
}
