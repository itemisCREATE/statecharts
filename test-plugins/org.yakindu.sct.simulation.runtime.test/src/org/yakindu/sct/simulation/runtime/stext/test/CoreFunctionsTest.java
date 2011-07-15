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

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.fail;

import org.junit.Test;
import org.yakindu.sct.simulation.runtime.EvaluationException;
import org.yakindu.sct.simulation.runtime.stext.CoreFunction;
import org.yakindu.sct.simulation.runtime.stext.Function;
/**
 * 
 * @author axel terfloth
 * @author andreas muelder
 *
 */
public class CoreFunctionsTest {

	@Test
	public void testIntPlus() {
		Object params[] = new Object[] { 3, 2 };

		Object result = Function.lookup(CoreFunction.class, "+", params)
				.execute(params);
		assertEquals(5, result);
	}

	@Test
	public void testFloatPlus() {
		Object params[] = new Object[] { 3.0f, 2.0f };

		Object result = Function.lookup(CoreFunction.class, "+", params)
				.execute(params);
		assertEquals(5.0f, result);
	}
	@Test
	public void testIntFloatPlus(){
		Object params[] = new Object[] { 3, 2.0f };

		Object result = Function.lookup(CoreFunction.class, "+", params)
				.execute(params);
		assertEquals(5.0f, result);
	}
	
	@Test
	public void testFloatIntPlus(){
		Object params[] = new Object[] { 3.0f, 2 };

		Object result = Function.lookup(CoreFunction.class, "+", params)
				.execute(params);
		assertEquals(5.0f, result);
	}

	@Test
	public void testIntMin() {
		Object params[] = new Object[] { 3, 2 };

		Object result = Function.lookup(CoreFunction.class, "-", params)
				.execute(params);
		assertEquals(1, result);
	}

	@Test
	public void testFloatMin() {
		Object params[] = new Object[] { 3.0f, 2.0f };

		Object result = Function.lookup(CoreFunction.class, "-", params)
				.execute(params);
		assertEquals(1.0f, result);
	}
	
	@Test
	public void testFloatIntMin() {
		Object params[] = new Object[] { 3.0f, 2 };

		Object result = Function.lookup(CoreFunction.class, "-", params)
				.execute(params);
		assertEquals(1.0f, result);
	}
	
	@Test
	public void testIntFloatMin() {
		Object params[] = new Object[] { 3, 2.0f };

		Object result = Function.lookup(CoreFunction.class, "-", params)
				.execute(params);
		assertEquals(1.0f, result);
	}
	
	@Test
	public void testIntMul() {
		Object params[] = new Object[] { 3, 2 };

		Object result = Function.lookup(CoreFunction.class, "*", params)
				.execute(params);
		assertEquals(6, result);
	}
	

	@Test
	public void testIntMulNegative() {
		Object params[] = new Object[] { -3, -2 };

		Object result = Function.lookup(CoreFunction.class, "*", params)
				.execute(params);
		assertEquals(6, result);
	}

	@Test
	public void testIntMulPositiveNegative() {
		Object params[] = new Object[] { 3, -2 };

		Object result = Function.lookup(CoreFunction.class, "*", params)
				.execute(params);
		assertEquals(-6, result);
	}

	@Test
	public void testFloatMul() {
		Object params[] = new Object[] { 3.0f, 2.0f };

		Object result = Function.lookup(CoreFunction.class, "*", params)
				.execute(params);
		assertEquals(6.0f, result);
	}

	@Test
	public void testFloatMulNegative() {
		Object params[] = new Object[] { -3.0f, -2.0f };

		Object result = Function.lookup(CoreFunction.class, "*", params)
				.execute(params);
		assertEquals(6.0f, result);
	}

	@Test
	public void testFloatMulPositiveNegative() {
		Object params[] = new Object[] { -3.0f, 2.0f };

		Object result = Function.lookup(CoreFunction.class, "*", params)
				.execute(params);
		assertEquals(-6.0f, result);
	}
	
