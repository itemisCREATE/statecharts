/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.sexec.interpreter.test;

import static org.junit.Assert.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EcoreFactoryImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.yakindu.sct.model.sexec.interpreter.stext.CoreFunction;

/**
 * 
 * @author florian antony
 *
 */
public class CoreFunctionTest {

	private static CoreFunction cFunction;
	private static double delta;
	private static EObject obj1;
	private static EObject obj2;

	@BeforeClass
	public static void beforeClass() throws Exception {
		cFunction = new CoreFunction();
		delta = 0.001;

	}

	@Before
	public void setUp() throws Exception {
		cFunction = new CoreFunction();
		obj1 = EcoreFactoryImpl.eINSTANCE.createEObject();
		obj2 = obj1;
	}

	@After
	public void tearDown() throws Exception {
		cFunction = null;
	}

	@Test
	public void testPlusIntegerInteger() {
		int expected = 10;
		int actual = cFunction.plus(5, 5);
		assertEquals("testPlusIntegerInteger faild", expected, actual);
	}

	@Test
	public void testPlusFloatFloat() {
		float expected = 10.6F;
		float actual = cFunction.plus(5.3F, 5.3F);
		assertEquals("testFloatFloat faild", expected, actual, delta);

	}

	@Test
	public void testPlusDoubleDouble() {
		double expected = 10.6;
		double actual = cFunction.plus(5.3, 5.3);
		assertEquals("testPlusDoubleDouble faild", expected, actual, delta);
	}

	@Test
	public void testPlusLongLong() {
		long expected = 10;
		long actual = cFunction.plus(5L, 5L);
		assertEquals("testPlusLongLong faild", expected, actual);
	}

	@Test
	public void testPlusIntegerFloat() {
		float expected = 10.3F;
		float actual = cFunction.plus(5, 5.3F);
		assertEquals("testPlusIntegerFloat faild", expected, actual, delta);
	}

	@Test
	public void testPlusIntegerDouble() {
		double expected = 10.3;
		double actual = cFunction.plus(5, 5.3);
		assertEquals("testPlusIntegerDouble faild", expected, actual, delta);
	}

	@Test
	public void testPlusIntegerLong() {
		long expected = 10;
		long actual = cFunction.plus(5, 5L);
		assertEquals("testPlusIntegerLong faild", expected, actual);
	}

	@Test
	public void testPlusFloatInteger() {
		float expected = 10.3F;
		float actual = cFunction.plus(5.3F, 5);
		assertEquals("testPlusFloatInteger faild", expected, actual, delta);
	}

	@Test
	public void testPlusFloatDouble() {
		double expected = 10.6;
		double actual = cFunction.plus(5.3F, 5.3);
		assertEquals("testPlusFloatDouble faild", expected, actual, delta);
	}

	@Test
	public void testPlusDoubleInteger() {
		double expected = 10.6;
		double actual = cFunction.plus(5.6, 5);
		assertEquals("testPlusDoubleInteger faild", expected, actual, delta);
	}

	@Test
	public void testPlusDoubleFloat() {
		double expected = 10.6;
		double actual = cFunction.plus(5.3F, 5.3);
		assertEquals("testPlusDoubleFloat faild", expected, actual, delta);
	}

	@Test
	public void testPlusDoubleLong() {
		double expected = 10.3;
		double actual = cFunction.plus(5.3, 5L);
		assertEquals("testPlusDoublelong faild", expected, actual, delta);
	}

	@Test
	public void testPlusLongInteger() {
		long expected = 10;
		long actual = cFunction.plus(5L, 5);
		assertEquals("testPlusLongInteger faild", expected, actual);
	}

	@Test
	public void testPositiveInteger() {
		int expected = 10;
		int actual = cFunction.positive(10);
		assertEquals("testPositiveInteger faild", expected, actual);
	}

	@Test
	public void testPositiveFloat() {
		float expected = 10.3F;
		float actual = cFunction.positive(10.3F);
		assertEquals("testPositiveFloat faild", expected, actual, delta);
	}

	@Test
	public void testPositiveLong() {
		long expected = 10;
		long actual = cFunction.positive(10);
		assertEquals("testPositiveLong faild", expected, actual);
	}

	@Test
	public void testPositiveDouble() {
		double expected = 10.3;
		double actual = cFunction.positive(10.3);
		assertEquals("testPositiveDouble faild", expected, actual, delta);
	}

	@Test
	public void testPositiveBoolean() {
		boolean expected = true;
		boolean actual = cFunction.positive(true);
		assertEquals("testPositiveBoolean faild", expected, actual);
	}

	@Test
	public void testPositiveString() {
		String expected = "positive";
		String actual = cFunction.positive("positive");
		assertEquals("testPositiveString faild", expected, actual);
	}

	@Test
	public void testNegativeInteger() {
		int expected = -10;
		int actual = cFunction.negative(10);
		assertEquals("testNegativeInteger faild", expected, actual);
	}

