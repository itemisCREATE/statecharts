/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.c.gtest;

import java.io.File;
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
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;


public class GCCCommandExecutor {

	public void execute(List<String> command, File workingDirectory) {
		execute(command, workingDirectory, true);
	}
	
	public void execute(List<String> command, File workingDirectory, boolean refreshWorkspace) {
		try {
			// System.out.println("compile: " + command);

			ProcessBuilder processBuilder = new ProcessBuilder(command).directory(workingDirectory);
			Process process = processBuilder.redirectErrorStream(true).start();
			String message = readProcessInputStream(process);

			boolean wait = true;
			int exitCode = 0;

			do {
				wait = false;

				// waiting for the processes termination
				try {
					process.waitFor();
				} catch (InterruptedException e) { /*
													 * we ignore if waiting was
													 * interrupted ...
													 */
				}

				// if we get an exit code then we know that the process is
				// finished
				try {
					exitCode = process.exitValue();
				} catch (IllegalThreadStateException e) {
					wait = true; // if we get an exception then the process has
									// not finished ...
				}
			} while (wait);

			if (exitCode != 0) {
				throw new RuntimeException("Compilation failed (exit status " + process.exitValue() + "):\n" + message);
			}
		} catch (Error e) {
			throw e;
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (refreshWorkspace) {
					ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE,
							new NullProgressMonitor());
				}
			} catch (CoreException e) {
				throw new RuntimeException(e);
			}
		}
	}

	protected String readProcessInputStream(Process process) throws IOException {
		Reader reader = new InputStreamReader(process.getInputStream());
		char[] buffer = new char[4096];
		int count;
		StringBuilder message = new StringBuilder();
		while ((count = reader.read(buffer)) != -1) {
			message.append(buffer, 0, count);
		}
		return message.toString();
	}
}
