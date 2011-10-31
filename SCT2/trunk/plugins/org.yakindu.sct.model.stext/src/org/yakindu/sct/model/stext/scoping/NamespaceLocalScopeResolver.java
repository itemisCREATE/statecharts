package org.yakindu.sct.model.stext.scoping;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;
import org.eclipse.xtext.util.Strings;
import org.yakindu.sct.model.sgraph.Statechart;

import com.google.inject.Inject;

public class NamespaceLocalScopeResolver extends
		ImportedNamespaceAwareLocalScopeProvider {
	@Inject
	IQualifiedNameConverter nameConverter;

	@Override
	protected List<ImportNormalizer> internalGetImportedNamespaceResolvers(
			EObject context, boolean ignoreCase) {
		List<ImportNormalizer> namespaceResolvers = super
				.internalGetImportedNamespaceResolvers(context, ignoreCase);
		// TODO The elements could be in a new 'FakeResource' and are not below
		// a statechart while editing
		Statechart statechart = EcoreUtil2.getContainerOfType(context,
				Statechart.class);
		if (statechart != null) {
			if (!Strings.isEmpty(statechart.getNamespace())) {
				namespaceResolvers.add(new ImportNormalizer(nameConverter
								.toQualifiedName(statechart.getNamespace()),
								true, true));
			}
		}
		return namespaceResolvers;
	}
}
