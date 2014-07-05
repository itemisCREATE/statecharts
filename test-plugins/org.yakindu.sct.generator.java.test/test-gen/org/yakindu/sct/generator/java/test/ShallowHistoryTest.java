/**
 * Copyright (c) 2014 committers of YAKINDU and others.
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
import org.yakindu.scr.shallowhistory.ShallowHistoryStatemachine;
import org.yakindu.scr.shallowhistory.ShallowHistoryStatemachine.State;
/**
 *  Unit TestCase for ShallowHistory
 */
@SuppressWarnings("all")
public class ShallowHistoryTest {

	private ShallowHistoryStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new ShallowHistoryStatemachine();
		statemachine.init();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testshallowHistoryTest() {
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
		statemachine.raiseEvent6();
		statemachine.runCycle();
		assertTrue(!statemachine
				.isStateActive(State.mainRegion_State2__region0_State4__region0_State7__region0_State9));
		assertTrue(statemachine
				.isStateActive(State.mainRegion_State2__region0_State4__region0_State6));
		statemachine.raiseEvent5();
		statemachine.runCycle();
		assertTrue(!statemachine
				.isStateActive(State.mainRegion_State2__region0_State4__region0_State7__region0_State8));
		assertTrue(statemachine
				.isStateActive(State.mainRegion_State2__region0_State4__region0_State7__region0_State9));
		statemachine.raiseEvent2();
		statemachine.runCycle();
		assertTrue(!statemachine
				.isStateActive(State.mainRegion_State2__region0_State4__region0_State7__region0_State9));
		assertTrue(statemachine.isStateActive(State.mainRegion_State1));
		statemachine.raiseEvent1();
		statemachine.runCycle();
		assertTrue(statemachine
				.isStateActive(State.mainRegion_State2__region0_State4__region0_State6));
		assertTrue(!statemachine.isStateActive(State.mainRegion_State1));
		statemachine.raiseEvent5();
		statemachine.runCycle();
		assertTrue(!statemachine
				.isStateActive(State.mainRegion_State2__region0_State4__region0_State6));
		assertTrue(statemachine
				.isStateActive(State.mainRegion_State2__region0_State4__region0_State7__region0_State9));
	}
}
