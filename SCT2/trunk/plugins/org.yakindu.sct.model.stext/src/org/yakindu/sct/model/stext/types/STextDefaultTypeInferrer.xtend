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
package org.yakindu.sct.model.stext.types

import com.google.common.collect.Iterables
import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.core.runtime.IStatus
import org.eclipse.emf.ecore.EObject
import org.eclipse.internal.xtend.expression.ast.Literal
import org.yakindu.base.expressions.expressions.AdditiveOperator
import org.yakindu.base.expressions.expressions.AssignmentExpression
import org.yakindu.base.expressions.expressions.AssignmentOperator
import org.yakindu.base.expressions.expressions.BitwiseAndExpression
import org.yakindu.base.expressions.expressions.BitwiseOrExpression
import org.yakindu.base.expressions.expressions.BitwiseXorExpression
import org.yakindu.base.expressions.expressions.BoolLiteral
import org.yakindu.base.expressions.expressions.ConditionalExpression
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.Expression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.expressions.HexLiteral
import org.yakindu.base.expressions.expressions.IntLiteral
import org.yakindu.base.expressions.expressions.LogicalAndExpression
import org.yakindu.base.expressions.expressions.LogicalNotExpression
import org.yakindu.base.expressions.expressions.LogicalOrExpression
import org.yakindu.base.expressions.expressions.LogicalRelationExpression
import org.yakindu.base.expressions.expressions.MultiplicativeOperator
import org.yakindu.base.expressions.expressions.NumericalAddSubtractExpression
import org.yakindu.base.expressions.expressions.NumericalMultiplyDivideExpression
import org.yakindu.base.expressions.expressions.NumericalUnaryExpression
import org.yakindu.base.expressions.expressions.ParenthesizedExpression
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression
import org.yakindu.base.expressions.expressions.RealLiteral
import org.yakindu.base.expressions.expressions.RelationalOperator
import org.yakindu.base.expressions.expressions.ShiftExpression
import org.yakindu.base.expressions.expressions.ShiftOperator
import org.yakindu.base.expressions.expressions.StringLiteral
import org.yakindu.base.expressions.expressions.UnaryOperator
import org.yakindu.base.types.Enumerator
import org.yakindu.base.types.Event
import org.yakindu.base.types.Feature
import org.yakindu.base.types.ITypeSystem.ITypeSystemOperator
import org.yakindu.base.types.ITypeSystem.InferenceIssue
import org.yakindu.base.types.ITypeSystem.InferenceResult
import org.yakindu.base.types.ITypeSystem.InferredType
import org.yakindu.base.types.Type
import org.yakindu.base.types.TypedElement
import org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.EventRaisingExpression
import org.yakindu.sct.model.stext.stext.EventValueReferenceExpression
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.InternalScope
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.sct.model.stext.stext.VariableDefinition

/**
 * 
 * The TypeInferrer checks an expression AST for type conformance
 * 
 * @author andreas muelder - Initial contribution and API
 * @author Alexander Nyßen - Complete revision of API
 *  
 */
 @Singleton
class STextDefaultTypeInferrer implements ISTextTypeInferrer {
	
	@Inject protected extension
	ISTextTypeSystem ts
	
	override inferType(Expression e) {
		if(e == null){
			throw new IllegalArgumentException("Expression may not be null")
		}
		else{
			return doInferType(e)
		}
	}
	
	override inferType(VariableDefinition definition) {
		if(definition == null){
			throw new IllegalArgumentException("Definition may not be null")
		}
		else{
			definition.doInferType
		}
	}
	
	override inferType(EventDefinition definition) {
		if(definition == null){
			throw new IllegalArgumentException("Definition may not be null")
		}
		else{
			definition.doInferType
		}
	}
	
