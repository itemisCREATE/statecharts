/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.core.extensions;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.yakindu.sct.generator.core.features.IDefaultFeatureValueProvider;
import org.yakindu.sct.model.sgen.FeatureTypeLibrary;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class LibraryExtensions {

	private static final String EXTENSION_POINT_ID = "org.yakindu.sct.generator.core.featuretypes";
	private static final String ATTRIBUTE_URI = "uri";
	private static final String ATTRIBUTE_LIBRARY_ID = "library_id";
	private static final String DEFAULT_PROVIDER = "defaultProvider";

	public static final String GLOBAL_ID = "ALL";

	private static List<ILibraryDescriptor> descriptors;

	private static class LibraryDescriptor implements ILibraryDescriptor {
		private final IConfigurationElement configElement;

		LibraryDescriptor(IConfigurationElement configElement) {
			this.configElement = configElement;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.yakindu.sct.generator.core.extensions.ILibraryDescriptor#getURI()
		 */
		@Override
		public URI getURI() {
			return URI.createURI(configElement.getAttribute(ATTRIBUTE_URI));
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.yakindu.sct.generator.core.extensions.ILibraryDescriptor#
		 * getLibraryId()
		 */
		@Override
		public String getLibraryId() {
			return configElement.getAttribute(ATTRIBUTE_LIBRARY_ID);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.yakindu.sct.generator.core.extensions.ILibraryDescriptor#
		 * createFeatureValueProvider()
		 */
		@Override
		public IDefaultFeatureValueProvider createFeatureValueProvider() {
			try {
				return (IDefaultFeatureValueProvider) configElement.createExecutableExtension(DEFAULT_PROVIDER);
			} catch (CoreException e) {
				e.printStackTrace();
			}
			return null;
		}
	}

	public static List<ILibraryDescriptor> getLibraryDescriptors() {

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
			descriptors.add(new LibraryDescriptor(iConfigurationElement));
		}
	}

	public static List<ILibraryDescriptor> getLibraryDescriptors(final List<String> libraryIds) {
		Iterable<ILibraryDescriptor> libraryDescriptor = getLibraryDescriptors();
		return Lists.newArrayList(Iterables.filter(libraryDescriptor, new Predicate<ILibraryDescriptor>() {
			public boolean apply(ILibraryDescriptor input) {
				for (String libId : libraryIds) {
					if (input.getLibraryId().equals(libId)) {
						return true;
					}
				}
				return false;
			}
		}));
	}

	public static IDefaultFeatureValueProvider getDefaultFeatureValueProvider(List<String> libraryId,
			FeatureTypeLibrary library) {
		List<ILibraryDescriptor> libraryDescriptor = getLibraryDescriptors(libraryId);
		for (ILibraryDescriptor desc : libraryDescriptor) {
			IDefaultFeatureValueProvider defaultProvider = desc.createFeatureValueProvider();
			if (defaultProvider != null && defaultProvider.isProviderFor(library)) {
				return defaultProvider;
			}
		}
		return null;
	}

}
