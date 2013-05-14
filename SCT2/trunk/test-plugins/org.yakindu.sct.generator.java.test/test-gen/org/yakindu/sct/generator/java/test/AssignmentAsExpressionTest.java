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
import org.yakindu.scr.assignmentasexpression.AssignmentAsExpressionStatemachine;
import org.yakindu.scr.assignmentasexpression.AssignmentAsExpressionStatemachine.State;
/**
 *  Unit TestCase for AssignmentAsExpression
 */
@SuppressWarnings("all")
public class AssignmentAsExpressionTest {

	private AssignmentAsExpressionStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new AssignmentAsExpressionStatemachine();
		statemachine.init();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testsimpleAssignment() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_Add));
		assertTrue(statemachine.getB() == 5);
		assertTrue(statemachine.getA() == 9);
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_Subtract));
		assertTrue(statemachine.getD() == 6);
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_Multiply));
		assertTrue(statemachine.getE() == 15);
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_Divide));
		assertTrue(statemachine.getG() == 1);
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_Modulo));
		assertTrue(statemachine.getI() == 1);
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_Shift));
		assertTrue(statemachine.getJ() == 16);
		assertTrue(statemachine.getK() == 4);
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_boolean_And));
		assertTrue(statemachine.getL() == 1);
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_boolean_Or));
		assertTrue(statemachine.getP() == 15);
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_boolean_Xor));
		assertTrue(statemachine.getU() == 12);
		statemachine.exit();
	}
}
