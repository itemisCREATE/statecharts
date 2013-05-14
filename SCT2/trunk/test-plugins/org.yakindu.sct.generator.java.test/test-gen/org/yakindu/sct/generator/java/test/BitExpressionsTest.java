/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.java.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.yakindu.scr.bitexpressions.BitExpressionsStatemachine;
import org.yakindu.scr.bitexpressions.BitExpressionsStatemachine.State;
/**
 *  Unit TestCase for BitExpressions
 */
@SuppressWarnings("all")
public class BitExpressionsTest {

	private BitExpressionsStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new BitExpressionsStatemachine();
		statemachine.init();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testBitExpressions() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_StateA));
		assertTrue(statemachine.getMyBit1() == 5);
		assertTrue(statemachine.getMyBit2() == 7);
		statemachine.raiseE1();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_StateB));
		assertTrue(statemachine.getLeftBitshift() == 10);
		assertTrue(statemachine.getRightBitshift() == 2);
		assertTrue(statemachine.getComplementBitshift() == -6);
		assertTrue(statemachine.getBitwiseAnd() == 5);
		assertTrue(statemachine.getBitwiseOr() == 7);
		assertTrue(statemachine.getBitwiseXor() == 2);
	}
}
