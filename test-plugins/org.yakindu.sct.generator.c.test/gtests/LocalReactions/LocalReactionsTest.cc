
#include "gtest/gtest.h"
#include "LocalReactions.h"

#include "sc_timer_service.h"

static LocalReactions statechart;


class LocalReactionsTest : public ::testing::Test
{
public:
	/* All operations from the SCTUnit test class. */
	void LocalReactionsTest();
	void setTimer(LocalReactions* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
	void unsetTimer(LocalReactions* handle, const sc_eventid evid);
protected:
	sc_unit_timer_service_t timer_service;
	virtual void SetUp();
};

static LocalReactionsTest * tc;


void LocalReactionsTest::SetUp()
{
	localReactions_init(&statechart);
	sc_timer_service_init(
		&timer_service,
		0,
		(sc_run_cycle_fp) &localReactions_runCycle,
		false,
		200,
		&statechart
	);
	
	
	tc = this;
}
void LocalReactionsTest::LocalReactionsTest()
{
	localReactions_enter(&statechart);
	EXPECT_TRUE(localReactions_isStateActive(&statechart, LocalReactions_main_region_A));
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(localReactionsIface_get_x(&statechart)== 1l);
}

void LocalReactionsTest::setTimer(LocalReactions* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid);
	insert_timer(&(tc->timer_service), timer);
}

void LocalReactionsTest::unsetTimer(LocalReactions* handle, const sc_eventid evid){
	delete_task(&(tc->timer_service), find_time_event(&timer_service, evid));
}

TEST_F(LocalReactionsTest, LocalReactionsTest) {
	LocalReactionsTest();
}


