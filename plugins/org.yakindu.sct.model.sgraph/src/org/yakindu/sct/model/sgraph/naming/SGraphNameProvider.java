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
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.SimpleAttributeResolver;
import org.eclipse.xtext.util.Strings;
import org.yakindu.base.types.Declaration;
import org.yakindu.sct.model.sgraph.Choice;
import org.yakindu.sct.model.sgraph.CompositeElement;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.Exit;
import org.yakindu.sct.model.sgraph.FinalState;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.ScopedElement;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Synchronization;
import org.yakindu.sct.model.sgraph.Vertex;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * NameProvider for SGraph elements like statecharts, scopes and declarations.
 * 
 * @author benjamin schwertfeger
 * @author andreas muelder
 * 
 */
public class SGraphNameProvider extends DefaultDeclarativeQualifiedNameProvider {

	/** "Default" */
	private static final QualifiedName DEFAULT_ENTRY_NAME = QualifiedName
			.create("_entry_Default");
	private static final QualifiedName DEFAULT_EXIT_NAME = QualifiedName
			.create("_exit_Default");
	private static final String _FINAL_STATE_NAME = "_final_";
	private static final String _CHOICE_NAME = "_choice_";
	private static final String _SYNC_NAME = "_sync";

	@Inject
	private IQualifiedNameConverter nameConverter;
	@Inject
	private IdentifierConverter identifierConverter;

	@Override
	protected Function<EObject, String> getResolver() {
		return SimpleAttributeResolver.NAME_RESOLVER;
	}

	public QualifiedName qualifiedName(Statechart ele) {
		String scName = ele.getName();
		if (Strings.isEmpty(scName)) {
			return null;
		}
		QualifiedName name = QualifiedName.create(identifierConverter
				.toIdentifier(ele.getName()));
		if (!Strings.isEmpty(ele.getNamespace())) {
			name = nameConverter.toQualifiedName(ele.getNamespace()).append(
					name);
		}
		return name;
	}

	public QualifiedName qualifiedName(Synchronization ele) {

		QualifiedName qualifiedNameFromConverter = null;

		if (!Strings.isEmpty(ele.getName())) {
			qualifiedNameFromConverter = QualifiedName.create(ele.getName());
		} else {
			LinkedList<Synchronization> list = new LinkedList<Synchronization>();
			Iterables.addAll(list, Iterables.filter(
					((Region) ele.eContainer()).getVertices(),
					Synchronization.class));
			qualifiedNameFromConverter = QualifiedName.create(_SYNC_NAME
					+ list.indexOf(ele));
		}

		return getParentQualifiedName(ele, qualifiedNameFromConverter);
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

		QualifiedName qualifiedNameFromConverter = QualifiedName
				.create(_CHOICE_NAME + index);

		return getParentQualifiedName(ele, qualifiedNameFromConverter);
	}

	public QualifiedName qualifiedName(Entry ele) {

		QualifiedName name = DEFAULT_ENTRY_NAME;
		if (ele.getName() != null && !ele.getName().isEmpty()) {
			name = QualifiedName.create(ele.getName());
		}

		return getParentQualifiedName(ele, name);
	}

	public QualifiedName qualifiedName(Exit ele) {

		QualifiedName name = DEFAULT_EXIT_NAME;
		if (ele.getName() != null && !ele.getName().isEmpty()) {
			name = QualifiedName.create(ele.getName());
		}

		return getParentQualifiedName(ele, name);
	}

	protected QualifiedName getParentQualifiedName(final EObject ele,
			final QualifiedName childName) {
		EObject temp = ele;
		while (temp.eContainer() != null) {
			temp = temp.eContainer();
			QualifiedName parentsQualifiedName = getFullyQualifiedName(temp);
			if (parentsQualifiedName != null)
				return parentsQualifiedName.append(childName);
		}
		return childName;
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
		QualifiedName qfn = null;
		if (Strings.isEmpty(ele.getName())) {
			qfn = QualifiedName.create(_FINAL_STATE_NAME);
		} else {
			qfn = QualifiedName.create(identifierConverter.toIdentifier(ele
					.getName()));
		}

		return getParentQualifiedName(ele, qfn);
	}

	public QualifiedName qualifiedName(State ele) {
		if (ele.getName() == null) {
			return null;
		}
		QualifiedName qualifiedNameFromConverter = QualifiedName
				.create(identifierConverter.toIdentifier(ele.getName()));

		return getParentQualifiedName(ele, qualifiedNameFromConverter);
	}

	public QualifiedName qualifiedName(Region ele) {
		QualifiedName qualifiedNameFromConverter = null;
		if (ele.getName() == null || ele.getName().isEmpty()) {
			if (ele.eContainer() instanceof CompositeElement) {
				CompositeElement parent = (CompositeElement) ele.eContainer();
				int index = parent.getRegions().indexOf(ele);
				if (index != -1) {
					qualifiedNameFromConverter = QualifiedName.create("_region"
							+ index);
				}
			}
			if (qualifiedNameFromConverter == null) {
				return null;
			}
		} else {
			qualifiedNameFromConverter = QualifiedName
					.create(identifierConverter.toIdentifier(ele.getName()));
		}

		return getParentQualifiedName(ele, qualifiedNameFromConverter);
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
