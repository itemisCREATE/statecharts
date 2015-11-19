package org.yakindu.sct.generator.csharp;

import 	java.io.File;

import org.eclipse.xpand2.output.FileHandle;
import org.eclipse.xpand2.output.FileHandleImpl;
import org.eclipse.xpand2.output.JavaBeautifier;
import org.eclipse.xpand2.output.Outlet;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class Beautifier {

	@Inject
	JavaBeautifier csharpBeautifier;

	/**
	 * Format code with PostProcessor (XPand style).
	 */
	public CharSequence format(String fileName, CharSequence code) {

		// create fileHandle with dummy outlet.
		File file = new File(fileName);
		FileHandle fileHandle = new FileHandleImpl(new Outlet(), file);
		fileHandle.setBuffer(code);

		// call postProcessor for formatting the code.
		csharpBeautifier.beforeWriteAndClose(fileHandle);

		// return formatted results.
		return fileHandle.getBuffer();

	}
}