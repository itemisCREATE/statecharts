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
#include "BitExpressions.h"


BitExpressions handle;

TEST(StatemachineTest, BitExpressions) {
	bitExpressions_init(&handle);
	bitExpressions_enter(&handle);
	EXPECT_TRUE(bitExpressions_isActive(&handle, BitExpressions_main_region_StateA));
	EXPECT_TRUE(bitExpressionsIface_get_myBit1(&handle) == 5l);
	EXPECT_TRUE(bitExpressionsIface_get_myBit2(&handle) == 7l);
	bitExpressionsIface_raise_e1(&handle);
	bitExpressions_runCycle(&handle);
	EXPECT_TRUE(bitExpressions_isActive(&handle, BitExpressions_main_region_StateB));
	EXPECT_TRUE(bitExpressionsIface_get_leftBitshift(&handle) == 10l);
	EXPECT_TRUE(bitExpressionsIface_get_rightBitshift(&handle) == 2l);
	EXPECT_TRUE(bitExpressionsIface_get_complementBitshift(&handle) == - 6l );
	EXPECT_TRUE(bitExpressionsIface_get_bitwiseAnd(&handle) == 5l);
	EXPECT_TRUE(bitExpressionsIface_get_bitwiseOr(&handle) == 7l);
	EXPECT_TRUE(bitExpressionsIface_get_bitwiseXor(&handle) == 2l);
}

		
