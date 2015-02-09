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
import org.yakindu.scr.ckeywords.CKeywordsStatemachine;
import org.yakindu.scr.ckeywords.CKeywordsStatemachine.State;
/**
 *  Unit TestCase for CKeywords
 */
@SuppressWarnings("all")
public class CKeywordsTest {

	private CKeywordsStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new CKeywordsStatemachine();
		statemachine.init();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testCKeywordsTest() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.auto_char));
		statemachine.raiseAuto();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.auto_loop));
		assertTrue(statemachine.isStateActive(State.auto_loop_switch_case));
		assertTrue(statemachine
				.isStateActive(State.auto_loop_switch_case_enum_asm));
	}
}
