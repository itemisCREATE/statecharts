/**
 * Copyright (c) 2015 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */

package org.yakindu.sct.generator.java.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import org.yakindu.scr.operationswithoutbraces.OperationsWithoutBracesStatemachine;
import org.yakindu.scr.operationswithoutbraces.IOperationsWithoutBracesStatemachine.SCInterfaceOperationCallback;
import org.yakindu.scr.operationswithoutbraces.OperationsWithoutBracesStatemachine.State;
/**
 *  Unit TestCase for OperationsWithoutBraces
 */
@SuppressWarnings("all")
public class OperationsWithoutBracesCustom implements SCInterfaceOperationCallback{

	private OperationsWithoutBracesStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new OperationsWithoutBracesStatemachine();
		statemachine.init();
		statemachine.getSCInterface().setSCInterfaceOperationCallback(this);
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testOperationsWithoutBracesTest() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		assertTrue(statemachine.isStateActive(State.another_region_A));
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_B));
		assertTrue(statemachine.isStateActive(State.another_region_B));
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_C));
		assertTrue(statemachine.isStateActive(State.another_region_C));
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_D));
		assertTrue(statemachine.isStateActive(State.another_region_D));
	}
	
	// Default Implementation for Operations
	public boolean myBoolOp() {
		return false;
	}
	public long myIntOp() {
		return 0;
	}
	public double myRealOp() {
		return 0;
	}
}
