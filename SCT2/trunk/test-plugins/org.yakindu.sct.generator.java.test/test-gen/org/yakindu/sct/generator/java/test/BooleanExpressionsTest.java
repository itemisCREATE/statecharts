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
import org.yakindu.scr.booleanexpressions.BooleanExpressionsStatemachine;
import org.yakindu.scr.booleanexpressions.BooleanExpressionsStatemachine.State;
/**
 *  Unit TestCase for BooleanExpressions
 */
@SuppressWarnings("all")
public class BooleanExpressionsTest {

	private BooleanExpressionsStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new BooleanExpressionsStatemachine();
		statemachine.init();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testbooleanExpressions() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_StateA));
		assertTrue(statemachine.getMyBool1() == true);
		assertTrue(statemachine.getMyBool2() == false);
		statemachine.raiseE1();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_StateB));
		assertTrue(statemachine.getAnd() == false);
		assertTrue(statemachine.getOr() == true);
		assertTrue(statemachine.getNot() == false);
		assertTrue(statemachine.getEqual() == false);
		assertTrue(statemachine.getNotequal() == true);
	}
}
