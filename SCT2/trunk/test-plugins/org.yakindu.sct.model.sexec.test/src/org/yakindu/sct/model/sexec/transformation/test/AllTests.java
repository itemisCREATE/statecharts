package org.yakindu.sct.model.sexec.transformation.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
		DefaultNamingServiceTest.class,
		FlowOptimizer_ExecutionEntryTest.class, 
		HistoryTest.class,
		LocalReactionTest.class,
		ModelSequencerSCTest.class, 
		ModelSequencertDeclarationsTest.class,
		ModelSequencerStateTest.class, 
		ModelSequencerStateReactionTest.class,
		ModelSequencerHierarchyTest.class,
		ModelSequencerOrthogonalityTest.class,
		ModelSequencerStateVectorTest.class, 
		ModelSequencerHistoryTest.class,
		SelfTransitionTest.class,
		StatechartEnterExistActionTest.class,
		DefaultNamingServiceTest.class
		})
public class AllTests {

}
