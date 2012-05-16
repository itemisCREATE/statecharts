/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.java;

import static util.TestModels.*;
import static util.TestModels.FEATURE_CALLS;
import static util.TestModels.GUARD;
import static util.TestModels.SIMPLE_HIERACHY;
import static util.TestModels.STATECHART_LOCAL_REACTIONS;
import static util.TestModels.STATE_ACTIVE;
import static util.TestModels.VALUED_EVENTS;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yakindu.sct.generator.java.util.AbstractJavaGeneratorTest;
import org.yakindu.sct.generator.java.util.JavaGeneratorInjectionProvider;
import org.yakindu.sct.model.sgraph.Statechart;

import util.TestModels;

import com.google.inject.Inject;

/**
 * These tests only check for compile errors, they don't check the behaviour of
 * the generated Statemachine!
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@RunWith(XtextRunner.class)
@InjectWith(JavaGeneratorInjectionProvider.class)
public class JavaSCTGeneratorTest extends AbstractJavaGeneratorTest {

	@Inject
	private TestModels models;

	@Test
	public void testGuardModel() throws Exception {
		Statechart statechart = models.loadStatechartFromResource(GUARD);
		failOnError(generateAndCompile(statechart));
	}

	@Test
	public void testSimpleHierachyModel() throws Exception {
		Statechart statechart = models
				.loadStatechartFromResource(SIMPLE_HIERACHY);
		failOnError(generateAndCompile(statechart));

	}

	@Test
	public void testDeepHistoryModel() throws Exception {
		Statechart statechart = models.loadStatechartFromResource(DEEP_HISTORY);
		failOnError(generateAndCompile(statechart));

	}

	@Test
	public void testStateActiveModel() throws Exception {
		Statechart statechart = models.loadStatechartFromResource(STATE_ACTIVE);
		failOnError(generateAndCompile(statechart));

	}

	@Test
	public void testValuedEventsModel() throws Exception {
		Statechart statechart = models
				.loadStatechartFromResource(VALUED_EVENTS);
		failOnError(generateAndCompile(statechart));

	}

	@Test
	public void testFeatureCallsModel() throws Exception {
		Statechart statechart = models
				.loadStatechartFromResource(FEATURE_CALLS);
		failOnError(generateAndCompile(statechart));

	}

	@Test
	public void testStatechartLocalReactionsModel() throws Exception {
		Statechart statechart = models
				.loadStatechartFromResource(STATECHART_LOCAL_REACTIONS);
		failOnError(generateAndCompile(statechart));

	}

	@Test
	public void testAlwaysOnCycleModel() throws Exception {
		Statechart statechart = models
				.loadStatechartFromResource(ALWAYS_ONCYCLE);
		failOnError(generateAndCompile(statechart));

	}

	@Test
	public void testTimeTriggerModel() throws Exception {
		Statechart statechart = models.loadStatechartFromResource(TIME_TRIGGER);
		failOnError(generateAndCompile(statechart));

	}

	private void failOnError(IMarker[] diagnostics) throws CoreException {
		for (IMarker diagnostic : diagnostics) {
			int severity = (Integer) diagnostic.getAttribute("severity");
			if (severity == IMarker.SEVERITY_ERROR) {
				Assert.fail(diagnostic.getAttribute(IMarker.MESSAGE, ""));
			}
		}
	}
}
