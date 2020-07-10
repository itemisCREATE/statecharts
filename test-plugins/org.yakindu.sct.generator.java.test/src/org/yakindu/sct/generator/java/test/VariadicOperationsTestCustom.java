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

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.yakindu.scr.variadicfunctions.IVariadicFunctionsStatemachine.InternalOperationCallback;
import org.yakindu.scr.variadicfunctions.IVariadicFunctionsStatemachine.InterfaceIF2OperationCallback;
import org.yakindu.scr.variadicfunctions.IVariadicFunctionsStatemachine.InterfaceOperationCallback;
import org.yakindu.scr.variadicfunctions.VariadicFunctionsStatemachine;

/**
 * Unit TestCase for Variadic Functions
 */
public class VariadicOperationsTestCustom {

	private VariadicFunctionsStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new VariadicFunctionsStatemachine();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void test() {
		InternalOperationCallback internalMock = mock(InternalOperationCallback.class);
		ArgumentCaptor<Double> internalCapture = ArgumentCaptor.forClass(Double.class);
		InterfaceOperationCallback interfaceMock = mock(InterfaceOperationCallback.class);
		ArgumentCaptor<String> interfaceCapture = ArgumentCaptor.forClass(String.class);
		InterfaceIF2OperationCallback interface2Mock = mock(InterfaceIF2OperationCallback.class);
		ArgumentCaptor<Long> interface2Capture = ArgumentCaptor.forClass(Long.class);

		statemachine.setInternalOperationCallback(internalMock);
		statemachine.getInterface().setInterfaceOperationCallback(interfaceMock);
		statemachine.getInterfaceIF2().setInterfaceIF2OperationCallback(interface2Mock);
		statemachine.init();
		statemachine.enter();

		verify(interfaceMock, times(3)).myVarOperation(interfaceCapture.capture());
		assertThat(interfaceCapture.getAllValues(), is(Arrays.asList("one", "one", "two", "three")));
		statemachine.runCycle();

		verify(internalMock, times(1)).myInternalVarOperation(internalCapture.capture());
		assertThat(internalCapture.getAllValues(), is(Arrays.asList(0.0, 0.2)));
		statemachine.runCycle();
		verify(interface2Mock, times(3)).myVarOperation2(ArgumentCaptor.forClass(Long.class).capture(),
				interface2Capture.capture());
		assertThat(interface2Capture.getAllValues(), is(Arrays.asList(2L, 2L, 3L, 4L)));
	}

}
