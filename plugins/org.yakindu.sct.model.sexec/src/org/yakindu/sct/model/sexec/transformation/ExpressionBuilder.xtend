package org.yakindu.sct.model.sexec.transformation

import org.eclipse.emf.ecore.EObject
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.ExpressionsFactory
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.expressions.MetaCall
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.Expression
import org.yakindu.base.types.Operation
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.expressions.expressions.NumericalAddSubtractExpression
import org.yakindu.base.expressions.expressions.NumericalMultiplyDivideExpression
import org.yakindu.base.expressions.expressions.AdditiveOperator
import org.yakindu.base.expressions.expressions.MultiplicativeOperator
import org.yakindu.base.expressions.expressions.BitwiseAndExpression
import org.yakindu.base.expressions.expressions.BitwiseOrExpression
import org.yakindu.base.expressions.expressions.BitwiseXorExpression
import org.yakindu.base.expressions.expressions.LogicalAndExpression
import org.yakindu.base.expressions.expressions.LogicalOrExpression
import org.yakindu.base.expressions.expressions.LogicalRelationExpression
import org.yakindu.base.expressions.expressions.RelationalOperator
import org.yakindu.base.expressions.expressions.ParenthesizedExpression

class ExpressionBuilder {

	extension ExpressionsFactory = ExpressionsFactory.eINSTANCE
	extension TypesFactory = TypesFactory.eINSTANCE

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

	def PrimitiveValueExpression _integer(Long l) {
		createPrimitiveValueExpression => [
			value = createIntLiteral => [value = l.intValue]
		]
	}
	
	def PrimitiveValueExpression _integer(Integer i) {
		createPrimitiveValueExpression => [
			value = createIntLiteral => [value = i]
		]
	}

	def PrimitiveValueExpression _double(Double d) {
		createPrimitiveValueExpression => [
			value = createDoubleLiteral => [value = d]
		]
	}
	
	def PrimitiveValueExpression _float(Float f) {
		createPrimitiveValueExpression => [
			value = createFloatLiteral => [value = f]
		]
	}
	

	def ElementReferenceExpression _ref(EObject p, Expression... arguments) {
		if(p instanceof ElementReferenceExpression) return p
		createElementReferenceExpression => [
			reference = p
			operationCall = p instanceof Operation
			arguments.addAll(arguments.map[arg|createArgument => [value = arg]])
		]
	}

	def FeatureCall _dot(Expression o, Declaration p, Expression... arguments) {
		createFeatureCall => [
			owner = o
			feature = p
			operationCall = p instanceof Operation
			arguments.addAll(arguments.map[arg|createArgument => [value = arg]])
		]
	}

	def MetaCall _meta(Expression o, Declaration p, Expression... arguments) {
		createMetaCall => [
			owner = o
			feature = p
			operationCall = p instanceof Operation
			arguments.addAll(arguments.map[arg|createArgument => [value = arg]])
		]
	}
	

	def NumericalAddSubtractExpression _plus(Expression e1, Expression e2) {
		createNumericalAddSubtractExpression => [
			leftOperand = e1
			rightOperand = e2
			operator = AdditiveOperator.PLUS
		]
	}
	
	def NumericalAddSubtractExpression _minus(Expression e1, Expression e2) {
		createNumericalAddSubtractExpression => [
			leftOperand = e1
			rightOperand = e2
			operator = AdditiveOperator.MINUS
		]
	}
	
	def NumericalMultiplyDivideExpression _multiply(Expression e1, Expression e2) {
		createNumericalMultiplyDivideExpression => [
			leftOperand = e1
			rightOperand = e2
			operator = MultiplicativeOperator.MUL
		]
	}
	
	def NumericalMultiplyDivideExpression _divide(Expression e1, Expression e2) {
		createNumericalMultiplyDivideExpression => [
			leftOperand = e1
			rightOperand = e2
			operator = MultiplicativeOperator.DIV
		]
	}
	
	def NumericalMultiplyDivideExpression _modulo(Expression e1, Expression e2) {
		createNumericalMultiplyDivideExpression => [
			leftOperand = e1
			rightOperand = e2
			operator = MultiplicativeOperator.MOD
		]
	}
	
	def BitwiseAndExpression _bitwiseAnd(Expression e1, Expression e2) {
		createBitwiseAndExpression => [
			leftOperand = e1
			rightOperand = e2
		]
	}
	
	def BitwiseOrExpression _bitwiseOr(Expression e1, Expression e2) {
		createBitwiseOrExpression => [
			leftOperand = e1
			rightOperand = e2
		]
	}
	
	def BitwiseXorExpression _bitwiseXor(Expression e1, Expression e2) {
		createBitwiseXorExpression => [
			leftOperand = e1
			rightOperand = e2
		]
	}
	

	
	def LogicalAndExpression _and(Expression e1, Expression e2) {
		createLogicalAndExpression => [
			leftOperand = e1
			rightOperand = e2
		]
	}
	
	def LogicalOrExpression _or(Expression e1, Expression e2) {
		createLogicalOrExpression => [
			leftOperand = e1
			rightOperand = e2
		]
	}
	
	def LogicalRelationExpression _equals(Expression e1, Expression e2) {
		createLogicalRelationExpression => [
			leftOperand = e1
			rightOperand = e2
			operator = RelationalOperator.EQUALS
		]
	}
	
	def LogicalRelationExpression _smaller(Expression e1, Expression e2) {
		createLogicalRelationExpression => [
			leftOperand = e1
			rightOperand = e2
			operator = RelationalOperator.SMALLER
		]
	}
	
	def ParenthesizedExpression _parenthesis(Expression e) {
		createParenthesizedExpression => [
			expression = e
		]
	}

}
