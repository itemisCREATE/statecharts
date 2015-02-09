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
import org.yakindu.scr.outeventlifecycle.OutEventLifeCycleStatemachine;
import org.yakindu.scr.outeventlifecycle.OutEventLifeCycleStatemachine.State;
/**
 *  Unit TestCase for OutEventLifeCycle
 */
@SuppressWarnings("all")
public class OutEventLifeCycleTest {

	private OutEventLifeCycleStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new OutEventLifeCycleStatemachine();
		statemachine.init();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testavailableAfterCycle() {
		statemachine.enter();
		statemachine.raiseE();
		statemachine.runCycle();
		assertTrue(statemachine.isRaisedF());
	}
	@Test
	public void testavailableWithinCycle() {
		statemachine.enter();
		statemachine.raiseE();
		statemachine.runCycle();
		assertTrue(statemachine.getF_available_in_cycle());
	}
	@Test
	public void testunvailableWithin2ndCycle() {
		statemachine.enter();
		statemachine.raiseE();
		statemachine.runCycle();
		statemachine.runCycle();
		assertTrue(!statemachine.getF_available_in_next_cycle());
	}
	@Test
	public void testunvailableAfter2ndCycle() {
		statemachine.enter();
		statemachine.raiseE();
		statemachine.runCycle();
		statemachine.runCycle();
		assertTrue(!statemachine.isRaisedF());
	}
}
