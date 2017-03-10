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

class TypeParameterResolver {

	@Inject ITypeSystem registry;
	@Inject TypeValidator typeValidator;

	/**
	 * Goes through the parameters and the arguments of the operation and the operation call
	 * and tries to infer the type of the TypeParameters for this operation call.
	 */
	def void resolveTypeParametersFromOperationArguments(Map<TypeParameter, InferenceResult> typeParameterMapping,
		List<InferenceResult> arguments, List<Parameter> parameters) throws TypeInferrenceException, TypeValidationException {
		if (parameters.size() <= arguments.size()) {
			for (var i = 0; i < parameters.size(); i++) {
				val parameter = parameters.get(i);
				val argument = arguments.get(i);
				if (parameter.getType() instanceof TypeParameter || parameter.getType() instanceof GenericElement) {
					buildTypeParameterMapping(typeParameterMapping, parameter.getTypeSpecifier(), argument);
				}
			}
		}
	}

	def protected void buildTypeParameterMapping(Map<TypeParameter, InferenceResult> typeParameterMapping,
		TypeSpecifier parameterTypeSpecifier, InferenceResult argumentType) throws TypeInferrenceException {
		val parameterType = parameterTypeSpecifier.getType()
		if (parameterType instanceof TypeParameter) {
			resolveTypeParameter(parameterType, argumentType, typeParameterMapping)
		} else if (parameterType instanceof GenericElement) {
			resolveGenericElement(parameterTypeSpecifier, argumentType, typeParameterMapping)
		}
	}

	def protected resolveGenericElement(TypeSpecifier parameterTypeSpecifier, InferenceResult argumentType,
		Map<TypeParameter, InferenceResult> typeParameterMapping) {
		for (var i = 0; i < parameterTypeSpecifier.getTypeArguments().size(); i++) {
			val typeParameter = parameterTypeSpecifier.getTypeArguments().get(i);
			if (argumentType.getBindings().size() <= i) {
				val errorMsg = String.format(INFER_TYPE, typeParameter.getType().getName())
				throw new TypeInferrenceException(errorMsg);
			} else {
				val typeArgument = argumentType.getBindings().get(i);
				buildTypeParameterMapping(typeParameterMapping, typeParameter, typeArgument);
			}
		}
	}

	def protected resolveTypeParameter(TypeParameter parameterType, InferenceResult argumentType,
		Map<TypeParameter, InferenceResult> typeParameterMapping) {

		val newMappedType = argumentType.getType();
		val typeInMap = typeParameterMapping.get(parameterType);
		if (typeInMap == null) {
			typeParameterMapping.put(parameterType, InferenceResult.from(newMappedType, argumentType.getBindings()));
		} else {
			val commonType = getCommonType(argumentType, typeInMap);
			if (commonType == null) {
				typeParameterMapping.put(parameterType, null);
				val errorMsg = String.format(INFER_COMMON_TYPE, parameterType.getName(), newMappedType.getName(),
					typeInMap.getType().getName());
				throw new TypeInferrenceException(errorMsg);
			} else {
				typeParameterMapping.put(parameterType, InferenceResult.from(commonType, argumentType.getBindings()));
			}
		}
	}

	protected def Type getCommonType(InferenceResult newMappedType, InferenceResult typeInMap) {
		val result = registry.getCommonType(newMappedType.getType(), typeInMap.getType())
		if (result == null) {
			return null
		}
		val errorMsg = String.format(INCOMPATIBLE_TYPES, newMappedType.toString, typeInMap.toString)
		typeValidator.assertTypeBindingsSame(newMappedType, typeInMap, errorMsg)
		return result
	}

	/**
	 * Returns the InferenceResult for a given TypeSpecifier.
	 * If the TypeSpecifier is a GenericElement, it calls itself recursively to fill all 
	 * nested TypeParameters.
	 */
	def protected InferenceResult buildInferenceResult(TypeSpecifier typeSpecifier,
		Map<TypeParameter, InferenceResult> typeParameterMapping) throws TypeInferrenceException {
		if (typeSpecifier.getType() instanceof TypeParameter) {
			// get already inferred type from type parameter map
			val typeParameter = typeSpecifier.getType() as TypeParameter
			val mappedType = typeParameterMapping.get(typeParameter);
			if (mappedType == null) {
				val errorMsg = String.format(INFER_RETURN_TYPE, typeParameter.getName().toString());
				throw new TypeInferrenceException(errorMsg)
			} else {
				return mappedType;
			}
		} else {
			val List<InferenceResult> bindings = newArrayList()
			for (TypeSpecifier typeArgSpecifier : typeSpecifier.getTypeArguments()) {
				bindings.add( buildInferenceResult(typeArgSpecifier, typeParameterMapping))
			}
			val result = InferenceResult.from(typeSpecifier.getType(), bindings);
			return result;
		}
	}

	def InferenceResult inferType(TypeSpecifier genericType,
		Map<TypeParameter, InferenceResult> typeParameterMapping) throws TypeInferrenceException {
		val type = genericType.getType()
		if (type instanceof TypeParameter) {
			val mappedType = typeParameterMapping.get(type)
			if (mappedType == null) {
				throw new TypeInferrenceException(String.format(INFER_RETURN_TYPE, type.getName()));
			} else {
				return mappedType;
			}
		} else if (type instanceof GenericElement) {
			return buildInferenceResult(genericType, typeParameterMapping);
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

	def void resolveTypeParametersFromOwner(Map<TypeParameter, InferenceResult> typeParameterMapping,
		InferenceResult operationOwnerResult) {
		var operationOwnerType = operationOwnerResult.getType()
		if (operationOwnerType instanceof GenericElement) {
			for (var i = 0; i < operationOwnerType.typeParameters.size() &&
				i < operationOwnerResult.bindings.size(); i++) { // T1, T2...
				val typeParameter = operationOwnerType.typeParameters.get(i)
				val binding = operationOwnerResult.bindings.get(i) // integer, boolean...
				typeParameterMapping.put(typeParameter, binding)
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
