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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.yakindu.sct.runtime.java.RuntimeService;
import org.yakindu.sct.runtime.java.test_hierarchy.Test_HierarchyEventBasedStatemachine;

/**
 * Testcases for 'Test_LocalActions' cycle based statemachine.
 * 
 * @author muehlbrandt
 * 
 */
public class TestHierarchyEventBasedStatemachine {

	private Test_HierarchyEventBasedStatemachine statemachine;
	
	private RuntimeService runtimeService;

	// Minimal cycletime
	private final long cyclePeriod = 1;

	@Before
	public void setUp() {
		statemachine = new Test_HierarchyEventBasedStatemachine();
		statemachine.init();
		statemachine.enter();
		runtimeService = new RuntimeService(cyclePeriod);
		runtimeService.addStatemachine(statemachine);
	}

	@After
	public void tearDown() {
		runtimeService.removeStatemachine(statemachine);
		runtimeService.cancel();
		statemachine = null;
	}

	private void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testState1() {
		assertEquals("s1 value not set correct: ", 2, statemachine
				.getDefaultInterface().getVarS1());
		assertEquals("s2 value not set correct: ", 0, statemachine
				.getDefaultInterface().getVarS2());

		statemachine.getDefaultInterface().raiseEvent9();
		sleep(2);
		assertEquals("s1 value not set correct: ", 2, statemachine
				.getDefaultInterface().getVarS1());
		assertEquals("s2 value not set correct: ", 0, statemachine
				.getDefaultInterface().getVarS2());

		statemachine.getDefaultInterface().raiseEvent10();
		sleep(2);
		assertEquals("s1 value not set correct: ", 2, statemachine
				.getDefaultInterface().getVarS1());
		assertEquals("s2 value not set correct: ", 0, statemachine
				.getDefaultInterface().getVarS2());

		statemachine.getDefaultInterface().raiseEvent1();
		sleep(2);
		assertEquals("s1 value not set correct: ", 0, statemachine
				.getDefaultInterface().getVarS1());
		assertEquals("s2 value not set correct: ", 2, statemachine
				.getDefaultInterface().getVarS2());

		statemachine.getDefaultInterface().raiseEvent14();
		sleep(2);
		assertEquals("s1 value not set correct: ", 2, statemachine
				.getDefaultInterface().getVarS1());
		assertEquals("s2 value not set correct: ", 0, statemachine
				.getDefaultInterface().getVarS2());

		statemachine.getDefaultInterface().raiseEvent1();
		statemachine.getDefaultInterface().raiseEvent2();
		sleep(4);
		assertEquals("s1 value not set correct: ", 0, statemachine
				.getDefaultInterface().getVarS1());
		assertEquals("s2 value not set correct: ", 3, statemachine
				.getDefaultInterface().getVarS2());

		statemachine.getDefaultInterface().raiseEvent15();
		sleep(2);
		assertEquals("s1 value not set correct: ", 2, statemachine
				.getDefaultInterface().getVarS1());
		assertEquals("s2 value not set correct: ", 0, statemachine
				.getDefaultInterface().getVarS2());

		statemachine.getDefaultInterface().raiseEvent1();
		statemachine.getDefaultInterface().raiseEvent2();
		statemachine.getDefaultInterface().raiseEvent3();
		sleep(6);
		assertEquals("s1 value not set correct: ", 0, statemachine
				.getDefaultInterface().getVarS1());
		assertEquals("s2 value not set correct: ", 4, statemachine
				.getDefaultInterface().getVarS2());

		statemachine.getDefaultInterface().raiseEvent4();
		sleep(2);
		assertEquals("s1 value not set correct: ", 0, statemachine
				.getDefaultInterface().getVarS1());
		assertEquals("s2 value not set correct: ", 4, statemachine
				.getDefaultInterface().getVarS2());

		statemachine.getDefaultInterface().raiseEvent16();
		sleep(2);
		assertEquals("s1 value not set correct: ", 2, statemachine
				.getDefaultInterface().getVarS1());
		assertEquals("s2 value not set correct: ", 0, statemachine
				.getDefaultInterface().getVarS2());

		statemachine.getDefaultInterface().raiseEvent1();
		statemachine.getDefaultInterface().raiseEvent2();
		statemachine.getDefaultInterface().raiseEvent3();
		statemachine.getDefaultInterface().raiseEvent4();
		statemachine.getDefaultInterface().raiseEvent5();
		sleep(10);
		assertEquals("s1 value not set correct: ", 0, statemachine
				.getDefaultInterface().getVarS1());
		assertEquals("s2 value not set correct: ", 4, statemachine
				.getDefaultInterface().getVarS2());

		statemachine.getDefaultInterface().raiseEvent8();
		sleep(2);
		assertEquals("s1 value not set correct: ", 0, statemachine
				.getDefaultInterface().getVarS1());
		assertEquals("s2 value not set correct: ", 3, statemachine
				.getDefaultInterface().getVarS2());

		statemachine.getDefaultInterface().raiseEvent7();
		sleep(2);
		assertEquals("s1 value not set correct: ", 0, statemachine
				.getDefaultInterface().getVarS1());
		assertEquals("s2 value not set correct: ", 2, statemachine
				.getDefaultInterface().getVarS2());

		statemachine.getDefaultInterface().raiseEvent6();
		sleep(2);
		assertEquals("s1 value not set correct: ", 2, statemachine
				.getDefaultInterface().getVarS1());
		assertEquals("s2 value not set correct: ", 0, statemachine
				.getDefaultInterface().getVarS2());
	}
}
