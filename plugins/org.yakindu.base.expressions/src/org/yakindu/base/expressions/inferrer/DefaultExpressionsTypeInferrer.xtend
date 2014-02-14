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
package org.yakindu.base.expressions.inferrer

import com.google.common.collect.Iterables
import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.core.runtime.IStatus
import org.eclipse.emf.ecore.EObject
import org.yakindu.base.expressions.expressions.AdditiveOperator
import org.yakindu.base.expressions.expressions.AssignmentOperator
import org.yakindu.base.expressions.expressions.BitwiseAndExpression
import org.yakindu.base.expressions.expressions.BitwiseOrExpression
import org.yakindu.base.expressions.expressions.BitwiseXorExpression
import org.yakindu.base.expressions.expressions.BoolLiteral
import org.yakindu.base.expressions.expressions.ConditionalExpression
import org.yakindu.base.expressions.expressions.Expression
import org.yakindu.base.expressions.expressions.HexLiteral
import org.yakindu.base.expressions.expressions.IntLiteral
import org.yakindu.base.expressions.expressions.Literal
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
import org.yakindu.base.types.ITypeSystem
import org.yakindu.base.types.ITypeSystem.ITypeSystemOperator
import org.yakindu.base.types.InferenceIssue
import org.yakindu.base.types.InferenceResult
import org.yakindu.base.types.InferredType
import org.yakindu.base.types.TypedElement

/**
 * 
 * The TypeInferrer checks an expression AST for type conformance
 * 
 * @author andreas muelder - Initial contribution and API
 * @author Alexander Nyßen - Complete revision of API
 *  
 */
@Singleton
class DefaultExpressionsTypeInferrer implements IExpressionsTypeInferrer {

	@Inject protected extension ITypeSystem ts

	override inferType(Expression e) {
		if (e == null) {
			throw new IllegalArgumentException("Expression may not be null")
		} else {
			return doInferType(e)
		}
	}

	def dispatch InferenceResult doInferType(TypedElement typedElement) {
		if (typedElement.type == null)
			return new InferenceResult(null,
				new InferenceIssue("Could not infer type of typedelement: " + typedElement, IStatus::ERROR))
		else
			return new InferenceResult(new InferredType(typedElement.type))
	}

	def dispatch InferenceResult doInferType(Enumerator enumerator) {
		return new InferenceResult(new InferredType(enumerator.owningEnumeration));
	}

	def InferenceResult inferResult(InferenceResult operand, ITypeSystemOperator unaryOperator) {
		if (operand.getType() != null) {
			return ts.inferType(operand.type, unaryOperator);

		//			result.issues.addAll(operand.issues);
		}
		return new InferenceResult(null, operand.issues)
	}

	def InferenceResult inferResult(InferenceResult firstOperand, InferenceResult secondOperand,
		ITypeSystemOperator binaryOperator) {
		if (firstOperand.getType() != null && secondOperand.getType() != null) {
			val result = ts.inferType(firstOperand.type, secondOperand.type, binaryOperator);
			result.issues.addAll(firstOperand.issues);
			result.issues.addAll(secondOperand.issues);
			return result;
		}
		return new InferenceResult(null, Iterables::concat(firstOperand.issues, secondOperand.issues).toList);
	}

	def InferenceResult inferResult(InferenceResult firstOperand, InferenceResult secondOperand,
		InferenceResult thirdOperand, ITypeSystemOperator ternaryOperator) {
		if (firstOperand.getType() != null && secondOperand.getType() != null && thirdOperand.getType() != null) {
			val result = ts.inferType(firstOperand.type, secondOperand.type, thirdOperand.type, ternaryOperator);
			result.issues.addAll(firstOperand.issues);
			result.issues.addAll(secondOperand.issues);
			result.issues.addAll(thirdOperand.issues);
			return result;
		}
		return new InferenceResult(null, Iterables::concat(firstOperand.issues, secondOperand.issues).toList);
	}

	def dispatch InferenceResult doInferType(LogicalAndExpression expression) {
		return inferResult(expression.leftOperand.doInferType, expression.rightOperand.doInferType,
			ITypeSystem.BinaryOperators::LOGICAL_AND)
	}

