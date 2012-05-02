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
package org.yakindu.sct.model.sgraph.resource.provider;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionManager;
import org.eclipse.xtext.resource.impl.DefaultResourceServiceProvider;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * 
 * @author andreas muelder
 * 
 */
public class StatechartResourceProvider extends DefaultResourceServiceProvider {

	@Inject
	private Injector injector;

	@Override
	public IResourceDescription.Manager getResourceDescriptionManager() {
		DefaultResourceDescriptionManager defaultResourceDescriptionManager = new DefaultResourceDescriptionManager() {
			public IResourceDescription getResourceDescription(Resource resource) {
				StatechartResourceDescription description = new StatechartResourceDescription(
						resource);
				injector.injectMembers(description);
				return description;
			}
		};
		injector.injectMembers(defaultResourceDescriptionManager);
		return defaultResourceDescriptionManager;
	}

	@Override
	public boolean canHandle(URI uri) {
		return uri.fileExtension().toLowerCase().equals("sct");
	}

}
