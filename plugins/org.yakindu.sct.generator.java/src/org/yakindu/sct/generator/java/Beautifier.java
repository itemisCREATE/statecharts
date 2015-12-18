/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.generator.java;

import java.io.File;

import org.eclipse.xpand2.output.FileHandle;
import org.eclipse.xpand2.output.FileHandleImpl;
import org.eclipse.xpand2.output.JavaBeautifier;
import org.eclipse.xpand2.output.Outlet;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class Beautifier {

	@Inject
	JavaBeautifier javaBeautifier;

	/**
	 * Format code with PostProcessor (XPand style).
	 */
	public CharSequence format(String fileName, CharSequence code) {

		// create fileHandle with dummy outlet.
		File file = new File(fileName);
		FileHandle fileHandle = new FileHandleImpl(new Outlet(), file);
		fileHandle.setBuffer(code);

		// call postProcessor for formatting the code.
		javaBeautifier.beforeWriteAndClose(fileHandle);

		// return formatted results.
		return fileHandle.getBuffer();

	}
}