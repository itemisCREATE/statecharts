/** Generated by YAKINDU Statechart Tools code generator. */

package org.yakindu.sct.generator.java.test;

import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.parentfirstexecutionhierarchy.ParentFirstExecutionHierarchyStatemachine;
import org.yakindu.scr.parentfirstexecutionhierarchy.ParentFirstExecutionHierarchyStatemachine.State;	
import org.yakindu.scr.VirtualTimer;
import org.yakindu.scr.VirtualTimer.VirtualTimeTask;
import org.yakindu.scr.VirtualTimer.CycleTimeEventTask;

/**
 * Unit TestCase for ParentFirstExecutionHierarchy
 */
@SuppressWarnings("all")
public class ParentFirstExecutionHierarchy {
	
	private ParentFirstExecutionHierarchyStatemachine statemachine;	
	private VirtualTimer timer;
	
	
	@Before
	public void parentFirstExecutionHierarchy_setUp() {
		statemachine = new ParentFirstExecutionHierarchyStatemachine();
		timer = new VirtualTimer(200);
		timer.schedulePeriodicalTask(new CycleTimeEventTask(statemachine), 200, 200);
		
		statemachine.init();
		
	}

	@After
	public void parentFirstExecutionHierarchy_tearDown() {
		statemachine = null;
		
		timer = null;
	}
	
	@Test
	public void childShouldTakeTransition() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.parentFirstExecutionHierarchy_r_A_r_AA_r_AAA));
		statemachine.setDisable_a(true);
		statemachine.setDisable_aa(true);
		statemachine.getSCInterface().raiseE();
		timer.cycleLeap(1l);
		assertTrue(statemachine.isStateActive(State.parentFirstExecutionHierarchy_r_B));
		assertTrue(!statemachine.getA_reacted());
		assertTrue(!statemachine.getAa_reacted());
		assertTrue(statemachine.getAaa_reacted());
		assertTrue(statemachine.getA_local());
		assertTrue(statemachine.getAa_local());
		assertTrue(!statemachine.getAaa_local());
	}
	
	@Test
	public void parentShouldTakeTransition() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.parentFirstExecutionHierarchy_r_A_r_AA_r_AAA));
		statemachine.setDisable_a(true);
		statemachine.getSCInterface().raiseE();
		timer.cycleLeap(1l);
		assertTrue(statemachine.isStateActive(State.parentFirstExecutionHierarchy_r_B));
		assertTrue(!statemachine.getA_reacted());
		assertTrue(statemachine.getAa_reacted());
		assertTrue(!statemachine.getAaa_reacted());
		assertTrue(statemachine.getA_local());
		assertTrue(!statemachine.getAa_local());
		assertTrue(!statemachine.getAaa_local());
	}
	
	@Test
	public void grandparentShouldTakeTransition() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.parentFirstExecutionHierarchy_r_A_r_AA_r_AAA));
		statemachine.getSCInterface().raiseE();
		timer.cycleLeap(1l);
		assertTrue(statemachine.isStateActive(State.parentFirstExecutionHierarchy_r_B));
		assertTrue(statemachine.getA_reacted());
		assertTrue(!statemachine.getAa_reacted());
		assertTrue(!statemachine.getAaa_reacted());
		assertNoLocalReaction();
	}
	
	@Test
	public void expectLocalReactrionsExecuteWithNoTransition() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.parentFirstExecutionHierarchy_r_A_r_AA_r_AAA));
		timer.cycleLeap(1l);
		assertTrue(statemachine.isStateActive(State.parentFirstExecutionHierarchy_r_A_r_AA_r_AAA));
		assertTrue(statemachine.getA_local());
		assertTrue(statemachine.getAa_local());
		assertTrue(statemachine.getAaa_local());
	}
	
	public void assertNoLocalReaction() {
		assertTrue(!statemachine.getA_local());
		assertTrue(!statemachine.getAa_local());
		assertTrue(!statemachine.getAaa_local());
	}
}
