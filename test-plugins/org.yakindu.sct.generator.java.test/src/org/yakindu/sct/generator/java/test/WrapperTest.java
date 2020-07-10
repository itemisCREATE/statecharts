package org.yakindu.sct.generator.java.test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.yakindu.sct.RuntimeService;
import org.yakindu.scr.runnabletest.RunnableTestStatemachineRunnable;
import org.yakindu.scr.wrappertest.IWrapperTestStatemachine.InterfaceOperationCallback;
import org.yakindu.scr.wrappertest.SynchronizedWrapperTestStatemachine;
import org.yakindu.scr.wrappertest.WrapperTestStatemachine.State;

public class WrapperTest {

	private static final int CYCLE_TIME = 250;

	protected int operationCallbacks;

	@Before
	public void setup() {
		operationCallbacks = 0;
	}

	@Test
	public void synchronizedStatemachineWrapperTest() throws InterruptedException {

		int waitTimeSeconds = 10;
		SynchronizedWrapperTestStatemachine sm = new SynchronizedWrapperTestStatemachine();

		sm.getInterface().setInterfaceOperationCallback(new InterfaceOperationCallback() {

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
		assertTrue(sm.isStateActive(State.MAIN_REGION__FINAL_));
		assertTrue(sm.getInterface().getCycles() >= waitTimeSeconds * 1000 / CYCLE_TIME);
		assertTrue((waitTimeSeconds - operationCallbacks) <= 1);
		assertTrue((timer.getTimerCallbackCount(0) - sm.getInterface().getAfterCalls()) <= 1);
	}

	@Test
	public void runnableStatemachineWrapperTest() throws InterruptedException {
		
		int waitTimeSeconds = 11;
		
		RunnableTestStatemachineRunnable sm = new RunnableTestStatemachineRunnable();

		sm.getInterface().setInterfaceOperationCallback(
				new org.yakindu.scr.runnabletest.IRunnableTestStatemachine.InterfaceOperationCallback() {

					@Override
					public void displayTime() {
						operationCallbacks++;
					}
				});

		CustomTimerService timer = new CustomTimerService();
		sm.setTimer(timer);
		sm.init();
		sm.enter();
		Thread thread = new Thread(sm);
		thread.start();
		sleep(waitTimeSeconds);
		thread.interrupt();
		assertTrue(sm.isStateActive(org.yakindu.scr.runnabletest.RunnableTestStatemachine.State.MAIN_REGION__FINAL_));
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