	@Test
	public void testNegativeFloat() {
		float expected = -10.3F;
		float actual = cFunction.negative(10.3F);
		assertEquals("testPositiveFloat faild", expected, actual, delta);
	}

	@Test
	public void testNegativeDouble() {
		double expected = -10.3;
		double actual = cFunction.negative(10.3);
		assertEquals("testPositiveDouble faild", expected, actual, delta);
	}

	@Test
	public void testNegativeLong() {
		long expected = 10L;
		long actual = cFunction.negative(-10L);
		assertEquals("testPositiveLong faild", expected, actual);
	}

	@Test
	public void testMinusIntegerInteger() {
		int expected = 5;
		int actual = cFunction.minus(10, 5);
		assertEquals("testMinusIntegerInteger faild", expected, actual);
	}

	@Test
	public void testMinusFloatFloat() {
		float expected = 5.3F;
		float actual = cFunction.minus(10.3F, 5.0F);
		assertEquals("testMinusFloatFloat faild", expected, actual, delta);
	}

	@Test
	public void testMinusDoubleDouble() {
		double expected = 5.3;
		double actual = cFunction.minus(10.6, 5.3);
		assertEquals("testMinusDoubleDouble faild", expected, actual, delta);
	}

	@Test
	public void testMinusLongLong() {
		long expected = 5L;
		long actual = cFunction.minus(10L, 5L);
		assertEquals("testMinusLongLong faild", expected, actual, delta);
	}

	@Test
	public void testMinusIntegerFloat() {
		float expected = 4.7F;
		float actual = cFunction.minus(10, 5.3F);
		assertEquals("testMinusIntegerFloat faild", expected, actual, delta);
	}

	@Test
	public void testMinusIntegerDouble() {
		double expected = 4.7;
		double actual = cFunction.minus(10, 5.3F);
		assertEquals("testMinusFloatDouble faild", expected, actual, delta);
	}

	@Test
	public void testMinusIntegerLong() {
		long expected = 5L;
		long actual = cFunction.minus(10, 5L);
		assertEquals("testMinusIntegerLong faild", expected, actual, delta);
	}

	@Test
	public void testMinusFloatInteger() {
		float expected = 5.3F;
		float actual = cFunction.minus(10.3F, 5);
		assertEquals("testMinusFloatInteger faild", expected, actual, delta);
	}

	@Test
	public void testMinusFloatDouble() {
		double expected = 5.0;
		double actual = cFunction.minus(10.3, 5.3F);
		assertEquals("testMinusFloatDouble faild", expected, actual, delta);
	}

	@Test
	public void testMinusDoubleInteger() {
		double expected = 5.3;
		double actual = cFunction.minus(10.3, 5);
		assertEquals("testMinusDoubleInteger faild", expected, actual, delta);
	}

	@Test
	public void testMinusDoubleFloat() {
		double expected = 5.0;
		double actual = cFunction.minus(10.3, 5.3F);
		assertEquals("testMinusDoubleFloat faild", expected, actual, delta);
	}

	@Test
	public void testMinusDoubleLong() {
		double expected = 5.3;
		double actual = cFunction.minus(10.3, 5L);
		assertEquals("testMinusDoubleLong faild", expected, actual, delta);
	}

	@Test
	public void testMinusLongInteger() {
		long expected = 5L;
		long actual = cFunction.minus(10L, 5);
		assertEquals("testMinusLongInteger faild", expected, actual);
	}

	@Test
	public void testMulIntegerInteger() {
		int expected = 25;
		int actual = cFunction.mul(5, 5);
		assertEquals("testMulIntegerInteger faild", expected, actual);
	}

	@Test
	public void testMulFloatFloat() {
		float expected = 25.0F;
		float actual = cFunction.mul(5.0F, 5.0F);
		assertEquals("testMulFloatFloat faild", expected, actual, delta);
	}

	@Test
	public void testMulDoubleDouble() {
		double expected = 25.0;
		double actual = cFunction.mul(5.0, 5.0);
		assertEquals("testMulDoubleDouble faild", expected, actual, delta);
	}

	@Test
	public void testMulLongLong() {
		long expected = 25L;
		long actual = cFunction.mul(5L, 5L);
		assertEquals("testMulLongLong faild", expected, actual);
	}

	@Test
	public void testMulIntegerFloat() {
		float expected = 25.0F;
		float actual = cFunction.mul(5, 5.0F);
		assertEquals("testMulIntegerFloat faild", expected, actual, delta);
	}

	@Test
	public void testMulIntegerDouble() {
		double expected = 25.0;
		double actual = cFunction.mul(5, 5.0F);
		assertEquals("testMulIntegerDouble faild", expected, actual, delta);
	}

	@Test
	public void testMulIntegerLong() {
		long expected = 25L;
		long actual = cFunction.mul(5, 5L);
		assertEquals("testMulIntegerLong faild", expected, actual);
	}

