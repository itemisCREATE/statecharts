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

import static org.yakindu.base.types.typesystem.ITypeSystem.BOOLEAN;
import static org.yakindu.base.types.typesystem.ITypeSystem.INTEGER;
import static org.yakindu.base.types.typesystem.ITypeSystem.NULL;
import static org.yakindu.base.types.typesystem.ITypeSystem.REAL;
import static org.yakindu.base.types.typesystem.ITypeSystem.STRING;
import static org.yakindu.base.types.typesystem.ITypeSystem.VOID;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.EcoreUtil2;
import org.yakindu.base.expressions.expressions.AssignmentExpression;
import org.yakindu.base.expressions.expressions.BitwiseAndExpression;
import org.yakindu.base.expressions.expressions.BitwiseOrExpression;
import org.yakindu.base.expressions.expressions.BitwiseXorExpression;
import org.yakindu.base.expressions.expressions.BoolLiteral;
import org.yakindu.base.expressions.expressions.ConditionalExpression;
import org.yakindu.base.expressions.expressions.DoubleLiteral;
import org.yakindu.base.expressions.expressions.ElementReferenceExpression;
import org.yakindu.base.expressions.expressions.Expression;
import org.yakindu.base.expressions.expressions.FeatureCall;
import org.yakindu.base.expressions.expressions.FloatLiteral;
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
import org.yakindu.base.expressions.expressions.ShiftExpression;
import org.yakindu.base.expressions.expressions.StringLiteral;
import org.yakindu.base.expressions.expressions.TypeCastExpression;
import org.yakindu.base.expressions.expressions.UnaryOperator;
import org.yakindu.base.types.EnumerationType;
import org.yakindu.base.types.Enumerator;
import org.yakindu.base.types.Operation;
import org.yakindu.base.types.Parameter;
import org.yakindu.base.types.Property;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.TypeAlias;
import org.yakindu.base.types.inferrer.AbstractTypeSystemInferrer;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ExpressionsTypeInferrer extends AbstractTypeSystemInferrer implements ExpressionsTypeInferrerMessages {

	public Type infer(AssignmentExpression e) {
		Type type1 = inferTypeDispatch(e.getVarRef());
		Type type2 = inferTypeDispatch(e.getExpression());
		assertAssignable(type1, type2, String.format(ASSIGNMENT_OPERATOR, e.getOperator(), type1, type2));
		return inferTypeDispatch(e.getVarRef());
	}

	public Type infer(ConditionalExpression e) {
		Type type1 = inferTypeDispatch(e.getTrueCase());
		Type type2 = inferTypeDispatch(e.getFalseCase());
		assertCompatible(type1, type2, String.format(COMMON_TYPE, type1, type2));
		assertIsType(inferTypeDispatch(e.getCondition()), CONDITIONAL_BOOLEAN, getType(BOOLEAN));
		return getCommonType(type1, type2);
	}

	public Type infer(LogicalOrExpression e) {
		Type type1 = inferTypeDispatch(e.getLeftOperand());
		Type type2 = inferTypeDispatch(e.getRightOperand());
		assertIsType(type1, String.format(LOGICAL_OPERATORS, "||", type1, type2), getType(BOOLEAN));
		assertIsType(type2, String.format(LOGICAL_OPERATORS, "||", type1, type2), getType(BOOLEAN));
		return getType(BOOLEAN);
	}

	public Type infer(LogicalAndExpression e) {
		Type type1 = inferTypeDispatch(e.getLeftOperand());
		Type type2 = inferTypeDispatch(e.getRightOperand());
		assertIsType(type1, String.format(LOGICAL_OPERATORS, "&&", type1, type2), getType(BOOLEAN));
		assertIsType(type2, String.format(LOGICAL_OPERATORS, "&&", type1, type2), getType(BOOLEAN));
		return getType(BOOLEAN);
	}

	public Type infer(LogicalNotExpression e) {
		Type type = inferTypeDispatch(e.getOperand());
		assertIsType(type, String.format(LOGICAL_OPERATOR, "!", type), getType(BOOLEAN));
		return getType(BOOLEAN);
	}

	public Type infer(BitwiseXorExpression e) {
		Type type1 = inferTypeDispatch(e.getLeftOperand());
		Type type2 = inferTypeDispatch(e.getRightOperand());
		assertIsType(type1, String.format(BITWISE_OPERATORS, "^", type1, type2), getType(INTEGER));
		assertIsType(type2, String.format(BITWISE_OPERATORS, "^", type1, type2), getType(INTEGER));
		return getType(INTEGER);
	}

	public Type infer(BitwiseOrExpression e) {
		Type type1 = inferTypeDispatch(e.getLeftOperand());
		Type type2 = inferTypeDispatch(e.getRightOperand());
		assertIsType(type1, String.format(BITWISE_OPERATORS, "|", type1, type2), getType(INTEGER));
		assertIsType(type2, String.format(BITWISE_OPERATORS, "|", type1, type2), getType(INTEGER));
		return getType(INTEGER);
	}

	public Type infer(BitwiseAndExpression e) {
		Type type1 = inferTypeDispatch(e.getLeftOperand());
		Type type2 = inferTypeDispatch(e.getRightOperand());
		assertIsType(type1, String.format(BITWISE_OPERATORS, "&", type1, type2), getType(INTEGER));
		assertIsType(type2, String.format(BITWISE_OPERATORS, "&", type1, type2), getType(INTEGER));
		return getType(INTEGER);
	}

	public Type infer(ShiftExpression e) {
		Type type1 = inferTypeDispatch(e.getLeftOperand());
		Type type2 = inferTypeDispatch(e.getRightOperand());
		assertIsType(type1, String.format(BITWISE_OPERATORS, e.getOperator(), type1, type2), getType(INTEGER));
		assertIsType(type2, String.format(BITWISE_OPERATORS, e.getOperator(), type1, type2), getType(INTEGER));
		return getType(INTEGER);
	}

	public Type infer(LogicalRelationExpression e) {
		Type type1 = inferTypeDispatch(e.getLeftOperand());
		Type type2 = inferTypeDispatch(e.getRightOperand());
		assertCompatible(type1, type2, String.format(COMPARSION_OPERATOR, e.getOperator(), type1, type2));
		Type result = getType(BOOLEAN);
		return result;

	}

	public Type infer(NumericalAddSubtractExpression e) {
		Type type1 = inferTypeDispatch(e.getLeftOperand());
		Type type2 = inferTypeDispatch(e.getRightOperand());
		assertCompatible(type1, type2, String.format(ARITHMETIC_OPERATORS, e.getOperator(), type1, type2));
		assertIsType(type1, String.format(ARITHMETIC_OPERATORS, e.getOperator(), type1, type2), getType(INTEGER),
				getType(REAL));
		return getCommonType(e.getLeftOperand(), e.getRightOperand());
	}

	public Type infer(NumericalMultiplyDivideExpression e) {
		Type type1 = inferTypeDispatch(e.getLeftOperand());
		Type type2 = inferTypeDispatch(e.getRightOperand());
		assertCompatible(type1, type2, String.format(ARITHMETIC_OPERATORS, e.getOperator(), type1, type2));
		assertIsType(type1, String.format(ARITHMETIC_OPERATORS, e.getOperator(), type1, type2), getType(INTEGER),
				getType(REAL));
		return getCommonType(type1, type2);
	}

	public Type infer(NumericalUnaryExpression e) {
		Type type1 = inferTypeDispatch(e.getOperand());
		if (e.getOperator() == UnaryOperator.COMPLEMENT)
			assertIsType(type1, String.format(BITWISE_OPERATOR, '~', type1), getType(INTEGER));
		else {
			assertCompatible(type1, getType(REAL), String.format(ARITHMETIC_OPERATOR, e.getOperator(), type1));
		}
		return type1;
	}

	public Type infer(TypeCastExpression e) {
		Type type1 = inferTypeDispatch(e.getOperand());
		Type type2 = inferTypeDispatch(e.getType());
		assertCompatible(type1, type2, String.format(CAST_OPERATORS, type1, type2));
		return inferTypeDispatch(e.getType());
	}

	public Type infer(EnumerationType enumType) {
		return enumType;
	}

	public Type infer(Enumerator enumerator) {
		return EcoreUtil2.getContainerOfType(enumerator, Type.class);
	}

	public Type infer(Type type) {
		return type;
	}

	// TODO: How to handle TypeAlias, like in C as weak types or like Lint
	// strong types?
	public Object infer(TypeAlias typeAlias) {
		return inferTypeDispatch(typeAlias.getType());
	}

	public Type infer(FeatureCall e) {
		if (e.isOperationCall()) {
			Operation operation = (Operation) e.getFeature();
			EList<Parameter> parameters = operation.getParameters();
			EList<Expression> args = e.getArgs();
			inferParameter(parameters, args);
		}
		return inferTypeDispatch(e.getFeature());
	}

	public Type infer(ElementReferenceExpression e) {
		if (e.isOperationCall()) {
			Operation operation = (Operation) e.getReference();
			EList<Parameter> parameters = operation.getParameters();
			EList<Expression> args = e.getArgs();
			inferParameter(parameters, args);
		}
		return inferTypeDispatch(e.getReference());
	}

	protected void inferParameter(EList<Parameter> parameters, EList<Expression> args) {
		if (parameters.size() == args.size()) {
			for (int i = 0; i < parameters.size(); i++) {
				Type type1 = inferTypeDispatch(parameters.get(i));
				Type type2 = inferTypeDispatch(args.get(i));
				assertCompatible(type1, type2, String.format(INCOMPATIBLE_TYPES, type1, type2));
			}
		}
	}

	public Type infer(ParenthesizedExpression e) {
		return inferTypeDispatch(e.getExpression());
	}

	public Type infer(PrimitiveValueExpression e) {
		return inferTypeDispatch(e.getValue());
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

	public Type infer(DoubleLiteral literal) {
		return getType(REAL);
	}
	
	public Type infer(FloatLiteral literal){
		return getType(REAL);
	}

	public Type infer(StringLiteral literal) {
		return getType(STRING);
	}

	public Type infer(NullLiteral literal) {
		return getType(NULL);
	}

	public Object infer(Property p) {
		Type type = inferTypeDispatch(p.getType());
		assertNotType(type, VARIABLE_VOID_TYPE, getType(VOID));
		return inferTypeDispatch(type);

	}

	public Object infer(Operation e) {
		return inferTypeDispatch(e.getType() != null ? e.getType() : getType(VOID));
	}

	public Object infer(Parameter e) {
		return inferTypeDispatch(e.getType());
	}
}
