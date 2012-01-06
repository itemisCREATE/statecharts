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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.yakindu.sct.runtime.java.test_parallelregions.Test_ParallelRegionsCycleBasedStatemachine;
import org.yakindu.sct.runtime.java.test_parallelregions.Test_ParallelRegionsCycleBasedStatemachine.State;

/**
 * Testcases for 'InterfaceTest' cycle based statemachine.
 * 
 * @author muehlbrandt
 * 
 */
public class TestParallelRegionsCycleBasedStatemachine {

	private Test_ParallelRegionsCycleBasedStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new Test_ParallelRegionsCycleBasedStatemachine();
		statemachine.init();
		statemachine.enter();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testStatemachineEnter() {
		assertTrue("Statemachine isn't in State: " + State.State1.name() + ".",
				statemachine.isStateActive(State.State1));
	}

	@Test
	public void testStatemachineHierarchyLevelOne() {
		statemachine.getDefaultInterface().raiseEvent1();
		statemachine.runCycle();
		// Test if state is changed to State3 && State7
		assertTrue("Statemachine isn't in State: " + State.State3.name() + ".",
				statemachine.isStateActive(State.State3));
		assertTrue("Statemachine isn't in State: " + State.State7.name() + ".",
				statemachine.isStateActive(State.State7));

		statemachine.getDefaultInterface().raiseEvent5();
		statemachine.runCycle();
		// Test if state is changed to State3 && State8
		assertTrue("Statemachine isn't in State: " + State.State3.name() + ".",
				statemachine.isStateActive(State.State3));
		assertTrue("Statemachine isn't in State: " + State.State8.name() + ".",
				statemachine.isStateActive(State.State8));
		assertFalse(
				"Statemachine isn't in State: " + State.State7.name() + ".",
				statemachine.isStateActive(State.State7));

		statemachine.getDefaultInterface().raiseEvent6();
		statemachine.runCycle();
		// Test if state is changed to State3 && State7
		assertTrue("Statemachine isn't in State: " + State.State3.name() + ".",
				statemachine.isStateActive(State.State3));
		assertTrue("Statemachine isn't in State: " + State.State7.name() + ".",
				statemachine.isStateActive(State.State7));
		assertFalse(
				"Statemachine isn't in State: " + State.State8.name() + ".",
				statemachine.isStateActive(State.State8));

		statemachine.getDefaultInterface().raiseEvent3();
		statemachine.runCycle();
		// Test if state is back to State1
		assertTrue(statemachine.isStateActive(State.State1));
		assertFalse(statemachine.isStateActive(State.State3));
		assertFalse(statemachine.isStateActive(State.State7));
		assertFalse(statemachine.isStateActive(State.State8));
	}

	@Test
	public void testStatemachineHierarchyLevelTwo() {
		statemachine.getDefaultInterface().raiseEvent1();
		statemachine.runCycle();
		// Test if state is changed to State3 && State7
		assertTrue("Statemachine isn't in State: " + State.State3.name() + ".",
				statemachine.isStateActive(State.State3));
		assertTrue("Statemachine isn't in State: " + State.State7.name() + ".",
				statemachine.isStateActive(State.State7));

		statemachine.getDefaultInterface().raiseEvent2();
		statemachine.runCycle();
		// Test if state is changed to State9, State5 and State7
		assertTrue("Statemachine isn't in State: " + State.State9.name() + ".",
				statemachine.isStateActive(State.State9));
		assertTrue("Statemachine isn't in State: " + State.State5.name() + ".",
				statemachine.isStateActive(State.State5));
		assertTrue("Statemachine isn't in State: " + State.State7.name() + ".",
				statemachine.isStateActive(State.State7));
		assertFalse(
				"Statemachine isn't in State: " + State.State8.name() + ".",
				statemachine.isStateActive(State.State8));

		statemachine.getDefaultInterface().raiseEvent3();
		statemachine.runCycle();
		// Test if state is changed to State9, State6 and State8
		assertTrue("Statemachine isn't in State: " + State.State9.name() + ".",
				statemachine.isStateActive(State.State9));
		assertTrue("Statemachine isn't in State: " + State.State6.name() + ".",
				statemachine.isStateActive(State.State6));
		assertFalse(
				"Statemachine isn't in State: " + State.State7.name() + ".",
				statemachine.isStateActive(State.State7));
		assertTrue("Statemachine isn't in State: " + State.State8.name() + ".",
				statemachine.isStateActive(State.State8));

		statemachine.getDefaultInterface().raiseEvent6();
		statemachine.runCycle();
		// Test if state is changed to State9, State6 and State8
		assertTrue("Statemachine isn't in State: " + State.State9.name() + ".",
				statemachine.isStateActive(State.State9));
		assertTrue("Statemachine isn't in State: " + State.State6.name() + ".",
				statemachine.isStateActive(State.State6));
		assertTrue("Statemachine isn't in State: " + State.State7.name() + ".",
				statemachine.isStateActive(State.State7));
		assertFalse(
				"Statemachine isn't in State: " + State.State8.name() + ".",
				statemachine.isStateActive(State.State8));
	}

}