	@Test
	public void testMulFloatInteger() {
		float expected = 25.0F;
		float actual = cFunction.mul(5.0F, 5);
		assertEquals("testMulFlatInteger faild", expected, actual, delta);
	}

	@Test
	public void testMulFloatDouble() {
		double expected = 25.0;
		double actual = cFunction.mul(5.0F, 5.0);
		assertEquals("testMulFloatDouble faild", expected, actual, delta);
	}

	@Test
	public void testMulDoubleInteger() {
		double expected = 25.0;
		double actual = cFunction.mul(5.0, 5);
		assertEquals("testMulDoubleInteger faild", expected, actual, delta);
	}

	@Test
	public void testMulDoubleFloat() {
		double expected = 25.0;
		double actual = cFunction.mul(5.0, 5.0F);
		assertEquals("testMulDoubleDouble faild", expected, actual, delta);

	}

	@Test
	public void testMulDoubleLong() {
		double expected = 25.0;
		double actual = cFunction.mul(5.0, 5L);
		assertEquals("testMuldoubleLong faild", expected, actual, delta);
	}

	@Test
	public void testMulLongInteger() {
		long expected = 25L;
		long actual = cFunction.mul(5L, 5);
		assertEquals("testMulLongInteger faild", expected, actual);
	}

	@Test
	public void testDivIntegerInteger() {
		int expected = 5;
		int actual = cFunction.div(25, 5);
		assertEquals("testDivIntegerInteger faild", expected, actual);
	}

	@Test
	public void testDivFloatFloat() {
		float expected = 5.0F;
		float actual = cFunction.div(25.0F, 5.0F);
		assertEquals("testDivFloatFloat faild", expected, actual, delta);
	}

	@Test
	public void testDivDoubleDouble() {
		double expected = 5.0;
		double actual = cFunction.div(25.0, 5.0);
		assertEquals("testDivDoubleDouble faild", expected, actual, delta);
	}

	@Test
	public void testDivLongLong() {
		long expected = 5L;
		long actual = cFunction.div(25L, 5L);
		assertEquals("testDivLongLong faild", expected, actual);
	}

	@Test
	public void testDivIntegerFloat() {
		float expected = 5.0F;
		float actual = cFunction.div(25, 5.0F);
		assertEquals("testDivIntegerFloat faild", expected, actual, delta);
	}

	@Test
	public void testDivIntegerDouble() {
		double expected = 5.0;
		double actual = cFunction.div(25, 5.0F);
		assertEquals("testDivFloatDouble faild", expected, actual, delta);
	}

	@Test
	public void testDivIntegerLong() {
		long expected = 5L;
		long actual = cFunction.div(25, 5L);
		assertEquals("testDivIntegerLong faild", expected, actual);
	}

	@Test
	public void testDivFloatInteger() {
		float expected = 5.0F;
		float actual = cFunction.div(25.0F, 5);
		assertEquals("testDivFloatInteger faild", expected, actual, delta);
	}

	@Test
	public void testDivFloatDouble() {
		double expected = 5.0;
		double actual = cFunction.div(25.0F, 5.0);
		assertEquals("testDivFloatDouble faild", expected, actual, delta);
	}

	@Test
	public void testDivDoubleInteger() {
		double expected = 5.0;
		double actual = cFunction.div(25.0, 5);
		assertEquals("testDivDoubleInteger faild", expected, actual, delta);
	}

	@Test
	public void testDivDoubleFloat() {
		double expected = 5.0;
		double actual = cFunction.div(25.0, 5.0F);
		assertEquals("testDivDoublFloat faild", expected, actual, delta);
	}

	@Test
	public void testDivDoubleLong() {
		double expected = 5.0;
		double actual = cFunction.div(25.0, 5L);
		assertEquals("testDivDoubleLong faild", expected, actual, delta);
	}

	@Test
	public void testDivLongInteger() {
		long expected = 5L;
		long actual = cFunction.div(25L, 5);
		assertEquals("testDivLongInteger faild", expected, actual, delta);
	}

	@Test
	public void testModIntegerInteger() {
		int expected = 0;
		int actual = cFunction.mod(5, 5);
		assertEquals("testModIntegerInteger faild", expected, actual);
	}

	@Test
	public void testModFloatFloat() {
		float expected = 0.0F;
		float actual = cFunction.mod(5.0F, 5.0F);
		assertEquals("testModFloatFloat faild", expected, actual, delta);
	}

	@Test
	public void testModDoubleDouble() {
		double expected = 0.0;
		double actual = cFunction.mod(5.0, 5.0);
		assertEquals("testModDoubleDouble faild", expected, actual, delta);
	}

	@Test
	public void testModLongLong() {
		long expected = 0L;
		long actual = cFunction.mod(5L, 5L);
		assertEquals("testModLongLong faild", expected, actual);
	}

	@Test
	public void testModIntegerFloat() {
		float expected = 0.0F;
		float actual = cFunction.mod(5, 5.0F);
		assertEquals("testModIntegerFloat faild", expected, actual, delta);
	}

