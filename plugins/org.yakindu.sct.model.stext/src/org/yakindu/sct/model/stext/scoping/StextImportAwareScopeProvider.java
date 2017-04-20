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

import static java.util.Collections.singletonList;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.ISelectable;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;
import org.yakindu.base.types.Package;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.util.ContextElementAdapter;
import org.yakindu.sct.model.stext.stext.ImportScope;
import org.yakindu.sct.model.stext.stext.StateSpecification;
import org.yakindu.sct.model.stext.stext.TransitionSpecification;

import com.google.common.collect.Lists;

/**
 * 
 * @author thomas kutz
 *
 */
public class StextImportAwareScopeProvider extends ImportedNamespaceAwareLocalScopeProvider {

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
			importScopes = EcoreUtil2.getAllContentsOfType(getStatechart(context), ImportScope.class);
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
		for (org.yakindu.base.types.Package child : importScope.getImports()) {
			String value = getImportedNamespace(child);
			ImportNormalizer resolver = createImportedNamespaceResolver(value, ignoreCase);
			if (resolver != null)
				importedNamespaceResolvers.add(resolver);
		}
		return importedNamespaceResolvers;
	}

	protected IScope getLocalElementsScope(IScope parent, final EObject context, final EReference reference) {
		IScope result = parent;
		ISelectable allDescriptions = getAllDescriptions(context.eResource());
		QualifiedName name = getQualifiedNameOfLocalElement(context);
		boolean ignoreCase = isIgnoreCase(reference);
		final List<ImportNormalizer> namespaceResolvers = getImportedNamespaceResolvers(context, ignoreCase);
		if (!namespaceResolvers.isEmpty()) {
			if (isRelativeImport() && name != null && !name.isEmpty()) {
				ImportNormalizer localNormalizer = doCreateImportNormalizer(name, true, ignoreCase);
				result = createImportScope(result, singletonList(localNormalizer), allDescriptions,
						reference.getEReferenceType(), isIgnoreCase(reference));
			}
			result = createImportScope(result, namespaceResolvers, null, reference.getEReferenceType(),
					isIgnoreCase(reference));
		}
		if (name != null) {
			ImportNormalizer localNormalizer = doCreateImportNormalizer(name, true, ignoreCase);
			result = createImportScope(result, singletonList(localNormalizer), allDescriptions,
					reference.getEReferenceType(), isIgnoreCase(reference));
		}
		return result;
	}

	@Override
	protected String getImportedNamespace(EObject object) {
		if (object instanceof Package)
			return ((Package) object).getName();
		return super.getImportedNamespace(object);
	}

	protected Statechart getStatechart(EObject context) {

		final ContextElementAdapter provider = (ContextElementAdapter) EcoreUtil.getExistingAdapter(context.eResource(),
				ContextElementAdapter.class);

		if (provider == null) {
			return EcoreUtil2.getContainerOfType(context, Statechart.class);
		} else {
			return (Statechart) EcoreUtil.getObjectByType(provider.getElement().eResource().getContents(),
					SGraphPackage.Literals.STATECHART);
		}
	}

}
