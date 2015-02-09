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
import org.yakindu.scr.stringexpressions.StringExpressionsStatemachine;
import org.yakindu.scr.stringexpressions.StringExpressionsStatemachine.State;
/**
 *  Unit TestCase for StringExpressions
 */
@SuppressWarnings("all")
public class StringExpressionsTest {

	private StringExpressionsStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new StringExpressionsStatemachine();
		statemachine.init();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testStringExpressionsTest() {
		assertTrue(statemachine.getQuotedStringX().equals("\"X\""));
		assertTrue(statemachine.getQuotedStringY().equals("\"Y\""));
		statemachine.enter();
		assertTrue(statemachine
				.isStateActive(State.main_region_AssignmentChecked));
		statemachine.raiseE();
		statemachine.runCycle();
		assertTrue(statemachine
				.isStateActive(State.main_region_VarToVarCompareSucceeded));
		assertTrue(statemachine.getGuardStringEqual());
		assertTrue(statemachine.getGuardStringNotEqual());
		assertTrue(statemachine.getStringVarEqual());
		assertTrue(statemachine.getStringVarNotEqual());
		statemachine.raiseE();
		statemachine.runCycle();
		assertTrue(statemachine
				.isStateActive(State.main_region_VarToConstCompareSucceeded));
		assertTrue(statemachine.getGuardStringEqual());
		assertTrue(statemachine.getGuardStringNotEqual());
		assertTrue(statemachine.getStringVarEqual());
		assertTrue(statemachine.getStringVarNotEqual());
		statemachine.raiseE();
		statemachine.runCycle();
		assertTrue(statemachine
				.isStateActive(State.main_region_ConstToVarCompareSucceeded));
		assertTrue(statemachine.getGuardStringEqual());
		assertTrue(statemachine.getGuardStringNotEqual());
		assertTrue(statemachine.getStringVarEqual());
		assertTrue(statemachine.getStringVarNotEqual());
		statemachine.raiseE();
		statemachine.runCycle();
		assertTrue(statemachine
				.isStateActive(State.main_region_ConstToConstCompareSucceeded));
		assertTrue(statemachine.getGuardStringEqual());
		assertTrue(statemachine.getGuardStringNotEqual());
		assertTrue(statemachine.getStringVarEqual());
		assertTrue(statemachine.getStringVarNotEqual());
	}
}
