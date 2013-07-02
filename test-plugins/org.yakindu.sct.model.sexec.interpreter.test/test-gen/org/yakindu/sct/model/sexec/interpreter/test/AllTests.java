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

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AlwaysOncycleTest.class, AssignmentAsExpressionTest.class,
		BitExpressionsTest.class, BooleanExpressionsTest.class, CKeywordsTest.class,
		DeclarationsTest.class, ChoiceTest.class, DeepHistoryTest.class, EnterStateTest.class,
		ExitStateTest.class, ExitOnSelfTransitionTest.class, GuardTest.class,
		GuardedEntryTest.class, GuardedExitTest.class, HistoryWithoutInitialStepTest.class,
		IntegerExpressionsTest.class, InEventLifeCycleTest.class,
		InternalEventLifeCycleTest.class, OutEventLifeCycleTest.class,
		ParenthesisTest.class, PriorityValuesTest.class, RaiseEventTest.class,
		SameNameDifferentRegionTest.class, ShallowHistoryTest.class,
		SimpleHierachyTest.class, StateIsActiveTest.class,
		StatechartLocalReactionsTest.class, StateWithEmptyRegionTest.class,
		StringExpressionsTest.class, SyncForkTest.class, SyncJoinTest.class,
		SimpleEventTest.class, STextKeywordsInStatesAndRegionsTest.class,
		TransitionWithoutConditionTest.class, ValuedEventsTest.class})
public class AllTests {
}