	@Test
	public void testModIntegerDouble() {
		double expected = 0.0;
		double actual = cFunction.mod(5, 5.0);
		assertEquals("testModIntegerDouble faild", expected, actual, delta);
	}

	@Test
	public void testModIntegerLong() {
		long expected = 0L;
		long actual = cFunction.mod(5, 5L);
		assertEquals("testModIntegerLong faild", expected, actual);
	}

	@Test
	public void testModFloatInteger() {
		float expected = 0.0F;
		float actual = cFunction.mod(5.0F, 5);
		assertEquals("testModDFloatInteger faild", expected, actual, delta);
	}

	@Test
	public void testModFloatDouble() {
		double expected = 0.0;
		double actual = cFunction.mod(5.0F, 5.0);
		assertEquals("testModFloatDouble faild", expected, actual, delta);
	}

	@Test
	public void testModDoubleInteger() {
		double expected = 0.0;
		double actual = cFunction.mod(5.0, 5);
		assertEquals("testModDoubleInteger faild", expected, actual, delta);
	}

	@Test
	public void testModDoubleFloat() {
		double expected = 0.0;
		double actual = cFunction.mod(5.0, 5.0);
		assertEquals("testModDoubleDouble faild", expected, actual, delta);
	}

	@Test
	public void testModDoubleLong() {
		double expected = 0.0;
		double actual = cFunction.mod(5.0, 5L);
		assertEquals("testModDoubleLong faild", expected, actual, delta);
	}

	@Test
	public void testModLongInteger() {
		long expected = 0L;
		double actual = cFunction.mod(5L, 5);
		assertEquals("testModLongInteger faild", expected, actual, delta);
	}

	@Test
	public void testLeft() {
		int expected = 20;
		int actual = cFunction.left(10, 1);
		assertEquals("testLeftIntegerInteger faild", expected, actual);
	}

	@Test
	public void testRight() {
		int expected = 5;
		int actual = cFunction.right(10, 1);
		assertEquals("testRightIntegerInteger faild", expected, actual);
	}

	@Test
	public void testBitwiseAnd() {
		int expected = 0;
		int actual = cFunction.bitwiseAnd(5, 2);
		assertEquals("testBitwiseANDntegerInteger faild", expected, actual);
	}

	@Test
	public void testBitwiseOr() {
		int expected = 7;
		int actual = cFunction.bitwiseOr(5, 2);
		assertEquals("testBitwiseORntegerInteger faild", expected, actual);
	}

	@Test
	public void testBitwiseXorIntegerInteger() {
		int expected = 6;
		int actual = cFunction.bitwiseXor(5, 3);
		assertEquals("testBitwiseXORIntegerInteger faild", expected, actual);
	}

	@Test
	public void testBitwiseXorLongLong() {
		long expected = 6L;
		long actual = cFunction.bitwiseXor(5L, 3L);
		assertEquals("testBitwiseXORLongLong faild", expected, actual);
	}

	@Test
	public void testEqualsBooleanBoolean() {
		boolean expected = false;
		boolean actual = cFunction.equals(true, false);
		assertEquals("testEqualsBooleanBoolean faild", expected, actual);
	}

	@Test
	public void testEqualsEObjectEObject() {
		boolean expected = true;
		boolean actual = cFunction.equals(obj1, obj2);
		assertEquals("testEqualsEObjectEObject faild", expected, actual);
	}

	@Test
	public void testEqualsStringString() {
		boolean expected = true;
		String test = "test";
		boolean actual = cFunction.equals(test, "test");
		assertEquals("testEqualsStringString faild", expected, actual);
	}

	@Test
	public void testEqualsIntegerInteger() {
		boolean expected = true;
		boolean actual = cFunction.equals(1, 1);
		assertEquals("testEqualsIntegerInteger faild", expected, actual);
	}

	@Test
	public void testEqualsFloatFloat() {
		boolean expected = true;
		boolean actual = cFunction.equals(1.5F, 1.5F);
		assertEquals("testEqualsloatFloat faild", expected, actual);
	}

	@Test
	public void testEqualsDoubleDouble() {

		boolean expected = true;
		boolean actual = cFunction.equals(1.5, 1.5);
		assertEquals("testEqualsDoubleDouble faild", expected, actual);
	}

	@Test
	public void testEqualsLongLong() {
		boolean expected = true;
		boolean actual = cFunction.equals(10L, 10L);
		assertEquals("testEqualsLongLong faild", expected, actual);
	}

	@Test
	public void testEqualsIntegerFloat() {
		boolean expected = true;
		boolean actual = cFunction.equals(1, 1.0F);
		assertEquals("testEqualsIntegerFloat faild", expected, actual);
	}

	@Test
	public void testEqualsIntegerDouble() {
		boolean expected = true;
		boolean actual = cFunction.equals(1, 1.0);
		assertEquals("testEqualsIntegerDouble faild", expected, actual);
	}

