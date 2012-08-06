package org.yakindu.sct.generator.c.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
//TODO: The testsuite should be generated too
@RunWith(Suite.class)
@SuiteClasses({ AlwaysOncycleTest.class, BitExpressionsTest.class,
		ChoiceTest.class, IntegerExpressionsTest.class,
		PriorityValuesTest.class, ShallowHistoryTest.class })
public class AllGUnitTests {

}
