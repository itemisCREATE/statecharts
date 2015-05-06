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
import org.yakindu.scr.conditionalexpressions.ConditionalExpressionsStatemachine;
import org.yakindu.scr.conditionalexpressions.ConditionalExpressionsStatemachine.State;
/**
 *  Unit TestCase for ConditionalExpressions
 */
@SuppressWarnings("all")
public class ConditionalExpressionTest {

	private ConditionalExpressionsStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new ConditionalExpressionsStatemachine();
		statemachine.init();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testConditionalExpressionTest() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		assertTrue(statemachine.getCondition() == 1l);
		statemachine.raiseE();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_B));
		assertTrue(statemachine.getCondition() == 2l);
	}
}
