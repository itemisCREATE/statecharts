#include "gtest/gtest.h"
#include "../src-gen/TimeTrigger/TimeTrigger.h"
#include "../src-gen/TimeTrigger/TimeTrigger.c"
#include "../src-gen/TimeTrigger/TimeTriggerRequired.h"

typedef struct {
	sc_eventid unsetEvid;
	sc_eventid setEvid;
	sc_integer time_ms;sc_boolean periodic;
} TimeEvent;

TimeEvent timeEvent;

TEST(StatemachineTest, TimeTrigger) {
	TimeTrigger handle;
	timeTrigger_init(&handle);

	//Enter calls setTimer the first time event!
	timeTrigger_enter(&handle);
	EXPECT_TRUE(timeTrigger_isActive(&handle, TimeTrigger_mainRegion_StateA));
	EXPECT_TRUE(timeTriggerIface_get_value(&handle) == 0);
	EXPECT_TRUE(
			timeEvent.setEvid == &(handle.timeEvents.StateA_time_event_0_raised));
	EXPECT_TRUE(timeEvent.time_ms == 100);
	EXPECT_FALSE(timeEvent.periodic);

	timeTrigger_raiseTimeEvent(&handle, timeEvent.setEvid);
	timeTrigger_runCycle(&handle);
	EXPECT_TRUE( timeTrigger_isActive(&handle, TimeTrigger_mainRegion_StateB));
	//Reset TimeEvent0 of state A
	EXPECT_TRUE(
			timeEvent.unsetEvid == &(handle.timeEvents.StateA_time_event_0_raised));
	//Queue TimeEvent0 of state B
	EXPECT_TRUE(
			timeEvent.setEvid == &(handle.timeEvents.StateB_time_event_0_raised));
	EXPECT_TRUE(timeEvent.time_ms == 20);
	EXPECT_TRUE(timeEvent.periodic);

	for (int i = 1; i <= 10; i++) {
		timeTrigger_raiseTimeEvent(&handle, timeEvent.setEvid);
		timeTrigger_runCycle(&handle);
		EXPECT_TRUE(
				timeTrigger_isActive(&handle, TimeTrigger_mainRegion_StateB));
		EXPECT_TRUE(timeTriggerIface_get_value(&handle) == i);
	}
	//timeTrigger_raiseTimeEvent(&handle, timeEvent.setEvid);
	timeTrigger_runCycle(&handle);
	EXPECT_TRUE( timeTrigger_isActive(&handle, TimeTrigger_mainRegion_StateA));
	EXPECT_TRUE(timeTriggerIface_get_value(&handle) == 0);
	EXPECT_TRUE(
			timeEvent.setEvid == &(handle.timeEvents.StateA_time_event_0_raised));
	EXPECT_TRUE(
			timeEvent.unsetEvid == &(handle.timeEvents.StateB_time_event_0_raised));
	EXPECT_TRUE(timeEvent.time_ms == 100);
	EXPECT_FALSE(timeEvent.periodic);
}

void timeTrigger_setTimer(const sc_eventid evid, const sc_integer time_ms,
		const sc_boolean periodic) {
	timeEvent.setEvid = evid;
	timeEvent.time_ms = time_ms;
	timeEvent.periodic = periodic;
}

void timeTrigger_unsetTimer(const sc_eventid evid) {
	timeEvent.unsetEvid = evid;
}
