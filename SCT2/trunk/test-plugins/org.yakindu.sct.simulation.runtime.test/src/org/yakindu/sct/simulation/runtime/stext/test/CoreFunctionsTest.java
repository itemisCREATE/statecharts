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


import junit.framework.TestCase;

import org.yakindu.sct.simulation.runtime.stext.CoreFunction;
import org.yakindu.sct.simulation.runtime.EvaluationException;
import org.yakindu.sct.simulation.runtime.stext.Function;

public class CoreFunctionsTest extends TestCase {
	
	public void testIntPlus() {
		Object params[] = new Object[]{3, 2};
		
		Object result = Function.lookup(CoreFunction.class, "+", params).execute(params);
		assertEquals(5, result);
	}
	
	public void testFloatPlus() {
		Object params[] = new Object[]{3.0f, 2.0f};
		
		Object result = Function.lookup(CoreFunction.class, "+", params).execute(params);
		assertEquals(5.0f, result);
	}
	
	public void testIntMin() {
		Object params[] = new Object[]{3, 2};
		
		Object result = Function.lookup(CoreFunction.class, "-", params).execute(params);
		assertEquals(1, result);
	}
	
	public void testFloatMin() {
		Object params[] = new Object[]{3.0f, 2.0f};
		
		Object result = Function.lookup(CoreFunction.class, "-", params).execute(params);
		assertEquals(1.0f, result);
	}
	
	public void testIntMul() {
		Object params[] = new Object[]{3, 2};
		
		Object result = Function.lookup(CoreFunction.class, "*", params).execute(params);
		assertEquals(6, result);
	}
	
	public void testIntMulNegative() {
		Object params[] = new Object[]{-3, -2};
		
		Object result = Function.lookup(CoreFunction.class, "*", params).execute(params);
		assertEquals(6, result);
	}
	
	public void testIntMulPositiveNegative() {
		Object params[] = new Object[]{3, -2};
		
		Object result = Function.lookup(CoreFunction.class, "*", params).execute(params);
		assertEquals(-6, result);
	}
	
	public void testFloatMul() {
		Object params[] = new Object[]{3.0f, 2.0f};
		
		Object result = Function.lookup(CoreFunction.class, "*", params).execute(params);
		assertEquals(6.0f, result);
	}
	
	public void testFloatMulNegative() {
		Object params[] = new Object[]{-3.0f, -2.0f};
		
		Object result = Function.lookup(CoreFunction.class, "*", params).execute(params);
		assertEquals(6.0f, result);
	}
	
	public void testFloatMulPositiveNegative() {
		Object params[] = new Object[]{-3.0f, 2.0f};
		
		Object result = Function.lookup(CoreFunction.class, "*", params).execute(params);
		assertEquals(-6.0f, result);
	}
	
	public void testIntDiv() {
		Object params[] = new Object[]{6, 2};
		
		Object result = Function.lookup(CoreFunction.class, "/", params).execute(params);
		assertEquals(3, result);
	}
	
	public void testIntDivNotPerfect() {
		Object params[] = new Object[]{7, 2};
		
		Object result = Function.lookup(CoreFunction.class, "/", params).execute(params);
		assertEquals(3, result);
	}
	
	public void testIntDivNegative() {
		Object params[] = new Object[]{-6, -2};
		
		Object result = Function.lookup(CoreFunction.class, "/", params).execute(params);
		assertEquals(3, result);
	}
	
	public void testIntDivPositiveNegative() {
		Object params[] = new Object[]{6, -2};
		
		Object result = Function.lookup(CoreFunction.class, "/", params).execute(params);
		assertEquals(-3, result);
	}
		
	public void testIntDivByZero() {
		try {
			Object params[] = new Object[]{3, 0};
		
			Object result = Function.lookup(CoreFunction.class, "/", params).execute(params);
			assertEquals(6, result);
			fail("EvaluationException expected");
		} catch (EvaluationException e) {}
	}
	
	public void testFloatDiv() {
		Object params[] = new Object[]{6.0f, 2.0f};
		
		Object result = Function.lookup(CoreFunction.class, "/", params).execute(params);
		assertEquals(3.0f, result);
	}
	
	public void testFloatDivNotPerfect() {
		Object params[] = new Object[]{7.0f, 2.0f};
		
		Object result = Function.lookup(CoreFunction.class, "/", params).execute(params);
		assertEquals(3.5f, result);
	}
	
	public void testFloatDivNegative() {
		Object params[] = new Object[]{-6.0f, -2.0f};
		
		Object result = Function.lookup(CoreFunction.class, "/", params).execute(params);
		assertEquals(3.0f, result);
	}
	
	public void testFloatDivPositiveNegative() {
		Object params[] = new Object[]{-6.0f, 2.0f};
		
		Object result = Function.lookup(CoreFunction.class, "/", params).execute(params);
		assertEquals(-3.0f, result);
	}
	
	public void testFloatDivByZero() {
		Object params[] = new Object[]{6.0f, 0.0f};
		
		Object result = Function.lookup(CoreFunction.class, "/", params).execute(params);
		assertEquals(Float.POSITIVE_INFINITY, result);
	}
	
	public void testIntModulo() {
		Object params[] = new Object[]{42, 2};
		
		Object result = Function.lookup(CoreFunction.class, "%", params).execute(params);
		assertEquals(0, result);
	}
	
	public void testIntModuloNotPerfect() {
		Object params[] = new Object[]{42, 5};
		
		Object result = Function.lookup(CoreFunction.class, "%", params).execute(params);
		assertEquals(2, result);
	}
	
