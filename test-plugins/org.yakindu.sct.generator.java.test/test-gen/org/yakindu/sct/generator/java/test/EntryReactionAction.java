/** Generated by YAKINDU Statechart Tools code generator. */

package org.yakindu.sct.generator.java.test;

import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.entryreactionaction.EntryReactionActionStatemachine;
import org.yakindu.scr.entryreactionaction.EntryReactionActionStatemachine.State;	
import org.yakindu.scr.VirtualTimer;
import org.yakindu.scr.VirtualTimer.VirtualTimeTask;
import org.yakindu.scr.VirtualTimer.CycleTimeEventTask;

/**
 * Unit TestCase for EntryReactionAction
 */
@SuppressWarnings("all")
public class EntryReactionAction {
	
	private EntryReactionActionStatemachine statemachine;	
	private VirtualTimer timer;
	
	
	@Before
	public void entryReactionAction_setUp() {
		statemachine = new EntryReactionActionStatemachine();
		timer = new VirtualTimer(200);
		timer.schedulePeriodicalTask(new CycleTimeEventTask(statemachine), 200, 200);
		
		statemachine.init();
		
	}

	@After
	public void entryReactionAction_tearDown() {
		statemachine = null;
		
		timer = null;
	}
	
	@Test
	public void entryTransitionActionOnStatechartEnter() {
		statemachine.enter();
		assertTrue(statemachine.getEnteredR1());
		assertTrue(statemachine.getEnteredR2());
		assertTrue(statemachine.getEnteredBdefault());
		assertTrue(!statemachine.getEnteredBother());
	}
	
	@Test
	public void entryOnRTS() {
		init();
		statemachine.raiseB();
		timer.cycleLeap(1l);
		assertTrue(!statemachine.getEnteredR1());
		assertTrue(!statemachine.getEnteredR2());
		assertTrue(!statemachine.getEnteredBdefault());
		assertTrue(statemachine.getEnteredBother());
	}
	
	@Test
	public void noEntryTransitionActionOnHistory() {
		init();
		statemachine.raiseD();
		timer.cycleLeap(1l);
		assertTrue(!statemachine.getEnteredR1());
		assertTrue(!statemachine.getEnteredR2());
		assertTrue(!statemachine.getEnteredBdefault());
		assertTrue(!statemachine.getEnteredBother());
	}
	
	public void init() {
		statemachine.enter();
		statemachine.raiseB();
		timer.cycleLeap(1l);
		statemachine.raiseD();
		timer.cycleLeap(1l);
		statemachine.setEnteredR1(false);
		statemachine.setEnteredR2(false);
		statemachine.setEnteredBdefault(false);
		statemachine.setEnteredBother(false);
	}
}
