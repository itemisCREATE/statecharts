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
import org.yakindu.scr.guardedentry.GuardedEntryStatemachine;
import org.yakindu.scr.guardedentry.GuardedEntryStatemachine.State;

/**
 * Unit TestCase for GuardedEntry
 */
@SuppressWarnings("all")
public class GuardedEntryTest {
	private GuardedEntryStatemachine statemachine;	
	
	@Before
	public void setUp() {
		statemachine = new GuardedEntryStatemachine();
		statemachine.init();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}
	
	@Test
	public void testEntryNotTakenOnStatechartEnter() {
		assertTrue(statemachine.getGuard() == false);
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		assertTrue(statemachine.getDone() == false);
	}
	@Test
	public void testEntryTakenOnStatechartEnter() {
		statemachine.setGuard(true);
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		assertTrue(statemachine.getDone() == true);
	}
	@Test
	public void testEntryTakenInTransition() {
		initEntryInTransition(true,false);
		assertTrue(statemachine.getDone());
	}
	@Test
	public void testEntryNotTakenInTransition() {
		initEntryInTransition(false,false);
		assertTrue(!statemachine.getDone());
	}
	public void initEntryInTransition(boolean guardVar, boolean doneVar) {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		statemachine.raiseE();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_B));
		statemachine.setGuard(guardVar);
		statemachine.setDone(doneVar);
		statemachine.raiseE();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_A));
	}
}
