/**
 * Copyright (c) 2014 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.base.expressions.inferrer;

import static org.yakindu.base.types.typesystem.DefaultTypeSystem.BOOLEAN;
import static org.yakindu.base.types.typesystem.DefaultTypeSystem.INTEGER;
import static org.yakindu.base.types.typesystem.DefaultTypeSystem.NULL;
import static org.yakindu.base.types.typesystem.DefaultTypeSystem.REAL;
import static org.yakindu.base.types.typesystem.DefaultTypeSystem.STRING;

import org.yakindu.base.expressions.expressions.AssignmentExpression;
import org.yakindu.base.expressions.expressions.BitwiseAndExpression;
import org.yakindu.base.expressions.expressions.BitwiseOrExpression;
import org.yakindu.base.expressions.expressions.BitwiseXorExpression;
import org.yakindu.base.expressions.expressions.BoolLiteral;
import org.yakindu.base.expressions.expressions.ConditionalExpression;
import org.yakindu.base.expressions.expressions.ElementReferenceExpression;
import org.yakindu.base.expressions.expressions.FeatureCall;
import org.yakindu.base.expressions.expressions.HexLiteral;
import org.yakindu.base.expressions.expressions.IntLiteral;
import org.yakindu.base.expressions.expressions.LogicalAndExpression;
import org.yakindu.base.expressions.expressions.LogicalNotExpression;
import org.yakindu.base.expressions.expressions.LogicalOrExpression;
import org.yakindu.base.expressions.expressions.LogicalRelationExpression;
import org.yakindu.base.expressions.expressions.NullLiteral;
import org.yakindu.base.expressions.expressions.NumericalAddSubtractExpression;
import org.yakindu.base.expressions.expressions.NumericalMultiplyDivideExpression;
import org.yakindu.base.expressions.expressions.NumericalUnaryExpression;
import org.yakindu.base.expressions.expressions.ParenthesizedExpression;
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression;
import org.yakindu.base.expressions.expressions.RealLiteral;
import org.yakindu.base.expressions.expressions.ShiftExpression;
import org.yakindu.base.expressions.expressions.StringLiteral;
import org.yakindu.base.expressions.expressions.TypeCastExpression;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.inferrer.AbstractTypeSystemInferrer;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ExpressionsTypeInferrer extends AbstractTypeSystemInferrer implements ExpressionsTypeInferrerMessages {

	public Type infer(AssignmentExpression e) {
		Type type1 = inferType(e.getVarRef());
		Type type2 = inferType(e.getExpression());
		assertIsSuperType(type2, type1, String.format(ASSIGNMENT_OPERATOR, e.getOperator(), type1, type2));
		return inferType(e.getVarRef());
	}

	public Type infer(ConditionalExpression e) {
		Type type1 = inferType(e.getTrueCase());
		Type type2 = inferType(e.getFalseCase());
		assertCompatibleType(type1, type2, String.format(COMMON_TYPE, type1, type2));
		assertType(inferType(e.getCondition()), CONDITIONAL_BOOLEAN, getType(BOOLEAN));
		return getCommonType(type1, type2);
	}

	public Type infer(LogicalOrExpression e) {
		Type type1 = inferType(e.getLeftOperand());
		Type type2 = inferType(e.getRightOperand());
		assertType(type1, String.format(LOGICAL_OPERATORS, "||", type1, type2), getType(BOOLEAN));
		assertType(type2, String.format(LOGICAL_OPERATORS, "||", type1, type2), getType(BOOLEAN));
		return getType(BOOLEAN);
	}

	public Type infer(LogicalAndExpression e) {
		Type type1 = inferType(e.getLeftOperand());
		Type type2 = inferType(e.getRightOperand());
		assertType(type1, String.format(LOGICAL_OPERATORS, "&&", type1, type2), getType(BOOLEAN));
		assertType(type2, String.format(LOGICAL_OPERATORS, "&&", type1, type2), getType(BOOLEAN));
		return getType(BOOLEAN);
	}

	public Type infer(LogicalNotExpression e) {
		Type type = inferType(e.getOperand());
		assertType(type, String.format(LOGICAL_OPERATOR, "!", type), getType(BOOLEAN));
		return getType(BOOLEAN);
	}

	public Type infer(BitwiseXorExpression e) {
		Type type1 = inferType(e.getLeftOperand());
		Type type2 = inferType(e.getRightOperand());
		assertType(type1, String.format(BITWISE_OPERATORS, "^", type1, type2), getType(INTEGER));
		assertType(type2, String.format(BITWISE_OPERATORS, "^", type1, type2), getType(INTEGER));
		return getType(INTEGER);
	}

	public Type infer(BitwiseOrExpression e) {
		Type type1 = inferType(e.getLeftOperand());
		Type type2 = inferType(e.getRightOperand());
		assertType(type1, String.format(BITWISE_OPERATORS, "|", type1, type2), getType(INTEGER));
		assertType(type2, String.format(BITWISE_OPERATORS, "|", type1, type2), getType(INTEGER));
		return getType(INTEGER);
	}

	public Type infer(BitwiseAndExpression e) {
		Type type1 = inferType(e.getLeftOperand());
		Type type2 = inferType(e.getRightOperand());
		assertType(type1, String.format(BITWISE_OPERATORS, "&", type1, type2), getType(INTEGER));
		assertType(type2, String.format(BITWISE_OPERATORS, "&", type1, type2), getType(INTEGER));
		return getType(INTEGER);
	}

	public Type infer(ShiftExpression e) {
		Type type1 = inferType(e.getLeftOperand());
		Type type2 = inferType(e.getRightOperand());
		assertType(type1, String.format(BITWISE_OPERATORS, e.getOperator(), type1, type2), getType(INTEGER));
		assertType(type2, String.format(BITWISE_OPERATORS, e.getOperator(), type1, type2), getType(INTEGER));
		return getType(INTEGER);
	}

	public Type infer(LogicalRelationExpression e) {
		Type type1 = inferType(e.getLeftOperand());
		Type type2 = inferType(e.getRightOperand());
		assertCompatibleType(type1, type2, String.format(COMPARSION_OPERATOR, e.getOperator(), type1, type2));
		return getType(BOOLEAN);

	}

	public Type infer(NumericalAddSubtractExpression e) {
		Type type1 = inferType(e.getLeftOperand());
		Type type2 = inferType(e.getRightOperand());
		assertCompatibleType(type1, type2, String.format(ARITHMETIC_OPERATORS, e.getOperator(), type1, type2));
		assertType(type1, String.format(ARITHMETIC_OPERATORS, e.getOperator(), type1, type2), getType(INTEGER),
				getType(REAL));
		return getCommonType(e.getLeftOperand(), e.getRightOperand());
	}

	public Type infer(NumericalMultiplyDivideExpression e) {
		Type type1 = inferType(e.getLeftOperand());
		Type type2 = inferType(e.getRightOperand());
		assertCompatibleType(type1, type2, String.format(ARITHMETIC_OPERATORS, e.getOperator(), type1, type2));
		assertType(type1, String.format(ARITHMETIC_OPERATORS, e.getOperator(), type1, type2), getType(INTEGER),
				getType(REAL));
		return getCommonType(type1, type2);
	}

	public Type infer(NumericalUnaryExpression e) {
		Type type1 = inferType(e.getOperand());
		assertType(type1, String.format(BITWISE_OPERATOR, '~', type1), getType(INTEGER));
		return type1;
	}

	public Type infer(TypeCastExpression e) {
		Type type1 = inferType(e.getOperand());
		Type type2 = inferType(e.getType());
		assertCompatibleType(type1, type2, String.format(CAST_OPERATORS, type1, type2));
		return e.getType();
	}

	public Type infer(FeatureCall e) {
		return inferType(e.getFeature());
	}

	public Type infer(ElementReferenceExpression e) {
		return inferType(e.getReference());
	}

	public Type infer(ParenthesizedExpression e) {
		return inferType(e.getExpression());
	}

	public Type infer(PrimitiveValueExpression e) {
		return inferType(e.getValue());
	}

	public Type infer(BoolLiteral literal) {
		return getType(BOOLEAN);
	}

	public Type infer(IntLiteral literal) {
		return getType(INTEGER);
	}

	public Type infer(HexLiteral literal) {
		return getType(INTEGER);
	}

	public Type infer(RealLiteral literal) {
		return getType(REAL);
	}

	public Type infer(StringLiteral literal) {
		return getType(STRING);
	}

	public Type infer(NullLiteral literal) {
		return getType(NULL);
	}

}
