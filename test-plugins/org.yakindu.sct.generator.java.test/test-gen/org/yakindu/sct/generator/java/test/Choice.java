
package org.yakindu.sct.generator.java.test;

import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;
import static org.hamcrest.CoreMatchers.*;
import org.yakindu.scr.choice.IChoiceStatemachine.*;	
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.choice.ChoiceStatemachine;
import org.yakindu.scr.choice.ChoiceStatemachine.State;	
import org.yakindu.scr.VirtualTimer;
import org.yakindu.scr.VirtualTimer.VirtualTimeTask;
import org.yakindu.scr.VirtualTimer.CycleTimeEventTask;

/**
 * Unit TestCase for Choice
 */
@SuppressWarnings("all")
public class Choice {
	
	private ChoiceStatemachine statemachine;	
	private VirtualTimer timer;
	
	
	@Before
	public void choice_setUp() {
		statemachine = new ChoiceStatemachine();
		timer = new VirtualTimer(200);
		timer.schedulePeriodicalTask(new CycleTimeEventTask(statemachine), 200, 200);
		
		statemachine.init();
		
	}

	@After
	public void choice_tearDown() {
		statemachine = null;
		
		timer = null;
	}
	
	@Test
	public void elseChoiceUsingNonDefaultTransition() {
		initForEventE(true);
		assertTrue(statemachine.isStateActive(State.main_region_C));
	}
	
	@Test
	public void elseChoiceUsingDefaultTransition() {
		initForEventE(false);
		assertTrue(statemachine.isStateActive(State.main_region_B));
	}
	
	@Test
	public void defaultChoiceUsingNonDefaultTransition() {
		initForEventG(true);
		assertTrue(statemachine.isStateActive(State.main_region_C));
	}
	
	@Test
	public void defaultChoiceUsingDefaultTransition() {
		initForEventG(false);
		assertTrue(statemachine.isStateActive(State.main_region_B));
	}
	
	@Test
	public void uncheckedChoiceUsingNonDefaultTransition() {
		initForEventF(true);
		assertTrue(statemachine.isStateActive(State.main_region_C));
	}
	
	@Test
	public void uncheckedChoiceUsingDefaultTransition() {
		initForEventF(false);
		assertTrue(statemachine.isStateActive(State.main_region_B));
	}
	
	@Test
	public void alwaysTrueTransitionInChoice() {
		initForEventH(true);
		assertTrue(statemachine.isStateActive(State.main_region_C));
	}
	
	public void initForEventE(boolean valueForC) {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		statemachine.getSCInterface().setC(valueForC);
		statemachine.getSCInterface().raiseE();
		timer.cycleLeap(1);
	}
	
	public void initForEventF(boolean valueForC) {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		statemachine.getSCInterface().setC(valueForC);
		statemachine.getSCInterface().raiseF();
		timer.cycleLeap(1);
	}
	
	public void initForEventG(boolean valueForC) {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		statemachine.getSCInterface().setC(valueForC);
		statemachine.getSCInterface().raiseG();
		timer.cycleLeap(1);
	}
	
	public void initForEventH(boolean valueForC) {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		statemachine.getSCInterface().setC(valueForC);
		statemachine.getSCInterface().raiseH();
		timer.cycleLeap(1);
	}
}
