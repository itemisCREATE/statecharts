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
import org.yakindu.sct.runtime.java.test_hierarchy.Test_HierarchyEventBasedStatemachine;

/**
 * Testcases for 'Test_LocalActions' cycle based statemachine.
 * 
 * @author muehlbrandt
 * 
 */
public class TestHierarchyEventBasedStatemachine {

	private Test_HierarchyEventBasedStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new Test_HierarchyEventBasedStatemachine();
		statemachine.init();
		statemachine.enter();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testState1() {
		assertEquals("s1 value not set correct: ", 2, statemachine.getVarS1());
		assertEquals("s2 value not set correct: ", 0, statemachine.getVarS2());

		statemachine.raiseEvent9();
		assertEquals("s1 value not set correct: ", 2, statemachine.getVarS1());
		assertEquals("s2 value not set correct: ", 0, statemachine.getVarS2());

		statemachine.raiseEvent10();
		assertEquals("s1 value not set correct: ", 2, statemachine.getVarS1());
		assertEquals("s2 value not set correct: ", 0, statemachine.getVarS2());

		statemachine.raiseEvent1();
		assertEquals("s1 value not set correct: ", 0, statemachine.getVarS1());
		assertEquals("s2 value not set correct: ", 2, statemachine.getVarS2());

		statemachine.raiseEvent14();
		assertEquals("s1 value not set correct: ", 2, statemachine.getVarS1());
		assertEquals("s2 value not set correct: ", 0, statemachine.getVarS2());

		statemachine.raiseEvent1();
		statemachine.raiseEvent2();
		assertEquals("s1 value not set correct: ", 0, statemachine.getVarS1());
		assertEquals("s2 value not set correct: ", 3, statemachine.getVarS2());

		statemachine.raiseEvent15();
		assertEquals("s1 value not set correct: ", 2, statemachine.getVarS1());
		assertEquals("s2 value not set correct: ", 0, statemachine.getVarS2());

		statemachine.raiseEvent1();
		statemachine.raiseEvent2();
		statemachine.raiseEvent3();
		assertEquals("s1 value not set correct: ", 0, statemachine.getVarS1());
		assertEquals("s2 value not set correct: ", 4, statemachine.getVarS2());

		statemachine.raiseEvent4();
		assertEquals("s1 value not set correct: ", 0, statemachine.getVarS1());
		assertEquals("s2 value not set correct: ", 4, statemachine.getVarS2());

		statemachine.raiseEvent16();
		assertEquals("s1 value not set correct: ", 2, statemachine.getVarS1());
		assertEquals("s2 value not set correct: ", 0, statemachine.getVarS2());

		statemachine.raiseEvent1();
		statemachine.raiseEvent2();
		statemachine.raiseEvent3();
		statemachine.raiseEvent4();
		statemachine.raiseEvent5();
		assertEquals("s1 value not set correct: ", 0, statemachine.getVarS1());
		assertEquals("s2 value not set correct: ", 4, statemachine.getVarS2());

		statemachine.raiseEvent8();
		assertEquals("s1 value not set correct: ", 0, statemachine.getVarS1());
		assertEquals("s2 value not set correct: ", 3, statemachine.getVarS2());

		statemachine.raiseEvent7();
		assertEquals("s1 value not set correct: ", 0, statemachine.getVarS1());
		assertEquals("s2 value not set correct: ", 2, statemachine.getVarS2());

		statemachine.raiseEvent6();
		assertEquals("s1 value not set correct: ", 2, statemachine.getVarS1());
		assertEquals("s2 value not set correct: ", 0, statemachine.getVarS2());
	}
}
