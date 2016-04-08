/**
 * Copyright (c) 2015 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */

package org.yakindu.sct.generator.csharp.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.yakindu.scr.localreactions.LocalReactionsStatemachine;
import org.yakindu.scr.localreactions.LocalReactionsStatemachine.State;
/**
 *  Unit TestCase for LocalReactions
 */
@SuppressWarnings("all")
public class LocalReactionsTest {

	private LocalReactionsStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new LocalReactionsStatemachine();
		statemachine.init();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testLocalReactionsTest() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		statemachine.runCycle();
		assertTrue(statemachine.getX() == 1l);
	}
}
