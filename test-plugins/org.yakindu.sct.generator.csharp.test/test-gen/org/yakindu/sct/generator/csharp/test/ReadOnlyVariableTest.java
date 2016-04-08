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

package org.yakindu.sct.generator.csharp.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.yakindu.scr.readonlyvariable.ReadOnlyVariableStatemachine;
import org.yakindu.scr.readonlyvariable.ReadOnlyVariableStatemachine.State;
/**
 *  Unit TestCase for ReadOnlyVariable
 */
@SuppressWarnings("all")
public class ReadOnlyVariableTest {

	private ReadOnlyVariableStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new ReadOnlyVariableStatemachine();
		statemachine.init();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testReadOnlyVariableTest() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_StateA));
		assertTrue(statemachine.getMyInt() == 0l);
		assertTrue(statemachine.getMyString().equals("testString"));
		assertTrue(statemachine.getMyBool() == true);
		assertTrue(statemachine.getMyReal() == 1.1d);
		assertTrue(statemachine.getSCIA().getMyInt() == 0l);
		assertTrue(statemachine.getSCIA().getMyString().equals("testString"));
		assertTrue(statemachine.getSCIA().getMyBool() == true);
		assertTrue(statemachine.getSCIA().getMyReal() == 1.1d);
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_StateB));
		assertTrue(statemachine.getMyInt() == 100l);
		assertTrue(statemachine.getMyString().equals("fail"));
		assertTrue(statemachine.getMyBool() == false);
		assertTrue(statemachine.getMyReal() == 6.6d);
		assertTrue(statemachine.getSCIA().getMyInt() == 200l);
		assertTrue(statemachine.getSCIA().getMyString().equals("A_fail"));
		assertTrue(statemachine.getSCIA().getMyBool() == false);
		assertTrue(statemachine.getSCIA().getMyReal() == 7.7d);
	}
}
