/**
 * Copyright (c) 2019 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 *  thomas kutz - itemis AG
 *  axel terfloth - itemis AG
 */
package org.yakindu.base.expressions.util

import org.eclipse.emf.ecore.EObject
import org.yakindu.base.expressions.expressions.AdditiveOperator
import org.yakindu.base.expressions.expressions.ArgumentExpression
import org.yakindu.base.expressions.expressions.AssignmentOperator
import org.yakindu.base.expressions.expressions.BlockExpression
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.ExpressionsFactory
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.expressions.IfExpression
import org.yakindu.base.expressions.expressions.MultiplicativeOperator
import org.yakindu.base.expressions.expressions.PostFixOperator
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression
import org.yakindu.base.expressions.expressions.RelationalOperator
import org.yakindu.base.expressions.expressions.ShiftOperator
import org.yakindu.base.expressions.expressions.SwitchCase
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Constructor
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.Event
import org.yakindu.base.types.Expression
import org.yakindu.base.types.Operation

/**
 * Builder extension for building expressions.
 * 
 * @author axel terfloth
 * @author thomas kutz
 */
class ExpressionBuilder {

	extension ExpressionsFactory eFactory = ExpressionsFactory.eINSTANCE

	def BlockExpression _block(Expression... sequenceSteps) {
		createBlockExpression => [
			expressions.addAll(sequenceSteps.filter(step|step !== null))
		]
	}

	def PrimitiveValueExpression _true() {
		createPrimitiveValueExpression => [
			value = createBoolLiteral => [value = true]
		]
	}

	def PrimitiveValueExpression _false() {
		createPrimitiveValueExpression => [
			value = createBoolLiteral => [value = false]
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

	def ArgumentExpression _with(ArgumentExpression it, Expression... arguments) {
		it.arguments.addAll(arguments.map[arg|createArgument => [value = arg]])
		return it
	}

	def ElementReferenceExpression _ref(EObject p) {
		createElementReferenceExpression => [
			reference = p
			operationCall = false
		]
	}
	
	def ElementReferenceExpression _new(ComplexType it, Expression...arguments) {
		features.filter(Constructor).head._call() => [
			arguments.addAll(arguments.map[arg|createArgument => [value = arg]])
		]
	}

	def FeatureCall _fc(Expression owner, Declaration feature, Expression... arguments) {
		createFeatureCall => [ fc |
			fc.owner = owner
			fc.feature = feature
			fc.operationCall = feature instanceof Operation
			fc.arguments.addAll(arguments.map[arg|createArgument => [value = arg]])
		]
	}

	def ArgumentExpression _qref(Declaration... parts) {
		return parts.fold(
			null as ArgumentExpression,
			[o, p|if(o === null) p._ref else o._fc(p)]
		)
	}

	def ElementReferenceExpression _get(ElementReferenceExpression exp, Expression index) {
		exp.arraySelector += index
		exp.arrayAccess = true
		exp
	}

	def _for(Expression varDecl, Expression cond, Expression varUpdate) {
		createForExpression => [
			varInits += varDecl
			condition = cond
			varUpdates += varUpdate
		]
	}
	
	def _while(Expression cond) {
		createWhileExpression => [
			condition = cond
		]
	}

	def _smaller(Expression left, Expression right) {
		createLogicalRelationExpression => [
			operator = RelationalOperator.SMALLER
			leftOperand = left
			rightOperand = right
		]
	}

	def _smallerEqual(Expression left, Expression right) {
		createLogicalRelationExpression => [
			operator = RelationalOperator.SMALLER_EQUAL
			leftOperand = left
			rightOperand = right
		]
	}

	def _greaterEqual(Expression left, Expression right) {
		createLogicalRelationExpression => [
			operator = RelationalOperator.GREATER_EQUAL
			leftOperand = left
			rightOperand = right
		]
	}
	
	def _greater(Expression left, Expression right) {
		createLogicalRelationExpression => [
			operator = RelationalOperator.GREATER
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

	def _bitwiseXor(Expression left, Expression right) {
		createBitwiseXorExpression => [
			it.leftOperand = left
			it.rightOperand = right
		]
	}

	def _bitwiseOr(Expression left, Expression right) {
		createBitwiseOrExpression => [
			it.leftOperand = left
			it.rightOperand = right
		]
	}

	def _bitwiseAnd(Expression left, Expression right) {
		createBitwiseAndExpression => [
			it.leftOperand = left
			it.rightOperand = right
		]
	}

	def _leftShift(Expression left, Expression right) {
		createShiftExpression => [
			operator = ShiftOperator.LEFT
			it.leftOperand = left
			it.rightOperand = right
		]
	}

	def _rightShift(Expression left, Expression right) {
		createShiftExpression => [
			operator = ShiftOperator.RIGHT
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

	def _if(Expression cond) {
		createIfExpression => [
			condition = cond
		]
	}

	def _then(IfExpression ife, Expression then) {
		ife.then = then
		ife
	}

	def _else(IfExpression ife, Expression e) {
		ife.^else = e
		ife
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

	def _divide(Expression left, Expression right) {
		createNumericalMultiplyDivideExpression => [
			operator = MultiplicativeOperator::DIV
			leftOperand = left
			rightOperand = right
		]
	}

	def _multiply(Expression left, Expression right) {
		createNumericalMultiplyDivideExpression => [
			operator = MultiplicativeOperator::MUL
			leftOperand = left
			rightOperand = right
		]
	}

	def _mod(Expression left, Expression right) {
		createNumericalMultiplyDivideExpression => [
			operator = MultiplicativeOperator::MOD
			leftOperand = left
			rightOperand = right
		]
	}

	def _plus(Expression left, Expression right) {
		createNumericalAddSubtractExpression => [
			operator = AdditiveOperator::PLUS
			leftOperand = left
			rightOperand = right
		]
	}

	def _minus(Expression left, Expression right) {
		createNumericalAddSubtractExpression => [
			operator = AdditiveOperator::MINUS
			leftOperand = left
			rightOperand = right
		]
	}

	def dispatch value(Boolean b) {
		createPrimitiveValueExpression => [
			value = createBoolLiteral => [value = b.booleanValue]
		]
	}

	def dispatch value(Integer i) {
		createPrimitiveValueExpression => [
			value = createIntLiteral => [value = i.intValue]
		]
	}

	def dispatch value(Long i) {
		createPrimitiveValueExpression => [
			value = createIntLiteral => [value = i.intValue]
		]
	}

	def dispatch Expression value(Double d) {
		createPrimitiveValueExpression => [
			value = createDoubleLiteral => [value = d.doubleValue]
		]
	}

	def dispatch value(Float d) {
		createPrimitiveValueExpression => [
			value = createFloatLiteral => [value = d.floatValue]
		]
	}

	def dispatch value(String i) {
		createPrimitiveValueExpression => [
			value = createStringLiteral => [value = i]
		]
	}

	def dispatch value(Object o) {
		null
	}

	def dispatch value(Void o) {
		null
	}

	def _clearEvent(Event e) {
		createEventClearingExpression => [
			event = e._ref
		]
	}

	def _clearEvent(Expression e) {
		createEventClearingExpression => [
			event = e
		]
	}

}
