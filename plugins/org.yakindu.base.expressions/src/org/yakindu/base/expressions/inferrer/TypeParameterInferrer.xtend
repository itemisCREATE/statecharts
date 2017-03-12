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
import org.yakindu.base.types.inferrer.ITypeSystemInferrer.InferenceResult
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.base.types.validation.TypeValidationException
import org.yakindu.base.types.validation.TypeValidator

import static org.yakindu.base.expressions.inferrer.ExpressionsTypeInferrerMessages.*

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
	def void inferTypeParametersFromOperationArguments(List<Parameter> parameters, List<InferenceResult> arguments, Map<TypeParameter, InferenceResult> inferredTypeParameterTypes) throws TypeParameterInferrer.TypeParameterInferrenceException, TypeValidationException {
		if (parameters.size() <= arguments.size()) {
			for (var i = 0; i < parameters.size(); i++) {
				val parameter = parameters.get(i);
				val argument = arguments.get(i);
				inferTypeParameterFromOperationArgument(parameter.getTypeSpecifier(), argument, inferredTypeParameterTypes);
			}
		}
	}

	def protected void inferTypeParameterFromOperationArgument(TypeSpecifier parameterTypeSpecifier, InferenceResult argumentType, Map<TypeParameter, InferenceResult> inferredTypeParameterTypes) throws TypeParameterInferrer.TypeParameterInferrenceException {
		val parameterType = parameterTypeSpecifier.getType()
		if (parameterType instanceof TypeParameter) {
			doInferTypeParameterFromOperationArgument(parameterType, argumentType, inferredTypeParameterTypes)
		} else if (parameterType instanceof GenericElement) {
			doInferGenericTypeFromOperationArgument(parameterTypeSpecifier, argumentType, inferredTypeParameterTypes)
		}
	}

	def protected doInferGenericTypeFromOperationArgument(TypeSpecifier parameterTypeSpecifier, InferenceResult argumentType,
		Map<TypeParameter, InferenceResult> inferredTypeParameterTypes) {
		for (var i = 0; i < parameterTypeSpecifier.getTypeArguments().size(); i++) {
			val typeParameter = parameterTypeSpecifier.getTypeArguments().get(i);
			if (argumentType.getBindings().size() <= i) {
				throw new TypeParameterInferrenceException(typeParameter);
			} else {
				val typeArgument = argumentType.getBindings().get(i);
				inferTypeParameterFromOperationArgument(typeParameter, typeArgument, inferredTypeParameterTypes);
			}
		}
	}

	def protected doInferTypeParameterFromOperationArgument(TypeParameter typeParameter, InferenceResult argumentType,
		Map<TypeParameter, InferenceResult> inferredTypeParameterTypes) {

		val newMappedType = argumentType.getType();
		val typeInMap = inferredTypeParameterTypes.get(typeParameter);
		if (typeInMap == null) {
			inferredTypeParameterTypes.put(typeParameter, InferenceResult.from(newMappedType, argumentType.getBindings()));
		} else {
			val commonType = getCommonType(argumentType, typeInMap);
			if (commonType == null) {
				inferredTypeParameterTypes.put(typeParameter, null);
				throw new MultiTypeParameterInferrenceException(typeParameter,
					newArrayList(argumentType.type.name, typeInMap.type.name));
			} else {
				inferredTypeParameterTypes.put(typeParameter, InferenceResult.from(commonType, argumentType.getBindings()));
			}
		}
	}

	def protected Type getCommonType(InferenceResult type1, InferenceResult type2) {
		val result = registry.getCommonType(type1.getType(), type2.getType())
		if (result == null) {
			return null
		}
		val errorMsg = String.format(INCOMPATIBLE_TYPES, type1.toString, type2.toString)
		typeValidator.assertTypeBindingsSame(type1, type2, errorMsg)
		return result
	}

	/**
	 * For a given inference result with potentially unresolved type parameters a new inference result is built by 
	 * resolving type parameters based on the given type parameter inference map.
	 * For generic types this method calls itself recursively to fill all nested type parameters.
	 */
	def protected InferenceResult buildInferenceResult(InferenceResult oldInferenceResult,
		Map<TypeParameter, InferenceResult> inferredTypeParameterTypes) throws TypeParameterInferrer.TypeParameterInferrenceException {
		if (oldInferenceResult.getType() instanceof TypeParameter) {
			// get already inferred type from type parameter map
			val typeParameter = oldInferenceResult.getType() as TypeParameter
			val mappedType = inferredTypeParameterTypes.get(typeParameter);
			if (mappedType == null) {
				throw new TypeParameterInferrenceException(typeParameter)
			} else {
				return mappedType;
			}
		} else if (oldInferenceResult.getType() instanceof GenericElement) {
			val List<InferenceResult> newBindings = newArrayList()
			for (InferenceResult oldBinding : oldInferenceResult.getBindings()) {
				newBindings.add(buildInferenceResult(oldBinding, inferredTypeParameterTypes))
			}
			val result = InferenceResult.from(oldInferenceResult.getType(), newBindings);
			return result;
		}
		return oldInferenceResult;
	}

	def void inferTypeParametersFromOwner(InferenceResult operationOwnerResult, Map<TypeParameter, InferenceResult> inferredTypeParameterTypes) {
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
	
	static class TypeParameterInferrenceException extends Exception {
		new(TypeParameter typeParameter) {
			super(String.format(INFER_TYPE_PARAMETER, typeParameter.name))
		}
		new(TypeSpecifier typeSpecifier) {
			super(String.format(INFER_TYPE_PARAMETER, typeSpecifier.type.name))
		}
		new (String message) {
			super(message)
		}
	}
	
	static class MultiTypeParameterInferrenceException extends TypeParameterInferrenceException {
		new(TypeParameter typeParameter, List<String> inferredTypes) {
			super(String.format(INFER_COMMON_TYPE, typeParameter.name, inferredTypes))
		}
	}

}
