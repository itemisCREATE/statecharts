/**
 * Copyright (c) 2012 committers of YAKINDU and others.
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

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
@RunWith(value = Suite.class)
@SuiteClasses(value = { 
		TypeInferrerTest.class, 
		STextJavaValidatorTest.class, 
		StextParserRuleTest.class,
		TestModelsContainErrors.class 
		})
public class AllTests {

}
