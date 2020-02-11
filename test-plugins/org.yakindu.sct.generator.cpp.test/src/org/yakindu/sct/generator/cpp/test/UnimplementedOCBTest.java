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

import java.util.Collection;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.yakindu.sct.generator.c.gtest.GTest;
import org.yakindu.sct.generator.c.gtest.GTestHelper;
import org.yakindu.sct.generator.c.gtest.GTestRunner;
import org.yakindu.sct.generator.c.gtest.GTestHelper.Compiler;

@GTest(
		statechartBundle = "org.yakindu.sct.test.models",
		sourceFile = "gtests/UnimplementedOCBTest/UnimplementedOCBTest.cc", 
		program = "gtests/UnimplementedOCBTest/UnimplementedOCB", 
		model = "testmodels/SCTUnit/UnimplementedOCB.sct", 
		additionalFilesToCopy = {
			"gtests/UnimplementedOCBTest/OCBDefaultInterfaceImpl.h",
			"gtests/UnimplementedOCBTest/OCBInternalImpl.h",
			"gtests/UnimplementedOCBTest/OCBNamedInterfaceImpl.h",
			"gtests/UnimplementedOCBTest/OCBInternalImpl.cpp",
			"gtests/UnimplementedOCBTest/OCBNamedInterfaceImpl.cpp",
			"gtests/UnimplementedOCBTest/OCBDefaultInterfaceImpl.cpp",
			"libraryTarget/sc_runner.h",
			"libraryTarget/sc_runner.cpp"
		}, 
		additionalFilesToCompile = {
			"UnimplementedOCB.cpp",
			"OCBInternalImpl.cpp",
			"OCBNamedInterfaceImpl.cpp",
			"OCBDefaultInterfaceImpl.cpp",
			"sc_runner.cpp"
		}
		)
@RunWith(GTestRunner.class)
public class UnimplementedOCBTest {
	protected final GTestHelper helper = new GTestHelper(this, Compiler.GPLUSPLUS) {

	};

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
