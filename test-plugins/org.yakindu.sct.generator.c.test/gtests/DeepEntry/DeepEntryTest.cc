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
#include "DeepEntry.h"

static DeepEntry statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		deepEntry_init(&statechart);
	}
};


TEST_F(StatemachineTest, enterToSubstate) {					
	deepEntry_enter(&statechart);
	long vergleich = 4l;
	EXPECT_TRUE(vergleich== 4l);
	deepEntry_exit(&statechart);
}


