/**
 * Copyright (c) 2019 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 *  thomas kutz - itemis AG
 *  axel terfloth - itemis AG
 */
package org.yakindu.sct.model.sexec.transformation

import org.eclipse.emf.ecore.EObject
import org.yakindu.base.expressions.expressions.AssignmentOperator
import org.yakindu.base.expressions.expressions.BlockExpression
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.ExpressionsFactory
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.expressions.PostFixOperator
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression
import org.yakindu.base.expressions.expressions.RelationalOperator
import org.yakindu.base.expressions.expressions.SwitchCase
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.Expression
import org.yakindu.base.types.Operation

/**
 * Builder extension for building expressions.
 * 
 * TODO: move to expressions plugin
 * 
 * @author axel terfloth
 * @author thomas kutz
 */
class ExpressionBuilder {

	extension ExpressionsFactory eFactory = ExpressionsFactory.eINSTANCE
	
	def BlockExpression _block (Expression... sequenceSteps) {
		createBlockExpression => [
			expressions.addAll(sequenceSteps.filter(step | step !== null))
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

	def ElementReferenceExpression _call(Operation op, Expression... arguments) {
		createElementReferenceExpression => [
			it.reference = op
			it.operationCall = true
			it.arguments.addAll(arguments.map[arg|createArgument => [value = arg]])
		]
	}

	def ElementReferenceExpression _ref(EObject p) {
		createElementReferenceExpression => [
			reference = p
			operationCall = false
		]
	}
	
	def FeatureCall _fc(Expression owner, Declaration feature, Expression... arguments) {
		createFeatureCall => [fc |
			fc.owner = owner
			fc.feature = feature
			fc.operationCall = feature instanceof Operation
			fc.arguments.addAll(arguments.map[arg|createArgument => [value = arg]])
		]
	}
	
	def ElementReferenceExpression _get(ElementReferenceExpression exp, Expression index) {
		exp.arraySelector += index
		exp
	}
	
	def _for(Expression varDecl, Expression cond, Expression varUpdate) {
		createForExpression => [
			varInits += varDecl
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
	
	def _assign(Expression left, Expression right) {
		createAssignmentExpression => [
			it.varRef = left
			it.expression = right 
			it.operator = AssignmentOperator.ASSIGN
		]
	}
	
	def _comment(EObject it, String comment) {
		// TODO: implement comment handling e.g. using adapters.
	}

	def _return(Expression exp) {
		createReturnExpression => [
			it.expression = exp
		]
	}
	
	def _or(Expression left, Expression right) {
		createLogicalOrExpression => [
			it.leftOperand = left
			it.rightOperand = right
		]
	}
	
	def _and(Expression left, Expression right) {
		createLogicalAndExpression => [
			it.leftOperand = left
			it.rightOperand = right
		]
	}
	
	def _notEquals(Expression left, Expression right) {
		createLogicalRelationExpression => [
			operator = RelationalOperator.NOT_EQUALS
			leftOperand = left
			rightOperand = right
		]
	}
	
	def _equals(Expression left, Expression right) {
		createLogicalRelationExpression => [
			operator = RelationalOperator.EQUALS
			leftOperand = left
			rightOperand = right
		]
	}
	
	def _parenthesized(Expression exp) {
		createParenthesizedExpression => [
			expression = exp
		]
	}
	
	def _switch(Expression exp, SwitchCase... cases) {
		createSwitchExpression => [
			it.^switch = exp
			it.cases.addAll(cases)
		]
	}
	
	def _case(Expression ^case, Expression then) {
		createSwitchCase => [
			it.^case = ^case
			it.then = then
		]
	}


}
