/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 *
 */

package org.yakindu.sct.generator.c.gtest;

public class GMockHelper extends GTestHelper {
	public GMockHelper(Object owner) {
		super(owner);
		this.compiler = Compiler.GPLUSPLUS;
	}
	
	@Override
	protected String getMainLib() {
		return "gmock_main";
	}
}
