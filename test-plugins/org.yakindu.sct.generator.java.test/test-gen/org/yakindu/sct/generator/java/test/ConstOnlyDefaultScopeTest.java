/**
* Copyright (c) 2017 committers of YAKINDU and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*     committers of YAKINDU - initial API and implementation
*/

package org.yakindu.sct.generator.java.test;

import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.constonlydefaultscope.ConstOnlyDefaultScopeStatemachine;
import org.yakindu.scr.constonlydefaultscope.ConstOnlyDefaultScopeStatemachine.State;

/**
 * Unit TestCase for ConstOnlyDefaultScope
 */
@SuppressWarnings("all")
public class ConstOnlyDefaultScopeTest {
	private ConstOnlyDefaultScopeStatemachine statemachine;	
	
	@Before
	public void setUp() {
		statemachine = new ConstOnlyDefaultScopeStatemachine();
		statemachine.init();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}
	
	@Test
	public void testStatechartEntry() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.constOnlyDefaultScope_main_region_A));
	}
	@Test
	public void testStateTransition() {
		statemachine.enter();
		statemachine.getSCIA().raiseE(1l);
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.constOnlyDefaultScope_main_region_B));
	}
}
