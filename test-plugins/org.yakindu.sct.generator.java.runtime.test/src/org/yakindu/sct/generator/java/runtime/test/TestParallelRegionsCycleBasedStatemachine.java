/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	@author markus muehlbrandt - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.java.runtime.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.yakindu.sct.generator.java.runtime.cyclebased.test_parallelregions.Test_ParallelRegionsStatemachine;
import org.yakindu.sct.generator.java.runtime.cyclebased.test_parallelregions.Test_ParallelRegionsStatemachine.State;

/**
 * Testcases for 'InterfaceTest' cycle based statemachine.
 * 
 * @author muehlbrandt
 * 
 */
public class TestParallelRegionsCycleBasedStatemachine {

	private Test_ParallelRegionsStatemachine sm;

	@Before
	public void setUp() {
		sm = new Test_ParallelRegionsStatemachine();
		sm.init();
		sm.enter();
	}

	@After
	public void tearDown() {
		sm = null;
	}

	@Test
	public void testStatemachineEnter() {
		assertTrue("Statemachine isn't in State: " + State.MainRegion_State1.name() + ".",
				sm.isStateActive(State.MainRegion_State1));
	}

	@Test
	public void testStatemachineHierarchyLevelOne() {
		sm.raiseEvent1();
		sm.runCycle();
		// Test if state is changed to State3 && State7
		assertTrue(sm.isStateActive(State.MainRegion_State2_Region1_State3));
		assertTrue(sm.isStateActive(State.MainRegion_State2_Region3_State7));

		sm.raiseEvent5();
		sm.runCycle();
		// Test if state is changed to State3 && State8
		assertTrue(sm.isStateActive(State.MainRegion_State2_Region1_State3));
		assertTrue(sm.isStateActive(State.MainRegion_State2_Region3_State8));
		assertFalse(sm.isStateActive(State.MainRegion_State2_Region3_State7));

		sm.raiseEvent6();
		sm.runCycle();
		// Test if state is changed to State3 && State7
		assertTrue(sm.isStateActive(State.MainRegion_State2_Region1_State3));
		assertTrue(sm.isStateActive(State.MainRegion_State2_Region3_State7));
		assertFalse(sm.isStateActive(State.MainRegion_State2_Region3_State8));

		sm.raiseEvent3();
		sm.runCycle();
		// Test if state is back to State1
		assertTrue(sm.isStateActive(State.MainRegion_State1));
		assertFalse(sm.isStateActive(State.MainRegion_State2_Region1_State3));
		assertFalse(sm.isStateActive(State.MainRegion_State2_Region3_State7));
		assertFalse(sm.isStateActive(State.MainRegion_State2_Region3_State8));
	}

	@Test
	public void testStatemachineHierarchyLevelTwo() {
		sm.raiseEvent1();
		sm.runCycle();
		// Test if state is changed to State3 && State7
		assertTrue(sm.isStateActive(State.MainRegion_State2_Region1_State3));
		assertTrue(sm.isStateActive(State.MainRegion_State2_Region3_State7));

		sm.raiseEvent2();
		sm.runCycle();
		// Test if state is changed to State9, State5 and State7
		assertTrue(sm.isStateActive(State.MainRegion_State2_Region1_State4_Region4_State9));
		assertTrue(sm.isStateActive(State.MainRegion_State2_Region1_State4_Region2_State5));
		assertTrue(sm.isStateActive(State.MainRegion_State2_Region3_State7));

		sm.raiseEvent3();
		sm.runCycle();
		// Test if state is changed to State9, State6 and State8
		assertTrue(sm.isStateActive(State.MainRegion_State2_Region1_State4_Region4_State9));
		assertTrue(sm.isStateActive(State.MainRegion_State2_Region1_State4_Region2_State6));
		assertFalse(sm.isStateActive(State.MainRegion_State2_Region3_State7));
		assertTrue(sm.isStateActive(State.MainRegion_State2_Region3_State8));

		sm.raiseEvent6();
		sm.runCycle();
		// Test if state is changed to State9, State6 and State8
		assertTrue(sm.isStateActive(State.MainRegion_State2_Region1_State4_Region4_State9));
		assertTrue(sm.isStateActive(State.MainRegion_State2_Region1_State4_Region2_State6));
		assertTrue(sm.isStateActive(State.MainRegion_State2_Region3_State7));
		assertFalse(sm.isStateActive(State.MainRegion_State2_Region3_State8));
	}

	@Test
	public void testEntryAndExitExecution() {

		sm.raiseEvent1();
		sm.runCycle();
		// Exit State1
		int hierarchy = 2;
		// Entry State2
		hierarchy += 3;
		assertEquals(7, sm.getReg3());
		assertEquals(hierarchy, sm.getHierarchy());

		sm.raiseEvent5();
		sm.runCycle();
		assertEquals(8, sm.getReg3());

		sm.raiseEvent6();
		sm.runCycle();
		sm.raiseEvent3();
		sm.runCycle();
		// Exit State1
		hierarchy = 2;
		assertEquals(-1, sm.getReg3());
		assertEquals(hierarchy, sm.getHierarchy());

		sm.raiseEvent1();
		sm.runCycle();
		// Entry State2
		hierarchy += 3;

		sm.raiseEvent2();
		sm.runCycle();
		// Entry State4
		hierarchy *= 4;
		// Entry State9
		hierarchy += 10;
		// Entry State5
		hierarchy += 5;
		assertEquals(hierarchy, sm.getHierarchy());

		sm.raiseEvent8();
		sm.runCycle();
		// Exit State9
		hierarchy -= 10;
		// Exit State5
		hierarchy -= 5;
		// Exit State 4
		hierarchy /= 4;
		// Exit State 2
		hierarchy -= 3;
		assertEquals(hierarchy, sm.getHierarchy());

		// Jump to State6 && State9
		sm.raiseEvent11();
		sm.runCycle();
		// Exit State1
		hierarchy = 2;
		// Entry State2
		hierarchy += 3;
		// Entry State4
		hierarchy *= 4;
		// Entry State9
		hierarchy += 10;
		// Entry State6
		hierarchy += 6;
		assertEquals(hierarchy, sm.getHierarchy());
	}

}