	@Test
	public void testEqualsIntegerLong() {
		boolean expected = true;
		boolean actual = cFunction.equals(1, 1L);
		assertEquals("testEqualsIntegerLong faild", expected, actual);
	}

	@Test
	public void testEqualsFloatInteger() {
		boolean expected = true;
		boolean actual = cFunction.equals(1.0F, 1);
		assertEquals("testEqualsFloatInteger faild", expected, actual);
	}

	@Test
	public void testEqualsFloatDouble() {
		assertTrue( cFunction.equals(1.0F, 1.0));
		assertTrue( cFunction.equals(1.5F, 1.5));
		assertFalse( cFunction.equals(1.3F, 1.3));
	}

	@Test
	public void testEqualsDoubleInteger() {
		boolean expected = true;
		boolean actual = cFunction.equals(1.0, 1);
		assertEquals("testEqualsDoubleInteger faild", expected, actual);
	}

	@Test
	public void testEqualsDoubleFloat() {
		boolean expected = true;
		boolean actual = cFunction.equals(1.5, 1.5F);
		assertEquals("testEqualsDoubleFloat faild", expected, actual);
	}

	@Test
	public void testEqualsDoubleLong() {
		boolean expected = true;
		boolean actual = cFunction.equals(1.0, 1L);
		assertEquals("testEqualsDoubleLong faild", expected, actual);
	}

	@Test
	public void testEqualsLongInteger() {
		boolean expected = true;
		boolean actual = cFunction.equals(1L, 1);
		assertEquals("testEqualsLongInteger faild", expected, actual);
	}

	@Test
	public void testNotEqualsEObjectEObject() {
		boolean expected = false;
		boolean actual = cFunction.notEquals(obj1, EcoreFactoryImpl.eINSTANCE.createEObject());
		assertEquals(expected, actual);
	}

	@Test
	public void testNotEqualsBooleanBoolean() {
		boolean expected = true;
		boolean actual = cFunction.notEquals(true, false);
		assertEquals("testNotEqualsBooleanBoolean faild", expected, actual);
	}

	@Test
	public void testNotEqualsStringString() {
		boolean expected = true;
		boolean actual = cFunction.notEquals("Hans", "Wurst");
		assertEquals("testNotEqualsStringString faild", expected, actual);
	}

	@Test
	public void testNotEqualsIntegerInteger() {
		boolean expected = true;
		boolean actual = cFunction.notEquals(1, 2);
		assertEquals("testNotEqualsIntegerInteger faild", expected, actual);
	}

	@Test
	public void testNotEqualsFloatFloat() {
		boolean expected = true;
		boolean actual = cFunction.notEquals(1.2F, 1.3F);
		assertEquals("testNotEqualsFloatFloat faild", expected, actual);
	}

	@Test
	public void testNotEqualsDoubleDouble() {
		boolean expected = true;
		boolean actual = cFunction.notEquals(1.2, 1.3);
		assertEquals("testNotEqualsDoubleDouble faild", expected, actual);
	}

	@Test
	public void testNotEqualsLongLong() {
		boolean expected = true;
		boolean actual = cFunction.notEquals(1L, 2L);
		assertEquals("testNotEqualsLongLong faild", expected, actual);
	}

	@Test
	public void testNotEqualsIntegerFloat() {
		boolean expected = true;
		boolean actual = cFunction.notEquals(1, 1.1F);
		assertEquals("testNotEqualsIntegerFloat faild", expected, actual);
	}

	@Test
	public void testNotEqualsIntegerDouble() {
		boolean expected = true;
		boolean actual = cFunction.notEquals(1, 1.1);
		assertEquals("testNotEqualsIntegerDouble faild", expected, actual);
	}

	@Test
	public void testNotEqualsIntegerLong() {
		boolean expected = true;
		boolean actual = cFunction.notEquals(1, 2L);
		assertEquals("testNotEqualsIntegerLong faild", expected, actual);
	}

	@Test
	public void testNotEqualsFloatInteger() {
		boolean expected = true;
		boolean actual = cFunction.notEquals(1.1F, 1);
		assertEquals("testNotEqualsFloatInteger faild", expected, actual);
	}

	@Test
	public void testNotEqualsFloatDouble() {
		boolean expected = true;
		boolean actual = cFunction.notEquals(1.01F, 1.02);
		assertEquals("testNotEqualsFloatDouble faild", expected, actual);
	}

	@Test
	public void testNotEqualsDoubleInteger() {
		boolean expected = true;
		boolean actual = cFunction.notEquals(1.01, 1);
		assertEquals("testNotEqualsDoubleinteger faild", expected, actual);
	}

	@Test
	public void testNotEqualsDoubleFloat() {
		boolean expected = true;
		boolean actual = cFunction.notEquals(1.01, 1.02F);
		assertEquals("testNotEqualsDoubleFloat faild", expected, actual);
	}

	@Test
	public void testNotEqualsDoubleLong() {
		boolean expected = true;
		boolean actual = cFunction.notEquals(1.01, 1L);
		assertEquals("testNotEqualsDoubleLong faild", expected, actual);
	}

