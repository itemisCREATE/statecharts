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
import org.yakindu.scr.alwaysoncycle.AlwaysOncycleStatemachine;
import org.yakindu.scr.alwaysoncycle.AlwaysOncycleStatemachine.State;
/**
 *  Unit TestCase for AlwaysOncycle
 */
@SuppressWarnings("all")
public class AlwaysOncycleTest {

	private AlwaysOncycleStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new AlwaysOncycleStatemachine();
		statemachine.init();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testalwaysOncycleTest() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_StateA));
		while (statemachine.getValue() < 5l) {
			statemachine.runCycle();
			assertTrue(statemachine.isStateActive(State.main_region_StateA));
		}
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_StateB));
		while (statemachine.getValue() < 5l) {
			statemachine.runCycle();
			assertTrue(statemachine.isStateActive(State.main_region_StateB));
		}
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_StateA));
	}
}
