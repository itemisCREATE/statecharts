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

@GTest(sourceFile = "gtests/UnimplementedOCBTest/UnimplementedOCBTest.cc", program = "gtests/UnimplementedOCBTest/UnimplementedOCB", model = "testmodels/SCTUnit/UnimplementedOCB.sct", statechartBundle = "org.yakindu.sct.test.models")
@RunWith(GTestRunner.class)
public class UnimplementedOCBTest {
	protected final GTestHelper helper = new GTestHelper(this, Compiler.GPLUSPLUS) {

		@Override
		protected void getTestDataFiles(Collection<String> files) {
			super.getTestDataFiles(files);
			files.add("gtests/UnimplementedOCBTest/OCBDefaultInterfaceImpl.h");
			files.add("gtests/UnimplementedOCBTest/OCBInternalImpl.h");
			files.add("gtests/UnimplementedOCBTest/OCBNamedInterfaceImpl.h");
		}

		@Override
		protected void getSourceFiles(Collection<String> files) {
			super.getSourceFiles(files);
			files.add(getFileName(getTestProgram()) + ".cpp");
		}

	};

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
