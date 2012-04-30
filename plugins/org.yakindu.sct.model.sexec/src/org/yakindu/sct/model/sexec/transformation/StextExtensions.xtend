package org.yakindu.sct.model.sexec.transformation

import org.yakindu.sct.model.stext.stext.StextFactory
import org.yakindu.sct.model.stext.stext.Expression


class StextExtensions {
	
	def factory() { StextFactory::eINSTANCE }

	def Expression or(Expression left, Expression right) {
		val or = factory.createLogicalOrExpression
		or.leftOperand = left
		or.rightOperand = right
		or
	}
	
	def Expression and(Expression left, Expression right) {
		val or = factory.createLogicalAndExpression
		or.leftOperand = left
		or.rightOperand = right
		or
	}
} 