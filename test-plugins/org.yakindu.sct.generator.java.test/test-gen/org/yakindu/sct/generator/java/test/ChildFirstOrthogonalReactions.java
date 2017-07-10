/**
* Copyright (c) 2017 committers of YAKINDU and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*     committers of YAKINDU - initial API and implementation
*/

package org.yakindu.sct.generator.java.test;

import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;
import static org.hamcrest.CoreMatchers.*;
import org.yakindu.scr.childfirstorthogonalreactions.IChildFirstOrthogonalReactionsStatemachine.*;
import org.mockito.ArgumentCaptor;
import static org.mockito.ArgumentCaptor.forClass;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.childfirstorthogonalreactions.ChildFirstOrthogonalReactionsStatemachine;
import org.yakindu.scr.childfirstorthogonalreactions.ChildFirstOrthogonalReactionsStatemachine.State;

/**
 * Unit TestCase for ChildFirstOrthogonalReactions
 */
@SuppressWarnings("all")
public class ChildFirstOrthogonalReactions {
	SCInterfaceOperationCallback defaultMock;
	private ChildFirstOrthogonalReactionsStatemachine statemachine;	
	
	long counter = 0l;
	long checkFail = - 1l ;
	
	@Before
	public void setUp() {
		statemachine = new ChildFirstOrthogonalReactionsStatemachine();
		statemachine.init();
		defaultMock = mock(SCInterfaceOperationCallback.class);
		statemachine.getSCInterface().setSCInterfaceOperationCallback(defaultMock);
	}

	@After
	public void tearDown() {
		statemachine.getSCInterface().setSCInterfaceOperationCallback(null);
		statemachine = null;
	}
	
