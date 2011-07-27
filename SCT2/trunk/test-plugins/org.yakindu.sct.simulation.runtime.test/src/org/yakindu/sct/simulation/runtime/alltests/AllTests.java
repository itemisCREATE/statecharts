/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.simulation.runtime.alltests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.yakindu.sct.simulation.runtime.sgraph.builder.test.SGraphBuilderTest;
import org.yakindu.sct.simulation.runtime.sgraph.test.StatechartTest;
import org.yakindu.sct.simulation.runtime.stext.builder.test.STextBuilderTest;
import org.yakindu.sct.simulation.runtime.stext.test.CoreFunctionsTest;
import org.yakindu.sct.simulation.runtime.stext.test.ExpressionsTest;
import org.yakindu.sct.simulation.runtime.stext.test.FunctionsTest;

@RunWith(Suite.class)
@SuiteClasses(value = { SGraphBuilderTest.class, StatechartTest.class,
		STextBuilderTest.class, CoreFunctionsTest.class, ExpressionsTest.class,
		FunctionsTest.class })
public class AllTests {

}
