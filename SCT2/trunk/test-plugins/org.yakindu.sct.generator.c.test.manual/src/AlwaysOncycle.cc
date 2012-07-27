#include "gtest/gtest.h"
#include "../src-gen/AlwaysOncycle/AlwaysOncycle.h"
#include "../src-gen/AlwaysOncycle/AlwaysOncycle.c"

TEST(StatemachineTest, AlwaysOncycle) {
	AlwaysOncycle handle;
	alwaysOncycle_init(&handle);
	alwaysOncycle_enter(&handle);
	EXPECT_TRUE(
			alwaysOncycle_isActive(&handle, AlwaysOncycle_main_region_StateA));

	for (int value = 0; value < 5; value++) {
		alwaysOncycle_runCycle(&handle);
		EXPECT_TRUE(
				alwaysOncycle_isActive(&handle, AlwaysOncycle_main_region_StateA));
	}

	alwaysOncycle_runCycle(&handle);
	EXPECT_TRUE(
			alwaysOncycle_isActive(&handle, AlwaysOncycle_main_region_StateB));

	for (int value = 0; value < 5; value++) {
		alwaysOncycle_runCycle(&handle);
		EXPECT_TRUE(
				alwaysOncycle_isActive(&handle, AlwaysOncycle_main_region_StateB));
	}

	alwaysOncycle_runCycle(&handle);
	EXPECT_TRUE(
				alwaysOncycle_isActive(&handle, AlwaysOncycle_main_region_StateA));
}
