
package org.yakindu.sct.generator.java.test;

import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;
import static org.hamcrest.CoreMatchers.*;
import org.yakindu.scr.shallowhistorywithdeepentry.IShallowHistoryWithDeepEntryStatemachine.*;	
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.shallowhistorywithdeepentry.ShallowHistoryWithDeepEntryStatemachine;
import org.yakindu.scr.shallowhistorywithdeepentry.ShallowHistoryWithDeepEntryStatemachine.State;	
import org.yakindu.scr.VirtualTimer;
import org.yakindu.scr.VirtualTimer.VirtualTimeTask;
import org.yakindu.scr.VirtualTimer.CycleTimeEventTask;

/**
 * Unit TestCase for ShallowHistoryWithDeepEntry
 */
@SuppressWarnings("all")
public class ShallowHistoryWithDeepEntry {
	
	private ShallowHistoryWithDeepEntryStatemachine statemachine;	
	private VirtualTimer timer;
	
	
	@Before
	public void shallowHistoryWithDeepEntry_setUp() {
		statemachine = new ShallowHistoryWithDeepEntryStatemachine();
		timer = new VirtualTimer(200);
		timer.schedulePeriodicalTask(new CycleTimeEventTask(statemachine), 200, 200);
		
		statemachine.init();
		
	}

	@After
	public void shallowHistoryWithDeepEntry_tearDown() {
		statemachine = null;
		
		timer = null;
	}
	
	@Test
	public void noDeepEntryWithinHistory() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_Y));
		statemachine.getSCInterface().raiseToZ();
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_Z__region0_A));
		statemachine.getSCInterface().raiseToY();
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_Y));
		statemachine.getSCInterface().raiseToZ();
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_Z__region0_A));
	}
	
	@Test
	public void deepEntryWithinHistory() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_Y));
		statemachine.getSCInterface().raiseToZ();
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_Z__region0_A));
		statemachine.getSCInterface().raiseToC();
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_Z__region0_B__region0_C));
		assertTrue(statemachine.isStateActive(State.main_region_Z__region0_B));
		statemachine.getSCInterface().raiseToY();
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_Y));
		statemachine.getSCInterface().raiseToZ();
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_Z__region0_B__region0_C));
		assertTrue(statemachine.isStateActive(State.main_region_Z__region0_B));
	}
	
	@Test
	public void directDeepEntryIntoHistory() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_Y));
		statemachine.getSCInterface().raiseToC();
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_Z__region0_B__region0_C));
		assertTrue(statemachine.isStateActive(State.main_region_Z__region0_B));
		statemachine.getSCInterface().raiseToY();
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_Y));
		statemachine.getSCInterface().raiseToZ();
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_Z__region0_B__region0_C));
		assertTrue(statemachine.isStateActive(State.main_region_Z__region0_B));
	}
}
