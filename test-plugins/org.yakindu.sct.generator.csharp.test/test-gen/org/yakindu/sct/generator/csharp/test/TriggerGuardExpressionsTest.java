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

package org.yakindu.sct.generator.csharp.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.yakindu.scr.triggerguardexpressions.TriggerGuardExpressionsStatemachine;
import org.yakindu.scr.triggerguardexpressions.TriggerGuardExpressionsStatemachine.State;
/**
 *  Unit TestCase for TriggerGuardExpressions
 */
@SuppressWarnings("all")
public class TriggerGuardExpressionsTest {

	private TriggerGuardExpressionsStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new TriggerGuardExpressionsStatemachine();
		statemachine.init();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testtrueGuard() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		statemachine.raiseE1();
		statemachine.setB(true);
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_B));
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		statemachine.raiseE2();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_B));
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		statemachine.raiseE1();
		statemachine.raiseE2();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_B));
	}
	@Test
	public void testfalseGuard() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		statemachine.setB(false);
		statemachine.raiseE1();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		statemachine.raiseE2();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		statemachine.raiseE1();
		statemachine.raiseE2();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_A));
	}
}
