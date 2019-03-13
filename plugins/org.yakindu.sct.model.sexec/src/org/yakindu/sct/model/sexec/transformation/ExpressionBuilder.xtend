package org.yakindu.sct.model.sexec.transformation

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.ExpressionsFactory
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Property
import org.yakindu.base.types.TypedElement
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.base.types.Expression
import org.yakindu.base.expressions.expressions.RelationalOperator
import org.yakindu.base.expressions.expressions.UnaryOperator
import org.yakindu.base.expressions.expressions.PostFixOperator

class ExpressionBuilder {

	@Inject extension ITypeSystem typeSystem

	def PrimitiveValueExpression _true() {
		ExpressionsFactory.eINSTANCE.createPrimitiveValueExpression => [
			value = ExpressionsFactory.eINSTANCE.createBoolLiteral => [value = true]
		]
	}

	def PrimitiveValueExpression _false() {
		ExpressionsFactory.eINSTANCE.createPrimitiveValueExpression => [
			value = ExpressionsFactory.eINSTANCE.createBoolLiteral => [value = false]
		]
	}
	
	def PrimitiveValueExpression _int(int v) {
		ExpressionsFactory.eINSTANCE.createPrimitiveValueExpression => [
			value = ExpressionsFactory.eINSTANCE.createIntLiteral => [value = v]
		]
	}

	def ElementReferenceExpression _call(Operation op) {
		ExpressionsFactory.eINSTANCE.createElementReferenceExpression => [
			reference = op
			operationCall = true
		]
	}

	def ElementReferenceExpression _ref(EObject p) {
		ExpressionsFactory.eINSTANCE.createElementReferenceExpression => [
			reference = p
			operationCall = false
		]
	}

	def _type(TypedElement it, String typeName) {
		typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier => [
			type = typeSystem.getType(typeName);
		]
	}
	
	def _variable(String name, String typeName) {
		TypesFactory.eINSTANCE.createProperty => [ prop |
			prop.name = name
			prop._type(typeName)
		]	
	}
	
	def _variable(String name, String typeName, Expression init) {
		TypesFactory.eINSTANCE.createProperty => [ prop |
			prop.name = name
			prop._type(typeName)
			prop.initialValue = init
		]	
	}
	
	def _for(Property varDecl, Expression cond, Expression varUpdate) {
		ExpressionsFactory.eINSTANCE.createForExpression => [
			varDecls += varDecl
			condition = cond
			varUpdates += varUpdate
		]
	}
	
	def _smaller(Expression left, Expression right) {
		ExpressionsFactory.eINSTANCE.createLogicalRelationExpression => [
			operator = RelationalOperator.SMALLER
			leftOperand = left
			rightOperand = right
		]
	}
	
	def _inc(Expression operand) {
		ExpressionsFactory.eINSTANCE.createPostFixUnaryExpression => [
			it.operand = operand
			operator = PostFixOperator.INCREMENT
		]
	}

}
