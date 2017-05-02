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
import org.yakindu.scr.typealias.TypeAliasStatemachine;
import org.yakindu.scr.typealias.TypeAliasStatemachine.State;

/**
 * Unit TestCase for TypeAlias
 */
@SuppressWarnings("all")
public class TypeAliasTest {
	private TypeAliasStatemachine statemachine;	
	
	@Before
	public void setUp() {
		statemachine = new TypeAliasStatemachine();
		statemachine.init();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}
	
	@Test
	public void testTypeAliasTest() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_Start));
		assertTrue(statemachine.getMyVar() == 1l);
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_Mid));
		assertTrue(statemachine.getMyString().equals("TypeSystem"));
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_Mid2));
		statemachine.raiseMyEvent();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_End));
	}
}
