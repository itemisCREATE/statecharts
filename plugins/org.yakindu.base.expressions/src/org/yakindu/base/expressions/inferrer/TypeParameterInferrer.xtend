/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	Thomas Kutz, René Beckmann - initial API and implementation
 * 
 */
package org.yakindu.base.expressions.inferrer

import com.google.inject.Inject
import java.util.List
import java.util.Map
import org.yakindu.base.types.GenericElement
import org.yakindu.base.types.Parameter
import org.yakindu.base.types.Type
import org.yakindu.base.types.TypeParameter
import org.yakindu.base.types.TypeSpecifier
import org.yakindu.base.types.Property
import org.yakindu.base.types.inferrer.ITypeSystemInferrer.InferenceResult
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.base.types.validation.IValidationIssueAcceptor
import org.yakindu.base.types.validation.IValidationIssueAcceptor.ValidationIssue
import org.yakindu.base.types.validation.IValidationIssueAcceptor.ValidationIssue.Severity
import org.yakindu.base.types.validation.TypeValidator

import static org.yakindu.base.expressions.inferrer.ExpressionsTypeInferrerMessages.*
import static org.yakindu.base.types.inferrer.ITypeSystemInferrer.NOT_INFERRABLE_TYPE_PARAMETER_CODE
import static org.yakindu.base.types.inferrer.ITypeSystemInferrer.NOT_COMPATIBLE_CODE
import org.yakindu.base.types.validation.TypeValidationError
import org.yakindu.base.types.PrimitiveType
import org.yakindu.base.types.ComplexType

/**
 * Infers the actual type for a type parameter used in generic elements like operations or complex types.
 * <p>
 * For a generic operation, the actual type is inferred from the arguments used in the operation call:
 * <ul>
 * <li><code>op(p: T)</code> called as <code>op(10)</code> implies that <code>T</code> is <code>integer</code></li>
 * <li><code>op(p1: T, p2: T)</code> called as <code>op(10, 1.5)</code> implies that <code>T</code> is <code>real</code> (common type of <code>integer</code> and <code>real</code>)</li>
 * </ul>
 * 
 * For a generic type, the actual type of its type parameter is inferred from the type instantiation:
 * <ul>
 * <li><code>CPT&lt;T&gt;</code> instantiated as <code>var x : CPT&lt;integer&gt;</code> implies that <code>T</code> is <code>integer</code></li>
 * <li><code>CPT&lt;T&gt;</code> instantiated as <code>var x : CPT&lt;List&lt;integer&gt;&gt;</code> implies that <code>T</code> is <code>List&lt;integer&gt;</code></li>
 * </ul>
 */
class TypeParameterInferrer {

	@Inject ITypeSystem registry;
	@Inject TypeValidator typeValidator;

	/**
	 * Goes through the parameters and the arguments of the operation and the operation call
	 * and tries to infer the type of the TypeParameters for this operation call.
	 * 
	 * @param parameters the parameters of the operation
	 * @param arguments the inferred types of operation call's arguments
	 * @param inferredTypeParameterTypes map of type parameters to their inference result which will be filled by this method
	 */
	def void inferTypeParametersFromOperationArguments(List<Parameter> parameters, List<InferenceResult> arguments,
		Map<TypeParameter, InferenceResult> inferredTypeParameterTypes, IValidationIssueAcceptor acceptor) {
		if (parameters.size() <= arguments.size()) {
			for (var i = 0; i < parameters.size(); i++) {
				val parameter = parameters.get(i).typeSpecifier;
				val argument = arguments.get(i);
				if (parameterContainsTypeParameter(parameter) && assertArgumentAndParameterSoftCompatible(argument, parameter, acceptor)) {
					inferTypeParameterFromOperationArgument(parameter, argument, inferredTypeParameterTypes, acceptor);
				}
			}
		}
	}
	
	def boolean parameterContainsTypeParameter(TypeSpecifier specifier) {
		val type = specifier.type
		if (type instanceof PrimitiveType) {
			return false
		} 
		if(type instanceof TypeParameter) {
			return true
		} 
		if(type instanceof ComplexType) {
			val complexType = type as ComplexType
			if(complexType.typeParameters != null) {
				return true;
			} else {
				for(prop : complexType.features.filter(Property)) {
					if(prop.typeSpecifier.parameterContainsTypeParameter) {
						return true
					}
				}
			}
		}
		return false
	}

