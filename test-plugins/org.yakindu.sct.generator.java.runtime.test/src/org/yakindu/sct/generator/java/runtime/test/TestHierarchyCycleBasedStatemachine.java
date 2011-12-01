/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	@author markus muehlbrandt - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.java.runtime.test;

import org.junit.After;
import org.junit.Before;
import org.yakindu.sct.runtime.java.test_hierarchy.Test_HierarchyCycleBasedStatemachine;

/**
 * Testcases for 'Test_LocalActions' cycle based statemachine.
 * 
 * @author muehlbrandt
 * 
 */
public class TestHierarchyCycleBasedStatemachine {

	private Test_HierarchyCycleBasedStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new Test_HierarchyCycleBasedStatemachine();
		statemachine.enter();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}
}