	@Test
	public void testNotEqualsLongInteger() {
		boolean expected = true;
		boolean actual = cFunction.notEquals(1L, 2);
		assertEquals("testNotEqualsLongInteger faild", expected, actual);
	}

	@Test
	public void testGreaterEqualIntegerInteger() {
		boolean expected = true;
		boolean actual = cFunction.greaterEqual(1, 1);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.greaterEqual(2, 1);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.greaterEqual(1, 2);
		assertEquals(expected, actual);
	}

	@Test
	public void testGreaterEqualFloatFloat() {
		boolean expected = true;
		boolean actual = cFunction.greaterEqual(1.0F, 1.0F);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.greaterEqual(1.1F, 1F);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.greaterEqual(1F, 1.1F);
		assertEquals(expected, actual);
	}

	@Test
	public void testGreaterEqualDoubleDouble() {
		boolean expected = true;
		boolean actual = cFunction.greaterEqual(1.0, 1.0);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.greaterEqual(1.1, 1);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.greaterEqual(1, 1.1);
		assertEquals(expected, actual);
	}

	@Test
	public void testGreaterEqualLongLong() {
		boolean expected = true;
		boolean actual = cFunction.greaterEqual(1L, 1L);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.greaterEqual(2L, 1L);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.greaterEqual(1L, 2L);
		assertEquals(expected, actual);
	}

	@Test
	public void testGreaterEqualIntegerFloat() {
		boolean expected = true;
		boolean actual = cFunction.greaterEqual(1, 1.0F);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.greaterEqual(2, 1.0F);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.greaterEqual(1, 1.1F);
		assertEquals(expected, actual);
	}

	@Test
	public void testGreaterEqualIntegerDouble() {
		boolean expected = true;
		boolean actual = cFunction.greaterEqual(1, 1.0);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.greaterEqual(2, 1.0);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.greaterEqual(1, 1.1);
		assertEquals(expected, actual);
	}

	@Test
	public void testGreaterEqualIntegerLong() {
		boolean expected = true;
		boolean actual = cFunction.greaterEqual(1, 1L);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.greaterEqual(2, 1L);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.greaterEqual(1, 2L);
		assertEquals(expected, actual);
	}

	@Test
	public void testGreaterEqualFloatInteger() {
		boolean expected = true;
		boolean actual = cFunction.greaterEqual(1.0F, 1);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.greaterEqual(2.0F, 1);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.greaterEqual(1.0F, 2);
		assertEquals(expected, actual);
	}

	@Test
	public void testGreaterEqualFloatDouble() {
		boolean expected = true;
		boolean actual = cFunction.greaterEqual(1.0, 1.0F);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.greaterEqual(2.0, 1.0F);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.greaterEqual(1.0, 1.1F);
		assertEquals(expected, actual);
	}

	@Test
	public void testGreaterEqualDoubleInteger() {
		boolean expected = true;
		boolean actual = cFunction.greaterEqual(1.0, 1);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.greaterEqual(1.1, 1);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.greaterEqual(1, 1.2);
		assertEquals(expected, actual);
	}

	@Test
	public void testGreaterEqualDoubleFloat() {
		boolean expected = true;
		boolean actual = cFunction.greaterEqual(1.0, 1.0F);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.greaterEqual(2.0, 1.0F);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.greaterEqual(1.0, 1.1F);
		assertEquals(expected, actual);
	}

	@Test
	public void testGreaterEqualDoubleLong() {
		boolean expected = true;
		boolean actual = cFunction.greaterEqual(1.0, 1L);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.greaterEqual(1.1, 1L);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.greaterEqual(0.9, 1L);
		assertEquals(expected, actual);
	}

	@Test
	public void testGreaterEqualLongInteger() {
		boolean expected = true;
		boolean actual = cFunction.greaterEqual(1L, 1);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.greaterEqual(2L, 1);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.greaterEqual(1L, 2);
		assertEquals(expected, actual);
	}

	@Test
	public void testSmallerEqualIntegerInteger() {
		boolean expected = true;
		boolean actual = cFunction.smallerEqual(1, 1);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.smallerEqual(1, 2);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.smallerEqual(2, 1);
		assertEquals(expected, actual);
	}

	@Test
	public void testSmallerEqualFloatFloat() {
		boolean expected = true;
		boolean actual = cFunction.smallerEqual(1.0F, 1.0F);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.smallerEqual(1.0F, 1.1F);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.smallerEqual(1.1F, 1.0F);
		assertEquals(expected, actual);
	}

	@Test
	public void testSmallerEqualDoubleDouble() {
		boolean expected = true;
		boolean actual = cFunction.smallerEqual(1.1, 1.1);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.smallerEqual(1.1, 1.2);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.smallerEqual(1.2, 1.1);
		assertEquals(expected, actual);
	}

