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
package org.yakindu.sct.generator.csharp.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.yakindu.sct.generator.csharp.CSharpSCTGeneratorTest;

@RunWith(Suite.class)
@SuiteClasses({ OperationsTestCustom.class, OperationsWithoutBracesCustom.class, CSharpSCTGeneratorTest.class })
public class AllTestsTestCustom {
}
