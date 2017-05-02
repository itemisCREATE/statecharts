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
import org.yakindu.scr.exitstate.ExitStateStatemachine;
import org.yakindu.scr.exitstate.ExitStateStatemachine.State;

/**
 * Unit TestCase for ExitState
 */
@SuppressWarnings("all")
public class ExitStateTest {
	private ExitStateStatemachine statemachine;	
	
	@Before
	public void setUp() {
		statemachine = new ExitStateStatemachine();
		statemachine.init();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}
	
	@Test
	public void testDefaultExit() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.r_A));
		statemachine.raiseE();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.r_E));
	}
	@Test
	public void testNamedExitThroughNamedTransition() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.r_A));
		statemachine.raiseF();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.r_F));
	}
	@Test
	public void testNamedExitThroughDefaultTransition() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.r_A));
		statemachine.raiseG();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.r_E));
	}
	@Test
	public void testRemainInA() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.r_A));
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.r_A));
	}
}
