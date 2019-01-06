/** 
 * Copyright (c) 2016 committers of YAKINDU and others. 
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
import org.yakindu.sct.model.sexec.transformation.test.validation.SExecValidationTest;

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
		ShortStringTest.class,
		StatechartEnterExistActionTest.class,
		StatechartExtensionsTest.class,
		StringTreeNodeTest.class,
		TreeNamingServiceTest.class,
		NullCallTest.class,
		SExecValidationTest.class
		})
public class AllTests {

}
