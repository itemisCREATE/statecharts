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
package org.yakindu.sct.model.stext.scoping;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.DefaultGlobalScopeProvider;
import org.eclipse.xtext.scoping.impl.FilteringScope;
import org.yakindu.base.types.TypesPackage;
import org.yakindu.base.types.scope.TypeLibrariesExtensionPointScopeHelper;
import org.yakindu.sct.model.stext.stext.StextPackage;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

import de.itemis.xtext.utils.jface.viewers.ContextElementAdapter;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class STextGlobalScopeProvider extends DefaultGlobalScopeProvider {

	@Inject
	private TypeLibrariesExtensionPointScopeHelper typeScopeHelper;

	public IScope getScope(Resource context, EReference reference,
			Predicate<IEObjectDescription> filter) {
		IScope parentScope = super.getScope(context, reference, filter);
		parentScope = filterExternalDeclarations(context, parentScope);
		parentScope = addTypeLibraries(reference, parentScope);
		return parentScope;
	}

	/**
	 * Filter all Variables and Events that are not contained in context
	 * resource
	 * 
	 * @param context
	 * @param parentScope
	 * @return
	 */
	protected IScope filterExternalDeclarations(Resource context,
			IScope parentScope) {
		final ContextElementAdapter provider = (ContextElementAdapter) EcoreUtil
				.getExistingAdapter(context, ContextElementAdapter.class);
		if (provider != null) {
			parentScope = new FilteringScope(parentScope,
					new Predicate<IEObjectDescription>() {
						public boolean apply(IEObjectDescription input) {
							if (input.getEClass() == StextPackage.Literals.EVENT_DEFINITION
									|| input.getEClass() == StextPackage.Literals.VARIABLE_DEFINITION) {
								URI sourceURI = input.getEObjectURI()
										.trimFragment();
								return sourceURI.equals(provider.getElement()
										.eResource().getURI());
							}
							return true;
						}
					});
		}
		return parentScope;
	}

	/**
	 * add types from type libraries, in case the type of the reference refers
	 * to Type
	 * 
	 * @param reference
	 * @param parentScope
	 * @return
	 */
	protected IScope addTypeLibraries(EReference reference, IScope parentScope) {
		if (reference.getEReferenceType().isSuperTypeOf(
				TypesPackage.eINSTANCE.getType())) {
			return typeScopeHelper.createExtensionScope(parentScope);
		}
		return parentScope;
	}

}
