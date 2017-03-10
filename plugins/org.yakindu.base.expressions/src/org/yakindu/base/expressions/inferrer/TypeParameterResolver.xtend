package org.yakindu.base.expressions.inferrer

import com.google.inject.Inject
import java.util.Map
import org.eclipse.emf.ecore.EObject
import org.yakindu.base.types.GenericElement
import org.yakindu.base.types.Operation
import org.yakindu.base.types.TypeParameter
import org.yakindu.base.types.TypeSpecifier
import org.yakindu.base.types.inferrer.ITypeSystemInferrer.InferenceResult
import org.yakindu.base.types.typesystem.ITypeSystem

import static org.yakindu.base.expressions.inferrer.ExpressionsTypeInferrerMessages.*

class TypeParameterResolver {

	@Inject ITypeSystem registry;

	def void buildTypeParameterMapping(Map<TypeParameter, InferenceResult> typeParameterMapping,
		TypeSpecifier parameterTypeSpecifier, InferenceResult argumentType) throws TypeInferrenceException {
		buildTypeParameterMap(parameterTypeSpecifier.getType(), parameterTypeSpecifier, argumentType,
			typeParameterMapping)
	}

	def dispatch buildTypeParameterMap(TypeParameter parameterTypeSpecifierType, TypeSpecifier parameterTypeSpecifier,
		InferenceResult argumentType, Map<TypeParameter, InferenceResult> typeParameterMapping) {

		val newMappedType = argumentType.getType();
		val typeParameter = parameterTypeSpecifier.getType() as TypeParameter;
		val typeInMap = typeParameterMapping.get(typeParameter);
		if (typeInMap == null) {
			typeParameterMapping.put(typeParameter, InferenceResult.from(newMappedType, argumentType.getBindings()));
		} else {
			val commonType = registry.getCommonType(newMappedType, typeInMap.getType());
			if (commonType == null) {
				typeParameterMapping.put(typeParameter, null);
				val errorMsg = String.format(INFER_COMMON_TYPE, parameterTypeSpecifier.getType().getName(),
					newMappedType.getName(), typeInMap.getType().getName());
				throw new TypeInferrenceException(errorMsg);
			} else {
				typeParameterMapping.put(typeParameter, InferenceResult.from(commonType, argumentType.getBindings()));
			}
		}
	}

	def dispatch buildTypeParameterMap(GenericElement parameterTypeSpecifierType, TypeSpecifier parameterTypeSpecifier,
		InferenceResult argumentType, Map<TypeParameter, InferenceResult> typeParameterMapping) {
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

	def dispatch buildTypeParameterMap(EObject parameterTypeSpecifierType, TypeSpecifier parameterTypeSpecifier,
		InferenceResult argumentType, Map<TypeParameter, InferenceResult> typeParameterMapping) {
			// Fallback for uninteresting case
	}

	def InferenceResult buildInferenceResult(TypeSpecifier typeSpecifier,
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
			val result = InferenceResult.from(typeSpecifier.getType());
			for (TypeSpecifier typeArgSpecifier : typeSpecifier.getTypeArguments()) {
				buildInferenceResult(typeArgSpecifier, typeParameterMapping);
			}
			return result;
		}
	}

	def InferenceResult inferReturnType(Operation operation,
		Map<TypeParameter, InferenceResult> typeParameterMapping) throws TypeInferrenceException {
		val type = operation.getType()
		if (type instanceof TypeParameter) {
			val mappedType = typeParameterMapping.get(type)
			if (mappedType == null) {
				throw new TypeInferrenceException(String.format(INFER_RETURN_TYPE, type.getName()));
			} else {
				return mappedType;
			}
		} else if (type instanceof GenericElement) {
			return buildInferenceResult(operation.getTypeSpecifier(), typeParameterMapping);
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

	static class TypeInferrenceException extends Exception {
		new(String message) {
			super(message)
		}
	}
}
