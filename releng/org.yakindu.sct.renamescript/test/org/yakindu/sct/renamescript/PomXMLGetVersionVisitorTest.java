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
package org.yakindu.sct.renamescript;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;

class PomXMLGetVersionVisitorTest {
	
	@Test
	void test() throws IOException
	{
		Path f = UpdateVersion.getSearchPath();
		String currentVersion = "error";
		currentVersion = PomXMLGetVersionVisitor.getVersion(f);
		assertEquals("3.1.0-SNAPSHOT",currentVersion);
	}
	
}
