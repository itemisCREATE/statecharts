#include "gtest/gtest.h"
#include "../src-gen/ShallowHistory/ShallowHistory.h"
#include "../src-gen/ShallowHistory/ShallowHistory.c"

TEST(StatemachineTest, ShallowHistory) {
	ShallowHistory handle;
	shallowHistory_init(&handle);
	shallowHistory_enter(&handle);
	EXPECT_TRUE(
			shallowHistory_isActive(&handle, ShallowHistory_mainRegion_State1));

	shallowHistoryIface_raise_event1(&handle);
	shallowHistory_runCycle(&handle);
	EXPECT_TRUE(
			shallowHistory_isActive(&handle, ShallowHistory_mainRegion_State2__region0_State3));

	shallowHistoryIface_raise_event3(&handle);
	shallowHistory_runCycle(&handle);
	EXPECT_TRUE(
			shallowHistory_isActive(&handle, ShallowHistory_mainRegion_State2__region0_State4__region0_State6));

	shallowHistoryIface_raise_event5(&handle);
	shallowHistory_runCycle(&handle);
	EXPECT_TRUE(
			shallowHistory_isActive(&handle, ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8));

	shallowHistoryIface_raise_event7(&handle);
	shallowHistory_runCycle(&handle);
	EXPECT_FALSE(
			shallowHistory_isActive(&handle, ShallowHistory_mainRegion_State1));
	EXPECT_TRUE(
			shallowHistory_isActive(&handle, ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9));

	shallowHistoryIface_raise_event6(&handle);
	shallowHistory_runCycle(&handle);
	EXPECT_FALSE(
			shallowHistory_isActive(&handle, ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9));
	EXPECT_TRUE(
			shallowHistory_isActive(&handle, ShallowHistory_mainRegion_State2__region0_State4__region0_State6));

	shallowHistoryIface_raise_event5(&handle);
	shallowHistory_runCycle(&handle);
	EXPECT_FALSE(
			shallowHistory_isActive(&handle, ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8));
	EXPECT_TRUE(
			shallowHistory_isActive(&handle, ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9));

	shallowHistoryIface_raise_event2(&handle);
	shallowHistory_runCycle(&handle);
	EXPECT_FALSE(
			shallowHistory_isActive(&handle, ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9));
	EXPECT_TRUE(
			shallowHistory_isActive(&handle, ShallowHistory_mainRegion_State1));

	shallowHistoryIface_raise_event1(&handle);
	shallowHistory_runCycle(&handle);
	EXPECT_FALSE(
			shallowHistory_isActive(&handle, ShallowHistory_mainRegion_State1));
	EXPECT_TRUE(
			shallowHistory_isActive(&handle, ShallowHistory_mainRegion_State2__region0_State4__region0_State6));

	shallowHistoryIface_raise_event5(&handle);
	shallowHistory_runCycle(&handle);
	EXPECT_FALSE(
			shallowHistory_isActive(&handle, ShallowHistory_mainRegion_State2__region0_State4__region0_State6));
	EXPECT_TRUE(
			shallowHistory_isActive(&handle, ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9));
}
