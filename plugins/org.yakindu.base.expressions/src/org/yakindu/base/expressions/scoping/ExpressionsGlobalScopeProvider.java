package org.yakindu.base.expressions.scoping;

import java.util.LinkedHashSet;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.yakindu.base.types.typesystem.ITypeSystem;

import com.google.common.base.Predicate;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class ExpressionsGlobalScopeProvider extends ImportUriGlobalScopeProvider {

	@Inject
	protected ITypeSystem typeSystem;
	@Inject
	protected IQualifiedNameProvider qualifiedNameProvider;
	@Inject
	private ExpressionsImportUriProvider importUriProvider;
	@Inject
	private IResourceScopeCache cache;

	@Override
	public IScope getScope(Resource resource, EReference reference, Predicate<IEObjectDescription> filter) {
		IScope parentScope = super.getScope(resource, reference, filter);
		parentScope = new TypeSystemAwareScope(parentScope, typeSystem, qualifiedNameProvider,
				reference.getEReferenceType());
		return parentScope;
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
}
