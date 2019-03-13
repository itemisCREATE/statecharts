package org.yakindu.sct.model.sexec.transformation

import org.yakindu.base.expressions.expressions.PrimitiveValueExpression
import org.yakindu.base.expressions.expressions.ExpressionsFactory
import org.yakindu.base.expressions.expressions.BlockExpression
import org.yakindu.base.types.Expression

class ExpressionBuilder {
	
	extension ExpressionsFactory eFactory = ExpressionsFactory.eINSTANCE
	
	def BlockExpression _block (Expression... sequenceSteps) {
		createBlockExpression => [
			expressions.addAll(sequenceSteps)
		]
	}		
	
	def PrimitiveValueExpression _true() { 
		createPrimitiveValueExpression => [
			value = createBoolLiteral => [ value = true]	
		]
	}
	 
	def PrimitiveValueExpression _false() { 
		createPrimitiveValueExpression => [
			value = createBoolLiteral => [ value = false]	
		]
	}
	
}