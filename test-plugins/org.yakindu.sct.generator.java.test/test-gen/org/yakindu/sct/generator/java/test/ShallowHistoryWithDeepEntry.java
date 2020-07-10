/** Generated by YAKINDU Statechart Tools code generator. */

package org.yakindu.sct.generator.java.test;

import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.shallowhistorywithdeepentry.ShallowHistoryWithDeepEntryStatemachine;
import org.yakindu.scr.shallowhistorywithdeepentry.ShallowHistoryWithDeepEntryStatemachine.State;
import org.yakindu.sct.VirtualTimer;
import org.yakindu.sct.VirtualTimer.VirtualTimeTask;
import org.yakindu.sct.VirtualTimer.CycleTimeEventTask;

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
		assertTrue(statemachine.isStateActive(ShallowHistoryWithDeepEntryStatemachine.State.MAIN_REGION_Y));
		statemachine.raiseToZ();
		timer.cycleLeap(1l);
		assertTrue(statemachine.isStateActive(ShallowHistoryWithDeepEntryStatemachine.State.MAIN_REGION_Z__REGION0_A));
		statemachine.raiseToY();
		timer.cycleLeap(1l);
		assertTrue(statemachine.isStateActive(ShallowHistoryWithDeepEntryStatemachine.State.MAIN_REGION_Y));
		statemachine.raiseToZ();
		timer.cycleLeap(1l);
		assertTrue(statemachine.isStateActive(ShallowHistoryWithDeepEntryStatemachine.State.MAIN_REGION_Z__REGION0_A));
	}
	
	@Test
	public void deepEntryWithinHistory() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(ShallowHistoryWithDeepEntryStatemachine.State.MAIN_REGION_Y));
		statemachine.raiseToZ();
		timer.cycleLeap(1l);
		assertTrue(statemachine.isStateActive(ShallowHistoryWithDeepEntryStatemachine.State.MAIN_REGION_Z__REGION0_A));
		statemachine.raiseToC();
		timer.cycleLeap(1l);
		assertTrue(statemachine.isStateActive(ShallowHistoryWithDeepEntryStatemachine.State.MAIN_REGION_Z__REGION0_B__REGION0_C));
		assertTrue(statemachine.isStateActive(ShallowHistoryWithDeepEntryStatemachine.State.MAIN_REGION_Z__REGION0_B));
		statemachine.raiseToY();
		timer.cycleLeap(1l);
		assertTrue(statemachine.isStateActive(ShallowHistoryWithDeepEntryStatemachine.State.MAIN_REGION_Y));
		statemachine.raiseToZ();
		timer.cycleLeap(1l);
		assertTrue(statemachine.isStateActive(ShallowHistoryWithDeepEntryStatemachine.State.MAIN_REGION_Z__REGION0_B__REGION0_C));
		assertTrue(statemachine.isStateActive(ShallowHistoryWithDeepEntryStatemachine.State.MAIN_REGION_Z__REGION0_B));
	}
	
	@Test
	public void directDeepEntryIntoHistory() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(ShallowHistoryWithDeepEntryStatemachine.State.MAIN_REGION_Y));
		statemachine.raiseToC();
		timer.cycleLeap(1l);
		assertTrue(statemachine.isStateActive(ShallowHistoryWithDeepEntryStatemachine.State.MAIN_REGION_Z__REGION0_B__REGION0_C));
		assertTrue(statemachine.isStateActive(ShallowHistoryWithDeepEntryStatemachine.State.MAIN_REGION_Z__REGION0_B));
		statemachine.raiseToY();
		timer.cycleLeap(1l);
		assertTrue(statemachine.isStateActive(ShallowHistoryWithDeepEntryStatemachine.State.MAIN_REGION_Y));
		statemachine.raiseToZ();
		timer.cycleLeap(1l);
		assertTrue(statemachine.isStateActive(ShallowHistoryWithDeepEntryStatemachine.State.MAIN_REGION_Z__REGION0_B__REGION0_C));
		assertTrue(statemachine.isStateActive(ShallowHistoryWithDeepEntryStatemachine.State.MAIN_REGION_Z__REGION0_B));
	}
}
