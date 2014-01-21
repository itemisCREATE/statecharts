/**
 * Copyright (c) 2014 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.test.models;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.yakindu.sct.model.sgraph.Statechart;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SCTUnitTestModels extends AbstractTestModelsUtil {

	private static final String TESTMODEL_DIR = "org.yakindu.sct.test.models/testmodels/SCTUnit/";
	public static final String ALWAYS_ONCYCLE = "AlwaysOncycle.sct";
	public static final String ASSIGNMENT_AS_EXPRESSION ="AssignmentAsExpression.sct";
	public static final String BIT_EXPRESSIONS = "BitExpressions.sct";
	public static final String BOOLEAN_EXPRESSIONS = "BooleanExpressions.sct";
	public static final String CHOICE = "Choice.sct";
	public static final String C_KEYWORDS_M = "CKeywords.sct";
	public static final String DECLARATIONS = "Declarations.sct";
	public static final String DEEP_ENTRY = "DeepEntry.sct";
	public static final String DEEP_HISTORY = "DeepHistory.sct";
	public static final String DYNAMIC_CHOICE = "DynamicChoice.sct";
	public static final String ENTER_STATE = "EnterState.sct";
	public static final String ENTRY_CHOICE = "EntryChoice.sct";
	public static final String EXIT_ON_SELF_TRANSITION = "ExitOnSelfTransition.sct";
	public static final String EXIT_STATE = "ExitState.sct";
	public static final String EXIT_STATECHART = "ExitStatechart.sct";
	public static final String FEATURE_CALLS = "FeatureCalls.sct";
	public static final String GUARD = "Guard.sct";
	public static final String GUARDED_ENTRY = "GuardedEntry.sct";
	public static final String GUARDED_EXIT = "GuardedExit.sct";
	public static final String HISTORY_WITHOUT_INITIAL_STEP = "HistoryWithoutInitialStep.sct";
	public static final String IN_EVENT_LIFE_CYCLE = "InEventLifeCycle.sct";
	public static final String INTEGER_EXPRESSIONS = "IntegerExpressions.sct";
	public static final String INTERNAT_EVENT_LIFE_CYCLE = "InternalEventLifeCycle.sct";
	public static final String JAVA_KEYWORDS_M = "JavaKeywords.sct";
	public static final String LOGICAL_AND = "LogicalAnd.sct";
	public static final String LOGICAL_OR = "LogicalOr.sct";
	public static final String NAMED_INTERFACE_ACCESS = "NamedInterfaceAccess.sct";
	public static final String OPERATIONS = "Operations.sct";
	public static final String OUT_EVENT_LIFE_CYCLE = "OutEventLifeCycle.sct";
	public static final String PARENTHESIS = "Parenthesis.sct";
	public static final String PERFORMANCE_TEST = "PerformanceTest.sct";
	public static final String PRIORITY_VALUES = "PriorityValues.sct";
	public static final String RAISE_EVENTS = "RaiseEvent.sct";
	public static final String REAL_EXPRESSIONS = "RealExpressions.sct";
	public static final String SAME_NAME_DIFFERENT_REGION = "SameNameDifferentRegion.sct";
	public static final String SHALLOW_HISTORY = "ShallowHistory.sct";
	public static final String SIMPLE_EVENT = "SimpleEvent.sct";
	public static final String SIMPLE_HIERACHY = "SimpleHierachy.sct";
	public static final String STATECHART_LOCAL_REACTIONS = "StatechartLocalReactions.sct";	
	public static final String STATE_ACTIVE = "StateIsActive.sct";
	public static final String STATIC_CHOICE = "StaticChoice.sct";
	public static final String STEXT_KEYWORDS_IN_STATES_AND_REGIONS = "STextKeywordsInStatesAndRegions.sct";
	public static final String STRING_EXPRESSIONS = "StringExpressions.sct";
	public static final String SYNC_JOIN = "SyncJoin.sct";
	public static final String SYNC_FORK = "SyncFork.sct";
	public static final String TIMED_TRANSITIONS = "TimedTransitions.sct";
	public static final String TRANSITIONS_WITHOUT_CONDITION = "TransitionWithoutCondition.sct";
	public static final String VALUED_EVENTS = "ValuedEvents.sct";
	public static final String VARIABLE_INITIALIZATION = "VariableInitialization.sct";

	@Override
	public String getModelDirectory() {
		return TESTMODEL_DIR;
	}

	public List<Statechart> loadAllStatecharts() throws Exception {
		List<Statechart> result = new ArrayList<Statechart>();
		Field[] fields = getClass().getFields();
		for (Field field : fields) {
			String value = (String) field.get(this);
			if (value.endsWith(".sct")) {
				result.add(loadStatechartFromResource(value));
			}
		}
		return result;
	}
	public static Iterable<Object[]> parameterizedTestData() throws Exception {
		SCTUnitTestModels models = new SCTUnitTestModels();
		List<Statechart> all = models.loadAllStatecharts();
		return Iterables.transform(all, new Function<Statechart, Object[]>() {
			public Object[] apply(Statechart input) {
				return new Object[] { input };
			}
		});
	}

}
