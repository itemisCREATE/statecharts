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
import org.yakindu.sct.domain.extension.DomainStatus.Severity;
import org.yakindu.sct.domain.extension.impl.DomainImpl;
import org.yakindu.sct.domain.extension.impl.ModuleContribution;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

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

	private static final String FEATURE = "feature";
	private static final String MODULE_PROVIDER = "moduleProvider";

	private DomainRegistry() {
	}

	private static List<IDomain> domainDescriptors;

	public static List<IDomain> getDomains() {
		if (domainDescriptors == null) {
			domainDescriptors = Lists.newArrayList();
			if (Platform.isRunning()) {
				initFromExtensions();
			}
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
					return input.getDomainID().equals(domainID == null || domainID.isEmpty()
							? BasePackage.Literals.DOMAIN_ELEMENT__DOMAIN_ID.getDefaultValueLiteral() : domainID);
				}
			});
		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
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
		try {
			provider = (IModuleProvider) element.createExecutableExtension(MODULE_PROVIDER);
			return new ModuleContribution(element.getAttribute(DOMAIN_ID), element.getAttribute(FEATURE), provider);
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return null;
	}

	protected static IDomain createDomain(final IConfigurationElement element, List<ModuleContribution> allModules) {
		String path = element.getAttribute(IMAGE);
		URL image = null;
		if (path != null) {
			Bundle extensionBundle = Platform.getBundle(element.getContributor().getName());
			image = extensionBundle.getEntry(path);
		}
		IDomainStatusProvider provider = new IDomainStatusProvider.DefaultDomainStatusProvider();
		if (element.getAttribute(DOMAIN_STATUS_PROVIDER) != null) {
			try {
				provider = (IDomainStatusProvider) element.createExecutableExtension(DOMAIN_STATUS_PROVIDER);
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
				}), provider);
	}
}
