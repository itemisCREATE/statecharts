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

import com.google.inject.Inject
import org.yakindu.base.types.Feature
import org.yakindu.base.types.ITypeSystemAccess
import org.yakindu.base.types.Type
import org.yakindu.sct.model.sgraph.Statement
import org.yakindu.sct.model.stext.stext.AssignmentExpression
import org.yakindu.sct.model.stext.stext.BitwiseAndExpression
import org.yakindu.sct.model.stext.stext.BitwiseOrExpression
import org.yakindu.sct.model.stext.stext.BitwiseXorExpression
import org.yakindu.sct.model.stext.stext.BoolLiteral
import org.yakindu.sct.model.stext.stext.ConditionalExpression
import org.yakindu.sct.model.stext.stext.ElementReferenceExpression
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.EventRaisingExpression
import org.yakindu.sct.model.stext.stext.EventValueReferenceExpression
import org.yakindu.sct.model.stext.stext.Expression
import org.yakindu.sct.model.stext.stext.FeatureCall
import org.yakindu.sct.model.stext.stext.IntLiteral
import org.yakindu.sct.model.stext.stext.LogicalAndExpression
import org.yakindu.sct.model.stext.stext.LogicalNotExpression
import org.yakindu.sct.model.stext.stext.LogicalOrExpression
import org.yakindu.sct.model.stext.stext.LogicalRelationExpression
import org.yakindu.sct.model.stext.stext.NumericalAddSubtractExpression
import org.yakindu.sct.model.stext.stext.NumericalMultiplyDivideExpression
import org.yakindu.sct.model.stext.stext.NumericalUnaryExpression
import org.yakindu.sct.model.stext.stext.PrimitiveValueExpression
import org.yakindu.sct.model.stext.stext.RealLiteral
import org.yakindu.sct.model.stext.stext.RelationalOperator
import org.yakindu.sct.model.stext.stext.ShiftExpression
import org.yakindu.sct.model.stext.stext.StringLiteral
import org.yakindu.sct.model.stext.stext.VariableDefinition
import org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression
import org.yakindu.sct.model.stext.stext.UnaryOperator
import org.yakindu.sct.model.stext.stext.HexLiteral
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.eclipse.emf.ecore.EObject
 
/**
 * 
 * The TypeInferrer checks an expression AST for type conformance
 * 
 * @author andreas muelder - Initial contribution and API
 *  
 */
class TypeInferrer implements org.yakindu.sct.model.stext.validation.ITypeInferrer, org.yakindu.sct.model.stext.validation.TypeInferrerCache$ICacheableTypeAnalyzer {
	
	@Inject extension
	ITypeSystemAccess ts 
	@Inject 
	org.yakindu.sct.model.stext.validation.TypeInferrerCache cache
	
	override getType(Statement stmt) {
		if (stmt == null) {
			return null;
		}
		cache.get(stmt, this)
	}
	
	def dispatch inferType(Statement statement){
		null
	}
	
	def check(Statement stmt) {
		stmt.getType
	}
	
	/**
	 * Check Variable assignments
	 */
	def dispatch inferType(AssignmentExpression assignment){
		var valueType = assignment.expression.getType
		var type = assignment.varRef.getType
		
		if(!type.isAssignable(valueType)){
			error("Can not assign a value of type " + valueType?.name + " to a variable of type " + type?.name)
			return null 
		}
		return type
	}
	/**
	 * Check Event value assignments
	 */
	def dispatch inferType(EventRaisingExpression eventRaising){
		var valueType = eventRaising.value.getType
		var type = eventRaising.event.getType
		if(!type.isAssignable(valueType)){
			error("Can not assign a value of type " + valueType?.name + " to a variable of type " + type?.name)
			return null 
		}
		return type
	}
	
	def dispatch inferType(LogicalAndExpression expression){
		return assertBooleanTypes(expression.leftOperand.getType,
			expression.rightOperand.getType,'&&')
	}
	def dispatch inferType(LogicalOrExpression expression){
		return assertBooleanTypes(expression.leftOperand.getType,
			expression.rightOperand.getType,'||')
	}
	def assertBooleanTypes(Type left, Type right, String literal) {
		if (assertIsBoolean(left,literal) != null
			&& assertIsBoolean(right, literal) != null) {
				return left.combine(right)
			}
		return null;
	}
	def dispatch inferType(LogicalNotExpression expression){
		val type = expression.operand.getType
		return assertIsBoolean(type,'!')
	}
	def dispatch inferType(BitwiseAndExpression expression){
		assertIsInteger(expression.leftOperand.getType, '&');
		assertIsInteger(expression.rightOperand.getType, '&');
		return integer
	}
	def dispatch inferType(BitwiseOrExpression expression){
		assertIsInteger(expression.leftOperand.getType, '|');
		assertIsInteger(expression.rightOperand.getType, '|');
		return integer
	}
	def dispatch inferType(BitwiseXorExpression expression){
		assertIsInteger(expression.leftOperand.getType, '^');
		assertIsInteger(expression.rightOperand.getType, '^');
		return integer
	}
	
