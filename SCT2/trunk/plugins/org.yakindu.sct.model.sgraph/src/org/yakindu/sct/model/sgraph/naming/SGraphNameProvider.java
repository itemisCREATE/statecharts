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
package org.yakindu.sct.model.sgraph.naming;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.SimpleAttributeResolver;
import org.eclipse.xtext.util.Strings;
import org.yakindu.sct.model.sgraph.Choice;
import org.yakindu.sct.model.sgraph.Declaration;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.FinalState;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.ScopedElement;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Vertex;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.inject.Inject;

/**
 * NameProvider for SGraph elements like statecharts, scopes and declarations.
 * 
 * @author benjamin schwertfeger
 * @author andreas muelder
 * 
 */
public class SGraphNameProvider extends DefaultDeclarativeQualifiedNameProvider {

	private static final QualifiedName DEFAULT_ENTRY_NAME = QualifiedName
			.create("Default");
	private static final String _FINAL_STATE_NAME = "_final_";
	private static final String _CHOICE_NAME = "_choice_";

	@Inject
	private IQualifiedNameConverter nameConverter;
	@Inject
	private IdentifierConverter identifierConverer;

	@Override
	protected Function<EObject, String> getResolver() {
		return SimpleAttributeResolver.NAME_RESOLVER;
	}

	public QualifiedName qualifiedName(Statechart ele) {
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

	public QualifiedName qualifiedName(Choice ele) {

		// first get order number of choice node
		List<Vertex> choiceList = new ArrayList<Vertex>();
		choiceList.addAll(Collections2.filter(
				((Region) ele.eContainer()).getVertices(),
				new Predicate<Vertex>() {
					public boolean apply(Vertex input) {
						return input instanceof Choice;
					}
				}));
		int index = choiceList.indexOf(ele);

		EObject temp = ele;
		QualifiedName qualifiedNameFromConverter = QualifiedName
				.create(_CHOICE_NAME + index);
		while (temp.eContainer() != null) {
			temp = temp.eContainer();
			QualifiedName parentsQualifiedName = getFullyQualifiedName(temp);
			if (parentsQualifiedName != null)
				return parentsQualifiedName.append(qualifiedNameFromConverter);
		}
		return qualifiedNameFromConverter;
	}

	public QualifiedName qualifiedName(Entry ele) {

		QualifiedName name = DEFAULT_ENTRY_NAME;
		if (ele.getName() != null && !ele.getName().isEmpty()) {
			name = QualifiedName.create(ele.getName());
		}
		EObject temp = ele;
		while (temp.eContainer() != null) {
			temp = temp.eContainer();
			QualifiedName parentsQualifiedName = getFullyQualifiedName(temp);
			if (parentsQualifiedName != null)
				return parentsQualifiedName.append(name);
		}
		return name;
	}

	public QualifiedName qualifiedName(Scope ele) {
		QualifiedName name = null;
		String nameString = SimpleAttributeResolver.NAME_RESOLVER.apply(ele);
		if (!Strings.isEmpty(nameString)) {
			name = nameConverter.toQualifiedName(nameString);
		}

		QualifiedName namespace = getNamespace(ele);
		if (namespace != null && name != null) {
			name = namespace.append(name);
		}
		return name;
	}

	public QualifiedName qualifiedName(FinalState ele) {
		ele.getName();
		QualifiedName qfn = QualifiedName.create(_FINAL_STATE_NAME);
		EObject temp = ele;
		while (temp.eContainer() != null) {
			temp = temp.eContainer();
			QualifiedName parentsQualifiedName = getFullyQualifiedName(temp);
			if (parentsQualifiedName != null)
				return parentsQualifiedName.append(qfn);
		}
		return qfn;
	}

	public QualifiedName qualifiedName(State ele) {
		EObject temp = ele;
		ele.getName();
		QualifiedName qualifiedNameFromConverter = QualifiedName
				.create(identifierConverer.toIdentifier(ele.getName()));
		while (temp.eContainer() != null) {
			temp = temp.eContainer();
			QualifiedName parentsQualifiedName = getFullyQualifiedName(temp);
			if (parentsQualifiedName != null)
				return parentsQualifiedName.append(qualifiedNameFromConverter);
		}
		return qualifiedNameFromConverter;
	}

	public QualifiedName qualifiedName(Region ele) {
		EObject temp = ele;
		if (ele.getName() == null) {
			return null;
		}
		QualifiedName qualifiedNameFromConverter = QualifiedName
				.create(identifierConverer.toIdentifier(ele.getName()));
		while (temp.eContainer() != null) {
			temp = temp.eContainer();
			QualifiedName parentsQualifiedName = getFullyQualifiedName(temp);
			if (parentsQualifiedName != null)
				return parentsQualifiedName.append(qualifiedNameFromConverter);
		}
		return qualifiedNameFromConverter;
	}

	public QualifiedName qualifiedName(Declaration ele) {
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
