/**
* Copyright (c) 2015 committers of YAKINDU and others.
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
#include "LogicalOr.h"


LogicalOr handle;

TEST(StatemachineTest, operandEvaluationOrder) {
	logicalOr_init(&handle);
	logicalOr_enter(&handle);
	logicalOr_runCycle(&handle);
	EXPECT_TRUE(logicalOrIface_get_x(&handle) == 4l && logicalOrIface_get_b(&handle) ) << "logical or expression was executed in wrong order..." ;
}

		
