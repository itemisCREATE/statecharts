
package org.yakindu.sct.generator.java.test;

import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;
import static org.hamcrest.CoreMatchers.*;
import org.yakindu.scr.floatmodulo.IFloatModuloStatemachine.*;	
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.floatmodulo.FloatModuloStatemachine;
import org.yakindu.scr.floatmodulo.FloatModuloStatemachine.State;	
import org.yakindu.scr.VirtualTimer;
import org.yakindu.scr.VirtualTimer.VirtualTimeTask;
import org.yakindu.scr.VirtualTimer.CycleTimeEventTask;

/**
 * Unit TestCase for FloatModulo
 */
@SuppressWarnings("all")
public class FloatModulo {
	
	private FloatModuloStatemachine statemachine;	
	private VirtualTimer timer;
	
	
	@Before
	public void floatModulo_setUp() {
		statemachine = new FloatModuloStatemachine();
		timer = new VirtualTimer(200);
		timer.schedulePeriodicalTask(new CycleTimeEventTask(statemachine), 200, 200);
		
		statemachine.init();
		
	}

	@After
	public void floatModulo_tearDown() {
		statemachine = null;
		
		timer = null;
	}
	
	@Test
	public void test() {
		statemachine.enter();
		timer.cycleLeap(1);
		assertTrue(statemachine.isFinal());
	}
}
