package org.yakindu.sct.model.sexec.transformation

import org.yakindu.base.expressions.expressions.Expression
import org.yakindu.base.expressions.expressions.ExpressionsFactory
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.stext.stext.StextFactory

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


	def Expression active(State state) {
		val active = factory.createActiveStateReferenceExpression
		active.value = state
		active
	}

} 