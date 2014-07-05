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
import static org.junit.Assert.*;
import org.yakindu.scr.featurecalls.FeatureCallsStatemachine;
import org.yakindu.scr.featurecalls.FeatureCallsStatemachine.State;
/**
 *  Unit TestCase for FeatureCalls
 */
@SuppressWarnings("all")
public class FeatureCallsTest {

	private FeatureCallsStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new FeatureCallsStatemachine();
		statemachine.init();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testFeatureCalls() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_A));
	}
}
