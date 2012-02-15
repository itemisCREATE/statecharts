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

/**
 * 
 * The Static type analyzer checks an expression AST for type conformance
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
class StaticTypeAnalyzer {
	
// begin TODO: externalize this
	def isBoolean(Type type){
		return type != null && type.name == "boolean";	
	}
	
	def isInteger(Type type){
		return type != null && type.name =="integer";
	}
	
	def isReal(Type type){
		return type != null && type.name == "real";	
	}
// end TODO
	
	/**
	 * Check Variable assignments
	 */
	def dispatch check(Assignment assignment){
		var valueType = assignment.expression.check
		var ref = assignment.varRef
		var type = (ref as VariableDefinition).getType()
		if(isBoolean(type) && !(valueType == typeof(Boolean))){
			error("Can not assign a value of type " + valueType.simpleName + " to a variable of type " + type)
		}
		else if(isInteger(type) && !(valueType == typeof(Number))){
			error("Can not assign a value of type " + valueType.simpleName + " to a variable of type " + type)
		}
		else if(isReal(type) && !(valueType == typeof(Number))){
			error("Can not assign a value of type " + valueType.simpleName + " to a variable of type " + type)
		} 
		return null 
	}
	
	
		
	/**
	 * Check Event value assignments
	 */
	def dispatch check(EventRaising eventRaising){
		var valueType = eventRaising.value.check
		var ref = eventRaising.event
		var type = (ref as EventDefinition).getType()
		if(isBoolean(type) && !(valueType == typeof(Boolean))){
			error("Can not assign a value of type " + valueType.simpleName + " to an event of type " + type)
		}
		else if (isInteger(type) && !(valueType == typeof(Number))){
			error("Can not assign a value of type " + valueType.simpleName + " to an event of type " + type)
		}
		else if(isReal(type) && !(valueType == typeof(Number))){
			error("Can not assign a value of type " + valueType.simpleName + " to an event  type " + type)
		} 
		return null 
	}
	
	
	
	def dispatch check(LogicalAndExpression expression){
		assertIsBoolean(expression.leftOperand.check, '&&')
		assertIsBoolean(expression.rightOperand.check, '&&')
		typeof(Boolean)
	}
	def dispatch check(LogicalOrExpression expression){
		assertIsBoolean(expression.leftOperand.check,'||')
		assertIsBoolean(expression.rightOperand.check,'||')
		typeof(Boolean)
	}
	def dispatch check(LogicalNotExpression expression){
		assertIsBoolean(expression.operand.check,'!')
		typeof(Boolean)
	}
	def dispatch check(BitwiseAndExpression expression){
		assertIsNumber(expression.leftOperand.check,'&')
		assertIsNumber(expression.rightOperand.check,'&')
		typeof(Number)
	}
	def dispatch check(BitwiseOrExpression expression){
		assertIsNumber(expression.leftOperand.check,'|')
		assertIsNumber(expression.rightOperand.check,'|')
		typeof(Number)
	}
	def dispatch check(BitwiseXorExpression expression){
		assertIsNumber(expression.leftOperand.check,'^')
		assertIsNumber(expression.rightOperand.check,'^')
		typeof(Number)
	}
	def dispatch check(LogicalRelationExpression expression){
		var leftType = expression.leftOperand.check
		var rightType = expression.rightOperand.check
		if(leftType != rightType){
			error("Incompatible operands " +leftType.name + " and " + rightType.name + " for operator '" + expression.operator.literal+"'")
		}
		//If both types are boolean, only relational operators Equals and not_Equals are allowed
		if(leftType == typeof(Boolean) && rightType == typeof(Boolean)){
			if(expression.operator != RelationalOperator::EQUALS && expression.operator != RelationalOperator::NOT_EQUALS){
				error("operator '" + expression.operator.literal + "' can not be applied to boolean values!")
			}
		}
		return typeof(Boolean) 
		
	}
	def dispatch check(NumericalAddSubtractExpression expression){
		assertIsNumber(expression.leftOperand.check, expression.operator.literal)
		assertIsNumber(expression.rightOperand.check, expression.operator.literal)
		typeof(Number)
	}
	def dispatch check(NumericalMultiplyDivideExpression expression){
		assertIsNumber(expression.leftOperand.check, expression.operator.literal)
		assertIsNumber(expression.rightOperand.check, expression.operator.literal)
		typeof(Number)
	}
	def dispatch check(NumericalUnaryExpression expression){
		assertIsNumber(expression.operand.check, expression.operator.literal)
		typeof(Number)
	}	
	def dispatch check(PrimitiveValueExpression expression){
		expression.value.type
	}
	def dispatch check(ShiftExpression expression){
		//TODO: Implement me
	}
	def dispatch check(ConditionalExpression expression){
		//TODO: Implement me
	} 
	def dispatch check(ElementReferenceExpression expression){
		var declaration = expression.value
		if(declaration instanceof VariableDefinition){
			return (declaration as VariableDefinition).type.toJavaType
		}
		return null;
	}
	def dispatch check(EventValueReferenceExpression expression){
		//TODO: Implement me
	}
	
	def dispatch type(IntLiteral literal){
		return typeof(Number)
	} 
	
	def dispatch type(BoolLiteral bool){
		return typeof(Boolean)
	}
	
	def dispatch type(RealLiteral literal){
		return typeof(Number)
	}
	
	def toJavaType(Type type){
		if(isBoolean(type)){
			return typeof(Boolean)
		}
		else if(isInteger(type)){
			return typeof(Number)
		}
		else if(isReal(type)){
			return typeof(Number)
		} 
		return typeof(Void)
	}
	
	def assertIsNumber(Object object, String operator){
		if(!(object == typeof(Number)))
			error("operator '" +operator+"' can only be applied to numbers!")
	}
	def assertIsBoolean(Object object, String operator){
		if(!(object == typeof(Boolean)))
			error("operator '" +operator+"' can only ne applied to boolean values!")
	}
	
	def error(String msg){
		throw new TypeCheckException(msg)
	}

}