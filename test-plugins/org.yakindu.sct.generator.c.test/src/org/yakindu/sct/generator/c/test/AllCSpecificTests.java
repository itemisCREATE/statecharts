/**
 * Copyright (c) 2014-2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.c.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Suite of all test cases that are specific to the C code generator and which are not defined by the
 * set of cross target language tests.
 *
 * @author terfloth
 */
@RunWith(Suite.class)
@SuiteClasses({
	ActiveBeforeInit.class,
	OperationsWithoutBracesCustom.class,
	InternalEventLifeCycleTest_Naming.class,
	PedanticNoLocalEventsTest.class,
	VariadicOperations.class,
	StateNumTest.class,
	TracingTest.class
})
public class AllCSpecificTests {
}
