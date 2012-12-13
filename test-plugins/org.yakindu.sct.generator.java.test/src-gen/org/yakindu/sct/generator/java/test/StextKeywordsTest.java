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
package org.yakindu.sct.generator.java.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.yakindu.scr.stextkeywordsinstatesandregions.STextKeywordsInStatesAndRegionsStatemachine;
import org.yakindu.scr.stextkeywordsinstatesandregions.STextKeywordsInStatesAndRegionsStatemachine.State;
/**
 *  Unit TestCase for STextKeywordsInStatesAndRegions
 */
@SuppressWarnings("all")
public class StextKeywordsTest {

	private STextKeywordsInStatesAndRegionsStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new STextKeywordsInStatesAndRegionsStatemachine();
		statemachine.init();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testactiveCheckWithSTextNamedStates() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.default_var));
		assertTrue(statemachine.isStateActive(State.operation_interface));
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.default_var));
		assertTrue(statemachine.isStateActive(State.operation_active));
		statemachine.runCycle();
	}
}
