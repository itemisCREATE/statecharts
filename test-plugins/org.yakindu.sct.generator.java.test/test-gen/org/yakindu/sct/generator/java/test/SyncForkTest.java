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
import org.yakindu.scr.syncfork.SyncForkStatemachine;
import org.yakindu.scr.syncfork.SyncForkStatemachine.State;
/**
 *  Unit TestCase for SyncFork
 */
@SuppressWarnings("all")
public class SyncForkTest {

	private SyncForkStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new SyncForkStatemachine();
		statemachine.init();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testsyncForkTest() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		statemachine.raiseF();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_B));
		assertTrue(statemachine.isStateActive(State.main_region_B_r1_C1));
		assertTrue(statemachine.isStateActive(State.main_region_B_r2_D1));
		statemachine.raiseF();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_B));
		assertTrue(statemachine.isStateActive(State.main_region_B_r1_C2));
		assertTrue(statemachine.isStateActive(State.main_region_B_r2_D2));
		statemachine.raiseE();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		statemachine.raiseF();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_B));
		assertTrue(statemachine.isStateActive(State.main_region_B_r1_C1));
		assertTrue(statemachine.isStateActive(State.main_region_B_r2_D1));
	}
}
