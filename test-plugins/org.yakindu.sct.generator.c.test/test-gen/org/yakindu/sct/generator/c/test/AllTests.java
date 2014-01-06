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
package org.yakindu.sct.generator.c.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AlwaysOncycle.class, AssignmentAsExpression.class,
		BitExpressions.class, BooleanExpressions.class, Choice.class,
		CKeywords.class, Declarations.class, DeepEntry.class,
		DeepHistory.class, EnterState.class, EntryChoice.class,
		ExitOnSelfTransition.class, ExitState.class, FeatureCalls.class,
		Guard.class, GuardedEntry.class, GuardedExit.class,
		HistoryWithoutInitialStep.class, InEventLifeCycle.class,
		IntegerExpressions.class, InternalEventLifeCycle.class,
		LogicalAndTests.class, LogicalOrTests.class,
		NamedInterfaceAccess.class, OutEventLifeCycle.class, Parenthesis.class,
		PriorityValues.class, RaiseEvent.class, SameNameDifferentRegion.class,
		ShallowHistory.class, SimpleEvent.class, SimpleHierachy.class,
		StatechartLocalReactions.class, StateIsActive.class,
		STextKeywordsInStatesAndRegions.class, StringExpressions.class,
		SyncFork.class, SyncJoin.class, TimedTransitions.class,
		TransitionWithoutCondition.class, ValuedEvents.class })
public class AllTests {
}
