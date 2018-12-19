
package org.yakindu.sct.generator.java.test;

import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;
import static org.hamcrest.CoreMatchers.*;
import org.yakindu.scr.entryexitselftransition.IEntryExitSelfTransitionStatemachine.*;	
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.entryexitselftransition.EntryExitSelfTransitionStatemachine;
import org.yakindu.scr.entryexitselftransition.EntryExitSelfTransitionStatemachine.State;	
import org.yakindu.scr.VirtualTimer;
import org.yakindu.scr.VirtualTimer.VirtualTimeTask;
import org.yakindu.scr.VirtualTimer.CycleTimeEventTask;

/**
 * Unit TestCase for EntryExitSelfTransition
 */
@SuppressWarnings("all")
public class EntryExitSelfTransition {
	
	private EntryExitSelfTransitionStatemachine statemachine;	
	private VirtualTimer timer;
	
	
	@Before
	public void entryExitSelfTransition_setUp() {
		statemachine = new EntryExitSelfTransitionStatemachine();
		timer = new VirtualTimer(200);
		timer.schedulePeriodicalTask(new CycleTimeEventTask(statemachine), 200, 200);
		
		statemachine.init();
		
	}

	@After
	public void entryExitSelfTransition_tearDown() {
		statemachine = null;
		
		timer = null;
	}
	
	@Test
	public void selfTransitionToChildState() {
		init();
		statemachine.getSCInterface().raiseE();
		timer.cycleLeap(1);
		assertTrue(statemachine.getEntries() == 1l);
		assertTrue(statemachine.getExits() == 1l);
		assertTrue(statemachine.isStateActive(State.main_region_A__region0_C));
		statemachine.exit();
	}
	
	@Test
	public void selfTransitionFromChildState() {
		init();
		statemachine.getSCInterface().raiseE1();
		timer.cycleLeap(1);
		assertTrue(statemachine.getEntries() == 0l);
		assertTrue(statemachine.getExits() == 0l);
		assertTrue(statemachine.isStateActive(State.main_region_A__region0_C));
		statemachine.getSCInterface().raiseE1();
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_A__region0_B));
		assertTrue(statemachine.getEntries() == 1l);
		assertTrue(statemachine.getExits() == 1l);
		statemachine.exit();
	}
	
	public void init() {
		statemachine.enter();
		timer.cycleLeap(1);
		assertTrue(statemachine.getEntries() == 1l);
		assertTrue(statemachine.isStateActive(State.main_region_A__region0_B));
		statemachine.getSCInterface().setEntries(0l);
	}
}
