package org.yakindu.sct.model.sexec.transformation

import org.eclipse.emf.ecore.EObject
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.ExpressionsFactory
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression
import org.yakindu.base.types.Expression
import org.yakindu.base.types.Operation
import org.yakindu.base.expressions.expressions.LogicalOrExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.types.Declaration
import org.yakindu.base.expressions.expressions.MetaCall
import org.yakindu.base.types.TypesFactory

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

	def LogicalOrExpression _or(Expression e1, Expression e2) {
		createLogicalOrExpression => [
			leftOperand = e1
			rightOperand = e2
		]
	}

}