	@Test
	public void testFloatIntMul() {
		Object params[] = new Object[] { 3.0f, 2 };

		Object result = Function.lookup(CoreFunction.class, "*", params)
				.execute(params);
		assertEquals(6.0f, result);
	}
	
	@Test
	public void testIntFloatMul() {
		Object params[] = new Object[] { 3, 2.0f };

		Object result = Function.lookup(CoreFunction.class, "*", params)
				.execute(params);
		assertEquals(6.0f, result);
	}

	@Test
	public void testIntDiv() {
		Object params[] = new Object[] { 6, 2 };

		Object result = Function.lookup(CoreFunction.class, "/", params)
				.execute(params);
		assertEquals(3, result);
	}

	@Test
	public void testIntDivNotPerfect() {
		Object params[] = new Object[] { 7, 2 };

		Object result = Function.lookup(CoreFunction.class, "/", params)
				.execute(params);
		assertEquals(3, result);
	}

	@Test
	public void testIntDivNegative() {
		Object params[] = new Object[] { -6, -2 };

		Object result = Function.lookup(CoreFunction.class, "/", params)
				.execute(params);
		assertEquals(3, result);
	}

	@Test
	public void testIntDivPositiveNegative() {
		Object params[] = new Object[] { 6, -2 };

		Object result = Function.lookup(CoreFunction.class, "/", params)
				.execute(params);
		assertEquals(-3, result);
	}

	@Test
	public void testIntDivByZero() {
		try {
			Object params[] = new Object[] { 3, 0 };

			Object result = Function.lookup(CoreFunction.class, "/", params)
					.execute(params);
			assertEquals(6, result);
			fail("EvaluationException expected");
		} catch (EvaluationException e) {
		}
	}

	@Test
	public void testFloatDiv() {
		Object params[] = new Object[] { 6.0f, 2.0f };

		Object result = Function.lookup(CoreFunction.class, "/", params)
				.execute(params);
		assertEquals(3.0f, result);
	}

	@Test
	public void testFloatDivNotPerfect() {
		Object params[] = new Object[] { 7.0f, 2.0f };

		Object result = Function.lookup(CoreFunction.class, "/", params)
				.execute(params);
		assertEquals(3.5f, result);
	}

	@Test
	public void testFloatDivNegative() {
		Object params[] = new Object[] { -6.0f, -2.0f };

		Object result = Function.lookup(CoreFunction.class, "/", params)
				.execute(params);
		assertEquals(3.0f, result);
	}

	@Test
	public void testFloatDivPositiveNegative() {
		Object params[] = new Object[] { -6.0f, 2.0f };

		Object result = Function.lookup(CoreFunction.class, "/", params)
				.execute(params);
		assertEquals(-3.0f, result);
	}

	@Test
	public void testFloatDivByZero() {
		Object params[] = new Object[] { 6.0f, 0.0f };

		Object result = Function.lookup(CoreFunction.class, "/", params)
				.execute(params);
		assertEquals(Float.POSITIVE_INFINITY, result);
	}
	
	@Test
	public void testFloatIntDiv() {
		Object params[] = new Object[] { 6.0f, 2 };

		Object result = Function.lookup(CoreFunction.class, "/", params)
				.execute(params);
		assertEquals(3.0f, result);
	}
	@Test
	public void testIntFloatDiv() {
		Object params[] = new Object[] { 6, 2.0f };

		Object result = Function.lookup(CoreFunction.class, "/", params)
				.execute(params);
		assertEquals(3.0f, result);
	}
	
	

	@Test
	public void testIntModulo() {
		Object params[] = new Object[] { 42, 2 };

		Object result = Function.lookup(CoreFunction.class, "%", params)
				.execute(params);
		assertEquals(0, result);
	}

	@Test
	public void testIntModuloNotPerfect() {
		Object params[] = new Object[] { 42, 5 };

		Object result = Function.lookup(CoreFunction.class, "%", params)
				.execute(params);
		assertEquals(2, result);
	}

	@Test
	public void testFloatModulo() {
		Object params[] = new Object[] { 42.0f, 2.0f };

		Object result = Function.lookup(CoreFunction.class, "%", params)
				.execute(params);
		assertEquals(0.0f, result);
	}

