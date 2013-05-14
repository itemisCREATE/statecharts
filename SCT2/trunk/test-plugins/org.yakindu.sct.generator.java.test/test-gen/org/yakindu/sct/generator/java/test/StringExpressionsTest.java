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
		assertTrue(statemachine.getQuotedString().equals("\"x\""));
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_StateA));
		assertTrue(statemachine.getMyString().equals("hello"));
		assertTrue(statemachine.getMyString2().equals("world"));
		assertTrue(statemachine.getQuotedString().equals("'y'"));
		statemachine.raiseE1();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_StateB));
		assertTrue(statemachine.getEquals() == false);
		assertTrue(statemachine.getNotEqual() == true);
		assertTrue(statemachine.getQuotedString().equals("\"z\""));
	}
}
