package org.yakindu.sct.model.stext.naming;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.Strings;
import org.yakindu.sct.model.sgraph.Declaration;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.StatechartDefinition;

import com.google.inject.Inject;

public class StextNameProvider extends DefaultDeclarativeQualifiedNameProvider {
	@Inject
	IQualifiedNameConverter nameConverter;

	QualifiedName qualifiedName(Statechart ele) {
		QualifiedName name = nameConverter.toQualifiedName(ele.getName());
		if (!Strings.isEmpty(ele.getNamespace())) {
			name = nameConverter.toQualifiedName(ele.getNamespace()).append(
					name);
		}
		return name;
	}
	QualifiedName qualifiedName(InterfaceScope ele) {
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

	QualifiedName qualifiedName(StatechartDefinition ele) {
		return nameConverter.toQualifiedName(ele.getNamespace());
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

	private QualifiedName getNamespace(EObject child) {
		QualifiedName name = null;
		if (!(child instanceof InterfaceScope)) {
			InterfaceScope interfaceScope = EcoreUtil2.getContainerOfType(
					child, InterfaceScope.class);
			if (interfaceScope != null
					&& !Strings.isEmpty(interfaceScope.getName())) {
				name = nameConverter.toQualifiedName(interfaceScope.getName());
			}
		}
		// TODO Only pseudo qualified names, because the statechart namespace an
		// not be determined i.e. XtextStyledTextCellEditor
		// ScopedElement definition = EcoreUtil2.getContainerOfType(child,
		// ScopedElement.class);
		// if (definition != null &&
		// !Strings.isEmpty(definition.getNamespace())) {
		// if (name == null) {
		// name = nameConverter.toQualifiedName(definition.getNamespace());
		// } else {
		// name = nameConverter.toQualifiedName(definition.getNamespace())
		// .append(name);
		// }
		// }
		return name;
	}
}
