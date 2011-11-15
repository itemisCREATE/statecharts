package org.yakindu.sct.generator.core.features;

import static com.google.common.collect.Iterables.transform;
import static com.google.common.collect.Lists.newArrayList;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class LibraryExtensions {

	private static final String EXTENSION_POINT_ID = "org.yakindu.sct.generator.genmodel.featuretypes";
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

	private static final class CreateLibraryDescriptor implements
			Function<IConfigurationElement, LibraryDescriptor> {

		public LibraryDescriptor apply(IConfigurationElement from) {
			return new LibraryDescriptor(from);
		}
	}

}
