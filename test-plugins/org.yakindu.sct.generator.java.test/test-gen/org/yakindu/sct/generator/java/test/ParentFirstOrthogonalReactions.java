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
import org.yakindu.scr.parentfirstorthogonalreactions.IParentFirstOrthogonalReactionsStatemachine.*;
import org.mockito.ArgumentCaptor;
import static org.mockito.ArgumentCaptor.forClass;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.parentfirstorthogonalreactions.ParentFirstOrthogonalReactionsStatemachine;
import org.yakindu.scr.parentfirstorthogonalreactions.ParentFirstOrthogonalReactionsStatemachine.State;

/**
 * Unit TestCase for ParentFirstOrthogonalReactions
 */
@SuppressWarnings("all")
public class ParentFirstOrthogonalReactions {
	SCInterfaceOperationCallback defaultMock;
	private ParentFirstOrthogonalReactionsStatemachine statemachine;	
	
	long counter = 0l;
	long checkFail = - 1l ;
	
	@Before
	public void setUp() {
		statemachine = new ParentFirstOrthogonalReactionsStatemachine();
		statemachine.init();
		defaultMock = mock(SCInterfaceOperationCallback.class);
		statemachine.getSCInterface().setSCInterfaceOperationCallback(defaultMock);
	}

	@After
	public void tearDown() {
		statemachine.getSCInterface().setSCInterfaceOperationCallback(null);
		statemachine = null;
	}
	
	public void setUp() {
		counter = 0l;
	}
	@Test
	public void executionOrder() {
		setUp();
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
		assertTrue(statemachine.getSm_local() == 1l);
		assertTrue(statemachine.getA_check() == 2l);
		assertTrue(statemachine.getA_local() == 3l);
		assertTrue(statemachine.getAa_check() == 4l);
		assertTrue(statemachine.getAa_local() == 5l);
		assertTrue(statemachine.getAaa_check() == 6l);
		assertTrue(statemachine.getAaa_local() == 7l);
		assertTrue(statemachine.getAac_check() == 8l);
		assertTrue(statemachine.getAac_local() == 9l);
		assertTrue(statemachine.getAc_check() == 10l);
		assertTrue(statemachine.getAc_local() == 11l);
		assertTrue(statemachine.getC_check() == 12l);
		assertTrue(statemachine.getC_local() == 13l);
	}
	@Test
	public void executionOrderWIthFirstLeafTransition() {
		setUp();
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
		assertTrue(statemachine.getSm_local() == 1l);
		assertTrue(statemachine.getA_check() == 2l);
		assertTrue(statemachine.getA_local() == 3l);
		assertTrue(statemachine.getAa_check() == 4l);
		assertTrue(statemachine.getAa_local() == 5l);
		assertTrue(statemachine.getAaa_check() == 6l);
		assertTrue(statemachine.getAaa_local() == 0l);
		assertTrue(statemachine.getAac_check() == 0l);
		assertTrue(statemachine.getAac_local() == 0l);
		assertTrue(statemachine.getAc_check() == 0l);
		assertTrue(statemachine.getAc_local() == 0l);
		assertTrue(statemachine.getC_check() == 7l);
		assertTrue(statemachine.getC_local() == 8l);
	}
	@Test
	public void executionOrderWIthFirstParentTransition() {
		setUp();
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
		assertTrue(statemachine.getSm_local() == 1l);
		assertTrue(statemachine.getA_check() == 2l);
		assertTrue(statemachine.getA_local() == 3l);
		assertTrue(statemachine.getAa_check() == 4l);
		assertTrue(statemachine.getAa_local() == 0l);
		assertTrue(statemachine.getAaa_check() == 0l);
		assertTrue(statemachine.getAaa_local() == 0l);
		assertTrue(statemachine.getAac_check() == 0l);
		assertTrue(statemachine.getAac_local() == 0l);
		assertTrue(statemachine.getAc_check() == 0l);
		assertTrue(statemachine.getAc_local() == 0l);
		assertTrue(statemachine.getC_check() == 5l);
		assertTrue(statemachine.getC_local() == 6l);
	}
	@Test
	public void executionOrderWIthFirstGrandParentTransition() {
		setUp();
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
		assertTrue(statemachine.getSm_local() == 1l);
		assertTrue(statemachine.getA_check() == 2l);
		assertTrue(statemachine.getA_local() == 0l);
		assertTrue(statemachine.getAa_check() == 0l);
		assertTrue(statemachine.getAa_local() == 0l);
		assertTrue(statemachine.getAaa_check() == 0l);
		assertTrue(statemachine.getAaa_local() == 0l);
		assertTrue(statemachine.getAac_check() == 0l);
		assertTrue(statemachine.getAac_local() == 0l);
		assertTrue(statemachine.getAc_check() == 0l);
		assertTrue(statemachine.getAc_local() == 0l);
		assertTrue(statemachine.getC_check() == 3l);
		assertTrue(statemachine.getC_local() == 4l);
	}
	@Test
	public void executionOrderWithLastLeafTransition() {
		setUp();
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
		assertTrue(statemachine.getSm_local() == 1l);
		assertTrue(statemachine.getA_check() == 2l);
		assertTrue(statemachine.getA_local() == 3l);
		assertTrue(statemachine.getAa_check() == 4l);
		assertTrue(statemachine.getAa_local() == 5l);
		assertTrue(statemachine.getAaa_check() == 6l);
		assertTrue(statemachine.getAaa_local() == 7l);
		assertTrue(statemachine.getAac_check() == 8l);
		assertTrue(statemachine.getAac_local() == 9l);
		assertTrue(statemachine.getAc_check() == 10l);
		assertTrue(statemachine.getAc_local() == 11l);
		assertTrue(statemachine.getC_check() == 12l);
		assertTrue(statemachine.getC_local() == 0l);
	}
}
