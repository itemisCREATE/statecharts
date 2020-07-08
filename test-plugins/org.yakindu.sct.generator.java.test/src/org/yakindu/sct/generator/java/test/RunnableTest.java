/**
 * Copyright (c) 2019 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */

package org.yakindu.sct.generator.java.test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.yakindu.sct.RuntimeService;
import org.yakindu.scr.runnable.eventdriven.IRunnableTestStatemachine;
import org.yakindu.scr.runnable.eventdriven.RunnableTestStatemachine;

public class RunnableTest {
	protected int operationCallbacks;

	@Before
	public void setup() {
		operationCallbacks = 0;
	}

	@Test
	public void runnableStatemachineWrapperTest() throws InterruptedException {
		
		int waitTimeSeconds = 11;
		
		RunnableTestStatemachine sm = new RunnableTestStatemachine();

		sm.getInterface().setInterfaceOperationCallback(
				new IRunnableTestStatemachine.InterfaceOperationCallback() {

					@Override
					public void displayTime() {
						operationCallbacks++;
					}
				});

		CustomTimerService timer = new CustomTimerService();
		sm.setTimer(timer);
		Thread thread = new Thread(sm);
		thread.start();
		sleep(waitTimeSeconds);
		thread.interrupt();
		assertTrue(sm.isStateActive(RunnableTestStatemachine.State.runnableTest_main_region__final_));
		sm.exit();
		assertTrue((waitTimeSeconds - operationCallbacks) <= 1);
		assertTrue((timer.getTimerCallbackCount(1) - sm.getInterface().getAfterCalls()) <= 1);
	}

	@After
	public void tearDown() {
		RuntimeService.getInstance().cancelTimer();
	}

	private void sleep(long time) throws InterruptedException {
		Thread.sleep(time * 1000);
	}
}
