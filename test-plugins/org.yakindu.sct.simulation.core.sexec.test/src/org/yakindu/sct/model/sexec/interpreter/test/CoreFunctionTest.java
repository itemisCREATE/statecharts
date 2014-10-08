/**
 * Copyright (c) 2014 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.sexec.interpreter.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.yakindu.sct.simulation.core.sexec.interpreter.CoreFunction;

/**
 * 
 * @author florian antony
 * 
 */
public class CoreFunctionTest {

	private CoreFunction cFunction;
	private double delta = 0.001;

	@Before
	public void setUp() throws Exception {
		cFunction = new CoreFunction();
	}

	@After
	public void tearDown() throws Exception {
		cFunction = null;
	}

	@Test
	public void testPlusIntegerInteger() {
		int expected = 10;
		int actual = cFunction.plus(5, 5);
		assertEquals(expected, actual);
	}

	@Test
	public void testPlusFloatFloat() {
		float expected = 10.6F;
		float actual = cFunction.plus(5.3F, 5.3F);
		assertEquals(expected, actual, delta);

	}

	@Test
	public void testPlusDoubleDouble() {
		double expected = 10.6;
		double actual = cFunction.plus(5.3, 5.3);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testPlusLongLong() {
		long expected = 10;
		long actual = cFunction.plus(5L, 5L);
		assertEquals(expected, actual);
	}

	@Test
	public void testPlusIntegerFloat() {
		float expected = 10.3F;
		float actual = cFunction.plus(5, 5.3F);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testPlusIntegerDouble() {
		double expected = 10.3;
		double actual = cFunction.plus(5, 5.3);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testPlusIntegerLong() {
		long expected = 10;
		long actual = cFunction.plus(5, 5L);
		assertEquals(expected, actual);
	}

	@Test
	public void testPlusFloatInteger() {
		float expected = 10.3F;
		float actual = cFunction.plus(5.3F, 5);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testPlusFloatDouble() {
		double expected = 10.6;
		double actual = cFunction.plus(5.3F, 5.3);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testPlusFloatLong() {
		double expected = 10.3;
		double actual = cFunction.plus(5.3F, 5L);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testPlusDoubleInteger() {
		double expected = 10.6;
		double actual = cFunction.plus(5.6, 5);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testPlusDoubleFloat() {
		double expected = 10.6;
		double actual = cFunction.plus(5.3D, 5.3F);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testPlusDoubleLong() {
		double expected = 10.3;
		double actual = cFunction.plus(5.3, 5L);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testPlusLongInteger() {
		long expected = 10;
		long actual = cFunction.plus(5L, 5);
		assertEquals(expected, actual);
	}

	@Test
	public void testPlusLongFloat() {
		float expected = 10;
		float actual = cFunction.plus(5L, 5.0f);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testPlusLongDouble() {
		double expected = 10;
		double actual = cFunction.plus(5L, 5.0d);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testPositiveInteger() {
		int expected = 10;
		int actual = cFunction.positive(10);
		assertEquals(expected, actual);
	}

	@Test
	public void testPositiveFloat() {
		float expected = 10.3F;
		float actual = cFunction.positive(10.3F);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testPositiveLong() {
		long expected = 10;
		long actual = cFunction.positive(10L);
		assertEquals(expected, actual);
	}

	@Test
	public void testPositiveDouble() {
		double expected = 10.3D;
		double actual = cFunction.positive(10.3D);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testPositiveBoolean() {
		boolean expected = true;
		boolean actual = cFunction.positive(true);
		assertEquals(expected, actual);
	}

	@Test
	public void testPositiveString() {
		String expected = "positive";
		String actual = cFunction.positive("positive");
		assertEquals(expected, actual);
	}

	@Test
	public void testNegativeInteger() {
		int expected = -10;
		int actual = cFunction.negative(10);
		assertEquals(expected, actual);
	}

	@Test
	public void testNegativeFloat() {
		float expected = -10.3F;
		float actual = cFunction.negative(10.3F);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testNegativeDouble() {
		double expected = -10.3;
		double actual = cFunction.negative(10.3);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testNegativeLong() {
		long expected = 10L;
		long actual = cFunction.negative(-10L);
		assertEquals(expected, actual);
	}

	@Test
	public void testMinusIntegerInteger() {
		int expected = 5;
		int actual = cFunction.minus(10, 5);
		assertEquals(expected, actual);
	}

	@Test
	public void testMinusFloatFloat() {
		float expected = 5.3F;
		float actual = cFunction.minus(10.3F, 5.0F);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testMinusDoubleDouble() {
		double expected = 5.3;
		double actual = cFunction.minus(10.6, 5.3);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testMinusLongLong() {
		long expected = 5L;
		long actual = cFunction.minus(10L, 5L);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testMinusIntegerFloat() {
		float expected = 4.7F;
		float actual = cFunction.minus(10, 5.3F);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testMinusIntegerDouble() {
		double expected = 4.7;
		double actual = cFunction.minus(10, 5.3D);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testMinusIntegerLong() {
		long expected = 5L;
		long actual = cFunction.minus(10, 5L);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testMinusFloatInteger() {
		float expected = 5.3F;
		float actual = cFunction.minus(10.3F, 5);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testMinusFloatDouble() {
		double expected = 5.0;
		double actual = cFunction.minus(10.3F, 5.3D);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testMinusFloatLong() {
		float expected = 5.3f;
		float actual = cFunction.minus(10.3f, 5L);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testMinusDoubleInteger() {
		double expected = 5.3;
		double actual = cFunction.minus(10.3, 5);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testMinusDoubleFloat() {
		double expected = 5.0;
		double actual = cFunction.minus(10.3, 5.3F);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testMinusDoubleLong() {
		double expected = 5.3;
		double actual = cFunction.minus(10.3, 5L);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testMinusLongInteger() {
		long expected = 5L;
		long actual = cFunction.minus(10L, 5);
		assertEquals(expected, actual);
	}

	@Test
	public void testMinusLongDouble() {
		double expected = 5L;
		double actual = cFunction.minus(10L, 5.0d);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testMinusLongFloat() {
		float expected = 5L;
		float actual = cFunction.minus(10L, 5.0f);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testMulIntegerInteger() {
		int expected = 25;
		int actual = cFunction.mul(5, 5);
		assertEquals(expected, actual);
	}

	@Test
	public void testMulFloatFloat() {
		float expected = 25.0F;
		float actual = cFunction.mul(5.0F, 5.0F);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testMulDoubleDouble() {
		double expected = 25.0;
		double actual = cFunction.mul(5.0, 5.0);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testMulLongLong() {
		long expected = 25L;
		long actual = cFunction.mul(5L, 5L);
		assertEquals(expected, actual);
	}

	@Test
	public void testMulIntegerFloat() {
		float expected = 25.0F;
		float actual = cFunction.mul(5, 5.0F);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testMulIntegerDouble() {
		double expected = 25.0;
		double actual = cFunction.mul(5, 5.0D);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testMulIntegerLong() {
		long expected = 25L;
		long actual = cFunction.mul(5, 5L);
		assertEquals(expected, actual);
	}

	@Test
	public void testMulFloatInteger() {
		float expected = 25.0F;
		float actual = cFunction.mul(5.0F, 5);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testMulFloatDouble() {
		double expected = 25.0;
		double actual = cFunction.mul(5.0F, 5.0);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testMulFloatLong() {
		double expected = 25.0;
		double actual = cFunction.mul(5.0F, 5L);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testMulDoubleInteger() {
		double expected = 25.0;
		double actual = cFunction.mul(5.0, 5);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testMulDoubleFloat() {
		double expected = 25.0;
		double actual = cFunction.mul(5.0, 5.0F);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testMulDoubleLong() {
		double expected = 25.0;
		double actual = cFunction.mul(5.0, 5L);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testMulLongInteger() {
		long expected = 25L;
		long actual = cFunction.mul(5L, 5);
		assertEquals(expected, actual);
	}

	@Test
	public void testMulLongFloat() {
		float expected = 25f;
		float actual = cFunction.mul(5L, 5.0f);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testMulLongDouble() {
		double expected = 25L;
		double actual = cFunction.mul(5L, 5.0d);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testDivIntegerInteger() {
		int expected = 5;
		int actual = cFunction.div(25, 5);
		assertEquals(expected, actual);
	}

	@Test
	public void testDivFloatFloat() {
		float expected = 5.0F;
		float actual = cFunction.div(25.0F, 5.0F);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testDivDoubleDouble() {
		double expected = 5.0;
		double actual = cFunction.div(25.0, 5.0);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testDivLongLong() {
		long expected = 5L;
		long actual = cFunction.div(25L, 5L);
		assertEquals(expected, actual);
	}

	@Test
	public void testDivIntegerFloat() {
		float expected = 5.0F;
		float actual = cFunction.div(25, 5.0F);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testDivIntegerDouble() {
		double expected = 5.0;
		double actual = cFunction.div(25, 5.0D);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testDivIntegerLong() {
		long expected = 5L;
		long actual = cFunction.div(25, 5L);
		assertEquals(expected, actual);
	}

	@Test
	public void testDivFloatInteger() {
		float expected = 5.0F;
		float actual = cFunction.div(25.0F, 5);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testDivFloatDouble() {
		double expected = 5.0d;
		double actual = cFunction.div(25.0F, 5.0);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testDivFloatLong() {
		float expected = 5.0f;
		float actual = cFunction.div(25.0F, 5L);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testDivDoubleInteger() {
		double expected = 5.0;
		double actual = cFunction.div(25.0, 5);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testDivDoubleFloat() {
		double expected = 5.0;
		double actual = cFunction.div(25.0, 5.0F);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testDivDoubleLong() {
		double expected = 5.0;
		double actual = cFunction.div(25.0, 5L);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testDivLongInteger() {
		long expected = 5L;
		long actual = cFunction.div(25L, 5);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testDivLongFloat() {
		float expected = 5f;
		float actual = cFunction.div(25L, 5.0f);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testDivLongDouble() {
		double expected = 5d;
		double actual = cFunction.div(25L, 5.0D);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testModIntegerInteger() {
		int expected = 0;
		int actual = cFunction.mod(5, 5);
		assertEquals(expected, actual);
	}

	@Test
	public void testModFloatFloat() {
		float expected = 0.0F;
		float actual = cFunction.mod(5.0F, 5.0F);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testModDoubleDouble() {
		double expected = 0.0;
		double actual = cFunction.mod(5.0, 5.0);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testModLongLong() {
		long expected = 0L;
		long actual = cFunction.mod(5L, 5L);
		assertEquals(expected, actual);
	}

	@Test
	public void testModIntegerFloat() {
		float expected = 0.0F;
		float actual = cFunction.mod(5, 5.0F);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testModIntegerDouble() {
		double expected = 0.0;
		double actual = cFunction.mod(5, 5.0);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testModIntegerLong() {
		long expected = 0L;
		long actual = cFunction.mod(5, 5L);
		assertEquals(expected, actual);
	}

	@Test
	public void testModFloatInteger() {
		float expected = 0.0F;
		float actual = cFunction.mod(5.0F, 5);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testModFloatDouble() {
		double expected = 0.0;
		double actual = cFunction.mod(5.0F, 5.0);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testModFloatLong() {
		float expected = 0.2f;
		float actual = cFunction.mod(5.2F, 5L);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testModDoubleInteger() {
		double expected = 0.0;
		double actual = cFunction.mod(5.0, 5);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testModDoubleFloat() {
		double expected = 0.0;
		double actual = cFunction.mod(5.0D, 5.0F);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testModDoubleLong() {
		double expected = 0.0;
		double actual = cFunction.mod(5.0, 5L);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testModLongInteger() {
		long expected = 0L;
		double actual = cFunction.mod(5L, 5);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testModLongFloat() {
		long expected = 0L;
		double actual = cFunction.mod(5L, 5.0f);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testModLongDouble() {
		long expected = 0L;
		double actual = cFunction.mod(5L, 5.0d);
		assertEquals(expected, actual, delta);
	}

	@Test
	public void testLeftIntegerInteger() {
		int expected = 20;
		int actual = cFunction.left(10, 1);
		assertEquals(expected, actual);
	}

	@Test
	public void testLeftLongLong() {
		long expected = 20;
		long actual = cFunction.left(10l, 1l);
		assertEquals(expected, actual);
	}

	@Test
	public void testLeftLongInteger() {
		long expected = 20;
		long actual = cFunction.left(10l, 1);
		assertEquals(expected, actual);
	}

	@Test
	public void testLeftIntegerLong() {
		int expected = 20;
		int actual = cFunction.left(10, 1l);
		assertEquals(expected, actual);
	}

	@Test
	public void testRightLongLong() {
		long expected = 5;
		long actual = cFunction.right(10L, 1L);
		assertEquals(expected, actual);
	}

	@Test
	public void testRightLongInteger() {
		long expected = 5;
		long actual = cFunction.right(10L, 1);
		assertEquals(expected, actual);
	}

	@Test
	public void testRightIntegerLong() {
		int expected = 5;
		int actual = cFunction.right(10, 1L);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testRightIntegerInteger() {
		int expected = 5;
		int actual = cFunction.right(10, 1);
		assertEquals(expected, actual);
	}

	@Test
	public void testBitwiseAnd() {
		int expected = 0;
		int actual = cFunction.bitwiseAnd(5, 2);
		assertEquals(expected, actual);
	}

	@Test
	public void testBitwiseOr() {
		int expected = 7;
		int actual = cFunction.bitwiseOr(5, 2);
		assertEquals(expected, actual);
	}

	@Test
	public void testBitwiseXorIntegerInteger() {
		int expected = 6;
		int actual = cFunction.bitwiseXor(5, 3);
		assertEquals(expected, actual);
	}

	@Test
	public void testBitwiseXorLongLong() {
		long expected = 6L;
		long actual = cFunction.bitwiseXor(5L, 3L);
		assertEquals(expected, actual);
	}

	@Test
	public void testEqualsBooleanBoolean() {
		assertFalse(cFunction.equals(true, false));
		assertTrue(cFunction.equals(true, true));
	}

	@Test
	public void testEqualsObjectObject() {
		Object obj1 = new Object();
		assertTrue(cFunction.equals(obj1, obj1));
		assertFalse(cFunction.equals(obj1, null));
		assertFalse(cFunction.equals(null, obj1));
		assertFalse(cFunction.equals(new Object(), new Object()));
	}

	@Test
	public void testEqualsStringString() {
		String test = "test";
		assertTrue(cFunction.equals(test, "test"));
		assertFalse(cFunction.equals(test, "test2"));
	}

	@Test
	public void testEqualsIntegerInteger() {
		assertTrue(cFunction.equals(1, 1));
		assertFalse(cFunction.equals(1, 2));
	}

	@Test
	public void testEqualsFloatFloat() {
		assertTrue(cFunction.equals(1.3F, 1.3F));
		assertFalse(cFunction.equals(1.31F, 1.3F));
	}

	@Test
	public void testEqualsDoubleDouble() {
		assertTrue(cFunction.equals(1.5, 1.5));
		assertFalse(cFunction.equals(1.3, 1.31));
	}

	@Test
	public void testEqualsLongLong() {
		assertTrue(cFunction.equals(10L, 10L));
		assertFalse(cFunction.equals(11L, 10L));
	}

	@Test
	public void testEqualsIntegerFloat() {
		assertTrue(cFunction.equals(1, 1.0F));
		assertFalse(cFunction.equals(1, 1.1F));
	}

	@Test
	public void testEqualsIntegerDouble() {
		assertTrue(cFunction.equals(1, 1.0));
		assertFalse(cFunction.equals(1, 1.1));
	}

	@Test
	public void testEqualsIntegerLong() {
		assertTrue(cFunction.equals(1, 1L));
		assertFalse(cFunction.equals(1, 2L));
	}

	@Test
	public void testEqualsFloatInteger() {
		assertTrue(cFunction.equals(1.0F, 1));
		assertFalse(cFunction.equals(1.1F, 1));
	}

	@Test
	public void testEqualsLongFloat() {
		assertTrue(cFunction.equals(1L, 1F));
		assertFalse(cFunction.equals(1L, 1.01F));
	}

	@Test
	public void testEqualsLongDouble() {
		assertTrue(cFunction.equals(1L, 1D));
		assertFalse(cFunction.equals(1L, 1.01D));
	}

	@Test
	public void testEqualsFloatDouble() {
		assertTrue(cFunction.equals(1.0F, 1.0));
		assertTrue(cFunction.equals(1.5F, 1.5));
		// Since Java and C are not able to compare
		// float and double values with absolute precision -> 1.3F != 1.3
		assertFalse(cFunction.equals(1.3F, 1.3));
	}

	@Test
	public void testEqualsFloatLong() {
		assertTrue(cFunction.equals(1.0F, 1L));
		// Since Java and C are not able to compare
		// float and double values with absolute precision -> 1.3F != 1.3
		assertFalse(cFunction.equals(1.3F, 1.3));
	}

	@Test
	public void testEqualsDoubleInteger() {
		assertTrue(cFunction.equals(1.0, 1));
		assertFalse(cFunction.equals(1.1, 1));
	}

	@Test
	public void testEqualsDoubleFloat() {
		// Since Java and C are not able to compare
		// float and double values with absolute precision -> 1.3 != 1.3F
		assertFalse(cFunction.equals(1.3, 1.3F));

		assertTrue(cFunction.equals(1.5, 1.5F));
	}

	@Test
	public void testEqualsDoubleLong() {
		assertTrue(cFunction.equals(1.0, 1L));
		assertFalse(cFunction.equals(1.1, 1L));
	}

	@Test
	public void testEqualsLongInteger() {
		assertTrue(cFunction.equals(1L, 1));
		assertFalse(cFunction.equals(1L, 2));
	}

	@Test
	public void testNotEqualsBooleanBoolean() {
		assertTrue(cFunction.notEquals(true, false));
		assertFalse(cFunction.notEquals(true, true));
	}

	@Test
	public void testNotEqualsStringString() {
		assertTrue(cFunction.notEquals("Hans", "Wurst"));
		assertFalse(cFunction.notEquals("Hans", "Hans"));
	}

	@Test
	public void testNotEqualsIntegerInteger() {
		assertTrue(cFunction.notEquals(1, 2));
		assertFalse(cFunction.notEquals(1, 1));
	}

	@Test
	public void testNotEqualsFloatFloat() {
		assertTrue(cFunction.notEquals(1.2F, 1.3F));
		assertFalse(cFunction.notEquals(1.1F, 1.1F));
	}

	@Test
	public void testNotEqualsDoubleDouble() {
		assertTrue(cFunction.notEquals(1.2, 1.3));
		assertFalse(cFunction.notEquals(1.2, 1.2));
	}

	@Test
	public void testNotEqualsLongLong() {
		assertTrue(cFunction.notEquals(1L, 2L));
		assertFalse(cFunction.notEquals(1L, 1L));
	}

	@Test
	public void testNotEqualsIntegerFloat() {
		assertTrue(cFunction.notEquals(1, 1.1F));
		assertFalse(cFunction.notEquals(1, 1.0F));
	}

	@Test
	public void testNotEqualsIntegerDouble() {
		assertTrue(cFunction.notEquals(1, 1.1));
		assertFalse(cFunction.notEquals(1, 1.0));
	}
	
	@Test
	public void testNotEqualsLongFloat() {
		assertTrue(cFunction.notEquals(1L, 1.1F));
		assertFalse(cFunction.notEquals(1L, 1.0F));
	}
	
	@Test
	public void testNotEqualsLongDouble() {
		assertTrue(cFunction.notEquals(1L, 1.1D));
		assertFalse(cFunction.notEquals(1L, 1.0D));
	}

	@Test
	public void testNotEqualsObjectObject() {
		Object obj1 = new Object();
		assertFalse(cFunction.notEquals(obj1, obj1));
		assertTrue(cFunction.notEquals(obj1, null));
		assertTrue(cFunction.notEquals(null, obj1));
		assertTrue(cFunction.notEquals(new Object(), new Object()));
	}

	@Test
	public void testNotEqualsIntegerLong() {
		assertTrue(cFunction.notEquals(1, 2L));
		assertFalse(cFunction.notEquals(1, 1L));
	}

	@Test
	public void testNotEqualsFloatInteger() {
		assertTrue(cFunction.notEquals(1.1F, 1));
		assertFalse(cFunction.notEquals(1.0F, 1));
	}

	@Test
	public void testNotEqualsFloatDouble() {
		assertTrue(cFunction.notEquals(1.01F, 1.02));
		assertFalse(cFunction.notEquals(1.5F, 1.5));
	}

	@Test
	public void testNotEqualsFloatLong() {
		assertFalse(cFunction.notEquals(1.0F, 1L));
		assertTrue(cFunction.notEquals(1.5F, 1L));
	}

	@Test
	public void testNotEqualsDoubleInteger() {
		assertTrue(cFunction.notEquals(1.01, 1));
		assertFalse(cFunction.notEquals(1.0, 1));
	}

	@Test
	public void testNotEqualsDoubleFloat() {
		assertTrue(cFunction.notEquals(1.01, 1.02F));
		assertFalse(cFunction.notEquals(1.5, 1.5F));
	}

	@Test
	public void testNotEqualsDoubleLong() {
		assertTrue(cFunction.notEquals(1.01, 1L));
		assertFalse(cFunction.notEquals(1.0, 1L));
	}

	@Test
	public void testNotEqualsLongInteger() {
		assertTrue(cFunction.notEquals(1L, 2));
		assertFalse(cFunction.notEquals(1L, 1));
	}

	@Test
	public void testGreaterEqualIntegerInteger() {
		assertTrue(cFunction.greaterEqual(1, 1));
		assertTrue(cFunction.greaterEqual(2, 1));
		assertFalse(cFunction.greaterEqual(1, 2));
	}

	@Test
	public void testGreaterEqualFloatFloat() {
		assertTrue(cFunction.greaterEqual(1.0F, 1.0F));
		assertTrue(cFunction.greaterEqual(1.1F, 1F));
		assertFalse(cFunction.greaterEqual(1F, 1.1F));
	}

	@Test
	public void testGreaterEqualDoubleDouble() {
		assertTrue(cFunction.greaterEqual(1.0, 1.0));
		assertTrue(cFunction.greaterEqual(1.1, 1));
		assertFalse(cFunction.greaterEqual(1, 1.1));
	}

	@Test
	public void testGreaterEqualLongLong() {
		assertTrue(cFunction.greaterEqual(1L, 1L));
		assertTrue(cFunction.greaterEqual(2L, 1L));
		assertFalse(cFunction.greaterEqual(1L, 2L));
	}

	@Test
	public void testGreaterEqualIntegerFloat() {
		assertTrue(cFunction.greaterEqual(1, 1.0F));
		assertTrue(cFunction.greaterEqual(2, 1.0F));
		assertFalse(cFunction.greaterEqual(1, 1.1F));
	}

	@Test
	public void testGreaterEqualIntegerDouble() {
		assertTrue(cFunction.greaterEqual(1, 1.0));
		assertTrue(cFunction.greaterEqual(2, 1.0));
		assertFalse(cFunction.greaterEqual(1, 1.1));
	}

	@Test
	public void testGreaterEqualIntegerLong() {
		assertTrue(cFunction.greaterEqual(1, 1L));
		assertTrue(cFunction.greaterEqual(2, 1L));
		assertFalse(cFunction.greaterEqual(1, 2L));
	}

	@Test
	public void testGreaterEqualFloatInteger() {
		assertTrue(cFunction.greaterEqual(1.0F, 1));
		assertTrue(cFunction.greaterEqual(2.0F, 1));
		assertFalse(cFunction.greaterEqual(1.0F, 2));
	}

	@Test
	public void testGreaterEqualFloatDouble() {
		assertTrue(cFunction.greaterEqual(1.0f, 1.0D));
		assertTrue(cFunction.greaterEqual(2.0f, 1.0D));
		assertFalse(cFunction.greaterEqual(1.0f, 1.1D));
	}
	
	@Test
	public void testGreaterEqualFloatLong() {
		assertTrue(cFunction.greaterEqual(1.0f, 1L));
		assertTrue(cFunction.greaterEqual(2.0f, 1L));
		assertFalse(cFunction.greaterEqual(0.9f, 1L));
	}


	@Test
	public void testGreaterEqualDoubleInteger() {
		assertTrue(cFunction.greaterEqual(1.0, 1));
		assertTrue(cFunction.greaterEqual(1.1, 1));
		assertFalse(cFunction.greaterEqual(1, 1.2));
	}

	@Test
	public void testGreaterEqualDoubleFloat() {
		assertTrue(cFunction.greaterEqual(1.0, 1.0F));
		assertTrue(cFunction.greaterEqual(1.1, 1.0F));
		assertFalse(cFunction.greaterEqual(1.0, 1.1F));
	}

	@Test
	public void testGreaterEqualDoubleLong() {
		assertTrue(cFunction.greaterEqual(1.0, 1L));
		assertTrue(cFunction.greaterEqual(1.1, 1L));
		assertFalse(cFunction.greaterEqual(1.9, 2L));
	}

	@Test
	public void testGreaterEqualLongInteger() {
		assertTrue(cFunction.greaterEqual(1L, 1));
		assertTrue(cFunction.greaterEqual(1L, 0));
		assertFalse(cFunction.greaterEqual(1L, 2));
	}
	
	@Test
	public void testGreaterEqualLongFloat() {
		assertTrue(cFunction.greaterEqual(1L, 1.0f));
		assertTrue(cFunction.greaterEqual(1L, 0.0f));
		assertFalse(cFunction.greaterEqual(1L, 2.0f));
	}
	
	@Test
	public void testGreaterEqualLongDouble() {
		assertTrue(cFunction.greaterEqual(1L, 1.0d));
		assertTrue(cFunction.greaterEqual(1L, 0.0d));
		assertFalse(cFunction.greaterEqual(1L, 2.0d));
	}

	@Test
	public void testSmallerEqualIntegerInteger() {
		assertTrue(cFunction.smallerEqual(1, 1));
		assertTrue(cFunction.smallerEqual(1, 2));
		assertFalse(cFunction.smallerEqual(2, 1));
	}

	@Test
	public void testSmallerEqualFloatFloat() {
		assertTrue(cFunction.smallerEqual(1.0F, 1.0F));
		assertTrue(cFunction.smallerEqual(1.0F, 1.1F));
		assertFalse(cFunction.smallerEqual(1.1F, 1.0F));
	}

	@Test
	public void testSmallerEqualDoubleDouble() {
		assertTrue(cFunction.smallerEqual(1.0, 1.0));
		assertTrue(cFunction.smallerEqual(1.0, 1.1));
		assertFalse(cFunction.smallerEqual(1.1, 1.0));
	}

	@Test
	public void testSmallerEqualLongLong() {
		assertTrue(cFunction.smallerEqual(1L, 1L));
		assertTrue(cFunction.smallerEqual(1L, 2L));
		assertFalse(cFunction.smallerEqual(2l, 1L));
	}

	@Test
	public void testSmallerEqualIntegerFloat() {
		assertTrue(cFunction.smallerEqual(1, 1.1F));
		assertTrue(cFunction.smallerEqual(1, 1.1F));
		assertFalse(cFunction.smallerEqual(1, 0.9F));
	}

	@Test
	public void testSmallerEqualIntegerDouble() {
		assertTrue(cFunction.smallerEqual(1, 1.1));
		assertTrue(cFunction.smallerEqual(1, 1.1));
		assertFalse(cFunction.smallerEqual(2, 1.9));
	}

	@Test
	public void testSmallerEqualIntegerLong() {
		assertTrue(cFunction.smallerEqual(1, 1L));
		assertTrue(cFunction.smallerEqual(1, 2L));
		assertFalse(cFunction.smallerEqual(2, 1L));
	}

	@Test
	public void testSmallerEqualFloatInteger() {
		assertTrue(cFunction.smallerEqual(1.0F, 1));
		assertTrue(cFunction.smallerEqual(1.9F, 2));
		assertFalse(cFunction.smallerEqual(1.9F, 1));
	}
	
	@Test
	public void testSmallerEqualFloatLong() {
		assertTrue(cFunction.smallerEqual(1.0F, 1L));
		assertTrue(cFunction.smallerEqual(1.9F, 2L));
		assertFalse(cFunction.smallerEqual(1.9F, 1L));
	}

	@Test
	public void testSmallerEqualFloatDouble() {
		assertTrue(cFunction.smallerEqual(1.0F, 1.0));
		assertTrue(cFunction.smallerEqual(1.5F, 1.5));
		assertTrue(cFunction.smallerEqual(1.1F, 1.2));
		// Since Java and C are not able to compare
		// float and double values with absolute precision -> 1.2 ! <= 1.2F
		assertFalse(cFunction.smallerEqual(1.2F, 1.2));
		assertFalse(cFunction.smallerEqual(1.2F, 1.1));
	}

	@Test
	public void testSmallerEqualDoubleInteger() {
		assertTrue(cFunction.smallerEqual(1.0, 1));
		assertTrue(cFunction.smallerEqual(1.9, 2));
		assertFalse(cFunction.smallerEqual(1.9, 1));
	}

	@Test
	public void testSmallerEqualDoubleFloat() {
		assertTrue(cFunction.smallerEqual(1.0, 1.0F));
		assertTrue(cFunction.smallerEqual(1.9, 2.0F));
		assertFalse(cFunction.smallerEqual(1.9, 1.0F));
	}

	@Test
	public void testSmallerEqualDoubleLong() {
		assertTrue(cFunction.smallerEqual(1.0, 1L));
		assertTrue(cFunction.smallerEqual(1.9, 2L));
		assertFalse(cFunction.smallerEqual(1.9, 1L));
	}

	@Test
	public void testSmallerEqualLongInteger() {
		assertTrue(cFunction.smallerEqual(1L, 1));
		assertTrue(cFunction.smallerEqual(1L, 2));
		assertFalse(cFunction.smallerEqual(2L, 1));
	}
	
	@Test
	public void testSmallerEqualLongFloat() {
		assertTrue(cFunction.smallerEqual(1L, 1.0F));
		assertTrue(cFunction.smallerEqual(1L, 2.0F));
		assertFalse(cFunction.smallerEqual(2L, 1.0F));
	}
	
	@Test
	public void testSmallerEqualLongDouble() {
		assertTrue(cFunction.smallerEqual(1L, 1.0D));
		assertTrue(cFunction.smallerEqual(1L, 2.0D));
		assertFalse(cFunction.smallerEqual(2L, 1.0D));
	}

	@Test
	public void testGreaterIntegerInteger() {
		assertTrue(cFunction.greater(2, 1));
		assertFalse(cFunction.greater(1, 1));
		assertFalse(cFunction.greater(1, 2));
	}

	@Test
	public void testGreaterFloatFloat() {
		assertTrue(cFunction.greater(1.1F, 1.0F));
		assertFalse(cFunction.greater(1.0F, 1.0F));
		assertFalse(cFunction.greater(1.0F, 1.1F));
	}

	@Test
	public void testGreaterDoubleDouble() {
		assertTrue(cFunction.greater(1.1, 1.0));
		assertFalse(cFunction.greater(1.0, 1.0));
		assertFalse(cFunction.greater(1.0, 1.1));
	}

	@Test
	public void testGreaterLongLong() {
		assertTrue(cFunction.greater(2L, 1L));
		assertFalse(cFunction.greater(1L, 1L));
		assertFalse(cFunction.greater(1L, 2L));
	}

	@Test
	public void testGreaterIntegerFloat() {
		assertTrue(cFunction.greater(2, 1.9F));
		assertFalse(cFunction.greater(1, 1.0F));
		assertFalse(cFunction.greater(1, 1.1F));
	}

	@Test
	public void testGreaterIntegerDouble() {
		assertTrue(cFunction.greater(1, 0.9));
		assertFalse(cFunction.greater(1, 1.0));
		assertFalse(cFunction.greater(1, 1.1));
	}

	@Test
	public void testGreaterIntegerLong() {
		assertTrue(cFunction.greater(2, 1L));
		assertFalse(cFunction.greater(1, 1L));
		assertFalse(cFunction.greater(1, 2L));
	}

	@Test
	public void testGreaterFloatInteger() {
		assertTrue(cFunction.greater(1.1F, 1));
		assertFalse(cFunction.greater(1.0F, 1));
		assertFalse(cFunction.greater(1.9F, 2));
	}

	@Test
	public void testGreaterFloatDouble() {
		assertTrue(cFunction.greater(1.1F, 1.0));
		assertFalse(cFunction.greater(1.0F, 1.0));
		assertFalse(cFunction.greater(1.0F, 1.1));
	}
	
	@Test
	public void testGreaterFloatLong() {
		assertTrue(cFunction.greater(1.1F, 1L));
		assertFalse(cFunction.greater(1.0F, 1L));
		assertFalse(cFunction.greater(1.0F, 2L));
	}

	@Test
	public void testGreaterDoubleInteger() {
		assertTrue(cFunction.greater(1.1, 1));
		assertFalse(cFunction.greater(1.0F, 1));
		assertFalse(cFunction.greater(0.9F, 1));
	}

	@Test
	public void testGreaterDoubleFloat() {
		assertTrue(cFunction.greater(1.1, 1.0F));
		assertFalse(cFunction.greater(1.0, 1.0F));
		assertFalse(cFunction.greater(1.0, 1.1F));
	}

	@Test
	public void testGreaterDoubleLong() {
		assertTrue(cFunction.greater(1.1, 1L));
		assertFalse(cFunction.greater(1.0, 1L));
		assertFalse(cFunction.greater(0.9, 1L));
	}

	@Test
	public void testGreaterLongInteger() {
		assertTrue(cFunction.greater(1L, 0));
		assertFalse(cFunction.greater(1L, 1));
		assertFalse(cFunction.greater(1L, 2));
	}
	
	@Test
	public void testGreaterLongFloat() {
		assertTrue(cFunction.greater(1L, 0.0F));
		assertFalse(cFunction.greater(1L, 1.0F));
		assertFalse(cFunction.greater(1L, 1.2F));
	}
	
	@Test
	public void testGreaterLongDouble() {
		assertTrue(cFunction.greater(1L, 0.0D));
		assertFalse(cFunction.greater(1L, 1.0D));
		assertFalse(cFunction.greater(1L, 2.0D));
	}

	@Test
	public void testSmallerIntegerInteger() {
		assertTrue(cFunction.smaller(1, 2));
		assertFalse(cFunction.smaller(1, 1));
		assertFalse(cFunction.smaller(2, 1));
	}

	@Test
	public void testSmallerFloatFloat() {
		assertTrue(cFunction.smaller(1.9F, 2.0F));
		assertFalse(cFunction.smaller(1.0F, 1.0F));
		assertFalse(cFunction.smaller(2.0F, 1.9F));
	}

	@Test
	public void testSmallerDoubleDouble() {
		assertTrue(cFunction.smaller(1.9, 2.0));
		assertFalse(cFunction.smaller(1.0, 1.0));
		assertFalse(cFunction.smaller(2.0, 1.9));
	}

	@Test
	public void testSmallerLongLong() {
		assertTrue(cFunction.smaller(1L, 2L));
		assertFalse(cFunction.smaller(1L, 1L));
		assertFalse(cFunction.smaller(2L, 1L));
	}

	@Test
	public void testSmallerIntegerFloat() {
		assertTrue(cFunction.smaller(1, 1.1F));
		assertFalse(cFunction.smaller(1, 1.0F));
		assertFalse(cFunction.smaller(2, 1.9F));
	}

	@Test
	public void testSmallerIntegerDouble() {
		assertTrue(cFunction.smaller(1, 1.1));
		assertFalse(cFunction.smaller(1, 1.0));
		assertFalse(cFunction.smaller(1, 0.9));
	}

	@Test
	public void testSmallerIntegerLong() {
		assertTrue(cFunction.smaller(1, 2L));
		assertFalse(cFunction.smaller(1, 1L));
		assertFalse(cFunction.smaller(2, 1L));
	}

	@Test
	public void testSmallerFloatInteger() {
		assertTrue(cFunction.smaller(1.9F, 2));
		assertFalse(cFunction.smaller(1.0F, 1));
		assertFalse(cFunction.smaller(1.1F, 1));
	}
	
	@Test
	public void testSmallerFloatLong() {
		assertTrue(cFunction.smaller(1.9F, 2L));
		assertFalse(cFunction.smaller(1.0F, 1L));
		assertFalse(cFunction.smaller(1.1F, 1L));
	}

	@Test
	public void testSmallerFloatDouble() {
		assertFalse(cFunction.smaller(1.0F, 1.0));
		assertTrue(cFunction.smaller(0.9F, 1.0));
		assertFalse(cFunction.smaller(1.1F, 1.0));
	}

	@Test
	public void testSmallerDoubleInteger() {
		assertTrue(cFunction.smaller(1.9, 2));
		assertFalse(cFunction.smaller(1.0, 1));
		assertFalse(cFunction.smaller(2.0, 1));
	}

	@Test
	public void testSmallerDoubleFloat() {
		assertTrue(cFunction.smaller(1.9, 2.0F));
		assertFalse(cFunction.smaller(1.0, 1.0F));
		assertFalse(cFunction.smaller(2.0, 1.9F));
	}

	@Test
	public void testSmallerDoubleLong() {
		assertTrue(cFunction.smaller(1.9, 2L));
		assertFalse(cFunction.smaller(1.0, 1L));
		assertFalse(cFunction.smaller(1.1, 1L));
	}

	@Test
	public void testSmallerLongInteger() {
		assertTrue(cFunction.smaller(1L, 2));
		assertFalse(cFunction.smaller(1L, 1));
		assertFalse(cFunction.smaller(2L, 1));
	}
	
	@Test
	public void testSmallerLongFloat() {
		assertTrue(cFunction.smaller(1L, 2.0F));
		assertFalse(cFunction.smaller(1L, 1.0F));
		assertFalse(cFunction.smaller(2L, 1.0F));
	}
	
	@Test
	public void testSmallerLongDouble() {
		assertTrue(cFunction.smaller(1L, 2.0D));
		assertFalse(cFunction.smaller(1L, 1.0D));
		assertFalse(cFunction.smaller(2L, 1.0D));
	}

	@Test
	public void testNot() {
		assertTrue(cFunction.not(false));
		assertFalse(cFunction.not(true));
	}

	@Test
	public void testComplementInteger() {
		int expected = -3;
		int actual = cFunction.complement(2);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testComplementLong() {
		long expected = -3;
		long actual = cFunction.complement(2L);
		assertEquals(expected, actual);
	}
}
