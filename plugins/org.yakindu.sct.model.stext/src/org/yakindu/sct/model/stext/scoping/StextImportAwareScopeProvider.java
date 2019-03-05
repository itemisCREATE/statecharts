/**
* Copyright (c) 2016 itemis AG - All rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* 
* Contributors:
*	Andreas Muelder - itemis AG	
*	Thomas Kutz - itemis AG
*
*/
package org.yakindu.sct.model.stext.scoping;

import java.util.List;
import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;
import org.yakindu.base.expressions.scoping.IPackageImport2URIMapper;
import org.yakindu.base.expressions.scoping.IPackageImport2URIMapper.PackageImport;
import org.yakindu.base.types.Package;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.stext.extensions.STextExtensions;
import org.yakindu.sct.model.stext.stext.ImportScope;
import org.yakindu.sct.model.stext.stext.StateSpecification;
import org.yakindu.sct.model.stext.stext.TransitionSpecification;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * 
 * @author thomas kutz
 *
 */
public class StextImportAwareScopeProvider extends ImportedNamespaceAwareLocalScopeProvider {

	@Inject
	private IPackageImport2URIMapper mapper;

	@Inject STextExtensions utils;
	
	@Override
	public IScope getScope(EObject context, EReference reference) {
		if (context == null)
			throw new NullPointerException("context");
		IScope result = null;
		if (context instanceof ImportScope) {
			result = getResourceScope(context.eResource(), reference);
		} else if (context.eContainer() != null) {
			result = getScope(context.eContainer(), reference);
		} else {
			result = getResourceScope(context.eResource(), reference);
		}
		return getLocalElementsScope(result, context, reference);
	}

	@Override
	protected List<ImportNormalizer> internalGetImportedNamespaceResolvers(final EObject context, boolean ignoreCase) {
		List<ImportNormalizer> importedNamespaceResolvers = Lists.newArrayList();
		List<ImportScope> importScopes = null;
		if (context instanceof StateSpecification || context instanceof TransitionSpecification) {
			importScopes = EcoreUtil2.getAllContentsOfType(utils.getStatechart(context), ImportScope.class);
		} else {
			importScopes = EcoreUtil2.getAllContentsOfType(context, ImportScope.class);
		}
		for (ImportScope scope : importScopes) {
			importedNamespaceResolvers.addAll(createNamespaceResolver(scope, ignoreCase));
		}
		return importedNamespaceResolvers;
	}

	@Override
	protected ImportNormalizer doCreateImportNormalizer(QualifiedName importedNamespace, boolean wildcard,
			boolean ignoreCase) {
		// all imports should be treated as if they had a wild card
		return new ImportNormalizer(importedNamespace, true, ignoreCase);
	}
	protected List<ImportNormalizer> createNamespaceResolver(Scope scope, boolean ignoreCase) {
		List<ImportNormalizer> importedNamespaceResolvers = Lists.newArrayList();
		ImportScope importScope = (ImportScope) scope;
		for (String child : importScope.getImports()) {
			Optional<PackageImport> pkgImport = mapper.findPackageImport(scope.eResource(), child);
			if (pkgImport.isPresent()) {
				ImportNormalizer resolver = createImportedNamespaceResolver(pkgImport.get().getNamespace(), ignoreCase);
				if (resolver != null)
					importedNamespaceResolvers.add(resolver);
			}
		}
		return importedNamespaceResolvers;
	}

	@Override
	protected String getImportedNamespace(EObject object) {
		if (object instanceof Package)
			return ((Package) object).getName();
		return super.getImportedNamespace(object);
	}
}
