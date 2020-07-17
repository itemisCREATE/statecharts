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

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.Scopes
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.types.Annotation
import org.yakindu.base.types.Argument
import org.yakindu.base.types.Operation

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
class ExpressionsScopeProvider extends AbstractDeclarativeScopeProvider {
	
	def scope_Argument_parameter(Argument object, EReference ref) {
		var parameters = object?.eContainer?.operation?.parameters
		return if(parameters !== null) Scopes.scopeFor(parameters) else IScope.NULLSCOPE;
	}

	def scope_Argument_parameter(Annotation object, EReference ref) {
		var parameters = object?.operation?.parameters
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
	
	def dispatch getOperation(Annotation op)
	{
		op.type
	}

	def dispatch getOperation(EObject object) {
	}

}
