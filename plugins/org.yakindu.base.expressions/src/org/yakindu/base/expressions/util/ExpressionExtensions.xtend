/**
 * Copyright (c) 2018 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	itemis AG - initial API and implementation
 * 
 */
package org.yakindu.base.expressions.util

import com.google.common.collect.Lists
import com.google.inject.Inject
import java.util.Collections
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.yakindu.base.expressions.expressions.ArgumentExpression
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.types.Expression

/**
 * Thomas Kutz - Initial API and contribution
 */
class ExpressionExtensions {

	@Inject
	protected extension IQualifiedNameProvider

	/**
	 * Transforms a feature call to its call stack by traversing through the owner hierarchy
	 * @return a list of feature calls starting from the root call, 
	 * i.e. for <code>MyInterface.myVar.x</code> it returns <code>[MyInterface, myVar, x]</code>
	 */
	def dispatch List<ArgumentExpression> toCallStack(FeatureCall call) {
		val callStack = Lists.newArrayList
		callStack.addAll(call.owner.toCallStack)
		callStack.add(call)
		callStack
	}

	def dispatch List<ArgumentExpression> toCallStack(ElementReferenceExpression ex) {
		Lists.newArrayList(ex)
	}
	
	def dispatch List<ArgumentExpression> toCallStack(Expression ex) {
		Collections.emptyList
	}
	
	/**
	 * Returns getFeature() for FeatureCall and getReference() for ElementReferenceExpression
	 */
	def dispatch EObject featureOrReference(ArgumentExpression it) {
		null
	}
	
	def dispatch EObject featureOrReference(FeatureCall it) {
		feature
	}
	
	def dispatch EObject featureOrReference(ElementReferenceExpression it) {
		reference
	}
}