	def dispatch InferenceResult doInferType(LogicalOrExpression expression) {
		return inferResult(expression.leftOperand.doInferType, expression.rightOperand.doInferType,
			ITypeSystem.BinaryOperators::LOGICAL_OR)
	}

	def dispatch InferenceResult doInferType(LogicalNotExpression expression) {
		return inferResult(expression.operand.doInferType, ITypeSystem.UnaryOperators::LOGICAL_NOT)
	}

	def dispatch InferenceResult doInferType(BitwiseAndExpression expression) {
		return inferResult(expression.leftOperand.doInferType, expression.rightOperand.doInferType,
			ITypeSystem.BinaryOperators::BITWISE_AND)
	}

	def dispatch InferenceResult doInferType(BitwiseOrExpression expression) {
		return inferResult(expression.leftOperand.doInferType, expression.rightOperand.doInferType,
			ITypeSystem.BinaryOperators::BITWISE_OR)
	}

	def dispatch InferenceResult doInferType(BitwiseXorExpression expression) {
		return inferResult(expression.leftOperand.doInferType, expression.rightOperand.doInferType,
			ITypeSystem.BinaryOperators::BITWISE_XOR)
	}

	def dispatch InferenceResult doInferType(LogicalRelationExpression expression) {
		return inferResult(expression.leftOperand.doInferType, expression.rightOperand.doInferType,
			getTypeSystemOperator(expression.operator))
	}

	def dispatch InferenceResult doInferType(NumericalAddSubtractExpression expression) {
		return inferResult(expression.leftOperand.doInferType, expression.rightOperand.doInferType,
			getTypeSystemOperator(expression.operator))
	}

	def dispatch InferenceResult doInferType(NumericalMultiplyDivideExpression expression) {
		return inferResult(expression.leftOperand.doInferType, expression.rightOperand.doInferType,
			getTypeSystemOperator(expression.operator))
	}

	def dispatch InferenceResult doInferType(NumericalUnaryExpression expression) {
		return inferResult(expression.operand.doInferType, getTypeSystemOperator(expression.operator))
	}

	def dispatch InferenceResult doInferType(PrimitiveValueExpression expression) {
		return expression.value.doInferType
	}

	def dispatch InferenceResult doInferType(ShiftExpression expression) {
		return inferResult(expression.leftOperand.doInferType, expression.rightOperand.doInferType,
			getTypeSystemOperator(expression.operator))
	}

	def dispatch InferenceResult doInferType(ConditionalExpression expression) {
		return inferResult(expression.condition.doInferType, expression.trueCase.doInferType,
			expression.falseCase.doInferType, ITypeSystem.TernaryOperators::CONDITIONAL);
	}

	def dispatch InferenceResult doInferType(StringLiteral literal) {
		return inferTypeForLiteral(literal.value);
	}

	def dispatch InferenceResult doInferType(BoolLiteral literal) {
		return inferTypeForLiteral(literal.value);
	}

	def dispatch InferenceResult doInferType(RealLiteral literal) {
		return inferTypeForLiteral(literal.value);
	}

	def dispatch InferenceResult doInferType(HexLiteral literal) {
		return inferTypeForLiteral(literal.value);
	}

	def dispatch InferenceResult doInferType(IntLiteral literal) {
		return inferTypeForLiteral(literal.value);
	}

	def dispatch InferenceResult doInferType(Literal l) {
		throw new IllegalArgumentException("Unsupported literal kind " + l)
	}

	def dispatch InferenceResult doInferType(EObject e) {
		return inferTypeForLiteral(e);
	}

	def dispatch InferenceResult doInferType(ParenthesizedExpression expression) {
		return doInferType(expression.expression)
	}

	def protected dispatch ITypeSystemOperator getTypeSystemOperator(UnaryOperator operator) {
		switch (operator) {
			case UnaryOperator::COMPLEMENT:
				ITypeSystem.UnaryOperators::COMPLEMENT
			case UnaryOperator::NEGATIVE:
				ITypeSystem.UnaryOperators::NEGATIVE
			case UnaryOperator::POSITIVE:
				ITypeSystem.UnaryOperators::POSITIVE
			default:
				throw new IllegalArgumentException("Unsupported operator" + operator)
		}
	}

