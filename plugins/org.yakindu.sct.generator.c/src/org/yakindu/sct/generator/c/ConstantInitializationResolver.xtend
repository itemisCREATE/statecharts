package org.yakindu.sct.generator.c

import org.yakindu.base.expressions.expressions.Expression
import org.yakindu.sct.model.stext.stext.VariableDefinition

class ConstantInitializationResolver extends ExpressionCode {
	
	def CharSequence resolveConstants(Expression it) {
		code
	}
	
	override dispatch CharSequence code(Expression it, VariableDefinition target) {
		target.initialValue.code
	}
		
}