	def protected void inferTypeParameterFromOperationArgument(TypeSpecifier parameterTypeSpecifier,
		InferenceResult argumentType, Map<TypeParameter, InferenceResult> inferredTypeParameterTypes,
		IValidationIssueAcceptor acceptor) {
		val parameterType = parameterTypeSpecifier.getType()

		if (parameterType instanceof TypeParameter) {
			doInferTypeParameterFromOperationArgument(parameterType, argumentType, inferredTypeParameterTypes, acceptor)
		} else if (parameterType instanceof GenericElement) {
			doInferGenericTypeFromOperationArgument(parameterTypeSpecifier, argumentType, inferredTypeParameterTypes,
				acceptor)
		}
	}

	def protected doInferGenericTypeFromOperationArgument(TypeSpecifier parameterTypeSpecifier,
		InferenceResult argumentType, Map<TypeParameter, InferenceResult> inferredTypeParameterTypes,
		IValidationIssueAcceptor acceptor) {
		for (var i = 0; i < parameterTypeSpecifier.getTypeArguments().size(); i++) {
			val typeParameter = parameterTypeSpecifier.getTypeArguments().get(i);
			if (argumentType.getBindings().size() <= i) {
				acceptor.error(typeParameter, NOT_INFERRABLE_TYPE_PARAMETER_CODE)
			} else {
				val typeArgument = argumentType.getBindings().get(i);
				inferTypeParameterFromOperationArgument(typeParameter, typeArgument, inferredTypeParameterTypes,
					acceptor);
			}
		}
	}

	def protected doInferTypeParameterFromOperationArgument(TypeParameter typeParameter, InferenceResult argumentType,
		Map<TypeParameter, InferenceResult> inferredTypeParameterTypes, IValidationIssueAcceptor acceptor) {

		val newMappedType = argumentType.getType();
		val typeInMap = inferredTypeParameterTypes.get(typeParameter);
		if (typeInMap == null) {
			inferredTypeParameterTypes.put(typeParameter,
				InferenceResult.from(newMappedType, argumentType.getBindings()));
		} else {
			val commonType = getCommonType(argumentType, typeInMap);
			val errorMsg = String.format(INCOMPATIBLE_TYPES, argumentType.toString, typeInMap.toString)
			val errors = typeValidator.assertTypeBindingsSame(argumentType, typeInMap, errorMsg)
			if (commonType == null || !errors.empty) {
				inferredTypeParameterTypes.put(typeParameter, null);
				if (!errors.empty) {
					errors.forEach [
						acceptor.error(message, errorCode)
					]
				}
				acceptor.error(
					String.format(INFER_COMMON_TYPE, typeParameter.name,
						newArrayList(argumentType.type.name, typeInMap.type.name)), NOT_INFERRABLE_TYPE_PARAMETER_CODE)
			} else {
				inferredTypeParameterTypes.put(typeParameter,
					InferenceResult.from(commonType, argumentType.getBindings()));
			}
		}
	}

	def protected Type getCommonType(InferenceResult type1, InferenceResult type2) {
		val result = registry.getCommonType(type1.getType(), type2.getType())
		return result
	}

	/**
	 * For a given inference result with potentially unresolved type parameters a new inference result is built by 
	 * resolving type parameters based on the given type parameter inference map.
	 * For generic types this method calls itself recursively to fill all nested type parameters.
	 */
	def protected InferenceResult buildInferenceResult(InferenceResult oldInferenceResult,
		Map<TypeParameter, InferenceResult> inferredTypeParameterTypes, IValidationIssueAcceptor acceptor) {
		if (oldInferenceResult.getType() instanceof TypeParameter) {
			// get already inferred type from type parameter map
			val typeParameter = oldInferenceResult.getType() as TypeParameter
			val mappedType = inferredTypeParameterTypes.get(typeParameter);
			if (mappedType == null) {
				acceptor.warning(typeParameter, NOT_INFERRABLE_TYPE_PARAMETER_CODE)
				return null
			} else {
				return mappedType;
			}
		} else if (oldInferenceResult.getType() instanceof GenericElement) {
			val List<InferenceResult> newBindings = newArrayList()
			for (InferenceResult oldBinding : oldInferenceResult.getBindings()) {
				newBindings.add(buildInferenceResult(oldBinding, inferredTypeParameterTypes, acceptor))
			}
			val result = InferenceResult.from(oldInferenceResult.getType(), newBindings);
			return result;
		}
		return oldInferenceResult;
	}

