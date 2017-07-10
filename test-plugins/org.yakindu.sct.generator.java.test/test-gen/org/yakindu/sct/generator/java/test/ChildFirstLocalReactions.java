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
import org.yakindu.scr.childfirstlocalreactions.ChildFirstLocalReactionsStatemachine;
import org.yakindu.scr.childfirstlocalreactions.ChildFirstLocalReactionsStatemachine.State;

/**
 * Unit TestCase for ChildFirstLocalReactions
 */
@SuppressWarnings("all")
public class ChildFirstLocalReactions {
	private ChildFirstLocalReactionsStatemachine statemachine;	
	
	long counter = 0l;
	
	@Before
	public void setUp() {
		statemachine = new ChildFirstLocalReactionsStatemachine();
		statemachine.init();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}
	
	@Test
	public void expectBottomUpLocalReactionOrder() {
		statemachine.enter();;
		assertTrue(statemachine.isStateActive(State.childFirstLocalReactions_r_A_r_AA_r_AAA));
		statemachine.runCycle();
		;
		assertTrue(statemachine.isStateActive(State.childFirstLocalReactions_r_A_r_AA_r_AAA));
		assertTrue(statemachine.getAaa_local() == 1l);
		assertTrue(statemachine.getAa_local() == 2l);
		assertTrue(statemachine.getA_local() == 3l);
		assertTrue(statemachine.getSm_local() == 4l);
	}
	@Test
	public void expectParentLocalReactionOnChildLocalTransition() {
		statemachine.enter();;
		assertTrue(statemachine.isStateActive(State.childFirstLocalReactions_r_A_r_AA_r_AAA));
		statemachine.raiseE();
		statemachine.runCycle();
		;
		assertTrue(statemachine.isStateActive(State.childFirstLocalReactions_r_A_r_AA_r_AAB));
		assertTrue(statemachine.getAaa_local() == 0l);
		assertTrue(statemachine.getAa_local() == 1l);
		assertTrue(statemachine.getA_local() == 2l);
		assertTrue(statemachine.getSm_local() == 3l);
	}
	@Test
	public void expectGrandparentLocalReactionOnParentLocalTransition() {
		statemachine.enter();;
		assertTrue(statemachine.isStateActive(State.childFirstLocalReactions_r_A_r_AA_r_AAA));
		statemachine.setDisable_aaa(true);
		statemachine.raiseE();
		statemachine.runCycle();
		;
		assertTrue(statemachine.isStateActive(State.childFirstLocalReactions_r_A_r_AB));
		assertTrue(statemachine.getAaa_local() == 1l);
		assertTrue(statemachine.getAa_local() == 0l);
		assertTrue(statemachine.getA_local() == 2l);
		assertTrue(statemachine.getSm_local() == 3l);
	}
	@Test
	public void expectNoLocalReactionOnGrandparentTransition() {
		statemachine.enter();;
		assertTrue(statemachine.isStateActive(State.childFirstLocalReactions_r_A_r_AA_r_AAA));
		statemachine.setDisable_aaa(true);
		statemachine.setDisable_aa(true);
		statemachine.raiseE();
		statemachine.runCycle();
		;
		assertTrue(statemachine.isStateActive(State.childFirstLocalReactions_r_B));
		assertTrue(statemachine.getAaa_local() == 1l);
		assertTrue(statemachine.getAa_local() == 2l);
		assertTrue(statemachine.getA_local() == 0l);
		assertTrue(statemachine.getSm_local() == 3l);
	}
}
