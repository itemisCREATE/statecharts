package org.yakindu.sct.model.sexec.transformation

import org.yakindu.base.expressions.expressions.PrimitiveValueExpression
import org.yakindu.base.expressions.expressions.ExpressionsFactory

class ExpressionBuilder {
	
	def PrimitiveValueExpression _true() { 
		ExpressionsFactory.eINSTANCE.createPrimitiveValueExpression => [
			value = ExpressionsFactory.eINSTANCE.createBoolLiteral => [ value = true]	
		]
	}
	 
	def PrimitiveValueExpression _false() { 
		ExpressionsFactory.eINSTANCE.createPrimitiveValueExpression => [
			value = ExpressionsFactory.eINSTANCE.createBoolLiteral => [ value = false]	
		]
	}
	
}