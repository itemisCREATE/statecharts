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
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;
import org.yakindu.sct.model.stext.stext.Import;

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
		List<Import> imports = EcoreUtil2.getAllContentsOfType(context, Import.class);
		for (Import child : imports) {
			String value = getImportedNamespace(child);
			ImportNormalizer resolver = createImportedNamespaceResolver(value, ignoreCase);
			if (resolver != null)
				importedNamespaceResolvers.add(resolver);
		}
		return importedNamespaceResolvers;
	}
	
	protected ImportNormalizer doCreateImportNormalizer(QualifiedName importedNamespace, boolean wildcard, boolean ignoreCase) {
		// all imports should be treated as if they had a wild card
		return new ImportNormalizer(importedNamespace, true, ignoreCase);
	}
	
}
