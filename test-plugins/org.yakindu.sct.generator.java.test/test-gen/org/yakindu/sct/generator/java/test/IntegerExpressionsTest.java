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
import org.yakindu.scr.integerexpressions.IntegerExpressionsStatemachine;
import org.yakindu.scr.integerexpressions.IntegerExpressionsStatemachine.State;
/**
 *  Unit TestCase for IntegerExpressions
 */
@SuppressWarnings("all")
public class IntegerExpressionsTest {

	private IntegerExpressionsStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new IntegerExpressionsStatemachine();
		statemachine.init();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testintegerExpressions() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_StateA));
		assertTrue(statemachine.getMyInt1() == 10);
		assertTrue(statemachine.getMyInt2() == 5);
		statemachine.raiseE1();
		statemachine.runCycle();
		assertTrue(statemachine.getLess() == false);
		assertTrue(statemachine.getGreater() == true);
		assertTrue(statemachine.getEqualOrLess() == false);
		assertTrue(statemachine.getEqualOrGreater() == true);
		assertTrue(statemachine.getEqual() == false);
		assertTrue(statemachine.getNotEqual() == true);
		assertTrue(statemachine.getPlus() == 15);
		assertTrue(statemachine.getMinus() == 5);
		assertTrue(statemachine.getMultiply() == 50);
		assertTrue(statemachine.getDivision() == 2);
		assertTrue(statemachine.getModulo() == 0);
		assertTrue(statemachine.getNegat() == -10);
		assertTrue(statemachine.getMultiAssign() == 20);
		assertTrue(statemachine.getDivAssign() == 2);
		assertTrue(statemachine.getPlusAssign() == 12);
		assertTrue(statemachine.getMinusAssign() == -8);
		assertTrue(statemachine.getModuloAssign() == 0);
	}
}
