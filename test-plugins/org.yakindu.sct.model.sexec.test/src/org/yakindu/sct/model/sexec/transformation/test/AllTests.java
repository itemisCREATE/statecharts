/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
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
		DefaultNamingServiceTest.class,
		NullCallTest.class
		})
public class AllTests {

}
