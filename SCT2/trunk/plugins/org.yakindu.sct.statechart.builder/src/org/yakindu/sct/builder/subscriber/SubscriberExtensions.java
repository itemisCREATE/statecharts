/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */

package org.yakindu.sct.builder.subscriber;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@Deprecated
public class SubscriberExtensions {

	private static final String extensionPointId = "org.yakindu.sct.builder.subscriber";

	public static List<IBuilderSubscriber> getSubscriber(String resourceUri) {
		List<IBuilderSubscriber> providers = new ArrayList<IBuilderSubscriber>();
		IConfigurationElement[] configurationElements = Platform
				.getExtensionRegistry().getConfigurationElementsFor(
						extensionPointId);
		for (IConfigurationElement configurationElement : configurationElements) {
			try {
				String resourceExtension = configurationElement
						.getAttribute("resourceExtension");
				if (resourceUri.endsWith(resourceExtension)) {
					IBuilderSubscriber provider = (IBuilderSubscriber) configurationElement
							.createExecutableExtension("class");
					providers.add(provider);
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		return providers;
	}
}
