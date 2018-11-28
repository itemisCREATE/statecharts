/**
 * Copyright (c) 2015 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 *
 */
package org.yakindu.base.types.validation;

import static org.yakindu.base.types.inferrer.AbstractTypeSystemInferrer.ASSERT_COMPATIBLE;
import static org.yakindu.base.types.inferrer.AbstractTypeSystemInferrer.ASSERT_NOT_TYPE;
import static org.yakindu.base.types.inferrer.AbstractTypeSystemInferrer.ASSERT_SAME;
import static org.yakindu.base.types.inferrer.ITypeSystemInferrer.NOT_COMPATIBLE_CODE;
import static org.yakindu.base.types.inferrer.ITypeSystemInferrer.NOT_SAME_CODE;
import static org.yakindu.base.types.inferrer.ITypeSystemInferrer.NOT_TYPE_CODE;

import java.util.List;

import org.yakindu.base.types.ComplexType;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.inferrer.ITypeSystemInferrer.InferenceResult;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.base.types.validation.IValidationIssueAcceptor.ValidationIssue;
import org.yakindu.base.types.validation.IValidationIssueAcceptor.ValidationIssue.Severity;

import com.google.inject.Inject;

public class TypeValidator {

	@Inject
	protected ITypeSystem registry;

	public void assertNotType(InferenceResult currentResult, String msg, IValidationIssueAcceptor acceptor,
			InferenceResult... candidates) {
		if (currentResult == null)
			return;
		for (InferenceResult type : candidates) {
			if (registry.isSame(currentResult.getType(), type.getType())) {
				msg = msg != null ? msg : String.format(ASSERT_NOT_TYPE, currentResult);
				acceptor.accept(new ValidationIssue(Severity.ERROR, msg, NOT_TYPE_CODE));
			}
		}
	}

	public void assertSame(InferenceResult result1, InferenceResult result2, String msg,
			IValidationIssueAcceptor acceptor) {
		if (result1 == null || result2 == null)
			return;
		if (!registry.isSame(result1.getType(), result2.getType())) {
			msg = msg != null ? msg : String.format(ASSERT_SAME, result1, result2);
			acceptor.accept(new ValidationIssue(Severity.ERROR, msg, NOT_SAME_CODE));
			return;
		}

		assertTypeBindingsSame(result1, result2, msg, acceptor);
	}

	public void assertCompatible(InferenceResult result1, InferenceResult result2, String msg,
			IValidationIssueAcceptor acceptor) {
		if (result1 == null || result2 == null || isNullOnComplexType(result1, result2)
				|| isNullOnComplexType(result2, result1)) {
			return;
		}
		
		if (registry.isConvertableTo(result1.getType(), result2.getType())) {
			return;
		}

		if (!registry.haveCommonType(result1.getType(), result2.getType())) {
			msg = msg != null ? msg : String.format(ASSERT_COMPATIBLE, result1, result2);
			acceptor.accept(new ValidationIssue(Severity.ERROR, msg, NOT_COMPATIBLE_CODE));
			return;
		}
		assertTypeBindingsSame(result1, result2, msg, acceptor);

	}

	public void assertAssignable(InferenceResult varResult, InferenceResult valueResult, String msg,
			IValidationIssueAcceptor acceptor) {
		if (varResult == null || valueResult == null || isNullOnComplexType(varResult, valueResult)) {
			return;
		}

		if (isAnyType(varResult.getType())) {
			return;
		}
		
		if (registry.isConvertableTo(valueResult.getType(), varResult.getType())) {
			return;
		}

		if (!registry.isSuperType(valueResult.getType(), varResult.getType())) {
			msg = msg != null ? msg : String.format(ASSERT_COMPATIBLE, varResult, valueResult);
			acceptor.accept(new ValidationIssue(Severity.ERROR, msg, NOT_COMPATIBLE_CODE));
			return;
		}
		assertTypeBindingsSame(varResult, valueResult, msg, acceptor);
	}

	public void assertTypeBindingsSame(InferenceResult result1, InferenceResult result2, String msg,
			IValidationIssueAcceptor acceptor) {
		List<InferenceResult> bindings1 = result1.getBindings();
		List<InferenceResult> bindings2 = result2.getBindings();
		msg = msg != null ? msg : String.format(ASSERT_COMPATIBLE, result1, result2);
		if (bindings1.size() != bindings2.size()) {
			acceptor.accept(new ValidationIssue(Severity.ERROR, msg, NOT_COMPATIBLE_CODE));
			return;
		}
		for (int i = 0; i < bindings1.size(); i++) {
			assertSame(bindings1.get(i), bindings2.get(i), msg, acceptor);
		}
	}

	public void assertIsSubType(InferenceResult subResult, InferenceResult superResult, String msg,
			IValidationIssueAcceptor acceptor) {
		if (subResult == null || superResult == null)
			return;
		
		if (registry.isConvertableTo(subResult.getType(), superResult.getType())) {
			return;
		}
		
		if (!registry.isSuperType(subResult.getType(), superResult.getType())) {
			msg = msg != null ? msg : String.format(ASSERT_COMPATIBLE, subResult, superResult);
			acceptor.accept(new ValidationIssue(Severity.ERROR, msg, NOT_COMPATIBLE_CODE));
		}
	}

	public boolean isNullOnComplexType(InferenceResult result1, InferenceResult result2) {
		return result1.getType() instanceof ComplexType
				&& isNull(result2);
	}

	protected boolean isNull(InferenceResult result) {
		return registry.isSame(result.getType(), registry.getType(ITypeSystem.NULL));
	}

	protected boolean isAnyType(Type type) {
		return registry.isSame(type, registry.getType(ITypeSystem.ANY));
	}
}
