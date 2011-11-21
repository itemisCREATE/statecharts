package org.yakindu.sct.model.stext.naming;

import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.Strings;
import org.yakindu.sct.model.sgraph.naming.SGraphNameProvider;
import org.yakindu.sct.model.stext.stext.InterfaceScope;

import com.google.inject.Inject;

public class StextNameProvider extends SGraphNameProvider {
	@Inject
	IQualifiedNameConverter nameConverter;

	QualifiedName qualifiedName(InterfaceScope ele) {
		QualifiedName name = null;
		if (!Strings.isEmpty(ele.getName())) {
			name = nameConverter.toQualifiedName(ele.getName());
		} else if (ele.getName() == null) {
			// Default interface
			name = nameConverter.toQualifiedName("default");
		}

		QualifiedName namespace = getNamespace(ele);
		if (namespace != null && name != null) {
			name = namespace.append(name);
		}
		return name;
	}
}