	@Test
	public void testFloatModuloNotPerfect() {
		Object params[] = new Object[] { 42.0f, 5.0f };

		Object result = Function.lookup(CoreFunction.class, "%", params)
				.execute(params);
		assertEquals(2.0f, result);
	}
	
	@Test
	public void testFloatIntModulo() {
		Object params[] = new Object[] { 42.0f, 2 };

		Object result = Function.lookup(CoreFunction.class, "%", params)
				.execute(params);
		assertEquals(0.0f, result);
	}

	
	@Test
	public void testIntFloatModulo() {
		Object params[] = new Object[] { 42, 2.0f };

		Object result = Function.lookup(CoreFunction.class, "%", params)
				.execute(params);
		assertEquals(0.0f, result);
	}


	@Test
	public void testIntLeft() {
		Object params[] = new Object[] { 42, 2 };

		Object result = Function.lookup(CoreFunction.class, "<<", params)
				.execute(params);
		assertEquals(168, result);
	}

	@Test
	public void testFloatLeft() {
		Object params[] = new Object[] { 42.0f, 2.0f };

		Object result = Function.lookup(CoreFunction.class, "<<", params);
		assertNull(result);
	}

	@Test
	public void testIntRight() {
		Object params[] = new Object[] { 42, 2 };

		Object result = Function.lookup(CoreFunction.class, ">>", params)
				.execute(params);
		assertEquals(10, result);
	}

	@Test
	public void testIntRightNull() {
		Object params[] = new Object[] { 42, 7 };

		Object result = Function.lookup(CoreFunction.class, ">>", params)
				.execute(params);
		assertEquals(0, result);
	}

	@Test
	public void testFloatRight() {
		Object params[] = new Object[] { 42.0f, 2.0f };

		Object result = Function.lookup(CoreFunction.class, "<<", params);
		assertNull(result);
	}

	@Test
	public void testIntAnd() {
		Object params[] = new Object[] { 3, 2 };

		Object result = Function.lookup(CoreFunction.class, "&", params)
				.execute(params);
		assertEquals(2, result);
	}

	@Test
	public void testFloatAnd() {
		Object params[] = new Object[] { 3.0f, 2.0f };

		Object result = Function.lookup(CoreFunction.class, "&", params);
		assertNull(result);
	}

	@Test
	public void testIntOr() {
		Object params[] = new Object[] { 3, 2 };

		Object result = Function.lookup(CoreFunction.class, "|", params)
				.execute(params);
		assertEquals(3, result);
	}

	@Test
	public void testFloatOr() {
		Object params[] = new Object[] { 3.0f, 2.0f };

		Object result = Function.lookup(CoreFunction.class, "|", params);
		assertNull(result);
	}

	@Test
	public void testIntXor() {
		Object params[] = new Object[] { 3, 2 };

		Object result = Function.lookup(CoreFunction.class, "^", params)
				.execute(params);
		assertEquals(1, result);
	}

	@Test
	public void testLongXor() {
		Long l1 = new Long(3);
		Long l2 = new Long(2);
		Long l3 = new Long(1);

		Object params[] = new Object[] { l1, l2 };

		Object result = Function.lookup(CoreFunction.class, "^", params)
				.execute(params);
		assertEquals(l3, result);
	}

	@Test
	public void testFloatXor() {
		Object params[] = new Object[] { 3.0f, 2.0f };

		Object result = Function.lookup(CoreFunction.class, "^", params);
		assertNull(result);
	}

	@Test
	public void testIntEquals() {
		Object params[] = new Object[] { 3, 3 };

		Object result = Function.lookup(CoreFunction.class, "==", params)
				.execute(params);
		assertEquals(true, result);
	}

	@Test
	public void testIntNotEquals() {
		Object params[] = new Object[] { 3, 2 };

		Object result = Function.lookup(CoreFunction.class, "==", params)
				.execute(params);
		assertEquals(false, result);
	}

	@Test
	public void testFloatEquals() {
		Object params[] = new Object[] { 3.0f, 3.0f };

		Object result = Function.lookup(CoreFunction.class, "==", params)
				.execute(params);
		assertEquals(true, result);
	}

