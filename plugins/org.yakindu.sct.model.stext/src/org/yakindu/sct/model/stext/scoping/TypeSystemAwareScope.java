/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Alexander Nyssen (itemis AG) - initial API and implementation
 */
package org.yakindu.sct.model.stext.scoping;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractScope;
import org.yakindu.base.types.ITypeSystemRegistry;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.sct.domain.extension.DefaultDomain;
import org.yakindu.sct.model.sgraph.Statechart;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class TypeSystemAwareScope extends AbstractScope {

	private final ITypeSystemRegistry typeSystemAccess;

	private final IQualifiedNameProvider qualifiedNameProvider;

	private EClass eClass;

	private String domainID;

	private Statechart context;

	public TypeSystemAwareScope(IScope parent, ITypeSystemRegistry typeSystemAccess,
			IQualifiedNameProvider qualifiedNameProvider, EClass eClass, String domainID, Statechart context) {
		super(parent, false);
		this.typeSystemAccess = typeSystemAccess;
		this.qualifiedNameProvider = qualifiedNameProvider;
		this.eClass = eClass;
		this.context = context;
		this.domainID = domainID != null ? domainID : DefaultDomain.DOMAIN_ID;
	}

	@Override
	protected Iterable<IEObjectDescription> getAllLocalElements() {
		List<IEObjectDescription> result = Lists.newArrayList();
		Iterable<ITypeSystem> allTypeSystems = typeSystemAccess.getTypeSystems(domainID);
		for (ITypeSystem iTypeSystem : allTypeSystems) {
			Iterable<IEObjectDescription> iterable = Scopes
					.scopedElementsFor(EcoreUtil2.<EObject> getObjectsByType(iTypeSystem.getTypes(context), eClass),
							qualifiedNameProvider);
			Iterables.addAll(result, iterable);
		}
		return result;
	}
}