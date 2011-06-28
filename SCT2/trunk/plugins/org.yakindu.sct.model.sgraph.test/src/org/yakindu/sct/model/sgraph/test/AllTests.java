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
package org.yakindu.sct.model.sgraph.test;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * 
 * @author terfloth
 * 
@RunWith(value=Suite.class)
@SuiteClasses(value={
		ExpressionsTest.class, 
		FunctionsTest.class,
		CoreFunctionsTest.class
		}) 
*/
public class AllTests extends TestSuite{
	
	public static Test suite() {
		TestSuite suite = new AllTests();
		suite.addTestSuite(SGraphBaseValidationTest.class);
			
		return suite;
	}

	

}
