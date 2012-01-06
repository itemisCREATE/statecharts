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
import org.yakindu.sct.runtime.java.test_hierarchy.Test_HierarchyCycleBasedStatemachine;

/**
 * Testcases for 'Test_LocalActions' cycle based statemachine.
 * 
 * @author muehlbrandt
 * 
 */
public class TestHierarchyCycleBasedStatemachine {

	private Test_HierarchyCycleBasedStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new Test_HierarchyCycleBasedStatemachine();
		statemachine.init();
		statemachine.enter();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}
	
	@Test
	public void testState1() {
		assertEquals("s1 value not set correct: ", 2, statemachine
				.getDefaultInterface().getVarS1());
		assertEquals("s2 value not set correct: ", 0, statemachine
				.getDefaultInterface().getVarS2());
		
		statemachine.getDefaultInterface().raiseEvent9();
		statemachine.runCycle();
		assertEquals("s1 value not set correct: ", 2, statemachine
				.getDefaultInterface().getVarS1());
		assertEquals("s2 value not set correct: ", 0, statemachine
				.getDefaultInterface().getVarS2());
		
		statemachine.getDefaultInterface().raiseEvent10();
		statemachine.runCycle();
		assertEquals("s1 value not set correct: ", 2, statemachine
				.getDefaultInterface().getVarS1());
		assertEquals("s2 value not set correct: ", 0, statemachine
				.getDefaultInterface().getVarS2());
		
		statemachine.getDefaultInterface().raiseEvent1();
		statemachine.runCycle();
		assertEquals("s1 value not set correct: ", 0, statemachine
				.getDefaultInterface().getVarS1());
		assertEquals("s2 value not set correct: ", 2, statemachine
				.getDefaultInterface().getVarS2());
		

		statemachine.getDefaultInterface().raiseEvent14();
		statemachine.runCycle();	
		assertEquals("s1 value not set correct: ", 2, statemachine
				.getDefaultInterface().getVarS1());
		assertEquals("s2 value not set correct: ", 0, statemachine
				.getDefaultInterface().getVarS2());
		
		statemachine.getDefaultInterface().raiseEvent1();
		statemachine.runCycle();
		statemachine.getDefaultInterface().raiseEvent2();
		statemachine.runCycle();
		assertEquals("s1 value not set correct: ", 0, statemachine
				.getDefaultInterface().getVarS1());
		assertEquals("s2 value not set correct: ", 3, statemachine
				.getDefaultInterface().getVarS2());
		
		statemachine.getDefaultInterface().raiseEvent15();
		statemachine.runCycle();	
		assertEquals("s1 value not set correct: ", 2, statemachine
				.getDefaultInterface().getVarS1());
		assertEquals("s2 value not set correct: ", 0, statemachine
				.getDefaultInterface().getVarS2());
		
		statemachine.getDefaultInterface().raiseEvent1();
		statemachine.runCycle();
		statemachine.getDefaultInterface().raiseEvent2();
		statemachine.runCycle();
		statemachine.getDefaultInterface().raiseEvent3();
		statemachine.runCycle();
		assertEquals("s1 value not set correct: ", 0, statemachine
				.getDefaultInterface().getVarS1());
		assertEquals("s2 value not set correct: ", 4, statemachine
				.getDefaultInterface().getVarS2());
		
		statemachine.getDefaultInterface().raiseEvent4();
		statemachine.runCycle();
		assertEquals("s1 value not set correct: ", 0, statemachine
				.getDefaultInterface().getVarS1());
		assertEquals("s2 value not set correct: ", 4, statemachine
				.getDefaultInterface().getVarS2());
		
		statemachine.getDefaultInterface().raiseEvent16();
		statemachine.runCycle();
		assertEquals("s1 value not set correct: ", 2, statemachine
				.getDefaultInterface().getVarS1());
		assertEquals("s2 value not set correct: ", 0, statemachine
				.getDefaultInterface().getVarS2());
		
		statemachine.getDefaultInterface().raiseEvent1();
		statemachine.runCycle();
		statemachine.getDefaultInterface().raiseEvent2();
		statemachine.runCycle();
		statemachine.getDefaultInterface().raiseEvent3();
		statemachine.runCycle();
		statemachine.getDefaultInterface().raiseEvent4();
		statemachine.runCycle();
		statemachine.getDefaultInterface().raiseEvent5();
		statemachine.runCycle();
		assertEquals("s1 value not set correct: ", 0, statemachine
				.getDefaultInterface().getVarS1());
		assertEquals("s2 value not set correct: ", 4, statemachine
				.getDefaultInterface().getVarS2());
		
		statemachine.getDefaultInterface().raiseEvent8();
		statemachine.runCycle();
		assertEquals("s1 value not set correct: ", 0, statemachine
				.getDefaultInterface().getVarS1());
		assertEquals("s2 value not set correct: ", 3, statemachine
				.getDefaultInterface().getVarS2());
		
		statemachine.getDefaultInterface().raiseEvent7();
		statemachine.runCycle();
		assertEquals("s1 value not set correct: ", 0, statemachine
				.getDefaultInterface().getVarS1());
		assertEquals("s2 value not set correct: ", 2, statemachine
				.getDefaultInterface().getVarS2());
		
		statemachine.getDefaultInterface().raiseEvent6();
		statemachine.runCycle();
		assertEquals("s1 value not set correct: ", 2, statemachine
				.getDefaultInterface().getVarS1());
		assertEquals("s2 value not set correct: ", 0, statemachine
				.getDefaultInterface().getVarS2());
	}
}
