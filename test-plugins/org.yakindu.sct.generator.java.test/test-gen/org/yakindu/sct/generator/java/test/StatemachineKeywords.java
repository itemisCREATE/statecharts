
package org.yakindu.sct.generator.java.test;

import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;
import static org.hamcrest.CoreMatchers.*;
import org.yakindu.scr.statechartkeywords.IStatechartKeywordsStatemachine.*;	
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.statechartkeywords.StatechartKeywordsStatemachine;
import org.yakindu.scr.statechartkeywords.StatechartKeywordsStatemachine.State;	
import org.yakindu.scr.VirtualTimer;
import org.yakindu.scr.VirtualTimer.VirtualTimeTask;
import org.yakindu.scr.VirtualTimer.CycleTimeEventTask;

/**
 * Unit TestCase for StatechartKeywords
 */
@SuppressWarnings("all")
public class StatemachineKeywords {
	SCIIfOperationCallback ifMock;
	InternalOperationCallback internalMock;
	
	private StatechartKeywordsStatemachine statemachine;	
	private VirtualTimer timer;
	
	
	@Before
	public void statemachineKeywords_setUp() {
		statemachine = new StatechartKeywordsStatemachine();
		timer = new VirtualTimer(200);
		timer.schedulePeriodicalTask(new CycleTimeEventTask(statemachine), 200, 200);
		statemachine.setTimer(timer);
		ifMock = mock(SCIIfOperationCallback.class);
		statemachine.getSCIIf().setSCIIfOperationCallback(ifMock);
		internalMock = mock(InternalOperationCallback.class);
		statemachine.setInternalOperationCallback(internalMock);
		
		statemachine.init();
		
	}

	@After
	public void statemachineKeywords_tearDown() {
		statemachine.getSCIIf().setSCIIfOperationCallback(null);
		statemachine.setInternalOperationCallback(null);
		statemachine = null;
		
		timer = null;
	}
	
	@Test
	public void statemachineKeywords() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_Timer));
	}
}