	@Test
	public void testSmallerEqualLongLong() {
		boolean expected = true;
		boolean actual = cFunction.smallerEqual(1L, 1L);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.smallerEqual(1L, 2L);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.smallerEqual(2L, 1L);
		assertEquals(expected, actual);
	}

	@Test
	public void testSmallerEqualIntegerFloat() {
		boolean expected = true;
		boolean actual = cFunction.smallerEqual(1, 1.0F);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.smallerEqual(1, 1.2F);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.smallerEqual(1, 0.9F);
		assertEquals(expected, actual);
	}

	@Test
	public void testSmallerEqualIntegerDouble() {
		boolean expected = true;
		boolean actual = cFunction.smallerEqual(1, 1.1);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.smallerEqual(1, 1.2);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.smallerEqual(2, 1.9);
		assertEquals(expected, actual);
	}

	@Test
	public void testSmallerEqualIntegerLong() {
		boolean expected = true;
		boolean actual = cFunction.smallerEqual(1, 1L);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.smallerEqual(1, 2L);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.smallerEqual(2, 1L);
		assertEquals(expected, actual);
	}

	@Test
	public void testSmallerEqualFloatInteger() {
		boolean expected = true;
		boolean actual = cFunction.smallerEqual(1.0F, 1);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.smallerEqual(1.0F, 1);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.smallerEqual(1.2F, 1);
		assertEquals(expected, actual);
	}

	@Test
	public void testSmallerEqualFloatDouble() {
		assertTrue( cFunction.smallerEqual(1.0F, 1.0));		
		assertTrue( cFunction.smallerEqual(1.5F, 1.5));		
		assertTrue( cFunction.smallerEqual(1.1F, 1.2));
		assertFalse( cFunction.smallerEqual(1.2F, 1.2));
		assertFalse( cFunction.smallerEqual(1.2F, 1.1));
	}

	@Test
	public void testSmallerEqualDoubleInteger() {
		boolean expected = true;
		boolean actual = cFunction.smallerEqual(1.0, 1);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.smallerEqual(0.9, 1);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.smallerEqual(1.1, 1);
		assertEquals(expected, actual);
	}

	@Test
	public void testSmallerEqualDoubleFloat() {
		boolean expected = true;
		boolean actual = cFunction.smallerEqual(1.1, 1.1);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.smallerEqual(1.1, 1.2);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.smallerEqual(1.2, 1.1);
		assertEquals(expected, actual);
	}

	@Test
	public void testSmallerEqualDoubleLong() {
		boolean expected = true;
		boolean actual = cFunction.smallerEqual(1.0, 1L);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.smallerEqual(0.9, 1L);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.smallerEqual(1.1, 1L);
		assertEquals(expected, actual);
	}

	@Test
	public void testSmallerEqualLongInteger() {
		boolean expected = true;
		boolean actual = cFunction.smallerEqual(1L, 1);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.smallerEqual(1L, 2);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.smallerEqual(2L, 1);
		assertEquals(expected, actual);
	}

	@Test
	public void testGreaterIntegerInteger() {
		boolean expected = false;
		boolean actual = cFunction.greater(1, 1);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.greater(2, 1);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.greater(1, 2);
		assertEquals(expected, actual);
	}

	@Test
	public void testGreaterFloatFloat() {
		boolean expected = false;
		boolean actual = cFunction.greater(1.0F, 1.0F);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.greater(1.1F, 1.0F);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.greater(1.0F, 1.1F);
		assertEquals(expected, actual);
	}

	@Test
	public void testGreaterDoubleDouble() {
		boolean expected = false;
		boolean actual = cFunction.greater(1.0, 1.0);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.greater(1.1, 1.0);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.greater(1.0, 1.1);
		assertEquals(expected, actual);
	}

	@Test
	public void testGreaterLongLong() {
		boolean expected = false;
		boolean actual = cFunction.greater(1L, 1L);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.greater(2L, 1L);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.greater(1L, 2L);
		assertEquals(expected, actual);
	}

	@Test
	public void testGreaterIntegerFloat() {
		boolean expected = false;
		boolean actual = cFunction.greater(1, 1.0F);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.greater(1, 0.9F);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.greater(1, 1.1F);
		assertEquals(expected, actual);
	}

	@Test
	public void testGreaterIntegerDouble() {
		boolean expected = false;
		boolean actual = cFunction.greater(1, 1.0);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.greater(1, 0.9);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.greater(1, 1.1);
		assertEquals(expected, actual);
	}

	@Test
	public void testGreaterIntegerLong() {
		boolean expected = false;
		boolean actual = cFunction.greater(1, 1L);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.greater(2, 1L);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.greater(1L, 2L);
		assertEquals(expected, actual);
	}

	@Test
	public void testGreaterFloatInteger() {
		boolean expected = false;
		boolean actual = cFunction.greater(1.0F, 1);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.greater(1.1F, 1);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.greater(0.9F, 1);
		assertEquals(expected, actual);
	}

