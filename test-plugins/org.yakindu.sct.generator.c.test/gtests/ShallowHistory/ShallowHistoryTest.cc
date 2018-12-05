
#include "gtest/gtest.h"
#include "ShallowHistory.h"

#include "sc_timer_service.h"

static ShallowHistory statechart;


class ShallowHistoryTest : public ::testing::Test
{
public:
	/* All operations from the SCTUnit test class. */
	void shallowHistoryTest();
	void setTimer(ShallowHistory* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
	void unsetTimer(ShallowHistory* handle, const sc_eventid evid);
protected:
	sc_unit_timer_service_t timer_service;
	virtual void SetUp();
};

static ShallowHistoryTest * tc;


void ShallowHistoryTest::SetUp()
{
	shallowHistory_init(&statechart);
	sc_timer_service_init(
		&timer_service,
		0,
		(sc_run_cycle_fp) &shallowHistory_runCycle,
		false,
		200,
		&statechart
	);
	
	
	tc = this;
}
void ShallowHistoryTest::shallowHistoryTest()
{
	shallowHistory_enter(&statechart);
	shallowHistoryIface_raise_event1(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	shallowHistoryIface_raise_event3(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	shallowHistoryIface_raise_event5(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	shallowHistoryIface_raise_event7(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(!shallowHistory_isStateActive(&statechart, ShallowHistory_mainRegion_State1));
	EXPECT_TRUE(shallowHistory_isStateActive(&statechart, ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9));
	shallowHistoryIface_raise_event6(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(!shallowHistory_isStateActive(&statechart, ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9));
	EXPECT_TRUE(shallowHistory_isStateActive(&statechart, ShallowHistory_mainRegion_State2__region0_State4__region0_State6));
	shallowHistoryIface_raise_event5(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(!shallowHistory_isStateActive(&statechart, ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8));
	EXPECT_TRUE(shallowHistory_isStateActive(&statechart, ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9));
	shallowHistoryIface_raise_event2(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(!shallowHistory_isStateActive(&statechart, ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9));
	EXPECT_TRUE(shallowHistory_isStateActive(&statechart, ShallowHistory_mainRegion_State1));
	shallowHistoryIface_raise_event1(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(shallowHistory_isStateActive(&statechart, ShallowHistory_mainRegion_State2__region0_State4__region0_State6));
	EXPECT_TRUE(!shallowHistory_isStateActive(&statechart, ShallowHistory_mainRegion_State1));
	shallowHistoryIface_raise_event5(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(!shallowHistory_isStateActive(&statechart, ShallowHistory_mainRegion_State2__region0_State4__region0_State6));
	EXPECT_TRUE(shallowHistory_isStateActive(&statechart, ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9));
}

void ShallowHistoryTest::setTimer(ShallowHistory* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid);
	insert_timer(&(tc->timer_service), timer);
}

void ShallowHistoryTest::unsetTimer(ShallowHistory* handle, const sc_eventid evid){
	delete_task(&(tc->timer_service), find_time_event(&timer_service, evid));
}

TEST_F(ShallowHistoryTest, shallowHistoryTest) {
	shallowHistoryTest();
}