	def dispatch inferType(LogicalRelationExpression expression){ 
		val leftType = expression.leftOperand.getType
		val rightType = expression.rightOperand.getType
		//If both types are boolean, only relational operators Equals and not_Equals are allowed
		if(leftType.^boolean && rightType.^boolean){
			if(expression.operator != RelationalOperator::EQUALS && expression.operator != RelationalOperator::NOT_EQUALS){
				error("operator '" + expression.operator?.literal + "' can not be applied to boolean values!")
				return null
			}
		} else {
			val combined = leftType.combine(rightType)
			if(combined == null){
				error("Incompatible operands " +leftType?.name + " and " + rightType?.name + " for operator '" + expression.operator.literal+"'")
		}
		
		}
		return ts.^boolean
		
	}
	
	def assertNumericalTypes(Type left, Type right, String operator) {
		if (assertIsNumber(left, operator) != null
			&& assertIsNumber(right, operator) != null) {
				return left.combine(right)
		}
		return null;
	}
	
	def dispatch inferType(NumericalAddSubtractExpression expression){
		return assertNumericalTypes(expression.leftOperand.getType, 
			expression.rightOperand.getType, expression.operator.literal
		)
	}
	def dispatch inferType(NumericalMultiplyDivideExpression expression){
		return assertNumericalTypes(expression.leftOperand.getType, 
			expression.rightOperand.getType, expression.operator.literal
		)
	}
	def dispatch Type inferType(NumericalUnaryExpression expression){
		val type = expression.operand.getType
		if(expression.operator == UnaryOperator::COMPLEMENT){
			return assertIsInteger(type, expression.operator.literal)
		}
		return assertIsNumber(type, expression.operator.literal)
	}	
	def dispatch inferType(PrimitiveValueExpression expression){
		val Type t = expression.value.literalType
		return t
	}
	
	def dispatch inferType(ActiveStateReferenceExpression expression){
		return ts.boolean	
	}
	
	def dispatch inferType(ShiftExpression expression){
		assertIsInteger(expression.leftOperand.type, expression.operator.literal)
		assertIsInteger(expression.rightOperand.type, expression.operator.literal)
	}
	def dispatch inferType(ConditionalExpression expression){
		val condType = expression.condition.getType
		if (!condType.^boolean) {
			error("Condition type have to be boolean")
			return null;
		}
		val trueType = expression.trueCase.getType
		val falseType = expression.falseCase.getType
		return trueType.combine(falseType)
	} 
	//TODO: Remove dependency to base types
	def dispatch inferType(FeatureCall featureCall){
		if (featureCall.feature instanceof Feature) {
			return (featureCall.feature as Feature)?.type
		} else if (featureCall.feature !=null) {
			error("Type of FeatureCall is unknown: "+featureCall)			
			return null;
		} else {
			return null;
		}
	}
	 
	def dispatch inferType(ElementReferenceExpression expression){
		return expression.reference.inferType(expression)
	}
	def dispatch inferType(EObject object, ElementReferenceExpression expression) {
		//	
	}
	def dispatch inferType(VariableDefinition definition,ElementReferenceExpression expression) {
		return definition.type
	}

	def dispatch inferType(EventDefinition definition,ElementReferenceExpression expression) {
		if(expression.eContainer instanceof EventRaisingExpression
				|| expression.eContainer instanceof EventValueReferenceExpression)
			return definition.type
		return ts.^boolean
	}

	def dispatch inferType(OperationDefinition definition,ElementReferenceExpression expression) {
		return definition.type
	}
	
	def dispatch inferType(EventValueReferenceExpression expression){
		return getType(expression.value)
	}
	
	def dispatch getLiteralType(HexLiteral literal){
		return ts.integer
	}
	
	def dispatch getLiteralType(IntLiteral literal){
		return ts.integer
	}
	
	def dispatch getLiteralType(BoolLiteral bool){
		return ts.^boolean
	}
	
	def dispatch getLiteralType(RealLiteral literal){
		return ts.real
	}
	def dispatch getLiteralType(StringLiteral literal){
		return ts.string
	}
	
	def Type assertIsInteger(Type object, String operator){
		if(!object.integer){
			error("operator '" +operator+"' can only be applied to integers!")
			return null
		}
		return object
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
		throw new TypeCheckException(msg)
	}
	
	def dispatch inferType(Expression expr) {
		return null;
	}

}