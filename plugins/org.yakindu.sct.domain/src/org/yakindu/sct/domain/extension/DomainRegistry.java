/**
 * Copyright (c) 2015 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.domain.extension;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.xtext.EcoreUtil2;
import org.osgi.framework.Bundle;
import org.yakindu.base.base.BasePackage;
import org.yakindu.base.base.DomainElement;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.util.Modules;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class DomainRegistry {

	private static final String DOMAIN_EXTENSION_POINT_ID = "org.yakindu.sct.domain";
	private static final String MODULES_EXTENSION_POINT_ID = "org.yakindu.sct.domain.modules";

	private DomainRegistry() {
	}

	private static List<IDomain> domainDescriptors;
	private static List<IModule> moduleDescriptors;

	private static final class ConfigElementDomain implements IDomain {

		private static final String DOMAIN_ID = "domainID";
		private static final String DESCRIPTION = "description";
		private static final String IMAGE = "image";
		private static final String NAME = "name";

		private final IConfigurationElement configElement;

		private URL image;

		ConfigElementDomain(IConfigurationElement configElement) {
			this.configElement = configElement;
		}

		@Override
		public String getDomainID() {
			return configElement.getAttribute(DOMAIN_ID);
		}

		@Override
		public String getName() {
			return configElement.getAttribute(NAME);
		}

		@Override
		public String getDescription() {
			return configElement.getAttribute(DESCRIPTION);
		}

		@Override
		public URL getImagePath() {
			if (image != null)
				return image;
			String path = configElement.getAttribute(IMAGE);
			if (path == null)
				return null;
			Bundle extensionBundle = Platform.getBundle(configElement.getContributor().getName());
			image = extensionBundle.getEntry(path);
			return image;
		}

		@Override
		public Injector getInjector(String feature, String... options) {
			return getInjector(feature, null, options);
		}

		@Override
		public Injector getInjector(String feature, Module overrides, String... options) {
			List<Module> modules = new ArrayList<>();
			for (IModule module : moduleDescriptors) {
				if (getDomainID().equals(module.getDomainID()) && feature.equals(module.getFeature())) {
					modules.add(module.getModuleProvider().getModule(options));
				}
			}
			Module result = Modules.combine(modules);
			if (overrides != null)
				result = Modules.override(result).with(overrides);
			return Guice.createInjector(result);
		}

	}

	private static final class ConfigElementModule implements IModule {

		private static final String DOMAIN_ID = "domainID";
		private static final String FEATURE = "feature";
		private static final String MODULE_PROVIDER = "moduleProvider";
		private final IConfigurationElement configElement;

		public ConfigElementModule(IConfigurationElement configElement) {
			this.configElement = configElement;
		}

		@Override
		public String getDomainID() {
			return configElement.getAttribute(DOMAIN_ID);
		}

		@Override
		public String getFeature() {
			return configElement.getAttribute(FEATURE);
		}

		@Override
		public IModuleProvider getModuleProvider() {
			try {
				return (IModuleProvider) configElement.createExecutableExtension(MODULE_PROVIDER);
			} catch (CoreException e) {
				e.printStackTrace();
			}
			return null;
		}

	}

	public static List<IDomain> getDomains() {
		if (domainDescriptors == null) {
			domainDescriptors = Lists.newArrayList();
			moduleDescriptors = Lists.newArrayList();
			if (Platform.isRunning()) {
				initFromExtensions();
			}
		}
		return domainDescriptors;
	}

	protected static void initFromExtensions() {
		IConfigurationElement[] configurationElements = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(DOMAIN_EXTENSION_POINT_ID);
		for (IConfigurationElement iConfigurationElement : configurationElements) {
			domainDescriptors.add(new ConfigElementDomain(iConfigurationElement));
		}

		configurationElements = Platform.getExtensionRegistry().getConfigurationElementsFor(MODULES_EXTENSION_POINT_ID);
		for (IConfigurationElement iConfigurationElement : configurationElements) {
			moduleDescriptors.add(new ConfigElementModule(iConfigurationElement));
		}
	}

	public static IDomain getDomain(final String id) {
		final String defaultDomainID = BasePackage.Literals.DOMAIN_ELEMENT__DOMAIN_ID.getDefaultValueLiteral();
		try {
			return Iterables.find(getDomains(), new Predicate<IDomain>() {
				@Override
				public boolean apply(IDomain input) {
					return input.getDomainID().equals(id != null ? id : defaultDomainID);
				}
			});
		} catch (NoSuchElementException e) {
			if (defaultDomainID.equals(id)) {
				throw new IllegalArgumentException("No default domain found!");
			}
			System.err.println("Could not find domain descriptor for id " + id + " - > using default domain");
			return getDomain(defaultDomainID);
		}
	}

	public static IDomain getDomain(EObject object) {
		DomainElement domainElement = EcoreUtil2.getContainerOfType(object, DomainElement.class);
		String domainID = domainElement != null ? domainElement.getDomainID()
				: BasePackage.Literals.DOMAIN_ELEMENT__DOMAIN_ID.getDefaultValueLiteral();
		return getDomain(domainID);
	}

	public static String determineDomainID(URI uri) {
		String result = BasePackage.Literals.DOMAIN_ELEMENT__DOMAIN_ID.getDefaultValueLiteral();
		if (URIConverter.INSTANCE.exists(uri, null)) {
			XMIResource resource = new XMIResourceImpl(uri);
			try {
				resource.load(null);
				DomainElement element = (DomainElement) EcoreUtil.getObjectByType(resource.getContents(),
						BasePackage.Literals.DOMAIN_ELEMENT);
				String domainID = element.getDomainID();
				Assert.isNotNull(domainID);
				result = domainID;
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				resource.unload();
			}
		}
		return result;
	}
}
