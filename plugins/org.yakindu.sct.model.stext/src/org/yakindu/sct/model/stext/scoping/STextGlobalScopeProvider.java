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
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.DefaultGlobalScopeProvider;
import org.eclipse.xtext.scoping.impl.FilteringScope;
import org.yakindu.base.types.ITypeSystem;
import org.yakindu.base.types.scope.TypeSystemAwareScope;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.stext.stext.StextPackage;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

import de.itemis.xtext.utils.jface.viewers.ContextElementAdapter;

/**
 * @author andreas muelder - Initial contribution and API
 * @author Alexander Nyßen - Ensured type system information is only inferred via {@link ITypeSystem} facade.
 * 
 */
public class STextGlobalScopeProvider extends DefaultGlobalScopeProvider {

	@Inject
	private ITypeSystem typeSystem;

	@Inject
	private IQualifiedNameProvider qualifiedNameProvider;

	public IScope getScope(Resource context, EReference reference,
			Predicate<IEObjectDescription> filter) {
		IScope parentScope = super.getScope(context, reference, filter);
//		parentScope = filterExternalDeclarations(context, parentScope);

		parentScope = new TypeSystemAwareScope(parentScope, typeSystem,
				qualifiedNameProvider, reference.getEReferenceType());
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
									|| SGraphPackage.Literals.REGULAR_STATE
											.isSuperTypeOf(input.getEClass())
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
}
