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

import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.impl.EObjectDescriptionLookUp;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractGlobalScopeProvider;
import org.eclipse.xtext.scoping.impl.SelectableBasedScope;

import com.google.common.base.Predicate;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractLibraryGlobalScopeProvider extends AbstractGlobalScopeProvider
		implements IGlobalScopeProvider {

	public abstract Set<URI> getLibraries();

	private LoadingCache<URI, Iterable<IEObjectDescription>> libraryCache;

	public AbstractLibraryGlobalScopeProvider() {
		libraryCache = CacheBuilder.newBuilder().build(new CacheLoader<URI, Iterable<IEObjectDescription>>() {
			@Override
			public Iterable<IEObjectDescription> load(URI key) throws Exception {
				return getDescriptions(key);
			}
		});
	}

	@Override
	public IScope getScope(Resource context, EReference reference, Predicate<IEObjectDescription> filter) {
		List<IEObjectDescription> descriptions = Lists.newArrayList();
		for (URI uri : getLibraries()) {
			try {
				Iterables.addAll(descriptions, libraryCache.get(uri));
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		return SelectableBasedScope.createScope(IScope.NULLSCOPE, new EObjectDescriptionLookUp(descriptions),
				reference.getEReferenceType(), isIgnoreCase(reference));
	}

	protected Iterable<IEObjectDescription> getDescriptions(URI uri) {
		ResourceSet set = new ResourceSetImpl();
		List<IEObjectDescription> result = Lists.newArrayList();
		Resource resource = set.getResource(uri, true);
		System.out.println("Loading " + uri);
		Iterable<IEObjectDescription> iterable = Scopes
				.scopedElementsFor(Lists.newArrayList(resource.getAllContents()));
		Iterables.addAll(result, iterable);
		resource.unload();
		return result;
	}

}
