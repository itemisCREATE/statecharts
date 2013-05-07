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

import java.util.NoSuchElementException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.graphics.Image;
import org.yakindu.sct.generator.core.ISCTGenerator;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * @author holger willebrandt - Initial contribution and API
 */
public class GeneratorExtensions {

	private static final String EXTENSION_POINT_ID = "org.yakindu.sct.generator.core.generator";
	private static final String ATTRIBUTE_CLASS = "class";
	private static final String ATTRIBUTE_ID = "id";
	private static final String ATTRIBUTE_NAME = "name";
	private static final String ATTRIBUTE_CONTENT_TYPE = "contentType";
	private static final String ATTRIBUTE_ELEMENT_REF_TYPE = "elementRefType";
	@SuppressWarnings("unused")
	private static final String ATTRIBUTE_ICON = "icon";

	private static Iterable<GeneratorDescriptor> generatorDescriptors;

	public static class GeneratorDescriptor {
		private final IConfigurationElement configElement;

		GeneratorDescriptor(IConfigurationElement configElement) {
			this.configElement = configElement;
		}

		public ISCTGenerator createGenerator() {
			try {
				return (ISCTGenerator) configElement.createExecutableExtension(ATTRIBUTE_CLASS);
			} catch (CoreException e) {
				e.printStackTrace();
			}
			return null;
		}

		public String getId() {
			return configElement.getAttribute(ATTRIBUTE_ID);
		}

		public String getName() {
			return configElement.getAttribute(ATTRIBUTE_NAME);
		}

		public Image getImage() {
			return null;
		}

		public String getContentType() {
			return configElement.getAttribute(ATTRIBUTE_CONTENT_TYPE);
		}

		public String getElementRefType() {
			try {
				return configElement.getAttribute(ATTRIBUTE_ELEMENT_REF_TYPE);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}

		@Override
		public int hashCode() {
			String id = getId();
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			GeneratorDescriptor other = (GeneratorDescriptor) obj;
			String id = getId();
			if (id == null) {
				if (other.getId() != null) {
					return false;
				}
			} else if (!id.equals(other.getId())) {
				return false;
			}
			return true;
		}

	}

	public static Iterable<GeneratorDescriptor> getGeneratorDescriptors() {
		IConfigurationElement[] configurationElements = Platform.getExtensionRegistry().getConfigurationElementsFor(
				EXTENSION_POINT_ID);
		if (generatorDescriptors == null) {
			generatorDescriptors = transform(newArrayList(configurationElements), new CreateGeneratorDescriptor());
		}
		return generatorDescriptors;
	}

	/**
	 * returns the Generator Descriptor for the given generator id, or null, if
	 * the id is unknown
	 */
	public static GeneratorDescriptor getGeneratorDescriptorForId(final String generatorId) {
		try {
			return Iterables.find(getGeneratorDescriptors(), new Predicate<GeneratorDescriptor>() {
				public boolean apply(GeneratorDescriptor input) {
					return input != null && input.getId() != null && input.getId().equals(generatorId);
				}
			});
		} catch (NoSuchElementException ex) {
			return null;
		}
	}

	private static final class CreateGeneratorDescriptor implements
			Function<IConfigurationElement, GeneratorDescriptor> {

		public GeneratorDescriptor apply(IConfigurationElement from) {
			return new GeneratorDescriptor(from);
		}
	}

}
