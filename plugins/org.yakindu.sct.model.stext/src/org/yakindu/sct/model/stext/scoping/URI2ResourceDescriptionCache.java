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

import java.util.concurrent.ExecutionException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer.Delegate;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Manager;
import org.eclipse.xtext.resource.IResourceServiceProvider;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@Singleton
public class URI2ResourceDescriptionCache implements Delegate {

	private static final String DOMAIN_ID = "StatechartDomain";

	@Inject
	private IResourceServiceProvider.Registry serviceProviderRegistry;

	private LoadingCache<String, IResourceDescription> cache;

	private WorkspaceSynchronizer workspaceSynchronizer;

	public URI2ResourceDescriptionCache() {
		cache = CacheBuilder.newBuilder().build(new CacheLoader<String, IResourceDescription>() {
			@Override
			public IResourceDescription load(String key) throws Exception {
				return getInternal(URI.createURI(key));
			}
		});
		TransactionalEditingDomain editingDomain = getEditingDomain();
		if (editingDomain != null)
		workspaceSynchronizer = new WorkspaceSynchronizer(editingDomain, this);
	}

	protected TransactionalEditingDomain getEditingDomain() {
		return TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(DOMAIN_ID);
	}

	public synchronized IResourceDescription get(URI uri) {
		try {
			IResourceDescription descrpition = cache.get(uri.toString());
			return descrpition;
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return null;

	}

	protected IResourceDescription getInternal(URI uri) {
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
		if(getEditingDomain() == null) {
			return new ResourceSetImpl();
		}
		return getEditingDomain().getResourceSet();
	}

	@Override
	public synchronized boolean handleResourceDeleted(Resource resource) {
		cache.invalidate(resource.getURI().toString());
		return true;
	}

	@Override
	public synchronized boolean handleResourceMoved(Resource resource, URI newURI) {
		cache.invalidate(resource.getURI().toString());
		return true;
	}

	@Override
	public synchronized boolean handleResourceChanged(Resource resource) {
		cache.invalidate(resource.getURI().toString());
		return true;
	}

	@Override
	public synchronized void dispose() {
		if (workspaceSynchronizer != null)
			workspaceSynchronizer.dispose();
		cache.invalidateAll();
	}

}
