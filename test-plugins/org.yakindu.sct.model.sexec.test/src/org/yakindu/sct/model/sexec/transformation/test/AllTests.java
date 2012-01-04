package org.yakindu.sct.model.sexec.transformation.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	ModelSequencerSCTest.class,
	ModelSequencertDeclarationsTest.class,
	ModelSequencerStateTest.class,
	ModelSequencerStateReactionTest.class,
	ModelSequencerHierarchyTest.class,
	ModelSequencerOrthogonalityTest.class,
	ModelSequencerStateVectorTest.class})
public class AllTests {
	
}
