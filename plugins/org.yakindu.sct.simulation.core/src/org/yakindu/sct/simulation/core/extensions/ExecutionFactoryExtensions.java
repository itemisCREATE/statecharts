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
package org.yakindu.sct.simulation.core.extensions;

import static com.google.common.collect.Iterables.transform;
import static com.google.common.collect.Lists.newArrayList;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.yakindu.sct.simulation.core.runtime.IExecutionFacadeFactory;

import com.google.common.base.Function;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ExecutionFactoryExtensions {

	private static final String EXTENSION_POINT_ID = "org.yakindu.sct.simulation.core.executionfactory";
	private static final String ATTRIBUTE_CLASS = "class";

	public static class ExecutionFactoryDescriptor {

		private final IConfigurationElement configElement;

		ExecutionFactoryDescriptor(IConfigurationElement configElement) {
			this.configElement = configElement;
		}

		public IExecutionFacadeFactory createExecutableExtensionFactory() {
			try {
				return (IExecutionFacadeFactory) configElement
						.createExecutableExtension(ATTRIBUTE_CLASS);
			} catch (CoreException e) {
				e.printStackTrace();
			}
			return null;
		}
	}

	public static Iterable<ExecutionFactoryDescriptor> getExecutionFactoryDescriptor() {
		IConfigurationElement[] configurationElements = Platform
				.getExtensionRegistry().getConfigurationElementsFor(
						EXTENSION_POINT_ID);
		return transform(newArrayList(configurationElements),
				new CreateLibraryDescriptor());
	}

	private static final class CreateLibraryDescriptor implements
			Function<IConfigurationElement, ExecutionFactoryDescriptor> {

		public ExecutionFactoryDescriptor apply(IConfigurationElement from) {
			return new ExecutionFactoryDescriptor(from);
		}
	}

}
