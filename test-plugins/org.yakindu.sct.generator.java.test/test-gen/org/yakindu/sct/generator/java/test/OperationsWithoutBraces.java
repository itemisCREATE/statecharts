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
import org.yakindu.scr.operationswithoutbraces.IOperationsWithoutBracesStatemachine.*;
import org.mockito.ArgumentCaptor;
import static org.mockito.ArgumentCaptor.forClass;
import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.operationswithoutbraces.OperationsWithoutBracesStatemachine;
import org.yakindu.scr.operationswithoutbraces.OperationsWithoutBracesStatemachine.State;

/**
 * Unit TestCase for OperationsWithoutBraces
 */
@SuppressWarnings("all")
public class OperationsWithoutBraces {
	SCInterfaceOperationCallback defaultMock;
	private OperationsWithoutBracesStatemachine statemachine;	
	
	@Before
	public void setUp() {
		statemachine = new OperationsWithoutBracesStatemachine();
		statemachine.init();
		defaultMock = mock(SCInterfaceOperationCallback.class);
		statemachine.getSCInterface().setSCInterfaceOperationCallback(defaultMock);
	}

	@After
	public void tearDown() {
		statemachine.getSCInterface().setSCInterfaceOperationCallback(null);
		statemachine = null;
	}
	
	@Test
	public void operationsWithoutBracesTest() {
		when(defaultMock.myBoolOp()).thenReturn(false);
		 
		when(defaultMock.myIntOp()).thenReturn(0l);
		 
		when(defaultMock.myRealOp()).thenReturn(0.0);
		 
		statemachine.enter();;
		assertTrue(statemachine.isStateActive(State.another_region_A));
		assertTrue(statemachine.isStateActive(State.main_region_A));
		statemachine.runCycle();;
		assertTrue(statemachine.isStateActive(State.another_region_C));
		assertTrue(statemachine.isStateActive(State.main_region_C));
		statemachine.runCycle();;
		assertTrue(statemachine.isStateActive(State.main_region_D));
		assertTrue(statemachine.isStateActive(State.another_region_D));
	}
}
