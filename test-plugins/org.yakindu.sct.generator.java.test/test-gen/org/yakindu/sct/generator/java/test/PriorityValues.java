/** Generated by YAKINDU Statechart Tools code generator. */

package org.yakindu.sct.generator.java.test;

import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.priorityvalues.PriorityValuesStatemachine;
import org.yakindu.scr.priorityvalues.PriorityValuesStatemachine.State;
import org.yakindu.sct.VirtualTimer;
import org.yakindu.sct.VirtualTimer.VirtualTimeTask;
import org.yakindu.sct.VirtualTimer.CycleTimeEventTask;

/**
 * Unit TestCase for PriorityValues
 */
@SuppressWarnings("all")
public class PriorityValues {
	
	private PriorityValuesStatemachine statemachine;	
	private VirtualTimer timer;
	
	
	@Before
	public void priorityValues_setUp() {
		statemachine = new PriorityValuesStatemachine();
		timer = new VirtualTimer(200);
		timer.schedulePeriodicalTask(new CycleTimeEventTask(statemachine), 200, 200);
		
		statemachine.init();
		
	}

	@After
	public void priorityValues_tearDown() {
		statemachine = null;
		
		timer = null;
	}
	
	@Test
	public void transitionPriority() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(PriorityValuesStatemachine.State.MAIN_REGION_A));
		statemachine.raiseEvent1();
		timer.cycleLeap(1l);
		assertTrue(statemachine.isStateActive(PriorityValuesStatemachine.State.MAIN_REGION_C));
	}
	
	@Test
	public void regionPriority() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(PriorityValuesStatemachine.State.SOMEREGION_A));
		statemachine.raiseEvent2();
		timer.cycleLeap(1l);
		assertTrue(statemachine.isStateActive(PriorityValuesStatemachine.State.SOMEREGION_B));
		assertTrue(!statemachine.isStateActive(PriorityValuesStatemachine.State.MAIN_REGION_E));
	}
}
