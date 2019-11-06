/**
 * Copyright (c) 2019 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 		committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.python.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;

import junit.framework.AssertionFailedError;

public class PythonUnittestRunner extends Runner {
	private static final Pattern TEST_OK_PATTERN = Pattern.compile("OK");
	private static final Pattern TRACEBACK_PATTERN = Pattern.compile("(?s)-*\\s(Traceback.*)\\s*-{70}.*-*");
	private static final Pattern TEST_FAIL_PATTERN = Pattern.compile("FAIL");
	private static final Pattern TEST_ERROR_PATTERN = Pattern.compile("ERROR");

	private Class<?> testClass;

	private boolean ignore;

	private Map<String, List<String>> testCases = new LinkedHashMap<String, List<String>>();

	public PythonUnittestRunner(Class<?> testClass) throws InitializationError {
		this.testClass = testClass;
		ignore = testClass.getAnnotation(Ignore.class) != null;
	}

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
		String name = testCase + "." + test;
		return Description.createTestDescription(testClass, name);
	}

	@Override
	public void run(RunNotifier notifier) {
		if (ignore) {
			notifier.fireTestIgnored(getDescription());
		} else {
			try {
				Object test = testClass.newInstance();
				Method[] methods = testClass.getMethods();

				for (Method method : methods) {
					if (method.isAnnotationPresent(Before.class)) {
						method.invoke(test);
					}
				}
				runPythonTest(notifier);
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
	}

	private void runPythonTest(RunNotifier notifier) throws IOException {
		PythonTest pyTest = testClass.getAnnotation(PythonTest.class);
		String testpath = pyTest.sourceFile();
		IResource resource = ResourcesPlugin.getWorkspace().getRoot();
		File directory = resource.getLocation().toFile();
		Description tcDescription = Description.createTestDescription(testClass, testpath);
		notifier.fireTestStarted(tcDescription);

		Process process = new ProcessBuilder("python3", "-m", "unittest", testpath).redirectErrorStream(true)
				.directory(directory).start();
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line;
		StringBuilder b = new StringBuilder();
		while ((line = reader.readLine()) != null) {
			b.append(line + "\n");
		}

		// Handle test output
		TestOutput out = parseTestOutput(b.toString());
		if (!out.getPass()) {
			Failure failure = new Failure(tcDescription, new AssertionFailedError(out.getTraceback().toString()));
			notifier.fireTestFailure(failure);
		}
		notifier.fireTestFinished(tcDescription);


	}

	private TestOutput parseTestOutput(String s) {
		int status = TestOutput.FAIL;
		String traceback = "";

		Matcher matcher_fail = TEST_FAIL_PATTERN.matcher(s);
		Matcher matcher_error = TEST_ERROR_PATTERN.matcher(s);
		Matcher matcher_ok = TEST_OK_PATTERN.matcher(s);
		Matcher matcher_traceback = TRACEBACK_PATTERN.matcher(s);
		
		if (matcher_ok.find()) {
			status = TestOutput.PASS;
		} else if (matcher_fail.find()) {
			status = TestOutput.FAIL;
		} else if (matcher_error.find()) {
			status = TestOutput.ERROR;
		}
		
		if (matcher_traceback.find()) {
			traceback = matcher_traceback.group(1);
		}

		return new TestOutput(status, traceback);
	}

	private class TestOutput {
		public static final int PASS = 0;
		public static final int FAIL = 1;
		public static final int ERROR = 2;
		private int status; // 0 - pass, 1 - fail, 2 - error
		private String traceback;

		public TestOutput(int status, String traceback) {
			this.status = status;
			this.traceback = (traceback == null ? "" : traceback);
		}

		public boolean getPass() {
			return this.status == PASS;
		}

		public String getTraceback() {
			return this.traceback;
		}
	}
}
