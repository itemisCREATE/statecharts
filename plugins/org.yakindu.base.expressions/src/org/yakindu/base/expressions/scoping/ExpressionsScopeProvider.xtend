/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.base.expressions.scoping

import com.google.common.base.Predicate
import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.Scopes
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider
import org.eclipse.xtext.scoping.impl.FilteringScope
import org.yakindu.base.expressions.expressions.Argument
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.EnumerationType
import org.yakindu.base.types.Expression
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Type
import org.yakindu.base.types.inferrer.ITypeSystemInferrer
import org.yakindu.base.types.inferrer.ITypeSystemInferrer.InferenceResult
import com.google.common.base.Predicates

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
class ExpressionsScopeProvider extends AbstractDeclarativeScopeProvider {

	@Inject 
	protected ITypeSystemInferrer typeInferrer

	def scope_Argument_parameter(Argument object, EReference ref) {
		var parameters = object?.eContainer?.operation?.parameters
		return if(parameters !== null) Scopes.scopeFor(parameters) else IScope.NULLSCOPE;
	}

	def scope_Argument_parameter(ElementReferenceExpression exp, EReference ref) {
		var parameters = exp?.operation?.parameters
		return if(parameters !== null) Scopes.scopeFor(parameters) else IScope.NULLSCOPE;
	}

	def scope_Argument_parameter(FeatureCall fc, EReference ref) {
		var parameters = fc?.operation?.parameters
		return if(parameters !== null) Scopes.scopeFor(parameters) else IScope.NULLSCOPE;
	}

	def dispatch getOperation(ElementReferenceExpression it) {
		return if (reference instanceof Operation)
			reference as Operation
		else
			null
	}

	def dispatch getOperation(FeatureCall it) {
		return if (feature instanceof Operation)
			feature as Operation
		else
			null
	}

	def dispatch getOperation(EObject object) {
	}
	
	def IScope scope_FeatureCall_feature(FeatureCall context, EReference reference) {
		var Expression owner = context.getOwner()
		var InferenceResult result = typeInferrer.infer(owner)
		var Type ownerType = if(result !== null) result.getType() else null
		if (ownerType instanceof EnumerationType) {
			return addScopeForEnumType(ownerType, IScope.NULLSCOPE, Predicates.alwaysTrue)
		}
		if (ownerType instanceof ComplexType) {
			return addScopeForComplexType(ownerType, IScope.NULLSCOPE, Predicates.alwaysTrue)
		}
		
	}
	
	def protected IScope addScopeForEnumType(EnumerationType element, IScope parentScope,
		Predicate<IEObjectDescription> predicate) {
		var scope = parentScope
		scope = Scopes.scopeFor((element).getEnumerator(), scope)
		scope = new FilteringScope(scope, predicate)
		return scope
	}

	def protected IScope addScopeForComplexType(ComplexType type, IScope parentScope,
		Predicate<IEObjectDescription> predicate) {
		var scope = parentScope
		scope = Scopes.scopeFor(type.getAllFeatures(), scope)
		scope = new FilteringScope(scope, predicate)
		return scope
	}
	

}
