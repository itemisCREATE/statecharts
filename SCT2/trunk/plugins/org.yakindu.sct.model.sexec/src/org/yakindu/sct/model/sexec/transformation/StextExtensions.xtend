package org.yakindu.sct.model.sexec.transformation

import org.yakindu.sct.model.stext.stext.StextFactory
import org.yakindu.sct.model.stext.stext.Expression
import org.yakindu.sct.model.sgraph.State

/**
 * @author Axel Terfloth added 'active' extension
 */
class StextExtensions {
	
	def factory() { StextFactory::eINSTANCE }

	def Expression or(Expression left, Expression right) {
		val or = factory.createLogicalOrExpression
		or.leftOperand = left
		or.rightOperand = right
		or
	}
	
	def Expression and(Expression left, Expression right) {
		val and = factory.createLogicalAndExpression
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