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
import org.yakindu.scr.enterstate.EnterStateStatemachine;
import org.yakindu.scr.enterstate.EnterStateStatemachine.State;
/**
 *  Unit TestCase for EnterState
 */
@SuppressWarnings("all")
public class EnterStateTest {

	private EnterStateStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new EnterStateStatemachine();
		statemachine.init();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testdefaultEntry() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.r_A));
		statemachine.raiseE();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.r_B_r_E));
	}
	@Test
	public void testnamedEntryThroughNamedTransition() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.r_A));
		statemachine.raiseF();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.r_B_r_F));
	}
	@Test
	public void testnamedEntryThroughDefaultTransition() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.r_A));
		statemachine.raiseG();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.r_B_r_E));
	}
}
