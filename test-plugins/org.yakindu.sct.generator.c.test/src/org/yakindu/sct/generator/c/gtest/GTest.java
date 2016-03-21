/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.yakindu.sct.generator.c.gtest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface GTest {

	String sourceFile();
	String program();
	String model();

	/**
	 * If no test bundle provided, source files (cc and sgen) are expected to be
	 * in the Junit test's bundle and the model file (sct) in
	 * org.yakindu.sct.test.models.
	 * 
	 * If test bundle is provided, all test files (cc, sgen, sct) are exepcted
	 * to be located in the test bundle. Also a project of the same name is
	 * created in Junit workspace.
	 * 
	 */
	String testBundle() default "";

}