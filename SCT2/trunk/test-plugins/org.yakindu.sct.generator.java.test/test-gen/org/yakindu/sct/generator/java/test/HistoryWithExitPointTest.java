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
import org.yakindu.scr.historywithexitpoint.HistoryWithExitPointStatemachine;
import org.yakindu.scr.historywithexitpoint.HistoryWithExitPointStatemachine.State;
/**
 *  Unit TestCase for HistoryWithExitPoint
 */
@SuppressWarnings("all")
public class HistoryWithExitPointTest {

	private HistoryWithExitPointStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new HistoryWithExitPointStatemachine();
		statemachine.init();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testhistoryEntryAfterExit() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.mr_A_r_X1));
		statemachine.raisePush();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.mr_B));
		statemachine.raiseBack();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.mr_A_r_X1));
		statemachine.raiseNext();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.mr_A_r_X2));
		statemachine.raisePush();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.mr_B));
		statemachine.raiseBack();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.mr_A_r_X2));
	}
}
