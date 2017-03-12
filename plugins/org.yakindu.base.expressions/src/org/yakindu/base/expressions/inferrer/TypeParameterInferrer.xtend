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

import static org.yakindu.base.expressions.inferrer.ExpressionsTypeInferrerMessages.*
import org.yakindu.base.types.validation.TypeValidator
import org.yakindu.base.types.validation.TypeValidationException

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
	def void inferTypeParametersFromOperationArguments(List<Parameter> parameters, List<InferenceResult> arguments, Map<TypeParameter, InferenceResult> inferredTypeParameterTypes) throws TypeInferrenceException, TypeValidationException {
		if (parameters.size() <= arguments.size()) {
			for (var i = 0; i < parameters.size(); i++) {
				val parameter = parameters.get(i);
				val argument = arguments.get(i);
				if (parameter.getType() instanceof TypeParameter || parameter.getType() instanceof GenericElement) {
					inferTypeParameterFromOperationArgument(parameter.getTypeSpecifier(), argument, inferredTypeParameterTypes);
				}
			}
		}
	}

	def protected void inferTypeParameterFromOperationArgument(TypeSpecifier parameterTypeSpecifier, InferenceResult argumentType, Map<TypeParameter, InferenceResult> inferredTypeParameterTypes) throws TypeInferrenceException {
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
				val errorMsg = String.format(INFER_TYPE, typeParameter.getType().getName())
				throw new TypeInferrenceException(errorMsg);
			} else {
				val typeArgument = argumentType.getBindings().get(i);
				inferTypeParameterFromOperationArgument(typeParameter, typeArgument, inferredTypeParameterTypes);
			}
		}
	}

	def protected doInferTypeParameterFromOperationArgument(TypeParameter parameterType, InferenceResult argumentType,
		Map<TypeParameter, InferenceResult> inferredTypeParameterTypes) {

		val newMappedType = argumentType.getType();
		val typeInMap = inferredTypeParameterTypes.get(parameterType);
		if (typeInMap == null) {
			inferredTypeParameterTypes.put(parameterType, InferenceResult.from(newMappedType, argumentType.getBindings()));
		} else {
			val commonType = getCommonType(argumentType, typeInMap);
			if (commonType == null) {
				inferredTypeParameterTypes.put(parameterType, null);
				val errorMsg = String.format(INFER_COMMON_TYPE, parameterType.getName(), newMappedType.getName(),
					typeInMap.getType().getName());
				throw new TypeInferrenceException(errorMsg);
			} else {
				inferredTypeParameterTypes.put(parameterType, InferenceResult.from(commonType, argumentType.getBindings()));
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
	 * Returns the inference result for a given type specifier by taking the type parameter inference map into account.
	 * If the type specifier is a generic element, it calls itself recursively to fill all nested type parameters.
	 */
	def protected InferenceResult buildInferenceResult(TypeSpecifier typeSpecifier,
		Map<TypeParameter, InferenceResult> inferredTypeParameterTypes) throws TypeInferrenceException {
		if (typeSpecifier.getType() instanceof TypeParameter) {
			// get already inferred type from type parameter map
			val typeParameter = typeSpecifier.getType() as TypeParameter
			val mappedType = inferredTypeParameterTypes.get(typeParameter);
			if (mappedType == null) {
				val errorMsg = String.format(INFER_RETURN_TYPE, typeParameter.getName().toString());
				throw new TypeInferrenceException(errorMsg)
			} else {
				return mappedType;
			}
		} else {
			val List<InferenceResult> bindings = newArrayList()
			for (TypeSpecifier typeArgSpecifier : typeSpecifier.getTypeArguments()) {
				bindings.add(buildInferenceResult(typeArgSpecifier, inferredTypeParameterTypes))
			}
			val result = InferenceResult.from(typeSpecifier.getType(), bindings);
			return result;
		}
	}
	
	def protected InferenceResult buildInferenceResult(InferenceResult oldInferenceResult,
		Map<TypeParameter, InferenceResult> inferredTypeParameterTypes) throws TypeInferrenceException {
		if (oldInferenceResult.getType() instanceof TypeParameter) {
			// get already inferred type from type parameter map
			val typeParameter = oldInferenceResult.getType() as TypeParameter
			val mappedType = inferredTypeParameterTypes.get(typeParameter);
			if (mappedType == null) {
				val errorMsg = String.format(INFER_RETURN_TYPE, typeParameter.getName().toString());
				throw new TypeInferrenceException(errorMsg)
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

	/**
	 * TODO: check if can be replaced by buildInferenceResult
	 */
	def InferenceResult inferType(TypeSpecifier genericType,
		Map<TypeParameter, InferenceResult> inferredTypeParameterTypes) throws TypeInferrenceException {
		val type = genericType.getType()
		if (type instanceof TypeParameter) {
			val mappedType = inferredTypeParameterTypes.get(type)
			if (mappedType == null) {
				throw new TypeInferrenceException(String.format(INFER_RETURN_TYPE, type.getName()));
			} else {
				return mappedType;
			}
		} else if (type instanceof GenericElement) {
			return buildInferenceResult(genericType, inferredTypeParameterTypes);
		}
	}

	def InferenceResult inferTypeParameter(TypeParameter typeParameter, InferenceResult ownerResult) {
		if (ownerResult.getBindings().isEmpty() || !(ownerResult.getType() instanceof GenericElement)) {
			return InferenceResult.from(registry.getType(ITypeSystem.ANY));
		} else {
			val index = (ownerResult.getType() as GenericElement).getTypeParameters().indexOf(typeParameter);
			return InferenceResult.from(ownerResult.getBindings().get(index).getType(),
				ownerResult.getBindings().get(index).getBindings());
		}
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

	static class TypeInferrenceException extends Exception {
		new(String message) {
			super(message)
		}
	}

	static class TypeInferrenceBindingException extends TypeInferrenceException {
		new(String message) {
			super(message)
		}
	}
}
