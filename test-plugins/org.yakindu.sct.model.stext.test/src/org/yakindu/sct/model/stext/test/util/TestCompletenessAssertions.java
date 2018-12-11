/**
 * Copyright (c) 2017 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Johannes Dicks - initial API and implementation
 * 
 */
package org.yakindu.sct.model.stext.test.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.lang.reflect.Method;

import org.eclipse.xtext.validation.Check;
import org.junit.Test;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * 
 * @author Johannes Dicks
 *
 */
public class TestCompletenessAssertions {

	public void assertAllChecksHaveTests(Class<?> validatorClass, Class<?> validatorTestClass) {
		Iterable<Method> methods = Lists.newArrayList(validatorClass.getDeclaredMethods());
		methods = Iterables.filter(methods, new Predicate<Method>() {
			@Override
			public boolean apply(Method input) {
				return input.getAnnotation(Check.class) != null;
			}
		});
		for (Method checkMethod : methods) {
			Method testMethod = null;
			try {
				testMethod = validatorTestClass.getMethod(checkMethod.getName());
			} catch (Exception e) {
				fail("Cannot find test method for " + getSignature(checkMethod, false));
			}
			if (testMethod != null)
				assertNotNull("Missing @Test Annotation for method " + getSignature(checkMethod, false),
						testMethod.getAnnotation(Test.class));
		}
	}

	protected String getSignature(Method method, boolean longTypeNames) {
		return method.getName() + "(" + parametersAsString(method, longTypeNames) + ")";
	}

	protected String parametersAsString(Method method, boolean longTypeNames) {
		Class<?>[] parameterTypes = method.getParameterTypes();
		if (parameterTypes.length == 0)
			return "";
		StringBuilder paramString = new StringBuilder();
		paramString.append(longTypeNames ? parameterTypes[0].getName() : parameterTypes[0].getSimpleName());
		for (int i = 1; i < parameterTypes.length; i++) {
			paramString.append(",")
					.append(longTypeNames ? parameterTypes[i].getName() : parameterTypes[i].getSimpleName());
		}
		return paramString.toString();
	}
}