	@Test
	public void testGreaterFloatDouble() {
		assertFalse(cFunction.greater(1.0F, 1.0));
		assertTrue( cFunction.greater(1.1F, 1.0));
		assertFalse(cFunction.greater(1.0F, 1.1));
	}

	@Test
	public void testGreaterDoubleInteger() {
		boolean expected = false;
		boolean actual = cFunction.greater(1.0, 1);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.greater(1.1, 1);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.greater(0.9, 1);
		assertEquals(expected, actual);
	}

	@Test
	public void testGreaterDoubleFloat() {
		boolean expected = false;
		boolean actual = cFunction.greater(1.0, 1.0F);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.greater(1.1, 1.0F);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.greater(0.9, 1.0F);
		assertEquals(expected, actual);
	}

	@Test
	public void testGreaterDoubleLong() {
		boolean expected = false;
		boolean actual = cFunction.greater(1.0, 1L);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.greater(1.1, 1L);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.greater(0.9, 1L);
		assertEquals(expected, actual);
	}

	@Test
	public void testGreaterLongInteger() {
		boolean expected = false;
		boolean actual = cFunction.greater(1L, 1);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.greater(2L, 1);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.greater(0L, 1);
		assertEquals(expected, actual);
	}

	@Test
	public void testSmallerIntegerInteger() {
		boolean expected = false;
		boolean actual = cFunction.smaller(1, 1);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.smaller(1, 2);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.smaller(1, 0);
		assertEquals(expected, actual);
	}

	@Test
	public void testSmallerFloatFloat() {
		boolean expected = false;
		boolean actual = cFunction.smaller(1.0F, 1.0F);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.smaller(1.0F, 1.1F);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.smaller(1.0F, 0.9F);
		assertEquals(expected, actual);
	}

	@Test
	public void testSmallerDoubleDouble() {
		boolean expected = false;
		boolean actual = cFunction.smaller(1.0, 1.0);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.smaller(1.0, 1.1);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.smaller(1.0, 0.9);
		assertEquals(expected, actual);
	}

	@Test
	public void testSmallerLongLong() {
		boolean expected = false;
		boolean actual = cFunction.smaller(1L, 1L);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.smaller(0L, 1L);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.smaller(1L, 0L);
		assertEquals(expected, actual);
	}

	@Test
	public void testSmallerIntegerFloat() {
		boolean expected = false;
		boolean actual = cFunction.smaller(1, 1.0F);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.smaller(1, 1.1F);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.smaller(1, 0.9F);
		assertEquals(expected, actual);
	}

	@Test
	public void testSmallerIntegerDouble() {
		boolean expected = false;
		boolean actual = cFunction.smaller(1, 1.0);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.smaller(1, 1.1);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.smaller(1, 0.9);
		assertEquals(expected, actual);
	}

	@Test
	public void testSmallerIntegerLong() {
		boolean expected = false;
		boolean actual = cFunction.smaller(1, 1L);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.smaller(1, 2L);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.smaller(1, 0L);
		assertEquals(expected, actual);
	}

	@Test
	public void testSmallerFloatInteger() {
		boolean expected = false;
		boolean actual = cFunction.smaller(1.0F, 1);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.smaller(0.9F, 1);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.smaller(1.1F, 1);
		assertEquals(expected, actual);
	}

	@Test
	public void testSmallerFloatDouble() {
		boolean expected = false;
		boolean actual = cFunction.smaller(1.0F, 1.0);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.smaller(0.9F, 1.0);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.smaller(1.1F, 1.0);
		assertEquals(expected, actual);
	}

	@Test
	public void testSmallerDoubleInteger() {
		boolean expected = false;
		boolean actual = cFunction.smaller(1.0, 1);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.smaller(0.9, 1);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.smaller(1.1, 1);
		assertEquals(expected, actual);
	}

	@Test
	public void testSmallerDoubleFloat() {
		boolean expected = false;
		boolean actual = cFunction.smaller(1.0, 1.0F);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.smaller(0.9, 1.0F);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.smaller(1.1, 1.0F);
		assertEquals(expected, actual);
	}

	@Test
	public void testSmallerDoubleLong() {
		boolean expected = false;
		boolean actual = cFunction.smaller(1.0, 1L);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.smaller(0.9, 1L);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.smaller(1.1, 1L);
		assertEquals(expected, actual);
	}

	@Test
	public void testSmallerLongInteger() {
		boolean expected = false;
		boolean actual = cFunction.smaller(1L, 1);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.smaller(0L, 1L);
		assertEquals(expected, actual);
		expected = false;
		actual = cFunction.smaller(1L, 0L);
		assertEquals(expected, actual);
	}

	@Test
	public void testNot() {
		boolean expected = false;
		boolean actual = cFunction.not(true);
		assertEquals(expected, actual);
		expected = true;
		actual = cFunction.not(false);
	}

	@Test
	public void testComplement() {
		int expected = -3;
		int actual = cFunction.complement(2);
		assertEquals(expected, actual);
	}
}
