/**
 * Copyright (c) 2014 committers of YAKINDU and others.
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

import org.yakindu.scr.operations.IOperationsStatemachine.SCIInterface1OperationCallback;
import org.yakindu.scr.operations.IOperationsStatemachine.SCInterfaceOperationCallback;
import org.yakindu.scr.operations.OperationsStatemachine;
import org.yakindu.scr.operations.IOperationsStatemachine.InternalOperationCallback;
import org.yakindu.scr.operations.OperationsStatemachine.State;
/**
 *  Unit TestCase for Operations
 */
@SuppressWarnings("all")
public class OperationsTestCustom implements InternalOperationCallback, SCIInterface1OperationCallback, SCInterfaceOperationCallback{

	private OperationsStatemachine statemachine;

	private boolean internalOpration1visited = false;
	private boolean interfaceOperation1visited = false;
	private boolean unnamedInterfaceOperation1visited = false;
	
	@Before
	public void setUp() {
		statemachine = new OperationsStatemachine();
		statemachine.init();
		statemachine.setInternalOperationCallback(this);
		statemachine.getSCInterface().setSCInterfaceOperationCallback(this);
		statemachine.getSCIInterface1().setSCIInterface1OperationCallback(this);
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testOperationsSimpleTest() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_B));
	}
	
	@Test
	public void testOperationsTest() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_B));
		statemachine.raiseEv();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_C));
		statemachine.raiseEv();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_D));
		
		// Operations used
		assertTrue(interfaceOperation1visited && internalOpration1visited && unnamedInterfaceOperation1visited);
	}

	public void internalOperation1() {
		internalOpration1visited = true;
	}

	public boolean internalOperation2(long param1) {
		assertTrue(param1 == 4);		
		return false;
	}

	public void interfaceOperation1() {
		interfaceOperation1visited = true;		
	}

	public boolean interfaceOperation2(long param1) {
		assertTrue(param1 == 4);	
		return false;
	}

	public void unnamedInterfaceOperation1() {
		unnamedInterfaceOperation1visited = true;
	}

	public boolean unnamedInterfaceOperation2(long param1) {
		assertTrue(param1 == 4);	
		return false;
	}
}
