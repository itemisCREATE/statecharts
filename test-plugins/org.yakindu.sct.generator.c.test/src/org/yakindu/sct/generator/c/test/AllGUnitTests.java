package org.yakindu.sct.generator.c.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
//TODO: The testsuite should be generated too
@RunWith(Suite.class)
@SuiteClasses({ 
	AlwaysOncycle.class, 
	BitExpressions.class,
	BooleanExpressions.class,
	Choice.class, 
	DeepHistory.class,
	//FeatureCalls.class,
	Guard.class,
	IntegerExpressions.class,
	PriorityValues.class,
	RaiseEvent.class,
	//RealExpressions.class,
	SameNameDifferentRegion.class,
	ShallowHistory.class,
	SimpleEvent.class,
	SimpleHietachy.class,
	StatechartLocalReactions.class,
	StateIsActive.class,
	SyncFork.class,
	SyncJoin.class,
	ValuedEvent.class
	})
public class AllGUnitTests {

}
