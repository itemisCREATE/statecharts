package org.yakindu.sct.model.sexec.interpreter.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
@RunWith(value = Suite.class)
@SuiteClasses({ AlwaysOncycleTest.class, BooleanExpressionsTest.class,
		ChoiceTest.class, DeepHistoryTest.class, GuardTest.class,
		IntegerExpressionsTest.class, PriorityValuesTest.class,
		RaiseEventTest.class, SameNameDifferentRegionTest.class,
		ShallowHistoryTest.class, SimpleEventTest.class,
		SimpleHierachyTest.class, StatechartLocalReactionsTest.class,
		StateIsActiveTest.class, SyncJoinTest.class, SyncJoinTest.class,
		ValuedEventsTest.class })
public class AllTests {

}
