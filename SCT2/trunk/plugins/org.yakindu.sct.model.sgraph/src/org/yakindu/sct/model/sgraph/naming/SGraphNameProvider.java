package org.yakindu.sct.model.sgraph.naming;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.SimpleAttributeResolver;
import org.eclipse.xtext.util.Strings;
import org.yakindu.sct.model.sgraph.Declaration;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.ScopedElement;
import org.yakindu.sct.model.sgraph.Statechart;

import com.google.inject.Inject;

public class SGraphNameProvider extends DefaultDeclarativeQualifiedNameProvider {
	@Inject
	IQualifiedNameConverter nameConverter;

	QualifiedName qualifiedName(Statechart ele) {
		String scName = ele.getName();
		if (Strings.isEmpty(scName)) {
			return null;
		}
		QualifiedName name = nameConverter.toQualifiedName(scName);
		if (!Strings.isEmpty(ele.getNamespace())) {
			name = nameConverter.toQualifiedName(ele.getNamespace()).append(
					name);
		}
		return name;
	}

	QualifiedName qualifiedName(Scope ele) {
		QualifiedName name = null;
		String nameString = SimpleAttributeResolver.NAME_RESOLVER.apply(ele);
		if (!Strings.isEmpty(nameString)) {
			name = nameConverter.toQualifiedName(nameString);
		} else if (nameString == null) {
			// Default interface
			name = nameConverter.toQualifiedName("default");
		}

		QualifiedName namespace = getNamespace(ele);
		if (namespace != null && name != null) {
			name = namespace.append(name);
		}
		return name;
	}

	QualifiedName qualifiedName(Declaration ele) {
		QualifiedName name = null;
		if (!Strings.isEmpty(ele.getName())) {
			name = nameConverter.toQualifiedName(ele.getName());
		}
		QualifiedName namespace = getNamespace(ele);
		if (namespace != null && name != null) {
			name = namespace.append(name);
		}
		return name;
	}

	protected QualifiedName getNamespace(EObject child) {
		QualifiedName name = null;
		if (!(child instanceof ScopedElement)) {
			ScopedElement interfaceScope = EcoreUtil2.getContainerOfType(child,
					ScopedElement.class);
			if (interfaceScope != null
					&& !Strings.isEmpty(interfaceScope.getNamespace())) {
				name = nameConverter.toQualifiedName(interfaceScope
						.getNamespace());
			}
		}
		return name;
	}
}
