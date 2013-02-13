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
package org.yakindu.base.types.scope;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractScope;
import org.yakindu.base.types.ITypeSystem;

public class TypeSystemAwareScope extends AbstractScope {

	private final ITypeSystem typeSystemAccess;

	private final IQualifiedNameProvider qualifiedNameProvider;

	private EClass eClass;

	public TypeSystemAwareScope(IScope parent,
			ITypeSystem typeSystemAccess,
			IQualifiedNameProvider qualifiedNameProvider, EClass eClass) {
		super(parent, false);
		this.typeSystemAccess = typeSystemAccess;
		this.qualifiedNameProvider = qualifiedNameProvider;
		this.eClass = eClass;
	}

	@Override
	protected Iterable<IEObjectDescription> getAllLocalElements() {
		Iterable<IEObjectDescription> iterable = Scopes.scopedElementsFor(
				EcoreUtil2.<EObject>getObjectsByType(typeSystemAccess.getTypes(), eClass), qualifiedNameProvider);
		return iterable;
	}
}