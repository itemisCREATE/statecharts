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
import java.util.Arrays;

import org.yakindu.sct.simulation.runtime.EvaluationException;

public class Function {

	protected Method functionMethod;

	/**
	 * Looks up the appropriate function for the given parameter types. This lookup currently does not perform a polymophic lookup.
	 * 
	 * @param name
	 * @param paramTypes
	 * @return
	 */
	public static Function lookup(Class<?> functionClass, String name, Class<?>[] paramTypes) {
		Method[] methods = functionClass.getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
			Method fMethod = methods[i];
			FunctionMethod fAnno = fMethod.getAnnotation(FunctionMethod.class);
			if (fAnno != null) {
				if ((name.equals(fMethod.getName())) || name.equals(fAnno.value())) {
					if (Arrays.equals(paramTypes, fMethod.getParameterTypes())) {						
						return createFunction(functionClass, fMethod);
					}
				}
			}
		}
		
		return null;
	}

	
	public static Function lookup(Class<?> functionClass, String name, Object[] params) {
		Class<?>[] paramTypes = new Class<?>[params.length];
		for (int i = 0; i < params.length; i++) {
			paramTypes[i] = params[i].getClass();
		}
		return lookup(functionClass, name, paramTypes);
	}


	protected static Function createFunction(Class<?> functionClass, Method functionMethod) {

		if ( functionClass == null || functionMethod == null ) return null;
		
		try {
			Constructor<?> constr;
			try {
				constr = (Constructor<?>) functionClass.getConstructor(new Class<?>[0]);
			} catch (NoSuchMethodException e) {
				throw new ExpressionRuntimeException("Missing default constructor in class " + functionClass.getName() + " while loading function " + functionMethod.getName() + " !");
			}

			Function func = (Function) constr.newInstance(new Object[0]);
			func.setFunctionMethod(functionMethod);
			return func;

		} catch (ExpressionRuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new ExpressionRuntimeException("Error loading function " + functionMethod.getName() + " from function class " + functionClass.getName() + " !", e);
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