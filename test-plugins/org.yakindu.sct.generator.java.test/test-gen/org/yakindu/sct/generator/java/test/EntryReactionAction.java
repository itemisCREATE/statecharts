
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
		statemachine.getSCInterface().raiseB();
		timer.cycleLeap(1);
		assertTrue(!statemachine.getEnteredR1());
		assertTrue(!statemachine.getEnteredR2());
		assertTrue(!statemachine.getEnteredBdefault());
		assertTrue(statemachine.getEnteredBother());
	}
	
	@Test
	public void noEntryTransitionActionOnHistory() {
		init();
		statemachine.getSCInterface().raiseD();
		timer.cycleLeap(1);
		assertTrue(!statemachine.getEnteredR1());
		assertTrue(!statemachine.getEnteredR2());
		assertTrue(!statemachine.getEnteredBdefault());
		assertTrue(!statemachine.getEnteredBother());
	}
	
	public void init() {
		statemachine.enter();
		statemachine.getSCInterface().raiseB();
		timer.cycleLeap(1);
		statemachine.getSCInterface().raiseD();
		timer.cycleLeap(1);
		statemachine.getSCInterface().setEnteredR1(false);
		statemachine.getSCInterface().setEnteredR2(false);
		statemachine.getSCInterface().setEnteredBdefault(false);
		statemachine.getSCInterface().setEnteredBother(false);
	}
}
