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

import static org.yakindu.sct.test.models.SCTUnitTestModels.ALWAYS_ONCYCLE;
import static org.yakindu.sct.test.models.SCTUnitTestModels.BIT_EXPRESSIONS;
import static org.yakindu.sct.test.models.SCTUnitTestModels.BOOLEAN_EXPRESSIONS;
import static org.yakindu.sct.test.models.SCTUnitTestModels.CHOICE;
import static org.yakindu.sct.test.models.SCTUnitTestModels.C_KEYWORDS_M;
import static org.yakindu.sct.test.models.SCTUnitTestModels.DEEP_HISTORY;
import static org.yakindu.sct.test.models.SCTUnitTestModels.FEATURE_CALLS;
import static org.yakindu.sct.test.models.SCTUnitTestModels.GUARD;
import static org.yakindu.sct.test.models.SCTUnitTestModels.INTEGER_EXPRESSIONS;
import static org.yakindu.sct.test.models.SCTUnitTestModels.JAVA_KEYWORDS_M;
import static org.yakindu.sct.test.models.SCTUnitTestModels.OPERATIONS;
import static org.yakindu.sct.test.models.SCTUnitTestModels.PARENTHESIS;
import static org.yakindu.sct.test.models.SCTUnitTestModels.PRIORITY_VALUES;
import static org.yakindu.sct.test.models.SCTUnitTestModels.RAISE_EVENTS;
import static org.yakindu.sct.test.models.SCTUnitTestModels.REAL_EXPRESSIONS;
import static org.yakindu.sct.test.models.SCTUnitTestModels.SAME_NAME_DIFFERENT_REGION;
import static org.yakindu.sct.test.models.SCTUnitTestModels.SHALLOW_HISTORY;
import static org.yakindu.sct.test.models.SCTUnitTestModels.SIMPLE_EVENT;
import static org.yakindu.sct.test.models.SCTUnitTestModels.SIMPLE_HIERACHY;
import static org.yakindu.sct.test.models.SCTUnitTestModels.STATECHART_LOCAL_REACTIONS;
import static org.yakindu.sct.test.models.SCTUnitTestModels.STATE_ACTIVE;
import static org.yakindu.sct.test.models.SCTUnitTestModels.STATE_WITH_EMPTY_REGION;
import static org.yakindu.sct.test.models.SCTUnitTestModels.STRING_EXPRESSIONS;
import static org.yakindu.sct.test.models.SCTUnitTestModels.SYNC_FORK;
import static org.yakindu.sct.test.models.SCTUnitTestModels.SYNC_JOIN;
import static org.yakindu.sct.test.models.SCTUnitTestModels.VALUED_EVENTS;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yakindu.sct.generator.java.util.AbstractJavaGeneratorTest;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.test.models.TestModelInjectorProvider;
import org.yakindu.sct.test.models.SCTUnitTestModels;


import com.google.inject.Inject;

/**
 * These tests only check for compile errors, they don't check the behaviour of
 * the generated Statemachine!
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@RunWith(XtextRunner.class)
@InjectWith(TestModelInjectorProvider.class)
public class JavaSCTGeneratorTest extends AbstractJavaGeneratorTest {

	@Inject
	private SCTUnitTestModels models;

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