	public void set_up() {
		counter = 0l;
	}
	public boolean foo(String id) {
		return false;
	}
	@Test
	public void executionOrder() {
		set_up();
		when(defaultMock.check(anyString())).thenReturn(foo);
		 
		when(defaultMock.check(anyString())).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				Object[] args = invocation.getArguments();
				String id = (String) args[0];
				return (statemachine.setAa_check((counter += 1l))) == checkFail;
			}
		});
		 
		when(defaultMock.check(anyString())).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				Object[] args = invocation.getArguments();
				String id = (String) args[0];
				return (statemachine.setAaa_check((counter += 1l))) == checkFail;
			}
		});
		 
		when(defaultMock.check(anyString())).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				Object[] args = invocation.getArguments();
				String id = (String) args[0];
				return (statemachine.setAac_check((counter += 1l))) == checkFail;
			}
		});
		 
		when(defaultMock.check(anyString())).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				Object[] args = invocation.getArguments();
				String id = (String) args[0];
				return (statemachine.setAc_check((counter += 1l))) == checkFail;
			}
		});
		 
		when(defaultMock.check(anyString())).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				Object[] args = invocation.getArguments();
				String id = (String) args[0];
				return (statemachine.setC_check((counter += 1l))) == checkFail;
			}
		});
		 
		when(defaultMock.next()).thenAnswer(new Answer<Long>() {
			@Override
			public Long answer(InvocationOnMock invocation) {
				Object[] args = invocation.getArguments();
				return counter += 1l;
			}
		});
		 
		statemachine.enter();;
		statemachine.runCycle();
		;
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
		set_up();
		when(defaultMock.check(anyString())).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				Object[] args = invocation.getArguments();
				String id = (String) args[0];
				return (statemachine.setA_check((counter += 1l))) == checkFail;
			}
		});
		 
		when(defaultMock.check(anyString())).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				Object[] args = invocation.getArguments();
				String id = (String) args[0];
				return (statemachine.setAa_check((counter += 1l))) == checkFail;
			}
		});
		 
		when(defaultMock.check(anyString())).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				Object[] args = invocation.getArguments();
				String id = (String) args[0];
				return (statemachine.setAaa_check((counter += 1l))) == statemachine.getAaa_check();
			}
		});
		 
		when(defaultMock.check(anyString())).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				Object[] args = invocation.getArguments();
				String id = (String) args[0];
				return (statemachine.setAac_check((counter += 1l))) == checkFail;
			}
		});
		 
		when(defaultMock.check(anyString())).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				Object[] args = invocation.getArguments();
				String id = (String) args[0];
				return (statemachine.setAc_check((counter += 1l))) == checkFail;
			}
		});
		 
		when(defaultMock.check(anyString())).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				Object[] args = invocation.getArguments();
				String id = (String) args[0];
				return (statemachine.setC_check((counter += 1l))) == checkFail;
			}
		});
		 
		when(defaultMock.next()).thenAnswer(new Answer<Long>() {
			@Override
			public Long answer(InvocationOnMock invocation) {
				Object[] args = invocation.getArguments();
				return counter += 1l;
			}
		});
		 
		statemachine.enter();;
		statemachine.runCycle();
		;
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
		set_up();
		when(defaultMock.check(anyString())).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				Object[] args = invocation.getArguments();
				String id = (String) args[0];
				return (statemachine.setA_check((counter += 1l))) == checkFail;
			}
		});
		 
		when(defaultMock.check(anyString())).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				Object[] args = invocation.getArguments();
				String id = (String) args[0];
				return (statemachine.setAa_check((counter += 1l))) == statemachine.getAa_check();
			}
		});
		 
		when(defaultMock.check(anyString())).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				Object[] args = invocation.getArguments();
				String id = (String) args[0];
				return (statemachine.setAaa_check((counter += 1l))) == checkFail;
			}
		});
		 
		when(defaultMock.check(anyString())).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				Object[] args = invocation.getArguments();
				String id = (String) args[0];
				return (statemachine.setAac_check((counter += 1l))) == checkFail;
			}
		});
		 
		when(defaultMock.check(anyString())).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				Object[] args = invocation.getArguments();
				String id = (String) args[0];
				return (statemachine.setAc_check((counter += 1l))) == checkFail;
			}
		});
		 
		when(defaultMock.check(anyString())).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				Object[] args = invocation.getArguments();
				String id = (String) args[0];
				return (statemachine.setC_check((counter += 1l))) == checkFail;
			}
		});
		 
		when(defaultMock.next()).thenAnswer(new Answer<Long>() {
			@Override
			public Long answer(InvocationOnMock invocation) {
				Object[] args = invocation.getArguments();
				return counter += 1l;
			}
		});
		 
		statemachine.enter();;
		statemachine.runCycle();
		;
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
		set_up();
		when(defaultMock.check(anyString())).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				Object[] args = invocation.getArguments();
				String id = (String) args[0];
				return (statemachine.setA_check((counter += 1l))) == statemachine.getA_check();
			}
		});
		 
		when(defaultMock.check(anyString())).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				Object[] args = invocation.getArguments();
				String id = (String) args[0];
				return (statemachine.setAa_check((counter += 1l))) == checkFail;
			}
		});
		 
		when(defaultMock.check(anyString())).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				Object[] args = invocation.getArguments();
				String id = (String) args[0];
				return (statemachine.setAaa_check((counter += 1l))) == checkFail;
			}
		});
		 
		when(defaultMock.check(anyString())).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				Object[] args = invocation.getArguments();
				String id = (String) args[0];
				return (statemachine.setAac_check((counter += 1l))) == checkFail;
			}
		});
		 
		when(defaultMock.check(anyString())).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				Object[] args = invocation.getArguments();
				String id = (String) args[0];
				return (statemachine.setAc_check((counter += 1l))) == checkFail;
			}
		});
		 
		when(defaultMock.check(anyString())).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				Object[] args = invocation.getArguments();
				String id = (String) args[0];
				return (statemachine.setC_check((counter += 1l))) == checkFail;
			}
		});
		 
		when(defaultMock.next()).thenAnswer(new Answer<Long>() {
			@Override
			public Long answer(InvocationOnMock invocation) {
				Object[] args = invocation.getArguments();
				return counter += 1l;
			}
		});
		 
		statemachine.enter();;
		statemachine.runCycle();
		;
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
		set_up();
		when(defaultMock.check(anyString())).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				Object[] args = invocation.getArguments();
				String id = (String) args[0];
				return (statemachine.setA_check((counter += 1l))) == checkFail;
			}
		});
		 
		when(defaultMock.check(anyString())).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				Object[] args = invocation.getArguments();
				String id = (String) args[0];
				return (statemachine.setAa_check((counter += 1l))) == checkFail;
			}
		});
		 
		when(defaultMock.check(anyString())).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				Object[] args = invocation.getArguments();
				String id = (String) args[0];
				return (statemachine.setAaa_check((counter += 1l))) == checkFail;
			}
		});
		 
		when(defaultMock.check(anyString())).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				Object[] args = invocation.getArguments();
				String id = (String) args[0];
				return (statemachine.setAac_check((counter += 1l))) == checkFail;
			}
		});
		 
		when(defaultMock.check(anyString())).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				Object[] args = invocation.getArguments();
				String id = (String) args[0];
				return (statemachine.setAc_check((counter += 1l))) == checkFail;
			}
		});
		 
		when(defaultMock.check(anyString())).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				Object[] args = invocation.getArguments();
				String id = (String) args[0];
				return (statemachine.setC_check((counter += 1l))) == statemachine.getC_check();
			}
		});
		 
		when(defaultMock.next()).thenAnswer(new Answer<Long>() {
			@Override
			public Long answer(InvocationOnMock invocation) {
				Object[] args = invocation.getArguments();
				return counter += 1l;
			}
		});
		 
		statemachine.enter();;
		statemachine.runCycle();
		;
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
