
package org.yakindu.sct.generator.java.test;

import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;
import static org.hamcrest.CoreMatchers.*;
import org.yakindu.scr.alwaysoncycle.IAlwaysOncycleStatemachine.*;	
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.alwaysoncycle.AlwaysOncycleStatemachine;
import org.yakindu.scr.alwaysoncycle.AlwaysOncycleStatemachine.State;	
import org.yakindu.scr.VirtualTimer;
import org.yakindu.scr.VirtualTimer.VirtualTimeTask;
import org.yakindu.scr.VirtualTimer.CycleTimeEventTask;

/**
 * Unit TestCase for AlwaysOncycle
 */
@SuppressWarnings("all")
public class AlwaysOncycle {
	
	private AlwaysOncycleStatemachine statemachine;	
	private VirtualTimer timer;
	
	
	@Before
	public void alwaysOncycle_setUp() {
		statemachine = new AlwaysOncycleStatemachine();
		timer = new VirtualTimer(200);
		timer.schedulePeriodicalTask(new CycleTimeEventTask(statemachine), 200, 200);
		
		statemachine.init();
		
	}

	@After
	public void alwaysOncycle_tearDown() {
		statemachine = null;
		
		timer = null;
	}
	
	@Test
	public void alwaysOnCycleTest() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_StateA));
		long count = 0l;
		while (count < 5l) {
			timer.cycleLeap(1);
			assertTrue(statemachine.isStateActive(State.main_region_StateA));
			count++;
		}
		assertTrue((statemachine.getValue() == 5l));
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_StateB));
		assertTrue(statemachine.getValue() == 0l);
		count = 0l;
		while (count < 5l) {
			timer.cycleLeap(1);
			assertTrue(statemachine.isStateActive(State.main_region_StateB));
			count++;
		}
		assertTrue((statemachine.getValue() == 5l));
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_StateA));
		assertTrue(statemachine.getValue() == 0l);
	}
}
