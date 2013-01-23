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

import static util.TestModels.ALWAYS_ONCYCLE;
import static util.TestModels.BIT_EXPRESSIONS;
import static util.TestModels.BOOLEAN_EXPRESSIONS;
import static util.TestModels.CHOICE;
import static util.TestModels.C_KEYWORDS_M;
import static util.TestModels.DEEP_HISTORY;
import static util.TestModels.FEATURE_CALLS;
import static util.TestModels.GUARD;
import static util.TestModels.INTEGER_EXPRESSIONS;
import static util.TestModels.JAVA_KEYWORDS_M;
import static util.TestModels.OPERATIONS;
import static util.TestModels.PARENTHESIS;
import static util.TestModels.PRIORITY_VALUES;
import static util.TestModels.RAISE_EVENTS;
import static util.TestModels.REAL_EXPRESSIONS;
import static util.TestModels.SAME_NAME_DIFFERENT_REGION;
import static util.TestModels.SHALLOW_HISTORY;
import static util.TestModels.SIMPLE_EVENT;
import static util.TestModels.SIMPLE_HIERACHY;
import static util.TestModels.STATECHART_LOCAL_REACTIONS;
import static util.TestModels.STATE_ACTIVE;
import static util.TestModels.STATE_WITH_EMPTY_REGION;
import static util.TestModels.STRING_EXPRESSIONS;
import static util.TestModels.SYNC_FORK;
import static util.TestModels.SYNC_JOIN;
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

	private void failOnError(IMarker[] diagnostics) throws CoreException {
		for (IMarker diagnostic : diagnostics) {
			int severity = (Integer) diagnostic.getAttribute("severity");
			if (severity == IMarker.SEVERITY_ERROR) {
				Assert.fail(diagnostic.getAttribute(IMarker.MESSAGE, ""));
			}
		}
	}

	@Test
	public void testAlwaysOnCycleModel() throws Exception {
		Statechart statechart = models
				.loadStatechartFromResource(ALWAYS_ONCYCLE);
		failOnError(generateAndCompile(statechart));

	}

	@Test
	public void testBitExpressionsModel() throws Exception {
		Statechart statechart = models
				.loadStatechartFromResource(BIT_EXPRESSIONS);
		failOnError(generateAndCompile(statechart));

	}

	@Test
	public void testBooleanExpressionsModel() throws Exception {
		Statechart statechart = models
				.loadStatechartFromResource(BOOLEAN_EXPRESSIONS);
		failOnError(generateAndCompile(statechart));

	}

	@Test
	public void testChoiceModel() throws Exception {
		Statechart statechart = models.loadStatechartFromResource(CHOICE);
		failOnError(generateAndCompile(statechart));

	}

	@Test
	public void testCKeywordsModel() throws Exception {
		Statechart statechart = models.loadStatechartFromResource(C_KEYWORDS_M);
		failOnError(generateAndCompile(statechart));

	}

	@Test
	public void testDeepHistoryModel() throws Exception {
		Statechart statechart = models.loadStatechartFromResource(DEEP_HISTORY);
		failOnError(generateAndCompile(statechart));

	}

	@Test
	public void testFeatureCallsModel() throws Exception {
		Statechart statechart = models
				.loadStatechartFromResource(FEATURE_CALLS);
		failOnError(generateAndCompile(statechart));

	}

	@Test
	public void testGuardModel() throws Exception {
		Statechart statechart = models.loadStatechartFromResource(GUARD);
		failOnError(generateAndCompile(statechart));
	}

	@Test
	public void testIntegerExpressionsModel() throws Exception {
		Statechart statechart = models
				.loadStatechartFromResource(INTEGER_EXPRESSIONS);
		failOnError(generateAndCompile(statechart));
	}

	@Test
	public void testJavaKeywordsModel() throws Exception {
		Statechart statechart = models
				.loadStatechartFromResource(JAVA_KEYWORDS_M);
		failOnError(generateAndCompile(statechart));
	}

	@Test
	public void testParenthesisModel() throws Exception {
		Statechart statechart = models.loadStatechartFromResource(PARENTHESIS);
		failOnError(generateAndCompile(statechart));
	}

	@Test
	public void testPriorityValuesModel() throws Exception {
		Statechart statechart = models
				.loadStatechartFromResource(PRIORITY_VALUES);
		failOnError(generateAndCompile(statechart));
	}

	@Test
	public void testRaiseEventModel() throws Exception {
		Statechart statechart = models.loadStatechartFromResource(RAISE_EVENTS);
		failOnError(generateAndCompile(statechart));
	}

	@Test
	public void testRealExpressionsModel() throws Exception {
		Statechart statechart = models
				.loadStatechartFromResource(REAL_EXPRESSIONS);
		failOnError(generateAndCompile(statechart));
	}

	@Test
	public void testSameNameDifferentRegionModel() throws Exception {
		Statechart statechart = models
				.loadStatechartFromResource(SAME_NAME_DIFFERENT_REGION);
		failOnError(generateAndCompile(statechart));
	}

	@Test
	public void testShallowHistoryModel() throws Exception {
		Statechart statechart = models
				.loadStatechartFromResource(SHALLOW_HISTORY);
		failOnError(generateAndCompile(statechart));
	}

	@Test
	public void testSimpleEventModel() throws Exception {
		Statechart statechart = models.loadStatechartFromResource(SIMPLE_EVENT);
		failOnError(generateAndCompile(statechart));
	}

	@Test
	public void testSimpleHierachyModel() throws Exception {
		Statechart statechart = models
				.loadStatechartFromResource(SIMPLE_HIERACHY);
		failOnError(generateAndCompile(statechart));
	}

	@Test
	public void testStatechartLocalReactionsModel() throws Exception {
		Statechart statechart = models
				.loadStatechartFromResource(STATECHART_LOCAL_REACTIONS);
		failOnError(generateAndCompile(statechart));
	}

	@Test
	public void testStateActiveModel() throws Exception {
		Statechart statechart = models.loadStatechartFromResource(STATE_ACTIVE);
		failOnError(generateAndCompile(statechart));

	}
	@Test
	public void testStateWithEmptyRegionModel() throws Exception {
		Statechart statechart = models.loadStatechartFromResource(STATE_WITH_EMPTY_REGION);
		failOnError(generateAndCompile(statechart));
		
	}

	@Test
	public void testStringExpressionsModel() throws Exception {
		Statechart statechart = models
				.loadStatechartFromResource(STRING_EXPRESSIONS);
		failOnError(generateAndCompile(statechart));

	}

	@Test
	public void testSyncForkModel() throws Exception {
		Statechart statechart = models.loadStatechartFromResource(SYNC_FORK);
		failOnError(generateAndCompile(statechart));
	}

	@Test
	public void testSyncJoinModel() throws Exception {
		Statechart statechart = models.loadStatechartFromResource(SYNC_JOIN);
		failOnError(generateAndCompile(statechart));
	}

	@Test
	public void testValuedEventsModel() throws Exception {
		Statechart statechart = models
				.loadStatechartFromResource(VALUED_EVENTS);
		failOnError(generateAndCompile(statechart));
	}
	@Test
	public void tesTOperationsModel() throws Exception{
		Statechart statechart = models
				.loadStatechartFromResource(OPERATIONS);
		failOnError(generateAndCompile(statechart));
	}
}
