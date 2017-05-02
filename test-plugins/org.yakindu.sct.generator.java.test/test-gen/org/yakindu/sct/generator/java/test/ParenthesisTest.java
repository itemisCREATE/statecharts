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
import org.yakindu.scr.parenthesis.ParenthesisStatemachine;
import org.yakindu.scr.parenthesis.ParenthesisStatemachine.State;

/**
 * Unit TestCase for Parenthesis
 */
@SuppressWarnings("all")
public class ParenthesisTest {
	private ParenthesisStatemachine statemachine;	
	
	@Before
	public void setUp() {
		statemachine = new ParenthesisStatemachine();
		statemachine.init();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}
	
	@Test
	public void testSimple() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.mainRegion_A));
		assertTrue(statemachine.getErg() == 8l);
	}
}
