/**
* Copyright (c) 2017 committers of YAKINDU and others.
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
#include "StatechartKeywords.h"
#include "sc_types.h"
StatechartKeywords* statechart = new StatechartKeywords();
statechart->init();

TEST(StatemachineTest, statemachineKeywords) {
	
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(StatechartKeywords::main_region_Timer));
	
	delete statechart;
}
