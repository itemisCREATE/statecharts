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
import org.yakindu.scr.entryreactionaction.EntryReactionActionStatemachine;
import org.yakindu.scr.entryreactionaction.EntryReactionActionStatemachine.State;

/**
 * Unit TestCase for EntryReactionAction
 */
@SuppressWarnings("all")
public class EntryReactionActionTest {
	private EntryReactionActionStatemachine statemachine;	
	
	@Before
	public void setUp() {
		statemachine = new EntryReactionActionStatemachine();
		statemachine.init();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}
	
	@Test
	public void testEntryTransitionActionOnStatechartEnter() {
		statemachine.enter();
		assertTrue(statemachine.getEnteredR1());
		assertTrue(statemachine.getEnteredR2());
		assertTrue(statemachine.getEnteredBdefault());
		assertTrue(!statemachine.getEnteredBother());
	}
	@Test
	public void testEntryOnRTS() {
		init();
		statemachine.raiseB();
		statemachine.runCycle();
		assertTrue(!statemachine.getEnteredR1());
		assertTrue(!statemachine.getEnteredR2());
		assertTrue(!statemachine.getEnteredBdefault());
		assertTrue(statemachine.getEnteredBother());
	}
	@Test
	public void testNoEntryTransitionActionOnHistory() {
		init();
		statemachine.raiseD();
		statemachine.runCycle();
		assertTrue(!statemachine.getEnteredR1());
		assertTrue(!statemachine.getEnteredR2());
		assertTrue(!statemachine.getEnteredBdefault());
		assertTrue(!statemachine.getEnteredBother());
	}
	public void init() {
		statemachine.enter();
		statemachine.raiseB();
		statemachine.runCycle();
		statemachine.raiseD();
		statemachine.runCycle();
		statemachine.setEnteredR1(false);
		statemachine.setEnteredR2(false);
		statemachine.setEnteredBdefault(false);
		statemachine.setEnteredBother(false);
	}
}
