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
import org.yakindu.sct.generator.java.runtime.cyclebased.test_hierarchy.Test_HierarchyStatemachine;

/**
 * Testcases for 'Test_LocalActions' cycle based statemachine.
 * 
 * @author muehlbrandt
 * 
 */
public class TestHierarchyCycleBasedStatemachine {

	private Test_HierarchyStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new Test_HierarchyStatemachine();
		statemachine.init();
		statemachine.enter();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testState1() {
		assertEquals("s1 value not set correct: ", 2, statemachine.getS1());
		assertEquals("s2 value not set correct: ", 0, statemachine.getS2());

		statemachine.raiseEvent9();
		statemachine.runCycle();
		assertEquals("s1 value not set correct: ", 2, statemachine.getS1());
		assertEquals("s2 value not set correct: ", 0, statemachine.getS2());

		statemachine.raiseEvent10();
		statemachine.runCycle();
		assertEquals("s1 value not set correct: ", 2, statemachine.getS1());
		assertEquals("s2 value not set correct: ", 0, statemachine.getS2());

		statemachine.raiseEvent1();
		statemachine.runCycle();
		assertEquals("s1 value not set correct: ", 0, statemachine.getS1());
		assertEquals("s2 value not set correct: ", 2, statemachine.getS2());

		statemachine.raiseEvent14();
		statemachine.runCycle();
		assertEquals("s1 value not set correct: ", 2, statemachine.getS1());
		assertEquals("s2 value not set correct: ", 0, statemachine.getS2());

		statemachine.raiseEvent1();
		statemachine.runCycle();
		statemachine.raiseEvent2();
		statemachine.runCycle();
		assertEquals("s1 value not set correct: ", 0, statemachine.getS1());
		assertEquals("s2 value not set correct: ", 3, statemachine.getS2());

		statemachine.raiseEvent15();
		statemachine.runCycle();
		assertEquals("s1 value not set correct: ", 2, statemachine.getS1());
		assertEquals("s2 value not set correct: ", 0, statemachine.getS2());

		statemachine.raiseEvent1();
		statemachine.runCycle();
		statemachine.raiseEvent2();
		statemachine.runCycle();
		statemachine.raiseEvent3();
		statemachine.runCycle();
		assertEquals("s1 value not set correct: ", 0, statemachine.getS1());
		assertEquals("s2 value not set correct: ", 4, statemachine.getS2());

		statemachine.raiseEvent4();
		statemachine.runCycle();
		assertEquals("s1 value not set correct: ", 0, statemachine.getS1());
		assertEquals("s2 value not set correct: ", 4, statemachine.getS2());

		statemachine.raiseEvent16();
		statemachine.runCycle();
		assertEquals("s1 value not set correct: ", 2, statemachine.getS1());
		assertEquals("s2 value not set correct: ", 0, statemachine.getS2());

		statemachine.raiseEvent1();
		statemachine.runCycle();
		statemachine.raiseEvent2();
		statemachine.runCycle();
		statemachine.raiseEvent3();
		statemachine.runCycle();
		statemachine.raiseEvent4();
		statemachine.runCycle();
		statemachine.raiseEvent5();
		statemachine.runCycle();
		assertEquals("s1 value not set correct: ", 0, statemachine.getS1());
		assertEquals("s2 value not set correct: ", 4, statemachine.getS2());

		statemachine.raiseEvent8();
		statemachine.runCycle();
		assertEquals("s1 value not set correct: ", 0, statemachine.getS1());
		assertEquals("s2 value not set correct: ", 3, statemachine.getS2());

		statemachine.raiseEvent7();
		statemachine.runCycle();
		assertEquals("s1 value not set correct: ", 0, statemachine.getS1());
		assertEquals("s2 value not set correct: ", 2, statemachine.getS2());

		statemachine.raiseEvent6();
		statemachine.runCycle();
		assertEquals("s1 value not set correct: ", 2, statemachine.getS1());
		assertEquals("s2 value not set correct: ", 0, statemachine.getS2());
	}

}
