/** 
 * Copyright (c) 2017 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.base.expressions.scoping;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.impl.EObjectDescriptionLookUp;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractGlobalScopeProvider;
import org.eclipse.xtext.scoping.impl.SelectableBasedScope;
import org.yakindu.base.types.typesystem.GenericTypeSystem;

import com.google.common.base.Predicate;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractLibraryGlobalScopeProvider extends AbstractGlobalScopeProvider
		implements IGlobalScopeProvider {

	@Inject
	private IResourceServiceProvider.Registry serviceProviderRegistry;

	protected abstract Set<URI> getLibraries(Resource context);

	protected Iterable<URI> getValidLibraries(Resource context) {
		return Iterables.filter(getLibraries(context), new Predicate<URI>() {
			@Override
			public boolean apply(URI input) {
				return URIConverter.INSTANCE.exists(input, Collections.EMPTY_MAP);
			}
		});
	}

	private Cache<URI, Iterable<IEObjectDescription>> libraryCache;

	public AbstractLibraryGlobalScopeProvider() {
		libraryCache = CacheBuilder.newBuilder().<URI, Iterable<IEObjectDescription>> build();
	}

	@Override
	public IScope getScope(Resource context, EReference reference, Predicate<IEObjectDescription> filter) {
		List<IEObjectDescription> descriptions = Lists.newArrayList();
		for (URI uri : getValidLibraries(context)) {
			try {
				Iterables.addAll(descriptions, libraryCache.get(uri, new Callable<Iterable<IEObjectDescription>>() {

					@Override
					public Iterable<IEObjectDescription> call() throws Exception {
						return getDescriptions(context, uri);
					}
				}));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return SelectableBasedScope.createScope(IScope.NULLSCOPE, new EObjectDescriptionLookUp(descriptions),
				reference.getEReferenceType(), isIgnoreCase(reference));
	}

	protected Iterable<IEObjectDescription> getDescriptions(Resource context, URI uri) {
		List<IEObjectDescription> result = Lists.newArrayList();
		ResourceSet set = new ResourceSetImpl();
		set.getResources().add(GenericTypeSystem.getInstance().getResource());
		Resource resource = set.getResource(uri, true);
		EcoreUtil.resolveAll(set);
		IResourceServiceProvider resourceServiceProvider = serviceProviderRegistry.getResourceServiceProvider(uri);
		if (resourceServiceProvider == null) {
			Iterables.addAll(result, Scopes.scopedElementsFor(Lists.newArrayList(resource.getAllContents())));
		} else {
			IResourceDescription resourceDescription = resourceServiceProvider.getResourceDescriptionManager()
					.getResourceDescription(resource);
			Iterables.addAll(result, resourceDescription.getExportedObjects());
		}
		return result;
	}

}