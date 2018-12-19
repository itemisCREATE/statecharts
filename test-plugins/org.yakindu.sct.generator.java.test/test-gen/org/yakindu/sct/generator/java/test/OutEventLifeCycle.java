
package org.yakindu.sct.generator.java.test;

import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;
import static org.hamcrest.CoreMatchers.*;
import org.yakindu.scr.outeventlifecycle.IOutEventLifeCycleStatemachine.*;	
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.outeventlifecycle.OutEventLifeCycleStatemachine;
import org.yakindu.scr.outeventlifecycle.OutEventLifeCycleStatemachine.State;	
import org.yakindu.scr.VirtualTimer;
import org.yakindu.scr.VirtualTimer.VirtualTimeTask;
import org.yakindu.scr.VirtualTimer.CycleTimeEventTask;

/**
 * Unit TestCase for OutEventLifeCycle
 */
@SuppressWarnings("all")
public class OutEventLifeCycle {
	
	private OutEventLifeCycleStatemachine statemachine;	
	private VirtualTimer timer;
	
	
	@Before
	public void outEventLifeCycle_setUp() {
		statemachine = new OutEventLifeCycleStatemachine();
		timer = new VirtualTimer(200);
		timer.schedulePeriodicalTask(new CycleTimeEventTask(statemachine), 200, 200);
		
		statemachine.init();
		
	}

	@After
	public void outEventLifeCycle_tearDown() {
		statemachine = null;
		
		timer = null;
	}
	
	@Test
	public void availableAfterCycle() {
		statemachine.enter();
		statemachine.getSCInterface().raiseE();
		timer.cycleLeap(1);
		assertTrue(statemachine.isRaisedF());
	}
	
	@Test
	public void availableWithinCycle() {
		init(false);
		assertTrue(statemachine.getF_available_in_cycle());
	}
	
	@Test
	public void unvailableWithin2ndCycle() {
		init(true);
		assertTrue(!statemachine.getF_available_in_next_cycle());
	}
	
	@Test
	public void unvailableAfter2ndCycle() {
		init(true);
		assertTrue(!statemachine.isRaisedF());
	}
	
	public void init(boolean sndCycle) {
		statemachine.enter();
		statemachine.getSCInterface().raiseE();
		timer.cycleLeap(1);
		if (sndCycle) {
			timer.cycleLeap(1);
		}
	}
}
