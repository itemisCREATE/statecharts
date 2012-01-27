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
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.yakindu.sct.runtime.java.RuntimeService;
import org.yakindu.sct.runtime.java.TimerService;
import org.yakindu.sct.runtime.java.test_localactions.Test_LocalActionsCycleBasedStatemachine;
import org.yakindu.sct.runtime.java.test_localactions.Test_LocalActionsCycleBasedStatemachine.State;
import org.yakindu.sct.runtime.java.test_localactions.Test_LocalActionsEventBasedStatemachine;

/**
 * Testcases for 'Test_LocalActions' cycle based statemachine.
 * 
 * @author muehlbrandt
 * 
 */
public class TestLocalActionsEventBasedStatemachine {

	private Test_LocalActionsEventBasedStatemachine statemachine;

	// Define the error threshold in ms. 10 ms are required to satisfy
	// soft-realtime requirements.
	private final long timerThreshold = 10;

	// Define sleeptime in ms of JUnit Test between statemachine "runCycle()"
	// calls. So the TimerHandler Thread get's a chance to throw a timed event
	// within the timerThreshold time.
	private final long junitSleepTime = 1;

	private RuntimeService runtimeService;

	// Minimal cycletime
	private final long cyclePeriod = 1;

	@Before
	public void setUp() {
		statemachine = new Test_LocalActionsEventBasedStatemachine();
		statemachine.setTimerService(new TimerService());
		statemachine.init();
		statemachine.enter();
		runtimeService = new RuntimeService(cyclePeriod);
		runtimeService.addStatemachine(statemachine);
	}

	@After
	public void tearDown() {
		runtimeService.cancel();
		statemachine.getTimerService().cancel();
		statemachine = null;
	}

	@Test (expected = NullPointerException.class)
	public void testExceptionHandling() {
		Test_LocalActionsCycleBasedStatemachine statemachine = new Test_LocalActionsCycleBasedStatemachine();
		statemachine.enter();
	}

	@Test
	public void testStatemachineEntry() {
		assertTrue("Statemachine isn't in State: " + State.State1.name() + ".",
				statemachine.isStateActive(State.State1));
		assertEquals("Variable i not set to 1", 1, statemachine
				.getDefaultInterface().getVarI());
	}

	@Test
	public void testState1LocalReaction() throws InterruptedException {
		final long time = System.currentTimeMillis();

		assertEquals("Error in local reaction \"Entry / i=1;\" of State1", 1,
				statemachine.getDefaultInterface().getVarI());

		statemachine.getDefaultInterface().raiseEvent3();
		Thread.sleep(5);
		assertEquals("Error in local reaction \"onCycle / i=2;\" of State1", 2,
				statemachine.getDefaultInterface().getVarI());

		statemachine.getDefaultInterface().raiseEvent2();
		Thread.sleep(5);
		assertEquals("Error in local reaction \"Event2 / i=3;\" of State1", 3,
				statemachine.getDefaultInterface().getVarI());

		// Check timer behavior
		while (statemachine.getDefaultInterface().getVarC() < 10) {
			Thread.sleep(junitSleepTime);
		}
		final long time2 = System.currentTimeMillis() - time;
		final long expectedTime = statemachine.getDefaultInterface().getVarC() * 100;
		final long delta = time2 - expectedTime;
		assertTrue("Timer threshold overflow in State 1. Delta is " + delta
				+ " ms. Threshold is: " + timerThreshold + " ms.",
				time2 <= expectedTime + timerThreshold);
	}

	@Test
	public void testState2LocalReaction() throws InterruptedException {
		// Switch to State2;
		statemachine.getDefaultInterface().raiseEvent1();
		Thread.sleep(5);
		final long time = System.currentTimeMillis();

		assertEquals("Error in local reaction \"exit / i=0;\" of State1", 0,
				statemachine.getDefaultInterface().getVarI());

		assertEquals("Error in local reaction \"entry / j=0;\" of State2", 1,
				statemachine.getDefaultInterface().getVarJ());

		// Check local reaction for Event2
		statemachine.getDefaultInterface().raiseEvent2();
		Thread.sleep(5);
		assertEquals(
				"Error in local reaction \"Event2, Event4 / j=2;\" of State2",
				2, statemachine.getDefaultInterface().getVarJ());

		// Check timer behavior
		while (statemachine.getDefaultInterface().getVarJ() != 3) {
			Thread.sleep(junitSleepTime);
		}
		final long time2 = System.currentTimeMillis() - time;
		// After 200 ms var j should be set to 3
		final long expectedTime = 200;
		final long delta = time2 - expectedTime;
		assertTrue("Timer threshold overflow in State 2. Delta is " + delta
				+ " ms. Threshold is: " + timerThreshold + " ms.",
				time2 <= expectedTime + timerThreshold);

		// Check local reaction for Event4
		statemachine.getDefaultInterface().raiseEvent4();
		Thread.sleep(5);
		assertEquals(
				"Error in local reaction \"Event2, Event4 / j=2;\" of State2",
				2, statemachine.getDefaultInterface().getVarJ());

		// Check local reaction for exit
		statemachine.getDefaultInterface().raiseEvent3();
		Thread.sleep(5);
		assertEquals("Error in local reaction \"exit / j=0;\" of State2", 0,
				statemachine.getDefaultInterface().getVarJ());
	}
}
