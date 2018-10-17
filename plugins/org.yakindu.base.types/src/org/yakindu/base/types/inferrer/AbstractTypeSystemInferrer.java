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

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource.CyclicLinkingException;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.TypeAlias;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.base.types.validation.IValidationIssueAcceptor;
import org.yakindu.base.types.validation.IValidationIssueAcceptor.ListBasedValidationIssueAcceptor;
import org.yakindu.base.types.validation.IValidationIssueAcceptor.ValidationIssue;
import org.yakindu.base.types.validation.IValidationIssueAcceptor.ValidationIssue.Severity;
import org.yakindu.base.types.validation.TypeValidator;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractTypeSystemInferrer implements ITypeSystemInferrer {

	protected static final String NO_INFER_METHOD = "No infer method for type(s) %s";
	protected static final String ASSERT_IS_TYPE = "Expected one of %s, but was %s.";
	public static final String ASSERT_NOT_TYPE = "Expected type is not %s.";
	public static final String ASSERT_SAME = "Expected types %s and %s are same.";
	public static final String ASSERT_COMPATIBLE = "Incompatible types %s and %s.";

	private static final String METHOD_NAME = "doInfer";

	@Inject
	protected ITypeSystem registry;

	@Inject
	TypeValidator typeValidator;

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
		inferring.clear();
		return result;
	}
	
	protected Set<EObject> inferring = Sets.newHashSet();

	protected InferenceResult inferTypeDispatch(EObject object) {
		if (object == null || object.eIsProxy() || inferring.contains(object))
			return null;
		try {
			inferring.add(object);
			return typeCache.get(object);
		} catch (Exception e) {
			// Ignore invalid expressions and recursions
		} catch (Error err) {
			// rethrow CyclicLinkingException to avoid error dialogs popping up
			CyclicLinkingException cle = unwrapCyclicLinkingException(err);
			if (cle != null) {
				throw cle;
			}
		} finally {
			inferring.remove(object);
		}
		return null;
	}
	
	protected CyclicLinkingException unwrapCyclicLinkingException(Error err) {
		Throwable cause = err.getCause();
		while (cause != null) {
			if (cause instanceof CyclicLinkingException) {
				return (CyclicLinkingException) cause;
			}
			cause = cause.getCause();
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

	public void initDispatcher(List<ITypeSystemInferrer> targets) {
		dispatcher = new PolymorphicDispatcher<Object>(METHOD_NAME, 1, 1, targets,
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

	protected void initDispatcher() {
		initDispatcher(Collections.singletonList(this));
	}

	protected void assertNotType(InferenceResult currentResult, String msg, InferenceResult... candidates) {
		typeValidator.assertNotType(currentResult, msg, acceptor, candidates);
	}

	protected void assertSame(InferenceResult result1, InferenceResult result2, String msg) {
		typeValidator.assertSame(result1, result2, msg, acceptor);
	}

	protected void assertCompatible(InferenceResult result1, InferenceResult result2, String msg) {
		typeValidator.assertCompatible(result1, result2, msg, acceptor);
	}

	protected void assertAssignable(InferenceResult varResult, InferenceResult valueResult, String msg) {
		typeValidator.assertAssignable(varResult, valueResult, msg, acceptor);
	}

	protected void assertTypeBindingsSame(InferenceResult result1, InferenceResult result2, String msg) {
		typeValidator.assertTypeBindingsSame(result1, result2, msg, acceptor);
	}

	protected void assertIsSubType(InferenceResult subResult, InferenceResult superResult, String msg) {
		typeValidator.assertIsSubType(subResult, superResult, msg, acceptor);
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
