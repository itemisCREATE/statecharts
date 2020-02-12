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
package org.yakindu.sct.generator.cpp.test;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.yakindu.sct.generator.c.gtest.GTest;
import org.yakindu.sct.generator.c.gtest.GTestHelper;
import org.yakindu.sct.generator.c.gtest.GTestHelper.Compiler;
import org.yakindu.sct.generator.c.gtest.GTestRunner;

@GTest(
		statechartBundle = "org.yakindu.sct.test.models", 
		sourceFile = "gtests/StateNumTest/StateNumTest.cc", 
		program = "gtests/StateNumTest/StateNumTest", 
		model = "testmodels/SCTUnit/HistoryWithoutInitialStep.sct", 
		additionalFilesToCopy = {
		"libraryTarget/sc_runner.h",
		"libraryTarget/sc_runner.cpp"
}, additionalFilesToCompile = {
		"HistoryWithoutInitialStep.cpp",
		"sc_runner.cpp"
})
@RunWith(GTestRunner.class)
public class StateNumTest {
	protected final GTestHelper helper = new GTestHelper(this, Compiler.GPLUSPLUS);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
