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
import org.yakindu.scr.operations.IOperationsStatemachine.*;
import org.mockito.ArgumentCaptor;
import static org.mockito.ArgumentCaptor.forClass;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.operations.OperationsStatemachine;
import org.yakindu.scr.operations.OperationsStatemachine.State;

/**
 * Unit TestCase for Operations
 */
@SuppressWarnings("all")
public class OperationsTest {
	SCInterfaceOperationCallback defaultMock;
	InternalOperationCallback internalMock;
	SCIInterface1OperationCallback interface1Mock;
	private OperationsStatemachine statemachine;	
	
	@Before
	public void setUp() {
		statemachine = new OperationsStatemachine();
		statemachine.init();
		defaultMock = mock(SCInterfaceOperationCallback.class);
		statemachine.getSCInterface().setSCInterfaceOperationCallback(defaultMock);
		internalMock = mock(InternalOperationCallback.class);
		statemachine.setInternalOperationCallback(internalMock);
		interface1Mock = mock(SCIInterface1OperationCallback.class);
		statemachine.getSCIInterface1().setSCIInterface1OperationCallback(interface1Mock);
	}

	@After
	public void tearDown() {
		statemachine.getSCInterface().setSCInterfaceOperationCallback(null);
		statemachine.setInternalOperationCallback(null);
		statemachine.getSCIInterface1().setSCIInterface1OperationCallback(null);
		statemachine = null;
	}
	
	@Test
	public void testOperationsCalled() {
		when(defaultMock.alwaysTrue()).thenReturn(true);
		 
		when(internalMock.internalOperation3a(anyDouble())).thenAnswer(new Answer<Double>() {
			@Override
			public Double answer(InvocationOnMock invocation) {
				Object[] args = invocation.getArguments();
				Double param1 = (Double) args[0];
				return param1+1.0;
			}
		});
		 
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		 
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_B));
		 
		verify(internalMock, atLeastOnce()).internalOperation1();
		 
		ArgumentCaptor<Long> longCaptureinternalOperation2_7_0 = forClass(Long.class);
		verify(internalMock, atLeastOnce()).internalOperation2(longCaptureinternalOperation2_7_0.capture());
		assertThat(longCaptureinternalOperation2_7_0.getValue(), is(4l));
		 
		verify(internalMock, atLeastOnce()).internalOperation3();
		 
		ArgumentCaptor<Double> doubleCaptureinternalOperation3a_9_0 = forClass(Double.class);
		verify(internalMock, atLeastOnce()).internalOperation3a(doubleCaptureinternalOperation3a_9_0.capture());
		 
		verify(internalMock, atLeastOnce()).internalOperation4();
		 
		ArgumentCaptor<Long> longCaptureinternalOperation4a_11_0 = forClass(Long.class);
		verify(internalMock, atLeastOnce()).internalOperation4a(longCaptureinternalOperation4a_11_0.capture());
		assertThat(longCaptureinternalOperation4a_11_0.getValue(), is(5l));
		 
		verify(internalMock, atLeastOnce()).internalOperation5();
		 
		ArgumentCaptor<String> stringCaptureinternalOperation5a_13_0 = forClass(String.class);
		verify(internalMock, atLeastOnce()).internalOperation5a(stringCaptureinternalOperation5a_13_0.capture());
		assertThat(stringCaptureinternalOperation5a_13_0.getValue(), is(""));
		 
		ArgumentCaptor<Long> longCaptureinternalOperation2_14_0 = forClass(Long.class);
		verify(internalMock, atLeastOnce()).internalOperation2(longCaptureinternalOperation2_14_0.capture());
		assertThat(longCaptureinternalOperation2_14_0.getValue(), is(4l));
		 
		statemachine.raiseEv();;
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_C));
		 
		verify(interface1Mock, atLeastOnce()).interfaceOperation1();
		 
		ArgumentCaptor<Long> longCaptureinterfaceOperation2_19_0 = forClass(Long.class);
		verify(interface1Mock, atLeastOnce()).interfaceOperation2(longCaptureinterfaceOperation2_19_0.capture());
		assertThat(longCaptureinterfaceOperation2_19_0.getValue(), is(4l));
		 
		verify(interface1Mock, atLeastOnce()).interfaceOperation3();
		 
		ArgumentCaptor<Double> doubleCaptureinterfaceOperation3a_21_0 = forClass(Double.class);
		verify(interface1Mock, atLeastOnce()).interfaceOperation3a(doubleCaptureinterfaceOperation3a_21_0.capture());
		assertThat(doubleCaptureinterfaceOperation3a_21_0.getValue(), is(1.0));
		 
		verify(interface1Mock, atLeastOnce()).interfaceOperation4();
		 
		ArgumentCaptor<Long> longCaptureinterfaceOperation4a_23_0 = forClass(Long.class);
		verify(interface1Mock, atLeastOnce()).interfaceOperation4a(longCaptureinterfaceOperation4a_23_0.capture());
		assertThat(longCaptureinterfaceOperation4a_23_0.getValue(), is(5l));
		 
		verify(interface1Mock, atLeastOnce()).interfaceOperation5();
		 
		ArgumentCaptor<String> stringCaptureinterfaceOperation5a_25_0 = forClass(String.class);
		verify(interface1Mock, atLeastOnce()).interfaceOperation5a(stringCaptureinterfaceOperation5a_25_0.capture());
		assertThat(stringCaptureinterfaceOperation5a_25_0.getValue(), is(""));
		 
		statemachine.raiseEv();;
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_D));
		 
		verify(defaultMock, atLeastOnce()).unnamedInterfaceOperation1();
		 
		ArgumentCaptor<Long> longCaptureunnamedInterfaceOperation2_30_0 = forClass(Long.class);
		verify(defaultMock, atLeastOnce()).unnamedInterfaceOperation2(longCaptureunnamedInterfaceOperation2_30_0.capture());
		assertThat(longCaptureunnamedInterfaceOperation2_30_0.getValue(), is(4l));
		 
		verify(defaultMock, atLeastOnce()).unnamedOperation3();
		 
		ArgumentCaptor<Double> doubleCaptureunnamedOperation3a_32_0 = forClass(Double.class);
		verify(defaultMock, atLeastOnce()).unnamedOperation3a(doubleCaptureunnamedOperation3a_32_0.capture());
		assertThat(doubleCaptureunnamedOperation3a_32_0.getValue(), is(1.0));
		 
		verify(defaultMock, atLeastOnce()).unnamedOperation4();
		 
		ArgumentCaptor<Long> longCaptureunnamedOperation4a_34_0 = forClass(Long.class);
		verify(defaultMock, atLeastOnce()).unnamedOperation4a(longCaptureunnamedOperation4a_34_0.capture());
		assertThat(longCaptureunnamedOperation4a_34_0.getValue(), is(5l));
		 
		verify(defaultMock, atLeastOnce()).unnamedOperation5();
		 
		ArgumentCaptor<String> stringCaptureunnamedOperation5a_36_0 = forClass(String.class);
		verify(defaultMock, atLeastOnce()).unnamedOperation5a(stringCaptureunnamedOperation5a_36_0.capture());
		assertThat(stringCaptureunnamedOperation5a_36_0.getValue(), is(""));
		 
	}
}
