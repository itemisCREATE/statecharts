/**
* Copyright (c) 2019 itemis AG - All rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* 
* Contributors:
* 	itemis AG
*
*/
package org.yakindu.base.expressions.util

import org.yakindu.base.expressions.expressions.AssignmentOperator
import org.yakindu.base.expressions.expressions.ExpressionsFactory
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.expressions.ReturnExpression
import org.yakindu.base.types.Expression
import org.yakindu.base.types.Property
import org.yakindu.base.types.Type
import org.yakindu.base.types.TypeSpecifier
import org.yakindu.base.types.TypesFactory

class ExpressionsHelper {
	protected ExpressionsFactory expFactory = ExpressionsFactory.eINSTANCE
	protected TypesFactory typesFactory = TypesFactory.eINSTANCE
	
	def dispatch primitiveLiteral(Object value) {
		
	}
	
	def dispatch primitiveLiteral(Void value) {
		primitiveValueExpression => [ prim |
			prim.value = expFactory.createNullLiteral
		]
	}
	
	def dispatch primitiveLiteral(Boolean value) {
		primitiveValueExpression => [ prim |
			prim.value = expFactory.createBoolLiteral => [ b |
				b.value = value.booleanValue
			]
		]
	}
	
	def dispatch primitiveLiteral(Integer value) {
		primitiveValueExpression => [ prim |
			prim.value = expFactory.createIntLiteral => [ i |
				i.value = value.intValue
			]
		]
	}
	
	def dispatch primitiveLiteral(String value) {
		primitiveValueExpression => [ prim |
			prim.value = expFactory.createStringLiteral => [ s |
				s.value = value
			]
		]
	}
	
	def protected primitiveValueExpression() {
		expFactory.createPrimitiveValueExpression
	}
	
	def assign(Property property, Object value) {
		expFactory.createAssignmentExpression => [
			varRef = property.elementReference
			operator = AssignmentOperator.ASSIGN
			expression = value.primitiveLiteral
		]
	}
	
	def assign(FeatureCall fc, Object value) {
		expFactory.createAssignmentExpression => [
			varRef = fc
			operator = AssignmentOperator.ASSIGN
			expression = value.primitiveLiteral
		]
	}
	
	def assign(FeatureCall fc, Expression exp) {
		expFactory.createAssignmentExpression => [
			varRef = fc
			operator = AssignmentOperator.ASSIGN
			expression = exp
		]
	}
	
	def property(Type type, String name) {
		typesFactory.createProperty => [
			it.typeSpecifier = typeSpecifier(type)
			it.name = name
		]
	}
	
	def typeSpecifier(Type type) {
		typesFactory.createTypeSpecifier => [
			it.type = type
		]
	}
	
	def codeBlock(Expression... exp) {
		val block = expFactory.createBlockExpression
		block.expressions += exp
		block
	}
	
	def elementReference(Property property) {
		expFactory.createElementReferenceExpression => [
			it.reference = property
		]
	}
	
	def dispatch ReturnExpression returnExpression(Expression expression) {
		expFactory.createReturnExpression => [
			it.expression = expression
		]
	}
	
	def dispatch ReturnExpression returnExpression(Property property) {
		returnExpression(property.elementReference)
	}
	
	def operation(String name, Expression... body) {
		typesFactory.createOperation => [
			it.name = name
			it.body = codeBlock(body)
		]
	}
	
	def operation(String name, Type type, Expression... body) {
		operation(name, typeSpecifier(type), body)
	}
	
	def operation(String name, TypeSpecifier typeSpecifier, Expression... body) {
		typesFactory.createOperation => [
			it.name = name
			it.typeSpecifier = typeSpecifier
			it.body = codeBlock(body)
		]
	}
}
