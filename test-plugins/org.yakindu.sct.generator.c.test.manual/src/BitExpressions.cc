#include "gtest/gtest.h"
#include "../src-gen/BitExpressions/BitExpressions.h"
#include "../src-gen/BitExpressions/BitExpressions.c"

TEST(StatemachineTest, BitExpressions) {
	BitExpressions handle;
	bitExpressions_init(&handle);
	bitExpressions_enter(&handle);
	EXPECT_TRUE(
			bitExpressions_isActive(&handle, BitExpressions_main_region_StateA));
	EXPECT_TRUE(bitExpressionsIface_get_myBit1(&handle) == 5);
	EXPECT_TRUE(bitExpressionsIface_get_myBit2(&handle) == 7);

	bitExpressionsIface_raise_e1(&handle);
	bitExpressions_runCycle(&handle);
	EXPECT_TRUE(
				bitExpressions_isActive(&handle, BitExpressions_main_region_StateB));
	EXPECT_TRUE(bitExpressionsIface_get_leftBitshift(&handle) == 10);
	EXPECT_TRUE(bitExpressionsIface_get_rightBitshift(&handle) == 2);
	EXPECT_TRUE(bitExpressionsIface_get_complementBitshift(&handle) == -6);
	EXPECT_TRUE(bitExpressionsIface_get_bitwiseAnd(&handle) == 5);
	EXPECT_TRUE(bitExpressionsIface_get_bitwiseOr(&handle) == 7);
	EXPECT_TRUE(bitExpressionsIface_get_bitwiseXor(&handle) == 2);

}
