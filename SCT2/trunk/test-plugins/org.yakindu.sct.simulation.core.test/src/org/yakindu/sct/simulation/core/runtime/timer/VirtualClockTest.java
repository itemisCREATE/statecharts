/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.simulation.core.runtime.timer;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class VirtualClockTest {

	private VirtualClock clock;

	@Before
	public void setup() {
		clock = new VirtualClock();
	}

	@Test
	public void testSimpleTimeScaling() throws InterruptedException {
		long start = System.currentTimeMillis();
		clock.start();
		Thread.sleep(200);
		clock.setFactor(2);
		Thread.sleep(200);
		assertFuzzy(clock.getTime() - start, 600);
	}

	@Test
	public void testDoubleTimeScaling() throws InterruptedException {
		long start = System.currentTimeMillis();
		clock.start();
		Thread.sleep(200);
		clock.setFactor(2);
		Thread.sleep(200);
		clock.setFactor(0.5);
		Thread.sleep(200);
		assertFuzzy(clock.getTime() - start, 700);
	}

	@Test
	public void testsuspendResume() throws InterruptedException {
		long start = System.currentTimeMillis();
		clock.start();
		Thread.sleep(200);
		clock.suspend();
		Thread.sleep(200);
		clock.resume();
		assertFuzzy(clock.getTime() - start, 200);
	}
	
	@Test
	public void testsuspendResumeTimeScaling() throws InterruptedException {
		long start = System.currentTimeMillis();
		clock.start();
		Thread.sleep(200);
		clock.setFactor(2);
		Thread.sleep(200);
		clock.suspend();
		Thread.sleep(200);
		clock.resume();
		clock.setFactor(0.5);
		Thread.sleep(200);
		assertFuzzy(clock.getTime() - start, 700);
	}
	
	@Test
	public void testScaleDuringsuspend() throws InterruptedException {
		long start = System.currentTimeMillis();
		clock.start();
		Thread.sleep(200);
		clock.setFactor(4);
		Thread.sleep(200);
		clock.suspend();
		clock.setFactor(0.25);
		Thread.sleep(200);
		clock.resume();
		Thread.sleep(200);
		assertFuzzy(clock.getTime() - start, 1050);
	}

	private static final long GAP = 20; // ms

	protected void assertFuzzy(long expected, long actual) {
		assertTrue("Expected " + expected + " but was " + actual,
				expected > actual - GAP && expected < actual + GAP);
	}

}
