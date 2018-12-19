
package org.yakindu.sct.generator.java.test;

import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;
import static org.hamcrest.CoreMatchers.*;
import org.yakindu.scr.castexpressions.ICastExpressionsStatemachine.*;	
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.castexpressions.CastExpressionsStatemachine;
import org.yakindu.scr.castexpressions.CastExpressionsStatemachine.State;	
import org.yakindu.scr.VirtualTimer;
import org.yakindu.scr.VirtualTimer.VirtualTimeTask;
import org.yakindu.scr.VirtualTimer.CycleTimeEventTask;

/**
 * Unit TestCase for CastExpressions
 */
@SuppressWarnings("all")
public class CastExpressions {
	
	private CastExpressionsStatemachine statemachine;	
	private VirtualTimer timer;
	
	
	@Before
	public void castExpressions_setUp() {
		statemachine = new CastExpressionsStatemachine();
		timer = new VirtualTimer(200);
		timer.schedulePeriodicalTask(new CycleTimeEventTask(statemachine), 200, 200);
		
		statemachine.init();
		
	}

	@After
	public void castExpressions_tearDown() {
		statemachine = null;
		
		timer = null;
	}
	
	@Test
	public void castExpressionTest() {
		statemachine.enter();
		assertTrue(statemachine.getRealValue() == 5l);
		assertTrue(statemachine.getIntValue() == 5l);
		timer.cycleLeap(1);
		assertTrue(statemachine.getRealValue() == 15l);
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_C));
		assertTrue(statemachine.getRealValue() == 757l);
	}
}
