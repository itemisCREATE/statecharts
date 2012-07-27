#include "gtest/gtest.h"
#include "../src-gen/DeepHistory/DeepHistory.h"
#include "../src-gen/DeepHistory/DeepHistory.c"

TEST(StatemachineTest, DeepHistory) {
	DeepHistory handle;
	deepHistory_init(&handle);
	deepHistory_enter(&handle);
	EXPECT_TRUE(
			deepHistory_isActive(&handle, DeepHistory_mainRegion_State1));

	deepHistoryIface_raise_event1(&handle);
	deepHistory_runCycle(&handle);

	deepHistoryIface_raise_event3(&handle);
	deepHistory_runCycle(&handle);

	deepHistoryIface_raise_event5(&handle);
	deepHistory_runCycle(&handle);

	deepHistoryIface_raise_event7(&handle);
	deepHistory_runCycle(&handle);
	EXPECT_FALSE(
			deepHistory_isActive(&handle, DeepHistory_mainRegion_State1));
	EXPECT_TRUE(
			deepHistory_isActive(&handle, DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9));

	deepHistoryIface_raise_event2(&handle);
	deepHistory_runCycle(&handle);
	EXPECT_FALSE(
			deepHistory_isActive(&handle, DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9));
	EXPECT_TRUE(
			deepHistory_isActive(&handle, DeepHistory_mainRegion_State1));

	deepHistoryIface_raise_event1(&handle);
	deepHistory_runCycle(&handle);
	EXPECT_FALSE(
			deepHistory_isActive(&handle, DeepHistory_mainRegion_State1));
	EXPECT_TRUE(
			deepHistory_isActive(&handle, DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9));
}
