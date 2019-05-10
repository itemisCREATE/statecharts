/** 
 * Copyright (c) 2014 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 */
package org.yakindu.base.expressions.inferrer

import com.google.common.collect.Maps
import com.google.inject.Inject
import java.util.ArrayList
import java.util.List
import java.util.Map
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.EcoreUtil2
import org.yakindu.base.expressions.expressions.Argument
import org.yakindu.base.expressions.expressions.ArgumentExpression
import org.yakindu.base.expressions.expressions.AssignmentExpression
import org.yakindu.base.expressions.expressions.BitwiseAndExpression
import org.yakindu.base.expressions.expressions.BitwiseOrExpression
import org.yakindu.base.expressions.expressions.BitwiseXorExpression
import org.yakindu.base.expressions.expressions.BoolLiteral
import org.yakindu.base.expressions.expressions.ConditionalExpression
import org.yakindu.base.expressions.expressions.DoubleLiteral
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.expressions.FloatLiteral
import org.yakindu.base.expressions.expressions.HexLiteral
import org.yakindu.base.expressions.expressions.IntLiteral
import org.yakindu.base.expressions.expressions.LogicalAndExpression
import org.yakindu.base.expressions.expressions.LogicalNotExpression
import org.yakindu.base.expressions.expressions.LogicalOrExpression
import org.yakindu.base.expressions.expressions.LogicalRelationExpression
import org.yakindu.base.expressions.expressions.NullLiteral
import org.yakindu.base.expressions.expressions.NumericalAddSubtractExpression
import org.yakindu.base.expressions.expressions.NumericalMultiplyDivideExpression
import org.yakindu.base.expressions.expressions.NumericalUnaryExpression
import org.yakindu.base.expressions.expressions.ParenthesizedExpression
import org.yakindu.base.expressions.expressions.PostFixUnaryExpression
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression
import org.yakindu.base.expressions.expressions.ShiftExpression
import org.yakindu.base.expressions.expressions.StringLiteral
import org.yakindu.base.expressions.expressions.TypeCastExpression
import org.yakindu.base.expressions.expressions.UnaryOperator
import org.yakindu.base.expressions.util.ExpressionExtensions
import org.yakindu.base.types.Annotation
import org.yakindu.base.types.AnnotationType
import org.yakindu.base.types.EnumerationType
import org.yakindu.base.types.Enumerator
import org.yakindu.base.types.Expression
import org.yakindu.base.types.GenericElement
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Parameter
import org.yakindu.base.types.Property
import org.yakindu.base.types.Package
import org.yakindu.base.types.Type
import org.yakindu.base.types.TypeAlias
import org.yakindu.base.types.TypeParameter
import org.yakindu.base.types.TypeSpecifier
import org.yakindu.base.types.inferrer.AbstractTypeSystemInferrer
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.base.types.validation.IValidationIssueAcceptor

import static org.yakindu.base.types.typesystem.ITypeSystem.ANY
import static org.yakindu.base.types.typesystem.ITypeSystem.BOOLEAN
import static org.yakindu.base.types.typesystem.ITypeSystem.INTEGER
import static org.yakindu.base.types.typesystem.ITypeSystem.NULL
import static org.yakindu.base.types.typesystem.ITypeSystem.REAL
import static org.yakindu.base.types.typesystem.ITypeSystem.STRING
import static org.yakindu.base.types.typesystem.ITypeSystem.VOID

