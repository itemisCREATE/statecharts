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
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.DefaultGlobalScopeProvider;
import org.eclipse.xtext.scoping.impl.FilteringScope;
import org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider;
import org.eclipse.xtext.scoping.impl.MapBasedScope;
import org.eclipse.xtext.scoping.impl.SelectableBasedScope;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.yakindu.base.types.TypesPackage;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.sct.domain.extension.DomainRegistry;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.util.ContextElementAdapter;
import org.yakindu.sct.model.stext.scoping.IPackageImport2URIMapper.PackageImport;
import org.yakindu.sct.model.stext.stext.ImportScope;
import org.yakindu.sct.model.stext.stext.StatechartSpecification;
import org.yakindu.sct.model.stext.stext.StextPackage;

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
	private DefaultGlobalScopeProvider delegate;
	@Inject
	private STextLibraryGlobalScopeProvider libraryScope;
	@Inject
	private IPackageImport2URIMapper mapper;
	@Inject
	private ImportedResourceCache resourceDescriptionCache;

	public void setCache(IResourceScopeCache cache) {
		this.cache = cache;
	}

	public static final String FILE_EXTENSION = "sct";

	public IScope getScope(Resource context, EReference reference, Predicate<IEObjectDescription> filter) {
		if (reference.getEReferenceType() == TypesPackage.Literals.PACKAGE) {
			return delegate.getScope(context, reference, filter);
		}
		IScope parentScope = super.getScope(context, reference, filter);
		parentScope = new SimpleScope(parentScope, delegate.getScope(context, reference, filter).getAllElements());
		parentScope = filterExternalDeclarations(context, parentScope);
		parentScope = new SimpleScope(parentScope, filterPropertiesOfLibrary(context, reference, filter).getAllElements());
		final Statechart statechart = getStatechart(context);
		parentScope = new TypeSystemAwareScope(parentScope, typeSystem, qualifiedNameProvider,
				reference.getEReferenceType());
		IScope result = new FilteringScope(parentScope, new Predicate<IEObjectDescription>() {
			@Override
			public boolean apply(IEObjectDescription input) {
				String userData = input.getUserData(DomainRegistry.DOMAIN_ID);
				if (userData == null)
					return true;

				return statechart.getDomainID().equals(userData);
			}
		});
		result = filterAnnotations(reference, result);
		return result;
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
	
	protected IScope filterPropertiesOfLibrary(Resource context, EReference reference, Predicate<IEObjectDescription> filter) {
		return new FilteringScope(libraryScope.getScope(context, reference, filter), new Predicate<IEObjectDescription>() {
			@Override
			public boolean apply(IEObjectDescription input) {
				return input.getEClass() != TypesPackage.Literals.PROPERTY;
			}
		});
	}

	@Override
	public IScope getScope(Resource resource, EReference reference) {
		if (reference.getEReferenceType() == TypesPackage.Literals.PACKAGE) {
			return delegate.getScope(resource, reference);
		}
		return super.getScope(resource, reference);
	}

	protected LinkedHashSet<URI> getImportedUris(final Resource resource) {
		return cache.get(ImportUriGlobalScopeProvider.class.getName(), resource, new Provider<LinkedHashSet<URI>>() {
			@Override
			public LinkedHashSet<URI> get() {
				final LinkedHashSet<URI> uniqueImportURIs = new LinkedHashSet<URI>(5);
				IAcceptor<String> collector = createURICollector(resource, uniqueImportURIs);
				Collection<ImportScope> importScopes = getImportScopes(resource);
				for (ImportScope object : importScopes) {
					EList<String> imports = object.getImports();
					for (String packageImport : imports) {
						collectPackageImports(resource, packageImport, collector, uniqueImportURIs);
					}
				}
				Iterator<URI> uriIter = uniqueImportURIs.iterator();
				while (uriIter.hasNext()) {
					if (!EcoreUtil2.isValidUri(resource, uriIter.next()))
						uriIter.remove();
				}
				return uniqueImportURIs;
			}

			private Collection<ImportScope> getImportScopes(final Resource resource) {
				StatechartSpecification specification = (StatechartSpecification) EcoreUtil
						.getObjectByType(resource.getContents(), StextPackage.Literals.STATECHART_SPECIFICATION);
				if (specification != null) {
					return EcoreUtil.getObjectsByType(specification.getScopes(), StextPackage.Literals.IMPORT_SCOPE);
				} else {
					Statechart statechart = getStatechart(resource);
					return EcoreUtil.getObjectsByType(statechart.getScopes(), StextPackage.Literals.IMPORT_SCOPE);
				}
			}
		});
	}

	protected void collectPackageImports(Resource resource, String packageImport, IAcceptor<String> acceptor,
			LinkedHashSet<URI> uniqueImportURIs) {
		PackageImport pkgImport = mapper.findPackageImport(resource, packageImport);
		if (pkgImport != null && pkgImport.getUri() != null && URIConverter.INSTANCE.exists(pkgImport.getUri(), null)) {
			acceptor.accept(pkgImport.getUri().toString());
		}
	}

	protected Statechart getStatechart(Resource context) {
		final ContextElementAdapter provider = (ContextElementAdapter) EcoreUtil.getExistingAdapter(context,
				ContextElementAdapter.class);
		if (provider == null) {
			return (Statechart) EcoreUtil2.getObjectByType(context.getContents(), SGraphPackage.Literals.STATECHART);
		} else {
			return (Statechart) EcoreUtil.getObjectByType(provider.getElement().eResource().getContents(),
					SGraphPackage.Literals.STATECHART);
		}
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
		List<IEObjectDescription> objectDescriptions = new ArrayList<IEObjectDescription>();
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

	/**
	 * Filter all Elements that are part of an SCT file from other resources to
	 * avoid cross document referencing
	 */
	protected IScope filterExternalDeclarations(Resource context, IScope parentScope) {
		final ContextElementAdapter provider = (ContextElementAdapter) EcoreUtil.getExistingAdapter(context,
				ContextElementAdapter.class);
		final URI resourceURI = provider != null ? provider.getElement().eResource().getURI() : context.getURI();
		parentScope = new FilteringScope(parentScope, new Predicate<IEObjectDescription>() {
			public boolean apply(IEObjectDescription input) {
				if (FILE_EXTENSION.equals(input.getEObjectURI().fileExtension())) {
					URI sourceURI = input.getEObjectURI().trimFragment();
					return sourceURI.equals(resourceURI);
				}
				return true;
			}
		});
		return parentScope;
	}

}
