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

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

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
		assertFalse(cFunction.equals(true, false));
		assertTrue(cFunction.equals(true, true));
	}

	@Test
	public void testEqualsEObjectEObject() {
		assertTrue(cFunction.equals(obj1, obj2));
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
	public void testEqualsFloatDouble() {
		assertTrue(cFunction.equals(1.0F, 1.0));
		assertTrue(cFunction.equals(1.5F, 1.5));
		//Since Java and C are not able to compare 
		//float and double values with absolute precision -> 1.3F != 1.3  
		assertFalse(cFunction.equals(1.3F, 1.3));
	}

	@Test
	public void testEqualsDoubleInteger() {
		assertTrue(cFunction.equals(1.0, 1));
		assertFalse(cFunction.equals(1.1, 1));
	}

	@Test
	public void testEqualsDoubleFloat() {
		//Since Java and C are not able to compare 
		//float and double values with absolute precision -> 1.3 != 1.3F  
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
	public void testNotEqualsEObjectEObject() {
		assertFalse(cFunction.notEquals(obj1, obj1));

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
		assertTrue(cFunction.greaterEqual(1.0, 1.0F));
		assertTrue(cFunction.greaterEqual(2.0, 1.0F));
		assertFalse(cFunction.greaterEqual(1.0, 1.1F));
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
	public void testSmallerEqualFloatDouble() {
		assertTrue(cFunction.smallerEqual(1.0F, 1.0));
		assertTrue(cFunction.smallerEqual(1.5F, 1.5));
		assertTrue(cFunction.smallerEqual(1.1F, 1.2));
		//Since Java and C are not able to compare 
		//float and double values with absolute precision -> 1.2 ! <= 1.2F
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
	public void testNot() {
		assertTrue(cFunction.not(false));
		assertFalse(cFunction.not(true));
	}

	@Test
	public void testComplement() {
		int expected = -3;
		int actual = cFunction.complement(2);
		assertEquals(expected, actual);
	}
}
