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
#include <string>
#include "gtest/gtest.h"
#include "TimedTransitions.h"
			

TimedTransitions* statechart;

	
TEST(StatemachineTest, Timer01) {
	statechart = new TimedTransitions();				
	
	//  YAKHMI-701 doesnt work for Cpp atm
	
	// statechart->init();
	// statechart->enter();
	// EXPECT_TRUE(statechart->isActive(TimedTransitions::TimedTransitions_main_region_Start));
	//not implemented: WaitStatement
	// statechart->runCycle();
	// EXPECT_TRUE(statechart->isActive(TimedTransitions::TimedTransitions_main_region_End));
	delete statechart;
}

