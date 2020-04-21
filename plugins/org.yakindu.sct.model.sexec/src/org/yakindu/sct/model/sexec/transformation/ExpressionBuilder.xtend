package org.yakindu.sct.model.sexec.transformation

import org.eclipse.emf.ecore.EObject
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.ExpressionsFactory
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression
import org.yakindu.base.types.Expression
import org.yakindu.base.types.Operation

class ExpressionBuilder {

	extension ExpressionsFactory eFactory = ExpressionsFactory.eINSTANCE

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
		if (p instanceof ElementReferenceExpression) return p
		createElementReferenceExpression => [
			reference = p
			operationCall = false
			operationCall = p instanceof Operation
			arguments.addAll(arguments.map[arg|createArgument => [value = arg]])
		]
	}

}
