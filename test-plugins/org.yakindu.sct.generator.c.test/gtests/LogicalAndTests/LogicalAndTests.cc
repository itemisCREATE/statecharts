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
#include "LogicalAnd.h"


LogicalAnd handle;

TEST(StatemachineTest, operandEvaluationOrder) {
	logicalAnd_init(&handle);
	logicalAnd_enter(&handle);
	logicalAnd_runCycle(&handle);
	EXPECT_TRUE(logicalAndIface_get_x(&handle) == 4 && logicalAndIface_get_b(&handle) ) << "logical and expression was executed in wrong order..." ;
}

		
