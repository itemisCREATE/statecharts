/**
 * Copyright (c) 2013 committers of YAKINDU and others.
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
import org.yakindu.scr.deepentry.DeepEntryStatemachine;
import org.yakindu.scr.deepentry.DeepEntryStatemachine.State;
/**
 *  Unit TestCase for DeepEntry
 */
@SuppressWarnings("all")
public class DeepEntryTest {

	private DeepEntryStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new DeepEntryStatemachine();
		statemachine.init();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testenterToSubstate() {
		assertTrue(statemachine.getX() == 0);
		assertTrue(statemachine.getY() == 0);
		assertTrue(statemachine.getZ() == 0);
		statemachine.enter();
		assertTrue(statemachine.getX() == 1);
		assertTrue(statemachine.getY() == 1);
		assertTrue(statemachine.getZ() == 2);
		statemachine.raiseE();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.r2_B_r_BB));
		statemachine.raiseF();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.r2_C));
		statemachine.raiseF();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.r2_B_r_BB));
		assertTrue(statemachine.getY() == 1);
	}
}
