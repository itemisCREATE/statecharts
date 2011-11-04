package org.yakindu.sct.generator.base.internal;

import static com.google.common.collect.Iterables.transform;
import static com.google.common.collect.Lists.newArrayList;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.yakindu.sct.generator.base.AbstractSCTGenerator;

import com.google.common.base.Function;

/**
 * 
 * 
 * @author holger willebrandt - Initial contribution and API
 */
public class GeneratorExtensions {

	private static final String EXTENSION_POINT_ID = "org.yakindu.sct.builder.generator";
	private static final String ATTRIBUTE_CLASS = "class";
	private static final String ATTRIBUTE_RESOURCE_EXTENSION = "resourceExtension";

	public static class GeneratorDescriptor {
		private final IConfigurationElement configElement;

		GeneratorDescriptor(IConfigurationElement configElement) {
			this.configElement = configElement;
		}

		public AbstractSCTGenerator<?> getGenerator() throws CoreException {
			return (AbstractSCTGenerator<?>) configElement
					.createExecutableExtension(ATTRIBUTE_CLASS);
		}

		public String getResourceExtension() {
			return configElement.getAttribute(ATTRIBUTE_RESOURCE_EXTENSION);
		}
	}

	public static Iterable<GeneratorDescriptor> getGeneratorDescriptors() {
		IConfigurationElement[] configurationElements = Platform
				.getExtensionRegistry().getConfigurationElementsFor(
						EXTENSION_POINT_ID);
		return transform(newArrayList(configurationElements),
				new CreateGeneratorDescritor());
	}

	private static final class CreateGeneratorDescritor implements
			Function<IConfigurationElement, GeneratorDescriptor> {
		CreateGeneratorDescritor() {
		}

		public GeneratorDescriptor apply(IConfigurationElement from) {
			return new GeneratorDescriptor(from);
		}
	}

}
