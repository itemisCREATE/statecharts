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
#include "gtest/gtest.h"
#include "TypeAlias.h"

static TypeAlias statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		typeAlias_init(&statechart);
	}
};


TEST_F(StatemachineTest, TypeAliasTest) {					
	typeAlias_enter(&statechart);
	EXPECT_TRUE(typeAlias_isStateActive(&statechart, TypeAlias_main_region_Start));
	EXPECT_TRUE(typeAliasIface_get_myVar(&statechart)== 1l);
	typeAlias_runCycle(&statechart);
	EXPECT_TRUE(typeAlias_isStateActive(&statechart, TypeAlias_main_region_Mid));
	EXPECT_TRUE(strcmp(typeAliasIface_get_myString(&statechart), "TypeSystem") == 0);
	typeAlias_runCycle(&statechart);
	EXPECT_TRUE(typeAlias_isStateActive(&statechart, TypeAlias_main_region_Mid2));
	typeAliasIface_raise_myEvent(&statechart);
	typeAlias_runCycle(&statechart);
	EXPECT_TRUE(typeAlias_isStateActive(&statechart, TypeAlias_main_region_End));
}


