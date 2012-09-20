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
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import junit.framework.AssertionFailedError;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * @author Andreas Unger
 * 
 */
public class GTestRunner extends Runner {

	private static final Pattern TEST_PATTERN = Pattern.compile("TEST(?:_F)?\\s*\\(\\s*(\\w+)\\s*,\\s*(\\w+)\\s*\\)");
	private static final Pattern SL_COMMENT_PATTERN = Pattern.compile("//.*(?:\\r?\\n|\\z)");
	private static final Pattern ML_COMMENT_PATTERN = Pattern.compile("/\\*.*\\*/", Pattern.DOTALL);
	private static final Pattern TEST_OUTPUT_PATTERN = Pattern.compile("\\[\\s*(\\w+)\\s*\\] (\\w+)\\.(\\w+)");

	private Class<?> testClass;

	private Map<String, List<String>> testCases = new LinkedHashMap<String, List<String>>();

	/**
	 * 
	 */
	public GTestRunner(Class<?> testClass) throws InitializationError {
		this.testClass = testClass;

		GTest annotation = testClass.getAnnotation(GTest.class);
		if (annotation == null) {
			throw new InitializationError("Test class must specify " + GTest.class.getCanonicalName() + " annotation");
		}

		String sourceFile = annotation.sourceFile();
		try {
			CharSequence charSequence = readSourceFile(sourceFile);
			String s = ML_COMMENT_PATTERN.matcher(SL_COMMENT_PATTERN.matcher(charSequence).replaceAll("")).replaceAll("");
			Matcher matcher = TEST_PATTERN.matcher(s);
			while (matcher.find()) {
				String testCaseName = matcher.group(1);
				String testName = matcher.group(2);
				List<String> testCase = testCases.get(testCaseName);
				if (testCase == null) {
					testCase = new ArrayList<String>();
					testCases.put(testCaseName, testCase);
				}
				testCase.add(testName);
			}
		} catch (IOException e) {
			throw new InitializationError(e);
		}

		if (testCases.isEmpty()) {
			throw new InitializationError("No tests specified");
		}
	}

	private CharSequence readSourceFile(String sourceFile) throws IOException {
		Bundle bundle = FrameworkUtil.getBundle(testClass);
		InputStream is = FileLocator.openStream(bundle, new Path(sourceFile),
				false);
		Reader reader = new InputStreamReader(is);
		char[] buffer = new char[4096];
		StringBuilder sb = new StringBuilder(buffer.length);
		int count;
		while ((count = reader.read(buffer)) != -1) {
			sb.append(buffer, 0, count);
		}
		reader.close();
		is.close();
		return sb;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.junit.runner.Runner#getDescription()
	 */
	@Override
	public Description getDescription() {
		Description description = Description.createSuiteDescription(testClass);
		for (Entry<String, List<String>> entry : testCases.entrySet()) {
			for (String test : entry.getValue()) {
				String testCase = entry.getKey();
				Description childDescription = createDescription(testCase, test);
				description.addChild(childDescription);
			}
		}
		return description;
	}

	private Description createDescription(String testCase, String test) {
		String name;
		if (testCases.size() == 1) {
			name = test;
		} else {
			name = testCase + "." + test;
		}
		return Description.createTestDescription(testClass, name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.junit.runner.Runner#run(org.junit.runner.notification.RunNotifier)
	 */
	@Override
	public void run(RunNotifier notifier) {
		try {
			Object test = testClass.newInstance();
			Method[] methods = testClass.getMethods();

			for (Method method : methods) {
				if (method.isAnnotationPresent(Before.class)) {
					method.invoke(test);
				}
			}

			runGTests(notifier);

			for (Method method : methods) {
				if (method.isAnnotationPresent(After.class)) {
					method.invoke(test);
				}
			}
		} catch (InvocationTargetException e) {
			Throwable targetException = ((InvocationTargetException) e).getTargetException();
			notifier.fireTestFailure(new Failure(getDescription(), targetException));
		} catch (Throwable throwable) {
			notifier.fireTestFailure(new Failure(getDescription(), throwable));
		}
	}

	private void runGTests(RunNotifier notifier) throws IOException, InterruptedException {
		String program = testClass.getAnnotation(GTest.class).program();
		IResource programFile = ResourcesPlugin.getWorkspace().getRoot().findMember(new Path(program));
		IContainer programContainer = programFile.getParent();
		if (!programContainer.isAccessible()) {
			throw new RuntimeException("Test program container " + programContainer.getLocation().toOSString() + " inaccessible");
		}
		
		File directory = programContainer.getLocation().toFile();
		Process process = new ProcessBuilder(programFile.getLocation().toOSString()).redirectErrorStream(true).directory(directory).start();
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
					case TestOutput.RUN:
						running = true;
						message.setLength(0);
						notifier.fireTestStarted(description);
						break;
					case TestOutput.OK:
						running = false;
						notifier.fireTestFinished(description);
						break;
					default:
						running = false;
						notifier.fireTestFailure(new Failure(description, new AssertionFailedError(message.toString())));
						notifier.fireTestFinished(description);
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
			String name;
			if (testCases.size() == 1) {
				name = testName;
			} else {
				name = testCaseName + "." + testName;
			}
			return Description.createTestDescription(testClass, name);
		}

	}

}
