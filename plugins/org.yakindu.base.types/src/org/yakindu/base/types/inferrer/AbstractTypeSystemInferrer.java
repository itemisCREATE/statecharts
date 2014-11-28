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
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.inferrer.ITypeSystemInferrer.ITypeTraceAcceptor.TypeTrace;
import org.yakindu.base.types.inferrer.ITypeSystemInferrer.ITypeTraceAcceptor.TypeTrace.Severity;
import org.yakindu.base.types.typesystem.ITypeSystem;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.inject.Inject;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractTypeSystemInferrer implements ITypeSystemInferrer {

	private static final String METHOD_NAME = "infer";

	@Inject
	private ITypeSystem typeSystem;

	private ITypeTraceAcceptor acceptor;

	private PolymorphicDispatcher<Object> dispatcher;

	private LoadingCache<EObject, Type> typeCache;

	public AbstractTypeSystemInferrer() {
		initDispatcher();
		initTypeCache();
	}

	protected Type getType(String name) {
		return typeSystem.getType(name);
	}

	protected Type getCommonType(EObject object1, EObject object2) {
		return typeSystem.getCommonType(inferTypeDispatch(object1), inferTypeDispatch(object2));
	}

	@Override
	public final Type inferType(EObject object, ITypeTraceAcceptor acceptor) {
		this.acceptor = (acceptor != null ? acceptor : new ListBasedTypeTraceAcceptor());
		info("infering type for object " + object);
		Type result = inferTypeDispatch(object);
		typeCache.invalidateAll();
		return result;
	}

	protected Type inferTypeDispatch(EObject object) {
		try {
			return typeCache.get(object);
		} catch (IllegalStateException e) {
			// Detection of recursive loads
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void initTypeCache() {
		typeCache = CacheBuilder.newBuilder().maximumSize(1000).build(new CacheLoader<EObject, Type>() {
			public Type load(EObject key) {
				Collection<Type> types = typeSystem.getTypes();
				for (Type type : types) {
					if (key instanceof Type && typeSystem.isSame((Type) key, type))
						return type;
				}
				return (Type) (EObject) dispatcher.invoke(key);
			}
		});
	}

	protected void initDispatcher() {
		dispatcher = new PolymorphicDispatcher<Object>(METHOD_NAME, 1, 1, Collections.singletonList(this),
				new PolymorphicDispatcher.ErrorHandler<Object>() {
					@Override
					public Object handle(Object[] params, Throwable throwable) {
						if (throwable instanceof NoSuchMethodError) {
							warning("No infer method for type " + Arrays.toString(params));
						} else {
							error(throwable.getMessage());
						}
						return null;
					}
				});
	}

	protected void assertType(Type type1, String msg, Type... types) {
		boolean same = false;
		for (Type type : types) {
			if (typeSystem.isSame(type1, type)) {
				same = true;
			}
		}
		if (!same) {
			error(msg != null ? msg : "Expected one of " + Arrays.toString(types) + " but was " + type1);
		}
	}

	protected void assertSame(Type type1, Type type2, String msg) {
		if (!typeSystem.isSame(type1, type2)) {
			error(msg != null ? msg : "Types not the same : " + type1 + " and " + type2);
		}
	}

	protected void assertCompatibleType(Type type1, Type type2, String msg) {
		if (!typeSystem.haveCommonType(type1, type2)) {
			error(msg != null ? msg : "Incompatible types " + type1 + " and " + type2);
		}
	}

	protected void assertIsSuperType(Type subType, Type superType, String msg) {
		if (!typeSystem.isSuperType(subType, superType)) {
			error(msg != null ? msg : "Incompatible types " + subType + " and " + superType);
		}
	}

	protected void info(String msg) {
		acceptor.accept(new TypeTrace(Severity.INFO, msg));
	}

	protected void warning(String msg) {
		acceptor.accept(new TypeTrace(Severity.WARNING, msg));
	}

	protected void error(String msg) {
		acceptor.accept(new TypeTrace(Severity.ERROR, msg));
	}
}
