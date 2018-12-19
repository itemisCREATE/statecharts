
package org.yakindu.sct.generator.java.test;

import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;
import static org.hamcrest.CoreMatchers.*;
import org.yakindu.scr.conditionalexpressions.IConditionalExpressionsStatemachine.*;	
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.conditionalexpressions.ConditionalExpressionsStatemachine;
import org.yakindu.scr.conditionalexpressions.ConditionalExpressionsStatemachine.State;	
import org.yakindu.scr.VirtualTimer;
import org.yakindu.scr.VirtualTimer.VirtualTimeTask;
import org.yakindu.scr.VirtualTimer.CycleTimeEventTask;

/**
 * Unit TestCase for ConditionalExpressions
 */
@SuppressWarnings("all")
public class ConditionalExpression {
	
	private ConditionalExpressionsStatemachine statemachine;	
	private VirtualTimer timer;
	
	
	@Before
	public void conditionalExpression_setUp() {
		statemachine = new ConditionalExpressionsStatemachine();
		timer = new VirtualTimer(200);
		timer.schedulePeriodicalTask(new CycleTimeEventTask(statemachine), 200, 200);
		
		statemachine.init();
		
	}

	@After
	public void conditionalExpression_tearDown() {
		statemachine = null;
		
		timer = null;
	}
	
	@Test
	public void conditionalExpressionTest() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		assertTrue(statemachine.getCondition() == 1l);
		statemachine.getSCInterface().raiseE();
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_B));
		assertTrue(statemachine.getCondition() == 2l);
	}
}
