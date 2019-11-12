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

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.xtext.EcoreUtil2;
import org.osgi.framework.Bundle;
import org.yakindu.base.base.BasePackage;
import org.yakindu.base.base.DomainElement;
import org.yakindu.sct.domain.extension.DomainStatus.Severity;
import org.yakindu.sct.domain.extension.impl.DomainImpl;
import org.yakindu.sct.domain.extension.impl.ModuleContribution;
import org.yakindu.sct.model.sgraph.resource.FastStatechartAttributeParser;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Binder;
import com.google.inject.Module;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class DomainRegistry {

	private static final String DOMAIN_EXTENSION_POINT_ID = "org.yakindu.sct.domain";
	private static final String MODULES_EXTENSION_POINT_ID = "org.yakindu.sct.domain.modules";

	public static final String DOMAIN_ID = "domainID";
	private static final String DESCRIPTION = "description";
	private static final String IMAGE = "image";
	private static final String NAME = "name";
	private static final String DOMAIN_STATUS_PROVIDER = "domainStatusProvider";
	private static final String DOCU_PROVIDER = "documentationProvider";

	private static final String FEATURE = "feature";
	private static final String MODULE_PROVIDER = "moduleProvider";

	private DomainRegistry() {
	}

	private static List<IDomain> domainDescriptors;

	public static synchronized List<IDomain> getDomains() {
		if (domainDescriptors == null) {
			domainDescriptors = Lists.newArrayList();
			initFromExtensions();
		}
		return domainDescriptors;
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
			return getDomain(defaultDomainID);
		}
	}

	public static IDomain getDomain(EObject object) {
		DomainElement domainElement = EcoreUtil2.getContainerOfType(object, DomainElement.class);
		String domainID = domainElement != null ? domainElement.getDomainID()
				: BasePackage.Literals.DOMAIN_ELEMENT__DOMAIN_ID.getDefaultValueLiteral();
		return getDomain(domainID);
	}

	public static boolean domainExists(final String domainID) {
		try {
			Iterables.find(getDomains(), new Predicate<IDomain>() {
				@Override
				public boolean apply(IDomain input) {
					return input.getDomainID()
							.equals(domainID == null || domainID.isEmpty()
									? BasePackage.Literals.DOMAIN_ELEMENT__DOMAIN_ID.getDefaultValueLiteral()
									: domainID);
				}
			});
		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
	}

	public static String determineDomainID(URI uri) {
		if (URIConverter.INSTANCE.exists(uri, null)) {
			return FastStatechartAttributeParser.parse(uri, "domainID");
		}
		return BasePackage.Literals.DOMAIN_ELEMENT__DOMAIN_ID.getDefaultValueLiteral();
	}

	public static DomainStatus getDomainStatus(String domainID) {
		if (!DomainRegistry.domainExists(domainID)) {
			return new DomainStatus(Severity.ERROR,
					String.format(String.format("Domain '%s' is not available.", domainID)));
		} else {
			IDomain domain = DomainRegistry.getDomain(domainID);
			return domain.getAvailabilityStatus();
		}
	}

	protected static void initFromExtensions() {
		List<ModuleContribution> moduleDescriptors = new ArrayList<>();
		IConfigurationElement[] configurationElements = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(MODULES_EXTENSION_POINT_ID);
		for (IConfigurationElement element : configurationElements) {
			moduleDescriptors.add(createModuleContribution(element));
		}
		configurationElements = Platform.getExtensionRegistry().getConfigurationElementsFor(DOMAIN_EXTENSION_POINT_ID);
		for (IConfigurationElement iConfigurationElement : configurationElements) {
			domainDescriptors.add(createDomain(iConfigurationElement, moduleDescriptors));
		}
	}

	protected static ModuleContribution createModuleContribution(IConfigurationElement element) {
		IModuleProvider provider;
		provider = new ModuleProviderProxy(element);
		return new ModuleContribution(element.getAttribute(DOMAIN_ID), element.getAttribute(FEATURE), provider);
	}

	protected static IDomain createDomain(final IConfigurationElement element, List<ModuleContribution> allModules) {
		String path = element.getAttribute(IMAGE);
		URL image = null;
		if (path != null) {
			Bundle extensionBundle = Platform.getBundle(element.getContributor().getName());
			image = extensionBundle.getEntry(path);
		}
		IDomainStatusProvider statusProvider = new IDomainStatusProvider.DefaultDomainStatusProvider();
		if (element.getAttribute(DOMAIN_STATUS_PROVIDER) != null) {
			try {
				statusProvider = (IDomainStatusProvider) element.createExecutableExtension(DOMAIN_STATUS_PROVIDER);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}

		IDomainDocumentationProvider docuProvider = new IDomainDocumentationProvider.NullImpl();
		if (element.getAttribute(DOCU_PROVIDER) != null) {
			try {
				docuProvider = (IDomainDocumentationProvider) element.createExecutableExtension(DOCU_PROVIDER);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}

		return new DomainImpl(element.getAttribute(DOMAIN_ID), element.getAttribute(NAME),
				element.getAttribute(DESCRIPTION), image,
				Iterables.filter(allModules, new Predicate<ModuleContribution>() {
					@Override
					public boolean apply(ModuleContribution input) {
						return input.getDomainID().equals(element.getAttribute(DOMAIN_ID));
					}
				}), statusProvider, docuProvider);
	}

	protected static class ModuleProviderProxy implements IModuleProvider {

		private IConfigurationElement element;

		private IModuleProvider provider;

		public ModuleProviderProxy(IConfigurationElement element) {
			this.element = element;
		}

		@Override
		public Module getModule(String... options) throws IllegalArgumentException {
			if (provider == null) {
				try {
					provider = (IModuleProvider) element.createExecutableExtension(MODULE_PROVIDER);
				} catch (CoreException e) {
					e.printStackTrace();
					return new Module() {
						@Override
						public void configure(Binder binder) {
							//Return empty module if provider is configured wrong
						}
					};
				}
			}
			return provider.getModule(options);
		}
	}
}