	def dispatch InferenceResult doInferType(VariableDefinition definition) {
		if(definition.type == null) {
 				return new InferenceResult(null, new InferenceIssue("Could not infer type of variable: " + definition.name, IStatus::ERROR))
 		}
 		else{
 			var varType = new InferenceResult(new InferredType(definition.type))
 			if(definition.initialValue != null){
 				val valueType = definition.initialValue.doInferType
 				if(valueType.type == null){
					return valueType
 				}
 			
 				// reuse the assignment logic of the type system
 				val result = inferResult(varType, valueType, ISTextTypeSystem.BinaryOperators::ASSIGN)
 				if(result.type == null){
 					return new InferenceResult(null, new InferenceIssue("Cannot assign a value of type " + valueType.type.type.name + " to a variable of type " + varType.type.type.name + ".", IStatus::ERROR))
 				}	
 			}
 			return varType
 		}
	}

	def dispatch InferenceResult doInferType(EventDefinition definition) {
		if(definition == null){
			throw new IllegalArgumentException("EventDefinition may not be null")
		}
		if(definition.type == null){
			return new InferenceResult(new InferredType(voidType))
		}
		return new InferenceResult(new InferredType(definition.type))
	}

	def dispatch InferenceResult doInferType(OperationDefinition definition) {
		if(definition == null){
			throw new IllegalArgumentException("EventDefinition may not be null")
		}
		if(definition.type == null){
			return new InferenceResult(new InferredType(voidType))
		}
		return new InferenceResult(new InferredType(definition.type))
	}
	
	def dispatch InferenceResult doInferType(Type type) {
		return new InferenceResult(new InferredType(type))
	}
	
	def dispatch InferenceResult doInferType(TypedElement typedElement) {
		if(typedElement.type == null)
			return new InferenceResult(null,new InferenceIssue("Could not infer type of typedelement: " + typedElement, IStatus::ERROR))
		else
			return new InferenceResult(new InferredType(typedElement.type))
	}
	
	def dispatch InferenceResult doInferType(Enumerator enumerator) {
		return new InferenceResult(new InferredType(enumerator.owningEnumeration));
	}
	
	def dispatch InferenceResult doInferType(InterfaceScope s){
		// TODO: this could be handled via the type system
		return new InferenceResult(voidType)	
	}
	
	def dispatch InferenceResult doInferType(InternalScope s){
		// TODO: this could be handled via the type system
		return new InferenceResult(voidType)	
	}

	def dispatch InferenceResult doInferType(Expression e) {
		throw new UnsupportedOperationException("Unsupported expression type " + e)
	}
	
	def InferenceResult inferResult(InferenceResult operand, ITypeSystemOperator unaryOperator){
		if(operand.getType() != null){
			return ts.inferType(operand.type, unaryOperator);
//			result.issues.addAll(operand.issues);
		}
		return new InferenceResult(null, operand.issues)
	}
	
	def InferenceResult inferResult(InferenceResult firstOperand, InferenceResult secondOperand, ITypeSystemOperator binaryOperator){
		if(firstOperand.getType() != null && secondOperand.getType() != null){
			val result = ts.inferType(firstOperand.type, secondOperand.type, binaryOperator);
			result.issues.addAll(firstOperand.issues);
			result.issues.addAll(secondOperand.issues);
			return result;
		}
		return new InferenceResult(null, Iterables::concat(firstOperand.issues, secondOperand.issues).toList);
	}
	
	def InferenceResult inferResult(InferenceResult firstOperand, InferenceResult secondOperand, InferenceResult thirdOperand, ITypeSystemOperator ternaryOperator){
		if(firstOperand.getType() != null && secondOperand.getType() != null && thirdOperand.getType() != null){
			val result = ts.inferType(firstOperand.type, secondOperand.type, thirdOperand.type, ternaryOperator);
			result.issues.addAll(firstOperand.issues);
			result.issues.addAll(secondOperand.issues);
			result.issues.addAll(thirdOperand.issues);
			return result;
		}
		return new InferenceResult(null, Iterables::concat(firstOperand.issues, secondOperand.issues).toList);
	}
	
