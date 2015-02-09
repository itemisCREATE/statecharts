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
import org.yakindu.scr.constants.ConstantsStatemachine;
import org.yakindu.scr.constants.ConstantsStatemachine.State;
/**
 *  Unit TestCase for Constants
 */
@SuppressWarnings("all")
public class ConstantsTestsTest {

	private ConstantsStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new ConstantsStatemachine();
		statemachine.init();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testconstantDefinition() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		assertTrue(statemachine.getX() == 10);
		assertTrue(statemachine.getY() == 20);
		assertTrue(statemachine.getSCINamed().getY().equals("Hello World"));
		statemachine.raiseE();
		statemachine.runCycle();
		assertTrue(statemachine.getResult() == 20);
	}
}
