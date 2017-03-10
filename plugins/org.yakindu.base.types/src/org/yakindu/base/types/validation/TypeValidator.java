package org.yakindu.base.types.validation;

import static org.yakindu.base.types.inferrer.AbstractTypeSystemInferrer.ASSERT_COMPATIBLE;
import static org.yakindu.base.types.inferrer.AbstractTypeSystemInferrer.ASSERT_NOT_TYPE;
import static org.yakindu.base.types.inferrer.AbstractTypeSystemInferrer.ASSERT_SAME;
import static org.yakindu.base.types.inferrer.ITypeSystemInferrer.NOT_COMPATIBLE_CODE;
import static org.yakindu.base.types.inferrer.ITypeSystemInferrer.NOT_SAME_CODE;
import static org.yakindu.base.types.inferrer.ITypeSystemInferrer.NOT_TYPE_CODE;

import java.util.List;

import org.yakindu.base.types.ComplexType;
import org.yakindu.base.types.inferrer.ITypeSystemInferrer.InferenceResult;
import org.yakindu.base.types.typesystem.ITypeSystem;

import com.google.inject.Inject;

public class TypeValidator {
	@Inject
	protected ITypeSystem registry;
	
	public void assertNotType(InferenceResult currentResult, String msg, InferenceResult... candidates) throws TypeValidationException {
		if (currentResult == null)
			return;
		for (InferenceResult type : candidates) {
			if (registry.isSame(currentResult.getType(), type.getType())) {
				msg = msg != null ? msg : String.format(ASSERT_NOT_TYPE, currentResult); 
				throw new TypeValidationException(msg, NOT_TYPE_CODE);
			}
		}
	}

	public boolean assertSame(InferenceResult result1, InferenceResult result2, String msg) throws TypeValidationException {
		if (result1 == null || result2 == null)
			return true;
		if (!registry.isSame(result1.getType(), result2.getType())) {
			msg = msg != null ? msg : String.format(ASSERT_SAME, result1, result2);
			throw new TypeValidationException(msg, NOT_SAME_CODE);
		}

		return assertTypeBindingsSame(result1, result2, msg);
	}

	public void assertCompatible(InferenceResult result1, InferenceResult result2, String msg) throws TypeValidationException {
		if (result1 == null || result2 == null)
			return;
		if (isNullOnComplexType(result1, result2) || isNullOnComplexType(result2, result1)) {
			return;
		}
		if (!registry.haveCommonType(result1.getType(), result2.getType())) {
			msg = msg != null ? msg : String.format(ASSERT_COMPATIBLE, result1, result2);
			throw new TypeValidationException(msg, NOT_COMPATIBLE_CODE);
		}
		assertTypeBindingsSame(result1, result2, msg);

	}

	public void assertAssignable(InferenceResult varResult, InferenceResult valueResult, String msg) throws TypeValidationException {
		if (varResult == null || valueResult == null)
			return;
		if (isNullOnComplexType(varResult, valueResult)) {
			return;
		}
		if (!registry.isSuperType(valueResult.getType(), varResult.getType())) {
			msg = msg != null ? msg : String.format(ASSERT_COMPATIBLE, varResult, valueResult);
			throw new TypeValidationException(msg, NOT_COMPATIBLE_CODE);
		}
		assertTypeBindingsSame(varResult, valueResult, msg);
	}

	public boolean assertTypeBindingsSame(InferenceResult result1, InferenceResult result2, String msg) throws TypeValidationException {
		List<InferenceResult> bindings1 = result1.getBindings();
		List<InferenceResult> bindings2 = result2.getBindings();
		String errorMsg = msg != null ? msg : String.format(ASSERT_COMPATIBLE, result1, result2);
		if (bindings1.size() != bindings2.size()) {
			throw new TypeValidationException(errorMsg, NOT_COMPATIBLE_CODE);
		}
		for (int i = 0; i < bindings1.size(); i++) {
			if (!assertSame(bindings1.get(i), bindings2.get(i), errorMsg)) {
				return false;
			};
		}
		return true;
	}

	public void assertIsSubType(InferenceResult subResult, InferenceResult superResult, String msg) throws TypeValidationException {
		if (subResult == null || superResult == null)
			return;
		if (!registry.isSuperType(subResult.getType(), superResult.getType())) {
			String msg2 = msg != null ? msg : String.format(ASSERT_COMPATIBLE, subResult, superResult);
			throw new TypeValidationException(msg2, NOT_COMPATIBLE_CODE);
		}
	}
	
	public boolean isNullOnComplexType(InferenceResult result1, InferenceResult result2) {
		return result1.getType() instanceof ComplexType
				&& registry.isSame(result2.getType(), registry.getType(ITypeSystem.NULL));
	}
}
