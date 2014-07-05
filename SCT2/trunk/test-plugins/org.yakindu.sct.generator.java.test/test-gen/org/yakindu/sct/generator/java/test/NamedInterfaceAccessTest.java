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
import org.yakindu.scr.namedinterfaceaccess.NamedInterfaceAccessStatemachine;
import org.yakindu.scr.namedinterfaceaccess.NamedInterfaceAccessStatemachine.State;
/**
 *  Unit TestCase for NamedInterfaceAccess
 */
@SuppressWarnings("all")
public class NamedInterfaceAccessTest {

	private NamedInterfaceAccessStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new NamedInterfaceAccessStatemachine();
		statemachine.init();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testSafeOpenSuccess() {
		statemachine.enter();
		statemachine.runCycle();
		statemachine.getSCIUser().raiseNumberPressed(3);
		statemachine.runCycle();
		statemachine.getSCIUser().raiseNumberPressed(7);
		statemachine.runCycle();
		statemachine.getSCIUser().raiseNumberPressed(5);
		statemachine.runCycle();
		assertTrue(statemachine.getSCISafe().isRaisedOpen());
	}
}
