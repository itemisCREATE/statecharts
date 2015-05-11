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
import org.yakindu.scr.statechartactive.StatechartActiveStatemachine;
import org.yakindu.scr.statechartactive.StatechartActiveStatemachine.State;
/**
 *  Unit TestCase for StatechartActive
 */
@SuppressWarnings("all")
public class StatechartActiveTest {

	private StatechartActiveStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new StatechartActiveStatemachine();
		statemachine.init();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testinactiveBeforeEnter() {
		assertTrue(!statemachine.isActive());
	}
	@Test
	public void testactiveAfterEnter() {
		statemachine.enter();
		assertTrue(statemachine.isActive());
	}
	@Test
	public void testinactiveAfterExit() {
		statemachine.enter();
		statemachine.exit();
		assertTrue(!statemachine.isActive());
	}
	@Test
	public void testactiveAfterReenter() {
		statemachine.enter();
		statemachine.exit();
		statemachine.enter();
		assertTrue(statemachine.isActive());
	}
}
