package org.yakindu.sct.model.sexec.interpreter.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
@RunWith(value = Suite.class)
@SuiteClasses({ AlwaysOncycleTest.class, ChoiceTest.class,
		DeepHistoryTest.class, GuardTest.class, PriorityValuesTest.class,
		ShallowHistoryTest.class, SimpleEventTest.class,
		SimpleHierachyTest.class, StatechartLocalReactionsTest.class,
		StateIsActiveTest.class,
		SyncJoinTest.class})
public class AllTests {

}
