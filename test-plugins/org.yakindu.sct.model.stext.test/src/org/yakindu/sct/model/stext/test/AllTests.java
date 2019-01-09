/**
 * Copyright (c) 2012-2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.stext.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.yakindu.sct.model.stext.test.validation.STextValidatorTest;
import org.yakindu.sct.model.stext.test.validation.TransitionsWithNoTriggerTest;

/**
 * @author andreas muelder - Initial contribution and API
 * @author terfloth - extensions
 * 
 */
@RunWith(value = Suite.class)
@SuiteClasses(value = { TypeInferrerTest.class, StextParserRuleTest.class, TestModelsContainErrorsTest.class,
		SCTUnitClassifierTest.class, STextValidatorTest.class, TransitionsWithNoTriggerTest.class,
		STextScopeProviderTest.class })

public class AllTests {
}
