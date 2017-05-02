/**
* Copyright (c) 2017 committers of YAKINDU and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*     committers of YAKINDU - initial API and implementation
*/

package org.yakindu.sct.generator.java.test;

import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.triggerexpressionprecedence.TriggerExpressionPrecedenceStatemachine;
import org.yakindu.scr.triggerexpressionprecedence.TriggerExpressionPrecedenceStatemachine.State;

/**
 * Unit TestCase for TriggerExpressionPrecedence
 */
@SuppressWarnings("all")
public class TriggerExpressionPrecedenceTest {
	private TriggerExpressionPrecedenceStatemachine statemachine;	
	
	@Before
	public void setUp() {
		statemachine = new TriggerExpressionPrecedenceStatemachine();
		statemachine.init();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}
	
	@Test
	public void testUnsatisfiedTriggerAndFGuardFalseOrFalse() {
		statemachine.enter();
		statemachine.setC1(false);
		statemachine.setC2(false);
		statemachine.runCycle();
		assertTrue(!statemachine.getE1_transition());
	}
	@Test
	public void testUnsatisfiedTriggerAndFGuardTrueOrFalse() {
		statemachine.enter();
		statemachine.setC1(true);
		statemachine.setC2(false);
		statemachine.runCycle();
		assertTrue(!statemachine.getE1_transition());
	}
	@Test
	public void testUnsatisfiedTriggerAndFGuardFalseOrTrue() {
		statemachine.enter();
		statemachine.setC1(false);
		statemachine.setC2(true);
		statemachine.runCycle();
		assertTrue(!statemachine.getE1_transition());
	}
	@Test
	public void testUnsatisfiedTriggerAndFGuardTrueOrTrue() {
		statemachine.enter();
		statemachine.setC1(true);
		statemachine.setC2(true);
		statemachine.runCycle();
		assertTrue(!statemachine.getE1_transition());
	}
}
