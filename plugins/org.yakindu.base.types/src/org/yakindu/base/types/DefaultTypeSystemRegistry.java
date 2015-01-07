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

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.yakindu.base.types.typesystem.ITypeSystem;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Singleton;

/**
 * The default implementation of {@link ITypeSystemRegistry}. Loads all type
 * systems contributed via extension point org.yakindu.base.types.typesystem
 * This class is not intended to be subclassed.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@Singleton
public class DefaultTypeSystemRegistry extends AbstractTypeSystemRegistry implements ITypeSystemRegistry {

	private static final String EXTENSION_POINT_ID = "org.yakindu.base.types.typesystem";
	private static final String ITYPESYSTEM_CLASS = "typesystem";
	private static final String DOMAIN_ID = "domainID";

	public DefaultTypeSystemRegistry() {
		init();
	}

	protected synchronized void loadFromExtension() {
		IConfigurationElement[] configurationElements = Platform.getExtensionRegistry().getConfigurationElementsFor(
				EXTENSION_POINT_ID);
		for (IConfigurationElement element : configurationElements) {
			try {
				ITypeSystem typeSystem = (ITypeSystem) element.createExecutableExtension(ITYPESYSTEM_CLASS);
				Guice.createInjector(new AbstractModule() {
					@Override
					protected void configure() {
						bind(ITypeSystemRegistry.class).toInstance(DefaultTypeSystemRegistry.this);
					}
				}).injectMembers(typeSystem);
				String attribute = element.getAttribute(DOMAIN_ID);
				Assert.isNotNull(attribute);
				addTypeSystem(attribute, typeSystem);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void init() {
		loadFromExtension();
		Iterable<ITypeSystem> allTypeSystems = getAllTypeSystems();
		for (ITypeSystem iTypeSystem : allTypeSystems) {
			iTypeSystem.init();
		}
	}
}
