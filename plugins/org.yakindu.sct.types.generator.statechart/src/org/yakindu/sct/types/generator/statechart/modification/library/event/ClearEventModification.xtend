package org.yakindu.sct.types.generator.statechart.modification.library.event

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.EcoreUtil2
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.EventClearingExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.util.ExpressionBuilder
import org.yakindu.base.expressions.util.ExpressionExtensions
import org.yakindu.base.types.Event
import org.yakindu.base.types.Expression
import org.yakindu.base.types.Property
import org.yakindu.sct.types.generator.modification.library.ModificationHelper

class ClearEventModification {

	@Inject protected extension ExpressionBuilder
	@Inject protected extension ExpressionExtensions
	@Inject protected extension ModificationHelper
	
	def modifyClearEvent(Property prop, Event e) {
		for (clear : e.clearExpressions) {
			EcoreUtil.replace(clear, clear.event.toAssignment(_fc(prop.ownerInstance._ref, prop), _false))
		}
	}

	protected def List<EventClearingExpression> getClearExpressions(Event e) {
		EcoreUtil2.getRootContainer(e).eAllContents.filter(EventClearingExpression).filter [
			event.featureOrReference.equals(e)
		].toList
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

	def protected dispatch toAssignment(Expression exp, FeatureCall fc, Expression value) {
		val newEre = EcoreUtil.copy(fc)
		newEre._assign(value)
	}
}