	def dispatch InferenceResult doInferType(AssignmentExpression expression){
		return inferResult(expression.varRef.doInferType, expression.expression.doInferType, getTypeSystemOperator(expression.operator))
	}
	
	def dispatch InferenceResult doInferType(LogicalAndExpression expression){
		return inferResult(expression.leftOperand.doInferType, expression.rightOperand.doInferType, ISTextTypeSystem.BinaryOperators::LOGICAL_AND)
	}
	def dispatch InferenceResult doInferType(LogicalOrExpression expression){
		return inferResult(expression.leftOperand.doInferType, expression.rightOperand.doInferType, ISTextTypeSystem.BinaryOperators::LOGICAL_OR)
	}
	
	def dispatch InferenceResult doInferType(LogicalNotExpression expression){
		return inferResult(expression.operand.doInferType, ISTextTypeSystem.UnaryOperators::LOGICAL_NOT)
	}
	
	def dispatch InferenceResult doInferType(BitwiseAndExpression expression){
		return inferResult(expression.leftOperand.doInferType, expression.rightOperand.doInferType, ISTextTypeSystem.BinaryOperators::BITWISE_AND)
	}
	
	def dispatch InferenceResult doInferType(BitwiseOrExpression expression){
		return inferResult(expression.leftOperand.doInferType, expression.rightOperand.doInferType, ISTextTypeSystem.BinaryOperators::BITWISE_OR)
	}
	
	def dispatch InferenceResult doInferType(BitwiseXorExpression expression){
		return inferResult(expression.leftOperand.doInferType, expression.rightOperand.doInferType, ISTextTypeSystem.BinaryOperators::BITWISE_XOR)
	}
	
	def dispatch InferenceResult doInferType(LogicalRelationExpression expression){ 
		return inferResult(expression.leftOperand.doInferType, expression.rightOperand.doInferType, getTypeSystemOperator(expression.operator))
	}
	
	def dispatch InferenceResult doInferType(NumericalAddSubtractExpression expression){
		return inferResult(expression.leftOperand.doInferType, expression.rightOperand.doInferType, getTypeSystemOperator(expression.operator))
	}
	def dispatch InferenceResult doInferType(NumericalMultiplyDivideExpression expression){
		return inferResult(expression.leftOperand.doInferType, expression.rightOperand.doInferType, getTypeSystemOperator(expression.operator))
	}
	def dispatch InferenceResult doInferType(NumericalUnaryExpression expression){
		return inferResult(expression.operand.doInferType, getTypeSystemOperator(expression.operator))
	}	
	
	def dispatch InferenceResult doInferType(PrimitiveValueExpression expression){
		return expression.value.doInferType
	}
	
	def dispatch InferenceResult doInferType(ShiftExpression expression){
		return inferResult(expression.leftOperand.doInferType, expression.rightOperand.doInferType, getTypeSystemOperator(expression.operator))
	}
	
	def dispatch InferenceResult doInferType(ConditionalExpression expression){
		return inferResult(expression.condition.doInferType, expression.trueCase.doInferType, expression.falseCase.doInferType, ISTextTypeSystem.TernaryOperators::CONDITIONAL);
	} 
	
	def dispatch InferenceResult doInferType(EventRaisingExpression eventRaising){
 		val eventType = eventRaising.event.doInferType
 		if(eventType.type == null) {
 			return eventType
 		}
 		else{
 			if(eventRaising.value == null){
 				if(!eventType.type.voidType){
 					return new InferenceResult(null, new InferenceIssue("Need to assign a value to an event of type " + eventType.type.type.name + ".", IStatus::ERROR))
 				}	
 				return eventType
 			}
 			else{
 				val valueType = eventRaising.value.doInferType
 				if(valueType.type == null){
 					return valueType
 				}
 			
 				// reuse the assignment logic of the type system
 				val result = inferResult(eventType, valueType, ISTextTypeSystem.BinaryOperators::ASSIGN)
 				if(result.type == null){
 					return new InferenceResult(null, new InferenceIssue("Cannot assign a value of type " + valueType.type.type.name + " to an event of type " + eventType.type.type.name + ".", IStatus::ERROR))
 				}
 				else {
 					return result
 				}
 			}
 		}
	}
	
