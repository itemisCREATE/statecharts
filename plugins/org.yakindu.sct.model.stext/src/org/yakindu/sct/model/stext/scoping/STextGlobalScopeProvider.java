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

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.DefaultGlobalScopeProvider;
import org.eclipse.xtext.scoping.impl.FilteringScope;
import org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider;
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
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class STextGlobalScopeProvider extends ImportUriGlobalScopeProvider {

	private static final ResourceImpl CACHE_RESOURCE_DESC = new ResourceImpl();

	private static final String CACHE_KEY_IMPORTED_URIS = "IMPORTED_URIS";

	public static final URI STEXT_LIB = URI
			.createURI("platform:/plugin/org.yakindu.sct.model.stext.lib/lib/STextLib.xmi");

	@Inject
	private ITypeSystem typeSystem;
	@Inject
	private IQualifiedNameProvider qualifiedNameProvider;

	@Inject
	IResourceScopeCache cache;

	@Inject
	private DefaultGlobalScopeProvider delegate;
	@Inject
	private STextLibraryGlobalScopeProvider libraryScope;
	@Inject
	private IPackageImport2URIMapper mapper;

	public static final String FILE_EXTENSION = "sct";

	public IScope getScope(Resource context, EReference reference, Predicate<IEObjectDescription> filter) {
		if (reference.getEReferenceType() == TypesPackage.Literals.PACKAGE) {
			return delegate.getScope(context, reference, filter);
		}
		IScope parentScope = super.getScope(context, reference, filter);
		parentScope = new SimpleScope(parentScope, delegate.getScope(context, reference, filter).getAllElements());
		parentScope = filterExternalDeclarations(context, parentScope);
		parentScope = new SimpleScope(parentScope, libraryScope.getScope(context, reference, filter).getAllElements());
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

	@Override
	public IScope getScope(Resource resource, EReference reference) {
		if (reference.getEReferenceType() == TypesPackage.Literals.PACKAGE) {
			return delegate.getScope(resource, reference);
		}
		return super.getScope(resource, reference);
	}

	@Override
	protected IScope createLazyResourceScope(IScope parent, URI uri, IResourceDescriptions descriptions, EClass type,
			Predicate<IEObjectDescription> filter, boolean ignoreCase) {
		
		return cache.get(uri.toString(), CACHE_RESOURCE_DESC, new Provider<IScope>() {

			@Override
			public IScope get() {
				return STextGlobalScopeProvider.super.createLazyResourceScope(parent, uri, descriptions, type, filter, ignoreCase);
			}
			
		});
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

	protected LinkedHashSet<URI> getImportedUris(final Resource resourceOrig) {
		Resource cacheResource = getContextResource(resourceOrig);
		LinkedHashSet<URI> set = cache.get(CACHE_KEY_IMPORTED_URIS, cacheResource, new Provider<LinkedHashSet<URI>>() {

			@Override
			public LinkedHashSet<URI> get() {
				LinkedHashSet<URI> importedURIs = new LinkedHashSet<URI>(5);
				for (ImportScope object : getImportScopes(cacheResource)) {
					collectPackageImports(cacheResource, object.getImports(),
							createURICollector(cacheResource, importedURIs));
				}
				return importedURIs;
			}
		});
		return set;

	}

	protected Resource getContextResource(Resource context) {
		Resource contextResource = context;
		ContextElementAdapter existingAdapter = (ContextElementAdapter) EcoreUtil.getExistingAdapter(context,
				ContextElementAdapter.class);

		if (existingAdapter != null) {
			contextResource = existingAdapter.getElement().eResource();
		}
		return contextResource;
	}

	protected void collectPackageImports(Resource resource, EList<String> imports, IAcceptor<String> acceptor) {

		List<String> importsToFind = Lists.newArrayList(imports);
		Set<PackageImport> allImports = mapper.getAllImports(resource);

		for (PackageImport packageImport : allImports) {
			if (importsToFind.size() == 0) {
				break;
			}
			if (!EcoreUtil2.isValidUri(resource, packageImport.getUri()))
				continue;

			if (importsToFind.contains(packageImport.getName())) {
				acceptor.accept(packageImport.getUri().toString());
				importsToFind.remove(packageImport.getName());
			} else if (importsToFind.contains(packageImport.getNamespace())) {
				acceptor.accept(packageImport.getUri().toString());
				importsToFind.remove(packageImport.getNamespace());
			}
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
