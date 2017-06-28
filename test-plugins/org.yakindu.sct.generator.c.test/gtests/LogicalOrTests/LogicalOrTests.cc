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
#include "LogicalOr.h"

static LogicalOr statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		logicalOr_init(&statechart);
	}
};


TEST_F(StatemachineTest, operandEvaluationOrder) {					
	logicalOr_enter(&statechart);
	logicalOr_runCycle(&statechart);
	EXPECT_TRUE(logicalOrIface_get_x(&statechart)== 4l && logicalOrIface_get_b(&statechart)) << "logical or expression was executed in wrong order..." ;
}