	def dispatch InferenceResult doInferType(FeatureCall featureCall){
		if(featureCall.feature instanceof Event /*Definition*/ 
			&& !(featureCall.eContainer instanceof EventRaisingExpression) 
			&& !(featureCall.eContainer instanceof EventValueReferenceExpression)
		){
			// e1 is a shortcut for isRaised(e1) and thus we have to return boolean here
			return new InferenceResult(getBooleanType)
		}
		if (featureCall.feature instanceof Feature) {
			val type = (featureCall.feature as Feature).type
			if(type != null){
				return new InferenceResult(new InferredType(type))
			}
			return new InferenceResult(getVoidType)
		}
		return featureCall.feature.doInferType
	}
	 
	def dispatch InferenceResult doInferType(ActiveStateReferenceExpression expression){
		return new InferenceResult(getBooleanType)
	}

	def dispatch InferenceResult doInferType(ElementReferenceExpression expression){
		if(expression.reference instanceof EventDefinition && !(expression.eContainer instanceof EventRaisingExpression
				|| expression.eContainer instanceof EventValueReferenceExpression)){
			// in case we are not inside an raise or valueOf expression, the event is a shortcut for isRaised(event) and thus, we may return boolean here
			return new InferenceResult(getBooleanType)
		}
		else {
			// inference of the reference type is not context dependent
			return expression.reference.doInferType
		}
	}
	
	def dispatch InferenceResult doInferType(EventValueReferenceExpression expression){
		return doInferType(expression.value)
	}
	
	def dispatch InferenceResult doInferType(ParenthesizedExpression expression){
		return doInferType(expression.expression)
	}
	
	def dispatch InferenceResult doInferType(StringLiteral literal){
		return inferTypeForLiteral(literal.value);
	}
	
	def dispatch InferenceResult doInferType(BoolLiteral literal){
		return inferTypeForLiteral(literal.value);
	}
	
	def dispatch InferenceResult doInferType(RealLiteral literal){
		return inferTypeForLiteral(literal.value);
	}
	
	def dispatch InferenceResult doInferType(HexLiteral literal){
		return inferTypeForLiteral(literal.value);
	}
	
	def dispatch InferenceResult doInferType(IntLiteral literal){
		return inferTypeForLiteral(literal.value);
	}
	
	def dispatch InferenceResult doInferType(Literal l) {
		throw new IllegalArgumentException("Unsupported literal kind " + l)
	}
	
	def dispatch InferenceResult doInferType(EObject e) {
		return inferTypeForLiteral(e);
	}
	
	def protected dispatch ITypeSystemOperator getTypeSystemOperator(UnaryOperator operator){
		switch(operator){
			case UnaryOperator::COMPLEMENT:
				ISTextTypeSystem.UnaryOperators::COMPLEMENT
			case UnaryOperator::NEGATIVE:
				ISTextTypeSystem.UnaryOperators::NEGATIVE
			case UnaryOperator::POSITIVE:
				ISTextTypeSystem.UnaryOperators::POSITIVE
			default:
				throw new IllegalArgumentException("Unsupported operator" + operator)
		}
	}
	
