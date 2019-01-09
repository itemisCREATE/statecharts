
package org.yakindu.sct.generator.java.test;

import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;
import static org.hamcrest.CoreMatchers.*;
import org.yakindu.scr.childfirstorthogonalreactions.IChildFirstOrthogonalReactionsStatemachine.*;	
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.childfirstorthogonalreactions.ChildFirstOrthogonalReactionsStatemachine;
import org.yakindu.scr.childfirstorthogonalreactions.ChildFirstOrthogonalReactionsStatemachine.State;	
import org.yakindu.scr.VirtualTimer;
import org.yakindu.scr.VirtualTimer.VirtualTimeTask;
import org.yakindu.scr.VirtualTimer.CycleTimeEventTask;

/**
 * Unit TestCase for ChildFirstOrthogonalReactions
 */
@SuppressWarnings("all")
public class ChildFirstOrthogonalReactions {
	SCInterfaceOperationCallback defaultMock;
	
	private ChildFirstOrthogonalReactionsStatemachine statemachine;	
	private VirtualTimer timer;
	
	
	@Before
	public void childFirstOrthogonalReactions_setUp() {
		statemachine = new ChildFirstOrthogonalReactionsStatemachine();
		timer = new VirtualTimer(200);
		timer.schedulePeriodicalTask(new CycleTimeEventTask(statemachine), 200, 200);
		defaultMock = mock(SCInterfaceOperationCallback.class);
		statemachine.getSCInterface().setSCInterfaceOperationCallback(defaultMock);
		
		statemachine.init();
		
	}

	@After
	public void childFirstOrthogonalReactions_tearDown() {
		statemachine.getSCInterface().setSCInterfaceOperationCallback(null);
		statemachine = null;
		
		timer = null;
	}
	
	public boolean checkA(boolean ret) {
		statemachine.getSCInterface().setCnt(statemachine.getCnt()+1l);
		statemachine.getSCInterface().setA_check(statemachine.getCnt());
		return ret;
	}
	
	public boolean checkAA(boolean ret) {
		statemachine.getSCInterface().setCnt(statemachine.getCnt()+1l);
		statemachine.getSCInterface().setAa_check(statemachine.getCnt());
		return ret;
	}
	
	public boolean checkAAA(boolean ret) {
		statemachine.getSCInterface().setCnt(statemachine.getCnt()+1l);
		statemachine.getSCInterface().setAaa_check(statemachine.getCnt());
		return ret;
	}
	
	public boolean checkAAC(boolean ret) {
		statemachine.getSCInterface().setCnt(statemachine.getCnt()+1l);
		statemachine.getSCInterface().setAac_check(statemachine.getCnt());
		return ret;
	}
	
	public boolean checkAC(boolean ret) {
		statemachine.getSCInterface().setCnt(statemachine.getCnt()+1l);
		statemachine.getSCInterface().setAc_check(statemachine.getCnt());
		return ret;
	}
	
	public boolean checkC(boolean ret) {
		statemachine.getSCInterface().setCnt(statemachine.getCnt()+1l);
		statemachine.getSCInterface().setC_check(statemachine.getCnt());
		return ret;
	}
	
	public long nextCounter() {
		statemachine.getSCInterface().setCnt(statemachine.getCnt()+1l);
		return statemachine.getCnt();
	}
	
