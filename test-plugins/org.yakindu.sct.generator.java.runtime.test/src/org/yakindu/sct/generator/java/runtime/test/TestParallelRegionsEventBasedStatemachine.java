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
import org.yakindu.sct.runtime.java.RuntimeService;
import org.yakindu.sct.runtime.java.test_parallelregions.DefaultInterface;
import org.yakindu.sct.runtime.java.test_parallelregions.Test_ParallelRegionsCycleBasedStatemachine.State;
import org.yakindu.sct.runtime.java.test_parallelregions.Test_ParallelRegionsEventBasedStatemachine;

/**
 * Testcases for 'InterfaceTest' cycle based statemachine.
 * 
 * @author muehlbrandt
 * 
 */
public class TestParallelRegionsEventBasedStatemachine {

	private Test_ParallelRegionsEventBasedStatemachine sm;
	
	private RuntimeService runtimeService;

	// Minimal cycletime
	private final long cyclePeriod = 1;

	@Before
	public void setUp() {
		sm = new Test_ParallelRegionsEventBasedStatemachine();
		sm.init();
		sm.enter();
		runtimeService = new RuntimeService(cyclePeriod);
		runtimeService.addStatemachine(sm);
	}

	@After
	public void tearDown() {
		sm = null;
	}

	@Test
	public void testStatemachineEnter() {
		assertTrue("Statemachine isn't in State: " + State.State1.name() + ".",
				sm.isStateActive(State.State1));
	}

	@Test
	public void testStatemachineHierarchyLevelOne() throws InterruptedException {
		sm.getDefaultInterface().raiseEvent1();
		Thread.sleep(5);
		// Test if state is changed to State3 && State7
		assertTrue(sm.isStateActive(State.State3));
		assertTrue(sm.isStateActive(State.State7));

		sm.getDefaultInterface().raiseEvent5();
		Thread.sleep(5);
		// Test if state is changed to State3 && State8
		assertTrue(sm.isStateActive(State.State3));
		assertTrue(sm.isStateActive(State.State8));
		assertFalse(sm.isStateActive(State.State7));

		sm.getDefaultInterface().raiseEvent6();
		Thread.sleep(5);
		// Test if state is changed to State3 && State7
		assertTrue(sm.isStateActive(State.State3));
		assertTrue(sm.isStateActive(State.State7));
		assertFalse(sm.isStateActive(State.State8));

		sm.getDefaultInterface().raiseEvent3();
		Thread.sleep(5);
		// Test if state is back to State1
		assertTrue(sm.isStateActive(State.State1));
		assertFalse(sm.isStateActive(State.State3));
		assertFalse(sm.isStateActive(State.State7));
		assertFalse(sm.isStateActive(State.State8));
	}

	@Test
	public void testStatemachineHierarchyLevelTwo() throws InterruptedException {
		sm.getDefaultInterface().raiseEvent1();
		Thread.sleep(5);
		// Test if state is changed to State3 && State7
		assertTrue(sm.isStateActive(State.State3));
		assertTrue(sm.isStateActive(State.State7));

		sm.getDefaultInterface().raiseEvent2();
		Thread.sleep(5);
		// Test if state is changed to State9, State5 and State7
		assertTrue(sm.isStateActive(State.State9));
		assertTrue(sm.isStateActive(State.State5));
		assertTrue(sm.isStateActive(State.State7));

		sm.getDefaultInterface().raiseEvent3();
		Thread.sleep(5);
		// Test if state is changed to State9, State6 and State8
		assertTrue(sm.isStateActive(State.State9));
		assertTrue(sm.isStateActive(State.State6));
		assertFalse(sm.isStateActive(State.State7));
		assertTrue(sm.isStateActive(State.State8));

		sm.getDefaultInterface().raiseEvent6();
		Thread.sleep(5);
		// Test if state is changed to State9, State6 and State8
		assertTrue(sm.isStateActive(State.State9));
		assertTrue(sm.isStateActive(State.State6));
		assertTrue(sm.isStateActive(State.State7));
		assertFalse(sm.isStateActive(State.State8));
	}

	@Test
	public void testEntryAndExitExecution() throws InterruptedException {
		DefaultInterface di = sm.getDefaultInterface();

		di.raiseEvent1();
		Thread.sleep(5);
		// Exit State1
		int hierarchy = 2;
		// Entry State2
		hierarchy += 3;
		assertEquals(7, di.getVarReg3());
		assertEquals(hierarchy, di.getVarHierarchy());

		di.raiseEvent5();
		Thread.sleep(5);
		assertEquals(8, di.getVarReg3());

		di.raiseEvent6();
		Thread.sleep(5);
		di.raiseEvent3();
		Thread.sleep(5);
		// Exit State1
		hierarchy = 2;
		assertEquals(-1, di.getVarReg3());
		assertEquals(hierarchy, di.getVarHierarchy());

		di.raiseEvent1();
		Thread.sleep(5);
		// Entry State2
		hierarchy += 3;

		di.raiseEvent2();
		Thread.sleep(5);
		// Entry State4
		hierarchy *= 4;
		// Entry State9
		hierarchy += 10;
		// Entry State5
		hierarchy += 5;
		assertEquals(hierarchy, di.getVarHierarchy());

		di.raiseEvent8();
		Thread.sleep(5);
		// Exit State9
		hierarchy -= 10;
		// Exit State5
		hierarchy -= 5;
		// Exit State 4
		hierarchy /= 4;
		// Exit State 2
		hierarchy -= 3;
		assertEquals(hierarchy, di.getVarHierarchy());

		//Jump to State6 && State9
		di.raiseEvent11();
		Thread.sleep(5);
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
		assertEquals(hierarchy, di.getVarHierarchy());
	}


}
