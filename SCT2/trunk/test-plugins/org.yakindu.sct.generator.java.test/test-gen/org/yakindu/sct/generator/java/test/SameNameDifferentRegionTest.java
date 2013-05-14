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
import org.yakindu.scr.samenamedifferentregion.SameNameDifferentRegionStatemachine;
import org.yakindu.scr.samenamedifferentregion.SameNameDifferentRegionStatemachine.State;
/**
 *  Unit TestCase for SameNameDifferentRegion
 */
@SuppressWarnings("all")
public class SameNameDifferentRegionTest {

	private SameNameDifferentRegionStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new SameNameDifferentRegionStatemachine();
		statemachine.init();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testsameNameDifferenRegionTest() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_StateA));
		statemachine.raiseE1();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_StateB));
		assertTrue(statemachine
				.isStateActive(State.main_region_StateB_r1_StateA));
		statemachine.raiseE1();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_StateB));
		assertTrue(statemachine
				.isStateActive(State.main_region_StateB_r1_StateB));
	}
}