	@Test
	public void executionOrder() {
		when(defaultMock.check("A")).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				return checkA(false);
			}
		});
		 
		when(defaultMock.check("AA")).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				return checkAA(false);
			}
		});
		 
		when(defaultMock.check("AAA")).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				return checkAAA(false);
			}
		});
		 
		when(defaultMock.check("AAC")).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				return checkAAC(false);
			}
		});
		 
		when(defaultMock.check("AC")).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				return checkAC(false);
			}
		});
		 
		when(defaultMock.check("C")).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				return checkC(false);
			}
		});
		 
		when(defaultMock.next()).thenAnswer(new Answer<Long>() {
			@Override
			public Long answer(InvocationOnMock invocation) {
				return nextCounter();
			}
		});
		 
		statemachine.enter();
		timer.cycleLeap(1);
		assertTrue(statemachine.getAaa_check() == 1l);
		assertTrue(statemachine.getAaa_local() == 2l);
		assertTrue(statemachine.getAac_check() == 3l);
		assertTrue(statemachine.getAac_local() == 4l);
		assertTrue(statemachine.getAa_check() == 5l);
		assertTrue(statemachine.getAa_local() == 6l);
		assertTrue(statemachine.getAc_check() == 7l);
		assertTrue(statemachine.getAc_local() == 8l);
		assertTrue(statemachine.getA_check() == 9l);
		assertTrue(statemachine.getA_local() == 10l);
		assertTrue(statemachine.getC_check() == 11l);
		assertTrue(statemachine.getC_local() == 12l);
		assertTrue(statemachine.getSm_local() == 13l);
	}
	
	@Test
	public void executionOrderWIthFirstLeafTransition() {
		when(defaultMock.check("A")).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				return checkA(false);
			}
		});
		 
		when(defaultMock.check("AA")).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				return checkAA(false);
			}
		});
		 
		when(defaultMock.check("AAA")).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				return checkAAA(true);
			}
		});
		 
		when(defaultMock.check("AAC")).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				return checkAAC(false);
			}
		});
		 
		when(defaultMock.check("AC")).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				return checkAC(false);
			}
		});
		 
		when(defaultMock.check("C")).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				return checkC(false);
			}
		});
		 
		when(defaultMock.next()).thenAnswer(new Answer<Long>() {
			@Override
			public Long answer(InvocationOnMock invocation) {
				return nextCounter();
			}
		});
		 
		statemachine.enter();
		timer.cycleLeap(1);
		assertTrue(statemachine.getAaa_check() == 1l);
		assertTrue(statemachine.getAaa_local() == 0l);
		assertTrue(statemachine.getAac_check() == 0l);
		assertTrue(statemachine.getAac_local() == 0l);
		assertTrue(statemachine.getAa_check() == 0l);
		assertTrue(statemachine.getAa_local() == 0l);
		assertTrue(statemachine.getAc_check() == 0l);
		assertTrue(statemachine.getAc_local() == 0l);
		assertTrue(statemachine.getA_check() == 0l);
		assertTrue(statemachine.getA_local() == 0l);
		assertTrue(statemachine.getC_check() == 2l);
		assertTrue(statemachine.getC_local() == 3l);
		assertTrue(statemachine.getSm_local() == 4l);
	}
	
	@Test
	public void executionOrderWIthFirstParentTransition() {
		when(defaultMock.check("A")).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				return checkA(false);
			}
		});
		 
		when(defaultMock.check("AA")).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				return checkAA(true);
			}
		});
		 
		when(defaultMock.check("AAA")).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				return checkAAA(false);
			}
		});
		 
		when(defaultMock.check("AAC")).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				return checkAAC(false);
			}
		});
		 
		when(defaultMock.check("AC")).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				return checkAC(false);
			}
		});
		 
		when(defaultMock.check("C")).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				return checkC(false);
			}
		});
		 
		when(defaultMock.next()).thenAnswer(new Answer<Long>() {
			@Override
			public Long answer(InvocationOnMock invocation) {
				return nextCounter();
			}
		});
		 
		statemachine.enter();
		timer.cycleLeap(1);
		assertTrue(statemachine.getAaa_check() == 1l);
		assertTrue(statemachine.getAaa_local() == 2l);
		assertTrue(statemachine.getAac_check() == 3l);
		assertTrue(statemachine.getAac_local() == 4l);
		assertTrue(statemachine.getAa_check() == 5l);
		assertTrue(statemachine.getAa_local() == 0l);
		assertTrue(statemachine.getAc_check() == 0l);
		assertTrue(statemachine.getAc_local() == 0l);
		assertTrue(statemachine.getA_check() == 0l);
		assertTrue(statemachine.getA_local() == 0l);
		assertTrue(statemachine.getC_check() == 6l);
		assertTrue(statemachine.getC_local() == 7l);
		assertTrue(statemachine.getSm_local() == 8l);
	}
	
	@Test
	public void executionOrderWIthFirstGrandParentTransition() {
		when(defaultMock.check("A")).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				return checkA(true);
			}
		});
		 
		when(defaultMock.check("AA")).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				return checkAA(false);
			}
		});
		 
		when(defaultMock.check("AAA")).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				return checkAAA(false);
			}
		});
		 
		when(defaultMock.check("AAC")).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				return checkAAC(false);
			}
		});
		 
		when(defaultMock.check("AC")).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				return checkAC(false);
			}
		});
		 
		when(defaultMock.check("C")).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				return checkC(false);
			}
		});
		 
		when(defaultMock.next()).thenAnswer(new Answer<Long>() {
			@Override
			public Long answer(InvocationOnMock invocation) {
				return nextCounter();
			}
		});
		 
		statemachine.enter();
		timer.cycleLeap(1);
		assertTrue(statemachine.getAaa_check() == 1l);
		assertTrue(statemachine.getAaa_local() == 2l);
		assertTrue(statemachine.getAac_check() == 3l);
		assertTrue(statemachine.getAac_local() == 4l);
		assertTrue(statemachine.getAa_check() == 5l);
		assertTrue(statemachine.getAa_local() == 6l);
		assertTrue(statemachine.getAc_check() == 7l);
		assertTrue(statemachine.getAc_local() == 8l);
		assertTrue(statemachine.getA_check() == 9l);
		assertTrue(statemachine.getA_local() == 0l);
		assertTrue(statemachine.getC_check() == 10l);
		assertTrue(statemachine.getC_local() == 11l);
		assertTrue(statemachine.getSm_local() == 12l);
	}
	
	@Test
	public void executionOrderWithLastLeafTransition() {
		when(defaultMock.check("A")).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				return checkA(false);
			}
		});
		 
		when(defaultMock.check("AA")).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				return checkAA(false);
			}
		});
		 
		when(defaultMock.check("AAA")).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				return checkAAA(false);
			}
		});
		 
		when(defaultMock.check("AAC")).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				return checkAAC(false);
			}
		});
		 
		when(defaultMock.check("AC")).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				return checkAC(false);
			}
		});
		 
		when(defaultMock.check("C")).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				return checkC(true);
			}
		});
		 
		when(defaultMock.next()).thenAnswer(new Answer<Long>() {
			@Override
			public Long answer(InvocationOnMock invocation) {
				return nextCounter();
			}
		});
		 
		statemachine.enter();
		timer.cycleLeap(1);
		assertTrue(statemachine.getAaa_check() == 1l);
		assertTrue(statemachine.getAaa_local() == 2l);
		assertTrue(statemachine.getAac_check() == 3l);
		assertTrue(statemachine.getAac_local() == 4l);
		assertTrue(statemachine.getAa_check() == 5l);
		assertTrue(statemachine.getAa_local() == 6l);
		assertTrue(statemachine.getAc_check() == 7l);
		assertTrue(statemachine.getAc_local() == 8l);
		assertTrue(statemachine.getA_check() == 9l);
		assertTrue(statemachine.getA_local() == 10l);
		assertTrue(statemachine.getC_check() == 11l);
		assertTrue(statemachine.getC_local() == 0l);
		assertTrue(statemachine.getSm_local() == 12l);
	}
}
