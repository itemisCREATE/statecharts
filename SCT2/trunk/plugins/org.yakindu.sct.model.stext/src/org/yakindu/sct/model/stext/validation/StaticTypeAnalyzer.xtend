/**
 * Copyright (c) 2011 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	itemis AG - initial API and implementation
 *  
 */
package org.yakindu.sct.model.stext.validation

import org.yakindu.sct.model.stext.stext.Expression
import org.yakindu.sct.model.stext.stext.LogicalAndExpression
import org.yakindu.sct.model.sgraph.Statement
import org.yakindu.sct.model.stext.stext.RealLiteral
import org.yakindu.sct.model.stext.stext.BoolLiteral
import org.yakindu.sct.model.stext.stext.IntLiteral
import org.yakindu.sct.model.stext.stext.PrimitiveValueExpression
import org.yakindu.sct.model.stext.stext.LogicalOrExpression
import org.yakindu.sct.model.stext.stext.LogicalNotExpression
import org.yakindu.sct.model.stext.stext.BitwiseAndExpression
import org.yakindu.sct.model.stext.stext.BitwiseOrExpression
import org.yakindu.sct.model.stext.stext.BitwiseXorExpression
import org.yakindu.sct.model.stext.stext.LogicalRelationExpression
import org.yakindu.sct.model.stext.stext.NumericalAddSubtractExpression
import org.yakindu.sct.model.stext.stext.NumericalMultiplyDivideExpression
import org.yakindu.sct.model.stext.stext.ShiftExpression
import org.yakindu.sct.model.stext.stext.NumericalUnaryExpression
import org.yakindu.sct.model.stext.stext.EventValueReferenceExpression
import org.yakindu.sct.model.stext.stext.EventRaisedReferenceExpression
import org.yakindu.sct.model.stext.stext.ElementReferenceExpression
import org.yakindu.sct.model.stext.stext.ConditionalExpression
import org.yakindu.sct.model.stext.stext.EventRaising
import org.yakindu.sct.model.stext.stext.Assignment
import org.yakindu.sct.model.stext.stext.RelationalOperator
import org.yakindu.sct.model.stext.stext.VariableDefinition
import com.google.inject.Inject
import org.eclipse.xtext.validation.ValidationMessageAcceptor
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.base.types.Type
import org.yakindu.sct.model.stext.stext.EventRaisingExpression
import org.yakindu.sct.model.stext.stext.AssignmentExpression
import org.yakindu.sct.model.stext.stext.TypedElementReferenceExpression
import org.yakindu.base.types.Feature
import javax.lang.model.element.TypeElement
import org.yakindu.sct.model.stext.stext.FeatureCall
import org.yakindu.sct.model.stext.validation.ITypeAnalyzer
import org.yakindu.base.types.LibrariesExtensions
import org.yakindu.base.types.scope.TypeLibraryLocation
import org.yakindu.base.types.TypesPackage
import org.yakindu.base.types.TypesFactory
import org.yakindu.sct.model.stext.stext.StringLiteral
import org.eclipse.xtext.validation.AbstractValidationMessageAcceptor
import org.eclipse.xtext.EcoreUtil2
import org.yakindu.sct.model.stext.stext.EventDerivation
 
