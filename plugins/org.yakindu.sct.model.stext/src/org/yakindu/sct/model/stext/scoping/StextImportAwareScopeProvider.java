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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;
import org.yakindu.base.xtext.utils.jface.viewers.ContextElementAdapter;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.stext.stext.Import;
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
	protected ImportNormalizer doCreateImportNormalizer(QualifiedName importedNamespace, boolean wildcard, boolean ignoreCase) {
		// all imports should be treated as if they had a wild card
		return new ImportNormalizer(importedNamespace, true, ignoreCase);
	}
	
	protected List<ImportNormalizer> createNamespaceResolver(Scope scope, boolean ignoreCase) {
		List<ImportNormalizer> importedNamespaceResolvers = Lists.newArrayList();
		ImportScope importScope = (ImportScope) scope;
		for (Import child : importScope.getImports()) {
			String value = getImportedNamespace(child);
			ImportNormalizer resolver = createImportedNamespaceResolver(value, ignoreCase);
			if (resolver != null)
				importedNamespaceResolvers.add(resolver);
		}
		return importedNamespaceResolvers;
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
