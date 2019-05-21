/**
* Copyright (c) 2016 itemis AG - All rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* 
* Contributors:
*	Andreas Muelder - itemis AG	
*	Thomas Kutz - itemis AG
*
*/
package org.yakindu.base.expressions.scoping;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.scoping.impl.ImportScope;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;
import org.yakindu.base.expressions.scoping.IPackageImport2URIMapper.PackageImport;
import org.yakindu.base.types.Package;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

public class ExpressionsImportAwareScopeProvider extends ImportedNamespaceAwareLocalScopeProvider {

	@Inject
	private IPackageImport2URIMapper mapper;

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
		if (context instanceof Package) {
			EList<String> imports = ((Package) context).getImports();
			for (String import1 : imports) {
				importedNamespaceResolvers.addAll(createNamespaceResolver(import1, ignoreCase, context));
			}
		}
		if (importedNamespaceResolvers.isEmpty()) {
			return super.internalGetImportedNamespaceResolvers(context, ignoreCase);
		}
		return importedNamespaceResolvers;
	}

	@Override
	protected ImportNormalizer doCreateImportNormalizer(QualifiedName importedNamespace, boolean wildcard,
			boolean ignoreCase) {
		// all imports should be treated as if they had a wild card
		return new ImportNormalizer(importedNamespace, true, ignoreCase);
	}

	protected List<ImportNormalizer> createNamespaceResolver(String importStatement, boolean ignoreCase,
			EObject context) {
		Optional<PackageImport> pkgImport = mapper.findPackageImport(context.eResource(), importStatement);
		if (pkgImport.isPresent()) {
			ImportNormalizer resolver = createImportedNamespaceResolver(pkgImport.get().getNamespace(), ignoreCase);
			return Collections.singletonList(resolver);
		}
		return Lists.newArrayList();
	}

	@Override
	protected String getImportedNamespace(EObject object) {
		if (object instanceof Package)
			return ((Package) object).getName();
		return super.getImportedNamespace(object);
	}
}