/**
 * 
 * The Static type analyzer checks an expression AST for type conformance
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
class StaticTypeAnalyzer implements ITypeAnalyzer {
	
	@Inject 
	TypeLibraryLocation$Registry libraries
	@Inject
	ITypeCheckErrorAcceptor acceptor
	
	
	def dispatch inferType(Statement statement){
		null
	}
	
	def check(Statement stmt) {
		stmt.inferType
	}
	
	/**
	 * Check Variable assignments
	 */
	def dispatch inferType(AssignmentExpression assignment){
		var valueType = assignment.expression.inferType
		var type = assignment.varRef.inferType
		
		if(!isAssignable(type, valueType)){
			error("Can not assign a value of type " + valueType?.name + " to a variable of type " + type?.name)
			return null 
		}
		return type
	}
	/**
	 * Check Event value assignments
	 */
	def dispatch inferType(EventRaisingExpression eventRaising){
		var valueType = eventRaising.value.inferType
		var type = eventRaising.event.inferType
		
		if(!isAssignable(type, valueType)){
			error("Can not assign a value of type " + valueType?.name + " to a variable of type " + type?.name)
			return null 
		}
		return type
	}
	
	def dispatch inferType(LogicalAndExpression expression){
		return assertBooleanTypes(expression.leftOperand.inferType,
			expression.rightOperand.inferType,'&&')
	}
	def dispatch inferType(LogicalOrExpression expression){
		return assertBooleanTypes(expression.leftOperand.inferType,
			expression.rightOperand.inferType,'||')
	}
	def assertBooleanTypes(Type left, Type right, String literal) {
		if (assertIsBoolean(left,literal) != null
			&& assertIsBoolean(right, literal) != null) {
				return combine(left, right)
			}
		return null;
	}
	def dispatch inferType(LogicalNotExpression expression){
		val type = expression.operand.inferType
		return assertIsBoolean(type,'!')
	}
	def dispatch inferType(BitwiseAndExpression expression){
		return assertNumericalTypes(expression.leftOperand.inferType, 
			expression.rightOperand.inferType,'&')
	}
	def dispatch inferType(BitwiseOrExpression expression){
		return assertNumericalTypes(expression.leftOperand.inferType, 
			expression.rightOperand.inferType,'|')
	}
	def dispatch inferType(BitwiseXorExpression expression){
		return assertNumericalTypes(expression.leftOperand.inferType, 
			expression.rightOperand.inferType,'^')
	}
	def dispatch inferType(LogicalRelationExpression expression){ 
		val leftType = expression.leftOperand.inferType
		val rightType = expression.rightOperand.inferType
		//If both types are boolean, only relational operators Equals and not_Equals are allowed
		if(leftType.^boolean && rightType.^boolean){
			if(expression.operator != RelationalOperator::EQUALS && expression.operator != RelationalOperator::NOT_EQUALS){
				error("operator '" + expression.operator?.literal + "' can not be applied to boolean values!")
				return null
			}
		} else {
			val combined = combine(leftType, rightType)
			if(combined == null){
				error("Incompatible operands " +leftType?.name + " and " + rightType?.name + " for operator '" + expression.operator.literal+"'")
		}
		
		}
		return createBoolean
		
	}
	
	def assertNumericalTypes(Type left, Type right, String literal) {
		if (assertIsNumber(left, literal) != null
			&& assertIsNumber(right, literal) != null) {
				return combine(left, right)
		}
		return null;
	}
	
	def dispatch inferType(NumericalAddSubtractExpression expression){
		return assertNumericalTypes(expression.leftOperand.inferType, 
			expression.rightOperand.inferType, expression.operator.literal
		)
	}
	def dispatch inferType(NumericalMultiplyDivideExpression expression){
		return assertNumericalTypes(expression.leftOperand.inferType, 
			expression.rightOperand.inferType, expression.operator.literal
		)
	}
	def dispatch Type inferType(NumericalUnaryExpression expression){
		val type = expression.operand.inferType
		return assertIsNumber(type, expression.operator.literal)
	}	
	def dispatch inferType(PrimitiveValueExpression expression){
		val Type t = expression.value.getType
		return t
	}
	def dispatch inferType(ShiftExpression expression){
		//TODO: Implement me
	}
	def dispatch inferType(ConditionalExpression expression){
		val condType = expression.condition.inferType
		if (!condType.^boolean) {
			error("Condition type have to be boolean")
			return null;
		}
		val trueType = expression.trueCase.inferType
		val falseType = expression.falseCase.inferType
		return combine(trueType, falseType)
	} 
	
	def dispatch inferType(FeatureCall featureCall){
		return featureCall.feature.type
	}
	
	def dispatch inferType(TypedElementReferenceExpression expression){
		var reference  = expression.reference
		if(reference instanceof VariableDefinition){
			return (reference as VariableDefinition).type
		}
		if(reference instanceof EventDefinition){
			if(expression.eContainer instanceof EventRaisingExpression
				|| expression.eContainer instanceof EventValueReferenceExpression
			)
				return (reference as EventDefinition).type
			else
				return createBoolean
		}
		null
		
	}
	
	def createBoolean() {
		val type = TypesFactory::eINSTANCE.createType()
		type.name = "boolean"
		return type
	}
	def dispatch inferType(EventValueReferenceExpression expression){
		return inferType(expression.value)
	}
	
	def dispatch getType(IntLiteral literal){
		return createInteger
	}

	def createInteger() {
		val type = TypesFactory::eINSTANCE.createType()
		type.name = "integer"
		return type
	} 
	
	def dispatch getType(BoolLiteral bool){
		return createBoolean
	}
	
	def dispatch getType(RealLiteral literal){
		return createReal
	}
	def dispatch getType(StringLiteral literal){
		return createString
	}
	def createReal() {
		val type = TypesFactory::eINSTANCE.createType()
		type.name = "real"
		return type
	}
	def createString() {
		val type = TypesFactory::eINSTANCE.createType()
		type.name = "string"
		return type
	}
	
	def Type assertIsNumber(Type object, String operator){
		if(!object.real && !object.integer) {
			error("operator '" +operator+"' can only be applied to numbers!")
			return null
		}
		return object
	}
	def Type assertIsBoolean(Type object, String operator){
		if(!object.^boolean) {
			error("operator '" +operator+"' can only be applied to boolean values!")
		}
		return object
	}
	 
	def error(String msg){
		if (acceptor != null) {
			acceptor.acceptError(msg)
		}
	}
	
	
	override isBoolean(Type type){
		return type != null && type.name == "boolean";	
	}
	
	override isInteger(Type type){
		return type != null && (type.name =="integer" || type.name =="int");
	}
	
	override isReal(Type type){
		return type != null && type.name == "real";	
	}
	override isString(Type type) {
		return type != null && type.name == "string";	
	}
	def dispatch inferType(Expression expr) {
		return null;
	}
	
	override isAssignable(Type expected, Type actual) {
		if (expected?.equals(combine(expected, actual))) {
			return true
		}
		if ((expected.integer || expected.real) && (actual.integer || actual.real)) {
			return true
		}
		return false
	}
	
	override combine(Type typeOne, Type typeTwo) {
		if (typeOne == null || typeTwo == null) {
			return null;
		}
		if (typeOne.equals(typeTwo) 
			|| typeOne.name.equals(typeTwo.name)) {
			return typeOne;
		}
		if(typeOne.integer && typeTwo.real){
			return typeTwo
		}
		if(typeOne.real && typeTwo.integer){
			return typeOne
		}
		
		val typesOne = typeOne.allSuperTypes
		val typesTwo = typeTwo.allSuperTypes
		
		val superType = typesOne.findFirst(t|typesTwo.contains(t))
		if (superType != null) {
			return superType
		}
		
		return null;
	}
	
	def allSuperTypes(Type type) {
		val types = <Type>newLinkedHashSet()
		types.add(type)
		var newSuperTypes = <Type>newArrayList()
		newSuperTypes.addAll(type.superTypes)
		while (!newSuperTypes.empty) {
			val oldSuperTypes = newSuperTypes
			newSuperTypes = <Type>newArrayList()
			for (superType : oldSuperTypes) {
				if (!types.contains(superType)) {
					types.add(superType)
					newSuperTypes.addAll(superType.superTypes)
				}
			}
		}
		return types
	}

}