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
package org.yakindu.sct.generator.c.test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({AlwaysOncycle.class, AssignmentAsExpression.class,
		BitExpressions.class, BooleanExpressions.class, CKeywords.class,
		Declarations.class, Choice.class, DeepHistory.class,
		ExitOnSelfTransition.class, Guard.class, GuardedEntry.class,
		GuardedExit.class, IntegerExpressions.class,
		InternalEventLifeCycle.class, Parenthesis.class, PriorityValues.class,
		RaiseEvent.class, SameNameDifferentRegion.class, ShallowHistory.class,
		SimpleHietachy.class, StateIsActive.class,
		StatechartLocalReactions.class, StringExpressions.class,
		SyncFork.class, SyncJoin.class, ValuedEvent.class, SimpleEvent.class})
public class AllTests {
}
