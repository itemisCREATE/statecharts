/**
* Copyright (c) 2012 committers of YAKINDU and others.
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
#include "STextKeywordsInStatesAndRegions.h"

TEST(StatemachineTest, activeCheckWithSTextNamedStates) {
	STextKeywordsInStatesAndRegions handle;
	sTextKeywordsInStatesAndRegions_init(&handle);
	sTextKeywordsInStatesAndRegions_enter(&handle);
	EXPECT_TRUE(sTextKeywordsInStatesAndRegions_isActive(&handle, STextKeywordsInStatesAndRegions_default_var));
	EXPECT_TRUE(sTextKeywordsInStatesAndRegions_isActive(&handle, STextKeywordsInStatesAndRegions_operation_interface));
	sTextKeywordsInStatesAndRegions_runCycle(&handle);
	EXPECT_TRUE(sTextKeywordsInStatesAndRegions_isActive(&handle, STextKeywordsInStatesAndRegions_default_var));
	EXPECT_TRUE(sTextKeywordsInStatesAndRegions_isActive(&handle, STextKeywordsInStatesAndRegions_operation_active));
	sTextKeywordsInStatesAndRegions_runCycle(&handle);
}
