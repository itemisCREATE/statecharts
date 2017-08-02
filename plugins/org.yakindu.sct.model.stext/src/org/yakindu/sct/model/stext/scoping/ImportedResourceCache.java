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

import java.util.Optional;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.WorkspaceEditingDomainFactory;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Manager;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.util.IResourceScopeCache;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@Singleton
public class ImportedResourceCache {

	public static final String DOMAIN_ID = "org.yakindu.sct.domain.resources";

	@Inject
	private IResourceServiceProvider.Registry serviceProviderRegistry;
	@Inject
	private IResourceScopeCache cache;

	protected TransactionalEditingDomain getEditingDomain() {
		TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain(DOMAIN_ID);
		if (editingDomain == null) {
			TransactionalEditingDomain resourceDomain = WorkspaceEditingDomainFactory.INSTANCE.createEditingDomain();
			resourceDomain.setID(DOMAIN_ID);
			TransactionalEditingDomain.Registry.INSTANCE.add(DOMAIN_ID, resourceDomain);
			new WorkspaceSynchronizer(resourceDomain);
		}
		return TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(DOMAIN_ID);
	}

	public IResourceDescription get(final URI uri) {
		final ResourceSet set = getResourceSet();
		final Resource resource = set.getResource(uri, true);
		if (resource != null) {
			Optional<IResourceDescription> optional = cache.get(ImportedResourceCache.class, resource,
					new Provider<Optional<IResourceDescription>>() {
						@Override
						public Optional<IResourceDescription> get() {
							IResourceServiceProvider serviceProvider = serviceProviderRegistry
									.getResourceServiceProvider(uri);
							if (serviceProvider == null)
								return Optional.empty();
							final Manager resourceDescriptionManager = serviceProvider.getResourceDescriptionManager();
							if (resourceDescriptionManager == null)
								return Optional.empty();
							IResourceDescription result = resourceDescriptionManager.getResourceDescription(resource);
							return Optional.of(result);
						}
					});
			if (optional.isPresent()) {
				return optional.get();
			}
		}
		return null;
	}

	protected ResourceSet getResourceSet() {
		return getEditingDomain().getResourceSet();
	}

}
