package org.yakindu.sct.model.sexec.transformation

import org.eclipse.emf.ecore.EObject
import org.yakindu.base.expressions.expressions.BlockExpression
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.ExpressionsFactory
import org.yakindu.base.expressions.expressions.PostFixOperator
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression
import org.yakindu.base.expressions.expressions.RelationalOperator
import org.yakindu.base.types.Expression
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Property

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
	
	def PrimitiveValueExpression _int(int v) {
		createPrimitiveValueExpression => [
			value = createIntLiteral => [value = v]
		]
	}

	def ElementReferenceExpression _call(Operation op) {
		createElementReferenceExpression => [
			reference = op
			operationCall = true
		]
	}

	def ElementReferenceExpression _ref(EObject p) {
		createElementReferenceExpression => [
			reference = p
			operationCall = false
		]
	}

	
	def _for(Property varDecl, Expression cond, Expression varUpdate) {
		createForExpression => [
			varDecls += varDecl
			condition = cond
			varUpdates += varUpdate
		]
	}
	
	def _smaller(Expression left, Expression right) {
		createLogicalRelationExpression => [
			operator = RelationalOperator.SMALLER
			leftOperand = left
			rightOperand = right
		]
	}
	
	def _inc(Expression operand) {
		createPostFixUnaryExpression => [
			it.operand = operand
			operator = PostFixOperator.INCREMENT
		]
	}

}
