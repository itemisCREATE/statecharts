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
import org.yakindu.scr.sync.IWrapperTestStatemachine.SCInterfaceOperationCallback;
import org.yakindu.scr.sync.WrapperTestStatemachine;
import org.yakindu.scr.sync.WrapperTestStatemachine.State;

public class SynchronizedTest {

	private static final int CYCLE_TIME = 250;

	protected int operationCallbacks;

	@Before
	public void setup() {
		operationCallbacks = 0;
	}

	@Test
	public void synchronizedStatemachineWrapperTest() throws InterruptedException {

		int waitTimeSeconds = 10;
		WrapperTestStatemachine sm = new WrapperTestStatemachine();

		sm.getSCInterface().setSCInterfaceOperationCallback(new SCInterfaceOperationCallback() {

			@Override
			public void displayTime() {
				operationCallbacks++;
			}
		});

		CustomTimerService timer = new CustomTimerService();
		sm.setTimer(timer);
		sm.init();
		sm.enter();
		RuntimeService.getInstance().registerStatemachine(sm, CYCLE_TIME);

		sleep(waitTimeSeconds);
		RuntimeService.getInstance().cancelTimer();
		assertTrue(sm.isStateActive(State.main_region__final_));
		assertTrue(sm.getSCInterface().getCycles() >= waitTimeSeconds * 1000 / CYCLE_TIME);
		assertTrue((waitTimeSeconds - operationCallbacks) <= 1);
		assertTrue((timer.getTimerCallbackCount(0) - sm.getSCInterface().getAfterCalls()) <= 1);
	}

	@After
	public void tearDown() {
		RuntimeService.getInstance().cancelTimer();
	}

	private void sleep(long time) throws InterruptedException {
		Thread.sleep(time * 1000);
	}
}
