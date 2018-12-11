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

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.junit.runner.Description;

/**
 * @author Andreas Unger
 * @author Thomas Kutz - hook methods for subclassing in different contexts
 *
 */
public class GTestExecutor {

	private static final Pattern TEST_OUTPUT_PATTERN = Pattern.compile("\\[\\s*(\\w+)\\s*\\] (\\w+)\\.(\\w+)");

	private Class<?> testClass;
	
	public GTestExecutor(Class<?> testClass) {
		this.testClass = testClass;
	}

	public void execute(IFile programFile) throws IOException, InterruptedException {
		IContainer programContainer = programFile.getParent();
		if (!programContainer.isAccessible()) {
			throw new RuntimeException(
					"Test program container " + programContainer.getLocation().toOSString() + " inaccessible");
		}
		
		File directory = programContainer.getLocation().toFile();
		Process process = new ProcessBuilder(programFile.getLocation().toOSString()).redirectErrorStream(true)
				.directory(directory).start();
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		
		boolean started = false;
		boolean running = false;
		StringBuilder message = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			if (line.startsWith("[====")) {
				if (started) {
					started = false;
					// Eat remaining input
					char[] buffer = new char[4096];
					while (reader.read(buffer) != -1);
					break;
				}
				started = true;
			} else {
				TestOutput testOutput = parseTestOutput(line);
				if (testOutput != null) {
					Description description = testOutput.toDescription();
					switch (testOutput.getStatus()) {
						case TestOutput.RUN :
							running = true;
							message.setLength(0);
							testStarted(description);
							break;
						case TestOutput.OK :
							running = false;
							testFinished(description);
							break;
						default :
							running = false;
							testFailed(description, message.toString());
							testFinished(description);
							break;
					}
				} else if (running) {
					message.append(line);
					message.append("\n");
				}
			}
		}
		
		process.waitFor();
		
		if (started) {
			throw new RuntimeException("Test quit unexpectedly (exit status " + process.exitValue() + "):\n" + message);
		}
	}

	protected void testStarted(Description desc) {
		// hook to be overridden in subclass
	}

	protected void testFinished(Description desc) {
		// hook to be overridden in subclass
	}

	protected void testFailed(Description desc, String message) {
		// hook to be overridden in subclass
	}
	
	private TestOutput parseTestOutput(String s) {
		Matcher matcher = TEST_OUTPUT_PATTERN.matcher(s);
		if (matcher.find()) {
			String statusString = matcher.group(1);
			int status;
			if ("RUN".equals(statusString)) {
				status = TestOutput.RUN;
			} else if ("OK".equals(statusString)) {
				status = TestOutput.OK;
			} else {
				status = TestOutput.FAILED;
			}
			String testCaseName = matcher.group(2);
			String testName = matcher.group(3);
			return new TestOutput(status, testCaseName, testName);
		}
		return null;
	}
	
	private class TestOutput {
		
		public static final int RUN = 0;
		public static final int OK = 1;
		public static final int FAILED = 2;
		
		private int status;
		
		private String testCaseName;
		private String testName;
		
		public TestOutput(int status, String testCaseName, String testName) {
			this.status = status;
			this.testCaseName = testCaseName;
			this.testName = testName;
		}
		
		/**
		 * @return the status
		 */
		public int getStatus() {
			return status;
		}
		
		public Description toDescription() {
			String name = testCaseName + "." + testName;
			return Description.createTestDescription(testClass, name);
		}
		
	}
}
