/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.stext.scoping;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Manager;
import org.eclipse.xtext.resource.IResourceServiceProvider;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@Singleton
public class URI2ResourceDescriptionCache {

	private static final String DOMAIN_ID = "org.yakindu.sct.domain";

	@Inject
	private IResourceServiceProvider.Registry serviceProviderRegistry;

	protected TransactionalEditingDomain getEditingDomain() {
		TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain(DOMAIN_ID);
		return editingDomain;
	}

	public IResourceDescription get(URI uri) {
		ResourceSet set = getResourceSet();
		Resource resource = set.getResource(uri, true);
		if (resource != null) {
			IResourceServiceProvider serviceProvider = serviceProviderRegistry.getResourceServiceProvider(uri);
			if (serviceProvider == null)
				return null;
			final Manager resourceDescriptionManager = serviceProvider.getResourceDescriptionManager();
			if (resourceDescriptionManager == null)
				return null;
			IResourceDescription result = resourceDescriptionManager.getResourceDescription(resource);
			return result;
		}
		return null;
	}

	protected ResourceSet getResourceSet() {
		return getEditingDomain().getResourceSet();
	}

}
