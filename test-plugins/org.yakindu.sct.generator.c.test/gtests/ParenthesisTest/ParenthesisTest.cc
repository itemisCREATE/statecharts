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
#include "Parenthesis.h"

Parenthesis handle;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		parenthesis_init(&handle);
	}
};


TEST_F(StatemachineTest, simple) {					
	parenthesis_enter(&handle);
	EXPECT_TRUE(parenthesis_isStateActive(&handle, Parenthesis_mainRegion_A));
	EXPECT_TRUE(parenthesisIface_get_erg(&handle)== 8l);
}