	def void inferTypeParametersFromOwner(InferenceResult operationOwnerResult,
		Map<TypeParameter, InferenceResult> inferredTypeParameterTypes) {
		var operationOwnerType = operationOwnerResult.getType()
		if (operationOwnerType instanceof GenericElement) {
			for (var i = 0; i < operationOwnerType.typeParameters.size() &&
				i < operationOwnerResult.bindings.size(); i++) { // T1, T2...
				val typeParameter = operationOwnerType.typeParameters.get(i)
				val binding = operationOwnerResult.bindings.get(i) // integer, boolean...
				inferredTypeParameterTypes.put(typeParameter, binding)
			}
		}
	}

	/**
	 * Asserts that two types are <i>roughly</i> compatible.<br>
	 * These are compatible:
	 * <ul>
	 * <li><code>ComplexType&lt;integer&gt;</code></li>
	 * <li> <code>ComplexType&lt;T&gt;</code></li>
	 * </ul>
	 * These are as well:
	 * <ul>
	 * <li><code>T</code></li>
	 * <li><code>integer</code></li>
	 * </ul>
	 * These are not:
	 * <ul>
	 * <li><code>ComplexType&lt;T&gt;</code></li>
	 * <li><code>integer</code></li>
	 * </ul>
	 */
	def assertArgumentAndParameterSoftCompatible(InferenceResult argumentResult, TypeSpecifier parameter,
		IValidationIssueAcceptor acceptor) {
		// I can't think of anything that's not compatible to a TypeParameter, so...
		if (parameter.type instanceof TypeParameter) {
			return true
		}
		var result1 = InferenceResult.from(argumentResult.type) // ignore bindings
		val result2 = InferenceResult.from(parameter.type)
		val errors = typeValidator.assertCompatible(result1, result2, null)
		// check for correct number of TypeParameters / Argument's type parameters
		if (errors.empty && parameter.typeArguments != null &&
			parameter.typeArguments.size != argumentResult.bindings.size) {
			// build temporary binding list for error message
			val bindings = parameter.typeArguments.map [
				InferenceResult.from(type)
			]
			errors.add(
				new TypeValidationError(
					String.format(INCOMPATIBLE_TYPES, argumentResult, InferenceResult.from(parameter.type, bindings)),
					NOT_COMPATIBLE_CODE))
		}
		if (!errors.empty) {
			errors.forEach [
				acceptor.error(message, errorCode)
			]
			return false
		}
		return true
	}

	def error(IValidationIssueAcceptor acceptor, String msg, String issueCode) {
		acceptor.accept(new ValidationIssue(Severity.ERROR, msg, issueCode));
	}

	def error(IValidationIssueAcceptor acceptor, TypeSpecifier typeSpecifier, String issueCode) {
		acceptor.accept(
			new ValidationIssue(Severity.ERROR, String.format(INFER_TYPE_PARAMETER, typeSpecifier.type.name),
				issueCode));
	}

	def error(IValidationIssueAcceptor acceptor, TypeParameter typeParameter, String issueCode) {
		acceptor.accept(
			new ValidationIssue(Severity.ERROR, String.format(INFER_TYPE_PARAMETER, typeParameter.name),
				issueCode));
	}

	def warning(IValidationIssueAcceptor acceptor, String msg, String issueCode) {
		acceptor.accept(new ValidationIssue(Severity.WARNING, msg, issueCode))
	}

	def warning(IValidationIssueAcceptor acceptor, TypeParameter typeParameter, String issueCode) {
		acceptor.accept(
			new ValidationIssue(Severity.WARNING, String.format(INFER_TYPE_PARAMETER, typeParameter.name),
				issueCode));
	}

}
		