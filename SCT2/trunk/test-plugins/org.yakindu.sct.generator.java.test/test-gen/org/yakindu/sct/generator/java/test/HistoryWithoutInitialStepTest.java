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
import org.yakindu.scr.historywithoutinitialstep.HistoryWithoutInitialStepStatemachine;
import org.yakindu.scr.historywithoutinitialstep.HistoryWithoutInitialStepStatemachine.State;
/**
 *  Unit TestCase for HistoryWithoutInitialStep
 */
@SuppressWarnings("all")
public class HistoryWithoutInitialStepTest {

	private HistoryWithoutInitialStepStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new HistoryWithoutInitialStepStatemachine();
		statemachine.init();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testenterThroughInitialEntry() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		statemachine.raiseE1();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_B_r1_C));
		statemachine.raiseE2();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_B_r1_D));
	}
	@Test
	public void testenterCThroughHistory() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		statemachine.raiseE1();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_B_r1_C));
		statemachine.raiseE1();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		statemachine.raiseE2();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_B_r1_C));
	}
	@Test
	public void testenterDThroughHistory() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		statemachine.raiseE1();
		statemachine.runCycle();
		statemachine.raiseE2();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_B_r1_D));
		statemachine.raiseE1();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		statemachine.raiseE2();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_B_r1_D));
	}
}
