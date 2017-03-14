package org.yakindu.base.types.validation;

import static org.yakindu.base.types.inferrer.AbstractTypeSystemInferrer.ASSERT_COMPATIBLE;
import static org.yakindu.base.types.inferrer.AbstractTypeSystemInferrer.ASSERT_NOT_TYPE;
import static org.yakindu.base.types.inferrer.AbstractTypeSystemInferrer.ASSERT_SAME;
import static org.yakindu.base.types.inferrer.ITypeSystemInferrer.NOT_COMPATIBLE_CODE;
import static org.yakindu.base.types.inferrer.ITypeSystemInferrer.NOT_SAME_CODE;
import static org.yakindu.base.types.inferrer.ITypeSystemInferrer.NOT_TYPE_CODE;

import java.util.ArrayList;
import java.util.List;

import org.yakindu.base.types.ComplexType;
import org.yakindu.base.types.inferrer.ITypeSystemInferrer.InferenceResult;
import org.yakindu.base.types.typesystem.ITypeSystem;

import com.google.inject.Inject;

public class TypeValidator {
	@Inject
	protected ITypeSystem registry;
	
	public List<TypeValidationError> assertNotType(InferenceResult currentResult, String msg, InferenceResult... candidates) {
		List<TypeValidationError> errors = new ArrayList<>();
		if (currentResult == null)
			return errors;
		for (InferenceResult type : candidates) {
			if (registry.isSame(currentResult.getType(), type.getType())) {
				msg = msg != null ? msg : String.format(ASSERT_NOT_TYPE, currentResult);
				errors.add(new TypeValidationError(msg, NOT_TYPE_CODE));
			}
		}
		return errors;
	}

	public List<TypeValidationError> assertSame(InferenceResult result1, InferenceResult result2, String msg) {
		List<TypeValidationError> errors = new ArrayList<>();
		if (result1 == null || result2 == null)
			return errors;
		if (!registry.isSame(result1.getType(), result2.getType())) {
			msg = msg != null ? msg : String.format(ASSERT_SAME, result1, result2);
			errors.add(new TypeValidationError(msg, NOT_SAME_CODE));
			return errors;
		}

		return assertTypeBindingsSame(result1, result2, msg);
	}

	public List<TypeValidationError> assertCompatible(InferenceResult result1, InferenceResult result2, String msg) {
		List<TypeValidationError> errors = new ArrayList<>();
		if (result1 == null || result2 == null)
			return errors;
		if (isNullOnComplexType(result1, result2) || isNullOnComplexType(result2, result1)) {
			return errors;
		}
		if (!registry.haveCommonType(result1.getType(), result2.getType())) {
			msg = msg != null ? msg : String.format(ASSERT_COMPATIBLE, result1, result2);
			errors.add(new TypeValidationError(msg, NOT_COMPATIBLE_CODE));
			return errors;
		}
		return assertTypeBindingsSame(result1, result2, msg);

	}

	public List<TypeValidationError> assertAssignable(InferenceResult varResult, InferenceResult valueResult, String msg) {
		List<TypeValidationError> errors = new ArrayList<>();
		if (varResult == null || valueResult == null)
			return errors;
		if (isNullOnComplexType(varResult, valueResult)) {
			return errors;
		}
		if (!registry.isSuperType(valueResult.getType(), varResult.getType())) {
			msg = msg != null ? msg : String.format(ASSERT_COMPATIBLE, varResult, valueResult);
			errors.add(new TypeValidationError(msg, NOT_COMPATIBLE_CODE));
			return errors;
		}
		return assertTypeBindingsSame(varResult, valueResult, msg);
	}

	public List<TypeValidationError> assertTypeBindingsSame(InferenceResult result1, InferenceResult result2, String msg) {
		List<TypeValidationError> errors = new ArrayList<>();
		List<InferenceResult> bindings1 = result1.getBindings();
		List<InferenceResult> bindings2 = result2.getBindings();
		msg = msg != null ? msg : String.format(ASSERT_COMPATIBLE, result1, result2);
		if (bindings1.size() != bindings2.size()) {
			errors.add(new TypeValidationError(msg, NOT_COMPATIBLE_CODE));
			return errors;
		}
		for (int i = 0; i < bindings1.size(); i++) {
			errors.addAll(assertSame(bindings1.get(i), bindings2.get(i), msg));
		}
		return errors;
	}

	public List<TypeValidationError> assertIsSubType(InferenceResult subResult, InferenceResult superResult, String msg) {
		List<TypeValidationError> errors = new ArrayList<>();
		if (subResult == null || superResult == null)
			return errors;
		if (!registry.isSuperType(subResult.getType(), superResult.getType())) {
			msg = msg != null ? msg : String.format(ASSERT_COMPATIBLE, subResult, superResult);
			errors.add(new TypeValidationError(msg, NOT_COMPATIBLE_CODE));
			return errors;
		}
		return errors;
	}
	
	public boolean isNullOnComplexType(InferenceResult result1, InferenceResult result2) {
		return result1.getType() instanceof ComplexType
				&& registry.isSame(result2.getType(), registry.getType(ITypeSystem.NULL));
	}
}
