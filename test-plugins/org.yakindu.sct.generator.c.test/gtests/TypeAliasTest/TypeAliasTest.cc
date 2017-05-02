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

TypeAlias handle;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		typeAlias_init(&handle);
	}
};


TEST_F(StatemachineTest, TypeAliasTest) {					
	typeAlias_enter(&handle);
	EXPECT_TRUE(typeAlias_isStateActive(&handle, TypeAlias_main_region_Start));
	EXPECT_TRUE(typeAliasIface_get_myVar(&handle)== 1l);
	typeAlias_runCycle(&handle);
	EXPECT_TRUE(typeAlias_isStateActive(&handle, TypeAlias_main_region_Mid));
	EXPECT_TRUE(strcmp(typeAliasIface_get_myString(&handle), "TypeSystem") == 0);
	typeAlias_runCycle(&handle);
	EXPECT_TRUE(typeAlias_isStateActive(&handle, TypeAlias_main_region_Mid2));
	typeAliasIface_raise_myEvent(&handle);
	typeAlias_runCycle(&handle);
	EXPECT_TRUE(typeAlias_isStateActive(&handle, TypeAlias_main_region_End));
}