	@Test
	public void testFloatNotEquals() {
		Object params[] = new Object[] { 3.0f, 2.0f };

		Object result = Function.lookup(CoreFunction.class, "==", params)
				.execute(params);
		assertEquals(false, result);
	}
	
	@Test
	public void testIntFloatEquals() {
		Object params[] = new Object[] { 3, 3.0f };

		Object result = Function.lookup(CoreFunction.class, "==", params)
				.execute(params);
		assertEquals(true, result);
	}
	
	@Test
	public void testFloatIntEquals() {
		Object params[] = new Object[] { 2.0f, 2 };

		Object result = Function.lookup(CoreFunction.class, "==", params)
				.execute(params);
		assertEquals(true, result);
	}
	
	@Test
	public void testIntFloatNotEquals() {
		Object params[] = new Object[] { 3, 4.0f };

		Object result = Function.lookup(CoreFunction.class, "==", params)
				.execute(params);
		assertEquals(false, result);
	}
	
	@Test
	public void testFloatIntNotEquals() {
		Object params[] = new Object[] { 4.0f, 2 };

		Object result = Function.lookup(CoreFunction.class, "==", params)
				.execute(params);
		assertEquals(false, result);
	}

	@Test
	public void testIntDifferent() {
		Object params[] = new Object[] { 3, 2 };

		Object result = Function.lookup(CoreFunction.class, "!=", params)
				.execute(params);
		assertEquals(true, result);
	}

	@Test
	public void testIntNotDifferent() {
		Object params[] = new Object[] { 3, 3 };

		Object result = Function.lookup(CoreFunction.class, "!=", params)
				.execute(params);
		assertEquals(false, result);
	}

	@Test
	public void testFloatDifferent() {
		Object params[] = new Object[] { 3.0f, 2.0f };

		Object result = Function.lookup(CoreFunction.class, "!=", params)
				.execute(params);
		assertEquals(true, result);
	}

	@Test
	public void testFloatNotDifferent() {
		Object params[] = new Object[] { 3.0f, 3.0f };

		Object result = Function.lookup(CoreFunction.class, "!=", params)
				.execute(params);
		assertEquals(false, result);
	}
	
	@Test
	public void testIntFloatDifferent() {
		Object params[] = new Object[] { 3, 4.0f };

		Object result = Function.lookup(CoreFunction.class, "!=", params)
				.execute(params);
		assertEquals(true, result);
	}
	
	@Test
	public void testFloatIntDifferent() {
		Object params[] = new Object[] { 4.0f, 3 };

		Object result = Function.lookup(CoreFunction.class, "!=", params)
				.execute(params);
		assertEquals(true, result);
	}
	

	@Test
	public void testIntFloatNotDifferent() {
		Object params[] = new Object[] { 3, 3.0f };

		Object result = Function.lookup(CoreFunction.class, "!=", params)
				.execute(params);
		assertEquals(false, result);
	}
	
	@Test
	public void testFloatIntNotDifferent() {
		Object params[] = new Object[] { 3.0f, 3 };

		Object result = Function.lookup(CoreFunction.class, "!=", params)
				.execute(params);
		assertEquals(false, result);
	}

	@Test
	public void testIntBitComplement() {
		Object params[] = new Object[] { 9 };

		Object result = Function.lookup(CoreFunction.class, "~", params)
				.execute(params);
		assertEquals(-10, result);
	}

	@Test
	public void testFloatBitComplement() {
		Object params[] = new Object[] { 9.0f };

		Object result = Function.lookup(CoreFunction.class, "~", params);
		assertNull(result);
	}

	@Test
	public void testNotTrue() {
		Object params[] = new Object[] { true };

		Object result = Function.lookup(CoreFunction.class, "!", params)
				.execute(params);
		assertEquals(false, result);
	}

	@Test
	public void testNotFalse() {
		Object params[] = new Object[] { false };

		Object result = Function.lookup(CoreFunction.class, "!", params)
				.execute(params);
		assertEquals(true, result);
	}
}
