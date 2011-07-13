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
package org.yakindu.sct.simulation.runtime.stext.test;

import java.math.BigDecimal;

import junit.framework.TestCase;

import org.yakindu.sct.simulation.runtime.EvaluationException;
import org.yakindu.sct.simulation.runtime.stext.ExpressionRuntimeException;
import org.yakindu.sct.simulation.runtime.stext.Function;
import org.yakindu.sct.simulation.runtime.stext.FunctionMethod;


/**
 * TODO: Negativ-Tests
 * 
 * @author aterfloth
 *
 */
public class FunctionsTest extends TestCase {
	

	public static class TestFunction extends Function {
		
		@FunctionMethod("?")
		public Integer test(Integer i1, Integer i2) {
			return i1 + 2 * i2;
		}
		
		@FunctionMethod("+")
		public float add(float f1, float f2) {
			return f1 + f2;
		}
		
		@FunctionMethod("fail")
		public int fail() {
			throw new RuntimeException();
		}
	}
	
	
	
	public void testLookupByMethodNameAndParamTypes() {
		
		Class<?> params[] = new Class<?>[]{Integer.class, Integer.class};
		
		Function function = Function.lookup(TestFunction.class, "test", params);
		assertNotNull(function);
	}

	
	public void testLookupByFunctionNameAndParamTypes() {
		
		Class<?> params[] = new Class<?>[]{Integer.class, Integer.class};
		
		Function function = Function.lookup(TestFunction.class, "?", params);
		assertNotNull(function);
	}

	
	public void testLookupByFunctionNameAndParamValues() {
		
		Object params[] = new Object[]{1, 2};
		
		Function function = Function.lookup(TestFunction.class, "?", params);
		assertNotNull(function);
	}

	
	public void testLookupNonMatchingMethodName() {
		
		Class<?> params[] = new Class<?>[]{Integer.class, Integer.class};
		
		Function function = Function.lookup(TestFunction.class, "blabla", params);
		assertNull(function);
	}

	
	public void testLookupNonParamTypes() {
		
		Class<?> params[] = new Class<?>[]{BigDecimal.class, BigDecimal.class};
		
		Function function = Function.lookup(TestFunction.class,  "test", params);
		assertNull(function);
	}

	
	public void testPrimitiveTypes() {
		
		Class<?> paramTypes[] = new Class<?>[]{Float.TYPE, Float.TYPE};
		
		assertNotNull( Function.lookup(TestFunction.class, "+", paramTypes) );
	}

	
	public void testExecuteFunction() {
		
		Object params[] = new Object[]{1, 2};
		
		Object result = Function.lookup(TestFunction.class, "?", params).execute(params);
		assertEquals(5, result);
	}

	
	public void testExecutePrimitiveTypeFunction() {
		
		Object params[] = new Object[]{1.1f, 2.0f};
		Class<?> paramTypes[] = new Class<?>[]{Float.TYPE, Float.TYPE};
		
		Object result = Function.lookup(TestFunction.class, "+", paramTypes).execute(params);
		assertEquals(3.1f, result);
	}
	
	
	public void testIllegalArguments() {
		Object params[] = new Object[]{1.1f, true};
		Class<?> paramTypes[] = new Class<?>[]{Float.TYPE, Float.TYPE};
		
		try {
			Function.lookup(TestFunction.class, "+", paramTypes).execute(params);
			fail("expected EvaluationException !");
		} catch (EvaluationException e) {}
	}
	
	public void testTargetException() {
		Object params[] = new Object[]{};
		Class<?> paramTypes[] = new Class<?>[]{};
		
		try {
			Function.lookup(TestFunction.class, "fail", paramTypes).execute(params);
			fail("expected EvaluationException !");
		} catch (EvaluationException e) {}
	}
	
	
	public void testFunctionWithoutDefaultConstructor() {
		Class<?> paramTypes[] = new Class<?>[]{Object.class};
		
		try {
			Function result = Function.lookup(FunctionWithoutDefaultConstructor.class, "foo", paramTypes);
			fail("Expected ExpressionRuntimeException !");
		} catch (ExpressionRuntimeException e) {}
	}
	
	
	public static class FunctionWithoutDefaultConstructor extends Function {
		
		public FunctionWithoutDefaultConstructor(String foo) {};
		
		@FunctionMethod("foo")
		public Object foo(Object obj) { return null; }
	}
	

	public void testFailingFunctionConstructor() {
		Class<?> paramTypes[] = new Class<?>[]{Object.class};
		
		try {
			Function result = Function.lookup(FunctionWithFailingConstructor.class, "foo", paramTypes);
			fail("Expected ExpressionRuntimeException !");
		} catch (ExpressionRuntimeException e) {}
	}
	
	
	public static class FunctionWithFailingConstructor extends Function {
		
		private FunctionWithFailingConstructor() {
			super();
			throw new RuntimeException("test...");
		}

		@FunctionMethod("foo")
		public Object foo(Object obj) { return null; }
	}

}
