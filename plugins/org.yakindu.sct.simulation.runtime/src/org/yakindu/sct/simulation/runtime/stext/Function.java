/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.simulation.runtime.stext;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.yakindu.sct.simulation.runtime.EvaluationException;

/**
 * 
 * @author axel terfloth
 * @author andreas muelder
 * 
 */
public class Function {
	/**
	 * Sorts a {@link Collection} of {@link Method} . The most specialized
	 * parameter types are put first.
	 * 
	 * @author muelder
	 * 
	 */
	public static class PolymorphicComparator implements Comparator<Method> {

		public int compare(Method method1, Method method2) {
			Class<?>[] parameterTypes1 = method1.getParameterTypes();
			Class<?>[] parameterTypes2 = method2.getParameterTypes();

			if (parameterTypes1.length != parameterTypes2.length)
				return -1;

			for (int i = 0; i < parameterTypes1.length; i++) {
				final Class<?> class1 = parameterTypes1[i];
				final Class<?> class2 = parameterTypes2[i];
				if (class1.equals(class2))
					continue;
				if (class1.isAssignableFrom(class2)
						|| Void.class.equals(class2)) {
					return 1;
				}
				if (class2.isAssignableFrom(class1)
						|| Void.class.equals(class1)) {
					return -1;
				}
			}
			return 0;
		}
	}

	protected Method functionMethod;

	/**
	 * Looks up the appropriate function for the given parameter types. This
	 * lookup currently does not perform a polymophic lookup.
	 * 
	 * @param name
	 * @param paramTypes
	 * @return
	 */
	public static Function lookup(Class<?> functionClass, String name,
			Class<?>[] paramTypes) {

		List<Method> functionMethods = getFunctionMethods(functionClass);
		for (Method fMethod : functionMethods) {
			FunctionMethod fAnno = fMethod.getAnnotation(FunctionMethod.class);
			if ((name.equals(fMethod.getName())) || name.equals(fAnno.value())) {
				if (isCallable(paramTypes, fMethod.getParameterTypes())) {
					return createFunction(functionClass, fMethod);
				}
			}
		}
		return null;
	}

	private static List<Method> getFunctionMethods(Class<?> functionClass) {

		List<Method> result = new ArrayList<Method>();
		Method[] methods = functionClass.getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
			Method fMethod = methods[i];
			FunctionMethod fAnno = fMethod.getAnnotation(FunctionMethod.class);
			if (fAnno != null) {
				result.add(fMethod);
			}
		}
		Collections.sort(result, new PolymorphicComparator());
		return result;
	}

	private static boolean isCallable(Class<?>[] paramTypes,
			Class<?>[] parameterTypes) {
		if (paramTypes.length != parameterTypes.length)
			return false;
		for (int i = 0; i < paramTypes.length; i++) {
			Class<?> class1 = paramTypes[i];
			Class<?> class2 = parameterTypes[i];
			if (!class2.isAssignableFrom(class1))
				return false;
		}
		return true;

	}

	public static Function lookup(Class<?> functionClass, String name,
			Object[] params) {
		Class<?>[] paramTypes = new Class<?>[params.length];
		for (int i = 0; i < params.length; i++) {
			paramTypes[i] = params[i].getClass();
		}
		return lookup(functionClass, name, paramTypes);
	}

	protected static Function createFunction(Class<?> functionClass,
			Method functionMethod) {

		if (functionClass == null || functionMethod == null)
			return null;

		try {
			Constructor<?> constr;
			try {
				constr = (Constructor<?>) functionClass
						.getConstructor(new Class<?>[0]);
			} catch (NoSuchMethodException e) {
				throw new ExpressionRuntimeException(
						"Missing default constructor in class "
								+ functionClass.getName()
								+ " while loading function "
								+ functionMethod.getName() + " !");
			}

			Function func = (Function) constr.newInstance(new Object[0]);
			func.setFunctionMethod(functionMethod);
			return func;

		} catch (ExpressionRuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new ExpressionRuntimeException("Error loading function "
					+ functionMethod.getName() + " from function class "
					+ functionClass.getName() + " !", e);
		}
	}

	public Function() {
		super();
	}

	public Method getFunctionMethod() {
		return functionMethod;
	}

	public void setFunctionMethod(Method functionMethod) {
		this.functionMethod = functionMethod;
	}

	public Object execute(Object[] params) {
		try {
			return getFunctionMethod().invoke(this, params);
		} catch (IllegalArgumentException e) {
			throw new EvaluationException(e);
		} catch (IllegalAccessException e) {
			throw new EvaluationException(e);
		} catch (InvocationTargetException e) {
			throw new EvaluationException(e.getCause());
		}
	}

}