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
package org.yakindu.sct.generator.cpp.test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.yakindu.sct.generator.c.test.AlwaysOncycle;
import org.yakindu.sct.generator.c.test.AssignmentAsExpression;
import org.yakindu.sct.generator.c.test.BitExpressions;
import org.yakindu.sct.generator.c.test.BooleanExpressions;
import org.yakindu.sct.generator.c.test.CKeywords;
import org.yakindu.sct.generator.c.test.Choice;
import org.yakindu.sct.generator.c.test.Declarations;
import org.yakindu.sct.generator.c.test.DeepEntry;
import org.yakindu.sct.generator.c.test.DeepHistory;
import org.yakindu.sct.generator.c.test.DynamicChoice;
import org.yakindu.sct.generator.c.test.EnterState;
import org.yakindu.sct.generator.c.test.EntryChoice;
import org.yakindu.sct.generator.c.test.ExitOnSelfTransition;
import org.yakindu.sct.generator.c.test.ExitState;
import org.yakindu.sct.generator.c.test.FeatureCalls;
import org.yakindu.sct.generator.c.test.Guard;
import org.yakindu.sct.generator.c.test.GuardedEntry;
import org.yakindu.sct.generator.c.test.GuardedExit;
import org.yakindu.sct.generator.c.test.HistoryWithoutInitialStep;
import org.yakindu.sct.generator.c.test.InEventLifeCycle;
import org.yakindu.sct.generator.c.test.IntegerExpressions;
import org.yakindu.sct.generator.c.test.InternalEventLifeCycle;
import org.yakindu.sct.generator.c.test.LogicalAndTests;
import org.yakindu.sct.generator.c.test.LogicalOrTests;
import org.yakindu.sct.generator.c.test.NamedInterfaceAccess;
import org.yakindu.sct.generator.c.test.NullCheck;
import org.yakindu.sct.generator.c.test.OutEventLifeCycle;
import org.yakindu.sct.generator.c.test.Parenthesis;
import org.yakindu.sct.generator.c.test.PriorityValues;
import org.yakindu.sct.generator.c.test.RaiseEvent;
import org.yakindu.sct.generator.c.test.STextKeywordsInStatesAndRegions;
import org.yakindu.sct.generator.c.test.SameNameDifferentRegion;
import org.yakindu.sct.generator.c.test.ShallowHistory;
import org.yakindu.sct.generator.c.test.SimpleEvent;
import org.yakindu.sct.generator.c.test.SimpleHierachy;
import org.yakindu.sct.generator.c.test.StateIsActive;
import org.yakindu.sct.generator.c.test.StatechartLocalReactions;
import org.yakindu.sct.generator.c.test.StaticChoice;
import org.yakindu.sct.generator.c.test.StringExpressions;
import org.yakindu.sct.generator.c.test.SyncFork;
import org.yakindu.sct.generator.c.test.SyncJoin;
import org.yakindu.sct.generator.c.test.TimedTransitions;
import org.yakindu.sct.generator.c.test.TransitionWithoutCondition;
import org.yakindu.sct.generator.c.test.ValuedEvents;

@RunWith(Suite.class)
@SuiteClasses({ AlwaysOncycle.class, AssignmentAsExpression.class,
	BitExpressions.class, BooleanExpressions.class, Choice.class,
	CKeywords.class, Declarations.class, DeepEntry.class,
	DeepHistory.class, DynamicChoice.class, EnterState.class,
	EntryChoice.class, ExitOnSelfTransition.class, ExitState.class,
	FeatureCalls.class, Guard.class, GuardedEntry.class, GuardedExit.class,
	HistoryWithoutInitialStep.class, InEventLifeCycle.class,
	IntegerExpressions.class, InternalEventLifeCycle.class,
	LogicalAndTests.class, LogicalOrTests.class,
	NamedInterfaceAccess.class, NullCheck.class, OutEventLifeCycle.class,
	Parenthesis.class, PriorityValues.class, RaiseEvent.class,
	SameNameDifferentRegion.class, ShallowHistory.class, SimpleEvent.class,
	SimpleHierachy.class, StatechartLocalReactions.class,
	StateIsActive.class, StaticChoice.class,
	STextKeywordsInStatesAndRegions.class, StringExpressions.class,
	SyncFork.class, SyncJoin.class, TimedTransitions.class,
	TransitionWithoutCondition.class, ValuedEvents.class })
public class AllTestsTest {
}
