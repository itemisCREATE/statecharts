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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import junit.framework.AssertionFailedError;

/**
 * @author Andreas Unger
 * 
 */
public class GTestRunner extends Runner {

	private static final Pattern TEST_PATTERN = Pattern.compile("TEST(?:_F)?\\s*\\(\\s*(\\w+)\\s*,\\s*(\\w+)\\s*\\)");
	private static final Pattern SL_COMMENT_PATTERN = Pattern.compile("//.*(?:\\r?\\n|\\z)");
	private static final Pattern ML_COMMENT_PATTERN = Pattern.compile("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)");

	private Class<?> testClass;

	private boolean ignore;

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

		ignore = testClass.getAnnotation(Ignore.class) != null;

		String sourceFile = annotation.sourceFile();
		try {
			CharSequence charSequence = readSourceFile(sourceFile);
			String s = ML_COMMENT_PATTERN.matcher(SL_COMMENT_PATTERN.matcher(charSequence).replaceAll(""))
					.replaceAll("");
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
		Bundle bundle = getTestBundle();
//		System.out.println("[GTestRunner] Loaded bundle " + bundle.getSymbolicName());
		InputStream is = FileLocator.openStream(bundle, new Path(sourceFile), false);
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

	protected Bundle getTestBundle() {
		String testProject = testClass.getAnnotation(GTest.class).testBundle();
		if (!testProject.isEmpty()) {
			Bundle testBundle = Platform.getBundle(testProject);
			if (testBundle != null) {
				return testBundle;
			}
		}
		return FrameworkUtil.getBundle(testClass);
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
		String name = testCase + "." + test;
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
	}

	private void runGTests(RunNotifier notifier) throws IOException, InterruptedException {
		String program = testClass.getAnnotation(GTest.class).program();
		if (Platform.getOS().equalsIgnoreCase(Platform.OS_WIN32)) {
			program += ".exe";
		}
		String targetProject = testClass.getAnnotation(GTest.class).testBundle();
		IPath programPath = new Path(targetProject).append(program);
		IFile programFile = ResourcesPlugin.getWorkspace().getRoot().getFile(programPath);
		
		GTestExecutor executor = new GTestExecutor(testClass) {
			@Override
			protected void testStarted(Description desc) {
				notifier.fireTestStarted(desc);
			}
			@Override
			protected void testFinished(Description desc) {
				notifier.fireTestFinished(desc);
			}
			@Override
			protected void testFailed(Description desc, String message) {
				notifier.fireTestFailure(
						new Failure(desc, new AssertionFailedError(message.toString())));
			}
		};
		executor.execute(programFile);
	}
}
