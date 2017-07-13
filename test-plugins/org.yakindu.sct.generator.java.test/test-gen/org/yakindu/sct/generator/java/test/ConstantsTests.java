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
import org.yakindu.scr.constants.ConstantsStatemachine;
import org.yakindu.scr.constants.ConstantsStatemachine.State;	

/**
 * Unit TestCase for Constants
 */
@SuppressWarnings("all")
public class ConstantsTests {
	
	private ConstantsStatemachine statemachine;	
	
	
	
	@Before
	public void constantsTests_setUp() {
		statemachine = new ConstantsStatemachine();
		statemachine.init();
	}

	@After
	public void constantsTests_tearDown() {
		statemachine = null;
	}
	
	@Test
	public void constantDefinition() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		assertTrue(statemachine.getX() == 10l);
		assertTrue(statemachine.getY() == 20l);
		assertTrue(statemachine.getSCINamed().getY().equals("Hello World"));
		statemachine.raiseE();
		statemachine.runCycle();
		assertTrue(statemachine.getResult() == 20l);
		statemachine.raiseE();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_C));
		assertTrue(statemachine.getResult() == 100l);
		statemachine.raiseE2(statemachine.getX());
		statemachine.runCycle();
		assertTrue(statemachine.getResult() == 1000l);
		assertTrue(statemachine.isStateActive(State.main_region_A));
	}
}