	def protected dispatch ITypeSystemOperator getTypeSystemOperator(AssignmentOperator operator) {
		switch(operator){
			case AssignmentOperator::ADD_ASSIGN:
				ISTextTypeSystem.BinaryOperators::ASSIGN_ADD
			case AssignmentOperator::AND_ASSIGN:
				ISTextTypeSystem.BinaryOperators::ASSIGN_BITWISE_AND
			case AssignmentOperator::ASSIGN:
				ISTextTypeSystem.BinaryOperators::ASSIGN
			case AssignmentOperator::DIV_ASSIGN:
				ISTextTypeSystem.BinaryOperators::ASSIGN_DIV
			case AssignmentOperator::LEFT_SHIFT_ASSIGN:
				ISTextTypeSystem.BinaryOperators::ASSIGN_LEFT_SHIFT
			case AssignmentOperator::MOD_ASSIGN:
				ISTextTypeSystem.BinaryOperators::ASSIGN_MOD
			case AssignmentOperator::MULT_ASSIGN:
				ISTextTypeSystem.BinaryOperators::ASSIGN_MULTIPLY
			case AssignmentOperator::OR_ASSIGN:
				ISTextTypeSystem.BinaryOperators::ASSIGN_BITWISE_OR
			case AssignmentOperator::RIGHT_SHIFT_ASSIGN:
				ISTextTypeSystem.BinaryOperators::ASSIGN_RIGHT_SHIFT
			case AssignmentOperator::SUB_ASSIGN:
				ISTextTypeSystem.BinaryOperators::ASSIGN_SUBTRACT
			case AssignmentOperator::XOR_ASSIGN:
				ISTextTypeSystem.BinaryOperators::ASSIGN_BITWISE_XOR
			default: 
				throw new IllegalArgumentException("Unsupported operator" + operator)
		}
	}
	
	def dispatch ITypeSystemOperator getTypeSystemOperator(ShiftOperator operator) {
		switch(operator){
			case ShiftOperator::LEFT:
				ISTextTypeSystem.BinaryOperators::LEFT_SHIFT
			case ShiftOperator::RIGHT:
				ISTextTypeSystem.BinaryOperators::RIGHT_SHIFT
			default: 
				throw new IllegalArgumentException("Unsupported operator" + operator)
		}
	}
	
	def protected dispatch ITypeSystemOperator getTypeSystemOperator(AdditiveOperator operator) {
		switch(operator){
			case AdditiveOperator::PLUS:
				ISTextTypeSystem.BinaryOperators::ADD
			case AdditiveOperator::MINUS:
				ISTextTypeSystem.BinaryOperators::SUBTRACT
			default: 
				throw new IllegalArgumentException("Unsupported operator" + operator)
		}
	}
	
	def protected dispatch ITypeSystemOperator getTypeSystemOperator(MultiplicativeOperator operator) {
		switch(operator){
			case MultiplicativeOperator::DIV:
				ISTextTypeSystem.BinaryOperators::DIV
			case MultiplicativeOperator::MOD:
				ISTextTypeSystem.BinaryOperators::MOD
			case MultiplicativeOperator::MUL:
				ISTextTypeSystem.BinaryOperators::MULTIPLY
			default: 
				throw new IllegalArgumentException("Unsupported operator" + operator)
		}
	}

	def protected dispatch ITypeSystemOperator getTypeSystemOperator(RelationalOperator operator) {
		switch(operator){
			case RelationalOperator::EQUALS:
				ISTextTypeSystem.BinaryOperators::EQUAL
			case RelationalOperator::NOT_EQUALS:
				ISTextTypeSystem.BinaryOperators::NOT_EQUAL
			case RelationalOperator::GREATER:
				ISTextTypeSystem.BinaryOperators::GREATER
			case RelationalOperator::GREATER_EQUAL:
				ISTextTypeSystem.BinaryOperators::GREATER_EQUAL
			case RelationalOperator::SMALLER:
				ISTextTypeSystem.BinaryOperators::SMALLER
			case RelationalOperator::SMALLER_EQUAL:
				ISTextTypeSystem.BinaryOperators::SMALLER_EQUAL
			default: 
				throw new IllegalArgumentException("Unsupported operator" + operator)
		}
	}

}