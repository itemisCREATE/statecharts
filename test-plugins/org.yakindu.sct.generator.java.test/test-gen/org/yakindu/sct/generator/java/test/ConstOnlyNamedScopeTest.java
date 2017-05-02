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
import org.yakindu.scr.constonlynamedscope.ConstOnlyNamedScopeStatemachine;
import org.yakindu.scr.constonlynamedscope.ConstOnlyNamedScopeStatemachine.State;

/**
 * Unit TestCase for ConstOnlyNamedScope
 */
@SuppressWarnings("all")
public class ConstOnlyNamedScopeTest {
	private ConstOnlyNamedScopeStatemachine statemachine;	
	
	@Before
	public void setUp() {
		statemachine = new ConstOnlyNamedScopeStatemachine();
		statemachine.init();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}
	
	@Test
	public void testStatechartEntry() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.constOnlyNamedScope_main_region_A));
	}
	@Test
	public void testStateTransition() {
		statemachine.enter();
		statemachine.raiseE(1l);
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.constOnlyNamedScope_main_region_B));
	}
}