/** 
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
class ExpressionsTypeInferrer extends AbstractTypeSystemInferrer implements ExpressionsTypeInferrerMessages {
	@Inject protected TypeParameterInferrer typeParameterInferrer
	@Inject protected ExpressionExtensions utils

	def InferenceResult doInfer(AssignmentExpression e) {
		var InferenceResult result1 = inferTypeDispatch(e.getVarRef())
		var InferenceResult result2 = inferTypeDispatch(e.getExpression())
		assertAssignable(result1, result2, String.format(ASSIGNMENT_OPERATOR, e.getOperator(), result1, result2))
		return inferTypeDispatch(e.getVarRef())
	}

	def InferenceResult doInfer(ConditionalExpression e) {
		var InferenceResult result1 = inferTypeDispatch(e.getTrueCase())
		var InferenceResult result2 = inferTypeDispatch(e.getFalseCase())
		assertCompatible(result1, result2, String.format(COMMON_TYPE, result1, result2))
		assertIsSubType(inferTypeDispatch(e.getCondition()), getResultFor(BOOLEAN), CONDITIONAL_BOOLEAN)
		return getCommonType(result1, result2)
	}

	def InferenceResult doInfer(LogicalOrExpression e) {
		var InferenceResult result1 = inferTypeDispatch(e.getLeftOperand())
		var InferenceResult result2 = inferTypeDispatch(e.getRightOperand())
		assertIsSubType(result1, getResultFor(BOOLEAN), String.format(LOGICAL_OPERATORS, "||", result1, result2))
		assertIsSubType(result2, getResultFor(BOOLEAN), String.format(LOGICAL_OPERATORS, "||", result1, result2))
		return getResultFor(BOOLEAN)
	}

	def InferenceResult doInfer(LogicalAndExpression e) {
		var InferenceResult result1 = inferTypeDispatch(e.getLeftOperand())
		var InferenceResult result2 = inferTypeDispatch(e.getRightOperand())
		assertIsSubType(result1, getResultFor(BOOLEAN), String.format(LOGICAL_OPERATORS, "&&", result1, result2))
		assertIsSubType(result2, getResultFor(BOOLEAN), String.format(LOGICAL_OPERATORS, "&&", result1, result2))
		return getResultFor(BOOLEAN)
	}

	def InferenceResult doInfer(LogicalNotExpression e) {
		var InferenceResult type = inferTypeDispatch(e.getOperand())
		assertIsSubType(type, getResultFor(BOOLEAN), String.format(LOGICAL_OPERATOR, "!", type))
		return getResultFor(BOOLEAN)
	}

	def InferenceResult doInfer(BitwiseXorExpression e) {
		var InferenceResult result1 = inferTypeDispatch(e.getLeftOperand())
		var InferenceResult result2 = inferTypeDispatch(e.getRightOperand())
		assertIsSubType(result1, getResultFor(INTEGER), String.format(BITWISE_OPERATORS, "^", result1, result2))
		assertIsSubType(result2, getResultFor(INTEGER), String.format(BITWISE_OPERATORS, "^", result1, result2))
		return getResultFor(INTEGER)
	}

	def InferenceResult doInfer(BitwiseOrExpression e) {
		var InferenceResult result1 = inferTypeDispatch(e.getLeftOperand())
		var InferenceResult result2 = inferTypeDispatch(e.getRightOperand())
		assertIsSubType(result1, getResultFor(INTEGER), String.format(BITWISE_OPERATORS, "|", result1, result2))
		assertIsSubType(result2, getResultFor(INTEGER), String.format(BITWISE_OPERATORS, "|", result1, result2))
		return getResultFor(INTEGER)
	}

	def InferenceResult doInfer(BitwiseAndExpression e) {
		var InferenceResult result1 = inferTypeDispatch(e.getLeftOperand())
		var InferenceResult result2 = inferTypeDispatch(e.getRightOperand())
		assertIsSubType(result1, getResultFor(INTEGER), String.format(BITWISE_OPERATORS, "&", result1, result2))
		assertIsSubType(result2, getResultFor(INTEGER), String.format(BITWISE_OPERATORS, "&", result1, result2))
		return getResultFor(INTEGER)
	}

	def InferenceResult doInfer(ShiftExpression e) {
		var InferenceResult result1 = inferTypeDispatch(e.getLeftOperand())
		var InferenceResult result2 = inferTypeDispatch(e.getRightOperand())
		assertIsSubType(result1, getResultFor(INTEGER),
			String.format(BITWISE_OPERATORS, e.getOperator(), result1, result2))
		assertIsSubType(result2, getResultFor(INTEGER),
			String.format(BITWISE_OPERATORS, e.getOperator(), result1, result2))
		return getResultFor(INTEGER)
	}

	def InferenceResult doInfer(LogicalRelationExpression e) {
		var InferenceResult result1 = inferTypeDispatch(e.getLeftOperand())
		var InferenceResult result2 = inferTypeDispatch(e.getRightOperand())
		assertCompatible(result1, result2, String.format(COMPARSION_OPERATOR, e.getOperator(), result1, result2))
		return getResultFor(BOOLEAN)
	}

	def InferenceResult doInfer(NumericalAddSubtractExpression e) {
		var InferenceResult result1 = inferTypeDispatch(e.getLeftOperand())
		var InferenceResult result2 = inferTypeDispatch(e.getRightOperand())
		assertCompatible(result1, result2, String.format(ARITHMETIC_OPERATORS, e.getOperator(), result1, result2))
		assertIsSubType(result1, getResultFor(REAL),
			String.format(ARITHMETIC_OPERATORS, e.getOperator(), result1, result2))
		return getCommonType(result1, result2)
	}

	def InferenceResult doInfer(NumericalMultiplyDivideExpression e) {
		var InferenceResult result1 = inferTypeDispatch(e.getLeftOperand())
		var InferenceResult result2 = inferTypeDispatch(e.getRightOperand())
		assertCompatible(result1, result2, String.format(ARITHMETIC_OPERATORS, e.getOperator(), result1, result2))
		assertIsSubType(result1, getResultFor(REAL),
			String.format(ARITHMETIC_OPERATORS, e.getOperator(), result1, result2))
		return getCommonType(result1, result2)
	}

	def InferenceResult doInfer(NumericalUnaryExpression e) {
		var InferenceResult result1 = inferTypeDispatch(e.getOperand())
		if (e.getOperator() === UnaryOperator.COMPLEMENT)
			assertIsSubType(result1, getResultFor(INTEGER),
				String.format(BITWISE_OPERATOR, Character.valueOf('~').charValue, result1))
		else {
			assertIsSubType(result1, getResultFor(REAL), String.format(ARITHMETIC_OPERATOR, e.getOperator(), result1))
		}
		return result1
	}

	def InferenceResult doInfer(PostFixUnaryExpression expression) {
		var InferenceResult result = inferTypeDispatch(expression.getOperand())
		assertIsSubType(result, getResultFor(REAL), null)
		return result
	}

	def InferenceResult doInfer(TypeCastExpression e) {
		var InferenceResult result1 = inferTypeDispatch(e.getOperand())
		var InferenceResult result2 = inferTypeDispatch(e.getType())
		assertCompatible(result1, result2, String.format(CAST_OPERATORS, result1, result2))
		return inferTypeDispatch(e.getType())
	}

	def InferenceResult doInfer(EnumerationType enumType) {
		return InferenceResult.from(enumType)
	}

	def InferenceResult doInfer(Enumerator enumerator) {
		return InferenceResult.from(EcoreUtil2.getContainerOfType(enumerator, Type))
	}

	def InferenceResult doInfer(Type type) {
		return InferenceResult.from(type.getOriginType())
	}
	
	def InferenceResult doInfer(Package pkg) {
		return null
	}

	/** 
	 * The type of a type alias is its (recursively inferred) base type, i.e. type
	 * aliases are assignable if their inferred base types are assignable.
	 */
	def InferenceResult doInfer(TypeAlias typeAlias) {
		return inferTypeDispatch(typeAlias.getTypeSpecifier())
	}

	def InferenceResult doInfer(FeatureCall e) {
		// map to hold inference results for type parameters
		var Map<TypeParameter, InferenceResult> inferredTypeParameterTypes = Maps.newHashMap()
		typeParameterInferrer.inferTypeParametersFromOwner(inferTypeDispatch(e.getOwner()), inferredTypeParameterTypes)
		if (e.isOperationCall()) {
			if (!e.getFeature().eIsProxy()) {
				return inferOperation(e, (e.getFeature() as Operation), inferredTypeParameterTypes)
			} else {
				return getAnyType()
			}
		}
		var InferenceResult result = inferTypeDispatch(e.getFeature())
		if (result !== null) {
			result = typeParameterInferrer.buildInferenceResult(result, inferredTypeParameterTypes, acceptor)
		}
		if (result === null) {
			return getAnyType()
		}
		
		if (e.isArrayAccess && result?.type.name == ITypeSystem.ARRAY) {
			return getResult(result, e.arraySelector.size)
		}
		return result
	}

	def InferenceResult doInfer(ElementReferenceExpression e) {
		if (e.isOperationCall()) {
			if (e.getReference() !== null && !e.getReference().eIsProxy()) {
				return inferOperation(e, (e.getReference() as Operation),
					Maps.<TypeParameter, InferenceResult>newHashMap())
			} else {
				return getAnyType()
			}
		}
		var result =  inferTypeDispatch(e.getReference())
		if (e.isArrayAccess && result?.type.name == ITypeSystem.ARRAY) {
			return getResult(result, e.arraySelector.size)
		}
		result
	}

	def protected InferenceResult inferOperation(ArgumentExpression e, Operation op,
		Map<TypeParameter, InferenceResult> typeParameterMapping) {
		// resolve type parameter from operation call
		var List<InferenceResult> argumentTypes = getArgumentTypes(getOperationArguments(e))
		var List<Parameter> parameters = op.getParameters()
		var List<InferenceResult> argumentsToInfer = new ArrayList()
		var List<Parameter> parametersToInfer = new ArrayList()
		for (var int i = 0; i < parameters.size(); i++) {
			if (!typeParameterMapping.containsKey(parameters.get(i).getType())) {
				parametersToInfer.add(parameters.get(i))
				if (i < argumentTypes.size()) {
					argumentsToInfer.add(argumentTypes.get(i))
				}
			}
		}
		typeParameterInferrer.inferTypeParametersFromOperationArguments(parametersToInfer, argumentsToInfer,
			typeParameterMapping, acceptor)
		validateParameters(typeParameterMapping, op, getOperationArguments(e), acceptor)
		return inferReturnType(e, op, typeParameterMapping)
	}

	def protected InferenceResult getTargetType(ArgumentExpression exp) {
		var EObject container = exp.eContainer()
		// Assignment
		if (container instanceof AssignmentExpression) {
			var AssignmentExpression assignment = (container as AssignmentExpression)
			if (assignment.getExpression() === exp) {
				var Expression varRef = ((container as AssignmentExpression)).getVarRef()
				return inferTypeDispatch(varRef)
			}
		}
		// Variable Initialization
		if (container instanceof Property) {
			var Property property = (container as Property)
			if (property.getInitialValue() === exp) {
				return inferTypeDispatch(property.getTypeSpecifier())
			}
		}
		// Operation Argument
		if (container instanceof Argument) {
			var Argument argument = (container as Argument)
			if (argument.getValue() === exp) {
				var ArgumentExpression argumentExpression = (argument.eContainer() as ArgumentExpression)
				var int index = getOperationArguments(argumentExpression).indexOf(argument.getValue())
				var Operation op = (utils.featureOrReference(argumentExpression) as Operation)
				var Parameter param = op.getParameters().get(index)
				return inferTypeDispatch(param)
			}
		}
		return null
	}

	/** 
	 * Can be extended to e.g. add operation caller to argument list for extension
	 * methods
	 */
	def protected List<Expression> getOperationArguments(ArgumentExpression e) {
		return e.getExpressions()
	}

	def protected List<InferenceResult> getArgumentTypes(List<Expression> args) {
		var List<InferenceResult> argumentTypes = new ArrayList()
		for (Expression arg : args) {
			argumentTypes.add(inferTypeDispatch(arg))
		}
		return argumentTypes
	}

	def protected InferenceResult inferReturnType(ArgumentExpression e, Operation operation,
		Map<TypeParameter, InferenceResult> inferredTypeParameterTypes) {
		var InferenceResult returnType = inferTypeDispatch(operation)
		// if return type is not generic nor type parameter, we can return it immediately
		if (returnType !== null) {
			var Type type = returnType.getType()
			if (!(type instanceof TypeParameter) &&
				(!(type instanceof GenericElement) || ((type as GenericElement)).getTypeParameters().isEmpty())) {
				return returnType
			}
		}
		inferByTargetType(e, operation, inferredTypeParameterTypes)
		returnType = typeParameterInferrer.buildInferenceResult(returnType, inferredTypeParameterTypes, acceptor)
		if (returnType === null) {
			return getAnyType()
		}
		return returnType
	}

	def private void inferByTargetType(ArgumentExpression e, Operation operation,
		Map<TypeParameter, InferenceResult> inferredTypeParameterTypes) {
		// use target type inference
		var InferenceResult targetType = getTargetType(e)
		if (targetType !== null) {
			typeParameterInferrer.inferTypeParametersFromTargetType(targetType, operation, inferredTypeParameterTypes,
				acceptor)
		}
	}

	def private InferenceResult getAnyType() {
		return InferenceResult.from(registry.getType(ANY))
	}

	/** 
	 * Takes the operation parameter type and performs a lookup for all contained
	 * type parameters by using the given type parameter inference map.<br>
	 * The parameter types are validated against the operation call's argument
	 * types.
	 * @throws TypeParameterInferrenceException
	 */
	def Map<TypeParameter, InferenceResult> validateParameters(Map<TypeParameter, InferenceResult> typeParameterMapping,
		Operation operation, List<Expression> args, IValidationIssueAcceptor acceptor) {
		var List<Parameter> parameters = operation.getParameters()
		for (var int i = 0; i < parameters.size(); i++) {
			if (args.size() > i) {
				var Parameter parameter = parameters.get(i)
				var Expression argument = args.get(i)
				var InferenceResult parameterType = inferTypeDispatch(parameter)
				var InferenceResult argumentType = inferTypeDispatch(argument)
				parameterType = typeParameterInferrer.buildInferenceResult(parameterType, typeParameterMapping,
					acceptor)
				assertAssignable(parameterType, argumentType,
					String.format(INCOMPATIBLE_TYPES, argumentType, parameterType))
			}
		}
		if (operation.isVariadic() && args.size() - 1 >= operation.getVarArgIndex()) {
			var Parameter parameter = operation.getParameters().get(operation.getVarArgIndex())
			var List<Expression> varArgs = args.subList(operation.getVarArgIndex(), args.size() - 1)
			var InferenceResult parameterType = inferTypeDispatch(parameter)
			for (Expression expression : varArgs) {
				parameterType = typeParameterInferrer.buildInferenceResult(parameterType, typeParameterMapping,
					acceptor)
				var InferenceResult argumentType = inferTypeDispatch(expression)
				assertAssignable(parameterType, argumentType,
					String.format(INCOMPATIBLE_TYPES, argumentType, parameterType))
			}
		}
		return typeParameterMapping
	}

	def InferenceResult doInfer(ParenthesizedExpression e) {
		return inferTypeDispatch(e.getExpression())
	}

	def InferenceResult doInfer(PrimitiveValueExpression e) {
		return inferTypeDispatch(e.getValue())
	}

	def InferenceResult doInfer(BoolLiteral literal) {
		return getResultFor(BOOLEAN)
	}

	def InferenceResult doInfer(IntLiteral literal) {
		return getResultFor(INTEGER)
	}

	def InferenceResult doInfer(HexLiteral literal) {
		return getResultFor(INTEGER)
	}

	def InferenceResult doInfer(DoubleLiteral literal) {
		return getResultFor(REAL)
	}

	def InferenceResult doInfer(FloatLiteral literal) {
		return getResultFor(REAL)
	}

	def InferenceResult doInfer(StringLiteral literal) {
		return getResultFor(STRING)
	}

	def InferenceResult doInfer(NullLiteral literal) {
		return getResultFor(NULL)
	}

	def InferenceResult doInfer(Property e) {
		var InferenceResult result = inferTypeDispatch(e.getTypeSpecifier())
		assertNotType(result, VARIABLE_VOID_TYPE, getResultFor(VOID))
		if(e.getInitialValue() === null) return result
		var InferenceResult result2 = inferTypeDispatch(e.getInitialValue())
		assertAssignable(result, result2, String.format(PROPERTY_INITIAL_VALUE, result2, result))
		return result
	}

	def InferenceResult doInfer(Operation e) {
		return if(e.getTypeSpecifier() === null) getResultFor(VOID) else inferTypeDispatch(e.getTypeSpecifier())
	}

	def InferenceResult doInfer(Parameter e) {
		return inferTypeDispatch(e.getTypeSpecifier())
	}

	def InferenceResult doInfer(TypeSpecifier specifier) {
		if (specifier.getType() instanceof GenericElement &&
			((specifier.getType() as GenericElement)).getTypeParameters().size() > 0) {
			var List<InferenceResult> bindings = new ArrayList()
			var EList<TypeSpecifier> arguments = specifier.getTypeArguments()
			for (TypeSpecifier typeSpecifier : arguments) {
				var InferenceResult binding = inferTypeDispatch(typeSpecifier)
				if (binding !== null) {
					bindings.add(binding)
				}
			}
			var Type type = inferTypeDispatch(specifier.getType()).getType()
			return InferenceResult.from(type, bindings)
		}
		return inferTypeDispatch(specifier.getType())
	}

	def InferenceResult doInfer(Annotation ad) {
		var EList<Expression> arguments = ad.getArguments()
		inferAnnotationProperty(ad.getType(), arguments)
		return getResultFor(VOID)
	}

	def protected void inferAnnotationProperty(AnnotationType type, EList<Expression> arguments) {
		var EList<Property> properties = type.getProperties()
		if (properties.size() === arguments.size()) {
			for (var int i = 0; i < properties.size(); i++) {
				var InferenceResult type1 = inferTypeDispatch(properties.get(i))
				var InferenceResult type2 = inferTypeDispatch(arguments.get(i))
				assertCompatible(type1, type2, String.format(INCOMPATIBLE_TYPES, type1, type2))
			}
		}
	}
	
	def protected InferenceResult getResult(InferenceResult result, int i) {
		if (i == 1) {
			return result.bindings.head
		}
		val j = i - 1;
		return getResult(result.bindings.head, j)
	}
}
