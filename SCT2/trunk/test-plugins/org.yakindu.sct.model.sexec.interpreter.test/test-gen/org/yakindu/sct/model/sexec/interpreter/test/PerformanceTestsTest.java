/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.sexec.interpreter.test;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yakindu.sct.model.sexec.interpreter.test.util.AbstractExecutionFlowTest;
import org.yakindu.sct.model.sexec.interpreter.test.util.SExecInjectionProvider;
import com.google.inject.Inject;
import org.junit.Before;
import org.yakindu.sct.model.sexec.interpreter.IExecutionFlowInterpreter;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.test.models.SCTUnitTestModels;
import static junit.framework.Assert.*;
/**
 *  Unit TestCase for PerformanceTest
 */
@SuppressWarnings("all")
@RunWith(XtextRunner.class)
@InjectWith(SExecInjectionProvider.class)
public class PerformanceTestsTest extends AbstractExecutionFlowTest {
	@Inject
	private SCTUnitTestModels models;
	@Before
	public void setup() throws Exception {
		ExecutionFlow flow = models
				.loadExecutionFlowFromResource("PerformanceTest.sct");
		initInterpreter(flow);
	}
	@Test
	public void test_100_000() throws Exception {
		interpreter.enter();
		assertTrue(isActive("A"));
		while (getInteger("c") < 100000) {
			if (isActive("A")) {
				raiseEvent("e1");;
			} else {
				if (getInteger("c") % 2 == 0) {
					raiseEvent("e2");;
				} else {
					raiseEvent("e3");;
				};
			}
			interpreter.runCycle();
		}
		assertTrue(getInteger("a") > 2);
	}
	@Test
	public void test_1_000_000() throws Exception {
		interpreter.enter();
		assertTrue(isActive("A"));
		while (getInteger("c") < 1000000) {
			if (isActive("A")) {
				raiseEvent("e1");;
			} else {
				if (getInteger("c") % 2 == 0) {
					raiseEvent("e2");;
				} else {
					raiseEvent("e3");;
				};
			}
			interpreter.runCycle();
		}
		assertTrue(getInteger("a") > 2);
	}
	@Test
	public void test_10_000_000() throws Exception {
		interpreter.enter();
		assertTrue(isActive("A"));
		while (getInteger("c") < 10000000) {
			if (isActive("A")) {
				raiseEvent("e1");;
			} else {
				if (getInteger("c") % 2 == 0) {
					raiseEvent("e2");;
				} else {
					raiseEvent("e3");;
				};
			}
			interpreter.runCycle();
		}
		assertTrue(getInteger("a") > 2);
	}
}
