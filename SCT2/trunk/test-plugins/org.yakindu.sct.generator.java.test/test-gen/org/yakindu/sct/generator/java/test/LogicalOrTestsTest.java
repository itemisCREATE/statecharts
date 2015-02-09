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

package org.yakindu.sct.generator.java.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.yakindu.scr.logicalor.LogicalOrStatemachine;
import org.yakindu.scr.logicalor.LogicalOrStatemachine.State;
/**
 *  Unit TestCase for LogicalOr
 */
@SuppressWarnings("all")
public class LogicalOrTestsTest {

	private LogicalOrStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new LogicalOrStatemachine();
		statemachine.init();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testoperandEvaluationOrder() {
		statemachine.enter();
		statemachine.runCycle();
		assertTrue("logical or expression was executed in wrong order...",
				statemachine.getX() == 4 && statemachine.getB());
	}
}
