/**
 * Copyright (c) 2015 committers of YAKINDU and others.
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
		assertTrue(statemachine.getMyBit1() == 5l);
		assertTrue(statemachine.getMyBit2() == 7l);
		statemachine.raiseE1();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_StateB));
		assertTrue(statemachine.getLeftBitshift() == 10l);
		assertTrue(statemachine.getRightBitshift() == 2l);
		assertTrue(statemachine.getComplementBitshift() == -6l);
		assertTrue(statemachine.getBitwiseAnd() == 5l);
		assertTrue(statemachine.getBitwiseOr() == 7l);
		assertTrue(statemachine.getBitwiseXor() == 2l);
	}
}
