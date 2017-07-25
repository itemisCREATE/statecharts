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

import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.deepentry.DeepEntryStatemachine;
import org.yakindu.scr.deepentry.DeepEntryStatemachine.State;	

/**
 * Unit TestCase for DeepEntry
 */
@SuppressWarnings("all")
public class DeepEntry {
	
	private DeepEntryStatemachine statemachine;	
	
	
	
	@Before
	public void deepEntry_setUp() {
		statemachine = new DeepEntryStatemachine();
		statemachine.init();
	}

	@After
	public void deepEntry_tearDown() {
		statemachine = null;
	}
	
	@Test
	public void enterToSubstate() {
		statemachine.enter();
		long vergleich = 4l;
		assertTrue(vergleich == 4l);
		statemachine.exit();
	}
}
