/**
 * Copyright (c) 2014 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */

package org.yakindu.sct.generator.java.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.yakindu.scr.operations.IOperationsStatemachine.InterfaceInterface1OperationCallback;
import org.yakindu.scr.operations.IOperationsStatemachine.InterfaceOperationCallback;
import org.yakindu.scr.operations.OperationsStatemachine;
import org.yakindu.scr.operations.IOperationsStatemachine.InternalOperationCallback;
import org.yakindu.scr.operations.OperationsStatemachine.State;
/**
 *  Unit TestCase for Operations
 */
@SuppressWarnings("all")
public class OperationsTestCustom{

	private OperationsStatemachine statemachine;
	private InternalOperationCallback internalMock;
	private InterfaceOperationCallback interfaceMock;
	private InterfaceInterface1OperationCallback interface2Mock;
	
	@Before
	public void setUp() {
		internalMock = mock(InternalOperationCallback.class);
		interfaceMock = mock(InterfaceOperationCallback.class);
		interface2Mock = mock(InterfaceInterface1OperationCallback.class);
		when(interfaceMock.alwaysTrue()).thenReturn(true);
		statemachine = new OperationsStatemachine();
		statemachine.setInternalOperationCallback(internalMock);
		statemachine.getInterface().setInterfaceOperationCallback(interfaceMock);
		statemachine.getInterfaceInterface1().setInterfaceInterface1OperationCallback(interface2Mock);
		statemachine.init();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testOperationsSimpleTest() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.MAIN_REGION_A));
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.MAIN_REGION_B));
	}
	
	@Test
	public void testOperationsTest() {
		ArgumentCaptor<Boolean> booleanCapture = ArgumentCaptor.forClass(Boolean.class);
		ArgumentCaptor<Double> doubleCapture = ArgumentCaptor.forClass(Double.class);
		ArgumentCaptor<Long> longCapture = ArgumentCaptor.forClass(Long.class);
		ArgumentCaptor<String> stringCapture = ArgumentCaptor.forClass(String.class);
		
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.MAIN_REGION_A));
		statemachine.runCycle();
		
		//State is active
	    
		assertTrue(statemachine.isStateActive(State.MAIN_REGION_B));
		
		//Operations in State B used 
		
		verify(internalMock).internalOperation1();
		
		verify(internalMock).internalOperation2(longCapture.capture());
		assertThat(longCapture.getValue(), is(4L));
		
		verify(internalMock).internalOperation3();
		
		verify(internalMock).internalOperation3a(doubleCapture.capture());
		assertThat(doubleCapture.getValue(), is(1.0));
		
		verify(internalMock).internalOperation4();
		
		verify(internalMock).internalOperation4a(longCapture.capture());
		assertThat(longCapture.getValue(), is(5L));
		
		verify(internalMock).internalOperation5();
		
		verify(internalMock).internalOperation5a(stringCapture.capture());
		assertThat(stringCapture.getValue(),is(""));
		
		
		statemachine.raiseEv();
		statemachine.runCycle();
		
		//State is active
		
		assertTrue(statemachine.isStateActive(State.MAIN_REGION_C));
		
		//Operations in State C used
		
		verify(interface2Mock).interfaceOperation1();
		
		verify(interface2Mock).interfaceOperation2(longCapture.capture());
		assertThat(longCapture.getValue(), is(4L));
		
		verify(interface2Mock).interfaceOperation3();
		
		verify(interface2Mock).interfaceOperation3a(doubleCapture.capture());
		assertThat(doubleCapture.getValue(), is(1.0));
		
		verify(interface2Mock).interfaceOperation4();
		
		verify(interface2Mock).interfaceOperation4a(longCapture.capture());
		assertThat(longCapture.getValue(), is(5L));
		
		verify(interface2Mock).interfaceOperation5();
		
		verify(interface2Mock).interfaceOperation5a(stringCapture.capture());
		assertThat(stringCapture.getValue(),is(""));
		
		
		statemachine.raiseEv();
		statemachine.runCycle();
		
		//State is active
		
		assertTrue(statemachine.isStateActive(State.MAIN_REGION_D));
		
		//Operations in State D used
		
		verify(interfaceMock).unnamedInterfaceOperation1();
		
		verify(interfaceMock).unnamedInterfaceOperation2(longCapture.capture());
		assertThat(longCapture.getValue(), is(4L));
		
		verify(interfaceMock).unnamedOperation3();
		
		verify(interfaceMock).unnamedOperation3a(doubleCapture.capture());
		assertThat(doubleCapture.getValue(), is(1.0));
		
		verify(interfaceMock).unnamedOperation4();
		
		verify(interfaceMock).unnamedOperation4a(longCapture.capture());
		assertThat(longCapture.getValue(), is(5L));
		
		verify(interfaceMock).unnamedOperation5();
		
		verify(interfaceMock).unnamedOperation5a(stringCapture.capture());
		assertThat(stringCapture.getValue(),is(""));
	}
}