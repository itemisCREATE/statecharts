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
import org.yakindu.scr.deephistory.DeepHistoryStatemachine;
import org.yakindu.scr.deephistory.DeepHistoryStatemachine.State;
/**
 *  Unit TestCase for DeepHistory
 */
@SuppressWarnings("all")
public class DeepHistoryTest {

	private DeepHistoryStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new DeepHistoryStatemachine();
		statemachine.init();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testdeepHistoryTest() {
		statemachine.enter();
		statemachine.raiseEvent1();
		statemachine.runCycle();
		statemachine.raiseEvent3();
		statemachine.runCycle();
		statemachine.raiseEvent5();
		statemachine.runCycle();
		statemachine.raiseEvent7();
		statemachine.runCycle();
		assertTrue(!statemachine.isStateActive(State.mainRegion_State1));
		assertTrue(statemachine
				.isStateActive(State.mainRegion_State2__region0_State4__region0_State7__region0_State9));
		statemachine.raiseEvent2();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.mainRegion_State1));
		assertTrue(!statemachine
				.isStateActive(State.mainRegion_State2__region0_State4__region0_State7__region0_State9));
		statemachine.raiseEvent1();
		statemachine.runCycle();
		assertTrue(!statemachine.isStateActive(State.mainRegion_State1));
		assertTrue(statemachine
				.isStateActive(State.mainRegion_State2__region0_State4__region0_State7__region0_State9));
	}
}
