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
package org.yakindu.sct.model.stext.scoping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.FilteringScope;
import org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider;
import org.eclipse.xtext.scoping.impl.MapBasedScope;
import org.eclipse.xtext.scoping.impl.SelectableBasedScope;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.yakindu.base.types.TypesPackage;
import org.yakindu.base.types.resource.TypedResourceDescriptionStrategy;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.sct.domain.extension.DomainRegistry;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.stext.extensions.STextExtensions;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author andreas muelder - Initial contribution and API
 *
 */
public class STextGlobalScopeProvider extends ImportUriGlobalScopeProvider {

	public static final URI STEXT_LIB = URI
			.createURI("platform:/plugin/org.yakindu.sct.model.stext.lib/lib/STextLib.xmi");

	@Inject
	private ITypeSystem typeSystem;
	@Inject
	private IQualifiedNameProvider qualifiedNameProvider;
	@Inject
	private IResourceScopeCache cache;
	@Inject
	private STextLibraryGlobalScopeProvider libraryScope;
	@Inject
	private ImportedResourceCache resourceDescriptionCache;
	@Inject
	private STextExtensions utils;
	@Inject
	private ImportUriProvider importUriProvider;

	@Override
	public void setCache(IResourceScopeCache cache) {
		this.cache = cache;
	}

	public static final String FILE_EXTENSION = "sct";

	@Override
	public IScope getScope(Resource context, EReference reference, Predicate<IEObjectDescription> filter) {
		IScope parentScope = super.getScope(context, reference, filter);
		parentScope = new SimpleScope(parentScope,
				filterPropertiesOfLibrary(context, reference, filter).getAllElements());
		Statechart statechart = utils.getStatechart(context);
		if (statechart == null)
			return IScope.NULLSCOPE;
		final String statechartDomain = statechart.getDomainID();
		parentScope = new TypeSystemAwareScope(parentScope, typeSystem, qualifiedNameProvider,
				reference.getEReferenceType());
		IScope result = new FilteringScope(parentScope, new Predicate<IEObjectDescription>() {
			@Override
			public boolean apply(IEObjectDescription input) {
				String userData = input.getUserData(DomainRegistry.DOMAIN_ID);
				if (userData == null)
					return true;

				return statechartDomain.equals(userData);
			}
		});
		result = filterAnnotations(reference, result);
		return new FilteringScope(result, input -> {
			String isVisible = input.getUserData(TypedResourceDescriptionStrategy.IS_VISIBLE_TYPE);
			return isVisible == null || Boolean.valueOf(isVisible);
		});
	}

	protected IScope filterAnnotations(EReference reference, IScope result) {
		if (reference != TypesPackage.Literals.ANNOTATION__TYPE)
			result = new FilteringScope(result, new Predicate<IEObjectDescription>() {
				@Override
				public boolean apply(IEObjectDescription input) {
					return input.getEClass() != TypesPackage.Literals.ANNOTATION_TYPE;
				}
			});
		return result;
	}

	protected IScope filterPropertiesOfLibrary(Resource context, EReference reference,
			Predicate<IEObjectDescription> filter) {
		return new FilteringScope(libraryScope.getScope(context, reference, filter),
				new Predicate<IEObjectDescription>() {
					@Override
					public boolean apply(IEObjectDescription input) {
						return input.getEClass() != TypesPackage.Literals.PROPERTY;
					}
				});
	}
	
	@Override
	protected LinkedHashSet<URI> getImportedUris(final Resource resource) {
		return cache.get(ImportUriGlobalScopeProvider.class.getName(), resource, new Provider<LinkedHashSet<URI>>() {

			@Override
			public LinkedHashSet<URI> get() {
				return importUriProvider.get(resource);
			}
		});
	}

	/**
	 * Overidden to avoid scope nesting which is not required and slows down because
	 * of shadowing testing.
	 */
	@Override
	protected IScope getScope(Resource resource, boolean ignoreCase, EClass type,
			Predicate<IEObjectDescription> filter) {
		final LinkedHashSet<URI> uniqueImportURIs = getImportedUris(resource);
		IResourceDescriptions descriptions = getResourceDescriptions(resource, uniqueImportURIs);
		List<URI> urisAsList = Lists.newArrayList(uniqueImportURIs);
		Collections.reverse(urisAsList);
		List<IEObjectDescription> objectDescriptions = new ArrayList<>();
		for (URI uri : urisAsList) {
			IScope scope = createLazyResourceScope(IScope.NULLSCOPE, uri, descriptions, type, filter, ignoreCase);
			Iterables.addAll(objectDescriptions, scope.getAllElements());
		}
		return MapBasedScope.createScope(IScope.NULLSCOPE, objectDescriptions);
	}

	@Override
	protected IScope createLazyResourceScope(IScope parent, URI uri, IResourceDescriptions descriptions, EClass type,
			Predicate<IEObjectDescription> filter, boolean ignoreCase) {
		IResourceDescription description = resourceDescriptionCache.get(uri);
		if (description == null)
			return IScope.NULLSCOPE;
		return SelectableBasedScope.createScope(parent, description, filter, type, ignoreCase);
	}
}
