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
import org.yakindu.scr.entryexitselftransition.EntryExitSelfTransitionStatemachine;
import org.yakindu.scr.entryexitselftransition.EntryExitSelfTransitionStatemachine.State;
/**
 *  Unit TestCase for EntryExitSelfTransition
 */
@SuppressWarnings("all")
public class EntryExitSelfTransitionTest {

	private EntryExitSelfTransitionStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new EntryExitSelfTransitionStatemachine();
		statemachine.init();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testSelfTransitionToChildState() {
		statemachine.enter();
		statemachine.runCycle();
		assertTrue(statemachine.getEntries() == 1);
		assertTrue(statemachine.isStateActive(State.main_region_A__region0_B));
		statemachine.setEntries(0);
		statemachine.raiseE();
		statemachine.runCycle();
		assertTrue(statemachine.getEntries() == 1);
		assertTrue(statemachine.getExits() == 1);
		assertTrue(statemachine.isStateActive(State.main_region_A__region0_C));
	}
	@Test
	public void testSelfTransitionFromChildState() {
		statemachine.enter();
		statemachine.runCycle();
		assertTrue(statemachine.getEntries() == 1);
		statemachine.setEntries(0);
		statemachine.raiseE1();
		statemachine.runCycle();
		assertTrue(statemachine.getEntries() == 0);
		assertTrue(statemachine.getExits() == 0);
		assertTrue(statemachine.isStateActive(State.main_region_A__region0_C));
		statemachine.raiseE1();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_A__region0_B));
		assertTrue(statemachine.getEntries() == 1);
		assertTrue(statemachine.getExits() == 1);
	}
}
