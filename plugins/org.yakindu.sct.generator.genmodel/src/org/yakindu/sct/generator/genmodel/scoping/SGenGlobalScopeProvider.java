/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.genmodel.scoping;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.DefaultGlobalScopeProvider;
import org.yakindu.base.expressions.scoping.TypeSystemAwareScope;
import org.yakindu.base.types.typesystem.ITypeSystem;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SGenGlobalScopeProvider extends DefaultGlobalScopeProvider {

	@Inject
	private ITypeSystem typeSystem;
	@Inject
	private IQualifiedNameProvider qualifiedNameProvider;

	@Override
	public IScope getScope(Resource resource, EReference reference, Predicate<IEObjectDescription> filter) {
		if (reference.getEReferenceType() == org.yakindu.base.types.TypesPackage.Literals.TYPE) {
			return new TypeSystemAwareScope(IScope.NULLSCOPE, typeSystem, qualifiedNameProvider,
					reference.getEReferenceType());
		}
		return super.getScope(resource, reference, filter);
	}

}