	public void testFloatModulo() {
		Object params[] = new Object[]{42.0f, 2.0f};
		
		Object result = Function.lookup(CoreFunction.class, "%", params).execute(params);
		assertEquals(0.0f, result);
	}
	
	public void testFloatModuloNotPerfect() {
		Object params[] = new Object[]{42.0f, 5.0f};
		
		Object result = Function.lookup(CoreFunction.class, "%", params).execute(params);
		assertEquals(2.0f, result);
	}
	
	
	public void testIntLeft() {
		Object params[] = new Object[]{42, 2};
		
		Object result = Function.lookup(CoreFunction.class, "<<", params).execute(params);
		assertEquals(168, result);
	}
	
	public void testFloatLeft() {
		Object params[] = new Object[]{42.0f, 2.0f};
		
		Object result = Function.lookup(CoreFunction.class, "<<", params);
		assertNull(result);			
	}
	
	public void testIntRight() {
		Object params[] = new Object[]{42, 2};
		
		Object result = Function.lookup(CoreFunction.class, ">>", params).execute(params);
		assertEquals(10, result);
	}
	
	public void testIntRightNull() {
		Object params[] = new Object[]{42, 7};
		
		Object result = Function.lookup(CoreFunction.class, ">>", params).execute(params);
		assertEquals(0, result);
	}
	
	public void testFloatRight() {
		Object params[] = new Object[]{42.0f, 2.0f};
		
		Object result = Function.lookup(CoreFunction.class, "<<", params);
		assertNull(result);			
	}
	
	public void testIntAnd() {
		Object params[] = new Object[]{3, 2};
		
		Object result = Function.lookup(CoreFunction.class, "&", params).execute(params);
		assertEquals(2, result);
	}
	
	public void testFloatAnd() {
		Object params[] = new Object[]{3.0f, 2.0f};
		
		Object result = Function.lookup(CoreFunction.class, "&", params);
		assertNull(result);
	}
	
	public void testIntOr() {
		Object params[] = new Object[]{3, 2};
		
		Object result = Function.lookup(CoreFunction.class, "|", params).execute(params);
		assertEquals(3, result);
	}
	
	public void testFloatOr() {
		Object params[] = new Object[]{3.0f, 2.0f};
		
		Object result = Function.lookup(CoreFunction.class, "|", params);
		assertNull(result);
	}
	
	public void testIntXor() {
		Object params[] = new Object[]{3, 2};
		
		Object result = Function.lookup(CoreFunction.class, "^", params).execute(params);
		assertEquals(1, result);
	}
	
	public void testLongXor() {
		Long l1 = new Long(3);
		Long l2 = new Long(2);
		Long l3 = new Long(1);
		
		Object params[] = new Object[]{l1, l2};
		
		Object result = Function.lookup(CoreFunction.class, "^", params).execute(params);
		assertEquals(l3, result);
	}
	
	public void testFloatXor() {
		Object params[] = new Object[]{3.0f, 2.0f};
		
		Object result = Function.lookup(CoreFunction.class, "^", params);
		assertNull(result);
	}
	
	public void testIntEquals() {
		Object params[] = new Object[]{3, 3};
		
		Object result = Function.lookup(CoreFunction.class, "==", params).execute(params);
		assertEquals(true, result);
	}
	
	public void testIntNotEquals() {
		Object params[] = new Object[]{3, 2};
		
		Object result = Function.lookup(CoreFunction.class, "==", params).execute(params);
		assertEquals(false, result);
	}
	
	public void testFloatEquals() {
		Object params[] = new Object[]{3.0f, 3.0f};
		
		Object result = Function.lookup(CoreFunction.class, "==", params).execute(params);
		assertEquals(true, result);
	}
	
	public void testFloatNotEquals() {
		Object params[] = new Object[]{3.0f, 2.0f};
		
		Object result = Function.lookup(CoreFunction.class, "==", params).execute(params);
		assertEquals(false, result);
	}
	
	public void testIntDifferent() {
		Object params[] = new Object[]{3, 2};
		
		Object result = Function.lookup(CoreFunction.class, "!=", params).execute(params);
		assertEquals(true, result);
	}
	
	public void testIntNotDifferent() {
		Object params[] = new Object[]{3, 3};
		
		Object result = Function.lookup(CoreFunction.class, "!=", params).execute(params);
		assertEquals(false, result);
	}
	
	public void testFloatDifferent() {
		Object params[] = new Object[]{3.0f, 2.0f};
		
		Object result = Function.lookup(CoreFunction.class, "!=", params).execute(params);
		assertEquals(true, result);
	}
	
	public void testFloatNotDifferent() {
		Object params[] = new Object[]{3.0f, 3.0f};
		
		Object result = Function.lookup(CoreFunction.class, "!=", params).execute(params);
		assertEquals(false, result);
	}
	
	public void testIntBitComplement() {
		Object params[] = new Object[]{9};
		
		Object result = Function.lookup(CoreFunction.class, "~", params).execute(params);
		assertEquals(-10, result);
	}	
	
	public void testFloatBitComplement() {
		Object params[] = new Object[]{9.0f};
		
		Object result = Function.lookup(CoreFunction.class, "~", params);
		assertNull(result);
	}	
	
	public void testNotTrue() {
		Object params[] = new Object[]{true};
		
		Object result = Function.lookup(CoreFunction.class, "!", params).execute(params);
		assertEquals(false, result);
	}
	
	public void testNotFalse() {
		Object params[] = new Object[]{false};
		
		Object result = Function.lookup(CoreFunction.class, "!", params).execute(params);
		assertEquals(true, result);
	}
}
