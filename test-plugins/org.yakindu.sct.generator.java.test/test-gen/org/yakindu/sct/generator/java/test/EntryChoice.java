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
import org.yakindu.scr.entrychoice.EntryChoiceStatemachine;
import org.yakindu.scr.entrychoice.EntryChoiceStatemachine.State;	

/**
 * Unit TestCase for EntryChoice
 */
@SuppressWarnings("all")
public class EntryChoice {
	
	private EntryChoiceStatemachine statemachine;	
	
	
	
	@Before
	public void entryChoice_setUp() {
		statemachine = new EntryChoiceStatemachine();
		statemachine.init();
	}

	@After
	public void entryChoice_tearDown() {
		statemachine = null;
	}
	
	@Test
	public void entryChoiceTest() {
		statemachine.enter();
		statemachine.runCycle();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_A));
	}
}