	def protected dispatch ITypeSystemOperator getTypeSystemOperator(AssignmentOperator operator) {
		switch (operator) {
			case AssignmentOperator::ADD_ASSIGN:
				ITypeSystem.BinaryOperators::ASSIGN_ADD
			case AssignmentOperator::AND_ASSIGN:
				ITypeSystem.BinaryOperators::ASSIGN_BITWISE_AND
			case AssignmentOperator::ASSIGN:
				ITypeSystem.BinaryOperators::ASSIGN
			case AssignmentOperator::DIV_ASSIGN:
				ITypeSystem.BinaryOperators::ASSIGN_DIV
			case AssignmentOperator::LEFT_SHIFT_ASSIGN:
				ITypeSystem.BinaryOperators::ASSIGN_LEFT_SHIFT
			case AssignmentOperator::MOD_ASSIGN:
				ITypeSystem.BinaryOperators::ASSIGN_MOD
			case AssignmentOperator::MULT_ASSIGN:
				ITypeSystem.BinaryOperators::ASSIGN_MULTIPLY
			case AssignmentOperator::OR_ASSIGN:
				ITypeSystem.BinaryOperators::ASSIGN_BITWISE_OR
			case AssignmentOperator::RIGHT_SHIFT_ASSIGN:
				ITypeSystem.BinaryOperators::ASSIGN_RIGHT_SHIFT
			case AssignmentOperator::SUB_ASSIGN:
				ITypeSystem.BinaryOperators::ASSIGN_SUBTRACT
			case AssignmentOperator::XOR_ASSIGN:
				ITypeSystem.BinaryOperators::ASSIGN_BITWISE_XOR
			default:
				throw new IllegalArgumentException("Unsupported operator" + operator)
		}
	}

	def dispatch ITypeSystemOperator getTypeSystemOperator(ShiftOperator operator) {
		switch (operator) {
			case ShiftOperator::LEFT:
				ITypeSystem.BinaryOperators::LEFT_SHIFT
			case ShiftOperator::RIGHT:
				ITypeSystem.BinaryOperators::RIGHT_SHIFT
			default:
				throw new IllegalArgumentException("Unsupported operator" + operator)
		}
	}

	def protected dispatch ITypeSystemOperator getTypeSystemOperator(AdditiveOperator operator) {
		switch (operator) {
			case AdditiveOperator::PLUS:
				ITypeSystem.BinaryOperators::ADD
			case AdditiveOperator::MINUS:
				ITypeSystem.BinaryOperators::SUBTRACT
			default:
				throw new IllegalArgumentException("Unsupported operator" + operator)
		}
	}

	def protected dispatch ITypeSystemOperator getTypeSystemOperator(MultiplicativeOperator operator) {
		switch (operator) {
			case MultiplicativeOperator::DIV:
				ITypeSystem.BinaryOperators::DIV
			case MultiplicativeOperator::MOD:
				ITypeSystem.BinaryOperators::MOD
			case MultiplicativeOperator::MUL:
				ITypeSystem.BinaryOperators::MULTIPLY
			default:
				throw new IllegalArgumentException("Unsupported operator" + operator)
		}
	}

	def protected dispatch ITypeSystemOperator getTypeSystemOperator(RelationalOperator operator) {
		switch (operator) {
			case RelationalOperator::EQUALS:
				ITypeSystem.BinaryOperators::EQUAL
			case RelationalOperator::NOT_EQUALS:
				ITypeSystem.BinaryOperators::NOT_EQUAL
			case RelationalOperator::GREATER:
				ITypeSystem.BinaryOperators::GREATER
			case RelationalOperator::GREATER_EQUAL:
				ITypeSystem.BinaryOperators::GREATER_EQUAL
			case RelationalOperator::SMALLER:
				ITypeSystem.BinaryOperators::SMALLER
			case RelationalOperator::SMALLER_EQUAL:
				ITypeSystem.BinaryOperators::SMALLER_EQUAL
			default:
				throw new IllegalArgumentException("Unsupported operator" + operator)
		}
	}

}
