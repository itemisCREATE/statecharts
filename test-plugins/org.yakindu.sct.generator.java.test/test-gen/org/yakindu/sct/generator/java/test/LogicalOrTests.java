
package org.yakindu.sct.generator.java.test;

import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.logicalor.LogicalOrStatemachine;
import org.yakindu.scr.logicalor.LogicalOrStatemachine.State;	
import org.yakindu.scr.VirtualTimer;
import org.yakindu.scr.VirtualTimer.VirtualTimeTask;
import org.yakindu.scr.VirtualTimer.CycleTimeEventTask;

/**
 * Unit TestCase for LogicalOr
 */
@SuppressWarnings("all")
public class LogicalOrTests {
	
	private LogicalOrStatemachine statemachine;	
	private VirtualTimer timer;
	
	
	@Before
	public void logicalOrTests_setUp() {
		statemachine = new LogicalOrStatemachine();
		timer = new VirtualTimer(200);
		timer.schedulePeriodicalTask(new CycleTimeEventTask(statemachine), 200, 200);
		
		statemachine.init();
		
	}

	@After
	public void logicalOrTests_tearDown() {
		statemachine = null;
		
		timer = null;
	}
	
	@Test
	public void operandEvaluationOrder() {
		statemachine.enter();
		timer.cycleLeap(1);
		assertTrue("logical or expression was executed in wrong order...",statemachine.getX() == 4l && statemachine.getB());
	}
}
