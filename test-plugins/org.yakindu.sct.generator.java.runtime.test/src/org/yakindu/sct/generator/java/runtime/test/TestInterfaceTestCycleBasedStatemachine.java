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
import org.yakindu.sct.generator.java.runtime.cyclebased.interfacetest.InterfaceTestStatemachine;
import org.yakindu.sct.generator.java.runtime.cyclebased.interfacetest.InterfaceTestStatemachine.State;

/**
 * Testcases for 'InterfaceTest' cycle based statemachine.
 * 
 * @author muehlbrandt
 * 
 */
public class TestInterfaceTestCycleBasedStatemachine {

	private InterfaceTestStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new InterfaceTestStatemachine();
		statemachine.init();
		statemachine.enter();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testStatemachineEntry() {
		assertEquals("InterfaceDefault.Var2 is not correct initialized:", 2.3,
				statemachine.getVar2(), Math.pow(10, -8));
		assertEquals("InterfaceDefault.Var3 is not correct initialized:", 1,
				statemachine.getVar3());
		assertTrue("Statemachine isn't in State: " + State.MainRegion_state1.name() + ".",
				statemachine.isStateActive(State.MainRegion_state1));
	}

	@Test
	public void testStatemachineRunCycle_1() {
		statemachine.raiseEvent1();
		statemachine.runCycle();
		// Test if state is changed to State2
		assertTrue("Statemachine isn't in State: " + State.MainRegion_state2.name() + ".",
				statemachine.isStateActive(State.MainRegion_state2));
		// Test if event2 is raised (happens in entry of State2
		assertTrue("Event not raised: ", statemachine.isRaisedEvent2());
		// Test if event2 value is set to 22 (happens in entry of State2
		assertEquals("Event 2 value not set correct: ", 22,
				statemachine.getEvent2Value());

		statemachine.raiseEvent1();
		statemachine.runCycle();
		// Test if statemachine is back in State 1
		assertTrue("Statemachine isn't in State: " + State.MainRegion_state1.name() + ".",
				statemachine.isStateActive(State.MainRegion_state1));
		// Event 2 shouldn't be raised anymore
		assertFalse("Event is still raised: ", statemachine.isRaisedEvent2());
	}

	@Test
	public void testStatemachineRunCycle_2() {
		statemachine.setVar2(-12.6);
		statemachine.raiseEvent1();
		statemachine.runCycle();
		// Test if statemachine is still in State 1
		assertTrue("Statemachine isn't in State: " + State.MainRegion_state1.name() + ".",
				statemachine.isStateActive(State.MainRegion_state1));
		// Event 2 shouldn't be raised
		assertFalse("Event is still raised: ", statemachine.isRaisedEvent2());

		statemachine.raiseEvent1();
		statemachine.setVar2(213.55);
		statemachine.runCycle();
		// Test if state is changed to State2
		assertTrue("Statemachine isn't in State: " + State.MainRegion_state2.name() + ".",
				statemachine.isStateActive(State.MainRegion_state2));
		// Test if event2 is raised (happens in entry of State2
		assertTrue("Event not raised: ", statemachine.isRaisedEvent2());
		// Test if event2 value is set to 22 (happens in entry of State2
		assertEquals("Event 2 value not set correct: ", 22,
				statemachine.getEvent2Value());
	}

	@Test
	public void testStatemachineRunCycle_3() {
		statemachine.getSCIOther().raiseEvent3();
		statemachine.runCycle();
		// Test if state is changed to State3
		assertTrue("Statemachine isn't in State: " + State.MainRegion_state3.name() + ".",
				statemachine.isStateActive(State.MainRegion_state3));
		// Test if event4 is raised (happens in entry of State3
		assertTrue("Event not raised: ", statemachine.getSCIOther()
				.isRaisedEvent4());

		statemachine.getSCIOther().raiseEvent3();
		statemachine.runCycle();
		// Test if statemachine is back in State 1
		assertTrue("Statemachine isn't in State: " + State.MainRegion_state1.name() + ".",
				statemachine.isStateActive(State.MainRegion_state1));
		// Event 4 shouldn't be raised anymore
		assertFalse("Event is still raised: ", statemachine.getSCIOther()
				.isRaisedEvent4());
	}

	@Test
	public void testStatemachineRunCycle_4() {
		statemachine.setVar3(2);
		statemachine.getSCIOther().raiseEvent3();
		statemachine.runCycle();
		// Test if state is changed to MainRegion_state1
		assertTrue("Statemachine isn't in State: " + State.MainRegion_state1.name() + ".",
				statemachine.isStateActive(State.MainRegion_state1));
		// Test if event4 is not raised
		assertFalse("Event not raised: ", statemachine.getSCIOther()
				.isRaisedEvent4());

		statemachine.getSCIOther().raiseEvent3();
		statemachine.setVar3(1);
		statemachine.runCycle();
		// Test if state is changed to State3
		assertTrue("Statemachine isn't in State: " + State.MainRegion_state3.name() + ".",
				statemachine.isStateActive(State.MainRegion_state3));
		// Test if event4 is raised (happens in entry of State3
		assertTrue("Event not raised: ", statemachine.getSCIOther()
				.isRaisedEvent4());
	}

	@Test
	public void testStatemachineRunCycle_5() {
		statemachine.setVar1(true);
		statemachine.getSCIThird().raiseEvent5();
		statemachine.runCycle();
		// Test if state is changed to State4
		assertTrue("Statemachine isn't in State: " + State.MainRegion_state4.name() + ".",
				statemachine.isStateActive(State.MainRegion_state4));
		// Test if event6 is raised
		assertTrue("Event not raised: ", statemachine.getSCIThird()
				.isRaisedEvent6());
		// Test if event6 is set to true;
		assertTrue("Event 6 not set: ", statemachine.getSCIThird()
				.getEvent6Value());

		statemachine.getSCIThird().raiseEvent5();
		statemachine.runCycle();
		// Test if state is changed to MainRegion_state1
		assertTrue("Statemachine isn't in State: " + State.MainRegion_state1.name() + ".",
				statemachine.isStateActive(State.MainRegion_state1));
		// Test if event6 is not raised
		assertFalse("Event raised: ", statemachine.getSCIThird()
				.isRaisedEvent6());
	}
}
