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
import java.util.List;
import java.util.NoSuchElementException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.EcoreUtil2;
import org.osgi.framework.Bundle;
import org.yakindu.base.xtext.utils.jface.viewers.ContextElementAdapter;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Statechart;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class DomainRegistry {

	private static final String EXTENSION_POINT_ID = "org.yakindu.sct.domain";
	private static final String DOMAIN_ID = "domainID";
	private static final String DESCRIPTION = "description";
	private static final String IMAGE = "image";
	private static final String NAME = "name";
	private static final String MODULE_PROVIDER = "domainModuleProvider";

	private DomainRegistry() {
	}

	private static List<IDomainDescriptor> descriptors;

	private static final class ConfigElementDomainDescriptor implements IDomainDescriptor {

		private final IConfigurationElement configElement;

		private Image image;

		private IDomainInjectorProvider injectorProvider;

		ConfigElementDomainDescriptor(IConfigurationElement configElement) {
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
		public IDomainInjectorProvider getDomainInjectorProvider() {
			if (injectorProvider == null) {
				try {
					injectorProvider = (IDomainInjectorProvider) configElement
							.createExecutableExtension(MODULE_PROVIDER);
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
			return injectorProvider;
		}

		@Override
		public Image getImage() {
			if (image != null)
				return image;
			String path = configElement.getAttribute(IMAGE);
			if (path == null)
				return null;

			Bundle extensionBundle = Platform.getBundle(configElement.getContributor().getName());
			URL entry = extensionBundle.getEntry(path);
			ImageDescriptor descriptor = ImageDescriptor.createFromURL(entry);
			image = descriptor.createImage();
			return image;
		}
	}

	public static List<IDomainDescriptor> getDomainDescriptors() {
		if (descriptors == null) {
			descriptors = Lists.newArrayList();
			if (Platform.isRunning()) {
				initFromExtensions();
			}
		}
		return descriptors;
	}

	protected static void initFromExtensions() {
		IConfigurationElement[] configurationElements = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(EXTENSION_POINT_ID);
		for (IConfigurationElement iConfigurationElement : configurationElements) {
			descriptors.add(new ConfigElementDomainDescriptor(iConfigurationElement));
		}
	}

	public static IDomainDescriptor getDomainDescriptor(final String id) {
		final String defaultDomainID = SGraphPackage.Literals.STATECHART__DOMAIN_ID.getDefaultValueLiteral();
		try {
			return Iterables.find(getDomainDescriptors(), new Predicate<IDomainDescriptor>() {
				@Override
				public boolean apply(IDomainDescriptor input) {
					return input.getDomainID().equals(id != null ? id : defaultDomainID);
				}
			});
		} catch (NoSuchElementException e) {
			if (defaultDomainID.equals(id)) {
				throw new IllegalArgumentException("No default domain found!");
			}
			System.err.println("Could not find domain descriptor for id " + id + " - > using default domain");
			return getDomainDescriptor(defaultDomainID);
		}
	}

	public static IDomainDescriptor getDomainDescriptor(EObject object) {
		EObject rootContainer = EcoreUtil.getRootContainer(object);
				if (rootContainer instanceof Statechart)
						return getDomainDescriptor(((Statechart) rootContainer).getDomainID());
					else {
						return getDomainDescriptor(((Statechart) getStatechart(object)).getDomainID());
					}
				}
				
				protected static Statechart getStatechart(EObject context) {
					final ContextElementAdapter provider = (ContextElementAdapter) EcoreUtil.getExistingAdapter(context.eResource(),
							ContextElementAdapter.class);
			
					if (provider == null) {
						return EcoreUtil2.getContainerOfType(context, Statechart.class);
					} else {
						return (Statechart) EcoreUtil.getObjectByType(provider.getElement().eResource().getContents(),
								SGraphPackage.Literals.STATECHART);
					}
				}
}
