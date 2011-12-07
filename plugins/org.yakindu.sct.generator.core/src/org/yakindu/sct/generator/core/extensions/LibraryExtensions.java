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

import static com.google.common.collect.Iterables.transform;
import static com.google.common.collect.Lists.newArrayList;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.yakindu.sct.generator.core.features.IDefaultFeatureValueProvider;
import org.yakindu.sct.model.sgen.FeatureTypeLibrary;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class LibraryExtensions {

	private static final String EXTENSION_POINT_ID = "org.yakindu.sct.generator.core.featuretypes";
	private static final String ATTRIBUTE_URI = "uri";
	private static final String ATTRIBUTE_GENERATOR_ID = "generatorId";
	private static final String DEFAULT_PROVIDER = "defaultProvider";

	public static final String GLOBAL_ID = "ALL";

	public static class LibraryDescriptor {
		private final IConfigurationElement configElement;

		LibraryDescriptor(IConfigurationElement configElement) {
			this.configElement = configElement;
		}

		public URI getURI() {
			return URI.createURI(configElement.getAttribute(ATTRIBUTE_URI));
		}

		public String getGeneratorId() {
			return configElement.getAttribute(ATTRIBUTE_GENERATOR_ID);
		}

		public IDefaultFeatureValueProvider createFeatureValueProvider() {
			try {
				return (IDefaultFeatureValueProvider) configElement
						.createExecutableExtension(DEFAULT_PROVIDER);
			} catch (CoreException e) {
				e.printStackTrace();
			}
			return null;
		}
	}

	public static Iterable<LibraryDescriptor> getLibraryDescriptor() {
		IConfigurationElement[] configurationElements = Platform
				.getExtensionRegistry().getConfigurationElementsFor(
						EXTENSION_POINT_ID);
		return transform(newArrayList(configurationElements),
				new CreateLibraryDescriptor());
	}

	public static Iterable<LibraryDescriptor> getLibraryDescriptor(
			final String generatorId) {
		Iterable<LibraryDescriptor> libraryDescriptor = LibraryExtensions
				.getLibraryDescriptor();
		return Iterables.filter(libraryDescriptor,
				new Predicate<LibraryDescriptor>() {
					public boolean apply(LibraryDescriptor input) {
						return input.getGeneratorId().equals(generatorId)
								|| input.getGeneratorId().equals(GLOBAL_ID);
					}
				});
	}

	public static IDefaultFeatureValueProvider getDefaultFeatureValueProvider(
			String generatorId, FeatureTypeLibrary library) {
		Iterable<LibraryDescriptor> libraryDescriptor = getLibraryDescriptor(generatorId);
		for (LibraryDescriptor desc : libraryDescriptor) {
			IDefaultFeatureValueProvider defaultProvider = desc
					.createFeatureValueProvider();
			if (defaultProvider != null
					&& defaultProvider.isProviderFor(library)) {
				return defaultProvider;
			}
		}
		return null;
	}

	private static final class CreateLibraryDescriptor implements
			Function<IConfigurationElement, LibraryDescriptor> {

		public LibraryDescriptor apply(IConfigurationElement from) {
			return new LibraryDescriptor(from);
		}
	}

}
