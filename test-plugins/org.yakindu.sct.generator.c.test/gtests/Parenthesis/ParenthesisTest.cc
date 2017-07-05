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

static Parenthesis statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		parenthesis_init(&statechart);
	}
};


TEST_F(StatemachineTest, simple) {					
	parenthesis_enter(&statechart);
	EXPECT_TRUE(parenthesis_isStateActive(&statechart, Parenthesis_mainRegion_A));
	EXPECT_TRUE(parenthesisIface_get_erg(&statechart)== 8l);
}


