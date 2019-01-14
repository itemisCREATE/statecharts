
#include "gtest/gtest.h"
#include "AlwaysOncycle.h"

#include "sc_timer_service.h"

static AlwaysOncycle statechart;


class AlwaysOncycleTest : public ::testing::Test
{
public:
	/* All operations from the SCTUnit test class. */
	void alwaysOnCycleTest();
	void setTimer(AlwaysOncycle* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
	void unsetTimer(AlwaysOncycle* handle, const sc_eventid evid);
protected:
	sc_unit_timer_service_t timer_service;
	virtual void SetUp();
};

static AlwaysOncycleTest * tc;


void AlwaysOncycleTest::SetUp()
{
	alwaysOncycle_init(&statechart);
	sc_timer_service_init(
		&timer_service,
		0,
		(sc_run_cycle_fp) &alwaysOncycle_runCycle,
		false,
		200,
		&statechart
	);
	
	
	tc = this;
}
void AlwaysOncycleTest::alwaysOnCycleTest()
{
	alwaysOncycle_enter(&statechart);
	EXPECT_TRUE(alwaysOncycle_isStateActive(&statechart, AlwaysOncycle_main_region_StateA));
	sc_integer count = 0;
	while (count< 5) {
		sc_timer_service_proceed_cycles(&timer_service, 1);
		EXPECT_TRUE(alwaysOncycle_isStateActive(&statechart, AlwaysOncycle_main_region_StateA));
		count++;
	}
	EXPECT_TRUE((alwaysOncycleIface_get_value(&statechart)== 5));
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(alwaysOncycle_isStateActive(&statechart, AlwaysOncycle_main_region_StateB));
	EXPECT_TRUE(alwaysOncycleIface_get_value(&statechart)== 0);
	count = 0;
	while (count< 5) {
		sc_timer_service_proceed_cycles(&timer_service, 1);
		EXPECT_TRUE(alwaysOncycle_isStateActive(&statechart, AlwaysOncycle_main_region_StateB));
		count++;
	}
	EXPECT_TRUE((alwaysOncycleIface_get_value(&statechart)== 5));
	EXPECT_TRUE((alwaysOncycleIface_get_x(&statechart)== 5));
	EXPECT_TRUE((alwaysOncycleIface_get_y(&statechart)== 5));
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(alwaysOncycle_isStateActive(&statechart, AlwaysOncycle_main_region_StateA));
	EXPECT_TRUE(alwaysOncycleIface_get_value(&statechart)== 0);
}

void AlwaysOncycleTest::setTimer(AlwaysOncycle* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid);
	insert_timer(&(tc->timer_service), timer);
}

void AlwaysOncycleTest::unsetTimer(AlwaysOncycle* handle, const sc_eventid evid){
	delete_task(&(tc->timer_service), find_time_event(&timer_service, evid));
}

TEST_F(AlwaysOncycleTest, alwaysOnCycleTest) {
	alwaysOnCycleTest();
}


