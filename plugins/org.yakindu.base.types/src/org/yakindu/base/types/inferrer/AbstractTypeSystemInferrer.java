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
package org.yakindu.base.types.inferrer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.yakindu.base.types.ComplexType;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.TypeAlias;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.base.types.validation.IValidationIssueAcceptor;
import org.yakindu.base.types.validation.IValidationIssueAcceptor.ListBasedValidationIssueAcceptor;
import org.yakindu.base.types.validation.IValidationIssueAcceptor.ValidationIssue;
import org.yakindu.base.types.validation.IValidationIssueAcceptor.ValidationIssue.Severity;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.inject.Inject;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractTypeSystemInferrer implements ITypeSystemInferrer {

	protected static final String NO_INFER_METHOD = "No infer method for type(s) %s";
	protected static final String ASSERT_IS_TYPE = "Expected one of %s, but was %s.";
	protected static final String ASSERT_NOT_TYPE = "Expected type is not %s.";
	protected static final String ASSERT_SAME = "Expected types %s and %s are same.";
	protected static final String ASSERT_COMPATIBLE = "Incompatible types %s and %s.";

	private static final String METHOD_NAME = "doInfer";

	@Inject
	protected ITypeSystem registry;

	protected IValidationIssueAcceptor acceptor;

	private PolymorphicDispatcher<Object> dispatcher;

	private LoadingCache<EObject, InferenceResult> typeCache;

	public AbstractTypeSystemInferrer() {
		initDispatcher();
	}

	protected InferenceResult getResultFor(String name) {
		return InferenceResult.from(registry.getType(name));
	}

	protected InferenceResult getCommonType(InferenceResult result1, InferenceResult result2) {
		return InferenceResult.from(registry.getCommonType(result1.getType(), result2.getType()));
	}

	@Override
	public final InferenceResult infer(EObject object) {
		return infer(object, null);
	}

	@Override
	public final InferenceResult infer(EObject object, IValidationIssueAcceptor acceptor) {
		initTypeCache();
		this.acceptor = (acceptor != null ? acceptor : new ListBasedValidationIssueAcceptor());
		InferenceResult result = inferTypeDispatch(object);
		typeCache.invalidateAll();
		return result;
	}

	protected InferenceResult inferTypeDispatch(EObject object) {
		if (object == null || object.eIsProxy())
			return null;
		try {
			return typeCache.get(object);
		} catch (Exception e) {
			// Ignore invalid expressions and recursions
		}
		return null;
	}

	private void initTypeCache() {
		typeCache = CacheBuilder.newBuilder().maximumSize(100).build(new CacheLoader<EObject, InferenceResult>() {

			public InferenceResult load(EObject key) {
				// TODO: this is not relevant anymore as we do not declare type
				// aliases in type system
				if (key instanceof TypeAlias) {
					// for type aliases we want to infer their base types
					return (InferenceResult) dispatcher.invoke(key);
				}
				if (key instanceof Type) {
					Collection<Type> types = registry.getTypes();
					for (Type type : types) {
						if (registry.isSame((Type) key, type))
							return InferenceResult.from(type);
					}
				}
				return (InferenceResult) dispatcher.invoke(key);
			}
		});
	}

	protected void initDispatcher() {
		dispatcher = new PolymorphicDispatcher<Object>(METHOD_NAME, 1, 1, Collections.singletonList(this),
				new PolymorphicDispatcher.ErrorHandler<Object>() {
					@Override
					public Object handle(Object[] params, Throwable throwable) {
						if (throwable instanceof NoSuchMethodError) {
							warning(String.format(NO_INFER_METHOD, Arrays.toString(params)), NO_INFER_METHOD_CODE);
						} else {
							error(throwable.getMessage(), EXCEPTION_CODE);
						}
						return null;
					}
				});
	}

	protected void assertNotType(InferenceResult currentResult, String msg, InferenceResult... candidates) {
		if (currentResult == null)
			return;
		for (InferenceResult type : candidates) {
			if (registry.isSame(currentResult.getType(), type.getType())) {
				error(msg != null ? msg : String.format(ASSERT_NOT_TYPE, currentResult), NOT_TYPE_CODE);
				return;
			}
		}
	}

	protected boolean assertSame(InferenceResult result1, InferenceResult result2, String msg) {
		if (result1 == null || result2 == null)
			return true;
		String errorMsg = msg != null ? msg : String.format(ASSERT_SAME, result1, result2);
		if (!registry.isSame(result1.getType(), result2.getType())) {
			error(errorMsg, NOT_SAME_CODE);
			return false;
		}

		return assertTypeBindingsSame(result1, result2, errorMsg);
	}

	protected void assertCompatible(InferenceResult result1, InferenceResult result2, String msg) {
		if (result1 == null || result2 == null)
			return;
		if (isNullOnComplexType(result1, result2) || isNullOnComplexType(result2, result1)) {
			return;
		}
		String errorMsg = msg != null ? msg : String.format(ASSERT_COMPATIBLE, result1, result2);
		if (!registry.haveCommonType(result1.getType(), result2.getType())) {
			error(errorMsg, NOT_COMPATIBLE_CODE);
			return;
		}
		assertTypeBindingsSame(result1, result2, errorMsg);

	}

	protected void assertAssignable(InferenceResult varResult, InferenceResult valueResult, String msg) {
		if (varResult == null || valueResult == null)
			return;
		if (isNullOnComplexType(varResult, valueResult)) {
			return;
		}
		if (!registry.isSuperType(valueResult.getType(), varResult.getType())) {
			error(msg != null ? msg : String.format(ASSERT_COMPATIBLE, varResult, valueResult), NOT_COMPATIBLE_CODE);
			return;
		}
		assertTypeBindingsSame(varResult, valueResult, msg);
	}

	protected boolean assertTypeBindingsSame(InferenceResult result1, InferenceResult result2, String msg) {
		List<InferenceResult> bindings1 = result1.getBindings();
		List<InferenceResult> bindings2 = result2.getBindings();
		String errorMsg = msg != null ? msg : String.format(ASSERT_COMPATIBLE, result1, result2);
		if (bindings1.size() != bindings2.size()) {
			error(errorMsg, NOT_COMPATIBLE_CODE);
			return false;
		}
		for (int i = 0; i < bindings1.size(); i++) {
			if (!assertSame(bindings1.get(i), bindings2.get(i), errorMsg)) {
				return false;
			};
		}
		return true;
	}

	protected void assertIsSubType(InferenceResult subResult, InferenceResult superResult, String msg) {
		if (subResult == null || superResult == null)
			return;
		if (!registry.isSuperType(subResult.getType(), superResult.getType())) {
			String msg2 = msg != null ? msg : String.format(ASSERT_COMPATIBLE, subResult, superResult);
			error(msg2, NOT_COMPATIBLE_CODE);
		}
	}
	
	protected boolean isNullOnComplexType(InferenceResult result1, InferenceResult result2) {
		return result1.getType() instanceof ComplexType
				&& registry.isSame(result2.getType(), registry.getType(ITypeSystem.NULL));
	}

	protected void info(String msg, String issueCode) {
		acceptor.accept(new ValidationIssue(Severity.INFO, msg, issueCode));
	}

	protected void warning(String msg, String issueCode) {
		acceptor.accept(new ValidationIssue(Severity.WARNING, msg, issueCode));
	}

	protected void error(String msg, String issueCode) {
		acceptor.accept(new ValidationIssue(Severity.ERROR, msg, issueCode));
	}
}
