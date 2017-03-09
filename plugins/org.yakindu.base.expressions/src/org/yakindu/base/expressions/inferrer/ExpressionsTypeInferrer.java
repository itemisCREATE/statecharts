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

import static org.yakindu.base.types.typesystem.ITypeSystem.ANY;
import static org.yakindu.base.types.typesystem.ITypeSystem.BOOLEAN;
import static org.yakindu.base.types.typesystem.ITypeSystem.INTEGER;
import static org.yakindu.base.types.typesystem.ITypeSystem.NULL;
import static org.yakindu.base.types.typesystem.ITypeSystem.REAL;
import static org.yakindu.base.types.typesystem.ITypeSystem.STRING;
import static org.yakindu.base.types.typesystem.ITypeSystem.VOID;

import java.util.ArrayList;
import java.util.List;

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
import org.yakindu.base.types.GenericElement;
import org.yakindu.base.types.Operation;
import org.yakindu.base.types.Parameter;
import org.yakindu.base.types.Property;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.TypeAlias;
import org.yakindu.base.types.TypeParameter;
import org.yakindu.base.types.TypeSpecifier;
import org.yakindu.base.types.inferrer.AbstractTypeSystemInferrer;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ExpressionsTypeInferrer extends AbstractTypeSystemInferrer implements ExpressionsTypeInferrerMessages {

	public InferenceResult doInfer(AssignmentExpression e) {
		InferenceResult result1 = inferTypeDispatch(e.getVarRef());
		InferenceResult result2 = inferTypeDispatch(e.getExpression());
		assertAssignable(result1, result2, String.format(ASSIGNMENT_OPERATOR, e.getOperator(), result1, result2));
		return inferTypeDispatch(e.getVarRef());
	}

	public InferenceResult doInfer(ConditionalExpression e) {
		InferenceResult result1 = inferTypeDispatch(e.getTrueCase());
		InferenceResult result2 = inferTypeDispatch(e.getFalseCase());
		assertCompatible(result1, result2, String.format(COMMON_TYPE, result1, result2));
		assertIsSubType(inferTypeDispatch(e.getCondition()), getResultFor(BOOLEAN), CONDITIONAL_BOOLEAN);
		return getCommonType(result1, result2);
	}

	public InferenceResult doInfer(LogicalOrExpression e) {
		InferenceResult result1 = inferTypeDispatch(e.getLeftOperand());
		InferenceResult result2 = inferTypeDispatch(e.getRightOperand());
		assertIsSubType(result1, getResultFor(BOOLEAN), String.format(LOGICAL_OPERATORS, "||", result1, result2));
		assertIsSubType(result2, getResultFor(BOOLEAN), String.format(LOGICAL_OPERATORS, "||", result1, result2));
		return getResultFor(BOOLEAN);
	}

	public InferenceResult doInfer(LogicalAndExpression e) {
		InferenceResult result1 = inferTypeDispatch(e.getLeftOperand());
		InferenceResult result2 = inferTypeDispatch(e.getRightOperand());
		assertIsSubType(result1, getResultFor(BOOLEAN), String.format(LOGICAL_OPERATORS, "&&", result1, result2));
		assertIsSubType(result2, getResultFor(BOOLEAN), String.format(LOGICAL_OPERATORS, "&&", result1, result2));
		return getResultFor(BOOLEAN);
	}

	public InferenceResult doInfer(LogicalNotExpression e) {
		InferenceResult type = inferTypeDispatch(e.getOperand());
		assertIsSubType(type, getResultFor(BOOLEAN), String.format(LOGICAL_OPERATOR, "!", type));
		return getResultFor(BOOLEAN);
	}

	public InferenceResult doInfer(BitwiseXorExpression e) {
		InferenceResult result1 = inferTypeDispatch(e.getLeftOperand());
		InferenceResult result2 = inferTypeDispatch(e.getRightOperand());
		assertIsSubType(result1, getResultFor(INTEGER), String.format(BITWISE_OPERATORS, "^", result1, result2));
		assertIsSubType(result2, getResultFor(INTEGER), String.format(BITWISE_OPERATORS, "^", result1, result2));
		return getResultFor(INTEGER);
	}

	public InferenceResult doInfer(BitwiseOrExpression e) {
		InferenceResult result1 = inferTypeDispatch(e.getLeftOperand());
		InferenceResult result2 = inferTypeDispatch(e.getRightOperand());
		assertIsSubType(result1, getResultFor(INTEGER), String.format(BITWISE_OPERATORS, "|", result1, result2));
		assertIsSubType(result2, getResultFor(INTEGER), String.format(BITWISE_OPERATORS, "|", result1, result2));
		return getResultFor(INTEGER);
	}

	public InferenceResult doInfer(BitwiseAndExpression e) {
		InferenceResult result1 = inferTypeDispatch(e.getLeftOperand());
		InferenceResult result2 = inferTypeDispatch(e.getRightOperand());
		assertIsSubType(result1, getResultFor(INTEGER), String.format(BITWISE_OPERATORS, "&", result1, result2));
		assertIsSubType(result2, getResultFor(INTEGER), String.format(BITWISE_OPERATORS, "&", result1, result2));
		return getResultFor(INTEGER);
	}

	public InferenceResult doInfer(ShiftExpression e) {
		InferenceResult result1 = inferTypeDispatch(e.getLeftOperand());
		InferenceResult result2 = inferTypeDispatch(e.getRightOperand());
		assertIsSubType(result1, getResultFor(INTEGER),
				String.format(BITWISE_OPERATORS, e.getOperator(), result1, result2));
		assertIsSubType(result2, getResultFor(INTEGER),
				String.format(BITWISE_OPERATORS, e.getOperator(), result1, result2));
		return getResultFor(INTEGER);
	}

	public InferenceResult doInfer(LogicalRelationExpression e) {
		InferenceResult result1 = inferTypeDispatch(e.getLeftOperand());
		InferenceResult result2 = inferTypeDispatch(e.getRightOperand());
		assertCompatible(result1, result2, String.format(COMPARSION_OPERATOR, e.getOperator(), result1, result2));
		InferenceResult result = getResultFor(BOOLEAN);
		return result;
	}

	public InferenceResult doInfer(NumericalAddSubtractExpression e) {
		InferenceResult result1 = inferTypeDispatch(e.getLeftOperand());
		InferenceResult result2 = inferTypeDispatch(e.getRightOperand());
		assertCompatible(result1, result2, String.format(ARITHMETIC_OPERATORS, e.getOperator(), result1, result2));
		assertIsSubType(result1, getResultFor(REAL),
				String.format(ARITHMETIC_OPERATORS, e.getOperator(), result1, result2));
		return getCommonType(inferTypeDispatch(e.getLeftOperand()), inferTypeDispatch(e.getRightOperand()));
	}

	public InferenceResult doInfer(NumericalMultiplyDivideExpression e) {
		InferenceResult result1 = inferTypeDispatch(e.getLeftOperand());
		InferenceResult result2 = inferTypeDispatch(e.getRightOperand());
		assertCompatible(result1, result2, String.format(ARITHMETIC_OPERATORS, e.getOperator(), result1, result2));
		assertIsSubType(result1, getResultFor(REAL),
				String.format(ARITHMETIC_OPERATORS, e.getOperator(), result1, result2));
		return getCommonType(result1, result2);
	}

	public InferenceResult doInfer(NumericalUnaryExpression e) {
		InferenceResult result1 = inferTypeDispatch(e.getOperand());
		if (e.getOperator() == UnaryOperator.COMPLEMENT)
			assertIsSubType(result1, getResultFor(INTEGER), String.format(BITWISE_OPERATOR, '~', result1));
		else {
			assertIsSubType(result1, getResultFor(REAL), String.format(ARITHMETIC_OPERATOR, e.getOperator(), result1));
		}
		return result1;
	}

	public InferenceResult doInfer(TypeCastExpression e) {
		InferenceResult result1 = inferTypeDispatch(e.getOperand());
		InferenceResult result2 = inferTypeDispatch(e.getType());
		assertCompatible(result1, result2, String.format(CAST_OPERATORS, result1, result2));
		return inferTypeDispatch(e.getType());
	}

	public InferenceResult doInfer(EnumerationType enumType) {
		return InferenceResult.from(enumType);
	}

	public InferenceResult doInfer(Enumerator enumerator) {
		return InferenceResult.from(EcoreUtil2.getContainerOfType(enumerator, Type.class));
	}

	public InferenceResult doInfer(Type type) {
		return InferenceResult.from(type.getOriginType());
	}

	/**
	 * The type of a type alias is its (recursively inferred) base type, i.e.
	 * type aliases are assignable if their inferred base types are assignable.
	 */
	public InferenceResult doInfer(TypeAlias typeAlias) {
		return inferTypeDispatch(typeAlias.getTypeSpecifier());
	}

	public InferenceResult doInfer(FeatureCall e) {
		if (e.isOperationCall()) {
			Operation operation = (Operation) e.getFeature();
			EList<Expression> args = e.getArgs();
			inferParameter(operation, args, e.getOwner());
		}
		InferenceResult result = inferTypeDispatch(e.getFeature());
		if (result != null && result.getType() instanceof TypeParameter) {
			result = inferTypeParameter((TypeParameter) result.getType(), inferTypeDispatch(e.getOwner()));
		}
		return result;
	}

	public InferenceResult doInfer(ElementReferenceExpression e) {
		if (e.isOperationCall()) {
			Operation operation = (Operation) e.getReference();
			EList<Expression> args = e.getArgs();
			inferParameter(operation, args, null);
		}
		return inferTypeDispatch(e.getReference());
	}

	public void inferParameter(Operation operation, EList<Expression> args, Expression operationOwner) {
		EList<Parameter> parameters = operation.getParameters();
		if (parameters.size() <= args.size()) {
			for (int i = 0; i < parameters.size(); i++) {
				assertArgumentIsCompatible(operationOwner, parameters.get(i), args.get(i));
			}
		}
		if (operation.isVariadic() && args.size() - 1 >= operation.getVarArgIndex()) {
			Parameter parameter = operation.getParameters().get(operation.getVarArgIndex());
			List<Expression> varArgs = args.subList(operation.getVarArgIndex(), args.size() - 1);
			for (Expression expression : varArgs) {
				assertArgumentIsCompatible(operationOwner, parameter, expression);
			}
		}
	}

	protected void assertArgumentIsCompatible(Expression operationOwner, Parameter parameter, Expression argument) {
		InferenceResult result1 = inferTypeDispatch(parameter);
		if (operationOwner != null && result1 != null && result1.getType() instanceof TypeParameter) {
			result1 = inferTypeParameter((TypeParameter) result1.getType(), inferTypeDispatch(operationOwner));
		}
		InferenceResult result2 = inferTypeDispatch(argument);
		assertCompatible(result2, result1, String.format(INCOMPATIBLE_TYPES, result2, result1));
	}

	protected InferenceResult inferTypeParameter(TypeParameter typeParameter, InferenceResult ownerResult) {
		if (ownerResult.getBindings().isEmpty() || !(ownerResult.getType() instanceof GenericElement)) {
			return getResultFor(ANY);
		} else {
			int index = ((GenericElement) ownerResult.getType()).getTypeParameters().indexOf(typeParameter);
			return InferenceResult.from(ownerResult.getBindings().get(index).getType(),
					ownerResult.getBindings().get(index).getBindings());
		}
	}

	public InferenceResult doInfer(ParenthesizedExpression e) {
		return inferTypeDispatch(e.getExpression());
	}

	public InferenceResult doInfer(PrimitiveValueExpression e) {
		return inferTypeDispatch(e.getValue());
	}

	public InferenceResult doInfer(BoolLiteral literal) {
		return getResultFor(BOOLEAN);
	}

	public InferenceResult doInfer(IntLiteral literal) {
		return getResultFor(INTEGER);
	}

	public InferenceResult doInfer(HexLiteral literal) {
		return getResultFor(INTEGER);
	}

	public InferenceResult doInfer(DoubleLiteral literal) {
		return getResultFor(REAL);
	}

	public InferenceResult doInfer(FloatLiteral literal) {
		return getResultFor(REAL);
	}

	public InferenceResult doInfer(StringLiteral literal) {
		return getResultFor(STRING);
	}

	public InferenceResult doInfer(NullLiteral literal) {
		return getResultFor(NULL);
	}

	public InferenceResult doInfer(Property p) {
		InferenceResult type = inferTypeDispatch(p.getTypeSpecifier());
		assertNotType(type, VARIABLE_VOID_TYPE, getResultFor(VOID));
		return type;
	}

	public InferenceResult doInfer(Operation e) {
		return e.getTypeSpecifier() == null ? getResultFor(VOID) : inferTypeDispatch(e.getTypeSpecifier());
	}

	public InferenceResult doInfer(Parameter e) {
		return inferTypeDispatch(e.getTypeSpecifier());
	}

	public InferenceResult doInfer(TypeSpecifier specifier) {
		if (specifier.getType() instanceof GenericElement
				&& ((GenericElement) specifier.getType()).getTypeParameters().size() > 0) {
			List<InferenceResult> bindings = new ArrayList<>();
			EList<TypeSpecifier> arguments = specifier.getTypeArguments();
			for (TypeSpecifier typeSpecifier : arguments) {
				InferenceResult binding = inferTypeDispatch(typeSpecifier);
				if (binding != null) {
					bindings.add(binding);
				}
			}
			Type type = inferTypeDispatch(specifier.getType()).getType();
			return InferenceResult.from(type, bindings);
		}
		return inferTypeDispatch(specifier.getType());

	}
}
