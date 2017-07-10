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
import org.yakindu.scr.parentfirstlocalreactions.ParentFirstLocalReactionsStatemachine;
import org.yakindu.scr.parentfirstlocalreactions.ParentFirstLocalReactionsStatemachine.State;

/**
 * Unit TestCase for ParentFirstLocalReactions
 */
@SuppressWarnings("all")
public class ParentFirstLocalReactions {
	private ParentFirstLocalReactionsStatemachine statemachine;	
	
	long counter = 0l;
	
	@Before
	public void setUp() {
		statemachine = new ParentFirstLocalReactionsStatemachine();
		statemachine.init();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}
	
	@Test
	public void expectBottomUpLocalReactionOrder() {
		statemachine.enter();;
		assertTrue(statemachine.isStateActive(State.parentFirstLocalReactions_r_A_r_AA_r_AAA));
		statemachine.runCycle();
		;
		assertTrue(statemachine.isStateActive(State.parentFirstLocalReactions_r_A_r_AA_r_AAA));
		assertTrue(statemachine.getSm_local() == 1l);
		assertTrue(statemachine.getA_local() == 2l);
		assertTrue(statemachine.getAa_local() == 3l);
		assertTrue(statemachine.getAaa_local() == 4l);
	}
	@Test
	public void expectParentLocalReactionOnChildLocalTransition() {
		statemachine.enter();;
		assertTrue(statemachine.isStateActive(State.parentFirstLocalReactions_r_A_r_AA_r_AAA));
		statemachine.raiseE();
		statemachine.setDisable_a(true);
		statemachine.setDisable_aa(true);
		statemachine.runCycle();
		;
		assertTrue(statemachine.isStateActive(State.parentFirstLocalReactions_r_A_r_AA_r_AAB));
		assertTrue(statemachine.getSm_local() == 1l);
		assertTrue(statemachine.getA_local() == 2l);
		assertTrue(statemachine.getAa_local() == 3l);
		assertTrue(statemachine.getAaa_local() == 0l);
	}
	@Test
	public void expectGrandparentLocalReactionOnParentLocalTransition() {
		statemachine.enter();;
		assertTrue(statemachine.isStateActive(State.parentFirstLocalReactions_r_A_r_AA_r_AAA));
		statemachine.setDisable_a(true);
		statemachine.raiseE();
		statemachine.runCycle();
		;
		assertTrue(statemachine.isStateActive(State.parentFirstLocalReactions_r_A_r_AB));
		assertTrue(statemachine.getSm_local() == 1l);
		assertTrue(statemachine.getA_local() == 2l);
		assertTrue(statemachine.getAa_local() == 0l);
		assertTrue(statemachine.getAaa_local() == 0l);
	}
	@Test
	public void expectNoLocalReactionOnGrandparentTransition() {
		statemachine.enter();;
		assertTrue(statemachine.isStateActive(State.parentFirstLocalReactions_r_A_r_AA_r_AAA));
		statemachine.setDisable_aaa(true);
		statemachine.setDisable_aa(true);
		statemachine.raiseE();
		statemachine.runCycle();
		;
		assertTrue(statemachine.isStateActive(State.parentFirstLocalReactions_r_B));
		assertTrue(statemachine.getSm_local() == 1l);
		assertTrue(statemachine.getA_local() == 0l);
		assertTrue(statemachine.getAa_local() == 0l);
		assertTrue(statemachine.getAaa_local() == 0l);
	}
}
