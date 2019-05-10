/**
* Copyright (c) 2019 itemis AG - All rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* 
* Contributors:
* 	itemis AG
*
*/
package com.yakindu.sct.types.slang.generator.core.modifications.events

import com.google.inject.Inject
import com.yakindu.sct.types.slang.generator.core.modifications.ContainmentExtensions
import java.util.List
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.EcoreUtil2
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.EventRaisingExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.util.ExpressionExtensions
import org.yakindu.base.types.Event
import org.yakindu.base.types.Expression
import org.yakindu.base.types.Property
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder

/**
 * Transforms <code>raise e</code> into <code>e_prop = true</code> where <code>e_prop</code> is the event property
 */
class RaiseEventModification {
	
	@Inject extension ExpressionBuilder
	@Inject extension ExpressionExtensions
	@Inject extension ContainmentExtensions

	def modifyRaiseEvent(Property prop, Event e) {
		for (raise : e.raiseExpressions) {
			EcoreUtil.replace(raise, raise.event.toAssignment(prop, _true))
		}
	}
	
	def modifyRaiseEvent(Property prop, Property valueProp, Event e) {
		for (raise : e.raiseExpressions) {
			val propAssignment = raise.event.toAssignment(prop, _true)
			val valueAssignment = raise.event.toAssignment(valueProp, raise.value)
			raise.replaceBy(valueAssignment, propAssignment)
		}
	}
	
	protected def List<EventRaisingExpression> getRaiseExpressions(Event e) {
		EcoreUtil2.getRootContainer(e).eAllContents.filter(EventRaisingExpression).filter[event.featureOrReference.equals(e)].toList
	}
	
	protected def dispatch toAssignment(FeatureCall fc, Property prop, Expression value) {
		val newFc = EcoreUtil.copy(fc)
		newFc.feature = prop
		newFc._assign(value)
	}
	
	protected def dispatch toAssignment(ElementReferenceExpression ere, Property prop, Expression value) {
		val newEre = EcoreUtil.copy(ere)
		newEre.reference = prop
		newEre._assign(value)
	}
	
	protected def dispatch toAssignment(Expression exp, Property prop, Expression value) {
		prop._assign(value)
	}
	
}
