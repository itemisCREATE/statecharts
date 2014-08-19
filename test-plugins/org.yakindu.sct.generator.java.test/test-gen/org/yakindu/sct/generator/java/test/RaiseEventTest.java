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
import org.yakindu.scr.raiseevent.RaiseEventStatemachine;
import org.yakindu.scr.raiseevent.RaiseEventStatemachine.State;
/**
 *  Unit TestCase for RaiseEvent
 */
@SuppressWarnings("all")
public class RaiseEventTest {

	private RaiseEventStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new RaiseEventStatemachine();
		statemachine.init();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testraiseEvent() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.second_region_SateA));
		assertTrue(statemachine.isStateActive(State.main_region_StateA));
		statemachine.raiseE2();
		statemachine.runCycle();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.second_region_StateB));
		assertTrue(statemachine.isStateActive(State.main_region_StateB));
	}
}
