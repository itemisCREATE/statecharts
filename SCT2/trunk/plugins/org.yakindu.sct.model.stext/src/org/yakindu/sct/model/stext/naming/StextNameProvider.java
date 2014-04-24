/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.stext.naming;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.Strings;
import org.yakindu.sct.model.sgraph.Event;
import org.yakindu.sct.model.sgraph.Variable;
import org.yakindu.sct.model.sgraph.naming.SGraphNameProvider;
import org.yakindu.sct.model.stext.stext.InterfaceScope;

import com.google.inject.Inject;

public class StextNameProvider extends SGraphNameProvider {
	@Inject
	protected IQualifiedNameConverter nameConverter;

	public QualifiedName qualifiedName(Event ele) {
		QualifiedName name = null;
		if (!Strings.isEmpty(ele.getName())) {
			name = nameConverter.toQualifiedName(ele.getName());
		}
		InterfaceScope scope = EcoreUtil2.getContainerOfType(ele,
				InterfaceScope.class);
		if (scope != null) {
			if (!Strings.isEmpty(scope.getName())) {
				QualifiedName namespace = nameConverter.toQualifiedName(scope
						.getName());
				name = namespace.append(name);
			}

		}
		return name;
	}

	public QualifiedName qualifiedName(Variable ele) {
		QualifiedName name = null;
		if (!Strings.isEmpty(ele.getName())) {
			name = nameConverter.toQualifiedName(ele.getName());
		}
		InterfaceScope scope = EcoreUtil2.getContainerOfType(ele,
				InterfaceScope.class);
		if (scope != null) {
			if (!Strings.isEmpty(scope.getName())) {
				QualifiedName namespace = nameConverter.toQualifiedName(scope
						.getName());
				name = namespace.append(name);
			}

		}
		return name;
	}

	public QualifiedName qualifiedName(InterfaceScope ele) {
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
		QualifiedName name = super.getNamespace(child);
		if (!(child instanceof InterfaceScope)) {
			InterfaceScope interfaceScope = EcoreUtil2.getContainerOfType(
					child, InterfaceScope.class);
			if (interfaceScope != null
					&& getFullyQualifiedName(interfaceScope) != null) {
				name = getFullyQualifiedName(interfaceScope);
			}
		}
		return name;
	}
}
