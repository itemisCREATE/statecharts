/**
 * Copyright (c) 2012 committers of YAKINDU and others.
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

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class FileExtensions {

	private static final String EXTENSION_POINT_ID = "org.yakindu.sct.generator.core.extensions";
	private static final String FILE_EXTENSION = "fileExtension";
	private static final String GENERATOR_ID = "generatorId";

	private static Iterable<FileExtensionDescriptor> generatorDescriptors;

	public static class FileExtensionDescriptor {
		private final IConfigurationElement configElement;

		FileExtensionDescriptor(IConfigurationElement configElement) {
			this.configElement = configElement;
		}

		public String getExtension() {
			return configElement.getAttribute(FILE_EXTENSION);
		}

		public String getGeneratorId() {
			return configElement.getAttribute(GENERATOR_ID);
		}

	}

	public static Iterable<FileExtensionDescriptor> getFileExtensions() {
		IConfigurationElement[] configurationElements = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_POINT_ID);
		if (generatorDescriptors == null) {
			generatorDescriptors = transform(newArrayList(configurationElements), new CreateFileExtensions());
		}
		return generatorDescriptors;
	}

	public static String getFileExtension(final String generatorId) {
		FileExtensionDescriptor descriptor = Iterables.find(getFileExtensions(), new Predicate<FileExtensionDescriptor>() {
			public boolean apply(FileExtensionDescriptor input) {
				return generatorId.equals(input.getGeneratorId());
			}
		});
		return descriptor.getExtension();
	}

	public static String getGeneratorForFileExtension(String extension) {

		IConfigurationElement[] configurationElements = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_POINT_ID);

		for (IConfigurationElement x : configurationElements) {
			if (x.getAttribute(FILE_EXTENSION).equals(extension)) {
				return x.getAttribute(GENERATOR_ID);
			}
		}
		return null;
	}

	private static final class CreateFileExtensions implements Function<IConfigurationElement, FileExtensionDescriptor> {

		public FileExtensionDescriptor apply(IConfigurationElement from) {
			return new FileExtensionDescriptor(from);
		}
	}

}
