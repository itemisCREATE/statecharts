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
import org.yakindu.sct.runtime.java.test_localactions.Test_LocalActionsAbstractBaseStatemachine.State;
import org.yakindu.sct.runtime.java.test_localactions.Test_LocalActionsCyleBasedStatemachine;

/**
 * Testcases for 'Test_LocalActions' cycle based statemachine.
 * 
 * @author muehlbrandt
 * 
 */
public class TestLocalActionsCycleBasedStatemachine {

	private Test_LocalActionsCyleBasedStatemachine statemachine;

	// Define the error threshold in ms. 10 ms are required to satisfy soft-realtime requirements.
	private final long timerThreshold = 10;

	@Before
	public void setUp() {
		statemachine = new Test_LocalActionsCyleBasedStatemachine();
		statemachine.entry();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testStatemachineEntry() {
		setUp();
		assertTrue("Statemachine isn't in State: " + State.State1.name() + ".",
				statemachine.getActiveStates().contains(State.State1));
		assertEquals("More than one state is active.", 1, statemachine
				.getActiveStates().size());
		assertEquals("Variable i not set to 1", 1, statemachine
				.getInterfaceDefault().getVarI());
		tearDown();
	}

	@Test
	public void testState1LocalReaction() throws InterruptedException {
		setUp();
		final long time = System.currentTimeMillis();
		statemachine.runCycle();
		// assertEquals("Error in local reaction \"onCycle / i=2;\" of State1",
		// 2,
		// statemachine.getInterfaceDefault().getVarI());

		statemachine.getInterfaceDefault().raiseEvent2();
		statemachine.runCycle();
		assertEquals("Error in local reaction \"Event2 / i=3;\" of State1", 3,
				statemachine.getInterfaceDefault().getVarI());

		// Check timer behavior
		while (statemachine.getInterfaceDefault().getVarC() < 10) {
			statemachine.runCycle();
			Thread.sleep(2);
		}
		final long time2 = System.currentTimeMillis() - time;
		final long delta = time2 - statemachine.getInterfaceDefault().getVarC()
				* 100;
		assertTrue("Timer threshold overflow. Delta is " + delta
				+ "ms. Threshold is: " + timerThreshold + "ms.",
				time2 <= statemachine.getInterfaceDefault().getVarC() * 100
						+ timerThreshold);

		tearDown();
	}
}
