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
package org.yakindu.sct.model.sexec.transformation

import org.yakindu.base.expressions.expressions.ExpressionsFactory
import org.yakindu.base.types.Expression
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.stext.stext.StextFactory
import org.yakindu.sct.model.stext.stext.SubmachineReferenceExpression
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.sct.model.stext.stext.EventSpec
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Property
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.TypedDeclaration

/**
 * @author Axel Terfloth added 'active' extension
 */
class StextExtensions {
	
	def expfactory() { ExpressionsFactory::eINSTANCE }
	def factory() { StextFactory::eINSTANCE }

	def Expression or(Expression left, Expression right) {
		val or = expfactory.createLogicalOrExpression
		or.leftOperand = left
		or.rightOperand = right
		or
	}
	
	def Expression and(Expression left, Expression right) {
		val and = expfactory.createLogicalAndExpression
		and.leftOperand = left
		and.rightOperand = right
		and
	}

	def Expression parenthesis(Expression exp) {
		val p = expfactory.createParenthesizedExpression
		p.expression = exp
		p
	}


	def Expression active(State state) {
		val active = factory.createActiveStateReferenceExpression
		active.value = state
		active
	}
	
	def operationCall(SubmachineReferenceExpression subRef, String opName) {
		expfactory.createFeatureCall => [
			owner = EcoreUtil.copy(subRef.submachine)
			feature = subRef.submachine.operation(opName)
		]
	}
	
	def localReaction(EventSpec triggerEvent, Expression action) {
		factory.createLocalReaction => [
			trigger = factory.createReactionTrigger => [
				triggers += triggerEvent
			]
			effect = factory.createReactionEffect => [
				actions += action
			]
		]
	}
	
	private def dispatch Operation operation(Expression prop, String opName) {
		throw new IllegalArgumentException("Could not find operation '" + opName + "'.")
	}
	
	private def dispatch Operation operation(FeatureCall fc, String name) {
		fc.feature.operation(name)
	}
	
	private def dispatch Operation operation(ElementReferenceExpression ref, String name) {
		ref.reference.operation(name)
	}
	
	private def dispatch Operation operation(Property prop, String opName) {
		prop.statemachineType.features.filter(Operation).filter[name == opName].head
	}
	
	private def getStatemachineType(TypedDeclaration it) {
		type.superTypes.map[type].filter(ComplexType).filter[name == "Statemachine"].head
	}

} 